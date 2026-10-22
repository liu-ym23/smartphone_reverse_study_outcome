package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e2 {
    public static final Object a(d2 r5, Function2 r10) {
        j0.i(r5, new u0(DelayKt.getDelay(r5.d.getContext()).e(r5.e, r5, r5.f18767c), 0));
    L6:
        th = move-exception;
        Object r11 = new v(false, th);
    L12:
        if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        Object r12 = r5.O(r11);
        if (r12 != j0.e) goto L18;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L18:
        if ((r12 instanceof v) == false) goto L29;
        Throwable r13 = ((v) r12).f19025a;
        if ((r13 instanceof TimeoutCancellationException) == true) goto L22;
        throw r13;
    L22:
        if (((TimeoutCancellationException) r13).coroutine == r5) goto L24;
        throw r13;
    L24:
        if ((r11 instanceof v) == false) goto L31;
        throw ((v) r11).f19025a;
    L31:
        return r11;
    L29:
        r11 = j0.k(r12);
        goto L31
    L36:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        if ((r10 instanceof BaseContinuationImpl) == true) goto L8;
        r11 = IntrinsicsKt.wrapWithContinuationImpl(r10, r5, r5);     // Catch: Throwable -> L6
    L32:
        goto L12
    L8:
        r11 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).mo2invoke(r5, r5);     // Catch: Throwable -> L6
        goto L32
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.d2] */
    public static final Object b(long r10, Function2 r11, ContinuationImpl r12) {
        if ((r12 instanceof TimeoutKt$withTimeoutOrNull$1) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r5 = (TimeoutKt$withTimeoutOrNull$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r5.L$1;
        Function2 r18 = (Function2) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: TimeoutCancellationException -> L14
        return r14;
    L14:
        e = e;
    L33:
        if (e.coroutine != r17.element) goto L35;
        return null;
    L35:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (r10 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r5.L$0 = r11;     // Catch: TimeoutCancellationException -> L26
        r5.L$1 = r19;     // Catch: TimeoutCancellationException -> L26
        r5.J$0 = r10;     // Catch: TimeoutCancellationException -> L26
        r5.label = 1;     // Catch: TimeoutCancellationException -> L26
        ?? r20 = new d2(r10, r5);     // Catch: TimeoutCancellationException -> L26
        r19.element = r20;     // Catch: TimeoutCancellationException -> L26
        Object r21 = a(r20, r11);     // Catch: TimeoutCancellationException -> L26
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        DebugProbesKt.probeCoroutineSuspended(r5);     // Catch: TimeoutCancellationException -> L26
    L28:
        if (r21 != r15) goto L31;
        return r15;
    L31:
        return r21;
    L26:
        e = e;
        r17 = r19;
    L7:
        r5 = new TimeoutKt$withTimeoutOrNull$1(r12);
        goto L8
    }
}
