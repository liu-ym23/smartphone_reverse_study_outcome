package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import dm9.a;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$sweepConditionalTask$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {1017}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$sweepConditionalTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ ObricConditionalTaskSweepRequest $request;
    int label;

    public ObricNetworkServiceImpl$sweepConditionalTask$1(ObricConditionalTaskSweepRequest r1, IFlowNetworkResultCallbackIDL r2, Continuation<? super ObricNetworkServiceImpl$sweepConditionalTask$1> r3) {
        this.$request = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricNetworkServiceImpl$sweepConditionalTask$1(this.$request, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        a.b r14 = (a) r13;
        if ((r14 instanceof a.b) == false) goto L28;
        a.b r2 = r14;
        int r8 = (int) r2.a.getCode();
        if (r8 != 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        FLogger.a.i("[ObricNetworkServiceImpl]", "sweepConditionalTask success");
    L24:
        IFlowNetworkResultCallbackIDL r9 = this.$callback;
        if (r9 == null) goto L32;
        r9.onResult(r7, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", r2.a.getMsg()), TuplesKt.to("code", String.valueOf(r8))}));
    L32:
        FLogger.a.i("[ObricNetworkServiceImpl]", "sweepConditionalTask: response = " + r14);
        return Unit.INSTANCE;
    L23:
        FLogger.a.i("[ObricNetworkServiceImpl]", "sweepConditionalTask failed, bizCode=" + r8 + ", msg=" + r2.a.getMsg());
        goto L24
    L20:
        r7 = false;
        goto L21
    L28:
        if ((r14 instanceof a.a) == false) goto L35;
        FLogger.a.i("[ObricNetworkServiceImpl]", "sweepConditionalTask error");
        IFlowNetworkResultCallbackIDL r3 = this.$callback;
        if (r3 == null) goto L32;
        a.a r10 = (a.a) r14;
        r3.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", r10.b), TuplesKt.to("code", String.valueOf(r10.a))}));
        goto L32
    L35:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FLogger r15 = FLogger.a;
        StringBuilder r4 = new StringBuilder("sweepConditionalTask: start, size=");
        List r5 = this.$request.getTaskList();
        if (r5 == null) goto L11;
        int r6 = r5.size();
    L12:
        r4.append(r6);
        r15.i("[ObricNetworkServiceImpl]", r4.toString());
        ObricProtocolApi.a r16 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$sweepConditionalTask$1$response$1 r11 = new ObricNetworkServiceImpl$sweepConditionalTask$1$response$1(this.$request, null);
        this.label = 1;
        r16.getClass();
        r13 = ObricProtocolApi.a.a(r11, this);
        if (r13 != r0) goto L15;
        return r0;
    L11:
        r6 = 0;
        goto L12
    }
}
