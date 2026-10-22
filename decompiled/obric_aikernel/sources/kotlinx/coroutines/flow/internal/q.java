package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes3.dex */
final class q<T> implements Continuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Continuation<T> f10499c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineContext f10500g;

    /* JADX WARN: Multi-variable type inference failed */
    public q(Continuation<? super T> r10, CoroutineContext r11) {
        this.f10499c = r10;
        this.f10500g = r11;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r10 = this.f10499c;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f10500g;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        this.f10499c.resumeWith(r10);
    }
}
