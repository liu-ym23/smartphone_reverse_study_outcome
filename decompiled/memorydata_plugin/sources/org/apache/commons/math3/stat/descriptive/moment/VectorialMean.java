package org.apache.commons.math3.stat.descriptive.moment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class VectorialMean implements Serializable {
    private static final long serialVersionUID = 8223009086481006892L;
    private final Mean[] means;

    public VectorialMean(int r4) {
        this.means = new Mean[r4];
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.means[r0] = new Mean();
        r0 = r0 + 1;
        goto L3
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VectorialMean.class) == true) goto L8;
        return false;
    L8:
        VectorialMean r6 = (VectorialMean) ZeusTransformUtils.preCheckCast(r5, VectorialMean.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(this.means, r6.means) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public long getN() {
        Mean[] r2 = this.means;
        if (r2.length != 0) goto L6;
        return 0;
    L6:
        return r2[0].getN();
    }

    public double[] getResult() {
        int r0 = this.means.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.means[r2].getResult();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.means);
    }

    public void increment(double[] r5) {
        if (r5.length != this.means.length) goto L10;
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L8;
        this.means[r0].increment(r5[r0]);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new DimensionMismatchException(r5.length, this.means.length);
    }
}
