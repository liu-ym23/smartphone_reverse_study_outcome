package org.bouncycastle.crypto.generators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SCrypt {
    private static void BlockMix(int[] r6, int[] r7, int[] r8, int[] r9, int r10) {
        System.arraycopy(r6, r6.length - 16, r7, 0, 16);
        int r0 = r6.length >>> 1;
        int r11 = r10 * 2;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r11 <= 0) goto L5;
        Xor(r7, r6, r3, r8);
        Salsa20Engine.salsaCore(8, r8, r7);
        System.arraycopy(r7, 0, r9, r4, 16);
        r4 = (r0 + r3) - r4;
        r3 = r3 + 16;
        r11 = r11 - 1;
        goto L3
    }

    private static void Clear(byte[] r1) {
        if (r1 == null) goto L5;
        Arrays.fill(r1, (byte) 0);
        return;
    }

    private static void Clear(int[] r1) {
        if (r1 == null) goto L5;
        Arrays.fill(r1, 0);
        return;
    }

    private static void ClearAll(int[][] r2) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L6;
        Clear(r2[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private static byte[] MFcrypt(byte[] r7, byte[] r8, int r9, int r10, int r11, int r12) {
        int r0 = r10 * 128;
        byte[] r13 = SingleIterationPBKDF2(r7, r8, r11 * r0);
        int[] r14 = null;
        int r1 = r13.length >>> 2;     // Catch: Throwable -> L15
        r14 = new int[r1];     // Catch: Throwable -> L15
        Pack.littleEndianToInt(r13, 0, r14);     // Catch: Throwable -> L15
        int r4 = r9 * r10;     // Catch: Throwable -> L15
        int r5 = 0;
    L5:
        if ((r9 - r5) <= 2) goto L9;
        if (r4 <= 1024) goto L9;
        r5 = r5 + 1;     // Catch: Throwable -> L15
        r4 = r4 >>> 1;     // Catch: Throwable -> L15
    L9:
        int r2 = r0 >>> 2;     // Catch: Throwable -> L15
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L12;
        SMix(r14, r3, r9, r5, r10);     // Catch: Throwable -> L15
        r3 = r3 + r2;     // Catch: Throwable -> L15
        goto L10
    L12:
        Pack.intToLittleEndian(r14, r13, 0);     // Catch: Throwable -> L15
        byte[] r15 = SingleIterationPBKDF2(r7, r13, r12);     // Catch: Throwable -> L15
        Clear(r13);
        Clear(r14);
        return r15;
    L15:
        th = move-exception;
        Clear(r13);
        Clear(r14);
        throw th;
    }

    private static void SMix(int[] r19, int r20, int r21, int r22, int r23) {
        int r5 = r21 >>> r22;
        int r7 = 1 << r22;
        int r8 = r5 - 1;
        int r4 = Integers.numberOfTrailingZeros(r21) - r22;
        int r9 = r23 * 32;
        int[] r11 = new int[16];
        int[] r10 = new int[16];
        int[] r12 = new int[r9];
        int[] r13 = new int[r9];
        int[][] r14 = new int[r7][];
        System.arraycopy(r19, r20, r13, 0, r9);     // Catch: Throwable -> L15
        int r15 = 0;
    L4:
        if (r15 >= r7) goto L9;
        int[] r6 = new int[r5 * r9];     // Catch: Throwable -> L15
        r14[r15] = r6;     // Catch: Throwable -> L15
        int r17 = r7;
        int r0 = 0;
        int r16 = 0;
    L6:
        if (r16 >= r5) goto L8;
        System.arraycopy(r13, 0, r6, r0, r9);     // Catch: Throwable -> L15
        int r1 = r0 + r9;     // Catch: Throwable -> L15
        BlockMix(r13, r11, r10, r12, r23);     // Catch: Throwable -> L15
        System.arraycopy(r12, 0, r6, r1, r9);     // Catch: Throwable -> L15
        r0 = r1 + r9;     // Catch: Throwable -> L15
        BlockMix(r12, r11, r10, r13, r23);     // Catch: Throwable -> L15
        r16 = r16 + 2;     // Catch: Throwable -> L15
        r5 = r5;
        goto L6
    L8:
        r15 = r15 + 1;     // Catch: Throwable -> L15
        r7 = r17;
        goto L4
    L9:
        int r2 = r21 - 1;     // Catch: Throwable -> L15
        int r18 = 0;
    L10:
        if (r18 >= r21) goto L12;
        int r24 = r13[r9 - 16] & r2;     // Catch: Throwable -> L15
        System.arraycopy(r14[r24 >>> r4], (r24 & r8) * r9, r12, 0, r9);     // Catch: Throwable -> L15
        Xor(r12, r13, 0, r12);     // Catch: Throwable -> L15
        BlockMix(r12, r11, r10, r13, r23);     // Catch: Throwable -> L15
        r18 = r18 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        System.arraycopy(r13, 0, r19, r20, r9);     // Catch: Throwable -> L15
        ClearAll(r14);
        ClearAll(new int[][]{r13, r11, r10, r12});
        return;
    L15:
        th = move-exception;
        ClearAll(r14);
        ClearAll(new int[][]{r13, r11, r10, r12});
        throw th;
    }

    private static byte[] SingleIterationPBKDF2(byte[] r2, byte[] r3, int r4) {
        PKCS5S2ParametersGenerator r0 = new PKCS5S2ParametersGenerator(new SHA256Digest());
        r0.init(r2, r3, 1);
        return ((KeyParameter) ZeusTransformUtils.preCheckCast(r0.generateDerivedMacParameters(r4 * 8), KeyParameter.class, "com.obric.memorydata.plugin")).getKey();
    }

    private static void Xor(int[] r3, int[] r4, int r5, int[] r6) {
        int r0 = r6.length - 1;
    L3:
        if (r0 < 0) goto L5;
        r6[r0] = r3[r0] ^ r4[r5 + r0];
        r0 = r0 - 1;
        goto L3
    }

    public static byte[] generate(byte[] r3, byte[] r4, int r5, int r6, int r7, int r8) {
        if (r3 == null) goto L32;
        if (r4 == null) goto L30;
        if (r5 <= 1) goto L28;
        if (isPowerOf2(r5) == false) goto L28;
        if (r6 == 1) goto L10;
    L14:
        if (r6 < 1) goto L26;
        int r1 = Integer.MAX_VALUE / ((r6 * 128) * 8);
        if (r7 < 1) goto L24;
        if (r7 > r1) goto L24;
        if (r8 < 1) goto L22;
        return MFcrypt(r3, r4, r5, r6, r7, r8);
    L22:
        throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
    L24:
        throw new IllegalArgumentException("Parallelisation parameter p must be >= 1 and <= " + r1 + " (based on block size r of " + r6 + ")");
    L26:
        throw new IllegalArgumentException("Block size r must be >= 1.");
    L10:
        if (r5 < 65536) goto L14;
        throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
    L28:
        throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
    L30:
        throw new IllegalArgumentException("Salt S must be provided.");
    L32:
        throw new IllegalArgumentException("Passphrase P must be provided.");
    }

    private static boolean isPowerOf2(int r1) {
        if ((r1 & (r1 - 1)) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
