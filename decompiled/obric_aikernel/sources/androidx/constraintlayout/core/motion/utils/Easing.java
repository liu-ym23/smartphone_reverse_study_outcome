package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str;

    static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        double f240x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        double f241x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        double f242y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        double f243y2;

        static {
        }

        public CubicEasing(double r10, double r11, double r12, double r13) {
            setup(r10, r11, r12, r13);
        }

        CubicEasing(String r10) {
            this.str = r10;
            int r11 = r10.indexOf(40);
            int r12 = r10.indexOf(44, r11);
            this.f240x1 = Double.parseDouble(r10.substring(r11 + 1, r12).trim());
            int r13 = r12 + 1;
            int r14 = r10.indexOf(44, r13);
            this.f242y1 = Double.parseDouble(r10.substring(r13, r14).trim());
            int r15 = r14 + 1;
            int r16 = r10.indexOf(44, r15);
            this.f241x2 = Double.parseDouble(r10.substring(r15, r16).trim());
            int r17 = r16 + 1;
            this.f243y2 = Double.parseDouble(r10.substring(r17, r10.indexOf(41, r17)).trim());
        }

        private double getDiffX(double r13) {
            double r10 = 1.0d - r13;
            double r11 = this.f240x1;
            double r12 = this.f241x2;
            return ((((r10 * 3.0d) * r10) * r11) + (((r10 * 6.0d) * r13) * (r12 - r11))) + (((3.0d * r13) * r13) * (1.0d - r12));
        }

        private double getDiffY(double r13) {
            double r10 = 1.0d - r13;
            double r11 = this.f242y1;
            double r12 = this.f243y2;
            return ((((r10 * 3.0d) * r10) * r11) + (((r10 * 6.0d) * r13) * (r12 - r11))) + (((3.0d * r13) * r13) * (1.0d - r12));
        }

        private double getX(double r10) {
            double r11 = 1.0d - r10;
            double r12 = 3.0d * r11;
            double r13 = (r11 * r12) * r10;
            double r14 = (r12 * r10) * r10;
            double r15 = (r10 * r10) * r10;
            return ((this.f240x1 * r13) + (this.f241x2 * r14)) + r15;
        }

        private double getY(double r10) {
            double r11 = 1.0d - r10;
            double r12 = 3.0d * r11;
            double r13 = (r11 * r12) * r10;
            double r14 = (r12 * r10) * r10;
            double r15 = (r10 * r10) * r10;
            return ((this.f242y1 * r13) + (this.f243y2 * r14)) + r15;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r11 = 0.5d;
            double r12 = 0.5d;
        L10:
            if (r11 <= error) goto L15;
            r11 = r11 * 0.5d;
            if (getX(r12) < r10) goto L13;
            r12 = r12 - r11;
            goto L10
        L13:
            r12 = r12 + r11;
            goto L10
        L15:
            double r13 = r12 - r11;
            double r14 = getX(r13);
            double r15 = r12 + r11;
            double r16 = getX(r15);
            double r17 = getY(r13);
            return (((getY(r15) - r17) * (r10 - r14)) / (r16 - r14)) + r17;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double r10) {
            double r11 = 0.5d;
            double r12 = 0.5d;
        L4:
            if (r11 <= d_error) goto L9;
            r11 = r11 * 0.5d;
            if (getX(r12) < r10) goto L7;
            r12 = r12 - r11;
            goto L4
        L7:
            r12 = r12 + r11;
            goto L4
        L9:
            double r13 = r12 - r11;
            double r14 = getX(r13);
            double r15 = r12 + r11;
            double r16 = getX(r15);
            return (getY(r15) - getY(r13)) / (r16 - r14);
        }

        void setup(double r10, double r11, double r12, double r13) {
            this.f240x1 = r10;
            this.f242y1 = r11;
            this.f241x2 = r12;
            this.f243y2 = r13;
        }
    }

    static {
        sDefault = new Easing();
        NAMED_EASING = new String[]{"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public Easing() {
        this.str = "identity";
    }

    public static Easing getInterpolator(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.startsWith("cubic") == false) goto L10;
        return new CubicEasing(r10);
    L10:
        if (r10.startsWith("spline") == false) goto L14;
        return new StepCurve(r10);
    L14:
        if (r10.startsWith("Schlick") == true) goto L16;
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1354466595: goto L41;
            case -1263948740: goto L37;
            case -1197605014: goto L33;
            case -1102672091: goto L29;
            case -749065269: goto L25;
            case 1312628413: goto L21;
            default: goto L44;
        };
    L44:
        switch(r11) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            default: goto L45;
        };
    L45:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
        return sDefault;
    L48:
        return new CubicEasing(STANDARD);
    L50:
        return new CubicEasing(OVERSHOOT);
    L52:
        return new CubicEasing(LINEAR);
    L54:
        return new CubicEasing(ANTICIPATE);
    L56:
        return new CubicEasing(DECELERATE);
    L58:
        return new CubicEasing(ACCELERATE);
    L21:
        if (r10.equals("standard") == false) goto L44;
        r11 = 5;
        goto L44
    L25:
        if (r10.equals(OVERSHOOT_NAME) == false) goto L44;
        r11 = 4;
        goto L44
    L29:
        if (r10.equals(LINEAR_NAME) == false) goto L44;
        r11 = 3;
        goto L44
    L33:
        if (r10.equals(ANTICIPATE_NAME) == false) goto L44;
        r11 = 2;
        goto L44
    L37:
        if (r10.equals(DECELERATE_NAME) == false) goto L44;
        r11 = 1;
        goto L44
    L41:
        if (r10.equals(ACCELERATE_NAME) == false) goto L44;
        r11 = 0;
        goto L44
    L16:
        return new Schlick(r10);
    }

    public double get(double r10) {
        return r10;
    }

    public double getDiff(double r10) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }
}
