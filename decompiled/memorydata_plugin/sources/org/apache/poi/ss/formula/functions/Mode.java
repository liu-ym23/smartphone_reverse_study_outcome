package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Mode implements Function {
    public Mode() {
    }

    private static void collectValue(ValueEval r2, List<Double> r3, boolean r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == true) goto L22;
        if (r5 != BlankEval.instance) goto L7;
    L17:
        if (r4 == true) goto L20;
        return;
    L20:
        throw EvaluationException.invalidValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, NumberEval.class) == false) goto L16;
        r6.add(Double.valueOf(((NumberEval) ZeusTransformUtils.preCheckCast(r5, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue()));
        return;
    L16:
        throw new RuntimeException("Unexpected value type (" + r5.getClass().getName() + ")");
    L22:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    }

    private static void collectValues(ValueEval r6, List<Double> r7) {
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, TwoDEval.class) == false) goto L12;
        TwoDEval r10 = (TwoDEval) ZeusTransformUtils.preCheckCast(r8, TwoDEval.class, "com.obric.memorydata.plugin");
        int r0 = r10.getWidth();
        int r1 = r10.getHeight();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L9;
        collectValue(r10.getValue(r3, r4), r9, false);
        r4 = r4 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
        goto L5
    L10:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r8, RefEval.class) == false) goto L17;
        RefEval r11 = (RefEval) ZeusTransformUtils.preCheckCast(r8, RefEval.class, "com.obric.memorydata.plugin");
        int r2 = r11.getFirstSheetIndex();
        int r5 = r11.getLastSheetIndex();
    L14:
        if (r2 > r5) goto L16;
        collectValue(r11.getInnerValueEval(r2), r9, true);
        r2 = r2 + 1;
        goto L14
    L16:
        return;
    L17:
        collectValue(r8, r9, true);
    }

    public static double evaluate(double[] r13) {
        if (r13.length < 2) goto L24;
        int r0 = r13.length;
        int[] r1 = new int[r0];
        Arrays.fill(r1, 1);
        int r3 = r13.length;
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L13;
        int r6 = r5 + 1;
        int r7 = r13.length;
        int r8 = r6;
    L7:
        if (r8 >= r7) goto L12;
        if (r13[r5] != r13[r8]) goto L11;
        r1[r5] = r1[r5] + 1;
    L11:
        r8 = r8 + 1;
        goto L7
    L12:
        r5 = r6;
        goto L5
    L13:
        double r9 = 0.0d;
        int r10 = 0;
    L14:
        if (r4 >= r0) goto L19;
        if (r1[r4] <= r10) goto L18;
        r9 = r13[r4];
        r10 = r1[r4];
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        if (r10 <= 1) goto L22;
        return r9;
    L22:
        throw new EvaluationException(ErrorEval.NA);
    L24:
        throw new EvaluationException(ErrorEval.NA);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r4, int r5, int r6) {
        ArrayList r3 = new ArrayList();     // Catch: EvaluationException -> L11
        int r7 = r4.length;     // Catch: EvaluationException -> L11
        int r8 = 0;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        collectValues(r4[r0], r3);     // Catch: EvaluationException -> L11
        r0 = r0 + 1;     // Catch: EvaluationException -> L11
        goto L3
    L5:
        int r9 = r3.size();     // Catch: EvaluationException -> L11
        double[] r10 = new double[r9];     // Catch: EvaluationException -> L11
    L6:
        if (r8 >= r9) goto L8;
        r10[r8] = ((Double) ZeusTransformUtils.preCheckCast(r3.get(r8), Double.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: EvaluationException -> L11
        r8 = r8 + 1;     // Catch: EvaluationException -> L11
        goto L6
    L8:
        return new NumberEval(evaluate(r10));
    L11:
        e = move-exception;
        return e.getErrorEval();
    }
}
