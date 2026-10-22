package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UShort;
import kotlin.text.Typography;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellReference implements GenericRecord {
    private static final Pattern CELL_REF_PATTERN = null;
    private static final Pattern COLUMN_REF_PATTERN = null;
    private static final Pattern NAMED_RANGE_NAME_PATTERN = null;
    private static final Pattern ROW_REF_PATTERN = null;
    private static final Pattern STRICTLY_CELL_REF_PATTERN = null;
    private final int _colIndex;
    private final boolean _isColAbs;
    private final boolean _isRowAbs;
    private final int _rowIndex;
    private final String _sheetName;

    /* JADX INFO: renamed from: org.apache.poi.ss.util.CellReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CellRefParts {
        final String colRef;
        final String rowRef;
        final String sheetName;

        private CellRefParts(String r1, String r2, String r3) {
            this.sheetName = r1;
            if (r2 != null) goto L6;
            r2 = "";
        L6:
            this.rowRef = r2;
            if (r3 != null) goto L10;
            r3 = "";
        L10:
            this.colRef = r3;
        }

        /* synthetic */ CellRefParts(String r1, String r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }
    }

    public static final enum NameType extends Enum<NameType> {
        private static final /* synthetic */ NameType[] $VALUES = null;
        public static final NameType BAD_CELL_OR_NAMED_RANGE = null;
        public static final NameType CELL = null;
        public static final NameType COLUMN = null;
        public static final NameType NAMED_RANGE = null;
        public static final NameType ROW = null;

        static {
            NameType r0 = new NameType("CELL", 0);
            CELL = r0;
            NameType r1 = new NameType("NAMED_RANGE", 1);
            NAMED_RANGE = r1;
            NameType r3 = new NameType("COLUMN", 2);
            COLUMN = r3;
            NameType r5 = new NameType("ROW", 3);
            ROW = r5;
            NameType r7 = new NameType("BAD_CELL_OR_NAMED_RANGE", 4);
            BAD_CELL_OR_NAMED_RANGE = r7;
            $VALUES = new NameType[]{r0, r1, r3, r5, r7};
        }

        private NameType(String r1, int r2) {
            super(r1, r2);
        }

        public static NameType valueOf(String r2) {
            return (NameType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NameType.class, r2), NameType.class, "com.obric.memorydata.plugin");
        }

        public static NameType[] values() {
            return (NameType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NameType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);
        STRICTLY_CELL_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)\\$?([0-9]+)", 2);
        COLUMN_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)", 2);
        ROW_REF_PATTERN = Pattern.compile("\\$?([0-9]+)");
        NAMED_RANGE_NAME_PATTERN = Pattern.compile("[_A-Z][_.A-Z0-9]*", 2);
    }

    public CellReference(int r2, int r3) {
        this(r2, r3, false, false);
    }

    public CellReference(int r7, int r8, boolean r9, boolean r10) {
        this(null, r7, r8, r9, r10);
    }

    public CellReference(int r2, short r3) {
        this(r2, r3 & UShort.MAX_VALUE, false, false);
    }

    public CellReference(String r7) {
        if (StringUtil.endsWithIgnoreCase(r7, "#REF!") == true) goto L31;
        CellRefParts r8 = separateRefParts(r7);
        this._sheetName = r8.sheetName;
        String r0 = r8.colRef;
        boolean r3 = false;
        if (r0.length() > 0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        this._isColAbs = r1;
        if (r1 == false) goto L14;
        r0 = r0.substring(1);
    L14:
        if (r0.length() != 0) goto L16;
        this._colIndex = -1;
    L17:
        String r9 = r8.rowRef;
        if (r9.length() > 0) goto L20;
    L22:
        this._isRowAbs = r3;
        if (r3 == false) goto L26;
        r9 = r9.substring(1);
    L26:
        if (r9.length() != 0) goto L28;
        this._rowIndex = -1;
        return;
    L28:
        this._rowIndex = Integer.parseInt(r9) - 1;
        return;
    L20:
        if (r9.charAt(0) != '$') goto L22;
        r3 = true;
        goto L22
    L16:
        this._colIndex = convertColStringToIndex(r0);
        goto L17
    L7:
        if (r0.charAt(0) != '$') goto L9;
        r1 = true;
        goto L10
    L31:
        throw new IllegalArgumentException("Cell reference invalid: " + r7);
    }

    public CellReference(String r2, int r3, int r4, boolean r5, boolean r6) {
        if (r3 < (-1)) goto L10;
        if (r4 < (-1)) goto L8;
        this._sheetName = r2;
        this._rowIndex = r3;
        this._colIndex = r4;
        this._isRowAbs = r5;
        this._isColAbs = r6;
        return;
    L8:
        throw new IllegalArgumentException("column index may not be negative, but had " + r4);
    L10:
        throw new IllegalArgumentException("row index may not be negative, but had " + r3);
    }

    public CellReference(Cell r8) {
        Cell r9 = (Cell) ZeusTransformUtils.wrapperContextForParams(r8, Cell.class, "com.obric.memorydata.plugin");
        this(r9.getSheet().getSheetName(), r9.getRowIndex(), r9.getColumnIndex(), false, false);
    }

    public static boolean cellReferenceIsWithinRange(String r0, String r1, SpreadsheetVersion r2) {
        if (isColumnWithinRange(r0, r2) == true) goto L7;
        return false;
    L7:
        return isRowWithinRange(r1, r2);
    }

    public static NameType classifyCellReference(String r5, SpreadsheetVersion r6) {
        int r0 = r5.length();
        if (r0 < 1) goto L36;
        char r2 = r5.charAt(0);
        if (r2 == '$') goto L18;
        if (r2 == '.') goto L18;
        if (r2 == '_') goto L18;
        if (Character.isLetter(r2) == true) goto L18;
        if (Character.isDigit(r2) == true) goto L18;
        throw new IllegalArgumentException("Invalid first char (" + r2 + ") of cell reference or named range.  Letter expected");
    L18:
        if (Character.isDigit(r5.charAt(r0 - 1)) == false) goto L20;
        Matcher r1 = STRICTLY_CELL_REF_PATTERN.matcher(r5);
        if (r1.matches() == true) goto L26;
        return validateNamedRangeName(r5, r6);
    L26:
        if (cellReferenceIsWithinRange(r1.group(1), r1.group(2), r6) == false) goto L30;
        return NameType.CELL;
    L30:
        if (r5.indexOf(36) < 0) goto L34;
        return NameType.BAD_CELL_OR_NAMED_RANGE;
    L34:
        return NameType.NAMED_RANGE;
    L20:
        return validateNamedRangeName(r5, r6);
    L36:
        throw new IllegalArgumentException("Empty string not allowed");
    }

    public static int convertColStringToIndex(String r5) {
        char[] r0 = r5.toUpperCase(Locale.ROOT).toCharArray();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0.length) goto L14;
        char r3 = r0[r1];
        if (r3 != '$') goto L11;
        if (r1 == 0) goto L12;
        throw new IllegalArgumentException("Bad col ref format '" + r5 + "'");
    L12:
        r1 = r1 + 1;
        goto L4
    L11:
        r2 = (r2 * 26) + ((r3 - 'A') + 1);
        goto L12
    L14:
        return r2 - 1;
    }

    public static String convertNumToColString(int r3) {
        int r4 = r3 + 1;
        StringBuilder r0 = new StringBuilder(2);
    L3:
        if (r4 <= 0) goto L9;
        int r1 = r4 % 26;
        if (r1 != 0) goto L7;
        r1 = 26;
    L7:
        r4 = (r4 - r1) / 26;
        r0.insert(0, (char) (r1 + 64));
        goto L3
    L9:
        return r0.toString();
    }

    public static boolean isColumnWithinRange(String r3, SpreadsheetVersion r4) {
        String r5 = r4.getLastColumnName();
        int r0 = r5.length();
        int r1 = r3.length();
        if (r1 <= r0) goto L5;
        return false;
    L5:
        if (r1 == r0) goto L7;
        return true;
    L7:
        if (r3.toUpperCase(Locale.ROOT).compareTo(r5) <= 0) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isPartAbsolute(String r2) {
        if (r2.charAt(0) != '$') goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isRowWithinRange(int r0, SpreadsheetVersion r1) {
        if (r0 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r0 > r1.getLastRowIndex()) goto L6;
        return true;
    }

    public static boolean isRowWithinRange(String r4, SpreadsheetVersion r5) {
        long r0 = Long.parseLong(r4) - 1;
        if (r0 <= 2147483647L) goto L7;
        return false;
    L7:
        return isRowWithinRange(Math.toIntExact(r0), r5);
    }

    private static String parseSheetName(String r7, int r8) {
        if (r8 >= 0) goto L6;
        return null;
    L6:
        if (r7.charAt(0) != '\'') goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        int r0 = r8 - 1;
        if (r7.charAt(r0) != '\'') goto L35;
        StringBuilder r2 = new StringBuilder(r8);
        int r9 = 1;
    L20:
        if (r9 >= r0) goto L33;
        char r5 = r7.charAt(r9);
        if (r5 == '\'') goto L24;
    L23:
        r2.append(r5);
        r9 = r9 + 1;
        goto L20
    L24:
        r9 = r9 + 1;
        if (r9 >= r0) goto L31;
        if (r7.charAt(r9) == '\'') goto L23;
    L31:
        throw new IllegalArgumentException("Bad sheet name quote escaping: (" + r7 + ")");
    L33:
        return r2.toString();
    L35:
        throw new IllegalArgumentException("Mismatched quotes: (" + r7 + ")");
    L12:
        if (r7.contains(" ") == true) goto L16;
        return r7.substring(0, r8);
    L16:
        throw new IllegalArgumentException("Sheet names containing spaces must be quoted: (" + r7 + ")");
    L8:
        r1 = false;
        goto L10
    }

    private static CellRefParts separateRefParts(String r4) {
        int r0 = r4.lastIndexOf(33);
        String r1 = parseSheetName(r4, r0);
        Matcher r2 = CELL_REF_PATTERN.matcher(r4.substring(r0 + 1).toUpperCase(Locale.ROOT));
        if (r2.matches() == false) goto L7;
        return new CellRefParts(r1, r2.group(2), r2.group(1), null);
    L7:
        throw new IllegalArgumentException("Invalid CellReference: " + r4);
    }

    private static NameType validateNamedRangeName(String r3, SpreadsheetVersion r4) {
        Matcher r0 = COLUMN_REF_PATTERN.matcher(r3);
        if (r0.matches() == true) goto L5;
    L8:
        Matcher r1 = ROW_REF_PATTERN.matcher(r3);
        if (r1.matches() == false) goto L15;
        if (isRowWithinRange(r1.group(1), r4) == false) goto L15;
        return NameType.ROW;
    L15:
        if (NAMED_RANGE_NAME_PATTERN.matcher(r3).matches() == true) goto L19;
        return NameType.BAD_CELL_OR_NAMED_RANGE;
    L19:
        return NameType.NAMED_RANGE;
    L5:
        if (isColumnWithinRange(r0.group(1), r4) == false) goto L8;
        return NameType.COLUMN;
    }

    void appendCellReference(StringBuilder r4) {
        if (this._colIndex == (-1)) goto L9;
        if (this._isColAbs == false) goto L7;
        r4.append(Typography.dollar);
    L7:
        r4.append(convertNumToColString(this._colIndex));
    L9:
        if (this._rowIndex != (-1)) goto L11;
        return;
    L11:
        if (this._isRowAbs == false) goto L13;
        r4.append(Typography.dollar);
    L13:
        r4.append(this._rowIndex + 1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CellReference.class) == true) goto L8;
        return false;
    L8:
        CellReference r6 = (CellReference) ZeusTransformUtils.preCheckCast(r5, CellReference.class, "com.obric.memorydata.plugin");
        if (this._rowIndex != r6._rowIndex) goto L20;
        if (this._colIndex != r6._colIndex) goto L20;
        if (this._isRowAbs != r6._isRowAbs) goto L20;
        if (this._isColAbs != r6._isColAbs) goto L20;
        if (Objects.equals(this._sheetName, r6._sheetName) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public String formatAsString() {
        return formatAsString(true);
    }

    public String formatAsString(boolean r3) {
        StringBuilder r0 = new StringBuilder(32);
        if (r3 == false) goto L7;
        String r4 = this._sheetName;
        if (r4 == null) goto L7;
        SheetNameFormatter.appendFormat(r0, r4);
        r0.append('!');
    L7:
        appendCellReference(r0);
        return r0.toString();
    }

    public short getCol() {
        return (short) this._colIndex;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("sheetName", new $$Lambda$c9cRfwa2oinXiVYiF3w98ZX2pIg(this), "rowIndex", new $$Lambda$diTQScB0DFaemA4OTQRs6JpVn0(this), "colIndex", new $$Lambda$WHow8evPYIRviqpM7D9VeIk3OM(this), "rowAbs", new $$Lambda$Y8iN_U4CVrZm33h1pgRJzTBqGjg(this), "colAbs", new $$Lambda$02_xpbDLSxkHV7G2Zt9q565ueow(this), "formatAsString", new $$Lambda$Dv0U9WtACO5vlHuNaPpHR9wxQ(this));
    }

    public int getRow() {
        return this._rowIndex;
    }

    public String getSheetName() {
        return this._sheetName;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this._rowIndex), Integer.valueOf(this._colIndex), Boolean.valueOf(this._isRowAbs), Boolean.valueOf(this._isColAbs), this._sheetName});
    }

    public boolean isColAbsolute() {
        return this._isColAbs;
    }

    public boolean isRowAbsolute() {
        return this._isRowAbs;
    }

    public String toString() {
        return getClass().getName() + " [" + formatAsString() + "]";
    }
}
