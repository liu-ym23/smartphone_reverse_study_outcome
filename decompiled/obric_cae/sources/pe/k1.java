package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b9.a f10033a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b9.a f10034b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b9.a f10035c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b9.a f10036d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b9.a f10037e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r0 f10038f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r0 f10039g = null;

    static {
        f10033a = new b9.a("COMPLETING_ALREADY", 4);
        f10034b = new b9.a("COMPLETING_WAITING_CHILDREN", 4);
        f10035c = new b9.a("COMPLETING_RETRY", 4);
        f10036d = new b9.a("TOO_LATE_TO_CANCEL", 4);
        f10037e = new b9.a("SEALED", 4);
        f10038f = new r0(false);
        f10039g = new r0(true);
    }

    public static final Object a(Object r8) {
        if ((r8 instanceof a1) == false) goto L5;
        a1 r10 = (a1) r8;
    L6:
        if (r10 == null) goto L12;
        z0 r11 = r10.f9992a;
        if (r11 != null) goto L11;
        return r8;
    L11:
        return r11;
    L12:
        return r8;
    L5:
        r10 = null;
        goto L6
    }
}
