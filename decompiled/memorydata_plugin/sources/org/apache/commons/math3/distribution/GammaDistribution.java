package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class GammaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20120524;
    private final double densityPrefactor1;
    private final double densityPrefactor2;
    private final double logDensityPrefactor1;
    private final double logDensityPrefactor2;
    private final double maxLogY;
    private final double minY;
    private final double scale;
    private final double shape;
    private final double shiftedShape;
    private final double solverAbsoluteAccuracy;

    public GammaDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public GammaDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public GammaDistribution(RandomGenerator r9, double r10, double r12) {
        this((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin"), r10, r12, 1.0E-9d);
    }

    public GammaDistribution(RandomGenerator r20, double r21, double r23, double r25) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r20, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r21 <= 0.0d) goto L11;
        if (r23 <= 0.0d) goto L9;
        this.shape = r21;
        this.scale = r23;
        this.solverAbsoluteAccuracy = r25;
        double r7 = r21 + 4.7421875d;
        double r11 = r7 + 0.5d;
        this.shiftedShape = r11;
        double r13 = 2.718281828459045d / (6.283185307179586d * r11);
        double r5 = (FastMath.sqrt(r13) * r21) / Gamma.lanczos(r21);
        this.densityPrefactor2 = r5;
        double r9 = (FastMath.log(r21) + (FastMath.log(r13) * 0.5d)) - FastMath.log(Gamma.lanczos(r21));
        this.logDensityPrefactor2 = r9;
        this.densityPrefactor1 = ((r5 / r23) * FastMath.pow(r11, -r21)) * FastMath.exp(r7);
        this.logDensityPrefactor1 = (((r9 - FastMath.log(r23)) - (FastMath.log(r11) * r21)) + r21) + 4.7421875d;
        this.minY = r7 - FastMath.log(Double.MAX_VALUE);
        this.maxLogY = FastMath.log(Double.MAX_VALUE) / (r21 - 1.0d);
        return;
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(r23));
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(r21));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r5) {
        if (r5 > 0.0d) goto L6;
        return 0.0d;
    L6:
        return Gamma.regularizedGammaP(this.shape, r5 / this.scale);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r9) {
        if (r9 >= 0.0d) goto L5;
        return 0.0d;
    L5:
        double r0 = r9 / this.scale;
        if (r0 > this.minY) goto L8;
    L12:
        double r2 = this.shiftedShape;
        double r4 = (r0 - r2) / r2;
        double r3 = this.shape * (FastMath.log1p(r4) - r4);
        double r1 = ((((-r0) * 5.2421875d) / this.shiftedShape) + 4.7421875d) + r3;
        return (this.densityPrefactor2 / r9) * FastMath.exp(r1);
    L8:
        if (FastMath.log(r0) >= this.maxLogY) goto L12;
        return (this.densityPrefactor1 * FastMath.exp(-r0)) * FastMath.pow(r0, this.shape - 1.0d);
    }

    @Deprecated
    public double getAlpha() {
        return this.shape;
    }

    @Deprecated
    public double getBeta() {
        return this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.shape * this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.shape;
        double r2 = this.scale;
        return (r0 * r2) * r2;
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
    public double logDensity(double r9) {
        if (r9 >= 0.0d) goto L6;
        return Double.NEGATIVE_INFINITY;
    L6:
        double r0 = r9 / this.scale;
        if (r0 > this.minY) goto L9;
    L13:
        double r2 = this.shiftedShape;
        double r4 = (r0 - r2) / r2;
        double r3 = this.shape * (FastMath.log1p(r4) - r4);
        double r1 = ((((-r0) * 5.2421875d) / this.shiftedShape) + 4.7421875d) + r3;
        return (this.logDensityPrefactor2 - FastMath.log(r9)) + r1;
    L9:
        if (FastMath.log(r0) >= this.maxLogY) goto L13;
        return (this.logDensityPrefactor1 - r0) + (FastMath.log(r0) * (this.shape - 1.0d));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        double r1 = this.shape;
        if (r1 >= 1.0d) goto L16;
    L4:
        double r2 = this.random.nextDouble();
        double r5 = this.shape;
        double r7 = (r5 / 2.718281828459045d) + 1.0d;
        double r3 = r2 * r7;
        if (r3 <= 1.0d) goto L6;
        double r4 = FastMath.log((r7 - r3) / r5) * (-1.0d);
        if (this.random.nextDouble() > FastMath.pow(r4, this.shape - 1.0d)) goto L4;
        return this.scale * r4;
    L6:
        double r6 = FastMath.pow(r3, 1.0d / r5);
        if (this.random.nextDouble() > FastMath.exp(-r6)) goto L4;
        return this.scale * r6;
    L16:
        double r8 = r1 - 0.3333333333333333d;
        double r9 = 1.0d / (FastMath.sqrt(r8) * 3.0d);
    L17:
        double r10 = this.random.nextGaussian();
        double r11 = (r9 * r10) + 1.0d;
        double r12 = (r11 * r11) * r11;
        if (r12 <= 0.0d) goto L17;
        double r13 = r10 * r10;
        double r14 = this.random.nextDouble();
        if (r14 < (1.0d - ((0.0331d * r13) * r13))) goto L23;
        if (FastMath.log(r14) >= ((r13 * 0.5d) + (((1.0d - r12) + FastMath.log(r12)) * r8))) goto L17;
        return (this.scale * r8) * r12;
    L23:
        return (this.scale * r8) * r12;
    }
}
