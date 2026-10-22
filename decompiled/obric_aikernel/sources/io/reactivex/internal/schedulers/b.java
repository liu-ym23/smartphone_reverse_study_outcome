package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class b implements Callable<Void>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final FutureTask<Void> f9628k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Runnable f9629c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<Future<?>> f9630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<Future<?>> f9631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final ExecutorService f9632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Thread f9633j;

    static {
        f9628k = new FutureTask(Functions.f9486a, null);
    }

    b(Runnable r10, ExecutorService r11) {
        this.f9629c = r10;
        this.f9631h = new AtomicReference();
        this.f9630g = new AtomicReference();
        this.f9632i = r11;
    }

    public Void a() {
        this.f9633j = Thread.currentThread();
        this.f9629c.run();     // Catch: Throwable -> L5
        c(this.f9632i.submit(this));     // Catch: Throwable -> L5
        this.f9633j = null;     // Catch: Throwable -> L5
    L7:
        return null;
    L5:
        th = move-exception;
        this.f9633j = null;
        dc.a.n(th);
        goto L7
    }

    void b(Future<?> r10) {
    L2:
        Future<?> r11 = this.f9631h.get();
        if (r11 == f9628k) goto L5;
        if (this.f9631h.compareAndSet(r11, r10) == false) goto L2;
        return;
    L5:
        if (this.f9633j == Thread.currentThread()) goto L7;
        boolean r12 = true;
    L8:
        r10.cancel(r12);
        return;
    L7:
        r12 = false;
        goto L8
    }

    void c(Future<?> r10) {
    L2:
        Future<?> r11 = this.f9630g.get();
        if (r11 == f9628k) goto L5;
        if (this.f9630g.compareAndSet(r11, r10) == false) goto L2;
        return;
    L5:
        if (this.f9633j == Thread.currentThread()) goto L7;
        boolean r12 = true;
    L8:
        r10.cancel(r12);
        return;
    L7:
        r12 = false;
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        AtomicReference<Future<?>> r10 = this.f9631h;
        FutureTask<Void> r11 = f9628k;
        Future<?> r12 = r10.getAndSet(r11);
        boolean r13 = true;
        if (r12 == null) goto L10;
        if (r12 == r11) goto L10;
        if (this.f9633j == Thread.currentThread()) goto L8;
        boolean r14 = true;
    L9:
        r12.cancel(r14);
        goto L10
    L8:
        r14 = false;
    L10:
        Future<?> r15 = this.f9630g.getAndSet(r11);
        if (r15 == null) goto L19;
        if (r15 != r11) goto L14;
        return;
    L14:
        if (this.f9633j != Thread.currentThread()) goto L17;
        r13 = false;
    L17:
        r15.cancel(r13);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.f9631h.get() != f9628k) goto L5;
        return true;
    L5:
        return false;
    }
}
