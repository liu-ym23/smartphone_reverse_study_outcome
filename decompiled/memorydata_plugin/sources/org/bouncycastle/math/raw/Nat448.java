package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat448 {
    public static void copy64(long[] r3, int r4, long[] r5, int r6) {
        r5[r6 + 0] = r3[r4 + 0];
        r5[r6 + 1] = r3[r4 + 1];
        r5[r6 + 2] = r3[r4 + 2];
        r5[r6 + 3] = r3[r4 + 3];
        r5[r6 + 4] = r3[r4 + 4];
        r5[r6 + 5] = r3[r4 + 5];
        r5[r6 + 6] = r3[r4 + 6];
    }

    public static void copy64(long[] r3, long[] r4) {
        r4[0] = r3[0];
        r4[1] = r3[1];
        r4[2] = r3[2];
        r4[3] = r3[3];
        r4[4] = r3[4];
        r4[5] = r3[5];
        r4[6] = r3[6];
    }

    public static long[] create64() {
        return new long[7];
    }

    public static long[] createExt64() {
        return new long[14];
    }

    public static boolean eq64(long[] r5, long[] r6) {
        int r0 = 6;
    L3:
        if (r0 < 0) goto L9;
        if (r5[r0] != r6[r0]) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static boolean isOne64(long[] r7) {
        if (r7[0] == 1) goto L5;
        return false;
    L5:
        int r2 = 1;
    L7:
        if (r2 >= 7) goto L12;
        if (r7[r2] != 0) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isZero64(long[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L9;
        if (r6[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static BigInteger toBigInteger64(long[] r6) {
        byte[] r0 = new byte[56];
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L10;
        long r2 = r6[r1];
        if (r2 == 0) goto L8;
        Pack.longToBigEndian(r2, r0, (6 - r1) << 3);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
