package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIntegerDistribution implements Serializable, IntegerDistribution {
    private static final long serialVersionUID = -1146319659338487221L;
    protected final RandomGenerator random;

    @Deprecated
    protected final RandomDataImpl randomData;

    @Deprecated
    public AbstractIntegerDistribution() {
        this.randomData = new RandomDataImpl();
        this.random = null;
    }

    public AbstractIntegerDistribution(RandomGenerator r3) {
        RandomGenerator r4 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        this.randomData = new RandomDataImpl();
        this.random = r4;
    }

    private double checkedCumulativeProbability(int r4) {
        double r0 = cumulativeProbability(r4);
        if (Double.isNaN(r0) == true) goto L6;
        return r0;
    L6:
        throw new MathInternalError(LocalizedFormats.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN, new Object[]{Integer.valueOf(r4)});
    }

    public double cumulativeProbability(int r3, int r4) {
        if (r4 < r3) goto L6;
        return cumulativeProbability(r4) - cumulativeProbability(r3);
    L6:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Integer.valueOf(r3), Integer.valueOf(r4), true);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int inverseCumulativeProbability(double r17) {
        boolean r6 = false;
        if (r17 < 0.0d) goto L39;
        if (r17 > 1.0d) goto L39;
        int r10 = getSupportLowerBound();
        if (r17 != 0.0d) goto L10;
        return r10;
    L10:
        if (r10 == Integer.MIN_VALUE) goto L12;
        r10 = r10 - 1;
    L15:
        int r11 = getSupportUpperBound();
        if (r17 != 1.0d) goto L18;
        return r11;
    L18:
        double r12 = getNumericalMean();
        double r14 = FastMath.sqrt(getNumericalVariance());
        if (Double.isInfinite(r12) == false) goto L21;
    L29:
        if (r6 == false) goto L37;
        double r3 = FastMath.sqrt((1.0d - r17) / r17);
        double r5 = r12 - (r3 * r14);
        if (r5 <= r10) goto L33;
        r10 = ((int) FastMath.ceil(r5)) - 1;
    L33:
        double r13 = r12 + ((1.0d / r3) * r14);
        if (r13 >= r11) goto L37;
        r11 = ((int) FastMath.ceil(r13)) - 1;
    L37:
        return solveInverseCumulativeProbability(r17, r10, r11);
    L21:
        if (Double.isNaN(r12) == true) goto L29;
        if (Double.isInfinite(r14) == true) goto L29;
        if (Double.isNaN(r14) == true) goto L29;
        if (r14 == 0.0d) goto L29;
        r6 = true;
        goto L29
    L12:
        if (checkedCumulativeProbability(r10) < r17) goto L15;
        return r10;
    L39:
        throw new OutOfRangeException(Double.valueOf(r17), 0, 1);
    }

    public double logProbability(int r1) {
        return FastMath.log(probability(r1));
    }

    public void reseedRandomGenerator(long r2) {
        this.random.setSeed(r2);
        this.randomData.reSeed(r2);
    }

    public int sample() {
        return inverseCumulativeProbability(this.random.nextDouble());
    }

    public int[] sample(int r4) {
        if (r4 <= 0) goto L8;
        int[] r0 = new int[r4];
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L6;
        r0[r1] = sample();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r4));
    }

    public int solveInverseCumulativeProbability(double r4, int r6, int r7) {
    L3:
        if ((r6 + 1) >= r7) goto L12;
        int r0 = (r6 + r7) / 2;
        if (r0 < r6) goto L7;
        if (r0 > r7) goto L7;
    L9:
        if (checkedCumulativeProbability(r0) >= r4) goto L10;
        r6 = r0;
        goto L3
    L10:
        r7 = r0;
    L7:
        r0 = ((r7 - r6) / 2) + r6;
        goto L9
    L12:
        return r7;
    }
}
