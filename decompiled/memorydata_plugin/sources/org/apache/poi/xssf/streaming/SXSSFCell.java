package org.apache.poi.xssf.streaming;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: loaded from: classes7.dex */
public class SXSSFCell extends CellBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SXSSFRow _row;
    private CellStyle _style;
    private Value _value;

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.BLANK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static class BlankValue implements Value {
        BlankValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BLANK;
        }
    }

    static class BooleanFormulaValue extends FormulaValue {
        boolean _preEvaluatedValue;

        public BooleanFormulaValue(String r1, boolean r2) {
            super(r1);
            this._preEvaluatedValue = r2;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.BOOLEAN;
        }

        boolean getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        void setPreEvaluatedValue(boolean r1) {
            this._preEvaluatedValue = r1;
        }
    }

    static class BooleanValue implements Value {
        boolean _value;

        public BooleanValue() {
            this._value = false;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BOOLEAN;
        }

        boolean getValue() {
            return this._value;
        }

        void setValue(boolean r1) {
            this._value = r1;
        }
    }

    static class ErrorFormulaValue extends FormulaValue {
        byte _preEvaluatedValue;

        public ErrorFormulaValue(String r1, byte r2) {
            super(r1);
            this._preEvaluatedValue = r2;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.ERROR;
        }

        byte getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class ErrorValue implements Value {
        byte _value;

        public ErrorValue() {
            this._value = FormulaError._NO_ERROR.getCode();
        }

        public ErrorValue(byte r1) {
            this._value = r1;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.ERROR;
        }

        byte getValue() {
            return this._value;
        }

        void setValue(byte r1) {
            this._value = r1;
        }
    }

    static abstract class FormulaValue implements Value {
        String _value;

        public FormulaValue(String r1) {
            this._value = r1;
        }

        abstract CellType getFormulaType();

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.FORMULA;
        }

        String getValue() {
            return this._value;
        }

        void setValue(String r1) {
            this._value = r1;
        }
    }

    static class NumericFormulaValue extends FormulaValue {
        double _preEvaluatedValue;

        public NumericFormulaValue(String r1, double r2) {
            super(r1);
            this._preEvaluatedValue = r2;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.NUMERIC;
        }

        double getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        void setPreEvaluatedValue(double r1) {
            this._preEvaluatedValue = r1;
        }
    }

    static class NumericValue implements Value {
        double _value;

        public NumericValue() {
            this._value = 0.0d;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.NUMERIC;
        }

        double getValue() {
            return this._value;
        }

        void setValue(double r1) {
            this._value = r1;
        }
    }

    static class PlainStringValue extends StringValue {
        String _value;

        PlainStringValue() {
        }

        String getValue() {
            return this._value;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return false;
        }

        void setValue(String r1) {
            this._value = r1;
        }
    }

    static class RichTextStringFormulaValue extends FormulaValue {
        RichTextString _preEvaluatedValue;

        public RichTextStringFormulaValue(String r3, RichTextString r4) {
            RichTextString r5 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r4, RichTextString.class, "com.obric.memorydata.plugin");
            super(r3);
            this._preEvaluatedValue = r5;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.STRING;
        }

        RichTextString getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        void setPreEvaluatedValue(RichTextString r3) {
            this._preEvaluatedValue = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r3, RichTextString.class, "com.obric.memorydata.plugin");
        }
    }

    static class RichTextValue extends StringValue {
        RichTextString _value;

        RichTextValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue, org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }

        RichTextString getValue() {
            return this._value;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return true;
        }

        void setValue(RichTextString r3) {
            this._value = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r3, RichTextString.class, "com.obric.memorydata.plugin");
        }
    }

    static class StringFormulaValue extends FormulaValue {
        String _preEvaluatedValue;

        public StringFormulaValue(String r1, String r2) {
            super(r1);
            this._preEvaluatedValue = r2;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.STRING;
        }

        String getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        void setPreEvaluatedValue(String r1) {
            this._preEvaluatedValue = r1;
        }
    }

    static abstract class StringValue implements Value {
        StringValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }

        abstract boolean isRichText();
    }

    interface Value {
        CellType getType();
    }

    static {
    }

    public SXSSFCell(SXSSFRow r1, CellType r2) {
        this._row = r1;
        this._value = new BlankValue();
        setType(r2);
    }

    private boolean convertCellValueToBoolean() {
        CellType r0 = getCellType();
        if (r0 != CellType.FORMULA) goto L5;
        r0 = getCachedFormulaResultType();
    L5:
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L8;
        return false;
    L8:
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L21;
        if (r1 == 4) goto L19;
        if (r1 != 5) goto L17;
        return false;
    L17:
        throw new IllegalStateException("Unexpected cell type (" + r0 + ")");
    L19:
        return getBooleanCellValue();
    L21:
        return Boolean.parseBoolean(getStringCellValue());
    L23:
        if (getNumericCellValue() != 0.0d) goto L25;
        return false;
    L25:
        return true;
    }

    private String convertCellValueToString() {
        return convertCellValueToString(getCellType());
    }

    private String convertCellValueToString(CellType r4) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r4.ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Value r5 = this._value;
        if (r5 == null) goto L12;
        FormulaValue r6 = (FormulaValue) ZeusTransformUtils.preCheckCast(r5, FormulaValue.class, "com.obric.memorydata.plugin");
        if (r6.getFormulaType() == CellType.FORMULA) goto L12;
        return convertCellValueToString(r6.getFormulaType());
    L12:
        return "";
    L24:
        return "";
    L5:
        throw new IllegalStateException("Unexpected cell type (" + r4 + ")");
    L14:
        return FormulaError.forInt(getErrorCellValue()).getString();
    L16:
        if (getBooleanCellValue() == false) goto L18;
        return "TRUE";
    L18:
        return "FALSE";
    L21:
        return getStringCellValue();
    L23:
        return Double.toString(getNumericCellValue());
    }

    private CellStyle getDefaultCellStyleFromColumn() {
        SXSSFSheet r0 = getSheet();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getColumnStyle(getColumnIndex());
    }

    private boolean isFormulaCell() {
        return ZeusTransformUtils.instanceOf(this._value, FormulaValue.class);
    }

    private static IllegalStateException typeMismatch(CellType r2, CellType r3, boolean r4) {
        StringBuilder r5 = new StringBuilder().append("Cannot get a ").append(r2).append(" value from a ").append(r3).append(" ");
        if (r4 == false) goto L5;
        String r6 = "formula ";
    L7:
        return new IllegalStateException(r5.append(r6).append(LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL).toString());
    L5:
        r6 = "";
        goto L7
    }

    void ensureRichTextStringType() {
        if (this._value.getType() != CellType.FORMULA) goto L6;
        this._value = new RichTextStringFormulaValue(((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getValue(), new XSSFRichTextString(""));
        return;
    L6:
        if (this._value.getType() == CellType.STRING) goto L8;
    L9:
        this._value = new RichTextValue();
        return;
    L8:
        if (((StringValue) ZeusTransformUtils.preCheckCast(this._value, StringValue.class, "com.obric.memorydata.plugin")).isRichText() == false) goto L9;
    }

    void ensureType(CellType r2) {
        if (this._value.getType() == r2) goto L6;
        setType(r2);
        return;
    }

    void ensureTypeOrFormulaType(CellType r4) {
        if (this._value.getType() != r4) goto L11;
        if (r4 == CellType.STRING) goto L7;
        return;
    L7:
        if (((StringValue) ZeusTransformUtils.preCheckCast(this._value, StringValue.class, "com.obric.memorydata.plugin")).isRichText() == false) goto L34;
        setType(CellType.STRING);
        return;
    L34:
        return;
    L11:
        if (this._value.getType() == CellType.FORMULA) goto L13;
        setType(r4);
        return;
    L13:
        if (((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType() != r4) goto L15;
        return;
    L15:
        int r5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r4.ordinal()];
        if (r5 != 2) goto L18;
        Value r6 = new NumericFormulaValue(getCellFormula(), 0.0d);
    L29:
        this._value = r6;
        return;
    L18:
        if (r5 != 3) goto L20;
        r6 = new StringFormulaValue(getCellFormula(), "");
        goto L29
    L20:
        if (r5 != 4) goto L22;
        r6 = new BooleanFormulaValue(getCellFormula(), false);
        goto L29
    L22:
        if (r5 != 5) goto L25;
        r6 = new ErrorFormulaValue(getCellFormula(), FormulaError._NO_ERROR.getCode());
        goto L29
    L25:
        throw new AssertionError();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        return false;
    L5:
        if (r1 == 4) goto L17;
        if (r1 != 6) goto L15;
        if (((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType() != CellType.BOOLEAN) goto L13;
        return ((BooleanFormulaValue) ZeusTransformUtils.preCheckCast(this._value, BooleanFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
    L13:
        throw typeMismatch(CellType.BOOLEAN, CellType.FORMULA, false);
    L15:
        throw typeMismatch(CellType.BOOLEAN, r0, false);
    L17:
        return ((BooleanValue) ZeusTransformUtils.preCheckCast(this._value, BooleanValue.class, "com.obric.memorydata.plugin")).getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultType() {
        if (isFormulaCell() == false) goto L7;
        return ((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType();
    L7:
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        if (this._value.getType() != CellType.FORMULA) goto L7;
        return ((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getValue();
    L7:
        throw typeMismatch(CellType.FORMULA, this._value.getType(), false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellStyle getCellStyle() {
        CellStyle r0 = this._style;
        if (r0 != null) goto L8;
        CellStyle r1 = getDefaultCellStyleFromColumn();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return getSheet().getWorkbook().getCellStyleAt(0);
    L8:
        return r0;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellType() {
        if (isFormulaCell() == false) goto L7;
        return CellType.FORMULA;
    L7:
        return this._value.getType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._row.getCellIndex(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() != CellType.BLANK) goto L7;
        return null;
    L7:
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 0;
    L5:
        if (r1 == 5) goto L17;
        if (r1 != 6) goto L15;
        if (((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType() != CellType.ERROR) goto L13;
        return ((ErrorFormulaValue) ZeusTransformUtils.preCheckCast(this._value, ErrorFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
    L13:
        throw typeMismatch(CellType.ERROR, CellType.FORMULA, false);
    L15:
        throw typeMismatch(CellType.ERROR, r0, false);
    L17:
        return ((ErrorValue) ZeusTransformUtils.preCheckCast(this._value, ErrorValue.class, "com.obric.memorydata.plugin")).getValue();
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
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 0.0d;
    L5:
        if (r1 == 2) goto L17;
        if (r1 != 6) goto L15;
        if (((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType() != CellType.NUMERIC) goto L13;
        return ((NumericFormulaValue) ZeusTransformUtils.preCheckCast(this._value, NumericFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
    L13:
        throw typeMismatch(CellType.NUMERIC, CellType.FORMULA, false);
    L15:
        throw typeMismatch(CellType.NUMERIC, r0, false);
    L17:
        return ((NumericValue) ZeusTransformUtils.preCheckCast(this._value, NumericValue.class, "com.obric.memorydata.plugin")).getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public RichTextString getRichStringCellValue() {
        CellType r0 = getCellType();
        if (getCellType() != CellType.STRING) goto L11;
        if (((StringValue) ZeusTransformUtils.preCheckCast(this._value, StringValue.class, "com.obric.memorydata.plugin")).isRichText() == false) goto L9;
        return ((RichTextValue) ZeusTransformUtils.preCheckCast(this._value, RichTextValue.class, "com.obric.memorydata.plugin")).getValue();
    L9:
        return new XSSFRichTextString(getStringCellValue());
    L11:
        throw typeMismatch(CellType.STRING, r0, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Row getRow() {
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
    public SXSSFSheet getSheet() {
        return this._row.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        CellType r0 = getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "";
    L5:
        if (r1 != 3) goto L7;
        boolean r2 = ((StringValue) ZeusTransformUtils.preCheckCast(this._value, StringValue.class, "com.obric.memorydata.plugin")).isRichText();
        Value r5 = this._value;
        if (r2 == false) goto L25;
        return ((RichTextValue) ZeusTransformUtils.preCheckCast(r5, RichTextValue.class, "com.obric.memorydata.plugin")).getValue().getString();
    L25:
        return ((PlainStringValue) ZeusTransformUtils.preCheckCast(r5, PlainStringValue.class, "com.obric.memorydata.plugin")).getValue();
    L7:
        if (r1 != 6) goto L19;
        if (((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).getFormulaType() != CellType.STRING) goto L17;
        boolean r3 = ZeusTransformUtils.instanceOf(this._value, RichTextStringFormulaValue.class);
        Value r6 = this._value;
        if (r3 == false) goto L15;
        return ((RichTextStringFormulaValue) ZeusTransformUtils.preCheckCast(r6, RichTextStringFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue().getString();
    L15:
        return ((StringFormulaValue) ZeusTransformUtils.preCheckCast(r6, StringFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
    L17:
        throw typeMismatch(CellType.STRING, CellType.FORMULA, false);
    L19:
        throw typeMismatch(CellType.STRING, r0, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void removeFormulaImpl() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCachedFormulaResultType().ordinal()];
        if (r0 != 2) goto L5;
        double r1 = ((NumericFormulaValue) ZeusTransformUtils.preCheckCast(this._value, NumericFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
        NumericValue r3 = new NumericValue();
        this._value = r3;
        ((NumericValue) ZeusTransformUtils.preCheckCast(r3, NumericValue.class, "com.obric.memorydata.plugin")).setValue(r1);
        return;
    L5:
        if (r0 != 3) goto L7;
        String r2 = ((StringFormulaValue) ZeusTransformUtils.preCheckCast(this._value, StringFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
        PlainStringValue r4 = new PlainStringValue();
        this._value = r4;
        ((PlainStringValue) ZeusTransformUtils.preCheckCast(r4, PlainStringValue.class, "com.obric.memorydata.plugin")).setValue(r2);
        return;
    L7:
        if (r0 != 4) goto L9;
        boolean r5 = ((BooleanFormulaValue) ZeusTransformUtils.preCheckCast(this._value, BooleanFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
        BooleanValue r6 = new BooleanValue();
        this._value = r6;
        ((BooleanValue) ZeusTransformUtils.preCheckCast(r6, BooleanValue.class, "com.obric.memorydata.plugin")).setValue(r5);
        return;
    L9:
        if (r0 != 5) goto L12;
        byte r7 = ((ErrorFormulaValue) ZeusTransformUtils.preCheckCast(this._value, ErrorFormulaValue.class, "com.obric.memorydata.plugin")).getPreEvaluatedValue();
        ErrorValue r8 = new ErrorValue();
        this._value = r8;
        ((ErrorValue) ZeusTransformUtils.preCheckCast(r8, ErrorValue.class, "com.obric.memorydata.plugin")).setValue(r7);
        return;
    L12:
        throw new AssertionError();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte r3) {
        if (this._value.getType() != CellType.FORMULA) goto L5;
        Value r0 = new ErrorFormulaValue(getCellFormula(), r3);
    L6:
        this._value = r0;
        return;
    L5:
        r0 = new ErrorValue(r3);
        goto L6
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellFormulaImpl(String r5) {
        if (getCellType() != CellType.FORMULA) goto L5;
        ((FormulaValue) ZeusTransformUtils.preCheckCast(this._value, FormulaValue.class, "com.obric.memorydata.plugin")).setValue(r5);
        return;
    L5:
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()];
        if (r0 != 1) goto L8;
    L23:
        Value r1 = new NumericFormulaValue(r5, getNumericCellValue());
    L24:
        this._value = r1;
        return;
    L8:
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L20;
        if (r0 != 4) goto L14;
        r1 = new BooleanFormulaValue(r5, getBooleanCellValue());
        goto L24
    L14:
        if (r0 != 5) goto L17;
        r1 = new ErrorFormulaValue(r5, getErrorCellValue());
        goto L24
    L17:
        throw new IllegalStateException("Cannot set a formula for a cell of type " + getCellType());
    L20:
        if (ZeusTransformUtils.instanceOf(this._value, PlainStringValue.class) == false) goto L22;
        r1 = new StringFormulaValue(r5, getStringCellValue());
        goto L24
    L22:
        r1 = new RichTextStringFormulaValue(r5, ((RichTextValue) ZeusTransformUtils.preCheckCast(this._value, RichTextValue.class, "com.obric.memorydata.plugin")).getValue());
        goto L24
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellTypeImpl(CellType r1) {
        ensureType(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean r4) {
        ensureTypeOrFormulaType(CellType.BOOLEAN);
        CellType r0 = this._value.getType();
        CellType r1 = CellType.FORMULA;
        Value r3 = this._value;
        if (r0 != r1) goto L5;
        ((BooleanFormulaValue) ZeusTransformUtils.preCheckCast(r3, BooleanFormulaValue.class, "com.obric.memorydata.plugin")).setPreEvaluatedValue(r4);
        return;
    L5:
        ((BooleanValue) ZeusTransformUtils.preCheckCast(r3, BooleanValue.class, "com.obric.memorydata.plugin")).setValue(r4);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(double r4) {
        ensureTypeOrFormulaType(CellType.NUMERIC);
        CellType r0 = this._value.getType();
        CellType r1 = CellType.FORMULA;
        Value r3 = this._value;
        if (r0 != r1) goto L5;
        ((NumericFormulaValue) ZeusTransformUtils.preCheckCast(r3, NumericFormulaValue.class, "com.obric.memorydata.plugin")).setPreEvaluatedValue(r4);
        return;
    L5:
        ((NumericValue) ZeusTransformUtils.preCheckCast(r3, NumericValue.class, "com.obric.memorydata.plugin")).setValue(r4);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(String r4) {
        ensureTypeOrFormulaType(CellType.STRING);
        CellType r0 = this._value.getType();
        CellType r1 = CellType.FORMULA;
        Value r3 = this._value;
        if (r0 != r1) goto L5;
        ((StringFormulaValue) ZeusTransformUtils.preCheckCast(r3, StringFormulaValue.class, "com.obric.memorydata.plugin")).setPreEvaluatedValue(r4);
        return;
    L5:
        ((PlainStringValue) ZeusTransformUtils.preCheckCast(r3, PlainStringValue.class, "com.obric.memorydata.plugin")).setValue(r4);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(RichTextString r4) {
        RichTextString r5 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r4, RichTextString.class, "com.obric.memorydata.plugin");
        ensureRichTextStringType();
        boolean r0 = ZeusTransformUtils.instanceOf(this._value, RichTextStringFormulaValue.class);
        Value r3 = this._value;
        if (r0 == false) goto L5;
        ((RichTextStringFormulaValue) ZeusTransformUtils.preCheckCast(r3, RichTextStringFormulaValue.class, "com.obric.memorydata.plugin")).setPreEvaluatedValue(r5);
        return;
    L5:
        ((RichTextValue) ZeusTransformUtils.preCheckCast(r3, RichTextValue.class, "com.obric.memorydata.plugin")).setValue(r5);
    }

    void setType(CellType r4) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r4.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L9:
        Value r5 = new ErrorValue();
    L18:
        this._value = r5;
        return;
    L10:
        BooleanValue r6 = new BooleanValue();
        r5 = r6;
        if (this._value == null) goto L18;
        r6.setValue(convertCellValueToBoolean());
        r5 = r6;
        goto L18
    L13:
        PlainStringValue r7 = new PlainStringValue();
        r5 = r7;
        if (this._value == null) goto L18;
        r7.setValue(convertCellValueToString());
        r5 = r7;
        goto L18
    L16:
        r5 = new NumericValue();
        goto L18
    L17:
        r5 = new BlankValue();
        goto L18
    L5:
        throw new IllegalArgumentException("Illegal type " + r4);
    L7:
        if (getCellType() != CellType.BLANK) goto L20;
        r5 = new NumericFormulaValue("", 0.0d);
        goto L18
    }

    public String toString() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L18;
            case 3: goto L16;
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
        return getCellFormula();
    L9:
        return ErrorEval.getText(getErrorCellValue());
    L11:
        if (getBooleanCellValue() == false) goto L13;
        return "TRUE";
    L13:
        return "FALSE";
    L16:
        return getRichStringCellValue().toString();
    L18:
        if (DateUtil.isCellDateFormatted(this) == false) goto L22;
        SimpleDateFormat r0 = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
        r0.setTimeZone(LocaleUtil.getUserTimeZone());
        return r0.format(getDateCellValue());
    L22:
        return getNumericCellValue() + "";
    }
}
