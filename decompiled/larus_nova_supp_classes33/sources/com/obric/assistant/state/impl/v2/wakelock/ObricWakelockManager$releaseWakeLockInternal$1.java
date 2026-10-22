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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager$releaseWakeLockInternal$1", f = "ObricWakelockManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricWakelockManager$releaseWakeLockInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricWakelockManager$releaseWakeLockInternal$1(Continuation<? super ObricWakelockManager$releaseWakeLockInternal$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricWakelockManager$releaseWakeLockInternal$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_state_impl_v2_wakelock_ObricWakelockManager$releaseWakeLockInternal$1_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r1) {
        if (g.d() == true) goto L6;
        r1.release();
        return;
    L6:
        r1.release();
        com.obric.performance.power.monitor.cpu.d.b(r1);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r12);
        FLogger r13 = FLogger.a;
        String r1 = ObricWakelockManager.b;
        StringBuilder r2 = new StringBuilder("lock=wake action=execute_release held=");
        ObricWakelockManager.a.getClass();
        r2.append(ObricWakelockManager.c().isHeld());
        r13.i(r1, r2.toString());
        ObricWakelockTimeoutHandler r3 = ObricWakelockManager.h;     // Catch: Exception -> L13
        if (r3 == null) goto L9;
        r13.i(r3.c, "cancelObricWakelockTimeoutHandler");     // Catch: Exception -> L13
        BuildersKt.launch$default(r3.d, null, null, new ObricWakelockTimeoutHandler$cancel$1(r3, null), 3, null);     // Catch: Exception -> L13
    L9:
        if (ObricWakelockManager.c().isHeld() == false) goto L11;
        INVOKEVIRTUAL_com_obric_assistant_state_impl_v2_wakelock_ObricWakelockManager$releaseWakeLockInternal$1_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(ObricWakelockManager.c());     // Catch: Exception -> L13
        r13.i(r1, "lock=wake action=execute_release result=success held=" + ObricWakelockManager.c().isHeld());     // Catch: Exception -> L13
    L16:
        return Unit.INSTANCE;
    L11:
        r13.i(r1, "lock=wake action=execute_release result=already_released held=false");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        FLogger.a.e(ObricWakelockManager.b, "lock=wake action=execute_release result=failed", e);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
