package hc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    public static final C0165a a = null;

    /* JADX INFO: renamed from: hc.a$a, reason: collision with other inner class name */
    public static final class C0165a implements a {
        public static final /* synthetic */ C0165a b = null;

        public C0165a() {
        }

        static {
            b = new C0165a();
        }

        @Override // hc.a
        public final b run() {
            return new b(Boolean.TRUE);
        }
    }

    public static final class b {
        public final Object a;

        public final String toString() {
            return "ExpressionResult(success=true, result=" + this.a + ')';
        }

        public b(Object r1) {
            this.a = r1;
        }
    }

    static {
        a = C0165a.b;
    }

    b run();
}
