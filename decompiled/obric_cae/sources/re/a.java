package re;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f11803b = null;

    static {
        a r8 = new a("SUSPEND", 0);
        f11802a = r8;
        f11803b = new a[]{r8, new a("DROP_OLDEST", 1), new a("DROP_LATEST", 2)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f11803b.clone();
    }
}
