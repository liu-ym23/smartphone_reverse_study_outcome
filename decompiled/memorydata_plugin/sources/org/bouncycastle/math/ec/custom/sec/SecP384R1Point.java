package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;

/* JADX INFO: loaded from: classes7.dex */
public class SecP384R1Point extends ECPoint.AbstractFp {
    SecP384R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecP384R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint r17) {
        if (isInfinity() == false) goto L6;
        return r17;
    L6:
        if (r17.isInfinity() == false) goto L8;
        return this;
    L8:
        if (this == r17) goto L10;
        ECCurve r2 = getCurve();
        SecP384R1FieldElement r3 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r4 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r6 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getXCoord(), SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r7 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getYCoord(), SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r8 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r1 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getZCoord(0), SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r10 = Nat.create(24);
        int[] r11 = Nat.create(24);
        int[] r5 = Nat.create(24);
        int r12 = 12;
        int[] r13 = Nat.create(12);
        int[] r14 = Nat.create(12);
        boolean r15 = r8.isOne();
        if (r15 == false) goto L14;
        int[] r9 = r6.x;
        int[] r16 = r7.x;
    L15:
        boolean r18 = r1.isOne();
        if (r18 == false) goto L18;
        int[] r19 = r3.x;
        int[] r20 = r4.x;
    L19:
        int[] r0 = Nat.create(r12);
        SecP384R1Field.subtract(r19, r9, r0);
        int[] r21 = Nat.create(r12);
        SecP384R1Field.subtract(r20, r16, r21);
        if (Nat.isZero(r12, r0) == true) goto L22;
        SecP384R1Field.square(r0, r13, r10);
        int[] r22 = Nat.create(r12);
        SecP384R1Field.multiply(r13, r0, r22, r10);
        SecP384R1Field.multiply(r13, r19, r13, r10);
        SecP384R1Field.negate(r22, r22);
        Nat384.mul(r20, r22, r11);
        SecP384R1Field.reduce32(Nat.addBothTo(r12, r13, r13, r22), r22);
        SecP384R1FieldElement r23 = new SecP384R1FieldElement(r14);
        SecP384R1Field.square(r21, r23.x, r10);
        SecP384R1Field.subtract(r23.x, r22, r23.x);
        SecP384R1FieldElement r24 = new SecP384R1FieldElement(r22);
        SecP384R1Field.subtract(r13, r23.x, r24.x);
        Nat384.mul(r24.x, r21, r5);
        SecP384R1Field.addExt(r11, r5, r11);
        SecP384R1Field.reduce(r11, r24.x);
        SecP384R1FieldElement r25 = new SecP384R1FieldElement(r0);
        if (r15 == true) goto L30;
        SecP384R1Field.multiply(r25.x, r8.x, r25.x, r10);
    L30:
        if (r18 == true) goto L33;
        SecP384R1Field.multiply(r25.x, r1.x, r25.x, r10);
    L33:
        return new SecP384R1Point(r2, r23, r24, new ECFieldElement[]{r25});
    L22:
        if (Nat.isZero(r12, r21) == false) goto L26;
        return twice();
    L26:
        return r2.getInfinity();
    L18:
        SecP384R1Field.square(r1.x, r14, r10);
        SecP384R1Field.multiply(r14, r3.x, r11, r10);
        SecP384R1Field.multiply(r14, r1.x, r14, r10);
        SecP384R1Field.multiply(r14, r4.x, r14, r10);
        r19 = r11;
        r20 = r14;
        r12 = 12;
        goto L19
    L14:
        SecP384R1Field.square(r8.x, r13, r10);
        SecP384R1Field.multiply(r13, r6.x, r5, r10);
        SecP384R1Field.multiply(r13, r8.x, r13, r10);
        SecP384R1Field.multiply(r13, r7.x, r13, r10);
        r9 = r5;
        r16 = r13;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP384R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP384R1Point(this.curve, this.x, this.y.negate(), this.zs);
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
        SecP384R1FieldElement r1 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == true) goto L8;
        SecP384R1FieldElement r2 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP384R1FieldElement r13 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat.create(24);
        int[] r6 = Nat.create(12);
        int[] r7 = Nat.create(12);
        int[] r8 = Nat.create(12);
        SecP384R1Field.square(r1.x, r8, r3);
        int[] r9 = Nat.create(12);
        SecP384R1Field.square(r8, r9, r3);
        boolean r10 = r13.isOne();
        int[] r11 = r13.x;
        if (r10 == true) goto L12;
        SecP384R1Field.square(r13.x, r7, r3);
        r11 = r7;
    L12:
        SecP384R1Field.subtract(r2.x, r11, r6);
        SecP384R1Field.add(r2.x, r11, r7);
        SecP384R1Field.multiply(r7, r6, r7, r3);
        SecP384R1Field.reduce32(Nat.addBothTo(12, r7, r7, r7), r7);
        SecP384R1Field.multiply(r8, r2.x, r8, r3);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, r8, 2, 0), r8);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, r9, 3, 0, r6), r6);
        SecP384R1FieldElement r4 = new SecP384R1FieldElement(r9);
        SecP384R1Field.square(r7, r4.x, r3);
        SecP384R1Field.subtract(r4.x, r8, r4.x);
        SecP384R1Field.subtract(r4.x, r8, r4.x);
        SecP384R1FieldElement r5 = new SecP384R1FieldElement(r8);
        SecP384R1Field.subtract(r8, r4.x, r5.x);
        SecP384R1Field.multiply(r5.x, r7, r5.x, r3);
        SecP384R1Field.subtract(r5.x, r6, r5.x);
        SecP384R1FieldElement r12 = new SecP384R1FieldElement(r7);
        SecP384R1Field.twice(r1.x, r12.x);
        if (r10 == true) goto L16;
        SecP384R1Field.multiply(r12.x, r13.x, r12.x, r3);
    L16:
        return new SecP384R1Point(r0, r4, r5, new ECFieldElement[]{r12});
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
