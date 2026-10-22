package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;

/* JADX INFO: loaded from: classes7.dex */
final class ArgumentsEvaluator {
    public static final ArgumentsEvaluator instance = null;

    static {
        instance = new ArgumentsEvaluator();
    }

    private ArgumentsEvaluator() {
    }

    public double evaluateDateArg(ValueEval r2, int r3, int r4) {
        ValueEval r1 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, (short) r4);
        if (ZeusTransformUtils.instanceOf(r1, StringEval.class) == false) goto L11;
        String r5 = ((StringEval) ZeusTransformUtils.preCheckCast(r1, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        Double r6 = OperandResolver.parseDouble(r5);
        if (r6 == null) goto L9;
        return r6.doubleValue();
    L9:
        return DateUtil.getExcelDate(DateParser.parseLocalDate(r5), false);
    L11:
        return OperandResolver.coerceValueToDouble(r1);
    }

    public double[] evaluateDatesArg(ValueEval r6, int r7, int r8) {
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r9 != null) goto L7;
        return new double[0];
    L7:
        if (ZeusTransformUtils.instanceOf(r9, StringEval.class) == false) goto L11;
        return new double[]{evaluateDateArg(r9, r7, r8)};
    L11:
        if (ZeusTransformUtils.instanceOf(r9, AreaEvalBase.class) == false) goto L26;
        ArrayList r10 = new ArrayList();
        AreaEvalBase r11 = (AreaEvalBase) ZeusTransformUtils.preCheckCast(r9, AreaEvalBase.class, "com.obric.memorydata.plugin");
        int r12 = r11.getFirstRow();
    L14:
        if (r12 > r11.getLastRow()) goto L20;
        int r2 = r11.getFirstColumn();
    L17:
        if (r2 > r11.getLastColumn()) goto L19;
        r10.add(Double.valueOf(evaluateDateArg(r11.getAbsoluteValue(r12, r2), r12, r2)));
        r2 = r2 + 1;
        goto L17
    L19:
        r12 = r12 + 1;
        goto L14
    L20:
        double[] r5 = new double[r10.size()];
    L22:
        if (r0 >= r10.size()) goto L24;
        r5[r0] = ((Double) ZeusTransformUtils.preCheckCast(r10.get(r0), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        r0 = r0 + 1;
        goto L22
    L24:
        return r5;
    L26:
        return new double[]{OperandResolver.coerceValueToDouble(r9)};
    }

    public double evaluateNumberArg(ValueEval r1, int r2, int r3) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r1, ValueEval.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return OperandResolver.coerceValueToDouble(r0);
    }
}
