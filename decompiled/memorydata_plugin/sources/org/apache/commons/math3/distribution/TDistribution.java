package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class TDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -5852615386664158222L;
    private final double degreesOfFreedom;
    private final double factor;
    private final double solverAbsoluteAccuracy;

    public TDistribution(double r3) {
        this(r3, 1.0E-9d);
    }

    public TDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public TDistribution(RandomGenerator r7, double r8) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r7, RandomGenerator.class, "com.obric.memorydata.plugin"), r8, 1.0E-9d);
    }

    public TDistribution(RandomGenerator r9, double r10, double r12) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r10 <= 0.0d) goto L7;
        this.degreesOfFreedom = r10;
        this.solverAbsoluteAccuracy = r12;
        this.factor = (Gamma.logGamma((1.0d + r10) / 2.0d) - ((FastMath.log(3.141592653589793d) + FastMath.log(r10)) * 0.5d)) - Gamma.logGamma(r10 / 2.0d);
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(r10));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r16) {
        if (r16 == 0.0d) goto L11;
        double r5 = this.degreesOfFreedom;
        double r6 = Beta.regularizedBeta(r5 / ((r16 * r16) + r5), r5 * 0.5d, 0.5d);
        if (r16 >= 0.0d) goto L9;
        return 0.5d * r6;
    L9:
        return 1.0d - (r6 * 0.5d);
    L11:
        return 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return FastMath.exp(logDensity(r1));
    }

    public double getDegreesOfFreedom() {
        return this.degreesOfFreedom;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        if (getDegreesOfFreedom() <= 1.0d) goto L6;
        return 0.0d;
    L6:
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = getDegreesOfFreedom();
        if (r0 <= 2.0d) goto L7;
        return r0 / (r0 - 2.0d);
    L7:
        if (r0 > 1.0d) goto L9;
        return Double.NaN;
    L9:
        if (r0 > 2.0d) goto L14;
        return Double.POSITIVE_INFINITY;
    L14:
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
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
        return false;
    }

    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r9) {
        double r0 = this.degreesOfFreedom;
        return this.factor - (((r0 + 1.0d) / 2.0d) * FastMath.log(((r9 * r9) / r0) + 1.0d));
    }
}
