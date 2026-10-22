package q11;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c {
    public final String a;

    public static final class a extends c {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("BEINVITING");
        }
    }

    public static final class b extends c {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("DISABLE");
        }
    }

    /* JADX INFO: renamed from: q11.c$c, reason: collision with other inner class name */
    public static final class C0296c extends c {
        public static final C0296c b = null;

        static {
            b = new C0296c();
        }

        public C0296c() {
            super("INVITING");
        }
    }

    public static final class d extends c {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("SUCCESS");
        }
    }

    public c(String r1) {
        this.a = r1;
    }
}
