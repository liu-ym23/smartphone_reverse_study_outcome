package hb;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8015b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f8016m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ a[] f8017n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8018a;

    static {
        a r8 = new a("X", 0, "x");
        a r10 = new a("Y", 1, "y");
        a r11 = new a("SCALE_X", 2, "scaleX");
        f8015b = r11;
        a r12 = new a("SCALE_Y", 3, "scaleY");
        f8016m = r12;
        f8017n = new a[]{r8, r10, r11, r12, new a("ROTATION", 4, "rotation"), new a("ROTATION_X", 5, "rotationX"), new a("ROTATION_Y", 6, "rotationY"), new a("TRANSLATION_X", 7, "translationX"), new a("TRANSLATION_Y", 8, "translationY"), new a("ALPHA", 9, "alpha")};
    }

    public a(String r8, int r10, String r11) {
        super(r8, r10);
        this.f8018a = r11;
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f8017n.clone();
    }
}
