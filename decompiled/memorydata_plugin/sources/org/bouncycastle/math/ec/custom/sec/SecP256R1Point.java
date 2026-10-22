package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes7.dex */
public class SecP256R1Point extends ECPoint.AbstractFp {
    SecP256R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecP256R1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
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
        SecP256R1FieldElement r3 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r4 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r6 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getXCoord(), SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r7 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getYCoord(), SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r8 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r1 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r17.getZCoord(0), SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r5 = Nat256.createExt();
        int[] r10 = Nat256.createExt();
        int[] r11 = Nat256.create();
        int[] r12 = Nat256.create();
        int[] r13 = Nat256.create();
        boolean r14 = r8.isOne();
        if (r14 == false) goto L14;
        int[] r9 = r6.x;
        int[] r15 = r7.x;
    L15:
        boolean r16 = r1.isOne();
        if (r16 == false) goto L18;
        int[] r18 = r3.x;
        int[] r19 = r4.x;
    L19:
        int[] r20 = Nat256.create();
        SecP256R1Field.subtract(r18, r9, r20);
        SecP256R1Field.subtract(r19, r15, r11);
        if (Nat256.isZero(r20) == true) goto L22;
        SecP256R1Field.square(r20, r12, r5);
        int[] r0 = Nat256.create();
        SecP256R1Field.multiply(r12, r20, r0, r5);
        SecP256R1Field.multiply(r12, r18, r12, r5);
        SecP256R1Field.negate(r0, r0);
        Nat256.mul(r19, r0, r10);
        SecP256R1Field.reduce32(Nat256.addBothTo(r12, r12, r0), r0);
        SecP256R1FieldElement r21 = new SecP256R1FieldElement(r13);
        SecP256R1Field.square(r11, r21.x, r5);
        SecP256R1Field.subtract(r21.x, r0, r21.x);
        SecP256R1FieldElement r22 = new SecP256R1FieldElement(r0);
        SecP256R1Field.subtract(r12, r21.x, r22.x);
        SecP256R1Field.multiplyAddToExt(r22.x, r11, r10);
        SecP256R1Field.reduce(r10, r22.x);
        SecP256R1FieldElement r23 = new SecP256R1FieldElement(r20);
        if (r14 == true) goto L30;
        SecP256R1Field.multiply(r23.x, r8.x, r23.x, r5);
    L30:
        if (r16 == true) goto L33;
        SecP256R1Field.multiply(r23.x, r1.x, r23.x, r5);
    L33:
        return new SecP256R1Point(r2, r21, r22, new ECFieldElement[]{r23});
    L22:
        if (Nat256.isZero(r11) == false) goto L26;
        return twice();
    L26:
        return r2.getInfinity();
    L18:
        SecP256R1Field.square(r1.x, r13, r5);
        SecP256R1Field.multiply(r13, r3.x, r10, r5);
        SecP256R1Field.multiply(r13, r1.x, r13, r5);
        SecP256R1Field.multiply(r13, r4.x, r13, r5);
        r18 = r10;
        r19 = r13;
        goto L19
    L14:
        SecP256R1Field.square(r8.x, r12, r5);
        SecP256R1Field.multiply(r12, r6.x, r11, r5);
        SecP256R1Field.multiply(r12, r8.x, r12, r5);
        SecP256R1Field.multiply(r12, r7.x, r12, r5);
        r9 = r11;
        r15 = r12;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP256R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP256R1Point(this.curve, this.x, this.y.negate(), this.zs);
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
        SecP256R1FieldElement r1 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == true) goto L8;
        SecP256R1FieldElement r2 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        SecP256R1FieldElement r12 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat256.createExt();
        int[] r5 = Nat256.create();
        int[] r6 = Nat256.create();
        int[] r7 = Nat256.create();
        SecP256R1Field.square(r1.x, r7, r3);
        int[] r8 = Nat256.create();
        SecP256R1Field.square(r7, r8, r3);
        boolean r9 = r12.isOne();
        int[] r10 = r12.x;
        if (r9 == true) goto L12;
        SecP256R1Field.square(r12.x, r6, r3);
        r10 = r6;
    L12:
        SecP256R1Field.subtract(r2.x, r10, r5);
        SecP256R1Field.add(r2.x, r10, r6);
        SecP256R1Field.multiply(r6, r5, r6, r3);
        SecP256R1Field.reduce32(Nat256.addBothTo(r6, r6, r6), r6);
        SecP256R1Field.multiply(r7, r2.x, r7, r3);
        SecP256R1Field.reduce32(Nat.shiftUpBits(8, r7, 2, 0), r7);
        SecP256R1Field.reduce32(Nat.shiftUpBits(8, r8, 3, 0, r5), r5);
        SecP256R1FieldElement r4 = new SecP256R1FieldElement(r8);
        SecP256R1Field.square(r6, r4.x, r3);
        SecP256R1Field.subtract(r4.x, r7, r4.x);
        SecP256R1Field.subtract(r4.x, r7, r4.x);
        SecP256R1FieldElement r11 = new SecP256R1FieldElement(r7);
        SecP256R1Field.subtract(r7, r4.x, r11.x);
        SecP256R1Field.multiply(r11.x, r6, r11.x, r3);
        SecP256R1Field.subtract(r11.x, r5, r11.x);
        SecP256R1FieldElement r13 = new SecP256R1FieldElement(r6);
        SecP256R1Field.twice(r1.x, r13.x);
        if (r9 == true) goto L16;
        SecP256R1Field.multiply(r13.x, r12.x, r13.x, r3);
    L16:
        return new SecP256R1Point(r0, r4, r11, new ECFieldElement[]{r13});
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
