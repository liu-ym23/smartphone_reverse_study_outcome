package com.bytedance.awemeopen.infra.base.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final char[] a = null;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r10) {
        if (r10 == null) goto L13;
        int r0 = r10.length;
        if ((0 + r0) > r10.length) goto L11;
        int r2 = r0 * 2;
        char[] r3 = new char[r2];
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r0) goto L9;
        int r6 = r10[r4 + 0] & 255;
        int r7 = r5 + 1;
        char[] r8 = a;
        r3[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r3[r7] = r8[r6 & 15];
        r4 = r4 + 1;
        goto L6
    L9:
        return new String(r3, 0, r2);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }
}
