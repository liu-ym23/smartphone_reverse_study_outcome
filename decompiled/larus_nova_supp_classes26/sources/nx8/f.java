package nx8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class f {
    public final int a;

    public static final class a extends f {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super(2);
        }
    }

    public static final class b extends f {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super(1);
        }
    }

    public static final class c extends f {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super(0);
        }
    }

    public f(int r1) {
        this.a = r1;
    }
}
