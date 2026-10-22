package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class MatrixFunction implements Function {
    public static final Function MDETERM = null;
    public static final Function MINVERSE = null;
    public static final Function MMULT = null;
    public static final Function TRANSPOSE = null;

    private static class Mdeterm extends OneArrayArg {
        private final MutableValueCollector instance;

        public Mdeterm() {
            MutableValueCollector r0 = new MutableValueCollector(false, false);
            this.instance = r0;
            r0.setBlankEvalPolicy(MultiOperandNumericFunction.Policy.ERROR);
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[] collectValues(ValueEval r5) {
            ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            double[] r0 = this.instance.collectValues(new ValueEval[]{r6});
            if (ZeusTransformUtils.instanceOf(r6, AreaEval.class) == false) goto L10;
            if (r0.length != 1) goto L10;
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        L10:
            return this.instance.collectValues(new ValueEval[]{r6});
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[][] evaluate(double[][] r4) {
            if (r4.length != r4[0].length) goto L7;
            double[][] r3 = (double[][]) Array.newInstance(double.class, new int[]{1, 1});
            Array2DRowRealMatrix r1 = new Array2DRowRealMatrix(r4);
            r3[0][0] = new LUDecomposition(r1).getDeterminant();
            return r3;
        L7:
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
    }

    public static final class MutableValueCollector extends MultiOperandNumericFunction {
        public MutableValueCollector(boolean r1, boolean r2) {
            super(r1, r2);
        }

        public double[] collectValues(ValueEval... r1) {
            return getNumberArray(r1);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] r1) {
            throw new IllegalStateException("should not be called");
        }
    }

    public static abstract class OneArrayArg extends Fixed1ArgFunction {
        public OneArrayArg() {
        }

        public abstract double[] collectValues(ValueEval r1);

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int r11, int r12, ValueEval r13) {
            ValueEval r14 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r14, AreaEval.class) == false) goto L26;
            double[][] r10 = evaluate(MatrixFunction.access$000(collectValues(r14), ((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getHeight(), ((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getWidth()));     // Catch: EvaluationException -> L15
            int r15 = r10[0].length;     // Catch: EvaluationException -> L15
            int r16 = r10.length;     // Catch: EvaluationException -> L15
            double[] r17 = MatrixFunction.access$100(r10);     // Catch: EvaluationException -> L15
            MatrixFunction.checkValues(r17);     // Catch: EvaluationException -> L15
            ValueEval[] r9 = new ValueEval[r17.length];
            int r0 = 0;
        L7:
            if (r0 >= r17.length) goto L10;
            r9[r0] = new NumberEval(r17[r0]);
            r0 = r0 + 1;
            goto L7
        L10:
            if (r17.length != 1) goto L14;
            return r9[0];
        L14:
            return new CacheAreaEval(((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getFirstRow(), ((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getFirstColumn(), (((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getFirstRow() + r16) - 1, (((AreaEval) ZeusTransformUtils.preCheckCast(r14, AreaEval.class, "com.obric.memorydata.plugin")).getFirstColumn() + r15) - 1, r9);
        L15:
            e = move-exception;
            return e.getErrorEval();
        L26:
            double[][] r18 = evaluate(new double[][]{new double[]{NumericFunction.singleOperandEvaluate(r14, r11, r12)}});     // Catch: EvaluationException -> L21
            NumericFunction.checkValue(r18[0][0]);     // Catch: EvaluationException -> L21
            return new NumberEval(r18[0][0]);
        L21:
            e = move-exception;
            return e.getErrorEval();
        }

        public abstract double[][] evaluate(double[][] r1);
    }

    public static abstract class TwoArrayArg extends Fixed2ArgFunction {
        public TwoArrayArg() {
        }

        public abstract double[] collectValues(ValueEval r1);

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int r11, int r12, ValueEval r13, ValueEval r14) {
            ValueEval r15 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin");
            ValueEval r16 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r14, ValueEval.class, "com.obric.memorydata.plugin");
        L40:
            e = move-exception;
            return e.getErrorEval();
        L5:
            if (ZeusTransformUtils.instanceOf(r15, AreaEval.class) == true) goto L50;
            double[][] r0 = {new double[]{NumericFunction.singleOperandEvaluate(r15, r11, r12)}};     // Catch: EvaluationException -> L35 IllegalArgumentException -> L38
        L13:
            if (ZeusTransformUtils.instanceOf(r16, AreaEval.class) == false) goto L48;
            double[][] r17 = MatrixFunction.access$000(collectValues(r16), ((AreaEval) ZeusTransformUtils.preCheckCast(r16, AreaEval.class, "com.obric.memorydata.plugin")).getHeight(), ((AreaEval) ZeusTransformUtils.preCheckCast(r16, AreaEval.class, "com.obric.memorydata.plugin")).getWidth());     // Catch: EvaluationException -> L16 IllegalArgumentException -> L38
        L21:
            double[][] r10 = evaluate(r0, r17);     // Catch: IllegalArgumentException -> L38 EvaluationException -> L40
            int r18 = r10[0].length;     // Catch: IllegalArgumentException -> L38 EvaluationException -> L40
            int r19 = r10.length;     // Catch: IllegalArgumentException -> L38 EvaluationException -> L40
            double[] r110 = MatrixFunction.access$100(r10);     // Catch: IllegalArgumentException -> L38 EvaluationException -> L40
            MatrixFunction.checkValues(r110);     // Catch: IllegalArgumentException -> L38 EvaluationException -> L40
            ValueEval[] r9 = new ValueEval[r110.length];
            int r111 = 0;
        L24:
            if (r111 >= r110.length) goto L27;
            r9[r111] = new NumberEval(r110[r111]);
            r111 = r111 + 1;
            goto L24
        L27:
            if (r110.length != 1) goto L31;
            return r9[0];
        L31:
            return new CacheAreaEval(((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getFirstRow(), ((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getFirstColumn(), (((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getFirstRow() + r19) - 1, (((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getFirstColumn() + r18) - 1, r9);
        L16:
            e = move-exception;
            return e.getErrorEval();
        L48:
            r17 = new double[][]{new double[]{NumericFunction.singleOperandEvaluate(r16, r11, r12)}};     // Catch: EvaluationException -> L32 IllegalArgumentException -> L38
        L32:
            e = move-exception;
            return e.getErrorEval();
        L35:
            e = move-exception;
            return e.getErrorEval();
        L50:
            r0 = MatrixFunction.access$000(collectValues(r15), ((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getHeight(), ((AreaEval) ZeusTransformUtils.preCheckCast(r15, AreaEval.class, "com.obric.memorydata.plugin")).getWidth());     // Catch: EvaluationException -> L8 IllegalArgumentException -> L38
        L8:
            e = move-exception;
            return e.getErrorEval();
        L39:
            return ErrorEval.VALUE_INVALID;
        }

        public abstract double[][] evaluate(double[][] r1, double[][] r2);
    }

    static {
        MINVERSE = new AnonymousClass1();
        TRANSPOSE = new AnonymousClass2();
        MDETERM = new Mdeterm();
        MMULT = new AnonymousClass3();
    }

    static /* synthetic */ double[][] access$000(double[] r0, int r1, int r2) {
        return fillDoubleArray(r0, r1, r2);
    }

    static /* synthetic */ double[] access$100(double[][] r0) {
        return extractDoubleArray(r0);
    }

    public static void checkValues(double[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        double r2 = r5[r1];
        if (Double.isNaN(r2) == true) goto L10;
        if (Double.isInfinite(r2) == true) goto L10;
        r1 = r1 + 1;
    L10:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    private static double[] extractDoubleArray(double[][] r10) {
        if (r10 == null) goto L16;
        if (r10.length < 1) goto L16;
        if (r10[0].length < 1) goto L16;
        double[] r1 = new double[r10.length * r10[0].length];
        int r2 = r10.length;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r2) goto L14;
        double[] r5 = r10[r3];
        int r6 = 0;
    L11:
        if (r6 >= r10[0].length) goto L13;
        r1[r4] = r5[r6];
        r6 = r6 + 1;
        r4 = r4 + 1;
        goto L11
    L13:
        r3 = r3 + 1;
        goto L8
    L14:
        return r1;
    L16:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static double[][] fillDoubleArray(double[] r8, int r9, int r10) {
        if (r9 < 1) goto L20;
        if (r10 < 1) goto L20;
        if (r8.length < 1) goto L20;
        double[][] r11 = (double[][]) Array.newInstance(double.class, new int[]{r9, r10});
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r1 >= r0) goto L18;
        double r4 = r8[r1];
        if (r2 >= r11.length) goto L17;
        if (r3 != r11[0].length) goto L15;
        r2 = r2 + 1;
        r3 = 0;
    L15:
        if (r2 >= r11.length) goto L17;
        r11[r2][r3] = r4;
        r3 = r3 + 1;
    L17:
        r1 = r1 + 1;
        goto L8
    L18:
        return r11;
    L20:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
