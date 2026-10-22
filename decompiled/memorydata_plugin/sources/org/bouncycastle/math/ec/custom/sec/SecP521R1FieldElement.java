package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP521R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    public SecP521R1FieldElement() {
        this.x = Nat.create(17);
    }

    public SecP521R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP521R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
    }

    public SecP521R1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat.create(17);
        SecP521R1Field.add(this.x, ((SecP521R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP521R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat.create(17);
        SecP521R1Field.addOne(this.x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat.create(17);
        SecP521R1Field.inv(((SecP521R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP521R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP521R1Field.multiply(r0, this.x, r0);
        return new SecP521R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP521R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP521R1FieldElement r4 = (SecP521R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP521R1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat.eq(17, this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 17) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat.create(17);
        SecP521R1Field.inv(this.x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(17, this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(17, this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat.create(17);
        SecP521R1Field.multiply(this.x, ((SecP521R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP521R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat.create(17);
        SecP521R1Field.negate(this.x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat.isZero(17, r0) == false) goto L5;
        return this;
    L5:
        if (Nat.isOne(17, r0) == true) goto L14;
        int[] r5 = Nat.create(33);
        int[] r2 = Nat.create(17);
        int[] r3 = Nat.create(17);
        SecP521R1Field.squareN(r0, 519, r2, r5);
        SecP521R1Field.square(r2, r3, r5);
        if (Nat.eq(17, r0, r3) == true) goto L13;
        return null;
    L13:
        return new SecP521R1FieldElement(r2);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat.create(17);
        SecP521R1Field.square(this.x, r0);
        return new SecP521R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat.create(17);
        SecP521R1Field.subtract(this.x, ((SecP521R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP521R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP521R1FieldElement(r0);
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
        return Nat.toBigInteger(17, this.x);
    }
}
