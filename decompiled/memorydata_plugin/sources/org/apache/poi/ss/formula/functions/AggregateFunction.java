package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AggregateFunction extends MultiOperandNumericFunction {
    public static final Function AVEDEV = null;
    public static final Function AVERAGE = null;
    public static final Function AVERAGEA = null;
    public static final Function DEVSQ = null;
    public static final Function GEOMEAN = null;
    public static final Function LARGE = null;
    public static final Function MAX = null;
    public static final Function MEDIAN = null;
    public static final Function MIN = null;
    public static final Function PERCENTILE = null;
    public static final Function PRODUCT = null;
    public static final Function SMALL = null;
    public static final Function STDEV = null;
    public static final Function STDEVA = null;
    public static final Function STDEVP = null;
    public static final Function STDEVPA = null;
    public static final Function SUM = null;
    public static final Function SUMSQ = null;
    public static final Function VAR = null;
    public static final Function VARA = null;
    public static final Function VARP = null;
    public static final Function VARPA = null;

    static abstract class AggregateFunctionA extends AggregateFunction {
        public AggregateFunctionA() {
            super(true);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public boolean treatStringsAsZero() {
            return true;
        }
    }

    private static class Geomean extends AggregateFunction {
        Geomean() {
            setMissingArgPolicy(MultiOperandNumericFunction.Policy.COERCE);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] r7) {
            int r6 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L10;
            if (r7[r1] <= 0.0d) goto L8;
            r1 = r1 + 1;
            goto L3
        L8:
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        L10:
            return new GeometricMean().evaluate(r7, 0, r7.length);
        }
    }

    private static final class LargeSmall extends Fixed2ArgFunction {
        private final boolean _isLarge;

        public LargeSmall(boolean r1) {
            this._isLarge = r1;
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
            ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            double r8 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: EvaluationException -> L23
            if (r8 < 1.0d) goto L7;
            int r9 = (int) Math.ceil(r8);
            double[] r10 = ValueCollector.collectValues(new ValueEval[]{r7});     // Catch: EvaluationException -> L20
            if (r9 <= r10.length) goto L14;
            return ErrorEval.NUM_ERROR;
        L14:
            if (this._isLarge == false) goto L16;
            double r2 = StatsLib.kthLargest(r10, r9);     // Catch: EvaluationException -> L20
        L17:
            NumericFunction.checkValue(r2);     // Catch: EvaluationException -> L20
            return new NumberEval(r2);
        L16:
            r2 = StatsLib.kthSmallest(r10, r9);     // Catch: EvaluationException -> L20
        L20:
            e = move-exception;
            return e.getErrorEval();
        L7:
            return ErrorEval.NUM_ERROR;
        L24:
            return ErrorEval.VALUE_INVALID;
        }
    }

    private static final class Percentile extends Fixed2ArgFunction {
        public Percentile() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8) {
            ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
            double r9 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin"), r5, r6));     // Catch: EvaluationException -> L32
            if (r9 < 0.0d) goto L31;
            if (r9 > 1.0d) goto L31;
            double[] r10 = ValueCollector.collectValues(new ValueEval[]{r4});     // Catch: EvaluationException -> L27
            int r1 = r10.length;     // Catch: EvaluationException -> L27
            if (r1 == 0) goto L26;
            if (r1 > 8191) goto L26;
            double r2 = (((double) (r1 - 1)) * r9) + 1.0d;     // Catch: EvaluationException -> L27
            if (r2 != 1.0d) goto L19;
            double r11 = StatsLib.kthSmallest(r10, 1);     // Catch: EvaluationException -> L27
        L22:
            NumericFunction.checkValue(r11);     // Catch: EvaluationException -> L27
            return new NumberEval(r11);
        L19:
            if (Double.compare(r2, r1) != 0) goto L21;
            r11 = StatsLib.kthLargest(r10, 1);     // Catch: EvaluationException -> L27
            goto L22
        L21:
            int r12 = (int) r2;     // Catch: EvaluationException -> L27
            r11 = StatsLib.kthSmallest(r10, r12) + ((r2 - ((double) r12)) * (StatsLib.kthSmallest(r10, r12 + 1) - StatsLib.kthSmallest(r10, r12)));     // Catch: EvaluationException -> L27
        L26:
            return ErrorEval.NUM_ERROR;
        L27:
            e = move-exception;
            return e.getErrorEval();
        L31:
            return ErrorEval.NUM_ERROR;
        L33:
            return ErrorEval.VALUE_INVALID;
        }
    }

    private static class Product extends AggregateFunction {
        Product() {
            setMissingArgPolicy(MultiOperandNumericFunction.Policy.SKIP);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] r1) {
            return MathX.product(r1);
        }
    }

    static final class ValueCollector extends MultiOperandNumericFunction {
        private static final ValueCollector instance = null;

        static {
            instance = new ValueCollector();
        }

        public ValueCollector() {
            super(false, false);
        }

        public static double[] collectValues(ValueEval... r1) {
            return instance.getNumberArray(r1);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] r1) {
            throw new IllegalStateException("should not be called");
        }
    }

    static {
        AVEDEV = new AnonymousClass2();
        AVERAGE = new AnonymousClass3();
        AVERAGEA = new AnonymousClass4();
        DEVSQ = new AnonymousClass5();
        LARGE = new LargeSmall(true);
        MAX = new AnonymousClass6();
        MEDIAN = new AnonymousClass7();
        MIN = new AnonymousClass8();
        PERCENTILE = new Percentile();
        PRODUCT = new Product();
        SMALL = new LargeSmall(false);
        STDEV = new AnonymousClass9();
        STDEVP = new AnonymousClass10();
        STDEVA = new AnonymousClass11();
        STDEVPA = new AnonymousClass12();
        SUM = new AnonymousClass13();
        SUMSQ = new AnonymousClass14();
        VAR = new AnonymousClass15();
        VARP = new AnonymousClass16();
        VARA = new AnonymousClass17();
        VARPA = new AnonymousClass18();
        GEOMEAN = new Geomean();
    }

    public AggregateFunction() {
        this(false);
    }

    public AggregateFunction(boolean r2) {
        super(r2, false);
    }

    static Function subtotalInstance(Function r2, final boolean r3) {
        final AggregateFunction r4 = (AggregateFunction) ZeusTransformUtils.preCheckCast((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), AggregateFunction.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r4, r3);
    }
}
