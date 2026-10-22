package org.apache.poi.hwpf.util;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class DoubleByteUtil {
    public static final Charset BIG5 = null;
    public static final Set<Charset> DOUBLE_BYTE_CHARSETS = null;

    static {
        Charset r0 = Charset.forName("Big5");
        BIG5 = r0;
        DOUBLE_BYTE_CHARSETS = Collections.singleton(r0);
    }

    public static String cp950ToString(byte[] r2, int r3, int r4) {
        StringBuilder r0 = new StringBuilder();
        LittleEndianCP950Reader r1 = new LittleEndianCP950Reader(r2, r3, r4);
    L21:
        int r5 = r1.read();     // Catch: Throwable -> L9
        if (r5 == (-1)) goto L7;
        r0.append((char) r5);     // Catch: Throwable -> L9
        goto L21
    L7:
        r1.close();
        return r0.toString();
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }
}
