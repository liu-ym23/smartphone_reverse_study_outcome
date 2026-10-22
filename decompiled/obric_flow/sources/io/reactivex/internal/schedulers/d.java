package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f18125c = null;
    public static final RxThreadFactory d = null;
    public static final int e = 0;
    public static final c f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18126b;

    static {
        int r5 = Runtime.getRuntime().availableProcessors();
        int r10 = 0;
        int r11 = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (r11 <= 0) goto L7;
        if (r11 > r5) goto L7;
        r5 = r11;
    L7:
        e = r5;
        c r12 = new c(new RxThreadFactory("RxComputationShutdown"));
        f = r12;
        r12.dispose();
        RxThreadFactory r13 = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        d = r13;
        b r14 = new b(0, r13);
        f18125c = r14;
        c[] r15 = r14.f18123b;
        int r16 = r15.length;
    L8:
        if (r10 >= r16) goto L10;
        r15[r10].dispose();
        r10 = r10 + 1;
        goto L8
    }

    public d() {
        RxThreadFactory r5 = d;
        b r10 = f18125c;
        this.f18126b = new AtomicReference(r10);
        b r11 = new b(e, r5);
    L3:
        AtomicReference r12 = this.f18126b;
        if (r12.compareAndSet(r10, r11) == true) goto L11;
        if (r12.get() == r10) goto L3;
        c[] r13 = r11.f18123b;
        int r14 = r13.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L16;
        r13[r15].dispose();
        r15 = r15 + 1;
        goto L9
    L16:
        return;
    }

    @Override // mt.z
    public final y a() {
        return new a(((b) this.f18126b.get()).a());
    }

    @Override // mt.z
    public final Disposable d(Runnable r5, long r10, TimeUnit r11) {
        c r12 = ((b) this.f18126b.get()).a();
        r12.getClass();
        ScheduledDirectTask r13 = new ScheduledDirectTask(r5);
        ScheduledExecutorService r14 = r12.f18142a;
        if (r10 > 0) goto L7;
        Future<?> r15 = r14.submit(r13);     // Catch: RejectedExecutionException -> L5
    L8:
        r13.setFuture(r15);     // Catch: RejectedExecutionException -> L5
        return r13;
    L7:
        r15 = r14.schedule(r13, r10, r11);     // Catch: RejectedExecutionException -> L5
    L5:
        e = move-exception;
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // mt.z
    public final Disposable e(Runnable r10, long r11, long r12, TimeUnit r14) {
        c r13 = ((b) this.f18126b.get()).a();
        r13.getClass();
        if (r12 > 0) goto L13;
        ScheduledExecutorService r15 = r13.f18142a;
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
    L13:
        ScheduledDirectPeriodicTask r18 = new ScheduledDirectPeriodicTask(r10);
        r18.setFuture(r13.f18142a.scheduleAtFixedRate(r18, r11, r12, r14));     // Catch: RejectedExecutionException -> L16
        return r18;
    L16:
        e = move-exception;
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    }
}
