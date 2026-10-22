package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
abstract class CombinedFuture$CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
    private final Executor listenerExecutor;
    final /* synthetic */ f0 this$0;

    public CombinedFuture$CombinedFutureInterruptibleTask(f0 r5, Executor r10) {
        r10.getClass();
        this.listenerExecutor = r10;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public final void afterRanInterruptiblyFailure(Throwable r5) {
        int r10 = f0.f9412k;
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public final void afterRanInterruptiblySuccess(T r5) {
        int r10 = f0.f9412k;
        throw null;
    }

    public final void execute() {
        this.listenerExecutor.execute(this);     // Catch: RejectedExecutionException -> L4
        return;
    L5:
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public final boolean isDone() {
        throw null;
    }

    public abstract void setValue(T r5);
}
