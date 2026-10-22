package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Callable, Disposable {
    public static final FutureTask f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18129c;
    public final ScheduledExecutorService d;
    public Thread e;

    static {
        f = new FutureTask(io.reactivex.internal.functions.e.f17618b, null);
    }

    public e(Runnable r5, ScheduledExecutorService r10) {
        this.f18127a = r5;
        this.f18129c = new AtomicReference();
        this.f18128b = new AtomicReference();
        this.d = r10;
    }

    public final void a(Future r5) {
    L2:
        AtomicReference r10 = this.f18129c;
        Future r11 = (Future) r10.get();
        if (r11 == f) goto L5;
    L11:
        if (r10.compareAndSet(r11, r5) == true) goto L12;
        if (r10.get() == r11) goto L11;
    L12:
        return;
    L5:
        if (this.e == Thread.currentThread()) goto L7;
        boolean r12 = true;
    L8:
        r5.cancel(r12);
        return;
    L7:
        r12 = false;
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.e = Thread.currentThread();
        this.f18127a.run();     // Catch: Throwable -> L14
        Future r5 = this.d.submit(this);     // Catch: Throwable -> L14
    L4:
        AtomicReference r10 = this.f18128b;     // Catch: Throwable -> L14
        Future r11 = (Future) r10.get();     // Catch: Throwable -> L14
        if (r11 == f) goto L7;
    L12:
        if (r10.compareAndSet(r11, r5) == true) goto L13;
        if (r10.get() == r11) goto L12;
    L13:
        this.e = null;     // Catch: Throwable -> L14
    L20:
        return null;
    L7:
        if (this.e == Thread.currentThread()) goto L9;
        boolean r12 = true;
    L10:
        r5.cancel(r12);     // Catch: Throwable -> L14
        goto L13
    L9:
        r12 = false;
    L14:
        th = move-exception;
        this.e = null;
        wn.f.k(th);
        goto L20
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AtomicReference r5 = this.f18129c;
        FutureTask r10 = f;
        Future r11 = (Future) r5.getAndSet(r10);
        boolean r12 = false;
        if (r11 == null) goto L10;
        if (r11 == r10) goto L10;
        if (this.e == Thread.currentThread()) goto L8;
        boolean r13 = true;
    L9:
        r11.cancel(r13);
        goto L10
    L8:
        r13 = false;
    L10:
        Future r14 = (Future) this.f18128b.getAndSet(r10);
        if (r14 == null) goto L18;
        if (r14 != r10) goto L14;
        return;
    L14:
        if (this.e == Thread.currentThread()) goto L16;
        r12 = true;
    L16:
        r14.cancel(r12);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f18129c.get() != f) goto L5;
        return true;
    L5:
        return false;
    }
}
