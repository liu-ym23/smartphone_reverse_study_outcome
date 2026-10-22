package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFName implements Name {
    private final HSSFWorkbook _book;
    private final NameCommentRecord _commentRec;
    private final NameRecord _definedNameRec;

    HSSFName(HSSFWorkbook r2, NameRecord r3) {
        this(r2, r3, null);
    }

    HSSFName(HSSFWorkbook r1, NameRecord r2, NameCommentRecord r3) {
        this._book = r1;
        this._definedNameRec = r2;
        this._commentRec = r3;
    }

    private static void validateName(String r9) {
        if (r9.length() == 0) goto L50;
        if (r9.length() > 255) goto L48;
        if (r9.equalsIgnoreCase("R") == true) goto L46;
        if (r9.equalsIgnoreCase("C") == true) goto L46;
        char r1 = r9.charAt(0);
        if (Character.isLetter(r1) == false) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L44;
        char[] r3 = r9.toCharArray();
        int r4 = r3.length;
        int r6 = 0;
    L19:
        if (r6 >= r4) goto L32;
        char r7 = r3[r6];
        if (Character.isLetterOrDigit(r7) == false) goto L23;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == false) goto L30;
        r6 = r6 + 1;
        goto L19
    L30:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': name must be letter, digit, period, or underscore");
    L23:
        if ("_.\\".indexOf(r7) != (-1)) goto L26;
        r8 = false;
        goto L27
    L32:
        if (r9.matches("[A-Za-z]+\\d+") == false) goto L39;
        if (CellReference.cellReferenceIsWithinRange(r9.replaceAll("\\d", ""), r9.replaceAll("[A-Za-z]", ""), SpreadsheetVersion.EXCEL97) == false) goto L39;
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be $A$1-style cell reference");
    L39:
        if (r9.matches("[Rr]\\d+[Cc]\\d+") == true) goto L42;
        return;
    L42:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be R1C1-style cell reference");
    L44:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': first character must be underscore or a letter");
    L13:
        if ("_\\".indexOf(r1) != (-1)) goto L16;
        r2 = false;
    L46:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be special shorthand R or C");
    L48:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot exceed 255 characters in length");
    L50:
        throw new IllegalArgumentException("Name cannot be blank");
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._definedNameRec.getNameText();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        return this._definedNameRec.getSheetNumber() - 1;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean r1) {
        this._definedNameRec.setFunction(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String r6) {
        validateName(r6);
        InternalWorkbook r0 = this._book.getWorkbook();
        this._definedNameRec.setNameText(r6);
        int r1 = this._definedNameRec.getSheetNumber();
        int r2 = r0.getNumNames() - 1;
    L3:
        if (r2 < 0) goto L17;
        NameRecord r3 = r0.getNameRecord(r2);
        if (r3 == this._definedNameRec) goto L16;
        if (r3.getNameText().equalsIgnoreCase(r6) == false) goto L16;
        if (r1 != r3.getSheetNumber()) goto L16;
        StringBuilder r4 = new StringBuilder().append("The ");
        if (r1 != 0) goto L13;
        String r5 = "workbook";
    L14:
        String r7 = r4.append(r5).append(" already contains this name: ").append(r6).toString();
        this._definedNameRec.setNameText(r6 + "(2)");
        throw new IllegalArgumentException(r7);
    L13:
        r5 = "sheet";
    L16:
        r2 = r2 - 1;
        goto L3
    L17:
        NameCommentRecord r8 = this._commentRec;
        if (r8 == null) goto L26;
        r8.setNameText(r6);
        this._book.getWorkbook().updateNameCommentRecordCache(this._commentRec);
        return;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int r5) {
        int r0 = this._book.getNumberOfSheets() - 1;
        if (r5 < (-1)) goto L8;
        if (r5 > r0) goto L8;
        this._definedNameRec.setSheetNumber(r5 + 1);
        return;
    L8:
        StringBuilder r6 = new StringBuilder().append("Sheet index (").append(r5).append(") is out of range");
        if (r0 != (-1)) goto L11;
        String r1 = "";
    L13:
        throw new IllegalArgumentException(r6.append(r1).toString());
    L11:
        r1 = " (0.." + r0 + ")";
        goto L13
    }

    public String toString() {
        return getClass().getName() + " [" + this._definedNameRec.getNameText() + "]";
    }
}
