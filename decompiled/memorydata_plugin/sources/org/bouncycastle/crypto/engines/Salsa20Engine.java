package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class Salsa20Engine implements SkippingStreamCipher {
    private static final int[] TAU_SIGMA = null;
    protected static final byte[] sigma = null;
    protected static final byte[] tau = null;

    static {
        TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
        sigma = Strings.toByteArray("expand 32-byte k");
        tau = Strings.toByteArray("expand 16-byte k");
    }

    public static void salsaCore(int r33, int[] r34, int[] r35) {
        if (r34.length != 16) goto L18;
        if (r35.length != 16) goto L16;
        if ((r33 % 2) != 0) goto L14;
        boolean r2 = false;
        int r3 = r34[0];
        int r5 = r34[1];
        int r7 = r34[2];
        int r9 = r34[3];
        int r11 = r34[4];
        int r13 = r34[5];
        int r15 = r34[6];
        int r14 = 7;
        int r16 = r34[7];
        int r18 = r34[8];
        int r12 = 9;
        int r19 = r34[9];
        int r21 = r34[10];
        int r23 = r34[11];
        int r25 = r34[12];
        int r10 = 13;
        int r26 = r34[13];
        int r28 = r34[14];
        int r31 = r34[15];
        int r30 = r28;
        int r29 = r26;
        int r27 = r25;
        int r210 = r23;
        int r24 = r21;
        int r22 = r19;
        int r110 = r18;
        int r111 = r16;
        int r17 = r15;
        int r112 = r13;
        int r113 = r11;
        int r114 = r9;
        int r20 = r7;
        int r8 = r5;
        int r6 = r3;
        int r4 = r33;
    L9:
        if (r4 <= 0) goto L11;
        int r32 = Integers.rotateLeft(r6 + r27, r14) ^ r113;
        int r115 = r110 ^ Integers.rotateLeft(r32 + r6, r12);
        int r36 = r27 ^ Integers.rotateLeft(r115 + r32, r10);
        int r37 = Integers.rotateLeft(r36 + r115, 18) ^ r6;
        int r38 = r22 ^ Integers.rotateLeft(r112 + r8, r14);
        int r116 = r29 ^ Integers.rotateLeft(r38 + r112, r12);
        int r39 = r8 ^ Integers.rotateLeft(r116 + r38, r10);
        int r117 = Integers.rotateLeft(r39 + r116, 18) ^ r112;
        int r40 = r30 ^ Integers.rotateLeft(r24 + r17, 7);
        int r41 = r20 ^ Integers.rotateLeft(r40 + r24, 9);
        int r118 = r17 ^ Integers.rotateLeft(r41 + r40, 13);
        int r1 = r24 ^ Integers.rotateLeft(r118 + r41, 18);
        int r0 = r114 ^ Integers.rotateLeft(r31 + r210, 7);
        int r119 = r111 ^ Integers.rotateLeft(r0 + r31, 9);
        int r310 = r4;
        int r42 = r210 ^ Integers.rotateLeft(r119 + r0, 13);
        int r120 = r31 ^ Integers.rotateLeft(r42 + r119, 18);
        r8 = r39 ^ Integers.rotateLeft(r37 + r0, 7);
        r20 = r41 ^ Integers.rotateLeft(r8 + r37, 9);
        int r43 = r0 ^ Integers.rotateLeft(r20 + r8, 13);
        int r44 = r37 ^ Integers.rotateLeft(r43 + r20, 18);
        r17 = r118 ^ Integers.rotateLeft(r117 + r32, 7);
        r111 = r119 ^ Integers.rotateLeft(r17 + r117, 9);
        int r45 = Integers.rotateLeft(r111 + r17, 13) ^ r32;
        r112 = r117 ^ Integers.rotateLeft(r45 + r111, 18);
        r210 = r42 ^ Integers.rotateLeft(r1 + r38, 7);
        int r46 = Integers.rotateLeft(r210 + r1, 9) ^ r115;
        r22 = r38 ^ Integers.rotateLeft(r46 + r210, 13);
        r24 = r1 ^ Integers.rotateLeft(r22 + r46, 18);
        r27 = r36 ^ Integers.rotateLeft(r120 + r40, 7);
        r29 = r116 ^ Integers.rotateLeft(r27 + r120, 9);
        r30 = r40 ^ Integers.rotateLeft(r29 + r27, 13);
        r31 = r120 ^ Integers.rotateLeft(r30 + r29, 18);
        r114 = r43;
        r110 = r46;
        r6 = r44;
        r113 = r45;
        r2 = false;
        r10 = 13;
        r12 = 9;
        r14 = 7;
        r4 = r310 - 2;
        goto L9
    L11:
        boolean r47 = r2;
        r35[r47 ? 1 : 0] = r6 + r34[r47 ? 1 : 0];
        r35[1] = r8 + r34[1];
        r35[2] = r20 + r34[2];
        r35[3] = r114 + r34[3];
        r35[4] = r113 + r34[4];
        r35[5] = r112 + r34[5];
        r35[6] = r17 + r34[6];
        r35[7] = r111 + r34[7];
        r35[8] = r110 + r34[8];
        r35[9] = r22 + r34[9];
        r35[10] = r24 + r34[10];
        r35[11] = r210 + r34[11];
        r35[12] = r27 + r34[12];
        r35[13] = r29 + r34[13];
        r35[14] = r30 + r34[14];
        r35[15] = r31 + r34[15];
        return;
    L14:
        throw new IllegalArgumentException("Number of rounds must be even");
    L16:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }
}
