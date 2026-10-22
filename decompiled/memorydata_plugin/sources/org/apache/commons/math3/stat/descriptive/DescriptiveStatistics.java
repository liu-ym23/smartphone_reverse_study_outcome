package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.ResizableDoubleArray;

/* JADX INFO: loaded from: classes6.dex */
public class DescriptiveStatistics implements Serializable, StatisticalSummary {
    public static final int INFINITE_WINDOW = -1;
    private static final String SET_QUANTILE_METHOD_NAME = "setQuantile";
    private static final long serialVersionUID = 4133067267405273064L;
    private ResizableDoubleArray eDA;
    private UnivariateStatistic geometricMeanImpl;
    private UnivariateStatistic kurtosisImpl;
    private UnivariateStatistic maxImpl;
    private UnivariateStatistic meanImpl;
    private UnivariateStatistic minImpl;
    private UnivariateStatistic percentileImpl;
    private UnivariateStatistic skewnessImpl;
    private UnivariateStatistic sumImpl;
    private UnivariateStatistic sumsqImpl;
    private UnivariateStatistic varianceImpl;
    protected int windowSize;

    public DescriptiveStatistics() {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
    }

    public DescriptiveStatistics(int r2) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        setWindowSize(r2);
    }

    public DescriptiveStatistics(DescriptiveStatistics r2) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        copy(r2, this);
    }

    public DescriptiveStatistics(double[] r2) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        if (r2 == null) goto L6;
        this.eDA = new ResizableDoubleArray(r2);
        return;
    }

    public static void copy(DescriptiveStatistics r1, DescriptiveStatistics r2) {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        r2.eDA = r1.eDA.copy();
        r2.windowSize = r1.windowSize;
        r2.maxImpl = r1.maxImpl.copy();
        r2.meanImpl = r1.meanImpl.copy();
        r2.minImpl = r1.minImpl.copy();
        r2.sumImpl = r1.sumImpl.copy();
        r2.varianceImpl = r1.varianceImpl.copy();
        r2.sumsqImpl = r1.sumsqImpl.copy();
        r2.geometricMeanImpl = r1.geometricMeanImpl.copy();
        r2.kurtosisImpl = r1.kurtosisImpl;
        r2.skewnessImpl = r1.skewnessImpl;
        r2.percentileImpl = r1.percentileImpl;
    }

    public void addValue(double r5) {
        if (this.windowSize != (-1)) goto L5;
    L9:
        this.eDA.addElement(r5);
        return;
    L5:
        if (getN() != this.windowSize) goto L8;
        this.eDA.addElementRolling(r5);
        return;
    L8:
        if (getN() < this.windowSize) goto L9;
    }

    public double apply(UnivariateStatistic r3) {
        UnivariateStatistic r4 = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");
        return this.eDA.compute(r4);
    }

    public void clear() {
        this.eDA.clear();
    }

    public DescriptiveStatistics copy() {
        DescriptiveStatistics r0 = new DescriptiveStatistics();
        copy(this, r0);
        return r0;
    }

    public double getElement(int r1) {
        return this.eDA.getElement(r1);
    }

    public double getGeometricMean() {
        return apply(this.geometricMeanImpl);
    }

    public synchronized UnivariateStatistic getGeometricMeanImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.geometricMeanImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double getKurtosis() {
        return apply(this.kurtosisImpl);
    }

    public synchronized UnivariateStatistic getKurtosisImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.kurtosisImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return apply(this.maxImpl);
    }

    public synchronized UnivariateStatistic getMaxImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.maxImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return apply(this.meanImpl);
    }

    public synchronized UnivariateStatistic getMeanImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.meanImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return apply(this.minImpl);
    }

    public synchronized UnivariateStatistic getMinImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.minImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.eDA.getNumElements();
    }

    public double getPercentile(double r8) {
        if (ZeusTransformUtils.instanceOf(this.percentileImpl, Percentile.class) == false) goto L16;
        ((Percentile) ZeusTransformUtils.preCheckCast(this.percentileImpl, Percentile.class, "com.obric.memorydata.plugin")).setQuantile(r8);
    L8:
        return apply(this.percentileImpl);
    L16:
        this.percentileImpl.getClass().getMethod(SET_QUANTILE_METHOD_NAME, new Class[]{Double.TYPE}).invoke(this.percentileImpl, new Object[]{Double.valueOf(r8)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12 NoSuchMethodException -> L14
    L9:
        e = move-exception;
        throw new IllegalStateException(e.getCause());
    L13:
        throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, new Object[]{SET_QUANTILE_METHOD_NAME, this.percentileImpl.getClass().getName()});
    L15:
        throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, new Object[]{this.percentileImpl.getClass().getName(), SET_QUANTILE_METHOD_NAME});
    }

    public synchronized UnivariateStatistic getPercentileImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.percentileImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double getPopulationVariance() {
        return apply(new Variance(false));
    }

    public double getQuadraticMean() {
        long r0 = getN();
        if (r0 > 0) goto L7;
        return Double.NaN;
    L7:
        return FastMath.sqrt(getSumsq() / r0);
    }

    public double getSkewness() {
        return apply(this.skewnessImpl);
    }

    public synchronized UnivariateStatistic getSkewnessImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.skewnessImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double[] getSortedValues() {
        double[] r0 = getValues();
        Arrays.sort(r0);
        return r0;
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
        return apply(this.sumImpl);
    }

    public synchronized UnivariateStatistic getSumImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.sumImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double getSumsq() {
        return apply(this.sumsqImpl);
    }

    public synchronized UnivariateStatistic getSumsqImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.sumsqImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double[] getValues() {
        return this.eDA.getElements();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return apply(this.varianceImpl);
    }

    public synchronized UnivariateStatistic getVarianceImpl() {
        monitor-enter(this);
        UnivariateStatistic r0 = this.varianceImpl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    public void removeMostRecentValue() {
        this.eDA.discardMostRecentElements(1);     // Catch: MathIllegalArgumentException -> L4
        return;
    L5:
        throw new MathIllegalStateException(LocalizedFormats.NO_DATA, new Object[0]);
    }

    public double replaceMostRecentValue(double r1) {
        return this.eDA.substituteMostRecentElement(r1);
    }

    public synchronized void setGeometricMeanImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.geometricMeanImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setKurtosisImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.kurtosisImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setMaxImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.maxImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setMeanImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.meanImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setMinImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.minImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setPercentileImpl(UnivariateStatistic r8) {
        monitor-enter(this);
        UnivariateStatistic r9 = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r8, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r9.getClass().getMethod(SET_QUANTILE_METHOD_NAME, new Class[]{Double.TYPE}).invoke(r9, new Object[]{Double.valueOf(50.0d)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L12 NoSuchMethodException -> L14 Throwable -> L16
        this.percentileImpl = r9;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e.getCause());     // Catch: Throwable -> L16
    L13:
        throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, new Object[]{SET_QUANTILE_METHOD_NAME, r9.getClass().getName()});     // Catch: Throwable -> L16
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, new Object[]{r9.getClass().getName(), SET_QUANTILE_METHOD_NAME});     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void setSkewnessImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.skewnessImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setSumImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.sumImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setSumsqImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.sumsqImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setVarianceImpl(UnivariateStatistic r3) {
        monitor-enter(this);
        this.varianceImpl = (UnivariateStatistic) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateStatistic.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setWindowSize(int r4) {
        if (r4 >= 1) goto L8;
        if (r4 == (-1)) goto L8;
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_WINDOW_SIZE, new Object[]{Integer.valueOf(r4)});
    L8:
        this.windowSize = r4;
        if (r4 != (-1)) goto L11;
        return;
    L11:
        if (r4 >= this.eDA.getNumElements()) goto L15;
        ResizableDoubleArray r3 = this.eDA;
        r3.discardFrontElements(r3.getNumElements() - r4);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DescriptiveStatistics:").append("\n");
        r0.append("n: ").append(getN()).append("\n");
        r0.append("min: ").append(getMin()).append("\n");
        r0.append("max: ").append(getMax()).append("\n");
        r0.append("mean: ").append(getMean()).append("\n");
        r0.append("std dev: ").append(getStandardDeviation()).append("\n");
        r0.append("median: ").append(getPercentile(50.0d)).append("\n");     // Catch: MathIllegalStateException -> L5
    L6:
        r0.append("skewness: ").append(getSkewness()).append("\n");
        r0.append("kurtosis: ").append(getKurtosis()).append("\n");
        return r0.toString();
    L5:
        r0.append("median: unavailable").append("\n");
        goto L6
    }
}
