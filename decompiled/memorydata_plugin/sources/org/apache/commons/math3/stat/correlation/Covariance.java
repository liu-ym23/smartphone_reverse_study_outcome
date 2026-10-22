package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

/* JADX INFO: loaded from: classes6.dex */
public class Covariance {
    private final RealMatrix covarianceMatrix;
    private final int n;

    public Covariance() {
        this.covarianceMatrix = null;
        this.n = 0;
    }

    public double covariance(double[] r18, double[] r19, boolean r20) {
        Mean r2 = new Mean();
        int r3 = r18.length;
        int r5 = 0;
        if (r3 != r19.length) goto L14;
        if (r3 < 2) goto L12;
        double r7 = r2.evaluate(r18);
        double r9 = r2.evaluate(r19);
        double r11 = 0.0d;
    L6:
        if (r5 >= r3) goto L8;
        double r13 = ((r18[r5] - r7) * (r19[r5] - r9)) - r11;
        r5 = r5 + 1;
        r11 = r11 + (r13 / ((double) r5));
        r7 = r7;
        goto L6
    L8:
        if (r20 == true) goto L10;
        return r11;
    L10:
        return r11 * (((double) r3) / ((double) (r3 - 1)));
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(r3), 2});
    L14:
        throw new MathIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(r3), Integer.valueOf(r19.length)});
    }
}
