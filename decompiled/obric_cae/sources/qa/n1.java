package qa;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f10847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<m1, Future<?>> f10848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f10849c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n1 f10850a;

        public a(n1 r8) {
            this.f10850a = r8;
        }
    }

    public n1() {
        this.f10848b = new ConcurrentHashMap();
        this.f10849c = new a(this);
    }

    public final void a(m1 r8) {
        monitor-enter(this);
        boolean r10 = this.f10848b.containsKey(r8);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        if (r10 == false) goto L11;
        return;
    L11:
        ThreadPoolExecutor r11 = this.f10847a;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.isShutdown() == true) goto L47;
        r8.f10824a = this.f10849c;
        Future<?> r12 = this.f10847a.submit(r8);     // Catch: RejectedExecutionException -> L30
        if (r12 != null) goto L20;
        return;
    L20:
        monitor-enter(this);
        this.f10848b.put(r8, r12);     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        q.f("TPool", "addQueue", th);     // Catch: Throwable -> L27
        th.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L30:
        e = move-exception;
        q.f("TPool", "addTask", e);
        return;
    L47:
        return;
    L5:
        th = move-exception;
        q.f("TPool", "contain", th);     // Catch: Throwable -> L33
        th.printStackTrace();     // Catch: Throwable -> L33
        r10 = false;
    L33:
        th = move-exception;
        throw th;
    }
}
