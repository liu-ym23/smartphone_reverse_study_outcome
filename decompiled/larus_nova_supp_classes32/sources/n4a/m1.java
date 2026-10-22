package n4a;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class m1 {
    public PThreadPoolExecutor a;
    public final ConcurrentHashMap<l1, Future<?>> b;
    public final a c;

    public class a {
        public final /* synthetic */ m1 a;

        public a(m1 r1) {
            this.a = r1;
        }
    }

    public m1() {
        this.b = new ConcurrentHashMap();
        this.c = new a(this);
    }

    public final synchronized void a(l1 r2, Future<?> r3) {
        monitor-enter(this);
        this.b.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        r.f(th, "TPool", "addQueue");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(l1 r4) {
        monitor-enter(this);
        boolean r0 = this.b.containsKey(r4);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        if (r0 == false) goto L11;
        return;
    L11:
        PThreadPoolExecutor r1 = this.a;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.isShutdown() == true) goto L35;
        r4.a = this.c;
        Future<?> r2 = this.a.submit(r4);     // Catch: RejectedExecutionException -> L22
        if (r2 != null) goto L20;
        return;
    L20:
        a(r4, r2);
        return;
    L22:
        e = move-exception;
        r.f(e, "TPool", "addTask");
        return;
    L35:
        return;
    L5:
        th = move-exception;
        r.f(th, "TPool", "contain");     // Catch: Throwable -> L25
        th.printStackTrace();     // Catch: Throwable -> L25
        r0 = false;
    L25:
        th = move-exception;
        throw th;
    }
}
