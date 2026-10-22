package org.apache.commons.math3.stat.descriptive;

/* JADX INFO: loaded from: classes6.dex */
public interface StorelessUnivariateStatistic extends UnivariateStatistic {
    void clear();

    StorelessUnivariateStatistic copy();

    long getN();

    double getResult();

    void increment(double r1);
}
