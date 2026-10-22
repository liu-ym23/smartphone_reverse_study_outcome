package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class n {
    public static r c;
    public Thread.UncaughtExceptionHandler a;
    public boolean b;

    public n() {
        this.b = true;
    }

    public static void a(Throwable r2, String r3, String r4) {
        r r0 = c;
        if (r0 == null) goto L6;
        r0.c(r2, 1, r3, r4);
        return;
    }
}
