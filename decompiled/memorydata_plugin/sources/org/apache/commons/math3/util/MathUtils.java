package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public final class MathUtils {
    public static void checkFinite(double r1) {
        if (Double.isInfinite(r1) == true) goto L8;
        if (Double.isNaN(r1) == true) goto L8;
        return;
    L8:
        throw new NotFiniteNumberException(Double.valueOf(r1), new Object[0]);
    }

    public static void checkNotNull(Object r0) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new NullArgumentException();
    }

    public static void checkNotNull(Object r2, Localizable r3, Object... r4) {
        Localizable r5 = (Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return;
    L6:
        throw new NullArgumentException(r5, r4);
    }

    public static int copySign(int r1, int r2) {
        if (r1 < 0) goto L4;
        if (r2 < 0) goto L4;
    L6:
        return r1;
    L4:
        if (r1 >= 0) goto L7;
        if (r2 < 0) goto L6;
    L7:
        if (r2 < 0) goto L14;
        if (r1 != Integer.MIN_VALUE) goto L14;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    L14:
        return -r1;
    }

    public static boolean equals(double r1, double r3) {
        return new Double(r1).equals(new Double(r3));
    }

    public static int hash(double r1) {
        return new Double(r1).hashCode();
    }

    public static int hash(double[] r0) {
        return Arrays.hashCode(r0);
    }

    public static double normalizeAngle(double r2, double r4) {
        return r2 - (FastMath.floor(((3.141592653589793d + r2) - r4) / 6.283185307179586d) * 6.283185307179586d);
    }
}
