package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class q<T> implements Continuation<T>, CoroutineStackFrame {
    public final Continuation<T> a;
    public final CoroutineContext b;

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final CoroutineStackFrame getCallerFrame() {
        CoroutineStackFrame r0 = this.a;
        if ((r0 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public CoroutineContext getContext() {
        return this.b;
    }

    public final void resumeWith(Object r2) {
        this.a.resumeWith(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(Continuation<? super T> r1, CoroutineContext r2) {
        this.a = r1;
        this.b = r2;
    }
}
