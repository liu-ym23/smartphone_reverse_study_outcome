package org.apache.poi.xssf.usermodel;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.p;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.r;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFCell extends CellBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private p _cell;
    private int _cellNum;
    private final XSSFRow _row;
    private final SharedStringsTable _sharedStringSource;
    private final StylesTable _stylesSource;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.BLANK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
    }

    public XSSFCell(XSSFRow r3, p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.memorydata.plugin");
        this._cell = r5;
        this._row = r3;
        String r6 = r5.getR();
        if (r6 == null) goto L6;
        int r7 = new CellReference(r6).getCol();
    L5:
        this._cellNum = r7;
    L9:
        this._sharedStringSource = r3.getSheet().getWorkbook().getSharedStringSource();
        this._stylesSource = r3.getSheet().getWorkbook().getStylesSource();
        return;
    L6:
        short r8 = r3.getLastCellNum();
        if (r8 == (-1)) goto L9;
        r7 = r3.getCell(r8 - 1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getColumnIndex() + 1;
        goto L5
    }

    private static void checkBounds(int r5) {
        SpreadsheetVersion r0 = SpreadsheetVersion.EXCEL2007;
        int r1 = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (r5 < 0) goto L7;
        if (r5 > r1) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid column index (" + r5 + ").  Allowable column range for " + r0.name() + " is (0.." + r1 + ") or ('A'..'" + r0.getLastColumnName() + "')");
    }

    private boolean convertCellValueToBoolean() {
        CellType r0 = getCellType();
        if (r0 != CellType.FORMULA) goto L5;
        r0 = getBaseCellType(false);
    L5:
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L8;
    L26:
        return false;
    L8:
        if (r1 == 2) goto L25;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 6) goto L26;
        throw new IllegalStateException("Unexpected cell type (" + r0 + ")");
    L19:
        return Boolean.parseBoolean(this._sharedStringSource.getItemAt(Integer.parseInt(this._cell.getV())).getString());
    L21:
        if (Double.parseDouble(this._cell.getV()) != 0.0d) goto L23;
        return false;
    L23:
        return true;
    L25:
        return "1".equals(this._cell.getV());
    }

    private String convertCellValueToString() {
        CellType r0 = getCellType();
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()]) {
            case 1: goto L36;
            case 2: goto L32;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L37;
            case 6: goto L10;
            default: goto L5;
        };
    L11:
        CellType r1 = getBaseCellType(false);
        String r7 = this._cell.getV();
        int r2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r1.ordinal()];
        if (r2 == 2) goto L24;
        if (r2 != 4) goto L16;
    L22:
        return r7;
    L16:
        if (r2 == 5) goto L22;
        if (r2 == 6) goto L22;
        throw new IllegalStateException("Unexpected formula result type (" + r1 + ")");
    L24:
        if ("1".equals(r7) == false) goto L27;
        return "TRUE";
    L27:
        if ("0".equals(r7) == false) goto L30;
        return "FALSE";
    L30:
        throw new IllegalStateException("Unexpected boolean cached formula value '" + r7 + "'.");
    L36:
        return "";
    L37:
        return this._sharedStringSource.getItemAt(Integer.parseInt(this._cell.getV())).getString();
    L8:
        return "";
    L5:
        throw new IllegalStateException("Unexpected cell type (" + r0 + ")");
    L10:
        return this._cell.getV();
    L32:
        if ("1".equals(this._cell.getV()) == false) goto L35;
        return "TRUE";
    L35:
        return "FALSE";
    }

    private String convertSharedFormula(int r6, BaseXSSFEvaluationWorkbook r7) {
        XSSFSheet r0 = getSheet();
        r r1 = r0.getSharedFormula(r6);
        if (r1 == null) goto L7;
        String r8 = r1.getStringValue();
        CellRangeAddress r2 = CellRangeAddress.valueOf(r1.getRef());
        return FormulaRenderer.toFormulaString(r7, new SharedFormula(SpreadsheetVersion.EXCEL2007).convertSharedFormulas(FormulaParser.parse(r8, r7, FormulaType.CELL, r0.getWorkbook().getSheetIndex(r0), getRowIndex()), getRowIndex() - r2.getFirstRow(), getColumnIndex() - r2.getFirstColumn()));
    L7:
        throw new IllegalStateException("Master cell of a shared formula with sid=" + r6 + " was not found");
    }

    private CellType getBaseCellType(boolean r3) {
        switch(this._cell.getT().intValue()) {
            case 1: goto L18;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Illegal cell type: " + this._cell.getT());
    L7:
        return CellType.STRING;
    L9:
        return CellType.ERROR;
    L11:
        if (this._cell.isSetV() == true) goto L16;
        if (r3 == false) goto L16;
        return CellType.BLANK;
    L16:
        return CellType.NUMERIC;
    L18:
        return CellType.BOOLEAN;
    }

    private XSSFCellStyle getDefaultCellStyleFromColumn() {
        XSSFSheet r0 = getSheet();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (XSSFCellStyle) ZeusTransformUtils.preCheckCast(r0.getColumnStyle(getColumnIndex()), XSSFCellStyle.class, "com.obric.memorydata.plugin");
    }

    private XSSFCellStyle getExplicitCellStyle() {
        if (this._stylesSource.getNumCellStyles() > 0) goto L5;
    L7:
        return null;
    L5:
        if (this._cell.isSetS() == false) goto L7;
        long r0 = this._cell.getS();
        return this._stylesSource.getStyleAt(Math.toIntExact(r0));
    }

    private boolean isFormulaCell() {
        if (this._cell.isSetF() == false) goto L7;
        if (this._cell.getF().getT() == STCellFormulaType.e) goto L7;
    L8:
        return true;
    L7:
        if (getSheet().isCellInArrayFormulaContext(this) == true) goto L8;
        return false;
    }

    private void setBlankPrivate() {
        p r0 = (p) ZeusTransformUtils.preCheckCast(p.f19779a.newInstance(), p.class, "com.obric.memorydata.plugin");
        r0.setR(this._cell.getR());
        if (this._cell.isSetS() == false) goto L5;
        r0.setS(this._cell.getS());
    L5:
        this._cell.set(r0);
    }

    private void setFormula(String r7, FormulaType r8) {
        XSSFWorkbook r0 = this._row.getSheet().getWorkbook();
        if (r8 != FormulaType.ARRAY) goto L8;
        if (r7 != null) goto L8;
        removeFormulaImpl();
        return;
    L8:
        if (r0.getCellFormulaValidation() == false) goto L18;
        XSSFEvaluationWorkbook r1 = XSSFEvaluationWorkbook.create(r0);
        Ptg[] r9 = FormulaParser.parse(r7, r1, r8, r0.getSheetIndex(getSheet()), getRowIndex());
        int r2 = r9.length;
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L15;
        if (ZeusTransformUtils.instanceOf(r9[r4], ErrPtg.class) == true) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        r3 = true;
    L15:
        if (r3 == true) goto L18;
        r7 = FormulaRenderer.toFormulaString(r1, r9);
    L18:
        if (this._cell.isSetF() == false) goto L22;
        r r10 = this._cell.getF();
        r10.setStringValue(r7);
        if (r10.getT() != STCellFormulaType.f) goto L26;
        getRow().getSheet().onReadCell(this);
        return;
    L26:
        return;
    L22:
        r r11 = (r) ZeusTransformUtils.preCheckCast(r.c.newInstance(), r.class, "com.obric.memorydata.plugin");
        r11.setStringValue(r7);
        this._cell.setF(r11);
    }

    private static RuntimeException typeMismatch(CellType r2, CellType r3, boolean r4) {
        StringBuilder r5 = new StringBuilder().append("Cannot get a ").append(r2).append(" value from a ").append(r3).append(" ");
        if (r4 == false) goto L5;
        String r6 = "formula ";
    L7:
        return new IllegalStateException(r5.append(r6).append(LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL).toString());
    L5:
        r6 = "";
        goto L7
    }

    public void applyDefaultCellStyleIfNecessary() {
        if (getExplicitCellStyle() == null) goto L5;
        return;
    L5:
        if (getSheet() == null) goto L11;
        XSSFCellStyle r0 = getDefaultCellStyleFromColumn();
        if (r0 == null) goto L12;
        setCellStyle(r0);
        return;
    L12:
        return;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        XSSFCell r0 = getSheet().getFirstCellInArrayFormula(this);
        if (r0 == null) goto L7;
        return CellRangeAddress.valueOf(r0._cell.getF().getRef());
    L7:
        throw new IllegalStateException("Cell " + new CellReference(this).formatAsString() + " is not part of an array formula.");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        return false;
    L5:
        if (r1 == 2) goto L18;
        if (r1 != 3) goto L16;
        if (this._cell.isSetV() == false) goto L14;
        if ("1".equals(this._cell.getV()) == false) goto L14;
        return true;
    L14:
        return false;
    L16:
        throw typeMismatch(CellType.BOOLEAN, r0, false);
    L18:
        if (this._cell.isSetV() == false) goto L23;
        if ("1".equals(this._cell.getV()) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public p getCTCell() {
        return this._cell;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultType() {
        if (isFormulaCell() == false) goto L7;
        return getBaseCellType(false);
    L7:
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        return getCellFormula(null);
    }

    public String getCellFormula(BaseXSSFEvaluationWorkbook r4) {
        CellType r0 = getCellType();
        if (r0 != CellType.FORMULA) goto L24;
        r r1 = this._cell.getF();
        if (isPartOfArrayFormulaGroup() == false) goto L11;
        if (r1 == null) goto L10;
        if (r1.getStringValue().isEmpty() == false) goto L11;
    L10:
        return getSheet().getFirstCellInArrayFormula(this).getCellFormula(r4);
    L11:
        if (r1 != null) goto L15;
        return null;
    L15:
        if (r1.getT() != STCellFormulaType.f) goto L22;
        int r2 = Math.toIntExact(r1.getSi());
        if (r4 != null) goto L20;
        r4 = XSSFEvaluationWorkbook.create(getSheet().getWorkbook());
    L20:
        return convertSharedFormula(r2, r4);
    L22:
        return r1.getStringValue();
    L24:
        throw typeMismatch(CellType.FORMULA, r0, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ CellStyle getCellStyle() {
        return getCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFCellStyle getCellStyle() {
        XSSFCellStyle r0 = getExplicitCellStyle();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getDefaultCellStyleFromColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellType() {
        if (isFormulaCell() == false) goto L7;
        return CellType.FORMULA;
    L7:
        return getBaseCellType(true);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._cellNum;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() != CellType.BLANK) goto L7;
        return null;
    L7:
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    public String getErrorCellString() {
        CellType r0 = getBaseCellType(true);
        if (r0 != CellType.ERROR) goto L7;
        return this._cell.getV();
    L7:
        throw typeMismatch(CellType.ERROR, r0, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        String r2 = getErrorCellString();
        if (r2 != null) goto L11;
        return 0;
    L11:
        return FormulaError.forString(r2).getCode();
    L8:
        e = move-exception;
        throw new IllegalStateException("Unexpected error code", e);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public LocalDateTime getLocalDateTimeCellValue() {
        if (getCellType() != CellType.BLANK) goto L7;
        return null;
    L7:
        return DateUtil.getLocalDateTime(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        if (isFormulaCell() == false) goto L5;
        CellType r0 = getCachedFormulaResultType();
    L6:
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L9;
        return 0.0d;
    L9:
        if (r1 == 3) goto L25;
        if (r1 != 4) goto L23;
        if (this._cell.isSetV() == false) goto L21;
        String r6 = this._cell.getV();
        if (r6.isEmpty() == false) goto L27;
        return 0.0d;
    L27:
        return Double.parseDouble(r6);
    L20:
        throw typeMismatch(CellType.NUMERIC, CellType.STRING, false);
    L21:
        return 0.0d;
    L23:
        throw typeMismatch(CellType.NUMERIC, r0, false);
    L25:
        throw new AssertionError();
    L5:
        r0 = getCellType();
        goto L6
    }

    public String getRawValue() {
        return this._cell.getV();
    }

    public String getReference() {
        String r0 = this._cell.getR();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getAddress().formatAsString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ RichTextString getRichStringCellValue() {
        return getRichStringCellValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRichTextString getRichStringCellValue() {
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        String r3 = "";
        if (r1 != 1) goto L5;
        XSSFRichTextString r2 = new XSSFRichTextString("");
    L40:
        r2.setStylesTableReference(this._stylesSource);
        return r2;
    L5:
        if (r1 != 3) goto L7;
        CellType r4 = getBaseCellType(false);
        if (r4 != CellType.STRING) goto L38;
        if (this._cell.isSetV() == false) goto L36;
        r3 = this._cell.getV();
    L36:
        r2 = new XSSFRichTextString(r3);
        goto L40
    L38:
        throw typeMismatch(CellType.STRING, r4, true);
    L7:
        if (r1 != 5) goto L30;
        STCellType.Enum r5 = this._cell.getT();
        if (r5 != STCellType.h) goto L18;
        if (this._cell.isSetIs() == false) goto L14;
        r2 = new XSSFRichTextString(this._cell.getIs());
        goto L40
    L14:
        if (this._cell.isSetV() == false) goto L16;
        r2 = new XSSFRichTextString(this._cell.getV());
        goto L40
    L16:
        r2 = new XSSFRichTextString("");
        goto L40
    L18:
        if (r5 != STCellType.g) goto L24;
        if (this._cell.isSetV() == false) goto L22;
        r3 = this._cell.getV();
    L22:
        r2 = new XSSFRichTextString(r3);
        goto L40
    L24:
        if (this._cell.isSetV() == true) goto L42;
        r2 = new XSSFRichTextString("");
        goto L40
    L42:
        int r6 = Integer.parseInt(this._cell.getV());     // Catch: Throwable -> L27
        r2 = (XSSFRichTextString) ZeusTransformUtils.preCheckCast(this._sharedStringSource.getItemAt(r6), XSSFRichTextString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L27:
        r2 = new XSSFRichTextString("");
        goto L40
    L30:
        throw typeMismatch(CellType.STRING, r0, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ Row getRow() {
        return getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRow getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ Sheet getSheet() {
        return getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFSheet getSheet() {
        return getRow().getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return getSheet().isCellInArrayFormulaContext(this);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void removeFormulaImpl() {
        this._row.getSheet().getWorkbook().onDeleteFormula(this);
        if (this._cell.isSetF() == false) goto L6;
        this._row.getSheet().onDeleteFormula(this, null);
        this._cell.unsetF();
        return;
    }

    public void setCTCell(p r3) {
        this._cell = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte r1) {
        setCellErrorValue(FormulaError.forInt(r1));
    }

    public void setCellErrorValue(FormulaError r3) {
        this._cell.setT(STCellType.e);
        this._cell.setV(r3.getString());
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellFormulaImpl(String r2) {
        setFormula(r2, FormulaType.CELL);
    }

    public void setCellNum(int r3) {
        checkBounds(r3);
        this._cellNum = r3;
        String r4 = new CellReference(getRowIndex(), getColumnIndex()).formatAsString();
        this._cell.setR(r4);
    }

    public void setCellStyle(CellStyle r3) {
        CellStyle r4 = (CellStyle) ZeusTransformUtils.wrapperContextForParams(r3, CellStyle.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        XSSFCellStyle r5 = (XSSFCellStyle) ZeusTransformUtils.preCheckCast(r4, XSSFCellStyle.class, "com.obric.memorydata.plugin");
        r5.verifyBelongsToStylesSource(this._stylesSource);
        this._cell.setS(this._stylesSource.putStyle(r5));
        return;
    L5:
        if (this._cell.isSetS() == false) goto L9;
        this._cell.unsetS();
        return;
    }

    public void setCellType(CellType r4, BaseXSSFEvaluationWorkbook r5) {
        CellType r0 = getCellType();
        if (r0 == CellType.FORMULA) goto L5;
    L10:
        String r1 = "0";
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r4.ordinal()]) {
            case 1: goto L30;
            case 2: goto L27;
            case 3: goto L22;
            case 4: goto L19;
            case 5: goto L16;
            case 6: goto L14;
            default: goto L13;
        };
    L14:
        p r6 = this._cell;
        STCellType.Enum r2 = STCellType.e;
    L20:
        r6.setT(r2);
    L32:
        if (r4 != CellType.FORMULA) goto L34;
        return;
    L34:
        if (this._cell.isSetF() == false) goto L38;
        this._cell.unsetF();
        return;
    L38:
        return;
    L19:
        r6 = this._cell;
        r2 = STCellType.d;
        goto L20
    L30:
        setBlankPrivate();
        goto L32
    L13:
        throw new IllegalArgumentException("Illegal cell type: " + r4);
    L16:
        if (r0 == CellType.STRING) goto L18;
        XSSFRichTextString r3 = new XSSFRichTextString(convertCellValueToString());
        r3.setStylesTableReference(this._stylesSource);
        this._cell.setV(Integer.toString(this._sharedStringSource.addSharedStringItem(r3)));
    L18:
        r6 = this._cell;
        r2 = STCellType.f;
        goto L20
    L22:
        if (this._cell.isSetF() == true) goto L32;
        r r7 = (r) ZeusTransformUtils.preCheckCast(r.c.newInstance(), r.class, "com.obric.memorydata.plugin");
        r7.setStringValue("0");
        this._cell.setF(r7);
        if (this._cell.isSetT() == false) goto L32;
        this._cell.unsetT();
        goto L32
    L27:
        if (convertCellValueToBoolean() == false) goto L29;
        r1 = "1";
    L29:
        this._cell.setT(STCellType.c);
        this._cell.setV(r1);
        goto L32
    L5:
        if (r4 == CellType.FORMULA) goto L10;
        if (this._cell.isSetF() == false) goto L9;
        this._row.getSheet().onDeleteFormula(this, r5);
    L9:
        getSheet().getWorkbook().onDeleteFormula(this);
        goto L10
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellTypeImpl(CellType r2) {
        setCellType(r2, null);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean r3) {
        this._cell.setT(STCellType.c);
        p r2 = this._cell;
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r2.setV(r4);
        return;
    L5:
        r4 = "0";
        goto L6
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(double r3) {
        this._cell.setT(STCellType.d);
        this._cell.setV(String.valueOf(r3));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(String r2) {
        setCellValueImpl(new XSSFRichTextString(r2));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(RichTextString r4) {
        RichTextString r5 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r4, RichTextString.class, "com.obric.memorydata.plugin");
        if (getCellType() != CellType.FORMULA) goto L6;
        this._cell.setV(r5.getString());
        this._cell.setT(STCellType.g);
        return;
    L6:
        if (this._cell.getT() != STCellType.h) goto L10;
        p r3 = this._cell;
        String r6 = r5.getString();
    L8:
        r3.setV(r6);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, XSSFRichTextString.class) == false) goto L12;
        this._cell.setT(STCellType.f);
        XSSFRichTextString r7 = (XSSFRichTextString) ZeusTransformUtils.preCheckCast(r5, XSSFRichTextString.class, "com.obric.memorydata.plugin");
        r7.setStylesTableReference(this._stylesSource);
        int r8 = this._sharedStringSource.addSharedStringItem(r7);
    L13:
        r3 = this._cell;
        r6 = Integer.toString(r8);
        goto L8
    L12:
        this._cell.setT(STCellType.f);
        XSSFRichTextString r0 = new XSSFRichTextString(r5.getString());
        r0.setStylesTableReference(this._stylesSource);
        r8 = this._sharedStringSource.addSharedStringItem(r0);
        goto L13
    }

    public String toString() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L23:
        return "";
    L5:
        return "Unknown Cell Type: " + getCellType();
    L7:
        return ErrorEval.getText(getErrorCellValue());
    L9:
        return getRichStringCellValue().toString();
    L11:
        if (DateUtil.isCellDateFormatted(this) == false) goto L15;
        SimpleDateFormat r0 = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
        r0.setTimeZone(LocaleUtil.getUserTimeZone());
        return r0.format(getDateCellValue());
    L15:
        return Double.toString(getNumericCellValue());
    L17:
        return getCellFormula();
    L19:
        if (getBooleanCellValue() == false) goto L21;
        return "TRUE";
    L21:
        return "FALSE";
    }
}
