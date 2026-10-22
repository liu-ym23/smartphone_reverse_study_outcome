package org.bouncycastle.math.ec.custom.djb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class Curve25519FieldElement extends ECFieldElement.AbstractFp {
    private static final int[] PRECOMP_POW2 = null;
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = Nat256.toBigInteger(Curve25519Field.P);
        PRECOMP_POW2 = new int[]{1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    }

    public Curve25519FieldElement() {
        this.x = Nat256.create();
    }

    public Curve25519FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = Curve25519Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
    }

    public Curve25519FieldElement(int[] r1) {
        this.x = r1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        Curve25519Field.add(this.x, ((Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r4, Curve25519FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new Curve25519FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat256.create();
        Curve25519Field.addOne(this.x, r0);
        return new Curve25519FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        Curve25519Field.inv(((Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r4, Curve25519FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        Curve25519Field.multiply(r0, this.x, r0);
        return new Curve25519FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Curve25519FieldElement.class) == true) goto L10;
        return false;
    L10:
        Curve25519FieldElement r4 = (Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r3, Curve25519FieldElement.class, "com.obric.memorydata.plugin");
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
        Curve25519Field.inv(this.x, r0);
        return new Curve25519FieldElement(r0);
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
        Curve25519Field.multiply(this.x, ((Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r4, Curve25519FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new Curve25519FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat256.create();
        Curve25519Field.negate(this.x, r0);
        return new Curve25519FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat256.isZero(r0) == false) goto L5;
        return this;
    L5:
        if (Nat256.isOne(r0) == true) goto L18;
        int[] r4 = Nat256.create();
        Curve25519Field.square(r0, r4);
        Curve25519Field.multiply(r4, r0, r4);
        Curve25519Field.square(r4, r4);
        Curve25519Field.multiply(r4, r0, r4);
        int[] r1 = Nat256.create();
        Curve25519Field.square(r4, r1);
        Curve25519Field.multiply(r1, r0, r1);
        int[] r2 = Nat256.create();
        Curve25519Field.squareN(r1, 3, r2);
        Curve25519Field.multiply(r2, r4, r2);
        Curve25519Field.squareN(r2, 4, r4);
        Curve25519Field.multiply(r4, r1, r4);
        Curve25519Field.squareN(r4, 4, r2);
        Curve25519Field.multiply(r2, r1, r2);
        Curve25519Field.squareN(r2, 15, r1);
        Curve25519Field.multiply(r1, r2, r1);
        Curve25519Field.squareN(r1, 30, r2);
        Curve25519Field.multiply(r2, r1, r2);
        Curve25519Field.squareN(r2, 60, r1);
        Curve25519Field.multiply(r1, r2, r1);
        Curve25519Field.squareN(r1, 11, r2);
        Curve25519Field.multiply(r2, r4, r2);
        Curve25519Field.squareN(r2, 120, r4);
        Curve25519Field.multiply(r4, r1, r4);
        Curve25519Field.square(r4, r4);
        Curve25519Field.square(r4, r1);
        if (Nat256.eq(r0, r1) == true) goto L10;
        Curve25519Field.multiply(r4, PRECOMP_POW2, r4);
        Curve25519Field.square(r4, r1);
        if (Nat256.eq(r0, r1) == true) goto L14;
        return null;
    L14:
        return new Curve25519FieldElement(r4);
    L10:
        return new Curve25519FieldElement(r4);
    L18:
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat256.create();
        Curve25519Field.square(this.x, r0);
        return new Curve25519FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat256.create();
        Curve25519Field.subtract(this.x, ((Curve25519FieldElement) ZeusTransformUtils.preCheckCast(r4, Curve25519FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new Curve25519FieldElement(r0);
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
