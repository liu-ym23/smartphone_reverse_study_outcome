package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class FuncPtg extends AbstractFunctionPtg {
    private FuncPtg(int r3, FunctionMetadata r4) {
        super(r3, r4.getReturnClassCode(), r4.getParameterClassCodes(), r4.getMinParams());
    }

    public static FuncPtg create(int r3) {
        FunctionMetadata r0 = FunctionMetadataRegistry.getFunctionByIndex(r3);
        if (r0 == null) goto L7;
        return new FuncPtg(r3, r0);
    L7:
        throw new RuntimeException("Invalid built-in function index (" + r3 + ")");
    }

    public static FuncPtg create(LittleEndianInput r2) {
        return create(((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin")).readUShort());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 33;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 3;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 33);
        r4.writeShort(getFunctionIndex());
    }
}
