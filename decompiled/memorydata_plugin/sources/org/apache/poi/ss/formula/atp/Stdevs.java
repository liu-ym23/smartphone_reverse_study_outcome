package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public class Stdevs implements FreeRefFunction {
    public static final Stdevs instance = null;

    static {
        instance = new Stdevs();
    }

    public Stdevs() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return AggregateFunction.STDEV.evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }
}
