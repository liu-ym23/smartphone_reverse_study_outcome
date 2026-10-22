package org.apache.commons.math3.transform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class FastCosineTransformer implements Serializable {
    static final long serialVersionUID = 20120212;
    private final DctNormalization normalization;

    public FastCosineTransformer(DctNormalization r1) {
        this.normalization = r1;
    }

    public double[] fct(double[] r23) {
        double[] r1 = new double[r23.length];
        int r2 = r23.length - 1;
        if (ArithmeticUtils.isPowerOfTwo(r2) == false) goto L17;
        double r6 = 0.5d;
        if (r2 != 1) goto L8;
        r1[0] = (r23[0] + r23[1]) * 0.5d;
        r1[1] = (r23[0] - r23[1]) * 0.5d;
        return r1;
    L8:
        double[] r4 = new double[r2];
        r4[0] = (r23[0] + r23[r2]) * 0.5d;
        int r8 = r2 >> 1;
        r4[r8] = r23[r8];
        double r9 = (r23[0] - r23[r2]) * 0.5d;
        int r11 = 1;
    L9:
        if (r11 >= r8) goto L11;
        int r14 = r2 - r11;
        double r12 = (r23[r11] + r23[r14]) * r6;
        double[] r17 = r4;
        double r7 = (((double) r11) * 3.141592653589793d) / ((double) r2);
        double r3 = FastMath.sin(r7) * (r23[r11] - r23[r14]);
        double r10 = FastMath.cos(r7) * (r23[r11] - r23[r14]);
        r17[r11] = r12 - r3;
        r17[r14] = r12 + r3;
        r9 = r9 + r10;
        r11 = r11 + 1;
        r4 = r17;
        r6 = 0.5d;
        goto L9
    L11:
        Complex[] r0 = new FastFourierTransformer(DftNormalization.STANDARD).transform(r4, TransformType.FORWARD);
        r1[0] = r0[0].getReal();
        int r5 = 1;
        r1[1] = r9;
        int r13 = 1;
    L12:
        if (r13 >= r8) goto L14;
        int r15 = r13 * 2;
        r1[r15] = r0[r13].getReal();
        r1[r15 + 1] = r1[r15 - r5] - r0[r13].getImaginary();
        r13 = r13 + 1;
        r5 = 1;
        goto L12
    L14:
        r1[r2] = r0[r8].getReal();
        return r1;
    L17:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE, new Object[]{Integer.valueOf(r23.length)});
    }

    public double[] transform(UnivariateFunction r7, double r8, double r10, int r12, TransformType r13) {
        return transform(FunctionUtils.sample((UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r7, UnivariateFunction.class, "com.obric.memorydata.plugin"), r8, r10, r12), r13);
    }

    public double[] transform(double[] r6, TransformType r7) {
        if (r7 == TransformType.FORWARD) goto L5;
        double r1 = 2.0d / ((double) (r6.length - 1));
        if (this.normalization != DctNormalization.ORTHOGONAL_DCT_I) goto L14;
        r1 = FastMath.sqrt(r1);
    L14:
        return TransformUtils.scaleArray(fct(r6), r1);
    L5:
        if (this.normalization != DctNormalization.ORTHOGONAL_DCT_I) goto L9;
        return TransformUtils.scaleArray(fct(r6), FastMath.sqrt(2.0d / ((double) (r6.length - 1))));
    L9:
        return fct(r6);
    }
}
