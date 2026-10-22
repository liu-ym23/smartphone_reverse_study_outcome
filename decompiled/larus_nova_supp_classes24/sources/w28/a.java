package w28;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static char[] a(byte[] r8) {
        char[] r0 = a;
        int r1 = r8.length;
        char[] r2 = new char[r1 << 1];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L5;
        int r5 = r4 + 1;
        byte r6 = r8[r3];
        r2[r4] = r0[(r6 & 240) >>> 4];
        r4 = r5 + 1;
        r2[r5] = r0[r6 & 15];
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }
}
