package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b extends o {
    public final String a;

    public static final class a extends b {
        public static final String b = null;
        public static final a c = null;

        static {
            c = new a();
            b = "ClearScreen";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    /* JADX INFO: renamed from: cc2.b$b, reason: collision with other inner class name */
    public static final class C0010b extends b {
        public static final String b = null;
        public static final C0010b c = null;

        static {
            c = new C0010b();
            b = "MultiAnchor";
        }

        public C0010b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class c extends b {
        public static final String b = null;
        public static final c c = null;

        static {
            c = new c();
            b = "PK";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public b() {
        this.a = "AudienceShadowView";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}
