package com.ss.ugc.live.sdk.msg.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static byte[] a(byte[] r7) throws Exception {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r7);
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        GZIPInputStream r1 = new GZIPInputStream(r0);
        byte[] r3 = new byte[4096];
    L3:
        int r5 = r1.read(r3, 0, 4096);
        if (r5 == (-1)) goto L6;
        r8.write(r3, 0, r5);
        goto L3
    L6:
        r1.close();
        byte[] r2 = r8.toByteArray();
        r8.flush();
        r8.close();
        r0.close();
        return r2;
    }
}
