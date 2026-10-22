package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Variance extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -9111962718267217978L;
    protected boolean incMoment;
    private boolean isBiasCorrected;
    protected SecondMoment moment;

    public Variance() {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
    }

    public Variance(SecondMoment r2) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.incMoment = false;
        this.moment = r2;
    }

    public Variance(Variance r2) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        copy(r2, this);
    }

    public Variance(boolean r2) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
        this.isBiasCorrected = r2;
    }

    public Variance(boolean r2, SecondMoment r3) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.incMoment = false;
        this.moment = r3;
        this.isBiasCorrected = r2;
    }

    public static void copy(Variance r1, Variance r2) {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        r2.setData(r1.getDataRef());
        r2.moment = r1.moment.copy();
        r2.isBiasCorrected = r1.isBiasCorrected;
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
    public Variance copy() {
        Variance r0 = new Variance();
        copy(this, r0);
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public double evaluate(double[] r3) {
        if (r3 == null) goto L7;
        return evaluate(r3, 0, r3.length);
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public double evaluate(double[] r7, double r8) {
        return evaluate(r7, r8, 0, r7.length);
    }

    public double evaluate(double[] r10, double r11, int r13, int r14) {
        double r1 = 0.0d;
        if (test(r10, r13, r14) == true) goto L5;
    L16:
        return Double.NaN;
    L5:
        if (r14 == 1) goto L20;
        if (r14 <= 1) goto L16;
        int r0 = r13;
        double r3 = 0.0d;
    L10:
        if (r0 >= (r13 + r14)) goto L12;
        double r5 = r10[r0] - r11;
        r1 = r1 + (r5 * r5);
        r3 = r3 + r5;
        r0 = r0 + 1;
        goto L10
    L12:
        double r12 = r14;
        double r2 = r1 - ((r3 * r3) / r12);
        if (this.isBiasCorrected == false) goto L19;
        r12 = r12 - 1.0d;
    L19:
        return r2 / r12;
    L20:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r8, int r9, int r10) {
        if (test(r8, r9, r10) == false) goto L9;
        clear();
        if (r10 != 1) goto L7;
        return 0.0d;
    L7:
        if (r10 <= 1) goto L9;
        return evaluate(r8, new Mean().evaluate(r8, r9, r10), r9, r10);
    L9:
        return Double.NaN;
    }

    public double evaluate(double[] r3, double[] r4) {
        return evaluate(r3, r4, 0, r3.length);
    }

    public double evaluate(double[] r8, double[] r9, double r10) {
        return evaluate(r8, r9, r10, 0, r8.length);
    }

    public double evaluate(double[] r19, double[] r20, double r21, int r23, int r24) {
        int r3 = r23;
        double r6 = 0.0d;
        if (test(r19, r20, r3, r24) == true) goto L5;
    L18:
        return Double.NaN;
    L5:
        if (r24 == 1) goto L23;
        if (r24 <= 1) goto L18;
        int r5 = r3;
        double r8 = 0.0d;
        double r10 = 0.0d;
    L9:
        int r12 = r3 + r24;
        if (r5 >= r12) goto L12;
        double r13 = r19[r5] - r21;
        r8 = r8 + (r20[r5] * (r13 * r13));
        r10 = r10 + (r20[r5] * r13);
        r5 = r5 + 1;
    L12:
        if (r3 >= r12) goto L14;
        r6 = r6 + r20[r3];
        r3 = r3 + 1;
        goto L12
    L14:
        double r9 = r8 - ((r10 * r10) / r6);
        if (this.isBiasCorrected == false) goto L22;
        r6 = r6 - 1.0d;
    L22:
        return r9 / r6;
    L23:
        return 0.0d;
    }

    public double evaluate(double[] r9, double[] r10, int r11, int r12) {
        if (test(r9, r10, r11, r12) == false) goto L9;
        clear();
        if (r12 != 1) goto L7;
        return 0.0d;
    L7:
        if (r12 <= 1) goto L9;
        return evaluate(r9, r10, new Mean().evaluate(r9, r10, r11, r12), r11, r12);
    L9:
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.n != 0) goto L7;
        return Double.NaN;
    L7:
        if (this.moment.n != 1) goto L11;
        return 0.0d;
    L11:
        if (this.isBiasCorrected == false) goto L15;
        double r0 = this.moment.m2;
        double r2 = this.moment.n - 1.0d;
    L14:
        return r0 / r2;
    L15:
        r0 = this.moment.m2;
        r2 = this.moment.n;
        goto L14
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double r2) {
        if (this.incMoment == false) goto L6;
        this.moment.increment(r2);
        return;
    }

    public boolean isBiasCorrected() {
        return this.isBiasCorrected;
    }

    public void setBiasCorrected(boolean r1) {
        this.isBiasCorrected = r1;
    }
}
