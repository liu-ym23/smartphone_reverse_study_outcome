package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* JADX INFO: loaded from: classes7.dex */
final class XLookupFunction implements ArrayFunction, FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private final ArgumentsEvaluator evaluator;

    static {
        instance = new XLookupFunction(ArgumentsEvaluator.instance);
    }

    private XLookupFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    private ValueEval _evaluate(ValueEval[] r10, int r11, int r12) {
        if (r10.length < 3) goto L5;
        ValueEval r0 = BlankEval.instance;
        if (r10.length > 3) goto L34;
    L14:
        ValueEval r6 = r0;
        LookupUtils.MatchMode r1 = LookupUtils.MatchMode.ExactMatch;
        if (r10.length > 4) goto L38;
    L23:
        LookupUtils.MatchMode r7 = r1;
        LookupUtils.SearchMode r2 = LookupUtils.SearchMode.IterateForward;
        if (r10.length > 5) goto L36;
    L32:
        ValueEval r3 = r10[0];
        ValueEval r4 = r10[1];
        ValueEval r5 = r10[2];
        return evaluate(r11, r12, r3, r4, r5, r6, r7, r2);
    L36:
        r2 = LookupUtils.searchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r10[5], r11, r12)));     // Catch: Exception -> L27 EvaluationException -> L29
    L29:
        e = move-exception;
        return e.getErrorEval();
    L28:
        return ErrorEval.VALUE_INVALID;
    L38:
        r1 = LookupUtils.matchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r10[4], r11, r12)));     // Catch: Exception -> L18 EvaluationException -> L20
    L20:
        e = move-exception;
        return e.getErrorEval();
    L19:
        return ErrorEval.VALUE_INVALID;
    L34:
        ValueEval r8 = OperandResolver.getSingleValue(r10[3], r11, r12);     // Catch: EvaluationException -> L11
        if (r8 == null) goto L14;
        r0 = r8;
    L11:
        e = move-exception;
        return e.getErrorEval();
    L5:
        return ErrorEval.VALUE_INVALID;
    }

    private ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6, ValueEval r7, ValueEval r8, LookupUtils.MatchMode r9, LookupUtils.SearchMode r10) {
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r13 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r14 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r15 = OperandResolver.getSingleValue(r11, r3, r4);     // Catch: EvaluationException -> L35
        TwoDEval r16 = LookupUtils.resolveTableArrayArg(r12);     // Catch: EvaluationException -> L35
        if (r16.isColumn() == false) goto L6;
        LookupUtils.ValueVector r17 = LookupUtils.createColumnVector(r16, 0);     // Catch: EvaluationException -> L35
    L38:
        int r2 = LookupUtils.xlookupIndexOfValue(r15, r17, r9, r10);     // Catch: EvaluationException -> L18
    L10:
        if (ZeusTransformUtils.instanceOf(r13, AreaEval.class) == false) goto L17;
        AreaEval r18 = (AreaEval) ZeusTransformUtils.preCheckCast(r13, AreaEval.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L35
        if (r16.isColumn() == false) goto L16;
        return r18.offset(r2, r2, 0, r18.getWidth() - 1);
    L16:
        return r18.offset(0, r18.getHeight() - 1, r2, r2);
    L17:
        return r13;
    L18:
        e = move-exception;
        if (ErrorEval.NA.equals(e.getErrorEval()) == false) goto L34;
        if (r14 == BlankEval.instance) goto L32;
        if (ZeusTransformUtils.instanceOf(r13, AreaEval.class) == false) goto L30;
        int r19 = ((AreaEval) ZeusTransformUtils.preCheckCast(r13, AreaEval.class, "com.obric.memorydata.plugin")).getWidth();     // Catch: EvaluationException -> L35
        if (r19 > 1) goto L29;
        return r14;
    L29:
        return notFoundAreaEval(r14, r19);
    L30:
        return r14;
    L32:
        return ErrorEval.NA;
    L34:
        return e.getErrorEval();
    L6:
        r17 = LookupUtils.createRowVector(r16, 0);     // Catch: EvaluationException -> L35
    L35:
        e = move-exception;
        return e.getErrorEval();
    }

    private AreaEval notFoundAreaEval(ValueEval r3, final int r4) {
        final ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(this, r4, r5);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return _evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r1, int r2, int r3) {
        return _evaluate(r1, r2, r3);
    }
}
