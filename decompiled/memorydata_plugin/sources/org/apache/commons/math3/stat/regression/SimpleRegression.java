package org.apache.commons.math3.stat.regression;

import java.io.Serializable;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleRegression implements Serializable {
    private static final long serialVersionUID = -3004689053607543335L;
    private final boolean hasIntercept;
    private long n;
    private double sumX;
    private double sumXX;
    private double sumXY;
    private double sumY;
    private double sumYY;
    private double xbar;
    private double ybar;

    public SimpleRegression() {
        this(true);
    }

    public SimpleRegression(boolean r5) {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.n = 0;
        this.xbar = 0.0d;
        this.ybar = 0.0d;
        this.hasIntercept = r5;
    }

    private double getIntercept(double r5) {
        if (this.hasIntercept == true) goto L5;
        return 0.0d;
    L5:
        return (this.sumY - (r5 * this.sumX)) / this.n;
    }

    private double getRegressionSumSquares(double r3) {
        return (r3 * r3) * this.sumXX;
    }

    public void addData(double r22, double r24) {
        long r5 = this.n;
        if (r5 != 0) goto L6;
        this.xbar = r22;
        this.ybar = r24;
    L10:
        if (this.hasIntercept == true) goto L12;
        this.sumXX += r22 * r22;
        this.sumYY += r24 * r24;
        this.sumXY += r22 * r24;
    L12:
        this.sumX += r22;
        this.sumY += r24;
        this.n = r5 + 1;
        return;
    L6:
        if (this.hasIntercept == false) goto L10;
        double r7 = r5 + 1.0d;
        double r11 = r5 / (r5 + 1.0d);
        double r9 = this.xbar;
        double r13 = r22 - r9;
        double r6 = this.ybar;
        double r17 = r24 - r6;
        this.sumXX += (r13 * r13) * r11;
        this.sumYY += (r17 * r17) * r11;
        this.sumXY += (r13 * r17) * r11;
        this.xbar = r9 + (r13 / r7);
        this.ybar = r6 + (r17 / r7);
        goto L10
    }

    public void addData(double[][] r7) {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L10;
        if (r7[r1].length < 2) goto L9;
        addData(r7[r1][0], r7[r1][1]);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, new Object[]{Integer.valueOf(r7[r1].length), 2});
    }

    public void addObservation(double[] r3, double r4) {
        if (r3 != null) goto L5;
    L9:
        LocalizedFormats r5 = LocalizedFormats.INVALID_REGRESSION_OBSERVATION;
        Object[] r6 = new Object[2];
        if (r3 == null) goto L12;
        int r7 = r3.length;
    L13:
        r6[0] = Integer.valueOf(r7);
        r6[1] = 1;
        throw new ModelSpecificationException(r5, r6);
    L12:
        r7 = 0;
        goto L13
    L5:
        if (r3.length == 0) goto L9;
        addData(r3[0], r4);
    }

    public void addObservations(double[][] r8, double[] r9) {
        int r2 = 0;
        if (r8 == null) goto L25;
        if (r9 == null) goto L25;
        if (r8.length != r9.length) goto L25;
        boolean r4 = true;
        int r3 = 0;
    L10:
        if (r3 >= r8.length) goto L17;
        if (r8[r3] != null) goto L14;
    L15:
        r4 = false;
    L16:
        r3 = r3 + 1;
        goto L10
    L14:
        if (r8[r3].length != 0) goto L16;
    L17:
        if (r4 == false) goto L24;
        int r0 = 0;
    L20:
        if (r0 >= r8.length) goto L22;
        addData(r8[r0][0], r9[r0]);
        r0 = r0 + 1;
        goto L20
    L22:
        return;
    L24:
        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{0, 1});
    L25:
        LocalizedFormats r5 = LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE;
        Object[] r1 = new Object[2];
        if (r8 != null) goto L28;
        int r10 = 0;
    L29:
        r1[0] = Integer.valueOf(r10);
        if (r9 == null) goto L33;
        r2 = r9.length;
    L33:
        r1[1] = Integer.valueOf(r2);
        throw new ModelSpecificationException(r5, r1);
    L28:
        r10 = r8.length;
        goto L29
    }

    public void append(SimpleRegression r23) {
        long r2 = this.n;
        if (r2 != 0) goto L6;
        this.xbar = r23.xbar;
        this.ybar = r23.ybar;
        this.sumXX = r23.sumXX;
        this.sumYY = r23.sumYY;
        this.sumXY = r23.sumXY;
    L9:
        this.sumX += r23.sumX;
        this.sumY += r23.sumY;
        this.n = r2 + r23.n;
        return;
    L6:
        if (this.hasIntercept == false) goto L8;
        long r4 = r23.n;
        double r6 = r4 / (r4 + r2);
        double r8 = (r2 * r4) / (r4 + r2);
        double r5 = r23.xbar;
        double r10 = this.xbar;
        double r7 = r5 - r10;
        double r12 = r23.ybar;
        double r14 = this.ybar;
        double r13 = r12 - r14;
        this.sumXX += r23.sumXX + ((r7 * r7) * r8);
        this.sumYY += r23.sumYY + ((r13 * r13) * r8);
        this.sumXY += r23.sumXY + ((r7 * r13) * r8);
        this.xbar = r10 + (r7 * r6);
        this.ybar = r14 + (r13 * r6);
        goto L9
    L8:
        this.sumXX += r23.sumXX;
        this.sumYY += r23.sumYY;
        this.sumXY += r23.sumXY;
        goto L9
    }

    public void clear() {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.n = 0;
    }

    public double getIntercept() {
        if (this.hasIntercept == true) goto L7;
        return 0.0d;
    L7:
        return getIntercept(getSlope());
    }

    public double getInterceptStdErr() {
        if (this.hasIntercept == true) goto L6;
        return Double.NaN;
    L6:
        double r0 = getMeanSquareError();
        double r2 = 1.0d / this.n;
        double r4 = this.xbar;
        return FastMath.sqrt(r0 * (r2 + ((r4 * r4) / this.sumXX)));
    }

    public double getMeanSquareError() {
        if (this.n >= 3) goto L7;
        return Double.NaN;
    L7:
        if (this.hasIntercept == false) goto L9;
        double r0 = getSumSquaredErrors();
        long r2 = this.n;
        long r4 = 2;
    L11:
        return r0 / (r2 - r4);
    L9:
        r0 = getSumSquaredErrors();
        r2 = this.n;
        r4 = 1;
        goto L11
    }

    public long getN() {
        return this.n;
    }

    public double getR() {
        double r0 = getSlope();
        double r2 = FastMath.sqrt(getRSquare());
        if (r0 < 0.0d) goto L5;
        return r2;
    L5:
        return -r2;
    }

    public double getRSquare() {
        double r0 = getTotalSumSquares();
        return (r0 - getSumSquaredErrors()) / r0;
    }

    public double getRegressionSumSquares() {
        return getRegressionSumSquares(getSlope());
    }

    public double getSignificance() {
        if (this.n >= 3) goto L7;
        return Double.NaN;
    L7:
        return (1.0d - new TDistribution(this.n - 2).cumulativeProbability(FastMath.abs(getSlope()) / getSlopeStdErr())) * 2.0d;
    }

    public double getSlope() {
        if (this.n >= 2) goto L6;
        return Double.NaN;
    L6:
        if (FastMath.abs(this.sumXX) >= 4.9E-323d) goto L9;
        return Double.NaN;
    L9:
        return this.sumXY / this.sumXX;
    }

    public double getSlopeConfidenceInterval() {
        return getSlopeConfidenceInterval(0.05d);
    }

    public double getSlopeConfidenceInterval(double r8) {
        if (this.n >= 3) goto L7;
        return Double.NaN;
    L7:
        if (r8 >= 1.0d) goto L13;
        if (r8 <= 0.0d) goto L13;
        return getSlopeStdErr() * new TDistribution(this.n - 2).inverseCumulativeProbability(1.0d - (r8 / 2.0d));
    L13:
        throw new OutOfRangeException(LocalizedFormats.SIGNIFICANCE_LEVEL, Double.valueOf(r8), 0, 1);
    }

    public double getSlopeStdErr() {
        return FastMath.sqrt(getMeanSquareError() / this.sumXX);
    }

    public double getSumOfCrossProducts() {
        return this.sumXY;
    }

    public double getSumSquaredErrors() {
        double r0 = this.sumYY;
        double r2 = this.sumXY;
        return FastMath.max(0.0d, r0 - ((r2 * r2) / this.sumXX));
    }

    public double getTotalSumSquares() {
        if (this.n >= 2) goto L7;
        return Double.NaN;
    L7:
        return this.sumYY;
    }

    public double getXSumSquares() {
        if (this.n >= 2) goto L7;
        return Double.NaN;
    L7:
        return this.sumXX;
    }

    public boolean hasIntercept() {
        return this.hasIntercept;
    }

    public double predict(double r5) {
        double r0 = getSlope();
        if (this.hasIntercept == false) goto L7;
        return getIntercept(r0) + (r0 * r5);
    L7:
        return r0 * r5;
    }

    public RegressionResults regress() {
        if (this.hasIntercept == false) goto L15;
        if (this.n < 3) goto L13;
        if (FastMath.abs(this.sumXX) <= Precision.SAFE_MIN) goto L10;
        double[] r11 = {getIntercept(), getSlope()};
        double r1 = getMeanSquareError();
        double r12 = this.sumYY;
        double r14 = this.sumY;
        long r9 = this.n;
        double r19 = r12 + ((r14 * r14) / r9);
        double r4 = this.xbar;
        double r15 = this.sumXX;
        return new RegressionResults(r11, new double[][]{new double[]{(((r4 * r4) / r15) + (1.0d / r9)) * r1, ((-r4) * r1) / r15, r1 / r15}}, true, this.n, 2, this.sumY, r19, getSumSquaredErrors(), true, false);
    L10:
        double r10 = this.sumY;
        long r13 = this.n;
        return new RegressionResults(new double[]{r10 / r13, Double.NaN}, new double[][]{new double[]{this.ybar / (r13 - 1.0d), Double.NaN, Double.NaN}}, true, this.n, 1, this.sumY, this.sumYY, getSumSquaredErrors(), true, false);
    L13:
        throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
    L15:
        if (this.n < 2) goto L23;
        if (Double.isNaN(this.sumXX) == true) goto L21;
        double r3 = getMeanSquareError();
        double r5 = this.sumXX;
        return new RegressionResults(new double[]{this.sumXY / r5}, new double[][]{new double[]{r3 / r5}}, true, this.n, 1, this.sumY, this.sumYY, getSumSquaredErrors(), false, false);
    L21:
        return new RegressionResults(new double[]{Double.NaN}, new double[][]{new double[]{Double.NaN}}, true, this.n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
    L23:
        throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
    }

    public RegressionResults regress(int[] r40) {
        if (r40 == null) goto L66;
        if (r40.length == 0) goto L66;
        int r5 = 2;
        if (r40.length <= 2) goto L9;
    L58:
        LocalizedFormats r4 = LocalizedFormats.ARRAY_SIZE_EXCEEDS_MAX_VARIABLES;
        Object[] r7 = new Object[1];
        if (r40.length > 1) goto L61;
    L63:
        r7[0] = Integer.valueOf(r5);
        throw new ModelSpecificationException(r4, r7);
    L61:
        if (this.hasIntercept == true) goto L63;
        r5 = 1;
        goto L63
    L9:
        if (r40.length <= 1) goto L14;
        if (this.hasIntercept == false) goto L58;
    L14:
        if (this.hasIntercept == false) goto L53;
        if (r40.length != 2) goto L32;
        if (r40[0] == 1) goto L30;
        if (r40[0] != 0) goto L28;
        if (r40[1] != 1) goto L26;
        return regress();
    L26:
        throw new OutOfRangeException(Integer.valueOf(r40[0]), 0, 1);
    L28:
        throw new OutOfRangeException(Integer.valueOf(r40[0]), 0, 1);
    L30:
        throw new ModelSpecificationException(LocalizedFormats.NOT_INCREASING_SEQUENCE, new Object[0]);
    L32:
        if (r40[0] != 1) goto L34;
    L38:
        double r3 = this.sumY;
        long r9 = this.n;
        double r8 = (r3 * r3) / r9;
        double r11 = this.sumYY;
        double r22 = r11 + r8;
        if (r40[0] != 0) goto L43;
        return new RegressionResults(new double[]{this.ybar}, new double[][]{new double[]{r11 / ((r9 - 1) * r9)}}, true, this.n, 1, this.sumY, r22 + r8, this.sumYY, true, false);
    L43:
        if (r40[0] != 1) goto L50;
        double r10 = this.sumXX;
        double r12 = this.sumX;
        double r13 = r10 + ((r12 * r12) / r9);
        double r14 = this.sumXY + ((r12 * r3) / r9);
        double r24 = FastMath.max(0.0d, r22 - ((r14 * r14) / r13));
        double r6 = r24 / (this.n - 1);
        if (Double.isNaN(r13) == true) goto L49;
        return new RegressionResults(new double[]{r14 / r13}, new double[][]{new double[]{r6 / r13}}, true, this.n, 1, this.sumY, r22, r24, false, false);
    L49:
        return new RegressionResults(new double[]{Double.NaN}, new double[][]{new double[]{Double.NaN}}, true, this.n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
    L50:
        return null;
    L34:
        if (r40[0] == 0) goto L38;
        throw new OutOfRangeException(Integer.valueOf(r40[0]), 0, 1);
    L53:
        if (r40[0] != 0) goto L57;
        return regress();
    L57:
        throw new OutOfRangeException(Integer.valueOf(r40[0]), 0, 0);
    L66:
        throw new MathIllegalArgumentException(LocalizedFormats.ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED, new Object[0]);
    }

    public void removeData(double r21, double r23) {
        long r1 = this.n;
        if (r1 <= 0) goto L10;
        double r6 = r1 - 1.0d;
        if (this.hasIntercept == false) goto L7;
        double r8 = r1 / (r1 - 1.0d);
        double r3 = this.xbar;
        double r10 = r21 - r3;
        double r12 = this.ybar;
        double r14 = r23 - r12;
        this.sumXX -= (r10 * r10) * r8;
        this.sumYY -= (r14 * r14) * r8;
        this.sumXY -= (r10 * r14) * r8;
        this.xbar = r3 - (r10 / r6);
        this.ybar = r12 - (r14 / r6);
        r1 = r1;
    L8:
        this.sumX -= r21;
        this.sumY -= r23;
        this.n = r1 - 1;
        return;
    L7:
        this.sumXX -= r21 * r21;
        this.sumYY -= r23 * r23;
        this.sumXY -= r21 * r23;
        this.xbar -= r21 / r6;
        this.ybar -= r23 / r6;
        goto L8
    }

    public void removeData(double[][] r7) {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L8;
        if (this.n <= 0) goto L11;
        removeData(r7[r1][0], r7[r1][1]);
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }
}
