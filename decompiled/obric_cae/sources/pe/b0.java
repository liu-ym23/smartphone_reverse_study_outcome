package pe;

/* JADX INFO: loaded from: classes2.dex */
public final enum b0 extends Enum<b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f9995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b0[] f9996b = null;

    static {
        b0 r8 = new b0("DEFAULT", 0);
        f9995a = r8;
        f9996b = new b0[]{r8, new b0("LAZY", 1), new b0("ATOMIC", 2), new b0("UNDISPATCHED", 3)};
    }

    public b0(String r8, int r10) {
        super(r8, r10);
    }

    public static b0 valueOf(String r8) {
        return (b0) Enum.valueOf(b0.class, r8);
    }

    public static b0[] values() {
        return (b0[]) f9996b.clone();
    }
}
