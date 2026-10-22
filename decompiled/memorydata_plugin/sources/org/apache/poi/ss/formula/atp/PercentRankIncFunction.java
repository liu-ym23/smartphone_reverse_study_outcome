package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.PercentRank;

/* JADX INFO: loaded from: classes7.dex */
final class PercentRankIncFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new PercentRankIncFunction(ArgumentsEvaluator.instance);
    }

    private PercentRankIncFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return PercentRank.instance.evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }
}
