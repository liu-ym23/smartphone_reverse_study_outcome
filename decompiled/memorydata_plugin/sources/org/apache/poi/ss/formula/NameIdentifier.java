package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public class NameIdentifier {
    private final boolean _isQuoted;
    private final String _name;

    public NameIdentifier(String r1, boolean r2) {
        this._name = r1;
        this._isQuoted = r2;
    }

    public String getName() {
        return this._name;
    }

    public boolean isQuoted() {
        return this._isQuoted;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        r0.append(getClass().getName());
        r0.append(" [");
        if (this._isQuoted == false) goto L5;
        r0.append('\'').append(this._name).append("'");
    L6:
        r0.append(']');
        return r0.toString();
    L5:
        r0.append(this._name);
        goto L6
    }
}
