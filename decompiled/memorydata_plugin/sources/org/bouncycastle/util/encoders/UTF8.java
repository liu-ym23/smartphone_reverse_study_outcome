package org.bouncycastle.util.encoders;

import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: loaded from: classes7.dex */
public class UTF8 {
    private static final short[] firstUnitTable = null;
    private static final byte[] transitionTable = null;

    static {
        firstUnitTable = new short[128];
        byte[] r2 = new byte[112];
        transitionTable = r2;
        byte[] r3 = new byte[128];
        int r4 = 0;
        fill(r3, 0, 15, (byte) 1);
        fill(r3, 16, 31, (byte) 2);
        fill(r3, 32, 63, (byte) 3);
        fill(r3, 64, 65, (byte) 0);
        fill(r3, 66, 95, (byte) 4);
        fill(r3, 96, 96, (byte) 5);
        fill(r3, 97, 108, (byte) 6);
        fill(r3, 109, 109, (byte) 7);
        fill(r3, 110, 111, (byte) 6);
        fill(r3, 112, 112, (byte) 8);
        fill(r3, 113, 115, (byte) 9);
        fill(r3, 116, 116, (byte) 10);
        fill(r3, 117, 127, (byte) 0);
        fill(r2, 0, r2.length - 1, (byte) -2);
        fill(r2, 8, 11, (byte) -1);
        fill(r2, 24, 27, (byte) 0);
        fill(r2, 40, 43, (byte) 16);
        fill(r2, 58, 59, (byte) 0);
        fill(r2, 72, 73, (byte) 0);
        fill(r2, 89, 91, (byte) 16);
        fill(r2, 104, 104, (byte) 16);
        byte[] r5 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] r1 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
    L3:
        if (r4 >= 128) goto L5;
        byte r6 = r3[r4];
        int r7 = r5[r6] & r4;
        byte r8 = r1[r6];
        firstUnitTable[r4] = (short) (r8 | (r7 << 8));
        r4 = r4 + 1;
        goto L3
    }

    private static void fill(byte[] r0, int r1, int r2, byte r3) {
    L2:
        if (r1 > r2) goto L4;
        r0[r1] = r3;
        r1 = r1 + 1;
        goto L2
    }

    public static int transcodeToUTF16(byte[] r6, int r7, int r8, char[] r9) {
        int r10 = r8 + r7;
        int r0 = 0;
    L3:
        if (r7 >= r10) goto L30;
        int r1 = r7 + 1;
        byte r11 = r6[r7];
        if (r11 >= 0) goto L7;
        short r12 = firstUnitTable[r11 & ByteCompanionObject.MAX_VALUE];
        int r3 = r12 >>> 8;
        byte r13 = (byte) r12;
    L11:
        if (r13 < 0) goto L17;
        if (r1 >= r6.length) goto L14;
        int r4 = r1 + 1;
        byte r2 = r6[r1];
        r3 = (r3 << 6) | (r2 & Utf8.REPLACEMENT_BYTE);
        r13 = transitionTable[r13 + ((r2 & 255) >>> 4)];
        r1 = r4;
        goto L11
    L14:
        return -1;
    L17:
        if (r13 == (-2)) goto L18;
        if (r3 > 65535) goto L26;
        if (r0 >= r9.length) goto L23;
        r9[r0] = (char) r3;
        r0 = r0 + 1;
    L29:
        r7 = r1;
        goto L3
    L23:
        return -1;
    L26:
        if (r0 >= (r9.length - 1)) goto L27;
        int r14 = r0 + 1;
        r9[r0] = (char) ((r3 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        r0 = r14 + 1;
        r9[r14] = (char) (56320 | (r3 & 1023));
        goto L29
    L27:
        return -1;
    L18:
        return -1;
    L7:
        if (r0 >= r9.length) goto L8;
        r9[r0] = (char) r11;
        r7 = r1;
        r0 = r0 + 1;
        goto L3
    L8:
        return -1;
    L30:
        return r0;
    }

    public static int transcodeToUTF16(byte[] r2, char[] r3) {
        return transcodeToUTF16(r2, 0, r2.length, r3);
    }
}
