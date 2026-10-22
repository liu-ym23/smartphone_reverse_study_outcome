package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes7.dex */
public class SecT571R1Point extends ECPoint.AbstractF2m {
    SecT571R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecT571R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint r18) {
        if (isInfinity() == false) goto L6;
        return r18;
    L6:
        if (r18.isInfinity() == false) goto L8;
        return this;
    L8:
        ECCurve r2 = getCurve();
        SecT571FieldElement r3 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r4 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r18.getRawXCoord(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r3.isZero() == true) goto L11;
        SecT571FieldElement r6 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r7 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r9 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r18.getRawYCoord(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r1 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r18.getZCoord(0), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        long[] r10 = Nat576.create64();
        long[] r11 = Nat576.create64();
        long[] r12 = Nat576.create64();
        long[] r13 = Nat576.create64();
        if (r7.isOne() == false) goto L19;
        long[] r14 = null;
    L20:
        if (r14 != null) goto L22;
        long[] r15 = r4.x;
        long[] r8 = r9.x;
    L24:
        if (r1.isOne() == false) goto L26;
        long[] r5 = null;
    L27:
        if (r5 != null) goto L29;
        long[] r16 = r3.x;
        long[] r0 = r6.x;
    L30:
        SecT571Field.add(r0, r8, r12);
        SecT571Field.add(r16, r15, r13);
        if (Nat576.isZero64(r13) == false) goto L39;
        if (Nat576.isZero64(r12) == false) goto L37;
        return twice();
    L37:
        return r2.getInfinity();
    L39:
        if (r4.isZero() == false) goto L45;
        ECPoint r17 = normalize();
        SecT571FieldElement r19 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r17.getXCoord(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        ECFieldElement r20 = r17.getYCoord();
        ECFieldElement r21 = r20.add(r9).divide(r19);
        SecT571FieldElement r22 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r21.square().add(r21).add(r19).addOne(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r22.isZero() == true) goto L43;
        SecT571FieldElement r23 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r21.multiply(r19.add(r22)).add(r22).add(r20).divide(r22).add(r22), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r24 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r2.fromBigInteger(ECConstants.ONE), SecT571FieldElement.class, "com.obric.memorydata.plugin");
    L57:
        return new SecT571R1Point(r2, r22, r23, new ECFieldElement[]{r24});
    L43:
        return new SecT571R1Point(r2, r22, SecT571R1Curve.SecT571R1_B_SQRT);
    L45:
        SecT571Field.square(r13, r13);
        long[] r25 = SecT571Field.precompMultiplicand(r12);
        SecT571Field.multiplyPrecomp(r16, r25, r10);
        SecT571Field.multiplyPrecomp(r15, r25, r11);
        r22 = new SecT571FieldElement(r10);
        SecT571Field.multiply(r10, r11, r22.x);
        if (r22.isZero() == true) goto L48;
        SecT571FieldElement r26 = new SecT571FieldElement(r12);
        SecT571Field.multiplyPrecomp(r13, r25, r26.x);
        if (r5 == null) goto L52;
        SecT571Field.multiplyPrecomp(r26.x, r5, r26.x);
    L52:
        long[] r27 = Nat576.createExt64();
        SecT571Field.add(r11, r13, r13);
        SecT571Field.squareAddToExt(r13, r27);
        SecT571Field.add(r6.x, r7.x, r13);
        SecT571Field.multiplyAddToExt(r13, r26.x, r27);
        SecT571FieldElement r28 = new SecT571FieldElement(r13);
        SecT571Field.reduce(r27, r28.x);
        if (r14 == null) goto L55;
        SecT571Field.multiplyPrecomp(r26.x, r14, r26.x);
    L55:
        r23 = r28;
        r24 = r26;
        goto L57
    L48:
        return new SecT571R1Point(r2, r22, SecT571R1Curve.SecT571R1_B_SQRT);
    L29:
        SecT571Field.multiplyPrecomp(r3.x, r5, r10);
        SecT571Field.multiplyPrecomp(r6.x, r5, r12);
        r16 = r10;
        r0 = r12;
        goto L30
    L26:
        r5 = SecT571Field.precompMultiplicand(r1.x);
        goto L27
    L22:
        SecT571Field.multiplyPrecomp(r4.x, r14, r11);
        SecT571Field.multiplyPrecomp(r9.x, r14, r13);
        r15 = r11;
        r8 = r13;
        goto L24
    L19:
        r14 = SecT571Field.precompMultiplicand(r7.x);
        goto L20
    L11:
        if (r4.isZero() == false) goto L15;
        return r2.getInfinity();
    L15:
        return r18.add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecT571R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public boolean getCompressionYTilde() {
        ECFieldElement r0 = getRawXCoord();
        if (r0.isZero() == false) goto L6;
        return false;
    L6:
        if (getRawYCoord().testBitZero() == r0.testBitZero()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECFieldElement getYCoord() {
        ECFieldElement r0 = this.x;
        ECFieldElement r1 = this.y;
        if (isInfinity() == false) goto L5;
    L11:
        return r1;
    L5:
        if (r0.isZero() == true) goto L11;
        ECFieldElement r2 = r1.add(r0).multiply(r0);
        ECFieldElement r3 = this.zs[0];
        if (r3.isOne() == false) goto L10;
        return r2;
    L10:
        return r2.divide(r3);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECFieldElement r0 = this.x;
        if (r0.isZero() == false) goto L8;
        return this;
    L8:
        ECFieldElement r1 = this.y;
        ECFieldElement r2 = this.zs[0];
        return new SecT571R1Point(this.curve, r0, r1.add(r2), new ECFieldElement[]{r2});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r0 = getCurve();
        SecT571FieldElement r1 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == true) goto L8;
        SecT571FieldElement r2 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r10 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecT571FieldElement.class, "com.obric.memorydata.plugin");
        long[] r3 = Nat576.create64();
        long[] r5 = Nat576.create64();
        if (r10.isOne() == false) goto L12;
        long[] r6 = null;
    L13:
        long[] r7 = r2.x;
        if (r6 != null) goto L16;
        long[] r11 = r10.x;
    L17:
        long[] r8 = Nat576.create64();
        SecT571Field.square(r2.x, r8);
        SecT571Field.addBothTo(r7, r11, r8);
        if (Nat576.isZero64(r8) == true) goto L20;
        long[] r4 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(r8, r7, r4);
        SecT571FieldElement r9 = new SecT571FieldElement(r3);
        SecT571Field.square(r8, r9.x);
        SecT571FieldElement r12 = new SecT571FieldElement(r8);
        if (r6 == null) goto L24;
        SecT571Field.multiply(r12.x, r11, r12.x);
    L24:
        long[] r13 = r1.x;
        if (r6 == null) goto L28;
        SecT571Field.multiplyPrecomp(r13, r6, r5);
        r13 = r5;
    L28:
        SecT571Field.squareAddToExt(r13, r4);
        SecT571Field.reduce(r4, r5);
        SecT571Field.addBothTo(r9.x, r12.x, r5);
        return new SecT571R1Point(r0, r9, new SecT571FieldElement(r5), new ECFieldElement[]{r12});
    L20:
        return new SecT571R1Point(r0, new SecT571FieldElement(r8), SecT571R1Curve.SecT571R1_B_SQRT);
    L16:
        SecT571Field.multiplyPrecomp(r7, r6, r3);
        SecT571Field.square(r10.x, r5);
        r7 = r3;
        r11 = r5;
        goto L17
    L12:
        r6 = SecT571Field.precompMultiplicand(r10.x);
        goto L13
    L8:
        return r0.getInfinity();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint r11) {
        if (isInfinity() == false) goto L6;
        return r11;
    L6:
        if (r11.isInfinity() == true) goto L8;
        ECCurve r0 = getCurve();
        SecT571FieldElement r1 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == false) goto L12;
        return r11;
    L12:
        SecT571FieldElement r2 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r11.getRawXCoord(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r5 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r11.getZCoord(0), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r2.isZero() == true) goto L32;
        if (r5.isOne() == false) goto L32;
        SecT571FieldElement r6 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r10 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r3 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r11.getRawYCoord(), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        long[] r7 = Nat576.create64();
        long[] r8 = Nat576.create64();
        long[] r9 = Nat576.create64();
        long[] r12 = Nat576.create64();
        SecT571Field.square(r1.x, r7);
        SecT571Field.square(r6.x, r8);
        SecT571Field.square(r10.x, r9);
        SecT571Field.multiply(r6.x, r10.x, r12);
        SecT571Field.addBothTo(r9, r8, r12);
        long[] r13 = SecT571Field.precompMultiplicand(r9);
        SecT571Field.multiplyPrecomp(r3.x, r13, r9);
        SecT571Field.add(r9, r8, r9);
        long[] r4 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(r9, r12, r4);
        SecT571Field.multiplyPrecompAddToExt(r7, r13, r4);
        SecT571Field.reduce(r4, r9);
        SecT571Field.multiplyPrecomp(r2.x, r13, r7);
        SecT571Field.add(r7, r12, r8);
        SecT571Field.square(r8, r8);
        if (Nat576.isZero64(r8) == false) goto L26;
        if (Nat576.isZero64(r9) == false) goto L24;
        return r11.twice();
    L24:
        return r0.getInfinity();
    L26:
        if (Nat576.isZero64(r9) == true) goto L28;
        SecT571FieldElement r14 = new SecT571FieldElement();
        SecT571Field.square(r9, r14.x);
        SecT571Field.multiply(r14.x, r7, r14.x);
        SecT571FieldElement r15 = new SecT571FieldElement(r7);
        SecT571Field.multiply(r9, r8, r15.x);
        SecT571Field.multiplyPrecomp(r15.x, r13, r15.x);
        SecT571FieldElement r16 = new SecT571FieldElement(r8);
        SecT571Field.add(r9, r8, r16.x);
        SecT571Field.square(r16.x, r16.x);
        Nat.zero64(18, r4);
        SecT571Field.multiplyAddToExt(r16.x, r12, r4);
        SecT571Field.addOne(r3.x, r12);
        SecT571Field.multiplyAddToExt(r12, r15.x, r4);
        SecT571Field.reduce(r4, r16.x);
        return new SecT571R1Point(r0, r14, r16, new ECFieldElement[]{r15});
    L28:
        return new SecT571R1Point(r0, new SecT571FieldElement(r9), SecT571R1Curve.SecT571R1_B_SQRT);
    L32:
        return twice().add(r11);
    L8:
        return twice();
    }
}
