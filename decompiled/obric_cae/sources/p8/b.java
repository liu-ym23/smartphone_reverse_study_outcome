package p8;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f9949b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m8.b f9950a;

    public b() {
    }

    public static b a() {
        if (f9949b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9949b != null) goto L9;
        f9949b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f9949b;
    }
}
