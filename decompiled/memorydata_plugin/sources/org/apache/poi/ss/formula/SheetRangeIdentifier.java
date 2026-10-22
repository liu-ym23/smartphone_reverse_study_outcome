package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public class SheetRangeIdentifier extends SheetIdentifier {
    private final NameIdentifier _lastSheetIdentifier;

    public SheetRangeIdentifier(String r1, NameIdentifier r2, NameIdentifier r3) {
        super(r1, r2);
        this._lastSheetIdentifier = r3;
    }

    @Override // org.apache.poi.ss.formula.SheetIdentifier
    public void asFormulaString(StringBuilder r2) {
        super.asFormulaString(r2);
        r2.append(':');
        if (this._lastSheetIdentifier.isQuoted() == false) goto L5;
        r2.append('\'').append(this._lastSheetIdentifier.getName()).append("'");
        return;
    L5:
        r2.append(this._lastSheetIdentifier.getName());
    }

    public NameIdentifier getLastSheetIdentifier() {
        return this._lastSheetIdentifier;
    }
}
