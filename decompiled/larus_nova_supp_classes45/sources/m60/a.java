package m60;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static <T> int a(T... r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r1 = r6.length;
        int r2 = 1;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L12;
        T r4 = r6[r3];
        if (r4 != null) goto L10;
        int r5 = 0;
    L11:
        r2 = ((r2 << 5) - r2) ^ r5;
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = r4.hashCode();
        goto L11
    L12:
        return r2;
    }
}
