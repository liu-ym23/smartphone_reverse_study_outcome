package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DataFormatter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TextFunction implements Function {
    public static final Function CHAR = null;
    public static final Function CLEAN = null;
    public static final FreeRefFunction CONCAT = null;
    public static final Function CONCATENATE = null;
    public static final Function EXACT = null;
    public static final Function FIND = null;
    public static final Function LEFT = null;
    public static final Function LEN = null;
    public static final Function LOWER = null;
    public static final Function MID = null;
    public static final Function PROPER = null;
    public static final Function RIGHT = null;
    public static final Function SEARCH = null;
    public static final Function TEXT = null;
    public static final Function TRIM = null;
    public static final Function UPPER = null;
    protected static final DataFormatter formatter = null;

    private static final class LeftRight extends Var1or2ArgFunction {
        private static final ValueEval DEFAULT_ARG1 = null;
        private final boolean _isLeft;

        static {
            DEFAULT_ARG1 = new NumberEval(1.0d);
        }

        public LeftRight(boolean r1) {
            this._isLeft = r1;
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5) {
            return evaluate(r3, r4, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), DEFAULT_ARG1);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
            ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
            String r9 = TextFunction.evaluateStringArg(r7, r3, r4);     // Catch: EvaluationException -> L13
            int r10 = TextFunction.evaluateIntArg(r8, r3, r4);     // Catch: EvaluationException -> L13
            if (r10 >= 0) goto L8;
            return ErrorEval.VALUE_INVALID;
        L8:
            if (this._isLeft == false) goto L10;
            String r2 = r9.substring(0, Math.min(r9.length(), r10));
        L12:
            return new StringEval(r2);
        L10:
            r2 = r9.substring(Math.max(0, r9.length() - r10));
        L13:
            e = move-exception;
            return e.getErrorEval();
        }
    }

    private static final class SearchFind extends Var2or3ArgFunction {
        private final boolean _isCaseSensitive;

        public SearchFind(boolean r1) {
            this._isCaseSensitive = r1;
        }

        private ValueEval eval(String r3, String r4, int r5) {
            if (this._isCaseSensitive == false) goto L5;
            int r2 = r3.indexOf(r4, r5);
        L7:
            if (r2 != (-1)) goto L11;
            return ErrorEval.VALUE_INVALID;
        L11:
            return new NumberEval(((double) r2) + 1.0d);
        L5:
            r2 = r3.toUpperCase(Locale.ROOT).indexOf(r4.toUpperCase(Locale.ROOT), r5);
            goto L7
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
            ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
            String r9 = TextFunction.evaluateStringArg(r7, r3, r4);     // Catch: EvaluationException -> L5
            return eval(TextFunction.evaluateStringArg(r8, r3, r4), r9, 0);
        L5:
            e = move-exception;
            return e.getErrorEval();
        }

        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6, ValueEval r7) {
            ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
            ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
            String r11 = TextFunction.evaluateStringArg(r8, r3, r4);     // Catch: EvaluationException -> L9
            String r12 = TextFunction.evaluateStringArg(r9, r3, r4);     // Catch: EvaluationException -> L9
            int r13 = TextFunction.evaluateIntArg(r10, r3, r4) - 1;     // Catch: EvaluationException -> L9
            if (r13 >= 0) goto L8;
            return ErrorEval.VALUE_INVALID;
        L8:
            return eval(r12, r11, r13);
        L9:
            e = move-exception;
            return e.getErrorEval();
        }
    }

    private static abstract class SingleArgTextFunc extends Fixed1ArgFunction {
        public SingleArgTextFunc() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5) {
            return evaluate(TextFunction.evaluateStringArg((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
        L6:
            e = move-exception;
            return e.getErrorEval();
        }

        public abstract ValueEval evaluate(String r1);
    }

    static {
        formatter = new DataFormatter();
        CHAR = new AnonymousClass1();
        LEN = new AnonymousClass2();
        LOWER = new AnonymousClass3();
        UPPER = new AnonymousClass4();
        PROPER = new AnonymousClass5();
        TRIM = new AnonymousClass6();
        CLEAN = new AnonymousClass7();
        MID = new AnonymousClass8();
        LEFT = new LeftRight(true);
        RIGHT = new LeftRight(false);
        CONCAT = $$Lambda$TextFunction$Hw7dBebwodDdQgSEw7mKPGE3Utc.INSTANCE;
        CONCATENATE = $$Lambda$TextFunction$DMDui_t7CZldInAEtC5Uca40Ljs.INSTANCE;
        EXACT = new AnonymousClass9();
        TEXT = new AnonymousClass10();
        FIND = new SearchFind(true);
        SEARCH = new SearchFind(false);
    }

    public static double evaluateDoubleArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    public static int evaluateIntArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    public static String evaluateStringArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    static /* synthetic */ ValueEval lambda$static$0(ValueEval[] r10, OperationEvaluationContext r11) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L21;
        ValueEval r4 = r10[r3];
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L15;
        AreaEval r5 = (AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L17
        int r6 = 0;
    L9:
        if (r6 >= r5.getHeight()) goto L16;
        int r7 = 0;
    L12:
        if (r7 >= r5.getWidth()) goto L14;
        r0.append(evaluateStringArg(r5.getRelativeValue(r6, r7), r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L17
        r7 = r7 + 1;     // Catch: EvaluationException -> L17
        goto L12
    L14:
        r6 = r6 + 1;     // Catch: EvaluationException -> L17
    L16:
        r3 = r3 + 1;
        goto L3
    L15:
        r0.append(evaluateStringArg(r4, r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L17
    L17:
        e = move-exception;
        return e.getErrorEval();
    L21:
        return new StringEval(r0.toString());
    }

    static /* synthetic */ ValueEval lambda$static$1(ValueEval[] r4, int r5, int r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        r0.append(evaluateStringArg(r4[r2], r5, r6));     // Catch: EvaluationException -> L7
        r2 = r2 + 1;
    L7:
        e = move-exception;
        return e.getErrorEval();
    L11:
        return new StringEval(r0.toString());
    }
}
