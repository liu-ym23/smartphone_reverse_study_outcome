package com.larksuite.framework.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e0 {
    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        if (r6.length > 0) goto L6;
        return null;
    L6:
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L14;
        String r3 = Integer.toHexString(r6[r2] & 255);
        if (r3.length() >= 2) goto L12;
        r0.append(0);
    L12:
        r0.append(r3);
        r2 = r2 + 1;
        goto L8
    L14:
        return r0.toString();
    }

    public static final byte[] b(InputStream r5) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[100];
    L3:
        int r4 = r5.read(r2, 0, 100);
        if (r4 <= 0) goto L7;
        r0.write(r2, 0, r4);
        goto L3
    L7:
        return r0.toByteArray();
    }
}
