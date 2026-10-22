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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager$releaseWakeLock$1", f = "ObricWakelockManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricWakelockManager$releaseWakeLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ ObricWakelockManager.LockReason $reason;
    int label;

    public ObricWakelockManager$releaseWakeLock$1(ObricWakelockManager.LockReason r1, long r2, Continuation<? super ObricWakelockManager$releaseWakeLock$1> r4) {
        this.$reason = r1;
        this.$delayMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricWakelockManager$releaseWakeLock$1(this.$reason, this.$delayMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r10);
        int r11 = ObricWakelockManager.f;
        ConcurrentHashMap<ObricWakelockManager.LockReason, Integer> r0 = ObricWakelockManager.g;
        if (r0.containsKey(this.$reason) == false) goto L13;
        if (r11 <= 0) goto L13;
        r0.remove(this.$reason);
        ObricWakelockManager.f--;
        FLogger r1 = FLogger.a;
        String r3 = ObricWakelockManager.b;
        StringBuilder r4 = new StringBuilder("lock=wake action=release result=accepted reason=");
        r4.append(this.$reason);
        r4.append(" countBefore=");
        r4.append(r11);
        r4.append(" countAfter=");
        r4.append(ObricWakelockManager.f);
        r4.append(" reasons=");
        r4.append(r0.keySet());
        r4.append(" requestedDelayMs=");
        r4.append(RangesKt.coerceAtLeast(this.$delayMs, 0));
        r4.append(" releaseMode=immediate held=");
        ObricWakelockManager.a.getClass();
        r4.append(ObricWakelockManager.c().isHeld());
        r1.i(r3, r4.toString());
        if (ObricWakelockManager.f != 0) goto L12;
        BuildersKt.launch$default(ObricWakelockManager.c, null, null, new ObricWakelockManager$releaseWakeLockInternal$1(null), 3, null);
    L12:
        return Unit.INSTANCE;
    L13:
        FLogger r2 = FLogger.a;
        String r5 = ObricWakelockManager.b;
        StringBuilder r6 = new StringBuilder("lock=wake action=release result=ignored_missing reason=");
        r6.append(this.$reason);
        r6.append(" count=");
        r6.append(r11);
        r6.append(" reasons=");
        r6.append(r0.keySet());
        r6.append(" held=");
        ObricWakelockManager.a.getClass();
        r6.append(ObricWakelockManager.c().isHeld());
        r2.i(r5, r6.toString());
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
