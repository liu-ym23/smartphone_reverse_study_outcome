package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeoutKt {
    public static final TimeoutCancellationException a(long r10, t0 r11, v1 r12) {
        if ((r11 instanceof u0) == false) goto L5;
        u0 r13 = (u0) r11;
    L6:
        if (r13 == null) goto L9;
        Duration.Companion r14 = Duration.Companion;
        String r15 = r13.N(DurationKt.toDuration(r10, DurationUnit.MILLISECONDS));
        if (r15 == null) goto L9;
    L11:
        return new TimeoutCancellationException(r15, r12);
    L9:
        r15 = "Timed out waiting for " + r10 + " ms";
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    private static final <U, T extends U> Object b(y2<U, ? super T> r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11) {
        y1.f(r10, DelayKt.c(r10.f10546i.getContext()).B(r10.f10735j, r10, r10.getContext()));
        return fc.b.d(r10, r10, r11);
    }

    public static final <T> Object c(long r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        if (r10 <= 0) goto L9;
        Object r13 = b(new y2(r10, r12), r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L7:
        return r13;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.y2] */
    public static final <T> Object d(long r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        if ((r12 instanceof TimeoutKt$withTimeoutOrNull$1) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r13 = (TimeoutKt$withTimeoutOrNull$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r13.L$1;
        Function2 r19 = (Function2) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: TimeoutCancellationException -> L14
        return r15;
    L14:
        e = e;
    L32:
        if (e.coroutine != r18.element) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (r10 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r13.L$0 = r11;     // Catch: TimeoutCancellationException -> L29
        r13.L$1 = r110;     // Catch: TimeoutCancellationException -> L29
        r13.J$0 = r10;     // Catch: TimeoutCancellationException -> L29
        r13.label = 1;     // Catch: TimeoutCancellationException -> L29
        ?? r20 = (T) new y2(r10, r13);
        r110.element = r20;     // Catch: TimeoutCancellationException -> L29
        Object r21 = b(r20, r11);     // Catch: TimeoutCancellationException -> L29
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r13);     // Catch: TimeoutCancellationException -> L29
    L25:
        if (r21 != r16) goto L28;
        return r16;
    L28:
        return r21;
    L29:
        e = e;
        r18 = r110;
    L7:
        r13 = new TimeoutKt$withTimeoutOrNull$1(r12);
        goto L8
    }
}
