package org.apache.commons.compress.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class ByteUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = null;

    public interface ByteSupplier {
        int getAsByte();
    }

    static {
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    private static void checkReadLength(int r1) {
        if (r1 > 8) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
    }

    public static long fromLittleEndian(ByteSupplier r7, int r8) {
        ByteSupplier r9 = (ByteSupplier) ZeusTransformUtils.wrapperContextForParams(r7, ByteSupplier.class, "com.obric.memorydata.plugin");
        checkReadLength(r8);
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L9;
        long r3 = r9.getAsByte();
        if (r3 == (-1)) goto L8;
        r0 = r0 | (r3 << (r2 * 8));
        r2 = r2 + 1;
        goto L3
    L8:
        throw new IOException("Premature end of data");
    L9:
        return r0;
    }

    public static long fromLittleEndian(byte[] r7, int r8, int r9) {
        checkReadLength(r9);
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L5;
        r0 = r0 | ((((long) r7[r8 + r2]) & 255) << (r2 * 8));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static void toLittleEndian(OutputStream r3, long r4, int r6) {
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r3.write((int) (255 & r4));
        r4 = r4 >> 8;
        r0 = r0 + 1;
        goto L3
    }

    public static void toLittleEndian(byte[] r4, long r5, int r7, int r8) {
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L5;
        r4[r7 + r0] = (byte) (255 & r5);
        r5 = r5 >> 8;
        r0 = r0 + 1;
        goto L3
    }
}
