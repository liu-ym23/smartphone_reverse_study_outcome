package androidx.work.impl.utils;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SerialExecutorImpl implements SerialExecutor {

    @GuardedBy("mLock")
    private Runnable mActive;
    private final Executor mExecutor;
    final Object mLock;
    private final ArrayDeque<Task> mTasks;

    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(@NonNull SerialExecutorImpl r10, @NonNull Runnable r11) {
            this.mSerialExecutor = r10;
            this.mRunnable = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();     // Catch: Throwable -> L11
            Object r10 = this.mSerialExecutor.mLock;
            monitor-enter(r10);
            this.mSerialExecutor.scheduleNext();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.mSerialExecutor.mLock);
            this.mSerialExecutor.scheduleNext();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public SerialExecutorImpl(@NonNull Executor r10) {
        this.mExecutor = r10;
        this.mTasks = new ArrayDeque();
        this.mLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mTasks.add(new Task(this, r10));     // Catch: Throwable -> L9
        if (this.mActive != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @NonNull
    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.SerialExecutor
    public boolean hasPendingTasks() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mTasks.isEmpty() == true) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    @GuardedBy("mLock")
    void scheduleNext() {
        Task r10 = this.mTasks.poll();
        this.mActive = r10;
        if (r10 == null) goto L6;
        this.mExecutor.execute(r10);
        return;
    }
}
