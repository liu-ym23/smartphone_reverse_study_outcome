package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes7.dex */
public class SecP192K1Point extends ECPoint.AbstractFp {
    SecP192K1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecP192K1Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
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
        SecP192K1FieldElement r1 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r2 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r4 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(r15.getXCoord(), SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r5 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(r15.getYCoord(), SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r6 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r16 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(r15.getZCoord(0), SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat192.createExt();
        int[] r8 = Nat192.create();
        int[] r9 = Nat192.create();
        int[] r10 = Nat192.create();
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
        int[] r18 = Nat192.create();
        SecP192K1Field.subtract(r14, r7, r18);
        SecP192K1Field.subtract(r17, r12, r8);
        if (Nat192.isZero(r18) == true) goto L22;
        SecP192K1Field.square(r18, r9);
        int[] r19 = Nat192.create();
        SecP192K1Field.multiply(r9, r18, r19);
        SecP192K1Field.multiply(r9, r14, r9);
        SecP192K1Field.negate(r19, r19);
        Nat192.mul(r17, r19, r3);
        SecP192K1Field.reduce32(Nat192.addBothTo(r9, r9, r19), r19);
        SecP192K1FieldElement r20 = new SecP192K1FieldElement(r10);
        SecP192K1Field.square(r8, r20.x);
        SecP192K1Field.subtract(r20.x, r19, r20.x);
        SecP192K1FieldElement r21 = new SecP192K1FieldElement(r19);
        SecP192K1Field.subtract(r9, r20.x, r21.x);
        SecP192K1Field.multiplyAddToExt(r21.x, r8, r3);
        SecP192K1Field.reduce(r3, r21.x);
        SecP192K1FieldElement r110 = new SecP192K1FieldElement(r18);
        if (r11 == true) goto L30;
        SecP192K1Field.multiply(r110.x, r6.x, r110.x);
    L30:
        if (r13 == true) goto L33;
        SecP192K1Field.multiply(r110.x, r16.x, r110.x);
    L33:
        return new SecP192K1Point(r0, r20, r21, new ECFieldElement[]{r110});
    L22:
        if (Nat192.isZero(r8) == false) goto L26;
        return twice();
    L26:
        return r0.getInfinity();
    L18:
        SecP192K1Field.square(r16.x, r10);
        SecP192K1Field.multiply(r10, r1.x, r3);
        SecP192K1Field.multiply(r10, r16.x, r10);
        SecP192K1Field.multiply(r10, r2.x, r10);
        r14 = r3;
        r17 = r10;
        goto L19
    L14:
        SecP192K1Field.square(r6.x, r9);
        SecP192K1Field.multiply(r9, r4.x, r8);
        SecP192K1Field.multiply(r9, r6.x, r9);
        SecP192K1Field.multiply(r9, r5.x, r9);
        r7 = r8;
        r12 = r9;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP192K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP192K1Point(this.curve, this.x, this.y.negate(), this.zs);
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
        SecP192K1FieldElement r1 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.y, SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        if (r1.isZero() == true) goto L8;
        SecP192K1FieldElement r2 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.x, SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        SecP192K1FieldElement r10 = (SecP192K1FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], SecP192K1FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat192.create();
        SecP192K1Field.square(r1.x, r3);
        int[] r5 = Nat192.create();
        SecP192K1Field.square(r3, r5);
        int[] r6 = Nat192.create();
        SecP192K1Field.square(r2.x, r6);
        SecP192K1Field.reduce32(Nat192.addBothTo(r6, r6, r6), r6);
        SecP192K1Field.multiply(r3, r2.x, r3);
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, r3, 2, 0), r3);
        int[] r4 = Nat192.create();
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, r5, 3, 0, r4), r4);
        SecP192K1FieldElement r7 = new SecP192K1FieldElement(r5);
        SecP192K1Field.square(r6, r7.x);
        SecP192K1Field.subtract(r7.x, r3, r7.x);
        SecP192K1Field.subtract(r7.x, r3, r7.x);
        SecP192K1FieldElement r8 = new SecP192K1FieldElement(r3);
        SecP192K1Field.subtract(r3, r7.x, r8.x);
        SecP192K1Field.multiply(r8.x, r6, r8.x);
        SecP192K1Field.subtract(r8.x, r4, r8.x);
        SecP192K1FieldElement r9 = new SecP192K1FieldElement(r6);
        SecP192K1Field.twice(r1.x, r9.x);
        if (r10.isOne() == true) goto L13;
        SecP192K1Field.multiply(r9.x, r10.x, r9.x);
    L13:
        return new SecP192K1Point(r0, r7, r8, new ECFieldElement[]{r9});
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
