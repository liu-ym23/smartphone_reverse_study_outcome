package k5;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Object f8951a;

    public m() {
    }

    public static Object a() {
        if (f8951a != null) goto L18;
        monitor-enter(m.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f8951a == null) goto L19;
    L12:
        monitor-exit(m.class);     // Catch: Throwable -> L14
        goto L18
    L19:
        f8951a = Class.forName("android.os.SystemProperties").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return f8951a;
    }
}
