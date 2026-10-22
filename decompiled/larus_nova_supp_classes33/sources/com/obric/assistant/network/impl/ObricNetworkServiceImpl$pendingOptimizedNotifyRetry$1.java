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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1", f = "ObricNetworkServiceImpl.kt", i = {1, 1}, l = {591, 633}, m = "invokeSuspend", n = {"retParams", "responseLogIdCapture"}, s = {"L$0", "L$1"})
final class ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ int $index;
    final /* synthetic */ String $lastResponseLogId;
    final /* synthetic */ a<Object> $lastRetryResult;
    final /* synthetic */ String $seqId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1(ObricNetworkServiceImpl r1, String r2, int r3, a<? extends Object> r4, String r5, IFlowNetworkResultCallbackIDL r6, Continuation<? super ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1> r7) {
        this.this$0 = r1;
        this.$seqId = r2;
        this.$index = r3;
        this.$lastRetryResult = r4;
        this.$lastResponseLogId = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1(this.this$0, this.$seqId, this.$index, this.$lastRetryResult, this.$lastResponseLogId, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        m r2 = (m) this.L$1;
        Map r3 = (Map) this.L$0;
        ResultKt.throwOnFailure(r15);
    L38:
        a.b r10 = (a) r15;
        if ((r10 instanceof a.b) == false) goto L47;
        a.b r16 = r10;
        if (((int) r16.a.getCode()) != 0) goto L47;
        r3.put("code", Boxing.boxLong(r16.a.getCode()));
        r3.put("msg", String.valueOf(r16.a.getMsg()));
        ObricNetworkServiceImpl r17 = this.this$0;
        String r4 = this.$seqId;
        String r5 = r2.a;
        List r6 = ObricNetworkServiceImpl.i;
        r17.C(r4, r3, r5);
        IFlowNetworkResultCallbackIDL r18 = this.$callback;
        if (r18 == null) goto L45;
        r18.onResult(true, r3);
    L45:
        this.this$0.c.remove(this.$seqId);
        ObricNetworkServiceImpl.z(this.this$0, IntentShortLinkType.ASYNC_NOTIFY, this.$seqId, this.$index + 1, r10);
        return Unit.INSTANCE;
    L47:
        ObricNetworkServiceImpl r7 = this.this$0;
        String r8 = this.$seqId;
        int r9 = this.$index + 1;
        IFlowNetworkResultCallbackIDL r12 = this.$callback;
        String r11 = r2.a;
        List r19 = ObricNetworkServiceImpl.i;
        BuildersKt.launch$default(r7.E(), null, null, new ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1(r7, r8, r9, r10, r11, r12, null), 3, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        byte[] r110 = (byte[]) this.this$0.c.get(this.$seqId);
        if (r110 == null) goto L16;
        FLogger r13 = FLogger.a;
        r13.i("[ObricNetworkServiceImpl]", "pendingOptimizedNotifyRetry, seqId: " + this.$seqId + ", index: " + this.$index + ", bodyBytes=" + r110.length);
        LinkedHashMap r14 = new LinkedHashMap();
        if (this.$index < 4) goto L34;
        r13.e("[ObricNetworkServiceImpl]", "pendingOptimizedNotifyRetry, exceed retry limit, abort retry, " + this.$seqId);
        a.a r111 = this.$lastRetryResult;
        if ((r111 instanceof a.a) == false) goto L23;
        r14.put("code", Boxing.boxInt(r111.a));
        r14.put("msg", this.$lastRetryResult.b);
    L27:
        this.this$0.C(this.$seqId, r14, this.$lastResponseLogId);
        IFlowNetworkResultCallbackIDL r112 = this.$callback;
        if (r112 == null) goto L30;
        r112.onResult(false, r14);
    L30:
        this.this$0.c.remove(this.$seqId);
        ObricNetworkServiceImpl.z(this.this$0, IntentShortLinkType.ASYNC_NOTIFY, this.$seqId, this.$index, this.$lastRetryResult);
        return Unit.INSTANCE;
    L23:
        if ((r111 instanceof a.b) == false) goto L25;
        r14.put("code", Boxing.boxLong(((a.b) r111).a.getCode()));
        r14.put("msg", String.valueOf(this.$lastRetryResult.a.getMsg()));
        goto L27
    L25:
        if (r111 != null) goto L33;
        r14.put("msg", "exceed retry limit, abort retry");
        goto L27
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        ObricNetworkServiceImpl.B(this.this$0, this.$seqId);
        m r20 = new m();
        ObricProtocolApi.a r21 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1$response$1 r22 = new ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1$response$1(this.$seqId, this.$index, r110, null);
        this.L$0 = r14;
        this.L$1 = r20;
        this.label = 2;
        r21.getClass();
        r15 = ObricProtocolApi.a.b(r20, r22, this);
        if (r15 != r0) goto L37;
        return r0;
    L37:
        r2 = r20;
        r3 = r14;
        goto L38
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L13;
        return r0;
    }
}
