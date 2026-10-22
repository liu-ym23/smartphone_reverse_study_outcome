package io.reactivex.internal.schedulers;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18144a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18145b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f18146c = null;
    public static final ConcurrentHashMap d = null;

    static {
        f18146c = new AtomicReference();
        d = new ConcurrentHashMap();
        Properties r5 = System.getProperties();
        if (r5.containsKey("rx2.purge-enabled") == false) goto L5;
        boolean r10 = Boolean.parseBoolean(r5.getProperty("rx2.purge-enabled"));
    L6:
        if (r10 == true) goto L8;
    L11:
        int r11 = 1;
    L12:
        f18144a = r10;
        f18145b = r11;
        if (r10 == false) goto L24;
    L14:
        AtomicReference r12 = f18146c;
        ScheduledExecutorService r13 = (ScheduledExecutorService) r12.get();
        if (r13 != null) goto L33;
        ScheduledExecutorService r14 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
    L19:
        if (r12.compareAndSet(r13, r14) == true) goto L20;
        if (r12.get() == r13) goto L19;
        r14.shutdownNow();
        goto L14
    L20:
        com.bytedance.android.anniex.worker.a r15 = new com.bytedance.android.anniex.worker.a(23);
        long r16 = f18145b;
        r14.scheduleAtFixedRate(r15, r16, r16, TimeUnit.SECONDS);
        return;
    L33:
        return;
    L24:
        return;
    L8:
        if (r5.containsKey("rx2.purge-period-seconds") == false) goto L11;
        r11 = Integer.parseInt(r5.getProperty("rx2.purge-period-seconds"));     // Catch: NumberFormatException -> L25
    L5:
        r10 = true;
        goto L6
    }
}
