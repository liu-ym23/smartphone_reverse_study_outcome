package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class CholeskyDecomposition {
    private RealMatrix cachedL;
    private RealMatrix cachedLT;
    private double[][] lTData;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.CholeskyDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] lTData;

        private Solver(double[][] r1) {
            this.lTData = r1;
        }

        /* synthetic */ Solver(double[][] r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.lTData.length));
        }

        public RealMatrix solve(RealMatrix r18) {
            RealMatrix r1 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r18, RealMatrix.class, "com.obric.memorydata.plugin");
            int r2 = this.lTData.length;
            if (r1.getRowDimension() != r2) goto L30;
            int r3 = r1.getColumnDimension();
            double[][] r4 = r1.getData();
            int r5 = 0;
        L5:
            if (r5 >= r2) goto L15;
            double[] r6 = this.lTData[r5];
            double r7 = r6[r5];
            double[] r9 = r4[r5];
            int r10 = 0;
        L7:
            if (r10 >= r3) goto L9;
            r9[r10] = r9[r10] / r7;
            r10 = r10 + 1;
            goto L7
        L9:
            r5 = r5 + 1;
            int r8 = r5;
        L10:
            if (r8 >= r2) goto L5;
            double[] r11 = r4[r8];
            double r12 = r6[r8];
            int r13 = 0;
        L12:
            if (r13 >= r3) goto L14;
            r11[r13] = r11[r13] - (r9[r13] * r12);
            r13 = r13 + 1;
            goto L12
        L14:
            r8 = r8 + 1;
            goto L10
        L15:
            int r14 = r2 - 1;
        L16:
            if (r14 < 0) goto L28;
            double r15 = this.lTData[r14][r14];
            double[] r16 = r4[r14];
            int r17 = 0;
        L18:
            if (r17 >= r3) goto L20;
            r16[r17] = r16[r17] / r15;
            r17 = r17 + 1;
            goto L18
        L20:
            int r19 = 0;
        L21:
            if (r19 >= r14) goto L26;
            double[] r20 = r4[r19];
            double r21 = this.lTData[r19][r14];
            int r110 = 0;
        L23:
            if (r110 >= r3) goto L25;
            r20[r110] = r20[r110] - (r16[r110] * r21);
            r110 = r110 + 1;
            goto L23
        L25:
            r19 = r19 + 1;
            goto L21
        L26:
            r14 = r14 - 1;
            goto L16
        L28:
            return new Array2DRowRealMatrix(r4);
        L30:
            throw new DimensionMismatchException(r1.getRowDimension(), r2);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r12) {
            int r0 = this.lTData.length;
            if (r12.getDimension() != r0) goto L18;
            double[] r13 = r12.toArray();
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L9;
            double[] r3 = this.lTData[r2];
            r13[r2] = r13[r2] / r3[r2];
            double r4 = r13[r2];
            r2 = r2 + 1;
            int r6 = r2;
        L7:
            if (r6 >= r0) goto L5;
            r13[r6] = r13[r6] - (r3[r6] * r4);
            r6 = r6 + 1;
            goto L7
        L9:
            int r1 = r0 - 1;
        L10:
            if (r1 < 0) goto L16;
            r13[r1] = r13[r1] / this.lTData[r1][r1];
            double r5 = r13[r1];
            int r7 = 0;
        L12:
            if (r7 >= r1) goto L14;
            r13[r7] = r13[r7] - (this.lTData[r7][r1] * r5);
            r7 = r7 + 1;
            goto L12
        L14:
            r1 = r1 - 1;
            goto L10
        L16:
            return new ArrayRealVector(r13, false);
        L18:
            throw new DimensionMismatchException(r12.getDimension(), r0);
        }
    }

    public CholeskyDecomposition(RealMatrix r17, double r18, double r20) {
        RealMatrix r3 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r17, RealMatrix.class, "com.obric.memorydata.plugin");
        if (r3.isSquare() == false) goto L29;
        int r4 = r3.getRowDimension();
        this.lTData = r3.getData();
        this.cachedL = null;
        this.cachedLT = null;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        double[] r6 = this.lTData[r5];
        int r7 = r5 + 1;
        int r8 = r7;
    L7:
        if (r8 >= r4) goto L13;
        double[] r9 = this.lTData[r8];
        double r10 = r6[r8];
        double r12 = r9[r5];
        int r19 = r4;
        if (FastMath.abs(r10 - r12) > (FastMath.max(FastMath.abs(r10), FastMath.abs(r12)) * r18)) goto L12;
        r9[r5] = 0.0d;
        r8 = r8 + 1;
        r4 = r19;
        goto L7
    L12:
        throw new NonSymmetricMatrixException(r5, r8, r18);
    L13:
        r5 = r7;
        goto L5
    L14:
        int r1 = r4;
        int r13 = 0;
    L15:
        if (r13 >= r1) goto L27;
        double[] r2 = this.lTData[r13];
        if (r2[r13] <= r20) goto L26;
        r2[r13] = FastMath.sqrt(r2[r13]);
        double r11 = 1.0d / r2[r13];
        int r14 = r1 - 1;
    L19:
        if (r14 <= r13) goto L24;
        r2[r14] = r2[r14] * r11;
        double[] r15 = this.lTData[r14];
        int r16 = r14;
    L21:
        if (r16 >= r1) goto L23;
        r15[r16] = r15[r16] - (r2[r14] * r2[r16]);
        r16 = r16 + 1;
        goto L21
    L23:
        r14 = r14 - 1;
        goto L19
    L24:
        r13 = r13 + 1;
        goto L15
    L26:
        throw new NonPositiveDefiniteMatrixException(r2[r13], r13, r20);
    L27:
        return;
    L29:
        throw new NonSquareMatrixException(r3.getRowDimension(), r3.getColumnDimension());
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.lTData, null);
    }
}
