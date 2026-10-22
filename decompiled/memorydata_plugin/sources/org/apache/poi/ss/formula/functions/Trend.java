package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Trend implements Function {

    private static final class TrendResults {
        private final int resultHeight;
        private final int resultWidth;
        private final double[] vals;

        public TrendResults(double[] r1, int r2, int r3) {
            this.vals = r1;
            this.resultWidth = r2;
            this.resultHeight = r3;
        }

        static /* synthetic */ double[] access$000(TrendResults r0) {
            return r0.vals;
        }

        static /* synthetic */ int access$100(TrendResults r0) {
            return r0.resultHeight;
        }

        static /* synthetic */ int access$200(TrendResults r0) {
            return r0.resultWidth;
        }
    }

    public Trend() {
    }

    private static double[][] evalToArray(ValueEval r11) {
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, MissingArgEval.class) == false) goto L7;
        return (double[][]) Array.newInstance(double.class, new int[]{0, 0});
    L7:
        if (ZeusTransformUtils.instanceOf(r12, RefEval.class) == false) goto L13;
        RefEval r13 = (RefEval) ZeusTransformUtils.preCheckCast(r12, RefEval.class, "com.obric.memorydata.plugin");
        if (r13.getNumberOfSheets() > 1) goto L12;
        r12 = r13.getInnerValueEval(r13.getFirstSheetIndex());
        goto L13
    L12:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L13:
        if (r12 == null) goto L33;
        if (ZeusTransformUtils.instanceOf(r12, AreaEval.class) == false) goto L27;
        AreaEval r14 = (AreaEval) ZeusTransformUtils.preCheckCast(r12, AreaEval.class, "com.obric.memorydata.plugin");
        int r1 = r14.getWidth();
        int r6 = r14.getHeight();
        double[][] r0 = (double[][]) Array.newInstance(double.class, new int[]{r6, r1});
        int r3 = 0;
    L17:
        if (r3 >= r6) goto L37;
        int r4 = 0;
    L19:
        if (r4 >= r1) goto L25;
        ValueEval r7 = r14.getRelativeValue(r3, r4);
        if (ZeusTransformUtils.instanceOf(r7, NumericValueEval.class) == false) goto L24;
        r0[r3][r4] = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r7, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        r4 = r4 + 1;
        goto L19
    L24:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L25:
        r3 = r3 + 1;
        goto L17
    L37:
        return r0;
    L27:
        if (ZeusTransformUtils.instanceOf(r12, NumericValueEval.class) == false) goto L31;
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{1, 1});
        r2[0][0] = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r12, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        return r2;
    L31:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L33:
        throw new RuntimeException("Parameter may not be null.");
    }

    private static double[] flattenArray(double[][] r6) {
        if (r6.length < 1) goto L5;
        double[] r0 = new double[r6.length * r6[0].length];
        int r1 = 0;
    L8:
        if (r1 >= r6.length) goto L10;
        System.arraycopy(r6[r1], 0, r0, r6[0].length * r1, r6[0].length);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return new double[0];
    }

    private static double[][] flattenArrayToRow(double[][] r7) {
        if (r7.length < 1) goto L5;
        double[][] r0 = (double[][]) Array.newInstance(double.class, new int[]{r7.length * r7[0].length, 1});
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L14;
        int r2 = 0;
    L11:
        if (r2 >= r7[0].length) goto L13;
        r0[(r7[0].length * r1) + r2][0] = r7[r1][r2];
        r2 = r2 + 1;
        goto L11
    L13:
        r1 = r1 + 1;
        goto L8
    L14:
        return r0;
    L5:
        return (double[][]) Array.newInstance(double.class, new int[]{0, 0});
    }

    private static double[][] getDefaultArrayOneD(int r8) {
        double[][] r0 = (double[][]) Array.newInstance(double.class, new int[]{r8, 1});
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L5;
        r0[r2][0] = ((double) r2) + 1.0d;
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static TrendResults getNewY(ValueEval[] r18) {
        int r2 = r18.length;
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L6;
        double[][] r3 = evalToArray(r18[0]);
        double[][] r7 = evalToArray(r18[1]);
        Object r0 = Array.newInstance(double.class, new int[]{0, 0});
    L19:
        double[][] r8 = (double[][]) r0;
    L20:
        boolean r1 = false;
    L22:
        if (r3.length < 1) goto L129;
        double[] r6 = flattenArray(r3);
        if (r8.length <= 0) goto L26;
        double[][] r4 = r8;
    L28:
        if (r6.length == 1) goto L127;
        if (r3.length == 1) goto L54;
        if (r3[0].length == 1) goto L54;
        if (r7.length >= 1) goto L39;
        double[][] r5 = getDefaultArrayOneD(r6.length);
        if (r8.length >= 1) goto L43;
        r4 = r3;
    L43:
        if (r8.length <= 0) goto L45;
        double[][] r10 = flattenArrayToRow(r8);
    L47:
        if (r6.length != r5.length) goto L52;
        if (r3.length != r7.length) goto L52;
    L78:
        if (r8.length >= 1) goto L81;
        r10 = r5;
    L90:
        if (r10[0].length != r5[0].length) goto L125;
        if (r5[0].length >= r5.length) goto L123;
        int r9 = r4.length;
        int r11 = r4[0].length;
        if (isAllColumnsSame(r5) == false) goto L97;
        double[] r12 = new double[r10.length];
        Arrays.fill(r12, Arrays.stream(r6).average().orElse(0.0d));
        return new TrendResults(r12, r11, r9);
    L97:
        OLSMultipleLinearRegression r13 = new OLSMultipleLinearRegression();
        if (r1 == false) goto L132;
        r13.setNoIntercept(true);
    L132:
        r13.newSampleData(r6, r5);     // Catch: IllegalArgumentException -> L120
        double[] r14 = r13.estimateRegressionParameters();     // Catch: SingularMatrixException -> L118
        double[] r15 = new double[r10.length];
        int r16 = 0;
    L104:
        if (r16 >= r10.length) goto L117;
        r15[r16] = 0.0d;
        if (r1 == false) goto L111;
        int r17 = 0;
    L109:
        if (r17 >= r14.length) goto L115;
        r15[r16] = r15[r16] + (r14[r17] * r10[r16][r17]);
        r17 = r17 + 1;
    L115:
        r16 = r16 + 1;
        goto L104
    L111:
        r15[r16] = r14[0];
        int r19 = 1;
    L113:
        if (r19 >= r14.length) goto L115;
        r15[r16] = r15[r16] + (r14[r19] * r10[r16][r19 - 1]);
        r19 = r19 + 1;
        goto L113
    L117:
        return new TrendResults(r15, r11, r9);
    L119:
        throw new NotImplementedException("Singular matrix in input");
    L121:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    L123:
        throw new NotImplementedException("Sample size too small");
    L125:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    L81:
        if (r8.length != 1) goto L90;
        if (r8[0].length <= 1) goto L90;
        if (r7.length <= 1) goto L90;
        if (r7[0].length != 1) goto L90;
        r10 = switchRowsColumns(r8);
    L52:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    L45:
        r10 = r8;
        goto L47
    L39:
        r5 = flattenArrayToRow(r7);
        if (r8.length >= 1) goto L43;
        r4 = r7;
    L54:
        if (r7.length >= 1) goto L60;
        r5 = getDefaultArrayOneD(r6.length);
        if (r8.length < 1) goto L70;
    L58:
        r3 = r4;
    L70:
        if (r8.length > 0) goto L72;
    L76:
        r4 = r3;
        r10 = r8;
        goto L78
    L72:
        if (r5.length != 1) goto L74;
    L75:
        r10 = flattenArrayToRow(r8);
        r4 = r3;
        goto L78
    L74:
        if (r5[0].length != 1) goto L76;
    L60:
        if (r7[0].length > 1) goto L62;
    L64:
        double[][] r20 = r7;
    L66:
        if (r8.length >= 1) goto L68;
        r5 = r20;
        r3 = r7;
        goto L70
    L68:
        r5 = r20;
        goto L58
    L62:
        if (r3.length != 1) goto L64;
        r20 = switchRowsColumns(r7);
        goto L66
    L127:
        throw new NotImplementedException("Sample size too small");
    L26:
        r4 = (double[][]) Array.newInstance(double.class, new int[]{1, 1});
        goto L28
    L129:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L6:
        if (r2 != 3) goto L8;
        r3 = evalToArray(r18[0]);
        r7 = evalToArray(r18[1]);
        r8 = evalToArray(r18[2]);
        goto L20
    L8:
        if (r2 != 4) goto L15;
        r3 = evalToArray(r18[0]);
        r7 = evalToArray(r18[1]);
        r8 = evalToArray(r18[2]);
        if (ZeusTransformUtils.instanceOf(r18[3], BoolEval.class) == false) goto L13;
        r1 = !((BoolEval) ZeusTransformUtils.preCheckCast(r18[3], BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue();
        goto L22
    L13:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L15:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L18:
        r3 = evalToArray(r18[0]);
        r7 = (double[][]) Array.newInstance(double.class, new int[]{0, 0});
        r0 = Array.newInstance(double.class, new int[]{0, 0});
        goto L19
    }

    private static boolean isAllColumnsSame(double[][] r10) {
        if (r10.length != 0) goto L5;
        return false;
    L5:
        int r0 = r10[0].length;
        boolean[] r2 = new boolean[r0];
        int r3 = 0;
    L7:
        if (r3 >= r10[0].length) goto L18;
        double r6 = Double.NaN;
        int r4 = 0;
    L10:
        if (r4 >= r10.length) goto L17;
        double r8 = r10[r4][r3];
        if (r4 <= 0) goto L16;
        if (r8 == r6) goto L16;
        r2[r3] = true;
    L16:
        r4 = r4 + 1;
        r6 = r8;
    L17:
        r3 = r3 + 1;
        goto L7
    L18:
        int r11 = 0;
    L19:
        if (r11 >= r0) goto L25;
        if (r2[r11] == true) goto L34;
        r11 = r11 + 1;
        goto L19
    L34:
        return false;
    L25:
        return true;
    }

    private static double[][] switchRowsColumns(double[][] r7) {
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r7[0].length, r7.length});
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L10;
        int r3 = 0;
    L7:
        if (r3 >= r7[0].length) goto L9;
        r1[r3][r2] = r7[r2][r3];
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r8, int r9, int r10) {
        if (r8.length < 1) goto L21;
        if (r8.length > 4) goto L21;
        TrendResults r7 = getNewY(r8);     // Catch: EvaluationException -> L17
        ValueEval[] r6 = new ValueEval[TrendResults.access$000(r7).length];     // Catch: EvaluationException -> L17
        int r1 = 0;
    L9:
        if (r1 >= TrendResults.access$000(r7).length) goto L12;
        r6[r1] = new NumberEval(TrendResults.access$000(r7)[r1]);     // Catch: EvaluationException -> L17
        r1 = r1 + 1;     // Catch: EvaluationException -> L17
        goto L9
    L12:
        if (TrendResults.access$000(r7).length != 1) goto L16;
        return r6[0];
    L16:
        return new CacheAreaEval(r9, r10, (TrendResults.access$100(r7) + r9) - 1, (TrendResults.access$200(r7) + r10) - 1, r6);
    L17:
        e = move-exception;
        return e.getErrorEval();
    L21:
        return ErrorEval.VALUE_INVALID;
    }
}
