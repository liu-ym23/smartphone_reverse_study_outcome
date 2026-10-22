package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SecT233FieldElement extends ECFieldElement.AbstractF2m {
    protected long[] x;

    public SecT233FieldElement() {
        this.x = Nat256.create64();
    }

    public SecT233FieldElement(BigInteger r3) {
        if (r3 == null) goto L11;
        if (r3.signum() < 0) goto L11;
        if (r3.bitLength() > 233) goto L11;
        this.x = SecT233Field.fromBigInteger(r3);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
    }

    public SecT233FieldElement(long[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        long[] r0 = Nat256.create64();
        SecT233Field.add(this.x, ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r0 = Nat256.create64();
        SecT233Field.addOne(this.x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r1) {
        return multiply(r1.invert());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecT233FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecT233FieldElement r4 = (SecT233FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT233FieldElement.class, "com.obric.memorydata.plugin");
        return Nat256.eq64(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return 233;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r0 = Nat256.create64();
        SecT233Field.halfTrace(this.x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.x, 0, 4) ^ 2330074;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r0 = Nat256.create64();
        SecT233Field.invert(this.x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        long[] r0 = Nat256.create64();
        SecT233Field.multiply(this.x, ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
        return multiplyPlusProduct(r1, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r3, ECFieldElement r4, ECFieldElement r5) {
        long[] r2 = this.x;
        long[] r6 = ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r7 = ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r8 = ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r5, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat256.createExt64();
        SecT233Field.multiplyAddToExt(r2, r6, r0);
        SecT233Field.multiplyAddToExt(r7, r8, r0);
        long[] r9 = Nat256.create64();
        SecT233Field.reduce(r0, r9);
        return new SecT233FieldElement(r9);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r0 = Nat256.create64();
        SecT233Field.sqrt(this.x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r0 = Nat256.create64();
        SecT233Field.square(this.x, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r3, ECFieldElement r4) {
        long[] r2 = this.x;
        long[] r5 = ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r6 = ((SecT233FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT233FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat256.createExt64();
        SecT233Field.squareAddToExt(r2, r0);
        SecT233Field.multiplyAddToExt(r5, r6, r0);
        long[] r7 = Nat256.create64();
        SecT233Field.reduce(r0, r7);
        return new SecT233FieldElement(r7);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r2) {
        if (r2 >= 1) goto L5;
        return this;
    L5:
        long[] r0 = Nat256.create64();
        SecT233Field.squareN(this.x, r2, r0);
        return new SecT233FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r1) {
        return add(r1);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if ((this.x[0] & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT233Field.trace(this.x);
    }
}
