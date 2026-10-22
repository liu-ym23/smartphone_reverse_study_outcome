package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRealDistribution implements Serializable, RealDistribution {
    public static final double SOLVER_DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private static final long serialVersionUID = -38038050983108802L;
    protected final RandomGenerator random;

    @Deprecated
    protected RandomDataImpl randomData;
    private double solverAbsoluteAccuracy;

    @Deprecated
    public AbstractRealDistribution() {
        this.randomData = new RandomDataImpl();
        this.solverAbsoluteAccuracy = 1.0E-6d;
        this.random = null;
    }

    public AbstractRealDistribution(RandomGenerator r3) {
        RandomGenerator r4 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        this.randomData = new RandomDataImpl();
        this.solverAbsoluteAccuracy = 1.0E-6d;
        this.random = r4;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double r1, double r3) {
        return probability(r1, r3);
    }

    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(final double r26) {
        boolean r6 = true;
        if (r26 < 0.0d) goto L53;
        double r8 = 1.0d;
        if (r26 > 1.0d) goto L53;
        double r10 = getSupportLowerBound();
        if (r26 != 0.0d) goto L9;
        return r10;
    L9:
        double r3 = getSupportUpperBound();
        if (r26 != 1.0d) goto L12;
        return r3;
    L12:
        double r12 = getNumericalMean();
        double r14 = FastMath.sqrt(getNumericalVariance());
        if (Double.isInfinite(r12) == false) goto L15;
    L21:
        r6 = false;
    L23:
        if (r10 != Double.NEGATIVE_INFINITY) goto L31;
        if (r6 == false) goto L26;
        r10 = r12 - (FastMath.sqrt((1.0d - r26) / r26) * r14);
        goto L31
    L26:
        r10 = -1.0d;
    L28:
        if (cumulativeProbability(r10) < r26) goto L31;
        r10 = r10 * 2.0d;
    L31:
        if (r3 != Double.POSITIVE_INFINITY) goto L38;
        if (r6 == false) goto L35;
        r3 = r12 + (r14 * FastMath.sqrt(r26 / (1.0d - r26)));
    L35:
        if (cumulativeProbability(r8) >= r26) goto L37;
        r8 = r8 * 2.0d;
        goto L35
    L37:
        double r21 = r8;
    L39:
        double r1 = UnivariateSolverUtils.solve(new AnonymousClass1(this, r26), r10, r21, getSolverAbsoluteAccuracy());
        if (isSupportConnected() == true) goto L51;
        double r4 = getSolverAbsoluteAccuracy();
        double r5 = r1 - r4;
        if (r5 < getSupportLowerBound()) goto L51;
        double r7 = cumulativeProbability(r1);
        if (cumulativeProbability(r5) != r7) goto L51;
    L46:
        if ((r1 - r10) <= r4) goto L51;
        double r13 = (r10 + r1) * 0.5d;
        if (cumulativeProbability(r13) < r7) goto L49;
        r1 = r13;
        goto L46
    L49:
        r10 = r13;
    L51:
        return r1;
    L38:
        r21 = r3;
        goto L39
    L15:
        if (Double.isNaN(r12) == true) goto L21;
        if (Double.isInfinite(r14) == true) goto L21;
        if (Double.isNaN(r14) == true) goto L21;
    L53:
        throw new OutOfRangeException(Double.valueOf(r26), 0, 1);
    }

    public double logDensity(double r1) {
        return FastMath.log(density(r1));
    }

    public double probability(double r1) {
        return 0.0d;
    }

    public double probability(double r2, double r4) {
        if (r2 > r4) goto L7;
        return cumulativeProbability(r4) - cumulativeProbability(r2);
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(r2), Double.valueOf(r4), true);
    }

    public void reseedRandomGenerator(long r2) {
        this.random.setSeed(r2);
        this.randomData.reSeed(r2);
    }

    public double sample() {
        return inverseCumulativeProbability(this.random.nextDouble());
    }

    public double[] sample(int r5) {
        if (r5 <= 0) goto L8;
        double[] r0 = new double[r5];
        int r1 = 0;
    L4:
        if (r1 >= r5) goto L6;
        r0[r1] = sample();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r5));
    }
}
