package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LogisticDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20141003;
    private final double mu;
    private final double s;

    public LogisticDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public LogisticDistribution(RandomGenerator r3, double r4, double r6) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0.0d) goto L7;
        this.mu = r4;
        this.s = r6;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_SCALE, Double.valueOf(r6));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r7) {
        return 1.0d / (FastMath.exp(-((1.0d / this.s) * (r7 - this.mu))) + 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r5) {
        double r6 = FastMath.exp(-((r5 - this.mu) / this.s));
        double r0 = (1.0d / this.s) * r6;
        double r7 = r6 + 1.0d;
        return r0 / (r7 * r7);
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
        double r0 = this.s;
        return (1.0d / (r0 * r0)) * 3.289868133696453d;
    }

    public double getScale() {
        return this.s;
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
    public double inverseCumulativeProbability(double r7) {
        if (r7 < 0.0d) goto L15;
        if (r7 > 1.0d) goto L15;
        if (r7 != 0.0d) goto L9;
        return 0.0d;
    L9:
        if (r7 != 1.0d) goto L13;
        return Double.POSITIVE_INFINITY;
    L13:
        return (this.s * Math.log(r7 / (1.0d - r7))) + this.mu;
    L15:
        throw new OutOfRangeException(Double.valueOf(r7), Double.valueOf(0.0d), Double.valueOf(1.0d));
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
