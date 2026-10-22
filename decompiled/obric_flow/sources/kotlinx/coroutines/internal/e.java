package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends q0 implements CoroutineStackFrame, Continuation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18931h = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final kotlinx.coroutines.z d;
    public final Continuation e;
    public Object f;
    public final Object g;

    static {
        f18931h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    public e(kotlinx.coroutines.z r5, Continuation r10) {
        super(-1);
        this.d = r5;
        this.e = r10;
        this.f = f.f18932a;
        this.g = v.b(r10.getContext());
    }

    @Override // kotlinx.coroutines.q0
    public final Continuation d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation r5 = this.e;
        if ((r5 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r5;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.q0
    public final Object i() {
        Object r5 = this.f;
        this.f = f.f18932a;
        return r5;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r10) {
        Throwable r5 = Result.m127exceptionOrNullimpl(r10);
        if (r5 != null) goto L5;
        Object r11 = r10;
    L6:
        Continuation r12 = this.e;
        CoroutineContext r13 = r12.getContext();
        kotlinx.coroutines.z r14 = this.d;
        if (r14.isDispatchNeeded(r13) == false) goto L9;
        this.f = r11;
        this.f18987c = 0;
        r14.dispatch(r12.getContext(), this);
        return;
    L9:
        b1 r15 = b2.a();
        if (r15.M() == false) goto L12;
        this.f = r11;
        this.f18987c = 0;
        r15.J(this);
        return;
    L12:
        r15.L(true);
        CoroutineContext r16 = r12.getContext();     // Catch: Throwable -> L19
        Object r17 = v.c(r16, this.g);     // Catch: Throwable -> L19
        r12.resumeWith(r10);     // Catch: Throwable -> L21
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L21
        v.a(r16, r17);     // Catch: Throwable -> L19
    L17:
        if (r15.O() == true) goto L17;
    L18:
        r15.g(true);
        return;
    L21:
        th = move-exception;
        v.a(r16, r17);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        h(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r15.g(true);
        throw th;
    L5:
        r11 = new kotlinx.coroutines.v(false, r5);
        goto L6
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + j0.j(this.e) + ']';
    }
}
