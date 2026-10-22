package ha;

/* JADX INFO: loaded from: classes.dex */
public interface y {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8007a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8008b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f8009m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f8010n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f8011o = null;

        static {
            a r8 = new a("ALLOW", 0);
            f8007a = r8;
            a r10 = new a("INDECISIVE", 1);
            f8008b = r10;
            a r11 = new a("BLOCK_INACCESSIBLE", 2);
            f8009m = r11;
            a r12 = new a("BLOCK_ALL", 3);
            f8010n = r12;
            f8011o = new a[]{r8, r10, r11, r12};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f8011o.clone();
        }
    }

    a a();
}
