package knc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final ThreadLocal<a> a = null;

    public static class a {
        public String a;
        public String b;
        public int c;

        public a() {
        }
    }

    static {
        a = new ThreadLocal();
    }
}
