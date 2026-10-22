package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class Area3DPxg extends AreaPtgBase {
    private int externalWorkbookNumber;
    private String firstSheetName;
    private String lastSheetName;

    public Area3DPxg(int r1, SheetIdentifier r2, AreaReference r3) {
        super(r3);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = r1;
        this.firstSheetName = r2.getSheetIdentifier().getName();
        if (ZeusTransformUtils.instanceOf(r2, SheetRangeIdentifier.class) == false) goto L5;
        String r4 = ((SheetRangeIdentifier) ZeusTransformUtils.preCheckCast(r2, SheetRangeIdentifier.class, "com.obric.memorydata.plugin")).getLastSheetIdentifier().getName();
    L6:
        this.lastSheetName = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public Area3DPxg(SheetIdentifier r2, AreaReference r3) {
        this(-1, r2, r3);
    }

    public Area3DPxg(Area3DPxg r2) {
        super(r2);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = r2.externalWorkbookNumber;
        this.firstSheetName = r2.firstSheetName;
        this.lastSheetName = r2.lastSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public Area3DPxg copy() {
        return new Area3DPxg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$Area3DPxg$23zRGNKWrbTRKzaBCjZKKYFs8E(this), "externalWorkbookNumber", new $$Lambda$lCkUNyRNgiNvN28u4zVNhU2Jnc(this), "sheetName", new $$Lambda$b5L1FpmOLjrEz6PVxrmXykiWrH0(this), "lastSheetName", new $$Lambda$kMV_zidKJkmlP859Nyhf5tTEJv4(this));
    }

    public String getLastSheetName() {
        return this.lastSheetName;
    }

    public String getSheetName() {
        return this.firstSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return -1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$Area3DPxg() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuilder r0 = new StringBuilder(64);
        SheetRangeAndWorkbookIndexFormatter.format(r0, this.externalWorkbookNumber, this.firstSheetName, this.lastSheetName);
        r0.append('!');
        r0.append(formatReferenceAsString());
        return r0.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r2) {
        LittleEndianOutput r1 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }
}
