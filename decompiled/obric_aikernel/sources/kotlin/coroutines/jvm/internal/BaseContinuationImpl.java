package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public BaseContinuationImpl(Continuation<Object> r10) {
        this.completion = r10;
    }

    public Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public Continuation<Unit> create(Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> r10 = this.completion;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }

    protected abstract Object invokeSuspend(Object r10);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r10) {
    L2:
        DebugProbesKt.probeCoroutineResumed(r2);
        BaseContinuationImpl r11 = (BaseContinuationImpl) r2;
        Continuation<Object> r12 = r11.completion;
        Intrinsics.checkNotNull(r12);
        Object r13 = r11.invokeSuspend(r10);     // Catch: Throwable -> L8
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        r10 = Result.m32constructorimpl(r13);     // Catch: Throwable -> L8
    L10:
        r11.releaseIntercepted();
        if ((r12 instanceof BaseContinuationImpl) == false) goto L13;
        ?? r15 = r12;
        goto L2
    L13:
        r12.resumeWith(r10);
        return;
    L5:
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Continuation at ");
        Object r11 = getStackTraceElement();
        if (r11 != null) goto L6;
        r11 = getClass().getName();
    L6:
        r10.append(r11);
        return r10.toString();
    }
}
