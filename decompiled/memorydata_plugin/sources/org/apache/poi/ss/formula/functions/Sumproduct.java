package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Sumproduct implements Function {
    public Sumproduct() {
    }

    private static boolean areasAllSameSize(TwoDEval[] r5, int r6, int r7) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        TwoDEval r3 = r5[r2];
        if (r3.getHeight() != r6) goto L6;
        if (r3.getWidth() != r7) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        return true;
    }

    private static ValueEval evaluateAreaSumProduct(ValueEval[] r13) {
        int r0 = r13.length;
        TwoDEval[] r14 = (TwoDEval[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r13, r0, TwoDEval[].class), TwoDEval[].class, "com.obric.memorydata.plugin");     // Catch: ArrayStoreException -> L23
        TwoDEval r2 = r14[0];
        int r3 = r2.getHeight();
        int r4 = r2.getWidth();
        if (areasAllSameSize(r14, r3, r4) == true) goto L12;
        int r1 = 1;
    L8:
        if (r1 >= r14.length) goto L11;
        throwFirstError(r14[r1]);
        r1 = r1 + 1;
        goto L8
    L11:
        return ErrorEval.VALUE_INVALID;
    L12:
        double r5 = 0.0d;
        int r6 = 0;
    L13:
        if (r6 >= r3) goto L22;
        int r7 = 0;
    L15:
        if (r7 >= r4) goto L20;
        double r8 = 1.0d;
        int r10 = 0;
    L17:
        if (r10 >= r0) goto L19;
        r8 = r8 * getProductTerm(r14[r10].getValue(r6, r7), false);
        r10 = r10 + 1;
        goto L17
    L19:
        r5 = r5 + r8;
        r7 = r7 + 1;
        goto L15
    L20:
        r6 = r6 + 1;
        goto L13
    L22:
        return new NumberEval(r5);
    L24:
        return ErrorEval.VALUE_INVALID;
    }

    private static ValueEval evaluateSingleProduct(ValueEval[] r6) {
        int r0 = r6.length;
        int r1 = r6.length;
        double r2 = 1.0d;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r2 = r2 * getScalarValue(r6[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        return new NumberEval(r2);
    }

    private static double getProductTerm(ValueEval r4, boolean r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == true) goto L22;
        if (r6 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, ErrorEval.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == false) goto L15;
        if (r5 == true) goto L13;
        return 0.0d;
    L13:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L15:
        if (ZeusTransformUtils.instanceOf(r6, NumericValueEval.class) == false) goto L19;
        return ((NumericValueEval) ZeusTransformUtils.preCheckCast(r6, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L19:
        throw new RuntimeException("Unexpected value eval class (" + r6.getClass().getName() + ")");
    L21:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r6, ErrorEval.class, "com.obric.memorydata.plugin"));
    L22:
        if (r5 == true) goto L25;
        return 0.0d;
    L25:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static double getScalarValue(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L9;
        RefEval r5 = (RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin");
        if (r5.getNumberOfSheets() > 1) goto L8;
        r4 = r5.getInnerValueEval(r5.getFirstSheetIndex());
        goto L9
    L8:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L9:
        if (r4 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L20;
        AreaEval r6 = (AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin");
        if (r6.isColumn() == false) goto L18;
        if (r6.isRow() == false) goto L18;
        r4 = r6.getRelativeValue(0, 0);
    L18:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L20:
        return getProductTerm(r4, true);
    L22:
        throw new RuntimeException("parameter may not be null");
    }

    private static void throwFirstError(TwoDEval r8) {
        TwoDEval r9 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r8, TwoDEval.class, "com.obric.memorydata.plugin");
        int r0 = r9.getHeight();
        int r2 = r9.getWidth();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L12;
        int r5 = 0;
    L5:
        if (r5 >= r2) goto L11;
        ValueEval r6 = r9.getValue(r4, r5);
        if (ZeusTransformUtils.instanceOf(r6, ErrorEval.class) == true) goto L10;
        r5 = r5 + 1;
        goto L5
    L10:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r6, ErrorEval.class, "com.obric.memorydata.plugin"));
    L11:
        r4 = r4 + 1;
        goto L3
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r1, int r2, int r3) {
        if (r1.length < 1) goto L5;
        ValueEval r0 = r1[0];
    L27:
        e = move-exception;
        return e.getErrorEval();
    L8:
        if (ZeusTransformUtils.instanceOf(r0, NumericValueEval.class) == false) goto L12;
        return evaluateSingleProduct(r1);
    L12:
        if (ZeusTransformUtils.instanceOf(r0, RefEval.class) == false) goto L16;
        return evaluateSingleProduct(r1);
    L16:
        if (ZeusTransformUtils.instanceOf(r0, TwoDEval.class) == false) goto L26;
        TwoDEval r4 = (TwoDEval) ZeusTransformUtils.preCheckCast(r0, TwoDEval.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L27
        if (r4.isRow() == false) goto L24;
        if (r4.isColumn() == false) goto L24;
        return evaluateSingleProduct(r1);
    L24:
        return evaluateAreaSumProduct(r1);
    L26:
        throw new RuntimeException("Invalid arg type for SUMPRODUCT: (" + r0.getClass().getName() + ")");
    L5:
        return ErrorEval.VALUE_INVALID;
    }
}
