package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Countblank extends Fixed1ArgFunction {
    private static final CountUtils.I_MatchPredicate predicate = null;

    static {
        predicate = $$Lambda$Countblank$yoK4tMVKrprkgY0c1ZZUA0muL2M.INSTANCE;
    }

    public Countblank() {
    }

    static /* synthetic */ boolean lambda$static$0(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r3 != BlankEval.instance) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, StringEval.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (((StringEval) ZeusTransformUtils.preCheckCast(r3, StringEval.class, "com.obric.memorydata.plugin")).getStringValue().isEmpty() == false) goto L9;
        goto L9
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, RefEval.class) == false) goto L7;
        int r4 = CountUtils.countMatchingCellsInRef((RefEval) ZeusTransformUtils.preCheckCast(r0, RefEval.class, "com.obric.memorydata.plugin"), predicate);
    L10:
        return new NumberEval(r4);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, ThreeDEval.class) == false) goto L12;
        r4 = CountUtils.countMatchingCellsInArea((ThreeDEval) ZeusTransformUtils.preCheckCast(r0, ThreeDEval.class, "com.obric.memorydata.plugin"), predicate);
        goto L10
    L12:
        throw new IllegalArgumentException("Bad range arg type (" + r0.getClass().getName() + ")");
    }
}
