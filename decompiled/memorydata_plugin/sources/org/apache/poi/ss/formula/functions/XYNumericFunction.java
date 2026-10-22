package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XYNumericFunction extends Fixed2ArgFunction {

    protected interface Accumulator {
        double accumulate(double r1, double r3);
    }

    private static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval r3) {
            TwoDEval r4 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r3, TwoDEval.class, "com.obric.memorydata.plugin");
            super(r4.getWidth() * r4.getHeight());
            this._ae = r4;
            this._width = r4.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
        public ValueEval getItemInternal(int r3) {
            int r0 = this._width;
            TwoDEval r2 = this._ae;
            return r2.getValue(r3 / r0, r3 % r0);
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

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
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

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
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

    public XYNumericFunction() {
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

    private double evaluateInternal(LookupUtils.ValueVector r13, LookupUtils.ValueVector r14, int r15) {
        LookupUtils.ValueVector r16 = (LookupUtils.ValueVector) ZeusTransformUtils.wrapperContextForParams(r13, LookupUtils.ValueVector.class, "com.obric.memorydata.plugin");
        LookupUtils.ValueVector r17 = (LookupUtils.ValueVector) ZeusTransformUtils.wrapperContextForParams(r14, LookupUtils.ValueVector.class, "com.obric.memorydata.plugin");
        Accumulator r12 = createAccumulator();
        int r0 = 0;
        double r5 = 0.0d;
        ErrorEval r3 = null;
        ErrorEval r4 = null;
        boolean r2 = false;
    L3:
        if (r0 >= r15) goto L18;
        ValueEval r7 = r16.getItem(r0);
        ValueEval r8 = r17.getItem(r0);
        if (ZeusTransformUtils.instanceOf(r7, ErrorEval.class) == false) goto L9;
        if (r3 != null) goto L9;
        r3 = (ErrorEval) ZeusTransformUtils.preCheckCast(r7, ErrorEval.class, "com.obric.memorydata.plugin");
    L17:
        r0 = r0 + 1;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, ErrorEval.class) == false) goto L13;
        if (r4 != null) goto L13;
        r4 = (ErrorEval) ZeusTransformUtils.preCheckCast(r8, ErrorEval.class, "com.obric.memorydata.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r7, NumberEval.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r8, NumberEval.class) == false) goto L17;
        r5 = r5 + r12.accumulate(((NumberEval) ZeusTransformUtils.preCheckCast(r7, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue(), ((NumberEval) ZeusTransformUtils.preCheckCast(r8, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
        r2 = true;
        goto L17
    L18:
        if (r3 != null) goto L27;
        if (r4 != null) goto L25;
        if (r2 == false) goto L23;
        return r5;
    L23:
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    L25:
        throw new EvaluationException(r4);
    L27:
        throw new EvaluationException(r3);
    }

    public abstract Accumulator createAccumulator();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        LookupUtils.ValueVector r7 = createValueVector(r5);     // Catch: EvaluationException -> L20
        LookupUtils.ValueVector r8 = createValueVector(r6);     // Catch: EvaluationException -> L20
        int r9 = r7.getSize();     // Catch: EvaluationException -> L20
        if (r9 == 0) goto L19;
        if (r8.getSize() != r9) goto L19;
        double r0 = evaluateInternal(r7, r8, r9);     // Catch: EvaluationException -> L20
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
