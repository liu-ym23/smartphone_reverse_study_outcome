package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ParetoDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20130424;
    private final double scale;
    private final double shape;
    private final double solverAbsoluteAccuracy;

    public ParetoDistribution() {
        this(1.0d, 1.0d);
    }

    public ParetoDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public ParetoDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public ParetoDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public ParetoDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r4 <= 0.0d) goto L11;
        if (r6 <= 0.0d) goto L9;
        this.scale = r4;
        this.shape = r6;
        this.solverAbsoluteAccuracy = r8;
        return;
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(r6));
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(r4));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r5) {
        double r0 = this.scale;
        if (r5 > r0) goto L7;
        return 0.0d;
    L7:
        return 1.0d - FastMath.pow(r0 / r5, this.shape);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double r1, double r3) {
        return probability(r1, r3);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r7) {
        double r0 = this.scale;
        if (r7 >= r0) goto L7;
        return 0.0d;
    L7:
        return (FastMath.pow(r0, this.shape) / FastMath.pow(r7, this.shape + 1.0d)) * this.shape;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double r0 = this.shape;
        if (r0 > 1.0d) goto L7;
        return Double.POSITIVE_INFINITY;
    L7:
        return (this.scale * r0) / (r0 - 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.shape;
        if (r0 > 2.0d) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        double r4 = r0 - 1.0d;
        double r6 = this.scale;
        return (((r6 * r6) * r0) / (r4 * r4)) / (r0 - 2.0d);
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
        return this.scale;
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
    public double logDensity(double r7) {
        double r0 = this.scale;
        if (r7 >= r0) goto L6;
        return Double.NEGATIVE_INFINITY;
    L6:
        double r1 = FastMath.log(r0) * this.shape;
        double r8 = FastMath.log(r7);
        double r2 = this.shape;
        return (r1 - (r8 * (1.0d + r2))) + FastMath.log(r2);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        double r0 = this.random.nextDouble();
        return this.scale / FastMath.pow(r0, 1.0d / this.shape);
    }
}
