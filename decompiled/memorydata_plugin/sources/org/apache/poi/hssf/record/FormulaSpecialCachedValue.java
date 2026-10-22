package org.apache.poi.hssf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class FormulaSpecialCachedValue implements GenericRecord {
    private final byte[] _variableData;

    private FormulaSpecialCachedValue(byte[] r1) {
        this._variableData = r1;
    }

    private static FormulaSpecialCachedValue create(int r2, int r3) {
        return new FormulaSpecialCachedValue(new byte[]{(byte) r2, 0, (byte) r3, 0, 0, 0});
    }

    public static FormulaSpecialCachedValue create(long r5) {
        if ((r5 & (-281474976710656L)) == (-281474976710656L)) goto L6;
        return null;
    L6:
        byte[] r1 = new byte[6];
        int r3 = 0;
    L7:
        if (r3 >= 6) goto L9;
        r1[r3] = (byte) r5;
        r5 = r5 >> 8;
        r3 = r3 + 1;
        goto L7
    L9:
        byte r6 = r1[0];
        if (r6 == 0) goto L21;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L21;
        throw new RecordFormatException("Bad special value code (" + r1[0] + ")");
    L21:
        return new FormulaSpecialCachedValue(r1);
    }

    public static FormulaSpecialCachedValue createCachedBoolean(boolean r1) {
        return create(1, r1 ? 1 : 0);
    }

    public static FormulaSpecialCachedValue createCachedEmptyValue() {
        return create(3, 0);
    }

    public static FormulaSpecialCachedValue createCachedErrorCode(int r1) {
        return create(2, r1);
    }

    public static FormulaSpecialCachedValue createForString() {
        return create(0, 0);
    }

    private String formatValue() {
        int r0 = getTypeCode();
        if (r0 != 0) goto L5;
        return "<string>";
    L5:
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L11;
        return "<empty>";
    L11:
        return "#error(type=" + r0 + ")#";
    L15:
        return ErrorEval.getText(getDataValue());
    L17:
        if (getDataValue() != 0) goto L19;
        return "FALSE";
    L19:
        return "TRUE";
    }

    private int getDataValue() {
        return this._variableData[2];
    }

    private Object getGenericValue() {
        int r0 = getTypeCode();
        if (r0 != 0) goto L5;
        return TypedValues.Custom.S_STRING;
    L5:
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unexpected type id (" + r0 + ")");
    L15:
        return Integer.valueOf(getErrorValue());
    L17:
        return Boolean.valueOf(getBooleanValue());
    }

    public static /* synthetic */ Object lambda$jFrUhorYx40A9r7fUn7Y42UxNRw(FormulaSpecialCachedValue r0) {
        return r0.getGenericValue();
    }

    public boolean getBooleanValue() {
        if (getTypeCode() != 1) goto L10;
        if (getDataValue() != 0) goto L11;
        return false;
    L11:
        return true;
    L10:
        throw new IllegalStateException("Not a boolean cached value - " + formatValue());
    }

    public int getErrorValue() {
        if (getTypeCode() != 2) goto L7;
        return getDataValue();
    L7:
        throw new IllegalStateException("Not an error cached value - " + formatValue());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(EventBody.KEY_VALUE, new $$Lambda$FormulaSpecialCachedValue$jFrUhorYx40A9r7fUn7Y42UxNRw(this), "typeCode", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$ChgOZOI6wXlxsOs96MgxqYGrtyQ(this), new int[]{0, 1, 2, 3}, new String[]{"STRING", "BOOLEAN", "ERROR_CODE", "EMPTY"}));
    }

    public int getTypeCode() {
        return this._variableData[0];
    }

    @Deprecated
    public int getValueType() {
        int r3 = getTypeCode();
        if (r3 != 0) goto L5;
    L17:
        CellType r4 = CellType.STRING;
    L15:
        return r4.getCode();
    L5:
        if (r3 != 1) goto L7;
        r4 = CellType.BOOLEAN;
        goto L15
    L7:
        if (r3 != 2) goto L9;
        r4 = CellType.ERROR;
        goto L15
    L9:
        if (r3 == 3) goto L17;
        throw new IllegalStateException("Unexpected type id (" + r3 + ")");
    }

    public CellType getValueTypeEnum() {
        int r3 = getTypeCode();
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L14;
        if (r3 == 3) goto L18;
        throw new IllegalStateException("Unexpected type id (" + r3 + ")");
    L14:
        return CellType.ERROR;
    L16:
        return CellType.BOOLEAN;
    L18:
        return CellType.STRING;
    }

    public String toString() {
        return getClass().getName() + '[' + formatValue() + ']';
    }
}
