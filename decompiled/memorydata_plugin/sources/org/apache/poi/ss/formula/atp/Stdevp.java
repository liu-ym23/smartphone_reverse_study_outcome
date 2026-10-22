package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public class Stdevp implements FreeRefFunction {
    public static final Stdevp instance = null;

    static {
        instance = new Stdevp();
    }

    public Stdevp() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return AggregateFunction.STDEVP.evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }
}
