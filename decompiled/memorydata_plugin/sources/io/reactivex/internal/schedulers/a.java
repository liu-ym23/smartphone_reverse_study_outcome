package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends u implements h {
    static final b c = null;
    static final RxThreadFactory d = null;
    static final int e = 0;
    static final c f = null;
    final ThreadFactory g;
    final AtomicReference<b> h;

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    static final class C0876a extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f17122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f17123b;
        private final io.reactivex.disposables.a c;
        private final io.reactivex.internal.disposables.b d;
        private final c e;

        C0876a(c r3) {
            this.e = r3;
            io.reactivex.internal.disposables.b r4 = new io.reactivex.internal.disposables.b();
            this.f17123b = r4;
            io.reactivex.disposables.a r0 = new io.reactivex.disposables.a();
            this.c = r0;
            io.reactivex.internal.disposables.b r1 = new io.reactivex.internal.disposables.b();
            this.d = r1;
            r1.a(r4);
            r1.a(r0);
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r7) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            if (this.f17122a == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.e.a(r1, 0, TimeUnit.MILLISECONDS, this.f17123b);
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r7, long r8, TimeUnit r10) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            if (this.f17122a == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.e.a(r1, r8, r10, this.c);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f17122a == true) goto L6;
            this.f17122a = true;
            this.d.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f17122a;
        }
    }

    static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f17124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f17125b;
        long c;

        b(int r4, ThreadFactory r5) {
            ThreadFactory r6 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r5, ThreadFactory.class, "com.obric.memorydata.plugin");
            this.f17124a = r4;
            this.f17125b = new c[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.f17125b[r0] = new c(r6);
            r0 = r0 + 1;
            goto L3
        }

        public c a() {
            int r0 = this.f17124a;
            if (r0 == 0) goto L5;
            c[] r1 = this.f17125b;
            long r2 = this.c;
            this.c = 1 + r2;
            return r1[(int) (r2 % ((long) r0))];
        L5:
            return a.f;
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int r7, h.a r8) {
            h.a r9 = (h.a) ZeusTransformUtils.wrapperContextForParams(r8, h.a.class, "com.obric.memorydata.plugin");
            int r0 = this.f17124a;
            int r1 = 0;
            if (r0 != 0) goto L6;
        L4:
            if (r1 >= r7) goto L18;
            r9.a(r1, a.f);
            r1 = r1 + 1;
            goto L4
        L18:
            return;
        L6:
            int r2 = ((int) this.c) % r0;
            int r3 = 0;
        L7:
            if (r3 >= r7) goto L12;
            r9.a(r3, new C0876a(this.f17125b[r2]));
            r2 = r2 + 1;
            if (r2 != r0) goto L11;
            r2 = 0;
        L11:
            r3 = r3 + 1;
            goto L7
        L12:
            this.c = r2;
        }

        public void b() {
            c[] r3 = this.f17125b;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }
    }

    static final class c extends f {
        c(ThreadFactory r3) {
            super((ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        e = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
        c r0 = new c(new RxThreadFactory("RxComputationShutdown"));
        f = r0;
        r0.dispose();
        RxThreadFactory r3 = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        d = r3;
        b r1 = new b(0, r3);
        c = r1;
        r1.b();
    }

    public a() {
        this(d);
    }

    public a(ThreadFactory r3) {
        this.g = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
        this.h = new AtomicReference(c);
        b();
    }

    static int a(int r0, int r1) {
        if (r1 <= 0) goto L7;
        if (r1 <= r0) goto L6;
        return r0;
    L6:
        return r1;
    L7:
        return r0;
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r10, long r11, long r13, TimeUnit r15) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        return ((b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.memorydata.plugin")).a().b(r3, r11, r13, r15);
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r3, long r4, TimeUnit r6) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return ((b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.memorydata.plugin")).a().b(r5, r4, r6);
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new C0876a(((b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.memorydata.plugin")).a());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int r3, h.a r4) {
        h.a r5 = (h.a) ZeusTransformUtils.wrapperContextForParams(r4, h.a.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r3, "number > 0 required");
        ((b) ZeusTransformUtils.preCheckCast(this.h.get(), b.class, "com.obric.memorydata.plugin")).a(r3, r5);
    }

    @Override // io.reactivex.u
    public void b() {
        b r0 = new b(e, this.g);
        if (this.h.compareAndSet(c, r0) == true) goto L6;
        r0.b();
        return;
    }
}
