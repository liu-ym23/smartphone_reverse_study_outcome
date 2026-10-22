package es0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public final long a;
    public final boolean b;

    /* JADX INFO: renamed from: es0.a$a, reason: collision with other inner class name */
    public static final class C0206a extends a {
        public C0206a(long r1, boolean r3) {
            super(r1, r3);
        }
    }

    public static final class b extends a {
        public b(long r1, boolean r3) {
            super(r1, r3);
        }
    }

    public static final class c extends a {
        public static final c c = null;

        public c() {
            super(0, false);
        }

        static {
            c = new c();
        }
    }

    public static final class d extends a {
        public d(long r2) {
            super(r2, true);
        }
    }

    public a(long r1, boolean r3) {
        this.a = r1;
        this.b = r3;
    }
}
