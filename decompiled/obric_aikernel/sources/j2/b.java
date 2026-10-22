package j2;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9741e = "b";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<NetworkAsyncTaskType, b> f9742f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<j2.a, ScheduledFuture> f9743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<j2.a, Runnable> f9744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NetworkAsyncTaskType f9745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f9746d;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: j2.b$b, reason: collision with other inner class name */
    private static class RunnableC0206b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j2.a f9747c;

        private RunnableC0206b(j2.a r10) {
            this.f9747c = r10;
        }

        /* synthetic */ RunnableC0206b(j2.a r10, a r11) {
            this(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f9747c.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(b.a(), "Task execute time: " + (System.currentTimeMillis() - r10));     // Catch: Throwable -> L8
        L6:
            if (this.f9747c.isLoop() == true) goto L13;
        L7:
            b.d(this.f9747c.getTaskType()).c().remove(this.f9747c);
            b.d(this.f9747c.getTaskType()).b().remove(this.f9747c);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(b.a(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f9747c.isLoop() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f9747c.isLoop() == true) goto L18;
            b.d(this.f9747c.getTaskType()).c().remove(this.f9747c);
            b.d(this.f9747c.getTaskType()).b().remove(this.f9747c);
        L18:
            throw th;
        }
    }

    static {
        f9742f = new ConcurrentHashMap();
    }

    private b(NetworkAsyncTaskType r10) {
        this.f9743a = new ConcurrentHashMap();
        this.f9744b = new ConcurrentHashMap();
        this.f9745c = r10;
        this.f9746d = new ScheduledThreadPoolExecutor(1, new d(r10.name()));
    }

    static /* synthetic */ String a() {
        return f9741e;
    }

    public static b d(NetworkAsyncTaskType r10) {
        if (r10 == null) goto L18;
        ConcurrentHashMap<NetworkAsyncTaskType, b> r11 = f9742f;
        if (r11.get(r10) != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r11.get(r10) != null) goto L10;
        r11.put(r10, new b(r10));     // Catch: Throwable -> L12
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
    L16:
        return r11.get(r10);
    L18:
        throw new IllegalArgumentException("unsupported async task type");
    }

    public ConcurrentHashMap<?, ?> b() {
        return this.f9743a;
    }

    public ConcurrentHashMap<?, ?> c() {
        return this.f9744b;
    }

    public void e(j2.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.setTaskType(this.f9745c);
        RunnableC0206b r11 = new RunnableC0206b(r10, null);     // Catch: Throwable -> L11
        if (r10.isLoop() == false) goto L8;
        ScheduledFuture<?> r12 = this.f9746d.scheduleWithFixedDelay(r11, r10.getInitialDelay(), r10.getLoopInterval(), r10.getTimeUnit());     // Catch: Throwable -> L11
    L9:
        this.f9744b.put(r10, r11);     // Catch: Throwable -> L11
        this.f9743a.put(r10, r12);     // Catch: Throwable -> L11
        return;
    L8:
        r12 = this.f9746d.schedule(r11, r10.getInitialDelay(), r10.getTimeUnit());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void f(j2.a r10) {
        Runnable r11 = this.f9744b.remove(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L5;
        this.f9746d.remove(r11);     // Catch: Throwable -> L9
    L5:
        ScheduledFuture r12 = this.f9743a.remove(r10);     // Catch: Throwable -> L9
        if (r12 == null) goto L14;
        r12.cancel(true);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(f9741e, "removeTask failed", th);
    }
}
