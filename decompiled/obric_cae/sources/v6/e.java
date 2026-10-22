package v6;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f12749a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f12750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f12751c;

    public e() {
        if (f12750b != null) goto L6;
        f.a r8 = new f.a();
        r8.f12760a = 8;
        r8.f12762c = 8;
        r8.f12761b = 8;
        r8.f12763d = 8;
        r8.f12764e = 30;
        r8.f12766g = 10;
        r8.f12765f = 10;
        r8.f12767h = true;
        f12750b = new f(r8);
        return;
    }

    public static synchronized f a() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f12750b != null) goto L7;
        f.a r8 = new f.a();     // Catch: Throwable -> L10
        r8.f12760a = 8;     // Catch: Throwable -> L10
        r8.f12762c = 8;     // Catch: Throwable -> L10
        r8.f12761b = 8;     // Catch: Throwable -> L10
        r8.f12763d = 8;     // Catch: Throwable -> L10
        r8.f12764e = 30;     // Catch: Throwable -> L10
        r8.f12766g = 10;     // Catch: Throwable -> L10
        r8.f12765f = 10;     // Catch: Throwable -> L10
        r8.f12767h = true;     // Catch: Throwable -> L10
        f12750b = new f(r8);     // Catch: Throwable -> L10
    L7:
        f r10 = f12750b;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r10;
    }
}
