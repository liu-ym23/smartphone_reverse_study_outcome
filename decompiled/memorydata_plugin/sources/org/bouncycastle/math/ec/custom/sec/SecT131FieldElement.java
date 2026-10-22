package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SecT131FieldElement extends ECFieldElement.AbstractF2m {
    protected long[] x;

    public SecT131FieldElement() {
        this.x = Nat192.create64();
    }

    public SecT131FieldElement(BigInteger r3) {
        if (r3 == null) goto L11;
        if (r3.signum() < 0) goto L11;
        if (r3.bitLength() > 131) goto L11;
        this.x = SecT131Field.fromBigInteger(r3);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
    }

    public SecT131FieldElement(long[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        long[] r0 = Nat192.create64();
        SecT131Field.add(this.x, ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r0 = Nat192.create64();
        SecT131Field.addOne(this.x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r1) {
        return multiply(r1.invert());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecT131FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecT131FieldElement r4 = (SecT131FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT131FieldElement.class, "com.obric.memorydata.plugin");
        return Nat192.eq64(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return 131;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r0 = Nat192.create64();
        SecT131Field.halfTrace(this.x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.x, 0, 3) ^ 131832;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r0 = Nat192.create64();
        SecT131Field.invert(this.x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        long[] r0 = Nat192.create64();
        SecT131Field.multiply(this.x, ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r1, ECFieldElement r2, ECFieldElement r3) {
        return multiplyPlusProduct(r1, r2, r3);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r3, ECFieldElement r4, ECFieldElement r5) {
        long[] r2 = this.x;
        long[] r6 = ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r7 = ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r8 = ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r5, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat.create64(5);
        SecT131Field.multiplyAddToExt(r2, r6, r0);
        SecT131Field.multiplyAddToExt(r7, r8, r0);
        long[] r9 = Nat192.create64();
        SecT131Field.reduce(r0, r9);
        return new SecT131FieldElement(r9);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r0 = Nat192.create64();
        SecT131Field.sqrt(this.x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r0 = Nat192.create64();
        SecT131Field.square(this.x, r0);
        return new SecT131FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r3, ECFieldElement r4) {
        long[] r2 = this.x;
        long[] r5 = ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r3, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r6 = ((SecT131FieldElement) ZeusTransformUtils.preCheckCast(r4, SecT131FieldElement.class, "com.obric.memorydata.plugin")).x;
        long[] r0 = Nat.create64(5);
        SecT131Field.squareAddToExt(r2, r0);
        SecT131Field.multiplyAddToExt(r5, r6, r0);
        long[] r7 = Nat192.create64();
        SecT131Field.reduce(r0, r7);
        return new SecT131FieldElement(r7);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r2) {
        if (r2 >= 1) goto L5;
        return this;
    L5:
        long[] r0 = Nat192.create64();
        SecT131Field.squareN(this.x, r2, r0);
        return new SecT131FieldElement(r0);
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
        return Nat192.toBigInteger64(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT131Field.trace(this.x);
    }
}
