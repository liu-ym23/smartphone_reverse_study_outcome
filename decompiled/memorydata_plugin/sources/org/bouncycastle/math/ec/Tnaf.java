package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
class Tnaf {
    private static final BigInteger MINUS_ONE = null;
    private static final BigInteger MINUS_THREE = null;
    private static final BigInteger MINUS_TWO = null;
    public static final ZTauElement[] alpha0 = null;
    public static final byte[][] alpha0Tnaf = null;
    public static final ZTauElement[] alpha1 = null;
    public static final byte[][] alpha1Tnaf = null;

    static {
        BigInteger r0 = ECConstants.ONE.negate();
        MINUS_ONE = r0;
        MINUS_TWO = ECConstants.TWO.negate();
        BigInteger r1 = ECConstants.THREE.negate();
        MINUS_THREE = r1;
        alpha0 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(r1, r0), null, new ZTauElement(r0, r0), null, new ZTauElement(ECConstants.ONE, r0), null};
        alpha0Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        alpha1 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(r1, ECConstants.ONE), null, new ZTauElement(r0, ECConstants.ONE), null, new ZTauElement(ECConstants.ONE, ECConstants.ONE), null};
        alpha1Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger r2, BigInteger r3, BigInteger r4, byte r5, int r6, int r7) {
        int r0 = ((r6 + 5) / 2) + r7;
        BigInteger r8 = r3.multiply(r2.shiftRight(((r6 - r0) - 2) + r5));
        BigInteger r9 = r8.add(r4.multiply(r8.shiftRight(r6)));
        int r1 = r0 - r7;
        BigInteger r10 = r9.shiftRight(r1);
        if (r9.testBit(r1 - 1) == false) goto L6;
        r10 = r10.add(ECConstants.ONE);
    L6:
        return new SimpleBigDecimal(r10, r7);
    }

    public static BigInteger[] getLucas(byte r5, int r6, boolean r7) {
        if (r5 != 1) goto L5;
    L9:
        if (r7 == false) goto L11;
        BigInteger r8 = ECConstants.TWO;
        BigInteger r1 = BigInteger.valueOf(r5);
    L12:
        int r2 = 1;
    L13:
        if (r2 >= r6) goto L19;
        if (r5 != 1) goto L16;
        BigInteger r3 = r1;
    L17:
        r2 = r2 + 1;
        BigInteger r4 = r1;
        r1 = r3.subtract(r8.shiftLeft(1));
        r8 = r4;
        goto L13
    L16:
        r3 = r1.negate();
        goto L17
    L19:
        return new BigInteger[]{r8, r1};
    L11:
        r8 = ECConstants.ZERO;
        r1 = ECConstants.ONE;
        goto L12
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(int r0) {
        if (r0 != 0) goto L4;
        int r1 = -1;
    L6:
        return (byte) r1;
    L4:
        r1 = 1;
        goto L6
    }

    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m r5, byte r6) {
        if (r6 != 0) goto L4;
        byte[][] r7 = alpha0Tnaf;
    L5:
        ECPoint.AbstractF2m[] r0 = new ECPoint.AbstractF2m[(r7.length + 1) >>> 1];
        r0[0] = r5;
        int r1 = r7.length;
        int r2 = 3;
    L6:
        if (r2 >= r1) goto L8;
        r0[r2 >>> 1] = multiplyFromTnaf(r5, r7[r2]);
        r2 = r2 + 2;
        goto L6
    L8:
        r5.getCurve().normalizeAll(r0);
        return r0;
    L4:
        r7 = alpha1Tnaf;
        goto L5
    }

    public static int getShiftsForCofactor(BigInteger r1) {
        if (r1 == null) goto L12;
        if (r1.equals(ECConstants.TWO) == false) goto L8;
        return 1;
    L8:
        if (r1.equals(ECConstants.FOUR) == false) goto L12;
        return 2;
    L12:
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static BigInteger[] getSi(ECCurve.AbstractF2m r5) {
        if (r5.isKoblitz() == false) goto L10;
        int r0 = r5.getFieldSize();
        int r1 = r5.getA().toBigInteger().intValue();
        byte r2 = getMu(r1);
        int r6 = getShiftsForCofactor(r5.getCofactor());
        BigInteger[] r3 = getLucas(r2, (r0 + 3) - r1, false);
        if (r2 != 1) goto L8;
        r3[0] = r3[0].negate();
        r3[1] = r3[1].negate();
    L8:
        return new BigInteger[]{ECConstants.ONE.add(r3[1]).shiftRight(r6), ECConstants.ONE.add(r3[0]).shiftRight(r6).negate()};
    L10:
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte r3, int r4) {
        if (r4 != 4) goto L9;
        if (r3 != 1) goto L8;
        return BigInteger.valueOf(6);
    L8:
        return BigInteger.valueOf(10);
    L9:
        BigInteger[] r5 = getLucas(r3, r4, false);
        BigInteger r6 = ECConstants.ZERO.setBit(r4);
        BigInteger r0 = r5[1].modInverse(r6);
        return ECConstants.TWO.multiply(r5[0]).multiply(r0).mod(r6);
    }

    public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m r7, byte[] r8) {
        ECPoint.AbstractF2m r0 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r7.getCurve().getInfinity(), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        ECPoint.AbstractF2m r1 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r7.negate(), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        int r3 = r8.length - 1;
        int r5 = 0;
    L3:
        if (r3 < 0) goto L12;
        r5 = r5 + 1;
        byte r6 = r8[r3];
        if (r6 == 0) goto L11;
        ECPoint.AbstractF2m r2 = r0.tauPow(r5);
        if (r6 <= 0) goto L9;
        ECPoint.AbstractF2m r9 = r7;
    L10:
        r0 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r2.add(r9), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        r5 = 0;
        goto L11
    L9:
        r9 = r1;
    L11:
        r3 = r3 - 1;
        goto L3
    L12:
        if (r5 > 0) goto L14;
        return r0;
    L14:
        return r0.tauPow(r5);
    }

    public static BigInteger norm(byte r3, ZTauElement r4) {
        BigInteger r0 = r4.u.multiply(r4.u);
        BigInteger r1 = r4.u.multiply(r4.v);
        BigInteger r5 = r4.v.multiply(r4.v).shiftLeft(1);
        if (r3 != 1) goto L7;
        BigInteger r6 = r0.add(r1);
    L9:
        return r6.add(r5);
    L7:
        if (r3 != (-1)) goto L11;
        r6 = r0.subtract(r1);
        goto L9
    L11:
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static ZTauElement partModReduction(BigInteger r13, int r14, byte r15, BigInteger[] r16, byte r17, byte r18) {
        if (r17 != 1) goto L5;
        BigInteger r3 = r16[0].add(r16[1]);
    L6:
        BigInteger r11 = getLucas(r17, r14, true)[1];
        ZTauElement r0 = round(approximateDivisionByN(r13, r16[0], r11, r15, r14, r18), approximateDivisionByN(r13, r16[1], r11, r15, r14, r18), r17);
        return new ZTauElement(r13.subtract(r3.multiply(r0.u)).subtract(BigInteger.valueOf(2).multiply(r16[1]).multiply(r0.v)), r16[1].multiply(r0.u).subtract(r16[0].multiply(r0.v)));
    L5:
        r3 = r16[0].subtract(r16[1]);
        goto L6
    }

    public static ZTauElement round(SimpleBigDecimal r7, SimpleBigDecimal r8, byte r9) {
        if (r8.getScale() != r7.getScale()) goto L39;
        int r0 = -1;
        int r1 = 1;
        if (r9 == 1) goto L10;
        if (r9 == (-1)) goto L10;
        throw new IllegalArgumentException("mu must be 1 or -1");
    L10:
        BigInteger r2 = r7.round();
        BigInteger r3 = r8.round();
        SimpleBigDecimal r10 = r7.subtract(r2);
        SimpleBigDecimal r11 = r8.subtract(r3);
        SimpleBigDecimal r4 = r10.add(r10);
        if (r9 != 1) goto L13;
        SimpleBigDecimal r5 = r4.add(r11);
    L14:
        SimpleBigDecimal r6 = r11.add(r11).add(r11);
        SimpleBigDecimal r12 = r6.add(r11);
        if (r9 != 1) goto L17;
        SimpleBigDecimal r13 = r10.subtract(r6);
        SimpleBigDecimal r14 = r10.add(r12);
    L18:
        byte r15 = 0;
        if (r5.compareTo(ECConstants.ONE) < 0) goto L24;
        if (r13.compareTo(MINUS_ONE) >= 0) goto L28;
    L25:
        r1 = 0;
        r15 = r9;
    L28:
        if (r5.compareTo(MINUS_ONE) >= 0) goto L33;
        if (r13.compareTo(ECConstants.ONE) < 0) goto L37;
    L34:
        r15 = (byte) (-r9);
    L35:
        r0 = r1;
    L37:
        return new ZTauElement(r2.add(BigInteger.valueOf(r0)), r3.add(BigInteger.valueOf(r15)));
    L33:
        if (r14.compareTo(MINUS_TWO) >= 0) goto L35;
    L24:
        if (r14.compareTo(ECConstants.TWO) >= 0) goto L25;
        r1 = 0;
        goto L28
    L17:
        r13 = r10.add(r6);
        r14 = r10.subtract(r12);
        goto L18
    L13:
        r5 = r4.subtract(r11);
        goto L14
    L39:
        throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
    }

    public static byte[] tauAdicWNaf(byte r8, ZTauElement r9, byte r10, BigInteger r11, BigInteger r12, ZTauElement[] r13) {
        if (r8 != 1) goto L5;
    L9:
        int r1 = norm(r8, r9).bitLength();
        if (r1 <= 30) goto L12;
        int r2 = (r1 + 4) + r10;
    L13:
        byte[] r14 = new byte[r2];
        BigInteger r3 = r11.shiftRight(1);
        BigInteger r4 = r9.u;
        BigInteger r15 = r9.v;
        int r5 = 0;
    L15:
        if (r4.equals(ECConstants.ZERO) == false) goto L21;
        if (r15.equals(ECConstants.ZERO) == false) goto L21;
        return r14;
    L21:
        if (r4.testBit(0) == false) goto L32;
        BigInteger r6 = r4.add(r15.multiply(r12)).mod(r11);
        if (r6.compareTo(r3) < 0) goto L25;
        r6 = r6.subtract(r11);
    L25:
        byte r7 = (byte) r6.intValue();
        r14[r5] = r7;
        if (r7 >= 0) goto L28;
        r7 = (byte) (-r7);
        boolean r16 = false;
    L29:
        if (r16 == false) goto L31;
        r4 = r4.subtract(r13[r7].u);
        r15 = r15.subtract(r13[r7].v);
    L33:
        BigInteger r17 = r4.shiftRight(1);
        if (r8 != 1) goto L36;
        BigInteger r18 = r15.add(r17);
    L37:
        BigInteger r19 = r4.shiftRight(1).negate();
        r5 = r5 + 1;
        r4 = r18;
        r15 = r19;
        goto L15
    L36:
        r18 = r15.subtract(r17);
        goto L37
    L31:
        r4 = r4.add(r13[r7].u);
        r15 = r15.add(r13[r7].v);
        goto L33
    L28:
        r16 = true;
        goto L29
    L32:
        r14[r5] = 0;
        goto L33
    L12:
        r2 = r10 + 34;
        goto L13
    L5:
        if (r8 == (-1)) goto L9;
        throw new IllegalArgumentException("mu must be 1 or -1");
    }
}
