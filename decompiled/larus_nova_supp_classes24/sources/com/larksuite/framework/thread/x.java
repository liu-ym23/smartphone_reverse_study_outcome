package com.larksuite.framework.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x<V> implements Future<V> {
    public final Future<?> a;

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return (V) this.a.get();
    L7:
        ThreadMethodProxy.currentThread().interrupt();
        e = null;
    L10:
        if (e == null) goto L12;
        a.c().b(e);
    L12:
        return null;
    L8:
        e = move-exception;
        e = e.getCause();
    L5:
        e = e;
        goto L10
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Future<V> r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r2) {
        return this.a.cancel(r2);
    }

    @Override // java.util.concurrent.Future
    public final V get(long r3, TimeUnit r5) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) this.a.get(r3, r5);
    L7:
        ThreadMethodProxy.currentThread().interrupt();
        e = null;
    L10:
        if (e == null) goto L12;
        a.c().b(e);
    L12:
        return null;
    L8:
        e = move-exception;
        e = e.getCause();
    L5:
        e = e;
        goto L10
    }
}
