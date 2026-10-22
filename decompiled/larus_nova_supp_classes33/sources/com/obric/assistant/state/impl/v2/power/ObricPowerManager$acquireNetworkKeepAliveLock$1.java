package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockStateType;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcher;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$acquireNetworkKeepAliveLock$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricPowerManager$acquireNetworkKeepAliveLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AssistantAliveReason $reason;
    int label;

    public ObricPowerManager$acquireNetworkKeepAliveLock$1(AssistantAliveReason r1, Continuation<? super ObricPowerManager$acquireNetworkKeepAliveLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPowerManager$acquireNetworkKeepAliveLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r14);
        ObricPowerlockTimeoutHandler r15 = ObricPowerManager.d;
        if (r15 == null) goto L7;
        r15.a("reset");
    L7:
        Job r0 = ObricPowerManager.i;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
        FLogger.a.i("[ObricPowerManager]", "lock=network action=cancel_pending_release reason=" + this.$reason);
    L16:
        Job r2 = ObricPowerManager.i;
        if (r2 == null) goto L19;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L19:
        ObricPowerManager.i = null;
        int r3 = ObricPowerManager.b;
        ConcurrentHashMap r4 = ObricPowerManager.c;
        if (r4.containsKey(this.$reason) == true) goto L31;
        r4.put(this.$reason, Boxing.boxInt(1));
        if (ObricPowerManager.b != 0) goto L30;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("lock=network action=publish state=");
        ObricNetworkKeepAliveLockStateType r8 = ObricNetworkKeepAliveLockStateType.ACQUIRED;
        r6.append(r8);
        r5.i("[ObricPowerManager]", r6.toString());
        if (r15 != null) goto L36;
    L26:
        ObricStateDispatcher.a.d(new ObricNetworkKeepAliveLockState(r8, "", null, 4, null));     // Catch: Exception -> L28
    L28:
        e = move-exception;
        FLogger.a.e("[ObricPowerManager]", "lock=network action=publish state=" + ObricNetworkKeepAliveLockStateType.ACQUIRED + " result=failed", e);
        goto L30
    L36:
        r15.a("start");     // Catch: Exception -> L28
    L30:
        ObricPowerManager.b++;
        FLogger.a.i("[ObricPowerManager]", "lock=network action=acquire result=accepted reason=" + this.$reason + " countBefore=" + r3 + " countAfter=" + ObricPowerManager.b + " reasons=" + ObricPowerManager.c.keySet());
    L33:
        return Unit.INSTANCE;
    L31:
        FLogger.a.i("[ObricPowerManager]", "lock=network action=acquire result=ignored_duplicate reason=" + this.$reason + " count=" + ObricPowerManager.b + " reasons=" + r4.keySet());
        goto L33
    L10:
        if (r0.isActive() != true) goto L12;
        r1 = true;
        goto L14
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
