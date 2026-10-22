package ha;

/* JADX INFO: loaded from: classes.dex */
public abstract enum z extends Enum<z> implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8013b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ z[] f8014m = null;

    public final enum a extends z {
        public a() {
            super("DOUBLE", 0);
        }

        @Override // ha.a0
        public final Number a(pa.a r8) {
            return Double.valueOf(r8.G());
        }
    }

    public final enum b extends z {
        public b() {
            super("LAZILY_PARSED_NUMBER", 1);
        }

        @Override // ha.a0
        public final Number a(pa.a r8) {
            return new ja.r(r8.e0());
        }
    }

    static {
        a r8 = new a();
        f8012a = r8;
        b r10 = new b();
        f8013b = r10;
        f8014m = new z[]{r8, r10, new c(), new d()};
    }

    public z() {
        throw null;
    }

    public z(String r8, int r10) {
        super(r8, r10);
    }

    public static z valueOf(String r8) {
        return (z) Enum.valueOf(z.class, r8);
    }

    public static z[] values() {
        return (z[]) f8014m.clone();
    }
}
