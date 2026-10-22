package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class l extends o {
    public final String a;

    public static final class a extends l {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "Hiboard";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends l {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "Keyboard";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class c extends l {
        public static final String b = null;
        public static final c c = null;

        static {
            c = new c();
            b = "PublicScreenStretch";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public l() {
        this.a = "PortraitDanmaku";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}
