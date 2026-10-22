package com.larus.feedback.impl.gateway;

import com.larus.dora.impl.ota.g2.j0;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import q99.c;
import q99.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "Lcom/larus/feedback/impl/gateway/FlowFeedbackHttpApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1", f = "FlowFeedbackRemoteGateway.kt", i = {}, l = {j0.G2_OTA_GLASSES_BATTERY_MIN}, m = "invokeSuspend", n = {}, s = {})
public final class FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1 extends SuspendLambda implements Function2<FlowFeedbackHttpApi, Continuation<? super BizResponse<d>>, Object> {
    final /* synthetic */ c $request;
    private /* synthetic */ Object L$0;
    int label;

    public FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1(c r1, Continuation<? super FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1 r0 = new FlowFeedbackRemoteGateway$queryFeedbackContent$1$result$1(this.$request, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(FlowFeedbackHttpApi r1, Continuation<? super BizResponse<d>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowFeedbackHttpApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        FlowFeedbackHttpApi r5 = (FlowFeedbackHttpApi) this.L$0;
        c r2 = this.$request;
        this.label = 1;
        r4 = r5.getContent(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
