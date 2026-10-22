package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class NotImplementedFunction implements Function {
    private final String _functionName;

    public NotImplementedFunction() {
        this._functionName = getClass().getName();
    }

    public NotImplementedFunction(String r1) {
        this._functionName = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r1, int r2, int r3) {
        throw new NotImplementedFunctionException(this._functionName);
    }
}
