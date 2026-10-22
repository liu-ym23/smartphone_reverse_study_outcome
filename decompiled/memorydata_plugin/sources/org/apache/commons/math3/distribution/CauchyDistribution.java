package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class CauchyDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 8589540077390120676L;
    private final double median;
    private final double scale;
    private final double solverAbsoluteAccuracy;

    public CauchyDistribution() {
        this(0.0d, 1.0d);
    }

    public CauchyDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public CauchyDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public CauchyDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public CauchyDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0.0d) goto L7;
        this.scale = r6;
        this.median = r4;
        this.solverAbsoluteAccuracy = r8;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(r6));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r3) {
        return (FastMath.atan((r3 - this.median) / this.scale) / 3.141592653589793d) + 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r5) {
        double r6 = r5 - this.median;
        double r0 = this.scale;
        return (r0 / ((r6 * r6) + (r0 * r0))) * 0.3183098861837907d;
    }

    public double getMedian() {
        return this.median;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return Double.NaN;
    }

    public double getScale() {
        return this.scale;
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

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r9) {
        if (r9 < 0.0d) goto L14;
        if (r9 > 1.0d) goto L14;
        if (r9 != 0.0d) goto L9;
        return Double.NEGATIVE_INFINITY;
    L9:
        if (r9 != 1.0d) goto L12;
        return Double.POSITIVE_INFINITY;
    L12:
        return this.median + (this.scale * FastMath.tan((r9 - 0.5d) * 3.141592653589793d));
    L14:
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
}
