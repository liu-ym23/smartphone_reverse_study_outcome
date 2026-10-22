package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public final class FinanceLib {
    public static double fv(double r6, double r8, double r10, double r12, boolean r14) {
        if (r6 == 0.0d) goto L5;
        double r0 = 1.0d;
        double r2 = r6 + 1.0d;
        double r4 = 1.0d - Math.pow(r2, r8);
        if (r14 == false) goto L10;
        r0 = r2;
    L10:
        return (((r4 * r0) * r10) / r6) - (r12 * Math.pow(r2, r8));
    L5:
        return (r12 + (r8 * r10)) * (-1.0d);
    }

    public static double nper(double r6, double r8, double r10, double r12, boolean r14) {
        if (r6 == 0.0d) goto L5;
        double r2 = 1.0d;
        double r4 = r6 + 1.0d;
        if (r14 == false) goto L9;
        r2 = r4;
    L9:
        double r3 = (r2 * r8) / r6;
        double r7 = r3 - r12;
        if (r7 >= 0.0d) goto L12;
        double r9 = Math.log(r12 - r3);
    L13:
        if (r7 >= 0.0d) goto L15;
        double r11 = Math.log((-r10) - r3);
    L16:
        double r13 = r9 - r11;
        return r13 / Math.log(r4);
    L15:
        r11 = Math.log(r10 + r3);
        goto L16
    L12:
        r9 = Math.log(r7);
        goto L13
    L5:
        return ((r12 + r10) * (-1.0d)) / r8;
    }

    public static double npv(double r8, double[] r10) {
        double r9 = r8 + 1.0d;
        int r0 = r10.length;
        double r1 = 0.0d;
        int r3 = 0;
        double r4 = r9;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + (r10[r3] / r4);
        r4 = r4 * r9;
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static double pmt(double r6, double r8, double r10, double r12, boolean r14) {
        if (r6 == 0.0d) goto L5;
        double r2 = r6 + 1.0d;
        double r13 = (r12 + (r10 * Math.pow(r2, r8))) * r6;
        if (r14 == false) goto L9;
        double r7 = r2;
    L11:
        return r13 / (r7 * (1.0d - Math.pow(r2, r8)));
    L9:
        r7 = 1.0d;
        goto L11
    L5:
        return ((r12 + r10) * (-1.0d)) / r8;
    }

    public static double pv(double r6, double r8, double r10, double r12, boolean r14) {
        if (r6 == 0.0d) goto L5;
        double r0 = 1.0d;
        double r2 = r6 + 1.0d;
        double r4 = (1.0d - Math.pow(r2, r8)) / r6;
        if (r14 == false) goto L10;
        r0 = r2;
    L10:
        return (((r4 * r0) * r10) - r12) / Math.pow(r2, r8);
    L5:
        return ((r8 * r10) + r12) * (-1.0d);
    }
}
