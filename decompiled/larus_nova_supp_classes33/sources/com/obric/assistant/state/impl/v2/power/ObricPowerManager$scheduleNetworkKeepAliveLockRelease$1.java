package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1", f = "ObricPowerManager.kt", i = {0}, l = {317}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ AssistantAliveReason $reason;
    private /* synthetic */ Object L$0;
    int label;

    public ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1(long r1, AssistantAliveReason r3, Continuation<? super ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1> r4) {
        this.$delayMs = r1;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1 r0 = new ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1(this.$delayMs, this.$reason, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        if (CoroutineScopeKt.isActive(r2) == true) goto L15;
    L19:
        FLogger r7 = FLogger.a;
        CoroutineScope r3 = ObricPowerManager.a;
        r7.i("[ObricPowerManager]", "lock=network action=skip_release reason=" + this.$reason + " delayMs=" + this.$delayMs + " count=" + ObricPowerManager.b + " reasons=" + ObricPowerManager.c.keySet());
    L21:
        return Unit.INSTANCE;
    L15:
        if (ObricPowerManager.b != 0) goto L19;
        if (ObricPowerManager.c.isEmpty() == false) goto L19;
        FLogger.a.i("[ObricPowerManager]", "lock=network action=execute_release reason=" + this.$reason + " delayMs=" + this.$delayMs);
        ObricPowerManager.b();
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        long r4 = this.$delayMs;
        this.L$0 = r8;
        this.label = 1;
        if (CoroutineExtKt.a(r4, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L13
    }
}
