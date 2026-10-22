package com.larus.avlink.gallery.business;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
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
@DebugMetadata(c = "com.larus.avlink.gallery.business.MediaLifecycleStateManager$markFailed$2", f = "MediaLifecycleStateManager.kt", i = {1, 1, 2, 2}, l = {193, 202, 209}, m = "invokeSuspend", n = {"metadata", "failedAtState", "failedAtState", "updatedMetadata"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MediaLifecycleStateManager$markFailed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ String $uniqId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaLifecycleStateManager this$0;

    public MediaLifecycleStateManager$markFailed$2(String r1, String r2, MediaLifecycleStateManager r3, Continuation<? super MediaLifecycleStateManager$markFailed$2> r4) {
        this.$uniqId = r1;
        this.$reason = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaLifecycleStateManager$markFailed$2(this.$uniqId, this.$reason, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r43) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L12;
        if (r5 != 3) goto L11;
        MediaMetadata r3 = (MediaMetadata) this.L$1;
        MediaLifecycleState r6 = (MediaLifecycleState) this.L$0;
        ResultKt.throwOnFailure(r43);     // Catch: Exception -> L34
        Object r7 = r43;
    L32:
        FLogger r8 = FLogger.a;     // Catch: Exception -> L34
        r8.i("MediaLifecycleStateManager", "markFailed cleanup result=" + ((o) r7) + ", uniqId=" + this.$uniqId);     // Catch: Exception -> L34
        MediaLifecycleStateManager.a(this.this$0, this.$uniqId, r6, this.$reason, r3);     // Catch: Exception -> L34
        r8.e("MediaLifecycleStateManager", "Media " + this.$uniqId + " failed at " + r6 + ": " + this.$reason);     // Catch: Exception -> L34
    L37:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        MediaLifecycleState r9 = (MediaLifecycleState) this.L$1;
        MediaMetadata r10 = (MediaMetadata) this.L$0;
        ResultKt.throwOnFailure(r43);     // Catch: Exception -> L34
    L28:
        MediaMetadata r11 = MediaMetadata.copy$default(r10, null, 0, null, null, null, null, 0, 0, 0, 0, 0, 0.0d, 0, null, null, MediaLifecycleState.FAILED, r9, this.$reason, null, null, null, null, null, 0, 16547839, null);     // Catch: Exception -> L34
        GalleryStoragePolicyManager r12 = GalleryStoragePolicyManager.a;     // Catch: Exception -> L34
        this.L$0 = r9;     // Catch: Exception -> L34
        this.L$1 = r11;     // Catch: Exception -> L34
        this.label = 3;     // Catch: Exception -> L34
        r12.getClass();     // Catch: Exception -> L34
        r7 = GalleryStoragePolicyManager.g(r11, this);     // Catch: Exception -> L34
        if (r7 != r4) goto L31;
        return r4;
    L31:
        r6 = r9;
        r3 = r11;
        goto L32
    L15:
        ResultKt.throwOnFailure(r43);     // Catch: Exception -> L34
        Object r13 = r43;
    L21:
        r10 = (MediaMetadata) r13;     // Catch: Exception -> L34
        if (r10 != null) goto L25;
        FLogger.a.e("MediaLifecycleStateManager", "Cannot mark failed: metadata not found for " + this.$uniqId);     // Catch: Exception -> L34
        return Unit.INSTANCE;
    L25:
        r9 = r10.getLifecycleState();     // Catch: Exception -> L34
        AlbumDataBaseHelper r14 = AlbumDataBaseHelper.a;     // Catch: Exception -> L34
        String r15 = this.$uniqId;     // Catch: Exception -> L34
        MediaLifecycleState r16 = MediaLifecycleState.FAILED;     // Catch: Exception -> L34
        String r17 = this.$reason;     // Catch: Exception -> L34
        this.L$0 = r10;     // Catch: Exception -> L34
        this.L$1 = r9;     // Catch: Exception -> L34
        this.label = 2;     // Catch: Exception -> L34
        if (r14.z(r15, r16, r17, this) != r4) goto L28;
        return r4;
    L17:
        ResultKt.throwOnFailure(r43);
        AlbumDataBaseHelper r18 = AlbumDataBaseHelper.a;     // Catch: Exception -> L34
        String r19 = this.$uniqId;     // Catch: Exception -> L34
        this.label = 1;     // Catch: Exception -> L34
        r13 = r18.o(r19, this);     // Catch: Exception -> L34
        if (r13 != r4) goto L21;
        return r4;
    L34:
        e = move-exception;
        FLogger.a.e("MediaLifecycleStateManager", "Error marking failed for " + this.$uniqId + ": " + e.getMessage(), e);
        goto L37
    }
}
