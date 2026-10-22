package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public class UnknownPtg extends Ptg {
    private final int _sid;
    private final short size;

    public UnknownPtg(int r2) {
        this.size = 1;
        this._sid = r2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) this._sid;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return "UNKNOWN";
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        ((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin")).writeByte(this._sid);
    }
}
