package androidx.constraintlayout.motion.utils;

import ai.j0;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str;

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        double f429x1;
        double x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        double f430y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        double f431y2;

        public CubicEasing(String r10) {
            this.str = r10;
            int r5 = r10.indexOf(40);
            int r11 = r10.indexOf(44, r5);
            this.f429x1 = Double.parseDouble(r10.substring(r5 + 1, r11).trim());
            int r12 = r11 + 1;
            int r13 = r10.indexOf(44, r12);
            this.f430y1 = Double.parseDouble(r10.substring(r12, r13).trim());
            int r14 = r13 + 1;
            int r15 = r10.indexOf(44, r14);
            this.x2 = Double.parseDouble(r10.substring(r14, r15).trim());
            int r16 = r15 + 1;
            this.f431y2 = Double.parseDouble(r10.substring(r16, r10.indexOf(41, r16)).trim());
        }

        private double getDiffX(double r18) {
            double r5 = 1.0d - r18;
            double r11 = this.f429x1;
            double r15 = ((r5 * 3.0d) * r5) * r11;
            double r13 = (r5 * 6.0d) * r18;
            double r10 = this.x2;
            double r12 = (3.0d * r18) * r18;
            return j0.a(1.0d, r10, r12, j0.a(r10, r11, r13, r15));
        }

        private double getDiffY(double r18) {
            double r5 = 1.0d - r18;
            double r11 = this.f430y1;
            double r15 = ((r5 * 3.0d) * r5) * r11;
            double r13 = (r5 * 6.0d) * r18;
            double r10 = this.f431y2;
            double r12 = (3.0d * r18) * r18;
            return j0.a(1.0d, r10, r12, j0.a(r10, r11, r13, r15));
        }

        private double getX(double r10) {
            double r5 = 1.0d - r10;
            double r11 = 3.0d * r5;
            double r12 = (r5 * r11) * r10;
            double r13 = (r11 * r10) * r10;
            double r14 = (r10 * r10) * r10;
            double r15 = this.f429x1 * r12;
            return ((this.x2 * r13) + r15) + r14;
        }

        private double getY(double r10) {
            double r5 = 1.0d - r10;
            double r11 = 3.0d * r5;
            double r12 = (r5 * r11) * r10;
            double r13 = (r11 * r10) * r10;
            double r14 = (r10 * r10) * r10;
            double r15 = this.f430y1 * r12;
            return ((this.f431y2 * r13) + r15) + r14;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r5 = 0.5d;
            double r11 = 0.5d;
        L10:
            if (r5 <= error) goto L15;
            r5 = r5 * 0.5d;
            if (getX(r11) < r10) goto L13;
            r11 = r11 - r5;
            goto L10
        L13:
            r11 = r11 + r5;
            goto L10
        L15:
            double r12 = r11 - r5;
            double r13 = getX(r12);
            double r14 = r11 + r5;
            double r15 = getX(r14);
            double r16 = getY(r12);
            return (((r10 - r13) * (getY(r14) - r16)) / (r15 - r13)) + r16;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double r10) {
            double r5 = 0.5d;
            double r11 = 0.5d;
        L4:
            if (r5 <= d_error) goto L9;
            r5 = r5 * 0.5d;
            if (getX(r11) < r10) goto L7;
            r11 = r11 - r5;
            goto L4
        L7:
            r11 = r11 + r5;
            goto L4
        L9:
            double r12 = r11 - r5;
            double r13 = getX(r12);
            double r14 = r11 + r5;
            double r15 = getX(r14);
            return (getY(r14) - getY(r12)) / (r15 - r13);
        }

        public void setup(double r5, double r10, double r11, double r12) {
            this.f429x1 = r5;
            this.f430y1 = r10;
            this.x2 = r11;
            this.f431y2 = r12;
        }

        public CubicEasing(double r5, double r10, double r11, double r12) {
            setup(r5, r10, r11, r12);
        }
    }

    static {
        sDefault = new Easing();
        NAMED_EASING = new String[]{"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public Easing() {
        this.str = "identity";
    }

    public static Easing getInterpolator(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.startsWith("cubic") == true) goto L8;
        byte r10 = -1;
        switch(r5.hashCode()) {
            case -1354466595: goto L25;
            case -1263948740: goto L21;
            case -1102672091: goto L17;
            case 1312628413: goto L13;
            default: goto L28;
        };
    L28:
        switch(r10) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            default: goto L29;
        };
    L29:
        Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
        return sDefault;
    L32:
        return new CubicEasing(STANDARD);
    L34:
        return new CubicEasing(LINEAR);
    L36:
        return new CubicEasing(DECELERATE);
    L38:
        return new CubicEasing(ACCELERATE);
    L13:
        if (r5.equals("standard") == false) goto L28;
        r10 = 3;
        goto L28
    L17:
        if (r5.equals(LINEAR_NAME) == false) goto L28;
        r10 = 2;
        goto L28
    L21:
        if (r5.equals(DECELERATE_NAME) == false) goto L28;
        r10 = 1;
        goto L28
    L25:
        if (r5.equals(ACCELERATE_NAME) == false) goto L28;
        r10 = 0;
        goto L28
    L8:
        return new CubicEasing(r5);
    }

    public double get(double r5) {
        return r5;
    }

    public double getDiff(double r5) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }
}
