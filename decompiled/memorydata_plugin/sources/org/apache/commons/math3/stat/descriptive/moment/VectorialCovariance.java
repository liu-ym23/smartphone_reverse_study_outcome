package org.apache.commons.math3.stat.descriptive.moment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class VectorialCovariance implements Serializable {
    private static final long serialVersionUID = 4118372414238930270L;
    private final boolean isBiasCorrected;
    private long n;
    private final double[] productsSums;
    private final double[] sums;

    public VectorialCovariance(int r3, boolean r4) {
        this.sums = new double[r3];
        this.productsSums = new double[(r3 * (r3 + 1)) / 2];
        this.n = 0;
        this.isBiasCorrected = r4;
    }

    public void clear() {
        this.n = 0;
        Arrays.fill(this.sums, 0.0d);
        Arrays.fill(this.productsSums, 0.0d);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, VectorialCovariance.class) == true) goto L8;
        return false;
    L8:
        VectorialCovariance r10 = (VectorialCovariance) ZeusTransformUtils.preCheckCast(r9, VectorialCovariance.class, "com.obric.memorydata.plugin");
        if (this.isBiasCorrected == r10.isBiasCorrected) goto L12;
        return false;
    L12:
        if (this.n == r10.n) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.productsSums, r10.productsSums) == true) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.sums, r10.sums) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public long getN() {
        return this.n;
    }

    public RealMatrix getResult() {
        int r1 = this.sums.length;
        RealMatrix r2 = MatrixUtils.createRealMatrix(r1, r1);
        long r3 = this.n;
        if (r3 > 1) goto L5;
    L14:
        return r2;
    L5:
        if (this.isBiasCorrected == false) goto L7;
        long r5 = r3 - 1;
    L8:
        double r7 = 1.0d / (r3 * r5);
        int r4 = 0;
        int r6 = 0;
    L9:
        if (r4 >= r1) goto L14;
        int r8 = 0;
    L11:
        if (r8 > r4) goto L13;
        int r12 = r6 + 1;
        double r9 = this.n * this.productsSums[r6];
        double[] r10 = this.sums;
        double r11 = (r9 - (r10[r4] * r10[r8])) * r7;
        r2.setEntry(r4, r8, r11);
        r2.setEntry(r8, r4, r11);
        r8 = r8 + 1;
        r6 = r12;
        goto L11
    L13:
        r4 = r4 + 1;
        goto L9
    L7:
        r5 = r3;
        goto L8
    }

    public int hashCode() {
        if (this.isBiasCorrected == false) goto L5;
        int r0 = 1231;
    L6:
        long r2 = this.n;
        return ((((((r0 + 31) * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + Arrays.hashCode(this.productsSums)) * 31) + Arrays.hashCode(this.sums);
    L5:
        r0 = 1237;
        goto L6
    }

    public void increment(double[] r13) {
        if (r13.length != this.sums.length) goto L14;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r13.length) goto L11;
        double[] r3 = this.sums;
        r3[r1] = r3[r1] + r13[r1];
        int r4 = 0;
    L8:
        if (r4 > r1) goto L10;
        double[] r5 = this.productsSums;
        r5[r2] = r5[r2] + (r13[r1] * r13[r4]);
        r4 = r4 + 1;
        r2 = r2 + 1;
        goto L8
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        this.n++;
        return;
    L14:
        throw new DimensionMismatchException(r13.length, this.sums.length);
    }
}
