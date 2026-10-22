package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = null;
    private static final byte[] EMPTY_BYTES = null;
    private static final int[] EMPTY_INTS = null;
    private static final ECPoint[] EMPTY_POINTS = null;

    static {
        DEFAULT_WINDOW_SIZE_CUTOFFS = new int[]{13, 41, 121, 337, 897, 2305};
        EMPTY_BYTES = new byte[0];
        EMPTY_INTS = new int[0];
        EMPTY_POINTS = new ECPoint[0];
    }

    static /* synthetic */ ECPoint[] access$000() {
        return EMPTY_POINTS;
    }

    static /* synthetic */ ECPoint[] access$100(ECPoint[] r0, int r1) {
        return resizeTable(r0, r1);
    }

    public static void configureBasepoint(ECPoint r3) {
        ECCurve r0 = r3.getCurve();
        if (r0 != null) goto L5;
        return;
    L5:
        BigInteger r1 = r0.getOrder();
        if (r1 != null) goto L8;
        int r2 = r0.getFieldSize() + 1;
    L9:
        final int r4 = Math.min(16, getWindowSize(r2) + 3);
        r0.precompute(r3, "bc_wnaf", new AnonymousClass1(r4));
        return;
    L8:
        r2 = r1.bitLength();
        goto L9
    }

    public static int[] generateCompactNaf(BigInteger r10) {
        if ((r10.bitLength() >>> 16) != 0) goto L24;
        if (r10.signum() == 0) goto L7;
        BigInteger r1 = r10.shiftLeft(1).add(r10);
        int r2 = r1.bitLength();
        int r3 = r2 >> 1;
        int[] r4 = new int[r3];
        BigInteger r5 = r1.xor(r10);
        int r6 = r2 - 1;
        int r7 = 0;
        int r8 = 1;
        int r9 = 0;
    L9:
        if (r8 >= r6) goto L19;
        if (r5.testBit(r8) == true) goto L14;
        r9 = r9 + 1;
    L18:
        r8 = r8 + 1;
        goto L9
    L14:
        if (r10.testBit(r8) == false) goto L16;
        int r11 = -1;
    L17:
        r4[r7] = r9 | (r11 << 16);
        r8 = r8 + 1;
        r9 = 1;
        r7 = r7 + 1;
        goto L18
    L16:
        r11 = 1;
        goto L17
    L19:
        int r12 = r7 + 1;
        r4[r7] = 65536 | r9;
        if (r3 > r12) goto L22;
        return r4;
    L22:
        return trim(r4, r12);
    L7:
        return EMPTY_INTS;
    L24:
        throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    }

    public static int[] generateCompactWindowNaf(int r13, BigInteger r14) {
        if (r13 == 2) goto L5;
        if (r13 < 2) goto L39;
        if (r13 > 16) goto L39;
        if ((r14.bitLength() >>> 16) != 0) goto L37;
        if (r14.signum() == 0) goto L14;
        int r1 = (r14.bitLength() / r13) + 1;
        int[] r3 = new int[r1];
        int r4 = 1 << r13;
        int r5 = r4 - 1;
        int r6 = r4 >>> 1;
        int r8 = 0;
        int r9 = 0;
        boolean r10 = false;
    L17:
        if (r8 > r14.bitLength()) goto L33;
        if (r14.testBit(r8) == r10) goto L20;
        r14 = r14.shiftRight(r8);
        int r11 = r14.intValue() & r5;
        if (r10 == false) goto L25;
        r11 = r11 + 1;
    L25:
        if ((r11 & r6) == 0) goto L27;
        r10 = true;
    L28:
        if (r10 == false) goto L30;
        r11 = r11 - r4;
    L30:
        if (r9 <= 0) goto L32;
        r8 = r8 - 1;
    L32:
        r3[r9] = r8 | (r11 << 16);
        r8 = r13;
        r9 = r9 + 1;
        goto L17
    L27:
        r10 = false;
        goto L28
    L20:
        r8 = r8 + 1;
        goto L17
    L33:
        if (r1 > r9) goto L35;
        return r3;
    L35:
        return trim(r3, r9);
    L14:
        return EMPTY_INTS;
    L37:
        throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    L39:
        throw new IllegalArgumentException("'width' must be in the range [2, 16]");
    L5:
        return generateCompactNaf(r14);
    }

    public static byte[] generateNaf(BigInteger r7) {
        if (r7.signum() == 0) goto L5;
        BigInteger r1 = r7.shiftLeft(1).add(r7);
        int r2 = r1.bitLength() - 1;
        byte[] r3 = new byte[r2];
        BigInteger r4 = r1.xor(r7);
        int r5 = 1;
    L7:
        if (r5 >= r2) goto L16;
        if (r4.testBit(r5) == false) goto L15;
        int r6 = r5 - 1;
        if (r7.testBit(r5) == false) goto L13;
        int r8 = -1;
    L14:
        r3[r6] = (byte) r8;
        r5 = r5 + 1;
        goto L15
    L13:
        r8 = 1;
    L15:
        r5 = r5 + 1;
        goto L7
    L16:
        r3[r2 - 1] = 1;
        return r3;
    L5:
        return EMPTY_BYTES;
    }

    public static byte[] generateWindowNaf(int r11, BigInteger r12) {
        if (r11 == 2) goto L5;
        if (r11 < 2) goto L35;
        if (r11 > 8) goto L35;
        if (r12.signum() == 0) goto L12;
        int r0 = r12.bitLength() + 1;
        byte[] r2 = new byte[r0];
        int r3 = 1 << r11;
        int r4 = r3 - 1;
        int r5 = r3 >>> 1;
        int r7 = 0;
        int r8 = 0;
        boolean r9 = false;
    L15:
        if (r7 > r12.bitLength()) goto L31;
        if (r12.testBit(r7) == r9) goto L18;
        r12 = r12.shiftRight(r7);
        int r10 = r12.intValue() & r4;
        if (r9 == false) goto L23;
        r10 = r10 + 1;
    L23:
        if ((r10 & r5) == 0) goto L25;
        r9 = true;
    L26:
        if (r9 == false) goto L28;
        r10 = r10 - r3;
    L28:
        if (r8 <= 0) goto L30;
        r7 = r7 - 1;
    L30:
        int r13 = r8 + r7;
        r2[r13] = (byte) r10;
        r8 = r13 + 1;
        r7 = r11;
        goto L15
    L25:
        r9 = false;
        goto L26
    L18:
        r7 = r7 + 1;
        goto L15
    L31:
        if (r0 > r8) goto L33;
        return r2;
    L33:
        return trim(r2, r8);
    L12:
        return EMPTY_BYTES;
    L35:
        throw new IllegalArgumentException("'width' must be in the range [2, 8]");
    L5:
        return generateNaf(r12);
    }

    public static int getWindowSize(int r2) {
        return getWindowSize(r2, DEFAULT_WINDOW_SIZE_CUTOFFS, 16);
    }

    public static int getWindowSize(int r1, int r2) {
        return getWindowSize(r1, DEFAULT_WINDOW_SIZE_CUTOFFS, r2);
    }

    public static int getWindowSize(int r2, int[] r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (r2 < r3[r0]) goto L10;
        r0 = r0 + 1;
    L10:
        return Math.max(2, Math.min(r4, r0 + 2));
    }

    public static WNafPreCompInfo precompute(final ECPoint r2, final int r3, final boolean r4) {
        final ECCurve r0 = r2.getCurve();
        return (WNafPreCompInfo) ZeusTransformUtils.preCheckCast(r0.precompute(r2, "bc_wnaf", new AnonymousClass2(r3, r4, r2, r0)), WNafPreCompInfo.class, "com.obric.memorydata.plugin");
    }

    public static WNafPreCompInfo precomputeWithPointMap(ECPoint r3, ECPointMap r4, final WNafPreCompInfo r5, final boolean r6) {
        final ECPointMap r7 = (ECPointMap) ZeusTransformUtils.wrapperContextForParams(r4, ECPointMap.class, "com.obric.memorydata.plugin");
        return (WNafPreCompInfo) ZeusTransformUtils.preCheckCast(r3.getCurve().precompute(r3, "bc_wnaf", new AnonymousClass3(r5, r6, r7)), WNafPreCompInfo.class, "com.obric.memorydata.plugin");
    }

    private static ECPoint[] resizeTable(ECPoint[] r2, int r3) {
        ECPoint[] r4 = new ECPoint[r3];
        System.arraycopy(r2, 0, r4, 0, r2.length);
        return r4;
    }

    private static byte[] trim(byte[] r2, int r3) {
        byte[] r0 = new byte[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static int[] trim(int[] r2, int r3) {
        int[] r0 = new int[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }
}
