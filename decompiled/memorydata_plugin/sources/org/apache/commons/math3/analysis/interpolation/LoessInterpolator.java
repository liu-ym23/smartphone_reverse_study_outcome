package org.apache.commons.math3.analysis.interpolation;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class LoessInterpolator implements Serializable, UnivariateInterpolator {
    public static final double DEFAULT_ACCURACY = 1.0E-12d;
    public static final double DEFAULT_BANDWIDTH = 0.3d;
    public static final int DEFAULT_ROBUSTNESS_ITERS = 2;
    private static final long serialVersionUID = 5204927143605193821L;
    private final double accuracy;
    private final double bandwidth;
    private final int robustnessIters;

    public LoessInterpolator() {
        this.bandwidth = 0.3d;
        this.robustnessIters = 2;
        this.accuracy = 1.0E-12d;
    }

    public LoessInterpolator(double r7, int r9) {
        this(r7, r9, 1.0E-12d);
    }

    public LoessInterpolator(double r3, int r5, double r6) {
        if (r3 < 0.0d) goto L13;
        if (r3 > 1.0d) goto L13;
        this.bandwidth = r3;
        if (r5 < 0) goto L11;
        this.robustnessIters = r5;
        this.accuracy = r6;
        return;
    L11:
        throw new NotPositiveException(LocalizedFormats.ROBUSTNESS_ITERATIONS, Integer.valueOf(r5));
    L13:
        throw new OutOfRangeException(LocalizedFormats.BANDWIDTH, Double.valueOf(r3), 0, 1);
    }

    private static void checkAllFiniteReal(double[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        MathUtils.checkFinite(r3[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private static int nextNonzero(double[] r4, int r5) {
    L2:
        r5 = r5 + 1;
        if (r5 >= r4.length) goto L7;
        if (r4[r5] == 0.0d) goto L2;
    L7:
        return r5;
    }

    private static double tricube(double r4) {
        double r5 = FastMath.abs(r4);
        if (r5 < 1.0d) goto L6;
        return 0.0d;
    L6:
        double r0 = 1.0d - ((r5 * r5) * r5);
        return (r0 * r0) * r0;
    }

    private static void updateBandwidthInterval(double[] r10, double[] r11, int r12, int[] r13) {
        int r1 = r13[0];
        int r3 = nextNonzero(r11, r13[1]);
        if (r3 < r10.length) goto L5;
        return;
    L5:
        if ((r10[r3] - r10[r12]) >= (r10[r12] - r10[r1])) goto L9;
        r13[0] = nextNonzero(r11, r13[0]);
        r13[1] = r3;
        return;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public final PolynomialSplineFunction interpolate(double[] r2, double[] r3) {
        return new SplineInterpolator().interpolate(r2, smooth(r2, r3));
    }

    public final double[] smooth(double[] r4, double[] r5) {
        if (r4.length != r5.length) goto L7;
        double[] r0 = new double[r4.length];
        Arrays.fill(r0, 1.0d);
        return smooth(r4, r5, r0);
    L7:
        throw new DimensionMismatchException(r4.length, r5.length);
    }

    public final double[] smooth(double[] r45, double[] r46, double[] r47) {
        if (r45.length != r46.length) goto L61;
        int r4 = r45.length;
        if (r4 == 0) goto L59;
        checkAllFiniteReal(r45);
        checkAllFiniteReal(r46);
        checkAllFiniteReal(r47);
        MathArrays.checkOrder(r45);
        int r5 = 0;
        char r6 = 1;
        if (r4 == 1) goto L9;
        int r7 = 2;
        if (r4 == 2) goto L13;
        int r8 = (int) (this.bandwidth * ((double) r4));
        if (r8 < 2) goto L57;
        double[] r9 = new double[r4];
        double[] r10 = new double[r4];
        double[] r11 = new double[r4];
        double[] r12 = new double[r4];
        Arrays.fill(r12, 1.0d);
        int r15 = 0;
    L18:
        if (r15 > this.robustnessIters) goto L55;
        int[] r13 = new int[r7];
        r13[r5] = r5;
        r13[r6] = r8 - 1;
        int r14 = r5;
    L20:
        double r18 = 0.0d;
        if (r14 >= r4) goto L41;
        double r20 = r45[r14];
        if (r14 <= 0) goto L25;
        updateBandwidthInterval(r45, r47, r14, r13);
    L25:
        int r22 = r13[r5];
        int r16 = r13[r6];
        if ((r45[r14] - r45[r22]) <= (r45[r16] - r45[r14])) goto L28;
        int r23 = r22;
    L29:
        double r24 = FastMath.abs(1.0d / (r45[r23] - r20));
        double r26 = 0.0d;
        double r28 = 0.0d;
        double r30 = 0.0d;
        double r32 = 0.0d;
        double r34 = 0.0d;
        int r17 = r22;
    L30:
        if (r17 > r16) goto L36;
        double r36 = r45[r17];
        double r38 = r46[r17];
        if (r17 >= r14) goto L34;
        double r40 = r20 - r36;
    L35:
        double r41 = (tricube(r40 * r24) * r12[r17]) * r47[r17];
        double r42 = r36 * r41;
        r28 = r28 + r41;
        r26 = r26 + r42;
        r34 = r34 + (r36 * r42);
        r30 = r30 + (r41 * r38);
        r32 = r32 + (r38 * r42);
        r17 = r17 + 1;
        goto L30
    L34:
        r40 = r36 - r20;
        goto L35
    L36:
        double r27 = r26 / r28;
        double r31 = r30 / r28;
        double r33 = r32 / r28;
        double r35 = (r34 / r28) - (r27 * r27);
        double[] r25 = r12;
        int[] r29 = r13;
        if (FastMath.sqrt(FastMath.abs(r35)) < this.accuracy) goto L40;
        r18 = (r33 - (r27 * r31)) / r35;
    L40:
        r9[r14] = (r18 * r20) + (r31 - (r27 * r18));
        r10[r14] = FastMath.abs(r46[r14] - r9[r14]);
        r14 = r14 + 1;
        r12 = r25;
        r13 = r29;
        r6 = 1;
        goto L20
    L28:
        r23 = r16;
        goto L29
    L41:
        double[] r210 = r12;
        if (r15 == this.robustnessIters) goto L55;
        System.arraycopy(r10, r5, r11, r5, r4);
        Arrays.sort(r11);
        double r19 = r11[r4 / 2];
        if (FastMath.abs(r19) < this.accuracy) goto L55;
        int r21 = 0;
    L48:
        if (r21 >= r4) goto L54;
        double r37 = r10[r21] / (6.0d * r19);
        if (r37 < 1.0d) goto L52;
        r210[r21] = 0.0d;
    L53:
        r21 = r21 + 1;
        goto L48
    L52:
        double r39 = 1.0d - (r37 * r37);
        r210[r21] = r39 * r39;
        goto L53
    L54:
        r15 = r15 + 1;
        r12 = r210;
        r5 = 0;
        r6 = 1;
        r7 = 2;
    L55:
        return r9;
    L57:
        throw new NumberIsTooSmallException(LocalizedFormats.BANDWIDTH, Integer.valueOf(r8), 2, true);
    L13:
        return new double[]{r46[0], r46[1]};
    L9:
        return new double[]{r46[0]};
    L59:
        throw new NoDataException();
    L61:
        throw new DimensionMismatchException(r45.length, r46.length);
    }
}
