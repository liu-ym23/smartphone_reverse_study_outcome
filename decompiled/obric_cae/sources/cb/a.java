package cb;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f3429b = null;

    static {
        a r8 = new a("NORMAL", 0);
        f3428a = r8;
        f3429b = new a[]{r8, new a("LOOP", 1), new a("REVERSE", 2)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f3429b.clone();
    }
}
