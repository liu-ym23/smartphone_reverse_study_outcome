package com.larus.avlink.gallery.business;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.business.MediaLifecycleStateManager$cleanupObsoleteFiles$2", f = "MediaLifecycleStateManager.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_GUI}, m = "invokeSuspend", n = {}, s = {})
final class MediaLifecycleStateManager$cleanupObsoleteFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaMetadata $metadata;
    int label;

    public MediaLifecycleStateManager$cleanupObsoleteFiles$2(MediaMetadata r1, Continuation<? super MediaLifecycleStateManager$cleanupObsoleteFiles$2> r2) {
        this.$metadata = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaLifecycleStateManager$cleanupObsoleteFiles$2(this.$metadata, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L15
    L13:
        FLogger.a.i("MediaLifecycleStateManager", "cleanupObsoleteFiles result=" + ((o) r8) + ", uniqId=" + this.$metadata.getUniqId());     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("MediaLifecycleStateManager", "cleanupObsoleteFiles state=" + this.$metadata.getLifecycleState() + ", uniqId=" + this.$metadata.getUniqId() + ", temp=" + this.$metadata.getTempFilePath() + ", processing=" + this.$metadata.getUnpackDirPath() + ", processed=" + this.$metadata.getProcessedFilePath() + ", final=" + this.$metadata.getFinalFilePath());     // Catch: Exception -> L15
        GalleryStoragePolicyManager r9 = GalleryStoragePolicyManager.a;     // Catch: Exception -> L15
        MediaMetadata r1 = this.$metadata;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        r9.getClass();     // Catch: Exception -> L15
        r8 = GalleryStoragePolicyManager.g(r1, this);     // Catch: Exception -> L15
        if (r8 != r2) goto L13;
        return r2;
    L15:
        e = move-exception;
        FLogger.a.e("MediaLifecycleStateManager", "Error cleaning obsolete files: " + e.getMessage(), e);
        goto L18
    }
}
