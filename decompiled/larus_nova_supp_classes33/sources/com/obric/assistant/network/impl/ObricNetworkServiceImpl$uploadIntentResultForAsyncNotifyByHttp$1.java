package com.obric.assistant.network.impl;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import dm9.a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1", f = "ObricNetworkServiceImpl.kt", i = {0, 0}, l = {359}, m = "invokeSuspend", n = {"seqId", "responseLogIdCapture"}, s = {"L$0", "L$1"})
public final class ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ List<OPushEvent> $intentResult;
    final /* synthetic */ boolean $needRetry;
    final /* synthetic */ Map<String, Object> $performanceExtras;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1(ObricNetworkServiceImpl r1, List<OPushEvent> r2, boolean r3, Map<String, ? extends Object> r4, IFlowNetworkResultCallbackIDL r5, Continuation<? super ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1> r6) {
        this.this$0 = r1;
        this.$intentResult = r2;
        this.$needRetry = r3;
        this.$performanceExtras = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1(this.this$0, this.$intentResult, this.$needRetry, this.$performanceExtras, this.$callback, r9);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        m r2 = (m) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L6:
        String r4 = r3;
        a r5 = (a) r15;
        ObricNetworkServiceImpl r6 = this.this$0;
        IntentShortLinkType r7 = IntentShortLinkType.ASYNC_NOTIFY;
        boolean r8 = this.$needRetry;
        IFlowNetworkResultCallbackIDL r9 = this.$callback;
        String r10 = r2.a;
        List r16 = ObricNetworkServiceImpl.i;
        r6.G(r7, r4, r8, r5, r9, r10);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        long r11 = SystemClock.elapsedRealtime();
        vea.i r17 = ObricNetworkServiceImpl.y(this.this$0, this.$intentResult);
        long r12 = SystemClock.elapsedRealtime() - r11;
        r3 = UUID.randomUUID().toString();
        FLogger.a.i("[ObricNetworkServiceImpl]", "uploadIntentResultForAsyncNotifyByHttp: start, " + this.$needRetry + ", " + r3);
        this.this$0.b.put(r3, r17);
        Map<String, Object> r13 = this.$performanceExtras;
        if (r13 == null) goto L14;
        Map r14 = MapsKt.toMutableMap(r13);
        if (r14 == null) goto L14;
        ObricNetworkServiceImpl.x(this.this$0, r14, r12);
        r14.put("network_start_time", Boxing.boxLong(SystemClock.elapsedRealtime()));
    L15:
        if (r14 == null) goto L18;
        this.this$0.d.put(r3, r14);
    L18:
        if (this.$needRetry == false) goto L20;
        this.this$0.J(IntentShortLinkType.ASYNC_NOTIFY, r3, 0, this.$callback, null, null);
    L20:
        int r18 = xea.a.a;
        xea.a.b("/assistant/func_call/notify", r3, Boxing.boxInt(this.this$0.isNetworkAvailable() ? 1 : 0));
        m r19 = new m();
        ObricProtocolApi.a r20 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1 r21 = new ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttp$1$response$1(r3, r17, null);
        this.L$0 = r3;
        this.L$1 = r19;
        this.label = 1;
        r20.getClass();
        r15 = ObricProtocolApi.a.b(r19, r21, this);
        if (r15 != r0) goto L23;
        return r0;
    L23:
        r2 = r19;
    L14:
        r14 = null;
        goto L15
    }
}
