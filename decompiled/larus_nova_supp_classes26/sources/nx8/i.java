package nx8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class i {
    public final boolean a;
    public final int b;
    public final boolean c;

    public static final class a {
    }

    public static final class b extends i {
        public static final b d = null;

        static {
            d = new b();
        }

        public b() {
            super(0, false, 7);
        }
    }

    public static final class c extends i {
        public static final c d = null;

        static {
            d = new c();
        }

        public c() {
            super(0, false, 6);
        }
    }

    public static final class d extends i {
        public static final d d = null;

        static {
            d = new d();
        }

        public d() {
            super(0, false, 7);
        }
    }

    public static final class e extends i {
        public static final e d = null;

        static {
            d = new e();
        }

        public e() {
            super(2, false, 5);
        }
    }

    public static final class f extends i {
        public static final f d = null;

        static {
            d = new f();
        }

        public f() {
            super(1, true, 1);
        }
    }

    public static final class g extends i {
        public static final g d = null;

        static {
            d = new g();
        }

        public g() {
            super(0, false, 6);
        }
    }

    static {
    }

    public i(int r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r4 = 0;
    L10:
        if ((r6 & 4) == 0) goto L12;
        r5 = false;
    L12:
        this.a = r0;
        this.b = r4;
        this.c = r5;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
