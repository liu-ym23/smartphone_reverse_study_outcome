package kotlinx.coroutines.internal;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.g2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f18933b = null;

    static {
        int r5 = 10;
        f18932a = new g8.g("UNDEFINED", r5);
        f18933b = new g8.g("REUSABLE_CLAIMED", r5);
    }

    public static final void a(Function1 r5, Object r10, CoroutineContext r11) {
        UndeliveredElementException r12 = b(r5, r10, null);
        if (r12 == null) goto L6;
        c0.a(r12, r11);
        return;
    }

    public static final UndeliveredElementException b(Function1 r5, Object r10, UndeliveredElementException r11) {
        r5.invoke(r10);     // Catch: Throwable -> L4
    L9:
        return r11;
    L4:
        th = move-exception;
        if (r11 == null) goto L11;
        if (r11.getCause() == th) goto L11;
        ExceptionsKt.addSuppressed(r11, th);
    L11:
        return new UndeliveredElementException("Exception in undelivered element handler for " + r10, th);
    }

    public static final void c(int r5) {
        if (r5 < 1) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(j0.g(r5, "Expected positive parallelism level, but got ").toString());
    }

    public static final s d(Object r5) {
        if (r5 == a.f18926a) goto L7;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (s) r5;
    L7:
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void e(Throwable r5, CoroutineContext r10) {
        Iterator r11 = d.f18930a.iterator();
    L4:
        if (r11.hasNext() == true) goto L20;
        ExceptionsKt.addSuppressed(r5, new DiagnosticCoroutineContextException(r10));     // Catch: Throwable -> L17
    L15:
        Thread r12 = Thread.currentThread();
        r12.getUncaughtExceptionHandler().uncaughtException(r12, r5);
        return;
    L20:
        ((wt.b) ((b0) r11.next())).g(r5, r10);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L13
    L13:
        return;
    L8:
        th = move-exception;
        if (r5 != th) goto L11;
        Throwable r13 = r5;
    L12:
        Thread r14 = Thread.currentThread();
        r14.getUncaughtExceptionHandler().uncaughtException(r14, r13);
        goto L4
    L11:
        r13 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r13, r5);
        goto L12
    }

    public static final boolean f(Object r5) {
        if (r5 != a.f18926a) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Object g(Object r5, Object r10) {
        if (r5 != null) goto L5;
        return r10;
    L5:
        if ((r5 instanceof ArrayList) == false) goto L7;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
        ((ArrayList) r5).add(r10);
        return r5;
    L7:
        ArrayList r11 = new ArrayList(4);
        r11.add(r5);
        r11.add(r10);
        return r11;
    }

    public static final void h(Object r10, Continuation r11) {
        if ((r11 instanceof e) == false) goto L46;
        e r12 = (e) r11;
        Throwable r5 = Result.m127exceptionOrNullimpl(r10);
        if (r5 != null) goto L7;
        Object r13 = r10;
    L8:
        kotlinx.coroutines.z r14 = r12.d;
        Continuation r15 = r12.e;
        if (r14.isDispatchNeeded(r15.getContext()) == false) goto L11;
        r12.f = r13;
        r12.f18987c = 1;
        CoroutineContext r16 = r15.getContext();
        r12.d.dispatch(r16, r12);
        return;
    L11:
        b1 r17 = b2.a();
        if (r17.M() == false) goto L14;
        r12.f = r13;
        r12.f18987c = 1;
        r17.J(r12);
        return;
    L14:
        r17.L(true);
        Job r18 = (Job) r15.getContext().get(Job.Key);     // Catch: Throwable -> L20
        if (r18 != null) goto L18;
    L22:
        Object r19 = r12.g;     // Catch: Throwable -> L20
        CoroutineContext r20 = r15.getContext();     // Catch: Throwable -> L20
        Object r21 = v.c(r20, r19);     // Catch: Throwable -> L20
        if (r21 == v.f18953a) goto L26;
        g2 r22 = kotlinx.coroutines.x.c(r15, r20, r21);     // Catch: Throwable -> L20
    L48:
        r15.resumeWith(r10);     // Catch: Throwable -> L35
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L35
        if (r22 != null) goto L30;
    L31:
        v.a(r20, r21);     // Catch: Throwable -> L20
    L33:
        if (r17.O() == true) goto L33;
    L34:
        r17.g(true);
        return;
    L30:
        if (r22.d0() == false) goto L33;
    L35:
        th = move-exception;
        if (r22 != null) goto L38;
    L39:
        v.a(r20, r21);     // Catch: Throwable -> L20
    L40:
        throw th;     // Catch: Throwable -> L20
    L38:
        if (r22.d0() == false) goto L40;
    L26:
        r22 = null;
        goto L48
    L18:
        if (r18.isActive() == true) goto L22;
        r12.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r18.getCancellationException())));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r12.h(th);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r17.g(true);
        throw th;
    L7:
        r13 = new kotlinx.coroutines.v(false, r5);
        goto L8
    L46:
        r11.resumeWith(r10);
    }

    public static final long i(long r5, long r10, long r11, String r12) {
        int r13 = u.f18952a;
        String r14 = System.getProperty(r12);     // Catch: SecurityException -> L5
    L6:
        if (r14 == null) goto L22;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L19;
        long r16 = r15.longValue();
        if (r10 <= r16) goto L13;
    L16:
        StringBuilder r17 = new StringBuilder("System property '");
        r17.append(r12);
        r17.append("' should be in range ");
        r17.append(r10);
        kotlin.collections.a.o(r17, "..", r11, ", but is '");
        r17.append(r16);
        r17.append('\'');
        throw new IllegalStateException(r17.toString().toString());
    L13:
        if (r16 > r11) goto L16;
        return r16;
    L19:
        throw new IllegalStateException(("System property '" + r12 + "' has unrecognized value '" + r14 + '\'').toString());
    L22:
        return r5;
    L5:
        r14 = null;
        goto L6
    }

    public static int j(String r10, int r11, int r12, int r13, int r14) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = Integer.MAX_VALUE;
    L9:
        return (int) i(r11, r12, r13, r10);
    }
}
