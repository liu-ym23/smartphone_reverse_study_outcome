package io.reactivex.internal.schedulers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f18137c = null;
    public static final RxThreadFactory d = null;
    public static final long e = 0;
    public static final TimeUnit f = null;
    public static final h g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f18138h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18139b;

    static {
        f = TimeUnit.SECONDS;
        e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        h r5 = new h(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        g = r5;
        r5.dispose();
        int r10 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory r11 = new RxThreadFactory("RxCachedThreadScheduler", r10);
        f18137c = r11;
        d = new RxThreadFactory("RxCachedWorkerPoolEvictor", r10);
        f r12 = new f(0, null, r11);
        f18138h = r12;
        r12.f18132c.dispose();
        ScheduledFuture r13 = r12.e;
        if (r13 == null) goto L5;
        r13.cancel(true);
    L5:
        ScheduledExecutorService r14 = r12.d;
        if (r14 == null) goto L9;
        r14.shutdownNow();
        return;
    }

    public i() {
        RxThreadFactory r5 = f18137c;
        f r10 = f18138h;
        this.f18139b = new AtomicReference(r10);
        TimeUnit r11 = f;
        f r12 = new f(e, r11, r5);
    L3:
        AtomicReference r13 = this.f18139b;
        if (r13.compareAndSet(r10, r12) == true) goto L19;
        if (r13.get() == r10) goto L3;
        r12.f18132c.dispose();
        ScheduledFuture r14 = r12.e;
        if (r14 == null) goto L11;
        r14.cancel(true);
    L11:
        ScheduledExecutorService r15 = r12.d;
        if (r15 == null) goto L18;
        r15.shutdownNow();
        return;
    L18:
        return;
    }

    @Override // mt.z
    public final y a() {
        return new g((f) this.f18139b.get());
    }
}
