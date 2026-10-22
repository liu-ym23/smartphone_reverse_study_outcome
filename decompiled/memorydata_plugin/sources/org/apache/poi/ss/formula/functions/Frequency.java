package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Frequency extends Fixed2ArgFunction {
    public static final Function instance = null;

    static {
        instance = new Frequency();
    }

    private Frequency() {
    }

    static int findBin(double r0, double[] r2) {
        int r1 = Arrays.binarySearch(r2, r0);
        if (r1 < 0) goto L6;
        return r1 + 1;
    L6:
        return -r1;
    }

    static int[] histogram(double[] r5, double[] r6) {
        int[] r0 = new int[r6.length + 1];
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = findBin(r5[r2], r6) - 1;
        r0[r3] = r0[r3] + 1;
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    static /* synthetic */ NumberEval[] lambda$evaluate$0(int r0) {
        return new NumberEval[r0];
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r10, int r11, ValueEval r12, ValueEval r13) {
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r14 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin");
        MatrixFunction.MutableValueCollector r15 = new MatrixFunction.MutableValueCollector(false, false);
        NumberEval[] r8 = (NumberEval[]) ZeusTransformUtils.preCheckCast(Arrays.stream(histogram(r15.collectValues(new ValueEval[]{r9}), r15.collectValues(new ValueEval[]{r14}))).boxed().map($$Lambda$sjWjqTPyyeWFn_cWF6tYM59doJU.INSTANCE).toArray($$Lambda$Frequency$vAt2D1u4vKevfPP1ho1L6892M.INSTANCE), NumberEval[].class, "com.obric.memorydata.plugin");
        return new CacheAreaEval(r10, r11, (r8.length + r10) - 1, r11, r8);
    L6:
        e = move-exception;
        return e.getErrorEval();
    }
}
