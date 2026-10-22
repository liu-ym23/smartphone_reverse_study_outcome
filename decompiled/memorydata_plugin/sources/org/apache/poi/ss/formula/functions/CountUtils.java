package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class CountUtils {

    public interface I_MatchAreaPredicate extends I_MatchPredicate {
        boolean matches(TwoDEval r1, int r2, int r3);
    }

    public interface I_MatchPredicate {
        boolean matches(ValueEval r1);
    }

    public static int countArg(ValueEval r2, I_MatchPredicate r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        I_MatchPredicate r5 = (I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r3, I_MatchPredicate.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        if (ZeusTransformUtils.instanceOf(r4, ThreeDEval.class) == false) goto L9;
        return countMatchingCellsInArea((ThreeDEval) ZeusTransformUtils.preCheckCast(r4, ThreeDEval.class, "com.obric.memorydata.plugin"), r5);
    L9:
        if (ZeusTransformUtils.instanceOf(r4, TwoDEval.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L15;
        return countMatchingCellsInRef((RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin"), r5);
    L15:
        return r5.matches(r4) ? 1 : 0;
    L17:
        throw new IllegalArgumentException("Count requires 3D Evals, 2D ones aren't supported");
    L19:
        throw new IllegalArgumentException("eval must not be null");
    }

    public static int countMatchingCellsInArea(ThreeDEval r11, I_MatchPredicate r12) {
        ThreeDEval r13 = (ThreeDEval) ZeusTransformUtils.wrapperContextForParams(r11, ThreeDEval.class, "com.obric.memorydata.plugin");
        I_MatchPredicate r14 = (I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r12, I_MatchPredicate.class, "com.obric.memorydata.plugin");
        int r0 = r13.getFirstSheetIndex();
        int r2 = r13.getLastSheetIndex();
        int r4 = 0;
    L3:
        if (r0 > r2) goto L19;
        int r5 = r13.getHeight();
        int r6 = r13.getWidth();
        int r7 = 0;
    L5:
        if (r7 >= r5) goto L18;
        int r8 = 0;
    L7:
        if (r8 >= r6) goto L17;
        ValueEval r9 = r13.getValue(r0, r7, r8);
        if (ZeusTransformUtils.instanceOf(r14, I_MatchAreaPredicate.class) == false) goto L14;
        if (((I_MatchAreaPredicate) ZeusTransformUtils.preCheckCast(r14, I_MatchAreaPredicate.class, "com.obric.memorydata.plugin")).matches(r13, r7, r8) == true) goto L14;
    L16:
        r8 = r8 + 1;
    L14:
        if (r14.matches(r9) == false) goto L16;
        r4 = r4 + 1;
        goto L16
    L17:
        r7 = r7 + 1;
        goto L5
    L18:
        r0 = r0 + 1;
        goto L3
    L19:
        return r4;
    }

    public static int countMatchingCellsInRef(RefEval r4, I_MatchPredicate r5) {
        RefEval r6 = (RefEval) ZeusTransformUtils.wrapperContextForParams(r4, RefEval.class, "com.obric.memorydata.plugin");
        I_MatchPredicate r7 = (I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r5, I_MatchPredicate.class, "com.obric.memorydata.plugin");
        int r0 = r6.getFirstSheetIndex();
        int r1 = r6.getLastSheetIndex();
        int r2 = 0;
    L3:
        if (r0 > r1) goto L8;
        if (r7.matches(r6.getInnerValueEval(r0)) == false) goto L7;
        r2 = r2 + 1;
    L7:
        r0 = r0 + 1;
        goto L3
    L8:
        return r2;
    }
}
