package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/agents/impl/network/GetAgentsMdData;", "Lcom/larus/agents/impl/network/AgentsMdApi;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1", f = "AgentsMdApi.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1 extends SuspendLambda implements Function2<AgentsMdApi, Continuation<? super BizResponse<d>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1(Continuation<? super NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1 r0 = new NetworkOfficeTaskPreferenceRemoteDataSource$fetch$result$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(AgentsMdApi r1, Continuation<? super BizResponse<d>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AgentsMdApi) r1, (Continuation) r2);
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
        AgentsMdApi r5 = (AgentsMdApi) this.L$0;
        this.label = 1;
        r4 = r5.getAgentsMd(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
