package p2;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f9933b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a3.a f9934a;

    public a() {
        this.f9934a = new a3.a(0);
    }

    public static a a() {
        if (f9933b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9933b != null) goto L9;
        f9933b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9933b;
    }
}
