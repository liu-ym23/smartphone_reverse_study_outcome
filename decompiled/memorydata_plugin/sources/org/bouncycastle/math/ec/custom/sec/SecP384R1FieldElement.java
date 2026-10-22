package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
    }

    public SecP384R1FieldElement() {
        this.x = Nat.create(12);
    }

    public SecP384R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP384R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
    }

    public SecP384R1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat.create(12);
        SecP384R1Field.add(this.x, ((SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP384R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat.create(12);
        SecP384R1Field.addOne(this.x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat.create(12);
        SecP384R1Field.inv(((SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP384R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP384R1Field.multiply(r0, this.x, r0);
        return new SecP384R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP384R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP384R1FieldElement r4 = (SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP384R1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat.eq(12, this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 12) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat.create(12);
        SecP384R1Field.inv(this.x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(12, this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(12, this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat.create(12);
        SecP384R1Field.multiply(this.x, ((SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP384R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat.create(12);
        SecP384R1Field.negate(this.x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat.isZero(12, r0) == false) goto L5;
        return this;
    L5:
        if (Nat.isOne(12, r0) == true) goto L14;
        int[] r8 = Nat.create(24);
        int[] r2 = Nat.create(12);
        int[] r3 = Nat.create(12);
        int[] r4 = Nat.create(12);
        int[] r5 = Nat.create(12);
        SecP384R1Field.square(r0, r2, r8);
        SecP384R1Field.multiply(r2, r0, r2, r8);
        SecP384R1Field.squareN(r2, 2, r3, r8);
        SecP384R1Field.multiply(r3, r2, r3, r8);
        SecP384R1Field.square(r3, r3, r8);
        SecP384R1Field.multiply(r3, r0, r3, r8);
        SecP384R1Field.squareN(r3, 5, r4, r8);
        SecP384R1Field.multiply(r4, r3, r4, r8);
        SecP384R1Field.squareN(r4, 5, r5, r8);
        SecP384R1Field.multiply(r5, r3, r5, r8);
        SecP384R1Field.squareN(r5, 15, r3, r8);
        SecP384R1Field.multiply(r3, r5, r3, r8);
        SecP384R1Field.squareN(r3, 2, r4, r8);
        SecP384R1Field.multiply(r2, r4, r2, r8);
        SecP384R1Field.squareN(r4, 28, r4, r8);
        SecP384R1Field.multiply(r3, r4, r3, r8);
        SecP384R1Field.squareN(r3, 60, r4, r8);
        SecP384R1Field.multiply(r4, r3, r4, r8);
        SecP384R1Field.squareN(r4, 120, r3, r8);
        SecP384R1Field.multiply(r3, r4, r3, r8);
        SecP384R1Field.squareN(r3, 15, r3, r8);
        SecP384R1Field.multiply(r3, r5, r3, r8);
        SecP384R1Field.squareN(r3, 33, r3, r8);
        SecP384R1Field.multiply(r3, r2, r3, r8);
        SecP384R1Field.squareN(r3, 64, r3, r8);
        SecP384R1Field.multiply(r3, r0, r3, r8);
        SecP384R1Field.squareN(r3, 30, r2, r8);
        SecP384R1Field.square(r2, r3, r8);
        if (Nat.eq(12, r0, r3) == true) goto L13;
        return null;
    L13:
        return new SecP384R1FieldElement(r2);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat.create(12);
        SecP384R1Field.square(this.x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat.create(12);
        SecP384R1Field.subtract(this.x, ((SecP384R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP384R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP384R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.x);
    }
}
