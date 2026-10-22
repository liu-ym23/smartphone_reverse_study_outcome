package c8;

/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3419b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f3420m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ e[] f3421n = null;

    static {
        e r8 = new e("IO", 0);
        f3418a = r8;
        e r10 = new e("TIME_SENSITIVE", 1);
        f3419b = r10;
        e r11 = new e("LIGHT_WEIGHT", 2);
        f3420m = r11;
        f3421n = new e[]{r8, r10, r11};
    }

    public e(String r8, int r10) {
        super(r8, r10);
    }

    public static e valueOf(String r8) {
        return (e) Enum.valueOf(e.class, r8);
    }

    public static e[] values() {
        return (e[]) f3421n.clone();
    }
}
