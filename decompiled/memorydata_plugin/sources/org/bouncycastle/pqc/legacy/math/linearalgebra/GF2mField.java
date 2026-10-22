package org.bouncycastle.pqc.legacy.math.linearalgebra;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class GF2mField {
    private int degree;
    private int polynomial;

    public GF2mField(byte[] r4) {
        this.degree = 0;
        if (r4.length != 4) goto L11;
        int r5 = LittleEndianConversions.OS2IP(r4);
        this.polynomial = r5;
        if (PolynomialRingGF2.isIrreducible(r5) == false) goto L9;
        this.degree = PolynomialRingGF2.degree(this.polynomial);
        return;
    L9:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    L11:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String polyToString(int r4) {
        if (r4 != 0) goto L5;
        return "0";
    L5:
        if (((byte) (r4 & 1)) != 1) goto L7;
        String r0 = "1";
    L8:
        int r5 = r4 >>> 1;
        int r2 = 1;
    L9:
        if (r5 == 0) goto L15;
        if (((byte) (r5 & 1)) != 1) goto L13;
        r0 = r0 + "+x^" + r2;
    L13:
        r5 = r5 >>> 1;
        r2 = r2 + 1;
        goto L9
    L15:
        return r0;
    L7:
        r0 = "";
        goto L8
    }

    public int add(int r1, int r2) {
        return r1 ^ r2;
    }

    public String elementToStr(int r5) {
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.degree) goto L10;
        if ((((byte) r5) & 1) != 0) goto L8;
        StringBuilder r2 = new StringBuilder();
        String r3 = "0";
    L9:
        r0 = r2.append(r3).append(r0).toString();
        r5 = r5 >>> 1;
        r1 = r1 + 1;
        goto L4
    L8:
        r2 = new StringBuilder();
        r3 = "1";
        goto L9
    L10:
        return r0;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
    L13:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, GF2mField.class) == false) goto L13;
        GF2mField r5 = (GF2mField) ZeusTransformUtils.preCheckCast(r4, GF2mField.class, "com.obric.memorydata.plugin");
        if (this.degree != r5.degree) goto L13;
        if (this.polynomial != r5.polynomial) goto L13;
        return true;
    }

    public int exp(int r4, int r5) {
        if (r5 != 0) goto L5;
        return 1;
    L5:
        if (r4 != 0) goto L8;
        return 0;
    L8:
        if (r4 != 1) goto L10;
        return 1;
    L10:
        if (r5 >= 0) goto L12;
        r4 = inverse(r4);
        r5 = -r5;
    L12:
        int r1 = 1;
    L13:
        if (r5 == 0) goto L18;
        if ((r5 & 1) != 1) goto L17;
        r1 = mult(r1, r4);
    L17:
        r4 = mult(r4, r4);
        r5 = r5 >>> 1;
        goto L13
    L18:
        return r1;
    }

    public int getDegree() {
        return this.degree;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.polynomial);
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int r3) {
        return exp(r3, (1 << this.degree) - 2);
    }

    public boolean isElementOfThisField(int r4) {
        int r3 = this.degree;
        if (r3 != 31) goto L7;
        if (r4 >= 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r4 >= 0) goto L9;
        return false;
    L9:
        if (r4 < (1 << r3)) goto L11;
        return false;
    L11:
        return true;
    }

    public int mult(int r1, int r2) {
        return PolynomialRingGF2.modMultiply(r1, r2, this.polynomial);
    }

    public String toString() {
        return "Finite Field GF(2^" + this.degree + ") = GF(2)[X]/<" + polyToString(this.polynomial) + "> ";
    }
}
