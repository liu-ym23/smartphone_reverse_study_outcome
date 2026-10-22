package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Kurtosis extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 2784465764798260919L;
    protected boolean incMoment;
    protected FourthMoment moment;

    public Kurtosis() {
        this.incMoment = true;
        this.moment = new FourthMoment();
    }

    public Kurtosis(FourthMoment r2) {
        this.incMoment = false;
        this.moment = r2;
    }

    public Kurtosis(Kurtosis r1) {
        copy(r1, this);
    }

    public static void copy(Kurtosis r1, Kurtosis r2) {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        r2.setData(r1.getDataRef());
        r2.moment = r1.moment.copy();
        r2.incMoment = r1.incMoment;
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
    public Kurtosis copy() {
        Kurtosis r0 = new Kurtosis();
        copy(this, r0);
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r13, int r14, int r15) {
        if (test(r13, r14, r15) == true) goto L5;
    L11:
        return Double.NaN;
    L5:
        if (r15 <= 3) goto L11;
        Variance r12 = new Variance();
        r12.incrementAll(r13, r14, r15);
        double r0 = r12.moment.m1;
        double r2 = FastMath.sqrt(r12.getResult());
        double r4 = 0.0d;
        int r16 = r14;
    L8:
        if (r16 >= (r14 + r15)) goto L10;
        r4 = r4 + FastMath.pow(r13[r16] - r0, 4.0d);
        r16 = r16 + 1;
        goto L8
    L10:
        double r17 = r15;
        double r1 = (r17 + 1.0d) * r17;
        double r18 = r17 - 1.0d;
        double r6 = r17 - 2.0d;
        double r19 = r17 - 3.0d;
        double r3 = r1 / ((r18 * r6) * r19);
        return (r3 * (r4 / FastMath.pow(r2, 4.0d))) - ((FastMath.pow(r18, 2.0d) * 3.0d) / (r6 * r19));
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.getN() <= 3) goto L11;
        double r0 = this.moment.m2 / (this.moment.n - 1);
        if (this.moment.n > 3) goto L7;
    L10:
        return 0.0d;
    L7:
        if (r0 < 1.0E-19d) goto L10;
        double r2 = this.moment.n;
        double r4 = r2 - 1.0d;
        return ((((r2 + 1.0d) * r2) * this.moment.getResult()) - (((this.moment.m2 * 3.0d) * this.moment.m2) * r4)) / ((((r4 * (r2 - 2.0d)) * (r2 - 3.0d)) * r0) * r0);
    L11:
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double r2) {
        if (this.incMoment == false) goto L6;
        this.moment.increment(r2);
        return;
    }
}
