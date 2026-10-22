package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP128R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    public SecP128R1FieldElement() {
        this.x = Nat128.create();
    }

    public SecP128R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP128R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
    }

    public SecP128R1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat128.create();
        SecP128R1Field.add(this.x, ((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat128.create();
        SecP128R1Field.addOne(this.x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat128.create();
        SecP128R1Field.inv(((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP128R1Field.multiply(r0, this.x, r0);
        return new SecP128R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP128R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP128R1FieldElement r4 = (SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP128R1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat128.eq(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 4) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat128.create();
        SecP128R1Field.inv(this.x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat128.isOne(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat128.isZero(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat128.create();
        SecP128R1Field.multiply(this.x, ((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat128.create();
        SecP128R1Field.negate(this.x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat128.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat128.isOne(r0) == true) goto L14;
        int[] r5 = Nat128.create();
        SecP128R1Field.square(r0, r5);
        SecP128R1Field.multiply(r5, r0, r5);
        int[] r1 = Nat128.create();
        SecP128R1Field.squareN(r5, 2, r1);
        SecP128R1Field.multiply(r1, r5, r1);
        int[] r3 = Nat128.create();
        SecP128R1Field.squareN(r1, 4, r3);
        SecP128R1Field.multiply(r3, r1, r3);
        SecP128R1Field.squareN(r3, 2, r1);
        SecP128R1Field.multiply(r1, r5, r1);
        SecP128R1Field.squareN(r1, 10, r5);
        SecP128R1Field.multiply(r5, r1, r5);
        SecP128R1Field.squareN(r5, 10, r3);
        SecP128R1Field.multiply(r3, r1, r3);
        SecP128R1Field.square(r3, r1);
        SecP128R1Field.multiply(r1, r0, r1);
        SecP128R1Field.squareN(r1, 95, r1);
        SecP128R1Field.square(r1, r3);
        if (Nat128.eq(r0, r3) == true) goto L13;
        return null;
    L13:
        return new SecP128R1FieldElement(r1);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat128.create();
        SecP128R1Field.square(this.x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat128.create();
        SecP128R1Field.subtract(this.x, ((SecP128R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP128R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP128R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat128.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat128.toBigInteger(this.x);
    }
}
