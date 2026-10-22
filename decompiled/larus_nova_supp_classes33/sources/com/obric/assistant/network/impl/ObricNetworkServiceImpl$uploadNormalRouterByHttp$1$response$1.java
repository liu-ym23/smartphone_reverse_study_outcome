package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ vea.j $request;
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1(vea.j r1, Continuation<? super ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1 r0 = new ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1(this.$request, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ObricProtocolApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricProtocolApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ObricProtocolApi r7 = (ObricProtocolApi) this.L$0;
        FLogger.a.i("[ObricNetworkServiceImpl]", "uploadNormalRouterByHttp: request = " + this.$request);
        vea.j r2 = this.$request;
        this.label = 1;
        r6 = r7.uploadNormalRouter(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
