package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$forceReleaseNetworkKeepAliveLock$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPowerManager$forceReleaseNetworkKeepAliveLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricPowerManager$ForceReleasePowerLockReason $reason;
    int label;

    public ObricPowerManager$forceReleaseNetworkKeepAliveLock$1(ObricPowerManager$ForceReleasePowerLockReason r1, Continuation<? super ObricPowerManager$forceReleaseNetworkKeepAliveLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPowerManager$forceReleaseNetworkKeepAliveLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        Job r8 = ObricPowerManager.i;
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L10:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("lock=network action=force_release reason=");
        r3.append(this.$reason);
        r3.append(" count=");
        r3.append(ObricPowerManager.b);
        r3.append(" reasons=");
        ConcurrentHashMap r4 = ObricPowerManager.c;
        r3.append(r4.keySet());
        r3.append(" pendingRelease=");
        r3.append(r9);
        r2.i("[ObricPowerManager]", r3.toString());
        r4.clear();
        Job r5 = ObricPowerManager.i;
        if (r5 == null) goto L13;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L13:
        ObricPowerManager.i = null;
        if (ObricPowerManager.b > 0) goto L16;
        if (r9 == true) goto L16;
    L17:
        ObricPowerManager.b = 0;
        return Unit.INSTANCE;
    L16:
        ObricPowerManager.b();
        goto L17
    L7:
        if (r8.isActive() != true) goto L9;
        r9 = true;
        goto L10
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
