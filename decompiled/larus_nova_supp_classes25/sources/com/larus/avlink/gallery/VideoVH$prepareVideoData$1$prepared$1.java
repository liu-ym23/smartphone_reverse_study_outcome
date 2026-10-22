package com.larus.avlink.gallery;

import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.VideoVH$prepareVideoData$1$prepared$1", f = "VideoVH.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoVH$prepareVideoData$1$prepared$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ VideoVH.c $displaySize;
    final /* synthetic */ n1 $mediaInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoVH this$0;

    public VideoVH$prepareVideoData$1$prepared$1(VideoVH r1, n1 r2, VideoVH.c r3, Continuation<? super VideoVH$prepareVideoData$1$prepared$1> r4) {
        this.this$0 = r1;
        this.$mediaInfo = r2;
        this.$displaySize = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        VideoVH$prepareVideoData$1$prepared$1 r0 = new VideoVH$prepareVideoData$1$prepared$1(this.this$0, this.$mediaInfo, this.$displaySize, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
        n1 r6 = this.this$0.r;
        if (r6 == null) goto L11;
        String r7 = r6.c;
    L13:
        if (Intrinsics.areEqual(r7, this.$mediaInfo.c) == true) goto L16;
        FLogger.a.i("VideoVH", "Skip stale video metadata callback for position=" + this.this$0.getBindingAdapterPosition());
        return Boxing.boxBoolean(false);
    L16:
        VideoVH r8 = this.this$0;
        r8.t = this.$displaySize;
        r8.b4();
        VideoVH.a4(this.this$0, this.$mediaInfo, this.$displaySize, null);
        FLogger.a.i("VideoVH", "Metadata preparation completed, transitioning to DATA_READY");
        VideoVH r9 = this.this$0;
        r9.k = VideoVH.PlayState.DATA_READY;
        r9.d4();
        return Boxing.boxBoolean(true);
    L11:
        r7 = null;
        goto L13
    L7:
        return Boxing.boxBoolean(false);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
