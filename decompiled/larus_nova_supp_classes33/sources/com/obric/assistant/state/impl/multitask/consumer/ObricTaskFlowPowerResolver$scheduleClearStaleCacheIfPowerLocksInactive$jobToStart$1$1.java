package com.obric.assistant.state.impl.multitask.consumer;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockStateType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.consumer.ObricTaskFlowPowerResolver$scheduleClearStaleCacheIfPowerLocksInactive$jobToStart$1$1", f = "ObricTaskFlowPowerResolver.kt", i = {0}, l = {167}, m = "invokeSuspend", n = {"currentJob"}, s = {"L$0"})
final class ObricTaskFlowPowerResolver$scheduleClearStaleCacheIfPowerLocksInactive$jobToStart$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ String $state;
    Object L$0;
    int label;
    final /* synthetic */ ObricTaskFlowPowerResolver this$0;

    public ObricTaskFlowPowerResolver$scheduleClearStaleCacheIfPowerLocksInactive$jobToStart$1$1(ObricTaskFlowPowerResolver r1, String r2, String r3, Continuation<? super ObricTaskFlowPowerResolver$scheduleClearStaleCacheIfPowerLocksInactive$jobToStart$1$1> r4) {
        this.this$0 = r1;
        this.$source = r2;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricTaskFlowPowerResolver$scheduleClearStaleCacheIfPowerLocksInactive$jobToStart$1$1(this.this$0, this.$source, this.$state, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Job r4 = (Job) this.L$0;
        ResultKt.throwOnFailure(r9);
    L12:
        ObricTaskFlowPowerResolver r10 = this.this$0;
        Object r5 = r10.b;
        String r6 = this.$source;
        String r7 = this.$state;
        monitor-enter(r5);
    L21:
        th = move-exception;
        throw th;
    L15:
        if (r10.f == r4) goto L17;
    L30:
        monitor-exit(r5);
        return Unit.INSTANCE;
    L17:
        if (r10.d != ObricNetworkKeepAliveLockStateType.ACQUIRED) goto L19;
    L23:
        r3 = false;
    L24:
        if (r3 == false) goto L30;
        if (r10.a.isEmpty() == false) goto L29;
        r10.f = null;     // Catch: Throwable -> L21
        goto L30
    L29:
        FLogger.a.w("ObricTaskFlowPowerResolver", "clear stale active task cache because power locks inactive, source=" + r6 + ",state=" + r7 + ",activeTaskIdsByReason=" + r10.a);     // Catch: Throwable -> L21
        r10.a.clear();     // Catch: Throwable -> L21
        r10.f = null;     // Catch: Throwable -> L21
        goto L30
    L19:
        if (r10.e == ObricAssistantAliveLockStateType.ACQUIRED) goto L23;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        Job r11 = getContext().get(Job.Key);
        this.L$0 = r11;
        this.label = 1;
        if (DelayKt.delay(500, this) != r1) goto L11;
        return r1;
    L11:
        r4 = r11;
        goto L12
    }
}
