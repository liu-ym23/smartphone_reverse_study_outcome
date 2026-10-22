package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Minifs extends Baseifs {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Minifs();
    }

    public Minifs() {
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public Baseifs.Aggregator createAggregator() {
        return new AnonymousClass1(this);
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs, org.apache.poi.ss.formula.functions.FreeRefFunction
    public /* bridge */ /* synthetic */ ValueEval evaluate(ValueEval[] r1, OperationEvaluationContext r2) {
        return super.evaluate(r1, r2);
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public boolean hasInitialRange() {
        return true;
    }
}
