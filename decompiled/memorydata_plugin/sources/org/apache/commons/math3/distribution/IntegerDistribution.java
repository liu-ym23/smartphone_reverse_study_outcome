package org.apache.commons.math3.distribution;

/* JADX INFO: loaded from: classes6.dex */
public interface IntegerDistribution {
    double cumulativeProbability(int r1);

    double getNumericalMean();

    double getNumericalVariance();

    int getSupportLowerBound();

    int getSupportUpperBound();

    int inverseCumulativeProbability(double r1);

    double probability(int r1);
}
