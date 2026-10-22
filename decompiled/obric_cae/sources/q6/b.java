package q6;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f10169b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m6.a f10170a;

    public b() {
    }

    public static b a() {
        if (f10169b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f10169b != null) goto L9;
        f10169b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f10169b;
    }
}
