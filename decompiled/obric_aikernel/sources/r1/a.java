package r1;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f12554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f12555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ExecutorService f12556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ScheduledExecutorService f12557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ExecutorService f12558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ExecutorService f12559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12560g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12561h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12562i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12563j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12564k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12565l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final c f12566m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final c f12567n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final c f12568o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final c f12569p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final c f12570q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final b f12571r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f12572s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f12573t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f12574u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final RejectedExecutionHandler f12575v = null;

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    static class RejectedExecutionHandlerC0287a implements RejectedExecutionHandler {
        RejectedExecutionHandlerC0287a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor r11) {
            Executors.newCachedThreadPool().execute(r10);
        }
    }

    private static class b implements ThreadFactory {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f12576i = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ThreadGroup f12577c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f12578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f12579h;

        /* JADX INFO: renamed from: r1.a$b$a, reason: collision with other inner class name */
        class C0288a extends Thread {
            C0288a(b r10, ThreadGroup r11, Runnable r12, String r13, long r14) {
                super(r11, r12, r13, r14);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        static {
            f12576i = new AtomicInteger(1);
        }

        b(String r10) {
            this.f12578g = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f12577c = r12;
            this.f12579h = r10 + "-" + f12576i.getAndIncrement() + "-Thread-";
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            C0288a r11 = new C0288a(this, this.f12577c, r10, this.f12579h + this.f12578g.getAndIncrement(), 0);
            if (r11.isDaemon() == false) goto L5;
            r11.setDaemon(false);
        L5:
            return r11;
        }
    }

    private static class c implements ThreadFactory {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f12580i = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ThreadGroup f12581c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f12582g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f12583h;

        static {
            f12580i = new AtomicInteger(1);
        }

        c(String r10) {
            this.f12582g = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f12581c = r12;
            this.f12583h = r10 + "-" + f12580i.getAndIncrement() + "-Thread-";
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(this.f12581c, r10, this.f12583h + this.f12582g.getAndIncrement(), 0);
            if (r11.isDaemon() == false) goto L6;
            r11.setDaemon(false);
        L6:
            if (r11.getPriority() == 5) goto L8;
            r11.setPriority(5);
        L8:
            return r11;
        }
    }

    static {
        int r10 = Runtime.getRuntime().availableProcessors();
        f12560g = r10;
        if (r10 > 0) goto L6;
        r10 = 1;
    L6:
        f12561h = r10;
        int r11 = Math.max(2, Math.min(r10 - 1, 6)) * 2;
        f12562i = r11;
        int r12 = (r11 * 2) + 1;
        f12563j = r12;
        int r15 = Math.max(2, Math.min(r10 - 1, 3));
        f12564k = r15;
        int r16 = (r10 * 2) + 1;
        f12565l = r16;
        c r13 = new c("TTDefaultExecutors");
        f12566m = r13;
        c r14 = new c("TTCpuExecutors");
        f12567n = r14;
        c r17 = new c("TTScheduledExecutors");
        f12568o = r17;
        c r18 = new c("TTDownLoadExecutors");
        f12569p = r18;
        c r19 = new c("TTSerialExecutors");
        f12570q = r19;
        b r110 = new b("TTBackgroundExecutors");
        f12571r = r110;
        LinkedBlockingQueue r111 = new LinkedBlockingQueue();
        f12572s = r111;
        LinkedBlockingQueue r20 = new LinkedBlockingQueue();
        f12573t = r20;
        LinkedBlockingQueue r23 = new LinkedBlockingQueue();
        f12574u = r23;
        RejectedExecutionHandlerC0287a r25 = new RejectedExecutionHandlerC0287a();
        f12575v = r25;
        TimeUnit r26 = TimeUnit.SECONDS;
        r1.b r112 = new r1.b(r11, r12, 30, r26, r111, r13, r25);
        f12554a = r112;
        r112.allowCoreThreadTimeOut(true);
        r1.b r21 = new r1.b(r15, r16, 30, r26, r20, r14, r25);
        f12555b = r21;
        r21.allowCoreThreadTimeOut(true);
        f12557d = Executors.newScheduledThreadPool(3, r17);
        r1.b r22 = new r1.b(2, 2, 30, r26, r23, r18, r25);
        f12556c = r22;
        r22.allowCoreThreadTimeOut(true);
        r1.b r24 = new r1.b(1, 1, 30, r26, new LinkedBlockingQueue(), r19);
        f12558e = r24;
        r24.allowCoreThreadTimeOut(true);
        r1.b r27 = new r1.b(0, 3, 30, r26, new LinkedBlockingQueue(), r110);
        f12559f = r27;
        r27.allowCoreThreadTimeOut(true);
    }

    public static ExecutorService a() {
        return f12554a;
    }

    public static ScheduledExecutorService b() {
        return f12557d;
    }
}
