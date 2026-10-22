package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final RxThreadFactory f9634i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final RxThreadFactory f9635j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f9636k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final TimeUnit f9637l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final C0203c f9638m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final a f9639n = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ThreadFactory f9640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<a> f9641h;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9642c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0203c> f9643g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final io.reactivex.disposables.a f9644h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ScheduledExecutorService f9645i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Future<?> f9646j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ThreadFactory f9647k;

        a(long r10, TimeUnit r11, ThreadFactory r12) {
            if (r11 == null) goto L5;
            long r13 = r11.toNanos(r10);
        L6:
            long r14 = r13;
            this.f9642c = r14;
            this.f9643g = new ConcurrentLinkedQueue();
            this.f9644h = new io.reactivex.disposables.a();
            this.f9647k = r12;
            ScheduledExecutorService r15 = null;
            if (r11 == null) goto L9;
            r15 = Executors.newScheduledThreadPool(1, c.f9635j);
            ScheduledFuture<?> r16 = r15.scheduleWithFixedDelay(this, r14, r14, TimeUnit.NANOSECONDS);
        L10:
            this.f9645i = r15;
            this.f9646j = r16;
            return;
        L9:
            r16 = null;
            goto L10
        L5:
            r13 = 0;
            goto L6
        }

        void a() {
            if (this.f9643g.isEmpty() == true) goto L12;
            long r10 = c();
            Iterator<C0203c> r11 = this.f9643g.iterator();
        L6:
            if (r11.hasNext() == false) goto L19;
            C0203c r12 = r11.next();
            if (r12.i() > r10) goto L20;
            if (this.f9643g.remove(r12) == false) goto L6;
            this.f9644h.a(r12);
            goto L6
        L20:
            return;
        L19:
            return;
        }

        C0203c b() {
            if (this.f9644h.isDisposed() == false) goto L7;
            return c.f9638m;
        L7:
            if (this.f9643g.isEmpty() == true) goto L11;
            C0203c r10 = this.f9643g.poll();
            if (r10 == null) goto L7;
            return r10;
        L11:
            C0203c r11 = new C0203c(this.f9647k);
            this.f9644h.b(r11);
            return r11;
        }

        long c() {
            return System.nanoTime();
        }

        void d(C0203c r10) {
            r10.j(c() + this.f9642c);
            this.f9643g.offer(r10);
        }

        void e() {
            this.f9644h.dispose();
            Future<?> r10 = this.f9646j;
            if (r10 == null) goto L5;
            r10.cancel(true);
        L5:
            ScheduledExecutorService r11 = this.f9645i;
            if (r11 == null) goto L9;
            r11.shutdownNow();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static final class b extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final io.reactivex.disposables.a f9648c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f9649g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final C0203c f9650h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f9651i;

        b(a r10) {
            this.f9651i = new AtomicBoolean();
            this.f9649g = r10;
            this.f9648c = new io.reactivex.disposables.a();
            this.f9650h = r10.b();
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12) {
            if (this.f9648c.isDisposed() == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f9650h.e(r10, r11, r12, this.f9648c);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f9651i.compareAndSet(false, true) == false) goto L6;
            this.f9648c.dispose();
            this.f9649g.d(this.f9650h);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f9651i.get();
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.c$c, reason: collision with other inner class name */
    static final class C0203c extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f9652h;

        C0203c(ThreadFactory r10) {
            super(r10);
            this.f9652h = 0;
        }

        public long i() {
            return this.f9652h;
        }

        public void j(long r10) {
            this.f9652h = r10;
        }
    }

    static {
        f9637l = TimeUnit.SECONDS;
        f9636k = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        C0203c r10 = new C0203c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f9638m = r10;
        r10.dispose();
        int r11 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory r12 = new RxThreadFactory("RxCachedThreadScheduler", r11);
        f9634i = r12;
        f9635j = new RxThreadFactory("RxCachedWorkerPoolEvictor", r11);
        a r13 = new a(0, null, r12);
        f9639n = r13;
        r13.e();
    }

    public c() {
        this(f9634i);
    }

    public c(ThreadFactory r10) {
        this.f9640g = r10;
        this.f9641h = new AtomicReference(f9639n);
        f();
    }

    @Override // xb.p
    public p.c a() {
        return new b(this.f9641h.get());
    }

    public void f() {
        a r10 = new a(f9636k, f9637l, this.f9640g);
        if (this.f9641h.compareAndSet(f9639n, r10) == true) goto L6;
        r10.e();
        return;
    }
}
