package d7;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f6839b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f6840m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f6841n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f6842o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f6843p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f6844q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ b[] f6845r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6846a;

    static {
        b r8 = new b("CONNECTION_INFO_UNKNOWN", 0, 0);
        f6839b = r8;
        b r10 = new b("CONNECTION_INFO_HTTP1_1", 1, 1);
        f6840m = r10;
        b r11 = new b("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        f6841n = r11;
        b r12 = new b("CONNECTION_INFO_HTTP2", 3, 4);
        f6842o = r12;
        b r13 = new b("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        f6843p = r13;
        b r14 = new b("CONNECTION_INFO_HTTP1_0", 5, 9);
        f6844q = r14;
        f6845r = new b[]{r8, r10, r11, r12, r13, r14};
    }

    public b(String r8, int r10, int r11) {
        super(r8, r10);
        this.f6846a = r11;
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f6845r.clone();
    }
}
