package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public class SheetIdentifier {
    private final String _bookName;
    private final NameIdentifier _sheetIdentifier;

    public SheetIdentifier(String r1, NameIdentifier r2) {
        this._bookName = r1;
        this._sheetIdentifier = r2;
    }

    public String asFormulaString() {
        StringBuilder r0 = new StringBuilder(32);
        asFormulaString(r0);
        return r0.toString();
    }

    public void asFormulaString(StringBuilder r3) {
        if (this._bookName == null) goto L6;
        r3.append(" [").append(this._sheetIdentifier.getName()).append("]");
    L6:
        if (this._sheetIdentifier.isQuoted() == false) goto L8;
        r3.append('\'').append(this._sheetIdentifier.getName()).append("'");
        return;
    L8:
        r3.append(this._sheetIdentifier.getName());
    }

    public String getBookName() {
        return this._bookName;
    }

    public NameIdentifier getSheetIdentifier() {
        return this._sheetIdentifier;
    }

    public String toString() {
        return getClass().getName() + " [" + asFormulaString() + "]";
    }
}
