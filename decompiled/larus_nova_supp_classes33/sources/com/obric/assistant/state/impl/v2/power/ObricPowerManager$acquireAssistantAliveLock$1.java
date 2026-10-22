package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcher;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$acquireAssistantAliveLock$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricPowerManager$acquireAssistantAliveLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AssistantAliveReason $reason;
    int label;

    public ObricPowerManager$acquireAssistantAliveLock$1(AssistantAliveReason r1, Continuation<? super ObricPowerManager$acquireAssistantAliveLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPowerManager$acquireAssistantAliveLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r11);
        ObricPowerlockTimeoutHandler r12 = ObricPowerManager.g;
        if (r12 == null) goto L7;
        r12.a("reset");
    L7:
        Job r0 = ObricPowerManager.j;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
        FLogger.a.i("[ObricPowerManager]", "lock=assistant action=cancel_pending_release reason=" + this.$reason);
    L16:
        Job r2 = ObricPowerManager.j;
        ObricAssistantAliveLockStateType r3 = null;
        if (r2 == null) goto L19;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L19:
        ObricPowerManager.j = null;
        int r4 = ObricPowerManager.e.get();
        ConcurrentHashMap r5 = ObricPowerManager.f;
        if (r5.containsKey(this.$reason) == true) goto L36;
        r5.put(this.$reason, Boxing.boxInt(1));
        if (r4 != 0) goto L35;
        ObricAssistantAliveLockState r6 = ObricPowerManager.h;
        if (r6 == null) goto L26;
        r3 = r6.getCurrentState();
    L26:
        ObricAssistantAliveLockStateType r7 = ObricAssistantAliveLockStateType.ACQUIRED;
        if (r3 == r7) goto L35;
        AssistantAliveReason r8 = this.$reason;
        FLogger.a.i("[ObricPowerManager]", "lock=assistant action=publish state=" + r7 + " reason=" + r8);
        if (r12 != null) goto L41;
    L31:
        ObricAssistantAliveLockState r13 = new ObricAssistantAliveLockState(r7, "", MapsKt.mapOf(TuplesKt.to("state_change_reason", r8)));     // Catch: Exception -> L33
        ObricPowerManager.h = r13;     // Catch: Exception -> L33
        ObricStateDispatcher.a.a(r13);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        FLogger.a.e("[ObricPowerManager]", "lock=assistant action=publish state=" + ObricAssistantAliveLockStateType.ACQUIRED + " reason=" + r8 + " result=failed", e);
        goto L35
    L41:
        r12.a("start");     // Catch: Exception -> L33
    L35:
        AtomicInteger r14 = ObricPowerManager.e;
        r14.getAndAdd(1);
        FLogger.a.i("[ObricPowerManager]", "lock=assistant action=acquire result=accepted reason=" + this.$reason + " countBefore=" + r4 + " countAfter=" + r14.get() + " reasons=" + ObricPowerManager.f.keySet());
    L38:
        return Unit.INSTANCE;
    L36:
        FLogger.a.i("[ObricPowerManager]", "lock=assistant action=acquire result=ignored_duplicate reason=" + this.$reason + " count=" + r4 + " reasons=" + r5.keySet());
        goto L38
    L10:
        if (r0.isActive() != true) goto L12;
        r1 = true;
        goto L14
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
