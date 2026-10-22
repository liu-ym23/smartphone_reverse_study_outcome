package org.apache.commons.math3.transform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FastHadamardTransformer implements Serializable {
    static final long serialVersionUID = 20120211;

    public FastHadamardTransformer() {
    }

    public double[] fht(double[] r13) {
        int r12 = r13.length;
        int r0 = r12 / 2;
        if (ArithmeticUtils.isPowerOfTwo(r12) == false) goto L16;
        double[] r1 = new double[r12];
        double[] r14 = (double[]) ZeusTransformUtils.preCheckCast(r13.clone(), double[].class, "com.obric.memorydata.plugin");
        int r4 = 1;
    L5:
        double[] r11 = r1;
        r1 = r14;
        r14 = r11;
        if (r4 >= r12) goto L14;
        int r5 = 0;
    L8:
        if (r5 >= r0) goto L10;
        int r6 = r5 * 2;
        r14[r5] = r1[r6] + r1[r6 + 1];
        r5 = r5 + 1;
        goto L8
    L10:
        int r7 = r0;
    L11:
        if (r7 >= r12) goto L13;
        int r8 = (r7 * 2) - r12;
        r14[r7] = r1[r8] - r1[r8 + 1];
        r7 = r7 + 1;
        goto L11
    L13:
        r4 = r4 << 1;
        goto L5
    L14:
        return r1;
    L16:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, new Object[]{Integer.valueOf(r12)});
    }

    public int[] fht(int[] r10) {
        int r9 = r10.length;
        int r0 = r9 / 2;
        if (ArithmeticUtils.isPowerOfTwo(r9) == false) goto L16;
        int[] r1 = new int[r9];
        int[] r11 = (int[]) ZeusTransformUtils.preCheckCast(r10.clone(), int[].class, "com.obric.memorydata.plugin");
        int r4 = 1;
    L5:
        int[] r8 = r1;
        r1 = r11;
        r11 = r8;
        if (r4 >= r9) goto L14;
        int r5 = 0;
    L8:
        if (r5 >= r0) goto L10;
        int r6 = r5 * 2;
        r11[r5] = r1[r6] + r1[r6 + 1];
        r5 = r5 + 1;
        goto L8
    L10:
        int r7 = r0;
    L11:
        if (r7 >= r9) goto L13;
        int r12 = (r7 * 2) - r9;
        r11[r7] = r1[r12] - r1[r12 + 1];
        r7 = r7 + 1;
        goto L11
    L13:
        r4 = r4 << 1;
        goto L5
    L14:
        return r1;
    L16:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, new Object[]{Integer.valueOf(r9)});
    }

    public double[] transform(UnivariateFunction r7, double r8, double r10, int r12, TransformType r13) {
        return transform(FunctionUtils.sample((UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r7, UnivariateFunction.class, "com.obric.memorydata.plugin"), r8, r10, r12), r13);
    }

    public double[] transform(double[] r3, TransformType r4) {
        TransformType r0 = TransformType.FORWARD;
        double[] r2 = fht(r3);
        if (r4 != r0) goto L6;
        return r2;
    L6:
        return TransformUtils.scaleArray(r2, 1.0d / ((double) r3.length));
    }

    public int[] transform(int[] r1) {
        return fht(r1);
    }
}
