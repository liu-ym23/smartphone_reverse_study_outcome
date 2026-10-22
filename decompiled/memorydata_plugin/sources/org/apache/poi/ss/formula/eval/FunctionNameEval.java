package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: classes7.dex */
public final class FunctionNameEval implements ValueEval {
    private final String _functionName;

    public FunctionNameEval(String r1) {
        this._functionName = r1;
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public String toString() {
        return getClass().getName() + " [" + this._functionName + "]";
    }
}
