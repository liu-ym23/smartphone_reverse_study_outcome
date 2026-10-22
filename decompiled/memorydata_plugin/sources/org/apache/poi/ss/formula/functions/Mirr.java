package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* JADX INFO: loaded from: classes7.dex */
public class Mirr extends MultiOperandNumericFunction {
    public Mirr() {
        super(false, false);
    }

    private static double mirr(double[] r17, double r18, double r20) {
        double r3 = 1.0d;
        double r1 = ((double) r17.length) - 1.0d;
        int r5 = r17.length;
        double r7 = 0.0d;
        double r10 = 0.0d;
        int r9 = 0;
        int r12 = 0;
    L3:
        if (r9 >= r5) goto L8;
        double r13 = r17[r9];
        if (r13 >= r7) goto L7;
        r10 = r10 + (r13 / Math.pow((r18 + r3) + r20, r12));
        r12 = r12 + 1;
    L7:
        r9 = r9 + 1;
        r3 = 1.0d;
        r7 = 0.0d;
        goto L3
    L8:
        int r4 = r17.length;
        double r6 = 0.0d;
        int r8 = 0;
    L9:
        if (r8 >= r4) goto L14;
        double r11 = r17[r8];
        double r15 = r10;
        if (r11 <= 0.0d) goto L13;
        r6 = r6 + (r11 * Math.pow(r18 + 1.0d, r1 - ((double) r12)));
        r12 = r12 + 1;
    L13:
        r8 = r8 + 1;
        r10 = r15;
        goto L9
    L14:
        double r16 = r10;
        if (r6 == 0.0d) goto L20;
        if (r16 == 0.0d) goto L20;
        return Math.pow((-r6) / r16, 1.0d / r1) - 1.0d;
    L20:
        return 0.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    public double evaluate(double[] r13) {
        double r1 = r13[r13.length - 1];
        double r3 = r13[r13.length - 2];
        double[] r12 = Arrays.copyOf(r13, r13.length - 2);
        int r14 = r12.length;
        boolean r7 = true;
        int r6 = 0;
    L4:
        if (r6 >= r14) goto L10;
        if (r12[r6] >= 0.0d) goto L8;
        boolean r8 = true;
    L9:
        r7 = r7 & r8;
        r6 = r6 + 1;
        goto L4
    L8:
        r8 = false;
        goto L9
    L10:
        if (r7 == false) goto L13;
        return -1.0d;
    L13:
        int r15 = r12.length;
        boolean r9 = true;
        int r10 = 0;
    L14:
        if (r10 >= r15) goto L20;
        if (r12[r10] <= 0.0d) goto L18;
        boolean r11 = true;
    L19:
        r9 = r9 & r11;
        r10 = r10 + 1;
        goto L14
    L18:
        r11 = false;
        goto L19
    L20:
        if (r9 == true) goto L24;
        return mirr(r12, r1, r3);
    L24:
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    public int getMaxNumOperands() {
        return 3;
    }
}
