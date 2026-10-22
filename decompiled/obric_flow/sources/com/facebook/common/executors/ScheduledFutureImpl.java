package com.facebook.common.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ScheduledFutureImpl<V> implements RunnableFuture<V>, ScheduledFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FutureTask f7646a;

    public ScheduledFutureImpl(Callable r5) {
        this.f7646a = new FutureTask(r5);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r5) {
        return this.f7646a.cancel(r5);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f7646a.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f7646a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f7646a.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        this.f7646a.run();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r5, TimeUnit r10) {
        return this.f7646a.get(r5, r10);
    }

    public ScheduledFutureImpl(Runnable r5, Object r10) {
        this.f7646a = new FutureTask(r5, r10);
    }
}
