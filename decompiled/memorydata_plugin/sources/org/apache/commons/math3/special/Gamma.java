package org.apache.commons.math3.special;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Gamma {
    private static final double HALF_LOG_2_PI = 0.0d;
    private static final double[] LANCZOS = null;

    static {
        LANCZOS = new double[]{0.9999999999999971d, 57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
        HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
    }

    public static double gamma(double r11) {
        if (r11 == FastMath.rint(r11)) goto L5;
    L8:
        double r3 = FastMath.abs(r11);
        if (r3 <= 20.0d) goto L11;
        double r5 = (4.7421875d + r3) + 0.5d;
        double r4 = lanczos(r3) * (((2.5066282746310007d / r3) * FastMath.pow(r5, 0.5d + r3)) * FastMath.exp(-r5));
        if (r11 <= 0.0d) goto L26;
        return r4;
    L26:
        return (-3.141592653589793d) / ((r11 * FastMath.sin(3.141592653589793d * r11)) * r4);
    L11:
        if (r11 < 1.0d) goto L17;
        double r2 = 1.0d;
    L13:
        r11 = r11 - 1.0d;
        if (r11 <= 2.5d) goto L29;
        r2 = r2 * r11;
        goto L13
    L29:
        return r2 / (invGamma1pm1(r11) + 1.0d);
    L17:
        double r6 = r11;
    L19:
        if (r11 >= (-0.5d)) goto L30;
        r11 = r11 + 1.0d;
        r6 = r6 * r11;
        goto L19
    L30:
        return 1.0d / (r6 * (invGamma1pm1(r11) + 1.0d));
    L5:
        if (r11 > 0.0d) goto L8;
        return Double.NaN;
    }

    public static double invGamma1pm1(double r39) {
        if (r39 < (-0.5d)) goto L24;
        if (r39 > 1.5d) goto L22;
        if (r39 > 0.5d) goto L9;
        double r2 = r39;
    L11:
        if (r2 >= 0.0d) goto L16;
        double r35 = ((((((((((((((((((((((((((((((6.247308301164655E-9d * r2) + 6.116095104481416E-9d) / ((((((((((((((((1.9575583661463974E-10d * r2) - 6.077618957228252E-8d) * r2) + 9.926418406727737E-7d) * r2) - 6.4304548177935305E-6d) * r2) - 8.514194324403149E-6d) * r2) + 4.939449793824468E-4d) * r2) + 0.026620534842894922d) * r2) + 0.203610414066807d) * r2) + 1.0d)) * r2) - 2.056338416977607E-7d) * r2) + 1.133027231981696E-6d) * r2) - 1.2504934821426706E-6d) * r2) - 2.013485478078824E-5d) * r2) + 1.280502823881162E-4d) * r2) - 2.1524167411495098E-4d) * r2) - 0.0011651675918590652d) * r2) + 0.0072189432466631d) * r2) - 0.009621971527876973d) * r2) - 0.04219773455554433d) * r2) + 0.16653861138229148d) * r2) - 0.04200263503409524d) * r2) - 0.6558780715202539d) * r2) - 0.42278433509846713d;
        if (r39 > 0.5d) goto L25;
        double r36 = (r35 + 0.5d) + 0.5d;
    L20:
        return r39 * r36;
    L25:
        return (r2 * r35) / r39;
    L16:
        r36 = ((((((((((((((((((((((((((((((((((((((((4.343529937408594E-15d * r2) - 1.2494415722763663E-13d) * r2) + 1.5728330277104463E-12d) * r2) + 4.686843322948848E-11d) * r2) + 6.820161668496171E-10d) * r2) + 6.8716741130671986E-9d) * r2) + 6.116095104481416E-9d) / ((((((((2.6923694661863613E-4d * r2) + 0.004956830093825887d) * r2) + 0.054642130860422966d) * r2) + 0.3056961078365221d) * r2) + 1.0d)) * r2) - 2.056338416977607E-7d) * r2) + 1.133027231981696E-6d) * r2) - 1.2504934821426706E-6d) * r2) - 2.013485478078824E-5d) * r2) + 1.280502823881162E-4d) * r2) - 2.1524167411495098E-4d) * r2) - 0.0011651675918590652d) * r2) + 0.0072189432466631d) * r2) - 0.009621971527876973d) * r2) - 0.04219773455554433d) * r2) + 0.16653861138229148d) * r2) - 0.04200263503409524d) * r2) - 0.6558780715202539d) * r2) + 0.5772156649015329d;
        if (r39 <= 0.5d) goto L20;
        return (r2 / r39) * ((r36 - 0.5d) - 0.5d);
    L9:
        r2 = (r39 - 0.5d) - 0.5d;
        goto L11
    L22:
        throw new NumberIsTooLargeException(Double.valueOf(r39), Double.valueOf(1.5d), true);
    L24:
        throw new NumberIsTooSmallException(Double.valueOf(r39), Double.valueOf(-0.5d), true);
    }

    public static double lanczos(double r7) {
        int r0 = LANCZOS.length - 1;
        double r1 = 0.0d;
    L3:
        if (r0 <= 0) goto L6;
        r1 = r1 + (LANCZOS[r0] / (((double) r0) + r7));
        r0 = r0 - 1;
        goto L3
    L6:
        return r1 + LANCZOS[0];
    }

    public static double logGamma(double r8) {
        if (Double.isNaN(r8) == false) goto L5;
    L23:
        return Double.NaN;
    L5:
        if (r8 <= 0.0d) goto L23;
        if (r8 >= 0.5d) goto L12;
        return logGamma1p(r8) - FastMath.log(r8);
    L12:
        if (r8 > 2.5d) goto L16;
        return logGamma1p((r8 - 0.5d) - 0.5d);
    L16:
        if (r8 > 8.0d) goto L22;
        int r0 = (int) FastMath.floor(r8 - 1.5d);
        double r1 = 1.0d;
        int r4 = 1;
    L18:
        if (r4 > r0) goto L21;
        r1 = r1 * (r8 - ((double) r4));
        r4 = r4 + 1;
        goto L18
    L21:
        return logGamma1p(r8 - ((double) (r0 + 1))) + FastMath.log(r1);
    L22:
        double r5 = (4.7421875d + r8) + 0.5d;
        return ((((0.5d + r8) * FastMath.log(r5)) - r5) + HALF_LOG_2_PI) + FastMath.log(lanczos(r8) / r8);
    }

    public static double logGamma1p(double r4) {
        if (r4 < (-0.5d)) goto L11;
        if (r4 > 1.5d) goto L9;
        return -FastMath.log1p(invGamma1pm1(r4));
    L9:
        throw new NumberIsTooLargeException(Double.valueOf(r4), Double.valueOf(1.5d), true);
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r4), Double.valueOf(-0.5d), true);
    }

    public static double regularizedGammaP(double r7, double r9) {
        return regularizedGammaP(r7, r9, 1.0E-14d, Integer.MAX_VALUE);
    }

    public static double regularizedGammaP(double r14, double r16, double r18, int r20) {
        double r6 = 0.0d;
        if (Double.isNaN(r14) == false) goto L5;
    L33:
        return Double.NaN;
    L5:
        if (Double.isNaN(r16) == true) goto L33;
        if (r14 <= 0.0d) goto L33;
        if (r16 < 0.0d) goto L33;
        if (r16 != 0.0d) goto L15;
        return 0.0d;
    L15:
        if (r16 >= (r14 + 1.0d)) goto L39;
        double r8 = 1.0d / r14;
        double r10 = r8;
    L19:
        if (FastMath.abs(r8 / r10) <= r18) goto L26;
        if (r6 >= r20) goto L26;
        if (r10 >= Double.POSITIVE_INFINITY) goto L26;
        r6 = r6 + 1.0d;
        r8 = r8 * (r16 / (r14 + r6));
        r10 = r10 + r8;
    L26:
        if (r6 >= r20) goto L32;
        if (Double.isInfinite(r10) == false) goto L40;
        return 1.0d;
    L40:
        return FastMath.exp(((-r16) + (FastMath.log(r16) * r14)) - logGamma(r14)) * r10;
    L32:
        throw new MaxCountExceededException(Integer.valueOf(r20));
    L39:
        return 1.0d - regularizedGammaQ(r14, r16, r18, r20);
    }

    public static double regularizedGammaQ(final double r9, double r11, double r13, int r15) {
        if (Double.isNaN(r9) == false) goto L5;
    L18:
        return Double.NaN;
    L5:
        if (Double.isNaN(r11) == true) goto L18;
        if (r9 <= 0.0d) goto L18;
        if (r11 < 0.0d) goto L18;
        if (r11 != 0.0d) goto L15;
        return 1.0d;
    L15:
        if (r11 >= (r9 + 1.0d)) goto L21;
        return 1.0d - regularizedGammaP(r9, r11, r13, r15);
    L21:
        return (1.0d / new AnonymousClass1(r9).evaluate(r11, r13, r15)) * FastMath.exp(((-r11) + (FastMath.log(r11) * r9)) - logGamma(r9));
    }
}
