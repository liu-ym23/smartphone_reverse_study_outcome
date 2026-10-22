package com.larus.avlink.gallery.storage;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import w88.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/api/GalleryStorageStats;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager$getStorageStats$2", f = "GalleryStoragePolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GalleryStoragePolicyManager$getStorageStats$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super q>, Object> {
    int label;

    public GalleryStoragePolicyManager$getStorageStats$2(Continuation<? super GalleryStoragePolicyManager$getStorageStats$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GalleryStoragePolicyManager$getStorageStats$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super q> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r6);
        GalleryStoragePolicyManager r0 = GalleryStoragePolicyManager.a;
        com.larus.avlink.gallery.e.a.getClass();
        List r1 = CollectionsKt.listOf(com.larus.avlink.gallery.e.c());
        Function1 r2 = new i();
        r0.getClass();
        List r7 = CollectionsKt.listOf(new w88.n[]{GalleryStoragePolicyManager.d("downloads", r1, r2), GalleryStoragePolicyManager.e(r0, "temp", CollectionsKt.listOf(com.larus.avlink.gallery.e.g())), GalleryStoragePolicyManager.e(r0, "processing", CollectionsKt.listOf(com.larus.avlink.gallery.e.f())), GalleryStoragePolicyManager.e(r0, "processed", CollectionsKt.listOf(com.larus.avlink.gallery.e.e())), GalleryStoragePolicyManager.e(r0, "final", CollectionsKt.listOf(com.larus.avlink.gallery.e.d())), GalleryStoragePolicyManager.e(r0, "failed", CollectionsKt.listOf(new PolarisFileWrapper(com.larus.avlink.gallery.e.b(), "failed"))), GalleryStoragePolicyManager.d("source", CollectionsKt.listOf(com.larus.avlink.gallery.e.c()), new j())});
        Iterator r3 = r7.iterator();
        long r4 = 0;
    L6:
        if (r3.hasNext() == false) goto L9;
        r4 = r4 + ((w88.n) r3.next()).b;
        goto L6
    L9:
        return new q(r7, r4);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
