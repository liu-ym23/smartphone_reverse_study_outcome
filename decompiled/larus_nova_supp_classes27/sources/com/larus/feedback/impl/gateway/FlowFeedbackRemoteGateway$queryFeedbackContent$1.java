package com.larus.feedback.impl.gateway;

import android.os.Handler;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
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
import q99.c;
import q99.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway$queryFeedbackContent$1", f = "FlowFeedbackRemoteGateway.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
final class FlowFeedbackRemoteGateway$queryFeedbackContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<d, Unit> $callback;
    final /* synthetic */ c $request;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowFeedbackRemoteGateway$queryFeedbackContent$1(c r1, Function1<? super d, Unit> r2, Continuation<? super FlowFeedbackRemoteGateway$queryFeedbackContent$1> r3) {
        this.$request = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowFeedbackRemoteGateway$queryFeedbackContent$1(this.$request, this.$callback, r4);
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
        final d r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        dm9.a.b r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.b) == false) goto L17;
        dm9.a.b r2 = r8;
        if (r2.a.isSuccess() == false) goto L17;
        r4 = (d) r2.a.getData();
    L19:
        Handler r9 = t0.a;
        final Function1<d, Unit> r3 = this.$callback;
        r9.post(new a(r3, r4));
        return Unit.INSTANCE;
    L17:
        if ((r8 instanceof dm9.a.a) == false) goto L19;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("queryFeedbackContent failed code=");
        dm9.a.a r10 = (dm9.a.a) r8;
        r6.append(r10.a);
        r6.append(" msg=");
        r6.append(r10.b);
        r5.e("FlowFeedbackGateway", r6.toString());
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("FlowFeedbackGateway", "queryFeedbackContent scene=" + this.$request.a());
        FlowFeedbackHttpApi.a r11 = FlowFeedbackHttpApi.a;
        FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1 r12 = new FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1(this.$request, null);
        this.label = 1;
        r11.getClass();
        r7 = FlowFeedbackHttpApi.a.a(r12, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
