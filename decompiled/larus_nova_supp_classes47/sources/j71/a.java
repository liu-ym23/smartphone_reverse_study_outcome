package j71;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: j71.a$a, reason: collision with other inner class name */
    public static final class C0256a extends a {
        public static final C0256a b = null;

        static {
            b = new C0256a();
        }

        public C0256a() {
            super("dismiss");
        }
    }

    public static final class b extends a {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("hide");
        }
    }

    public static final class c extends a {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("无效指令");
        }
    }

    public static final class d extends a {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("show");
        }
    }

    public static final class e extends a {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("suspend");
        }
    }

    public static final class f extends a {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super("show");
        }
    }

    public final String toString() {
        return String.valueOf(this.a);
    }

    public a(String r1) {
        this.a = r1;
    }
}
