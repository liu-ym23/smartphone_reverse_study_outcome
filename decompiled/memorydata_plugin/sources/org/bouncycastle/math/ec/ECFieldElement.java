package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public AbstractF2m() {
        }

        public ECFieldElement halfTrace() {
            int r0 = getFieldSize();
            if ((r0 & 1) == 0) goto L11;
            int r1 = (r0 + 1) >>> 1;
            int r2 = 31 - Integers.numberOfLeadingZeros(r1);
            ECFieldElement r3 = this;
            int r4 = 1;
        L5:
            if (r2 <= 0) goto L9;
            r3 = r3.squarePow(r4 << 1).add(r3);
            r2 = r2 - 1;
            r4 = r1 >>> r2;
            if ((r4 & 1) == 0) goto L5;
            r3 = r3.squarePow(2).add(this);
            goto L5
        L9:
            return r3;
        L11:
            throw new IllegalStateException("Half-trace only defined for odd m");
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int r0 = getFieldSize();
            int r1 = 31 - Integers.numberOfLeadingZeros(r0);
            ECFieldElement r3 = this;
            int r4 = 1;
        L3:
            if (r1 <= 0) goto L8;
            r3 = r3.squarePow(r4).add(r3);
            r1 = r1 - 1;
            r4 = r0 >>> r1;
            if ((r4 & 1) == 0) goto L3;
            r3 = r3.square().add(this);
            goto L3
        L8:
            if (r3.isZero() == false) goto L12;
            return 0;
        L12:
            if (r3.isOne() == false) goto L15;
            return 1;
        L15:
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
        public AbstractFp() {
        }
    }

    public static class F2m extends AbstractF2m {
        private int[] ks;
        private int m;
        private int representation;
        LongArray x;

        F2m(int r2, int[] r3, LongArray r4) {
            this.m = r2;
            if (r3.length != 1) goto L5;
            int r5 = 2;
        L6:
            this.representation = r5;
            this.ks = r3;
            this.x = r4;
            return;
        L5:
            r5 = 3;
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement r4) {
            LongArray r0 = (LongArray) ZeusTransformUtils.preCheckCast(this.x.clone(), LongArray.class, "com.obric.memorydata.plugin");
            r0.addShiftedByWords(((F2m) ZeusTransformUtils.preCheckCast(r4, F2m.class, "com.obric.memorydata.plugin")).x, 0);
            return new F2m(this.m, this.ks, r0);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.m, this.ks, this.x.addOne());
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.x.degree();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement r1) {
            return multiply(r1.invert());
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, F2m.class) == true) goto L8;
            return false;
        L8:
            F2m r6 = (F2m) ZeusTransformUtils.preCheckCast(r5, F2m.class, "com.obric.memorydata.plugin");
            if (this.m != r6.m) goto L18;
            if (this.representation != r6.representation) goto L18;
            if (Arrays.areEqual(this.ks, r6.ks) == false) goto L18;
            if (this.x.equals(r6.x) == false) goto L18;
            return true;
        L18:
            return false;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.m;
        }

        public int hashCode() {
            int r0 = this.x.hashCode() ^ this.m;
            return Arrays.hashCode(this.ks) ^ r0;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int r1 = this.m;
            int[] r2 = this.ks;
            return new F2m(r1, r2, this.x.modInverse(r1, r2));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.x.isOne();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.x.isZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement r7) {
            return new F2m(this.m, this.ks, this.x.modMultiply(((F2m) ZeusTransformUtils.preCheckCast(r7, F2m.class, "com.obric.memorydata.plugin")).x, this.m, this.ks));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
            return multiplyPlusProduct(r1, r2, r3);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement r6, ECFieldElement r7, ECFieldElement r8) {
            LongArray r1 = this.x;
            LongArray r9 = ((F2m) ZeusTransformUtils.preCheckCast(r6, F2m.class, "com.obric.memorydata.plugin")).x;
            LongArray r10 = ((F2m) ZeusTransformUtils.preCheckCast(r7, F2m.class, "com.obric.memorydata.plugin")).x;
            LongArray r11 = ((F2m) ZeusTransformUtils.preCheckCast(r8, F2m.class, "com.obric.memorydata.plugin")).x;
            LongArray r0 = r1.multiply(r9, this.m, this.ks);
            LongArray r12 = r10.multiply(r11, this.m, this.ks);
            if (r0 == r1) goto L5;
            if (r0 == r9) goto L5;
        L6:
            r0.addShiftedByWords(r12, 0);
            r0.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, r0);
        L5:
            r0 = (LongArray) ZeusTransformUtils.preCheckCast(r0.clone(), LongArray.class, "com.obric.memorydata.plugin");
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (this.x.isZero() == false) goto L5;
            return this;
        L5:
            if (this.x.isOne() == false) goto L8;
            return this;
        L8:
            return squarePow(this.m - 1);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int r1 = this.m;
            int[] r2 = this.ks;
            return new F2m(r1, r2, this.x.modSquare(r1, r2));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement r6, ECFieldElement r7) {
            LongArray r1 = this.x;
            LongArray r8 = ((F2m) ZeusTransformUtils.preCheckCast(r6, F2m.class, "com.obric.memorydata.plugin")).x;
            LongArray r9 = ((F2m) ZeusTransformUtils.preCheckCast(r7, F2m.class, "com.obric.memorydata.plugin")).x;
            LongArray r0 = r1.square(this.m, this.ks);
            LongArray r10 = r8.multiply(r9, this.m, this.ks);
            if (r0 != r1) goto L5;
            r0 = (LongArray) ZeusTransformUtils.preCheckCast(r0.clone(), LongArray.class, "com.obric.memorydata.plugin");
        L5:
            r0.addShiftedByWords(r10, 0);
            r0.reduce(this.m, this.ks);
            return new F2m(this.m, this.ks, r0);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePow(int r4) {
            if (r4 < 1) goto L7;
            int r1 = this.m;
            int[] r2 = this.ks;
            return new F2m(r1, r2, this.x.modSquareN(r4, r1, r2));
        L7:
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement r1) {
            return add(r1);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            return this.x.testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x.toBigInteger();
        }
    }

    public static class Fp extends AbstractFp {
        BigInteger q;
        BigInteger r;
        BigInteger x;

        Fp(BigInteger r1, BigInteger r2, BigInteger r3) {
            this.q = r1;
            this.r = r2;
            this.x = r3;
        }

        static BigInteger calculateResidue(BigInteger r5) {
            int r0 = r5.bitLength();
            if (r0 >= 96) goto L5;
            return null;
        L5:
            if (r5.shiftRight(r0 - 64).longValue() == (-1)) goto L7;
            return null;
        L7:
            return ONE.shiftLeft(r0).subtract(r5);
        }

        private ECFieldElement checkSqrt(ECFieldElement r2) {
            if (r2.square().equals(this) == true) goto L7;
            return null;
        L7:
            return r2;
        }

        private BigInteger[] lucasSequence(BigInteger r10, BigInteger r11, BigInteger r12) {
            int r0 = r12.bitLength();
            int r1 = r12.getLowestSetBit();
            BigInteger r2 = ECConstants.ONE;
            BigInteger r3 = ECConstants.TWO;
            BigInteger r4 = ECConstants.ONE;
            BigInteger r5 = ECConstants.ONE;
            int r6 = r0 - 1;
            BigInteger r7 = r10;
        L4:
            if (r6 < (r1 + 1)) goto L10;
            r4 = modMult(r4, r5);
            if (r12.testBit(r6) == false) goto L8;
            r5 = modMult(r4, r11);
            r2 = modMult(r2, r7);
            r3 = modReduce(r7.multiply(r3).subtract(r10.multiply(r4)));
            r7 = modReduce(r7.multiply(r7).subtract(r5.shiftLeft(1)));
        L9:
            r6 = r6 - 1;
            goto L4
        L8:
            r2 = modReduce(r2.multiply(r3).subtract(r4));
            BigInteger r8 = modReduce(r7.multiply(r3).subtract(r10.multiply(r4)));
            r3 = modReduce(r3.multiply(r3).subtract(r4.shiftLeft(1)));
            r7 = r8;
            r5 = r4;
            goto L9
        L10:
            BigInteger r13 = modMult(r4, r5);
            BigInteger r14 = modMult(r13, r11);
            BigInteger r9 = modReduce(r2.multiply(r3).subtract(r13));
            BigInteger r15 = modReduce(r7.multiply(r3).subtract(r10.multiply(r13)));
            BigInteger r16 = modMult(r13, r14);
            int r17 = 1;
        L11:
            if (r17 > r1) goto L14;
            r9 = modMult(r9, r15);
            r15 = modReduce(r15.multiply(r15).subtract(r16.shiftLeft(1)));
            r16 = modMult(r16, r16);
            r17 = r17 + 1;
            goto L11
        L14:
            return new BigInteger[]{r9, r15};
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement r5) {
            return new Fp(this.q, this.r, modAdd(this.x, r5.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger r0 = this.x.add(ECConstants.ONE);
            if (r0.compareTo(this.q) != 0) goto L6;
            r0 = ECConstants.ZERO;
        L6:
            return new Fp(this.q, this.r, r0);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement r5) {
            return new Fp(this.q, this.r, modMult(this.x, modInverse(r5.toBigInteger())));
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Fp.class) == true) goto L8;
            return false;
        L8:
            Fp r6 = (Fp) ZeusTransformUtils.preCheckCast(r5, Fp.class, "com.obric.memorydata.plugin");
            if (this.q.equals(r6.q) == false) goto L14;
            if (this.x.equals(r6.x) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.q.bitLength();
        }

        public int hashCode() {
            int r0 = this.q.hashCode();
            return this.x.hashCode() ^ r0;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.q, this.r, modInverse(this.x));
        }

        public BigInteger modAdd(BigInteger r1, BigInteger r2) {
            BigInteger r3 = r1.add(r2);
            if (r3.compareTo(this.q) >= 0) goto L5;
            return r3;
        L5:
            return r3.subtract(this.q);
        }

        public BigInteger modDouble(BigInteger r2) {
            BigInteger r3 = r2.shiftLeft(1);
            if (r3.compareTo(this.q) >= 0) goto L5;
            return r3;
        L5:
            return r3.subtract(this.q);
        }

        public BigInteger modHalfAbs(BigInteger r2) {
            if (r2.testBit(0) == false) goto L6;
            r2 = this.q.subtract(r2);
        L6:
            return r2.shiftRight(1);
        }

        public BigInteger modInverse(BigInteger r1) {
            return BigIntegers.modOddInverse(this.q, r1);
        }

        public BigInteger modMult(BigInteger r1, BigInteger r2) {
            return modReduce(r1.multiply(r2));
        }

        public BigInteger modReduce(BigInteger r6) {
            if (this.r == null) goto L25;
            if (r6.signum() >= 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == false) goto L10;
            r6 = r6.abs();
        L10:
            int r1 = this.q.bitLength();
            boolean r2 = this.r.equals(ECConstants.ONE);
        L12:
            if (r6.bitLength() <= (r1 + 1)) goto L18;
            BigInteger r3 = r6.shiftRight(r1);
            BigInteger r7 = r6.subtract(r3.shiftLeft(r1));
            if (r2 == true) goto L16;
            r3 = r3.multiply(this.r);
        L16:
            r6 = r3.add(r7);
        L18:
            if (r6.compareTo(this.q) < 0) goto L20;
            r6 = r6.subtract(this.q);
            goto L18
        L20:
            if (r0 == true) goto L22;
            return r6;
        L22:
            if (r6.signum() != 0) goto L32;
            return r6;
        L32:
            return this.q.subtract(r6);
        L7:
            r0 = false;
            goto L8
        L25:
            return r6.mod(this.q);
        }

        public BigInteger modSubtract(BigInteger r1, BigInteger r2) {
            BigInteger r3 = r1.subtract(r2);
            if (r3.signum() < 0) goto L5;
            return r3;
        L5:
            return r3.add(this.q);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement r5) {
            return new Fp(this.q, this.r, modMult(this.x, r5.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement r3, ECFieldElement r4, ECFieldElement r5) {
            BigInteger r0 = this.x;
            BigInteger r6 = r3.toBigInteger();
            BigInteger r7 = r4.toBigInteger();
            BigInteger r8 = r5.toBigInteger();
            BigInteger r9 = r0.multiply(r6);
            BigInteger r10 = r7.multiply(r8);
            return new Fp(this.q, this.r, modReduce(r9.subtract(r10)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement r3, ECFieldElement r4, ECFieldElement r5) {
            BigInteger r0 = this.x;
            BigInteger r6 = r3.toBigInteger();
            BigInteger r7 = r4.toBigInteger();
            BigInteger r8 = r5.toBigInteger();
            BigInteger r9 = r0.multiply(r6);
            BigInteger r10 = r7.multiply(r8);
            return new Fp(this.q, this.r, modReduce(r9.add(r10)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.x.signum() == 0) goto L7;
            BigInteger r1 = this.q;
            return new Fp(r1, this.r, r1.subtract(this.x));
        L7:
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (isZero() == false) goto L5;
        L40:
            return this;
        L5:
            if (isOne() == true) goto L40;
            if (this.q.testBit(0) == false) goto L39;
            if (this.q.testBit(1) == false) goto L14;
            BigInteger r0 = this.q.shiftRight(2).add(ECConstants.ONE);
            BigInteger r2 = this.q;
            return checkSqrt(new Fp(r2, this.r, this.x.modPow(r0, r2)));
        L14:
            if (this.q.testBit(2) == false) goto L21;
            BigInteger r1 = this.x.modPow(this.q.shiftRight(3), this.q);
            BigInteger r3 = modMult(r1, this.x);
            if (modMult(r3, r1).equals(ECConstants.ONE) == true) goto L18;
            BigInteger r4 = modMult(r3, ECConstants.TWO.modPow(this.q.shiftRight(2), this.q));
            return checkSqrt(new Fp(this.q, this.r, r4));
        L18:
            return checkSqrt(new Fp(this.q, this.r, r3));
        L21:
            BigInteger r5 = this.q.shiftRight(1);
            if (this.x.modPow(r5, this.q).equals(ECConstants.ONE) == true) goto L24;
            return null;
        L24:
            BigInteger r6 = this.x;
            BigInteger r7 = modDouble(modDouble(r6));
            BigInteger r8 = r5.add(ECConstants.ONE);
            BigInteger r9 = this.q.subtract(ECConstants.ONE);
            Random r10 = new Random();
        L25:
            BigInteger r11 = new BigInteger(this.q.bitLength(), r10);
            if (r11.compareTo(this.q) >= 0) goto L25;
            if (modReduce(r11.multiply(r11).subtract(r7)).modPow(r5, this.q).equals(r9) == false) goto L25;
            BigInteger[] r12 = lucasSequence(r11, r6, r8);
            BigInteger r13 = r12[0];
            BigInteger r14 = r12[1];
            if (modMult(r14, r14).equals(r7) == true) goto L32;
            if (r13.equals(ECConstants.ONE) == true) goto L25;
            if (r13.equals(r9) == true) goto L25;
            return null;
        L32:
            return new Fp(this.q, this.r, modHalfAbs(r14));
        L39:
            throw new RuntimeException("not done yet");
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger r1 = this.q;
            BigInteger r2 = this.r;
            BigInteger r3 = this.x;
            return new Fp(r1, r2, modMult(r3, r3));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement r4, ECFieldElement r5) {
            BigInteger r0 = this.x;
            BigInteger r6 = r4.toBigInteger();
            BigInteger r7 = r5.toBigInteger();
            BigInteger r1 = r0.multiply(r0);
            BigInteger r8 = r6.multiply(r7);
            return new Fp(this.q, this.r, modReduce(r1.add(r8)));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement r5) {
            return new Fp(this.q, this.r, modSubtract(this.x, r5.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x;
        }
    }

    public ECFieldElement() {
    }

    public abstract ECFieldElement add(ECFieldElement r1);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement r1);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        if (bitLength() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isZero() {
        if (toBigInteger().signum() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract ECFieldElement multiply(ECFieldElement r1);

    public ECFieldElement multiplyMinusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
        return multiply(r1).subtract(r2.multiply(r3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
        return multiply(r1).add(r2.multiply(r3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squarePlusProduct(ECFieldElement r1, ECFieldElement r2) {
        return square().add(r1.multiply(r2));
    }

    public ECFieldElement squarePow(int r2) {
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        ECFieldElement this = this.square();
        r0 = r0 + 1;
        goto L3
    L5:
        return this;
    }

    public abstract ECFieldElement subtract(ECFieldElement r1);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
