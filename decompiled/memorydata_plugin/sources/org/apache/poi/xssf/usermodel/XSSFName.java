package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ay;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFName implements Name {
    private final ay _ctName;
    private final XSSFWorkbook _workbook;

    public XSSFName(ay r3, XSSFWorkbook r4) {
        ay r5 = (ay) ZeusTransformUtils.wrapperContextForParams(r3, ay.class, "com.obric.memorydata.plugin");
        this._workbook = r4;
        this._ctName = r5;
    }

    private static void validateName(String r9) {
        if (r9.length() == 0) goto L51;
        if (r9.length() > 255) goto L49;
        if (r9.equalsIgnoreCase("R") == true) goto L47;
        if (r9.equalsIgnoreCase("C") == true) goto L47;
        char r1 = r9.charAt(0);
        if (Character.isLetter(r1) == false) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L45;
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
        if (r9.matches("[A-Za-z]+\\d+") == false) goto L40;
        if (CellReference.cellReferenceIsWithinRange(r9.replaceAll("\\d", ""), r9.replaceAll("[A-Za-z]", ""), SpreadsheetVersion.EXCEL2007) == false) goto L40;
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be $A$1-style cell reference");     // Catch: NumberFormatException -> L52
    L40:
        if (r9.matches("[Rr]\\d+[Cc]\\d+") == true) goto L43;
        return;
    L43:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be R1C1-style cell reference");
    L45:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': first character must be underscore or a letter");
    L13:
        if ("_\\".indexOf(r1) != (-1)) goto L16;
        r2 = false;
    L47:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot be special shorthand R or C");
    L49:
        throw new IllegalArgumentException("Invalid name: '" + r9 + "': cannot exceed 255 characters in length");
    L51:
        throw new IllegalArgumentException("Name cannot be blank");
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, XSSFName.class) == true) goto L10;
        return false;
    L10:
        XSSFName r4 = (XSSFName) ZeusTransformUtils.preCheckCast(r3, XSSFName.class, "com.obric.memorydata.plugin");
        return this._ctName.toString().equals(r4.getCTName().toString());
    }

    public ay getCTName() {
        return this._ctName;
    }

    public boolean getFunction() {
        return this._ctName.getFunction();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._ctName.getName();
    }

    public String getRefersToFormula() {
        String r2 = this._ctName.getStringValue();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.length() < 1) goto L10;
        return r2;
    L10:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        if (this._ctName.isSetLocalSheetId() == true) goto L7;
        return -1;
    L7:
        return (int) this._ctName.getLocalSheetId();
    }

    public int hashCode() {
        return this._ctName.toString().hashCode();
    }

    public boolean isFunctionName() {
        return getFunction();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean r1) {
        this._ctName.setFunction(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String r7) {
        validateName(r7);
        String r0 = getNameName();
        int r1 = getSheetIndex();
        Iterator<XSSFName> r2 = this._workbook.getNames(r7).iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        XSSFName r3 = (XSSFName) ZeusTransformUtils.preCheckCast(r2.next(), XSSFName.class, "com.obric.memorydata.plugin");
        if (r3.getSheetIndex() != r1) goto L4;
        if (r3 == this) goto L4;
        StringBuilder r6 = new StringBuilder().append("The ");
        if (r1 != (-1)) goto L11;
        String r4 = "workbook";
    L13:
        throw new IllegalArgumentException(r6.append(r4).append(" already contains this name: ").append(r7).toString());
    L11:
        r4 = "sheet";
        goto L13
    L14:
        this._ctName.setName(r7);
        this._workbook.updateName(this, r0);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int r5) {
        int r0 = this._workbook.getNumberOfSheets() - 1;
        if (r5 < (-1)) goto L12;
        if (r5 > r0) goto L12;
        if (r5 == (-1)) goto L8;
        this._ctName.setLocalSheetId(r5);
        return;
    L8:
        if (this._ctName.isSetLocalSheetId() == false) goto L18;
        this._ctName.unsetLocalSheetId();
        return;
    L18:
        return;
    L12:
        StringBuilder r6 = new StringBuilder().append("Sheet index (").append(r5).append(") is out of range");
        if (r0 != (-1)) goto L15;
        String r1 = "";
    L17:
        throw new IllegalArgumentException(r6.append(r1).toString());
    L15:
        r1 = " (0.." + r0 + ")";
        goto L17
    }
}
