package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class PoissonDistribution extends AbstractIntegerDistribution {
    public static final double DEFAULT_EPSILON = 1.0E-12d;
    public static final int DEFAULT_MAX_ITERATIONS = 10000000;
    private static final long serialVersionUID = -3349935121172596109L;
    private final double epsilon;
    private final ExponentialDistribution exponential;
    private final int maxIterations;
    private final double mean;
    private final NormalDistribution normal;

    public PoissonDistribution(double r7) {
        this(r7, 1.0E-12d, DEFAULT_MAX_ITERATIONS);
    }

    public PoissonDistribution(double r7, double r9) {
        this(r7, r9, DEFAULT_MAX_ITERATIONS);
    }

    public PoissonDistribution(double r8, double r10, int r12) {
        this(new Well19937c(), r8, r10, r12);
    }

    public PoissonDistribution(double r7, int r9) {
        this(r7, 1.0E-12d, r9);
    }

    public PoissonDistribution(RandomGenerator r9, double r10, double r12, int r14) {
        RandomGenerator r11 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin");
        super(r11);
        if (r10 <= 0.0d) goto L7;
        this.mean = r10;
        this.epsilon = r12;
        this.maxIterations = r14;
        this.normal = new NormalDistribution(r11, r10, FastMath.sqrt(r10), 1.0E-9d);
        this.exponential = new ExponentialDistribution(r11, 1.0d, 1.0E-9d);
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, Double.valueOf(r10));
    }

    private long nextPoisson(double r43) {
        PoissonDistribution r0 = this;
        long r4 = 0;
        double r6 = 1.0d;
        if (r43 >= 40.0d) goto L11;
        double r8 = FastMath.exp(-r43);
    L6:
        if (r4 >= (1000.0d * r43)) goto L10;
        r6 = r6 * r0.random.nextDouble();
        if (r6 < r8) goto L10;
        r4 = r4 + 1;
    L10:
        return r4;
    L11:
        double r9 = FastMath.floor(r43);
        double r1 = r43 - r9;
        double r10 = FastMath.log(r9);
        double r12 = CombinatoricsUtils.factorialLog((int) r9);
        if (r1 < Double.MIN_VALUE) goto L15;
        r4 = r0.nextPoisson(r1);
    L15:
        double r2 = FastMath.sqrt(FastMath.log(((32.0d * r9) / 3.141592653589793d) + 1.0d) * r9);
        double r18 = r2 / 2.0d;
        double r20 = r9 * 2.0d;
        double r22 = r20 + r2;
        double r24 = 1.0d / (8.0d * r9);
        double r14 = FastMath.sqrt(3.141592653589793d * r22) * FastMath.exp(r24);
        double r26 = r22 / r2;
        long r44 = r4;
        double r3 = FastMath.exp(((-r2) * (r2 + 1.0d)) / r22) * r26;
        double r28 = (r14 + r3) + 1.0d;
        double r15 = r14 / r28;
        double r5 = r3 / r28;
    L16:
        double r29 = r0.random.nextDouble();
        if (r29 > r15) goto L29;
        double r210 = r0.random.nextGaussian();
        double r32 = (FastMath.sqrt(r9 + r18) * r210) - 0.5d;
        if (r32 > r2) goto L16;
        if (r32 < (-r9)) goto L16;
        if (r32 >= 0.0d) goto L26;
        double r7 = FastMath.floor(r32);
    L27:
        double r11 = ((-r0.exponential.sample()) - ((r210 * r210) / 2.0d)) + r24;
        double r13 = r7;
        double r34 = 1.0d;
    L33:
        if (r32 >= 0.0d) goto L35;
        int r16 = 1;
    L36:
        double r30 = r13 + r34;
        double r36 = r2;
        double r17 = (r13 * r30) / r20;
        double r33 = r15;
        if (r11 >= (-r17)) goto L40;
        if (r16 != 0) goto L40;
    L42:
        r9 = r9 + r13;
    L50:
        return r44 + ((long) r9);
    L40:
        double r19 = ((((r13 * 2.0d) + 1.0d) / (6.0d * r9)) - 1.0d) * r17;
        double r40 = r12;
        if (r11 < (r19 - ((r17 * r17) / (((((double) r16) * r30) + r9) * 3.0d)))) goto L42;
        if (r11 <= r19) goto L46;
    L45:
        r0 = this;
        r5 = r5;
        r15 = r33;
        r2 = r36;
        r12 = r40;
        goto L16
    L46:
        double r21 = r13 * r10;
        double r23 = r13 + r9;
        if (r11 >= ((r21 - CombinatoricsUtils.factorialLog((int) r23)) + r40)) goto L45;
        r9 = r23;
        goto L50
    L35:
        r16 = 0;
        goto L36
    L26:
        r7 = FastMath.ceil(r32);
        goto L27
    L29:
        if (r29 > (r15 + r5)) goto L50;
        r32 = r2 + (r0.exponential.sample() * r26);
        r13 = FastMath.ceil(r32);
        r34 = 1.0d;
        r11 = (-r0.exponential.sample()) - (((r32 + 1.0d) * r2) / r22);
        goto L33
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r13) {
        if (r13 >= 0) goto L6;
        return 0.0d;
    L6:
        if (r13 != Integer.MAX_VALUE) goto L9;
        return 1.0d;
    L9:
        return Gamma.regularizedGammaQ(((double) r13) + 1.0d, this.mean, this.epsilon, this.maxIterations);
    }

    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r7) {
        if (r7 >= 0) goto L4;
    L9:
        return Double.NEGATIVE_INFINITY;
    L4:
        if (r7 == Integer.MAX_VALUE) goto L9;
        if (r7 == 0) goto L11;
        double r0 = r7;
        return (((-SaddlePointExpansion.getStirlingError(r0)) - SaddlePointExpansion.getDeviancePart(r0, this.mean)) - (FastMath.log(6.283185307179586d) * 0.5d)) - (FastMath.log(r0) * 0.5d);
    L11:
        return -this.mean;
    }

    public double normalApproximateProbability(int r5) {
        return this.normal.cumulativeProbability(((double) r5) + 0.5d);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r3) {
        double r2 = logProbability(r3);
        if (r2 != Double.NEGATIVE_INFINITY) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(r2);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public int sample() {
        return (int) FastMath.min(nextPoisson(this.mean), 2147483647L);
    }
}
