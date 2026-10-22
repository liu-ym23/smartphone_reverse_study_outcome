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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.LocalVideoSuccessViewBinder$refreshVideoView$1$4", f = "LocalVideoSuccessViewBinder.kt", i = {}, l = {265, 266}, m = "invokeSuspend", n = {}, s = {})
public final class LocalVideoSuccessViewBinder$refreshVideoView$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ LocalVideoSuccessViewBinder this$0;

    public LocalVideoSuccessViewBinder$refreshVideoView$1$4(LocalVideoSuccessViewBinder r1, nr9.g r2, Continuation<? super LocalVideoSuccessViewBinder$refreshVideoView$1$4> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalVideoSuccessViewBinder$refreshVideoView$1$4(this.this$0, this.$videoPlayData, r4);
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
        LocalVideoSuccessViewBinder r8 = this.this$0;
        int r2 = LocalVideoSuccessViewBinder.l;
        if (r8.j() == true) goto L32;
        LocalVideoSuccessViewBinder r9 = this.this$0;
        nr9.g r3 = this.$videoPlayData;
        r9.getClass();
        String r4 = r3.b;
        if (r4 == null) goto L32;
        if ((!StringsKt.isBlank(r4)) == true) goto L26;
        r4 = null;
    L26:
        if (r4 == null) goto L32;
        IVideoController r5 = r9.e();
        if (r5 == null) goto L32;
        r5.f(r4, new j(r4, r9));
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        LocalVideoSuccessViewBinder r10 = this.this$0;
        int r6 = LocalVideoSuccessViewBinder.l;
        kh8.a r11 = r10.d();
        if (r11 == null) goto L18;
        this.label = 2;
        if (r11.f(this) != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
