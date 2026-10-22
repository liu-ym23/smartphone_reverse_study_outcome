package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final i f9669g = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f9670c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c f9671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f9672h;

        a(Runnable r10, c r11, long r12) {
            this.f9670c = r10;
            this.f9671g = r11;
            this.f9672h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9671g.f9680i == true) goto L18;
            long r10 = this.f9671g.a(TimeUnit.MILLISECONDS);
            long r11 = this.f9672h;
            if (r11 <= r10) goto L13;
            Thread.sleep(r11 - r10);     // Catch: InterruptedException -> L9
        L9:
            e = move-exception;
            Thread.currentThread().interrupt();
            dc.a.n(e);
            return;
        L13:
            if (this.f9671g.f9680i == true) goto L19;
            this.f9670c.run();
            return;
        L19:
            return;
        }
    }

    static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Runnable f9673c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f9674g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f9675h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f9676i;

        b(Runnable r10, Long r11, int r12) {
            this.f9673c = r10;
            this.f9674g = r11.longValue();
            this.f9675h = r12;
        }

        public int a(b r10) {
            int r11 = io.reactivex.internal.functions.a.b(this.f9674g, r10.f9674g);
            if (r11 == 0) goto L5;
            return r11;
        L5:
            return io.reactivex.internal.functions.a.a(this.f9675h, r10.f9675h);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b r10) {
            return a(r10);
        }
    }

    static final class c extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final PriorityBlockingQueue<b> f9677c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f9678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicInteger f9679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f9680i;

        final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final b f9681c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f9682g;

            a(c r10, b r11) {
                this.f9682g = r10;
                this.f9681c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f9681c.f9676i = true;
                this.f9682g.f9677c.remove(this.f9681c);
            }
        }

        c() {
            this.f9677c = new PriorityBlockingQueue();
            this.f9678g = new AtomicInteger();
            this.f9679h = new AtomicInteger();
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b b(Runnable r10) {
            return e(r10, a(TimeUnit.MILLISECONDS));
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12) {
            long r13 = a(TimeUnit.MILLISECONDS) + r12.toMillis(r11);
            return e(new a(r10, this, r13), r13);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f9680i = true;
        }

        io.reactivex.disposables.b e(Runnable r10, long r11) {
            if (this.f9680i == true) goto L5;
            b r12 = new b(r10, Long.valueOf(r11), this.f9679h.incrementAndGet());
            this.f9677c.add(r12);
            if (this.f9678g.getAndIncrement() != 0) goto L23;
            int r13 = 1;
        L10:
            if (this.f9680i == true) goto L11;
            b r14 = this.f9677c.poll();
            if (r14 == null) goto L15;
            if (r14.f9676i == true) goto L10;
            r14.f9673c.run();
            goto L10
        L15:
            r13 = this.f9678g.addAndGet(-r13);
            if (r13 != 0) goto L10;
            return EmptyDisposable.INSTANCE;
        L11:
            this.f9677c.clear();
            return EmptyDisposable.INSTANCE;
        L23:
            return io.reactivex.disposables.c.b(new a(this, r12));
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f9680i;
        }
    }

    static {
        f9669g = new i();
    }

    i() {
    }

    public static i f() {
        return f9669g;
    }

    @Override // xb.p
    public p.c a() {
        return new c();
    }

    @Override // xb.p
    public io.reactivex.disposables.b c(Runnable r10) {
        dc.a.p(r10).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // xb.p
    public io.reactivex.disposables.b d(Runnable r10, long r11, TimeUnit r12) {
        r12.sleep(r11);     // Catch: InterruptedException -> L4
        dc.a.p(r10).run();     // Catch: InterruptedException -> L4
    L7:
        return EmptyDisposable.INSTANCE;
    L4:
        e = move-exception;
        Thread.currentThread().interrupt();
        dc.a.n(e);
        goto L7
    }
}
