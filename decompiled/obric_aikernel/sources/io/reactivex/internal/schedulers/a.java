package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final b f9614i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final RxThreadFactory f9615j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f9616k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final c f9617l = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ThreadFactory f9618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<b> f9619h;

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    static final class C0202a extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ac.b f9620c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final io.reactivex.disposables.a f9621g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ac.b f9622h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c f9623i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f9624j;

        C0202a(c r10) {
            this.f9623i = r10;
            ac.b r11 = new ac.b();
            this.f9620c = r11;
            io.reactivex.disposables.a r12 = new io.reactivex.disposables.a();
            this.f9621g = r12;
            ac.b r13 = new ac.b();
            this.f9622h = r13;
            r13.b(r11);
            r13.b(r12);
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b b(Runnable r10) {
            if (this.f9624j == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f9623i.e(r10, 0, TimeUnit.MILLISECONDS, this.f9620c);
        }

        @Override // xb.p.c
        public io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12) {
            if (this.f9624j == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f9623i.e(r10, r11, r12, this.f9621g);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f9624j == true) goto L6;
            this.f9624j = true;
            this.f9622h.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f9624j;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f9625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f9626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9627c;

        b(int r10, ThreadFactory r11) {
            this.f9625a = r10;
            this.f9626b = new c[r10];
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            this.f9626b[r12] = new c(r11);
            r12 = r12 + 1;
            goto L3
        }

        public c a() {
            int r10 = this.f9625a;
            if (r10 == 0) goto L5;
            c[] r11 = this.f9626b;
            long r12 = this.f9627c;
            this.f9627c = 1 + r12;
            return r11[(int) (r12 % ((long) r10))];
        L5:
            return a.f9617l;
        }

        public void b() {
            c[] r10 = this.f9626b;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r10[r12].dispose();
            r12 = r12 + 1;
            goto L3
        }
    }

    static final class c extends e {
        c(ThreadFactory r10) {
            super(r10);
        }
    }

    static {
        f9616k = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
        c r10 = new c(new RxThreadFactory("RxComputationShutdown"));
        f9617l = r10;
        r10.dispose();
        RxThreadFactory r11 = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f9615j = r11;
        b r12 = new b(0, r11);
        f9614i = r12;
        r12.b();
    }

    public a() {
        this(f9615j);
    }

    public a(ThreadFactory r10) {
        this.f9618g = r10;
        this.f9619h = new AtomicReference(f9614i);
        g();
    }

    static int f(int r10, int r11) {
        if (r11 <= 0) goto L7;
        if (r11 <= r10) goto L6;
        return r10;
    L6:
        return r11;
    L7:
        return r10;
    }

    @Override // xb.p
    public p.c a() {
        return new C0202a(this.f9619h.get().a());
    }

    @Override // xb.p
    public io.reactivex.disposables.b d(Runnable r10, long r11, TimeUnit r12) {
        return this.f9619h.get().a().f(r10, r11, r12);
    }

    @Override // xb.p
    public io.reactivex.disposables.b e(Runnable r10, long r11, long r12, TimeUnit r13) {
        return this.f9619h.get().a().g(r10, r11, r12, r13);
    }

    public void g() {
        b r10 = new b(f9616k, this.f9618g);
        if (this.f9619h.compareAndSet(f9614i, r10) == true) goto L6;
        r10.b();
        return;
    }
}
