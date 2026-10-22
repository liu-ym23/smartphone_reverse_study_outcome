package com.lynx.tasm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static byte[] a(InputStream r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        byte[] r3 = new byte[4096];
    L13:
        int r5 = r7.read(r3, 0, 4096);     // Catch: IOException -> L12
        if (r5 == (-1)) goto L10;
        r1.write(r3, 0, r5);     // Catch: IOException -> L12
        goto L13
    L10:
        return r1.toByteArray();
    L12:
        return null;
    }
}
