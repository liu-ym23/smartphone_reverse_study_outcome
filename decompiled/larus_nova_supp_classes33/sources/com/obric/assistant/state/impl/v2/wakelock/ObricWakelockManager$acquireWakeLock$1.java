package com.obric.assistant.state.impl.v2.wakelock;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager$acquireWakeLock$1", f = "ObricWakelockManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricWakelockManager$acquireWakeLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricWakelockManager.LockReason $reason;
    int label;

    public ObricWakelockManager$acquireWakeLock$1(ObricWakelockManager.LockReason r1, Continuation<? super ObricWakelockManager$acquireWakeLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricWakelockManager$acquireWakeLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r12);
        if (AppHost.a.a().isAppBackground() == false) goto L8;
        FLogger.a.i(ObricWakelockManager.b, "lock=wake action=acquire result=ignored_background reason=" + this.$reason);
        return Unit.INSTANCE;
    L8:
        ObricWakelockTimeoutHandler r13 = ObricWakelockManager.h;
        if (r13 == null) goto L11;
        r13.a("reset");
    L11:
        int r14 = ObricWakelockManager.f;
        ConcurrentHashMap<ObricWakelockManager.LockReason, Integer> r0 = ObricWakelockManager.g;
        if (r0.containsKey(this.$reason) == true) goto L17;
        r0.put(this.$reason, Boxing.boxInt(1));
        if (ObricWakelockManager.f != 0) goto L16;
        ObricWakelockManager.a.getClass();
        BuildersKt.launch$default(ObricWakelockManager.c, null, null, new ObricWakelockManager$acquireWakeLockInternal$1(null), 3, null);
    L16:
        ObricWakelockManager.f++;
        FLogger r1 = FLogger.a;
        String r4 = ObricWakelockManager.b;
        StringBuilder r5 = new StringBuilder("lock=wake action=acquire result=accepted reason=");
        r5.append(this.$reason);
        r5.append(" countBefore=");
        r5.append(r14);
        r5.append(" countAfter=");
        r5.append(ObricWakelockManager.f);
        r5.append(" reasons=");
        r5.append(r0.keySet());
        r5.append(" held=");
        ObricWakelockManager.a.getClass();
        r5.append(ObricWakelockManager.c().isHeld());
        r1.i(r4, r5.toString());
    L19:
        return Unit.INSTANCE;
    L17:
        FLogger r15 = FLogger.a;
        String r2 = ObricWakelockManager.b;
        StringBuilder r6 = new StringBuilder("lock=wake action=acquire result=ignored_duplicate reason=");
        r6.append(this.$reason);
        r6.append(" count=");
        r6.append(ObricWakelockManager.f);
        r6.append(" reasons=");
        r6.append(r0.keySet());
        r6.append(" held=");
        ObricWakelockManager.a.getClass();
        r6.append(ObricWakelockManager.c().isHeld());
        r15.i(r2, r6.toString());
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
