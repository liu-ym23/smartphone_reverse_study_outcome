package au1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: au1.a$a, reason: collision with other inner class name */
    public static final class C0001a extends a {
        public static final C0001a b = null;

        static {
            b = new C0001a();
        }

        public C0001a() {
            super("onHide");
        }
    }

    public static final class b extends a {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("onLoad");
        }
    }

    public static final class c extends a {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("onShow");
        }
    }

    public a(String r1) {
        this.a = r1;
    }
}
