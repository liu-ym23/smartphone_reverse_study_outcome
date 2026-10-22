package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import dm9.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import vea.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$replyAskUser$2", f = "ObricNetworkServiceImpl.kt", i = {}, l = {925}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$replyAskUser$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ b $request;
    int label;

    public ObricNetworkServiceImpl$replyAskUser$2(IFlowNetworkResultCallbackIDL r1, b r2, Continuation<? super ObricNetworkServiceImpl$replyAskUser$2> r3) {
        this.$callback = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricNetworkServiceImpl$replyAskUser$2(this.$callback, this.$request, r4);
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
        a.b r9 = (a) r8;
        if ((r9 instanceof a.b) == false) goto L17;
        FLogger.a.i("[ObricNetworkServiceImpl]", "replyAskUser success");
        IFlowNetworkResultCallbackIDL r2 = this.$callback;
        if (r2 == null) goto L21;
        r2.onResult(true, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", r9.a.getMsg())}));
    L21:
        FLogger.a.i("[ObricNetworkServiceImpl]", "replyAskUser: response = " + r9);
        return Unit.INSTANCE;
    L17:
        if ((r9 instanceof a.a) == false) goto L24;
        FLogger.a.i("[ObricNetworkServiceImpl]", "replyAskUser error");
        IFlowNetworkResultCallbackIDL r3 = this.$callback;
        if (r3 == null) goto L21;
        r3.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", ((a.a) r9).b)}));
        goto L21
    L24:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("[ObricNetworkServiceImpl]", "replyAskUser: start");
        ObricProtocolApi.a r10 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$replyAskUser$2$response$1 r4 = new ObricNetworkServiceImpl$replyAskUser$2$response$1(this.$request, null);
        this.label = 1;
        r10.getClass();
        r8 = ObricProtocolApi.a.a(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
