package y6a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public l() {
    }

    public static boolean a(float r1) {
        if (Float.compare(r1, 1.0E9f) < 0) goto L5;
    L8:
        return true;
    L5:
        if (Float.compare(r1, -1.0E9f) <= 0) goto L8;
        return false;
    }
}
