package org.bouncycastle.pqc.legacy.math.linearalgebra;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class PolynomialGF2mSmallM {
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField r1, int r2) {
        this.field = r1;
        this.degree = r2;
        int[] r3 = new int[r2 + 1];
        this.coefficients = r3;
        r3[r2] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField r10, byte[] r11) {
        this.field = r10;
        int r0 = 8;
        int r2 = 1;
    L4:
        if (r10.getDegree() <= r0) goto L7;
        r2 = r2 + 1;
        r0 = r0 + 8;
        goto L4
    L7:
        if ((r11.length % r2) != 0) goto L29;
        this.coefficients = new int[r11.length / r2];
        int r3 = 0;
        int r4 = 0;
    L9:
        int[] r5 = this.coefficients;
        if (r3 >= r5.length) goto L20;
        int r6 = 0;
    L12:
        if (r6 >= r0) goto L15;
        int[] r7 = this.coefficients;
        r7[r3] = ((r11[r4] & 255) << r6) ^ r7[r3];
        r6 = r6 + 8;
        r4 = r4 + 1;
        goto L12
    L15:
        if (this.field.isElementOfThisField(this.coefficients[r3]) == false) goto L18;
        r3 = r3 + 1;
        goto L9
    L18:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L20:
        if (r5.length != 1) goto L22;
    L26:
        computeDegree();
        return;
    L22:
        if (r5[r5.length - 1] != 0) goto L26;
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L29:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    }

    public PolynomialGF2mSmallM(GF2mField r1, int[] r2) {
        this.field = r1;
        this.coefficients = normalForm(r2);
        computeDegree();
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM r2) {
        this.field = r2.field;
        this.degree = r2.degree;
        this.coefficients = IntUtils.clone(r2.coefficients);
    }

    private int[] add(int[] r5, int[] r6) {
        if (r5.length >= r6.length) goto L5;
        int[] r0 = new int[r6.length];
        System.arraycopy(r6, 0, r0, 0, r6.length);
    L6:
        int r7 = r5.length - 1;
    L7:
        if (r7 < 0) goto L9;
        r0[r7] = this.field.add(r0[r7], r5[r7]);
        r7 = r7 - 1;
        goto L7
    L9:
        return r0;
    L5:
        r0 = new int[r5.length];
        System.arraycopy(r5, 0, r0, 0, r5.length);
        r5 = r6;
        goto L6
    }

    private static int computeDegree(int[] r2) {
        int r0 = r2.length - 1;
    L3:
        if (r0 < 0) goto L7;
        if (r2[r0] != 0) goto L7;
        r0 = r0 - 1;
    L7:
        return r0;
    }

    private void computeDegree() {
        int r0 = this.coefficients.length;
    L3:
        this.degree = r0 - 1;
        r0 = this.degree;
        if (r0 < 0) goto L8;
        if (this.coefficients[r0] == 0) goto L3;
        return;
    }

    private static int headCoefficient(int[] r2) {
        int r0 = computeDegree(r2);
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r2[r0];
    }

    private static boolean isEqual(int[] r5, int[] r6) {
        int r0 = computeDegree(r5);
        if (r0 == computeDegree(r6)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 > r0) goto L11;
        if (r5[r1] != r6[r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private int[] mod(int[] r6, int[] r7) {
        int r0 = computeDegree(r7);
        if (r0 == (-1)) goto L10;
        int r1 = r6.length;
        int[] r2 = new int[r1];
        int r3 = headCoefficient(r7);
        int r4 = this.field.inverse(r3);
        System.arraycopy(r6, 0, r2, 0, r1);
    L6:
        if (r0 > computeDegree(r2)) goto L8;
        int r8 = this.field.mult(headCoefficient(r2), r4);
        r2 = add(multWithElement(multWithMonomial(r7, computeDegree(r2) - r0), r8), r2);
        goto L6
    L8:
        return r2;
    L10:
        throw new ArithmeticException("Division by zero");
    }

    private int[] multWithElement(int[] r5, int r6) {
        int r0 = computeDegree(r5);
        if (r0 == (-1)) goto L14;
        if (r6 == 0) goto L14;
        if (r6 == 1) goto L8;
        int[] r1 = new int[r0 + 1];
    L10:
        if (r0 < 0) goto L12;
        r1[r0] = this.field.mult(r5[r0], r6);
        r0 = r0 - 1;
        goto L10
    L12:
        return r1;
    L8:
        return IntUtils.clone(r5);
    L14:
        return new int[1];
    }

    private static int[] multWithMonomial(int[] r4, int r5) {
        int r0 = computeDegree(r4);
        if (r0 == (-1)) goto L5;
        int[] r2 = new int[(r0 + r5) + 1];
        System.arraycopy(r4, 0, r2, r5, r0 + 1);
        return r2;
    L5:
        return new int[1];
    }

    private static int[] normalForm(int[] r3) {
        int r0 = computeDegree(r3);
        if (r0 == (-1)) goto L5;
        int r1 = r0 + 1;
        if (r3.length == r1) goto L9;
        int[] r2 = new int[r1];
        System.arraycopy(r3, 0, r2, 0, r1);
        return r2;
    L9:
        return IntUtils.clone(r3);
    L5:
        return new int[1];
    }

    public void addToThis(PolynomialGF2mSmallM r2) {
        this.coefficients = add(this.coefficients, r2.coefficients);
        computeDegree();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
    L15:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, PolynomialGF2mSmallM.class) == false) goto L15;
        PolynomialGF2mSmallM r5 = (PolynomialGF2mSmallM) ZeusTransformUtils.preCheckCast(r4, PolynomialGF2mSmallM.class, "com.obric.memorydata.plugin");
        if (this.field.equals(r5.field) == false) goto L15;
        if (this.degree != r5.degree) goto L15;
        if (isEqual(this.coefficients, r5.coefficients) == false) goto L15;
        return true;
    }

    public int evaluateAt(int r4) {
        int[] r0 = this.coefficients;
        int r1 = this.degree;
        int r2 = r0[r1];
        int r3 = r1 - 1;
    L3:
        if (r3 < 0) goto L5;
        r2 = this.field.mult(r2, r4) ^ this.coefficients[r3];
        r3 = r3 - 1;
        goto L3
    L5:
        return r2;
    }

    public int getCoefficient(int r2) {
        if (r2 >= 0) goto L4;
        return 0;
    L4:
        if (r2 <= this.degree) goto L7;
        return 0;
    L7:
        return this.coefficients[r2];
    }

    public int getDegree() {
        int[] r1 = this.coefficients;
        int r0 = r1.length - 1;
        if (r1[r0] != 0) goto L6;
        return -1;
    L6:
        return r0;
    }

    public byte[] getEncoded() {
        int r0 = 8;
        int r1 = 1;
    L4:
        if (this.field.getDegree() <= r0) goto L6;
        r1 = r1 + 1;
        r0 = r0 + 8;
        goto L4
    L6:
        byte[] r2 = new byte[this.coefficients.length * r1];
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= this.coefficients.length) goto L13;
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L12;
        r2[r4] = (byte) (this.coefficients[r3] >>> r5);
        r5 = r5 + 8;
        r4 = r4 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        return r2;
    }

    public int hashCode() {
        int r0 = this.field.hashCode();
        int r1 = 0;
    L3:
        int[] r2 = this.coefficients;
        if (r1 >= r2.length) goto L6;
        r0 = (r0 * 31) + r2[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM r2) {
        int[] r3 = mod(this.coefficients, r2.coefficients);
        return new PolynomialGF2mSmallM(this.field, r3);
    }

    public void multThisWithElement(int r2) {
        if (this.field.isElementOfThisField(r2) == false) goto L7;
        this.coefficients = multWithElement(this.coefficients, r2);
        computeDegree();
        return;
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int r2) {
        if (this.field.isElementOfThisField(r2) == false) goto L7;
        int[] r3 = multWithElement(this.coefficients, r2);
        return new PolynomialGF2mSmallM(this.field, r3);
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public String toString() {
        String r0 = " Polynomial over " + this.field.toString() + ": \n";
        int r1 = 0;
    L4:
        if (r1 >= this.coefficients.length) goto L7;
        r0 = r0 + this.field.elementToStr(this.coefficients[r1]) + "Y^" + r1 + Marker.ANY_NON_NULL_MARKER;
        r1 = r1 + 1;
        goto L4
    L7:
        return r0 + ";";
    }
}
