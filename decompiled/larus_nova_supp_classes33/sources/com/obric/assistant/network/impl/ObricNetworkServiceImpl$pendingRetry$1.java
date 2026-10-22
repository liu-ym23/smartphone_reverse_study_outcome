package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import dm9.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$pendingRetry$1", f = "ObricNetworkServiceImpl.kt", i = {1, 1}, l = {517, 549}, m = "invokeSuspend", n = {"retParams", "responseLogIdCapture"}, s = {"L$0", "L$1"})
final class ObricNetworkServiceImpl$pendingRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ int $index;
    final /* synthetic */ String $lastResponseLogId;
    final /* synthetic */ a<Object> $lastRetryResult;
    final /* synthetic */ String $seqId;
    final /* synthetic */ IntentShortLinkType $type;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$pendingRetry$1(ObricNetworkServiceImpl r1, String r2, IntentShortLinkType r3, int r4, a<? extends Object> r5, String r6, IFlowNetworkResultCallbackIDL r7, Continuation<? super ObricNetworkServiceImpl$pendingRetry$1> r8) {
        this.this$0 = r1;
        this.$seqId = r2;
        this.$type = r3;
        this.$index = r4;
        this.$lastRetryResult = r5;
        this.$lastResponseLogId = r6;
        this.$callback = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ObricNetworkServiceImpl$pendingRetry$1(this.this$0, this.$seqId, this.$type, this.$index, this.$lastRetryResult, this.$lastResponseLogId, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        m r3 = (m) this.L$1;
        Map r4 = (Map) this.L$0;
        ResultKt.throwOnFailure(r24);
        Map r11 = r4;
        Object r5 = r24;
    L38:
        a.b r6 = (a) r5;
        FLogger.a.i("[ObricNetworkServiceImpl]", "pendingRetry: type: " + this.$type + ", seqId: " + this.$seqId + ", index: " + this.$index + ", response = " + r6);
        if ((r6 instanceof a.b) == false) goto L47;
        a.b r7 = r6;
        if (((int) r7.a.getCode()) != 0) goto L47;
        r11.put("code", Boxing.boxLong(r7.a.getCode()));
        r11.put("msg", String.valueOf(r7.a.getMsg()));
        ObricNetworkServiceImpl r8 = this.this$0;
        String r9 = this.$seqId;
        String r10 = r3.a;
        List r12 = ObricNetworkServiceImpl.i;
        r8.C(r9, r11, r10);
        IFlowNetworkResultCallbackIDL r13 = this.$callback;
        if (r13 == null) goto L45;
        r13.onResult(true, r11);
    L45:
        this.this$0.b.remove(this.$seqId);
        ObricNetworkServiceImpl.z(this.this$0, this.$type, this.$seqId, this.$index + 1, r6);
        return Unit.INSTANCE;
    L47:
        ObricNetworkServiceImpl r14 = this.this$0;
        IntentShortLinkType r15 = this.$type;
        String r16 = this.$seqId;
        int r19 = this.$index + 1;
        IFlowNetworkResultCallbackIDL r17 = this.$callback;
        String r18 = r3.a;
        List r20 = ObricNetworkServiceImpl.i;
        r14.J(r15, r16, r19, r17, r6, r18);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r24);
    L13:
        vea.i r21 = (vea.i) this.this$0.b.get(this.$seqId);
        if (r21 == null) goto L16;
        FLogger r110 = FLogger.a;
        r110.i("[ObricNetworkServiceImpl]", "pendingRetry, type: " + this.$type + ", seqId: " + this.$seqId + ", index: " + this.$index);
        r11 = new LinkedHashMap();
        if (this.$index < 4) goto L34;
        r110.e("[ObricNetworkServiceImpl]", "pendingRetry, exceed retry limit, abort retry, " + this.$seqId);
        a.a r22 = this.$lastRetryResult;
        if ((r22 instanceof a.a) == false) goto L23;
        r11.put("code", Boxing.boxInt(r22.a));
        r11.put("msg", this.$lastRetryResult.b);
    L27:
        this.this$0.C(this.$seqId, r11, this.$lastResponseLogId);
        IFlowNetworkResultCallbackIDL r23 = this.$callback;
        if (r23 == null) goto L30;
        r23.onResult(false, r11);
    L30:
        this.this$0.b.remove(this.$seqId);
        ObricNetworkServiceImpl.z(this.this$0, this.$type, this.$seqId, this.$index, this.$lastRetryResult);
        return Unit.INSTANCE;
    L23:
        if ((r22 instanceof a.b) == false) goto L25;
        r11.put("code", Boxing.boxLong(((a.b) r22).a.getCode()));
        r11.put("msg", String.valueOf(this.$lastRetryResult.a.getMsg()));
        goto L27
    L25:
        if (r22 != null) goto L33;
        r11.put("msg", "exceed retry limit, abort retry");
        goto L27
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        ObricNetworkServiceImpl.B(this.this$0, this.$seqId);
        m r111 = new m();
        ObricProtocolApi.a r112 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$pendingRetry$1$response$1 r113 = new ObricNetworkServiceImpl$pendingRetry$1$response$1(this.$type, this.$seqId, r21, null);
        this.L$0 = r11;
        this.L$1 = r111;
        this.label = 2;
        r112.getClass();
        r5 = ObricProtocolApi.a.b(r111, r113, this);
        if (r5 != r1) goto L37;
        return r1;
    L37:
        r3 = r111;
        goto L38
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r24);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r1) goto L13;
        return r1;
    }
}
