package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f10625a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t0 f10626b = null;

    static {
        f10625a = kotlinx.coroutines.internal.j0.f("kotlinx.coroutines.main.delay", false);
        f10626b = b();
    }

    public static final t0 a() {
        return f10626b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final t0 b() {
        if (f10625a == false) goto L5;
        g2 r10 = z0.c();
        if (kotlinx.coroutines.internal.z.c(r10) == true) goto L13;
        if ((r10 instanceof t0) == false) goto L13;
        return (t0) r10;
    L13:
        return p0.f10623l;
    L5:
        return p0.f10623l;
    }
}
