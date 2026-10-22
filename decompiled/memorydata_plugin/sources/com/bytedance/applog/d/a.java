package com.bytedance.applog.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1563a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1564b = 0;
    public static final int c = 0;
    public static final int d = 0;
    private static final BlockingQueue<Runnable> e = null;
    private static final ThreadFactoryC0100a f = null;
    private static final RejectedExecutionHandler g = null;
    private static final com.bytedance.applog.log.b<b> h = null;
    private static final com.bytedance.applog.log.b<b> i = null;

    /* JADX INFO: renamed from: com.bytedance.applog.d.a$a, reason: collision with other inner class name */
    private static class ThreadFactoryC0100a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1565a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadGroup f1566b;
        private final AtomicInteger c;
        private final String d;

        static {
            f1565a = new AtomicInteger(1);
        }

        ThreadFactoryC0100a(String r3) {
            this.c = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f1566b = r1;
            this.d = r3 + "-" + f1565a.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Thread r8 = new Thread(this.f1566b, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin"), this.d + this.c.getAndIncrement(), 0);
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
        f1563a = r0;
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        f1564b = r0;
        int r1 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        c = r1;
        d = (r1 * 2) + 1;
        e = new LinkedBlockingQueue();
        f = new ThreadFactoryC0100a("AppLogDefaultExecutors");
        g = new AnonymousClass1();
        h = new AnonymousClass2();
        i = new AnonymousClass3();
    }

    public static ExecutorService a() {
        return (ExecutorService) ZeusTransformUtils.preCheckCast(h.c(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static ExecutorService b() {
        return (ExecutorService) ZeusTransformUtils.preCheckCast(i.c(new Object[0]), ExecutorService.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ BlockingQueue c() {
        return e;
    }

    static /* synthetic */ ThreadFactoryC0100a d() {
        return f;
    }

    static /* synthetic */ RejectedExecutionHandler e() {
        return g;
    }
}
