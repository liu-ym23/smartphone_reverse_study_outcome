package com.larus.uaigc.chat.markdown.video.statemanager;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$refreshVideoView$1$6", f = "VideoSuccessState.kt", i = {}, l = {298, 299}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$refreshVideoView$1$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$refreshVideoView$1$6(i r1, nr9.g r2, Continuation<? super VideoSuccessState$refreshVideoView$1$6> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessState$refreshVideoView$1$6(this.this$0, this.$videoPlayData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L18:
        i r7 = this.this$0;
        nr9.g r2 = this.$videoPlayData;
        int r3 = i.n;
        IVideoController r4 = r7.i();
        if (r4 == null) goto L22;
        r4.f(r2.b, new m(r2, r7));
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        i r8 = this.this$0;
        int r5 = i.n;
        kh8.a r9 = r8.h();
        if (r9 == null) goto L18;
        this.label = 2;
        if (r9.f(this) != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
