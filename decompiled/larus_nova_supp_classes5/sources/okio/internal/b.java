package okio.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final int a(char r4) {
        boolean r0 = false;
        if ('0' <= r4) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L28;
        char r2 = 'a';
        if ('a' <= r4) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L25;
        r2 = 'A';
        if ('A' <= r4) goto L21;
    L23:
        if (r0 == true) goto L25;
        throw new IllegalArgumentException("Unexpected hex digit: " + r4);
    L21:
        if (r4 >= 'G') goto L23;
        r0 = true;
    L25:
        return (r4 - r2) + 10;
    L13:
        if (r4 >= 'g') goto L15;
        r5 = true;
        goto L16
    L28:
        return r4 - '0';
    L5:
        if (r4 >= ':') goto L7;
        r3 = true;
        goto L8
    }
}
