package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Skewness extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 7101857578996691352L;
    protected boolean incMoment;
    protected ThirdMoment moment;

    public Skewness() {
        this.moment = null;
        this.incMoment = true;
        this.moment = new ThirdMoment();
    }

    public Skewness(Skewness r2) {
        this.moment = null;
        copy(r2, this);
    }

    public Skewness(ThirdMoment r2) {
        this.moment = null;
        this.incMoment = false;
        this.moment = r2;
    }

    public static void copy(Skewness r2, Skewness r3) {
        MathUtils.checkNotNull(r2);
        MathUtils.checkNotNull(r3);
        r3.setData(r2.getDataRef());
        r3.moment = new ThirdMoment(r2.moment.copy());
        r3.incMoment = r2.incMoment;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment == false) goto L6;
        this.moment.clear();
        return;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ StorelessUnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Skewness copy() {
        Skewness r0 = new Skewness();
        copy(this, r0);
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r18, int r19, int r20) {
        int r1 = r19;
        if (test(r18, r19, r20) == true) goto L5;
    L14:
        return Double.NaN;
    L5:
        if (r20 <= 2) goto L14;
        double r3 = new Mean().evaluate(r18, r1, r20);
        double r5 = 0.0d;
        int r7 = r1;
        double r8 = 0.0d;
        double r10 = 0.0d;
    L7:
        int r12 = r1 + r20;
        if (r7 >= r12) goto L10;
        double r13 = r18[r7] - r3;
        r8 = r8 + (r13 * r13);
        r10 = r10 + r13;
        r7 = r7 + 1;
        goto L7
    L10:
        double r14 = r20;
        double r9 = (r8 - ((r10 * r10) / r14)) / ((double) (r20 - 1));
    L11:
        if (r1 >= r12) goto L18;
        double r11 = r18[r1] - r3;
        r5 = r5 + ((r11 * r11) * r11);
        r1 = r1 + 1;
        goto L11
    L18:
        return (r14 / ((r14 - 1.0d) * (r14 - 2.0d))) * (r5 / (r9 * FastMath.sqrt(r9)));
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.n >= 3) goto L6;
        return Double.NaN;
    L6:
        double r0 = this.moment.m2 / (this.moment.n - 1);
        if (r0 >= 1.0E-19d) goto L10;
        return 0.0d;
    L10:
        double r2 = this.moment.getN();
        return (this.moment.m3 * r2) / ((((r2 - 1.0d) * (r2 - 2.0d)) * FastMath.sqrt(r0)) * r0);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double r2) {
        if (this.incMoment == false) goto L6;
        this.moment.increment(r2);
        return;
    }
}
