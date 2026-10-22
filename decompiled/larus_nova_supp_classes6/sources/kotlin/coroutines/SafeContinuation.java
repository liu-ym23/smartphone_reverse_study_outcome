package kotlin.coroutines;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001b\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private static final Companion Companion = null;
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = null;
    private final Continuation<T> delegate;
    private volatile Object result;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Rd\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private static /* synthetic */ void getRESULT$annotations() {
        }
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    static {
        Companion = new Companion(null);
        RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    public CoroutineStackFrame getCallerFrame() {
        CoroutineStackFrame r0 = this.delegate;
        if ((r0 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        Object r0 = this.result;
        CoroutineSingletons r1 = CoroutineSingletons.UNDECIDED;
        if (r0 != r1) goto L16;
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r2 = RESULT;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L6:
        if (r2.compareAndSet(this, r1, r3) == true) goto L7;
        if (r2.get(this) == r1) goto L6;
        boolean r4 = false;
    L11:
        if (r4 == true) goto L13;
        r0 = this.result;
        goto L16
    L13:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L7:
        r4 = true;
    L16:
        if (r0 != CoroutineSingletons.RESUMED) goto L19;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L19:
        if ((r0 instanceof Result.Failure) == true) goto L22;
        return r0;
    L22:
        throw ((Result.Failure) r0).exception;
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    public SafeContinuation(Continuation<? super T> r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this(r2, CoroutineSingletons.UNDECIDED);
    }

    public void resumeWith(Object r7) {
    L2:
        Object r0 = this.result;
        CoroutineSingletons r1 = CoroutineSingletons.UNDECIDED;
        boolean r2 = false;
        if (r0 == r1) goto L4;
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r3 = RESULT;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        CoroutineSingletons r5 = CoroutineSingletons.RESUMED;
    L16:
        if (r3.compareAndSet(this, r4, r5) == true) goto L17;
        if (r3.get(this) == r4) goto L16;
    L20:
        if (r2 == false) goto L2;
        this.delegate.resumeWith(r7);
        return;
    L17:
        r2 = true;
        goto L20
    L24:
        throw new IllegalStateException("Already resumed");
    L4:
        AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> r6 = RESULT;
    L6:
        if (r6.compareAndSet(this, r1, r7) == true) goto L7;
        if (r6.get(this) == r1) goto L6;
    L10:
        if (r2 == false) goto L2;
        return;
    L7:
        r2 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeContinuation(Continuation<? super T> r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
        this.result = r3;
    }
}
