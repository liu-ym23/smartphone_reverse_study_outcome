package org.apache.commons.math3.analysis;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FunctionUtils {
    public static UnivariateFunction fix2ndArgument(BivariateFunction r2, final double r3) {
        final BivariateFunction r4 = (BivariateFunction) ZeusTransformUtils.wrapperContextForParams(r2, BivariateFunction.class, "com.obric.memorydata.plugin");
        return new AnonymousClass13(r4, r3);
    }

    public static double[] sample(UnivariateFunction r4, double r5, double r7, int r9) {
        UnivariateFunction r6 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r4, UnivariateFunction.class, "com.obric.memorydata.plugin");
        if (r9 <= 0) goto L13;
        int r1 = 0;
        if (r5 >= r7) goto L11;
        double[] r0 = new double[r9];
        double r8 = (r7 - r5) / ((double) r9);
    L7:
        if (r1 >= r9) goto L9;
        r0[r1] = r6.value((((double) r1) * r8) + r5);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    L11:
        throw new NumberIsTooLargeException(Double.valueOf(r5), Double.valueOf(r7), false);
    L13:
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(r9));
    }
}
