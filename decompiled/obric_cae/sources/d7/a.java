package d7;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6836b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f6837m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ a[] f6838n = null;

    static {
        a r8 = new a("ADDRESS_FAMILY_UNSPECIFIED", 0);
        f6835a = r8;
        a r10 = new a("ADDRESS_FAMILY_IPV4", 1);
        f6836b = r10;
        a r11 = new a("ADDRESS_FAMILY_IPV6", 2);
        f6837m = r11;
        f6838n = new a[]{r8, r10, r11};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f6838n.clone();
    }
}
