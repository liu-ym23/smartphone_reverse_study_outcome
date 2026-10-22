package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import com.obric.assistant.settings.u;
import com.obric.assistant.settings.v;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {1793}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<v>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1(Continuation<? super ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1 r0 = new ObricNetworkServiceImpl$getAutoActionAppBlacklist$response$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(ObricProtocolApi r1, Continuation<? super BizResponse<v>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricProtocolApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricProtocolApi r6 = (ObricProtocolApi) this.L$0;
        u r2 = new u(0);
        this.label = 1;
        r5 = r6.getAppBlackList(r2, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
