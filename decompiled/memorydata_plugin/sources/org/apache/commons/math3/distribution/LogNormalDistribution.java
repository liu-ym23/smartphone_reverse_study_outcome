package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LogNormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final double SQRT2 = 0.0d;
    private static final double SQRT2PI = 0.0d;
    private static final long serialVersionUID = 20120112;
    private final double logShapePlusHalfLog2Pi;
    private final double scale;
    private final double shape;
    private final double solverAbsoluteAccuracy;

    static {
        SQRT2PI = FastMath.sqrt(6.283185307179586d);
        SQRT2 = FastMath.sqrt(2.0d);
    }

    public LogNormalDistribution() {
        this(0.0d, 1.0d);
    }

    public LogNormalDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public LogNormalDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public LogNormalDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public LogNormalDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0.0d) goto L7;
        this.scale = r4;
        this.shape = r6;
        this.logShapePlusHalfLog2Pi = FastMath.log(r6) + (FastMath.log(6.283185307179586d) * 0.5d);
        this.solverAbsoluteAccuracy = r8;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(r6));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r9) {
        if (r9 > 0.0d) goto L5;
        return 0.0d;
    L5:
        double r10 = FastMath.log(r9) - this.scale;
        double r2 = FastMath.abs(r10);
        double r6 = this.shape;
        if (r2 <= (40.0d * r6)) goto L13;
        if (r10 < 0.0d) goto L14;
        return 1.0d;
    L14:
        return 0.0d;
    L13:
        return (Erf.erf(r10 / (r6 * SQRT2)) * 0.5d) + 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double r1, double r3) {
        return probability(r1, r3);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r7) {
        if (r7 > 0.0d) goto L5;
        return 0.0d;
    L5:
        double r0 = (FastMath.log(r7) - this.scale) / this.shape;
        return FastMath.exp(((-0.5d) * r0) * r0) / ((this.shape * SQRT2PI) * r7);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double r0 = this.shape;
        return FastMath.exp(this.scale + ((r0 * r0) / 2.0d));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.shape;
        double r1 = r0 * r0;
        return FastMath.expm1(r1) * FastMath.exp((this.scale * 2.0d) + r1);
    }

    public double getScale() {
        return this.scale;
    }

    public double getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r5) {
        if (r5 > 0.0d) goto L6;
        return Double.NEGATIVE_INFINITY;
    L6:
        double r6 = FastMath.log(r5);
        double r0 = (r6 - this.scale) / this.shape;
        return (((-0.5d) * r0) * r0) - (this.logShapePlusHalfLog2Pi + r6);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double probability(double r5, double r7) {
        if (r5 > r7) goto L14;
        if (r5 <= 0.0d) goto L12;
        if (r7 <= 0.0d) goto L12;
        double r0 = this.shape * SQRT2;
        return Erf.erf((FastMath.log(r5) - this.scale) / r0, (FastMath.log(r7) - this.scale) / r0) * 0.5d;
    L12:
        return super.probability(r5, r7);
    L14:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(r5), Double.valueOf(r7), true);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        double r0 = this.random.nextGaussian();
        return FastMath.exp(this.scale + (this.shape * r0));
    }
}
