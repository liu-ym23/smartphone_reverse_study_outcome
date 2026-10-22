package org.apache.commons.math3.util;

import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes6.dex */
public class FastMath {
    private static final double[] CBRTTWO = null;
    private static final double[] COSINE_TABLE_A = null;
    private static final double[] COSINE_TABLE_B = null;
    private static final double[] EIGHTHS = null;
    private static final double[][] LN_HI_PREC_COEF = null;
    private static final double[][] LN_QUICK_COEF = null;
    private static final double LOG_MAX_VALUE = 0.0d;
    private static final long[] PI_O_4_BITS = null;
    private static final long[] RECIP_2PI = null;
    private static final double[] SINE_TABLE_A = null;
    private static final double[] SINE_TABLE_B = null;
    private static final double[] TANGENT_TABLE_A = null;
    private static final double[] TANGENT_TABLE_B = null;

    private static class CodyWaite {
        private final int finalK;
        private final double finalRemA;
        private final double finalRemB;

        CodyWaite(double r12) {
            int r0 = (int) (0.6366197723675814d * r12);
        L3:
            double r1 = -r0;
            double r3 = 1.570796251296997d * r1;
            double r5 = r12 + r3;
            double r7 = 7.549789948768648E-8d * r1;
            double r9 = r7 + r5;
            double r4 = (-((r5 - r12) - r3)) + (-((r9 - r5) - r7));
            double r2 = r1 * 6.123233995736766E-17d;
            double r6 = r2 + r9;
            double r8 = r4 + (-((r6 - r9) - r2));
            if (r6 > 0.0d) goto L5;
            r0 = r0 - 1;
            goto L3
        L5:
            this.finalK = r0;
            this.finalRemA = r6;
            this.finalRemB = r8;
        }

        int getK() {
            return this.finalK;
        }

        double getRemA() {
            return this.finalRemA;
        }

        double getRemB() {
            return this.finalRemB;
        }
    }

    private static class ExpFracTable {
        private static final double[] EXP_FRAC_TABLE_A = null;
        private static final double[] EXP_FRAC_TABLE_B = null;

        static {
            EXP_FRAC_TABLE_A = FastMathLiteralArrays.loadExpFracA();
            EXP_FRAC_TABLE_B = FastMathLiteralArrays.loadExpFracB();
        }

        static /* synthetic */ double[] access$200() {
            return EXP_FRAC_TABLE_A;
        }

        static /* synthetic */ double[] access$300() {
            return EXP_FRAC_TABLE_B;
        }
    }

    private static class ExpIntTable {
        private static final double[] EXP_INT_TABLE_A = null;
        private static final double[] EXP_INT_TABLE_B = null;

        static {
            EXP_INT_TABLE_A = FastMathLiteralArrays.loadExpIntA();
            EXP_INT_TABLE_B = FastMathLiteralArrays.loadExpIntB();
        }

        static /* synthetic */ double[] access$000() {
            return EXP_INT_TABLE_A;
        }

        static /* synthetic */ double[] access$100() {
            return EXP_INT_TABLE_B;
        }
    }

    private static class Split {
        public static final Split NAN = null;
        public static final Split NEGATIVE_INFINITY = null;
        public static final Split POSITIVE_INFINITY = null;
        private final double full;
        private final double high;
        private final double low;

        static {
            NAN = new Split(Double.NaN, 0.0d);
            POSITIVE_INFINITY = new Split(Double.POSITIVE_INFINITY, 0.0d);
            NEGATIVE_INFINITY = new Split(Double.NEGATIVE_INFINITY, 0.0d);
        }

