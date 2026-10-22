package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class Streams {
    private static int BUFFER_SIZE = 4096;

    static {
    }

    public static void pipeAll(InputStream r1, OutputStream r2) {
        pipeAll(r1, r2, BUFFER_SIZE);
    }

    public static void pipeAll(InputStream r3, OutputStream r4, int r5) {
        byte[] r0 = new byte[r5];
    L3:
        int r2 = r3.read(r0, 0, r5);
        if (r2 < 0) goto L6;
        r4.write(r0, 0, r2);
        goto L3
    }

    public static byte[] readAll(InputStream r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        pipeAll(r1, r0);
        return r0.toByteArray();
    }

    public static int readFully(InputStream r3, byte[] r4, int r5, int r6) {
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L8;
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 < 0) goto L8;
        r0 = r0 + r1;
    L8:
        return r0;
    }
}
