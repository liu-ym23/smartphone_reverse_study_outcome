package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class AreaReference {
    private static final SpreadsheetVersion DEFAULT_SPREADSHEET_VERSION = null;
    private final CellReference _firstCell;
    private final boolean _isSingleCell;
    private final CellReference _lastCell;
    private final SpreadsheetVersion _version;

    static {
        DEFAULT_SPREADSHEET_VERSION = SpreadsheetVersion.EXCEL97;
    }

    public AreaReference(String r8, SpreadsheetVersion r9) {
        if (r9 != null) goto L6;
        r9 = DEFAULT_SPREADSHEET_VERSION;
    L6:
        this._version = r9;
        if (isContiguous(r8) == false) goto L26;
        String[] r10 = separateAreaRefs(r8);
        String r1 = r10[0];
        if (r10.length != 1) goto L13;
        CellReference r11 = new CellReference(r1);
        this._firstCell = r11;
        this._lastCell = r11;
        this._isSingleCell = true;
        return;
    L13:
        if (r10.length != 2) goto L24;
        String r12 = r10[1];
        if (isPlainColumn(r1) == true) goto L17;
        this._firstCell = new CellReference(r1);
        this._lastCell = new CellReference(r12);
        this._isSingleCell = r1.equals(r12);
        return;
    L17:
        if (isPlainColumn(r12) == false) goto L20;
        boolean r13 = CellReference.isPartAbsolute(r1);
        boolean r2 = CellReference.isPartAbsolute(r12);
        int r3 = CellReference.convertColStringToIndex(r1);
        int r14 = CellReference.convertColStringToIndex(r12);
        this._firstCell = new CellReference(0, r3, true, r13);
        this._lastCell = new CellReference(65535, r14, true, r2);
        this._isSingleCell = false;
        return;
    L20:
        throw new RuntimeException("Bad area ref '" + r8 + "'");
    L24:
        throw new IllegalArgumentException("Bad area ref '" + r8 + "'");
    L26:
        throw new IllegalArgumentException("References passed to the AreaReference must be contiguous, use generateContiguous(ref) if you have non-contiguous references");
    }

    public AreaReference(CellReference r16, CellReference r17, SpreadsheetVersion r18) {
        if (r18 == null) goto L5;
        SpreadsheetVersion r1 = r18;
    L6:
        this._version = r1;
        boolean r3 = true;
        if (r16.getRow() <= r17.getRow()) goto L9;
        boolean r2 = true;
    L11:
        if (r16.getCol() > r17.getCol()) goto L14;
        r3 = false;
    L14:
        if (r2 == true) goto L19;
        if (r3 == true) goto L19;
        this._firstCell = r16;
        this._lastCell = r17;
    L27:
        this._isSingleCell = false;
        return;
    L19:
        if (r2 == false) goto L21;
        int r4 = r17.getRow();
        boolean r6 = r17.isRowAbsolute();
        int r7 = r16.getRow();
        boolean r8 = r16.isRowAbsolute();
    L22:
        int r11 = r4;
        boolean r13 = r6;
        boolean r5 = r8;
        if (r3 == false) goto L25;
        String r9 = r17.getSheetName();
        short r10 = r17.getCol();
        boolean r12 = r17.isColAbsolute();
        String r14 = r16.getSheetName();
        short r15 = r16.getCol();
        boolean r19 = r16.isColAbsolute();
        String r110 = r9;
        boolean r111 = r12;
    L26:
        this._firstCell = new CellReference(r110, r11, r10, r13, r111);
        this._lastCell = new CellReference(r14, r7, r15, r5, r19);
        goto L27
    L25:
        String r20 = r16.getSheetName();
        r10 = r16.getCol();
        boolean r21 = r16.isColAbsolute();
        r14 = r17.getSheetName();
        r15 = r17.getCol();
        r111 = r21;
        r110 = r20;
        r19 = r17.isColAbsolute();
        goto L26
    L21:
        r4 = r16.getRow();
        r6 = r16.isRowAbsolute();
        r7 = r17.getRow();
        r8 = r17.isRowAbsolute();
        goto L22
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = DEFAULT_SPREADSHEET_VERSION;
        goto L6
    }

    public static AreaReference getWholeColumn(SpreadsheetVersion r2, String r3, String r4) {
        if (r2 != null) goto L5;
        r2 = DEFAULT_SPREADSHEET_VERSION;
    L5:
        return new AreaReference(r3 + "$1:" + r4 + "$" + r2.getMaxRows(), r2);
    }

    public static AreaReference getWholeRow(SpreadsheetVersion r3, String r4, String r5) {
        if (r3 != null) goto L5;
        r3 = DEFAULT_SPREADSHEET_VERSION;
    L5:
        return new AreaReference("$A" + r4 + ":$" + r3.getLastColumnName() + r5, r3);
    }

    public static boolean isContiguous(String r1) {
        if (splitAreaReferences(r1).length == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isPlainColumn(String r4) {
        int r0 = r4.length() - 1;
    L3:
        if (r0 < 0) goto L16;
        char r2 = r4.charAt(r0);
        if (r2 != '$') goto L9;
        if (r0 != 0) goto L9;
    L13:
        r0 = r0 - 1;
    L9:
        if (r2 < 'A') goto L14;
        if (r2 <= 'Z') goto L13;
        return false;
    L14:
        return false;
    L16:
        return true;
    }

    public static boolean isWholeColumnReference(SpreadsheetVersion r1, CellReference r2, CellReference r3) {
        if (r1 != null) goto L5;
        r1 = DEFAULT_SPREADSHEET_VERSION;
    L5:
        if (r2.getRow() == 0) goto L7;
    L13:
        return false;
    L7:
        if (r2.isRowAbsolute() == false) goto L13;
        if (r3.getRow() != r1.getLastRowIndex()) goto L13;
        if (r3.isRowAbsolute() == false) goto L13;
        return true;
    }

    private static String[] separateAreaRefs(String r9) {
        int r0 = r9.length();
        int r2 = -1;
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r0) goto L26;
        char r7 = r9.charAt(r3);
        if (r7 != '\'') goto L8;
        if (r4 == true) goto L18;
        r4 = true;
    L23:
        r3 = r3 + 1;
        goto L4
    L18:
        if (r3 >= (r0 - 1)) goto L25;
        int r5 = r3 + 1;
        if (r9.charAt(r5) != '\'') goto L22;
        r3 = r5;
        goto L23
    L22:
        r4 = false;
        goto L23
    L25:
        throw new IllegalArgumentException("Area reference '" + r9 + "' ends with special name delimiter '''");
    L8:
        if (r7 != ':') goto L23;
        if (r4 == true) goto L23;
        if (r2 >= 0) goto L14;
        r2 = r3;
        goto L23
    L14:
        throw new IllegalArgumentException("More than one cell delimiter ':' appears in area reference '" + r9 + "'");
    L26:
        if (r2 < 0) goto L28;
        String r1 = r9.substring(0, r2);
        String r6 = r9.substring(r2 + 1);
        if (r6.indexOf(33) >= 0) goto L38;
        int r10 = r1.lastIndexOf(33);
        if (r10 >= 0) goto L36;
        return new String[]{r1, r6};
    L36:
        return new String[]{r1, r1.substring(0, r10 + 1) + r6};
    L38:
        throw new RuntimeException("Unexpected ! in second cell reference of '" + r9 + "'");
    L28:
        return new String[]{r9};
    }

    private static String[] splitAreaReferences(String r6) {
        ArrayList r0 = new ArrayList();
        StringTokenizer r1 = new StringTokenizer(r6, ",");
    L3:
        String r3 = "";
    L5:
        if (r1.hasMoreTokens() == false) goto L15;
        if (r3.length() <= 0) goto L9;
        r3 = r3 + ",";
    L9:
        r3 = r3 + r1.nextToken();
        int r4 = StringUtil.countMatches(r3, '\'');
        if (r4 == 0) goto L13;
        if (r4 != 2) goto L5;
    L13:
        r0.add(r3);
        goto L3
    L15:
        if (r3.length() <= 0) goto L18;
        r0.add(r3);
    L18:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    }

    public String formatAsString() {
        if (isWholeColumnReference() == true) goto L5;
        StringBuilder r0 = new StringBuilder(32);
        r0.append(this._firstCell.formatAsString());
        if (this._isSingleCell == true) goto L13;
        r0.append(':');
        String r1 = this._lastCell.getSheetName();
        CellReference r2 = this._lastCell;
        if (r1 != null) goto L11;
        r0.append(r2.formatAsString());
        goto L13
    L11:
        r2.appendCellReference(r0);
    L13:
        return r0.toString();
    L5:
        return CellReference.convertNumToColString(this._firstCell.getCol()) + ParameterizedMessage.ERROR_MSG_SEPARATOR + CellReference.convertNumToColString(this._lastCell.getCol());
    }

    public CellReference getFirstCell() {
        return this._firstCell;
    }

    public CellReference getLastCell() {
        return this._lastCell;
    }

    public boolean isWholeColumnReference() {
        return isWholeColumnReference(this._version, this._firstCell, this._lastCell);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        r0.append(getClass().getName()).append(" [");
        r0.append(formatAsString());     // Catch: Exception -> L5
    L7:
        r0.append(']');
        return r0.toString();
    L5:
        e = move-exception;
        r0.append(e);
        goto L7
    }
}
