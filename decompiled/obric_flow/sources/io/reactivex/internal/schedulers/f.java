package io.reactivex.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f18131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.reactivex.disposables.a f18132c;
    public final ScheduledExecutorService d;
    public final ScheduledFuture e;
    public final RxThreadFactory f;

    public f(long r10, TimeUnit r11, RxThreadFactory r12) {
        if (r11 == null) goto L6;
        long r13 = r11.toNanos(r10);
    L5:
        long r5 = r13;
        this.f18130a = r5;
        this.f18131b = new ConcurrentLinkedQueue();
        this.f18132c = new io.reactivex.disposables.a();
        this.f = r12;
        if (r11 == null) goto L10;
        ScheduledExecutorService r14 = Executors.newScheduledThreadPool(1, i.d);
        ScheduledFuture<?> r15 = r14.scheduleWithFixedDelay(this, r5, r5, TimeUnit.NANOSECONDS);
    L11:
        this.d = r14;
        this.e = r15;
        return;
    L10:
        r14 = null;
        r15 = null;
        goto L11
    L6:
        r13 = 0;
        goto L5
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue r5 = this.f18131b;
        if (r5.isEmpty() == true) goto L12;
        long r10 = System.nanoTime();
        Iterator r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L19;
        h r12 = (h) r11.next();
        if (r12.f18136c > r10) goto L20;
        if (r5.remove(r12) == false) goto L6;
        this.f18132c.a(r12);
        goto L6
    L20:
        return;
    L19:
        return;
    }
}
