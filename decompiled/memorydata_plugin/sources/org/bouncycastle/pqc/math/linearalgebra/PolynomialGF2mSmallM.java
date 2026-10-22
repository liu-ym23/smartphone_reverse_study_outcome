package org.bouncycastle.pqc.math.linearalgebra;

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

    public PolynomialGF2mSmallM(GF2mField r1, int[] r2) {
        this.field = r1;
        this.coefficients = normalForm(r2);
        computeDegree();
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

    public PolynomialGF2mSmallM addMonomial(int r3) {
        int[] r0 = new int[r3 + 1];
        r0[r3] = 1;
        int[] r4 = add(this.coefficients, r0);
        return new PolynomialGF2mSmallM(this.field, r4);
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
