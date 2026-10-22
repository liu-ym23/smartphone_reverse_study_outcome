package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class ArrayFunctionUtils {
    private static Double collectValue(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == false) goto L9;
        return Double.valueOf(((NumericValueEval) ZeusTransformUtils.preCheckCast(r4, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L9:
        if (ZeusTransformUtils.instanceOf(r4, StringValueEval.class) == false) goto L13;
        return OperandResolver.parseDouble(((StringValueEval) ZeusTransformUtils.preCheckCast(r4, StringValueEval.class, "com.obric.memorydata.plugin")).getStringValue().trim());
    L13:
        if (ZeusTransformUtils.instanceOf(r4, ErrorEval.class) == true) goto L21;
        if (r4 != BlankEval.instance) goto L19;
        return null;
    L19:
        throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + r4.getClass() + ")");
    L21:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin"));
    L23:
        throw new IllegalArgumentException("ve must not be null");
    }

    private static DoubleList collectValuesWithBlanks(ValueEval r11) {
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin");
        DoubleList r0 = new DoubleList();
        if (ZeusTransformUtils.instanceOf(r12, ThreeDEval.class) == false) goto L20;
        ThreeDEval r13 = (ThreeDEval) ZeusTransformUtils.preCheckCast(r12, ThreeDEval.class, "com.obric.memorydata.plugin");
        int r1 = r13.getFirstSheetIndex();
    L6:
        if (r1 > r13.getLastSheetIndex()) goto L18;
        int r2 = r13.getWidth();
        int r6 = r13.getHeight();
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L17;
        int r8 = 0;
    L10:
        if (r8 >= r2) goto L16;
        Double r9 = collectValue(r13.getValue(r1, r7, r8));
        if (r9 != null) goto L14;
        r0.add(Double.NaN);
    L15:
        r8 = r8 + 1;
        goto L10
    L14:
        r0.add(r9.doubleValue());
        goto L15
    L16:
        r7 = r7 + 1;
        goto L8
    L17:
        r1 = r1 + 1;
        goto L6
    L18:
        return r0;
    L20:
        if (ZeusTransformUtils.instanceOf(r12, TwoDEval.class) == false) goto L33;
        TwoDEval r14 = (TwoDEval) ZeusTransformUtils.preCheckCast(r12, TwoDEval.class, "com.obric.memorydata.plugin");
        int r3 = r14.getWidth();
        int r4 = r14.getHeight();
        int r10 = 0;
    L22:
        if (r10 >= r4) goto L31;
        int r15 = 0;
    L24:
        if (r15 >= r3) goto L30;
        Double r16 = collectValue(r14.getValue(r10, r15));
        if (r16 != null) goto L28;
        r0.add(Double.NaN);
    L29:
        r15 = r15 + 1;
        goto L24
    L28:
        r0.add(r16.doubleValue());
        goto L29
    L30:
        r10 = r10 + 1;
        goto L22
    L31:
        return r0;
    L33:
        if (ZeusTransformUtils.instanceOf(r12, RefEval.class) == false) goto L43;
        RefEval r17 = (RefEval) ZeusTransformUtils.preCheckCast(r12, RefEval.class, "com.obric.memorydata.plugin");
        int r5 = r17.getFirstSheetIndex();
    L36:
        if (r5 > r17.getLastSheetIndex()) goto L42;
        Double r18 = collectValue(r17.getInnerValueEval(r5));
        if (r18 != null) goto L40;
        r0.add(Double.NaN);
    L41:
        r5 = r5 + 1;
        goto L36
    L40:
        r0.add(r18.doubleValue());
        goto L41
    L42:
        return r0;
    L43:
        Double r19 = collectValue(r12);
        if (r19 != null) goto L46;
        r0.add(Double.NaN);
    L47:
        return r0;
    L46:
        r0.add(r19.doubleValue());
        goto L47
    }

    static List<DoubleList> getNumberArrays(ValueEval r7, ValueEval r8) {
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        double[] r11 = collectValuesWithBlanks(r9).toArray();
        double[] r12 = collectValuesWithBlanks(r10).toArray();
        if (r11.length != r12.length) goto L16;
        DoubleList r0 = new DoubleList();
        DoubleList r1 = new DoubleList();
        int r2 = Math.min(r11.length, r12.length);
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L14;
        if (Double.isNaN(r11[r4]) == true) goto L12;
        if (Double.isNaN(r12[r4]) == true) goto L12;
        r0.add(r11[r4]);
        r1.add(r12[r4]);
    L12:
        r4 = r4 + 1;
        goto L5
    L14:
        return Arrays.asList(new DoubleList[]{r0, r1});
    L16:
        throw new EvaluationException(ErrorEval.NA);
    }
}
