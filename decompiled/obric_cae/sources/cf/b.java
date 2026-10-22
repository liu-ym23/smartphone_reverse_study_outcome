package cf;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3450b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f3451m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f3452n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f3453o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f3454p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f3455q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ b[] f3456r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3457a;

    static {
        b r8 = new b("NO_ERROR", 0, 0);
        f3450b = r8;
        b r10 = new b("PROTOCOL_ERROR", 1, 1);
        f3451m = r10;
        b r11 = new b("INTERNAL_ERROR", 2, 2);
        f3452n = r11;
        b r12 = new b("FLOW_CONTROL_ERROR", 3, 3);
        f3453o = r12;
        b r13 = new b("REFUSED_STREAM", 4, 7);
        f3454p = r13;
        b r14 = new b("CANCEL", 5, 8);
        f3455q = r14;
        f3456r = new b[]{r8, r10, r11, r12, r13, r14, new b("COMPRESSION_ERROR", 6, 9), new b("CONNECT_ERROR", 7, 10), new b("ENHANCE_YOUR_CALM", 8, 11), new b("INADEQUATE_SECURITY", 9, 12), new b("HTTP_1_1_REQUIRED", 10, 13)};
    }

    public b(String r8, int r10, int r11) {
        super(r8, r10);
        this.f3457a = r11;
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f3456r.clone();
    }
}
