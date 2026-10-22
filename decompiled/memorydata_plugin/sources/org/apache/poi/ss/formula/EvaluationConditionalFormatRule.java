package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class EvaluationConditionalFormatRule implements Comparable<EvaluationConditionalFormatRule> {
    private final DecimalFormat decimalTextFormat;
    private final ConditionalFormatting formatting;
    private final int formattingIndex;
    private final String formula1;
    private final String formula2;
    private final String lowerText;
    private final Map<CellRangeAddress, Set<ValueAndFormat>> meaningfulRegionValues;
    private final ExcelNumberFormat numberFormat;
    private final OperatorEnum operator;
    private final int priority;
    private final CellRangeAddress[] regions;
    private final ConditionalFormattingRule rule;
    private final int ruleIndex;
    private final Sheet sheet;
    private final String text;
    private CellRangeAddress topLeftRegion;
    private final ConditionType type;
    private final WorkbookEvaluator workbookEvaluator;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.EvaluationConditionalFormatRule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L59:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L47:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L8:
            int[] r3 = new int[ConditionFilterType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType = r3;
            r3[ConditionFilterType.FILTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L73:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.TOP_10.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L43:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.UNIQUE_VALUES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L61:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.DUPLICATE_VALUES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L71:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.ABOVE_AVERAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L45:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L63:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_TEXT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L67:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.BEGINS_WITH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L53:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.ENDS_WITH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L57:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_BLANKS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L49:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_BLANKS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L51:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_ERRORS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L69:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_ERRORS.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L41:
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.TIME_PERIOD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
            return;
        }
    }

    protected static class ValueAndFormat implements Comparable<ValueAndFormat> {
        private final DecimalFormat decimalTextFormat;
        private final String format;
        private final String string;
        private final Double value;

        public ValueAndFormat(Double r1, String r2, DecimalFormat r3) {
            this.value = r1;
            this.format = r2;
            this.string = null;
            this.decimalTextFormat = r3;
        }

        public ValueAndFormat(String r2, String r3) {
            this.value = null;
            this.format = r3;
            this.string = r2;
            this.decimalTextFormat = null;
        }

        static /* synthetic */ Double access$000(ValueAndFormat r0) {
            return r0.value;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(ValueAndFormat r3) {
            return compareTo2((ValueAndFormat) ZeusTransformUtils.preCheckCast(r3, ValueAndFormat.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ValueAndFormat r6) {
            Double r0 = this.value;
            if (r0 == null) goto L5;
        L7:
            Double r2 = r6.value;
            if (r2 != null) goto L12;
            if (r0 == null) goto L12;
            return -1;
        L12:
            if (r0 != null) goto L14;
            int r1 = 0;
        L15:
            if (r1 == 0) goto L17;
            return r1;
        L17:
            String r5 = this.string;
            if (r5 == null) goto L20;
        L22:
            String r7 = r6.string;
            if (r7 != null) goto L26;
            if (r5 == null) goto L26;
            return -1;
        L26:
            if (r5 != null) goto L29;
            return 0;
        L29:
            return r5.compareTo(r7);
        L20:
            if (r6.string == null) goto L22;
            return 1;
        L14:
            r1 = r0.compareTo(r2);
            goto L15
        L5:
            if (r6.value == null) goto L7;
            return 1;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ValueAndFormat.class) == true) goto L5;
            return false;
        L5:
            ValueAndFormat r5 = (ValueAndFormat) ZeusTransformUtils.preCheckCast(r4, ValueAndFormat.class, "com.obric.memorydata.plugin");
            if (Objects.equals(this.value, r5.value) == true) goto L8;
            return false;
        L8:
            if (Objects.equals(this.format, r5.format) == true) goto L10;
            return false;
        L10:
            if (Objects.equals(this.string, r5.string) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public String getString() {
            return this.string;
        }

        public Double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.string, this.value, this.format});
        }

        public boolean isNumber() {
            if (this.value == null) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            if (isNumber() == false) goto L7;
            return this.decimalTextFormat.format(getValue().doubleValue());
        L7:
            return getString();
        }
    }

    public EvaluationConditionalFormatRule(WorkbookEvaluator r3, Sheet r4, ConditionalFormatting r5, int r6, ConditionalFormattingRule r7, int r8, CellRangeAddress[] r9) {
        Sheet r10 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r4, Sheet.class, "com.obric.memorydata.plugin");
        ConditionalFormatting r11 = (ConditionalFormatting) ZeusTransformUtils.wrapperContextForParams(r5, ConditionalFormatting.class, "com.obric.memorydata.plugin");
        ConditionalFormattingRule r12 = (ConditionalFormattingRule) ZeusTransformUtils.wrapperContextForParams(r7, ConditionalFormattingRule.class, "com.obric.memorydata.plugin");
        this.meaningfulRegionValues = new HashMap();
        this.workbookEvaluator = r3;
        this.sheet = r10;
        this.formatting = r11;
        this.rule = r12;
        this.formattingIndex = r6;
        this.ruleIndex = r8;
        this.priority = r12.getPriority();
        this.regions = r9;
        int r13 = r9.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L13;
        CellRangeAddress r15 = r9[r14];
        if (this.topLeftRegion != null) goto L8;
    L6:
        this.topLeftRegion = r15;
    L12:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r15.getFirstColumn() < this.topLeftRegion.getFirstColumn()) goto L6;
        if (r15.getFirstRow() >= this.topLeftRegion.getFirstRow()) goto L12;
    L13:
        this.formula1 = r12.getFormula1();
        this.formula2 = r12.getFormula2();
        String r16 = r12.getText();
        this.text = r16;
        if (r16 != null) goto L16;
        String r17 = null;
    L17:
        this.lowerText = r17;
        this.numberFormat = r12.getNumberFormat();
        this.operator = OperatorEnum.values()[r12.getComparisonOperation()];
        this.type = r12.getConditionType();
        DecimalFormat r18 = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        this.decimalTextFormat = r18;
        r18.setMaximumFractionDigits(340);
        return;
    L16:
        r17 = r16.toLowerCase(LocaleUtil.getUserLocale());
        goto L17
    }

    private boolean checkFilter(Cell r7, CellReference r8, CellRangeAddress r9) {
        Cell r10 = (Cell) ZeusTransformUtils.wrapperContextForParams(r7, Cell.class, "com.obric.memorydata.plugin");
        ConditionFilterType r0 = this.rule.getConditionFilterType();
        if (r0 != null) goto L5;
        return false;
    L5:
        ValueAndFormat r3 = getCellValue(r10);
        int r4 = 1;
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[r0.ordinal()]) {
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L42;
            case 6: goto L37;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L15;
            case 13: goto L10;
            case 14: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L10:
        if (r10 == null) goto L14;
        if (DataValidationEvaluator.isType(r10, CellType.ERROR) == false) goto L14;
        return false;
    L14:
        return true;
    L15:
        if (r10 != null) goto L17;
        return false;
    L17:
        if (DataValidationEvaluator.isType(r10, CellType.ERROR) == true) goto L19;
        return false;
    L19:
        return true;
    L42:
        ConditionFilterData r11 = this.rule.getFilterConfiguration();
        ArrayList r12 = new ArrayList(getMeaningfulValues(r9, false, new $$Lambda$EvaluationConditionalFormatRule$MRNbPCqQrwqBJ_QtCg_F6frhDE(this)));
        if (r3.isNumber() == false) goto L45;
        Double r6 = r3.getValue();
    L46:
        if (r6 != null) goto L48;
        return false;
    L48:
        double r2 = ValueAndFormat.access$000((ValueAndFormat) ZeusTransformUtils.preCheckCast(r12.get(0), ValueAndFormat.class, "com.obric.memorydata.plugin")).doubleValue();
        double r1 = ValueAndFormat.access$000((ValueAndFormat) ZeusTransformUtils.preCheckCast(r12.get(1), ValueAndFormat.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r11.getStdDev() > 0) goto L51;
    L55:
        Double r13 = Double.valueOf(r2);
        boolean r5 = r11.getAboveAverage();
        boolean r14 = r11.getEqualAverage();
        if (r5 == false) goto L60;
        if (r14 == false) goto L59;
        OperatorEnum r15 = OperatorEnum.GREATER_OR_EQUAL;
    L64:
        return r15.isValid(r6, r13, null);
    L59:
        r15 = OperatorEnum.GREATER_THAN;
        goto L64
    L60:
        if (r14 == false) goto L62;
        r15 = OperatorEnum.LESS_OR_EQUAL;
        goto L64
    L62:
        r15 = OperatorEnum.LESS_THAN;
        goto L64
    L51:
        if (r11.getAboveAverage() == true) goto L54;
        r4 = -1;
    L54:
        r2 = r2 + ((((double) r4) * r1) * ((double) r11.getStdDev()));
        goto L55
    L45:
        r6 = null;
        goto L46
    L74:
        return StringUtil.isNotBlank(r3.getString());
    L22:
        return true;
    L76:
        return StringUtil.isBlank(r3.getString());
    L25:
        return false;
    L9:
        return checkFormula(r8, r9);
    L27:
        return r3.toString().toLowerCase(LocaleUtil.getUserLocale()).endsWith(this.lowerText);
    L29:
        return r3.toString().toLowerCase(LocaleUtil.getUserLocale()).startsWith(this.lowerText);
    L31:
        if (this.text == null) goto L35;
        if (r3.toString().toLowerCase(LocaleUtil.getUserLocale()).contains(this.lowerText) == false) goto L35;
        return false;
    L35:
        return true;
    L37:
        if (this.text != null) goto L39;
        return false;
    L39:
        if (r3.toString().toLowerCase(LocaleUtil.getUserLocale()).contains(this.lowerText) == true) goto L41;
        return false;
    L41:
        return true;
    L66:
        return getMeaningfulValues(r9, true, new $$Lambda$fk2mC8iJrD2wOD7SEpgvkREdacw(this)).contains(r3);
    L68:
        return getMeaningfulValues(r9, true, new $$Lambda$EvaluationConditionalFormatRule$3uUU51b_lk4VS2RMZWUESLmqdow(this)).contains(r3);
    L70:
        if (r3.isNumber() == true) goto L73;
        return false;
    L73:
        return getMeaningfulValues(r9, false, new $$Lambda$EvaluationConditionalFormatRule$yaulZ_fAhHwxD7MciG5aZUpOjwM(this)).contains(r3);
    }

    private boolean checkFormula(CellReference r4, CellRangeAddress r5) {
        ValueEval r3 = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), r4, r5));
        if (ZeusTransformUtils.instanceOf(r3, BlankEval.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ErrorEval.class) == false) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, BoolEval.class) == false) goto L13;
        return ((BoolEval) ZeusTransformUtils.preCheckCast(r3, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue();
    L13:
        if (ZeusTransformUtils.instanceOf(r3, NumberEval.class) == true) goto L15;
        return false;
    L15:
        if (((NumberEval) ZeusTransformUtils.preCheckCast(r3, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue() == 0.0d) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean checkValue(Cell r7, CellRangeAddress r8) {
        Cell r9 = (Cell) ZeusTransformUtils.wrapperContextForParams(r7, Cell.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return false;
    L5:
        if (DataValidationEvaluator.isType(r9, CellType.BLANK) == false) goto L7;
        return false;
    L7:
        if (DataValidationEvaluator.isType(r9, CellType.ERROR) == false) goto L9;
        return false;
    L9:
        if (DataValidationEvaluator.isType(r9, CellType.STRING) == true) goto L11;
    L15:
        ValueEval r0 = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), ConditionalFormattingEvaluator.getRef(r9), r8));
        String r2 = this.rule.getFormula2();
        ValueEval r3 = BlankEval.instance;
        if (r2 != null) goto L18;
    L20:
        Object r4 = null;
        if (DataValidationEvaluator.isType(r9, CellType.BOOLEAN) == false) goto L41;
        if (r0 == BlankEval.instance) goto L27;
        if (ZeusTransformUtils.instanceOf(r0, BoolEval.class) == false) goto L41;
    L27:
        if (r3 != BlankEval.instance) goto L29;
    L30:
        OperatorEnum r6 = this.operator;
        Boolean r10 = Boolean.valueOf(r9.getBooleanCellValue());
        if (r0 != BlankEval.instance) goto L33;
        Boolean r11 = null;
    L35:
        if (r3 == BlankEval.instance) goto L39;
        r4 = Boolean.valueOf(((BoolEval) ZeusTransformUtils.preCheckCast(r3, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue());
    L39:
        return r6.isValid(r10, r11, r4);
    L33:
        r11 = Boolean.valueOf(((BoolEval) ZeusTransformUtils.preCheckCast(r0, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue());
        goto L35
    L29:
        if (ZeusTransformUtils.instanceOf(r3, BoolEval.class) == true) goto L30;
    L41:
        if (DataValidationEvaluator.isType(r9, CellType.NUMERIC) == false) goto L61;
        if (r0 == BlankEval.instance) goto L47;
        if (ZeusTransformUtils.instanceOf(r0, NumberEval.class) == false) goto L61;
    L47:
        if (r3 != BlankEval.instance) goto L49;
    L50:
        OperatorEnum r12 = this.operator;
        Double r13 = Double.valueOf(r9.getNumericCellValue());
        if (r0 != BlankEval.instance) goto L53;
        Double r14 = null;
    L55:
        if (r3 == BlankEval.instance) goto L59;
        r4 = Double.valueOf(((NumberEval) ZeusTransformUtils.preCheckCast(r3, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L59:
        return r12.isValid(r13, r14, r4);
    L53:
        r14 = Double.valueOf(((NumberEval) ZeusTransformUtils.preCheckCast(r0, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
        goto L55
    L49:
        if (ZeusTransformUtils.instanceOf(r3, NumberEval.class) == true) goto L50;
    L61:
        if (DataValidationEvaluator.isType(r9, CellType.STRING) == false) goto L81;
        if (r0 == BlankEval.instance) goto L67;
        if (ZeusTransformUtils.instanceOf(r0, StringEval.class) == false) goto L81;
    L67:
        if (r3 != BlankEval.instance) goto L69;
    L70:
        OperatorEnum r15 = this.operator;
        String r16 = r9.getStringCellValue();
        if (r0 != BlankEval.instance) goto L73;
        String r17 = null;
    L75:
        if (r3 == BlankEval.instance) goto L79;
        r4 = ((StringEval) ZeusTransformUtils.preCheckCast(r3, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
    L79:
        return r15.isValid(r16, r17, r4);
    L73:
        r17 = ((StringEval) ZeusTransformUtils.preCheckCast(r0, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        goto L75
    L69:
        if (ZeusTransformUtils.instanceOf(r3, StringEval.class) == true) goto L70;
    L81:
        return this.operator.isValidForIncompatibleTypes();
    L18:
        if (r2.length() <= 0) goto L20;
        r3 = unwrapEval(this.workbookEvaluator.evaluate(r2, ConditionalFormattingEvaluator.getRef(r9), r8));
        goto L20
    L11:
        if (r9.getStringCellValue() != null) goto L13;
        return false;
    L13:
        if (r9.getStringCellValue().isEmpty() == false) goto L15;
        return false;
    }

    private Set<ValueAndFormat> evaluateAboveAverage(List<ValueAndFormat> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        ValueEval[] r0 = new ValueEval[r14.size()];
        double r3 = 0.0d;
        int r5 = 0;
        double r6 = 0.0d;
    L4:
        if (r5 >= r14.size()) goto L6;
        ValueAndFormat r8 = (ValueAndFormat) ZeusTransformUtils.preCheckCast(r14.get(r5), ValueAndFormat.class, "com.obric.memorydata.plugin");
        r6 = r6 + ValueAndFormat.access$000(r8).doubleValue();
        r0[r5] = new NumberEval(ValueAndFormat.access$000(r8).doubleValue());
        r5 = r5 + 1;
        goto L4
    L6:
        LinkedHashSet r7 = new LinkedHashSet(1);
        if (r14.isEmpty() == false) goto L9;
        double r9 = 0.0d;
    L10:
        r7.add(new ValueAndFormat(Double.valueOf(r9), null, this.decimalTextFormat));
        if (r14.size() <= 1) goto L14;
        r3 = ((NumberEval) ZeusTransformUtils.preCheckCast(AggregateFunction.STDEV.evaluate(r0, 0, 0), NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L14:
        r7.add(new ValueAndFormat(Double.valueOf(r3), null, this.decimalTextFormat));
        return r7;
    L9:
        r9 = r6 / ((double) r14.size());
        goto L10
    }

    private Set<ValueAndFormat> evaluateTop10(List<ValueAndFormat> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ConditionFilterData r2 = this.rule.getFilterConfiguration();
        if (r2.getBottom() == true) goto L5;
        r4.sort(Collections.reverseOrder());
    L6:
        int r0 = Math.toIntExact(r2.getRank());
        if (r2.getPercent() == false) goto L10;
        r0 = (r4.size() * r0) / 100;
    L10:
        if (r4.size() > r0) goto L14;
        return new HashSet(r4);
    L14:
        return new HashSet(r4.subList(0, r0));
    L5:
        Collections.sort(r4);
        goto L6
    }

    private Set<ValueAndFormat> evaluateUniqueValues(List<ValueAndFormat> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Collections.sort(r4);
        HashSet r6 = new HashSet();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L17;
        ValueAndFormat r2 = (ValueAndFormat) ZeusTransformUtils.preCheckCast(r4.get(r1), ValueAndFormat.class, "com.obric.memorydata.plugin");
        if (r1 < (r4.size() - 1)) goto L8;
    L9:
        if (r1 > 0) goto L11;
    L15:
        r6.add(r2);
    L16:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r1 != (r4.size() - 1)) goto L15;
        if (r2.equals(r4.get(r1 - 1)) == false) goto L15;
    L14:
        r1 = r1 + 1;
        goto L16
    L8:
        if (r2.equals(r4.get(r1 + 1)) == true) goto L14;
    L17:
        return r6;
    }

    private ValueAndFormat getCellValue(Cell r5) {
        Cell r6 = (Cell) ZeusTransformUtils.wrapperContextForParams(r5, Cell.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        String r0 = r6.getCellStyle().getDataFormatString();
        CellType r1 = r6.getCellType();
        if (r1 != CellType.FORMULA) goto L7;
        r1 = r6.getCachedFormulaResultType();
    L7:
        int r2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r1.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L19;
    L15:
        return new ValueAndFormat(r6.getStringCellValue(), r0);
    L17:
        return new ValueAndFormat(Double.valueOf(r6.getNumericCellValue()), r0, this.decimalTextFormat);
    L19:
        return new ValueAndFormat("", "");
    }

    private Set<ValueAndFormat> getMeaningfulValues(CellRangeAddress r8, boolean r9, Function<List<ValueAndFormat>, Set<ValueAndFormat>> r10) {
        Function r11 = (Function) ZeusTransformUtils.wrapperContextForParams(r10, Function.class, "com.obric.memorydata.plugin");
        Set<ValueAndFormat> r0 = (Set) ZeusTransformUtils.preCheckCast(this.meaningfulRegionValues.get(r8), Set.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList(((r8.getLastColumn() - r8.getFirstColumn()) + 1) * ((r8.getLastRow() - r8.getFirstRow()) + 1));
        int r2 = r8.getFirstRow();
    L7:
        if (r2 > r8.getLastRow()) goto L21;
        Row r3 = this.sheet.getRow(r2);
        if (r3 == null) goto L20;
        int r4 = r8.getFirstColumn();
    L13:
        if (r4 > r8.getLastColumn()) goto L20;
        ValueAndFormat r5 = getCellValue(r3.getCell(r4));
        if (r9 == false) goto L17;
    L18:
        r1.add(r5);
    L19:
        r4 = r4 + 1;
        goto L13
    L17:
        if (r5.isNumber() == false) goto L19;
    L20:
        r2 = r2 + 1;
        goto L7
    L21:
        Set<ValueAndFormat> r12 = (Set) ZeusTransformUtils.preCheckCast(r11.apply(r1), Set.class, "com.obric.memorydata.plugin");
        this.meaningfulRegionValues.put(r8, r12);
        return r12;
    }

    public static /* synthetic */ Set lambda$3uUU51b_lk4VS2RMZWUESLmqdow(EvaluationConditionalFormatRule r0, List r1) {
        return r0.evaluateUniqueValues(r1);
    }

    /* JADX INFO: renamed from: lambda$MRNbPCqQrwqBJ_Qt-Cg_F6frhDE, reason: not valid java name */
    public static /* synthetic */ Set m3173lambda$MRNbPCqQrwqBJ_QtCg_F6frhDE(EvaluationConditionalFormatRule r0, List r1) {
        return r0.evaluateAboveAverage(r1);
    }

    public static /* synthetic */ Set lambda$yaulZ_fAhHwxD7MciG5aZUpOjwM(EvaluationConditionalFormatRule r0, List r1) {
        return r0.evaluateTop10(r1);
    }

    private ValueEval unwrapEval(ValueEval r2) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r1, RefEval.class) == false) goto L6;
        RefEval r3 = (RefEval) ZeusTransformUtils.preCheckCast(r1, RefEval.class, "com.obric.memorydata.plugin");
        r1 = r3.getInnerValueEval(r3.getFirstSheetIndex());
        goto L4
    L6:
        return r1;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(EvaluationConditionalFormatRule r3) {
        return compareTo2((EvaluationConditionalFormatRule) ZeusTransformUtils.preCheckCast(r3, EvaluationConditionalFormatRule.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(EvaluationConditionalFormatRule r3) {
        int r0 = getSheet().getSheetName().compareToIgnoreCase(r3.getSheet().getSheetName());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = Integer.compare(getPriority(), r3.getPriority());
        if (r1 == 0) goto L8;
        return r1;
    L8:
        int r2 = Integer.compare(getFormattingIndex(), r3.getFormattingIndex());
        if (r2 == 0) goto L12;
        return r2;
    L12:
        return Integer.compare(getRuleIndex(), r3.getRuleIndex());
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getClass().equals(getClass()) == true) goto L8;
        return false;
    L8:
        EvaluationConditionalFormatRule r5 = (EvaluationConditionalFormatRule) ZeusTransformUtils.preCheckCast(r4, EvaluationConditionalFormatRule.class, "com.obric.memorydata.plugin");
        if (getSheet().getSheetName().equalsIgnoreCase(r5.getSheet().getSheetName()) == true) goto L11;
        return false;
    L11:
        if (getFormattingIndex() == r5.getFormattingIndex()) goto L13;
        return false;
    L13:
        if (getRuleIndex() != r5.getRuleIndex()) goto L18;
        return true;
    L18:
        return false;
    }

    public Set<ValueAndFormat> evaluateDuplicateValues(List<ValueAndFormat> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Collections.sort(r4);
        HashSet r6 = new HashSet();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L16;
        ValueAndFormat r2 = (ValueAndFormat) ZeusTransformUtils.preCheckCast(r4.get(r1), ValueAndFormat.class, "com.obric.memorydata.plugin");
        if (r1 < (r4.size() - 1)) goto L8;
    L9:
        if (r1 <= 0) goto L15;
        if (r1 != (r4.size() - 1)) goto L15;
        if (r2.equals(r4.get(r1 - 1)) == false) goto L15;
    L14:
        r6.add(r2);
        r1 = r1 + 1;
    L15:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2.equals(r4.get(r1 + 1)) == true) goto L14;
    L16:
        return r6;
    }

    public int getFormattingIndex() {
        return this.formattingIndex;
    }

    public ExcelNumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public int getPriority() {
        return this.priority;
    }

    public ConditionalFormattingRule getRule() {
        return this.rule;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public ConditionType getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.sheet.getSheetName(), Integer.valueOf(this.formattingIndex), Integer.valueOf(this.ruleIndex)});
    }

    boolean matches(CellReference r8) {
        CellRangeAddress[] r0 = this.regions;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        Cell r4 = null;
        if (r3 >= r1) goto L9;
        CellRangeAddress r5 = r0[r3];
        if (r5.isInRange(r8) == true) goto L10;
        r3 = r3 + 1;
    L10:
        if (r5 != null) goto L12;
        return false;
    L12:
        ConditionType r2 = getRule().getConditionType();
        if (r2.equals(ConditionType.COLOR_SCALE) == false) goto L15;
        return true;
    L15:
        if (r2.equals(ConditionType.DATA_BAR) == false) goto L17;
        return true;
    L17:
        if (r2.equals(ConditionType.ICON_SET) == true) goto L42;
        Row r6 = this.sheet.getRow(r8.getRow());
        if (r6 == null) goto L23;
        r4 = r6.getCell(r8.getCol());
    L23:
        if (r2.equals(ConditionType.CELL_VALUE_IS) == false) goto L29;
        if (r4 != null) goto L27;
        return false;
    L27:
        return checkValue(r4, this.topLeftRegion);
    L29:
        if (r2.equals(ConditionType.FORMULA) == false) goto L33;
        return checkFormula(r8, this.topLeftRegion);
    L33:
        if (r2.equals(ConditionType.FILTER) == true) goto L35;
        return false;
    L35:
        return checkFilter(r4, r8, this.topLeftRegion);
    L42:
        return true;
    L9:
        r5 = null;
        goto L10
    }
}
