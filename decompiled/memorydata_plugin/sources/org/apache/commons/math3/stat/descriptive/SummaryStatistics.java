package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SummaryStatistics implements Serializable, StatisticalSummary {
    private static final long serialVersionUID = -2021321786743555871L;
    private GeometricMean geoMean;
    private StorelessUnivariateStatistic geoMeanImpl;
    private Max max;
    private StorelessUnivariateStatistic maxImpl;
    private Mean mean;
    private StorelessUnivariateStatistic meanImpl;
    private Min min;
    private StorelessUnivariateStatistic minImpl;
    private long n;
    private SecondMoment secondMoment;
    private Sum sum;
    private StorelessUnivariateStatistic sumImpl;
    private SumOfLogs sumLog;
    private StorelessUnivariateStatistic sumLogImpl;
    private SumOfSquares sumsq;
    private StorelessUnivariateStatistic sumsqImpl;
    private Variance variance;
    private StorelessUnivariateStatistic varianceImpl;

    public SummaryStatistics() {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean(this.secondMoment);
        Variance r0 = new Variance(this.secondMoment);
        this.variance = r0;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = r0;
    }

    public SummaryStatistics(SummaryStatistics r3) {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean(this.secondMoment);
        Variance r0 = new Variance(this.secondMoment);
        this.variance = r0;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = r0;
        copy(r3, this);
    }

    private void checkEmpty() {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    public static void copy(SummaryStatistics r4, SummaryStatistics r5) {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        r5.maxImpl = r4.maxImpl.copy();
        r5.minImpl = r4.minImpl.copy();
        r5.sumImpl = r4.sumImpl.copy();
        r5.sumLogImpl = r4.sumLogImpl.copy();
        r5.sumsqImpl = r4.sumsqImpl.copy();
        r5.secondMoment = r4.secondMoment.copy();
        r5.n = r4.n;
        if (ZeusTransformUtils.instanceOf(r4.getVarianceImpl(), Variance.class) == false) goto L5;
        StorelessUnivariateStatistic r0 = new Variance(r5.secondMoment);
    L6:
        r5.varianceImpl = r0;
        if (ZeusTransformUtils.instanceOf(r4.meanImpl, Mean.class) == false) goto L9;
        StorelessUnivariateStatistic r1 = new Mean(r5.secondMoment);
    L10:
        r5.meanImpl = r1;
        if (ZeusTransformUtils.instanceOf(r4.getGeoMeanImpl(), GeometricMean.class) == false) goto L13;
        StorelessUnivariateStatistic r2 = new GeometricMean((SumOfLogs) ZeusTransformUtils.preCheckCast(r5.sumLogImpl, SumOfLogs.class, "com.obric.memorydata.plugin"));
    L14:
        r5.geoMeanImpl = r2;
        GeometricMean r3 = r4.geoMean;
        if (r3 != r4.geoMeanImpl) goto L17;
        r5.geoMean = (GeometricMean) ZeusTransformUtils.preCheckCast(r5.geoMeanImpl, GeometricMean.class, "com.obric.memorydata.plugin");
    L18:
        Max r6 = r4.max;
        if (r6 != r4.maxImpl) goto L21;
        r5.max = (Max) ZeusTransformUtils.preCheckCast(r5.maxImpl, Max.class, "com.obric.memorydata.plugin");
    L22:
        Mean r7 = r4.mean;
        if (r7 != r4.meanImpl) goto L25;
        r5.mean = (Mean) ZeusTransformUtils.preCheckCast(r5.meanImpl, Mean.class, "com.obric.memorydata.plugin");
    L26:
        Min r8 = r4.min;
        if (r8 != r4.minImpl) goto L29;
        r5.min = (Min) ZeusTransformUtils.preCheckCast(r5.minImpl, Min.class, "com.obric.memorydata.plugin");
    L30:
        Sum r9 = r4.sum;
        if (r9 != r4.sumImpl) goto L33;
        r5.sum = (Sum) ZeusTransformUtils.preCheckCast(r5.sumImpl, Sum.class, "com.obric.memorydata.plugin");
    L34:
        Variance r10 = r4.variance;
        if (r10 != r4.varianceImpl) goto L37;
        r5.variance = (Variance) ZeusTransformUtils.preCheckCast(r5.varianceImpl, Variance.class, "com.obric.memorydata.plugin");
    L38:
        SumOfLogs r11 = r4.sumLog;
        if (r11 != r4.sumLogImpl) goto L41;
        r5.sumLog = (SumOfLogs) ZeusTransformUtils.preCheckCast(r5.sumLogImpl, SumOfLogs.class, "com.obric.memorydata.plugin");
    L42:
        SumOfSquares r12 = r4.sumsq;
        if (r12 != r4.sumsqImpl) goto L45;
        r5.sumsq = (SumOfSquares) ZeusTransformUtils.preCheckCast(r5.sumsqImpl, SumOfSquares.class, "com.obric.memorydata.plugin");
        return;
    L45:
        SumOfSquares.copy(r12, r5.sumsq);
        return;
    L41:
        SumOfLogs.copy(r11, r5.sumLog);
        goto L42
    L37:
        Variance.copy(r10, r5.variance);
        goto L38
    L33:
        Sum.copy(r9, r5.sum);
        goto L34
    L29:
        Min.copy(r8, r5.min);
        goto L30
    L25:
        Mean.copy(r7, r5.mean);
        goto L26
    L21:
        Max.copy(r6, r5.max);
        goto L22
    L17:
        GeometricMean.copy(r3, r5.geoMean);
        goto L18
    L13:
        r2 = r4.geoMeanImpl.copy();
        goto L14
    L9:
        r1 = r4.meanImpl.copy();
        goto L10
    L5:
        r0 = r4.varianceImpl.copy();
        goto L6
    }

    public void addValue(double r3) {
        this.sumImpl.increment(r3);
        this.sumsqImpl.increment(r3);
        this.minImpl.increment(r3);
        this.maxImpl.increment(r3);
        this.sumLogImpl.increment(r3);
        this.secondMoment.increment(r3);
        StorelessUnivariateStatistic r0 = this.meanImpl;
        if (r0 == this.mean) goto L5;
        r0.increment(r3);
    L5:
        StorelessUnivariateStatistic r1 = this.varianceImpl;
        if (r1 == this.variance) goto L8;
        r1.increment(r3);
    L8:
        StorelessUnivariateStatistic r2 = this.geoMeanImpl;
        if (r2 == this.geoMean) goto L11;
        r2.increment(r3);
    L11:
        this.n++;
    }

    public void clear() {
        this.n = 0;
        this.minImpl.clear();
        this.maxImpl.clear();
        this.sumImpl.clear();
        this.sumLogImpl.clear();
        this.sumsqImpl.clear();
        this.geoMeanImpl.clear();
        this.secondMoment.clear();
        StorelessUnivariateStatistic r0 = this.meanImpl;
        if (r0 == this.mean) goto L5;
        r0.clear();
    L5:
        StorelessUnivariateStatistic r1 = this.varianceImpl;
        if (r1 == this.variance) goto L9;
        r1.clear();
        return;
    }

    public SummaryStatistics copy() {
        SummaryStatistics r0 = new SummaryStatistics();
        copy(this, r0);
        return r0;
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SummaryStatistics.class) == true) goto L8;
        return false;
    L8:
        SummaryStatistics r10 = (SummaryStatistics) ZeusTransformUtils.preCheckCast(r9, SummaryStatistics.class, "com.obric.memorydata.plugin");
        if (Precision.equalsIncludingNaN(r10.getGeometricMean(), getGeometricMean()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getMax(), getMax()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getMean(), getMean()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getMin(), getMin()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getN(), getN()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getSum(), getSum()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getSumsq(), getSumsq()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r10.getVariance(), getVariance()) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public StorelessUnivariateStatistic getGeoMeanImpl() {
        return this.geoMeanImpl;
    }

    public double getGeometricMean() {
        return this.geoMeanImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.maxImpl.getResult();
    }

    public StorelessUnivariateStatistic getMaxImpl() {
        return this.maxImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.meanImpl.getResult();
    }

    public StorelessUnivariateStatistic getMeanImpl() {
        return this.meanImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.minImpl.getResult();
    }

    public StorelessUnivariateStatistic getMinImpl() {
        return this.minImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.n;
    }

    public double getPopulationVariance() {
        Variance r0 = new Variance(this.secondMoment);
        r0.setBiasCorrected(false);
        return r0.getResult();
    }

    public double getQuadraticMean() {
        long r0 = getN();
        if (r0 > 0) goto L7;
        return Double.NaN;
    L7:
        return FastMath.sqrt(getSumsq() / r0);
    }

    public double getSecondMoment() {
        return this.secondMoment.getResult();
    }

    public double getStandardDeviation() {
        if (getN() > 0) goto L5;
        return Double.NaN;
    L5:
        if (getN() > 1) goto L10;
        return 0.0d;
    L10:
        return FastMath.sqrt(getVariance());
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sumImpl.getResult();
    }

    public StorelessUnivariateStatistic getSumImpl() {
        return this.sumImpl;
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        return this.sumLogImpl;
    }

    public double getSumOfLogs() {
        return this.sumLogImpl.getResult();
    }

    public StatisticalSummary getSummary() {
        return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
    }

    public double getSumsq() {
        return this.sumsqImpl.getResult();
    }

    public StorelessUnivariateStatistic getSumsqImpl() {
        return this.sumsqImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.varianceImpl.getResult();
    }

    public StorelessUnivariateStatistic getVarianceImpl() {
        return this.varianceImpl;
    }

    public int hashCode() {
        return ((((((((((((((((MathUtils.hash(getGeometricMean()) + 31) * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumsq())) * 31) + MathUtils.hash(getVariance());
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.geoMeanImpl = r4;
    }

    public void setMaxImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.maxImpl = r4;
    }

    public void setMeanImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.meanImpl = r4;
    }

    public void setMinImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.minImpl = r4;
    }

    public void setSumImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.sumImpl = r4;
    }

    public void setSumLogImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.sumLogImpl = r4;
        this.geoMean.setSumLogImpl(r4);
    }

    public void setSumsqImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.sumsqImpl = r4;
    }

    public void setVarianceImpl(StorelessUnivariateStatistic r3) {
        StorelessUnivariateStatistic r4 = (StorelessUnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, StorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        checkEmpty();
        this.varianceImpl = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SummaryStatistics:").append("\n");
        r0.append("n: ").append(getN()).append("\n");
        r0.append("min: ").append(getMin()).append("\n");
        r0.append("max: ").append(getMax()).append("\n");
        r0.append("sum: ").append(getSum()).append("\n");
        r0.append("mean: ").append(getMean()).append("\n");
        r0.append("geometric mean: ").append(getGeometricMean()).append("\n");
        r0.append("variance: ").append(getVariance()).append("\n");
        r0.append("population variance: ").append(getPopulationVariance()).append("\n");
        r0.append("second moment: ").append(getSecondMoment()).append("\n");
        r0.append("sum of squares: ").append(getSumsq()).append("\n");
        r0.append("standard deviation: ").append(getStandardDeviation()).append("\n");
        r0.append("sum of logs: ").append(getSumOfLogs()).append("\n");
        return r0.toString();
    }
}
