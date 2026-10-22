package kb;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9097b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ a[] f9098m = null;

    static {
        a r8 = new a("QUADRATIC", 0);
        a r10 = new a("SKETCH", 1);
        f9096a = r10;
        a r11 = new a("FIGMA", 2);
        a r12 = new a("BASIC", 3);
        a r13 = new a("QUADRATIC_CAPSULE", 4);
        f9097b = r13;
        f9098m = new a[]{r8, r10, r11, r12, r13};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f9098m.clone();
    }
}
