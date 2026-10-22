package com.obric.assistant.network.impl;

import com.larus.common.apphost.AppHost;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/obric/assistant/network/impl/ConfigQueryResponse;", "Lcom/obric/assistant/network/impl/ObricUserExperiencePlanConfigApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {2009}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1 extends SuspendLambda implements Function2<ObricUserExperiencePlanConfigApi, Continuation<? super BizResponse<ConfigQueryResponse>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1(Continuation<? super ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1 r0 = new ObricNetworkServiceImpl$getReferenceMemoryConfig$response$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(ObricUserExperiencePlanConfigApi r1, Continuation<? super BizResponse<ConfigQueryResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricUserExperiencePlanConfigApi) r1, (Continuation) r2);
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
        ObricUserExperiencePlanConfigApi r7 = (ObricUserExperiencePlanConfigApi) this.L$0;
        ConfigQueryRequest r2 = new ConfigQueryRequest(AppHost.a.getApplication().getPackageName(), "obric_reference_memory_config");
        this.label = 1;
        r6 = r7.queryConfig(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
