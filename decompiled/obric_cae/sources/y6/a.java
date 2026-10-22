package y6;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile EnumC0198a f14000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile EnumC0198a f14001b;

    /* JADX INFO: renamed from: y6.a$a, reason: collision with other inner class name */
    public static final enum EnumC0198a extends Enum<EnumC0198a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0198a f14002b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0198a f14003m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0198a f14004n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final EnumC0198a f14005o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final EnumC0198a f14006p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final EnumC0198a f14007q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ EnumC0198a[] f14008r = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14009a;

        static {
            EnumC0198a r8 = new EnumC0198a("NormalStart", 0, -1);
            f14002b = r8;
            EnumC0198a r10 = new EnumC0198a("ColdStart", 1, 0);
            f14003m = r10;
            EnumC0198a r11 = new EnumC0198a("HotStart", 2, 1);
            f14004n = r11;
            EnumC0198a r12 = new EnumC0198a("WarmStart", 3, 2);
            f14005o = r12;
            EnumC0198a r13 = new EnumC0198a("WeakNet", 4, 3);
            f14006p = r13;
            EnumC0198a r14 = new EnumC0198a("Default", 5, 4);
            f14007q = r14;
            f14008r = new EnumC0198a[]{r8, r10, r11, r12, r13, r14};
        }

        public EnumC0198a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f14009a = r11;
        }

        public static EnumC0198a valueOf(String r8) {
            return (EnumC0198a) Enum.valueOf(EnumC0198a.class, r8);
        }

        public static EnumC0198a[] values() {
            return (EnumC0198a[]) f14008r.clone();
        }
    }

    static {
        f14000a = EnumC0198a.f14002b;
        f14001b = EnumC0198a.f14007q;
    }
}
