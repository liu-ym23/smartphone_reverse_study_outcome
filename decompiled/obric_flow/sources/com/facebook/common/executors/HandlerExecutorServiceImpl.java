package com.facebook.common.executors;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HandlerExecutorServiceImpl extends AbstractExecutorService implements ScheduledExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f7645a;

    public HandlerExecutorServiceImpl(Handler r5) {
        this.f7645a = r5;
    }

    public final boolean a() {
        if (Thread.currentThread() != this.f7645a.getLooper().getThread()) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r5, TimeUnit r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public abstract void execute(Runnable r5);

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable r5, Object r10) {
        return new ScheduledFutureImpl(r5, r10);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable r5, long r10, TimeUnit r11) {
        ScheduledFutureImpl r12 = new ScheduledFutureImpl(r5, null);
        this.f7645a.postDelayed(r12, r11.toMillis(r10));
        return r12;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable r5, long r10, long r11, TimeUnit r12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable r5, long r10, long r11, TimeUnit r12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable r5) {
        r5.getClass();
        ScheduledFutureImpl r10 = new ScheduledFutureImpl(r5, null);
        execute(r10);
        return r10;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable r5) {
        return new ScheduledFutureImpl(r5);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable r5, long r10, TimeUnit r11) {
        ScheduledFutureImpl r12 = new ScheduledFutureImpl(r5);
        this.f7645a.postDelayed(r12, r11.toMillis(r10));
        return r12;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable r5, Object r10) {
        r5.getClass();
        ScheduledFutureImpl r11 = new ScheduledFutureImpl(r5, r10);
        execute(r11);
        return r11;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Callable r5) {
        r5.getClass();
        ScheduledFutureImpl r10 = new ScheduledFutureImpl(r5);
        execute(r10);
        return r10;
    }
}
