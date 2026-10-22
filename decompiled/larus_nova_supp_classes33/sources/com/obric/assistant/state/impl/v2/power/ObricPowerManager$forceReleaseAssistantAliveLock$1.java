package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$forceReleaseAssistantAliveLock$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPowerManager$forceReleaseAssistantAliveLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricPowerManager$ForceReleasePowerLockReason $reason;
    int label;

    public ObricPowerManager$forceReleaseAssistantAliveLock$1(ObricPowerManager$ForceReleasePowerLockReason r1, Continuation<? super ObricPowerManager$forceReleaseAssistantAliveLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPowerManager$forceReleaseAssistantAliveLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        FLogger r6 = FLogger.a;
        CoroutineScope r0 = ObricPowerManager.a;
        StringBuilder r1 = new StringBuilder("lock=assistant action=force_release reason=");
        r1.append(this.$reason);
        r1.append(" count=");
        AtomicInteger r2 = ObricPowerManager.e;
        r1.append(r2.get());
        r1.append(" reasons=");
        ConcurrentHashMap r3 = ObricPowerManager.f;
        r1.append(r3.keySet());
        r6.i("[ObricPowerManager]", r1.toString());
        r3.clear();
        Job r7 = ObricPowerManager.j;
        ObricAssistantAliveLockStateType r4 = null;
        if (r7 == null) goto L7;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L7:
        ObricPowerManager.j = null;
        if (r2.get() > 0) goto L14;
        ObricAssistantAliveLockState r8 = ObricPowerManager.h;
        if (r8 == null) goto L13;
        r4 = r8.getCurrentState();
    L13:
        if (r4 == ObricAssistantAliveLockStateType.ACQUIRED) goto L14;
    L15:
        r2.set(0);
        return Unit.INSTANCE;
    L14:
        ObricPowerManager.a(AssistantAliveReason.FORCE_EXIT);
        goto L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
