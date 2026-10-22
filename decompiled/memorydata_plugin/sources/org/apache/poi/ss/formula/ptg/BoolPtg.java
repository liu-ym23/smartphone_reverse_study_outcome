package org.apache.poi.ss.formula.ptg;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class BoolPtg extends ScalarConstantPtg {
    private static final BoolPtg FALSE = null;
    private static final BoolPtg TRUE = null;
    private final boolean _value;

    static {
        FALSE = new BoolPtg(false);
        TRUE = new BoolPtg(true);
    }

    private BoolPtg(boolean r1) {
        this._value = r1;
    }

    public static BoolPtg read(LittleEndianInput r2) {
        boolean r0 = true;
        if (((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin")).readByte() == 1) goto L7;
        r0 = false;
    L7:
        return valueOf(r0);
    }

    public static BoolPtg valueOf(boolean r0) {
        if (r0 == false) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(EventBody.KEY_VALUE, new $$Lambda$mwTeiGKbvLHW_kB1gtSbSBINU0(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 29;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 2;
    }

    public boolean getValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        if (this._value == false) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 29);
        r4.writeByte(this._value ? 1 : 0);
    }
}
