package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class AverageIf extends Baseifs {
    public static final FreeRefFunction instance = null;

    static {
        instance = new AverageIf();
    }

    public AverageIf() {
    }

    public ValueEval aggregateMatchingCells(Baseifs.Aggregator r9, AreaEval r10, AreaEval r11, CountUtils.I_MatchPredicate r12) {
        Baseifs.Aggregator r8 = (Baseifs.Aggregator) ZeusTransformUtils.wrapperContextForParams(r9, Baseifs.Aggregator.class, "com.obric.memorydata.plugin");
        AreaEval r13 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r10, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r14 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r11, AreaEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r15 = (CountUtils.I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r12, CountUtils.I_MatchPredicate.class, "com.obric.memorydata.plugin");
        int r16 = r14.getHeight();
        int r1 = r14.getWidth();
        int r3 = 0;
    L3:
        if (r3 >= r16) goto L18;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L16;
        ValueEval r5 = r14.getRelativeValue(r3, r4);
        ValueEval r6 = r13.getRelativeValue(r3, r4);
        if (r15 == null) goto L15;
        if (r15.matches(r5) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == true) goto L14;
        r8.addValue(r6);
        goto L15
    L14:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    L15:
        r4 = r4 + 1;
        goto L5
    L16:
        r3 = r3 + 1;
        goto L3
    L18:
        return r8.getResult();
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public Baseifs.Aggregator createAggregator() {
        return new AnonymousClass1(this);
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs, org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r6, OperationEvaluationContext r7) {
        if (r6.length >= 2) goto L19;
        return ErrorEval.VALUE_INVALID;
    L19:
        AreaEval r2 = convertRangeArg(r6[0]);     // Catch: EvaluationException -> L16
        if (r6.length != 3) goto L10;
        r2 = convertRangeArg(r6[2]);     // Catch: EvaluationException -> L16
    L10:
        AreaEval r0 = convertRangeArg(r6[0]);     // Catch: EvaluationException -> L16
        CountUtils.I_MatchPredicate r8 = Countif.createCriteriaPredicate(r6[1], r7.getRowIndex(), r7.getColumnIndex());     // Catch: EvaluationException -> L16
        if (ZeusTransformUtils.instanceOf(r8, Countif.ErrorMatcher.class) == true) goto L15;
        return aggregateMatchingCells(createAggregator(), r2, r0, r8);
    L15:
        throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher) ZeusTransformUtils.preCheckCast(r8, Countif.ErrorMatcher.class, "com.obric.memorydata.plugin")).getValue()));     // Catch: EvaluationException -> L16
    L16:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public boolean hasInitialRange() {
        return false;
    }
}
