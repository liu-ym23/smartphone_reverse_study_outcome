package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f2828b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f2829m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final g f2830n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ g[] f2831o = null;

    static {
        g r8 = new g("REPLACE", 0);
        f2827a = r8;
        g r10 = new g("KEEP", 1);
        f2828b = r10;
        g r11 = new g("APPEND", 2);
        f2829m = r11;
        g r12 = new g("APPEND_OR_REPLACE", 3);
        f2830n = r12;
        f2831o = new g[]{r8, r10, r11, r12};
    }

    public g(String r8, int r10) {
        super(r8, r10);
    }

    public static g valueOf(String r8) {
        return (g) Enum.valueOf(g.class, r8);
    }

    public static g[] values() {
        return (g[]) f2831o.clone();
    }
}
