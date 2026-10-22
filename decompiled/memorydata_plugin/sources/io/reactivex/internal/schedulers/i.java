package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f17136a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17137b = 0;
    static final AtomicReference<ScheduledExecutorService> c = null;
    static final Map<ScheduledThreadPoolExecutor, Object> d = null;

    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r3 = new ArrayList(i.d.keySet()).iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            ScheduledThreadPoolExecutor r0 = (ScheduledThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r3.next(), ScheduledThreadPoolExecutor.class, "com.obric.memorydata.plugin");
            if (r0.isShutdown() == true) goto L7;
            r0.purge();
            goto L4
        L7:
            i.d.remove(r0);
            goto L4
        }
    }

    static final class b implements io.reactivex.b.h<String, String> {
        b() {
        }

        public String a(String r1) {
            return System.getProperty(r1);
        }

        @Override // io.reactivex.b.h
        public /* synthetic */ String apply(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        c = new AtomicReference();
        d = new ConcurrentHashMap();
        b r0 = new b();
        boolean r2 = a(true, "rx2.purge-enabled", true, true, r0);
        f17136a = r2;
        f17137b = a(r2, "rx2.purge-period-seconds", 1, 1, r0);
        a();
    }

    static int a(boolean r2, String r3, int r4, int r5, io.reactivex.b.h<String, String> r6) {
        io.reactivex.b.h r7 = (io.reactivex.b.h) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.h.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L11;
        return r5;
    L11:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.apply(r3), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r8 != null) goto L7;
        return r4;
    L7:
        return Integer.parseInt(r8);
    L9:
        return r4;
    }

    public static ScheduledExecutorService a(ThreadFactory r2) {
        ScheduledExecutorService r3 = Executors.newScheduledThreadPool(1, (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r2, ThreadFactory.class, "com.obric.memorydata.plugin"));
        a(f17136a, r3);
        return r3;
    }

    public static void a() {
        a(f17136a);
    }

    static void a(boolean r11) {
        if (r11 == false) goto L11;
    L3:
        AtomicReference<ScheduledExecutorService> r12 = c;
        ScheduledExecutorService r0 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(r12.get(), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        ScheduledExecutorService r4 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (r12.compareAndSet(r0, r4) == true) goto L8;
        r4.shutdownNow();
        goto L3
    L8:
        a r5 = new a();
        int r13 = f17137b;
        r4.scheduleAtFixedRate(r5, r13, r13, TimeUnit.SECONDS);
        return;
    L5:
        return;
    }

    static void a(boolean r2, ScheduledExecutorService r3) {
        ScheduledExecutorService r4 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ScheduledThreadPoolExecutor.class) == false) goto L9;
        ScheduledThreadPoolExecutor r5 = (ScheduledThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r4, ScheduledThreadPoolExecutor.class, "com.obric.memorydata.plugin");
        d.put(r5, r4);
        return;
    }

    static boolean a(boolean r2, String r3, boolean r4, boolean r5, io.reactivex.b.h<String, String> r6) {
        io.reactivex.b.h r7 = (io.reactivex.b.h) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.h.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L11;
        return r5;
    L11:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.apply(r3), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r8 != null) goto L7;
        return r4;
    L7:
        return "true".equals(r8);
    L9:
        return r4;
    }
}
