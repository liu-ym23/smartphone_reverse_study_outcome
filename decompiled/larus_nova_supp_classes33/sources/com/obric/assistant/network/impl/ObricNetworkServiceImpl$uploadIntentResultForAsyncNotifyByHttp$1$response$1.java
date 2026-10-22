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
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ vea.i $request;
    final /* synthetic */ String $seqId;
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1(String r1, vea.i r2, Continuation<? super ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1> r3) {
        this.$seqId = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1 r0 = new ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1(this.$seqId, this.$request, r5);
        r0.L$0 = r4;
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
        FLogger.a.i("[ObricNetworkServiceImpl]", "uploadIntentResultForAsyncNotifyByHttp: seqId: " + this.$seqId);
        vea.i r2 = this.$request;
        this.label = 1;
        r6 = r7.uploadIntentResultForAsyncNotify(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
