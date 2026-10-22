package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StepCurve extends Easing {
    private static final boolean DEBUG = false;
    MonotonicCurveFit mCurveFit;

    StepCurve(String r10) {
        this.str = r10;
        double[] r11 = new double[r10.length() / 2];
        int r12 = r10.indexOf(40) + 1;
        int r13 = r10.indexOf(44, r12);
        int r14 = 0;
    L4:
        if (r13 == (-1)) goto L6;
        r11[r14] = Double.parseDouble(r10.substring(r12, r13).trim());
        r12 = r13 + 1;
        r13 = r10.indexOf(44, r12);
        r14 = r14 + 1;
        goto L4
    L6:
        String r15 = r10.substring(r12, r10.indexOf(41, r12)).trim();
        r11[r14] = Double.parseDouble(r15);
        this.mCurveFit = genSpline(Arrays.copyOf(r11, r14 + 1));
    }

    private static MonotonicCurveFit genSpline(String r10) {
        String[] r11 = r10.split("\\s+");
        int r12 = r11.length;
        double[] r13 = new double[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L6;
        r13[r14] = Double.parseDouble(r11[r14]);
        r14 = r14 + 1;
        goto L3
    L6:
        return genSpline(r13);
    }

    private static MonotonicCurveFit genSpline(double[] r18) {
        int r10 = (r18.length * 3) - 2;
        int r11 = r18.length - 1;
        double r12 = 1.0d / ((double) r11);
        double[][] r13 = (double[][]) Array.newInstance(double.class, new int[]{r10, 1});
        double[] r14 = new double[r10];
        int r15 = 0;
    L4:
        if (r15 >= r18.length) goto L9;
        double r16 = r18[r15];
        int r17 = r15 + r11;
        r13[r17][0] = r16;
        double r19 = ((double) r15) * r12;
        r14[r17] = r19;
        if (r15 <= 0) goto L8;
        int r110 = (r11 * 2) + r15;
        r13[r110][0] = r16 + 1.0d;
        r14[r110] = r19 + 1.0d;
        int r111 = r15 - 1;
        r13[r111][0] = (r16 - 1.0d) - r12;
        r14[r111] = (r19 - 1.0d) - r12;
    L8:
        r15 = r15 + 1;
        goto L4
    L9:
        MonotonicCurveFit r20 = new MonotonicCurveFit(r14, r13);
        System.out.println(" 0 " + r20.getPos(0.0d, 0));
        System.out.println(" 1 " + r20.getPos(1.0d, 0));
        return r20;
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double r10) {
        return this.mCurveFit.getPos(r10, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double r10) {
        return this.mCurveFit.getSlope(r10, 0);
    }
}
