package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
public final class OperandResolver {
    private static final Pattern fpPattern = null;

    static {
        fpPattern = Pattern.compile("[\\x00-\\x20]*[+-]?(((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.(\\p{Digit}+)([eE][+-]?(\\p{Digit}+))?))[\\x00-\\x20]*");
    }

    public static ValueEval chooseSingleElementFromArea(AreaEval r2, int r3, int r4) {
        ValueEval r5 = chooseSingleElementFromAreaInternal((AreaEval) ZeusTransformUtils.wrapperContextForParams(r2, AreaEval.class, "com.obric.memorydata.plugin"), r3, r4);
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == true) goto L6;
        return r5;
    L6:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    }

    private static ValueEval chooseSingleElementFromAreaInternal(AreaEval r2, int r3, int r4) {
        AreaEval r5 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r2, AreaEval.class, "com.obric.memorydata.plugin");
        if (r5.isColumn() == false) goto L15;
        if (r5.isRow() == false) goto L9;
        return r5.getRelativeValue(0, 0);
    L9:
        if (r5.containsRow(r3) == false) goto L13;
        return r5.getAbsoluteValue(r3, r5.getFirstColumn());
    L13:
        throw EvaluationException.invalidValue();
    L15:
        if (r5.isRow() == true) goto L25;
        if (r5.containsRow(r3) == false) goto L23;
        if (r5.containsColumn(r4) == false) goto L23;
        return r5.getAbsoluteValue(r3, r4);
    L23:
        throw EvaluationException.invalidValue();
    L25:
        if (r5.containsColumn(r4) == false) goto L29;
        return r5.getAbsoluteValue(r5.getFirstRow(), r4);
    L29:
        throw EvaluationException.invalidValue();
    }

    private static ValueEval chooseSingleElementFromRef(RefEval r2) {
        RefEval r3 = (RefEval) ZeusTransformUtils.wrapperContextForParams(r2, RefEval.class, "com.obric.memorydata.plugin");
        return r3.getInnerValueEval(r3.getFirstSheetIndex());
    }

    public static Boolean coerceValueToBoolean(ValueEval r3, boolean r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L43:
        return null;
    L5:
        if (r5 == BlankEval.instance) goto L43;
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == false) goto L12;
        return Boolean.valueOf(((BoolEval) ZeusTransformUtils.preCheckCast(r5, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue());
    L12:
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == false) goto L26;
        if (r4 == false) goto L15;
        return null;
    L15:
        String r6 = ((StringEval) ZeusTransformUtils.preCheckCast(r5, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        if (r6.equalsIgnoreCase("true") == false) goto L20;
        return Boolean.TRUE;
    L20:
        if (r6.equalsIgnoreCase("false") == false) goto L24;
        return Boolean.FALSE;
    L24:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L26:
        if (ZeusTransformUtils.instanceOf(r5, NumericValueEval.class) == false) goto L38;
        double r7 = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r5, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        if (Double.isNaN(r7) == true) goto L36;
        if (r7 == 0.0d) goto L32;
        boolean r8 = true;
    L34:
        return Boolean.valueOf(r8);
    L32:
        r8 = false;
        goto L34
    L36:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L38:
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == false) goto L42;
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    L42:
        throw new RuntimeException("Unexpected eval (" + r5.getClass().getName() + ")");
    }

    public static double coerceValueToDouble(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r4 != BlankEval.instance) goto L7;
        return 0.0d;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == false) goto L11;
        return ((NumericValueEval) ZeusTransformUtils.preCheckCast(r4, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, StringEval.class) == false) goto L21;
        String r5 = ((StringEval) ZeusTransformUtils.preCheckCast(r4, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        Double r0 = parseDouble(r5);
        if (r0 != null) goto L15;
        r0 = parseDateTime(r5);
    L15:
        if (r0 == null) goto L19;
        return r0.doubleValue();
    L19:
        throw EvaluationException.invalidValue();
    L21:
        throw new RuntimeException("Unexpected arg eval type (" + r4.getClass().getName() + ")");
    }

    public static int coerceValueToInt(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r3 != BlankEval.instance) goto L7;
        return 0;
    L7:
        return (int) Math.floor(coerceValueToDouble(r3));
    }

    public static String coerceValueToString(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, StringValueEval.class) == false) goto L7;
        return ((StringValueEval) ZeusTransformUtils.preCheckCast(r4, StringValueEval.class, "com.obric.memorydata.plugin")).getStringValue();
    L7:
        if (r4 != BlankEval.instance) goto L11;
        return "";
    L11:
        throw new IllegalArgumentException("Unexpected eval class (" + r4.getClass().getName() + ")");
    }

    public static ValueEval getElementFromArray(AreaEval r3, EvaluationCell r4) {
        AreaEval r5 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r3, AreaEval.class, "com.obric.memorydata.plugin");
        EvaluationCell r6 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r4, EvaluationCell.class, "com.obric.memorydata.plugin");
        CellRangeAddress r0 = r6.getArrayFormulaRange();
        int r1 = r6.getRowIndex() - r0.getFirstRow();
        int r7 = r6.getColumnIndex() - r0.getFirstColumn();
        if (r5.isColumn() == false) goto L13;
        if (r5.isRow() == false) goto L9;
        return r5.getRelativeValue(0, 0);
    L9:
        if (r1 >= r5.getHeight()) goto L27;
        return r5.getRelativeValue(r1, 0);
    L27:
        return ErrorEval.NA;
    L13:
        if (r5.isRow() == true) goto L21;
        if (r1 >= r5.getHeight()) goto L21;
        if (r7 >= r5.getWidth()) goto L21;
        return r5.getRelativeValue(r1, r7);
    L21:
        if (r5.isRow() == false) goto L27;
        if (r7 >= r5.getWidth()) goto L27;
        return r5.getRelativeValue(0, r7);
    }

    public static ValueEval getSingleValue(ValueEval r2, int r3, int r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, RefEval.class) == false) goto L6;
        r5 = chooseSingleElementFromRef((RefEval) ZeusTransformUtils.preCheckCast(r5, RefEval.class, "com.obric.memorydata.plugin"));
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == true) goto L12;
        return r5;
    L12:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AreaEval.class) == false) goto L9;
        r5 = chooseSingleElementFromArea((AreaEval) ZeusTransformUtils.preCheckCast(r5, AreaEval.class, "com.obric.memorydata.plugin"), r3, r4);
        goto L9
    }

    public static Double parseDateTime(String r0) {
        return DateUtil.parseDateTime(r0);
    L4:
        return null;
    }

    public static Double parseDouble(String r4) {
        if (fpPattern.matcher(r4).matches() == true) goto L8;
    L6:
        return null;
    L8:
        return Double.valueOf(Double.parseDouble(r4));
    }
}
