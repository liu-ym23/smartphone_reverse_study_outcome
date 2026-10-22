package apa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static volatile b a;

    public static void a(String r1, String r2) {
        if (a != null) goto L5;
        return;
    L5:
        a.d(r1, r2);
    }

    public static void b(String r1, String r2) {
        if (a != null) goto L5;
        return;
    L5:
        a.e(r1, r2);
    }

    public static void c(String r1, String r2, Throwable r3) {
        if (a != null) goto L5;
        return;
    L5:
        a.e(r1, r2, r3);
    }
}
