package d52;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a extends d52.c {

    /* JADX INFO: renamed from: d52.a$a, reason: collision with other inner class name */
    public static final class C0224a extends a {
        public static final int a = 0;
        public static final C0224a b = null;

        static {
            b = new C0224a();
            a = 1;
        }

        public C0224a() {
        }

        @Override // d52.c
        public final int a() {
            return a;
        }
    }

    public static final class b extends a {
        public static final int a = 0;
        public static final b b = null;

        static {
            b = new b();
            a = 2;
        }

        public b() {
        }

        @Override // d52.c
        public final int a() {
            return a;
        }
    }

    public static final class c extends a {
        public static final c a = null;

        @Override // d52.c
        public final int a() {
            return 0;
        }

        static {
            a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
