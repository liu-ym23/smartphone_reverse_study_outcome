package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class NameXPxg extends OperandPtg {
    private int externalWorkbookNumber;
    private String nameName;
    private String sheetName;

    public NameXPxg(int r2, String r3, String r4) {
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = r2;
        this.sheetName = r3;
        this.nameName = r4;
    }

    public NameXPxg(String r3) {
        this(-1, null, r3);
    }

    public NameXPxg(String r2, String r3) {
        this(-1, r2, r3);
    }

    public NameXPxg(NameXPxg r2) {
        super(r2);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = r2.externalWorkbookNumber;
        this.sheetName = r2.sheetName;
        this.nameName = r2.nameName;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public NameXPxg copy() {
        return new NameXPxg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("externalWorkbookNumber", new $$Lambda$GCVl6oTi0PmTBnhHa8IZfdcsARs(this), "sheetName", new $$Lambda$s596dpHE_iHMSHDVTyOl_UHFoA8(this), "nameName", new $$Lambda$bD3tII452xqLXbHFBzqLkFpQV0M(this));
    }

    public String getNameName() {
        return this.nameName;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuilder r0 = new StringBuilder(64);
        boolean r2 = true;
        if (this.externalWorkbookNumber < 0) goto L5;
        r0.append('[');
        r0.append(this.externalWorkbookNumber);
        r0.append(']');
        boolean r1 = true;
    L6:
        String r3 = this.sheetName;
        if (r3 == null) goto L9;
        SheetNameFormatter.appendFormat(r0, r3);
    L10:
        if (r2 == false) goto L12;
        r0.append('!');
    L12:
        r0.append(this.nameName);
        return r0.toString();
    L9:
        r2 = r1;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r2) {
        LittleEndianOutput r1 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }
}
