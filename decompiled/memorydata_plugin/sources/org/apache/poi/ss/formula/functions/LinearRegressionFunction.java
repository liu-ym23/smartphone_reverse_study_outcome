package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class LinearRegressionFunction extends Fixed2ArgFunction {
    private final FUNCTION function;

    private static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval r3) {
            TwoDEval r4 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r3, TwoDEval.class, "com.obric.memorydata.plugin");
            super(r4.getWidth() * r4.getHeight());
            this._ae = r4;
            this._width = r4.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int r3) {
            int r0 = this._width;
            TwoDEval r2 = this._ae;
            return r2.getValue(r3 / r0, r3 % r0);
        }
    }

    public static final enum FUNCTION extends Enum<FUNCTION> {
        private static final /* synthetic */ FUNCTION[] $VALUES = null;
        public static final FUNCTION INTERCEPT = null;
        public static final FUNCTION SLOPE = null;

        static {
            FUNCTION r0 = new FUNCTION("INTERCEPT", 0);
            INTERCEPT = r0;
            FUNCTION r1 = new FUNCTION("SLOPE", 1);
            SLOPE = r1;
            $VALUES = new FUNCTION[]{r0, r1};
        }

        private FUNCTION(String r1, int r2) {
            super(r1, r2);
        }

        public static FUNCTION valueOf(String r2) {
            return (FUNCTION) ZeusTransformUtils.preCheckCast(Enum.valueOf(FUNCTION.class, r2), FUNCTION.class, "com.obric.memorydata.plugin");
        }

        public static FUNCTION[] values() {
            return (FUNCTION[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FUNCTION[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final class RefValueArray extends ValueArray {
        private final RefEval _ref;
        private final int _width;

        public RefValueArray(RefEval r3) {
            RefEval r4 = (RefEval) ZeusTransformUtils.wrapperContextForParams(r3, RefEval.class, "com.obric.memorydata.plugin");
            super(r4.getNumberOfSheets());
            this._ref = r4;
            this._width = r4.getNumberOfSheets();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int r2) {
            int r3 = (r2 % this._width) + this._ref.getFirstSheetIndex();
            return this._ref.getInnerValueEval(r3);
        }
    }

    private static final class SingleCellValueArray extends ValueArray {
        private final ValueEval _value;

        public SingleCellValueArray(ValueEval r3) {
            ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
            super(1);
            this._value = r4;
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int r1) {
            return this._value;
        }
    }

    private static abstract class ValueArray implements LookupUtils.ValueVector {
        private final int _size;

        public ValueArray(int r1) {
            this._size = r1;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int r4) {
            if (r4 < 0) goto L8;
            if (r4 > this._size) goto L8;
            return getItemInternal(r4);
        L8:
            throw new IllegalArgumentException("Specified index " + r4 + " is outside range (0.." + (this._size - 1) + ")");
        }

        public abstract ValueEval getItemInternal(int r1);

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public final int getSize() {
            return this._size;
        }
    }

    public LinearRegressionFunction(FUNCTION r1) {
        this.function = r1;
    }

    private static LookupUtils.ValueVector createValueVector(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ErrorEval.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r4, TwoDEval.class) == false) goto L9;
        return new AreaValueArray((TwoDEval) ZeusTransformUtils.preCheckCast(r4, TwoDEval.class, "com.obric.memorydata.plugin"));
    L9:
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L13;
        return new RefValueArray((RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin"));
    L13:
        return new SingleCellValueArray(r4);
    L15:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin"));
    }

    private double evaluateInternal(LookupUtils.ValueVector r21, LookupUtils.ValueVector r22, int r23) {
        LookupUtils.ValueVector r1 = (LookupUtils.ValueVector) ZeusTransformUtils.wrapperContextForParams(r21, LookupUtils.ValueVector.class, "com.obric.memorydata.plugin");
        LookupUtils.ValueVector r3 = (LookupUtils.ValueVector) ZeusTransformUtils.wrapperContextForParams(r22, LookupUtils.ValueVector.class, "com.obric.memorydata.plugin");
        ErrorEval r7 = null;
        int r8 = 0;
        boolean r9 = false;
        double r10 = 0.0d;
        double r12 = 0.0d;
    L3:
        if (r8 >= r23) goto L18;
        ValueEval r14 = r1.getItem(r8);
        ValueEval r15 = r3.getItem(r8);
        if (ZeusTransformUtils.instanceOf(r14, ErrorEval.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r15, ErrorEval.class) == false) goto L11;
        if (r7 != null) goto L11;
        r7 = (ErrorEval) ZeusTransformUtils.preCheckCast(r15, ErrorEval.class, "com.obric.memorydata.plugin");
    L15:
        r8 = r8 + 1;
    L11:
        if (ZeusTransformUtils.instanceOf(r14, NumberEval.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r15, NumberEval.class) == false) goto L15;
        NumberEval r4 = (NumberEval) ZeusTransformUtils.preCheckCast(r14, NumberEval.class, "com.obric.memorydata.plugin");
        NumberEval r11 = (NumberEval) ZeusTransformUtils.preCheckCast(r15, NumberEval.class, "com.obric.memorydata.plugin");
        r10 = r10 + r4.getNumberValue();
        r12 = r12 + r11.getNumberValue();
        r9 = true;
        goto L15
    L17:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r14, ErrorEval.class, "com.obric.memorydata.plugin"));
    L18:
        if (r7 != null) goto L39;
        if (r9 == false) goto L37;
        double r13 = r23;
        double r16 = r10 / r13;
        double r17 = r12 / r13;
        int r5 = 0;
        double r18 = 0.0d;
        double r19 = 0.0d;
    L21:
        if (r5 >= r23) goto L29;
        ValueEval r20 = r1.getItem(r5);
        ValueEval r6 = r3.getItem(r5);
        if (ZeusTransformUtils.instanceOf(r20, NumberEval.class) == false) goto L27;
        if (ZeusTransformUtils.instanceOf(r6, NumberEval.class) == false) goto L27;
        NumberEval r24 = (NumberEval) ZeusTransformUtils.preCheckCast(r20, NumberEval.class, "com.obric.memorydata.plugin");
        NumberEval r25 = (NumberEval) ZeusTransformUtils.preCheckCast(r6, NumberEval.class, "com.obric.memorydata.plugin");
        r18 = r18 + ((r24.getNumberValue() - r16) * (r24.getNumberValue() - r16));
        r19 = r19 + ((r24.getNumberValue() - r16) * (r25.getNumberValue() - r17));
    L27:
        r5 = r5 + 1;
        goto L21
    L29:
        if (r18 == 0.0d) goto L35;
        double r110 = r19 / r18;
        double r111 = r17 - (r16 * r110);
        if (this.function == FUNCTION.INTERCEPT) goto L33;
        return r110;
    L33:
        return r111;
    L35:
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    L37:
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    L39:
        throw new EvaluationException(r7);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        LookupUtils.ValueVector r7 = createValueVector(r5);     // Catch: EvaluationException -> L20
        LookupUtils.ValueVector r8 = createValueVector(r6);     // Catch: EvaluationException -> L20
        int r9 = r8.getSize();     // Catch: EvaluationException -> L20
        if (r9 == 0) goto L19;
        if (r7.getSize() != r9) goto L19;
        double r0 = evaluateInternal(r8, r7, r9);     // Catch: EvaluationException -> L20
        if (Double.isNaN(r0) == true) goto L17;
        if (Double.isInfinite(r0) == true) goto L17;
        return new NumberEval(r0);
    L17:
        return ErrorEval.NUM_ERROR;
    L19:
        return ErrorEval.NA;
    L20:
        e = move-exception;
        return e.getErrorEval();
    }
}
