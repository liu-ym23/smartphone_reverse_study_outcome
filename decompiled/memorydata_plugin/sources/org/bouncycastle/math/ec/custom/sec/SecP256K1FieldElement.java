package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP256K1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
    }

    public SecP256K1FieldElement() {
        this.x = Nat256.create();
    }

    public SecP256K1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP256K1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
    }

    public SecP256K1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256K1Field.add(this.x, ((SecP256K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat256.create();
        SecP256K1Field.addOne(this.x, r0);
        return new SecP256K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256K1Field.inv(((SecP256K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP256K1Field.multiply(r0, this.x, r0);
        return new SecP256K1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP256K1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP256K1FieldElement r4 = (SecP256K1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP256K1FieldElement.class, "com.obric.memorydata.plugin");
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
        SecP256K1Field.inv(this.x, r0);
        return new SecP256K1FieldElement(r0);
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
        SecP256K1Field.multiply(this.x, ((SecP256K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat256.create();
        SecP256K1Field.negate(this.x, r0);
        return new SecP256K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat256.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat256.isOne(r0) == true) goto L14;
        int[] r11 = Nat256.createExt();
        int[] r1 = Nat256.create();
        SecP256K1Field.square(r0, r1, r11);
        SecP256K1Field.multiply(r1, r0, r1, r11);
        int[] r2 = Nat256.create();
        SecP256K1Field.square(r1, r2, r11);
        SecP256K1Field.multiply(r2, r0, r2, r11);
        int[] r3 = Nat256.create();
        SecP256K1Field.squareN(r2, 3, r3, r11);
        SecP256K1Field.multiply(r3, r2, r3, r11);
        SecP256K1Field.squareN(r3, 3, r3, r11);
        SecP256K1Field.multiply(r3, r2, r3, r11);
        SecP256K1Field.squareN(r3, 2, r3, r11);
        SecP256K1Field.multiply(r3, r1, r3, r11);
        int[] r6 = Nat256.create();
        SecP256K1Field.squareN(r3, 11, r6, r11);
        SecP256K1Field.multiply(r6, r3, r6, r11);
        SecP256K1Field.squareN(r6, 22, r3, r11);
        SecP256K1Field.multiply(r3, r6, r3, r11);
        int[] r7 = Nat256.create();
        SecP256K1Field.squareN(r3, 44, r7, r11);
        SecP256K1Field.multiply(r7, r3, r7, r11);
        int[] r9 = Nat256.create();
        SecP256K1Field.squareN(r7, 88, r9, r11);
        SecP256K1Field.multiply(r9, r7, r9, r11);
        SecP256K1Field.squareN(r9, 44, r7, r11);
        SecP256K1Field.multiply(r7, r3, r7, r11);
        SecP256K1Field.squareN(r7, 3, r3, r11);
        SecP256K1Field.multiply(r3, r2, r3, r11);
        SecP256K1Field.squareN(r3, 23, r3, r11);
        SecP256K1Field.multiply(r3, r6, r3, r11);
        SecP256K1Field.squareN(r3, 6, r3, r11);
        SecP256K1Field.multiply(r3, r1, r3, r11);
        SecP256K1Field.squareN(r3, 2, r3, r11);
        SecP256K1Field.square(r3, r1, r11);
        if (Nat256.eq(r0, r1) == true) goto L13;
        return null;
    L13:
        return new SecP256K1FieldElement(r3);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat256.create();
        SecP256K1Field.square(this.x, r0);
        return new SecP256K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SecP256K1Field.subtract(this.x, ((SecP256K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP256K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP256K1FieldElement(r0);
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
