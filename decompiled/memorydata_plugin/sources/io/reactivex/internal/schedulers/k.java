package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class k extends u {
    private static final k c = null;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f17140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f17141b;
        private final long c;

        a(Runnable r3, c r4, long r5) {
            this.f17140a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f17141b = r4;
            this.c = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17141b.c == true) goto L18;
            long r0 = this.f17141b.a(TimeUnit.MILLISECONDS);
            long r2 = this.c;
            if (r2 <= r0) goto L13;
            Thread.sleep(r2 - r0);     // Catch: InterruptedException -> L9
        L9:
            e = move-exception;
            Thread.currentThread().interrupt();
            io.reactivex.d.a.a(e);
            return;
        L13:
            if (this.f17141b.c == true) goto L19;
            this.f17140a.run();
            return;
        L19:
            return;
        }
    }

    static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f17142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f17143b;
        final int c;
        volatile boolean d;

        b(Runnable r3, Long r4, int r5) {
            this.f17142a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f17143b = r4.longValue();
            this.c = r5;
        }

        public int a(b r5) {
            int r0 = io.reactivex.internal.functions.a.a(this.f17143b, r5.f17143b);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return io.reactivex.internal.functions.a.a(this.c, r5.c);
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(b r3) {
            return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class c extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f17144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f17145b;
        volatile boolean c;
        private final AtomicInteger d;

        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f17146a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f17147b;

            a(c r1, b r2) {
                this.f17147b = r1;
                this.f17146a = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f17146a.d = true;
                this.f17147b.f17144a.remove(this.f17146a);
            }
        }

        c() {
            this.f17144a = new PriorityBlockingQueue();
            this.d = new AtomicInteger();
            this.f17145b = new AtomicInteger();
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r3) {
            return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), a(TimeUnit.MILLISECONDS));
        }

        io.reactivex.disposables.b a(Runnable r3, long r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            if (this.c == true) goto L5;
            b r0 = new b(r5, Long.valueOf(r4), this.f17145b.incrementAndGet());
            this.f17144a.add(r0);
            if (this.d.getAndIncrement() != 0) goto L23;
            int r6 = 1;
        L10:
            if (this.c == true) goto L11;
            b r7 = (b) ZeusTransformUtils.preCheckCast(this.f17144a.poll(), b.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L15;
            if (r7.d == true) goto L10;
            r7.f17142a.run();
            goto L10
        L15:
            r6 = this.d.addAndGet(-r6);
            if (r6 != 0) goto L10;
            return EmptyDisposable.INSTANCE;
        L11:
            this.f17144a.clear();
            return EmptyDisposable.INSTANCE;
        L23:
            return io.reactivex.disposables.c.a(new a(this, r0));
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r3, long r4, TimeUnit r6) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            long r0 = a(TimeUnit.MILLISECONDS) + r6.toMillis(r4);
            return a(new a(r5, this, r0), r0);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.c;
        }
    }

    static {
        c = new k();
    }

    k() {
    }

    public static k c() {
        return c;
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r2) {
        io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r2, long r3, TimeUnit r5) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        r5.sleep(r3);     // Catch: InterruptedException -> L5
        io.reactivex.d.a.a(r1).run();     // Catch: InterruptedException -> L5
    L8:
        return EmptyDisposable.INSTANCE;
    L5:
        e = move-exception;
        Thread.currentThread().interrupt();
        io.reactivex.d.a.a(e);
        goto L8
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new c();
    }
}
