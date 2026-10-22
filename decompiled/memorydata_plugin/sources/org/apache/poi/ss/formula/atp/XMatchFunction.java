package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* JADX INFO: loaded from: classes7.dex */
final class XMatchFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private final ArgumentsEvaluator evaluator;

    static {
        instance = new XMatchFunction(ArgumentsEvaluator.instance);
    }

    private XMatchFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    private ValueEval _evaluate(ValueEval[] r8, int r9, int r10) {
        if (r8.length < 2) goto L5;
        LookupUtils.MatchMode r0 = LookupUtils.MatchMode.ExactMatch;
        if (r8.length > 2) goto L26;
    L15:
        LookupUtils.MatchMode r5 = r0;
        LookupUtils.SearchMode r1 = LookupUtils.SearchMode.IterateForward;
        if (r8.length > 3) goto L28;
    L24:
        ValueEval r3 = r8[0];
        ValueEval r4 = r8[1];
        return evaluate(r9, r10, r3, r4, r5, r1);
    L28:
        r1 = LookupUtils.searchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r8[3], r9, r10)));     // Catch: Exception -> L19 EvaluationException -> L21
    L21:
        e = move-exception;
        return e.getErrorEval();
    L20:
        return ErrorEval.VALUE_INVALID;
    L26:
        r0 = LookupUtils.matchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r8[2], r9, r10)));     // Catch: Exception -> L10 EvaluationException -> L12
    L12:
        e = move-exception;
        return e.getErrorEval();
    L11:
        return ErrorEval.VALUE_INVALID;
    L5:
        return ErrorEval.VALUE_INVALID;
    }

    private ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, LookupUtils.MatchMode r6, LookupUtils.SearchMode r7) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = OperandResolver.getSingleValue(r1, r2, r3);     // Catch: EvaluationException -> L9
        TwoDEval r10 = LookupUtils.resolveTableArrayArg(r8);     // Catch: EvaluationException -> L9
        if (r10.isColumn() == false) goto L6;
        LookupUtils.ValueVector r11 = LookupUtils.createColumnVector(r10, 0);     // Catch: EvaluationException -> L9
    L7:
        return new NumberEval(((double) LookupUtils.xlookupIndexOfValue(r9, r11, r6, r7)) + 1.0d);
    L6:
        r11 = LookupUtils.createRowVector(r10, 0);     // Catch: EvaluationException -> L9
    L9:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return _evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }
}
