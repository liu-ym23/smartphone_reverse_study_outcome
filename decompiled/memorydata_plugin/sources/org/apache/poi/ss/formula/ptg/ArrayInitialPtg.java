package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
final class ArrayInitialPtg extends Ptg {
    private final int _reserved0;
    private final int _reserved1;
    private final int _reserved2;

    public ArrayInitialPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this._reserved0 = r4.readInt();
        this._reserved1 = r4.readUShort();
        this._reserved2 = r4.readUByte();
    }

    private static RuntimeException invalid() {
        throw new IllegalStateException("This object is a partially initialised tArray, and cannot be used as a Ptg");
    }

    public ArrayPtg finishReading(LittleEndianInput r10) {
        LittleEndianInput r11 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r10, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r11.readUByte();
        int r6 = r0 + 1;
        short r7 = (short) (r11.readShort() + 1);
        Object[] r8 = ConstantValueParser.parse(r11, r7 * r6);
        ArrayPtg r12 = new ArrayPtg(this._reserved0, this._reserved1, this._reserved2, r6, r7, r8);
        r12.setClass(getPtgClass());
        return r12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved0", new $$Lambda$ArrayInitialPtg$8sn5NRVv1viqIO9a4cZtedo56Xs(this), "reserved1", new $$Lambda$ArrayInitialPtg$IZmmCB48cYQdjZFPOs5FIh9jHjI(this), "reserved2", new $$Lambda$ArrayInitialPtg$3SXS7weoWlVPvpI_oXXHWsu6Wpc(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 8;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return false;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ArrayInitialPtg() {
        return Integer.valueOf(this._reserved0);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ArrayInitialPtg() {
        return Integer.valueOf(this._reserved1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ArrayInitialPtg() {
        return Integer.valueOf(this._reserved2);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw invalid();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r2) {
        LittleEndianOutput r1 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        throw invalid();
    }
}
