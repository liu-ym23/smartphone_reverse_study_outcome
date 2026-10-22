package com.obric.assistant.state.impl.v2.wakelock;

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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager$forceReleaseWakeLock$1", f = "ObricWakelockManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricWakelockManager$forceReleaseWakeLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricWakelockManager.ForceReleaseWakelockReason $reason;
    int label;

    public ObricWakelockManager$forceReleaseWakeLock$1(ObricWakelockManager.ForceReleaseWakelockReason r1, Continuation<? super ObricWakelockManager$forceReleaseWakeLock$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricWakelockManager$forceReleaseWakeLock$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        FLogger r8 = FLogger.a;
        String r0 = ObricWakelockManager.b;
        StringBuilder r1 = new StringBuilder("lock=wake action=force_release reason=");
        r1.append(this.$reason);
        r1.append(" count=");
        r1.append(ObricWakelockManager.f);
        r1.append(" reasons=");
        ConcurrentHashMap<ObricWakelockManager.LockReason, Integer> r2 = ObricWakelockManager.g;
        r1.append(r2.keySet());
        r1.append(" held=");
        ObricWakelockManager.a.getClass();
        r1.append(ObricWakelockManager.c().isHeld());
        r8.i(r0, r1.toString());
        r2.clear();
        if (ObricWakelockManager.f <= 0) goto L7;
        BuildersKt.launch$default(ObricWakelockManager.c, null, null, new ObricWakelockManager$releaseWakeLockInternal$1(null), 3, null);
    L7:
        ObricWakelockManager.f = 0;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
