package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP160R2FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));
    }

    public SecP160R2FieldElement() {
        this.x = Nat160.create();
    }

    public SecP160R2FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP160R2Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
    }

    public SecP160R2FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat160.create();
        SecP160R2Field.add(this.x, ((SecP160R2FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP160R2FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat160.create();
        SecP160R2Field.addOne(this.x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat160.create();
        SecP160R2Field.inv(((SecP160R2FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP160R2FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP160R2Field.multiply(r0, this.x, r0);
        return new SecP160R2FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP160R2FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP160R2FieldElement r4 = (SecP160R2FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP160R2FieldElement.class, "com.obric.memorydata.plugin");
        return Nat160.eq(this.x, r4.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        int r0 = Q.hashCode();
        return Arrays.hashCode(this.x, 0, 5) ^ r0;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r0 = Nat160.create();
        SecP160R2Field.inv(this.x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat160.isOne(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat160.isZero(this.x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r4) {
        int[] r0 = Nat160.create();
        SecP160R2Field.multiply(this.x, ((SecP160R2FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP160R2FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat160.create();
        SecP160R2Field.negate(this.x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat160.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat160.isOne(r0) == true) goto L14;
        int[] r7 = Nat160.create();
        SecP160R2Field.square(r0, r7);
        SecP160R2Field.multiply(r7, r0, r7);
        int[] r1 = Nat160.create();
        SecP160R2Field.square(r7, r1);
        SecP160R2Field.multiply(r1, r0, r1);
        int[] r2 = Nat160.create();
        SecP160R2Field.square(r1, r2);
        SecP160R2Field.multiply(r2, r0, r2);
        int[] r3 = Nat160.create();
        SecP160R2Field.squareN(r2, 3, r3);
        SecP160R2Field.multiply(r3, r1, r3);
        SecP160R2Field.squareN(r3, 7, r2);
        SecP160R2Field.multiply(r2, r3, r2);
        SecP160R2Field.squareN(r2, 3, r3);
        SecP160R2Field.multiply(r3, r1, r3);
        int[] r5 = Nat160.create();
        SecP160R2Field.squareN(r3, 14, r5);
        SecP160R2Field.multiply(r5, r2, r5);
        SecP160R2Field.squareN(r5, 31, r2);
        SecP160R2Field.multiply(r2, r5, r2);
        SecP160R2Field.squareN(r2, 62, r5);
        SecP160R2Field.multiply(r5, r2, r5);
        SecP160R2Field.squareN(r5, 3, r2);
        SecP160R2Field.multiply(r2, r1, r2);
        SecP160R2Field.squareN(r2, 18, r2);
        SecP160R2Field.multiply(r2, r3, r2);
        SecP160R2Field.squareN(r2, 2, r2);
        SecP160R2Field.multiply(r2, r0, r2);
        SecP160R2Field.squareN(r2, 3, r2);
        SecP160R2Field.multiply(r2, r7, r2);
        SecP160R2Field.squareN(r2, 6, r2);
        SecP160R2Field.multiply(r2, r1, r2);
        SecP160R2Field.squareN(r2, 2, r2);
        SecP160R2Field.multiply(r2, r0, r2);
        SecP160R2Field.square(r2, r7);
        if (Nat160.eq(r0, r7) == true) goto L13;
        return null;
    L13:
        return new SecP160R2FieldElement(r2);
    L14:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat160.create();
        SecP160R2Field.square(this.x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat160.create();
        SecP160R2Field.subtract(this.x, ((SecP160R2FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP160R2FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP160R2FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat160.getBit(this.x, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat160.toBigInteger(this.x);
    }
}
