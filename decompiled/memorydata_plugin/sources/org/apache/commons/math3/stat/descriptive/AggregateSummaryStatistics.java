package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class AggregateSummaryStatistics implements Serializable, StatisticalSummary {
    private static final long serialVersionUID = -8207112444016386906L;
    private final SummaryStatistics statistics;
    private final SummaryStatistics statisticsPrototype;

    private static class AggregatingSummaryStatistics extends SummaryStatistics {
        private static final long serialVersionUID = 1;
        private final SummaryStatistics aggregateStatistics;

        AggregatingSummaryStatistics(SummaryStatistics r1) {
            this.aggregateStatistics = r1;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public void addValue(double r2) {
            super.addValue(r2);
            SummaryStatistics r0 = this.aggregateStatistics;
            monitor-enter(r0);
            this.aggregateStatistics.addValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AggregatingSummaryStatistics.class) == true) goto L8;
            return false;
        L8:
            AggregatingSummaryStatistics r6 = (AggregatingSummaryStatistics) ZeusTransformUtils.preCheckCast(r5, AggregatingSummaryStatistics.class, "com.obric.memorydata.plugin");
            if (super.equals(r6) == false) goto L14;
            if (this.aggregateStatistics.equals(r6.aggregateStatistics) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // org.apache.commons.math3.stat.descriptive.SummaryStatistics
        public int hashCode() {
            return (super.hashCode() + 123) + this.aggregateStatistics.hashCode();
        }
    }

    public AggregateSummaryStatistics() {
        this(new SummaryStatistics());
    }

    public AggregateSummaryStatistics(SummaryStatistics r2) {
        if (r2 != null) goto L4;
        SummaryStatistics r0 = null;
    L5:
        this(r2, r0);
        return;
    L4:
        r0 = new SummaryStatistics(r2);
        goto L5
    }

    public AggregateSummaryStatistics(SummaryStatistics r1, SummaryStatistics r2) {
        if (r1 != null) goto L5;
        r1 = new SummaryStatistics();
    L5:
        this.statisticsPrototype = r1;
        if (r2 != null) goto L8;
        r2 = new SummaryStatistics();
    L8:
        this.statistics = r2;
    }

    public static StatisticalSummaryValues aggregate(Collection<? extends StatisticalSummary> r30) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r30, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterator r1 = r0.iterator();
        if (r1.hasNext() == true) goto L8;
        return null;
    L8:
        StatisticalSummary r2 = (StatisticalSummary) ZeusTransformUtils.preCheckCast(r1.next(), StatisticalSummary.class, "com.obric.memorydata.plugin");
        long r3 = r2.getN();
        double r5 = r2.getMin();
        double r7 = r2.getSum();
        double r9 = r2.getMax();
        double r11 = r2.getVariance() * (r3 - 1.0d);
        double r26 = r5;
        double r28 = r7;
        double r24 = r9;
        double r18 = r2.getMean();
    L10:
        if (r1.hasNext() == false) goto L23;
        StatisticalSummary r4 = (StatisticalSummary) ZeusTransformUtils.preCheckCast(r1.next(), StatisticalSummary.class, "com.obric.memorydata.plugin");
        if (r4.getMin() >= r26) goto L14;
    L15:
        r26 = r4.getMin();
    L17:
        if (r4.getMax() <= r24) goto L19;
    L20:
        r24 = r4.getMax();
    L21:
        r28 = r28 + r4.getSum();
        double r6 = r3;
        double r8 = r4.getN();
        long r10 = (long) (r6 + r8);
        double r12 = r4.getMean() - r18;
        double r13 = r10;
        r18 = r28 / r13;
        r11 = (r11 + (r4.getVariance() * (r8 - 1.0d))) + ((((r12 * r12) * r6) * r8) / r13);
        r3 = r10;
        goto L10
    L19:
        if (Double.isNaN(r24) == false) goto L21;
    L14:
        if (Double.isNaN(r26) == false) goto L17;
    L23:
        if (r3 != 0) goto L27;
        double r14 = Double.NaN;
    L25:
        double r20 = r14;
    L31:
        return new StatisticalSummaryValues(r18, r20, r3, r24, r26, r28);
    L27:
        if (r3 != 1) goto L29;
        r14 = 0.0d;
        goto L25
    L29:
        r20 = r11 / (r3 - 1);
        goto L31
    }

    public SummaryStatistics createContributingStatistics() {
        AggregatingSummaryStatistics r0 = new AggregatingSummaryStatistics(this.statistics);
        SummaryStatistics.copy(this.statisticsPrototype, r0);
        return r0;
    }

    public double getGeometricMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getGeometricMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMax();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMean();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getMin();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        long r1 = this.statistics.getN();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSecondMoment() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSecondMoment();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getStandardDeviation() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getStandardDeviation();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSum();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumOfLogs() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumOfLogs();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public StatisticalSummary getSummary() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        StatisticalSummaryValues r14 = new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    public double getSumsq() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getSumsq();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        SummaryStatistics r0 = this.statistics;
        monitor-enter(r0);
        double r1 = this.statistics.getVariance();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
