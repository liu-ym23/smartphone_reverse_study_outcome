package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
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

/* JADX INFO: loaded from: classes6.dex */
public final class d extends u {
    static final RxThreadFactory c = null;
    static final RxThreadFactory d = null;
    static final c e = null;
    static boolean h;
    static final a i = null;
    private static final long j = 0;
    private static final TimeUnit k = null;
    final ThreadFactory f;
    final AtomicReference<a> g;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.disposables.a f17129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f17130b;
        private final ConcurrentLinkedQueue<c> c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long r8, TimeUnit r10, ThreadFactory r11) {
            ThreadFactory r12 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r11, ThreadFactory.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L5;
            long r9 = r10.toNanos(r8);
        L6:
            long r4 = r9;
            this.f17130b = r4;
            this.c = new ConcurrentLinkedQueue();
            this.f17129a = new io.reactivex.disposables.a();
            this.f = r12;
            ScheduledExecutorService r13 = null;
            if (r10 == null) goto L9;
            r13 = Executors.newScheduledThreadPool(1, d.d);
            ScheduledFuture<?> r14 = r13.scheduleWithFixedDelay(this, r4, r4, TimeUnit.NANOSECONDS);
        L10:
            this.d = r13;
            this.e = r14;
            return;
        L9:
            r14 = null;
            goto L10
        L5:
            r9 = 0;
            goto L6
        }

        c a() {
            if (this.f17129a.isDisposed() == false) goto L7;
            return d.e;
        L7:
            if (this.c.isEmpty() == true) goto L11;
            c r0 = (c) ZeusTransformUtils.preCheckCast(this.c.poll(), c.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return r0;
        L11:
            c r1 = new c(this.f);
            this.f17129a.a(r1);
            return r1;
        }

        void a(c r5) {
            r5.a(c() + this.f17130b);
            this.c.offer(r5);
        }

        void b() {
            if (this.c.isEmpty() == true) goto L12;
            long r0 = c();
            Iterator<c> r2 = this.c.iterator();
        L6:
            if (r2.hasNext() == false) goto L19;
            c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");
            if (r3.a() > r0) goto L20;
            if (this.c.remove(r3) == false) goto L6;
            this.f17129a.b(r3);
            goto L6
        L20:
            return;
        L19:
            return;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f17129a.dispose();
            Future<?> r0 = this.e;
            if (r0 == null) goto L5;
            r0.cancel(true);
        L5:
            ScheduledExecutorService r2 = this.d;
            if (r2 == null) goto L9;
            r2.shutdownNow();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }
    }

    static final class b extends u.c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicBoolean f17131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.disposables.a f17132b;
        private final a c;
        private final c d;

        b(a r2) {
            this.f17131a = new AtomicBoolean();
            this.c = r2;
            this.f17132b = new io.reactivex.disposables.a();
            this.d = r2.a();
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r7, long r8, TimeUnit r10) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            if (this.f17132b.isDisposed() == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.d.a(r1, r8, r10, this.f17132b);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f17131a.compareAndSet(false, true) == false) goto L9;
            this.f17132b.dispose();
            if (d.h == false) goto L7;
            this.d.a(this, 0, TimeUnit.NANOSECONDS, null);
            return;
        L7:
            this.c.a(this.d);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f17131a.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a(this.d);
        }
    }

    static final class c extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f17133b;

        c(ThreadFactory r3) {
            super((ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin"));
            this.f17133b = 0;
        }

        public long a() {
            return this.f17133b;
        }

        public void a(long r1) {
            this.f17133b = r1;
        }
    }

    static {
        k = TimeUnit.SECONDS;
        j = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        c r0 = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        e = r0;
        r0.dispose();
        int r1 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory r2 = new RxThreadFactory("RxCachedThreadScheduler", r1);
        c = r2;
        d = new RxThreadFactory("RxCachedWorkerPoolEvictor", r1);
        h = Boolean.getBoolean("rx2.io-scheduled-release");
        a r3 = new a(0, null, r2);
        i = r3;
        r3.d();
    }

    public d() {
        this(c);
    }

    public d(ThreadFactory r3) {
        this.f = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
        this.g = new AtomicReference(i);
        b();
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new b((a) ZeusTransformUtils.preCheckCast(this.g.get(), a.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.u
    public void b() {
        a r0 = new a(j, k, this.f);
        if (this.g.compareAndSet(i, r0) == true) goto L6;
        r0.d();
        return;
    }
}
