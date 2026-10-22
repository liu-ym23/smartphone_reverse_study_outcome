package x3;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13369a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedBlockingQueue f13370b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f13371c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RejectedExecutionHandlerC0191a f13372d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f13373e = null;

    /* JADX INFO: renamed from: x3.a$a, reason: collision with other inner class name */
    public static class RejectedExecutionHandlerC0191a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r8, ThreadPoolExecutor r10) {
            Executors.newCachedThreadPool().execute(r8);
        }
    }

    public static class b extends c4.b {
        public b() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r10) {
            x3.b r11 = new x3.b(1, a.f13369a, 1, TimeUnit.SECONDS, a.f13370b, a.f13371c, a.f13372d);
            r11.allowCoreThreadTimeOut(true);
            return r11;
        }
    }

    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f13374d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f13375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f13376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f13377c;

        static {
            f13374d = new AtomicInteger(1);
        }

        public c() {
            this.f13376b = new AtomicInteger(1);
            SecurityManager r8 = System.getSecurityManager();
            if (r8 == null) goto L5;
            ThreadGroup r10 = r8.getThreadGroup();
        L6:
            this.f13375a = r10;
            this.f13377c = "AppLogDefaultExecutors-" + f13374d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r10 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(this.f13375a, r8, this.f13377c + this.f13376b.getAndIncrement(), 0);
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
        f13369a = ((Math.max(2, Math.min(r8 - 1, 6)) * 2) * 2) + 1;
        f13370b = new LinkedBlockingQueue();
        f13371c = new c();
        f13372d = new RejectedExecutionHandlerC0191a();
        f13373e = new b();
    }
}
