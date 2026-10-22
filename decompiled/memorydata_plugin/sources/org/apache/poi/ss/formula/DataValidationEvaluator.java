package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class DataValidationEvaluator {
    private final WorkbookEvaluator workbookEvaluator;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.DataValidationEvaluator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class DataValidationContext {
        private final DataValidation dv;
        private final DataValidationEvaluator dve;
        private final CellRangeAddressBase region;
        private final CellReference target;

        public DataValidationEvaluator getEvaluator() {
            return this.dve;
        }

        public String getFormula1() {
            return this.dv.getValidationConstraint().getFormula1();
        }

        public String getFormula2() {
            return this.dv.getValidationConstraint().getFormula2();
        }

        public int getOperator() {
            return this.dv.getValidationConstraint().getOperator();
        }

        public CellRangeAddressBase getRegion() {
            return this.region;
        }

        public int getSheetIndex() {
            return this.dve.getWorkbookEvaluator().getSheetIndex(this.target.getSheetName());
        }

        public CellReference getTarget() {
            return this.target;
        }

        public DataValidation getValidation() {
            return this.dv;
        }
    }

    public static abstract enum OperatorEnum extends Enum<OperatorEnum> {
        private static final /* synthetic */ OperatorEnum[] $VALUES = null;
        public static final OperatorEnum BETWEEN = null;
        public static final OperatorEnum EQUAL = null;
        public static final OperatorEnum GREATER_OR_EQUAL = null;
        public static final OperatorEnum GREATER_THAN = null;
        public static final OperatorEnum IGNORED = null;
        public static final OperatorEnum LESS_OR_EQUAL = null;
        public static final OperatorEnum LESS_THAN = null;
        public static final OperatorEnum NOT_BETWEEN = null;
        public static final OperatorEnum NOT_EQUAL = null;

        static {
            final String r1 = "BETWEEN";
            final int r2 = 0;
            OperatorEnum r0 = new AnonymousClass1(r1, r2);
            BETWEEN = r0;
            final String r3 = "NOT_BETWEEN";
            final int r4 = 1;
            OperatorEnum r5 = new AnonymousClass2(r3, r4);
            NOT_BETWEEN = r5;
            final String r6 = "EQUAL";
            final int r7 = 2;
            OperatorEnum r8 = new AnonymousClass3(r6, r7);
            EQUAL = r8;
            final String r9 = "NOT_EQUAL";
            final int r10 = 3;
            OperatorEnum r11 = new AnonymousClass4(r9, r10);
            NOT_EQUAL = r11;
            final String r12 = "GREATER_THAN";
            final int r13 = 4;
            OperatorEnum r14 = new AnonymousClass5(r12, r13);
            GREATER_THAN = r14;
            final String r15 = "LESS_THAN";
            final int r16 = 5;
            OperatorEnum r17 = new AnonymousClass6(r15, r16);
            LESS_THAN = r17;
            final String r18 = "GREATER_OR_EQUAL";
            final int r19 = 6;
            OperatorEnum r110 = new AnonymousClass7(r18, r19);
            GREATER_OR_EQUAL = r110;
            final String r111 = "LESS_OR_EQUAL";
            final int r112 = 7;
            OperatorEnum r113 = new AnonymousClass8(r111, r112);
            LESS_OR_EQUAL = r113;
            $VALUES = new OperatorEnum[]{r0, r5, r8, r11, r14, r17, r110, r113};
            IGNORED = r0;
        }

        private OperatorEnum(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ OperatorEnum(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static OperatorEnum valueOf(String r2) {
            return (OperatorEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(OperatorEnum.class, r2), OperatorEnum.class, "com.obric.memorydata.plugin");
        }

        public static OperatorEnum[] values() {
            return (OperatorEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OperatorEnum[].class, "com.obric.memorydata.plugin");
        }

        public abstract boolean isValid(Double r1, Double r2, Double r3);
    }

    public static enum ValidationEnum extends Enum<ValidationEnum> {
        private static final /* synthetic */ ValidationEnum[] $VALUES = null;
        public static final ValidationEnum ANY = null;
        public static final ValidationEnum DATE = null;
        public static final ValidationEnum DECIMAL = null;
        public static final ValidationEnum FORMULA = null;
        public static final ValidationEnum INTEGER = null;
        public static final ValidationEnum LIST = null;
        public static final ValidationEnum TEXT_LENGTH = null;
        public static final ValidationEnum TIME = null;

        static {
            final String r1 = "ANY";
            final int r2 = 0;
            ValidationEnum r0 = new AnonymousClass1(r1, r2);
            ANY = r0;
            final String r3 = "INTEGER";
            final int r4 = 1;
            ValidationEnum r5 = new AnonymousClass2(r3, r4);
            INTEGER = r5;
            ValidationEnum r6 = new ValidationEnum("DECIMAL", 2);
            DECIMAL = r6;
            final String r7 = "LIST";
            final int r8 = 3;
            ValidationEnum r9 = new AnonymousClass3(r7, r8);
            LIST = r9;
            ValidationEnum r10 = new ValidationEnum("DATE", 4);
            DATE = r10;
            ValidationEnum r11 = new ValidationEnum("TIME", 5);
            TIME = r11;
            final String r13 = "TEXT_LENGTH";
            final int r14 = 6;
            ValidationEnum r12 = new AnonymousClass4(r13, r14);
            TEXT_LENGTH = r12;
            final String r15 = "FORMULA";
            final int r16 = 7;
            ValidationEnum r17 = new AnonymousClass5(r15, r16);
            FORMULA = r17;
            $VALUES = new ValidationEnum[]{r0, r5, r6, r9, r10, r11, r12, r17};
        }

        private ValidationEnum(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ValidationEnum(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private Double evalOrConstant(String r4, DataValidationContext r5) {
            if (StringUtil.isBlank(r4) == false) goto L26;
            return null;
        L26:
            return Double.valueOf(r4);
        L7:
            ValueEval r3 = r5.getEvaluator().getWorkbookEvaluator().evaluate(r4, r5.getTarget(), r5.getRegion());
            if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L11;
            r3 = ((RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin")).getInnerValueEval(((RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin")).getFirstSheetIndex());
        L11:
            if (ZeusTransformUtils.instanceOf(r3, BlankEval.class) == false) goto L14;
            return null;
        L14:
            if (ZeusTransformUtils.instanceOf(r3, NumberEval.class) == false) goto L18;
            return Double.valueOf(((NumberEval) ZeusTransformUtils.preCheckCast(r3, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
        L18:
            if (ZeusTransformUtils.instanceOf(r3, StringEval.class) == false) goto L25;
            String r6 = ((StringEval) ZeusTransformUtils.preCheckCast(r3, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
            if (StringUtil.isBlank(r6) == false) goto L23;
            return null;
        L23:
            return Double.valueOf(r6);
        L25:
            throw new NumberFormatException("Formula '" + r4 + "' evaluates to something other than a number");
        }

        public static boolean isValid(Cell r2, DataValidationContext r3) {
            Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r2, Cell.class, "com.obric.memorydata.plugin");
            return values()[r3.getValidation().getValidationConstraint().getValidationType()].isValidValue(r4, r3);
        }

        public static ValidationEnum valueOf(String r2) {
            return (ValidationEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(ValidationEnum.class, r2), ValidationEnum.class, "com.obric.memorydata.plugin");
        }

        public static ValidationEnum[] values() {
            return (ValidationEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ValidationEnum[].class, "com.obric.memorydata.plugin");
        }

        public boolean isValidNumericCell(Cell r3, DataValidationContext r4) {
            Cell r5 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
            if (DataValidationEvaluator.isType(r5, CellType.NUMERIC) == true) goto L7;
            return false;
        L7:
            return isValidNumericValue(Double.valueOf(r5.getNumericCellValue()), r4);
        }

        public boolean isValidNumericValue(Double r5, DataValidationContext r6) {
            Double r0 = evalOrConstant(r6.getFormula1(), r6);     // Catch: NumberFormatException -> L14
            if (r0 != null) goto L5;
            return true;
        L5:
            Double r2 = null;
            if (r6.getOperator() != 0) goto L8;
        L9:
            r2 = evalOrConstant(r6.getFormula2(), r6);     // Catch: NumberFormatException -> L14
            if (r2 != null) goto L12;
            return true;
        L12:
            return OperatorEnum.values()[r6.getOperator()].isValid(r5, r0, r2);
        L8:
            if (r6.getOperator() != 1) goto L12;
        L14:
            return false;
        }

        public boolean isValidValue(Cell r3, DataValidationContext r4) {
            return isValidNumericCell((Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    public static List<ValueEval> getValidationValuesForConstraint(DataValidationContext r5) {
        DataValidationConstraint r0 = r5.getValidation().getValidationConstraint();
        if (r0.getValidationType() == 3) goto L6;
        return null;
    L6:
        String r1 = r0.getFormula1();
        ArrayList r2 = new ArrayList();
        int r4 = 0;
        if (r0.getExplicitListValues() != null) goto L9;
    L16:
        if (r1 == null) goto L24;
        ValueEval r6 = r5.getEvaluator().getWorkbookEvaluator().evaluateList(r1, r5.getTarget(), r5.getRegion());
        if (ZeusTransformUtils.instanceOf(r6, TwoDEval.class) == false) goto L24;
        TwoDEval r7 = (TwoDEval) ZeusTransformUtils.preCheckCast(r6, TwoDEval.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L21:
        if (r3 >= r7.getHeight()) goto L24;
        r2.add(r7.getValue(r3, 0));
        r3 = r3 + 1;
    L24:
        return Collections.unmodifiableList(r2);
    L9:
        if (r0.getExplicitListValues().length <= 0) goto L16;
        String[] r8 = r0.getExplicitListValues();
        int r9 = r8.length;
    L11:
        if (r4 >= r9) goto L24;
        String r10 = r8[r4];
        if (r10 == null) goto L15;
        r2.add(new StringEval(r10));
    L15:
        r4 = r4 + 1;
        goto L11
    }

    public static boolean isType(Cell r2, CellType r3) {
        Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r2, Cell.class, "com.obric.memorydata.plugin");
        CellType r0 = r4.getCellType();
        if (r0 != r3) goto L5;
    L10:
        return true;
    L5:
        if (r0 == CellType.FORMULA) goto L7;
    L9:
        return false;
    L7:
        if (r4.getCachedFormulaResultType() != r3) goto L9;
        goto L9
    }

    public WorkbookEvaluator getWorkbookEvaluator() {
        return this.workbookEvaluator;
    }
}
