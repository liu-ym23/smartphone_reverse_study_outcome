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
import java.util.concurrent.atomic.AtomicReference;
import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f18152c = null;
    public static final ScheduledExecutorService d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18153b;

    static {
        ScheduledExecutorService r5 = Executors.newScheduledThreadPool(0);
        d = r5;
        r5.shutdown();
        f18152c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public p() {
        AtomicReference r5 = new AtomicReference();
        this.f18153b = r5;
        boolean r10 = l.f18144a;
        ScheduledExecutorService r11 = Executors.newScheduledThreadPool(1, f18152c);
        if (l.f18144a == true) goto L5;
    L7:
        r5.lazySet(r11);
        return;
    L5:
        if ((r11 instanceof ScheduledThreadPoolExecutor) == false) goto L7;
        ConcurrentHashMap r12 = l.d;
        r12.put((ScheduledThreadPoolExecutor) r11, r11);
        goto L7
    }

    @Override // mt.z
    public final y a() {
        return new o((ScheduledExecutorService) this.f18153b.get());
    }

    @Override // mt.z
    public final Disposable d(Runnable r5, long r10, TimeUnit r11) {
        ScheduledDirectTask r12 = new ScheduledDirectTask(r5);
        AtomicReference r13 = this.f18153b;
        if (r10 > 0) goto L7;
        Future<?> r14 = ((ScheduledExecutorService) r13.get()).submit(r12);     // Catch: RejectedExecutionException -> L5
    L8:
        r12.setFuture(r14);     // Catch: RejectedExecutionException -> L5
        return r12;
    L7:
        r14 = ((ScheduledExecutorService) r13.get()).schedule(r12, r10, r11);     // Catch: RejectedExecutionException -> L5
    L5:
        e = move-exception;
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // mt.z
    public final Disposable e(Runnable r10, long r11, long r12, TimeUnit r14) {
        AtomicReference r13 = this.f18153b;
        if (r12 > 0) goto L14;
        ScheduledExecutorService r15 = (ScheduledExecutorService) r13.get();
        e r16 = new e(r10, r15);
        if (r11 > 0) goto L9;
        Future r17 = r15.submit(r16);     // Catch: RejectedExecutionException -> L7
    L10:
        r16.a(r17);     // Catch: RejectedExecutionException -> L7
        return r16;
    L9:
        r17 = r15.schedule(r16, r11, r14);     // Catch: RejectedExecutionException -> L7
    L7:
        e = move-exception;
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    L14:
        ScheduledDirectPeriodicTask r18 = new ScheduledDirectPeriodicTask(r10);
        r18.setFuture(((ScheduledExecutorService) r13.get()).scheduleAtFixedRate(r18, r11, r12, r14));     // Catch: RejectedExecutionException -> L17
        return r18;
    L17:
        e = move-exception;
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    }
}
