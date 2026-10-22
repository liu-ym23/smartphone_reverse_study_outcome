package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 extends yt.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18987c;

    public q0(int r5) {
        super(0, false);
        this.f18987c = r5;
    }

    public void b(CancellationException r5) {
    }

    public abstract Continuation d();

    public Throwable f(Object r5) {
        if ((r5 instanceof v) == false) goto L5;
        v r10 = (v) r5;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.f19025a;
    L5:
        r10 = null;
        goto L6
    }

    public Object g(Object r5) {
        return r5;
    }

    public final void h(Throwable r5) {
        c0.a(new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r5), d().getContext());
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Continuation r5 = d();     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L6
        kotlinx.coroutines.internal.e r10 = (kotlinx.coroutines.internal.e) r5;     // Catch: Throwable -> L6
        Continuation r11 = r10.e;     // Catch: Throwable -> L6
        Object r12 = r10.g;     // Catch: Throwable -> L6
        CoroutineContext r13 = r11.getContext();     // Catch: Throwable -> L6
        Object r14 = kotlinx.coroutines.internal.v.c(r13, r12);     // Catch: Throwable -> L6
        Job r15 = null;
        if (r14 == kotlinx.coroutines.internal.v.f18953a) goto L8;
        g2 r16 = x.c(r11, r13, r14);     // Catch: Throwable -> L6
    L36:
        CoroutineContext r17 = r11.getContext();     // Catch: Throwable -> L14
        Object r18 = i();     // Catch: Throwable -> L14
        Throwable r19 = f(r18);     // Catch: Throwable -> L14
        if (r19 == null) goto L12;
    L16:
        if (r15 != null) goto L18;
    L20:
        if (r19 == null) goto L22;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L14
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r19)));     // Catch: Throwable -> L14
    L23:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L14
        if (r16 != null) goto L26;
    L27:
        kotlinx.coroutines.internal.v.a(r13, r14);     // Catch: Throwable -> L6
        return;
    L26:
        if (r16.d0() == true) goto L27;
        return;
    L22:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L14
        r11.resumeWith(Result.m124constructorimpl(g(r18)));     // Catch: Throwable -> L14
        goto L23
    L18:
        if (r15.isActive() == true) goto L20;
        CancellationException r23 = r15.getCancellationException();     // Catch: Throwable -> L14
        b(r23);     // Catch: Throwable -> L14
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L14
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r23)));     // Catch: Throwable -> L14
        goto L23
    L12:
        if (r0.a(this.f18987c) == false) goto L16;
        r15 = (Job) r17.get(Job.Key);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r16 != null) goto L30;
    L31:
        kotlinx.coroutines.internal.v.a(r13, r14);     // Catch: Throwable -> L6
    L32:
        throw th;     // Catch: Throwable -> L6
    L30:
        if (r16.d0() == false) goto L32;
    L8:
        r16 = null;
    L6:
        th = move-exception;
        h(th);
    }
}
