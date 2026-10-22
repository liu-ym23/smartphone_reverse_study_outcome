package v6;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12736a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12737b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f12738m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f12739n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f12740o = null;

        static {
            a r8 = new a("LOW", 0);
            f12736a = r8;
            a r10 = new a("NORMAL", 1);
            f12737b = r10;
            a r11 = new a("HIGH", 2);
            f12738m = r11;
            a r12 = new a("IMMEDIATE", 3);
            f12739n = r12;
            f12740o = new a[]{r8, r10, r11, r12};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f12740o.clone();
        }
    }

    int a();

    a b();
}
