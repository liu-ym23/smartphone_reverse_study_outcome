package com.larus.avlink.gallery.storage;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import w88.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/api/GalleryStorageCleanupResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager$cleanupDeletedMedia$2", f = "GalleryStoragePolicyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GalleryStoragePolicyManager$cleanupDeletedMedia$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    final /* synthetic */ MediaMetadata $metadata;
    final /* synthetic */ String $reason;
    int label;

    public GalleryStoragePolicyManager$cleanupDeletedMedia$2(MediaMetadata r1, String r2, Continuation<? super GalleryStoragePolicyManager$cleanupDeletedMedia$2> r3) {
        this.$metadata = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GalleryStoragePolicyManager$cleanupDeletedMedia$2(this.$metadata, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        return GalleryStoragePolicyManager.c(GalleryStoragePolicyManager.a, this.$metadata.getAllFilePaths(), this.$reason, true, String.valueOf(this.$metadata.getMediaId()));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
