package org.apache.poi.ss.formula.ptg;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class IntPtg extends ScalarConstantPtg {
    private final int field_1_value;

    public IntPtg(int r3) {
        if (isInRange(r3) == false) goto L7;
        this.field_1_value = r3;
        return;
    L7:
        throw new IllegalArgumentException("value is out of range: " + r3);
    }

    public IntPtg(LittleEndianInput r3) {
        this(((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin")).readUShort());
    }

    public static boolean isInRange(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 65535) goto L6;
        return true;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(EventBody.KEY_VALUE, new $$Lambda$cwysT24F8oTCkFNQo06Ipj5J9Z0(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 30;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 3;
    }

    public int getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return String.valueOf(getValue());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 30);
        r4.writeShort(getValue());
    }
}
