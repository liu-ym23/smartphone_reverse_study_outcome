package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedMultivariateSummaryStatistics extends MultivariateSummaryStatistics {
    private static final long serialVersionUID = 7099834153347155363L;

    public SynchronizedMultivariateSummaryStatistics(int r1, boolean r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void addValue(double[] r1) {
        monitor-enter(this);
        super.addValue(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized boolean equals(Object r1) {
        monitor-enter(this);
        boolean r2 = super.equals(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized RealMatrix getCovariance() {
        monitor-enter(this);
        RealMatrix r0 = super.getCovariance();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized int getDimension() {
        monitor-enter(this);
        int r0 = super.getDimension();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getGeoMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getGeoMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getGeometricMean() {
        monitor-enter(this);
        double[] r0 = super.getGeometricMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getMax() {
        monitor-enter(this);
        double[] r0 = super.getMax();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMaxImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMaxImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getMean() {
        monitor-enter(this);
        double[] r0 = super.getMean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMeanImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMeanImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getMin() {
        monitor-enter(this);
        double[] r0 = super.getMin();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMinImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getMinImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized long getN() {
        monitor-enter(this);
        long r0 = super.getN();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getStandardDeviation() {
        monitor-enter(this);
        double[] r0 = super.getStandardDeviation();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getSum() {
        monitor-enter(this);
        double[] r0 = super.getSum();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getSumLog() {
        monitor-enter(this);
        double[] r0 = super.getSumLog();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumLogImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumLogImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized double[] getSumSq() {
        monitor-enter(this);
        double[] r0 = super.getSumSq();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumsqImpl() {
        monitor-enter(this);
        StorelessUnivariateStatistic[] r0 = super.getSumsqImpl();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized int hashCode() {
        monitor-enter(this);
        int r0 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setGeoMeanImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMaxImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setMaxImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMeanImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setMeanImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMinImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setMinImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setSumImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setSumLogImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic[] r1) {
        monitor-enter(this);
        super.setSumsqImpl(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
