package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: loaded from: classes6.dex */
public class UniformIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20120109;
    private final int lower;
    private final int upper;

    public UniformIntegerDistribution(int r2, int r3) {
        this(new Well19937c(), r2, r3);
    }

    public UniformIntegerDistribution(RandomGenerator r3, int r4, int r5) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r4 > r5) goto L7;
        this.lower = r4;
        this.upper = r5;
        return;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Integer.valueOf(r4), Integer.valueOf(r5), true);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r6) {
        int r0 = this.lower;
        if (r6 >= r0) goto L6;
        return 0.0d;
    L6:
        int r5 = this.upper;
        if (r6 <= r5) goto L10;
        return 1.0d;
    L10:
        return (((double) (r6 - r0)) + 1.0d) / (((double) (r5 - r0)) + 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return ((double) (this.lower + this.upper)) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double r0 = (this.upper - this.lower) + 1;
        return ((r0 * r0) - 1.0d) / 12.0d;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return this.lower;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return this.upper;
    }

    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r4) {
        int r0 = this.lower;
        if (r4 < r0) goto L9;
        int r3 = this.upper;
        if (r4 <= r3) goto L8;
        return 0.0d;
    L8:
        return 1.0d / ((double) ((r3 - r0) + 1));
    L9:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public int sample() {
        int r0 = this.upper;
        int r1 = this.lower;
        int r2 = (r0 - r1) + 1;
        if (r2 > 0) goto L10;
    L4:
        int r3 = this.random.nextInt();
        if (r3 < this.lower) goto L4;
        if (r3 > this.upper) goto L4;
        return r3;
    L10:
        return r1 + this.random.nextInt(r2);
    }
}
