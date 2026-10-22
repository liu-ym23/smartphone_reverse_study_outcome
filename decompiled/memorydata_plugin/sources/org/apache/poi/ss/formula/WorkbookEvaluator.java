package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayMode;
import org.apache.poi.ss.formula.functions.Choose;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.UnknownPtg;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class WorkbookEvaluator {
    private static final c LOG = null;
    private final c EVAL_LOG;
    private EvaluationCache _cache;
    private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
    private final IEvaluationListener _evaluationListener;
    private boolean _ignoreMissingWorkbooks;
    private final Map<String, Integer> _sheetIndexesByName;
    private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
    private final IStabilityClassifier _stabilityClassifier;
    private final AggregatingUDFFinder _udfFinder;
    private final EvaluationWorkbook _workbook;
    private int _workbookIx;
    private boolean dbgEvaluationOutputForNextEval;
    private int dbgEvaluationOutputIndent;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.WorkbookEvaluator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        LOG = b.a(WorkbookEvaluator.class);
    }

    private NotImplementedException addExceptionInfo(NotImplementedException r7, int r8, int r9, int r10) {
        return new NotImplementedException("Error evaluating cell " + new CellReference(this._workbook.getSheetName(r8), r9, r10, false, false).formatAsString(), r7);
    L4:
        e = move-exception;
        LOG.atError().a(e).a("Can't add exception info");
        return r7;
    }

    private boolean adjustRegionRelativeReference(Ptg[] r10, CellReference r11, CellRangeAddressBase r12) {
        int r0 = r11.getRow() - r12.getFirstRow();
        int r13 = r11.getCol() - r12.getFirstColumn();
        int r14 = r10.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r14) goto L23;
        Ptg r3 = r10[r1];
        if (ZeusTransformUtils.instanceOf(r3, RefPtgBase.class) == false) goto L22;
        RefPtgBase r4 = (RefPtgBase) ZeusTransformUtils.preCheckCast(r3, RefPtgBase.class, "com.obric.memorydata.plugin");
        SpreadsheetVersion r5 = this._workbook.getSpreadsheetVersion();
        if (r4.isRowRelative() == false) goto L15;
        if (r0 <= 0) goto L15;
        int r6 = r4.getRow() + r0;
        if (r6 > r5.getMaxRows()) goto L13;
        r4.setRow(r6);
        r2 = true;
        goto L15
    L13:
        throw new IndexOutOfBoundsException(r5.name() + " files can only have " + r5.getMaxRows() + " rows, but row " + r6 + " was requested.");
    L15:
        if (r4.isColRelative() == false) goto L22;
        if (r13 <= 0) goto L22;
        int r7 = r4.getColumn() + r13;
        if (r7 > r5.getMaxColumns()) goto L21;
        r4.setColumn(r7);
        r2 = true;
        goto L22
    L21:
        throw new IndexOutOfBoundsException(r5.name() + " files can only have " + r5.getMaxColumns() + " columns, but column " + r7 + " was requested.");
    L22:
        r1 = r1 + 1;
        goto L3
    L23:
        return r2;
    }

    private static int countTokensToBeSkipped(Ptg[] r2, int r3, int r4) {
        int r0 = r3;
    L3:
        if (r4 == 0) goto L14;
        r0 = r0 + 1;
        if (r0 >= r2.length) goto L12;
        r4 = r4 - r2[r0].getSize();
        if (r4 >= 0) goto L3;
        throw new RuntimeException("Bad skip distance (wrong token size calculation).");
    L12:
        throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
    L14:
        return r0 - r3;
    }

    public static ValueEval dereferenceResult(ValueEval r2, int r3, int r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);     // Catch: EvaluationException -> L8
        if (r5 == BlankEval.instance) goto L7;
        return r5;
    L7:
        return NumberEval.ZERO;
    L8:
        e = move-exception;
        return e.getErrorEval();
    }

    private static ValueEval dereferenceResult(ValueEval r4, OperationEvaluationContext r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        if (r5.getWorkbook() == null) goto L19;
        EvaluationCell r0 = r5.getWorkbook().getSheet(r5.getSheetIndex()).getCell(r5.getRowIndex(), r5.getColumnIndex());
        if (r0 != null) goto L9;
    L13:
        ValueEval r7 = dereferenceResult(r6, r5.getRowIndex(), r5.getColumnIndex());
    L15:
        if (r7 == BlankEval.instance) goto L17;
        return r7;
    L17:
        return NumberEval.ZERO;
    L9:
        if (r0.isPartOfArrayFormulaGroup() == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r6, AreaEval.class) == false) goto L13;
        r7 = OperandResolver.getElementFromArray((AreaEval) ZeusTransformUtils.preCheckCast(r6, AreaEval.class, "com.obric.memorydata.plugin"), r0);
        goto L15
    L19:
        throw new IllegalArgumentException("OperationEvaluationContext ec.getWorkbook() is null");
    L21:
        throw new IllegalArgumentException("OperationEvaluationContext ec is null");
    }

    private ValueEval evaluate(String r11, CellReference r12, CellRangeAddressBase r13, FormulaType r14) {
        if (r12 != null) goto L4;
        String r0 = null;
    L5:
        if (r0 == null) goto L9;
        int r5 = getWorkbook().getSheetIndex(r0);
        Ptg[] r15 = FormulaParser.parse(r11, (FormulaParsingWorkbook) ZeusTransformUtils.preCheckCast(getWorkbook(), FormulaParsingWorkbook.class, "com.obric.memorydata.plugin"), r14, r5, r12.getRow());
        adjustRegionRelativeReference(r15, r12, r13);
        return evaluateNameFormula(r15, new OperationEvaluationContext(this, getWorkbook(), r5, r12.getRow(), r12.getCol(), new EvaluationTracker(this._cache), r14.isSingleValue()));
    L9:
        throw new IllegalArgumentException("Sheet name is required");
    L4:
        r0 = r12.getSheetName();
        goto L5
    }

    private ValueEval evaluateAny(EvaluationCell r17, final int r18, final int r19, final int r20, EvaluationTracker r21) {
        EvaluationCell r13 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r17, EvaluationCell.class, "com.obric.memorydata.plugin");
        IStabilityClassifier r0 = this._stabilityClassifier;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r13 != null) goto L11;
    L68:
        ValueEval r9 = getValueFromNonFormulaCell(r13);
        if (r1 == false) goto L71;
        r21.acceptPlainValueDependency(this._workbook, this._workbookIx, r18, r19, r20, r9);
    L71:
        return r9;
    L11:
        if (r13.getCellType() != CellType.FORMULA) goto L68;
        FormulaCellCacheEntry r15 = this._cache.getOrCreateFormulaCellEntry(r13);
        if (r1 == false) goto L16;
    L17:
        r21.acceptFormulaDependency(r15);
    L18:
        IEvaluationListener r2 = this._evaluationListener;
        if (r15.getValue() != null) goto L64;
        if (r21.startEvaluate(r15) == false) goto L23;
        Ptg[] r7 = this._workbook.getFormulaTokens(r13);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
        OperationEvaluationContext r6 = new OperationEvaluationContext(this, this._workbook, r18, r19, r20, r21);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
        if (r2 != null) goto L27;
        ValueEval r3 = evaluateFormula(r6, r7);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
    L28:
        r21.updateCacheResult(r3);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
    L29:
        r21.endEvaluate(r15);
        final ValueEval r8 = r3;
        LOG.atDebug().a(new $$Lambda$WorkbookEvaluator$7sxq8qsHg9dMDLDaM7aps47aEIM(this, r18, r19, r20, r8));
        return r3;
    L27:
        r2.onStartEvaluate(r13, r15);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
        ValueEval r4 = evaluateFormula(r6, r7);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
        r2.onEndEvaluate(r15, r4);     // Catch: Throwable -> L30 RuntimeException -> L32 NotImplementedException -> L58
        r3 = r4;
    L58:
        e = move-exception;
        throw addExceptionInfo(e, r18, r19, r20);     // Catch: Throwable -> L30
    L32:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), CollaboratingWorkbooksEnvironment.WorkbookNotFoundException.class) == true) goto L36;
    L57:
        throw e;     // Catch: Throwable -> L30
    L36:
        if (this._ignoreMissingWorkbooks == false) goto L57;
        LOG.atInfo().a("{} - Continuing with cached value!", e.getCause().getMessage());     // Catch: Throwable -> L30
        int r5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r13.getCachedFormulaResultType().ordinal()];     // Catch: Throwable -> L30
        if (r5 != 1) goto L40;
        r3 = new NumberEval(r13.getNumericCellValue());     // Catch: Throwable -> L30
        goto L29
    L40:
        if (r5 != 2) goto L42;
        r3 = new StringEval(r13.getStringCellValue());     // Catch: Throwable -> L30
        goto L29
    L42:
        if (r5 != 3) goto L44;
        r3 = BlankEval.instance;     // Catch: Throwable -> L30
        goto L29
    L44:
        if (r5 != 4) goto L46;
        r3 = BoolEval.valueOf(r13.getBooleanCellValue());     // Catch: Throwable -> L30
        goto L29
    L46:
        if (r5 != 5) goto L49;
        r3 = ErrorEval.valueOf(r13.getErrorCellValue());     // Catch: Throwable -> L30
        goto L29
    L49:
        throw new RuntimeException("Unexpected cell type '" + r13.getCellType() + "' found!");     // Catch: Throwable -> L30
    L23:
        return ErrorEval.CIRCULAR_REF_ERROR;
    L30:
        th = move-exception;
        r21.endEvaluate(r15);
        throw th;
    L64:
        if (r2 == null) goto L67;
        r2.onCacheHit(r18, r19, r20, r15.getValue());
    L67:
        return r15.getValue();
    L16:
        if (r15.isInputSensitive() == false) goto L18;
    L5:
        if (r0.isCellFinal(r18, r19, r20) == false) goto L8;
        r1 = false;
        goto L9
    }

    private ValueEval getEvalForNameRecord(EvaluationName r3, OperationEvaluationContext r4) {
        EvaluationName r5 = (EvaluationName) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationName.class, "com.obric.memorydata.plugin");
        if (r5.isFunctionName() == false) goto L7;
        return new FunctionNameEval(r5.getNameText());
    L7:
        if (r5.hasFormula() == false) goto L11;
        return evaluateNameFormula(r5.getNameDefinition(), r4);
    L11:
        throw new RuntimeException("Don't know how to evaluate name '" + r5.getNameText() + "'");
    }

    private ValueEval getEvalForPtg(Ptg r7, OperationEvaluationContext r8) {
        if (ZeusTransformUtils.instanceOf(r7, NamePtg.class) == false) goto L7;
        return getEvalForNameRecord(this._workbook.getName((NamePtg) ZeusTransformUtils.preCheckCast(r7, NamePtg.class, "com.obric.memorydata.plugin")), r8);
    L7:
        if (ZeusTransformUtils.instanceOf(r7, NameXPtg.class) == false) goto L11;
        return processNameEval(r8.getNameXEval((NameXPtg) ZeusTransformUtils.preCheckCast(r7, NameXPtg.class, "com.obric.memorydata.plugin")), r8);
    L11:
        if (ZeusTransformUtils.instanceOf(r7, NameXPxg.class) == false) goto L15;
        return processNameEval(r8.getNameXEval((NameXPxg) ZeusTransformUtils.preCheckCast(r7, NameXPxg.class, "com.obric.memorydata.plugin")), r8);
    L15:
        if (ZeusTransformUtils.instanceOf(r7, IntPtg.class) == false) goto L19;
        return new NumberEval(((IntPtg) ZeusTransformUtils.preCheckCast(r7, IntPtg.class, "com.obric.memorydata.plugin")).getValue());
    L19:
        if (ZeusTransformUtils.instanceOf(r7, NumberPtg.class) == false) goto L23;
        return new NumberEval(((NumberPtg) ZeusTransformUtils.preCheckCast(r7, NumberPtg.class, "com.obric.memorydata.plugin")).getValue());
    L23:
        if (ZeusTransformUtils.instanceOf(r7, StringPtg.class) == false) goto L27;
        return new StringEval(((StringPtg) ZeusTransformUtils.preCheckCast(r7, StringPtg.class, "com.obric.memorydata.plugin")).getValue());
    L27:
        if (ZeusTransformUtils.instanceOf(r7, BoolPtg.class) == false) goto L31;
        return BoolEval.valueOf(((BoolPtg) ZeusTransformUtils.preCheckCast(r7, BoolPtg.class, "com.obric.memorydata.plugin")).getValue());
    L31:
        if (ZeusTransformUtils.instanceOf(r7, ErrPtg.class) == false) goto L35;
        return ErrorEval.valueOf(((ErrPtg) ZeusTransformUtils.preCheckCast(r7, ErrPtg.class, "com.obric.memorydata.plugin")).getErrorCode());
    L35:
        if (ZeusTransformUtils.instanceOf(r7, MissingArgPtg.class) == false) goto L39;
        return MissingArgEval.instance;
    L39:
        if (ZeusTransformUtils.instanceOf(r7, AreaErrPtg.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r7, RefErrorPtg.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r7, DeletedArea3DPtg.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r7, DeletedRef3DPtg.class) == true) goto L86;
        if (ZeusTransformUtils.instanceOf(r7, Ref3DPtg.class) == false) goto L52;
        return r8.getRef3DEval((Ref3DPtg) ZeusTransformUtils.preCheckCast(r7, Ref3DPtg.class, "com.obric.memorydata.plugin"));
    L52:
        if (ZeusTransformUtils.instanceOf(r7, Ref3DPxg.class) == false) goto L56;
        return r8.getRef3DEval((Ref3DPxg) ZeusTransformUtils.preCheckCast(r7, Ref3DPxg.class, "com.obric.memorydata.plugin"));
    L56:
        if (ZeusTransformUtils.instanceOf(r7, Area3DPtg.class) == false) goto L60;
        return r8.getArea3DEval((Area3DPtg) ZeusTransformUtils.preCheckCast(r7, Area3DPtg.class, "com.obric.memorydata.plugin"));
    L60:
        if (ZeusTransformUtils.instanceOf(r7, Area3DPxg.class) == false) goto L64;
        return r8.getArea3DEval((Area3DPxg) ZeusTransformUtils.preCheckCast(r7, Area3DPxg.class, "com.obric.memorydata.plugin"));
    L64:
        if (ZeusTransformUtils.instanceOf(r7, RefPtg.class) == false) goto L68;
        RefPtg r6 = (RefPtg) ZeusTransformUtils.preCheckCast(r7, RefPtg.class, "com.obric.memorydata.plugin");
        return r8.getRefEval(r6.getRow(), r6.getColumn());
    L68:
        if (ZeusTransformUtils.instanceOf(r7, AreaPtg.class) == false) goto L72;
        AreaPtg r9 = (AreaPtg) ZeusTransformUtils.preCheckCast(r7, AreaPtg.class, "com.obric.memorydata.plugin");
        return r8.getAreaEval(r9.getFirstRow(), r9.getFirstColumn(), r9.getLastRow(), r9.getLastColumn());
    L72:
        if (ZeusTransformUtils.instanceOf(r7, ArrayPtg.class) == false) goto L76;
        ArrayPtg r10 = (ArrayPtg) ZeusTransformUtils.preCheckCast(r7, ArrayPtg.class, "com.obric.memorydata.plugin");
        return r8.getAreaValueEval(0, 0, r10.getRowCount() - 1, r10.getColumnCount() - 1, r10.getTokenArrayValues());
    L76:
        if (ZeusTransformUtils.instanceOf(r7, UnknownPtg.class) == true) goto L84;
        if (ZeusTransformUtils.instanceOf(r7, ExpPtg.class) == false) goto L82;
        throw new RuntimeException("ExpPtg currently not supported");
    L82:
        throw new RuntimeException("Unexpected ptg class (" + r7.getClass().getName() + ")");
    L84:
        throw new RuntimeException("UnknownPtg not allowed");
    L86:
        return ErrorEval.REF_INVALID;
    }

    private int getSheetIndex(EvaluationSheet r4) {
        EvaluationSheet r5 = (EvaluationSheet) ZeusTransformUtils.wrapperContextForParams(r4, EvaluationSheet.class, "com.obric.memorydata.plugin");
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this._sheetIndexesBySheet.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        int r1 = this._workbook.getSheetIndex(r5);
        if (r1 < 0) goto L8;
        r0 = Integer.valueOf(r1);
        this._sheetIndexesBySheet.put(r5, r0);
        goto L10
    L8:
        throw new RuntimeException("Specified sheet from a different book");
    L10:
        return r0.intValue();
    }

    static ValueEval getValueFromNonFormulaCell(EvaluationCell r3) {
        EvaluationCell r4 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationCell.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        CellType r0 = r4.getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L23;
        if (r1 == 4) goto L21;
        if (r1 != 5) goto L19;
        return ErrorEval.valueOf(r4.getErrorCellValue());
    L19:
        throw new RuntimeException("Unexpected cell type (" + r0 + ")");
    L21:
        return BoolEval.valueOf(r4.getBooleanCellValue());
    L23:
        return BlankEval.instance;
    L25:
        return new StringEval(r4.getStringCellValue());
    L27:
        return new NumberEval(r4.getNumericCellValue());
    L5:
        return BlankEval.instance;
    }

    static /* synthetic */ Message lambda$evaluateFormula$1(String r2, OperationEvaluationContext r3, Ptg[] r4) {
        return new SimpleMessage(r2 + "- evaluateFormula('" + r3.getRefEvaluatorForCurrentSheet().getSheetNameRange() + "'/" + new CellReference(r3.getRowIndex(), r3.getColumnIndex()).formatAsString() + "): " + Arrays.toString(r4).replace("\\Qorg.apache.poi.ss.formula.ptg.\\E", ""));
    }

    private ValueEval processNameEval(ValueEval r3, OperationEvaluationContext r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ExternalNameEval.class) == true) goto L5;
        return r5;
    L5:
        return getEvalForNameRecord(((ExternalNameEval) ZeusTransformUtils.preCheckCast(r5, ExternalNameEval.class, "com.obric.memorydata.plugin")).getName(), r4);
    }

    public ValueEval evaluate(String r2, CellReference r3, CellRangeAddressBase r4) {
        return evaluate(r2, r3, r4, FormulaType.CELL);
    }

    public ValueEval evaluate(EvaluationCell r7) {
        EvaluationCell r1 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r7, EvaluationCell.class, "com.obric.memorydata.plugin");
        return evaluateAny(r1, getSheetIndex(r1.getSheet()), r1.getRowIndex(), r1.getColumnIndex(), new EvaluationTracker(this._cache));
    }

    ValueEval evaluateFormula(final OperationEvaluationContext r18, final Ptg[] r19) {
        if (this.dbgEvaluationOutputForNextEval == false) goto L5;
        this.dbgEvaluationOutputIndent = 1;
        this.dbgEvaluationOutputForNextEval = true;
    L5:
        int r0 = this.dbgEvaluationOutputIndent;
        if (r0 <= 0) goto L8;
        final String r1 = "                                                                                                    ".substring(0, Math.min(100, r0 * 2));
        this.EVAL_LOG.atWarn().a(new $$Lambda$WorkbookEvaluator$0wjCRJdAxpNzeoS1ZNOY6rVY(r1, r18, r19));
        this.dbgEvaluationOutputIndent++;
    L9:
        String r12 = r1;
        EvaluationCell r13 = r18.getWorkbook().getSheet(r18.getSheetIndex()).getCell(r18.getRowIndex(), r18.getColumnIndex());
        Stack r14 = new Stack();
        int r15 = r19.length;
        int r11 = 0;
    L11:
        if (r11 >= r15) goto L105;
        Ptg r2 = r19[r11];
        if (this.dbgEvaluationOutputIndent <= 0) goto L17;
        this.EVAL_LOG.atInfo().a("{}  * ptg {}: {}, stack: {}", r12, v.a(r11), r2, r14);
    L17:
        if (ZeusTransformUtils.instanceOf(r2, AttrPtg.class) == false) goto L61;
        AttrPtg r6 = (AttrPtg) ZeusTransformUtils.preCheckCast(r2, AttrPtg.class, r10);
        if (r6.isSum() == false) goto L22;
        r2 = FuncVarPtg.SUM;
    L22:
        if (r6.isOptimizedChoose() == false) goto L35;
        ValueEval r3 = (ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, "com.obric.memorydata.plugin");
        int[] r5 = r6.getJumpTable();
        int r7 = r5.length;
        int r4 = Choose.evaluateFirstArg(r3, r18.getRowIndex(), r18.getColumnIndex());     // Catch: EvaluationException -> L31
        if (r4 < 1) goto L29;
        if (r4 > r7) goto L29;
        int r8 = r5[r4 - 1];     // Catch: EvaluationException -> L31
    L34:
        int r9 = r8 - ((r7 * 2) + 2);
        int r10 = r11;
        int r16 = r10 + countTokensToBeSkipped(r19, r10, r9);
    L60:
        boolean r17 = false;
    L104:
        r11 = r16 + 1;
    L29:
        r14.push(ErrorEval.VALUE_INVALID);     // Catch: EvaluationException -> L31
        int r20 = r6.getChooseFuncOffset();     // Catch: EvaluationException -> L31
    L33:
        r8 = r20 + 4;
    L31:
        e = move-exception;
        r14.push(e.getErrorEval());
        r20 = r6.getChooseFuncOffset();
        goto L33
    L35:
        int r21 = r11;
        if (r6.isOptimizedIf() == false) goto L54;
        if (r13.isPartOfArrayFormulaGroup() == true) goto L102;
        ValueEval r22 = (ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, r10);
        if (IfFunc.evaluateFirstArg(r22, r18.getRowIndex(), r18.getColumnIndex()) == false) goto L43;
        r16 = r21;
        goto L60
    L43:
        r16 = r21 + countTokensToBeSkipped(r19, r21, r6.getData());
        Ptg r23 = r19[r16 + 1];
        if (ZeusTransformUtils.instanceOf(r19[r16], AttrPtg.class) == false) goto L60;
        if (ZeusTransformUtils.instanceOf(r23, FuncVarPtg.class) == false) goto L60;
        if (((FuncVarPtg) ZeusTransformUtils.preCheckCast(r23, FuncVarPtg.class, r10)).getFunctionIndex() != 1) goto L60;
        r14.push(r22);
        ValueEval r24 = BoolEval.FALSE;
    L50:
        r14.push(r24);
    L51:
        e = move-exception;
        r14.push(e.getErrorEval());
        int r110 = r21 + countTokensToBeSkipped(r19, r21, r6.getData());
        r16 = r110 + countTokensToBeSkipped(r19, r110, ((AttrPtg) ZeusTransformUtils.preCheckCast(r19[r110], AttrPtg.class, r10)).getData() + 1);
    L102:
        r17 = false;
    L103:
        r16 = r21;
        goto L104
    L54:
        if (r6.isSkip() == false) goto L63;
        if (r13.isPartOfArrayFormulaGroup() == true) goto L63;
        r16 = r21 + countTokensToBeSkipped(r19, r21, r6.getData() + 1);
        if (r14.peek() != MissingArgEval.instance) goto L60;
        r14.pop();
        r24 = BlankEval.instance;
    L63:
        if (ZeusTransformUtils.instanceOf(r2, ControlPtg.class) == true) goto L102;
        if (ZeusTransformUtils.instanceOf(r2, MemFuncPtg.class) == true) goto L102;
        if (ZeusTransformUtils.instanceOf(r2, MemAreaPtg.class) == true) goto L102;
        if (ZeusTransformUtils.instanceOf(r2, MemErrPtg.class) == true) goto L102;
        if (ZeusTransformUtils.instanceOf(r2, UnionPtg.class) == false) goto L77;
        r14.push(new RefListEval((ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, r10), (ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, r10)));
        goto L102
    L77:
        if (ZeusTransformUtils.instanceOf(r2, OperationPtg.class) == false) goto L95;
        OperationPtg r25 = (OperationPtg) ZeusTransformUtils.preCheckCast(r2, OperationPtg.class, r10);
        int r26 = r25.getNumberOfOperands();
        ValueEval[] r27 = new ValueEval[r26];
        int r28 = r26 - 1;
        boolean r29 = false;
    L79:
        if (r28 < 0) goto L84;
        ValueEval r111 = (ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, r10);
        r27[r28] = r111;
        if (ZeusTransformUtils.instanceOf(r111, AreaEval.class) == false) goto L83;
        r29 = true;
    L83:
        r28 = r28 - 1;
        goto L79
    L84:
        if (r29 == false) goto L93;
        int r112 = r21;
    L86:
        if (r112 >= r15) goto L93;
        if (ZeusTransformUtils.instanceOf(r19[r112], FuncVarPtg.class) == true) goto L119;
        r112 = r112 + 1;
        goto L86
    L119:
        boolean r30 = ZeusTransformUtils.instanceOf(FunctionEval.getBasicFunction(((FuncVarPtg) ZeusTransformUtils.preCheckCast(r19[r112], FuncVarPtg.class, r10)).getFunctionIndex()), ArrayMode.class);     // Catch: NotImplementedException -> L118
    L94:
        r18.setArrayMode(r30);
        ValueEval r31 = OperationEvaluatorFactory.evaluate(r25, r27, r18);
        r17 = false;
        r18.setArrayMode(false);
    L96:
        if (r31 == null) goto L101;
        r14.push(r31);
        if (this.dbgEvaluationOutputIndent <= 0) goto L103;
        this.EVAL_LOG.atInfo().a("{}    = {}", r12, r31);
        goto L103
    L101:
        throw new RuntimeException("Evaluation result must not be null");
    L93:
        r30 = false;
        goto L94
    L95:
        r17 = false;
        r31 = getEvalForPtg(r2, r18);
        goto L96
    L61:
        r21 = r11;
        goto L63
    L105:
        ValueEval r32 = (ValueEval) ZeusTransformUtils.preCheckCast(r14.pop(), ValueEval.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L117;
        if (r18.isSingleValue() == false) goto L111;
        r32 = dereferenceResult(r32, r18);
    L111:
        if (this.dbgEvaluationOutputIndent <= 0) goto L115;
        this.EVAL_LOG.atInfo().a("{}finished eval of {}: {}", r12, new CellReference(r18.getRowIndex(), r18.getColumnIndex()).formatAsString(), r32);
        int r33 = this.dbgEvaluationOutputIndent - 1;
        this.dbgEvaluationOutputIndent = r33;
        if (r33 != 1) goto L115;
        this.dbgEvaluationOutputIndent = -1;
    L115:
        return r32;
    L117:
        throw new IllegalStateException("evaluation stack not empty");
    L8:
        r1 = "";
        goto L9
    }

    public ValueEval evaluateList(String r2, CellReference r3, CellRangeAddressBase r4) {
        return evaluate(r2, r3, r4, FormulaType.DATAVALIDATION_LIST);
    }

    ValueEval evaluateNameFormula(Ptg[] r10, OperationEvaluationContext r11) {
        if (r10.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r10[0], FuncVarPtg.class) == true) goto L9;
        return getEvalForPtg(r10[0], r11);
    L9:
        return evaluateFormula(new OperationEvaluationContext(this, r11.getWorkbook(), r11.getSheetIndex(), r11.getRowIndex(), r11.getColumnIndex(), new EvaluationTracker(this._cache), false), r10);
    }

    ValueEval evaluateReference(EvaluationSheet r7, int r8, int r9, int r10, EvaluationTracker r11) {
        return evaluateAny(((EvaluationSheet) ZeusTransformUtils.wrapperContextForParams(r7, EvaluationSheet.class, "com.obric.memorydata.plugin")).getCell(r9, r10), r8, r9, r10, r11);
    }

    public FreeRefFunction findUserDefinedFunction(String r1) {
        return this._udfFinder.findFunction(r1);
    }

    EvaluationName getName(String r1, int r2) {
        return this._workbook.getName(r1, r2);
    }

    WorkbookEvaluator getOtherWorkbookEvaluator(String r1) {
        return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(r1);
    }

    EvaluationSheet getSheet(int r1) {
        return this._workbook.getSheet(r1);
    }

    int getSheetIndex(String r4) {
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this._sheetIndexesByName.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        int r1 = this._workbook.getSheetIndex(r4);
        if (r1 >= 0) goto L8;
        return -1;
    L8:
        r0 = Integer.valueOf(r1);
        this._sheetIndexesByName.put(r4, r0);
    L10:
        return r0.intValue();
    }

    String getSheetName(int r1) {
        return this._workbook.getSheetName(r1);
    }

    EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    public /* synthetic */ Message lambda$evaluateAny$0$WorkbookEvaluator(int r3, int r4, int r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        return new SimpleMessage("Evaluated " + getSheetName(r3) + "!" + new CellReference(r4, r5).formatAsString() + " to " + r7);
    }
}
