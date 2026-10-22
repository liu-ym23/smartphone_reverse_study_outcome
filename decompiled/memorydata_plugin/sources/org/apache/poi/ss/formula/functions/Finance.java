package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public class Finance {
    public static double fv(double r8, int r10, double r11, double r13, int r15) {
        double r2 = r8 + 1.0d;
        double r4 = r10;
        return -((r13 * Math.pow(r2, r4)) + (((r11 * ((((double) r15) * r8) + 1.0d)) * (Math.pow(r2, r4) - 1.0d)) / r8));
    }

    public static double ipmt(double r8, int r10, int r11, double r12) {
        return ipmt(r8, r10, r11, r12, 0.0d);
    }

    public static double ipmt(double r9, int r11, int r12, double r13, double r15) {
        return ipmt(r9, r11, r12, r13, r15, 0);
    }

    public static double ipmt(double r10, int r12, int r13, double r14, double r16, int r18) {
        double r0 = fv(r10, r12 - 1, pmt(r10, r13, r14, r16, r18), r14, r18) * r10;
        if (r18 == 1) goto L5;
        return r0;
    L5:
        return r0 / (1.0d + r10);
    }

    public static double pmt(double r7, int r9, double r10) {
        return pmt(r7, r9, r10, 0.0d);
    }

    public static double pmt(double r8, int r10, double r11, double r13) {
        return pmt(r8, r10, r11, r13, 0);
    }

    public static double pmt(double r12, int r14, double r15, double r17, int r19) {
        double r6 = r12 + 1.0d;
        double r8 = r14;
        return ((-r12) * ((Math.pow(r6, r8) * r15) + r17)) / (((r12 * ((double) r19)) + 1.0d) * (Math.pow(r6, r8) - 1.0d));
    }

    public static double ppmt(double r2, int r4, int r5, double r6) {
        return pmt(r2, r5, r6) - ipmt(r2, r4, r5, r6);
    }
}
