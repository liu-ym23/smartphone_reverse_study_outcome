package p2;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f12315c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f12316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12317b;

    private b() {
        this.f12317b = false;
    }

    public static b b() {
        if (f12315c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12315c != null) goto L9;
        f12315c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12315c;
    }

    public a a() {
        return this.f12316a;
    }
}
