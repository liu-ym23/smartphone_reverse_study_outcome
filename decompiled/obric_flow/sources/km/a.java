package km;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f18684b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f18685a;

    public static a a() {
        if (f18684b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f18684b != null) goto L11;
        a r5 = new a();     // Catch: Throwable -> L9
        r5.f18685a = false;     // Catch: Throwable -> L9
        f18684b = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f18684b;
    }
}
