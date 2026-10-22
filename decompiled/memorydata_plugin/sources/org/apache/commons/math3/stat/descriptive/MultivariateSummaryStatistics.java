package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateSummaryStatistics implements Serializable {
    private static final long serialVersionUID = 2271900808994826718L;
    private VectorialCovariance covarianceImpl;
    private StorelessUnivariateStatistic[] geoMeanImpl;
    private int k;
    private StorelessUnivariateStatistic[] maxImpl;
    private StorelessUnivariateStatistic[] meanImpl;
    private StorelessUnivariateStatistic[] minImpl;
    private long n;
    private StorelessUnivariateStatistic[] sumImpl;
    private StorelessUnivariateStatistic[] sumLogImpl;
    private StorelessUnivariateStatistic[] sumSqImpl;

    public MultivariateSummaryStatistics(int r4, boolean r5) {
        this.n = 0;
        this.k = r4;
        this.sumImpl = new StorelessUnivariateStatistic[r4];
        this.sumSqImpl = new StorelessUnivariateStatistic[r4];
        this.minImpl = new StorelessUnivariateStatistic[r4];
        this.maxImpl = new StorelessUnivariateStatistic[r4];
        this.sumLogImpl = new StorelessUnivariateStatistic[r4];
        this.geoMeanImpl = new StorelessUnivariateStatistic[r4];
        this.meanImpl = new StorelessUnivariateStatistic[r4];
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.sumImpl[r0] = new Sum();
        this.sumSqImpl[r0] = new SumOfSquares();
        this.minImpl[r0] = new Min();
        this.maxImpl[r0] = new Max();
        this.sumLogImpl[r0] = new SumOfLogs();
        this.geoMeanImpl[r0] = new GeometricMean();
        this.meanImpl[r0] = new Mean();
        r0 = r0 + 1;
        goto L3
    L5:
        this.covarianceImpl = new VectorialCovariance(r4, r5);
    }

    private void append(StringBuilder r3, double[] r4, String r5, String r6, String r7) {
        r3.append(r5);
        int r2 = 0;
    L4:
        if (r2 >= r4.length) goto L8;
        if (r2 <= 0) goto L7;
        r3.append(r6);
    L7:
        r3.append(r4[r2]);
        r2 = r2 + 1;
        goto L4
    L8:
        r3.append(r7);
    }

    private void checkDimension(int r2) {
        if (r2 != this.k) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r2, this.k);
    }

    private void checkEmpty() {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    private double[] getResults(StorelessUnivariateStatistic[] r5) {
        int r4 = r5.length;
        double[] r0 = new double[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = r5[r1].getResult();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private void setImpl(StorelessUnivariateStatistic[] r2, StorelessUnivariateStatistic[] r3) {
        checkEmpty();
        checkDimension(r2.length);
        System.arraycopy(r2, 0, r3, 0, r2.length);
    }

    public void addValue(double[] r5) {
        checkDimension(r5.length);
        int r0 = 0;
    L4:
        if (r0 >= this.k) goto L6;
        double r1 = r5[r0];
        this.sumImpl[r0].increment(r1);
        this.sumSqImpl[r0].increment(r1);
        this.minImpl[r0].increment(r1);
        this.maxImpl[r0].increment(r1);
        this.sumLogImpl[r0].increment(r1);
        this.geoMeanImpl[r0].increment(r1);
        this.meanImpl[r0].increment(r1);
        r0 = r0 + 1;
        goto L4
    L6:
        this.covarianceImpl.increment(r5);
        this.n++;
    }

    public void clear() {
        this.n = 0;
        int r0 = 0;
    L4:
        if (r0 >= this.k) goto L6;
        this.minImpl[r0].clear();
        this.maxImpl[r0].clear();
        this.sumImpl[r0].clear();
        this.sumLogImpl[r0].clear();
        this.sumSqImpl[r0].clear();
        this.geoMeanImpl[r0].clear();
        this.meanImpl[r0].clear();
        r0 = r0 + 1;
        goto L4
    L6:
        this.covarianceImpl.clear();
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, MultivariateSummaryStatistics.class) == true) goto L8;
        return false;
    L8:
        MultivariateSummaryStatistics r8 = (MultivariateSummaryStatistics) ZeusTransformUtils.preCheckCast(r7, MultivariateSummaryStatistics.class, "com.obric.memorydata.plugin");
        if (MathArrays.equalsIncludingNaN(r8.getGeometricMean(), getGeometricMean()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getMax(), getMax()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getMean(), getMean()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getMin(), getMin()) == false) goto L28;
        if (Precision.equalsIncludingNaN(r8.getN(), getN()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getSum(), getSum()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getSumSq(), getSumSq()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r8.getSumLog(), getSumLog()) == false) goto L28;
        if (r8.getCovariance().equals(getCovariance()) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public RealMatrix getCovariance() {
        return this.covarianceImpl.getResult();
    }

    public int getDimension() {
        return this.k;
    }

    public StorelessUnivariateStatistic[] getGeoMeanImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.geoMeanImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public double[] getGeometricMean() {
        return getResults(this.geoMeanImpl);
    }

    public double[] getMax() {
        return getResults(this.maxImpl);
    }

    public StorelessUnivariateStatistic[] getMaxImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.maxImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public double[] getMean() {
        return getResults(this.meanImpl);
    }

    public StorelessUnivariateStatistic[] getMeanImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.meanImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public double[] getMin() {
        return getResults(this.minImpl);
    }

    public StorelessUnivariateStatistic[] getMinImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.minImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public long getN() {
        return this.n;
    }

    public double[] getStandardDeviation() {
        double[] r0 = new double[this.k];
        if (getN() >= 1) goto L7;
        double r1 = Double.NaN;
    L5:
        Arrays.fill(r0, r1);
    L13:
        return r0;
    L7:
        if (getN() >= 2) goto L9;
        r1 = 0.0d;
        goto L5
    L9:
        RealMatrix r2 = this.covarianceImpl.getResult();
        int r3 = 0;
    L11:
        if (r3 >= this.k) goto L13;
        r0[r3] = FastMath.sqrt(r2.getEntry(r3, r3));
        r3 = r3 + 1;
        goto L11
    }

    public double[] getSum() {
        return getResults(this.sumImpl);
    }

    public StorelessUnivariateStatistic[] getSumImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.sumImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public double[] getSumLog() {
        return getResults(this.sumLogImpl);
    }

    public StorelessUnivariateStatistic[] getSumLogImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.sumLogImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public double[] getSumSq() {
        return getResults(this.sumSqImpl);
    }

    public StorelessUnivariateStatistic[] getSumsqImpl() {
        return (StorelessUnivariateStatistic[]) ZeusTransformUtils.preCheckCast(this.sumSqImpl.clone(), StorelessUnivariateStatistic[].class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        return ((((((((((((((((((MathUtils.hash(getGeometricMean()) + 31) * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumSq())) * 31) + MathUtils.hash(getSumLog())) * 31) + getCovariance().hashCode();
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.geoMeanImpl);
    }

    public void setMaxImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.maxImpl);
    }

    public void setMeanImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.meanImpl);
    }

    public void setMinImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.minImpl);
    }

    public void setSumImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.sumImpl);
    }

    public void setSumLogImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.sumLogImpl);
    }

    public void setSumsqImpl(StorelessUnivariateStatistic[] r2) {
        setImpl(r2, this.sumSqImpl);
    }

    public String toString() {
        String r0 = System.getProperty("line.separator");
        StringBuilder r7 = new StringBuilder();
        r7.append("MultivariateSummaryStatistics:" + r0);
        r7.append("n: " + getN() + r0);
        append(r7, getMin(), "min: ", ", ", r0);
        append(r7, getMax(), "max: ", ", ", r0);
        append(r7, getMean(), "mean: ", ", ", r0);
        append(r7, getGeometricMean(), "geometric mean: ", ", ", r0);
        append(r7, getSumSq(), "sum of squares: ", ", ", r0);
        append(r7, getSumLog(), "sum of logarithms: ", ", ", r0);
        append(r7, getStandardDeviation(), "standard deviation: ", ", ", r0);
        r7.append("covariance: " + getCovariance().toString() + r0);
        return r7.toString();
    }
}
