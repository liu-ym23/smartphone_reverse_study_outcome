package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class QRDecomposition {
    private RealMatrix cachedH;
    private RealMatrix cachedQ;
    private RealMatrix cachedQT;
    private RealMatrix cachedR;
    private double[][] qrt;
    private double[] rDiag;
    private final double threshold;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.QRDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] qrt;
        private final double[] rDiag;
        private final double threshold;

        private Solver(double[][] r1, double[] r2, double r3) {
            this.qrt = r1;
            this.rDiag = r2;
            this.threshold = r3;
        }

        /* synthetic */ Solver(double[][] r1, double[] r2, double r3, AnonymousClass1 r5) {
            this(r1, r2, r3);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.qrt[0].length));
        }

        public boolean isNonSingular() {
            double[] r0 = this.rDiag;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L8;
            if (FastMath.abs(r0[r3]) <= this.threshold) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }

        public RealMatrix solve(RealMatrix r27) {
            RealMatrix r1 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r27, RealMatrix.class, "com.obric.memorydata.plugin");
            double[][] r2 = this.qrt;
            int r8 = r2.length;
            int r10 = r2[0].length;
            if (r1.getRowDimension() != r10) goto L45;
            if (isNonSingular() == false) goto L43;
            int r11 = r1.getColumnDimension();
            int r13 = ((r11 + 52) - 1) / 52;
            double[][] r14 = BlockRealMatrix.createBlocksLayout(r8, r11);
            double[][] r15 = (double[][]) Array.newInstance(double.class, new int[]{r1.getRowDimension(), 52});
            double[] r7 = new double[52];
            int r6 = 0;
        L7:
            if (r6 >= r13) goto L41;
            int r5 = r6 * 52;
            int r3 = FastMath.min(r5 + 52, r11);
            int r4 = r3 - r5;
            int r16 = r6;
            double[] r9 = r7;
            r1.copySubMatrix(0, r10 - 1, r5, r3 - 1, r15);
            int r12 = 0;
        L10:
            if (r12 >= FastMath.min(r10, r8)) goto L27;
            double[] r17 = this.qrt[r12];
            double r18 = 1.0d / (this.rDiag[r12] * r17[r12]);
            RealMatrix r19 = r1;
            Arrays.fill(r9, 0, r4, 0.0d);
            int r20 = r12;
        L12:
            if (r20 >= r10) goto L17;
            double r21 = r17[r20];
            double[] r110 = r15[r20];
            int r22 = r8;
            int r23 = 0;
        L14:
            if (r23 >= r4) goto L16;
            r9[r23] = r9[r23] + (r110[r23] * r21);
            r23 = r23 + 1;
            goto L14
        L16:
            r20 = r20 + 1;
            r8 = r22;
            goto L12
        L17:
            int r24 = r8;
            int r25 = 0;
        L18:
            if (r25 >= r4) goto L20;
            r9[r25] = r9[r25] * r18;
            r25 = r25 + 1;
            goto L18
        L20:
            int r26 = r12;
        L21:
            if (r26 >= r10) goto L26;
            double r28 = r17[r26];
            double[] r29 = r15[r26];
            int r30 = 0;
        L23:
            if (r30 >= r4) goto L25;
            r29[r30] = r29[r30] + (r9[r30] * r28);
            r30 = r30 + 1;
            goto L23
        L25:
            r26 = r26 + 1;
            goto L21
        L26:
            r12 = r12 + 1;
            r1 = r19;
            r8 = r24;
            goto L10
        L27:
            RealMatrix r111 = r1;
            int r210 = r8;
            int r31 = this.rDiag.length - 1;
        L28:
            if (r31 < 0) goto L39;
            int r32 = r31 / 52;
            int r33 = r32 * 52;
            double r34 = 1.0d / this.rDiag[r31];
            double[] r112 = r15[r31];
            double[] r35 = r14[(r32 * r13) + r16];
            int r211 = (r31 - r33) * r4;
            int r36 = 0;
        L30:
            if (r36 >= r4) goto L32;
            r112[r36] = r112[r36] * r34;
            r35[r211] = r112[r36];
            r36 = r36 + 1;
            r211 = r211 + 1;
            goto L30
        L32:
            double[] r37 = this.qrt[r31];
            int r38 = 0;
        L33:
            if (r38 >= r31) goto L38;
            double r39 = r37[r38];
            double[] r212 = r15[r38];
            int r40 = 0;
        L35:
            if (r40 >= r4) goto L37;
            r212[r40] = r212[r40] - (r112[r40] * r39);
            r40 = r40 + 1;
            goto L35
        L37:
            r38 = r38 + 1;
            goto L33
        L38:
            r31 = r31 - 1;
            goto L28
        L39:
            r6 = r16 + 1;
            r7 = r9;
            r1 = r111;
            r8 = r210;
            goto L7
        L41:
            return new BlockRealMatrix(r8, r11, r14, false);
        L43:
            throw new SingularMatrixException();
        L45:
            throw new DimensionMismatchException(r1.getRowDimension(), r10);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r14) {
            double[][] r0 = this.qrt;
            int r1 = r0.length;
            int r2 = r0[0].length;
            if (r14.getDimension() != r2) goto L27;
            if (isNonSingular() == false) goto L25;
            double[] r3 = new double[r1];
            double[] r15 = r14.toArray();
            int r4 = 0;
        L8:
            if (r4 >= FastMath.min(r2, r1)) goto L16;
            double[] r5 = this.qrt[r4];
            double r6 = 0.0d;
            int r8 = r4;
        L10:
            if (r8 >= r2) goto L12;
            r6 = r6 + (r15[r8] * r5[r8]);
            r8 = r8 + 1;
            goto L10
        L12:
            double r7 = r6 / (this.rDiag[r4] * r5[r4]);
            int r9 = r4;
        L13:
            if (r9 >= r2) goto L15;
            r15[r9] = r15[r9] + (r5[r9] * r7);
            r9 = r9 + 1;
            goto L13
        L15:
            r4 = r4 + 1;
            goto L8
        L16:
            int r10 = this.rDiag.length - 1;
        L17:
            if (r10 < 0) goto L23;
            r15[r10] = r15[r10] / this.rDiag[r10];
            double r11 = r15[r10];
            double[] r12 = this.qrt[r10];
            r3[r10] = r11;
            int r13 = 0;
        L19:
            if (r13 >= r10) goto L21;
            r15[r13] = r15[r13] - (r12[r13] * r11);
            r13 = r13 + 1;
            goto L19
        L21:
            r10 = r10 - 1;
            goto L17
        L23:
            return new ArrayRealVector(r3, false);
        L25:
            throw new SingularMatrixException();
        L27:
            throw new DimensionMismatchException(r14.getDimension(), r2);
        }
    }

    public QRDecomposition(RealMatrix r3) {
        this((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrix.class, "com.obric.memorydata.plugin"), 0.0d);
    }

    public QRDecomposition(RealMatrix r3, double r4) {
        RealMatrix r5 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrix.class, "com.obric.memorydata.plugin");
        this.threshold = r4;
        int r6 = r5.getRowDimension();
        int r7 = r5.getColumnDimension();
        this.qrt = r5.transpose().getData();
        this.rDiag = new double[FastMath.min(r6, r7)];
        this.cachedQ = null;
        this.cachedQT = null;
        this.cachedR = null;
        this.cachedH = null;
        decompose(this.qrt);
    }

    public void decompose(double[][] r5) {
        int r1 = 0;
    L4:
        if (r1 >= FastMath.min(r5.length, r5[0].length)) goto L6;
        performHouseholderReflection(r1, r5);
        r1 = r1 + 1;
        goto L4
    }

    public RealMatrix getQ() {
        if (this.cachedQ != null) goto L6;
        this.cachedQ = getQT().transpose();
    L6:
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQT != null) goto L24;
        double[][] r1 = this.qrt;
        int r2 = r1.length;
        int r3 = r1[0].length;
        double[][] r4 = (double[][]) Array.newInstance(double.class, new int[]{r3, r3});
        int r5 = r3 - 1;
    L5:
        double r7 = 1.0d;
        if (r5 < FastMath.min(r3, r2)) goto L8;
        r4[r5][r5] = 1.0d;
        r5 = r5 - 1;
        goto L5
    L8:
        int r6 = FastMath.min(r3, r2) - 1;
    L9:
        if (r6 < 0) goto L22;
        double[] r8 = this.qrt[r6];
        r4[r6][r6] = r7;
        if (r8[r6] == 0.0d) goto L21;
        int r9 = r6;
    L13:
        if (r9 >= r3) goto L21;
        int r10 = r6;
        double r11 = 0.0d;
    L15:
        if (r10 >= r3) goto L17;
        r11 = r11 - (r4[r9][r10] * r8[r10]);
        r10 = r10 + 1;
        goto L15
    L17:
        double r12 = r11 / (this.rDiag[r6] * r8[r6]);
        int r13 = r6;
    L18:
        if (r13 >= r3) goto L20;
        double[] r14 = r4[r9];
        r14[r13] = r14[r13] + ((-r12) * r8[r13]);
        r13 = r13 + 1;
        goto L18
    L20:
        r9 = r9 + 1;
    L21:
        r6 = r6 - 1;
        r7 = 1.0d;
        goto L9
    L22:
        this.cachedQT = MatrixUtils.createRealMatrix(r4);
    L24:
        return this.cachedQT;
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.qrt, this.rDiag, this.threshold, null);
    }

    public void performHouseholderReflection(int r14, double[][] r15) {
        double[] r0 = r15[r14];
        int r3 = r14;
        double r4 = 0.0d;
    L4:
        if (r3 >= r0.length) goto L7;
        double r6 = r0[r3];
        r4 = r4 + (r6 * r6);
        r3 = r3 + 1;
        goto L4
    L7:
        if (r0[r14] <= 0.0d) goto L9;
        double r5 = -FastMath.sqrt(r4);
    L10:
        this.rDiag[r14] = r5;
        if (r5 == 0.0d) goto L24;
        r0[r14] = r0[r14] - r5;
        int r13 = r14 + 1;
    L14:
        if (r13 >= r15.length) goto L29;
        double[] r7 = r15[r13];
        int r8 = r14;
        double r9 = 0.0d;
    L17:
        if (r8 >= r7.length) goto L19;
        r9 = r9 - (r7[r8] * r0[r8]);
        r8 = r8 + 1;
        goto L17
    L19:
        double r10 = r9 / (r0[r14] * r5);
        int r11 = r14;
    L21:
        if (r11 >= r7.length) goto L23;
        r7[r11] = r7[r11] - (r0[r11] * r10);
        r11 = r11 + 1;
        goto L21
    L23:
        r13 = r13 + 1;
        goto L14
    L29:
        return;
    L24:
        return;
    L9:
        r5 = FastMath.sqrt(r4);
        goto L10
    }
}
