package s5;

import android.os.Process;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s5.b f12023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScheduledExecutorService f12024b = null;

    /* JADX INFO: renamed from: s5.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC0152a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r8, ThreadPoolExecutor r10) {
            Executors.newCachedThreadPool().execute(r8);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f12025d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f12026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f12027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12028c;

        /* JADX INFO: renamed from: s5.a$b$a, reason: collision with other inner class name */
        public class C0153a extends Thread {
            public C0153a(ThreadGroup r8, Runnable r10, String r11) {
                super(r8, r10, r11, 0);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        static {
            f12025d = new AtomicInteger(1);
        }

        public b() {
            this.f12027b = new AtomicInteger(1);
            SecurityManager r8 = System.getSecurityManager();
            if (r8 == null) goto L5;
            ThreadGroup r10 = r8.getThreadGroup();
        L6:
            this.f12026a = r10;
            this.f12028c = "TTBackgroundExecutors-" + f12025d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r10 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            C0153a r10 = new C0153a(this.f12026a, r8, this.f12028c + this.f12027b.getAndIncrement());
            if (r10.isDaemon() == false) goto L5;
            r10.setDaemon(false);
        L5:
            return r10;
        }
    }

    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f12029d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f12030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f12031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12032c;

        static {
            f12029d = new AtomicInteger(1);
        }

        public c(String r8) {
            this.f12031b = new AtomicInteger(1);
            SecurityManager r10 = System.getSecurityManager();
            if (r10 == null) goto L5;
            ThreadGroup r11 = r10.getThreadGroup();
        L6:
            this.f12030a = r11;
            StringBuilder r12 = android.aimedia.a.k(r8, "-");
            r12.append(f12029d.getAndIncrement());
            r12.append("-Thread-");
            this.f12032c = r12.toString();
            return;
        L5:
            r11 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(this.f12030a, r8, this.f12032c + this.f12031b.getAndIncrement(), 0);
            if (r10.isDaemon() == false) goto L6;
            r10.setDaemon(false);
        L6:
            if (r10.getPriority() == 5) goto L8;
            r10.setPriority(5);
        L8:
            return r10;
        }
    }

    static {
        int r8 = Runtime.getRuntime().availableProcessors();
        if (r8 > 0) goto L6;
        r8 = 1;
    L6:
        int r10 = r8 - 1;
        int r11 = Math.max(2, Math.min(r10, 6)) * 2;
        c r12 = new c("TTDefaultExecutors");
        c r13 = new c("TTCpuExecutors");
        c r14 = new c("TTScheduledExecutors");
        c r15 = new c("TTDownLoadExecutors");
        c r16 = new c("TTSerialExecutors");
        b r21 = new b();
        LinkedBlockingQueue r17 = new LinkedBlockingQueue();
        LinkedBlockingQueue r18 = new LinkedBlockingQueue();
        LinkedBlockingQueue r19 = new LinkedBlockingQueue();
        RejectedExecutionHandlerC0152a r20 = new RejectedExecutionHandlerC0152a();
        TimeUnit r22 = TimeUnit.SECONDS;
        s5.b r110 = new s5.b(r11, (r11 * 2) + 1, r22, r17, r12, r20);
        f12023a = r110;
        r110.allowCoreThreadTimeOut(true);
        new s5.b(Math.max(2, Math.min(r10, 3)), (r8 * 2) + 1, r22, r18, r13, r20).allowCoreThreadTimeOut(true);
        f12024b = Executors.newScheduledThreadPool(3, r14);
        new s5.b(2, 2, r22, r19, r15, r20).allowCoreThreadTimeOut(true);
        new s5.b(1, 1, r22, new LinkedBlockingQueue(), r16).allowCoreThreadTimeOut(true);
        new s5.b(0, 3, r22, new LinkedBlockingQueue(), r21).allowCoreThreadTimeOut(true);
    }
}
