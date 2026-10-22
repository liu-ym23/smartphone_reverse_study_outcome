package org.apache.poi.ss.formula.ptg;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberPtg extends ScalarConstantPtg {
    private final double field_1_value;

    public NumberPtg(double r1) {
        this.field_1_value = r1;
    }

    public NumberPtg(String r3) {
        this(Double.parseDouble(r3));
    }

    public NumberPtg(LittleEndianInput r3) {
        this(((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin")).readDouble());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(EventBody.KEY_VALUE, new $$Lambda$CZpGNzsbwkrnuJXSFzal1tWWD_s(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 31;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 9;
    }

    public double getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return NumberToTextConverter.toText(this.field_1_value);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 31);
        r4.writeDouble(getValue());
    }
}
