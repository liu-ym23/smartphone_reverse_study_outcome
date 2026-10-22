package org.apache.commons.math3.distribution;

/* JADX INFO: loaded from: classes6.dex */
public interface RealDistribution {
    double cumulativeProbability(double r1);

    @Deprecated
    double cumulativeProbability(double r1, double r3);

    double density(double r1);

    double getNumericalMean();

    double getNumericalVariance();

    double getSupportLowerBound();

    double getSupportUpperBound();

    double inverseCumulativeProbability(double r1);

    boolean isSupportConnected();
}
