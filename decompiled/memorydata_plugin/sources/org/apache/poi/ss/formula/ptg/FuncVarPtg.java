package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class FuncVarPtg extends AbstractFunctionPtg {
    public static final OperationPtg SUM = null;
    private static final BitField ceFunc = null;
    private final boolean _isCetab;

    static {
        ceFunc = BitFieldFactory.getInstance(61440);
        SUM = create("SUM", 1);
    }

    private FuncVarPtg(int r1, int r2, byte[] r3, int r4, boolean r5) {
        super(r1, r2, r3, r4);
        this._isCetab = r5;
    }

    private static FuncVarPtg create(int r7, int r8) {
        BitField r0 = ceFunc;
        boolean r6 = r0.isSet(r8);
        if (r6 == false) goto L5;
        r8 = r0.clear(r8);
        FunctionMetadata r1 = FunctionMetadataRegistry.getCetabFunctionByIndex(r8);
    L6:
        int r2 = r8;
        if (r1 != null) goto L11;
        return new FuncVarPtg(r2, 32, new byte[]{32}, r7, r6);
    L11:
        return new FuncVarPtg(r2, r1.getReturnClassCode(), r1.getParameterClassCodes(), r7, r6);
    L5:
        r1 = FunctionMetadataRegistry.getFunctionByIndex(r8);
        goto L6
    }

    public static FuncVarPtg create(String r0, int r1) {
        return create(r1, lookupIndex(r0));
    }

    public static FuncVarPtg create(LittleEndianInput r2) {
        LittleEndianInput r3 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        return create(r3.readByte(), r3.readUShort());
    }

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$FuncVarPtg$9BY_2dygkokiWF2yZvtcBrc4o(this), "cetab", new $$Lambda$FuncVarPtg$IByxgVSbOfDy9tKmp5t6zctXMXA(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 34;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 4;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FuncVarPtg() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FuncVarPtg() {
        return Boolean.valueOf(this._isCetab);
    }

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg
    public String lookupName(short r2) {
        return lookupName(r2, this._isCetab);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 34);
        r4.writeByte(getNumberOfOperands());
        r4.writeShort(getFunctionIndex());
    }
}
