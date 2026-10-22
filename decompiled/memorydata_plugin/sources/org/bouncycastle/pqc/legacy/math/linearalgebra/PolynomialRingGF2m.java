package org.bouncycastle.pqc.legacy.math.linearalgebra;

/* JADX INFO: loaded from: classes7.dex */
public class PolynomialRingGF2m {
    private GF2mField field;
    private PolynomialGF2mSmallM p;
    protected PolynomialGF2mSmallM[] sqMatrix;
    protected PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField r1, PolynomialGF2mSmallM r2) {
        this.field = r1;
        this.p = r2;
        computeSquaringMatrix();
        computeSquareRootMatrix();
    }

    private void computeSquareRootMatrix() {
        int r0 = this.p.getDegree();
        PolynomialGF2mSmallM[] r1 = new PolynomialGF2mSmallM[r0];
        int r2 = r0 - 1;
        int r3 = r2;
    L3:
        if (r3 < 0) goto L5;
        r1[r3] = new PolynomialGF2mSmallM(this.sqMatrix[r3]);
        r3 = r3 - 1;
        goto L3
    L5:
        this.sqRootMatrix = new PolynomialGF2mSmallM[r0];
    L6:
        if (r2 < 0) goto L8;
        this.sqRootMatrix[r2] = new PolynomialGF2mSmallM(this.field, r2);
        r2 = r2 - 1;
        goto L6
    L8:
        int r4 = 0;
    L9:
        if (r4 >= r0) goto L30;
        if (r1[r4].getCoefficient(r4) != 0) goto L22;
        int r5 = r4 + 1;
        boolean r6 = false;
    L13:
        if (r5 >= r0) goto L18;
        if (r1[r5].getCoefficient(r4) == 0) goto L17;
        swapColumns(r1, r4, r5);
        swapColumns(this.sqRootMatrix, r4, r5);
        r5 = r0;
        r6 = true;
    L17:
        r5 = r5 + 1;
        goto L13
    L18:
        if (r6 == true) goto L22;
        throw new ArithmeticException("Squaring matrix is not invertible.");
    L22:
        int r7 = this.field.inverse(r1[r4].getCoefficient(r4));
        r1[r4].multThisWithElement(r7);
        this.sqRootMatrix[r4].multThisWithElement(r7);
        int r8 = 0;
    L23:
        if (r8 >= r0) goto L29;
        if (r8 == r4) goto L28;
        int r9 = r1[r8].getCoefficient(r4);
        if (r9 == 0) goto L28;
        PolynomialGF2mSmallM r10 = r1[r4].multWithElement(r9);
        PolynomialGF2mSmallM r11 = this.sqRootMatrix[r4].multWithElement(r9);
        r1[r8].addToThis(r10);
        this.sqRootMatrix[r8].addToThis(r11);
    L28:
        r8 = r8 + 1;
        goto L23
    L29:
        r4 = r4 + 1;
        goto L9
    }

    private void computeSquaringMatrix() {
        int r0 = this.p.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[r0];
        int r1 = 0;
    L3:
        int r2 = r0 >> 1;
        if (r1 >= r2) goto L6;
        int r3 = r1 << 1;
        int[] r4 = new int[r3 + 1];
        r4[r3] = 1;
        this.sqMatrix[r1] = new PolynomialGF2mSmallM(this.field, r4);
        r1 = r1 + 1;
    L6:
        if (r2 >= r0) goto L8;
        int r5 = r2 << 1;
        int[] r6 = new int[r5 + 1];
        r6[r5] = 1;
        PolynomialGF2mSmallM r7 = new PolynomialGF2mSmallM(this.field, r6);
        this.sqMatrix[r2] = r7.mod(this.p);
        r2 = r2 + 1;
        goto L6
    }

    private static void swapColumns(PolynomialGF2mSmallM[] r2, int r3, int r4) {
        PolynomialGF2mSmallM r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    public PolynomialGF2mSmallM[] getSquareRootMatrix() {
        return this.sqRootMatrix;
    }
}
