package com.lynx.devtool.recorder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Utils {
    public Utils() {
    }

    public static byte[] inputStreamToByteArray(InputStream r6) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[1024];
    L3:
        int r4 = r6.read(r2, 0, 1024);
        if (r4 == (-1)) goto L6;
        r0.write(r2, 0, r4);
        goto L3
    L6:
        r0.flush();
        return r0.toByteArray();
    }
}
