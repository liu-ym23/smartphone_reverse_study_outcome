package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public class e extends p.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f9655c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f9656g;

    public e(ThreadFactory r10) {
        this.f9655c = g.a(r10);
    }

    @Override // xb.p.c
    public io.reactivex.disposables.b b(Runnable r10) {
        return c(r10, 0, null);
    }

    @Override // xb.p.c
    public io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12) {
        if (this.f9656g == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return e(r10, r11, r12, null);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f9656g == true) goto L6;
        this.f9656g = true;
        this.f9655c.shutdownNow();
        return;
    }

    public ScheduledRunnable e(Runnable r10, long r11, TimeUnit r12, ac.a r13) {
        ScheduledRunnable r14 = new ScheduledRunnable(dc.a.p(r10), r13);
        if (r13 == null) goto L18;
        if (r13.b(r14) == true) goto L18;
        return r14;
    L18:
        if (r11 > 0) goto L10;
        Future<?> r15 = this.f9655c.submit(r14);     // Catch: RejectedExecutionException -> L13
    L11:
        r14.setFuture(r15);     // Catch: RejectedExecutionException -> L13
    L17:
        return r14;
    L10:
        r15 = this.f9655c.schedule(r14, r11, r12);     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        if (r13 == null) goto L16;
        r13.a(r14);
    L16:
        dc.a.n(e);
        goto L17
    }

    public io.reactivex.disposables.b f(Runnable r10, long r11, TimeUnit r12) {
        ScheduledDirectTask r13 = new ScheduledDirectTask(dc.a.p(r10));
        if (r11 > 0) goto L5;
        Future<?> r14 = this.f9655c.submit(r13);     // Catch: RejectedExecutionException -> L8
    L6:
        r13.setFuture(r14);     // Catch: RejectedExecutionException -> L8
        return r13;
    L5:
        r14 = this.f9655c.schedule(r13, r11, r12);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        dc.a.n(e);
        return EmptyDisposable.INSTANCE;
    }

    public io.reactivex.disposables.b g(Runnable r10, long r11, long r12, TimeUnit r14) {
        Runnable r13 = dc.a.p(r10);
        if (r12 > 0) goto L13;
        b r15 = new b(r13, this.f9655c);
        if (r11 > 0) goto L7;
        Future<?> r16 = this.f9655c.submit(r15);     // Catch: RejectedExecutionException -> L10
    L8:
        r15.b(r16);     // Catch: RejectedExecutionException -> L10
        return r15;
    L7:
        r16 = this.f9655c.schedule(r15, r11, r14);     // Catch: RejectedExecutionException -> L10
        goto L8
    L13:
        ScheduledDirectPeriodicTask r17 = new ScheduledDirectPeriodicTask(r13);
        r17.setFuture(this.f9655c.scheduleAtFixedRate(r17, r11, r12, r14));     // Catch: RejectedExecutionException -> L10
        return r17;
    L10:
        e = move-exception;
        dc.a.n(e);
        return EmptyDisposable.INSTANCE;
    }

    public void h() {
        if (this.f9656g == true) goto L6;
        this.f9656g = true;
        this.f9655c.shutdown();
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f9656g;
    }
}
