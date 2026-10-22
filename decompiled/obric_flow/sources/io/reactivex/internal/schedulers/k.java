package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public class k extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f18143b;

    public k(RxThreadFactory r5) {
        boolean r10 = l.f18144a;
        ScheduledExecutorService r11 = Executors.newScheduledThreadPool(1, r5);
        if (l.f18144a == true) goto L5;
    L7:
        this.f18142a = r11;
        return;
    L5:
        if ((r11 instanceof ScheduledThreadPoolExecutor) == false) goto L7;
        ConcurrentHashMap r12 = l.d;
        r12.put((ScheduledThreadPoolExecutor) r11, r11);
        goto L7
    }

    @Override // mt.y
    public final Disposable a(Runnable r5) {
        return b(r5, 0, null);
    }

    @Override // mt.y
    public final Disposable b(Runnable r10, long r11, TimeUnit r12) {
        if (this.f18143b == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return d(r10, r11, r12, null);
    }

    public final ScheduledRunnable d(Runnable r5, long r10, TimeUnit r11, qt.a r12) {
        ScheduledRunnable r13 = new ScheduledRunnable(r5, r12);
        if (r12 != null) goto L5;
    L7:
        ScheduledExecutorService r14 = this.f18142a;
        if (r10 > 0) goto L12;
        Future<?> r15 = r14.submit(r13);     // Catch: RejectedExecutionException -> L10
    L13:
        r13.setFuture(r15);     // Catch: RejectedExecutionException -> L10
    L18:
        return r13;
    L12:
        r15 = r14.schedule(r13, r10, r11);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        if (r12 == null) goto L17;
        r12.a(r13);
    L17:
        wn.f.k(e);
        goto L18
    L5:
        if (r12.b(r13) == true) goto L7;
        return r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f18143b == true) goto L6;
        this.f18143b = true;
        this.f18142a.shutdownNow();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18143b;
    }
}
