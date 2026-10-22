package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes7.dex */
public class SecT571K1Point extends ECPoint.AbstractF2m {
    SecT571K1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecT571K1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
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
        SecT571FieldElement r22 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r21.square().add(r21).add(r19), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        if (r22.isZero() == true) goto L43;
        SecT571FieldElement r23 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r21.multiply(r19.add(r22)).add(r22).add(r20).divide(r22).add(r22), SecT571FieldElement.class, "com.obric.memorydata.plugin");
        SecT571FieldElement r24 = (SecT571FieldElement) ZeusTransformUtils.preCheckCast(r2.fromBigInteger(ECConstants.ONE), SecT571FieldElement.class, "com.obric.memorydata.plugin");
    L57:
        return new SecT571K1Point(r2, r22, r23, new ECFieldElement[]{r24});
    L43:
        return new SecT571K1Point(r2, r22, r2.getB());
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
        return new SecT571K1Point(r2, r22, r2.getB());
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
        return new SecT571K1Point(null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT571K1Point(this.curve, r0, r1.add(r2), new ECFieldElement[]{r2});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r0 = getCurve();
        ECFieldElement r1 = this.x;
        if (r1.isZero() == true) goto L8;
        ECFieldElement r2 = this.y;
        ECFieldElement r9 = this.zs[0];
        boolean r4 = r9.isOne();
        if (r4 == false) goto L12;
        ECFieldElement r5 = r9;
    L13:
        if (r4 == false) goto L15;
        ECFieldElement r6 = r2.square().add(r2);
    L17:
        if (r6.isZero() == true) goto L19;
        ECFieldElement r7 = r6.square();
        if (r4 == false) goto L23;
        ECFieldElement r8 = r6;
    L24:
        ECFieldElement r3 = r2.add(r1).square();
        if (r4 == true) goto L29;
        r9 = r5.square();
    L29:
        return new SecT571K1Point(r0, r7, r3.add(r6).add(r5).multiply(r3).add(r9).add(r7).add(r8), new ECFieldElement[]{r8});
    L23:
        r8 = r6.multiply(r5);
        goto L24
    L19:
        return new SecT571K1Point(r0, r6, r0.getB());
    L15:
        r6 = r2.add(r9).multiply(r2);
        goto L17
    L12:
        r5 = r9.square();
        goto L13
    L8:
        return r0.getInfinity();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint r9) {
        if (isInfinity() == false) goto L6;
        return r9;
    L6:
        if (r9.isInfinity() == true) goto L8;
        ECCurve r0 = getCurve();
        ECFieldElement r1 = this.x;
        if (r1.isZero() == false) goto L12;
        return r9;
    L12:
        ECFieldElement r2 = r9.getRawXCoord();
        ECFieldElement r4 = r9.getZCoord(0);
        if (r2.isZero() == true) goto L32;
        if (r4.isOne() == false) goto L32;
        ECFieldElement r5 = this.y;
        ECFieldElement r8 = this.zs[0];
        ECFieldElement r6 = r9.getRawYCoord();
        ECFieldElement r3 = r1.square();
        ECFieldElement r7 = r5.square();
        ECFieldElement r10 = r8.square();
        ECFieldElement r11 = r7.add(r5.multiply(r8));
        ECFieldElement r12 = r6.addOne();
        ECFieldElement r13 = r12.multiply(r10).add(r7).multiplyPlusProduct(r11, r3, r10);
        ECFieldElement r14 = r2.multiply(r10);
        ECFieldElement r15 = r14.add(r11).square();
        if (r15.isZero() == false) goto L26;
        if (r13.isZero() == false) goto L24;
        return r9.twice();
    L24:
        return r0.getInfinity();
    L26:
        if (r13.isZero() == true) goto L28;
        ECFieldElement r16 = r13.square().multiply(r14);
        ECFieldElement r17 = r13.multiply(r15).multiply(r10);
        return new SecT571K1Point(r0, r16, r13.add(r15).square().multiplyPlusProduct(r11, r12, r17), new ECFieldElement[]{r17});
    L28:
        return new SecT571K1Point(r0, r13, r0.getB());
    L32:
        return twice().add(r9);
    L8:
        return twice();
    }
}
