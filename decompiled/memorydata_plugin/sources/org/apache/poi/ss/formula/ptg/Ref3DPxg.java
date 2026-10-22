package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class Ref3DPxg extends RefPtgBase {
    private int externalWorkbookNumber;
    private String firstSheetName;
    private String lastSheetName;

    public Ref3DPxg(int r1, SheetIdentifier r2, CellReference r3) {
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

    public Ref3DPxg(SheetIdentifier r2, CellReference r3) {
        this(-1, r2, r3);
    }

    public Ref3DPxg(Ref3DPxg r2) {
        super(r2);
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = r2.externalWorkbookNumber;
        this.firstSheetName = r2.firstSheetName;
        this.lastSheetName = r2.lastSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public Ref3DPxg copy() {
        return new Ref3DPxg(this);
    }

    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.ss.formula.ptg.RefPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$Ref3DPxg$g6IhqZUEI28fng_NsBGDqO6HZJE(this), "externalWorkbookNumber", new $$Lambda$7DM2f9lf9Qq_AIX9JG381IMDmU(this), "firstSheetName", new $$Lambda$2sNd19bwMHfE0X17vSsi0UWOES4(this), "lastSheetName", new $$Lambda$l8BX3n0B960K_mDkZGxn68crVZs(this));
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

    public /* synthetic */ Object lambda$getGenericProperties$0$Ref3DPxg() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
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
