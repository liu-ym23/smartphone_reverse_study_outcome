package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractStorelessUnivariateStatistic extends AbstractUnivariateStatistic implements StorelessUnivariateStatistic {
    public AbstractStorelessUnivariateStatistic() {
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void clear();

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract StorelessUnivariateStatistic copy();

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AbstractStorelessUnivariateStatistic.class) == true) goto L8;
        return false;
    L8:
        AbstractStorelessUnivariateStatistic r10 = (AbstractStorelessUnivariateStatistic) ZeusTransformUtils.preCheckCast(r9, AbstractStorelessUnivariateStatistic.class, "com.obric.memorydata.plugin");
        if (Precision.equalsIncludingNaN(r10.getResult(), getResult()) == false) goto L14;
        if (Precision.equalsIncludingNaN(r10.getN(), getN()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public double evaluate(double[] r3) {
        if (r3 == null) goto L7;
        return evaluate(r3, 0, r3.length);
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r2, int r3, int r4) {
        if (test(r2, r3, r4) == false) goto L6;
        clear();
        incrementAll(r2, r3, r4);
    L6:
        return getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract double getResult();

    public int hashCode() {
        return ((MathUtils.hash(getResult()) + 31) * 31) + MathUtils.hash(getN());
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void increment(double r1);

    public void incrementAll(double[] r3) {
        if (r3 == null) goto L7;
        incrementAll(r3, 0, r3.length);
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public void incrementAll(double[] r3, int r4, int r5) {
        if (test(r3, r4, r5) == false) goto L7;
        int r6 = r5 + r4;
    L5:
        if (r4 >= r6) goto L9;
        increment(r3[r4]);
        r4 = r4 + 1;
        goto L5
    L9:
        return;
    }
}
