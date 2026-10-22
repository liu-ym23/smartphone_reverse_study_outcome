package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends u {
    static final RxThreadFactory e = null;
    static final ScheduledExecutorService f = null;
    final ThreadFactory c;
    final AtomicReference<ScheduledExecutorService> d;

    static final class a extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f17138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.disposables.a f17139b;
        volatile boolean c;

        a(ScheduledExecutorService r3) {
            this.f17138a = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
            this.f17139b = new io.reactivex.disposables.a();
        }

        @Override // io.reactivex.u.c
        public io.reactivex.disposables.b a(Runnable r4, long r5, TimeUnit r7) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            if (this.c == true) goto L5;
            ScheduledRunnable r0 = new ScheduledRunnable(io.reactivex.d.a.a(r6), this.f17139b);
            this.f17139b.a(r0);
            if (r5 > 0) goto L9;
            Future<?> r8 = this.f17138a.submit(r0);     // Catch: RejectedExecutionException -> L12
        L10:
            r0.setFuture(r8);     // Catch: RejectedExecutionException -> L12
            return r0;
        L9:
            r8 = this.f17138a.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            io.reactivex.d.a.a(e);
            return EmptyDisposable.INSTANCE;
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.c == true) goto L6;
            this.c = true;
            this.f17139b.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.c;
        }
    }

    static {
        ScheduledExecutorService r0 = Executors.newScheduledThreadPool(0);
        f = r0;
        r0.shutdown();
        e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(e);
    }

    public j(ThreadFactory r3) {
        ThreadFactory r4 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
        AtomicReference<ScheduledExecutorService> r0 = new AtomicReference();
        this.d = r0;
        this.c = r4;
        r0.lazySet(a(r4));
    }

    static ScheduledExecutorService a(ThreadFactory r2) {
        return i.a((ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r2, ThreadFactory.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.memorydata.plugin"));
        if (r12 > 0) goto L13;
        ScheduledExecutorService r8 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        c r13 = new c(r11, r8);
        if (r10 > 0) goto L7;
        Future<?> r15 = r8.submit(r13);     // Catch: RejectedExecutionException -> L10
    L8:
        r13.a(r15);     // Catch: RejectedExecutionException -> L10
        return r13;
    L7:
        r15 = r8.schedule(r13, r10, r14);     // Catch: RejectedExecutionException -> L10
        goto L8
    L13:
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin")).scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L10
        return r7;
    L10:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.u
    public io.reactivex.disposables.b a(Runnable r5, long r6, TimeUnit r8) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin")));
        if (r6 > 0) goto L5;
        Future<?> r4 = ((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin")).submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.setFuture(r4);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r4 = ((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin")).schedule(r0, r6, r8);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new a((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.u
    public void b() {
        ScheduledExecutorService r0 = null;
    L3:
        ScheduledExecutorService r1 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.d.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r1 != f) goto L5;
        if (r0 != null) goto L11;
        r0 = a(this.c);
    L11:
        if (this.d.compareAndSet(r1, r0) == false) goto L3;
        return;
    L5:
        if (r0 == null) goto L16;
        r0.shutdown();
        return;
    }
}
