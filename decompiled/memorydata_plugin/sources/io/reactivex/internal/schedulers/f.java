package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.u;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class f extends u.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f17134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f17135b;

    public f(ThreadFactory r3) {
        this.f17135b = i.a((ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.u.c
    public io.reactivex.disposables.b a(Runnable r4) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"), 0, null);
    }

    @Override // io.reactivex.u.c
    public io.reactivex.disposables.b a(Runnable r7, long r8, TimeUnit r10) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        if (this.f17134a == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return a(r1, r8, r10, null);
    }

    public ScheduledRunnable a(Runnable r4, long r5, TimeUnit r7, io.reactivex.internal.disposables.a r8) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.disposables.a r9 = (io.reactivex.internal.disposables.a) ZeusTransformUtils.wrapperContextForParams(r8, io.reactivex.internal.disposables.a.class, "com.obric.memorydata.plugin");
        ScheduledRunnable r0 = new ScheduledRunnable(io.reactivex.d.a.a(r6), r9);
        if (r9 == null) goto L18;
        if (r9.a(r0) == true) goto L18;
        return r0;
    L18:
        if (r5 > 0) goto L10;
        Future<?> r3 = this.f17135b.submit(r0);     // Catch: RejectedExecutionException -> L13
    L11:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L13
    L17:
        return r0;
    L10:
        r3 = this.f17135b.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        if (r9 == null) goto L16;
        r9.b(r0);
    L16:
        io.reactivex.d.a.a(e);
        goto L17
    }

    public io.reactivex.disposables.b b(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.memorydata.plugin"));
        if (r12 > 0) goto L13;
        c r13 = new c(r11, this.f17135b);
        if (r10 > 0) goto L7;
        Future<?> r8 = this.f17135b.submit(r13);     // Catch: RejectedExecutionException -> L10
    L8:
        r13.a(r8);     // Catch: RejectedExecutionException -> L10
        return r13;
    L7:
        r8 = this.f17135b.schedule(r13, r10, r14);     // Catch: RejectedExecutionException -> L10
        goto L8
    L13:
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(this.f17135b.scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L10
        return r7;
    L10:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    }

    public io.reactivex.disposables.b b(Runnable r4, long r5, TimeUnit r7) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(io.reactivex.d.a.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin")));
        if (r5 > 0) goto L5;
        Future<?> r3 = this.f17135b.submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r3 = this.f17135b.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        io.reactivex.d.a.a(e);
        return EmptyDisposable.INSTANCE;
    }

    public void b() {
        if (this.f17134a == true) goto L6;
        this.f17134a = true;
        this.f17135b.shutdown();
        return;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f17134a == true) goto L6;
        this.f17134a = true;
        this.f17135b.shutdownNow();
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f17134a;
    }
}
