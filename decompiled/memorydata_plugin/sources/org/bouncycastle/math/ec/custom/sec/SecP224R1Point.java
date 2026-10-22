package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;

/* JADX INFO: loaded from: classes7.dex */
public class SecP224R1Point extends ECPoint.AbstractFp {
    SecP224R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecP224R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint r15) {
        if (isInfinity() == false) goto L6;
        return r15;
    L6:
        if (r15.isInfinity() == false) goto L8;
        return this;
    L8:
        if (this == r15) goto L10;
        ECCurve r0 = getCurve();
        SecP224R1FieldElement r1 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r2 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r4 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r15.getXCoord(), SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r5 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r15.getYCoord(), SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r6 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r16 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r15.getZCoord(0), SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat224.createExt();
        int[] r8 = Nat224.create();
        int[] r9 = Nat224.create();
        int[] r10 = Nat224.create();
        boolean r11 = r6.isOne();
        if (r11 == false) goto L14;
        int[] r7 = r4.x;
        int[] r12 = r5.x;
    L15:
        boolean r13 = r16.isOne();
        if (r13 == false) goto L18;
        int[] r14 = r1.x;
        int[] r17 = r2.x;
    L19:
        int[] r18 = Nat224.create();
        SecP224R1Field.subtract(r14, r7, r18);
        SecP224R1Field.subtract(r17, r12, r8);
        if (Nat224.isZero(r18) == true) goto L22;
        SecP224R1Field.square(r18, r9);
        int[] r19 = Nat224.create();
        SecP224R1Field.multiply(r9, r18, r19);
        SecP224R1Field.multiply(r9, r14, r9);
        SecP224R1Field.negate(r19, r19);
        Nat224.mul(r17, r19, r3);
        SecP224R1Field.reduce32(Nat224.addBothTo(r9, r9, r19), r19);
        SecP224R1FieldElement r20 = new SecP224R1FieldElement(r10);
        SecP224R1Field.square(r8, r20.x);
        SecP224R1Field.subtract(r20.x, r19, r20.x);
        SecP224R1FieldElement r21 = new SecP224R1FieldElement(r19);
        SecP224R1Field.subtract(r9, r20.x, r21.x);
        SecP224R1Field.multiplyAddToExt(r21.x, r8, r3);
        SecP224R1Field.reduce(r3, r21.x);
        SecP224R1FieldElement r110 = new SecP224R1FieldElement(r18);
        if (r11 == true) goto L30;
        SecP224R1Field.multiply(r110.x, r6.x, r110.x);
    L30:
        if (r13 == true) goto L33;
        SecP224R1Field.multiply(r110.x, r16.x, r110.x);
    L33:
        return new SecP224R1Point(r0, r20, r21, new ECFieldElement[]{r110});
    L22:
        if (Nat224.isZero(r8) == false) goto L26;
        return twice();
    L26:
        return r0.getInfinity();
    L18:
        SecP224R1Field.square(r16.x, r10);
        SecP224R1Field.multiply(r10, r1.x, r3);
        SecP224R1Field.multiply(r10, r16.x, r10);
        SecP224R1Field.multiply(r10, r2.x, r10);
        r14 = r3;
        r17 = r10;
        goto L19
    L14:
        SecP224R1Field.square(r6.x, r9);
        SecP224R1Field.multiply(r9, r4.x, r8);
        SecP224R1Field.multiply(r9, r6.x, r9);
        SecP224R1Field.multiply(r9, r5.x, r9);
        r7 = r8;
        r12 = r9;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP224R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP224R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        if (this.y.isZero() == false) goto L8;
        return this;
    L8:
        return twice().add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r0 = getCurve();
        SecP224R1FieldElement r1 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == true) goto L8;
        SecP224R1FieldElement r2 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP224R1FieldElement r11 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat224.create();
        int[] r5 = Nat224.create();
        int[] r6 = Nat224.create();
        SecP224R1Field.square(r1.x, r6);
        int[] r7 = Nat224.create();
        SecP224R1Field.square(r6, r7);
        boolean r8 = r11.isOne();
        int[] r9 = r11.x;
        if (r8 == true) goto L12;
        SecP224R1Field.square(r11.x, r5);
        r9 = r5;
    L12:
        SecP224R1Field.subtract(r2.x, r9, r3);
        SecP224R1Field.add(r2.x, r9, r5);
        SecP224R1Field.multiply(r5, r3, r5);
        SecP224R1Field.reduce32(Nat224.addBothTo(r5, r5, r5), r5);
        SecP224R1Field.multiply(r6, r2.x, r6);
        SecP224R1Field.reduce32(Nat.shiftUpBits(7, r6, 2, 0), r6);
        SecP224R1Field.reduce32(Nat.shiftUpBits(7, r7, 3, 0, r3), r3);
        SecP224R1FieldElement r4 = new SecP224R1FieldElement(r7);
        SecP224R1Field.square(r5, r4.x);
        SecP224R1Field.subtract(r4.x, r6, r4.x);
        SecP224R1Field.subtract(r4.x, r6, r4.x);
        SecP224R1FieldElement r10 = new SecP224R1FieldElement(r6);
        SecP224R1Field.subtract(r6, r4.x, r10.x);
        SecP224R1Field.multiply(r10.x, r5, r10.x);
        SecP224R1Field.subtract(r10.x, r3, r10.x);
        SecP224R1FieldElement r12 = new SecP224R1FieldElement(r5);
        SecP224R1Field.twice(r1.x, r12.x);
        if (r8 == true) goto L16;
        SecP224R1Field.multiply(r12.x, r11.x, r12.x);
    L16:
        return new SecP224R1Point(r0, r4, r10, new ECFieldElement[]{r12});
    L8:
        return r0.getInfinity();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint r2) {
        if (this != r2) goto L6;
        return threeTimes();
    L6:
        if (isInfinity() == false) goto L9;
        return r2;
    L9:
        if (r2.isInfinity() == false) goto L13;
        return twice();
    L13:
        if (this.y.isZero() == false) goto L16;
        return r2;
    L16:
        return twice().add(r2);
    }
}
