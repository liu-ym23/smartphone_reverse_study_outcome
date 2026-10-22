package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,222:1\n200#1,17:240\n1#2:223\n255#3:224\n256#3,2:235\n258#3:239\n107#4,10:225\n118#4,2:237\n61#5,2:257\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n190#1:240,17\n178#1:224\n178#1:235,2\n178#1:239\n178#1:225,10\n178#1:237,2\n220#1:257,2\n*E\n"})
public final class x0 {
    public static final <T> void a(w0<? super T> r10, int r11) {
        boolean r12 = true;
        if (n0.a() == true) goto L5;
    L12:
        Continuation<? super T> r13 = r10.d();
        if (r11 == 4) goto L16;
        r12 = false;
    L16:
        if (r12 == false) goto L18;
    L25:
        d(r10, r13, r12);
        return;
    L18:
        if ((r13 instanceof kotlinx.coroutines.internal.l) == false) goto L25;
        if (b(r11) != b(r10.f10728h)) goto L25;
        CoroutineDispatcher r14 = ((kotlinx.coroutines.internal.l) r13).f10559i;
        CoroutineContext r15 = r13.getContext();
        if (r14.isDispatchNeeded(r15) == false) goto L24;
        r14.dispatch(r15, r10);
        return;
    L24:
        e(r10);
        return;
    L5:
        if (r11 == (-1)) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L12;
        throw new AssertionError();
    L7:
        r16 = false;
        goto L8
    }

    public static final boolean b(int r10) {
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean c(int r10) {
        if (r10 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void d(w0<? super T> r10, Continuation<? super T> r11, boolean r12) {
        Object r13 = r10.i();
        Throwable r14 = r10.e(r13);
        if (r14 == null) goto L5;
        Result.Companion r15 = Result.Companion;
        Object r16 = ResultKt.createFailure(r14);
    L6:
        Object r17 = Result.m32constructorimpl(r16);
        if (r12 == false) goto L23;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.l r18 = (kotlinx.coroutines.internal.l) r11;
        Continuation<T> r19 = r18.f10560j;
        Object r20 = r18.f10562l;
        CoroutineContext r21 = r19.getContext();
        Object r22 = ThreadContextKt.c(r21, r20);
        if (r22 == ThreadContextKt.f10533a) goto L11;
        a3<?> r23 = CoroutineContextKt.g(r19, r21, r22);
    L25:
        r18.f10560j.resumeWith(r17);     // Catch: Throwable -> L17
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r23 != null) goto L15;
    L16:
        ThreadContextKt.a(r21, r22);
        return;
    L15:
        if (r23.j1() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r23 != null) goto L20;
    L21:
        ThreadContextKt.a(r21, r22);
    L22:
        throw th;
    L20:
        if (r23.j1() == false) goto L22;
    L11:
        r23 = null;
        goto L25
    L23:
        r11.resumeWith(r17);
        return;
    L5:
        Result.Companion r25 = Result.Companion;
        r16 = r10.f(r13);
        goto L6
    }

    private static final void e(w0<?> r10) {
        f1 r11 = s2.f10631a.b();
        if (r11.j0() == false) goto L5;
        r11.f0(r10);
        return;
    L5:
        r11.h0(true);
        d(r10, r10.d(), true);     // Catch: Throwable -> L10
    L7:
        if (r11.m0() == true) goto L7;
    L13:
        r11.c0(true);
        return;
    L10:
        th = move-exception;
        r10.g(th, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r11.c0(true);
        throw th;
    }
}
