package org.bouncycastle.math.ec.custom.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SecP224R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;
    protected int[] x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
    }

    public SecP224R1FieldElement() {
        this.x = Nat224.create();
    }

    public SecP224R1FieldElement(BigInteger r2) {
        if (r2 == null) goto L11;
        if (r2.signum() < 0) goto L11;
        if (r2.compareTo(Q) >= 0) goto L11;
        this.x = SecP224R1Field.fromBigInteger(r2);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
    }

    public SecP224R1FieldElement(int[] r1) {
        this.x = r1;
    }

    private static void RM(int[] r0, int[] r1, int[] r2, int[] r3, int[] r4, int[] r5, int[] r6) {
        SecP224R1Field.multiply(r4, r2, r6);
        SecP224R1Field.multiply(r6, r0, r6);
        SecP224R1Field.multiply(r3, r1, r5);
        SecP224R1Field.add(r5, r6, r5);
        SecP224R1Field.multiply(r3, r2, r6);
        Nat224.copy(r5, r3);
        SecP224R1Field.multiply(r4, r1, r4);
        SecP224R1Field.add(r4, r6, r4);
        SecP224R1Field.square(r4, r5);
        SecP224R1Field.multiply(r5, r0, r5);
    }

    private static void RP(int[] r10, int[] r11, int[] r12, int[] r13, int[] r14) {
        Nat224.copy(r10, r13);
        int[] r7 = Nat224.create();
        int[] r8 = Nat224.create();
        int r9 = 0;
    L4:
        if (r9 >= 7) goto L10;
        Nat224.copy(r11, r7);
        Nat224.copy(r12, r8);
        int r0 = 1 << r9;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L9;
        RS(r11, r12, r13, r14);
        goto L6
    L9:
        RM(r10, r7, r8, r11, r12, r13, r14);
        r9 = r9 + 1;
        goto L4
    }

    private static void RS(int[] r0, int[] r1, int[] r2, int[] r3) {
        SecP224R1Field.multiply(r1, r0, r1);
        SecP224R1Field.twice(r1, r1);
        SecP224R1Field.square(r0, r3);
        SecP224R1Field.add(r2, r3, r0);
        SecP224R1Field.multiply(r2, r3, r2);
        SecP224R1Field.reduce32(Nat.shiftUpBits(7, r2, 2, 0), r2);
    }

    private static boolean isSquare(int[] r3) {
        int[] r0 = Nat224.create();
        int[] r1 = Nat224.create();
        Nat224.copy(r3, r0);
        int r4 = 0;
    L4:
        if (r4 >= 7) goto L6;
        Nat224.copy(r0, r1);
        SecP224R1Field.squareN(r0, 1 << r4, r0);
        SecP224R1Field.multiply(r0, r1, r0);
        r4 = r4 + 1;
        goto L4
    L6:
        SecP224R1Field.squareN(r0, 95, r0);
        return Nat224.isOne(r0);
    }

    private static boolean trySqrt(int[] r7, int[] r8, int[] r9) {
        int[] r0 = Nat224.create();
        Nat224.copy(r8, r0);
        int[] r10 = Nat224.create();
        r10[0] = 1;
        int[] r3 = Nat224.create();
        RP(r7, r0, r10, r3, r9);
        int[] r11 = Nat224.create();
        int[] r4 = Nat224.create();
        int r5 = 1;
    L4:
        if (r5 >= 96) goto L10;
        Nat224.copy(r0, r11);
        Nat224.copy(r10, r4);
        RS(r0, r10, r3, r9);
        if (Nat224.isZero(r0) == true) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        SecP224R1Field.inv(r4, r9);
        SecP224R1Field.multiply(r9, r11, r9);
        return true;
    L10:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224R1Field.add(this.x, ((SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r0 = Nat224.create();
        SecP224R1Field.addOne(this.x, r0);
        return new SecP224R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224R1Field.inv(((SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        SecP224R1Field.multiply(r0, this.x, r0);
        return new SecP224R1FieldElement(r0);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, SecP224R1FieldElement.class) == true) goto L10;
        return false;
    L10:
        SecP224R1FieldElement r4 = (SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r3, SecP224R1FieldElement.class, "com.obric.memorydata.plugin");
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
        SecP224R1Field.inv(this.x, r0);
        return new SecP224R1FieldElement(r0);
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
        SecP224R1Field.multiply(this.x, ((SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r0 = Nat224.create();
        SecP224R1Field.negate(this.x, r0);
        return new SecP224R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r0 = this.x;
        if (Nat224.isZero(r0) == false) goto L5;
    L17:
        return this;
    L5:
        if (Nat224.isOne(r0) == true) goto L17;
        int[] r5 = Nat224.create();
        SecP224R1Field.negate(r0, r5);
        int[] r1 = Mod.random(SecP224R1Field.P);
        int[] r2 = Nat224.create();
        if (isSquare(r0) == true) goto L11;
        return null;
    L11:
        if (trySqrt(r5, r1, r2) == true) goto L13;
        SecP224R1Field.addOne(r1, r1);
        goto L11
    L13:
        SecP224R1Field.square(r2, r1);
        if (Nat224.eq(r0, r1) == true) goto L16;
        return null;
    L16:
        return new SecP224R1FieldElement(r2);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r0 = Nat224.create();
        SecP224R1Field.square(this.x, r0);
        return new SecP224R1FieldElement(r0);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r4) {
        int[] r0 = Nat224.create();
        SecP224R1Field.subtract(this.x, ((SecP224R1FieldElement) ZeusTransformUtils.preCheckCast(r4, SecP224R1FieldElement.class, "com.obric.memorydata.plugin")).x, r0);
        return new SecP224R1FieldElement(r0);
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
