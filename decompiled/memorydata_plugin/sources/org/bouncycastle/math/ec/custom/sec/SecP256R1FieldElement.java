package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP256R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    public SecP256R1FieldElement() {
        this.x = Nat256.create();
    }

    public SecP256R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP256R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
    }

    public SecP256R1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256R1Field.add(this.x, ((SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat256.create();
        SecP256R1Field.addOne(this.x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256R1Field.inv(((SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP256R1Field.multiply(r0, this.x, r0);
        return new SecP256R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP256R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP256R1FieldElement r4 = (SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP256R1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat256.eq(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 8) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat256.create();
        SecP256R1Field.inv(this.x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256R1Field.multiply(this.x, ((SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat256.create();
        SecP256R1Field.negate(this.x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat256.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat256.isOne(r0) == true) goto L14;
        int[] r4 = Nat256.createExt();
        int[] r1 = Nat256.create();
        int[] r2 = Nat256.create();
        SecP256R1Field.square(r0, r1, r4);
        SecP256R1Field.multiply(r1, r0, r1, r4);
        SecP256R1Field.squareN(r1, 2, r2, r4);
        SecP256R1Field.multiply(r2, r1, r2, r4);
        SecP256R1Field.squareN(r2, 4, r1, r4);
        SecP256R1Field.multiply(r1, r2, r1, r4);
        SecP256R1Field.squareN(r1, 8, r2, r4);
        SecP256R1Field.multiply(r2, r1, r2, r4);
        SecP256R1Field.squareN(r2, 16, r1, r4);
        SecP256R1Field.multiply(r1, r2, r1, r4);
        SecP256R1Field.squareN(r1, 32, r1, r4);
        SecP256R1Field.multiply(r1, r0, r1, r4);
        SecP256R1Field.squareN(r1, 96, r1, r4);
        SecP256R1Field.multiply(r1, r0, r1, r4);
        SecP256R1Field.squareN(r1, 94, r1, r4);
        SecP256R1Field.square(r1, r2, r4);
        if (Nat256.eq(r0, r2) == true) goto L13;
        return null;
    L13:
        return new SecP256R1FieldElement(r1);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat256.create();
        SecP256R1Field.square(this.x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256R1Field.subtract(this.x, ((SecP256R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat256.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.x);
    }
}
