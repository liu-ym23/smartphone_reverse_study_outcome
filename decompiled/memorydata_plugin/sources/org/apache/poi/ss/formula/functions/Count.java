package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Count implements Function {
    private static final CountUtils.I_MatchPredicate defaultPredicate = null;
    private static final CountUtils.I_MatchPredicate subtotalPredicate = null;
    private static final CountUtils.I_MatchPredicate subtotalVisibleOnlyPredicate = null;
    private final CountUtils.I_MatchPredicate _predicate;

    static {
        defaultPredicate = $$Lambda$Count$nfptuBnWyehMpPTPTPmGfFjC9o4.INSTANCE;
        subtotalPredicate = new AnonymousClass1();
        subtotalVisibleOnlyPredicate = new AnonymousClass2();
    }

    public Count() {
        this._predicate = defaultPredicate;
    }

    private Count(CountUtils.I_MatchPredicate r3) {
        this._predicate = (CountUtils.I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r3, CountUtils.I_MatchPredicate.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ CountUtils.I_MatchPredicate access$000() {
        return defaultPredicate;
    }

    static /* synthetic */ boolean lambda$static$0(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, NumberEval.class) == false) goto L6;
        return true;
    L6:
        if (r3 != MissingArgEval.instance) goto L8;
        return true;
    L8:
        return false;
    }

    public static Count subtotalInstance(boolean r1) {
        if (r1 == false) goto L5;
        CountUtils.I_MatchPredicate r2 = subtotalPredicate;
    L7:
        return new Count(r2);
    L5:
        r2 = subtotalVisibleOnlyPredicate;
        goto L7
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r4, int r5, int r6) {
        int r7 = r4.length;
        if (r7 >= 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        if (r7 > 30) goto L9;
        int r8 = r4.length;
        int r9 = 0;
        int r0 = 0;
    L11:
        if (r9 >= r8) goto L14;
        r0 = r0 + CountUtils.countArg(r4[r9], this._predicate);
        r9 = r9 + 1;
        goto L11
    L14:
        return new NumberEval(r0);
    L9:
        return ErrorEval.VALUE_INVALID;
    }
}
