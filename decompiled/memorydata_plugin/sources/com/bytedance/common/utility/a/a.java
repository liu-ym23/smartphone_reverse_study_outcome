package com.bytedance.common.utility.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1964a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1965b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    private static ExecutorService g;
    private static ExecutorService h;
    private static ExecutorService i;
    private static ScheduledExecutorService j;
    private static ExecutorService k;
    private static ExecutorService l;
    private static final b m = null;
    private static final b n = null;
    private static final b o = null;
    private static final b p = null;
    private static final b q = null;
    private static final ThreadFactoryC0111a r = null;
    private static final BlockingQueue<Runnable> s = null;
    private static final BlockingQueue<Runnable> t = null;
    private static final BlockingQueue<Runnable> u = null;
    private static final RejectedExecutionHandler v = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.a.a$a, reason: collision with other inner class name */
    private static class ThreadFactoryC0111a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadGroup f1967b;
        private final AtomicInteger c;
        private final String d;

        static {
            f1966a = new AtomicInteger(1);
        }

        ThreadFactoryC0111a(String r3) {
            this.c = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f1967b = r1;
            this.d = r3 + "-" + f1966a.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r8) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
            final ThreadGroup r2 = this.f1967b;
            final String r4 = this.d + this.c.getAndIncrement();
            final long r5 = 0;
            Thread r9 = new AnonymousClass1(this, r2, r3, r4, r5);
            if (r9.isDaemon() == false) goto L5;
            r9.setDaemon(false);
        L5:
            return r9;
        }
    }

    private static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1969a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadGroup f1970b;
        private final AtomicInteger c;
        private final String d;

        static {
            f1969a = new AtomicInteger(1);
        }

        b(String r3) {
            this.c = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f1970b = r1;
            this.d = r3 + "-" + f1969a.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Thread r8 = new Thread(this.f1970b, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin"), this.d + this.c.getAndIncrement(), 0);
            if (r8.isDaemon() == false) goto L6;
            r8.setDaemon(false);
        L6:
            if (r8.getPriority() == 5) goto L8;
            r8.setPriority(5);
        L8:
            return r8;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        f1964a = r0;
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        f1965b = r0;
        int r5 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        c = r5;
        int r6 = (r5 * 2) + 1;
        d = r6;
        int r15 = Math.max(2, Math.min(r0 - 1, 3));
        e = r15;
        int r16 = (r0 * 2) + 1;
        f = r16;
        b r11 = new b("TTDefaultExecutors");
        m = r11;
        b r1 = new b("TTCpuExecutors");
        n = r1;
        b r2 = new b("TTScheduledExecutors");
        o = r2;
        b r3 = new b("TTDownLoadExecutors");
        p = r3;
        b r14 = new b("TTSerialExecutors");
        q = r14;
        ThreadFactoryC0111a r12 = new ThreadFactoryC0111a("TTBackgroundExecutors");
        r = r12;
        LinkedBlockingQueue r10 = new LinkedBlockingQueue();
        s = r10;
        LinkedBlockingQueue r20 = new LinkedBlockingQueue();
        t = r20;
        LinkedBlockingQueue r23 = new LinkedBlockingQueue();
        u = r23;
        RejectedExecutionHandler r25 = new AnonymousClass1();
        v = r25;
        com.bytedance.common.utility.a.b r9 = new com.bytedance.common.utility.a.b(r5, r6, 30, TimeUnit.SECONDS, r10, r11, r25);
        g = r9;
        ((com.bytedance.common.utility.a.b) ZeusTransformUtils.preCheckCast(r9, com.bytedance.common.utility.a.b.class, "com.obric.memorydata.plugin")).allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.a.b r4 = new com.bytedance.common.utility.a.b(r15, r16, 30, TimeUnit.SECONDS, r20, r1, r25);
        h = r4;
        ((com.bytedance.common.utility.a.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.common.utility.a.b.class, "com.obric.memorydata.plugin")).allowCoreThreadTimeOut(true);
        j = Executors.newScheduledThreadPool(3, r2);
        com.bytedance.common.utility.a.b r7 = new com.bytedance.common.utility.a.b(2, 2, 30, TimeUnit.SECONDS, r23, r3, r25);
        i = r7;
        ((com.bytedance.common.utility.a.b) ZeusTransformUtils.preCheckCast(r7, com.bytedance.common.utility.a.b.class, "com.obric.memorydata.plugin")).allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.a.b r8 = new com.bytedance.common.utility.a.b(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), r14);
        k = r8;
        ((com.bytedance.common.utility.a.b) ZeusTransformUtils.preCheckCast(r8, com.bytedance.common.utility.a.b.class, "com.obric.memorydata.plugin")).allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.a.b r13 = new com.bytedance.common.utility.a.b(0, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), r12);
        l = r13;
        ((com.bytedance.common.utility.a.b) ZeusTransformUtils.preCheckCast(r13, com.bytedance.common.utility.a.b.class, "com.obric.memorydata.plugin")).allowCoreThreadTimeOut(true);
    }

    public static ExecutorService a() {
        return g;
    }

    public static ScheduledExecutorService b() {
        return j;
    }

    public static ExecutorService c() {
        return i;
    }
}
