package com.larus.avlink.gallery.storage;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import w88.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/api/GalleryStorageCleanupResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager$cleanupAfterSync$2", f = "GalleryStoragePolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryStoragePolicyManager$cleanupAfterSync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    final /* synthetic */ MediaMetadata $metadata;
    int label;

    public GalleryStoragePolicyManager$cleanupAfterSync$2(MediaMetadata r1, Continuation<? super GalleryStoragePolicyManager$cleanupAfterSync$2> r2) {
        this.$metadata = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GalleryStoragePolicyManager$cleanupAfterSync$2(this.$metadata, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r8);
        GalleryStoragePolicyManager r9 = GalleryStoragePolicyManager.a;
        MediaMetadata r0 = this.$metadata;
        r9.getClass();
        if (GalleryStoragePolicyManager.a.a[r0.getLifecycleState().ordinal()] != 1) goto L7;
        List<String> r10 = CollectionsKt.listOfNotNull(new String[]{r0.getDownloadFilePath(), r0.getTempFilePath(), r0.getUnpackDirPath(), r0.getProcessedFilePath()});
    L8:
        ArrayList r3 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        Object r4 = r11.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L10;
        r3.add(r4);
        goto L10
    L14:
        ArrayList r12 = new ArrayList();
        Iterator r2 = r3.iterator();
    L16:
        if (r2.hasNext() == false) goto L21;
        Object r5 = r2.next();
        GalleryStoragePolicyManager r6 = GalleryStoragePolicyManager.a;
        PolarisFileWrapper r7 = new PolarisFileWrapper((String) r5);
        r6.getClass();
        if (GalleryStoragePolicyManager.p(r7, r0) == true) goto L16;
        r12.add(r5);
        goto L16
    L21:
        return GalleryStoragePolicyManager.c(GalleryStoragePolicyManager.a, r12, "sync_finish", false, String.valueOf(this.$metadata.getMediaId()));
    L7:
        r10 = r0.getObsoleteFilePaths();
        goto L8
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
