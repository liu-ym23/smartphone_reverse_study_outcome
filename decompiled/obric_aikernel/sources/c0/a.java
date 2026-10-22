package c0;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private r0.c.a f575b;

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0027a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f576a = null;

        static {
            f576a = new a(null);
        }

        static /* synthetic */ a a() {
            return f576a;
        }
    }

    private a() {
    }

    /* synthetic */ a(C0027a r10) {
        this();
    }

    public static a b() {
        return b.a();
    }

    public synchronized c a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f574a != null) goto L6;
        this.f574a = new c.a().a();     // Catch: Throwable -> L9
    L6:
        c r10 = this.f574a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }

    public synchronized r0.c.a c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f575b != null) goto L6;
        this.f575b = new r0.c.a.C0286a().e();     // Catch: Throwable -> L9
    L6:
        r0.c.a r10 = this.f575b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }

    public void d(String r10) {
        if (com.bytedance.apm.d.D() == false) goto L6;
        Log.d("LaunchAnalysis", r10);
        return;
    }

    public void e(String r10) {
        Log.e("LaunchAnalysis", "notice!!!+ " + r10);
    }

    public synchronized void f(c r10) {
        monitor-enter(this);
        this.f574a = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
