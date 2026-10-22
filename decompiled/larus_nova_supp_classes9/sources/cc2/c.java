package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c extends o {
    public final String a;

    public static final class a extends c {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "DanmakuHide";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends c {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "HiBoard";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    /* JADX INFO: renamed from: cc2.c$c, reason: collision with other inner class name */
    public static final class C0011c extends c {
        public static final String b = null;
        public static final C0011c c = null;

        static {
            c = new C0011c();
            b = "Keyboard";
        }

        public C0011c() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class d extends c {
        public static final String b = null;
        public static final d c = null;

        static {
            c = new d();
            b = "PublicScreenStretch";
        }

        public d() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public c() {
        this.a = "CarnivalDanmaku";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}
