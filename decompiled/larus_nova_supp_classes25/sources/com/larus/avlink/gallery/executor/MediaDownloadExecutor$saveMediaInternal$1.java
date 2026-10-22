package com.larus.avlink.gallery.executor;

import android.content.Context;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.MediaInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$saveMediaInternal$1", f = "MediaDownloadExecutor.kt", i = {0, 1}, l = {878, 327}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class MediaDownloadExecutor$saveMediaInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MediaInfo $mediaInfo;
    final /* synthetic */ String $resultPath;
    final /* synthetic */ MediaSyncCoordinator.SyncMode $syncMode;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$saveMediaInternal$1(MediaDownloadExecutor r1, Context r2, MediaInfo r3, String r4, MediaSyncCoordinator.SyncMode r5, Continuation<? super MediaDownloadExecutor$saveMediaInternal$1> r6) {
        this.this$0 = r1;
        this.$context = r2;
        this.$mediaInfo = r3;
        this.$resultPath = r4;
        this.$syncMode = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MediaDownloadExecutor$saveMediaInternal$1(this.this$0, this.$context, this.$mediaInfo, this.$resultPath, this.$syncMode, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
    L24:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r2.unlock(null);
    L31:
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r7 = r2;
    L28:
        r7.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        MediaSyncCoordinator.SyncMode r3 = (MediaSyncCoordinator.SyncMode) this.L$5;
        String r4 = (String) this.L$4;
        MediaInfo r5 = (MediaInfo) this.L$3;
        Context r6 = (Context) this.L$2;
        MediaDownloadExecutor r8 = (MediaDownloadExecutor) this.L$1;
        r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
    L32:
        this.L$0 = r7;     // Catch: Throwable -> L27
        this.L$1 = null;     // Catch: Throwable -> L27
        this.L$2 = null;     // Catch: Throwable -> L27
        this.L$3 = null;     // Catch: Throwable -> L27
        this.L$4 = null;     // Catch: Throwable -> L27
        this.L$5 = null;     // Catch: Throwable -> L27
        this.label = 2;     // Catch: Throwable -> L27
        if (MediaDownloadExecutor.d(r8, r6, r5, r3, this) != r0) goto L23;
        return r0;
    L23:
        r2 = r7;
    L27:
        th = th;
        goto L28
    L14:
        ResultKt.throwOnFailure(r10);
        r8 = this.this$0;
        if (r8.e.b == true) goto L31;
        r7 = r8.d;
        r6 = this.$context;
        MediaInfo r12 = this.$mediaInfo;
        String r9 = this.$resultPath;
        MediaSyncCoordinator.SyncMode r13 = this.$syncMode;
        this.L$0 = r7;
        this.L$1 = r8;
        this.L$2 = r6;
        this.L$3 = r12;
        this.L$4 = r9;
        this.L$5 = r13;
        this.label = 1;
        if (r7.a(null, this) != r0) goto L19;
        return r0;
    L19:
        r5 = r12;
        r3 = r13;
        goto L32
    }
}
