package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import dm9.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadNormalRouterByHttp$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$uploadNormalRouterByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ String $passThrough;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$uploadNormalRouterByHttp$1(String r1, String r2, ObricNetworkServiceImpl r3, IFlowNetworkResultCallbackIDL r4, Continuation<? super ObricNetworkServiceImpl$uploadNormalRouterByHttp$1> r5) {
        this.$scene = r1;
        this.$passThrough = r2;
        this.this$0 = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricNetworkServiceImpl$uploadNormalRouterByHttp$1(this.$scene, this.$passThrough, this.this$0, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        a r4 = (a) r8;
        ObricNetworkServiceImpl r2 = this.this$0;
        IntentShortLinkType r3 = IntentShortLinkType.NORMAL;
        IFlowNetworkResultCallbackIDL r5 = this.$callback;
        List r9 = ObricNetworkServiceImpl.i;
        r2.G(r3, null, false, r4, r5, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("[ObricNetworkServiceImpl]", "uploadNormalRouterByHttp: start, " + this.$scene);
        vea.j r10 = new vea.j(this.$scene, this.$passThrough);
        ObricProtocolApi.a r6 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1 r7 = new ObricNetworkServiceImpl$uploadNormalRouterByHttp$1$response$1(r10, null);
        this.label = 1;
        r6.getClass();
        r8 = ObricProtocolApi.a.a(r7, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
