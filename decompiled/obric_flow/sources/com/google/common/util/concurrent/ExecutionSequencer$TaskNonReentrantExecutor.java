package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutionSequencer$TaskNonReentrantExecutor extends AtomicReference<ExecutionSequencer$RunningState> implements Executor, Runnable {
    Executor delegate;
    m0 sequencer;
    Thread submitting;
    Runnable task;

    public ExecutionSequencer$TaskNonReentrantExecutor(Executor r5, m0 r10, l0 r11) {
        super(ExecutionSequencer$RunningState.NOT_RUN);
        this.delegate = r5;
    }

    public static boolean access$200(ExecutionSequencer$TaskNonReentrantExecutor r5) {
        r5.getClass();
        return r5.compareAndSet(ExecutionSequencer$RunningState.NOT_RUN, ExecutionSequencer$RunningState.STARTED);
    }

    public static boolean access$400(ExecutionSequencer$TaskNonReentrantExecutor r5) {
        r5.getClass();
        return r5.compareAndSet(ExecutionSequencer$RunningState.NOT_RUN, ExecutionSequencer$RunningState.CANCELLED);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r5) {
        if (get() != ExecutionSequencer$RunningState.CANCELLED) goto L6;
        this.delegate = null;
        return;
    L6:
        this.submitting = Thread.currentThread();
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.submitting = null;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Thread.currentThread() == this.submitting) goto L6;
        Runnable r5 = this.task;
        Objects.requireNonNull(r5);
        this.task = null;
        r5.run();
        return;
    L6:
        throw null;
    }
}
