package com.obric.assistant.state.impl.v2.wakelock;

import android.os.PowerManager;
import com.larus.utils.logger.FLogger;
import fna.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager$acquireWakeLockInternal$1", f = "ObricWakelockManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricWakelockManager$acquireWakeLockInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricWakelockManager$acquireWakeLockInternal$1(Continuation<? super ObricWakelockManager$acquireWakeLockInternal$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricWakelockManager$acquireWakeLockInternal$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_state_impl_v2_wakelock_ObricWakelockManager$acquireWakeLockInternal$1_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r1) {
        if (g.d() == true) goto L6;
        r1.acquire();
        return;
    L6:
        r1.acquire();
        com.obric.performance.power.monitor.cpu.d.a(r1);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        FLogger r6 = FLogger.a;
        String r1 = ObricWakelockManager.b;
        StringBuilder r2 = new StringBuilder("lock=wake action=execute_acquire held=");
        ObricWakelockManager.a.getClass();
        r2.append(ObricWakelockManager.c().isHeld());
        r6.i(r1, r2.toString());
    L13:
        e = move-exception;
        FLogger.a.e(ObricWakelockManager.b, "lock=wake action=execute_acquire result=failed", e);
    L16:
        return Unit.INSTANCE;
    L6:
        if (ObricWakelockManager.c().isHeld() == true) goto L11;
        ObricWakelockTimeoutHandler r3 = ObricWakelockManager.h;     // Catch: Exception -> L13
        if (r3 == null) goto L10;
        r3.a("start");     // Catch: Exception -> L13
    L10:
        INVOKEVIRTUAL_com_obric_assistant_state_impl_v2_wakelock_ObricWakelockManager$acquireWakeLockInternal$1_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(ObricWakelockManager.c());     // Catch: Exception -> L13
        r6.i(r1, "lock=wake action=execute_acquire result=success held=" + ObricWakelockManager.c().isHeld());     // Catch: Exception -> L13
        goto L16
    L11:
        r6.i(r1, "lock=wake action=execute_acquire result=already_held held=true");     // Catch: Exception -> L13
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
