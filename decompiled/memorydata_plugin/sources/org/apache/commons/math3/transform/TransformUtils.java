package org.apache.commons.math3.transform;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.lang.reflect.Array;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class TransformUtils {
    private static final int[] POWERS_OF_TWO = null;

    static {
        POWERS_OF_TWO = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, 134217728, SQLiteDatabase.CREATE_IF_NECESSARY, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING, 1073741824};
    }

    public static Complex[] createComplexArray(double[][] r9) {
        if (r9.length != 2) goto L13;
        int r0 = 0;
        double[] r1 = r9[0];
        double[] r10 = r9[1];
        if (r1.length != r10.length) goto L11;
        int r2 = r1.length;
        Complex[] r3 = new Complex[r2];
    L7:
        if (r0 >= r2) goto L9;
        r3[r0] = new Complex(r1[r0], r10[r0]);
        r0 = r0 + 1;
        goto L7
    L9:
        return r3;
    L11:
        throw new DimensionMismatchException(r10.length, r1.length);
    L13:
        throw new DimensionMismatchException(r9.length, 2);
    }

    public static double[][] createRealImaginaryArray(Complex[] r7) {
        int r0 = 0;
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{2, r7.length});
        double[] r2 = r1[0];
        double[] r3 = r1[1];
    L4:
        if (r0 >= r7.length) goto L6;
        Complex r4 = r7[r0];
        r2[r0] = r4.getReal();
        r3[r0] = r4.getImaginary();
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static double[] scaleArray(double[] r3, double r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = r3[r0] * r4;
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }
}
