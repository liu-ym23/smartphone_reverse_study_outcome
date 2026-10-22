package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
abstract class Baseifs implements FreeRefFunction {

    protected interface Aggregator {
        void addValue(ValueEval r1);

        ValueEval getResult();
    }

    Baseifs() {
    }

    private static ValueEval aggregateMatchingCells(Aggregator r9, AreaEval r10, AreaEval[] r11, CountUtils.I_MatchPredicate[] r12) {
        Aggregator r13 = (Aggregator) ZeusTransformUtils.wrapperContextForParams(r9, Aggregator.class, "com.obric.memorydata.plugin");
        AreaEval r14 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r10, AreaEval.class, "com.obric.memorydata.plugin");
        int r2 = r11[0].getHeight();
        int r3 = r11[0].getWidth();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L29;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L27;
        int r6 = 0;
    L8:
        if (r6 >= r11.length) goto L16;
        AreaEval r7 = r11[r6];
        CountUtils.I_MatchPredicate r8 = r12[r6];
        if (r8 == null) goto L15;
        if (r8.matches(r7.getRelativeValue(r4, r5)) == false) goto L15;
        r6 = r6 + 1;
    L15:
        boolean r15 = false;
    L17:
        if (r15 == false) goto L26;
        if (r14 == null) goto L24;
        ValueEval r16 = r14.getRelativeValue(r4, r5);
        if (ZeusTransformUtils.instanceOf(r16, ErrorEval.class) == true) goto L23;
    L25:
        r13.addValue(r16);
        goto L26
    L23:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r16, ErrorEval.class, "com.obric.memorydata.plugin"));
    L24:
        r16 = null;
    L26:
        r5 = r5 + 1;
        goto L5
    L16:
        r15 = true;
        goto L17
    L27:
        r4 = r4 + 1;
        goto L3
    L29:
        return r13.getResult();
    }

    public static AreaEval convertRangeArg(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AreaEval.class) == false) goto L7;
        return (AreaEval) ZeusTransformUtils.preCheckCast(r3, AreaEval.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L11;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin")).offset(0, 0, 0, 0);
    L11:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static void validateCriteria(CountUtils.I_MatchPredicate[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        CountUtils.I_MatchPredicate r2 = r4[r1];
        if (ZeusTransformUtils.instanceOf(r2, Countif.ErrorMatcher.class) == true) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher) ZeusTransformUtils.preCheckCast(r2, Countif.ErrorMatcher.class, "com.obric.memorydata.plugin")).getValue()));
    }

    private static void validateCriteriaRanges(AreaEval r5, AreaEval[] r6) {
        AreaEval r7 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r5, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r1 = r6[0].getHeight();
        int r2 = r6[0].getWidth();
        if (r7 != null) goto L5;
    L11:
        int r8 = r6.length;
    L12:
        if (r0 >= r8) goto L20;
        AreaEval r3 = r6[r0];
        if (r3.getHeight() != r1) goto L19;
        if (r3.getWidth() != r2) goto L19;
        r0 = r0 + 1;
    L19:
        throw EvaluationException.invalidValue();
    L20:
        return;
    L5:
        if (r7.getHeight() != r1) goto L10;
        if (r7.getWidth() == r2) goto L11;
    L10:
        throw EvaluationException.invalidValue();
    }

    public abstract Aggregator createAggregator();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r9, OperationEvaluationContext r10) {
        ?? r0 = hasInitialRange();
        if (r9.length < (r0 + 2)) goto L20;
        if ((r9.length % 2) != r0) goto L20;
        AreaEval r1 = null;
        int r2 = 0;
        if (r0 != 0) goto L21;
    L10:
        int r3 = (r9.length - r0) / 2;     // Catch: EvaluationException -> L16
        AreaEval[] r4 = new AreaEval[r3];     // Catch: EvaluationException -> L16
        CountUtils.I_MatchPredicate[] r5 = new CountUtils.I_MatchPredicate[r3];     // Catch: EvaluationException -> L16
        ?? r6 = r0;
    L12:
        if (r6 >= r9.length) goto L14;
        r4[r2] = convertRangeArg(r9[r6]);     // Catch: EvaluationException -> L16
        r5[r2] = Countif.createCriteriaPredicate(r9[r6 + 1], r10.getRowIndex(), r10.getColumnIndex());     // Catch: EvaluationException -> L16
        r2 = r2 + 1;     // Catch: EvaluationException -> L16
        r6 = r6 + 2;     // Catch: EvaluationException -> L16
        goto L12
    L14:
        validateCriteriaRanges(r1, r4);     // Catch: EvaluationException -> L16
        validateCriteria(r5);     // Catch: EvaluationException -> L16
        return aggregateMatchingCells(createAggregator(), r1, r4, r5);
    L16:
        e = move-exception;
        return e.getErrorEval();
    L21:
        r1 = convertRangeArg(r9[0]);     // Catch: EvaluationException -> L16
    L20:
        return ErrorEval.VALUE_INVALID;
    }

    public abstract boolean hasInitialRange();
}
