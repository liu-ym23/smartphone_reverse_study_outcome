package org.bouncycastle.math.ec.custom.djb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes7.dex */
public class Curve25519Point extends ECPoint.AbstractFp {
    Curve25519Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    Curve25519Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
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
        Curve25519FieldElement r1 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.x, Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r2 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.y, Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r4 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r6 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r15.getXCoord(), Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r7 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r15.getYCoord(), Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r16 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r15.getZCoord(0), Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        int[] r3 = Nat256.createExt();
        int[] r8 = Nat256.create();
        int[] r9 = Nat256.create();
        int[] r10 = Nat256.create();
        boolean r11 = r4.isOne();
        if (r11 == false) goto L14;
        int[] r12 = r6.x;
        int[] r13 = r7.x;
    L15:
        boolean r14 = r16.isOne();
        if (r14 == false) goto L18;
        int[] r5 = r1.x;
        int[] r17 = r2.x;
    L19:
        int[] r18 = Nat256.create();
        Curve25519Field.subtract(r5, r12, r18);
        Curve25519Field.subtract(r17, r13, r8);
        if (Nat256.isZero(r18) == true) goto L22;
        int[] r19 = Nat256.create();
        Curve25519Field.square(r18, r19);
        int[] r20 = Nat256.create();
        Curve25519Field.multiply(r19, r18, r20);
        Curve25519Field.multiply(r19, r5, r9);
        Curve25519Field.negate(r20, r20);
        Nat256.mul(r17, r20, r3);
        Curve25519Field.reduce27(Nat256.addBothTo(r9, r9, r20), r20);
        Curve25519FieldElement r21 = new Curve25519FieldElement(r10);
        Curve25519Field.square(r8, r21.x);
        Curve25519Field.subtract(r21.x, r20, r21.x);
        Curve25519FieldElement r22 = new Curve25519FieldElement(r20);
        Curve25519Field.subtract(r9, r21.x, r22.x);
        Curve25519Field.multiplyAddToExt(r22.x, r8, r3);
        Curve25519Field.reduce(r3, r22.x);
        Curve25519FieldElement r23 = new Curve25519FieldElement(r18);
        if (r11 == true) goto L30;
        Curve25519Field.multiply(r23.x, r4.x, r23.x);
    L30:
        if (r14 == true) goto L32;
        Curve25519Field.multiply(r23.x, r16.x, r23.x);
    L32:
        if (r11 == false) goto L35;
        if (r14 == false) goto L35;
    L37:
        return new Curve25519Point(r0, r21, r22, new ECFieldElement[]{r23, calculateJacobianModifiedW(r23, r19)});
    L35:
        r19 = null;
        goto L37
    L22:
        if (Nat256.isZero(r8) == false) goto L26;
        return twice();
    L26:
        return r0.getInfinity();
    L18:
        Curve25519Field.square(r16.x, r10);
        Curve25519Field.multiply(r10, r1.x, r3);
        Curve25519Field.multiply(r10, r16.x, r10);
        Curve25519Field.multiply(r10, r2.x, r10);
        r5 = r3;
        r17 = r10;
        goto L19
    L14:
        Curve25519Field.square(r4.x, r9);
        Curve25519Field.multiply(r9, r6.x, r8);
        Curve25519Field.multiply(r9, r4.x, r9);
        Curve25519Field.multiply(r9, r7.x, r9);
        r12 = r8;
        r13 = r9;
        goto L15
    L10:
        return twice();
    }

    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement r3, int[] r4) {
        Curve25519FieldElement r2 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(getCurve().getA(), Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        if (r3.isOne() == false) goto L5;
        return r2;
    L5:
        Curve25519FieldElement r0 = new Curve25519FieldElement();
        if (r4 != null) goto L8;
        r4 = r0.x;
        Curve25519Field.square(r3.x, r4);
    L8:
        Curve25519Field.square(r4, r0.x);
        Curve25519Field.multiply(r0.x, r2.x, r0.x);
        return r0;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new Curve25519Point(null, getAffineXCoord(), getAffineYCoord());
    }

    public Curve25519FieldElement getJacobianModifiedW() {
        Curve25519FieldElement r0 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.zs[1], Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ECFieldElement[] r1 = this.zs;
        Curve25519FieldElement r5 = calculateJacobianModifiedW((Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], Curve25519FieldElement.class, "com.obric.memorydata.plugin"), null);
        r1[1] = r5;
        return r5;
    L6:
        return r0;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECFieldElement getZCoord(int r2) {
        if (r2 != 1) goto L7;
        return getJacobianModifiedW();
    L7:
        return super.getZCoord(r2);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new Curve25519Point(getCurve(), this.x, this.y.negate(), this.zs);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        if (this.y.isZero() == false) goto L9;
        return this;
    L9:
        return twiceJacobianModified(false).add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r0 = getCurve();
        if (this.y.isZero() == false) goto L10;
        return r0.getInfinity();
    L10:
        return twiceJacobianModified(true);
    }

    public Curve25519Point twiceJacobianModified(boolean r12) {
        Curve25519FieldElement r0 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.x, Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r1 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.y, Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r2 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(this.zs[0], Curve25519FieldElement.class, "com.obric.memorydata.plugin");
        Curve25519FieldElement r3 = getJacobianModifiedW();
        int[] r5 = Nat256.create();
        Curve25519Field.square(r0.x, r5);
        Curve25519Field.reduce27(Nat256.addBothTo(r5, r5, r5) + Nat256.addTo(r3.x, r5), r5);
        int[] r6 = Nat256.create();
        Curve25519Field.twice(r1.x, r6);
        int[] r7 = Nat256.create();
        Curve25519Field.multiply(r6, r1.x, r7);
        int[] r4 = Nat256.create();
        Curve25519Field.multiply(r7, r0.x, r4);
        Curve25519Field.twice(r4, r4);
        int[] r8 = Nat256.create();
        Curve25519Field.square(r7, r8);
        Curve25519Field.twice(r8, r8);
        Curve25519FieldElement r9 = new Curve25519FieldElement(r7);
        Curve25519Field.square(r5, r9.x);
        Curve25519Field.subtract(r9.x, r4, r9.x);
        Curve25519Field.subtract(r9.x, r4, r9.x);
        Curve25519FieldElement r10 = new Curve25519FieldElement(r4);
        Curve25519Field.subtract(r4, r9.x, r10.x);
        Curve25519Field.multiply(r10.x, r5, r10.x);
        Curve25519Field.subtract(r10.x, r8, r10.x);
        Curve25519FieldElement r11 = new Curve25519FieldElement(r6);
        if (Nat256.isOne(r2.x) == true) goto L5;
        Curve25519Field.multiply(r11.x, r2.x, r11.x);
    L5:
        Curve25519FieldElement r13 = null;
        if (r12 == false) goto L9;
        r13 = new Curve25519FieldElement(r8);
        Curve25519Field.multiply(r13.x, r3.x, r13.x);
        Curve25519Field.twice(r13.x, r13.x);
    L9:
        return new Curve25519Point(getCurve(), r9, r10, new ECFieldElement[]{r11, r13});
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
        return twiceJacobianModified(false).add(r2);
    }
}
