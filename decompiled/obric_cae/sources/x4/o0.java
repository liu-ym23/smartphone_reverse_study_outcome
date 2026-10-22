package x4;

/* JADX INFO: loaded from: classes.dex */
public final enum o0 extends Enum<o0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f13535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f13536b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ o0[] f13537m = null;

    static {
        o0 r8 = new o0("L0", 0);
        f13535a = r8;
        o0 r10 = new o0("L1", 1);
        f13536b = r10;
        f13537m = new o0[]{r8, r10};
    }

    public o0(String r8, int r10) {
        super(r8, r10);
    }

    public static o0 valueOf(String r8) {
        return (o0) Enum.valueOf(o0.class, r8);
    }

    public static o0[] values() {
        return (o0[]) f13537m.clone();
    }
}
