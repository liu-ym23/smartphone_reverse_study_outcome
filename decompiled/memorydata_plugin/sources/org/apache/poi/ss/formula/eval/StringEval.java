package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: classes7.dex */
public final class StringEval implements StringValueEval {
    public static final StringEval EMPTY_INSTANCE = null;
    private final String _value;

    static {
        EMPTY_INSTANCE = new StringEval("");
    }

    public StringEval(String r1) {
        if (r1 == null) goto L7;
        this._value = r1;
        return;
    L7:
        throw new IllegalArgumentException("value must not be null");
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        return this._value;
    }

    public String toString() {
        return getClass().getName() + " [" + this._value + "]";
    }
}
