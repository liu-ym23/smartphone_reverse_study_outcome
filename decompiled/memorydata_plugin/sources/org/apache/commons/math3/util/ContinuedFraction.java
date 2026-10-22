package org.apache.commons.math3.util;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ContinuedFraction {
    public ContinuedFraction() {
    }

    public double evaluate(double r26, double r28, int r30) {
        double r11 = getA(0, r26);
        if (Precision.equals(r11, 0.0d, 1.0E-50d) == false) goto L5;
        r11 = 1.0E-50d;
    L5:
        double r8 = 0.0d;
        int r10 = 1;
        double r13 = r11;
    L6:
        if (r10 >= r30) goto L26;
        double r15 = getA(r10, r26);
        double r17 = getB(r10, r26);
        double r9 = (r8 * r17) + r15;
        if (Precision.equals(r9, 0.0d, 1.0E-50d) == false) goto L10;
        r9 = 1.0E-50d;
    L10:
        double r16 = r15 + (r17 / r11);
        if (Precision.equals(r16, 0.0d, 1.0E-50d) == false) goto L13;
        r11 = 1.0E-50d;
    L14:
        r8 = 1.0d / r9;
        double r18 = r11 * r8;
        r13 = r13 * r18;
        if (Double.isInfinite(r13) == true) goto L25;
        if (Double.isNaN(r13) == true) goto L23;
        if (FastMath.abs(r18 - 1.0d) < r28) goto L26;
        r10 = r10 + 1;
        goto L6
    L23:
        throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_NAN_DIVERGENCE, new Object[]{Double.valueOf(r26)});
    L25:
        throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE, new Object[]{Double.valueOf(r26)});
    L13:
        r11 = r16;
    L26:
        if (r10 >= r30) goto L29;
        return r13;
    L29:
        throw new MaxCountExceededException(LocalizedFormats.NON_CONVERGENT_CONTINUED_FRACTION, Integer.valueOf(r30), new Object[]{Double.valueOf(r26)});
    }

    public abstract double getA(int r1, double r2);

    public abstract double getB(int r1, double r2);
}
