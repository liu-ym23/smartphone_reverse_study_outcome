package sp9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 1.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(float r1, float r2) {
        if (r1 > r2) goto L5;
    L7:
        return false;
    L5:
        if (a(r1, r2) == true) goto L7;
        return true;
    }

    public static boolean c(float r1, float r2) {
        if (r1 < r2) goto L5;
    L8:
        return true;
    L5:
        if (a(r1, r2) == true) goto L8;
        return false;
    }

    public static boolean d(float r1, float r2) {
        if (r1 < r2) goto L5;
    L7:
        return false;
    L5:
        if (a(r1, r2) == true) goto L7;
        return true;
    }

    public static boolean e(float r1, float r2) {
        if (r1 > r2) goto L5;
    L8:
        return true;
    L5:
        if (a(r1, r2) == true) goto L8;
        return false;
    }
}
