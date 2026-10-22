package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final RxThreadFactory f9663h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final ScheduledExecutorService f9664i = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f9665g;

    static final class a extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ScheduledExecutorService f9666c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final io.reactivex.disposables.a f9667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f9668h;

        a(ScheduledExecutorService r10) {
            this.f9666c = r10;
            this.f9667g = new io.reactivex.disposables.a();
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12) {
            if (this.f9668h == true) goto L5;
            ScheduledRunnable r13 = new ScheduledRunnable(dc.a.p(r10), this.f9667g);
            this.f9667g.b(r13);
            if (r11 > 0) goto L9;
            Future<?> r14 = this.f9666c.submit(r13);     // Catch: RejectedExecutionException -> L12
        L10:
            r13.setFuture(r14);     // Catch: RejectedExecutionException -> L12
            return r13;
        L9:
            r14 = this.f9666c.schedule(r13, r11, r12);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            dc.a.n(e);
            return EmptyDisposable.INSTANCE;
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f9668h == true) goto L6;
            this.f9668h = true;
            this.f9667g.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f9668h;
        }
    }

    static {
        ScheduledExecutorService r10 = Executors.newScheduledThreadPool(0);
        f9664i = r10;
        r10.shutdown();
        f9663h = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public h() {
        this(f9663h);
    }

    public h(ThreadFactory r10) {
        AtomicReference<ScheduledExecutorService> r11 = new AtomicReference();
        this.f9665g = r11;
        r11.lazySet(f(r10));
    }

    static ScheduledExecutorService f(ThreadFactory r10) {
        return g.a(r10);
    }

    @Override // xb.p
    public p.c a() {
        return new a(this.f9665g.get());
    }

    @Override // xb.p
    public io.reactivex.disposables.b d(Runnable r10, long r11, TimeUnit r12) {
        ScheduledDirectTask r13 = new ScheduledDirectTask(dc.a.p(r10));
        if (r11 > 0) goto L5;
        Future<?> r14 = this.f9665g.get().submit(r13);     // Catch: RejectedExecutionException -> L8
    L6:
        r13.setFuture(r14);     // Catch: RejectedExecutionException -> L8
        return r13;
    L5:
        r14 = this.f9665g.get().schedule(r13, r11, r12);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        dc.a.n(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // xb.p
    public io.reactivex.disposables.b e(Runnable r10, long r11, long r12, TimeUnit r14) {
        Runnable r13 = dc.a.p(r10);
        if (r12 > 0) goto L13;
        ScheduledExecutorService r15 = this.f9665g.get();
        b r16 = new b(r13, r15);
        if (r11 > 0) goto L7;
        Future<?> r17 = r15.submit(r16);     // Catch: RejectedExecutionException -> L10
    L8:
        r16.b(r17);     // Catch: RejectedExecutionException -> L10
        return r16;
    L7:
        r17 = r15.schedule(r16, r11, r14);     // Catch: RejectedExecutionException -> L10
        goto L8
    L13:
        ScheduledDirectPeriodicTask r18 = new ScheduledDirectPeriodicTask(r13);
        r18.setFuture(this.f9665g.get().scheduleAtFixedRate(r18, r11, r12, r14));     // Catch: RejectedExecutionException -> L10
        return r18;
    L10:
        e = move-exception;
        dc.a.n(e);
        return EmptyDisposable.INSTANCE;
    }
}
