package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f10009a = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int r8 = ue.v.f12626a;
        String r10 = System.getProperty("kotlinx.coroutines.main.delay");     // Catch: SecurityException -> L5
    L6:
        if (r10 == null) goto L8;
        boolean r11 = Boolean.parseBoolean(r10);
    L9:
        if (r11 == false) goto L13;
        ve.c r12 = n0.f10048a;
        l1 r13 = ue.p.f12623a;
        r13.t0();
        if ((r13 instanceof i0) == false) goto L13;
        i0 r14 = (i0) r13;
    L15:
        f10009a = r14;
        return;
    L13:
        r14 = e0.f10005t;
        goto L15
    L8:
        r11 = false;
    L5:
        r10 = null;
        goto L6
    }
}
