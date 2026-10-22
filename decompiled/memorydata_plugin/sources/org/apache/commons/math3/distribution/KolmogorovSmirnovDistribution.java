package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.fraction.FractionConversionException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class KolmogorovSmirnovDistribution implements Serializable {
    private static final long serialVersionUID = -4670676796862967187L;
    private int n;

    public KolmogorovSmirnovDistribution(int r2) {
        if (r2 <= 0) goto L7;
        this.n = r2;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(r2));
    }

    private FieldMatrix<BigFraction> createH(double r14) {
        int r0 = (int) FastMath.ceil(((double) this.n) * r14);
        int r1 = (r0 * 2) - 1;
        double r13 = ((double) r0) - (((double) this.n) * r14);
        if (r13 >= 1.0d) goto L43;
        BigFraction r15 = new BigFraction(r13, 1.0E-20d, 10000);     // Catch: FractionConversionException -> L6
    L9:
        BigFraction[][] r16 = (BigFraction[][]) Array.newInstance(BigFraction.class, new int[]{r1, r1});
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L19;
        int r4 = 0;
    L12:
        if (r4 >= r1) goto L18;
        if (((r3 - r4) + 1) >= 0) goto L16;
        r16[r3][r4] = BigFraction.ZERO;
    L17:
        r4 = r4 + 1;
        goto L12
    L16:
        r16[r3][r4] = BigFraction.ONE;
        goto L17
    L18:
        r3 = r3 + 1;
        goto L10
    L19:
        BigFraction[] r5 = new BigFraction[r1];
        r5[0] = r15;
        int r6 = 1;
    L20:
        if (r6 >= r1) goto L22;
        r5[r6] = r15.multiply2(r5[r6 - 1]);
        r6 = r6 + 1;
        goto L20
    L22:
        int r7 = 0;
    L23:
        if (r7 >= r1) goto L26;
        r16[r7][0] = r16[r7][0].subtract2(r5[r7]);
        int r8 = r1 - 1;
        r16[r8][r7] = r16[r8][r7].subtract2(r5[(r1 - r7) - 1]);
        r7 = r7 + 1;
        goto L23
    L26:
        if (r15.compareTo2(BigFraction.ONE_HALF) != 1) goto L28;
        int r9 = r1 - 1;
        r16[r9][0] = r16[r9][0].add2(r15.multiply2(2).subtract(1).pow(r1));
    L28:
        int r17 = 0;
    L29:
        if (r17 >= r1) goto L41;
        int r10 = 0;
    L31:
        int r11 = r17 + 1;
        if (r10 >= r11) goto L39;
        int r12 = (r17 - r10) + 1;
        if (r12 <= 0) goto L38;
        int r18 = 2;
    L36:
        if (r18 > r12) goto L38;
        r16[r17][r10] = r16[r17][r10].divide(r18);
        r18 = r18 + 1;
    L38:
        r10 = r10 + 1;
        goto L31
    L39:
        r17 = r11;
        goto L29
    L41:
        return new Array2DRowFieldMatrix(BigFractionField.getInstance(), r16);
    L6:
        r15 = new BigFraction(r13, 1.0E-10d, 10000);     // Catch: FractionConversionException -> L8
    L8:
        r15 = new BigFraction(r13, 1.0E-5d, 10000);
        goto L9
    L43:
        throw new NumberIsTooLargeException(Double.valueOf(r13), Double.valueOf(1.0d), false);
    }

    private double exactK(double r3) {
        int r0 = (int) FastMath.ceil(((double) this.n) * r3);
        FieldMatrix<T> r4 = createH(r3).power(this.n);
        int r5 = 1;
        int r1 = r0 - 1;
        BigFraction r6 = (BigFraction) ZeusTransformUtils.preCheckCast(r4.getEntry(r1, r1), BigFraction.class, "com.obric.memorydata.plugin");
    L4:
        if (r5 > this.n) goto L7;
        r6 = r6.multiply2(r5).divide(this.n);
        r5 = r5 + 1;
        goto L4
    L7:
        return r6.bigDecimalValue(20, 4).doubleValue();
    }

    private double roundedK(double r9) {
        int r0 = (int) FastMath.ceil(((double) this.n) * r9);
        FieldMatrix<BigFraction> r10 = createH(r9);
        int r11 = r10.getRowDimension();
        Array2DRowRealMatrix r1 = new Array2DRowRealMatrix(r11, r11);
        int r3 = 0;
    L3:
        if (r3 >= r11) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r11) goto L7;
        r1.setEntry(r3, r4, ((BigFraction) ZeusTransformUtils.preCheckCast(r10.getEntry(r3, r4), BigFraction.class, "com.obric.memorydata.plugin")).doubleValue());
        r4 = r4 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        int r12 = 1;
        int r2 = r0 - 1;
        double r5 = r1.power(this.n).getEntry(r2, r2);
    L9:
        int r13 = this.n;
        if (r12 > r13) goto L12;
        r5 = r5 * (((double) r12) / ((double) r13));
        r12 = r12 + 1;
        goto L9
    L12:
        return r5;
    }

    public double cdf(double r2) {
        return cdf(r2, false);
    }

    public double cdf(double r9, boolean r11) {
        int r0 = this.n;
        double r3 = 1.0d;
        double r1 = 1.0d / ((double) r0);
        double r5 = 0.5d * r1;
        if (r9 > r5) goto L7;
        return 0.0d;
    L7:
        if (r5 >= r9) goto L16;
        if (r9 > r1) goto L16;
        double r10 = (r9 * 2.0d) - r1;
        int r12 = 1;
    L12:
        if (r12 > this.n) goto L14;
        r3 = r3 * (((double) r12) * r10);
        r12 = r12 + 1;
        goto L12
    L14:
        return r3;
    L16:
        if ((1.0d - r1) > r9) goto L22;
        if (r9 >= 1.0d) goto L22;
        return 1.0d - (FastMath.pow(1.0d - r9, r0) * 2.0d);
    L22:
        if (1.0d > r9) goto L24;
        return 1.0d;
    L24:
        if (r11 == false) goto L27;
        return exactK(r9);
    L27:
        return roundedK(r9);
    }

    public double cdfExact(double r2) {
        return cdf(r2, true);
    }
}
