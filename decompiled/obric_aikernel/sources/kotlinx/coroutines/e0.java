package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
public final class e0 {
    public static final <T> Object a(Object r10, Continuation<? super T> r11) {
        if ((r10 instanceof b0) == false) goto L11;
        Result.Companion r12 = Result.Companion;
        Throwable r13 = ((b0) r10).f10244a;
        if (n0.d() == true) goto L7;
    L10:
        r10 = ResultKt.createFailure(r13);
    L13:
        return Result.m32constructorimpl(r10);
    L7:
        if ((r11 instanceof CoroutineStackFrame) == false) goto L10;
        r13 = kotlinx.coroutines.internal.h0.a(r13, (CoroutineStackFrame) r11);
        goto L10
    L11:
        Result.Companion r14 = Result.Companion;
        goto L13
    }

    public static final <T> Object b(Object r10, Function1<? super Throwable, Unit> r11) {
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 != null) goto L7;
        if (r11 != null) goto L9;
        return r10;
    L9:
        return new c0(r10, r11);
    L7:
        return new b0(r12, false, 2, null);
    }

    public static final <T> Object c(Object r10, n<?> r11) {
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 != null) goto L6;
    L12:
        return r10;
    L6:
        if (n0.d() == true) goto L8;
    L11:
        r10 = new b0(r12, false, 2, null);
        goto L12
    L8:
        if ((r11 instanceof CoroutineStackFrame) == false) goto L11;
        r12 = kotlinx.coroutines.internal.h0.a(r12, (CoroutineStackFrame) r11);
        goto L11
    }

    public static /* synthetic */ Object d(Object r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return b(r10, r11);
    }
}
