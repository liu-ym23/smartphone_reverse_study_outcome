package org.apache.commons.math3.stat.descriptive;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    public AbstractUnivariateStatistic() {
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract UnivariateStatistic copy();

    public double evaluate() {
        return evaluate(this.storedData);
    }

    public double evaluate(double[] r3) {
        test(r3, 0, 0);
        return evaluate(r3, 0, r3.length);
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public abstract double evaluate(double[] r1, int r2, int r3);

    public double[] getData() {
        double[] r2 = this.storedData;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public double[] getDataRef() {
        return this.storedData;
    }

    public void setData(double[] r3) {
        if (r3 != null) goto L4;
        double[] r4 = null;
    L5:
        this.storedData = r4;
        return;
    L4:
        r4 = (double[]) ZeusTransformUtils.preCheckCast(r3.clone(), double[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setData(double[] r4, int r5, int r6) {
        if (r4 == null) goto L17;
        if (r5 < 0) goto L15;
        if (r6 < 0) goto L13;
        int r1 = r5 + r6;
        if (r1 > r4.length) goto L11;
        double[] r2 = new double[r6];
        this.storedData = r2;
        System.arraycopy(r4, r5, r2, 0, r6);
        return;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(r1), Integer.valueOf(r4.length), true);
    L13:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r6));
    L15:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(r5));
    L17:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public boolean test(double[] r1, int r2, int r3) {
        return MathArrays.verifyValues(r1, r2, r3, false);
    }

    public boolean test(double[] r1, int r2, int r3, boolean r4) {
        return MathArrays.verifyValues(r1, r2, r3, r4);
    }

    public boolean test(double[] r1, double[] r2, int r3, int r4) {
        return MathArrays.verifyValues(r1, r2, r3, r4, false);
    }

    public boolean test(double[] r1, double[] r2, int r3, int r4, boolean r5) {
        return MathArrays.verifyValues(r1, r2, r3, r4, r5);
    }
}
