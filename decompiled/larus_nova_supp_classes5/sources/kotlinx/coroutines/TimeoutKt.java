package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TimeoutKt {
    public static final <U, T extends U> Object a(z1<U, ? super T> r4, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r5) {
        JobKt.disposeOnCompletion(r4, DelayKt.getDelay(((x) r4).d.getContext()).invokeOnTimeout(r4.e, r4, r4.getContext()));
        boolean r0 = false;
    L8:
        th = move-exception;
        Object r6 = new t(th, false);
    L11:
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        Object r1 = r4.V(r6);
        if (r1 != g1.b) goto L17;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L17:
        if ((r1 instanceof t) == false) goto L30;
        Throwable r2 = ((t) r1).a;
        if ((r2 instanceof TimeoutCancellationException) == true) goto L21;
    L22:
        r0 = true;
    L23:
        if (r0 == false) goto L25;
        throw r2;
    L25:
        if ((r6 instanceof t) == false) goto L32;
        throw ((t) r6).a;
    L32:
        return r6;
    L21:
        if (((TimeoutCancellationException) r2).coroutine == r4) goto L23;
    L30:
        r6 = g1.a(r1);
        goto L32
    L36:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        if ((r5 instanceof BaseContinuationImpl) == true) goto L6;
        r6 = IntrinsicsKt.wrapWithContinuationImpl(r5, r4, r4);     // Catch: Throwable -> L8
    L33:
        goto L11
    L6:
        r6 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).invoke(r4, r4);     // Catch: Throwable -> L8
        goto L33
    }

    public static final <T> Object b(long r3, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r5, Continuation<? super T> r6) {
        if (r3 <= 0) goto L9;
        Object r4 = a(new z1(r3, r6), r5);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L7:
        return r4;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    public static final <T> Object c(long r7, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r9, Continuation<? super T> r10) {
        if ((r10 instanceof TimeoutKt$withTimeoutOrNull$1) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r0 = (TimeoutKt$withTimeoutOrNull$1) r10;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r0.L$1;
        Function2 r12 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: TimeoutCancellationException -> L14
        return r11;
    L14:
        TimeoutCancellationException e = e;
    L32:
        if (e.coroutine != r8.element) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        if (r7 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r0.L$0 = r9;     // Catch: TimeoutCancellationException -> L29
        r0.L$1 = r13;     // Catch: TimeoutCancellationException -> L29
        r0.J$0 = r7;     // Catch: TimeoutCancellationException -> L29
        r0.label = 1;     // Catch: TimeoutCancellationException -> L29
        z1 r4 = new z1(r7, r0);     // Catch: TimeoutCancellationException -> L29
        r13.element = r4;     // Catch: TimeoutCancellationException -> L29
        Object r14 = a(r4, r9);     // Catch: TimeoutCancellationException -> L29
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: TimeoutCancellationException -> L29
    L25:
        if (r14 != r2) goto L28;
        return r2;
    L28:
        return r14;
    L29:
        e = move-exception;
        e = e;
        r8 = r13;
    L7:
        r0 = new TimeoutKt$withTimeoutOrNull$1(r10);
        goto L8
    }
}
