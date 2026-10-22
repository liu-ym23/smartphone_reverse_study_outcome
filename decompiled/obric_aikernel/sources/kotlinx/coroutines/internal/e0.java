package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public class e0<T> extends kotlinx.coroutines.a<T> implements CoroutineStackFrame {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public final Continuation<T> f10546i;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(CoroutineContext r10, Continuation<? super T> r11) {
        super(r10, true, true);
        this.f10546i = r11;
    }

    @Override // kotlinx.coroutines.c2
    protected final boolean A0() {
        return true;
    }

    @Override // kotlinx.coroutines.c2
    protected void Z(Object r10) {
        m.c(IntrinsicsKt.intercepted(this.f10546i), kotlinx.coroutines.e0.a(r10, this.f10546i), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    protected void f1(Object r10) {
        Continuation<T> r11 = this.f10546i;
        r11.resumeWith(kotlinx.coroutines.e0.a(r10, r11));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> r10 = this.f10546i;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }
}
