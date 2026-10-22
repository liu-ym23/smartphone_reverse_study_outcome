package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9657a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9658b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f9659c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f9660d = null;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9662b;

        a() {
        }

        void a(Properties r10) {
            if (r10.containsKey("rx2.purge-enabled") == false) goto L5;
            this.f9661a = Boolean.parseBoolean(r10.getProperty("rx2.purge-enabled"));
        L7:
            if (this.f9661a == true) goto L9;
        L12:
            this.f9662b = 1;
            return;
        L9:
            if (r10.containsKey("rx2.purge-period-seconds") == false) goto L12;
            this.f9662b = Integer.parseInt(r10.getProperty("rx2.purge-period-seconds"));     // Catch: NumberFormatException -> L14
            return;
        L5:
            this.f9661a = true;
            goto L7
        }
    }

    static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = new ArrayList(g.f9660d.keySet()).iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            ScheduledThreadPoolExecutor r11 = (ScheduledThreadPoolExecutor) r10.next();
            if (r11.isShutdown() == true) goto L7;
            r11.purge();
            goto L4
        L7:
            g.f9660d.remove(r11);
            goto L4
        }
    }

    static {
        f9659c = new AtomicReference();
        f9660d = new ConcurrentHashMap();
        Properties r10 = System.getProperties();
        a r11 = new a();
        r11.a(r10);
        f9657a = r11.f9661a;
        f9658b = r11.f9662b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory r10) {
        ScheduledExecutorService r11 = Executors.newScheduledThreadPool(1, r10);
        c(f9657a, r11);
        return r11;
    }

    public static void b() {
        d(f9657a);
    }

    static void c(boolean r10, ScheduledExecutorService r11) {
        if (r10 == true) goto L4;
        return;
    L4:
        if ((r11 instanceof ScheduledThreadPoolExecutor) == false) goto L8;
        Map<ScheduledThreadPoolExecutor, Object> r12 = f9660d;
        r12.put((ScheduledThreadPoolExecutor) r11, r11);
        return;
    }

    static void d(boolean r11) {
        if (r11 == false) goto L11;
    L3:
        AtomicReference<ScheduledExecutorService> r12 = f9659c;
        ScheduledExecutorService r10 = r12.get();
        if (r10 != null) goto L5;
        ScheduledExecutorService r13 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (r12.compareAndSet(r10, r13) == true) goto L8;
        r13.shutdownNow();
        goto L3
    L8:
        b r14 = new b();
        int r15 = f9658b;
        r13.scheduleAtFixedRate(r14, r15, r15, TimeUnit.SECONDS);
        return;
    L5:
        return;
    }
}
