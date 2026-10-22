package com.obric.assistant.network.impl;

import android.os.SystemClock;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1", f = "ObricNetworkServiceImpl.kt", i = {0, 0}, l = {406}, m = "invokeSuspend", n = {"seqId", "responseLogIdCapture"}, s = {"L$0", "L$1"})
public final class ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bodyBytes;
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ boolean $needRetry;
    final /* synthetic */ Map<String, Object> $performanceExtras;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1(byte[] r1, boolean r2, ObricNetworkServiceImpl r3, Map<String, ? extends Object> r4, IFlowNetworkResultCallbackIDL r5, Continuation<? super ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1> r6) {
        this.$bodyBytes = r1;
        this.$needRetry = r2;
        this.this$0 = r3;
        this.$performanceExtras = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1(this.$bodyBytes, this.$needRetry, this.this$0, this.$performanceExtras, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        m r3 = (m) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r23);
        String r5 = r4;
        Object r6 = r23;
    L24:
        a.b r7 = (a) r6;
        if (this.$needRetry == true) goto L27;
    L30:
        this.this$0.c.remove(r5);
    L31:
        ObricNetworkServiceImpl r8 = this.this$0;
        IntentShortLinkType r9 = IntentShortLinkType.ASYNC_NOTIFY;
        boolean r10 = this.$needRetry;
        IFlowNetworkResultCallbackIDL r11 = this.$callback;
        String r12 = r3.a;
        List r13 = ObricNetworkServiceImpl.i;
        r8.G(r9, r5, r10, r7, r11, r12);
        return Unit.INSTANCE;
    L27:
        if ((r7 instanceof a.b) == false) goto L31;
        if (((int) r7.a.getCode()) != 0) goto L31;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        long r14 = SystemClock.elapsedRealtime();
        TypedByteArray r15 = new TypedByteArray("application/json; charset=UTF-8", this.$bodyBytes, new String[0]);
        long r16 = SystemClock.elapsedRealtime() - r14;
        String r17 = UUID.randomUUID().toString();
        FLogger.a.i("[ObricNetworkServiceImpl]", "uploadIntentResultForAsyncNotifyByHttpOptimized: start, " + this.$needRetry + ", bodyBytes=" + this.$bodyBytes.length + ", requestBuildDurationMs=" + r16 + ", seqId=" + r17);
        this.this$0.c.put(r17, this.$bodyBytes);
        Map<String, Object> r18 = this.$performanceExtras;
        if (r18 == null) goto L13;
        Map r19 = MapsKt.toMutableMap(r18);
        if (r19 == null) goto L13;
        ObricNetworkServiceImpl.x(this.this$0, r19, r16);
        r19.put("network_start_time", Boxing.boxLong(SystemClock.elapsedRealtime()));
    L14:
        if (r19 == null) goto L17;
        this.this$0.d.put(r17, r19);
    L17:
        if (this.$needRetry == false) goto L20;
        ObricNetworkServiceImpl r20 = this.this$0;
        BuildersKt.launch$default(r20.E(), null, null, new ObricNetworkServiceImpl$pendingOptimizedNotifyRetry$1(r20, r17, 0, null, null, this.$callback, null), 3, null);
    L20:
        int r21 = xea.a.a;
        xea.a.b("/assistant/func_call/notify", r17, Boxing.boxInt(this.this$0.isNetworkAvailable() ? 1 : 0));
        m r22 = new m();
        ObricProtocolApi.a r24 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1$response$1 r25 = new ObricNetworkServiceImpl$uploadIntentResultForAsyncNotifyByHttpOptimized$1$response$1(r17, r15, 0);
        this.L$0 = r17;
        this.L$1 = r22;
        this.label = 1;
        r24.getClass();
        r6 = ObricProtocolApi.a.b(r22, r25, this);
        if (r6 != r1) goto L23;
        return r1;
    L23:
        r3 = r22;
        r5 = r17;
    L13:
        r19 = null;
        goto L14
    }
}
