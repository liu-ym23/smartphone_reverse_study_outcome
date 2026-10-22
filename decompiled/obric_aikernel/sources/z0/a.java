package z0;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13731a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13732b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13733c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13734d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f13735e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f13736f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final RejectedExecutionHandler f13737g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final o1.a<z0.b> f13738h = null;

    /* JADX INFO: renamed from: z0.a$a, reason: collision with other inner class name */
    static class RejectedExecutionHandlerC0321a implements RejectedExecutionHandler {
        RejectedExecutionHandlerC0321a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor r11) {
            Executors.newCachedThreadPool().execute(r10);
        }
    }

    static class b extends o1.a<z0.b> {
        b() {
        }

        @Override // o1.a
        protected /* bridge */ /* synthetic */ z0.b a(Object[] r10) {
            return c(r10);
        }

        protected z0.b c(Object... r10) {
            z0.b r11 = new z0.b(a.f13733c, a.f13734d, 30, TimeUnit.SECONDS, a.a(), a.b(), a.c());
            r11.allowCoreThreadTimeOut(true);
            return r11;
        }
    }

    static class c extends o1.a<z0.b> {
        c() {
        }

        @Override // o1.a
        protected /* bridge */ /* synthetic */ z0.b a(Object[] r10) {
            return c(r10);
        }

        protected z0.b c(Object... r10) {
            z0.b r11 = new z0.b(1, a.f13734d, 1, TimeUnit.SECONDS, a.a(), a.b(), a.c());
            r11.allowCoreThreadTimeOut(true);
            return r11;
        }
    }

    private static class d implements ThreadFactory {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f13739i = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ThreadGroup f13740c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f13741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f13742h;

        static {
            f13739i = new AtomicInteger(1);
        }

        d(String r10) {
            this.f13741g = new AtomicInteger(1);
            SecurityManager r11 = System.getSecurityManager();
            if (r11 == null) goto L5;
            ThreadGroup r12 = r11.getThreadGroup();
        L6:
            this.f13740c = r12;
            this.f13742h = r10 + "-" + f13739i.getAndIncrement() + "-Thread-";
            return;
        L5:
            r12 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(this.f13740c, r10, this.f13742h + this.f13741g.getAndIncrement(), 0);
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
        f13731a = r10;
        if (r10 > 0) goto L6;
        r10 = 1;
    L6:
        f13732b = r10;
        int r11 = Math.max(2, Math.min(r10 - 1, 6)) * 2;
        f13733c = r11;
        f13734d = (r11 * 2) + 1;
        f13735e = new LinkedBlockingQueue();
        f13736f = new d("AppLogDefaultExecutors");
        f13737g = new RejectedExecutionHandlerC0321a();
        new b();
        f13738h = new c();
    }

    static /* synthetic */ BlockingQueue a() {
        return f13735e;
    }

    static /* synthetic */ d b() {
        return f13736f;
    }

    static /* synthetic */ RejectedExecutionHandler c() {
        return f13737g;
    }

    public static ExecutorService d() {
        return f13738h.b(new Object[0]);
    }
}
