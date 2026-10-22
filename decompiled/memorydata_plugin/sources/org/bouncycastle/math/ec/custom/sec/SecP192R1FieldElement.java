package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP192R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));
    }

    public SecP192R1FieldElement() {
        this.x = Nat192.create();
    }

    public SecP192R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP192R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
    }

    public SecP192R1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat192.create();
        SecP192R1Field.add(this.x, ((SecP192R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP192R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat192.create();
        SecP192R1Field.addOne(this.x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat192.create();
        SecP192R1Field.inv(((SecP192R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP192R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP192R1Field.multiply(r0, this.x, r0);
        return new SecP192R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP192R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP192R1FieldElement r4 = (SecP192R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP192R1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat192.eq(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 6) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat192.create();
        SecP192R1Field.inv(this.x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat192.create();
        SecP192R1Field.multiply(this.x, ((SecP192R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP192R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat192.create();
        SecP192R1Field.negate(this.x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat192.isZero(r0) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat192.isOne(r0) == true) goto L12;
        int[] r3 = Nat192.create();
        int[] r1 = Nat192.create();
        SecP192R1Field.square(r0, r3);
        SecP192R1Field.multiply(r3, r0, r3);
        SecP192R1Field.squareN(r3, 2, r1);
        SecP192R1Field.multiply(r1, r3, r1);
        SecP192R1Field.squareN(r1, 4, r3);
        SecP192R1Field.multiply(r3, r1, r3);
        SecP192R1Field.squareN(r3, 8, r1);
        SecP192R1Field.multiply(r1, r3, r1);
        SecP192R1Field.squareN(r1, 16, r3);
        SecP192R1Field.multiply(r3, r1, r3);
        SecP192R1Field.squareN(r3, 32, r1);
        SecP192R1Field.multiply(r1, r3, r1);
        SecP192R1Field.squareN(r1, 64, r3);
        SecP192R1Field.multiply(r3, r1, r3);
        SecP192R1Field.squareN(r3, 62, r3);
        SecP192R1Field.square(r3, r1);
        if (Nat192.eq(r0, r1) == true) goto L13;
        return null;
    L13:
        return new SecP192R1FieldElement(r3);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat192.create();
        SecP192R1Field.square(this.x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat192.create();
        SecP192R1Field.subtract(this.x, ((SecP192R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP192R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP192R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat192.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.x);
    }
}
