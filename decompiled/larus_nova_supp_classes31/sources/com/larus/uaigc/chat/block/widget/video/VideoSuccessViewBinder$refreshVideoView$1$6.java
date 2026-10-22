package com.larus.uaigc.chat.block.widget.video;

import com.larus.platform.api.IVideoController;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$refreshVideoView$1$6", f = "VideoSuccessViewBinder.kt", i = {}, l = {298, 299}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessViewBinder$refreshVideoView$1$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ VideoSuccessViewBinder this$0;

    public VideoSuccessViewBinder$refreshVideoView$1$6(VideoSuccessViewBinder r1, nr9.g r2, Continuation<? super VideoSuccessViewBinder$refreshVideoView$1$6> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessViewBinder$refreshVideoView$1$6(this.this$0, this.$videoPlayData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L18:
        VideoSuccessViewBinder r8 = this.this$0;
        nr9.g r2 = this.$videoPlayData;
        int r3 = VideoSuccessViewBinder.n;
        r8.getClass();
        String r4 = r2.b;
        if (r4 == null) goto L30;
        if ((!StringsKt.isBlank(r4)) == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L30;
        IVideoController r5 = r8.e();
        if (r5 == null) goto L30;
        r5.f(r4, new v(r4, r8));
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        VideoSuccessViewBinder r9 = this.this$0;
        int r6 = VideoSuccessViewBinder.n;
        kh8.a r10 = r9.d();
        if (r10 == null) goto L18;
        this.label = 2;
        if (r10.f(this) != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
