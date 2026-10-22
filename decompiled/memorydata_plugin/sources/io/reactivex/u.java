package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f17186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long f17187b = 0;

    static final class a implements io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f17188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f17189b;
        Thread c;

        a(Runnable r3, c r4) {
            this.f17188a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f17189b = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.c == Thread.currentThread()) goto L5;
        L7:
            this.f17189b.dispose();
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(this.f17189b, io.reactivex.internal.schedulers.f.class) == false) goto L7;
            ((io.reactivex.internal.schedulers.f) ZeusTransformUtils.preCheckCast(this.f17189b, io.reactivex.internal.schedulers.f.class, "com.obric.memorydata.plugin")).b();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f17189b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            this.f17188a.run();     // Catch: Throwable -> L6
            dispose();
            this.c = null;
            return;
        L6:
            th = move-exception;
            dispose();
            this.c = null;
            throw th;
        }
    }

    static final class b implements io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f17190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f17191b;
        volatile boolean c;

        b(Runnable r3, c r4) {
            this.f17190a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f17191b = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.c = true;
            this.f17191b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == false) goto L10;
            return;
        L10:
            this.f17190a.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.f17191b.dispose();
            throw ExceptionHelper.a(th);
        }
    }

    public static abstract class c implements io.reactivex.disposables.b {

        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f17192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final SequentialDisposable f17193b;
            final long c;
            long d;
            long e;
            long f;
            final /* synthetic */ c g;

            a(c r3, long r4, Runnable r6, long r7, SequentialDisposable r9, long r10) {
                Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
                this.g = r3;
                this.f17192a = r8;
                this.f17193b = r9;
                this.c = r10;
                this.e = r7;
                this.f = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f17192a.run();
                if (this.f17193b.isDisposed() == true) goto L13;
                long r0 = this.g.a(TimeUnit.NANOSECONDS);
                long r2 = u.f17187b + r0;
                long r4 = this.e;
                if (r2 >= r4) goto L7;
            L10:
                long r3 = this.c;
                long r5 = r0 + r3;
                long r8 = this.d + 1;
                this.d = r8;
                this.f = r5 - (r3 * r8);
                long r6 = r5;
            L11:
                this.e = r0;
                long r7 = r6 - r0;
                this.f17193b.replace(this.g.a(this, r7, TimeUnit.NANOSECONDS));
                return;
            L7:
                if (r0 >= ((r4 + this.c) + u.f17187b)) goto L10;
                long r9 = this.f;
                long r10 = this.d + 1;
                this.d = r10;
                r6 = r9 + (r10 * this.c);
                goto L11
            }
        }

        public c() {
        }

        public long a(TimeUnit r1) {
            return u.a(r1);
        }

        public io.reactivex.disposables.b a(Runnable r4) {
            return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), 0, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b a(Runnable r17, long r18, long r20, TimeUnit r22) {
            Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r17, Runnable.class, "com.obric.memorydata.plugin");
            SequentialDisposable r14 = new SequentialDisposable();
            SequentialDisposable r15 = new SequentialDisposable(r14);
            Runnable r4 = io.reactivex.d.a.a(r0);
            long r8 = r22.toNanos(r20);
            long r5 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b r1 = a(new a(this, r5 + r22.toNanos(r18), r4, r5, r15, r8), r18, r22);
            if (r1 != EmptyDisposable.INSTANCE) goto L5;
            return r1;
        L5:
            r14.replace(r1);
            return r15;
        }

        public abstract io.reactivex.disposables.b a(Runnable r1, long r2, TimeUnit r4);
    }

    static {
        f17186a = Boolean.getBoolean("rx2.scheduler.use-nanotime");
        f17187b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public u() {
    }

    static long a(TimeUnit r3) {
        if (f17186a == true) goto L7;
        long r0 = System.currentTimeMillis();
        TimeUnit r2 = TimeUnit.MILLISECONDS;
    L6:
        return r3.convert(r0, r2);
    L7:
        r0 = System.nanoTime();
        r2 = TimeUnit.NANOSECONDS;
        goto L6
    }

    public io.reactivex.disposables.b a(Runnable r4) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b a(Runnable r8, long r9, long r11, TimeUnit r13) {
        Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        c r0 = a();
        b r12 = new b(io.reactivex.d.a.a(r10), r0);
        io.reactivex.disposables.b r7 = r0.a(r12, r9, r11, r13);
        if (r7 != EmptyDisposable.INSTANCE) goto L5;
        return r7;
    L5:
        return r12;
    }

    public io.reactivex.disposables.b a(Runnable r3, long r4, TimeUnit r6) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        c r2 = a();
        a r0 = new a(io.reactivex.d.a.a(r5), r2);
        r2.a(r0, r4, r6);
        return r0;
    }

    public abstract c a();

    public long b(TimeUnit r1) {
        return a(r1);
    }

    public void b() {
    }
}
