package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class ArrayPtg extends Ptg {
    private final Object[] _arrayValues;
    private final int _nColumns;
    private final int _nRows;
    private final int _reserved0Int;
    private final int _reserved1Short;
    private final int _reserved2Byte;

    ArrayPtg(int r1, int r2, int r3, int r4, int r5, Object[] r6) {
        this._reserved0Int = r1;
        this._reserved1Short = r2;
        this._reserved2Byte = r3;
        this._nColumns = r4;
        this._nRows = r5;
        this._arrayValues = (Object[]) ZeusTransformUtils.preCheckCast(r6.clone(), Object[].class, "com.obric.memorydata.plugin");
    }

    public ArrayPtg(Object[][] r10) {
        int r1 = r10[0].length;
        int r2 = r10.length;
        short r3 = (short) r1;
        this._nColumns = r3;
        short r4 = (short) r2;
        this._nRows = r4;
        Object[] r5 = new Object[r3 * r4];
        int r6 = 0;
    L3:
        if (r6 >= r2) goto L8;
        Object[] r7 = r10[r6];
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        r5[getValueIndex(r8, r6)] = r7[r8];
        r8 = r8 + 1;
        goto L5
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        this._arrayValues = r5;
        this._reserved0Int = 0;
        this._reserved1Short = 0;
        this._reserved2Byte = 0;
    }

    private static String getConstantText(Object r3) {
        if (r3 == null) goto L25;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        return "\"" + r3 + "\"";
    L8:
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L12;
        return NumberToTextConverter.toText(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L12:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L19;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L16;
        return "TRUE";
    L16:
        return "FALSE";
    L19:
        if (ZeusTransformUtils.instanceOf(r3, ErrorConstant.class) == false) goto L23;
        return ((ErrorConstant) ZeusTransformUtils.preCheckCast(r3, ErrorConstant.class, "com.obric.memorydata.plugin")).getText();
    L23:
        throw new IllegalArgumentException("Unexpected constant class (" + r3.getClass().getName() + ")");
    L25:
        throw new RuntimeException("Array item cannot be null");
    }

    public int getColumnCount() {
        return this._nColumns;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved0", new $$Lambda$ArrayPtg$uaTyeXOoLDfzdr2nc5U8bgJwes(this), "reserved1", new $$Lambda$ArrayPtg$HyUWF0OkRrPsa5Pz8oeGoGn_vQ(this), "reserved2", new $$Lambda$ArrayPtg$GmtGawJyqB9fxskEqa12oJZX45A(this), "columnCount", new $$Lambda$F2Y8DxcmNJKJZV70R1ixSW2p9w(this), "rowCount", new $$Lambda$CnQOdZWIQx13S6wGypEEibL7fKs(this), "arrayValues", new $$Lambda$ArrayPtg$VOOujD4XUEplgcrPx7xS5VzVc(this));
    }

    public int getRowCount() {
        return this._nRows;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 11;
    }

    public Object[][] getTokenArrayValues() {
        if (this._arrayValues == null) goto L14;
        Object[][] r0 = (Object[][]) Array.newInstance(Object.class, new int[]{this._nRows, this._nColumns});
        int r2 = 0;
    L6:
        if (r2 >= this._nRows) goto L12;
        Object[] r3 = r0[r2];
        int r4 = 0;
    L9:
        if (r4 >= this._nColumns) goto L11;
        r3[r4] = this._arrayValues[getValueIndex(r4, r2)];
        r4 = r4 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L6
    L12:
        return r0;
    L14:
        throw new IllegalStateException("array values not read yet");
    }

    int getValueIndex(int r5, int r6) {
        if (r5 < 0) goto L14;
        int r2 = this._nColumns;
        if (r5 >= r2) goto L14;
        if (r6 < 0) goto L12;
        if (r6 >= this._nRows) goto L12;
        return (r6 * r2) + r5;
    L12:
        throw new IllegalArgumentException("Specified rowIx (" + r6 + ") is outside the allowed range (0.." + (this._nRows - 1) + ")");
    L14:
        throw new IllegalArgumentException("Specified colIx (" + r5 + ") is outside the allowed range (0.." + (this._nColumns - 1) + ")");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return false;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ArrayPtg() {
        return Integer.valueOf(this._reserved0Int);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ArrayPtg() {
        return Integer.valueOf(this._reserved1Short);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ArrayPtg() {
        return Integer.valueOf(this._reserved2Byte);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ArrayPtg() {
        if (this._arrayValues != null) goto L6;
        return "#values#uninitialised#";
    L6:
        return toFormulaString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{");
        int r2 = 0;
    L4:
        if (r2 >= this._nRows) goto L14;
        if (r2 <= 0) goto L7;
        r0.append(";");
    L7:
        int r3 = 0;
    L9:
        if (r3 >= this._nColumns) goto L13;
        if (r3 <= 0) goto L12;
        r0.append(",");
    L12:
        r0.append(getConstantText(this._arrayValues[getValueIndex(r3, r2)]));
        r3 = r3 + 1;
        goto L9
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        r0.append("}");
        return r0.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 32);
        r4.writeInt(this._reserved0Int);
        r4.writeShort(this._reserved1Short);
        r4.writeByte(this._reserved2Byte);
    }

    public int writeTokenValueBytes(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(this._nColumns - 1);
        r4.writeShort(this._nRows - 1);
        ConstantValueParser.encode(r4, this._arrayValues);
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 3;
    }
}
