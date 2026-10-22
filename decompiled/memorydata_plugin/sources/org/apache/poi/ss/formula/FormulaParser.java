package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FormulaParser {
    private static final Pattern CELL_REF_PATTERN = null;
    private static final c LOGGER = null;
    private final FormulaParsingWorkbook _book;
    private final int _formulaLength;
    private final String _formulaString;
    private boolean _inIntersection;
    private int _pointer;
    private ParseNode _rootNode;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final SpreadsheetVersion _ssVersion;
    private int look;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.FormulaParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$SpreadsheetVersion = null;

        static {
            int[] r0 = new int[SpreadsheetVersion.values().length];
            $SwitchMap$org$apache$poi$ss$SpreadsheetVersion = r0;
            r0[SpreadsheetVersion.EXCEL97.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$poi$ss$SpreadsheetVersion[SpreadsheetVersion.EXCEL2007.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final class SimpleRangePart {
        private final String _rep;
        private final Type _type;

        private static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type CELL = null;
            public static final Type COLUMN = null;
            public static final Type ROW = null;

            static {
                Type r0 = new Type("CELL", 0);
                CELL = r0;
                Type r1 = new Type("ROW", 1);
                ROW = r1;
                Type r3 = new Type("COLUMN", 2);
                COLUMN = r3;
                $VALUES = new Type[]{r0, r1, r3};
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            public static Type get(boolean r0, boolean r1) {
                if (r0 == false) goto L7;
                if (r1 == false) goto L6;
                return CELL;
            L6:
                return COLUMN;
            L7:
                if (r1 == false) goto L11;
                return ROW;
            L11:
                throw new IllegalArgumentException("must have either letters or numbers");
            }

            public static Type valueOf(String r2) {
                return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
            }

            public static Type[] values() {
                return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
            }
        }

        public SimpleRangePart(String r1, boolean r2, boolean r3) {
            this._rep = r1;
            this._type = Type.get(r2, r3);
        }

        public CellReference getCellReference() {
            if (this._type != Type.CELL) goto L7;
            return new CellReference(this._rep);
        L7:
            throw new IllegalStateException("Not applicable to this reference-type, expected CELL, but had " + this._type);
        }

        public String getRep() {
            return this._rep;
        }

        public boolean isCell() {
            if (this._type != Type.CELL) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isColumn() {
            if (this._type != Type.COLUMN) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isCompatibleForArea(SimpleRangePart r1) {
            if (this._type != r1._type) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRow() {
            if (this._type != Type.ROW) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRowOrColumn() {
            if (this._type == Type.CELL) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return getClass().getName() + " [" + this._rep + "]";
        }
    }

    static {
        LOGGER = b.a(FormulaParser.class);
        CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");
    }

    private FormulaParser(String r3, FormulaParsingWorkbook r4, int r5, int r6) {
        FormulaParsingWorkbook r7 = (FormulaParsingWorkbook) ZeusTransformUtils.wrapperContextForParams(r4, FormulaParsingWorkbook.class, "com.obric.memorydata.plugin");
        this._formulaString = r3;
        this._pointer = 0;
        this._book = r7;
        if (r7 != null) goto L5;
        SpreadsheetVersion r8 = SpreadsheetVersion.EXCEL97;
    L6:
        this._ssVersion = r8;
        this._formulaLength = r3.length();
        this._sheetIndex = r5;
        this._rowIndex = r6;
        return;
    L5:
        r8 = r7.getSpreadsheetVersion();
        goto L6
    }

    private ParseNode[] Arguments() {
        ArrayList r0 = new ArrayList(2);
        SkipWhite();
        if (this.look != 41) goto L7;
        return ParseNode.EMPTY_ARRAY;
    L7:
        boolean r3 = true;
    L8:
        SkipWhite();
        if (isArgumentDelimiter(this.look) == true) goto L10;
        r0.add(intersectionExpression());
        r3 = false;
        SkipWhite();
        if (isArgumentDelimiter(this.look) == true) goto L8;
        throw expected("',' or ')'");
    L10:
        if (r3 == false) goto L13;
        r0.add(new ParseNode(MissingArgPtg.instance));
    L13:
        if (this.look == 41) goto L14;
        Match(44);
        goto L7
    L14:
        ParseNode[] r5 = new ParseNode[r0.size()];
        r0.toArray(r5);
        return r5;
    }

    private void GetChar() {
        if (IsWhite(this.look) == true) goto L5;
        this._inIntersection = false;
    L8:
        int r0 = this._pointer;
        int r2 = this._formulaLength;
        if (r0 > r2) goto L16;
        if (r0 >= r2) goto L12;
        this.look = this._formulaString.codePointAt(r0);
    L13:
        this._pointer += Character.charCount(this.look);
        return;
    L12:
        this.look = 0;
        this._inIntersection = false;
        goto L13
    L16:
        throw new RuntimeException("Parsed past the end of the formula, pos: " + this._pointer + ", length: " + this._formulaLength + ", formula: " + this._formulaString);
    L5:
        if (this.look != 32) goto L8;
        this._inIntersection = true;
        goto L8
    }

    private String GetNum() {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (IsDigit(this.look) == false) goto L7;
        r0.appendCodePoint(this.look);
        GetChar();
        goto L4
    L7:
        if (r0.length() != 0) goto L10;
        return null;
    L10:
        return r0.toString();
    }

    private static boolean IsAlpha(int r1) {
        if (Character.isLetter(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 36) goto L10;
        if (r1 == 95) goto L10;
        return false;
    }

    private static boolean IsDigit(int r0) {
        return Character.isDigit(r0);
    }

    private static boolean IsWhite(int r1) {
        if (r1 != 32) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 9) goto L12;
        if (r1 == 13) goto L12;
        if (r1 == 10) goto L12;
        return false;
    }

    private void Match(int r3) {
        if (this.look != r3) goto L7;
        GetChar();
        return;
    L7:
        throw expected(new StringBuilder().append("'").appendCodePoint(r3).append("'").toString());
    }

    private void SkipWhite() {
    L3:
        if (IsWhite(this.look) == false) goto L5;
        GetChar();
        goto L3
    }

    private ParseNode Term() {
        ParseNode r0 = powerFactor();
    L3:
        SkipWhite();
        int r1 = this.look;
        if (r1 != 42) goto L6;
        Match(42);
        Ptg r2 = MultiplyPtg.instance;
    L10:
        r0 = new ParseNode(r2, r0, powerFactor());
        goto L3
    L6:
        if (r1 != 47) goto L7;
        Match(47);
        r2 = DividePtg.instance;
        goto L10
    L7:
        return r0;
    }

    private void addName(String r3) {
        Name r0 = this._book.createName();
        r0.setFunction(true);
        r0.setNameName(r3);
        r0.setSheetIndex(this._sheetIndex);
    }

    private ParseNode additiveExpression() {
        ParseNode r0 = Term();
    L3:
        SkipWhite();
        int r1 = this.look;
        if (r1 != 43) goto L6;
        Match(43);
        Ptg r2 = AddPtg.instance;
    L10:
        r0 = new ParseNode(r2, r0, Term());
        goto L3
    L6:
        if (r1 != 45) goto L7;
        Match(45);
        r2 = SubtractPtg.instance;
        goto L10
    L7:
        return r0;
    }

    private static ParseNode augmentWithMemPtg(ParseNode r2) {
        if (needsMemFunc(r2) == false) goto L5;
        Ptg r0 = new MemFuncPtg(r2.getEncodedSize());
    L7:
        return new ParseNode(r0, r2);
    L5:
        r0 = new MemAreaPtg(r2.getEncodedSize());
        goto L7
    }

    private void checkRowLengths(Object[][] r4, int r5) {
        int r3 = 0;
    L4:
        if (r3 >= r4.length) goto L10;
        int r0 = r4[r3].length;
        if (r0 != r5) goto L9;
        r3 = r3 + 1;
        goto L4
    L9:
        throw new FormulaParseException("Array row " + r3 + " has length " + r0 + " but row 0 has length " + r5);
    }

    private static void checkValidRangeOperand(String r2, int r3, ParseNode r4) {
        if (isValidRangeOperand(r4) == false) goto L6;
        return;
    L6:
        throw new FormulaParseException("The " + r2 + " of the range operator ':' at position " + r3 + " is not a proper reference.");
    }

    private ParseNode comparisonExpression() {
        ParseNode r0 = concatExpression();
    L3:
        SkipWhite();
        switch(this.look) {
            case 60: goto L6;
            case 61: goto L6;
            case 62: goto L6;
            default: goto L5;
        };
    L6:
        r0 = new ParseNode(getComparisonToken(), r0, concatExpression());
        goto L3
    L5:
        return r0;
    }

    private ParseNode concatExpression() {
        ParseNode r0 = additiveExpression();
    L3:
        SkipWhite();
        if (this.look != 38) goto L5;
        Match(38);
        ParseNode r1 = additiveExpression();
        r0 = new ParseNode(ConcatPtg.instance, r0, r1);
        goto L3
    L5:
        return r0;
    }

    private static Double convertArrayNumber(Ptg r2, boolean r3) {
        if (ZeusTransformUtils.instanceOf(r2, IntPtg.class) == false) goto L6;
        double r0 = ((IntPtg) ZeusTransformUtils.preCheckCast(r2, IntPtg.class, "com.obric.memorydata.plugin")).getValue();
    L8:
        if (r3 == true) goto L11;
        r0 = -r0;
    L11:
        return Double.valueOf(r0);
    L6:
        if (ZeusTransformUtils.instanceOf(r2, NumberPtg.class) == false) goto L13;
        r0 = ((NumberPtg) ZeusTransformUtils.preCheckCast(r2, NumberPtg.class, "com.obric.memorydata.plugin")).getValue();
        goto L8
    L13:
        throw new RuntimeException("Unexpected ptg (" + r2.getClass().getName() + ")");
    }

    private AreaReference createAreaRef(SimpleRangePart r3, SimpleRangePart r4) {
        if (r3.isCompatibleForArea(r4) == false) goto L15;
        if (r3.isRow() == false) goto L9;
        return AreaReference.getWholeRow(this._ssVersion, r3.getRep(), r4.getRep());
    L9:
        if (r3.isColumn() == false) goto L13;
        return AreaReference.getWholeColumn(this._ssVersion, r3.getRep(), r4.getRep());
    L13:
        return new AreaReference(r3.getCellReference(), r4.getCellReference(), this._ssVersion);
    L15:
        throw new FormulaParseException("has incompatible parts: '" + r3.getRep() + "' and '" + r4.getRep() + "'.");
    }

    private ParseNode createAreaRefParseNode(SheetIdentifier r1, SimpleRangePart r2, SimpleRangePart r3) {
        if (r3 != null) goto L7;
        CellReference r4 = r2.getCellReference();
        if (r1 != null) goto L6;
        Ptg r0 = new RefPtg(r4);
    L12:
        return new ParseNode(r0);
    L6:
        r0 = this._book.get3DReferencePtg(r4, r1);
        goto L12
    L7:
        AreaReference r5 = createAreaRef(r2, r3);
        if (r1 != null) goto L10;
        r0 = new AreaPtg(r5);
        goto L12
    L10:
        r0 = this._book.get3DReferencePtg(r5, r1);
        goto L12
    }

    private RuntimeException expected(String r4) {
        if (this.look == 61) goto L5;
    L7:
        StringBuilder r3 = new StringBuilder("Parse error near char ").append(this._pointer - 1).append(" '").appendCodePoint(this.look).append("'").append(" in specified formula '").append(this._formulaString).append("'. Expected ");
    L9:
        return new FormulaParseException(r3.append(r4).toString());
    L5:
        if (StringUtil.isBlank(this._formulaString.substring(0, this._pointer - 1)) == false) goto L7;
        r3 = new StringBuilder().append("The specified formula '").append(this._formulaString);
        r4 = "' starts with an equals sign which is not allowed.";
        goto L9
    }

    private ParseNode function(String r4) {
        Ptg r1 = null;
        if (AbstractFunctionPtg.isBuiltInFunctionName(r4) == true) goto L25;
        FormulaParsingWorkbook r0 = this._book;
        if (r0 == null) goto L24;
        EvaluationName r2 = r0.getName(r4, this._sheetIndex);
        if (r2 != null) goto L9;
        r1 = this._book.getNameXPtg(r4, null);
        if (r1 != null) goto L25;
        LOGGER.atWarn().a("FormulaParser.function: Name '{}' is completely unknown in the current workbook.", r4);
        int r3 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$SpreadsheetVersion[this._book.getSpreadsheetVersion().ordinal()];
        if (r3 != 1) goto L18;
        addName(r4);
        r2 = this._book.getName(r4, this._sheetIndex);
    L10:
        r1 = r2.createPtg();
        goto L25
    L18:
        if (r3 != 2) goto L21;
        r1 = new NameXPxg(r4);
        goto L25
    L21:
        throw new IllegalStateException("Unexpected spreadsheet version: " + this._book.getSpreadsheetVersion().name());
    L9:
        if (r2.isFunctionName() == true) goto L10;
        throw new FormulaParseException("Attempt to use name '" + r4 + "' as a function, but defined name in workbook does not refer to a function");
    L24:
        throw new IllegalStateException("Need book to evaluate name '" + r4 + "'");
    L25:
        Match(40);
        ParseNode[] r5 = Arguments();
        Match(41);
        return getFunction(r4, r1, r5);
    }

    private String getBookName() {
        StringBuilder r0 = new StringBuilder();
    L3:
        GetChar();
        int r1 = this.look;
        if (r1 == 93) goto L6;
        r0.appendCodePoint(r1);
        goto L3
    L6:
        GetChar();
        return r0.toString();
    }

    private Ptg getComparisonToken() {
        int r0 = this.look;
        if (r0 != 61) goto L7;
        Match(r0);
        return EqualPtg.instance;
    L7:
        if (r0 != 62) goto L9;
        boolean r3 = true;
    L10:
        Match(r0);
        int r1 = this.look;
        if (r3 == false) goto L17;
        if (r1 != 61) goto L16;
        Match(61);
        return GreaterEqualPtg.instance;
    L16:
        return GreaterThanPtg.instance;
    L17:
        if (r1 == 61) goto L23;
        if (r1 != 62) goto L20;
        Match(62);
        return NotEqualPtg.instance;
    L20:
        return LessThanPtg.instance;
    L23:
        Match(61);
        return LessEqualPtg.instance;
    L9:
        r3 = false;
        goto L10
    }

    private ParseNode getFunction(String r6, Ptg r7, ParseNode[] r8) {
        FunctionMetadata r0 = FunctionMetadataRegistry.getFunctionByName(r6.toUpperCase(Locale.ROOT));
        int r1 = r8.length;
        if (r0 != null) goto L9;
        if (r7 == null) goto L8;
        int r5 = r1 + 1;
        ParseNode[] r2 = new ParseNode[r5];
        r2[0] = new ParseNode(r7);
        System.arraycopy(r8, 0, r2, 1, r1);
        return new ParseNode(FuncVarPtg.create(r6, r5), r2);
    L8:
        throw new IllegalStateException("NamePtg must be supplied for external functions");
    L9:
        if (r7 != null) goto L23;
        boolean r9 = !r0.hasFixedArgsLength();
        int r3 = r0.getIndex();
        if (r3 == 4) goto L13;
    L16:
        validateNumArgs(r8.length, r0);
        if (r9 == false) goto L19;
        Ptg r10 = FuncVarPtg.create(r6, r1);
    L21:
        return new ParseNode(r10, r8);
    L19:
        r10 = FuncPtg.create(r3);
        goto L21
    L13:
        if (r8.length != 1) goto L16;
        return new ParseNode(AttrPtg.getSumSingle(), r8);
    L23:
        throw new IllegalStateException("NamePtg no applicable to internal functions");
    }

    private static Ptg getNumberPtgFromString(String r2, String r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        if (r3 != null) goto L17;
        r0.append(r2);
        if (r4 == null) goto L7;
        r0.append('E');
        r0.append(r4);
    L7:
        String r5 = r0.toString();
        int r6 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L15
        if (IntPtg.isInRange(r6) == false) goto L14;
        return new IntPtg(r6);
    L14:
        return new NumberPtg(r5);
    L16:
        return new NumberPtg(r5);
    L17:
        if (r2 == null) goto L19;
        r0.append(r2);
    L19:
        r0.append('.');
        r0.append(r3);
        if (r4 == null) goto L23;
        r0.append('E');
        r0.append(r4);
    L23:
        return new NumberPtg(r0.toString());
    }

    private Ptg[] getRPNPtg(FormulaType r2) {
        new OperandClassTransformer(r2).transformFormula(this._rootNode);
        return ParseNode.toTokenArray(this._rootNode);
    }

    private ParseNode intersectionExpression() {
        ParseNode r0 = comparisonExpression();
        boolean r1 = false;
    L3:
        SkipWhite();
        if (this._inIntersection == false) goto L9;
        int r2 = this._pointer;
        ParseNode r3 = comparisonExpression();     // Catch: FormulaParseException -> L8
        r1 = true;
        r0 = new ParseNode(IntersectionPtg.instance, r0, r3);     // Catch: FormulaParseException -> L8
    L8:
        resetPointer(r2);
    L9:
        if (r1 == true) goto L11;
        return r0;
    L11:
        return augmentWithMemPtg(r0);
    }

    private static boolean isArgumentDelimiter(int r1) {
        if (r1 != 44) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 41) goto L8;
        return false;
    }

    private static boolean isUnquotedSheetNameChar(int r2) {
        if (Character.isLetterOrDigit(r2) == false) goto L6;
        return true;
    L6:
        if (r2 <= 128) goto L9;
        return true;
    L9:
        if (r2 != 32) goto L11;
    L16:
        return true;
    L11:
        if (r2 == 46) goto L16;
        if (r2 == 95) goto L16;
        return false;
    }

    private boolean isValidCellReference(String r5) {
        boolean r2 = true;
        if (CellReference.classifyCellReference(r5, this._ssVersion) != CellReference.NameType.CELL) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r0;
    L8:
        if (FunctionMetadataRegistry.getFunctionByName(r5.toUpperCase(Locale.ROOT)) == null) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L19;
        int r3 = this._pointer;
        resetPointer(r5.length() + r3);
        SkipWhite();
        if (this.look != 40) goto L16;
        r2 = false;
    L16:
        resetPointer(r3);
        return r2;
    L19:
        return r0;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private static boolean isValidDefinedNameChar(int r2) {
        if (Character.isLetterOrDigit(r2) == false) goto L6;
        return true;
    L6:
        if (r2 <= 128) goto L9;
        return true;
    L9:
        if (r2 != 46) goto L11;
    L18:
        return true;
    L11:
        if (r2 == 63) goto L18;
        if (r2 == 92) goto L18;
        if (r2 == 95) goto L18;
        return false;
    }

    private static boolean isValidRangeOperand(ParseNode r4) {
        Ptg r0 = r4.getToken();
        if (ZeusTransformUtils.instanceOf(r0, OperandPtg.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, AbstractFunctionPtg.class) == false) goto L15;
        byte r5 = ((AbstractFunctionPtg) ZeusTransformUtils.preCheckCast(r0, AbstractFunctionPtg.class, "com.obric.memorydata.plugin")).getDefaultOperandClass();
        if (r5 != 0) goto L10;
        return true;
    L10:
        if (32 != r5) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r0, ValueOperatorPtg.class) == false) goto L18;
        return false;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, OperationPtg.class) == false) goto L21;
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r0, ParenthesisPtg.class) == false) goto L25;
        return isValidRangeOperand(r4.getChildren()[0]);
    L25:
        if (r0 != ErrPtg.REF_INVALID) goto L28;
        return true;
    L28:
        return false;
    }

    private static boolean needsMemFunc(ParseNode r5) {
        Ptg r0 = r5.getToken();
        if (ZeusTransformUtils.instanceOf(r0, AbstractFunctionPtg.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ExternSheetReferenceToken.class) == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, NamePtg.class) == false) goto L11;
    L26:
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, NameXPtg.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r0, OperationPtg.class) == false) goto L16;
    L19:
        ParseNode[] r6 = r5.getChildren();
        int r1 = r6.length;
        int r2 = 0;
    L20:
        if (r2 >= r1) goto L25;
        if (needsMemFunc(r6[r2]) == true) goto L23;
        r2 = r2 + 1;
        goto L20
    L23:
        return true;
    L25:
        return false;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, ParenthesisPtg.class) == true) goto L19;
        return false;
    }

    private void parse() {
        this._pointer = 0;
        GetChar();
        this._rootNode = unionExpression();
        if (this._pointer <= this._formulaLength) goto L6;
        return;
    L6:
        throw new FormulaParseException("Unused input [" + this._formulaString.substring(this._pointer - 1) + "] after attempting to parse the formula [" + this._formulaString + "]");
    }

    public static Ptg[] parse(String r2, FormulaParsingWorkbook r3, FormulaType r4, int r5) {
        return parse(r2, (FormulaParsingWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, FormulaParsingWorkbook.class, "com.obric.memorydata.plugin"), r4, r5, -1);
    }

    public static Ptg[] parse(String r2, FormulaParsingWorkbook r3, FormulaType r4, int r5, int r6) {
        FormulaParser r0 = new FormulaParser(r2, (FormulaParsingWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, FormulaParsingWorkbook.class, "com.obric.memorydata.plugin"), r5, r6);
        r0.parse();
        return r0.getRPNPtg(r4);
    }

    private ParseNode parseArray() {
        ArrayList r0 = new ArrayList();
    L3:
        r0.add(parseArrayRow());
        int r1 = this.look;
        if (r1 == 125) goto L5;
        if (r1 != 59) goto L11;
        Match(59);
        goto L3
    L11:
        throw expected("'}' or ';'");
    L5:
        Object[][] r2 = new Object[r0.size()][];
        r0.toArray(r2);
        checkRowLengths(r2, r2[0].length);
        return new ParseNode(new ArrayPtg(r2));
    }

    private Object parseArrayItem() {
        SkipWhite();
        int r0 = this.look;
        if (r0 == 34) goto L25;
        if (r0 == 35) goto L23;
        if (r0 != 45) goto L9;
        Match(45);
        SkipWhite();
        return convertArrayNumber(parseNumber(), false);
    L9:
        if (r0 == 70) goto L19;
        if (r0 == 84) goto L19;
        if (r0 == 102) goto L19;
        if (r0 == 116) goto L19;
        return convertArrayNumber(parseNumber(), true);
    L19:
        return parseBooleanLiteral();
    L23:
        return ErrorConstant.valueOf(parseErrorLiteral());
    L25:
        return parseStringLiteral();
    }

    private Object[] parseArrayRow() {
        ArrayList r0 = new ArrayList();
    L3:
        r0.add(parseArrayItem());
        SkipWhite();
        int r1 = this.look;
        if (r1 != 44) goto L6;
        Match(44);
        goto L3
    L6:
        if (r1 != 59) goto L8;
    L12:
        Object[] r3 = new Object[r0.size()];
        r0.toArray(r3);
        return r3;
    L8:
        if (r1 == 125) goto L12;
        throw expected("'}' or ','");
    }

    private String parseAsColumnQuantifier() {
        if (this.look == 91) goto L5;
        return null;
    L5:
        GetChar();
        int r0 = this.look;
        if (r0 != 35) goto L9;
        return null;
    L9:
        if (r0 != 64) goto L11;
        GetChar();
    L11:
        StringBuilder r1 = new StringBuilder();
    L12:
        int r2 = this.look;
        if (r2 == 93) goto L15;
        r1.appendCodePoint(r2);
        GetChar();
        goto L12
    L15:
        Match(93);
        return r1.toString();
    }

    private String parseAsName() {
        StringBuilder r0 = new StringBuilder();
        if (Character.isLetter(this.look) == true) goto L12;
        int r1 = this.look;
        if (r1 == 95) goto L12;
        if (r1 == 92) goto L12;
        throw expected("number, string, defined name, or data table");
    L12:
        if (isValidDefinedNameChar(this.look) == false) goto L14;
        r0.appendCodePoint(this.look);
        GetChar();
        goto L12
    L14:
        SkipWhite();
        return r0.toString();
    }

    private String parseAsSpecialQuantifier() {
        if (this.look == 91) goto L5;
        return null;
    L5:
        GetChar();
        if (this.look == 35) goto L8;
        return null;
    L8:
        GetChar();
        String r0 = parseAsName();
        if (r0.equals("This") == false) goto L11;
        r0 = r0 + ' ' + parseAsName();
    L11:
        Match(93);
        return r0;
    }

    private Boolean parseBooleanLiteral() {
        String r0 = parseUnquotedIdentifier();
        if ("TRUE".equalsIgnoreCase(r0) == false) goto L7;
        return Boolean.TRUE;
    L7:
        if ("FALSE".equalsIgnoreCase(r0) == false) goto L11;
        return Boolean.FALSE;
    L11:
        throw expected("'TRUE' or 'FALSE'");
    }

    private int parseErrorLiteral() {
        Match(35);
        String r0 = parseUnquotedIdentifier();
        if (r0 == null) goto L53;
        String r1 = r0.toUpperCase(Locale.ROOT);
        char r2 = r1.charAt(0);
        if (r2 != 'D') goto L7;
        FormulaError r3 = FormulaError.DIV0;
        if (r1.equals("DIV") == false) goto L51;
        Match(47);
        Match(48);
    L14:
        Match(33);
    L16:
        return r3.getCode();
    L51:
        throw expected(r3.getString());
    L7:
        if (r2 != 'N') goto L9;
        r3 = FormulaError.NAME;
        if (r1.equals(r3.name()) == false) goto L30;
        int r4 = 63;
    L29:
        Match(r4);
        goto L16
    L30:
        r3 = FormulaError.NUM;
        if (r1.equals(r3.name()) == true) goto L14;
        r3 = FormulaError.NULL;
        if (r1.equals(r3.name()) == true) goto L14;
        r3 = FormulaError.NA;
        if (r1.equals("N") == false) goto L46;
        Match(47);
        r4 = this.look;
        if (r4 == 65) goto L29;
        if (r4 == 97) goto L29;
        throw expected(r3.getString());
    L46:
        throw expected("#NAME?, #NUM!, #NULL! or #N/A");
    L9:
        if (r2 != 'R') goto L11;
        r3 = FormulaError.REF;
        if (r1.equals(r3.name()) == true) goto L14;
        throw expected(r3.getString());
    L11:
        if (r2 != 'V') goto L20;
        r3 = FormulaError.VALUE;
        if (r1.equals(r3.name()) == true) goto L14;
        throw expected(r3.getString());
    L20:
        throw expected("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
    L53:
        throw expected("remainder of error constant literal");
    }

    private ParseNode parseNonRange(int r3) {
        resetPointer(r3);
        if (Character.isDigit(this.look) == false) goto L7;
        return new ParseNode(parseNumber());
    L7:
        if (this.look == 34) goto L9;
        String r4 = parseAsName();
        int r0 = this.look;
        if (r0 != 40) goto L15;
        return function(r4);
    L15:
        if (r0 != 91) goto L19;
        return parseStructuredReference(r4);
    L19:
        if (r4.equalsIgnoreCase("TRUE") == true) goto L38;
        if (r4.equalsIgnoreCase("FALSE") == true) goto L38;
        FormulaParsingWorkbook r1 = this._book;
        if (r1 == null) goto L36;
        EvaluationName r2 = r1.getName(r4, this._sheetIndex);
        if (r2 == null) goto L34;
        if (r2.isRange() == false) goto L32;
        return new ParseNode(r2.createPtg());
    L32:
        throw new FormulaParseException("Specified name '" + r4 + "' is not a range as expected.");
    L34:
        throw new FormulaParseException("Specified named range '" + r4 + "' does not exist in the current workbook.");
    L36:
        throw new IllegalStateException("Need book to evaluate name '" + r4 + "'");
    L38:
        return new ParseNode(BoolPtg.valueOf(r4.equalsIgnoreCase("TRUE")));
    L9:
        return new ParseNode(new StringPtg(parseStringLiteral()));
    }

    private Ptg parseNumber() {
        String r0 = GetNum();
        String r2 = null;
        if (this.look != 46) goto L5;
        GetChar();
        String r1 = GetNum();
    L7:
        if (this.look != 69) goto L20;
        GetChar();
        int r3 = this.look;
        if (r3 != 43) goto L12;
        GetChar();
    L14:
        String r4 = "";
    L15:
        String r5 = GetNum();
        if (r5 == null) goto L19;
        r2 = r4 + r5;
        goto L20
    L19:
        throw expected("Integer");
    L12:
        if (r3 != 45) goto L14;
        GetChar();
        r4 = "-";
    L20:
        if (r0 != null) goto L26;
        if (r1 != null) goto L26;
        throw expected("Integer");
    L26:
        return getNumberPtgFromString(r0, r1, r2);
    L5:
        r1 = null;
        goto L7
    }

    private ParseNode parseRangeExpression() {
        ParseNode r0 = parseRangeable();
        boolean r3 = false;
    L4:
        if (this.look != 58) goto L6;
        int r4 = this._pointer;
        GetChar();
        ParseNode r5 = parseRangeable();
        checkValidRangeOperand("LHS", r4, r0);
        checkValidRangeOperand("RHS", r4, r5);
        r0 = new ParseNode(RangePtg.instance, new ParseNode[]{r0, r5});
        r3 = true;
        goto L4
    L6:
        if (r3 == true) goto L8;
        return r0;
    L8:
        return augmentWithMemPtg(r0);
    }

    private ParseNode parseRangeable() {
        SkipWhite();
        int r0 = this._pointer;
        SheetIdentifier r1 = parseSheetName(false);
        if (r1 != null) goto L5;
        resetPointer(r0);
    L6:
        SimpleRangePart r2 = parseSimpleRangePart();
        if (r2 != null) goto L25;
        if (r1 == null) goto L24;
        if (this.look == 35) goto L12;
        String r3 = parseAsName();
        if (r3.length() == 0) goto L22;
        Ptg r12 = this._book.getNameXPtg(r3, r1);
        if (r12 == null) goto L20;
        return new ParseNode(r12);
    L20:
        throw new FormulaParseException("Specified name '" + r3 + "' for sheet " + r1.asFormulaString() + " not found");
    L22:
        throw new FormulaParseException("Cell reference or Named Range expected after sheet name at index " + this._pointer + ".");
    L12:
        return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
    L24:
        return parseNonRange(r0);
    L25:
        boolean r4 = IsWhite(this.look);
        if (r4 == false) goto L28;
        SkipWhite();
    L28:
        int r5 = this.look;
        SimpleRangePart r7 = null;
        if (r5 != 58) goto L47;
        int r6 = this._pointer;
        GetChar();
        SkipWhite();
        SimpleRangePart r8 = parseSimpleRangePart();
        if (r8 != null) goto L33;
    L35:
        r7 = r8;
    L36:
        if (r7 != null) goto L45;
        resetPointer(r6);
        if (r2.isCell() == true) goto L45;
        if (r1 == null) goto L41;
        String r13 = "'" + r1.getSheetIdentifier().getName() + '!';
    L43:
        throw new FormulaParseException(r13 + r2.getRep() + "' is not a proper reference.");
    L41:
        r13 = "";
    L45:
        return createAreaRefParseNode(r1, r2, r7);
    L33:
        if (r2.isCompatibleForArea(r8) == true) goto L35;
    L47:
        if (r5 != 46) goto L89;
        GetChar();
        int r9 = 1;
    L49:
        int r10 = this.look;
        if (r10 != 46) goto L52;
        r9 = r9 + 1;
        GetChar();
        goto L49
    L52:
        boolean r11 = IsWhite(r10);
        SkipWhite();
        SimpleRangePart r14 = parseSimpleRangePart();
        String r15 = this._formulaString.substring(r0 - 1, this._pointer - 1);
        if (r14 != null) goto L60;
        if (r1 != null) goto L58;
        return parseNonRange(r0);
    L58:
        throw new FormulaParseException("Complete area reference expected after sheet name at index " + this._pointer + ".");
    L60:
        if (r4 == true) goto L81;
        if (r11 == true) goto L81;
        if (r9 != 1) goto L71;
        if (r2.isRow() == false) goto L71;
        if (r14.isRow() == false) goto L71;
        return parseNonRange(r0);
    L71:
        if (r2.isRowOrColumn() == true) goto L75;
        if (r14.isRowOrColumn() == true) goto L75;
    L77:
        return createAreaRefParseNode(r1, r2, r14);
    L75:
        if (r9 == 2) goto L77;
        throw new FormulaParseException("Dotted range (full row or column) expression '" + r15 + "' must have exactly 2 dots.");
    L81:
        if (r2.isRowOrColumn() == true) goto L87;
        if (r14.isRowOrColumn() == true) goto L87;
        return createAreaRefParseNode(r1, r2, r14);
    L87:
        throw new FormulaParseException("Dotted range (full row or column) expression '" + r15 + "' must not contain whitespace.");
    L89:
        if (r2.isCell() == true) goto L91;
    L94:
        if (r1 != null) goto L98;
        return parseNonRange(r0);
    L98:
        throw new FormulaParseException("Second part of cell reference expected after sheet name at index " + this._pointer + ".");
    L91:
        if (isValidCellReference(r2.getRep()) == false) goto L94;
        return createAreaRefParseNode(r1, r2, null);
    L5:
        SkipWhite();
        r0 = this._pointer;
        goto L6
    }

    private SheetIdentifier parseSheetName(boolean r9) {
        if (this.look != 91) goto L5;
        String r0 = getBookName();
    L6:
        int r3 = this.look;
        boolean r6 = false;
        if (r3 == 39) goto L36;
        if (r9 == true) goto L36;
        if (r3 != 95) goto L13;
    L21:
        StringBuilder r10 = new StringBuilder();
    L23:
        if (isUnquotedSheetNameChar(this.look) == false) goto L26;
        r10.appendCodePoint(this.look);
        GetChar();
        goto L23
    L26:
        if (this.look != 39) goto L28;
        GetChar();
    L28:
        NameIdentifier r1 = new NameIdentifier(r10.toString(), false);
        SkipWhite();
        int r11 = this.look;
        if (r11 != 33) goto L32;
        GetChar();
        return new SheetIdentifier(r0, r1);
    L32:
        if (r11 == 58) goto L34;
        return null;
    L34:
        return parseSheetRange(r0, r1, false);
    L13:
        if (Character.isLetter(r3) == true) goto L21;
        if (this.look != 33) goto L20;
        if (r0 == null) goto L20;
        GetChar();
        return new SheetIdentifier(r0, null);
    L20:
        return null;
    L36:
        if (r9 == true) goto L39;
        Match(39);
    L39:
        if (this.look != 91) goto L41;
        r0 = getBookName();
    L41:
        StringBuilder r12 = new StringBuilder();
        if (this.look != 39) goto L44;
        r6 = true;
    L44:
        if (r6 == true) goto L52;
        r12.appendCodePoint(this.look);
        GetChar();
        int r2 = this.look;
        if (r2 != 39) goto L47;
        GetChar();
        if (this.look == 39) goto L51;
        r6 = true;
        goto L44
    L51:
        GetChar();
        goto L44
    L47:
        if (r2 != 58) goto L44;
        r6 = true;
        goto L44
    L52:
        NameIdentifier r4 = new NameIdentifier(r12.toString(), true);
        SkipWhite();
        int r13 = this.look;
        if (r13 != 33) goto L56;
        GetChar();
        return new SheetIdentifier(r0, r4);
    L56:
        if (r13 == 58) goto L58;
        return null;
    L58:
        return parseSheetRange(r0, r4, true);
    L5:
        r0 = null;
        goto L6
    }

    private SheetIdentifier parseSheetRange(String r1, NameIdentifier r2, boolean r3) {
        GetChar();
        SheetIdentifier r0 = parseSheetName(r3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return new SheetRangeIdentifier(r1, r2, r0.getSheetIdentifier());
    }

    private ParseNode parseSimpleFactor() {
        SkipWhite();
        int r0 = this.look;
        if (r0 == 34) goto L46;
        if (r0 == 35) goto L44;
        if (r0 != 40) goto L9;
        Match(40);
        ParseNode r1 = unionExpression();
        Match(41);
        return new ParseNode(ParenthesisPtg.instance, r1);
    L9:
        if (r0 != 43) goto L11;
        Match(43);
        return parseUnary(true);
    L11:
        if (r0 != 45) goto L13;
        Match(45);
        return parseUnary(false);
    L13:
        if (r0 != 123) goto L15;
        Match(123);
        ParseNode r2 = parseArray();
        Match(125);
        return r2;
    L15:
        if (IsAlpha(r0) == true) goto L34;
        if (Character.isDigit(this.look) == true) goto L34;
        int r3 = this.look;
        if (r3 == 39) goto L34;
        if (r3 == 91) goto L34;
        if (r3 == 95) goto L34;
        if (r3 == 92) goto L34;
        if (r3 != 46) goto L32;
        return new ParseNode(parseNumber());
    L32:
        throw expected("cell ref or constant literal");
    L34:
        return parseRangeExpression();
    L44:
        return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
    L46:
        return new ParseNode(new StringPtg(parseStringLiteral()));
    }

    private SimpleRangePart parseSimpleRangePart() {
        int r0 = this._pointer - 1;
        boolean r2 = false;
        boolean r3 = false;
    L4:
        if (r0 >= this._formulaLength) goto L16;
        char r4 = this._formulaString.charAt(r0);
        if (Character.isDigit(r4) == false) goto L9;
        r2 = true;
    L15:
        r0 = r0 + 1;
        goto L4
    L9:
        if (Character.isLetter(r4) == false) goto L12;
        r3 = true;
        goto L15
    L12:
        if (r4 == '$') goto L15;
        if (r4 == '_') goto L15;
    L16:
        int r5 = this._pointer;
        if (r0 > (r5 - 1)) goto L19;
        return null;
    L19:
        String r6 = this._formulaString.substring(r5 - 1, r0);
        if (CELL_REF_PATTERN.matcher(r6).matches() == true) goto L22;
        return null;
    L22:
        if (r3 == false) goto L28;
        if (r2 == false) goto L28;
        if (isValidCellReference(r6) == true) goto L38;
        return null;
    L38:
        resetPointer(r0 + 1);
        return new SimpleRangePart(r6, r3, r2);
    L28:
        if (r3 == true) goto L30;
        if (r2 == true) goto L42;
    L40:
        return null;
    L42:
        int r7 = Integer.parseInt(r6.replace("$", ""));     // Catch: NumberFormatException -> L41
        if (r7 < 1) goto L40;
        if (r7 <= this._ssVersion.getMaxRows()) goto L38;
    L30:
        if (CellReference.isColumnWithinRange(r6.replace("$", ""), this._ssVersion) == true) goto L38;
        return null;
    }

    private String parseStringLiteral() {
        Match(34);
        StringBuilder r1 = new StringBuilder();
    L4:
        if (this.look != 34) goto L9;
        GetChar();
        if (this.look == 34) goto L9;
        return r1.toString();
    L9:
        r1.appendCodePoint(this.look);
        GetChar();
        goto L4
    }

    private ParseNode parseStructuredReference(String r30) {
        if (this._ssVersion.equals(SpreadsheetVersion.EXCEL2007) == false) goto L191;
        Table r2 = this._book.getTable(r30);
        if (r2 == null) goto L189;
        String r1 = r2.getSheetName();
        int r3 = r2.getStartColIndex();
        int r4 = r2.getEndColIndex();
        int r5 = r2.getStartRowIndex();
        int r6 = r2.getEndRowIndex();
        int r7 = this._pointer;
        GetChar();
        int r9 = 0;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        boolean r14 = false;
    L7:
        int r15 = this._pointer;
        String r8 = parseAsSpecialQuantifier();
        int r16 = r4;
        byte r18 = 4;
        boolean r19 = r10;
        boolean r21 = r11;
        boolean r22 = r12;
        boolean r23 = r13;
        boolean r24 = r14;
        String r25 = r1;
        if (r8 == null) goto L9;
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1835006106: goto L30;
            case -1784055345: goto L26;
            case 65921: goto L22;
            case 2122698: goto L18;
            case 1291583832: goto L14;
            default: goto L12;
        };
    L12:
        byte r17 = -1;
    L33:
        switch(r17) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            default: goto L35;
        };
    L36:
        r21 = true;
    L41:
        r9 = r9 + 1;
        if (this.look != 44) goto L44;
        GetChar();
        r4 = r16;
        r10 = r19;
        r11 = r21;
        r12 = r22;
        r13 = r23;
        r14 = r24;
        r1 = r25;
    L44:
        SkipWhite();
        if (this.look != 64) goto L47;
        GetChar();
        boolean r20 = true;
    L48:
        int r110 = this._pointer;
        String r26 = parseAsColumnQuantifier();
        if (r26 != null) goto L52;
        resetPointer(r110);
        int r27 = r3;
        int r111 = 0;
    L51:
        String r112 = null;
    L63:
        if (r111 != 0) goto L103;
        if (r9 != 0) goto L103;
        resetPointer(r7);
        int r28 = this._pointer;
        r26 = parseAsColumnQuantifier();
        if (r26 == null) goto L68;
        r111 = r111 + 1;
    L104:
        String r29 = r26;
        if (r19 == true) goto L107;
    L110:
        if (r20 == true) goto L112;
        if (r21 == true) goto L112;
    L116:
        if (r9 > 0) goto L118;
        if (r20 == false) goto L151;
    L149:
        r5 = this._rowIndex;
    L150:
        r6 = r5;
    L156:
        if (r111 != 2) goto L168;
        if (r29 == null) goto L166;
        if (r112 == null) goto L166;
        int r31 = r2.findColumnIndex(r29);
        String r32 = r112;
        int r33 = r2.findColumnIndex(r32);
        if (r31 == (-1)) goto L164;
        if (r33 == (-1)) goto L164;
        int r34 = r27 + r31;
        int r35 = r27 + r33;
    L179:
        CellReference r36 = new CellReference(r5, r34);
        CellReference r37 = new CellReference(r6, r35);
        return new ParseNode(this._book.get3DReferencePtg(new AreaReference(r36, r37, this._ssVersion), new SheetIdentifier(null, new NameIdentifier(r25, true))));
    L164:
        throw new FormulaParseException("One of the columns " + r29 + ", " + r32 + " doesn't exist in table " + r2.getName());
    L166:
        throw new IllegalStateException(new StringBuilder().append("Cannot parse column: ").append(r29).append(" and ").append(r112).append(" with formula ").append(this._formulaString).toString());
    L168:
        if (r111 != 1) goto L178;
        if (r20 == true) goto L178;
        if (r29 == null) goto L177;
        int r38 = r2.findColumnIndex(r29);
        if (r38 == (-1)) goto L175;
        r34 = r27 + r38;
        r35 = r34;
        goto L179
    L175:
        throw new FormulaParseException("The column " + r29 + " doesn't exist in table " + r2.getName());
    L177:
        throw new IllegalStateException("Cannot parse column: " + r29 + " with formula " + this._formulaString);
    L178:
        r35 = r16;
        r34 = r27;
        goto L179
    L151:
        r5 = r5 + 1;
        if (r2.getTotalsRowCount() <= 0) goto L156;
        int r39 = r6 - 1;
    L154:
        r6 = r39;
        goto L156
    L118:
        if (r9 != 1) goto L121;
        if (r24 == true) goto L156;
    L121:
        if (r22 == false) goto L126;
        if (r23 == false) goto L126;
        if (r2.getTotalsRowCount() <= 0) goto L156;
        r6 = r6 - 1;
    L126:
        if (r22 == false) goto L129;
        if (r19 == false) goto L129;
        r5 = r5 + 1;
    L129:
        int r40 = 1;
        if (r9 != 1) goto L136;
        if (r22 == false) goto L135;
        r5 = r5 + 1;
        if (r2.getTotalsRowCount() <= 0) goto L156;
        r39 = r6 - 1;
        goto L154
    L135:
        r40 = 1;
    L136:
        if (r9 != r40) goto L139;
        if (r23 == true) goto L150;
    L139:
        if (r9 != r40) goto L142;
        if (r19 == false) goto L142;
        r5 = r6;
    L142:
        if (r9 != r40) goto L144;
        if (r21 == true) goto L149;
    L144:
        if (r20 == true) goto L149;
        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
    L112:
        int r41 = this._rowIndex;
        if (r41 < r5) goto L181;
        if (r6 >= r41) goto L116;
    L181:
        if (r41 < 0) goto L185;
        return new ParseNode(ErrPtg.VALUE_INVALID);
    L185:
        throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
    L107:
        if (r2.getTotalsRowCount() != 0) goto L110;
        return new ParseNode(ErrPtg.REF_INVALID);
    L68:
        resetPointer(r28);
        String r42 = parseAsSpecialQuantifier();
        if (r42 == null) goto L102;
        r42.hashCode();
        switch(r42.hashCode()) {
            case -1835006106: goto L89;
            case -1784055345: goto L85;
            case 65921: goto L81;
            case 2122698: goto L77;
            case 1291583832: goto L74;
            default: goto L72;
        };
    L72:
        r18 = -1;
    L92:
        switch(r18) {
            case 0: goto L99;
            case 1: goto L98;
            case 2: goto L97;
            case 3: goto L96;
            case 4: goto L95;
            default: goto L94;
        };
    L95:
        r21 = true;
    L100:
        r9 = r9 + 1;
        goto L104
    L96:
        r22 = true;
        goto L100
    L97:
        r24 = true;
        goto L100
    L98:
        r19 = true;
        goto L100
    L99:
        r23 = true;
        goto L100
    L94:
        throw new FormulaParseException("Unknown special quantifier " + r42);
    L74:
        if (r42.equals("This Row") == true) goto L92;
    L77:
        if (r42.equals("Data") == false) goto L72;
        r18 = 3;
        goto L92
    L81:
        if (r42.equals("All") == false) goto L72;
        r18 = 2;
        goto L92
    L85:
        if (r42.equals("Totals") == false) goto L72;
        r18 = 1;
        goto L92
    L89:
        if (r42.equals("Headers") == false) goto L72;
        r18 = 0;
        goto L92
    L102:
        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
    L103:
        Match(93);
        goto L104
    L52:
        int r113 = this.look;
        r27 = r3;
        if (r113 == 44) goto L187;
        if (r113 != 58) goto L61;
        GetChar();
        String r43 = parseAsColumnQuantifier();
        if (r43 == null) goto L60;
        r112 = r43;
        r111 = 2;
        goto L63
    L60:
        throw new FormulaParseException("The formula " + this._formulaString + " is illegal: the string after ':' must be column quantifier");
    L61:
        r111 = 1;
        goto L51
    L187:
        throw new FormulaParseException("The formula " + this._formulaString + " is illegal: you should not use ',' with column quantifiers");
    L47:
        r20 = false;
        goto L48
    L37:
        r22 = true;
        goto L41
    L38:
        r24 = true;
        goto L41
    L39:
        r19 = true;
        goto L41
    L40:
        r23 = true;
        goto L41
    L35:
        throw new FormulaParseException("Unknown special quantifier " + r8);
    L14:
        if (r8.equals("This Row") == false) goto L12;
        r17 = 4;
        goto L33
    L18:
        if (r8.equals("Data") == false) goto L12;
        r17 = 3;
        goto L33
    L22:
        if (r8.equals("All") == false) goto L12;
        r17 = 2;
        goto L33
    L26:
        if (r8.equals("Totals") == false) goto L12;
        r17 = 1;
        goto L33
    L30:
        if (r8.equals("Headers") == false) goto L12;
        r17 = 0;
        goto L33
    L9:
        resetPointer(r15);
        goto L44
    L189:
        throw new FormulaParseException("Illegal table name: '" + r30 + "'");
    L191:
        throw new FormulaParseException("Structured references work only on XSSF (Excel 2007+)!");
    }

    public static Area3DPxg parseStructuredReference(String r3, FormulaParsingWorkbook r4, int r5) {
        Ptg[] r6 = parse(r3, (FormulaParsingWorkbook) ZeusTransformUtils.wrapperContextForParams(r4, FormulaParsingWorkbook.class, "com.obric.memorydata.plugin"), FormulaType.CELL, -1, r5);
        if (r6.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r6[0], Area3DPxg.class) == false) goto L9;
        return (Area3DPxg) ZeusTransformUtils.preCheckCast(r6[0], Area3DPxg.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalStateException("Illegal structured reference, had length: " + r6.length);
    }

    private ParseNode parseUnary(boolean r4) {
        if (IsDigit(this.look) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        ParseNode r3 = powerFactor();
        if (r0 == false) goto L24;
        Ptg r1 = r3.getToken();
        if (ZeusTransformUtils.instanceOf(r1, NumberPtg.class) == false) goto L18;
        if (r4 == false) goto L16;
        return r3;
    L16:
        return new ParseNode(new NumberPtg(-((NumberPtg) ZeusTransformUtils.preCheckCast(r1, NumberPtg.class, "com.obric.memorydata.plugin")).getValue()));
    L18:
        if (ZeusTransformUtils.instanceOf(r1, IntPtg.class) == false) goto L24;
        if (r4 == false) goto L22;
        return r3;
    L22:
        return new ParseNode(new NumberPtg(-((IntPtg) ZeusTransformUtils.preCheckCast(r1, IntPtg.class, "com.obric.memorydata.plugin")).getValue()));
    L24:
        if (r4 == false) goto L26;
        Ptg r5 = UnaryPlusPtg.instance;
    L28:
        return new ParseNode(r5, r3);
    L26:
        r5 = UnaryMinusPtg.instance;
        goto L28
    L5:
        if (this.look == 46) goto L8;
        r0 = false;
        goto L9
    }

    private String parseUnquotedIdentifier() {
        if (this.look == 39) goto L18;
        StringBuilder r0 = new StringBuilder();
    L6:
        if (Character.isLetterOrDigit(this.look) == true) goto L16;
        if (this.look == 46) goto L16;
        if (r0.length() >= 1) goto L15;
        return null;
    L15:
        return r0.toString();
    L16:
        r0.appendCodePoint(this.look);
        GetChar();
        goto L6
    L18:
        throw expected("unquoted identifier");
    }

    private ParseNode percentFactor() {
        ParseNode r0 = parseSimpleFactor();
    L3:
        SkipWhite();
        if (this.look != 37) goto L5;
        Match(37);
        r0 = new ParseNode(PercentPtg.instance, r0);
        goto L3
    L5:
        return r0;
    }

    private ParseNode powerFactor() {
        ParseNode r0 = percentFactor();
    L3:
        SkipWhite();
        if (this.look != 94) goto L5;
        Match(94);
        ParseNode r1 = percentFactor();
        r0 = new ParseNode(PowerPtg.instance, r0, r1);
        goto L3
    L5:
        return r0;
    }

    private void resetPointer(int r3) {
        this._pointer = r3;
        if (r3 > this._formulaLength) goto L5;
        int r4 = this._formulaString.codePointAt(r3 - Character.charCount(this.look));
    L6:
        this.look = r4;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private ParseNode unionExpression() {
        ParseNode r0 = intersectionExpression();
        boolean r1 = false;
    L3:
        SkipWhite();
        if (this.look != 44) goto L6;
        GetChar();
        r1 = true;
        ParseNode r2 = intersectionExpression();
        r0 = new ParseNode(UnionPtg.instance, r0, r2);
        goto L3
    L6:
        if (r1 == true) goto L8;
        return r0;
    L8:
        return augmentWithMemPtg(r0);
    }

    private void validateNumArgs(int r8, FunctionMetadata r9) {
        if (r8 >= r9.getMinParams()) goto L11;
        String r7 = "Too few arguments to function '" + r9.getName() + "'. ";
        if (r9.hasFixedArgsLength() == false) goto L7;
        StringBuilder r10 = new StringBuilder().append(r7).append("Expected ").append(r9.getMinParams());
    L9:
        throw new FormulaParseException(r10.toString() + " but got " + r8 + ".");
    L7:
        r10 = new StringBuilder().append(r7).append("At least ").append(r9.getMinParams()).append(" were expected");
        goto L9
    L11:
        if (r9.hasUnlimitedVarags() == false) goto L15;
        FormulaParsingWorkbook r11 = this._book;
        if (r11 == null) goto L15;
        int r12 = r11.getSpreadsheetVersion().getMaxFunctionArgs();
    L16:
        if (r8 <= r12) goto L23;
        String r0 = "Too many arguments to function '" + r9.getName() + "'. ";
        if (r9.hasFixedArgsLength() == false) goto L20;
        StringBuilder r13 = new StringBuilder().append(r0).append("Expected ").append(r12);
    L22:
        throw new FormulaParseException(r13.toString() + " but got " + r8 + ".");
    L20:
        r13 = new StringBuilder().append(r0).append("At most ").append(r12).append(" were expected");
        goto L22
    L23:
        return;
    L15:
        r12 = r9.getMaxParams();
        goto L16
    }
}
