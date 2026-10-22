package org.apache.commons.math3.analysis.solvers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class UnivariateSolverUtils {
    public static boolean isBracketing(UnivariateFunction r3, double r4, double r6) {
        UnivariateFunction r5 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateFunction.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        double r7 = r5.value(r4);
        double r8 = r5.value(r6);
        if (r7 < 0.0d) goto L9;
        if (r8 > 0.0d) goto L9;
    L12:
        return true;
    L9:
        if (r7 <= 0.0d) goto L11;
        return false;
    L11:
        if (r8 >= 0.0d) goto L12;
        return false;
    L15:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static double solve(UnivariateFunction r7, double r8, double r10, double r12) {
        UnivariateFunction r2 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r7, UnivariateFunction.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        return new BrentSolver(r12).solve(Integer.MAX_VALUE, r2, r8, r10);
    L7:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static void verifyBracketing(UnivariateFunction r10, double r11, double r13) {
        UnivariateFunction r12 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r10, UnivariateFunction.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L10;
        verifyInterval(r11, r13);
        if (isBracketing(r12, r11, r13) == false) goto L8;
        return;
    L8:
        throw new NoBracketingException(r11, r13, r12.value(r11), r12.value(r13));
    L10:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static void verifyInterval(double r2, double r4) {
        if (r2 >= r4) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(r2), Double.valueOf(r4), false);
    }

    public static void verifySequence(double r0, double r2, double r4) {
        verifyInterval(r0, r2);
        verifyInterval(r2, r4);
    }
}
