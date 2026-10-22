package cq8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a0 {
    public static long b;
    public final String a;

    public static final class a {
        public static String a() {
            long r0 = a0.b + 1;
            a0.b = r0;
            return String.valueOf(r0);
        }
    }

    static {
    }

    public abstract String a();

    public a0(String r1) {
        this.a = r1;
    }
}
