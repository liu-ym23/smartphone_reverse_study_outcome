package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.util.NumberComparer;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RelationalOperationEval extends Fixed2ArgFunction implements ArrayFunction {
    public static final Function EqualEval = null;
    public static final Function GreaterEqualEval = null;
    public static final Function GreaterThanEval = null;
    public static final Function LessEqualEval = null;
    public static final Function LessThanEval = null;
    public static final Function NotEqualEval = null;

    static {
        EqualEval = new AnonymousClass1();
        GreaterEqualEval = new AnonymousClass2();
        GreaterThanEval = new AnonymousClass3();
        LessEqualEval = new AnonymousClass4();
        LessThanEval = new AnonymousClass5();
        NotEqualEval = new AnonymousClass6();
    }

    public RelationalOperationEval() {
    }

    private static int compareBlank(ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 != BlankEval.instance) goto L5;
    L26:
        return 0;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, MissingArgEval.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == false) goto L14;
        if (((BoolEval) ZeusTransformUtils.preCheckCast(r5, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue() == true) goto L12;
        return 0;
    L12:
        return -1;
    L14:
        if (ZeusTransformUtils.instanceOf(r5, NumberEval.class) == false) goto L18;
        return NumberComparer.compare(0.0d, ((NumberEval) ZeusTransformUtils.preCheckCast(r5, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L18:
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == false) goto L25;
        if (((StringEval) ZeusTransformUtils.preCheckCast(r5, StringEval.class, "com.obric.memorydata.plugin")).getStringValue().length() >= 1) goto L23;
        return 0;
    L23:
        return -1;
    L25:
        throw new IllegalArgumentException("bad value class (" + r5.getClass().getName() + ")");
    }

    private static int doCompare(ValueEval r4, ValueEval r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        if (r6 == BlankEval.instance) goto L49;
        if (ZeusTransformUtils.instanceOf(r6, MissingArgEval.class) == true) goto L49;
        if (r7 == BlankEval.instance) goto L47;
        if (ZeusTransformUtils.instanceOf(r7, MissingArgEval.class) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r6, BoolEval.class) == false) goto L26;
        if (ZeusTransformUtils.instanceOf(r7, BoolEval.class) == false) goto L50;
        BoolEval r8 = (BoolEval) ZeusTransformUtils.preCheckCast(r6, BoolEval.class, "com.obric.memorydata.plugin");
        if (r8.getBooleanValue() != ((BoolEval) ZeusTransformUtils.preCheckCast(r7, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue()) goto L21;
        return 0;
    L21:
        if (r8.getBooleanValue() == false) goto L24;
        return 1;
    L24:
        return -1;
    L50:
        return 1;
    L26:
        if (ZeusTransformUtils.instanceOf(r7, BoolEval.class) == false) goto L29;
        return -1;
    L29:
        if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == false) goto L36;
        if (ZeusTransformUtils.instanceOf(r7, StringEval.class) == true) goto L33;
        return 1;
    L33:
        return ((StringEval) ZeusTransformUtils.preCheckCast(r6, StringEval.class, "com.obric.memorydata.plugin")).getStringValue().compareToIgnoreCase(((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
    L36:
        if (ZeusTransformUtils.instanceOf(r7, StringEval.class) == false) goto L39;
        return -1;
    L39:
        if (ZeusTransformUtils.instanceOf(r6, NumberEval.class) == false) goto L45;
        if (ZeusTransformUtils.instanceOf(r7, NumberEval.class) == false) goto L45;
        return NumberComparer.compare(((NumberEval) ZeusTransformUtils.preCheckCast(r6, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue(), ((NumberEval) ZeusTransformUtils.preCheckCast(r7, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L45:
        throw new IllegalArgumentException("Bad operand types (" + r6.getClass().getName() + "), (" + r7.getClass().getName() + ")");
    L47:
        return -compareBlank(r6);
    L49:
        return compareBlank(r7);
    }

    public abstract boolean convertComparisonResult(int r1);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        return BoolEval.valueOf(convertComparisonResult(doCompare(OperandResolver.getSingleValue(r7, r3, r4), OperandResolver.getSingleValue(r8, r3, r4))));
    L6:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r8, int r9, int r10) {
        return evaluateTwoArrayArgs(r8[0], r8[1], r9, r10, new $$Lambda$RelationalOperationEval$WCHBZEakTQTSa1iC_W2LQ9nNMJI(this));
    }

    public /* synthetic */ ValueEval lambda$evaluateArray$0$RelationalOperationEval(ValueEval r3, ValueEval r4) {
        return BoolEval.valueOf(convertComparisonResult(doCompare((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"))));
    }
}
