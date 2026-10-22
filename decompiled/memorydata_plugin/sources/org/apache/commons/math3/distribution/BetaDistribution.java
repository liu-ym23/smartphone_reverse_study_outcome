package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class BetaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -1221965979403477668L;
    private final double alpha;
    private final double beta;
    private final double solverAbsoluteAccuracy;
    private double z;

    private static final class ChengBetaSampler {
        private static double algorithmBB(RandomGenerator r21, double r22, double r24, double r26) {
            RandomGenerator r2 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r21, RandomGenerator.class, "com.obric.memorydata.plugin");
            double r3 = r24 + r26;
            double r5 = FastMath.sqrt((r3 - 2.0d) / (((2.0d * r24) * r26) - r3));
            double r7 = (1.0d / r5) + r24;
        L3:
            double r9 = r2.nextDouble();
            double r11 = r2.nextDouble();
            RandomGenerator r23 = r2;
            double r15 = r3;
            double r13 = (FastMath.log(r9) - FastMath.log1p(-r9)) * r5;
            double r4 = FastMath.exp(r13) * r24;
            double r10 = (r9 * r9) * r11;
            double r14 = (r13 * r7) - 1.3862944d;
            double r12 = (r24 + r14) - r4;
            if ((r12 + 2.609438d) >= (5.0d * r10)) goto L11;
            double r16 = FastMath.log(r10);
            if (r12 >= r16) goto L11;
            if ((r14 + ((FastMath.log(r15) - FastMath.log(r26 + r4)) * r15)) >= r16) goto L11;
            r2 = r23;
            r3 = r15;
        L11:
            double r6 = FastMath.min(r4, Double.MAX_VALUE);
            if (Precision.equals(r24, r22) == false) goto L15;
            return r6 / (r26 + r6);
        L15:
            return r26 / (r26 + r6);
        }

        private static double algorithmBC(RandomGenerator r25, double r26, double r28, double r30) {
            RandomGenerator r2 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r25, RandomGenerator.class, "com.obric.memorydata.plugin");
            double r3 = r28 + r30;
            double r7 = 1.0d / r30;
            double r5 = (1.0d + r28) - r30;
            double r9 = (((0.0416667d * r30) + 0.0138889d) * r5) / ((r28 * r7) - 0.777778d);
            double r6 = (((0.25d / r5) + 0.5d) * r30) + 0.25d;
        L3:
            double r11 = r2.nextDouble();
            double r17 = r2.nextDouble();
            double r19 = r11 * r17;
            double r21 = r11 * r19;
            if (r11 < 0.5d) goto L6;
            if (r21 <= 0.25d) goto L10;
            if (r21 >= r6) goto L3;
        L14:
            double r18 = (FastMath.log(r11) - FastMath.log1p(-r11)) * r7;
            double r12 = FastMath.exp(r18) * r28;
            if (((((FastMath.log(r3) - FastMath.log(r30 + r12)) + r18) * r3) - 1.3862944d) < FastMath.log(r21)) goto L3;
            double r4 = r12;
        L17:
            double r8 = FastMath.min(r4, Double.MAX_VALUE);
            if (Precision.equals(r28, r26) == false) goto L21;
            return r8 / (r30 + r8);
        L21:
            return r30 / (r30 + r8);
        L10:
            r4 = FastMath.exp(r7 * (FastMath.log(r11) - FastMath.log1p(-r11))) * r28;
            goto L17
        L6:
            if ((((r17 * 0.25d) + r21) - r19) < r9) goto L14;
            goto L14
        }

        static double sample(RandomGenerator r7, double r8, double r10) {
            RandomGenerator r0 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r7, RandomGenerator.class, "com.obric.memorydata.plugin");
            double r5 = FastMath.min(r8, r10);
            double r11 = FastMath.max(r8, r10);
            if (r5 <= 1.0d) goto L7;
            return algorithmBB(r0, r8, r5, r11);
        L7:
            return algorithmBC(r0, r8, r11, r5);
        }
    }

    public BetaDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public BetaDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public BetaDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public BetaDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        this.alpha = r4;
        this.beta = r6;
        this.z = Double.NaN;
        this.solverAbsoluteAccuracy = r8;
    }

    private void recomputeZ() {
        if (Double.isNaN(this.z) == false) goto L6;
        this.z = (Gamma.logGamma(this.alpha) + Gamma.logGamma(this.beta)) - Gamma.logGamma(this.alpha + this.beta);
        return;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r10) {
        if (r10 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L9;
        return 1.0d;
    L9:
        return Beta.regularizedBeta(r10, this.alpha, this.beta);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r3) {
        double r2 = logDensity(r3);
        if (r2 != Double.NEGATIVE_INFINITY) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(r2);
    }

    public double getAlpha() {
        return this.alpha;
    }

    public double getBeta() {
        return this.beta;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double r0 = getAlpha();
        return r0 / (getBeta() + r0);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = getAlpha();
        double r2 = getBeta();
        double r4 = r0 + r2;
        return (r0 * r2) / ((r4 * r4) * (r4 + 1.0d));
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
        return 1.0d;
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
        recomputeZ();
        if (r9 >= 0.0d) goto L5;
    L22:
        return Double.NEGATIVE_INFINITY;
    L5:
        if (r9 > 1.0d) goto L22;
        if (r9 == 0.0d) goto L10;
        if (r9 == 1.0d) goto L16;
        double r0 = FastMath.log(r9);
        double r10 = FastMath.log1p(-r9);
        return (((this.alpha - 1.0d) * r0) + ((this.beta - 1.0d) * r10)) - this.z;
    L16:
        if (this.beta < 1.0d) goto L19;
        return Double.NEGATIVE_INFINITY;
    L19:
        throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, Double.valueOf(this.beta), 1, false);
    L10:
        if (this.alpha < 1.0d) goto L13;
        return Double.NEGATIVE_INFINITY;
    L13:
        throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, Double.valueOf(this.alpha), 1, false);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        return ChengBetaSampler.sample(this.random, this.alpha, this.beta);
    }
}
