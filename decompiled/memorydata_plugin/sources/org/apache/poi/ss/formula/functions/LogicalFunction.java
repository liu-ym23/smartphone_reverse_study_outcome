package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LogicalFunction extends Fixed1ArgFunction implements ArrayFunction {
    public static final Function ISBLANK = null;
    public static final Function ISERR = null;
    public static final Function ISERROR = null;
    public static final Function ISLOGICAL = null;
    public static final Function ISNA = null;
    public static final Function ISNONTEXT = null;
    public static final Function ISNUMBER = null;
    public static final Function ISREF = null;
    public static final Function ISTEXT = null;

    static {
        ISLOGICAL = new AnonymousClass1();
        ISNONTEXT = new AnonymousClass2();
        ISNUMBER = new AnonymousClass3();
        ISTEXT = new AnonymousClass4();
        ISBLANK = new AnonymousClass5();
        ISERROR = new AnonymousClass6();
        ISERR = new AnonymousClass7();
        ISNA = new AnonymousClass8();
        ISREF = new AnonymousClass9();
    }

    public LogicalFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5) {
        ValueEval r6 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);     // Catch: EvaluationException -> L5
    L8:
        return BoolEval.valueOf(evaluate(r6));
    L5:
        e = move-exception;
        r6 = e.getErrorEval();
        goto L8
    }

    public abstract boolean evaluate(ValueEval r1);

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r3, int r4, int r5) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluateOneArrayArg(r3[0], r4, r5, new $$Lambda$LogicalFunction$T5vi7AWnlgwcGzdQa64b9vEejU(this));
    }

    public /* synthetic */ ValueEval lambda$evaluateArray$0$LogicalFunction(ValueEval r3) {
        return BoolEval.valueOf(evaluate((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin")));
    }
}
