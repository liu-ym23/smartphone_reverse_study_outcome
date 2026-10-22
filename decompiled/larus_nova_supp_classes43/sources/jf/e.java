package jf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class e {
    public final int a;

    public static final class a extends e {
        public a(int r1) {
            super(r1);
        }
    }

    public static final class b extends e {
        public static final b b = null;

        public b() {
            super(4);
        }

        static {
            b = new b();
        }
    }

    public static final class c extends e {
        public static final c b = null;

        public c() {
            super(1);
        }

        static {
            b = new c();
        }
    }

    public static final class d extends e {
        public static final d b = null;

        public d() {
            super(2);
        }

        static {
            b = new d();
        }
    }

    /* JADX INFO: renamed from: jf.e$e, reason: collision with other inner class name */
    public static final class C0171e extends e {
        public static final C0171e b = null;

        public C0171e() {
            super(3);
        }

        static {
            b = new C0171e();
        }
    }

    public static final class f extends e {
        public static final f b = null;

        public f() {
            super(5);
        }

        static {
            b = new f();
        }
    }

    public static final class g extends e {
        public static final g b = null;

        public g() {
            super(-1);
        }

        static {
            b = new g();
        }
    }

    public e(int r1) {
        this.a = r1;
    }
}
