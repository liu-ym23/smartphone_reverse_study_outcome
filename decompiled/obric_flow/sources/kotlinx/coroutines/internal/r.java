package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes3.dex */
public class r extends kotlinx.coroutines.a implements CoroutineStackFrame {
    public final Continuation d;

    public r(Continuation r5, CoroutineContext r10) {
        super(r10, true);
        this.d = r5;
    }

    @Override // kotlinx.coroutines.r1
    public final boolean M() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation r5 = this.d;
        if ((r5 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r5;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.r1
    public void t(Object r5) {
        Continuation r10 = IntrinsicsKt.intercepted(this.d);
        f.h(kotlinx.coroutines.w.a(r5), r10);
    }

    @Override // kotlinx.coroutines.r1
    public void u(Object r5) {
        this.d.resumeWith(kotlinx.coroutines.w.a(r5));
    }
}
