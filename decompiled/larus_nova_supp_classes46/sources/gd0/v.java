package gd0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public static boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static int b(int r1, int r2) {
        if (a(r1, r2) == true) goto L5;
        return r1;
    L5:
        return r1 ^ r2;
    }
}
