package cmb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static volatile com.ss.android.lark.integrator.ccm.spacekit.b a;

    public f() {
    }

    public static com.ss.android.lark.integrator.ccm.spacekit.b a() {
        if (a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new com.ss.android.lark.integrator.ccm.spacekit.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }
}
