package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = null;
    protected ECCurve curve;
    protected Hashtable preCompTable;
    protected ECFieldElement x;
    protected ECFieldElement y;
    protected ECFieldElement[] zs;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
            super(r1, r2, r3);
        }

        public AbstractF2m(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
            super(r1, r2, r3, r4);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECCurve r0 = getCurve();
            ECFieldElement r1 = this.x;
            ECFieldElement r2 = r0.getA();
            ECFieldElement r3 = r0.getB();
            int r4 = r0.getCoordinateSystem();
            if (r4 != 6) goto L17;
            ECFieldElement r5 = this.zs[0];
            boolean r6 = r5.isOne();
            boolean r7 = r1.isZero();
            ECFieldElement r8 = this.y;
            if (r7 == false) goto L11;
            ECFieldElement r9 = r8.square();
            if (r6 == true) goto L10;
            r3 = r3.multiply(r5.square());
        L10:
            return r9.equals(r3);
        L11:
            ECFieldElement r10 = r1.square();
            if (r6 == false) goto L14;
            ECFieldElement r11 = r8.square().add(r8).add(r2);
            ECFieldElement r12 = r10.square().add(r3);
        L16:
            return r11.multiply(r10).equals(r12);
        L14:
            ECFieldElement r13 = r5.square();
            ECFieldElement r14 = r13.square();
            r11 = r8.add(r5).multiplyPlusProduct(r8, r2, r13);
            r12 = r10.squarePlusProduct(r3, r14);
            goto L16
        L17:
            ECFieldElement r15 = this.y;
            ECFieldElement r16 = r15.add(r1).multiply(r15);
            if (r4 == 0) goto L27;
            if (r4 != 1) goto L25;
            ECFieldElement r17 = this.zs[0];
            if (r17.isOne() == true) goto L27;
            ECFieldElement r18 = r17.multiply(r17.square());
            r16 = r16.multiply(r17);
            r2 = r2.multiply(r17);
            r3 = r3.multiply(r18);
            goto L27
        L25:
            throw new IllegalStateException("unsupported coordinate system");
        L27:
            return r16.equals(r1.add(r2).multiply(r1.square()).add(r3));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesOrder() {
            BigInteger r0 = this.curve.getCofactor();
            if (ECConstants.TWO.equals(r0) == false) goto L10;
            if (((ECFieldElement.AbstractF2m) ZeusTransformUtils.preCheckCast(normalize().getAffineXCoord(), ECFieldElement.AbstractF2m.class, "com.obric.memorydata.plugin")).trace() == 0) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (ECConstants.FOUR.equals(r0) == false) goto L20;
            ECPoint r1 = normalize();
            ECFieldElement r2 = r1.getAffineXCoord();
            ECFieldElement r7 = ((ECCurve.AbstractF2m) ZeusTransformUtils.preCheckCast(this.curve, ECCurve.AbstractF2m.class, "com.obric.memorydata.plugin")).solveQuadraticEquation(r2.add(this.curve.getA()));
            if (r7 != null) goto L14;
            return false;
        L14:
            ECFieldElement r3 = r1.getAffineYCoord();
            if (((ECFieldElement.AbstractF2m) ZeusTransformUtils.preCheckCast(r2.multiply(r7).add(r3), ECFieldElement.AbstractF2m.class, "com.obric.memorydata.plugin")).trace() != 0) goto L18;
            return true;
        L18:
            return false;
        L20:
            return super.satisfiesOrder();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleX(ECFieldElement r6) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            int r0 = getCurveCoordinateSystem();
            if (r0 != 5) goto L8;
            ECFieldElement r1 = getRawXCoord();
            ECFieldElement r2 = getRawYCoord();
            return getCurve().createRawPoint(r1, r2.add(r1).divide(r6).add(r1.multiply(r6)), getRawZCoords());
        L8:
            if (r0 != 6) goto L10;
            ECFieldElement r3 = getRawXCoord();
            ECFieldElement r4 = getRawYCoord();
            ECFieldElement r5 = getRawZCoords()[0];
            ECFieldElement r7 = r3.multiply(r6.square());
            ECFieldElement r8 = r4.add(r3).add(r7);
            ECFieldElement r9 = r5.multiply(r6);
            return getCurve().createRawPoint(r7, r8, new ECFieldElement[]{r9});
        L10:
            return super.scaleX(r6);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleY(ECFieldElement r3) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            int r0 = getCurveCoordinateSystem();
            if (r0 != 5) goto L8;
        L11:
            ECFieldElement r1 = getRawXCoord();
            ECFieldElement r4 = getRawYCoord().add(r1).multiply(r3).add(r1);
            return getCurve().createRawPoint(r1, r4, getRawZCoords());
        L8:
            if (r0 == 6) goto L11;
            return super.scaleY(r3);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint r2) {
            if (r2.isInfinity() == false) goto L6;
            return this;
        L6:
            return add(r2.negate());
        }

        public AbstractF2m tauPow(int r8) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r1 = getCurve();
            int r2 = r1.getCoordinateSystem();
            ECFieldElement r3 = this.x;
            if (r2 != 0) goto L8;
        L19:
            ECPoint r7 = r1.createRawPoint(r3.squarePow(r8), this.y.squarePow(r8));
        L18:
            return (AbstractF2m) ZeusTransformUtils.preCheckCast(r7, AbstractF2m.class, "com.obric.memorydata.plugin");
        L8:
            if (r2 != 1) goto L10;
        L16:
            ECFieldElement r4 = this.y;
            ECFieldElement r9 = this.zs[0];
            r7 = r1.createRawPoint(r3.squarePow(r8), r4.squarePow(r8), new ECFieldElement[]{r9.squarePow(r8)});
            goto L18
        L10:
            if (r2 == 5) goto L19;
            if (r2 == 6) goto L16;
            throw new IllegalStateException("unsupported coordinate system");
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
            super(r1, r2, r3);
        }

        public AbstractFp(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
            super(r1, r2, r3, r4);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement r0 = this.x;
            ECFieldElement r1 = this.y;
            ECFieldElement r2 = this.curve.getA();
            ECFieldElement r3 = this.curve.getB();
            ECFieldElement r4 = r1.square();
            int r5 = getCurveCoordinateSystem();
            if (r5 == 0) goto L22;
            if (r5 != 1) goto L7;
            ECFieldElement r7 = this.zs[0];
            if (r7.isOne() == true) goto L22;
            ECFieldElement r6 = r7.square();
            ECFieldElement r8 = r7.multiply(r6);
            r4 = r4.multiply(r7);
            r2 = r2.multiply(r6);
            r3 = r3.multiply(r8);
            goto L22
        L7:
            if (r5 != 2) goto L9;
        L15:
            ECFieldElement r9 = this.zs[0];
            if (r9.isOne() == true) goto L22;
            ECFieldElement r10 = r9.square();
            ECFieldElement r11 = r10.square();
            ECFieldElement r12 = r10.multiply(r11);
            r2 = r2.multiply(r11);
            r3 = r3.multiply(r12);
            goto L22
        L9:
            if (r5 == 3) goto L15;
            if (r5 == 4) goto L15;
            throw new IllegalStateException("unsupported coordinate system");
        L22:
            return r4.equals(r0.square().add(r2).multiply(r0).add(r3));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint r2) {
            if (r2.isInfinity() == false) goto L6;
            return this;
        L6:
            return add(r2.negate());
        }
    }

    public static class F2m extends AbstractF2m {
        F2m(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
            super(r1, r2, r3);
        }

        F2m(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
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
            ECCurve r0 = getCurve();
            int r1 = r0.getCoordinateSystem();
            ECFieldElement r2 = this.x;
            ECFieldElement r3 = r15.x;
            if (r1 != 0) goto L11;
            ECFieldElement r4 = this.y;
            ECFieldElement r16 = r15.y;
            ECFieldElement r5 = r2.add(r3);
            ECFieldElement r17 = r4.add(r16);
            if (r5.isZero() == true) goto L89;
            ECFieldElement r14 = r17.divide(r5);
            ECFieldElement r18 = r14.square().add(r14).add(r5).add(r0.getA());
            return new F2m(r0, r18, r14.multiply(r2.add(r18)).add(r18).add(r4));
        L89:
            if (r17.isZero() == false) goto L93;
            return twice();
        L93:
            return r0.getInfinity();
        L11:
            if (r1 != 1) goto L13;
            ECFieldElement r6 = this.y;
            ECFieldElement r7 = this.zs[0];
            ECFieldElement r8 = r15.y;
            ECFieldElement r19 = r15.zs[0];
            boolean r9 = r19.isOne();
            ECFieldElement r10 = r7.multiply(r8);
            if (r9 == false) goto L63;
            ECFieldElement r11 = r6;
        L64:
            ECFieldElement r12 = r10.add(r11);
            ECFieldElement r13 = r7.multiply(r3);
            if (r9 == false) goto L67;
            ECFieldElement r20 = r2;
        L68:
            ECFieldElement r21 = r13.add(r20);
            if (r21.isZero() == true) goto L71;
            ECFieldElement r110 = r21.square();
            ECFieldElement r22 = r110.multiply(r21);
            if (r9 == true) goto L80;
            r7 = r7.multiply(r19);
        L80:
            ECFieldElement r111 = r12.add(r21);
            ECFieldElement r112 = r111.multiplyPlusProduct(r12, r110, r0.getA()).multiply(r7).add(r22);
            ECFieldElement r113 = r21.multiply(r112);
            if (r9 == true) goto L85;
            r110 = r110.multiply(r19);
        L85:
            return new F2m(r0, r113, r12.multiplyPlusProduct(r2, r21, r6).multiplyPlusProduct(r110, r111, r112), new ECFieldElement[]{r22.multiply(r7)});
        L71:
            if (r12.isZero() == false) goto L75;
            return twice();
        L75:
            return r0.getInfinity();
        L67:
            r20 = r2.multiply(r19);
            goto L68
        L63:
            r11 = r6.multiply(r19);
            goto L64
        L13:
            if (r1 != 6) goto L59;
            if (r2.isZero() == true) goto L17;
            ECFieldElement r23 = this.y;
            ECFieldElement r24 = this.zs[0];
            ECFieldElement r25 = r15.y;
            ECFieldElement r114 = r15.zs[0];
            boolean r26 = r24.isOne();
            if (r26 == true) goto L25;
            ECFieldElement r27 = r3.multiply(r24);
            ECFieldElement r115 = r25.multiply(r24);
        L26:
            boolean r116 = r114.isOne();
            if (r116 == true) goto L29;
            r2 = r2.multiply(r114);
            ECFieldElement r117 = r23.multiply(r114);
        L30:
            ECFieldElement r118 = r117.add(r115);
            ECFieldElement r119 = r2.add(r27);
            if (r119.isZero() == false) goto L39;
            if (r118.isZero() == false) goto L37;
            return twice();
        L37:
            return r0.getInfinity();
        L39:
            if (r3.isZero() == false) goto L45;
            ECPoint r120 = normalize();
            ECFieldElement r121 = r120.getXCoord();
            ECFieldElement r122 = r120.getYCoord();
            ECFieldElement r28 = r122.add(r25).divide(r121);
            ECFieldElement r29 = r28.square().add(r28).add(r121).add(r0.getA());
            if (r29.isZero() == true) goto L43;
            ECFieldElement r123 = r28.multiply(r121.add(r29)).add(r29).add(r122).divide(r29).add(r29);
            ECFieldElement r124 = r0.fromBigInteger(ECConstants.ONE);
        L57:
            return new F2m(r0, r29, r123, new ECFieldElement[]{r124});
        L43:
            return new F2m(r0, r29, r0.getB().sqrt());
        L45:
            ECFieldElement r125 = r119.square();
            ECFieldElement r30 = r118.multiply(r2);
            ECFieldElement r31 = r118.multiply(r27);
            r29 = r30.multiply(r31);
            if (r29.isZero() == true) goto L48;
            ECFieldElement r32 = r118.multiply(r125);
            if (r116 == true) goto L52;
            r124 = r32.multiply(r114);
        L53:
            r123 = r31.add(r125).squarePlusProduct(r124, r23.add(r24));
            if (r26 == true) goto L57;
            r124 = r124.multiply(r24);
            goto L57
        L52:
            r124 = r32;
            goto L53
        L48:
            return new F2m(r0, r29, r0.getB().sqrt());
        L29:
            r117 = r23;
            goto L30
        L25:
            r27 = r3;
            r115 = r25;
            goto L26
        L17:
            if (r3.isZero() == false) goto L21;
            return r0.getInfinity();
        L21:
            return r15.add(this);
        L59:
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint detach() {
            return new F2m(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            ECFieldElement r0 = getRawXCoord();
            if (r0.isZero() == false) goto L5;
            return false;
        L5:
            ECFieldElement r1 = getRawYCoord();
            int r4 = getCurveCoordinateSystem();
            if (r4 == 5) goto L12;
            if (r4 == 6) goto L12;
            return r1.divide(r0).testBitZero();
        L12:
            if (r1.testBitZero() == r0.testBitZero()) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getYCoord() {
            int r0 = getCurveCoordinateSystem();
            if (r0 == 5) goto L7;
            if (r0 == 6) goto L7;
            return this.y;
        L7:
            ECFieldElement r1 = this.x;
            ECFieldElement r3 = this.y;
            if (isInfinity() == false) goto L10;
        L18:
            return r3;
        L10:
            if (r1.isZero() == true) goto L18;
            ECFieldElement r2 = r3.add(r1).multiply(r1);
            if (6 != r0) goto L19;
            ECFieldElement r5 = this.zs[0];
            if (r5.isOne() == false) goto L17;
            return r2;
        L17:
            return r2.divide(r5);
        L19:
            return r2;
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
            int r1 = getCurveCoordinateSystem();
            if (r1 == 0) goto L25;
            if (r1 != 1) goto L13;
            ECFieldElement r2 = this.y;
            ECFieldElement r4 = this.zs[0];
            return new F2m(this.curve, r0, r2.add(r0), new ECFieldElement[]{r4});
        L13:
            if (r1 == 5) goto L21;
            if (r1 != 6) goto L19;
            ECFieldElement r3 = this.y;
            ECFieldElement r5 = this.zs[0];
            return new F2m(this.curve, r0, r3.add(r5), new ECFieldElement[]{r5});
        L19:
            throw new IllegalStateException("unsupported coordinate system");
        L21:
            return new F2m(this.curve, r0, this.y.addOne());
        L25:
            return new F2m(this.curve, r0, this.y.add(r0));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r1 = getCurve();
            ECFieldElement r2 = this.x;
            if (r2.isZero() == true) goto L8;
            int r3 = r1.getCoordinateSystem();
            if (r3 != 0) goto L12;
            ECFieldElement r0 = this.y.divide(r2).add(r2);
            ECFieldElement r4 = r0.square().add(r0).add(r1.getA());
            return new F2m(r1, r4, r2.squarePlusProduct(r4, r0.addOne()));
        L12:
            if (r3 != 1) goto L14;
            ECFieldElement r5 = this.y;
            ECFieldElement r6 = this.zs[0];
            boolean r7 = r6.isOne();
            if (r7 == false) goto L58;
            ECFieldElement r8 = r2;
        L59:
            if (r7 == true) goto L62;
            r5 = r5.multiply(r6);
        L62:
            ECFieldElement r9 = r2.square();
            ECFieldElement r10 = r9.add(r5);
            ECFieldElement r11 = r8.square();
            ECFieldElement r12 = r10.add(r8);
            ECFieldElement r13 = r12.multiplyPlusProduct(r10, r11, r1.getA());
            return new F2m(r1, r8.multiply(r13), r9.square().multiplyPlusProduct(r8, r13, r12), new ECFieldElement[]{r8.multiply(r11)});
        L58:
            r8 = r2.multiply(r6);
            goto L59
        L14:
            if (r3 != 6) goto L54;
            ECFieldElement r14 = this.y;
            ECFieldElement r15 = this.zs[0];
            boolean r16 = r15.isOne();
            if (r16 == false) goto L18;
            ECFieldElement r17 = r14;
        L19:
            if (r16 == false) goto L21;
            ECFieldElement r18 = r15;
        L22:
            ECFieldElement r19 = r1.getA();
            if (r16 == false) goto L25;
            ECFieldElement r110 = r19;
        L26:
            ECFieldElement r111 = r14.square().add(r17).add(r110);
            if (r111.isZero() == true) goto L29;
            ECFieldElement r112 = r111.square();
            if (r16 == false) goto L33;
            ECFieldElement r113 = r111;
        L34:
            ECFieldElement r114 = r1.getB();
            if (r114.bitLength() >= (r1.getFieldSize() >> 1)) goto L46;
            ECFieldElement r20 = r14.add(r2).square();
            if (r114.isOne() == false) goto L39;
            ECFieldElement r21 = r110.add(r18).square();
        L40:
            ECFieldElement r22 = r20.add(r111).add(r18).multiply(r20).add(r21).add(r112);
            if (r19.isZero() == false) goto L44;
        L50:
            r22 = r22.add(r113);
        L52:
            return new F2m(r1, r112, r22, new ECFieldElement[]{r113});
        L44:
            if (r19.isOne() == true) goto L52;
            r22 = r22.add(r19.addOne().multiply(r113));
            goto L52
        L39:
            r21 = r110.squarePlusProduct(r114, r18.square());
            goto L40
        L46:
            if (r16 == true) goto L49;
            r2 = r2.multiply(r15);
        L49:
            r22 = r2.squarePlusProduct(r111, r17).add(r112);
            goto L50
        L33:
            r113 = r111.multiply(r18);
            goto L34
        L29:
            return new F2m(r1, r111, r1.getB().sqrt());
        L25:
            r110 = r19.multiply(r18);
            goto L26
        L21:
            r18 = r15.square();
            goto L22
        L18:
            r17 = r14.multiply(r15);
            goto L19
        L54:
            throw new IllegalStateException("unsupported coordinate system");
        L8:
            return r1.getInfinity();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint r9) {
            if (isInfinity() == false) goto L6;
            return r9;
        L6:
            if (r9.isInfinity() == true) goto L8;
            ECCurve r0 = getCurve();
            ECFieldElement r1 = this.x;
            if (r1.isZero() == false) goto L13;
            return r9;
        L13:
            if (r0.getCoordinateSystem() != 6) goto L15;
            ECFieldElement r2 = r9.x;
            ECFieldElement r3 = r9.zs[0];
            if (r2.isZero() == true) goto L36;
            if (r3.isOne() == false) goto L36;
            ECFieldElement r4 = this.y;
            ECFieldElement r8 = this.zs[0];
            ECFieldElement r5 = r9.y;
            ECFieldElement r6 = r1.square();
            ECFieldElement r7 = r4.square();
            ECFieldElement r10 = r8.square();
            ECFieldElement r11 = r0.getA().multiply(r10).add(r7).add(r4.multiply(r8));
            ECFieldElement r12 = r5.addOne();
            ECFieldElement r13 = r0.getA().add(r12).multiply(r10).add(r7).multiplyPlusProduct(r11, r6, r10);
            ECFieldElement r14 = r2.multiply(r10);
            ECFieldElement r15 = r14.add(r11).square();
            if (r15.isZero() == false) goto L30;
            if (r13.isZero() == false) goto L28;
            return r9.twice();
        L28:
            return r0.getInfinity();
        L30:
            if (r13.isZero() == true) goto L32;
            ECFieldElement r16 = r13.square().multiply(r14);
            ECFieldElement r17 = r13.multiply(r15).multiply(r10);
            return new F2m(r0, r16, r13.add(r15).square().multiplyPlusProduct(r11, r12, r17), new ECFieldElement[]{r17});
        L32:
            return new F2m(r0, r13, r0.getB().sqrt());
        L36:
            return twice().add(r9);
        L15:
            return twice().add(r9);
        L8:
            return twice();
        }
    }

    public static class Fp extends AbstractFp {
        Fp(ECCurve r1, ECFieldElement r2, ECFieldElement r3) {
            super(r1, r2, r3);
        }

        Fp(ECCurve r1, ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
            super(r1, r2, r3, r4);
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5321. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        @Override // org.bouncycastle.math.ec.ECPoint
        public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint r17) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: INVOKE (r2v0 ?? I:boolean) = (r16v0 'this' ?? I:org.bouncycastle.math.ec.ECPoint$Fp A[IMMUTABLE_TYPE, THIS]) VIRTUAL call: org.bouncycastle.math.ec.ECPoint.Fp.isInfinity():boolean A[DECLARE_VAR, MD:():boolean (m)] in method: org.bouncycastle.math.ec.ECPoint.Fp.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                Method dump skipped, instruction units count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.Fp.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement r3, ECFieldElement r4) {
            ECFieldElement r2 = getCurve().getA();
            if (r2.isZero() == false) goto L5;
            return r2;
        L5:
            if (r3.isOne() == true) goto L16;
            if (r4 != null) goto L9;
            r4 = r3.square();
        L9:
            ECFieldElement r5 = r4.square();
            ECFieldElement r6 = r2.negate();
            if (r6.bitLength() >= r2.bitLength()) goto L13;
            return r5.multiply(r6).negate();
        L13:
            return r5.multiply(r2);
        L16:
            return r2;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint detach() {
            return new Fp(null, getAffineXCoord(), getAffineYCoord());
        }

        public ECFieldElement eight(ECFieldElement r1) {
            return four(two(r1));
        }

        public ECFieldElement four(ECFieldElement r1) {
            return two(two(r1));
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement r0 = this.zs[1];
            if (r0 != null) goto L6;
            ECFieldElement[] r1 = this.zs;
            ECFieldElement r4 = calculateJacobianModifiedW(this.zs[0], null);
            r1[1] = r4;
            return r4;
        L6:
            return r0;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getZCoord(int r3) {
            if (r3 != 1) goto L9;
            if (4 != getCurveCoordinateSystem()) goto L9;
            return getJacobianModifiedW();
        L9:
            return super.getZCoord(r3);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r0 = getCurve();
            if (r0.getCoordinateSystem() == 0) goto L10;
            return new Fp(r0, this.x, this.y.negate(), this.zs);
        L10:
            return new Fp(r0, this.x, this.y.negate());
        }

        public ECFieldElement three(ECFieldElement r1) {
            return two(r1).add(r1);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint threeTimes() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECFieldElement r0 = this.y;
            if (r0.isZero() == false) goto L8;
            return this;
        L8:
            ECCurve r1 = getCurve();
            int r2 = r1.getCoordinateSystem();
            if (r2 != 0) goto L11;
            ECFieldElement r3 = this.x;
            ECFieldElement r4 = two(r0);
            ECFieldElement r5 = r4.square();
            ECFieldElement r6 = three(r3.square()).add(getCurve().getA());
            ECFieldElement r7 = r6.square();
            ECFieldElement r8 = three(r3).multiply(r5).subtract(r7);
            if (r8.isZero() == true) goto L19;
            ECFieldElement r9 = r8.multiply(r4).invert();
            ECFieldElement r10 = r8.multiply(r9).multiply(r6);
            ECFieldElement r11 = r5.square().multiply(r9).subtract(r10);
            ECFieldElement r12 = r11.subtract(r10).multiply(r10.add(r11)).add(r3);
            return new Fp(r1, r12, r3.subtract(r12).multiply(r11).subtract(r0));
        L19:
            return getCurve().getInfinity();
        L11:
            if (r2 == 4) goto L15;
            return twice().add(this);
        L15:
            return twiceJacobianModified(false).add(this);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint timesPow2(int r18) {
            if (r18 < 0) goto L63;
            if (r18 != 0) goto L6;
        L61:
            return this;
        L6:
            if (isInfinity() == true) goto L61;
            if (r18 == 1) goto L11;
            ECCurve r3 = getCurve();
            ECFieldElement r4 = this.y;
            if (r4.isZero() == true) goto L15;
            int r5 = r3.getCoordinateSystem();
            ECFieldElement r6 = r3.getA();
            ECFieldElement r7 = this.x;
            if (this.zs.length >= 1) goto L19;
            ECFieldElement r8 = r3.fromBigInteger(ECConstants.ONE);
        L21:
            if (r8.isOne() == true) goto L32;
            if (r5 == 0) goto L32;
            if (r5 == 1) goto L30;
            if (r5 == 2) goto L29;
            if (r5 != 4) goto L28;
            r6 = getJacobianModifiedW();
            goto L32
        L28:
            throw new IllegalStateException("unsupported coordinate system");
        L29:
            ECFieldElement r9 = null;
        L31:
            r6 = calculateJacobianModifiedW(r8, r9);
            goto L32
        L30:
            r9 = r8.square();
            r7 = r7.multiply(r8);
            r4 = r4.multiply(r9);
        L32:
            int r10 = 0;
        L33:
            if (r10 >= r18) goto L46;
            if (r4.isZero() == true) goto L37;
            ECFieldElement r14 = three(r7.square());
            ECFieldElement r15 = two(r4);
            ECFieldElement r11 = r15.multiply(r4);
            ECFieldElement r12 = two(r7.multiply(r11));
            ECFieldElement r13 = two(r11.square());
            if (r6.isZero() == true) goto L41;
            r14 = r14.add(r6);
            r6 = two(r13.multiply(r6));
        L41:
            ECFieldElement r16 = r14.square().subtract(two(r12));
            r4 = r14.multiply(r12.subtract(r16)).subtract(r13);
            if (r8.isOne() == false) goto L44;
            r8 = r15;
        L45:
            r10 = r10 + 1;
            r7 = r16;
            goto L33
        L44:
            r8 = r15.multiply(r8);
            goto L45
        L37:
            return r3.getInfinity();
        L46:
            if (r5 == 0) goto L59;
            if (r5 == 1) goto L58;
            if (r5 == 2) goto L56;
            if (r5 != 4) goto L54;
            return new Fp(r3, r7, r4, new ECFieldElement[]{r8, r6});
        L54:
            throw new IllegalStateException("unsupported coordinate system");
        L56:
            return new Fp(r3, r7, r4, new ECFieldElement[]{r8});
        L58:
            return new Fp(r3, r7.multiply(r8), r4, new ECFieldElement[]{r8.multiply(r8.square())});
        L59:
            ECFieldElement r0 = r8.invert();
            ECFieldElement r1 = r0.square();
            return new Fp(r3, r7.multiply(r1), r4.multiply(r1.multiply(r0)));
        L19:
            r8 = this.zs[0];
            goto L21
        L15:
            return r3.getInfinity();
        L11:
            return twice();
        L63:
            throw new IllegalArgumentException("'e' cannot be negative");
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r0 = getCurve();
            ECFieldElement r1 = this.y;
            if (r1.isZero() == true) goto L8;
            int r2 = r0.getCoordinateSystem();
            ECFieldElement r3 = this.x;
            if (r2 != 0) goto L12;
            ECFieldElement r4 = three(r3.square()).add(getCurve().getA()).divide(two(r1));
            ECFieldElement r15 = r4.square().subtract(two(r3));
            return new Fp(r0, r15, r4.multiply(r3.subtract(r15)).subtract(r1));
        L12:
            if (r2 != 1) goto L14;
            ECFieldElement r5 = this.zs[0];
            boolean r6 = r5.isOne();
            ECFieldElement r7 = r0.getA();
            if (r7.isZero() == true) goto L47;
            if (r6 == true) goto L47;
            r7 = r7.multiply(r5.square());
        L47:
            ECFieldElement r8 = r7.add(three(r3.square()));
            if (r6 == false) goto L50;
            ECFieldElement r9 = r1;
        L51:
            if (r6 == false) goto L53;
            ECFieldElement r10 = r1.square();
        L54:
            ECFieldElement r11 = four(r3.multiply(r10));
            ECFieldElement r12 = r8.square().subtract(two(r11));
            ECFieldElement r13 = two(r9);
            ECFieldElement r14 = r12.multiply(r13);
            ECFieldElement r16 = two(r10);
            ECFieldElement r17 = r11.subtract(r12).multiply(r8).subtract(two(r16.square()));
            if (r6 == false) goto L57;
            ECFieldElement r18 = two(r16);
        L59:
            return new Fp(r0, r14, r17, new ECFieldElement[]{two(r18).multiply(r9)});
        L57:
            r18 = r13.square();
            goto L59
        L53:
            r10 = r9.multiply(r1);
            goto L54
        L50:
            r9 = r1.multiply(r5);
            goto L51
        L14:
            if (r2 != 2) goto L16;
            ECFieldElement r19 = this.zs[0];
            boolean r20 = r19.isOne();
            ECFieldElement r21 = r1.square();
            ECFieldElement r22 = r21.square();
            ECFieldElement r23 = r0.getA();
            ECFieldElement r110 = r23.negate();
            if (r110.toBigInteger().equals(BigInteger.valueOf(3)) == false) goto L27;
            if (r20 == false) goto L25;
            ECFieldElement r24 = r19;
        L26:
            ECFieldElement r25 = three(r3.add(r24).multiply(r3.subtract(r24)));
            ECFieldElement r26 = r21.multiply(r3);
        L38:
            ECFieldElement r27 = four(r26);
            ECFieldElement r28 = r25.square().subtract(two(r27));
            ECFieldElement r29 = r27.subtract(r28).multiply(r25).subtract(eight(r22));
            ECFieldElement r111 = two(r1);
            if (r20 == true) goto L42;
            r111 = r111.multiply(r19);
        L42:
            return new Fp(r0, r28, r29, new ECFieldElement[]{r111});
        L25:
            r24 = r19.square();
            goto L26
        L27:
            ECFieldElement r112 = three(r3.square());
            if (r20 == false) goto L31;
        L29:
            r25 = r112.add(r23);
        L37:
            r26 = r3.multiply(r21);
            goto L38
        L31:
            if (r23.isZero() == true) goto L36;
            ECFieldElement r113 = r19.square().square();
            if (r110.bitLength() >= r23.bitLength()) goto L35;
            r25 = r112.subtract(r113.multiply(r110));
            goto L37
        L35:
            r23 = r113.multiply(r23);
            goto L29
        L36:
            r25 = r112;
            goto L37
        L16:
            if (r2 != 4) goto L20;
            return twiceJacobianModified(true);
        L20:
            throw new IllegalStateException("unsupported coordinate system");
        L8:
            return r0.getInfinity();
        }

        public Fp twiceJacobianModified(boolean r10) {
            ECFieldElement r0 = this.x;
            ECFieldElement r1 = this.y;
            ECFieldElement r2 = this.zs[0];
            ECFieldElement r4 = getJacobianModifiedW();
            ECFieldElement r5 = three(r0.square()).add(r4);
            ECFieldElement r6 = two(r1);
            ECFieldElement r3 = r6.multiply(r1);
            ECFieldElement r7 = two(r0.multiply(r3));
            ECFieldElement r8 = r5.square().subtract(two(r7));
            ECFieldElement r9 = two(r3.square());
            ECFieldElement r11 = r5.multiply(r7.subtract(r8)).subtract(r9);
            if (r10 == false) goto L5;
            ECFieldElement r12 = two(r9.multiply(r4));
        L7:
            if (r2.isOne() == true) goto L11;
            r6 = r6.multiply(r2);
        L11:
            return new Fp(getCurve(), r8, r11, new ECFieldElement[]{r6, r12});
        L5:
            r12 = null;
            goto L7
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint r9) {
            if (this != r9) goto L6;
            return threeTimes();
        L6:
            if (isInfinity() == false) goto L9;
            return r9;
        L9:
            if (r9.isInfinity() == true) goto L11;
            ECFieldElement r0 = this.y;
            if (r0.isZero() == false) goto L15;
            return r9;
        L15:
            ECCurve r1 = getCurve();
            int r2 = r1.getCoordinateSystem();
            if (r2 != 0) goto L18;
            ECFieldElement r3 = this.x;
            ECFieldElement r4 = r9.x;
            ECFieldElement r10 = r9.y;
            ECFieldElement r5 = r4.subtract(r3);
            ECFieldElement r11 = r10.subtract(r0);
            if (r5.isZero() == true) goto L26;
            ECFieldElement r6 = r5.square();
            ECFieldElement r7 = r11.square();
            ECFieldElement r8 = r6.multiply(two(r3).add(r4)).subtract(r7);
            if (r8.isZero() == true) goto L32;
            ECFieldElement r12 = r8.multiply(r5).invert();
            ECFieldElement r13 = r8.multiply(r12).multiply(r11);
            ECFieldElement r14 = two(r0).multiply(r6).multiply(r5).multiply(r12).subtract(r13);
            ECFieldElement r15 = r14.subtract(r13).multiply(r13.add(r14)).add(r4);
            return new Fp(r1, r15, r3.subtract(r15).multiply(r14).subtract(r0));
        L32:
            return r1.getInfinity();
        L26:
            if (r11.isZero() == true) goto L28;
            return this;
        L28:
            return threeTimes();
        L18:
            if (r2 == 4) goto L22;
            return twice().add(r9);
        L22:
            return twiceJacobianModified(false).add(r9);
        L11:
            return twice();
        }

        public ECFieldElement two(ECFieldElement r1) {
            return r1.add(r1);
        }
    }

    static {
        EMPTY_ZS = new ECFieldElement[0];
    }

    public ECPoint(ECCurve r2, ECFieldElement r3, ECFieldElement r4) {
        this(r2, r3, r4, getInitialZCoords(r2));
    }

    public ECPoint(ECCurve r2, ECFieldElement r3, ECFieldElement r4, ECFieldElement[] r5) {
        this.preCompTable = null;
        this.curve = r2;
        this.x = r3;
        this.y = r4;
        this.zs = r5;
    }

    public static ECFieldElement[] getInitialZCoords(ECCurve r6) {
        if (r6 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 == 0) goto L29;
        if (r1 == 5) goto L29;
        ECFieldElement r2 = r6.fromBigInteger(ECConstants.ONE);
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L27;
        if (r1 == 3) goto L25;
        if (r1 == 4) goto L23;
        if (r1 == 6) goto L27;
        throw new IllegalArgumentException("unknown coordinate system");
    L23:
        return new ECFieldElement[]{r2, r6.getA()};
    L25:
        return new ECFieldElement[]{r2, r2, r2};
    L27:
        return new ECFieldElement[]{r2};
    L29:
        return EMPTY_ZS;
    L5:
        r1 = r6.getCoordinateSystem();
        goto L6
    }

    public abstract ECPoint add(ECPoint r1);

    public void checkNormalized() {
        if (isNormalized() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("point not in normal form");
    }

    public ECPoint createScaledPoint(ECFieldElement r3, ECFieldElement r4) {
        return getCurve().createRawPoint(getRawXCoord().multiply(r3), getRawYCoord().multiply(r4));
    }

    public abstract ECPoint detach();

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ECPoint.class) == true) goto L11;
        return false;
    L11:
        return equals((ECPoint) ZeusTransformUtils.preCheckCast(r3, ECPoint.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(ECPoint r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        ECCurve r1 = getCurve();
        ECCurve r2 = r9.getCurve();
        if (r1 != null) goto L8;
        boolean r4 = true;
    L9:
        if (r2 != null) goto L11;
        boolean r5 = true;
    L12:
        boolean r6 = isInfinity();
        boolean r7 = r9.isInfinity();
        if (r6 == true) goto L33;
        if (r7 == true) goto L33;
        if (r4 == false) goto L19;
        if (r5 == false) goto L19;
    L28:
        if (this.getXCoord().equals(r9.getXCoord()) == true) goto L30;
        return false;
    L30:
        if (this.getYCoord().equals(r9.getYCoord()) == true) goto L32;
        return false;
    L32:
        return true;
    L19:
        if (r4 == false) goto L21;
        r9 = r9.normalize();
        goto L28
    L21:
        if (r5 == false) goto L24;
        ECPoint this = normalize();
        goto L28
    L24:
        if (r1.equals(r2) == true) goto L26;
        return false;
    L26:
        ECPoint[] r3 = {this, r1.importPoint(r9)};
        r1.normalizeAll(r3);
        this = r3[0];
        r9 = r3[1];
    L33:
        if (r6 == false) goto L43;
        if (r7 == false) goto L44;
        if (r4 == true) goto L40;
        if (r5 == true) goto L40;
        if (r1.equals(r2) == true) goto L40;
        return false;
    L40:
        return true;
    L44:
        return false;
    L43:
        return false;
    L11:
        r5 = false;
        goto L12
    L8:
        r4 = false;
        goto L9
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    public int getCurveCoordinateSystem() {
        ECCurve r0 = this.curve;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCoordinateSystem();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public byte[] getEncoded(boolean r5) {
        if (isInfinity() == true) goto L5;
        ECPoint r4 = normalize();
        byte[] r0 = r4.getXCoord().getEncoded();
        if (r5 == false) goto L14;
        byte[] r6 = new byte[r0.length + 1];
        if (r4.getCompressionYTilde() == false) goto L11;
        int r7 = 3;
    L12:
        r6[0] = (byte) r7;
        System.arraycopy(r0, 0, r6, 1, r0.length);
        return r6;
    L11:
        r7 = 2;
        goto L12
    L14:
        byte[] r8 = r4.getYCoord().getEncoded();
        byte[] r9 = new byte[(r0.length + r8.length) + 1];
        r9[0] = 4;
        System.arraycopy(r0, 0, r9, 1, r0.length);
        System.arraycopy(r8, 0, r9, r0.length + 1, r8.length);
        return r9;
    L5:
        return new byte[1];
    }

    public final ECFieldElement getRawXCoord() {
        return this.x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.y;
    }

    public final ECFieldElement[] getRawZCoords() {
        return this.zs;
    }

    public ECFieldElement getXCoord() {
        return this.x;
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int r2) {
        if (r2 < 0) goto L7;
        ECFieldElement[] r1 = this.zs;
        if (r2 >= r1.length) goto L7;
        return r1[r2];
    L7:
        return null;
    }

    public int hashCode() {
        ECCurve r0 = getCurve();
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        if (isInfinity() == true) goto L10;
        ECPoint r2 = normalize();
        return (r1 ^ (r2.getXCoord().hashCode() * 17)) ^ (r2.getYCoord().hashCode() * 257);
    L10:
        return r1;
    L5:
        r1 = ~r0.hashCode();
        goto L7
    }

    boolean implIsValid(final boolean r4, final boolean r5) {
        if (isInfinity() == false) goto L6;
        return true;
    L6:
        return !((ValidityPrecompInfo) ZeusTransformUtils.preCheckCast(getCurve().precompute(this, "bc_validity", new AnonymousClass1(this, r4, r5)), ValidityPrecompInfo.class, "com.obric.memorydata.plugin")).hasFailed();
    }

    public boolean isInfinity() {
        if (this.x != null) goto L5;
    L10:
        return true;
    L5:
        if (this.y == null) goto L10;
        ECFieldElement[] r2 = this.zs;
        if (r2.length > 0) goto L9;
        return false;
    L9:
        if (r2[0].isZero() == true) goto L10;
        return false;
    }

    public boolean isNormalized() {
        int r0 = getCurveCoordinateSystem();
        if (r0 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 5) goto L10;
        if (isInfinity() == true) goto L10;
        if (this.zs[0].isOne() == true) goto L10;
        return false;
    }

    public boolean isValid() {
        return implIsValid(false, true);
    }

    boolean isValidPartial() {
        return implIsValid(false, false);
    }

    public ECPoint multiply(BigInteger r2) {
        return getCurve().getMultiplier().multiply(this, r2);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        int r0 = getCurveCoordinateSystem();
        if (r0 != 0) goto L8;
    L18:
        return this;
    L8:
        if (r0 == 5) goto L18;
        ECFieldElement r1 = getZCoord(0);
        if (r1.isOne() == false) goto L13;
        return this;
    L13:
        if (this.curve == null) goto L17;
        SecureRandom r2 = CryptoServicesRegistrar.getSecureRandom();
        ECFieldElement r3 = this.curve.randomFieldElementMult(r2);
        return normalize(r1.multiply(r3).invert().multiply(r3));
    L17:
        throw new IllegalStateException("Detached points must be in affine coordinates");
    }

    ECPoint normalize(ECFieldElement r3) {
        int r0 = getCurveCoordinateSystem();
        if (r0 == 1) goto L18;
        if (r0 != 2) goto L7;
    L15:
        ECFieldElement r1 = r3.square();
        return createScaledPoint(r1, r1.multiply(r3));
    L7:
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L15;
        if (r0 == 6) goto L18;
        throw new IllegalStateException("not a projective coordinate system");
    L18:
        return createScaledPoint(r3, r3);
    }

    public abstract boolean satisfiesCurveEquation();

    public boolean satisfiesOrder() {
        if (ECConstants.ONE.equals(this.curve.getCofactor()) == false) goto L5;
        return true;
    L5:
        BigInteger r0 = this.curve.getOrder();
        if (r0 != null) goto L8;
        return true;
    L8:
        if (ECAlgorithms.referenceMultiply(this, r0).isInfinity() == true) goto L13;
        return false;
    L13:
        return true;
    }

    public ECPoint scaleX(ECFieldElement r3) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord().multiply(r3), getRawYCoord(), getRawZCoords());
    }

    public ECPoint scaleY(ECFieldElement r4) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(r4), getRawZCoords());
    }

    public abstract ECPoint subtract(ECPoint r1);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int r1) {
        if (r1 < 0) goto L8;
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L6;
        ECPoint this = this.twice();
        goto L3
    L6:
        return this;
    L8:
        throw new IllegalArgumentException("'e' cannot be negative");
    }

    public String toString() {
        if (isInfinity() == false) goto L6;
        return "INF";
    L6:
        StringBuffer r0 = new StringBuffer();
        r0.append('(');
        r0.append(getRawXCoord());
        r0.append(',');
        r0.append(getRawYCoord());
        int r2 = 0;
    L8:
        if (r2 >= this.zs.length) goto L10;
        r0.append(',');
        r0.append(this.zs[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        r0.append(')');
        return r0.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint r1) {
        return twice().add(r1);
    }
}
