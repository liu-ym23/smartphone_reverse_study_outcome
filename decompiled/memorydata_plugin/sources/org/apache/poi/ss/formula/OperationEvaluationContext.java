package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class OperationEvaluationContext {
    public static final FreeRefFunction UDF = null;
    private final WorkbookEvaluator _bookEvaluator;
    private final int _columnIndex;
    private boolean _isInArrayContext;
    private final boolean _isSingleValue;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;
    private final EvaluationWorkbook _workbook;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.OperationEvaluationContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$util$CellReference$NameType = null;

        static {
            int[] r0 = new int[CellReference.NameType.values().length];
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType = r0;
            r0[CellReference.NameType.BAD_CELL_OR_NAMED_RANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.NAMED_RANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.COLUMN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.ROW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.CELL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        UDF = UserDefinedFunction.instance;
    }

    public OperationEvaluationContext(WorkbookEvaluator r9, EvaluationWorkbook r10, int r11, int r12, int r13, EvaluationTracker r14) {
        this(r9, (EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r10, EvaluationWorkbook.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, true);
    }

    public OperationEvaluationContext(WorkbookEvaluator r3, EvaluationWorkbook r4, int r5, int r6, int r7, EvaluationTracker r8, boolean r9) {
        EvaluationWorkbook r10 = (EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r4, EvaluationWorkbook.class, "com.obric.memorydata.plugin");
        this._bookEvaluator = r3;
        this._workbook = r10;
        this._sheetIndex = r5;
        this._rowIndex = r6;
        this._columnIndex = r7;
        this._tracker = r8;
        this._isSingleValue = r9;
    }

    public static CellReference applyR1C1Reference(CellReference r7, String r8) {
        String r0 = r8.toUpperCase(LocaleUtil.getUserLocale());
        int r1 = r0.indexOf(82);
        int r2 = r0.indexOf(67);
        if (r1 < 0) goto L32;
        if (r2 <= r1) goto L32;
        String r3 = r8.substring(r1 + 1, r2).trim();
        String r9 = r8.substring(r2 + 1).trim();
        int r5 = 0;
        int r6 = -1;
        if (r3.startsWith("[") == false) goto L11;
        if (r3.endsWith("]") == false) goto L11;
        int r4 = Integer.parseInt(r3.substring(1, r3.length() - 1).trim());
    L14:
        int r10 = -1;
    L16:
        if (r9.startsWith("[") == false) goto L21;
        if (r9.endsWith("]") == false) goto L21;
        r5 = Integer.parseInt(r9.substring(1, r9.length() - 1).trim());
    L23:
        if (r10 < 0) goto L25;
        int r11 = r10 - 1;
    L26:
        if (r6 < 0) goto L28;
        int r12 = r6 - 1;
    L30:
        return new CellReference(r11, r12);
    L28:
        r12 = r7.getCol() + r5;
        goto L30
    L25:
        r11 = r7.getRow() + r4;
    L21:
        if (r9.isEmpty() == true) goto L23;
        r6 = Integer.parseInt(r9);
    L11:
        if (r3.isEmpty() == true) goto L13;
        r10 = Integer.parseInt(r3);
        r4 = 0;
        goto L16
    L13:
        r4 = 0;
    L32:
        throw new IllegalArgumentException(r8 + " is not a valid R1C1 reference");
    }

    private static CellReference.NameType classifyCellReference(String r2, SpreadsheetVersion r3) {
        if (r2.length() >= 1) goto L7;
        return CellReference.NameType.BAD_CELL_OR_NAMED_RANGE;
    L7:
        return CellReference.classifyCellReference(r2, r3);
    }

    private ValueEval convertObjectEval(Object r3) {
        if (r3 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        return new StringEval((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L12;
        return new NumberEval(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L12:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L16;
        return BoolEval.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L16:
        if (ZeusTransformUtils.instanceOf(r3, ErrorConstant.class) == false) goto L20;
        return ErrorEval.valueOf(((ErrorConstant) ZeusTransformUtils.preCheckCast(r3, ErrorConstant.class, "com.obric.memorydata.plugin")).getErrorCode());
    L20:
        throw new IllegalArgumentException("Unexpected constant class (" + r3.getClass().getName() + ")");
    L22:
        throw new RuntimeException("Array item cannot be null");
    }

    private SheetRefEvaluator createExternSheetRefEvaluator(String r3, String r4) {
        if (r3 != null) goto L5;
        WorkbookEvaluator r5 = this._bookEvaluator;
    L7:
        if (r4 != null) goto L9;
        int r6 = this._sheetIndex;
    L10:
        if (r6 >= 0) goto L13;
        return null;
    L13:
        return new SheetRefEvaluator(r5, this._tracker, r6);
    L9:
        r6 = r5.getSheetIndex(r4);
        goto L10
    L5:
        if (r4 == null) goto L15;
        r5 = this._bookEvaluator.getOtherWorkbookEvaluator(r3);     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L16
    L19:
        return null;
    L15:
        throw new IllegalArgumentException("sheetName must not be null if workbookName is provided");
    }

    private ValueEval getExternalNameXEval(EvaluationWorkbook.ExternalName r9, String r10) {
        WorkbookEvaluator r2 = this._bookEvaluator.getOtherWorkbookEvaluator(r10);     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L29
        EvaluationName r11 = r2.getName(r9.getName(), r9.getIx() - 1);     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L29
        if (r11 == null) goto L28;
        if (r11.hasFormula() == false) goto L28;
        if (r11.getNameDefinition().length > 1) goto L26;
        OperationEvaluationContext r12 = new OperationEvaluationContext(r2, r2.getWorkbook(), -1, -1, -1, this._tracker);     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L29
        Ptg r8 = r11.getNameDefinition()[0];     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L29
        if (ZeusTransformUtils.instanceOf(r8, Ref3DPtg.class) == false) goto L14;
        return r12.getRef3DEval((Ref3DPtg) ZeusTransformUtils.preCheckCast(r8, Ref3DPtg.class, "com.obric.memorydata.plugin"));
    L14:
        if (ZeusTransformUtils.instanceOf(r8, Ref3DPxg.class) == false) goto L18;
        return r12.getRef3DEval((Ref3DPxg) ZeusTransformUtils.preCheckCast(r8, Ref3DPxg.class, "com.obric.memorydata.plugin"));
    L18:
        if (ZeusTransformUtils.instanceOf(r8, Area3DPtg.class) == false) goto L22;
        return r12.getArea3DEval((Area3DPtg) ZeusTransformUtils.preCheckCast(r8, Area3DPtg.class, "com.obric.memorydata.plugin"));
    L22:
        if (ZeusTransformUtils.instanceOf(r8, Area3DPxg.class) == false) goto L28;
        return r12.getArea3DEval((Area3DPxg) ZeusTransformUtils.preCheckCast(r8, Area3DPxg.class, "com.obric.memorydata.plugin"));
    L26:
        throw new RuntimeException("Complex name formulas not supported yet");     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L29
    L28:
        return ErrorEval.REF_INVALID;
    L30:
        return ErrorEval.REF_INVALID;
    }

    private ValueEval getLocalNameXEval(NameXPtg r3) {
        String r4 = this._workbook.resolveNameXText(r3);
        int r0 = r4.indexOf(33);
        if (r0 <= (-1)) goto L5;
        String r1 = r4.substring(0, r0);
        String r2 = r4.substring(r0 + 1);
        EvaluationWorkbook r5 = this._workbook;
        EvaluationName r6 = r5.getName(r2, r5.getSheetIndex(r1));
    L6:
        if (r6 == null) goto L10;
        return new ExternalNameEval(r6);
    L10:
        return new FunctionNameEval(r4);
    L5:
        r6 = this._workbook.getName(r4, -1);
        goto L6
    }

    private ValueEval getLocalNameXEval(NameXPxg r3) {
        if (r3.getSheetName() == null) goto L5;
        int r0 = this._workbook.getSheetIndex(r3.getSheetName());
    L6:
        String r4 = r3.getNameName();
        EvaluationName r2 = this._workbook.getName(r4, r0);
        if (r2 == null) goto L11;
        return new ExternalNameEval(r2);
    L11:
        return new FunctionNameEval(r4);
    L5:
        r0 = -1;
        goto L6
    }

    private static CellReference.NameType getR1C1CellType(String r2) {
        String r3 = r2.toUpperCase(LocaleUtil.getUserLocale());
        int r0 = r3.indexOf(82);
        int r4 = r3.indexOf(67);
        if (r0 == (-1)) goto L9;
        if (r4 != (-1)) goto L8;
        return CellReference.NameType.ROW;
    L8:
        return CellReference.NameType.CELL;
    L9:
        if (r4 != (-1)) goto L13;
        return CellReference.NameType.BAD_CELL_OR_NAMED_RANGE;
    L13:
        return CellReference.NameType.COLUMN;
    }

    private static int parseColRef(String r0) {
        return Integer.parseInt(r0) - 1;
    }

    private static int parseRowRef(String r0) {
        return CellReference.convertColStringToIndex(r0);
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(int r2) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(r2));
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(String r2, String r3, int r4) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(r2, r3, r4));
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(EvaluationWorkbook.ExternalSheet r9) {
        int r1 = 0;
        if (r9 != null) goto L5;
    L20:
        WorkbookEvaluator r4 = this._bookEvaluator;
        if (r9 != null) goto L23;
        int r5 = 0;
    L25:
        if (ZeusTransformUtils.instanceOf(r9, EvaluationWorkbook.ExternalSheetRange.class) == false) goto L27;
        int r0 = this._workbook.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) ZeusTransformUtils.preCheckCast(r9, EvaluationWorkbook.ExternalSheetRange.class, "com.obric.memorydata.plugin")).getLastSheetName());
    L28:
        if (r0 != (-1)) goto L30;
        r0 = r5;
    L30:
        int r10 = (r0 - r5) + 1;
        SheetRefEvaluator[] r2 = new SheetRefEvaluator[r10];
    L31:
        if (r1 >= r10) goto L34;
        r2[r1] = new SheetRefEvaluator(r4, this._tracker, r1 + r5);
        r1 = r1 + 1;
        goto L31
    L34:
        return new SheetRangeEvaluator(r5, r0, r2);
    L27:
        r0 = -1;
        goto L28
    L23:
        r5 = this._workbook.getSheetIndex(r9.getSheetName());
        goto L25
    L5:
        if (r9.getWorkbookName() == null) goto L20;
        String r3 = r9.getWorkbookName();
        r4 = this._bookEvaluator.getOtherWorkbookEvaluator(r3);     // Catch: CollaboratingWorkbooksEnvironment.WorkbookNotFoundException -> L17
        r5 = r4.getSheetIndex(r9.getSheetName());
        if (ZeusTransformUtils.instanceOf(r9, EvaluationWorkbook.ExternalSheetRange.class) == false) goto L12;
        r0 = r4.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) ZeusTransformUtils.preCheckCast(r9, EvaluationWorkbook.ExternalSheetRange.class, "com.obric.memorydata.plugin")).getLastSheetName());
    L13:
        if (r5 >= 0) goto L28;
        throw new RuntimeException("Invalid sheet name '" + r9.getSheetName() + "' in bool '" + r3 + "'.");
    L12:
        r0 = -1;
    L17:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public FreeRefFunction findUserDefinedFunction(String r1) {
        return this._bookEvaluator.findUserDefinedFunction(r1);
    }

    public ValueEval getArea3DEval(Area3DPtg r8) {
        SheetRangeEvaluator r6 = createExternSheetRefEvaluator(r8.getExternSheetIndex());
        return new LazyAreaEval(r8.getFirstRow(), r8.getFirstColumn(), r8.getLastRow(), r8.getLastColumn(), r6);
    }

    public ValueEval getArea3DEval(Area3DPxg r10) {
        SheetRangeEvaluator r8 = createExternSheetRefEvaluator(r10.getSheetName(), r10.getLastSheetName(), r10.getExternalWorkbookNumber());
        return new LazyAreaEval(r10.getFirstRow(), r10.getFirstColumn(), r10.getLastRow(), r10.getLastColumn(), r8);
    }

    public ValueEval getAreaEval(int r7, int r8, int r9, int r10) {
        return new LazyAreaEval(r7, r8, r9, r10, getRefEvaluatorForCurrentSheet());
    }

    public ValueEval getAreaValueEval(int r10, int r11, int r12, int r13, Object[][] r14) {
        ValueEval[] r7 = new ValueEval[r14.length * r14[0].length];
        int r0 = r14.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L10;
        Object[] r4 = r14[r2];
        int r5 = 0;
    L6:
        if (r5 >= r14[0].length) goto L8;
        r7[r3] = convertObjectEval(r4[r5]);
        r5 = r5 + 1;
        r3 = r3 + 1;
        goto L6
    L8:
        r2 = r2 + 1;
        goto L3
    L10:
        return new CacheAreaEval(r10, r11, r12, r13, r7);
    }

    public int getColumnIndex() {
        return this._columnIndex;
    }

    public ValueEval getDynamicReference(String r18, String r19, String r20, String r21, boolean r22) {
        SheetRefEvaluator r3 = createExternSheetRefEvaluator(r18, r19);
        if (r3 == null) goto L5;
        SheetRangeEvaluator r4 = new SheetRangeEvaluator(this._sheetIndex, r3);
        SpreadsheetVersion r5 = this._workbook.getSpreadsheetVersion();
        if (r22 == false) goto L9;
        CellReference.NameType r6 = classifyCellReference(r20, r5);
    L10:
        int r7 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[r6.ordinal()];
        if (r7 == 1) goto L104;
        if (r7 != 2) goto L15;
        EvaluationName r2 = this._workbook.getName(r20, this._sheetIndex);
        if (r2 == null) goto L102;
        if (r2.isRange() == false) goto L100;
        return this._bookEvaluator.evaluateNameFormula(r2.getNameDefinition(), this);
    L100:
        throw new RuntimeException("Specified name '" + r20 + "' is not a range as expected.");
    L102:
        throw new RuntimeException("Specified name '" + r20 + "' is not found in the workbook (sheetIndex=" + this._sheetIndex + ").");
    L15:
        if (r21 != null) goto L61;
        int r8 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[r6.ordinal()];
        if (r8 == 3) goto L44;
        if (r8 == 4) goto L27;
        if (r8 != 5) goto L26;
        if (r22 == false) goto L22;
        CellReference r0 = new CellReference(r20);
    L24:
        return new LazyRefEval(r0.getRow(), r0.getCol(), r4);
    L22:
        r0 = applyR1C1Reference(new CellReference(getRowIndex(), getColumnIndex()), r20);
        goto L24
    L26:
        throw new IllegalStateException("Unexpected reference classification of '" + r20 + "'.");
    L27:
        if (r22 == true) goto L29;
        String r1 = r20.substring(r20.toUpperCase(LocaleUtil.getUserLocale()).indexOf(82) + 1).trim();     // Catch: Exception -> L42
        if (r1.startsWith("[") == false) goto L36;
        if (r1.endsWith("]") == false) goto L36;
        int r9 = getRowIndex() + Integer.parseInt(r1.substring(1, r1.length() - 1).trim());     // Catch: Exception -> L42
    L39:
        return new LazyAreaEval(r9, 0, r9, r5.getLastColumnIndex(), r4);
    L36:
        if (r1.isEmpty() == true) goto L41;
        r9 = Integer.parseInt(r1) - 1;     // Catch: Exception -> L42
        goto L39
    L41:
        return ErrorEval.REF_INVALID;
    L43:
        return ErrorEval.REF_INVALID;
    L29:
        return ErrorEval.REF_INVALID;
    L44:
        if (r22 == true) goto L46;
        String r10 = r20.substring(r20.toUpperCase(LocaleUtil.getUserLocale()).indexOf(67) + 1).trim();     // Catch: Exception -> L59
        if (r10.startsWith("[") == false) goto L53;
        if (r10.endsWith("]") == false) goto L53;
        int r11 = getColumnIndex() + Integer.parseInt(r10.substring(1, r10.length() - 1).trim());     // Catch: Exception -> L59
    L56:
        return new LazyAreaEval(0, r11, r5.getLastRowIndex(), r11, r4);
    L53:
        if (r10.isEmpty() == true) goto L58;
        r11 = Integer.parseInt(r10) - 1;     // Catch: Exception -> L59
        goto L56
    L58:
        return ErrorEval.REF_INVALID;
    L60:
        return ErrorEval.REF_INVALID;
    L46:
        return ErrorEval.REF_INVALID;
    L61:
        if (r22 == false) goto L63;
        CellReference.NameType r13 = classifyCellReference(r21, r5);
    L64:
        int r14 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[r13.ordinal()];
        if (r14 == 1) goto L92;
        if (r14 == 2) goto L90;
        if (r13 != r6) goto L69;
        int r12 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[r6.ordinal()];
        if (r12 == 3) goto L86;
        if (r12 == 4) goto L85;
        if (r12 != 5) goto L84;
        if (r22 == false) goto L77;
        CellReference r15 = new CellReference(r20);
    L78:
        int r16 = r15.getRow();
        int r17 = r15.getCol();
        if (r22 == false) goto L81;
        CellReference r23 = new CellReference(r21);
    L82:
        int r24 = r23.getRow();
        int r25 = r23.getCol();
    L88:
        return new LazyAreaEval(r16, r17, r24, r25, r4);
    L81:
        r23 = applyR1C1Reference(new CellReference(getRowIndex(), getColumnIndex()), r21);
        goto L82
    L77:
        r15 = new CellReference(getRowIndex(), getColumnIndex());
        r15 = applyR1C1Reference(r15, r20);
        goto L78
    L84:
        throw new IllegalStateException("Unexpected reference classification of '" + r20 + "'.");
    L85:
        r25 = r5.getLastColumnIndex();
        r16 = parseColRef(r20);
        r24 = parseColRef(r21);
        r17 = 0;
        goto L88
    L86:
        int r26 = r5.getLastRowIndex();
        r17 = parseRowRef(r20);
        r16 = 0;
        r24 = r26;
        r25 = parseRowRef(r21);
        goto L88
    L69:
        return ErrorEval.REF_INVALID;
    L90:
        throw new RuntimeException("Cannot evaluate '" + r20 + "'. Indirect evaluation of defined names not supported yet");
    L92:
        return ErrorEval.REF_INVALID;
    L63:
        r13 = getR1C1CellType(r21);
        goto L64
    L104:
        return ErrorEval.REF_INVALID;
    L9:
        r6 = getR1C1CellType(r20);
        goto L10
    L5:
        return ErrorEval.REF_INVALID;
    }

    public ValueEval getNameXEval(NameXPtg r4) {
        EvaluationWorkbook.ExternalSheet r0 = this._workbook.getExternalSheet(r4.getSheetRefIndex());
        if (r0 == null) goto L10;
        if (r0.getWorkbookName() == null) goto L10;
        String r1 = r0.getWorkbookName();
        return getExternalNameXEval(this._workbook.getExternalName(r4.getSheetRefIndex(), r4.getNameIndex()), r1);
    L10:
        return getLocalNameXEval(r4);
    }

    public ValueEval getNameXEval(NameXPxg r5) {
        EvaluationWorkbook.ExternalSheet r0 = this._workbook.getExternalSheet(r5.getSheetName(), null, r5.getExternalWorkbookNumber());
        if (r0 == null) goto L10;
        if (r0.getWorkbookName() == null) goto L10;
        String r1 = r0.getWorkbookName();
        return getExternalNameXEval(this._workbook.getExternalName(r5.getNameName(), r5.getSheetName(), r5.getExternalWorkbookNumber()), r1);
    L10:
        return getLocalNameXEval(r5);
    }

    public ValueEval getRef3DEval(Ref3DPtg r3) {
        SheetRangeEvaluator r2 = createExternSheetRefEvaluator(r3.getExternSheetIndex());
        return new LazyRefEval(r3.getRow(), r3.getColumn(), r2);
    }

    public ValueEval getRef3DEval(Ref3DPxg r4) {
        SheetRangeEvaluator r3 = createExternSheetRefEvaluator(r4.getSheetName(), r4.getLastSheetName(), r4.getExternalWorkbookNumber());
        return new LazyRefEval(r4.getRow(), r4.getColumn(), r3);
    }

    public ValueEval getRefEval(int r2, int r3) {
        return new LazyRefEval(r2, r3, getRefEvaluatorForCurrentSheet());
    }

    public SheetRangeEvaluator getRefEvaluatorForCurrentSheet() {
        SheetRefEvaluator r0 = new SheetRefEvaluator(this._bookEvaluator, this._tracker, this._sheetIndex);
        return new SheetRangeEvaluator(this._sheetIndex, r0);
    }

    public int getRowIndex() {
        return this._rowIndex;
    }

    public int getSheetIndex() {
        return this._sheetIndex;
    }

    public EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    public boolean isArraymode() {
        return this._isInArrayContext;
    }

    public boolean isSingleValue() {
        return this._isSingleValue;
    }

    public void setArrayMode(boolean r1) {
        this._isInArrayContext = r1;
    }
}
