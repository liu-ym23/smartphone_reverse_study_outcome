package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SecT409FieldElement extends ECFieldElement.AbstractF2m {
    protected long[] x;

    public SecT409FieldElement() {
        this.x = Nat448.create64();
    }

    public SecT409FieldElement(BigInteger r3) {
        if (r3 == null) goto L11;
        if (r3.signum() < 0) goto L11;
        if (r3.bitLength() > 409) goto L11;
        this.x = SecT409Field.fromBigInteger(r3);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
    }

    public SecT409FieldElement(long[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        long[] r0 = Nat448.create64();
        SecT409Field.add(this.x, ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r0 = Nat448.create64();
        SecT409Field.addOne(this.x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r1) {
        return multiply(r1.invert());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecT409FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecT409FieldElement r4 = (SecT409FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT409FieldElement.class, "com.obric.memorydata.plugin");
        return Nat448.eq64(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return 409;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r0 = Nat448.create64();
        SecT409Field.halfTrace(this.x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.x, 0, 7) ^ 4090087;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r0 = Nat448.create64();
        SecT409Field.invert(this.x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat448.isOne64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat448.isZero64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        long[] r0 = Nat448.create64();
        SecT409Field.multiply(this.x, ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
        return multiplyPlusProduct(r1, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r3, ECFieldElement r4, ECFieldElement r5) {
        long[] r2 = this.x;
        long[] r6 = ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r7 = ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r8 = ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r5, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat.create64(13);
        SecT409Field.multiplyAddToExt(r2, r6, r0);
        SecT409Field.multiplyAddToExt(r7, r8, r0);
        long[] r9 = Nat448.create64();
        SecT409Field.reduce(r0, r9);
        return new SecT409FieldElement(r9);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r0 = Nat448.create64();
        SecT409Field.sqrt(this.x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r0 = Nat448.create64();
        SecT409Field.square(this.x, r0);
        return new SecT409FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r3, ECFieldElement r4) {
        long[] r2 = this.x;
        long[] r5 = ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r6 = ((SecT409FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT409FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat.create64(13);
        SecT409Field.squareAddToExt(r2, r0);
        SecT409Field.multiplyAddToExt(r5, r6, r0);
        long[] r7 = Nat448.create64();
        SecT409Field.reduce(r0, r7);
        return new SecT409FieldElement(r7);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r2) {
        if (r2 >= 1) goto L5;
        return this;
    L5:
        long[] r0 = Nat448.create64();
        SecT409Field.squareN(this.x, r2, r0);
        return new SecT409FieldElement(r0);
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
        return Nat448.toBigInteger64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT409Field.trace(this.x);
    }
}
