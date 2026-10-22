package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP224K1FieldElement extends ECFieldElement.AbstractFp {
    private static final int[] PRECOMP_POW2 = null;
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
        PRECOMP_POW2 = new int[]{868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};
    }

    public SecP224K1FieldElement() {
        this.x = Nat224.create();
    }

    public SecP224K1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP224K1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
    }

    public SecP224K1FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224K1Field.add(this.x, ((SecP224K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat224.create();
        SecP224K1Field.addOne(this.x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224K1Field.inv(((SecP224K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP224K1Field.multiply(r0, this.x, r0);
        return new SecP224K1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP224K1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP224K1FieldElement r4 = (SecP224K1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP224K1FieldElement.class, "com.obric.memorydata.plugin");
        return Nat224.eq(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 7) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat224.create();
        SecP224K1Field.inv(this.x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224K1Field.multiply(this.x, ((SecP224K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat224.create();
        SecP224K1Field.negate(this.x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat224.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat224.isOne(r0) == true) goto L18;
        int[] r8 = Nat224.create();
        SecP224K1Field.square(r0, r8);
        SecP224K1Field.multiply(r8, r0, r8);
        SecP224K1Field.square(r8, r8);
        SecP224K1Field.multiply(r8, r0, r8);
        int[] r1 = Nat224.create();
        SecP224K1Field.square(r8, r1);
        SecP224K1Field.multiply(r1, r0, r1);
        int[] r2 = Nat224.create();
        SecP224K1Field.squareN(r1, 4, r2);
        SecP224K1Field.multiply(r2, r1, r2);
        int[] r4 = Nat224.create();
        SecP224K1Field.squareN(r2, 3, r4);
        SecP224K1Field.multiply(r4, r8, r4);
        SecP224K1Field.squareN(r4, 8, r4);
        SecP224K1Field.multiply(r4, r2, r4);
        SecP224K1Field.squareN(r4, 4, r2);
        SecP224K1Field.multiply(r2, r1, r2);
        SecP224K1Field.squareN(r2, 19, r1);
        SecP224K1Field.multiply(r1, r4, r1);
        int[] r6 = Nat224.create();
        SecP224K1Field.squareN(r1, 42, r6);
        SecP224K1Field.multiply(r6, r1, r6);
        SecP224K1Field.squareN(r6, 23, r1);
        SecP224K1Field.multiply(r1, r2, r1);
        SecP224K1Field.squareN(r1, 84, r2);
        SecP224K1Field.multiply(r2, r6, r2);
        SecP224K1Field.squareN(r2, 20, r2);
        SecP224K1Field.multiply(r2, r4, r2);
        SecP224K1Field.squareN(r2, 3, r2);
        SecP224K1Field.multiply(r2, r0, r2);
        SecP224K1Field.squareN(r2, 2, r2);
        SecP224K1Field.multiply(r2, r0, r2);
        SecP224K1Field.squareN(r2, 4, r2);
        SecP224K1Field.multiply(r2, r8, r2);
        SecP224K1Field.square(r2, r2);
        SecP224K1Field.square(r2, r6);
        if (Nat224.eq(r0, r6) == true) goto L10;
        SecP224K1Field.multiply(r2, PRECOMP_POW2, r2);
        SecP224K1Field.square(r2, r6);
        if (Nat224.eq(r0, r6) == true) goto L14;
        return null;
    L14:
        return new SecP224K1FieldElement(r2);
    L10:
        return new SecP224K1FieldElement(r2);
    L18:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat224.create();
        SecP224K1Field.square(this.x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224K1Field.subtract(this.x, ((SecP224K1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224K1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224K1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat224.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.x);
    }
}
