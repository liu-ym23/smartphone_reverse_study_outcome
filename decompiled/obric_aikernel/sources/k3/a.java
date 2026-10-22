package k3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f10041e = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f10042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f10043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f10044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<k3.b> f10045d;

    /* JADX INFO: renamed from: k3.a$a, reason: collision with other inner class name */
    class RunnableC0214a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f10046c;

        RunnableC0214a(a r10) {
            this.f10046c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<k3.b> r10 = this.f10046c.f10045d.iterator();     // Catch: OutOfMemoryError -> L10
        L4:
            if (r10.hasNext() == false) goto L7;
            r10.next().onTimeEvent(System.currentTimeMillis());     // Catch: OutOfMemoryError -> L10
            goto L4
        L7:
            if (a.a(this.f10046c) == false) goto L14;
            a.c(this.f10046c).h(this, a.b());     // Catch: OutOfMemoryError -> L10
            return;
        L14:
            return;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f10047a = null;

        static {
            f10047a = new a(null);
        }
    }

    static {
    }

    private a() {
        this.f10043b = true;
        this.f10044c = new RunnableC0214a(this);
        this.f10045d = new CopyOnWriteArraySet();
        c r10 = new c("AsyncEventManager-Thread");
        this.f10042a = r10;
        r10.l();
    }

    /* synthetic */ a(RunnableC0214a r10) {
        this();
    }

    static /* synthetic */ boolean a(a r10) {
        return r10.f10043b;
    }

    static /* synthetic */ long b() {
        return f10041e;
    }

    static /* synthetic */ c c(a r10) {
        return r10.f10042a;
    }

    public static a e() {
        return b.f10047a;
    }

    public void d(k3.b r10) {
        if (r10 == null) goto L10;
        this.f10045d.add(r10);     // Catch: Throwable -> L7
        if (this.f10043b == false) goto L11;
        this.f10042a.i(this.f10044c);     // Catch: Throwable -> L7
        this.f10042a.h(this.f10044c, f10041e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void f(Runnable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f10042a.g(r10);
    }

    public void g(Runnable r10, long r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f10042a.h(r10, r11);
    }
}
