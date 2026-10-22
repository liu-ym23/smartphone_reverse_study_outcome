package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Match extends Var2or3ArgFunction {

    private static final class SingleValueVector implements LookupUtils.ValueVector {
        private final ValueEval _value;

        public SingleValueVector(ValueEval r3) {
            this._value = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int r3) {
            if (r3 != 0) goto L6;
            return this._value;
        L6:
            throw new RuntimeException("Invalid index (" + r3 + ") only zero is allowed");
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return 1;
        }
    }

    public Match() {
    }

    private static LookupUtils.LookupValueComparer createLookupComparer(ValueEval r2, boolean r3) {
        return LookupUtils.createLookupComparer((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, true);
    }

    private static ValueEval eval(int r2, int r3, ValueEval r4, ValueEval r5, double r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        boolean r9 = true;
        if (r6 != 0.0d) goto L5;
        boolean r1 = true;
    L6:
        if (r6 > 0.0d) goto L14;
        r9 = false;
    L14:
        return new NumberEval(((double) findIndexOfValue(OperandResolver.getSingleValue(r7, r2, r3), evaluateLookupRange(r8), r1, r9)) + 1.0d);
    L11:
        e = move-exception;
        return e.getErrorEval();
    L5:
        r1 = false;
        goto L6
    }

    private static LookupUtils.ValueVector evaluateLookupRange(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L11;
        RefEval r5 = (RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin");
        if (r5.getNumberOfSheets() != 1) goto L9;
        return new SingleValueVector(r5.getInnerValueEval(r5.getFirstSheetIndex()));
    L9:
        return LookupUtils.createVector(r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r4, TwoDEval.class) == false) goto L18;
        LookupUtils.ValueVector r6 = LookupUtils.createVector((TwoDEval) ZeusTransformUtils.preCheckCast(r4, TwoDEval.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L16;
        return r6;
    L16:
        throw new EvaluationException(ErrorEval.NA);
    L18:
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r4, StringEval.class) == false) goto L28;
        if (OperandResolver.parseDouble(((StringEval) ZeusTransformUtils.preCheckCast(r4, StringEval.class, "com.obric.memorydata.plugin")).getStringValue()) != null) goto L26;
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L26:
        throw new EvaluationException(ErrorEval.NA);
    L28:
        throw new RuntimeException("Unexpected eval type (" + r4 + ")");
    L30:
        throw new EvaluationException(ErrorEval.NA);
    }

    private static double evaluateMatchTypeArg(ValueEval r2, int r3, int r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, NumericValueEval.class) == false) goto L9;
        return ((NumericValueEval) ZeusTransformUtils.preCheckCast(r5, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L9:
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == false) goto L17;
        Double r6 = OperandResolver.parseDouble(((StringEval) ZeusTransformUtils.preCheckCast(r5, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
        if (r6 == null) goto L15;
        return r6.doubleValue();
    L15:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L17:
        if (ZeusTransformUtils.instanceOf(r5, MissingArgEval.class) == false) goto L19;
        return 1.0d;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, BlankEval.class) == false) goto L22;
        return 1.0d;
    L22:
        throw new RuntimeException("Unexpected match_type type (" + r5.getClass().getName() + ")");
    L26:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin"));
    }

    private static int findIndexOfValue(ValueEval r3, LookupUtils.ValueVector r4, boolean r5, boolean r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        LookupUtils.ValueVector r8 = (LookupUtils.ValueVector) ZeusTransformUtils.wrapperContextForParams(r4, LookupUtils.ValueVector.class, "com.obric.memorydata.plugin");
        LookupUtils.LookupValueComparer r9 = createLookupComparer(r7, r5);
        int r0 = r8.getSize();
        int r1 = 0;
        if (r5 == false) goto L12;
    L4:
        if (r1 >= r0) goto L10;
        if (r9.compareTo(r8.getItem(r1)).isEqual() == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L10:
        throw new EvaluationException(ErrorEval.NA);
    L12:
        if (r6 == false) goto L24;
        int r2 = r0 - 1;
    L14:
        if (r2 < 0) goto L23;
        LookupUtils.CompareResult r10 = r9.compareTo(r8.getItem(r2));
        if (r10.isTypeMismatch() == true) goto L21;
        if (r10.isLessThan() == true) goto L21;
        return r2;
    L21:
        r2 = r2 - 1;
        goto L14
    L23:
        throw new EvaluationException(ErrorEval.NA);
    L24:
        if (r1 >= r0) goto L37;
        LookupUtils.CompareResult r11 = r9.compareTo(r8.getItem(r1));
        if (r11.isEqual() == true) goto L27;
        if (r11.isGreaterThan() == true) goto L30;
        r1 = r1 + 1;
        goto L24
    L30:
        if (r1 < 1) goto L34;
        return r1 - 1;
    L34:
        throw new EvaluationException(ErrorEval.NA);
    L27:
        return r1;
    L37:
        return r0 - 1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r8, int r9, ValueEval r10, ValueEval r11) {
        return eval(r8, r9, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r10, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin"), 1.0d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r8, int r9, ValueEval r10, ValueEval r11, ValueEval r12) {
        return eval(r8, r9, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r10, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin"), evaluateMatchTypeArg((ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), r8, r9));
    L7:
        return ErrorEval.REF_INVALID;
    }
}
