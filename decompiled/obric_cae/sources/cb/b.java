package cb;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3430a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f3431b = null;

    static {
        b r8 = new b("PARALLEL", 0);
        f3430a = r8;
        f3431b = new b[]{r8, new b("SERIAL", 1)};
    }

    public b(String r8, int r10) {
        super(r8, r10);
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f3431b.clone();
    }
}
