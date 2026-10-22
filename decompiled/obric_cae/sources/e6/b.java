package e6;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7127b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f7128m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f7129n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f7130o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f7131p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ b[] f7132q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7133a;

    static {
        b r8 = new b("CONNECTION_UNKNOWN", 0, 1);
        f7127b = r8;
        b r10 = new b("CONNECTING", 1, 2);
        f7128m = r10;
        b r11 = new b("CONNECT_FAILED", 2, 4);
        f7129n = r11;
        b r12 = new b("CONNECT_CLOSED", 3, 8);
        f7130o = r12;
        b r13 = new b("CONNECTED", 4, 16);
        f7131p = r13;
        f7132q = new b[]{r8, r10, r11, r12, r13};
    }

    public b(String r8, int r10, int r11) {
        super(r8, r10);
        this.f7133a = r11;
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f7132q.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return android.aimedia.a.f(new StringBuilder("ConnectionState{State="), this.f7133a, '}');
    }
}
