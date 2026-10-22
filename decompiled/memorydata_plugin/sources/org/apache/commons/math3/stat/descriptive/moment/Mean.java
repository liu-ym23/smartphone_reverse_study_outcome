package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Mean extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -1296043746617791564L;
    protected boolean incMoment;
    protected FirstMoment moment;

    public Mean() {
        this.incMoment = true;
        this.moment = new FirstMoment();
    }

    public Mean(FirstMoment r1) {
        this.moment = r1;
        this.incMoment = false;
    }

    public Mean(Mean r1) {
        copy(r1, this);
    }

    public static void copy(Mean r1, Mean r2) {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        r2.setData(r1.getDataRef());
        r2.incMoment = r1.incMoment;
        r2.moment = r1.moment.copy();
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
    public Mean copy() {
        Mean r0 = new Mean();
        copy(this, r0);
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r9, int r10, int r11) {
        if (test(r9, r10, r11) == false) goto L10;
        double r0 = r11;
        double r2 = new Sum().evaluate(r9, r10, r11) / r0;
        double r4 = 0.0d;
        int r8 = r10;
    L6:
        if (r8 >= (r10 + r11)) goto L9;
        r4 = r4 + (r9[r8] - r2);
        r8 = r8 + 1;
        goto L6
    L9:
        return r2 + (r4 / r0);
    L10:
        return Double.NaN;
    }

    public double evaluate(double[] r3, double[] r4) {
        return evaluate(r3, r4, 0, r3.length);
    }

    public double evaluate(double[] r11, double[] r12, int r13, int r14) {
        if (test(r11, r12, r13, r14) == false) goto L10;
        Sum r10 = new Sum();
        double r0 = r10.evaluate(r12, r13, r14);
        double r2 = r10.evaluate(r11, r12, r13, r14) / r0;
        double r4 = 0.0d;
        int r15 = r13;
    L6:
        if (r15 >= (r13 + r14)) goto L9;
        r4 = r4 + (r12[r15] * (r11[r15] - r2));
        r15 = r15 + 1;
        goto L6
    L9:
        return r2 + (r4 / r0);
    L10:
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.moment.m1;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double r2) {
        if (this.incMoment == false) goto L6;
        this.moment.increment(r2);
        return;
    }
}
