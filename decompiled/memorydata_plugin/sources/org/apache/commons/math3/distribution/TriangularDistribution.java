package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class TriangularDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20120112;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f17877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f17878b;
    private final double c;
    private final double solverAbsoluteAccuracy;

    public TriangularDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public TriangularDistribution(RandomGenerator r3, double r4, double r6, double r8) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        if (r4 >= r8) goto L15;
        if (r6 < r4) goto L13;
        if (r6 > r8) goto L11;
        this.f17877a = r4;
        this.c = r6;
        this.f17878b = r8;
        this.solverAbsoluteAccuracy = FastMath.max(FastMath.ulp(r4), FastMath.ulp(r8));
        return;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_TOO_LARGE, Double.valueOf(r6), Double.valueOf(r8), true);
    L13:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, Double.valueOf(r6), Double.valueOf(r4), true);
    L15:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(r4), Double.valueOf(r8), false);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r12) {
        double r0 = this.f17877a;
        if (r12 >= r0) goto L7;
        return 0.0d;
    L7:
        if (r0 > r12) goto L12;
        double r2 = this.c;
        if (r12 >= r2) goto L12;
        return ((r12 - r0) * (r12 - r0)) / ((this.f17878b - r0) * (r2 - r0));
    L12:
        double r3 = this.c;
        if (r12 != r3) goto L17;
        return (r3 - r0) / (this.f17878b - r0);
    L17:
        if (r3 >= r12) goto L22;
        double r7 = this.f17878b;
        if (r12 <= r7) goto L21;
        return 1.0d;
    L21:
        return 1.0d - (((r7 - r12) * (r7 - r12)) / ((r7 - r0) * (r7 - r3)));
    L22:
        return 1.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r12) {
        double r0 = this.f17877a;
        if (r12 >= r0) goto L6;
        return 0.0d;
    L6:
        if (r0 > r12) goto L11;
        double r7 = this.c;
        if (r12 >= r7) goto L11;
        return ((r12 - r0) * 2.0d) / ((this.f17878b - r0) * (r7 - r0));
    L11:
        double r8 = this.c;
        if (r12 != r8) goto L16;
        return 2.0d / (this.f17878b - r0);
    L16:
        if (r8 >= r12) goto L21;
        double r9 = this.f17878b;
        if (r12 > r9) goto L21;
        return ((r9 - r12) * 2.0d) / ((r9 - r0) * (r9 - r8));
    L21:
        return 0.0d;
    }

    public double getMode() {
        return this.c;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return ((this.f17877a + this.f17878b) + this.c) / 3.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.f17877a;
        double r4 = this.f17878b;
        double r2 = (r0 * r0) + (r4 * r4);
        double r6 = this.c;
        return ((((r2 + (r6 * r6)) - (r0 * r4)) - (r0 * r6)) - (r4 * r6)) / 18.0d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.f17877a;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.f17878b;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r13) {
        if (r13 < 0.0d) goto L20;
        if (r13 > 1.0d) goto L20;
        if (r13 == 0.0d) goto L9;
        if (r13 == 1.0d) goto L12;
        double r0 = this.c;
        double r4 = this.f17877a;
        double r8 = this.f17878b;
        if (r13 >= ((r0 - r4) / (r8 - r4))) goto L18;
        return r4 + FastMath.sqrt((r13 * (r8 - r4)) * (r0 - r4));
    L18:
        return r8 - FastMath.sqrt(((1.0d - r13) * (r8 - r4)) * (r8 - r0));
    L12:
        return this.f17878b;
    L9:
        return this.f17877a;
    L20:
        throw new OutOfRangeException(Double.valueOf(r13), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    public boolean isSupportUpperBoundInclusive() {
        return true;
    }
}
