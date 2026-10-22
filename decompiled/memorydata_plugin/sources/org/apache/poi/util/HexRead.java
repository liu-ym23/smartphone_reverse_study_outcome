package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class HexRead {
    public static byte[] readData(InputStream r7, int r8) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L3:
        int r2 = 0;
        byte r3 = 0;
    L4:
        int r4 = r7.read();
        if (48 > r4) goto L10;
        if (r4 > 57) goto L10;
        int r5 = r4 - 48;
    L26:
        if (r5 == (-1)) goto L4;
        r3 = (byte) (((byte) (r3 << 4)) + ((byte) r5));
        r2 = r2 + 1;
        if (r2 != 2) goto L4;
        r0.add(Byte.valueOf(r3));
    L10:
        if (65 > r4) goto L15;
        if (r4 > 70) goto L15;
        r5 = r4 - 55;
    L15:
        if (97 > r4) goto L20;
        if (r4 > 102) goto L20;
        r5 = r4 - 87;
    L20:
        if (35 != r4) goto L22;
        readToEOL(r7);
    L25:
        r5 = -1;
        goto L26
    L22:
        if ((-1) == r4) goto L30;
        if (r8 != r4) goto L25;
    L30:
        Byte[] r9 = (Byte[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Byte[0]), Byte[].class, "com.obric.memorydata.plugin");
        byte[] r10 = new byte[r9.length];
    L32:
        if (r1 >= r9.length) goto L34;
        r10[r1] = r9[r1].byteValue();
        r1 = r1 + 1;
        goto L32
    L34:
        return r10;
    }

    public static byte[] readFromString(String r2) {
        return readData(new ByteArrayInputStream(r2.getBytes(StringUtil.UTF8)), -1);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void readToEOL(InputStream r2) {
    L2:
        int r0 = r2.read();
        if (r0 == (-1)) goto L9;
        if (r0 == 10) goto L14;
        if (r0 != 13) goto L2;
        return;
    L14:
        return;
    }
}
