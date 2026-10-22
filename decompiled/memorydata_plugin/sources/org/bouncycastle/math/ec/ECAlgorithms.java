package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes7.dex */
public class ECAlgorithms {
    public static ECPoint cleanPoint(ECCurve r1, ECPoint r2) {
        if (r1.equals(r2.getCurve()) == false) goto L7;
        return r1.decodePoint(r2.getEncoded(false));
    L7:
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    static ECPoint implCheckResult(ECPoint r1) {
        if (r1.isValidPartial() == false) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Invalid result");
    }

    private static ECPoint implShamirsTrickFixedPoint(ECPoint r18, BigInteger r19, ECPoint r20, BigInteger r21) {
        ECCurve r2 = r18.getCurve();
        int r3 = FixedPointUtil.getCombSize(r2);
        if (r19.bitLength() > r3) goto L19;
        if (r21.bitLength() > r3) goto L19;
        FixedPointPreCompInfo r4 = FixedPointUtil.precompute(r18);
        FixedPointPreCompInfo r5 = FixedPointUtil.precompute(r20);
        ECLookupTable r6 = r4.getLookupTable();
        ECLookupTable r7 = r5.getLookupTable();
        int r8 = r4.getWidth();
        if (r8 == r5.getWidth()) goto L11;
        FixedPointCombMultiplier r9 = new FixedPointCombMultiplier();
        ECPoint r0 = r9.multiply(r18, r19);
        ECPoint r1 = r9.multiply(r20, r21);
    L10:
        return r0.add(r1);
    L11:
        int r10 = ((r3 + r8) - 1) / r8;
        ECPoint r11 = r2.getInfinity();
        int r12 = r8 * r10;
        int[] r13 = Nat.fromBigInteger(r12, r19);
        int[] r14 = Nat.fromBigInteger(r12, r21);
        int r15 = r12 - 1;
        int r16 = 0;
    L12:
        if (r16 >= r10) goto L17;
        int r17 = r15 - r16;
        int r110 = 0;
        int r111 = 0;
    L14:
        if (r17 < 0) goto L16;
        int r112 = r17 >>> 5;
        int r113 = r17 & 31;
        int r114 = r13[r112] >>> r113;
        r110 = ((r110 ^ (r114 >>> 1)) << 1) ^ r114;
        int r115 = r14[r112] >>> r113;
        r111 = ((r111 ^ (r115 >>> 1)) << 1) ^ r115;
        r17 = r17 - r10;
        goto L14
    L16:
        r11 = r11.twicePlus(r6.lookupVar(r110).add(r7.lookupVar(r111)));
        r16 = r16 + 1;
        goto L12
    L17:
        r0 = r11.add(r4.getOffset());
        r1 = r5.getOffset();
    L19:
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }

    static ECPoint implShamirsTrickWNaf(ECPoint r12, BigInteger r13, ECPoint r14, BigInteger r15) {
        boolean r1 = false;
        if (r13.signum() >= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r15.signum() >= 0) goto L9;
        r1 = true;
    L9:
        BigInteger r3 = r13.abs();
        BigInteger r4 = r15.abs();
        int r5 = WNafUtil.getWindowSize(r3.bitLength(), 8);
        int r7 = WNafUtil.getWindowSize(r4.bitLength(), 8);
        WNafPreCompInfo r6 = WNafUtil.precompute(r12, r5, true);
        WNafPreCompInfo r2 = WNafUtil.precompute(r14, r7, true);
        int r8 = FixedPointUtil.getCombSize(r12.getCurve());
        if (r0 == true) goto L22;
        if (r1 == true) goto L22;
        if (r13.bitLength() > r8) goto L22;
        if (r15.bitLength() > r8) goto L22;
        if (r6.isPromoted() == false) goto L22;
        if (r2.isPromoted() == false) goto L22;
        return implShamirsTrickFixedPoint(r12, r13, r14, r15);
    L22:
        int r16 = Math.min(8, r6.getWidth());
        int r17 = Math.min(8, r2.getWidth());
        if (r0 == false) goto L25;
        ECPoint[] r18 = r6.getPreCompNeg();
    L26:
        ECPoint[] r9 = r18;
        if (r1 == false) goto L29;
        ECPoint[] r19 = r2.getPreCompNeg();
    L30:
        ECPoint[] r10 = r19;
        if (r0 == false) goto L33;
        ECPoint[] r110 = r6.getPreComp();
    L34:
        ECPoint[] r11 = r110;
        if (r1 == false) goto L37;
        ECPoint[] r111 = r2.getPreComp();
    L39:
        return implShamirsTrickWNaf(r9, r11, WNafUtil.generateWindowNaf(r16, r3), r10, r111, WNafUtil.generateWindowNaf(r17, r4));
    L37:
        r111 = r2.getPreCompNeg();
        goto L39
    L33:
        r110 = r6.getPreCompNeg();
        goto L34
    L29:
        r19 = r2.getPreComp();
        goto L30
    L25:
        r18 = r6.getPreComp();
        goto L26
    L5:
        r0 = false;
        goto L7
    }

    static ECPoint implShamirsTrickWNaf(ECEndomorphism r11, ECPoint r12, BigInteger r13, BigInteger r14) {
        ECEndomorphism r15 = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r11, ECEndomorphism.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r13.signum() >= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r14.signum() >= 0) goto L9;
        r1 = true;
    L9:
        BigInteger r16 = r13.abs();
        BigInteger r17 = r14.abs();
        WNafPreCompInfo r3 = WNafUtil.precompute(r12, WNafUtil.getWindowSize(Math.max(r16.bitLength(), r17.bitLength()), 8), true);
        WNafPreCompInfo r18 = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(r15, r12), r15.getPointMap(), r3, true);
        int r19 = Math.min(8, r3.getWidth());
        int r2 = Math.min(8, r18.getWidth());
        if (r0 == false) goto L12;
        ECPoint[] r4 = r3.getPreCompNeg();
    L13:
        ECPoint[] r5 = r4;
        if (r1 == false) goto L16;
        ECPoint[] r6 = r18.getPreCompNeg();
    L17:
        ECPoint[] r8 = r6;
        if (r0 == false) goto L20;
        ECPoint[] r7 = r3.getPreComp();
    L21:
        ECPoint[] r9 = r7;
        if (r1 == false) goto L24;
        ECPoint[] r110 = r18.getPreComp();
    L26:
        return implShamirsTrickWNaf(r5, r9, WNafUtil.generateWindowNaf(r19, r16), r8, r110, WNafUtil.generateWindowNaf(r2, r17));
    L24:
        r110 = r18.getPreCompNeg();
        goto L26
    L20:
        r7 = r3.getPreCompNeg();
        goto L21
    L16:
        r6 = r18.getPreComp();
        goto L17
    L12:
        r4 = r3.getPreComp();
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] r8, ECPoint[] r9, byte[] r10, ECPoint[] r11, ECPoint[] r12, byte[] r13) {
        int r0 = Math.max(r10.length, r13.length);
        ECPoint r2 = r8[0].getCurve().getInfinity();
        int r1 = r0 - 1;
        int r3 = 0;
        ECPoint r4 = r2;
    L3:
        if (r1 < 0) goto L32;
        if (r1 >= r10.length) goto L7;
        byte r5 = r10[r1];
    L9:
        if (r1 >= r13.length) goto L11;
        byte r6 = r13[r1];
    L13:
        if ((r5 | r6) != 0) goto L15;
        r3 = r3 + 1;
    L31:
        r1 = r1 - 1;
        goto L3
    L15:
        if (r5 == 0) goto L21;
        int r7 = Math.abs(r5);
        if (r5 >= 0) goto L19;
        ECPoint[] r14 = r9;
    L20:
        ECPoint r15 = r2.add(r14[r7 >>> 1]);
    L22:
        if (r6 == 0) goto L28;
        int r16 = Math.abs(r6);
        if (r6 >= 0) goto L26;
        ECPoint[] r17 = r12;
    L27:
        r15 = r15.add(r17[r16 >>> 1]);
        goto L28
    L26:
        r17 = r11;
    L28:
        if (r3 <= 0) goto L30;
        r4 = r4.timesPow2(r3);
        r3 = 0;
    L30:
        r4 = r4.twicePlus(r15);
        goto L31
    L19:
        r14 = r8;
        goto L20
    L21:
        r15 = r2;
        goto L22
    L11:
        r6 = 0;
        goto L13
    L7:
        r5 = 0;
        goto L9
    L32:
        if (r3 > 0) goto L34;
        return r4;
    L34:
        return r4.timesPow2(r3);
    }

    static ECPoint implSumOfMultiplies(ECEndomorphism r16, ECPoint[] r17, BigInteger[] r18) {
        ECPoint[] r0 = r17;
        ECEndomorphism r1 = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r16, ECEndomorphism.class, "com.obric.memorydata.plugin");
        int r2 = r0.length;
        int r3 = r2 << 1;
        boolean[] r4 = new boolean[r3];
        WNafPreCompInfo[] r5 = new WNafPreCompInfo[r3];
        byte[][] r6 = new byte[r3][];
        ECPointMap r7 = r1.getPointMap();
        int r8 = 0;
    L3:
        if (r8 >= r2) goto L14;
        int r9 = r8 << 1;
        int r10 = r9 + 1;
        BigInteger r11 = r18[r9];
        if (r11.signum() >= 0) goto L7;
        boolean r12 = true;
    L8:
        r4[r9] = r12;
        BigInteger r13 = r11.abs();
        BigInteger r14 = r18[r10];
        if (r14.signum() >= 0) goto L11;
        boolean r15 = true;
    L12:
        r4[r10] = r15;
        BigInteger r19 = r14.abs();
        int r110 = WNafUtil.getWindowSize(Math.max(r13.bitLength(), r19.bitLength()), 8);
        ECPoint r20 = r0[r8];
        WNafPreCompInfo r111 = WNafUtil.precompute(r20, r110, true);
        WNafPreCompInfo r21 = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(r1, r20), r7, r111, true);
        int r112 = Math.min(8, r111.getWidth());
        int r22 = Math.min(8, r21.getWidth());
        r5[r9] = r111;
        r5[r10] = r21;
        r6[r9] = WNafUtil.generateWindowNaf(r112, r13);
        r6[r10] = WNafUtil.generateWindowNaf(r22, r19);
        r8 = r8 + 1;
        r0 = r17;
        goto L3
    L11:
        r15 = false;
        goto L12
    L7:
        r12 = false;
        goto L8
    L14:
        return implSumOfMultiplies(r4, r5, r6);
    }

    static ECPoint implSumOfMultiplies(ECPoint[] r11, BigInteger[] r12) {
        int r0 = r11.length;
        boolean[] r1 = new boolean[r0];
        WNafPreCompInfo[] r2 = new WNafPreCompInfo[r0];
        byte[][] r3 = new byte[r0][];
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L10;
        BigInteger r6 = r12[r5];
        if (r6.signum() >= 0) goto L7;
        boolean r7 = true;
    L8:
        r1[r5] = r7;
        BigInteger r8 = r6.abs();
        WNafPreCompInfo r9 = WNafUtil.precompute(r11[r5], WNafUtil.getWindowSize(r8.bitLength(), 8), true);
        int r10 = Math.min(8, r9.getWidth());
        r2[r5] = r9;
        r3[r5] = WNafUtil.generateWindowNaf(r10, r8);
        r5 = r5 + 1;
        goto L3
    L7:
        r7 = false;
        goto L8
    L10:
        return implSumOfMultiplies(r1, r2, r3);
    }

    private static ECPoint implSumOfMultiplies(boolean[] r13, WNafPreCompInfo[] r14, byte[][] r15) {
        int r0 = r15.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = Math.max(r3, r15[r2].length);
        r2 = r2 + 1;
        goto L3
    L5:
        ECPoint r4 = r14[0].getPreComp()[0].getCurve().getInfinity();
        int r5 = r3 - 1;
        int r6 = 0;
        ECPoint r7 = r4;
    L6:
        if (r5 < 0) goto L30;
        int r8 = 0;
        ECPoint r9 = r4;
    L8:
        if (r8 >= r0) goto L24;
        byte[] r10 = r15[r8];
        if (r5 >= r10.length) goto L12;
        byte r11 = r10[r5];
    L13:
        if (r11 == 0) goto L23;
        int r12 = Math.abs(r11);
        WNafPreCompInfo r16 = r14[r8];
        if (r11 >= 0) goto L17;
        boolean r17 = true;
    L19:
        if (r17 != r13[r8]) goto L21;
        ECPoint[] r18 = r16.getPreComp();
    L22:
        r9 = r9.add(r18[r12 >>> 1]);
        goto L23
    L21:
        r18 = r16.getPreCompNeg();
        goto L22
    L17:
        r17 = false;
    L23:
        r8 = r8 + 1;
        goto L8
    L12:
        r11 = 0;
        goto L13
    L24:
        if (r9 != r4) goto L26;
        r6 = r6 + 1;
    L29:
        r5 = r5 - 1;
        goto L6
    L26:
        if (r6 <= 0) goto L28;
        r7 = r7.timesPow2(r6);
        r6 = 0;
    L28:
        r7 = r7.twicePlus(r9);
        goto L29
    L30:
        if (r6 > 0) goto L32;
        return r7;
    L32:
        return r7.timesPow2(r6);
    }

    static ECPoint implSumOfMultipliesGLV(ECPoint[] r10, BigInteger[] r11, GLVEndomorphism r12) {
        GLVEndomorphism r13 = (GLVEndomorphism) ZeusTransformUtils.wrapperContextForParams(r12, GLVEndomorphism.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        BigInteger r1 = r10[0].getCurve().getOrder();
        int r2 = r10.length;
        int r3 = r2 << 1;
        BigInteger[] r4 = new BigInteger[r3];
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r2) goto L6;
        BigInteger[] r7 = r13.decomposeScalar(r11[r5].mod(r1));
        int r8 = r6 + 1;
        r4[r6] = r7[0];
        r6 = r8 + 1;
        r4[r8] = r7[1];
        r5 = r5 + 1;
        goto L3
    L6:
        if (r13.hasEfficientPointMap() == true) goto L8;
        ECPoint[] r14 = new ECPoint[r3];
        int r9 = 0;
    L10:
        if (r0 >= r2) goto L13;
        ECPoint r15 = r10[r0];
        ECPoint r16 = EndoUtil.mapPoint(r13, r15);
        int r17 = r9 + 1;
        r14[r9] = r15;
        r9 = r17 + 1;
        r14[r17] = r16;
        r0 = r0 + 1;
        goto L10
    L13:
        return implSumOfMultiplies(r14, r4);
    L8:
        return implSumOfMultiplies(r13, r10, r4);
    }

    public static ECPoint importPoint(ECCurve r1, ECPoint r2) {
        if (r1.equals(r2.getCurve()) == false) goto L7;
        return r1.importPoint(r2);
    L7:
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(ECCurve r0) {
        return isF2mField(r0.getField());
    }

    public static boolean isF2mField(FiniteField r3) {
        FiniteField r4 = (FiniteField) ZeusTransformUtils.wrapperContextForParams(r3, FiniteField.class, "com.obric.memorydata.plugin");
        if (r4.getDimension() > 1) goto L5;
    L9:
        return false;
    L5:
        if (r4.getCharacteristic().equals(ECConstants.TWO) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r4, PolynomialExtensionField.class) == false) goto L9;
        return true;
    }

    public static boolean isFpCurve(ECCurve r0) {
        return isFpField(r0.getField());
    }

    public static boolean isFpField(FiniteField r2) {
        if (((FiniteField) ZeusTransformUtils.wrapperContextForParams(r2, FiniteField.class, "com.obric.memorydata.plugin")).getDimension() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void montgomeryTrick(ECFieldElement[] r4, int r5, int r6, ECFieldElement r7) {
        ECFieldElement[] r0 = new ECFieldElement[r6];
        int r2 = 0;
        r0[0] = r4[r5];
    L3:
        r2 = r2 + 1;
        if (r2 >= r6) goto L6;
        r0[r2] = r0[r2 - 1].multiply(r4[r5 + r2]);
        goto L3
    L6:
        int r3 = r2 - 1;
        if (r7 == null) goto L9;
        r0[r3] = r0[r3].multiply(r7);
    L9:
        ECFieldElement r8 = r0[r3].invert();
    L10:
        if (r3 <= 0) goto L12;
        int r9 = r3 - 1;
        int r10 = r3 + r5;
        ECFieldElement r1 = r4[r10];
        r4[r10] = r0[r9].multiply(r8);
        r8 = r8.multiply(r1);
        r3 = r9;
        goto L10
    L12:
        r4[r5] = r8;
    }

    public static ECPoint referenceMultiply(ECPoint r5, BigInteger r6) {
        BigInteger r0 = r6.abs();
        ECPoint r1 = r5.getCurve().getInfinity();
        int r2 = r0.bitLength();
        if (r2 <= 0) goto L14;
        if (r0.testBit(0) == false) goto L7;
        r1 = r5;
    L7:
        int r3 = 1;
    L8:
        if (r3 >= r2) goto L14;
        r5 = r5.twice();
        if (r0.testBit(r3) == false) goto L12;
        r1 = r1.add(r5);
    L12:
        r3 = r3 + 1;
    L14:
        if (r6.signum() < 0) goto L16;
        return r1;
    L16:
        return r1.negate();
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint r5, BigInteger r6, ECPoint r7, BigInteger r8) {
        ECCurve r0 = r5.getCurve();
        ECPoint r9 = importPoint(r0, r7);
        if (ZeusTransformUtils.instanceOf(r0, ECCurve.AbstractF2m.class) == true) goto L5;
    L9:
        ECEndomorphism r1 = r0.getEndomorphism();
        if (ZeusTransformUtils.instanceOf(r1, GLVEndomorphism.class) == false) goto L12;
        ECPoint r10 = implSumOfMultipliesGLV(new ECPoint[]{r5, r9}, new BigInteger[]{r6, r8}, (GLVEndomorphism) ZeusTransformUtils.preCheckCast(r1, GLVEndomorphism.class, "com.obric.memorydata.plugin"));
    L8:
        return implCheckResult(r10);
    L12:
        r10 = implShamirsTrickWNaf(r5, r6, r9, r8);
        goto L8
    L5:
        if (((ECCurve.AbstractF2m) ZeusTransformUtils.preCheckCast(r0, ECCurve.AbstractF2m.class, "com.obric.memorydata.plugin")).isKoblitz() == false) goto L9;
        r10 = r5.multiply(r6).add(r9.multiply(r8));
        goto L8
    }
}
