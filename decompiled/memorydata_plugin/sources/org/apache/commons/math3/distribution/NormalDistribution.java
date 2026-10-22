package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class NormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final double SQRT2 = 0.0d;
    private static final long serialVersionUID = 8589540077390120676L;
    private final double logStandardDeviationPlusHalfLog2Pi;
    private final double mean;
    private final double solverAbsoluteAccuracy;
    private final double standardDeviation;

    static {
        SQRT2 = FastMath.sqrt(2.0d);
    }

    public NormalDistribution() {
        this(0.0d, 1.0d);
    }

    public NormalDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public NormalDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public NormalDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public NormalDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0.0d) goto L7;
        this.mean = r4;
        this.standardDeviation = r6;
        this.logStandardDeviationPlusHalfLog2Pi = FastMath.log(r6) + (FastMath.log(6.283185307179586d) * 0.5d);
        this.solverAbsoluteAccuracy = r8;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, Double.valueOf(r6));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r7) {
        double r8 = r7 - this.mean;
        double r0 = FastMath.abs(r8);
        double r2 = this.standardDeviation;
        if (r0 <= (40.0d * r2)) goto L10;
        if (r8 < 0.0d) goto L11;
        return 1.0d;
    L11:
        return 0.0d;
    L10:
        return Erf.erfc((-r8) / (r2 * SQRT2)) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double r1, double r3) {
        return probability(r1, r3);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return FastMath.exp(logDensity(r1));
    }

    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = getStandardDeviation();
        return r0 * r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    public double getStandardDeviation() {
        return this.standardDeviation;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r9) {
        if (r9 < 0.0d) goto L9;
        if (r9 > 1.0d) goto L9;
        return this.mean + ((this.standardDeviation * SQRT2) * Erf.erfInv((r9 * 2.0d) - 1.0d));
    L9:
        throw new OutOfRangeException(Double.valueOf(r9), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public boolean isSupportLowerBoundInclusive() {
        return false;
    }

    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r3) {
        double r4 = (r3 - this.mean) / this.standardDeviation;
        return (((-0.5d) * r4) * r4) - this.logStandardDeviationPlusHalfLog2Pi;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double probability(double r5, double r7) {
        if (r5 > r7) goto L7;
        double r0 = this.standardDeviation * SQRT2;
        double r2 = this.mean;
        return Erf.erf((r5 - r2) / r0, (r7 - r2) / r0) * 0.5d;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(r5), Double.valueOf(r7), true);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        return (this.standardDeviation * this.random.nextGaussian()) + this.mean;
    }
}
