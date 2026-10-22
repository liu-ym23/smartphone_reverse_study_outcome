package org.apache.xmlbeans.impl.util;

/* JADX INFO: loaded from: classes7.dex */
public final class HexBin {
    private static final byte[] hexNumberTable = null;
    private static final byte[] lookUpHexAlphabet = null;

    static {
        hexNumberTable = new byte[255];
        lookUpHexAlphabet = new byte[16];
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= 255) goto L5;
        hexNumberTable[r2] = -1;
        r2 = r2 + 1;
        goto L3
    L5:
        int r0 = 57;
    L7:
        if (r0 < 48) goto L9;
        hexNumberTable[r0] = (byte) (r0 - 48);
        r0 = r0 - 1;
        goto L7
    L9:
        int r3 = 70;
    L11:
        if (r3 < 65) goto L13;
        hexNumberTable[r3] = (byte) ((r3 - 65) + 10);
        r3 = r3 - 1;
        goto L11
    L13:
        int r4 = 102;
    L15:
        if (r4 < 97) goto L17;
        hexNumberTable[r4] = (byte) ((r4 - 97) + 10);
        r4 = r4 - 1;
    L17:
        if (r1 >= 10) goto L19;
        lookUpHexAlphabet[r1] = (byte) (r1 + 48);
        r1 = r1 + 1;
        goto L17
    L19:
        int r5 = 10;
    L21:
        if (r5 > 15) goto L23;
        lookUpHexAlphabet[r5] = (byte) ((r5 + 65) - 10);
        r5 = r5 + 1;
        goto L21
    }

    public static byte[] decode(byte[] r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        int r1 = r7.length;
        if ((r1 % 2) == 0) goto L8;
        return null;
    L8:
        int r2 = r1 / 2;
        byte[] r3 = new byte[r2];
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L17;
        int r5 = r4 * 2;
        if (isHex(r7[r5]) == false) goto L16;
        int r6 = r5 + 1;
        if (isHex(r7[r6]) == false) goto L16;
        byte[] r8 = hexNumberTable;
        r3[r4] = (byte) ((r8[r7[r5]] << 4) | r8[r7[r6]]);
        r4 = r4 + 1;
    L16:
        return null;
    L17:
        return r3;
    }

    public static byte[] encode(byte[] r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r0 = r6.length;
        byte[] r1 = new byte[r0 * 2];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        byte[] r4 = lookUpHexAlphabet;
        r1[r3] = r4[(r6[r2] >> 4) & 15];
        r1[r3 + 1] = r4[r6[r2] & 15];
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }

    static boolean isHex(byte r1) {
        if (hexNumberTable[r1] == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
