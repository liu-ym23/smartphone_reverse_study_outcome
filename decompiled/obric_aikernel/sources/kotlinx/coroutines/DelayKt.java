package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
public final class DelayKt {
    public static final Object a(Continuation<?> r10) {
        if ((r10 instanceof DelayKt$awaitCancellation$1) == false) goto L7;
        DelayKt$awaitCancellation$1 r11 = (DelayKt$awaitCancellation$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L12;
        ResultKt.throwOnFailure(r13);
    L20:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.label = 1;
        o r16 = new o(IntrinsicsKt.intercepted(r11), 1);
        r16.F();
        Object r17 = r16.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L17:
        if (r17 != r14) goto L20;
        return r14;
    L7:
        r11 = new DelayKt$awaitCancellation$1(r10);
        goto L8
    }

    public static final Object b(long r10, Continuation<? super Unit> r11) {
        if (r10 <= 0) goto L5;
        o r12 = new o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        if (r10 >= Long.MAX_VALUE) goto L9;
        c(r12.getContext()).k(r10, r12);
    L9:
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L13:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r13;
    L16:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static final t0 c(CoroutineContext r10) {
        CoroutineContext.Element r11 = r10.get(ContinuationInterceptor.Key);
        if ((r11 instanceof t0) == false) goto L5;
        t0 r12 = (t0) r11;
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return q0.a();
    L5:
        r12 = null;
        goto L6
    }

    public static final long d(long r10) {
        if (Duration.m1383compareToLRDsOJo(r10, Duration.Companion.m1487getZEROUwyO8pc()) > 0) goto L7;
        return 0;
    L7:
        return RangesKt.coerceAtLeast(Duration.m1402getInWholeMillisecondsimpl(r10), 1);
    }
}
