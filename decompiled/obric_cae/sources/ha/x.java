package ha;

/* JADX INFO: loaded from: classes.dex */
public abstract enum x extends Enum<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ x[] f8006b = null;

    public final enum a extends x {
        public a() {
            super("DEFAULT", 0);
        }
    }

    static {
        a r8 = new a();
        f8005a = r8;
        f8006b = new x[]{r8, new b()};
    }

    public x() {
        throw null;
    }

    public x(String r8, int r10) {
        super(r8, r10);
    }

    public static x valueOf(String r8) {
        return (x) Enum.valueOf(x.class, r8);
    }

    public static x[] values() {
        return (x[]) f8006b.clone();
    }
}
