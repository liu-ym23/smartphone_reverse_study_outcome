package fx9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class b {
    public final String a;

    public static final class a extends b {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("bottom_menu");
        }
    }

    /* JADX INFO: renamed from: fx9.b$b, reason: collision with other inner class name */
    public static final class C0056b extends b {
        public static final C0056b b = null;

        static {
            b = new C0056b();
        }

        public C0056b() {
            super("ime");
        }
    }

    public static final class c extends b {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("speak");
        }
    }

    public b(String r1) {
        this.a = r1;
    }
}
