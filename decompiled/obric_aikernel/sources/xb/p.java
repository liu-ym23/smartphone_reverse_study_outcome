package xb;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f13581c = 0;

    static final class a implements io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Runnable f13582c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final c f13583g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Thread f13584h;

        a(Runnable r10, c r11) {
            this.f13582c = r10;
            this.f13583g = r11;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f13584h != Thread.currentThread()) goto L7;
            c r10 = this.f13583g;
            if ((r10 instanceof io.reactivex.internal.schedulers.e) == false) goto L7;
            ((io.reactivex.internal.schedulers.e) r10).h();
            return;
        L7:
            this.f13583g.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f13583g.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13584h = Thread.currentThread();
            this.f13582c.run();     // Catch: Throwable -> L6
            dispose();
            this.f13584h = null;
            return;
        L6:
            th = move-exception;
            dispose();
            this.f13584h = null;
            throw th;
        }
    }

    static final class b implements io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Runnable f13585c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final c f13586g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f13587h;

        b(Runnable r10, c r11) {
            this.f13585c = r10;
            this.f13586g = r11;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f13587h = true;
            this.f13586g.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f13587h;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13587h == false) goto L10;
            return;
        L10:
            this.f13585c.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.f13586g.dispose();
            throw ExceptionHelper.d(th);
        }
    }

    public static abstract class c implements io.reactivex.disposables.b {

        final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Runnable f13588c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final SequentialDisposable f13589g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final long f13590h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            long f13591i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            long f13592j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            long f13593k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ c f13594l;

            a(c r10, long r11, Runnable r12, long r13, SequentialDisposable r14, long r15) {
                this.f13594l = r10;
                this.f13588c = r12;
                this.f13589g = r14;
                this.f13590h = r15;
                this.f13592j = r13;
                this.f13593k = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f13588c.run();
                if (this.f13589g.isDisposed() == true) goto L13;
                c r10 = this.f13594l;
                TimeUnit r11 = TimeUnit.NANOSECONDS;
                long r12 = r10.a(r11);
                long r13 = p.f13581c;
                long r14 = r12 + r13;
                long r15 = this.f13592j;
                if (r14 < r15) goto L10;
                long r16 = this.f13590h;
                if (r12 >= ((r15 + r16) + r13)) goto L10;
                long r17 = this.f13593k;
                long r18 = this.f13591i + 1;
                this.f13591i = r18;
                long r19 = r17 + (r18 * r16);
            L11:
                this.f13592j = r12;
                long r20 = r19 - r12;
                this.f13589g.replace(this.f13594l.c(this, r20, r11));
                return;
            L10:
                long r21 = this.f13590h;
                long r22 = r12 + r21;
                long r110 = this.f13591i + 1;
                this.f13591i = r110;
                this.f13593k = r22 - (r21 * r110);
                r19 = r22;
                goto L11
            }
        }

        public c() {
        }

        public long a(TimeUnit r10) {
            return r10.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public io.reactivex.disposables.b b(Runnable r10) {
            return c(r10, 0, TimeUnit.NANOSECONDS);
        }

        public abstract io.reactivex.disposables.b c(Runnable r10, long r11, TimeUnit r12);

        public io.reactivex.disposables.b d(Runnable r18, long r19, long r21, TimeUnit r23) {
            SequentialDisposable r14 = new SequentialDisposable();
            SequentialDisposable r15 = new SequentialDisposable(r14);
            Runnable r10 = dc.a.p(r18);
            long r11 = r23.toNanos(r21);
            long r12 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b r13 = c(new a(this, r12 + r23.toNanos(r19), r10, r12, r15, r11), r19, r23);
            if (r13 != EmptyDisposable.INSTANCE) goto L5;
            return r13;
        L5:
            r14.replace(r13);
            return r15;
        }
    }

    static {
        f13581c = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public p() {
    }

    public abstract c a();

    public long b(TimeUnit r10) {
        return r10.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public io.reactivex.disposables.b c(Runnable r10) {
        return d(r10, 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b d(Runnable r10, long r11, TimeUnit r12) {
        c r13 = a();
        a r14 = new a(dc.a.p(r10), r13);
        r13.c(r14, r11, r12);
        return r14;
    }

    public io.reactivex.disposables.b e(Runnable r10, long r11, long r12, TimeUnit r13) {
        c r14 = a();
        b r15 = new b(dc.a.p(r10), r14);
        io.reactivex.disposables.b r16 = r14.d(r15, r11, r12, r13);
        if (r16 != EmptyDisposable.INSTANCE) goto L5;
        return r16;
    L5:
        return r15;
    }
}
