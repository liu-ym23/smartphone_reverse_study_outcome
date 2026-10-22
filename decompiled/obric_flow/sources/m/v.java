package m;

/* JADX INFO: loaded from: classes3.dex */
public final enum v extends Enum<v> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f19932b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f19933c = null;
    public static final v d = null;
    public static final v e = null;
    public static final v f = null;
    public static final v g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f19934h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f19935i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ v[] f19936j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19937a;

    static {
        v r5 = new v("day_break", 0, 3);
        f19932b = r5;
        v r10 = new v("early_morning", 1, 8);
        f19933c = r10;
        v r11 = new v("morning", 2, 10);
        d = r11;
        v r12 = new v("noon", 3, 12);
        e = r12;
        v r13 = new v("afternoon", 4, 15);
        f = r13;
        v r14 = new v("night", 5, 18);
        g = r14;
        v r15 = new v("lateNight", 6, 20);
        f19934h = r15;
        v r16 = new v("midNight", 7, 23);
        f19935i = r16;
        f19936j = new v[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public v(String r5, int r10, int r11) {
        super(r5, r10);
        this.f19937a = r11;
    }

    public static v valueOf(String r5) {
        return (v) Enum.valueOf(v.class, r5);
    }

    public static v[] values() {
        return (v[]) f19936j.clone();
    }

    public int b() {
        return this.f19937a;
    }
}
