package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/* JADX INFO: loaded from: classes6.dex */
public class PearsonsCorrelation {
    private final RealMatrix correlationMatrix;
    private final int nObs;

    public PearsonsCorrelation() {
        this.correlationMatrix = null;
        this.nObs = 0;
    }

    public double correlation(double[] r7, double[] r8) {
        SimpleRegression r6 = new SimpleRegression();
        if (r7.length != r8.length) goto L14;
        int r1 = 0;
        if (r7.length < 2) goto L12;
    L7:
        if (r1 >= r7.length) goto L10;
        r6.addData(r7[r1], r8[r1]);
        r1 = r1 + 1;
        goto L7
    L10:
        return r6.getR();
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(r7.length), 2});
    L14:
        throw new DimensionMismatchException(r7.length, r8.length);
    }
}
