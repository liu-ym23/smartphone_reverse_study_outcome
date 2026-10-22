package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@PublishedApi
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion Companion = null;
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = null;
    private final Continuation<T> delegate;
    private volatile Object result;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private static /* synthetic */ void getRESULT$annotations() {
        }
    }

    static {
        Companion = new Companion(null);
        RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    @PublishedApi
    public SafeContinuation(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this(r10, CoroutineSingletons.UNDECIDED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.delegate = r10;
        this.result = r11;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r10 = this.delegate;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @PublishedApi
    public final Object getOrThrow() {
        Object r10 = this.result;
        CoroutineSingletons r11 = CoroutineSingletons.UNDECIDED;
        if (r10 != r11) goto L10;
        if (RESULT.compareAndSet(this, r11, IntrinsicsKt.getCOROUTINE_SUSPENDED()) == true) goto L7;
        r10 = this.result;
        goto L10
    L7:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L10:
        if (r10 != CoroutineSingletons.RESUMED) goto L13;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L13:
        if ((r10 instanceof Result.Failure) == true) goto L16;
        return r10;
    L16:
        throw ((Result.Failure) r10).exception;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
    L2:
        Object r11 = this.result;
        CoroutineSingletons r12 = CoroutineSingletons.UNDECIDED;
        if (r11 == r12) goto L5;
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        if (RESULT.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED) == false) goto L2;
        this.delegate.resumeWith(r10);
        return;
    L14:
        throw new IllegalStateException("Already resumed");
    L5:
        if (RESULT.compareAndSet(this, r12, r10) == false) goto L2;
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }
}
