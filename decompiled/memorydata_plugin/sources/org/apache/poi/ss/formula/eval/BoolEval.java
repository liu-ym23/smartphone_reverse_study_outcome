package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: classes7.dex */
public final class BoolEval implements NumericValueEval, StringValueEval {
    public static final BoolEval FALSE = null;
    public static final BoolEval TRUE = null;
    private final boolean _value;

    static {
        FALSE = new BoolEval(false);
        TRUE = new BoolEval(true);
    }

    private BoolEval(boolean r1) {
        this._value = r1;
    }

    public static BoolEval valueOf(boolean r0) {
        if (r0 == false) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    public boolean getBooleanValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.eval.NumericValueEval
    public double getNumberValue() {
        if (this._value == false) goto L5;
        return 1.0d;
    L5:
        return 0.0d;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        if (this._value == false) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }

    public String toString() {
        return getClass().getName() + " [" + getStringValue() + "]";
    }
}
