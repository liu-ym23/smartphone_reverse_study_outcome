package c8;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f3410e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3411f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f3412g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d8.b f3413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d8.b f3414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile d8.b f3415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f3416d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f3417a = null;

        static {
            f3417a = new d();
        }
    }

    static {
        f3410e = new Object();
        f3411f = new Object();
        f3412g = new Object();
    }

    public d() {
        this.f3416d = new ConcurrentHashMap(3);
    }

    public final d8.b a(g r8) {
        e r10 = r8.A();
        if (r10 != e.f3418a) goto L19;
        if (this.f3413a != null) goto L17;
        Object r11 = f3410e;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f3413a != null) goto L11;
        b();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
    L17:
        return this.f3413a;
    L19:
        if (r10 != e.f3419b) goto L35;
        if (this.f3415c != null) goto L33;
        Object r12 = f3412g;
        monitor-enter(r12);
    L29:
        th = move-exception;
        throw th;
    L25:
        if (this.f3415c != null) goto L27;
        d();     // Catch: Throwable -> L29
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L29
    L33:
        return this.f3415c;
    L35:
        if (this.f3414b != null) goto L47;
        Object r13 = f3411f;
        monitor-enter(r13);
    L43:
        th = move-exception;
        throw th;
    L39:
        if (this.f3414b != null) goto L41;
        c();     // Catch: Throwable -> L43
    L41:
        monitor-exit(r13);     // Catch: Throwable -> L43
    L47:
        return this.f3414b;
    }

    public final void b() {
        Object r8 = f3410e;
        monitor-enter(r8);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3413a != null) goto L7;
        d8.a r10 = new d8.a("io-task");     // Catch: Throwable -> L9
        r10.f6954b = new c8.a(this);     // Catch: Throwable -> L9
        this.f3413a = new d8.b(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
    }

    public final void c() {
        Object r8 = f3411f;
        monitor-enter(r8);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3414b != null) goto L7;
        d8.a r10 = new d8.a("light-weight-task");     // Catch: Throwable -> L9
        r10.f6954b = new b(this);     // Catch: Throwable -> L9
        this.f3414b = new d8.b(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
    }

    public final void d() {
        Object r8 = f3412g;
        monitor-enter(r8);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3415c != null) goto L7;
        d8.a r10 = new d8.a("time-sensitive-task");     // Catch: Throwable -> L9
        r10.f6954b = new c(this);     // Catch: Throwable -> L9
        this.f3415c = new d8.b(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
    }

    public final void e(g r8) {
        a(r8).a(r8);     // Catch: Throwable -> L4
        return;
    }

    public final void f(g r8, long r10) {
        if (r8 != null) goto L7;
        return;
    L7:
        a(r8).i(r8, r10);     // Catch: Throwable -> L6
        return;
    }

    public final void g(b3.b.a r8) {
        a(r8).n(r8);     // Catch: Throwable -> L4
        return;
    }
}
