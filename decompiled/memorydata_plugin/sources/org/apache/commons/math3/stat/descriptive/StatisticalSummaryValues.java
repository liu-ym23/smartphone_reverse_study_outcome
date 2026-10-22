package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class StatisticalSummaryValues implements Serializable, StatisticalSummary {
    private static final long serialVersionUID = -5108854841843722536L;
    private final double max;
    private final double mean;
    private final double min;
    private final long n;
    private final double sum;
    private final double variance;

    public StatisticalSummaryValues(double r1, double r3, long r5, double r7, double r9, double r11) {
        this.mean = r1;
        this.variance = r3;
        this.n = r5;
        this.max = r7;
        this.min = r9;
        this.sum = r11;
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, StatisticalSummaryValues.class) == true) goto L8;
        return false;
    L8:
        StatisticalSummaryValues r10 = (StatisticalSummaryValues) ZeusTransformUtils.preCheckCast(r9, StatisticalSummaryValues.class, "com.obric.memorydata.plugin");
        if (Precision.equalsIncludingNaN(r10.getMax(), getMax()) == false) goto L22;
        if (Precision.equalsIncludingNaN(r10.getMean(), getMean()) == false) goto L22;
        if (Precision.equalsIncludingNaN(r10.getMin(), getMin()) == false) goto L22;
        if (Precision.equalsIncludingNaN(r10.getN(), getN()) == false) goto L22;
        if (Precision.equalsIncludingNaN(r10.getSum(), getSum()) == false) goto L22;
        if (Precision.equalsIncludingNaN(r10.getVariance(), getVariance()) == false) goto L22;
        return true;
    L22:
        return false;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.max;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.min;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.n;
    }

    public double getStandardDeviation() {
        return FastMath.sqrt(this.variance);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sum;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.variance;
    }

    public int hashCode() {
        return ((((((((((MathUtils.hash(getMax()) + 31) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getVariance());
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append("StatisticalSummaryValues:").append("\n");
        r0.append("n: ").append(getN()).append("\n");
        r0.append("min: ").append(getMin()).append("\n");
        r0.append("max: ").append(getMax()).append("\n");
        r0.append("mean: ").append(getMean()).append("\n");
        r0.append("std dev: ").append(getStandardDeviation()).append("\n");
        r0.append("variance: ").append(getVariance()).append("\n");
        r0.append("sum: ").append(getSum()).append("\n");
        return r0.toString();
    }
}
