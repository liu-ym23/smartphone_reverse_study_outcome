package com.larus.feedback.impl.gateway;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import q99.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway$submitFeedback$1", f = "FlowFeedbackRemoteGateway.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class FlowFeedbackRemoteGateway$submitFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<dm9.a<Unit>, Unit> $callback;
    final /* synthetic */ k $request;
    int label;

    public FlowFeedbackRemoteGateway$submitFeedback$1(k r1, Function1<? super dm9.a<Unit>, Unit> r2, Continuation<? super FlowFeedbackRemoteGateway$submitFeedback$1> r3) {
        this.$request = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowFeedbackRemoteGateway$submitFeedback$1(this.$request, this.$callback, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        dm9.a.a r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.a) == false) goto L14;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("reportFeedback failed code=");
        dm9.a.a r4 = r8;
        r3.append(r4.a);
        r3.append(" msg=");
        r3.append(r4.b);
        r2.e("FlowFeedbackGateway", r3.toString());
    L14:
        Function1<dm9.a<Unit>, Unit> r5 = this.$callback;
        if (r5 == null) goto L18;
        r5.invoke(r8);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("FlowFeedbackGateway", "reportFeedback feedbackId=" + this.$request.a() + " action=" + this.$request.c() + " scene=" + this.$request.b());
        FlowFeedbackHttpApi.a r9 = FlowFeedbackHttpApi.a;
        FlowFeedbackRemoteGateway$submitFeedback$1$result$1 r6 = new FlowFeedbackRemoteGateway$submitFeedback$1$result$1(this.$request, null);
        this.label = 1;
        r9.getClass();
        r7 = FlowFeedbackHttpApi.a.a(r6, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
