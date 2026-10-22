package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f17127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<Future<?>> f17128b;
    final AtomicReference<Future<?>> c;
    final ExecutorService d;
    Thread e;

    static {
        f = new FutureTask(Functions.f16717b, null);
    }

    c(Runnable r3, ExecutorService r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        ExecutorService r6 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r4, ExecutorService.class, "com.obric.memorydata.plugin");
        this.f17127a = r5;
        this.c = new AtomicReference();
        this.f17128b = new AtomicReference();
        this.d = r6;
    }

    void a(Future<?> r4) {
        Future<?> r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");
    L3:
        Future<?> r0 = (Future) ZeusTransformUtils.preCheckCast(this.c.get(), Future.class, "com.obric.memorydata.plugin");
        if (r0 == f) goto L6;
        if (this.c.compareAndSet(r0, r5) == false) goto L3;
        return;
    L6:
        if (this.e == Thread.currentThread()) goto L8;
        boolean r3 = true;
    L9:
        r5.cancel(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    void b(Future<?> r4) {
        Future<?> r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");
    L3:
        Future<?> r0 = (Future) ZeusTransformUtils.preCheckCast(this.f17128b.get(), Future.class, "com.obric.memorydata.plugin");
        if (r0 == f) goto L6;
        if (this.f17128b.compareAndSet(r0, r5) == false) goto L3;
        return;
    L6:
        if (this.e == Thread.currentThread()) goto L8;
        boolean r3 = true;
    L9:
        r5.cancel(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        this.e = Thread.currentThread();
        this.f17127a.run();     // Catch: Throwable -> L5
        b(this.d.submit(this));     // Catch: Throwable -> L5
        this.e = null;     // Catch: Throwable -> L5
    L7:
        return null;
    L5:
        th = move-exception;
        this.e = null;
        io.reactivex.d.a.a(th);
        goto L7
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        AtomicReference<Future<?>> r0 = this.c;
        FutureTask<Void> r1 = f;
        Future<?> r2 = (Future) ZeusTransformUtils.preCheckCast(r0.getAndSet(r1), Future.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (r2 == null) goto L10;
        if (r2 == r1) goto L10;
        if (this.e == Thread.currentThread()) goto L8;
        boolean r5 = true;
    L9:
        r2.cancel(r5);
        goto L10
    L8:
        r5 = false;
    L10:
        Future<?> r4 = (Future) ZeusTransformUtils.preCheckCast(this.f17128b.getAndSet(r1), Future.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        if (r4 != r1) goto L14;
        return;
    L14:
        if (this.e != Thread.currentThread()) goto L17;
        r3 = false;
    L17:
        r4.cancel(r3);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.c.get() != f) goto L5;
        return true;
    L5:
        return false;
    }
}
