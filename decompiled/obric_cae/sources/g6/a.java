package g6;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7693b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ a[] f7694m = null;

    static {
        a r8 = new a("STATE_FOREGROUND", 0);
        f7692a = r8;
        a r10 = new a("STATE_BACKGROUND", 1);
        f7693b = r10;
        f7694m = new a[]{r8, r10, new a("STATE_LIGHT_DOZE", 2), new a("STATE_DOZE", 3)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f7694m.clone();
    }
}
