package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class SecT113R2Point extends ECPoint.AbstractF2m {
    SecT113R2Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
        super(r1, r2, r3);
    }

    SecT113R2Point(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint r14) {
        if (isInfinity() == false) goto L6;
        return r14;
    L6:
        if (r14.isInfinity() == false) goto L8;
        return this;
    L8:
        ECCurve r0 = getCurve();
        ECFieldElement r1 = this.x;
        ECFieldElement r2 = r14.getRawXCoord();
        if (r1.isZero() == true) goto L11;
        ECFieldElement r3 = this.y;
        ECFieldElement r4 = this.zs[0];
        ECFieldElement r6 = r14.getRawYCoord();
        ECFieldElement r15 = r14.getZCoord(0);
        boolean r7 = r4.isOne();
        if (r7 == true) goto L19;
        ECFieldElement r8 = r2.multiply(r4);
        ECFieldElement r9 = r6.multiply(r4);
    L20:
        boolean r10 = r15.isOne();
        if (r10 == true) goto L23;
        r1 = r1.multiply(r15);
        ECFieldElement r11 = r3.multiply(r15);
    L24:
        ECFieldElement r12 = r11.add(r9);
        ECFieldElement r13 = r1.add(r8);
        if (r13.isZero() == false) goto L33;
        if (r12.isZero() == false) goto L31;
        return twice();
    L31:
        return r0.getInfinity();
    L33:
        if (r2.isZero() == false) goto L39;
        ECPoint r16 = normalize();
        ECFieldElement r17 = r16.getXCoord();
        ECFieldElement r18 = r16.getYCoord();
        ECFieldElement r5 = r18.add(r6).divide(r17);
        ECFieldElement r19 = r5.square().add(r5).add(r17).add(r0.getA());
        if (r19.isZero() == true) goto L37;
        ECFieldElement r110 = r5.multiply(r17.add(r19)).add(r19).add(r18).divide(r19).add(r19);
        ECFieldElement r111 = r0.fromBigInteger(ECConstants.ONE);
    L52:
        return new SecT113R2Point(r0, r19, r110, new ECFieldElement[]{r111});
    L37:
        return new SecT113R2Point(r0, r19, r0.getB().sqrt());
    L39:
        ECFieldElement r112 = r13.square();
        ECFieldElement r20 = r12.multiply(r1);
        ECFieldElement r21 = r12.multiply(r8);
        ECFieldElement r22 = r20.multiply(r21);
        if (r22.isZero() == true) goto L42;
        ECFieldElement r23 = r12.multiply(r112);
        if (r10 == true) goto L46;
        r111 = r23.multiply(r15);
    L47:
        r110 = r21.add(r112).squarePlusProduct(r111, r3.add(r4));
        if (r7 == true) goto L50;
        r111 = r111.multiply(r4);
    L50:
        r19 = r22;
        goto L52
    L46:
        r111 = r23;
        goto L47
    L42:
        return new SecT113R2Point(r0, r22, r0.getB().sqrt());
    L23:
        r11 = r3;
        goto L24
    L19:
        r8 = r2;
        r9 = r6;
        goto L20
    L11:
        if (r2.isZero() == false) goto L15;
        return r0.getInfinity();
    L15:
        return r14.add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecT113R2Point(null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT113R2Point(this.curve, r0, r1.add(r2), new ECFieldElement[]{r2});
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
        ECFieldElement r8 = this.zs[0];
        boolean r4 = r8.isOne();
        if (r4 == false) goto L12;
        ECFieldElement r5 = r2;
    L13:
        if (r4 == false) goto L15;
        ECFieldElement r6 = r8;
    L16:
        ECFieldElement r7 = r0.getA();
        if (r4 == true) goto L20;
        r7 = r7.multiply(r6);
    L20:
        ECFieldElement r3 = r2.square().add(r5).add(r7);
        if (r3.isZero() == true) goto L23;
        ECFieldElement r9 = r3.square();
        if (r4 == false) goto L27;
        ECFieldElement r10 = r3;
    L28:
        if (r4 == true) goto L32;
        r1 = r1.multiply(r8);
    L32:
        return new SecT113R2Point(r0, r9, r1.squarePlusProduct(r3, r5).add(r9).add(r10), new ECFieldElement[]{r10});
    L27:
        r10 = r3.multiply(r6);
        goto L28
    L23:
        return new SecT113R2Point(r0, r3, r0.getB().sqrt());
    L15:
        r6 = r8.square();
        goto L16
    L12:
        r5 = r2.multiply(r8);
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
        ECFieldElement r11 = r0.getA().multiply(r10).add(r7).add(r5.multiply(r8));
        ECFieldElement r12 = r6.addOne();
        ECFieldElement r13 = r0.getA().add(r12).multiply(r10).add(r7).multiplyPlusProduct(r11, r3, r10);
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
        return new SecT113R2Point(r0, r16, r13.add(r15).square().multiplyPlusProduct(r11, r12, r17), new ECFieldElement[]{r17});
    L28:
        return new SecT113R2Point(r0, r13, r0.getB().sqrt());
    L32:
        return twice().add(r9);
    L8:
        return twice();
    }
}