        Split(double r5) {
            this.full = r5;
            double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r5) & (-134217728));
            this.high = r0;
            this.low = r5 - r0;
        }

        Split(double r10, double r12) {
            if (r10 == 0.0d) goto L5;
            double r0 = r10 + r12;
        L11:
            double r3 = r0;
        L12:
            this(r3, r10, r12);
            return;
        L5:
            if (r12 == 0.0d) goto L7;
        L9:
            r3 = r12;
            goto L12
        L7:
            if (Double.doubleToRawLongBits(r10) != Long.MIN_VALUE) goto L9;
            r0 = -0.0d;
            goto L11
        }

        Split(double r1, double r3, double r5) {
            this.full = r1;
            this.high = r3;
            this.low = r5;
        }

        static /* synthetic */ Split access$500(Split r0, long r1) {
            return r0.pow(r1);
        }

        static /* synthetic */ double access$600(Split r2) {
            return r2.full;
        }

        private Split pow(long r12) {
            Split r0 = new Split(1.0d);
            Split r10 = new Split(this.full, this.high, this.low);
            long r3 = r12;
        L4:
            if (r3 == 0) goto L10;
            if ((r3 & 1) == 0) goto L8;
            r0 = r0.multiply(r10);
        L8:
            r10 = r10.multiply(r10);
            r3 = r3 >>> 1;
            goto L4
        L10:
            if (Double.isNaN(r0.full) == true) goto L12;
            return r0;
        L12:
            if (Double.isNaN(this.full) == false) goto L16;
            return NAN;
        L16:
            if (FastMath.abs(this.full) >= 1.0d) goto L20;
            return new Split(FastMath.copySign(0.0d, this.full), 0.0d);
        L20:
            if (this.full >= 0.0d) goto L26;
            if ((r12 & 1) != 1) goto L26;
            return NEGATIVE_INFINITY;
        L26:
            return POSITIVE_INFINITY;
        }

        public Split multiply(Split r14) {
            Split r0 = new Split(this.full * r14.full);
            double r1 = this.low;
            double r3 = r14.low;
            double r7 = r0.full;
            double r9 = this.high;
            double r13 = r14.high;
            double r5 = (r1 * r3) - (((r7 - (r9 * r13)) - (r1 * r13)) - (r9 * r3));
            return new Split(r0.high, r0.low + r5);
        }

        public Split reciprocal() {
            Split r4 = new Split(1.0d / this.full);
            Split r0 = multiply(r4);
            double r5 = (r0.high - 1.0d) + r0.low;
            if (Double.isNaN(r5) == false) goto L6;
            return r4;
        L6:
            return new Split(r4.high, r4.low - (r5 / this.full));
        }
    }

    private static class lnMant {
        private static final double[][] LN_MANT = null;

        static {
            LN_MANT = FastMathLiteralArrays.loadLnMant();
        }

        static /* synthetic */ double[][] access$400() {
            return LN_MANT;
        }
    }

    static {
        LOG_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);
        LN_QUICK_COEF = new double[][]{new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
        LN_HI_PREC_COEF = new double[][]{new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
        SINE_TABLE_A = new double[]{0.0d, 0.1246747374534607d, 0.24740394949913025d, 0.366272509098053d, 0.4794255495071411d, 0.5850973129272461d, 0.6816387176513672d, 0.7675435543060303d, 0.8414709568023682d, 0.902267575263977d, 0.9489846229553223d, 0.9808930158615112d, 0.9974949359893799d, 0.9985313415527344d};
        SINE_TABLE_B = new double[]{0.0d, -4.068233003401932E-9d, 9.755392680573412E-9d, 1.9987994582857286E-8d, -1.0902938113007961E-8d, -3.9986783938944604E-8d, 4.23719669792332E-8d, -5.207000323380292E-8d, 2.800552834259E-8d, 1.883511811213715E-8d, -3.5997360512765566E-9d, 4.116164446561962E-8d, 5.0614674548127384E-8d, -1.0129027912496858E-9d};
        COSINE_TABLE_A = new double[]{1.0d, 0.9921976327896118d, 0.9689123630523682d, 0.9305076599121094d, 0.8775825500488281d, 0.8109631538391113d, 0.7316888570785522d, 0.6409968137741089d, 0.5403022766113281d, 0.4311765432357788d, 0.3153223395347595d, 0.19454771280288696d, 0.07073719799518585d, -0.05417713522911072d};
        COSINE_TABLE_B = new double[]{0.0d, 3.4439717236742845E-8d, 5.865827662008209E-8d, -3.7999795083850525E-8d, 1.184154459111628E-8d, -3.43338934259355E-8d, 1.1795268640216787E-8d, 4.438921624363781E-8d, 2.925681159240093E-8d, -2.6437112632041807E-8d, 2.2860509143963117E-8d, -4.813899778443457E-9d, 3.6725170580355583E-9d, 2.0217439756338078E-10d};
        TANGENT_TABLE_A = new double[]{0.0d, 0.1256551444530487d, 0.25534194707870483d, 0.3936265707015991d, 0.5463024377822876d, 0.7214844226837158d, 0.9315965175628662d, 1.1974215507507324d, 1.5574076175689697d, 2.092571258544922d, 3.0095696449279785d, 5.041914939880371d, 14.101419448852539d, -18.430862426757812d};
        TANGENT_TABLE_B = new double[]{0.0d, -7.877917738262007E-9d, -2.5857668567479893E-8d, 5.2240336371356666E-9d, 5.206150291559893E-8d, 1.8307188599677033E-8d, -5.7618793749770706E-8d, 7.848361555046424E-8d, 1.0708593250394448E-7d, 1.7827257129423813E-8d, 2.893485277253286E-8d, 3.1660099222737955E-7d, 4.983191803254889E-7d, -3.356118100840571E-7d};
        RECIP_2PI = new long[]{2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
        PI_O_4_BITS = new long[]{-3958705157555305932L, -4267615245585081135L};
        EIGHTHS = new double[]{0.0d, 0.125d, 0.25d, 0.375d, 0.5d, 0.625d, 0.75d, 0.875d, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
        CBRTTWO = new double[]{0.6299605249474366d, 0.7937005259840998d, 1.0d, 1.2599210498948732d, 1.5874010519681994d};
    }

    public static double IEEEremainder(double r0, double r2) {
        return StrictMath.IEEEremainder(r0, r2);
    }

    public static double abs(double r2) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(r2) & Long.MAX_VALUE);
    }

    public static int abs(int r2) {
        int r0 = r2 >>> 31;
        return (r2 ^ ((~r0) + 1)) + r0;
    }

    public static long abs(long r6) {
        long r0 = r6 >>> 63;
        return (r6 ^ ((~r0) + 1)) + r0;
    }

    public static double acos(double r21) {
        if (r21 == r21) goto L6;
        return Double.NaN;
    L6:
        if (r21 <= 1.0d) goto L8;
    L29:
        return Double.NaN;
    L8:
        if (r21 < (-1.0d)) goto L29;
        if (r21 != (-1.0d)) goto L15;
        return 3.141592653589793d;
    L15:
        if (r21 != 1.0d) goto L18;
        return 0.0d;
    L18:
        if (r21 != 0.0d) goto L20;
        return 1.5707963267948966d;
    L20:
        double r9 = r21 * 1.073741824E9d;
        double r11 = (r21 + r9) - r9;
        double r10 = r21 - r11;
        double r13 = -(r11 * r11);
        double r0 = -(((r11 * r10) * 2.0d) + (r10 * r10));
        double r15 = r13 + 1.0d;
        double r2 = -((r15 - 1.0d) - r13);
        double r14 = r15 + r0;
        double r3 = r2 + (-((r14 - r15) - r0));
        double r1 = sqrt(r14);
        double r7 = 1.073741824E9d * r1;
        double r16 = (r1 + r7) - r7;
        double r8 = r1 - r16;
        double r4 = r1 * 2.0d;
        double r12 = (r8 + ((((r14 - (r16 * r16)) - ((r16 * 2.0d) * r8)) - (r8 * r8)) / r4)) + (r3 / r4);
        double r5 = r16 + r12;
        double r6 = -((r5 - r16) - r12);
        double r17 = r5 / r21;
        if (Double.isInfinite(r17) == false) goto L23;
        return 1.5707963267948966d;
    L23:
        double r18 = doubleHighPart(r17);
        double r19 = r17 - r18;
        double r20 = (r19 + (((((r5 - (r18 * r11)) - (r18 * r10)) - (r11 * r19)) - (r10 * r19)) / r21)) + (r6 / r21);
        double r22 = r18 + r20;
        double r23 = -((r22 - r18) - r20);
        if (r21 >= 0.0d) goto L26;
        boolean r24 = true;
    L28:
        return atan(r22, r23, r24);
    L26:
        r24 = false;
        goto L28
    }

    public static double acosh(double r4) {
        return log(r4 + sqrt((r4 * r4) - 1.0d));
    }

    public static double asin(double r19) {
        if (r19 == r19) goto L6;
        return Double.NaN;
    L6:
        if (r19 <= 1.0d) goto L8;
    L22:
        return Double.NaN;
    L8:
        if (r19 < (-1.0d)) goto L22;
        if (r19 != 1.0d) goto L14;
        return 1.5707963267948966d;
    L14:
        if (r19 != (-1.0d)) goto L18;
        return -1.5707963267948966d;
    L18:
        if (r19 != 0.0d) goto L20;
        return r19;
    L20:
        double r7 = r19 * 1.073741824E9d;
        double r9 = (r19 + r7) - r7;
        double r8 = r19 - r9;
        double r11 = r9 * r9;
        double r10 = ((r9 * r8) * 2.0d) + (r8 * r8);
        double r12 = -r11;
        double r13 = -r10;
        double r14 = r12 + 1.0d;
        double r6 = r14 + r13;
        double r4 = (-((r14 - 1.0d) - r12)) + (-((r6 - r14) - r13));
        double r15 = sqrt(r6);
        double r16 = r15 * 1.073741824E9d;
        double r17 = (r15 + r16) - r16;
        double r18 = r15 - r17;
        double r110 = 2.0d * r15;
        double r111 = r18 + ((((r6 - (r17 * r17)) - ((r17 * 2.0d) * r18)) - (r18 * r18)) / r110);
        double r20 = r19 / r15;
        double r2 = 1.073741824E9d * r20;
        double r112 = (r20 + r2) - r2;
        double r21 = r20 - r112;
        double r0 = -r19;
        double r22 = (r21 + (((((r19 - (r112 * r17)) - (r112 * r111)) - (r17 * r21)) - (r111 * r21)) / r15)) + (((r0 * (r4 / r110)) / r15) / r15);
        double r1 = r112 + r22;
        return atan(r1, -((r1 - r112) - r22), false);
    }

    public static double asinh(double r38) {
        double r0 = r38;
        if (r0 >= 0.0d) goto L5;
        boolean r2 = true;
        r0 = -r0;
    L6:
        double r6 = r0 * r0;
        if (r0 <= 0.167d) goto L9;
        double r1 = log(sqrt(r6 + 1.0d) + r0);
    L21:
        if (r2 == true) goto L23;
        return r1;
    L23:
        return -r1;
    L9:
        double r12 = 0.07692307692307693d;
        double r20 = 0.1111111111111111d;
        double r28 = 0.2d;
        if (r0 <= 0.097d) goto L16;
        r12 = 0.07692307692307693d - (((0.06666666666666667d - ((0.058823529411764705d * r6) * 0.9375d)) * r6) * 0.9285714285714286d);
    L12:
        r20 = 0.1111111111111111d - (((0.09090909090909091d - ((r12 * r6) * 0.9166666666666666d)) * r6) * 0.9d);
    L13:
        r28 = 0.2d - (((0.14285714285714285d - ((r20 * r6) * 0.875d)) * r6) * 0.8333333333333334d);
    L14:
        r1 = r0 * (1.0d - ((r6 * (0.3333333333333333d - ((r28 * r6) * 0.75d))) * 0.5d));
        goto L21
    L16:
        if (r0 > 0.036d) goto L12;
        if (r0 <= 0.0036d) goto L14;
    L5:
        r2 = false;
        goto L6
    }

    public static double atan(double r3) {
        return atan(r3, 0.0d, false);
    }

    private static double atan(double r24, double r26, boolean r28) {
        double r0 = r24;
        if (r0 != 0.0d) goto L8;
        if (r28 == true) goto L6;
        return r0;
    L6:
        return copySign(3.141592653589793d, r0);
    L8:
        if (r0 >= 0.0d) goto L10;
        r0 = -r0;
        double r2 = -r26;
        boolean r4 = true;
    L12:
        if (r0 <= 1.633123935319537E16d) goto L19;
        if ((r4 ^ r28) == false) goto L16;
        return -1.5707963267948966d;
    L16:
        return 1.5707963267948966d;
    L19:
        if (r0 >= 1.0d) goto L21;
        int r9 = (int) ((((((-1.7168146928204135d) * r0) * r0) + 8.0d) * r0) + 0.5d);
    L22:
        double r10 = TANGENT_TABLE_A[r9];
        double r12 = TANGENT_TABLE_B[r9];
        double r14 = r0 - r10;
        double r5 = (-((r14 - r0) + r10)) + (r2 - r12);
        double r7 = r14 + r5;
        double r6 = -((r7 - r14) - r5);
        double r16 = r0 * 1.073741824E9d;
        double r18 = (r0 + r16) - r16;
        double r3 = r2 + ((r0 + r2) - r18);
        if (r9 != 0) goto L25;
        double r8 = 1.0d / (((r18 + r3) * (r10 + r12)) + 1.0d);
        double r11 = r7 * r8;
        double r13 = r6 * r8;
    L26:
        double r1 = r11 * r11;
        double r15 = (((((((((((0.07490822288864472d * r1) - 0.09088450866185192d) * r1) + 0.11111095942313305d) * r1) - 0.1428571423679182d) * r1) + 0.19999999999923582d) * r1) - 0.33333333333333287d) * r1) * r11;
        double r17 = r11 + r15;
        double r19 = (-((r17 - r11) - r15)) + (r13 / (r1 + 1.0d));
        double r20 = EIGHTHS[r9];
        double r21 = r20 + r17;
        double r22 = r21 + r19;
        double r23 = (-((r21 - r20) - r17)) + (-((r22 - r21) - r19));
        double r25 = r22 + r23;
        if (r28 == false) goto L30;
        double r27 = -((r25 - r22) - r23);
        double r29 = 3.141592653589793d - r25;
        r25 = ((-((r29 - 3.141592653589793d) + r25)) + (1.2246467991473532E-16d - r27)) + r29;
    L30:
        if ((r4 ^ r28) == true) goto L32;
        return r25;
    L32:
        return -r25;
    L25:
        double r110 = r18 * r10;
        double r210 = r110 + 1.0d;
        double r30 = -((r210 - 1.0d) - r110);
        double r111 = (r10 * r3) + (r18 * r12);
        double r112 = r210 + r111;
        double r31 = (r30 + (-((r112 - r210) - r111))) + (r3 * r12);
        double r32 = r7 / r112;
        double r113 = r32 * 1.073741824E9d;
        double r114 = (r32 + r113) - r113;
        double r115 = r32 - r114;
        double r116 = 1.073741824E9d * r112;
        double r117 = (r112 + r116) - r116;
        double r118 = r112 - r117;
        r13 = ((((((r7 - (r114 * r117)) - (r114 * r118)) - (r117 * r115)) - (r115 * r118)) / r112) + ((((-r7) * r31) / r112) / r112)) + (r6 / r112);
        r11 = r32;
        goto L26
    L21:
        double r119 = 1.0d / r0;
        r9 = (int) ((-(((((-1.7168146928204135d) * r119) * r119) + 8.0d) * r119)) + 13.07d);
        goto L22
    L10:
        r2 = r26;
        r4 = false;
        goto L12
    }

    public static double atan2(double r20, double r22) {
        if (r22 == r22) goto L5;
        return Double.NaN;
    L5:
        if (r20 == r20) goto L8;
        return Double.NaN;
    L8:
        if (r20 != 0.0d) goto L30;
        double r11 = r22 * r20;
        double r13 = 1.0d / r22;
        double r9 = 1.0d / r20;
        if (r13 != 0.0d) goto L17;
        if (r22 <= 0.0d) goto L15;
        return r20;
    L15:
        return copySign(3.141592653589793d, r20);
    L17:
        if (r22 < 0.0d) goto L23;
        if (r13 < 0.0d) goto L23;
        return r11;
    L23:
        if (r20 >= 0.0d) goto L25;
    L28:
        return -3.141592653589793d;
    L25:
        if (r9 < 0.0d) goto L28;
        return 3.141592653589793d;
    L30:
        if (r20 != Double.POSITIVE_INFINITY) goto L41;
        if (r22 != Double.POSITIVE_INFINITY) goto L36;
        return 0.7853981633974483d;
    L36:
        if (r22 != Double.NEGATIVE_INFINITY) goto L39;
        return 2.356194490192345d;
    L39:
        return 1.5707963267948966d;
    L41:
        if (r20 != Double.NEGATIVE_INFINITY) goto L52;
        if (r22 != Double.POSITIVE_INFINITY) goto L47;
        return -0.7853981633974483d;
    L47:
        if (r22 != Double.NEGATIVE_INFINITY) goto L50;
        return -2.356194490192345d;
    L50:
        return -1.5707963267948966d;
    L52:
        if (r22 != Double.POSITIVE_INFINITY) goto L65;
        if (r20 > 0.0d) goto L63;
        double r12 = 1.0d / r20;
        if (r12 > 0.0d) goto L63;
        if (r20 >= 0.0d) goto L60;
        return -0.0d;
    L60:
        if (r12 >= 0.0d) goto L65;
        return -0.0d;
    L63:
        return 0.0d;
    L65:
        if (r22 != Double.NEGATIVE_INFINITY) goto L77;
        if (r20 > 0.0d) goto L75;
        double r14 = 1.0d / r20;
        if (r14 > 0.0d) goto L75;
        if (r20 >= 0.0d) goto L73;
    L74:
        return -3.141592653589793d;
    L73:
        if (r14 >= 0.0d) goto L77;
    L75:
        return 3.141592653589793d;
    L77:
        if (r22 != 0.0d) goto L88;
        if (r20 > 0.0d) goto L87;
        double r10 = 1.0d / r20;
        if (r10 > 0.0d) goto L87;
        if (r20 >= 0.0d) goto L85;
    L86:
        return -1.5707963267948966d;
    L85:
        if (r10 >= 0.0d) goto L88;
    L87:
        return 1.5707963267948966d;
    L88:
        double r4 = r20 / r22;
        boolean r7 = true;
        if (Double.isInfinite(r4) == true) goto L91;
        double r15 = doubleHighPart(r4);
        double r5 = r4 - r15;
        double r16 = doubleHighPart(r22);
        double r17 = r22 - r16;
        double r6 = r5 + (((((r20 - (r15 * r16)) - (r15 * r17)) - (r16 * r5)) - (r17 * r5)) / r22);
        double r18 = r15 + r6;
        double r8 = -((r18 - r15) - r6);
        if (r18 != 0.0d) goto L100;
        r18 = copySign(0.0d, r20);
    L100:
        if (r22 < 0.0d) goto L104;
        r7 = false;
    L104:
        return atan(r18, r8, r7);
    L91:
        if (r22 < 0.0d) goto L95;
        r7 = false;
    L95:
        return atan(r4, 0.0d, r7);
    }

    public static double atanh(double r24) {
        double r0 = r24;
        if (r0 >= 0.0d) goto L5;
        boolean r2 = true;
        r0 = -r0;
    L7:
        if (r0 <= 0.15d) goto L10;
        double r6 = 0.5d;
        r0 = log((r0 + 1.0d) / (1.0d - r0));
    L9:
        double r1 = r0 * r6;
        if (r2 == true) goto L23;
        return r1;
    L23:
        return -r1;
    L10:
        double r7 = r0 * r0;
        if (r0 <= 0.087d) goto L15;
        double r8 = r7 * ((((((((((((((0.058823529411764705d * r7) + 0.06666666666666667d) * r7) + 0.07692307692307693d) * r7) + 0.09090909090909091d) * r7) + 0.1111111111111111d) * r7) + 0.14285714285714285d) * r7) + 0.2d) * r7) + 0.3333333333333333d);
    L13:
        r6 = r8 + 1.0d;
        goto L9
    L15:
        if (r0 <= 0.031d) goto L18;
        r8 = r7 * ((((((((((0.07692307692307693d * r7) + 0.09090909090909091d) * r7) + 0.1111111111111111d) * r7) + 0.14285714285714285d) * r7) + 0.2d) * r7) + 0.3333333333333333d);
        goto L13
    L18:
        if (r0 <= 0.003d) goto L20;
        r8 = r7 * ((((((0.1111111111111111d * r7) + 0.14285714285714285d) * r7) + 0.2d) * r7) + 0.3333333333333333d);
        goto L13
    L20:
        r8 = r7 * ((0.2d * r7) + 0.3333333333333333d);
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public static double cbrt(double r23) {
        long r0 = Double.doubleToRawLongBits(r23);
        int r3 = ((int) ((r0 >> 52) & 2047)) + NetError.ERR_BT_FRAME_CODEC_ERROR;
        if (r3 == (-1023)) goto L5;
        int r6 = r3;
        boolean r5 = false;
        double r4 = r23;
    L10:
        if (r6 != 1024) goto L12;
        return r4;
    L12:
        double r7 = Double.longBitsToDouble((Long.MIN_VALUE & r0) | (((long) (((r6 / 3) + 1023) & 2047)) << 52));
        double r1 = Double.longBitsToDouble((r0 & 4503599627370495L) | 4607182418800017408L);
        double r9 = (((((((((-0.010714690733195933d) * r1) + 0.0875862700108075d) * r1) - 0.3058015757857271d) * r1) + 0.7249995199969751d) * r1) + 0.5039018405998233d) * CBRTTWO[(r6 % 3) + 2];
        double r8 = r4 / ((r7 * r7) * r7);
        double r10 = r9 + ((r8 - ((r9 * r9) * r9)) / ((r9 * 3.0d) * r9));
        double r11 = r10 + ((r8 - ((r10 * r10) * r10)) / ((r10 * 3.0d) * r10));
        double r13 = r11 * 1.073741824E9d;
        double r15 = (r11 + r13) - r13;
        double r14 = r11 - r15;
        double r17 = r15 * r15;
        double r2 = 1.073741824E9d * r17;
        double r21 = (r17 + r2) - r2;
        double r19 = (((r15 * r14) * 2.0d) + (r14 * r14)) + (r17 - r21);
        double r12 = ((r21 * r14) + (r15 * r19)) + (r19 * r14);
        double r22 = r21 * r15;
        double r16 = r8 - r22;
        double r18 = (r11 + ((r16 + ((-((r16 - r8) + r22)) - r12)) / ((3.0d * r11) * r11))) * r7;
        if (r5 == true) goto L15;
        return r18;
    L15:
        return r18 * 3.814697265625E-6d;
    L5:
        if (r23 != 0.0d) goto L7;
        return r23;
    L7:
        r4 = 1.8014398509481984E16d * r23;
        long r20 = Double.doubleToRawLongBits(r4);
        r5 = true;
        r6 = ((int) (2047 & (r20 >> 52))) + NetError.ERR_BT_FRAME_CODEC_ERROR;
        r0 = r20;
        goto L10
    }

    public static double ceil(double r4) {
        if (r4 == r4) goto L5;
        return r4;
    L5:
        double r0 = floor(r4);
        if (r0 != r4) goto L8;
        return r0;
    L8:
        double r1 = r0 + 1.0d;
        if (r1 == 0.0d) goto L11;
        return r1;
    L11:
        return r4 * r1;
    }

    public static double copySign(double r2, double r4) {
        long r0 = Double.doubleToRawLongBits(r2);
        if ((Double.doubleToRawLongBits(r4) ^ r0) < 0) goto L6;
        return r2;
    L6:
        return -r2;
    }

    public static double cos(double r11) {
        double r0 = 0.0d;
        if (r11 >= 0.0d) goto L6;
        r11 = -r11;
    L6:
        if (r11 == r11) goto L8;
    L29:
        return Double.NaN;
    L8:
        if (r11 == Double.POSITIVE_INFINITY) goto L29;
        int r7 = 0;
        if (r11 <= 3294198.0d) goto L14;
        double[] r1 = new double[3];
        reducePayneHanek(r11, r1);
        r7 = ((int) r1[0]) & 3;
        r11 = r1[1];
        r0 = r1[2];
    L16:
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L26;
        if (r7 == 2) goto L23;
        if (r7 == 3) goto L22;
        return Double.NaN;
    L22:
        return sinQ(r11, r0);
    L23:
        double r12 = cosQ(r11, r0);
    L25:
        return -r12;
    L26:
        r12 = sinQ(r11, r0);
        goto L25
    L28:
        return cosQ(r11, r0);
    L14:
        if (r11 <= 1.5707963267948966d) goto L16;
        CodyWaite r2 = new CodyWaite(r11);
        r7 = r2.getK() & 3;
        r11 = r2.getRemA();
        r0 = r2.getRemB();
        goto L16
    }

    private static double cosQ(double r4, double r6) {
        double r2 = 1.5707963267948966d - r4;
        return sinQ(r2, (-((r2 - 1.5707963267948966d) + r4)) + (6.123233995736766E-17d - r6));
    }

    public static double cosh(double r21) {
        double r0 = r21;
        if (r0 == r0) goto L6;
        return r0;
    L6:
        if (r0 <= 20.0d) goto L16;
        if (r0 < LOG_MAX_VALUE) goto L12;
        double r1 = r0 * 0.5d;
    L10:
        double r2 = exp(r1);
        return (0.5d * r2) * r2;
    L12:
        double r3 = exp(r21);
    L14:
        return r3 * 0.5d;
    L16:
        if (r0 < (-20.0d)) goto L18;
        double[] r4 = new double[2];
        if (r0 >= 0.0d) goto L24;
        r0 = -r0;
    L24:
        exp(r0, 0.0d, r4);
        double r5 = r4[0] + r4[1];
        double r6 = -((r5 - r4[0]) - r4[1]);
        double r9 = r5 * 1.073741824E9d;
        double r11 = (r5 + r9) - r9;
        double r10 = r5 - r11;
        double r15 = 1.0d / r5;
        double r7 = 1.073741824E9d * r15;
        double r17 = (r15 + r7) - r7;
        double r8 = r15 - r17;
        double r12 = (r8 + (((((1.0d - (r11 * r17)) - (r11 * r8)) - (r10 * r17)) - (r10 * r8)) * r15)) + (((-r6) * r15) * r15);
        double r13 = r5 + r17;
        double r14 = r6 + (-((r13 - r5) - r17));
        double r16 = r13 + r12;
        return (r16 + (r14 + (-((r16 - r13) - r12)))) * 0.5d;
    L18:
        if (r0 > (-LOG_MAX_VALUE)) goto L20;
        r1 = r0 * (-0.5d);
        goto L10
    L20:
        r3 = exp(-r0);
        goto L14
    }

    private static double doubleHighPart(double r2) {
        if (r2 <= (-Precision.SAFE_MIN)) goto L8;
        if (r2 >= Precision.SAFE_MIN) goto L8;
        return r2;
    L8:
        return Double.longBitsToDouble(Double.doubleToRawLongBits(r2) & (-1073741824));
    }

    public static double exp(double r3) {
        return exp(r3, 0.0d, null);
    }

    private static double exp(double r22, double r24, double[] r26) {
        int r5 = (int) r22;
        if (r22 >= 0.0d) goto L22;
        if (r22 >= (-746.0d)) goto L10;
        if (r26 == null) goto L8;
        r26[0] = 0.0d;
        r26[1] = 0.0d;
    L8:
        return 0.0d;
    L10:
        if (r5 >= (-709)) goto L15;
        double r0 = exp(r22 + 40.19140625d, r24, r26) / 2.8504009514401178E17d;
        if (r26 == null) goto L14;
        r26[0] = r26[0] / 2.8504009514401178E17d;
        r26[1] = r26[1] / 2.8504009514401178E17d;
    L14:
        return r0;
    L15:
        if (r5 != (-709)) goto L20;
        double r1 = exp(r22 + 1.494140625d, r24, r26) / 4.455505956692757d;
        if (r26 == null) goto L19;
        r26[0] = r26[0] / 4.455505956692757d;
        r26[1] = r26[1] / 4.455505956692757d;
    L19:
        return r1;
    L20:
        r5 = r5 - 1;
    L26:
        int r13 = r5 + 750;
        double r14 = ExpIntTable.access$000()[r13];
        double r16 = ExpIntTable.access$100()[r13];
        double r11 = r5;
        int r6 = (int) ((r22 - r11) * 1024.0d);
        double r7 = ExpFracTable.access$200()[r6];
        double r18 = ExpFracTable.access$300()[r6];
        double r2 = r22 - (r11 + (((double) r6) / 1024.0d));
        double r8 = (((((((0.04168701738764507d * r2) + 0.1666666505023083d) * r2) + 0.5000000000042687d) * r2) + 1.0d) * r2) - 3.940510424527919E-20d;
        double r3 = r14 * r7;
        double r15 = ((r14 * r18) + (r7 * r16)) + (r16 * r18);
        double r9 = r15 + r3;
        if (r9 != Double.POSITIVE_INFINITY) goto L30;
        return Double.POSITIVE_INFINITY;
    L30:
        if (r24 == 0.0d) goto L32;
        double r12 = r9 * r24;
        double r17 = ((((r12 * r8) + r12) + (r9 * r8)) + r15) + r3;
    L33:
        if (r26 == null) goto L35;
        r26[0] = r3;
        double r4 = r9 * r24;
        r26[1] = (((r4 * r8) + r4) + (r9 * r8)) + r15;
    L35:
        return r17;
    L32:
        r17 = ((r9 * r8) + r15) + r3;
        goto L33
    L22:
        if (r5 <= 709) goto L26;
        if (r26 == null) goto L25;
        r26[0] = Double.POSITIVE_INFINITY;
        r26[1] = 0.0d;
    L25:
        return Double.POSITIVE_INFINITY;
    }

    public static double expm1(double r1) {
        return expm1(r1, null);
    }

    private static double expm1(double r24, double[] r26) {
        double r0 = r24;
        if (r0 == r0) goto L5;
        return r0;
    L5:
        if (r0 != 0.0d) goto L8;
        return r0;
    L8:
        if (r0 > (-1.0d)) goto L10;
    L23:
        double[] r8 = new double[2];
        exp(r0, 0.0d, r8);
        if (r0 > 0.0d) goto L26;
        double r1 = r8[0] - 1.0d;
        return r1 + ((-((1.0d + r1) - r8[0])) + r8[1]);
    L26:
        return (r8[0] - 1.0d) + r8[1];
    L10:
        if (r0 >= 1.0d) goto L23;
        if (r0 >= 0.0d) goto L15;
        r0 = -r0;
        boolean r2 = true;
    L16:
        int r5 = (int) (r0 * 1024.0d);
        double r6 = ExpFracTable.access$200()[r5] - 1.0d;
        double r12 = ExpFracTable.access$300()[r5];
        double r14 = r6 + r12;
        double r16 = r14 * 1.073741824E9d;
        double r18 = (r14 + r16) - r16;
        double r7 = (-((r14 - r6) - r12)) + (r14 - r18);
        double r3 = r0 - (((double) r5) / 1024.0d);
        double r4 = (((((((0.008336750013465571d * r3) + 0.041666663879186654d) * r3) + 0.16666666666745392d) * r3) + 0.49999999999999994d) * r3) * r3;
        double r15 = r3 + r4;
        double r9 = -((r15 - r3) - r4);
        double r10 = r15 * 1.073741824E9d;
        double r17 = (r15 + r10) - r10;
        double r11 = r9 + (r15 - r17);
        double r13 = r17 * r18;
        double r19 = r17 * r7;
        double r20 = r13 + r19;
        double r21 = -((r20 - r13) - r19);
        double r110 = r11 * r18;
        double r22 = r20 + r110;
        double r23 = r21 + (-((r22 - r20) - r110));
        double r111 = r11 * r7;
        double r25 = r22 + r111;
        double r27 = r23 + (-((r25 - r22) - r111));
        double r112 = r25 + r18;
        double r28 = r112 + r17;
        double r29 = (r27 + (-((r112 - r18) - r25))) + (-((r28 - r112) - r17));
        double r113 = r28 + r7;
        double r30 = r113 + r11;
        double r31 = (r29 + (-((r113 - r28) - r7))) + (-((r30 - r113) - r11));
        if (r2 == false) goto L19;
        double r32 = r30 + 1.0d;
        double r33 = 1.0d / r32;
        double r34 = (-((r32 - 1.0d) - r30)) + r31;
        double r114 = r30 * r33;
        double r115 = r114 * 1.073741824E9d;
        double r35 = (r114 + r115) - r115;
        double r116 = r114 - r35;
        double r117 = 1.073741824E9d * r32;
        double r118 = (r32 + r117) - r117;
        double r36 = r32 - r118;
        double r119 = ((r116 + (((((r30 - (r118 * r35)) - (r118 * r116)) - (r36 * r35)) - (r36 * r116)) * r33)) + (r31 * r33)) + ((((-r30) * r34) * r33) * r33);
        r30 = -r35;
        r31 = -r119;
    L19:
        if (r26 == null) goto L22;
        r26[0] = r30;
        r26[1] = r31;
    L22:
        return r30 + r31;
    L15:
        r2 = false;
        goto L16
    }

    public static double floor(double r4) {
        if (r4 == r4) goto L6;
        return r4;
    L6:
        if (r4 < 4.503599627370496E15d) goto L8;
        return r4;
    L8:
        if (r4 <= (-4.503599627370496E15d)) goto L22;
        long r0 = (long) r4;
        if (r4 >= 0.0d) goto L16;
        if (r0 == r4) goto L16;
        r0 = r0 - 1;
    L16:
        if (r0 != 0) goto L20;
        return r4 * r0;
    L20:
        return r0;
    L22:
        return r4;
    }

    public static int getExponent(double r2) {
        return ((int) ((Double.doubleToRawLongBits(r2) >>> 52) & 2047)) + NetError.ERR_BT_FRAME_CODEC_ERROR;
    }

    public static int getExponent(float r0) {
        return ((Float.floatToRawIntBits(r0) >>> 23) & 255) + NetError.ERR_PROXY_AUTH_REQUESTED;
    }

    public static double hypot(double r3, double r5) {
        if (Double.isInfinite(r3) == false) goto L5;
        return Double.POSITIVE_INFINITY;
    L5:
        if (Double.isInfinite(r5) == false) goto L8;
        return Double.POSITIVE_INFINITY;
    L8:
        if (Double.isNaN(r3) == false) goto L10;
        return Double.NaN;
    L10:
        if (Double.isNaN(r5) == true) goto L26;
        int r0 = getExponent(r3);
        int r1 = getExponent(r5);
        if (r0 <= (r1 + 27)) goto L17;
        return abs(r3);
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r4 = -r2;
        double r6 = scalb(r3, r4);
        double r7 = scalb(r5, r4);
        return scalb(sqrt((r6 * r6) + (r7 * r7)), r2);
    L19:
        return abs(r5);
    L26:
        return Double.NaN;
    }

    public static double log(double r1) {
        return log(r1, null);
    }

    private static double log(double r23, double[] r25) {
        if (r23 != 0.0d) goto L5;
        return Double.NEGATIVE_INFINITY;
    L5:
        long r5 = Double.doubleToRawLongBits(r23);
        if ((Long.MIN_VALUE & r5) == 0) goto L8;
    L9:
        if (r23 != 0.0d) goto L11;
    L15:
        if (r23 != Double.POSITIVE_INFINITY) goto L19;
        if (r25 == null) goto L18;
        r25[0] = Double.POSITIVE_INFINITY;
    L18:
        return Double.POSITIVE_INFINITY;
    L19:
        int r7 = ((int) (r5 >> 52)) + NetError.ERR_BT_FRAME_CODEC_ERROR;
        if ((9218868437227405312L & r5) != 0) goto L30;
        if (r23 != 0.0d) goto L25;
        if (r25 == null) goto L24;
        r25[0] = Double.NEGATIVE_INFINITY;
    L24:
        return Double.NEGATIVE_INFINITY;
    L25:
        r5 = r5 << 1;
    L27:
        if ((4503599627370496L & r5) != 0) goto L30;
        r7 = r7 - 1;
        r5 = r5 << 1;
    L30:
        if (r7 == (-1)) goto L33;
        if (r7 == 0) goto L33;
    L42:
        long r13 = 4499201580859392L & r5;
        double[] r0 = lnMant.access$400()[(int) (r13 >> 42)];
        double r4 = r5 & 4398046511103L;
        double r14 = r13 + 4.503599627370496E15d;
        double r17 = r4 / r14;
        if (r25 == null) goto L48;
        double r1 = r17 * 1.073741824E9d;
        double r19 = (r17 + r1) - r1;
        double r18 = r17 - r19;
        double r110 = r18 + (((r4 - (r19 * r14)) - (r18 * r14)) / r14);
        double[][] r2 = LN_HI_PREC_COEF;
        double[] r3 = r2[r2.length - 1];
        double r6 = r3[0];
        double r8 = r3[1];
        int r9 = r2.length - 2;
    L45:
        if (r9 < 0) goto L47;
        double r15 = r6 * r19;
        double r10 = ((r6 * r110) + (r8 * r19)) + (r8 * r110);
        double r11 = r15 * 1.073741824E9d;
        double r21 = (r15 + r11) - r11;
        double r16 = (r15 - r21) + r10;
        double[] r12 = LN_HI_PREC_COEF[r9];
        double r22 = r21 + r12[0];
        double r111 = r16 + r12[1];
        double r20 = r22 * 1.073741824E9d;
        r6 = (r22 + r20) - r20;
        r8 = (r22 - r6) + r111;
        r9 = r9 - 1;
        goto L45
    L47:
        double r24 = r6 * r19;
        double r26 = ((r6 * r110) + (r19 * r8)) + (r8 * r110);
        double r27 = r24 + r26;
        double r28 = -((r27 - r24) - r26);
    L49:
        double r29 = r7;
        double r30 = 0.6931470632553101d * r29;
        double r112 = r0[0] + r30;
        double r113 = r112 + r27;
        double r31 = ((-((r112 - r30) - r0[0])) + 0.0d) + (-((r113 - r112) - r27));
        double r32 = r29 * 1.1730463525082348E-7d;
        double r33 = r113 + r32;
        double r34 = r31 + (-((r33 - r113) - r32));
        double r35 = r0[1] + r33;
        double r36 = r34 + (-((r35 - r33) - r0[1]));
        double r37 = r35 + r28;
        double r38 = r36 + (-((r37 - r35) - r28));
        if (r25 == null) goto L53;
        r25[0] = r37;
        r25[1] = r38;
    L53:
        return r37 + r38;
    L48:
        r27 = (((((((((((-0.16624882440418567d) * r17) + 0.19999954120254515d) * r17) - 0.2499999997677497d) * r17) + 0.3333333333332802d) * r17) - 0.5d) * r17) + 1.0d) * r17;
        r28 = 0.0d;
    L33:
        if (r23 >= 1.01d) goto L42;
        if (r23 <= 0.99d) goto L42;
        if (r25 != null) goto L42;
        double r39 = r23 - 1.0d;
        double r40 = r39 * 1.073741824E9d;
        double r41 = (r39 + r40) - r40;
        double r42 = r39 - r41;
        double[][] r43 = LN_QUICK_COEF;
        double[] r44 = r43[r43.length - 1];
        double r45 = r44[0];
        double r114 = r44[1];
        int r46 = r43.length - 2;
    L38:
        if (r46 < 0) goto L40;
        double r115 = r45 * r41;
        double r47 = ((r45 * r42) + (r114 * r41)) + (r114 * r42);
        double r116 = r115 * 1.073741824E9d;
        double r117 = (r115 + r116) - r116;
        double r118 = (r115 - r117) + r47;
        double[] r48 = LN_QUICK_COEF[r46];
        double r119 = r117 + r48[0];
        double r49 = r119 * 1.073741824E9d;
        r45 = (r119 + r49) - r49;
        r114 = (r119 - r45) + (r118 + r48[1]);
        r46 = r46 - 1;
        goto L38
    L40:
        double r50 = r45 * r41;
        double r51 = ((r45 * r42) + (r41 * r114)) + (r114 * r42);
        double r52 = 1.073741824E9d * r50;
        double r53 = (r50 + r52) - r52;
        return r53 + ((r50 - r53) + r51);
    L11:
        if (r25 == null) goto L13;
        r25[0] = Double.NaN;
    L13:
        return Double.NaN;
    L8:
        if (r23 == r23) goto L15;
        goto L9
    }

    public static double log10(double r7) {
        double[] r0 = new double[2];
        double r8 = log(r7, r0);
        if (Double.isInfinite(r8) == false) goto L5;
        return r8;
    L5:
        double r1 = r0[0] * 1.073741824E9d;
        double r3 = (r0[0] + r1) - r1;
        double r9 = (r0[0] - r3) + r0[1];
        return (((r9 * 1.9699272335463627E-8d) + (1.9699272335463627E-8d * r3)) + (r9 * 0.4342944622039795d)) + (r3 * 0.4342944622039795d);
    }

    public static double log1p(double r10) {
        if (r10 != (-1.0d)) goto L7;
        return Double.NEGATIVE_INFINITY;
    L7:
        if (r10 != Double.POSITIVE_INFINITY) goto L10;
        return Double.POSITIVE_INFINITY;
    L10:
        if (r10 <= 1.0E-6d) goto L12;
    L16:
        double r5 = r10 + 1.0d;
        double r11 = -((r5 - 1.0d) - r10);
        double[] r0 = new double[2];
        double r7 = log(r5, r0);
        if (Double.isInfinite(r7) == false) goto L19;
        return r7;
    L19:
        double r12 = r11 / r5;
        return ((((0.5d * r12) + 1.0d) * r12) + r0[1]) + r0[0];
    L12:
        if (r10 < (-1.0E-6d)) goto L16;
        return ((((0.3333333333333333d * r10) - 0.5d) * r10) + 1.0d) * r10;
    }

    public static double max(double r4, double r6) {
        if (r4 <= r6) goto L6;
        return r4;
    L6:
        if (r4 >= r6) goto L8;
        return r6;
    L8:
        if (r4 == r6) goto L12;
        return Double.NaN;
    L12:
        if (Double.doubleToRawLongBits(r4) != Long.MIN_VALUE) goto L14;
        return r6;
    L14:
        return r4;
    }

    public static int max(int r0, int r1) {
        if (r0 <= r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static double min(double r4, double r6) {
        if (r4 <= r6) goto L6;
        return r6;
    L6:
        if (r4 >= r6) goto L8;
        return r4;
    L8:
        if (r4 == r6) goto L12;
        return Double.NaN;
    L12:
        if (Double.doubleToRawLongBits(r4) != Long.MIN_VALUE) goto L14;
        return r4;
    L14:
        return r6;
    }

    public static int min(int r0, int r1) {
        if (r0 > r1) goto L5;
        return r0;
    L5:
        return r1;
    }

    public static long min(long r1, long r3) {
        if (r1 > r3) goto L6;
        return r1;
    L6:
        return r3;
    }

    private static double polyCosine(double r4) {
        double r5 = r4 * r4;
        return ((((((2.479773539153719E-5d * r5) - 0.0013888888689039883d) * r5) + 0.041666666666621166d) * r5) - 0.49999999999999994d) * r5;
    }

    private static double polySine(double r6) {
        double r0 = r6 * r6;
        return (((((((2.7553817452272217E-6d * r0) - 1.9841269659586505E-4d) * r0) + 0.008333333333329196d) * r0) - 0.16666666666666666d) * r0) * r6;
    }

    public static double pow(double r24, double r26) {
        if (r26 != 0.0d) goto L5;
        return 1.0d;
    L5:
        long r7 = Double.doubleToRawLongBits(r26);
        int r11 = (int) ((r7 & 9218868437227405312L) >> 52);
        long r8 = r7 & 4503599627370495L;
        long r16 = Double.doubleToRawLongBits(r24);
        int r9 = (int) ((r16 & 9218868437227405312L) >> 52);
        long r12 = r16 & 4503599627370495L;
        if (r11 <= 1085) goto L30;
        if (r11 == 2047) goto L9;
    L10:
        if (r9 == 2047) goto L12;
    L14:
        if (r9 == 1023) goto L16;
    L20:
        if (r26 <= 0.0d) goto L22;
        boolean r0 = true;
    L23:
        if (r9 >= 1023) goto L25;
        boolean r14 = true;
    L27:
        if ((r0 ^ r14) == false) goto L29;
        return Double.POSITIVE_INFINITY;
    L29:
        return 0.0d;
    L25:
        r14 = false;
        goto L27
    L22:
        r0 = false;
        goto L23
    L16:
        if (r12 != 0) goto L20;
        if (r11 != 2047) goto L19;
        return Double.NaN;
    L19:
        return 1.0d;
    L12:
        if (r12 == 0) goto L14;
    L13:
        return Double.NaN;
    L9:
        if (r8 != 0) goto L13;
    L30:
        if (r11 < 1023) goto L46;
        long r10 = r8 | 4503599627370496L;
        if (r11 >= 1075) goto L40;
        int r4 = 1075 - r11;
        if ((((-1) << r4) & r10) != r10) goto L46;
        long r5 = r10 >> r4;
        if (r26 >= 0.0d) goto L39;
        r5 = -r5;
    L39:
        return pow(r24, r5);
    L40:
        long r6 = r10 << (r11 - 1075);
        if (r26 >= 0.0d) goto L44;
        r6 = -r6;
    L44:
        return pow(r24, r6);
    L46:
        if (r24 == 0.0d) goto L48;
        if (r9 != 2047) goto L61;
        if (r12 == 0) goto L55;
        return Double.NaN;
    L55:
        if (r26 >= 0.0d) goto L58;
        return 0.0d;
    L58:
        return Double.POSITIVE_INFINITY;
    L61:
        if (r24 >= 0.0d) goto L63;
        return Double.NaN;
    L63:
        double r13 = r26 * 1.073741824E9d;
        double r15 = (r26 + r13) - r13;
        double r17 = r26 - r15;
        double[] r18 = new double[2];
        double r1 = log(r24, r18);
        if (Double.isInfinite(r1) == false) goto L66;
        return r1;
    L66:
        double r2 = r18[0];
        double r3 = 1.073741824E9d * r2;
        double r19 = (r2 + r3) - r3;
        double r110 = r18[1] + (r2 - r19);
        double r20 = r19 * r15;
        double r111 = ((r19 * r17) + (r15 * r110)) + (r110 * r17);
        double r21 = r20 + r111;
        double r22 = -((r21 - r20) - r111);
        return exp(r21, ((((((((0.008333333333333333d * r22) + 0.041666666666666664d) * r22) + 0.16666666666666666d) * r22) + 0.5d) * r22) + 1.0d) * r22, null);
    L48:
        if (r26 < 0.0d) goto L50;
        return 0.0d;
    L50:
        return Double.POSITIVE_INFINITY;
    }

    public static double pow(double r2, int r4) {
        return pow(r2, r4);
    }

    public static double pow(double r2, long r4) {
        if (r4 != 0) goto L6;
        return 1.0d;
    L6:
        if (r4 <= 0) goto L10;
        Split r3 = Split.access$500(new Split(r2), r4);
    L9:
        return Split.access$600(r3);
    L10:
        r3 = Split.access$500(new Split(r2).reciprocal(), -r4);
        goto L9
    }

    private static void reducePayneHanek(double r36, double[] r38) {
        long r0 = Double.doubleToRawLongBits(r36);
        int r2 = (((int) ((r0 >> 52) & 2047)) + NetError.ERR_BT_FRAME_CODEC_ERROR) + 1;
        long r1 = ((r0 & 4503599627370495L) | 4503599627370496L) << 11;
        int r4 = r2 >> 6;
        int r3 = r2 - (r4 << 6);
        if (r3 == 0) goto L8;
        if (r4 != 0) goto L6;
        long r8 = 0;
    L7:
        long[] r10 = RECIP_2PI;
        int r13 = 64 - r3;
        long r9 = r8 | (r10[r4] >>> r13);
        int r14 = r4 + 1;
        long r11 = (r10[r4] << r3) | (r10[r14] >>> r13);
        long r15 = (r10[r14] << r3) | (r10[r4 + 2] >>> r13);
    L12:
        long r16 = r1 >>> 32;
        long r5 = r1 & 4294967295L;
        long r19 = r11 >>> 32;
        long r12 = r11 & 4294967295L;
        long r21 = r16 * r19;
        long r23 = r5 * r12;
        long r110 = r19 * r5;
        long r17 = r12 * r16;
        long r25 = r23 + (r17 << 32);
        long r22 = r21 + (r17 >>> 32);
        if ((r23 & Long.MIN_VALUE) == 0) goto L15;
        boolean r6 = true;
    L17:
        if ((r17 & 2147483648L) == 0) goto L19;
        boolean r18 = true;
    L20:
        long r29 = r25 & Long.MIN_VALUE;
        if (r29 == 0) goto L23;
        boolean r210 = true;
    L25:
        if (r6 == false) goto L27;
        if (r18 == false) goto L27;
    L30:
        r22 = r22 + 1;
    L31:
        if (r29 == 0) goto L33;
        boolean r7 = true;
    L35:
        if ((r110 & 2147483648L) == 0) goto L37;
        boolean r111 = true;
    L38:
        long r26 = r25 + (r110 << 32);
        long r24 = r22 + (r110 >>> 32);
        long r112 = r26 & Long.MIN_VALUE;
        if (r112 == 0) goto L41;
        boolean r113 = true;
    L42:
        if (r7 == false) goto L44;
        if (r111 == false) goto L44;
    L47:
        r24 = r24 + 1;
    L48:
        long r114 = r15 >>> 32;
        long r32 = (r16 * r114) + (((r114 * r5) + ((r15 & 4294967295L) * r16)) >>> 32);
        if (r112 == 0) goto L51;
        boolean r20 = true;
    L53:
        if ((r32 & Long.MIN_VALUE) == 0) goto L55;
        boolean r115 = true;
    L56:
        long r27 = r26 + r32;
        if ((r27 & Long.MIN_VALUE) == 0) goto L59;
        boolean r116 = true;
    L60:
        if (r20 == false) goto L62;
        if (r115 == false) goto L62;
    L65:
        r24 = r24 + 1;
    L66:
        long r117 = r9 >>> 32;
        long r28 = r9 & 4294967295L;
        long r211 = r24 + ((r5 * r28) + (((r5 * r117) + (r16 * r28)) << 32));
        int r30 = (int) (r211 >>> 62);
        long r31 = (r211 << 2) | (r27 >>> 62);
        long r118 = r27 << 2;
        long r119 = r31 >>> 32;
        long r33 = r31 & 4294967295L;
        long[] r34 = PI_O_4_BITS;
        long r120 = r34[0] >>> 32;
        long r121 = r34[0] & 4294967295L;
        long r212 = r119 * r120;
        long r213 = r33 * r121;
        long r122 = r120 * r33;
        long r123 = r121 * r119;
        long r35 = r213 + (r123 << 32);
        long r214 = r212 + (r123 >>> 32);
        if ((r213 & Long.MIN_VALUE) == 0) goto L69;
        boolean r37 = true;
    L71:
        if ((r123 & 2147483648L) == 0) goto L73;
        boolean r124 = true;
    L74:
        long r215 = r35 & Long.MIN_VALUE;
        if (r215 == 0) goto L77;
        boolean r216 = true;
    L78:
        if (r37 == false) goto L80;
        if (r124 == false) goto L80;
    L83:
        r214 = r214 + 1;
    L84:
        if (r215 == 0) goto L86;
        boolean r39 = true;
    L88:
        if ((r122 & 2147483648L) == 0) goto L90;
        boolean r125 = true;
    L91:
        long r310 = r35 + (r122 << 32);
        long r217 = r214 + (r122 >>> 32);
        long r126 = r310 & Long.MIN_VALUE;
        if (r126 == 0) goto L94;
        boolean r127 = true;
    L95:
        if (r39 == false) goto L97;
        if (r125 == false) goto L97;
    L100:
        r217 = r217 + 1;
    L101:
        long r128 = r34[1] >>> 32;
        long r218 = (r119 * r128) + (((r33 * r128) + (r119 * (r34[1] & 4294967295L))) >>> 32);
        if (r126 == 0) goto L104;
        boolean r40 = true;
    L106:
        if ((r218 & Long.MIN_VALUE) == 0) goto L108;
        boolean r41 = true;
    L109:
        long r311 = r310 + r218;
        long r129 = r311 & Long.MIN_VALUE;
        if (r129 == 0) goto L112;
        boolean r130 = true;
    L113:
        if (r40 == false) goto L115;
        if (r41 == false) goto L115;
    L118:
        r217 = r217 + 1;
    L119:
        long r131 = r118 >>> 32;
        long r132 = r34[0] >>> 32;
        long r133 = (r131 * r132) + ((((r118 & 4294967295L) * r132) + (r131 * (r34[0] & 4294967295L))) >>> 32);
        if (r129 == 0) goto L122;
        boolean r42 = true;
    L124:
        if ((r133 & Long.MIN_VALUE) == 0) goto L126;
        boolean r43 = true;
    L127:
        long r312 = r311 + r133;
        if ((r312 & Long.MIN_VALUE) == 0) goto L130;
        boolean r44 = true;
    L131:
        if (r42 == false) goto L133;
        if (r43 == false) goto L133;
    L136:
        r217 = r217 + 1;
    L137:
        double r45 = (r217 >>> 12) / 4.503599627370496E15d;
        double r134 = ((((r217 & 4095) << 40) + (r312 >>> 24)) / 4.503599627370496E15d) / 4.503599627370496E15d;
        double r46 = r45 + r134;
        r38[0] = r30;
        r38[1] = r46 * 2.0d;
        r38[2] = (-((r46 - r45) - r134)) * 2.0d;
        return;
    L133:
        if (r42 == true) goto L135;
        if (r43 == false) goto L137;
    L135:
        if (r44 == true) goto L137;
    L130:
        r44 = false;
        goto L131
    L126:
        r43 = false;
        goto L127
    L122:
        r42 = false;
    L115:
        if (r40 == true) goto L117;
        if (r41 == false) goto L119;
    L117:
        if (r130 == true) goto L119;
    L112:
        r130 = false;
        goto L113
    L108:
        r41 = false;
        goto L109
    L104:
        r40 = false;
    L97:
        if (r39 == true) goto L99;
        if (r125 == false) goto L101;
    L99:
        if (r127 == true) goto L101;
    L94:
        r127 = false;
        goto L95
    L90:
        r125 = false;
        goto L91
    L86:
        r39 = false;
    L80:
        if (r37 == true) goto L82;
        if (r124 == false) goto L84;
    L82:
        if (r216 == true) goto L84;
    L77:
        r216 = false;
        goto L78
    L73:
        r124 = false;
        goto L74
    L69:
        r37 = false;
    L62:
        if (r20 == true) goto L64;
        if (r115 == false) goto L66;
    L64:
        if (r116 == true) goto L66;
    L59:
        r116 = false;
        goto L60
    L55:
        r115 = false;
        goto L56
    L51:
        r20 = false;
    L44:
        if (r7 == true) goto L46;
        if (r111 == false) goto L48;
    L46:
        if (r113 == true) goto L48;
    L41:
        r113 = false;
        goto L42
    L37:
        r111 = false;
        goto L38
    L33:
        r7 = false;
    L27:
        if (r6 == true) goto L29;
        if (r18 == false) goto L31;
    L29:
        if (r210 == true) goto L31;
    L23:
        r210 = false;
        goto L25
    L19:
        r18 = false;
        goto L20
    L15:
        r6 = false;
        goto L17
    L6:
        r8 = RECIP_2PI[r4 - 1] << r3;
        goto L7
    L8:
        if (r4 != 0) goto L10;
        r9 = 0;
    L11:
        long[] r47 = RECIP_2PI;
        r11 = r47[r4];
        r15 = r47[r4 + 1];
        goto L12
    L10:
        r9 = RECIP_2PI[r4 - 1];
        goto L11
    }

    public static double rint(double r7) {
        double r0 = floor(r7);
        double r8 = r7 - r0;
        if (r8 <= 0.5d) goto L11;
        if (r0 != (-1.0d)) goto L9;
        return -0.0d;
    L9:
        return r0 + 1.0d;
    L11:
        if (r8 >= 0.5d) goto L14;
        return r0;
    L14:
        if ((((long) r0) & 1) != 0) goto L17;
        return r0;
    L17:
        return r0 + 1.0d;
    }

    public static long round(double r2) {
        return (long) floor(r2 + 0.5d);
    }

    public static double scalb(double r22, int r24) {
        if (r24 <= (-1023)) goto L9;
        if (r24 >= 1024) goto L9;
        return Double.longBitsToDouble(((long) (r24 + 1023)) << 52) * r22;
    L9:
        if (Double.isNaN(r22) == false) goto L11;
    L65:
        return r22;
    L11:
        if (Double.isInfinite(r22) == true) goto L65;
        if (r22 == 0.0d) goto L65;
        if (r24 >= (-2098)) goto L22;
        if (r22 <= 0.0d) goto L20;
        return 0.0d;
    L20:
        return -0.0d;
    L22:
        if (r24 <= 2097) goto L27;
        if (r22 <= 0.0d) goto L26;
        return Double.POSITIVE_INFINITY;
    L26:
        return Double.NEGATIVE_INFINITY;
    L27:
        long r4 = Double.doubleToRawLongBits(r22);
        long r12 = Long.MIN_VALUE & r4;
        int r14 = ((int) (r4 >>> 52)) & 2047;
        long r5 = r4 & 4503599627370495L;
        int r2 = r14 + r24;
        if (r24 >= 0) goto L44;
        if (r2 <= 0) goto L33;
        return Double.longBitsToDouble(((((long) r2) << 52) | r12) | r5);
    L33:
        if (r2 <= (-53)) goto L40;
        long r0 = 4503599627370496L | r5;
        long r6 = (1 << (-r2)) & r0;
        long r1 = r0 >>> (1 - r2);
        if (r6 == 0) goto L38;
        r1 = r1 + 1;
    L38:
        return Double.longBitsToDouble(r1 | r12);
    L40:
        if (r12 != 0) goto L43;
        return 0.0d;
    L43:
        return -0.0d;
    L44:
        if (r14 == 0) goto L46;
        if (r2 >= 2047) goto L61;
        return Double.longBitsToDouble(((((long) r2) << 52) | r12) | r5);
    L61:
        if (r12 != 0) goto L64;
        return Double.POSITIVE_INFINITY;
    L64:
        return Double.NEGATIVE_INFINITY;
    L46:
        if ((r5 >>> 52) == 1) goto L48;
        r5 = r5 << 1;
        r2 = r2 - 1;
        goto L46
    L48:
        int r3 = r2 + 1;
        long r7 = r5 & 4503599627370495L;
        if (r3 >= 2047) goto L53;
        return Double.longBitsToDouble(((((long) r3) << 52) | r12) | r7);
    L53:
        if (r12 != 0) goto L56;
        return Double.POSITIVE_INFINITY;
    L56:
        return Double.NEGATIVE_INFINITY;
    }

    public static double signum(double r3) {
        if (r3 >= 0.0d) goto L6;
        return -1.0d;
    L6:
        if (r3 <= 0.0d) goto L10;
        return 1.0d;
    L10:
        return r3;
    }

    public static double sin(double r12) {
        double r0 = 0.0d;
        int r4 = 0;
        if (r12 >= 0.0d) goto L5;
        double r5 = -r12;
        boolean r2 = true;
    L7:
        if (r5 != 0.0d) goto L14;
        if (Double.doubleToRawLongBits(r12) >= 0) goto L12;
        return -0.0d;
    L12:
        return 0.0d;
    L14:
        if (r5 == r5) goto L16;
    L39:
        return Double.NaN;
    L16:
        if (r5 == Double.POSITIVE_INFINITY) goto L39;
        if (r5 <= 3294198.0d) goto L22;
        double[] r13 = new double[3];
        reducePayneHanek(r5, r13);
        r4 = ((int) r13[0]) & 3;
        r5 = r13[1];
        r0 = r13[2];
    L24:
        if (r2 == false) goto L26;
        r4 = r4 ^ 2;
    L26:
        if (r4 == 0) goto L38;
        if (r4 == 1) goto L36;
        if (r4 == 2) goto L34;
        if (r4 == 3) goto L31;
        return Double.NaN;
    L31:
        double r14 = cosQ(r5, r0);
    L33:
        return -r14;
    L34:
        r14 = sinQ(r5, r0);
        goto L33
    L36:
        return cosQ(r5, r0);
    L38:
        return sinQ(r5, r0);
    L22:
        if (r5 <= 1.5707963267948966d) goto L24;
        CodyWaite r15 = new CodyWaite(r5);
        r4 = r15.getK() & 3;
        r5 = r15.getRemA();
        r0 = r15.getRemB();
        goto L24
    L5:
        r5 = r12;
        r2 = false;
        goto L7
    }

    private static double sinQ(double r23, double r25) {
        int r0 = (int) ((8.0d * r23) + 0.5d);
        double r1 = r23 - EIGHTHS[r0];
        double r3 = SINE_TABLE_A[r0];
        double r5 = SINE_TABLE_B[r0];
        double r7 = COSINE_TABLE_A[r0];
        double r9 = COSINE_TABLE_B[r0];
        double r11 = polySine(r1);
        double r13 = polyCosine(r1);
        double r15 = 1.073741824E9d * r1;
        double r17 = (r1 + r15) - r15;
        double r12 = r11 + (r1 - r17);
        double r16 = r3 + 0.0d;
        double r10 = (-((r16 - 0.0d) - r3)) + 0.0d;
        double r19 = r7 * r17;
        double r21 = r16 + r19;
        double r14 = ((((((r10 + (-((r21 - r16) - r19))) + (r3 * r13)) + (r7 * r12)) + r5) + (r9 * r17)) + (r5 * r13)) + (r9 * r12);
        if (r25 == 0.0d) goto L6;
        double r8 = (((r7 + r9) * (r13 + 1.0d)) - ((r3 + r5) * (r17 + r12))) * r25;
        double r2 = r21 + r8;
        r14 = r14 + (-((r2 - r21) - r8));
        r21 = r2;
    L6:
        return r21 + r14;
    }

    public static double sinh(double r21) {
        double r0 = r21;
        if (r0 == r0) goto L5;
        return r0;
    L5:
        double r3 = 0.5d;
        if (r0 <= 20.0d) goto L15;
        if (r0 < LOG_MAX_VALUE) goto L11;
    L9:
        double r1 = exp(r0 * r3);
        return (r3 * r1) * r1;
    L11:
        double r2 = exp(r21);
    L13:
        return r2 * r3;
    L15:
        if (r0 >= (-20.0d)) goto L21;
        r3 = -0.5d;
        if (r0 <= (-LOG_MAX_VALUE)) goto L9;
        r2 = exp(-r0);
        goto L13
    L21:
        if (r0 != 0.0d) goto L24;
        return r0;
    L24:
        if (r0 >= 0.0d) goto L26;
        r0 = -r0;
        boolean r4 = true;
    L28:
        if (r0 <= 0.25d) goto L30;
        double[] r9 = new double[2];
        exp(r0, 0.0d, r9);
        double r5 = r9[0] + r9[1];
        double r6 = -((r5 - r9[0]) - r9[1]);
        double r7 = r5 * 1.073741824E9d;
        double r10 = (r5 + r7) - r7;
        double r8 = r5 - r10;
        double r15 = 1.0d / r5;
        double r11 = 1.073741824E9d * r15;
        double r12 = (r15 + r11) - r11;
        double r17 = r15 - r12;
        double r13 = (r17 + (((((1.0d - (r10 * r12)) - (r10 * r17)) - (r8 * r12)) - (r8 * r17)) * r15)) + (((-r6) * r15) * r15);
        double r14 = -r12;
        double r16 = -r13;
        double r18 = r5 + r14;
        double r19 = r6 + (-((r18 - r5) - r14));
        double r20 = r18 + r16;
        double r22 = -((r20 - r18) - r16);
    L31:
        double r23 = (r20 + (r19 + r22)) * 0.5d;
        if (r4 == true) goto L34;
        return r23;
    L34:
        return -r23;
    L30:
        double[] r24 = new double[2];
        expm1(r0, r24);
        double r25 = r24[0] + r24[1];
        double r26 = -((r25 - r24[0]) - r24[1]);
        double r27 = r25 + 1.0d;
        double r28 = 1.0d / r27;
        double r110 = (-((r27 - 1.0d) - r25)) + r26;
        double r111 = r25 * r28;
        double r112 = r111 * 1.073741824E9d;
        double r113 = (r111 + r112) - r112;
        double r114 = r111 - r113;
        double r115 = 1.073741824E9d * r27;
        double r116 = (r27 + r115) - r115;
        double r29 = r27 - r116;
        double r117 = ((r114 + (((((r25 - (r116 * r113)) - (r116 * r114)) - (r29 * r113)) - (r29 * r114)) * r28)) + (r26 * r28)) + ((((-r25) * r110) * r28) * r28);
        double r30 = r25 + r113;
        r19 = r26 + (-((r30 - r25) - r113));
        r20 = r30 + r117;
        r22 = -((r20 - r30) - r117);
        goto L31
    L26:
        r4 = false;
        goto L28
    }

    public static double sqrt(double r0) {
        return Math.sqrt(r0);
    }

    public static double tan(double r13) {
        double r0 = 0.0d;
        if (r13 >= 0.0d) goto L5;
        double r5 = -r13;
        boolean r2 = true;
    L7:
        if (r5 != 0.0d) goto L14;
        if (Double.doubleToRawLongBits(r13) >= 0) goto L12;
        return -0.0d;
    L12:
        return 0.0d;
    L14:
        if (r5 == r5) goto L16;
        return Double.NaN;
    L16:
        if (r5 != Double.POSITIVE_INFINITY) goto L19;
        return Double.NaN;
    L19:
        if (r5 <= 3294198.0d) goto L22;
        double[] r14 = new double[3];
        reducePayneHanek(r5, r14);
        int r15 = 3 & ((int) r14[0]);
        r5 = r14[1];
        r0 = r14[2];
    L26:
        if (r5 <= 1.5d) goto L29;
        double r9 = 1.5707963267948966d - r5;
        double r6 = (-((r9 - 1.5707963267948966d) + r5)) + (6.123233995736766E-17d - r0);
        double r1 = r9 + r6;
        r15 = r15 ^ 1;
        r2 = !r2;
        r0 = -((r1 - r9) - r6);
        r5 = r1;
    L29:
        if ((r15 & 1) != 0) goto L31;
        double r16 = tanQ(r5, r0, false);
    L32:
        if (r2 == true) goto L34;
        return r16;
    L34:
        return -r16;
    L31:
        r16 = -tanQ(r5, r0, true);
        goto L32
    L22:
        if (r5 <= 1.5707963267948966d) goto L24;
        CodyWaite r17 = new CodyWaite(r5);
        r15 = 3 & r17.getK();
        r5 = r17.getRemA();
        r0 = r17.getRemB();
        goto L26
    L24:
        r15 = 0;
        goto L26
    L5:
        r5 = r13;
        r2 = false;
        goto L7
    }

    private static double tanQ(double r31, double r33, boolean r35) {
        int r0 = (int) ((8.0d * r31) + 0.5d);
        double r1 = r31 - EIGHTHS[r0];
        double r3 = SINE_TABLE_A[r0];
        double r5 = SINE_TABLE_B[r0];
        double r7 = COSINE_TABLE_A[r0];
        double r9 = COSINE_TABLE_B[r0];
        double r11 = polySine(r1);
        double r13 = polyCosine(r1);
        double r17 = r1 * 1.073741824E9d;
        double r19 = (r1 + r17) - r17;
        double r12 = r11 + (r1 - r19);
        double r18 = r3 + 0.0d;
        double r6 = (-((r18 - 0.0d) - r3)) + 0.0d;
        double r21 = r7 * r19;
        double r23 = r18 + r21;
        double r8 = ((r6 + (-((r23 - r18) - r21))) + ((r3 * r13) + (r7 * r12))) + (((r5 + (r9 * r19)) + (r5 * r13)) + (r9 * r12));
        double r2 = r23 + r8;
        double r10 = -((r2 - r23) - r8);
        double r22 = r7 * 1.0d;
        double r27 = r22 + 0.0d;
        double r29 = r2;
        double r4 = (-((r27 - 0.0d) - r22)) + 0.0d;
        double r24 = r10;
        double r14 = (-r3) * r19;
        double r25 = r27 + r14;
        double r15 = ((r4 + (-((r25 - r27) - r14))) + (((1.0d * r9) + (r7 * r13)) + (r9 * r13))) - (((r5 * r19) + (r3 * r12)) + (r5 * r12));
        double r16 = r25 + r15;
        double r20 = -((r16 - r25) - r15);
        if (r35 == false) goto L5;
        double r26 = r20;
        double r28 = r16;
    L6:
        double r30 = r28 / r29;
        double r32 = r30 * 1.073741824E9d;
        double r34 = (r30 + r32) - r32;
        double r36 = r30 - r34;
        double r110 = 1.073741824E9d * r29;
        double r111 = (r29 + r110) - r110;
        double r112 = r29 - r111;
        double r113 = ((((((r28 - (r34 * r111)) - (r34 * r112)) - (r111 * r36)) - (r36 * r112)) / r29) + (r26 / r29)) + ((((-r28) * r24) / r29) / r29);
        if (r33 == 0.0d) goto L13;
        double r37 = r33 + ((r30 * r30) * r33);
        if (r35 == false) goto L11;
        r37 = -r37;
    L11:
        r113 = r113 + r37;
    L13:
        return r30 + r113;
    L5:
        r26 = r24;
        r24 = r20;
        r28 = r29;
        r29 = r16;
        goto L6
    }

    public static double tanh(double r19) {
        double r0 = r19;
        if (r0 == r0) goto L6;
        return r0;
    L6:
        if (r0 <= 20.0d) goto L9;
        return 1.0d;
    L9:
        if (r0 >= (-20.0d)) goto L12;
        return -1.0d;
    L12:
        if (r0 != 0.0d) goto L15;
        return r0;
    L15:
        if (r0 >= 0.0d) goto L17;
        r0 = -r0;
        boolean r2 = true;
    L19:
        if (r0 < 0.5d) goto L21;
        double[] r11 = new double[2];
        exp(r0 * 2.0d, 0.0d, r11);
        double r1 = r11[0] + r11[1];
        double r7 = -((r1 - r11[0]) - r11[1]);
        double r5 = (-1.0d) + r1;
        double r12 = r5 + r7;
        double r9 = (-((r5 + 1.0d) - r1)) + (-((r12 - r5) - r7));
        double r6 = r1 + 1.0d;
        double r3 = r6 + r7;
        double r4 = (-((r6 - 1.0d) - r1)) + (-((r3 - r6) - r7));
        double r8 = r3 * 1.073741824E9d;
        double r10 = (r3 + r8) - r8;
        double r13 = r3 - r10;
        double r15 = r12 / r3;
        double r14 = 1.073741824E9d * r15;
        double r17 = (r15 + r14) - r14;
        double r16 = r15 - r17;
        double r18 = ((r16 + (((((r12 - (r10 * r17)) - (r10 * r16)) - (r13 * r17)) - (r13 * r16)) / r3)) + (r9 / r3)) + ((((-r4) * r12) / r3) / r3);
    L22:
        double r110 = r17 + r18;
        if (r2 == true) goto L25;
        return r110;
    L25:
        return -r110;
    L21:
        double[] r20 = new double[2];
        expm1(r0 * 2.0d, r20);
        double r21 = r20[0] + r20[1];
        double r22 = -((r21 - r20[0]) - r20[1]);
        double r23 = r21 + 2.0d;
        double r24 = r23 + r22;
        double r25 = (-((r23 - 2.0d) - r21)) + (-((r24 - r23) - r22));
        double r26 = r24 * 1.073741824E9d;
        double r111 = (r24 + r26) - r26;
        double r27 = r24 - r111;
        double r112 = r21 / r24;
        double r113 = 1.073741824E9d * r112;
        r17 = (r112 + r113) - r113;
        double r114 = r112 - r17;
        r18 = ((r114 + (((((r21 - (r111 * r17)) - (r111 * r114)) - (r27 * r17)) - (r27 * r114)) / r24)) + (r22 / r24)) + ((((-r25) * r21) / r24) / r24);
        goto L22
    L17:
        r2 = false;
        goto L19
    }

    public static double toDegrees(double r8) {
        if (Double.isInfinite(r8) == false) goto L5;
    L9:
        return r8;
    L5:
        if (r8 == 0.0d) goto L9;
        double r0 = doubleHighPart(r8);
        double r9 = r8 - r0;
        return (((r9 * 3.145894820876798E-6d) + (r9 * 57.2957763671875d)) + (3.145894820876798E-6d * r0)) + (r0 * 57.2957763671875d);
    }

    public static double toRadians(double r12) {
        if (Double.isInfinite(r12) == false) goto L5;
    L11:
        return r12;
    L5:
        if (r12 == 0.0d) goto L11;
        double r2 = doubleHighPart(r12);
        double r4 = r12 - r2;
        double r8 = (((r4 * 1.997844754509471E-9d) + (r4 * 0.01745329052209854d)) + (1.997844754509471E-9d * r2)) + (r2 * 0.01745329052209854d);
        if (r8 == 0.0d) goto L10;
        return r8;
    L10:
        return r8 * r12;
    }

    public static double ulp(double r4) {
        if (Double.isInfinite(r4) == false) goto L7;
        return Double.POSITIVE_INFINITY;
    L7:
        return abs(r4 - Double.longBitsToDouble(Double.doubleToRawLongBits(r4) ^ 1));
    }
}
