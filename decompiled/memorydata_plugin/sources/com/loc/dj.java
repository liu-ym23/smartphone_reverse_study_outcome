package com.loc;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f5439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5440b;

    static {
    }

    public static String a(byte[] r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length <= 0) goto L27;
        int r1 = 0;
    L9:
        if (r1 >= r5.length) goto L20;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() >= 2) goto L13;
        r0.append("0");
    L13:
        r0.append(r2);
        if (r6.length() <= 0) goto L18;
        if (r1 >= (r5.length - 1)) goto L18;
        r0.append(r6);
    L18:
        r1 = r1 + 1;
        goto L9
    L20:
        return r0.toString();
    L27:
        return null;
    }

    public static byte[] a(long r7) {
        byte[] r1 = new byte[6];
        int r2 = 0;
    L3:
        if (r2 >= 6) goto L5;
        r1[r2] = (byte) ((r7 >> (((6 - r2) - 1) * 8)) & 255);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
