package org.apache.poi.hssf.usermodel;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import kotlin.UShort;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFCell extends CellBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LAST_COLUMN_NAME = null;
    public static final int LAST_COLUMN_NUMBER = 0;
    private final HSSFWorkbook _book;
    private CellType _cellType;
    private CellValueRecordInterface _record;
    private final HSSFSheet _sheet;
    private HSSFRichTextString _stringValue;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[HyperlinkType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = r0;
            r0[HyperlinkType.EMAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L38:
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L10:
            int[] r4 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r4;
            r4[CellType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L36:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L42:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L28:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L34:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    static {
        LAST_COLUMN_NUMBER = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        LAST_COLUMN_NAME = SpreadsheetVersion.EXCEL97.getLastColumnName();
    }

    public HSSFCell(HSSFWorkbook r7, HSSFSheet r8, int r9, short r10, CellType r11) {
        checkBounds(r10);
        this._cellType = CellType._NONE;
        this._stringValue = null;
        this._book = r7;
        this._sheet = r8;
        setCellType(r11, false, r9, r10, r8.getSheet().getXFIndexForColAt(r10));
    }

    public HSSFCell(HSSFWorkbook r3, HSSFSheet r4, CellValueRecordInterface r5) {
        CellValueRecordInterface r6 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r5, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        this._record = r6;
        this._cellType = determineType(r6);
        this._stringValue = null;
        this._book = r3;
        this._sheet = r4;
        int r7 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r7 != 1) goto L5;
        this._stringValue = new HSSFRichTextString(r3.getWorkbook(), (LabelSSTRecord) ZeusTransformUtils.preCheckCast(r6, LabelSSTRecord.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r7 != 2) goto L11;
        this._stringValue = new HSSFRichTextString(((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(r6, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getStringValue());
        return;
    }

    private static void checkBounds(int r3) {
        if (r3 < 0) goto L7;
        if (r3 > LAST_COLUMN_NUMBER) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid column index (" + r3 + ").  Allowable column range for BIFF8 is (0.." + LAST_COLUMN_NUMBER + ") or ('A'..'" + LAST_COLUMN_NAME + "')");
    }

    private static void checkFormulaCachedValueType(CellType r1, FormulaRecord r2) {
        CellType r3 = r2.getCachedResultTypeEnum();
        if (r3 != r1) goto L6;
        return;
    L6:
        throw typeMismatch(r1, r3, true);
    }

    private boolean convertCellValueToBoolean() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L16;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L16;
            default: goto L5;
        };
    L12:
        FormulaRecord r6 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord();
        checkFormulaCachedValueType(CellType.BOOLEAN, r6);
        return r6.getCachedBooleanValue();
    L16:
        return false;
    L5:
        throw new IllegalStateException("Unexpected cell type (" + this._cellType + ")");
    L7:
        return ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getBooleanValue();
    L9:
        if (((NumberRecord) ZeusTransformUtils.preCheckCast(this._record, NumberRecord.class, "com.obric.memorydata.plugin")).getValue() == 0.0d) goto L17;
        return true;
    L17:
        return false;
    L15:
        return Boolean.parseBoolean(this._book.getWorkbook().getSSTString(((LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin")).getSSTIndex()).getString());
    }

    private String convertCellValueToString() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()]) {
            case 1: goto L39;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L15:
        return "";
    L17:
        FormulaRecordAggregate r0 = (FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin");
        FormulaRecord r4 = r0.getFormulaRecord();
        int r5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r4.getCachedResultTypeEnum().ordinal()];
        if (r5 == 1) goto L37;
        if (r5 == 4) goto L35;
        if (r5 == 5) goto L30;
        if (r5 != 6) goto L28;
        return FormulaError.forInt(r4.getCachedErrorValue()).getString();
    L28:
        throw new IllegalStateException("Unexpected formula result type (" + this._cellType + ")");
    L30:
        if (r4.getCachedBooleanValue() == false) goto L33;
        return "TRUE";
    L33:
        return "FALSE";
    L35:
        return NumberToTextConverter.toText(r4.getValue());
    L37:
        return r0.getStringValue();
    L5:
        throw new IllegalStateException("Unexpected cell type (" + this._cellType + ")");
    L7:
        return FormulaError.forInt(((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getErrorValue()).getString();
    L9:
        if (((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getBooleanValue() == false) goto L12;
        return "TRUE";
    L12:
        return "FALSE";
    L14:
        return NumberToTextConverter.toText(((NumberRecord) ZeusTransformUtils.preCheckCast(this._record, NumberRecord.class, "com.obric.memorydata.plugin")).getValue());
    L39:
        return this._book.getWorkbook().getSSTString(((LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin")).getSSTIndex()).getString();
    }

    private static CellType determineType(CellValueRecordInterface r4) {
        CellValueRecordInterface r5 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, FormulaRecordAggregate.class) == true) goto L5;
        Record r0 = (Record) ZeusTransformUtils.preCheckCast(r5, Record.class, "com.obric.memorydata.plugin");
        short r2 = r0.getSid();
        if (r2 == 253) goto L26;
        if (r2 == 513) goto L24;
        if (r2 == 515) goto L22;
        if (r2 != 517) goto L20;
        if (((BoolErrRecord) ZeusTransformUtils.preCheckCast(r0, BoolErrRecord.class, "com.obric.memorydata.plugin")).isBoolean() == false) goto L18;
        return CellType.BOOLEAN;
    L18:
        return CellType.ERROR;
    L20:
        throw new RuntimeException("Bad cell value rec (" + r5.getClass().getName() + ")");
    L22:
        return CellType.NUMERIC;
    L24:
        return CellType.BLANK;
    L26:
        return CellType.STRING;
    L5:
        return CellType.FORMULA;
    }

    private void notifyFormulaChanging() {
        if (ZeusTransformUtils.instanceOf(this._record, FormulaRecordAggregate.class) == false) goto L6;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).notifyFormulaChanging();
        return;
    }

    private CellValue readValue() {
        if (getCellType() != CellType.FORMULA) goto L5;
        CellType r0 = getCachedFormulaResultType();
    L6:
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L19;
        if (r1 != 6) goto L17;
        return CellValue.getError(getErrorCellValue());
    L17:
        throw new IllegalStateException("Unexpected cell-type " + r0);
    L19:
        return CellValue.valueOf(getBooleanCellValue());
    L21:
        return new CellValue(getNumericCellValue());
    L23:
        return new CellValue(getStringCellValue());
    L5:
        r0 = getCellType();
        goto L6
    }

    private void restoreValue(CellValue r3) {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r3.getCellType().ordinal()];
        if (r0 != 1) goto L5;
        setCellValue(r3.getStringValue());
        return;
    L5:
        if (r0 != 4) goto L7;
        setCellValue(r3.getNumberValue());
        return;
    L7:
        if (r0 != 5) goto L9;
        setCellValue(r3.getBooleanValue());
        return;
    L9:
        if (r0 != 6) goto L12;
        setCellErrorValue(FormulaError.forInt(r3.getErrorValue()));
        return;
    L12:
        throw new IllegalStateException("Unexpected cell-type " + r3.getCellType() + " for cell-value: " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [org.apache.poi.hssf.record.NumberRecord] */
    /* JADX WARN: Type inference failed for: r0v23, types: [org.apache.poi.hssf.record.CellValueRecordInterface] */
    /* JADX WARN: Type inference failed for: r0v24, types: [org.apache.poi.hssf.record.BoolErrRecord] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.apache.poi.hssf.record.LabelSSTRecord] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    private void setCellType(CellType r8, boolean r9, int r10, short r11, short r12) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r8.ordinal()]) {
            case 1: goto L44;
            case 2: goto L36;
            case 3: goto L30;
            case 4: goto L22;
            case 5: goto L14;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Invalid cell type: " + r8);
    L7:
        if (r8 == this._cellType) goto L9;
        BoolErrRecord r0 = new BoolErrRecord();
    L10:
        r0.setColumn(r11);
        ?? r1 = r0;
        if (r9 == false) goto L20;
        r0.setValue(FormulaError.VALUE.getCode());
        r1 = r0;
    L20:
        r1.setXFIndex(r12);
        r1.setRow(r10);
    L53:
        this._record = r1;
    L54:
        CellType r13 = this._cellType;
        if (r8 != r13) goto L57;
    L59:
        this._cellType = r8;
        return;
    L57:
        if (r13 == CellType._NONE) goto L59;
        this._sheet.getSheet().replaceValueRecord(this._record);
        goto L59
    L9:
        r0 = (BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin");
        goto L10
    L14:
        if (r8 == this._cellType) goto L16;
        BoolErrRecord r2 = new BoolErrRecord();
    L17:
        r2.setColumn(r11);
        r1 = r2;
        if (r9 == false) goto L20;
        r2.setValue(convertCellValueToBoolean());
        r1 = r2;
        goto L20
    L16:
        r2 = (BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin");
        goto L17
    L22:
        if (r8 == this._cellType) goto L24;
        r1 = new NumberRecord();
    L25:
        r1.setColumn(r11);
        if (r9 == false) goto L28;
        r1.setValue(getNumericCellValue());
    L28:
        r1.setXFIndex(r12);
        r1.setRow(r10);
        goto L53
    L24:
        r1 = (NumberRecord) ZeusTransformUtils.preCheckCast(this._record, NumberRecord.class, "com.obric.memorydata.plugin");
        goto L25
    L30:
        if (r8 == this._cellType) goto L32;
        BlankRecord r14 = new BlankRecord();
    L33:
        r14.setColumn(r11);
        r14.setXFIndex(r12);
        r14.setRow(r10);
        CellValueRecordInterface r15 = r14;
    L34:
        this._record = r15;
        goto L54
    L32:
        r14 = (BlankRecord) ZeusTransformUtils.preCheckCast(this._record, BlankRecord.class, "com.obric.memorydata.plugin");
        goto L33
    L36:
        if (r8 == this._cellType) goto L38;
        FormulaRecordAggregate r16 = this._sheet.getSheet().getRowsAggregate().createFormula(r10, r11);
    L40:
        if (getCellType() != CellType.BLANK) goto L42;
        r16.getFormulaRecord().setValue(0.0d);
    L42:
        r16.setXFIndex(r12);
        r15 = r16;
        goto L34
    L38:
        FormulaRecordAggregate r17 = (FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin");
        r17.setRow(r10);
        r17.setColumn(r11);
        r16 = r17;
        goto L40
    L44:
        if (r8 != this._cellType) goto L46;
        r1 = (LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin");
    L47:
        if (r9 == false) goto L53;
        String r18 = convertCellValueToString();
        if (r18 != null) goto L52;
        setCellType(CellType.BLANK, false, r10, r11, r12);
        return;
    L52:
        int r19 = this._book.getWorkbook().addSSTString(new UnicodeString(r18));
        r1.setSSTIndex(r19);
        UnicodeString r20 = this._book.getWorkbook().getSSTString(r19);
        HSSFRichTextString r110 = new HSSFRichTextString();
        this._stringValue = r110;
        r110.setUnicodeString(r20);
        goto L53
    L46:
        LabelSSTRecord r3 = new LabelSSTRecord();
        r3.setColumn(r11);
        r3.setRow(r10);
        r3.setXFIndex(r12);
        r1 = r3;
        goto L47
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

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        if (this._cellType != CellType.FORMULA) goto L7;
        return ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getArrayFormulaRange();
    L7:
        throw new IllegalStateException("Cell " + new CellReference(this).formatAsString() + " is not part of an array formula.");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        FormulaRecord r4 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord();
        checkFormulaCachedValueType(CellType.BOOLEAN, r4);
        return r4.getCachedBooleanValue();
    L5:
        if (r0 != 3) goto L7;
        return false;
    L7:
        if (r0 != 5) goto L11;
        return ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getBooleanValue();
    L11:
        throw typeMismatch(CellType.BOOLEAN, this._cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultType() {
        if (this._cellType != CellType.FORMULA) goto L7;
        return ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord().getCachedResultTypeEnum();
    L7:
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        if (ZeusTransformUtils.instanceOf(this._record, FormulaRecordAggregate.class) == false) goto L7;
        return HSSFFormulaParser.toFormulaString(this._book, ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaTokens());
    L7:
        throw typeMismatch(CellType.FORMULA, this._cellType, true);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFCellStyle getCellStyle() {
        short r0 = this._record.getXFIndex();
        return new HSSFCellStyle(r0, this._book.getWorkbook().getExFormatAt(r0), this._book);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ CellStyle getCellStyle() {
        return getCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellType() {
        return this._cellType;
    }

    public CellValueRecordInterface getCellValueRecord() {
        return this._record;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._record.getColumn() & UShort.MAX_VALUE;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (this._cellType != CellType.BLANK) goto L6;
        return null;
    L6:
        double r0 = getNumericCellValue();
        if (this._book.getWorkbook().isUsing1904DateWindowing() == false) goto L11;
        boolean r2 = true;
    L10:
        return DateUtil.getJavaDate(r0, r2);
    L11:
        r2 = false;
        goto L10
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        FormulaRecord r3 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord();
        checkFormulaCachedValueType(CellType.ERROR, r3);
        return (byte) r3.getCachedErrorValue();
    L5:
        if (r0 != 6) goto L9;
        return ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getErrorValue();
    L9:
        throw typeMismatch(CellType.ERROR, this._cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public LocalDateTime getLocalDateTimeCellValue() {
        if (this._cellType != CellType.BLANK) goto L6;
        return null;
    L6:
        double r0 = getNumericCellValue();
        if (this._book.getWorkbook().isUsing1904DateWindowing() == false) goto L11;
        boolean r2 = true;
    L10:
        return DateUtil.getLocalDateTime(r0, r2);
    L11:
        r2 = false;
        goto L10
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        FormulaRecord r3 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord();
        checkFormulaCachedValueType(CellType.NUMERIC, r3);
        return r3.getValue();
    L5:
        if (r0 != 3) goto L7;
        return 0.0d;
    L7:
        if (r0 != 4) goto L11;
        return ((NumberRecord) ZeusTransformUtils.preCheckCast(this._record, NumberRecord.class, "com.obric.memorydata.plugin")).getValue();
    L11:
        throw typeMismatch(CellType.NUMERIC, this._cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRichTextString getRichStringCellValue() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 == 1) goto L19;
        String r2 = "";
        if (r0 != 2) goto L7;
        FormulaRecordAggregate r3 = (FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin");
        checkFormulaCachedValueType(CellType.STRING, r3.getFormulaRecord());
        String r4 = r3.getStringValue();
        if (r4 == null) goto L17;
        r2 = r4;
    L17:
        return new HSSFRichTextString(r2);
    L7:
        if (r0 != 3) goto L11;
        return new HSSFRichTextString("");
    L11:
        throw typeMismatch(CellType.STRING, this._cellType, false);
    L19:
        return this._stringValue;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ RichTextString getRichStringCellValue() {
        return getRichStringCellValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRow getRow() {
        int r0 = getRowIndex();
        return this._sheet.getRow(r0);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ Row getRow() {
        return getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._record.getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public /* bridge */ /* synthetic */ Sheet getSheet() {
        return getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL97;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        if (this._cellType == CellType.FORMULA) goto L5;
    L7:
        return false;
    L5:
        if (((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).isPartOfArrayFormula() == false) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void removeFormulaImpl() {
        notifyFormulaChanging();
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCachedFormulaResultType().ordinal()];
        if (r0 != 1) goto L5;
        NumberRecord r1 = new NumberRecord();
        this._record = r1;
        ((NumberRecord) ZeusTransformUtils.preCheckCast(r1, NumberRecord.class, "com.obric.memorydata.plugin")).setValue(0.0d);
        CellType r2 = CellType.STRING;
    L20:
        this._cellType = r2;
        return;
    L5:
        if (r0 != 4) goto L7;
        double r3 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord().getValue();
        NumberRecord r4 = new NumberRecord();
        this._record = r4;
        ((NumberRecord) ZeusTransformUtils.preCheckCast(r4, NumberRecord.class, "com.obric.memorydata.plugin")).setValue(r3);
        r2 = CellType.NUMERIC;
        goto L20
    L7:
        if (r0 != 5) goto L9;
        boolean r5 = ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord().getCachedBooleanValue();
        BoolErrRecord r6 = new BoolErrRecord();
        this._record = r6;
        ((BoolErrRecord) ZeusTransformUtils.preCheckCast(r6, BoolErrRecord.class, "com.obric.memorydata.plugin")).setValue(r5);
        r2 = CellType.BOOLEAN;
        goto L20
    L9:
        if (r0 != 6) goto L16;
        byte r7 = (byte) ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaRecord().getCachedErrorValue();
        BoolErrRecord r8 = new BoolErrRecord();
        this._record = r8;
        ((BoolErrRecord) ZeusTransformUtils.preCheckCast(r8, BoolErrRecord.class, "com.obric.memorydata.plugin")).setValue(r7);     // Catch: IllegalArgumentException -> L13
    L14:
        r2 = CellType.ERROR;
    L13:
        ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).setValue((byte) ErrorEval.REF_INVALID.getErrorCode());
        goto L14
    L16:
        throw new AssertionError();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @Deprecated
    public void setCellErrorValue(byte r1) {
        setCellErrorValue(FormulaError.forInt(r1));
    }

    public void setCellErrorValue(FormulaError r9) {
        int r4 = this._record.getRow();
        short r5 = this._record.getColumn();
        short r6 = this._record.getXFIndex();
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).setCachedErrorResult(r9.getCode());
        return;
    L5:
        if (r0 == 6) goto L7;
        setCellType(CellType.ERROR, false, r4, r5, r6);
    L7:
        ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).setValue(r9);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellFormulaImpl(String r8) {
        if (getValueType() != CellType.BLANK) goto L5;
        setCellValue(0.0d);
    L5:
        int r4 = this._record.getRow();
        short r5 = this._record.getColumn();
        short r6 = this._record.getXFIndex();
        CellValue r0 = readValue();
        int r1 = this._book.getSheetIndex(this._sheet);
        Ptg[] r9 = HSSFFormulaParser.parse(r8, this._book, FormulaType.CELL, r1);
        setCellType(CellType.FORMULA, false, r4, r5, r6);
        FormulaRecordAggregate r2 = (FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin");
        r2.getFormulaRecord().setOptions(2);
        if (r2.getXFIndex() != 0) goto L8;
        r2.setXFIndex(15);
    L8:
        r2.setParsedExpression(r9);
        restoreValue(r0);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellTypeImpl(CellType r8) {
        notifyFormulaChanging();
        setCellType(r8, true, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean r9) {
        int r4 = this._record.getRow();
        short r5 = this._record.getColumn();
        short r6 = this._record.getXFIndex();
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).setCachedBooleanResult(r9);
        return;
    L5:
        if (r0 == 5) goto L7;
        setCellType(CellType.BOOLEAN, false, r4, r5, r6);
    L7:
        ((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).setValue(r9);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(double r10) {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 != 2) goto L5;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).setCachedDoubleResult(r10);
        return;
    L5:
        if (r0 == 4) goto L7;
        setCellType(CellType.NUMERIC, false, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
    L7:
        ((NumberRecord) ZeusTransformUtils.preCheckCast(this._record, NumberRecord.class, "com.obric.memorydata.plugin")).setValue(r10);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(String r2) {
        setCellValueImpl(new HSSFRichTextString(r2));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(RichTextString r9) {
        RichTextString r10 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r9, RichTextString.class, "com.obric.memorydata.plugin");
        if (this._cellType != CellType.FORMULA) goto L7;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(this._record, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).setCachedStringResult(r10.getString());
        this._stringValue = new HSSFRichTextString(r10.getString());
        return;
    L7:
        if (this._cellType == CellType.STRING) goto L10;
        int r5 = this._record.getRow();
        short r6 = this._record.getColumn();
        short r7 = this._record.getXFIndex();
        setCellType(CellType.STRING, false, r5, r6, r7);
    L10:
        if (ZeusTransformUtils.instanceOf(r10, HSSFRichTextString.class) == false) goto L12;
        HSSFRichTextString r11 = (HSSFRichTextString) ZeusTransformUtils.preCheckCast(r10, HSSFRichTextString.class, "com.obric.memorydata.plugin");
        UnicodeString r0 = r11.getUnicodeString();
        int r1 = this._book.getWorkbook().addSSTString(r0);
        ((LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin")).setSSTIndex(r1);
        this._stringValue = r11;
        r11.setWorkbookReferences(this._book.getWorkbook(), (LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin"));
        this._stringValue.setUnicodeString(this._book.getWorkbook().getSSTString(r1));
        return;
    L12:
        HSSFRichTextString r2 = new HSSFRichTextString(r10.getString());
        UnicodeString r12 = r2.getUnicodeString();
        int r13 = this._book.getWorkbook().addSSTString(r12);
        ((LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin")).setSSTIndex(r13);
        this._stringValue = r2;
        r2.setWorkbookReferences(this._book.getWorkbook(), (LabelSSTRecord) ZeusTransformUtils.preCheckCast(this._record, LabelSSTRecord.class, "com.obric.memorydata.plugin"));
        this._stringValue.setUnicodeString(this._book.getWorkbook().getSSTString(r13));
    }

    public String toString() {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()]) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L19;
            case 4: goto L14;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L19:
        return "";
    L5:
        return "Unknown Cell Type: " + getCellType();
    L7:
        return ErrorEval.getText(((BoolErrRecord) ZeusTransformUtils.preCheckCast(this._record, BoolErrRecord.class, "com.obric.memorydata.plugin")).getErrorValue());
    L9:
        if (getBooleanCellValue() == false) goto L11;
        return "TRUE";
    L11:
        return "FALSE";
    L14:
        if (DateUtil.isCellDateFormatted(this) == false) goto L18;
        SimpleDateFormat r0 = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
        r0.setTimeZone(LocaleUtil.getUserTimeZone());
        return r0.format(getDateCellValue());
    L18:
        return String.valueOf(getNumericCellValue());
    L22:
        return getCellFormula();
    L24:
        return getStringCellValue();
    }
}
