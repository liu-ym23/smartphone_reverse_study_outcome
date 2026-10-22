package fc;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.n0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
public final class b {
    public static final <T> void a(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Continuation r12 = DebugProbesKt.probeCoroutineCreated(r11);
        CoroutineContext r13 = r11.getContext();     // Catch: Throwable -> L13
        Object r14 = ThreadContextKt.c(r13, null);     // Catch: Throwable -> L13
        Object r15 = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 1)).invoke(r12);     // Catch: Throwable -> L10
        ThreadContextKt.a(r13, r14);     // Catch: Throwable -> L13
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        Result.Companion r16 = Result.Companion;
    L15:
        r12.resumeWith(Result.m32constructorimpl(r15));
        return;
    L20:
        return;
    L10:
        th = move-exception;
        ThreadContextKt.a(r13, r14);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = ResultKt.createFailure(th);
        goto L15
    }

    public static final <R, T> void b(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        Continuation r13 = DebugProbesKt.probeCoroutineCreated(r12);
        CoroutineContext r14 = r12.getContext();     // Catch: Throwable -> L13
        Object r15 = ThreadContextKt.c(r14, null);     // Catch: Throwable -> L13
        Object r16 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 2)).invoke(r11, r13);     // Catch: Throwable -> L10
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L13
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        Result.Companion r17 = Result.Companion;
    L15:
        r13.resumeWith(Result.m32constructorimpl(r16));
        return;
    L20:
        return;
    L10:
        th = move-exception;
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = ResultKt.createFailure(th);
        goto L15
    }

    public static final <T, R> Object c(e0<? super T> r10, R r11, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r12) {
        Object r13 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 2)).invoke(r11, r10);     // Catch: Throwable -> L5
    L8:
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        Object r14 = r10.F0(r13);
        if (r14 == d2.f10331b) goto L28;
        if ((r14 instanceof b0) == false) goto L23;
        Throwable r15 = ((b0) r14).f10244a;
        Continuation<? super T> r16 = r10.f10546i;
        if (n0.d() == true) goto L18;
        throw r15;
    L18:
        if ((r16 instanceof CoroutineStackFrame) == true) goto L21;
        throw r15;
    L21:
        throw h0.a(r15, (CoroutineStackFrame) r16);
    L23:
        return d2.h(r14);
    L28:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        th = move-exception;
        r13 = new b0(th, false, 2, null);
        goto L8
    }

    public static final <T, R> Object d(e0<? super T> r10, R r11, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r12) {
        boolean r13 = false;
        Object r14 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 2)).invoke(r11, r10);     // Catch: Throwable -> L5
    L8:
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        Object r15 = r10.F0(r14);
        if (r15 == d2.f10331b) goto L46;
        if ((r15 instanceof b0) == false) goto L37;
        Throwable r16 = ((b0) r15).f10244a;
        if ((r16 instanceof TimeoutCancellationException) == true) goto L18;
    L19:
        r13 = true;
    L20:
        if (r13 == false) goto L29;
        Continuation<? super T> r17 = r10.f10546i;
        if (n0.d() == true) goto L24;
        throw r16;
    L24:
        if ((r17 instanceof CoroutineStackFrame) == true) goto L27;
        throw r16;
    L27:
        throw h0.a(r16, (CoroutineStackFrame) r17);
    L29:
        if ((r14 instanceof b0) == false) goto L39;
        Throwable r18 = ((b0) r14).f10244a;
        Continuation<? super T> r19 = r10.f10546i;
        if (n0.d() == true) goto L33;
        throw r18;
    L33:
        if ((r19 instanceof CoroutineStackFrame) == true) goto L36;
        throw r18;
    L36:
        throw h0.a(r18, (CoroutineStackFrame) r19);
    L39:
        return r14;
    L18:
        if (((TimeoutCancellationException) r16).coroutine == r10) goto L20;
    L37:
        r14 = d2.h(r15);
    L46:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        th = move-exception;
        r14 = new b0(th, false, 2, null);
        goto L8
    }
}
