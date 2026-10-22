package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f2932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f2933b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final n f2934m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n f2935n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n f2936o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final n f2937p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ n[] f2938q = null;

    static {
        n r8 = new n("NOT_REQUIRED", 0);
        f2932a = r8;
        n r10 = new n("CONNECTED", 1);
        f2933b = r10;
        n r11 = new n("UNMETERED", 2);
        f2934m = r11;
        n r12 = new n("NOT_ROAMING", 3);
        f2935n = r12;
        n r13 = new n("METERED", 4);
        f2936o = r13;
        n r14 = new n("TEMPORARILY_UNMETERED", 5);
        f2937p = r14;
        f2938q = new n[]{r8, r10, r11, r12, r13, r14};
    }

    public n(String r8, int r10) {
        super(r8, r10);
    }

    public static n valueOf(String r8) {
        return (n) Enum.valueOf(n.class, r8);
    }

    public static n[] values() {
        return (n[]) f2938q.clone();
    }
}
