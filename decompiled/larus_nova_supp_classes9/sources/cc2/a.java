package cc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a extends o {
    public final String a;

    /* JADX INFO: renamed from: cc2.a$a, reason: collision with other inner class name */
    public static final class C0009a extends a {
        public static final String b = null;
        public static final C0009a c = null;

        static {
            c = new C0009a();
            b = "ChatChannelEvent";
        }

        public C0009a() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class b extends a {
        public static final String b = null;
        public static final b c = null;

        static {
            c = new b();
            b = "LinkMode";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public static final class c extends a {
        public static final String b = null;
        public static final c c = null;

        static {
            c = new c();
            b = "ShowAIClone";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return b;
        }
    }

    public a() {
        this.a = "ai_entrance";
    }

    @Override // cc2.o
    public final String a() {
        return this.a;
    }
}
