package xb;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f13771b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f13772m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ b[] f13773n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13774a;

    static {
        b r8 = new b("MONTHS", 0, 6);
        f13771b = r8;
        b r10 = new b("WEEKS", 1, 1);
        f13772m = r10;
        f13773n = new b[]{r8, r10};
    }

    public b(String r8, int r10, int r11) {
        super(r8, r10);
        this.f13774a = r11;
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f13773n.clone();
    }
}
