package org.bouncycastle.math.ec.custom.gm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SM2P256V1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));
    }

    public SM2P256V1FieldElement() {
        this.x = Nat256.create();
    }

    public SM2P256V1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SM2P256V1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
    }

    public SM2P256V1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SM2P256V1Field.add(this.x, ((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4, SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat256.create();
        SM2P256V1Field.addOne(this.x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SM2P256V1Field.inv(((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4, SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SM2P256V1Field.multiply(r0, this.x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SM2P256V1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SM2P256V1FieldElement r4 = (SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r3, SM2P256V1FieldElement.class, "com.obric.memorydata.plugin");
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
        SM2P256V1Field.inv(this.x, r0);
        return new SM2P256V1FieldElement(r0);
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
        SM2P256V1Field.multiply(this.x, ((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4, SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat256.create();
        SM2P256V1Field.negate(this.x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat256.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat256.isOne(r0) == true) goto L14;
        int[] r6 = Nat256.create();
        SM2P256V1Field.square(r0, r6);
        SM2P256V1Field.multiply(r6, r0, r6);
        int[] r1 = Nat256.create();
        SM2P256V1Field.squareN(r6, 2, r1);
        SM2P256V1Field.multiply(r1, r6, r1);
        int[] r3 = Nat256.create();
        SM2P256V1Field.squareN(r1, 2, r3);
        SM2P256V1Field.multiply(r3, r6, r3);
        SM2P256V1Field.squareN(r3, 6, r6);
        SM2P256V1Field.multiply(r6, r3, r6);
        int[] r4 = Nat256.create();
        SM2P256V1Field.squareN(r6, 12, r4);
        SM2P256V1Field.multiply(r4, r6, r4);
        SM2P256V1Field.squareN(r4, 6, r6);
        SM2P256V1Field.multiply(r6, r3, r6);
        SM2P256V1Field.square(r6, r3);
        SM2P256V1Field.multiply(r3, r0, r3);
        SM2P256V1Field.squareN(r3, 31, r4);
        SM2P256V1Field.multiply(r4, r3, r6);
        SM2P256V1Field.squareN(r4, 32, r4);
        SM2P256V1Field.multiply(r4, r6, r4);
        SM2P256V1Field.squareN(r4, 62, r4);
        SM2P256V1Field.multiply(r4, r6, r4);
        SM2P256V1Field.squareN(r4, 4, r4);
        SM2P256V1Field.multiply(r4, r1, r4);
        SM2P256V1Field.squareN(r4, 32, r4);
        SM2P256V1Field.multiply(r4, r0, r4);
        SM2P256V1Field.squareN(r4, 62, r4);
        SM2P256V1Field.square(r4, r1);
        if (Nat256.eq(r0, r1) == true) goto L13;
        return null;
    L13:
        return new SM2P256V1FieldElement(r4);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat256.create();
        SM2P256V1Field.square(this.x, r0);
        return new SM2P256V1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        SM2P256V1Field.subtract(this.x, ((SM2P256V1FieldElement) ZeusTransformUtils.preCheckCast(r4, SM2P256V1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SM2P256V1FieldElement(r0);
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
