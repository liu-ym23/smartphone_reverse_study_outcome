package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LaplaceDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20141003;
    private final double beta;
    private final double mu;

    public LaplaceDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public LaplaceDistribution(RandomGenerator r3, double r4, double r6) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0.0d) goto L7;
        this.mu = r4;
        this.beta = r6;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_SCALE, Double.valueOf(r6));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r8) {
        double r0 = this.mu;
        if (r8 > r0) goto L7;
        return FastMath.exp((r8 - r0) / this.beta) / 2.0d;
    L7:
        return 1.0d - (FastMath.exp((r0 - r8) / this.beta) / 2.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r5) {
        return FastMath.exp((-FastMath.abs(r5 - this.mu)) / this.beta) / (this.beta * 2.0d);
    }

    public double getLocation() {
        return this.mu;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.mu;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.beta;
        return (2.0d * r0) * r0;
    }

    public double getScale() {
        return this.beta;
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
    public double inverseCumulativeProbability(double r6) {
        if (r6 < 0.0d) goto L20;
        if (r6 > 1.0d) goto L20;
        if (r6 != 0.0d) goto L10;
        return Double.NEGATIVE_INFINITY;
    L10:
        if (r6 != 1.0d) goto L13;
        return Double.POSITIVE_INFINITY;
    L13:
        double r7 = r6 * 2.0d;
        if (r6 <= 0.5d) goto L16;
        double r8 = -Math.log(2.0d - r7);
    L18:
        return this.mu + (this.beta * r8);
    L16:
        r8 = Math.log(r7);
    L20:
        throw new OutOfRangeException(Double.valueOf(r6), Double.valueOf(0.0d), Double.valueOf(1.0d));
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
