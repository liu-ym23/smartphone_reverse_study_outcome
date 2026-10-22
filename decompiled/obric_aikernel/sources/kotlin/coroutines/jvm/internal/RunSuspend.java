package kotlin.coroutines.jvm.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class RunSuspend implements Continuation<Unit> {
    private Result<Unit> result;

    public RunSuspend() {
    }

    public final void await() {
        monitor-enter(this);
    L12:
        Result<Unit> r10 = this.result;     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L9
        wait();     // Catch: Throwable -> L9
        goto L12
    L6:
        ResultKt.throwOnFailure(r10.m41unboximpl());     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* JADX INFO: renamed from: getResult-xLWZpok, reason: not valid java name */
    public final Result<Unit> m1247getResultxLWZpok() {
        return this.result;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        monitor-enter(this);
        this.result = Result.m31boximpl(r10);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setResult(Result<Unit> r10) {
        this.result = r10;
    }
}
