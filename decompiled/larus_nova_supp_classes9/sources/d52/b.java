package d52;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b extends d52.c {

    public static final class a extends b {
        public static final int a = 0;
        public static final a b = null;

        static {
            b = new a();
            a = 2;
        }

        public a() {
        }

        @Override // d52.c
        public final int a() {
            return a;
        }
    }

    /* JADX INFO: renamed from: d52.b$b, reason: collision with other inner class name */
    public static final class C0225b extends b {
        public static final C0225b a = null;

        @Override // d52.c
        public final int a() {
            return 0;
        }

        static {
            a = new C0225b();
        }

        public C0225b() {
        }
    }

    public static final class c extends b {
        public static final int a = 0;
        public static final c b = null;

        static {
            b = new c();
            a = 1;
        }

        public c() {
        }

        @Override // d52.c
        public final int a() {
            return a;
        }
    }

    public b() {
    }
}
