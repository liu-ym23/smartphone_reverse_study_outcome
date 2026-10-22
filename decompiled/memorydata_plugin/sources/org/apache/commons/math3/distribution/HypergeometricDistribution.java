package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class HypergeometricDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -436928820673516179L;
    private final int numberOfSuccesses;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private final int populationSize;
    private final int sampleSize;

    public HypergeometricDistribution(int r2, int r3, int r4) {
        this(new Well19937c(), r2, r3, r4);
    }

    public HypergeometricDistribution(RandomGenerator r3, int r4, int r5, int r6) {
        super((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (r4 <= 0) goto L20;
        if (r5 < 0) goto L18;
        if (r6 < 0) goto L16;
        if (r5 > r4) goto L14;
        if (r6 > r4) goto L12;
        this.numberOfSuccesses = r5;
        this.populationSize = r4;
        this.sampleSize = r6;
        return;
    L12:
        throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(r6), Integer.valueOf(r4), true);
    L14:
        throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(r5), Integer.valueOf(r4), true);
    L16:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r6));
    L18:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, Integer.valueOf(r5));
    L20:
        throw new NotStrictlyPositiveException(LocalizedFormats.POPULATION_SIZE, Integer.valueOf(r4));
    }

    private int[] getDomain(int r3, int r4, int r5) {
        return new int[]{getLowerDomain(r3, r4, r5), getUpperDomain(r4, r5)};
    }

    private int getLowerDomain(int r1, int r2, int r3) {
        return FastMath.max(0, r2 - (r1 - r3));
    }

    private int getUpperDomain(int r1, int r2) {
        return FastMath.min(r2, r1);
    }

    private double innerCumulativeProbability(int r5, int r6, int r7) {
        double r0 = probability(r5);
    L3:
        if (r5 == r6) goto L5;
        r5 = r5 + r7;
        r0 = r0 + probability(r5);
        goto L3
    L5:
        return r0;
    }

    public double calculateNumericalVariance() {
        double r0 = getPopulationSize();
        double r2 = getNumberOfSuccesses();
        double r4 = getSampleSize();
        return (((r4 * r2) * (r0 - r4)) * (r0 - r2)) / ((r0 * r0) * (r0 - 1.0d));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r5) {
        int[] r0 = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (r5 >= r0[0]) goto L6;
        return 0.0d;
    L6:
        if (r5 < r0[1]) goto L9;
        return 1.0d;
    L9:
        return innerCumulativeProbability(r0[0], r5, 1);
    }

    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return ((double) getSampleSize()) * (((double) getNumberOfSuccesses()) / ((double) getPopulationSize()));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        if (this.numericalVarianceIsCalculated == true) goto L6;
        this.numericalVariance = calculateNumericalVariance();
        this.numericalVarianceIsCalculated = true;
    L6:
        return this.numericalVariance;
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return FastMath.max(0, (getSampleSize() + getNumberOfSuccesses()) - getPopulationSize());
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return FastMath.min(getNumberOfSuccesses(), getSampleSize());
    }

    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r18) {
        int[] r1 = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (r18 >= r1[0]) goto L5;
    L8:
        return Double.NEGATIVE_INFINITY;
    L5:
        if (r18 > r1[1]) goto L8;
        int r2 = this.sampleSize;
        int r4 = this.populationSize;
        double r13 = ((double) r2) / ((double) r4);
        double r15 = ((double) (r4 - r2)) / ((double) r4);
        double r3 = SaddlePointExpansion.logBinomialProbability(r18, this.numberOfSuccesses, r13, r15);
        double r5 = SaddlePointExpansion.logBinomialProbability(this.sampleSize - r18, this.populationSize - this.numberOfSuccesses, r13, r15);
        double r6 = r3 + r5;
        return r6 - SaddlePointExpansion.logBinomialProbability(this.sampleSize, this.populationSize, r13, r15);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r3) {
        double r2 = logProbability(r3);
        if (r2 != Double.NEGATIVE_INFINITY) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(r2);
    }

    public double upperCumulativeProbability(int r4) {
        int[] r0 = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (r4 > r0[0]) goto L6;
        return 1.0d;
    L6:
        if (r4 <= r0[1]) goto L9;
        return 0.0d;
    L9:
        return innerCumulativeProbability(r0[1], r4, -1);
    }
}
