package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Offset implements Function {

    private static final class BaseRef {
        private final AreaEval _areaEval;
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _height;
        private final RefEval _refEval;
        private final int _width;

        public BaseRef(AreaEval r3) {
            AreaEval r4 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r3, AreaEval.class, "com.obric.memorydata.plugin");
            this._refEval = null;
            this._areaEval = r4;
            this._firstRowIndex = r4.getFirstRow();
            this._firstColumnIndex = r4.getFirstColumn();
            this._height = (r4.getLastRow() - r4.getFirstRow()) + 1;
            this._width = (r4.getLastColumn() - r4.getFirstColumn()) + 1;
        }

        public BaseRef(RefEval r3) {
            RefEval r4 = (RefEval) ZeusTransformUtils.wrapperContextForParams(r3, RefEval.class, "com.obric.memorydata.plugin");
            this._refEval = r4;
            this._areaEval = null;
            this._firstRowIndex = r4.getRow();
            this._firstColumnIndex = r4.getColumn();
            this._height = 1;
            this._width = 1;
        }

        public int getFirstColumnIndex() {
            return this._firstColumnIndex;
        }

        public int getFirstRowIndex() {
            return this._firstRowIndex;
        }

        public int getHeight() {
            return this._height;
        }

        public int getWidth() {
            return this._width;
        }

        public AreaEval offset(int r2, int r3, int r4, int r5) {
            RefEval r0 = this._refEval;
            if (r0 != null) goto L7;
            return this._areaEval.offset(r2, r3, r4, r5);
        L7:
            return r0.offset(r2, r3, r4, r5);
        }
    }

    static final class LinearOffsetRange {
        private final int _length;
        private final int _offset;

        public LinearOffsetRange(int r1, int r2) {
            if (r2 == 0) goto L7;
            this._offset = r1;
            this._length = r2;
            return;
        L7:
            throw new RuntimeException("length may not be zero");
        }

        public short getFirstIndex() {
            return (short) this._offset;
        }

        public short getLastIndex() {
            return (short) ((this._offset + this._length) - 1);
        }

        public boolean isOutOfBounds(int r2, int r3) {
            if (this._offset >= r2) goto L5;
        L8:
            return true;
        L5:
            if (getLastIndex() > r3) goto L8;
            return false;
        }

        public LinearOffsetRange normaliseAndTranslate(int r3) {
            if (this._length <= 0) goto L8;
            if (r3 != 0) goto L7;
            return this;
        L7:
            return new LinearOffsetRange(r3 + this._offset, this._length);
        L8:
            int r4 = r3 + this._offset;
            int r2 = this._length;
            return new LinearOffsetRange((r4 + r2) + 1, -r2);
        }

        public String toString() {
            return getClass().getName() + " [" + this._offset + "..." + getLastIndex() + "]";
        }
    }

    public Offset() {
    }

    private static AreaEval createOffset(BaseRef r4, LinearOffsetRange r5, LinearOffsetRange r6) {
        LinearOffsetRange r0 = r5.normaliseAndTranslate(r4.getFirstRowIndex());
        LinearOffsetRange r1 = r6.normaliseAndTranslate(r4.getFirstColumnIndex());
        if (r0.isOutOfBounds(0, 65535) == true) goto L11;
        if (r1.isOutOfBounds(0, 255) == true) goto L9;
        return r4.offset(r5.getFirstIndex(), r5.getLastIndex(), r6.getFirstIndex(), r6.getLastIndex());
    L9:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    L11:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    }

    private static BaseRef evaluateBaseRef(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L7;
        return new BaseRef((RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L11;
        return new BaseRef((AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r4, ErrorEval.class) == false) goto L15;
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin"));
    L15:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    static int evaluateIntArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r8, int r9, int r10) {
        if (r8.length < 1) goto L37;
        if (r8.length > 5) goto L37;
        int r7 = 0;
        BaseRef r2 = evaluateBaseRef(r8[0]);     // Catch: EvaluationException -> L33
        if (ZeusTransformUtils.instanceOf(r8[1], MissingArgEval.class) == false) goto L11;
        int r0 = 0;
    L13:
        if (ZeusTransformUtils.instanceOf(r8[2], MissingArgEval.class) == true) goto L16;
        r7 = evaluateIntArg(r8[2], r9, r10);     // Catch: EvaluationException -> L33
    L16:
        int r3 = r2.getHeight();     // Catch: EvaluationException -> L33
        int r4 = r2.getWidth();     // Catch: EvaluationException -> L33
        int r5 = r8.length;     // Catch: EvaluationException -> L33
        if (r5 == 4) goto L24;
        if (r5 == 5) goto L21;
    L26:
        if (r3 == 0) goto L32;
        if (r4 == 0) goto L32;
        return createOffset(r2, new LinearOffsetRange(r0, r3), new LinearOffsetRange(r7, r4));
    L32:
        return ErrorEval.REF_INVALID;
    L21:
        if (ZeusTransformUtils.instanceOf(r8[4], MissingArgEval.class) == true) goto L24;
        r4 = evaluateIntArg(r8[4], r9, r10);     // Catch: EvaluationException -> L33
    L24:
        if (ZeusTransformUtils.instanceOf(r8[3], MissingArgEval.class) == true) goto L26;
        r3 = evaluateIntArg(r8[3], r9, r10);     // Catch: EvaluationException -> L33
        goto L26
    L11:
        r0 = evaluateIntArg(r8[1], r9, r10);     // Catch: EvaluationException -> L33
    L33:
        e = move-exception;
        return e.getErrorEval();
    L37:
        return ErrorEval.VALUE_INVALID;
    }
}
