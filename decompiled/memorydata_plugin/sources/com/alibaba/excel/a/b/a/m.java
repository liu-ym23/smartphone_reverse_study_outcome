package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes.dex */
public class m extends a implements com.alibaba.excel.a.b.a {
    public m() {
    }

    @Override // com.alibaba.excel.a.b.a.a, com.alibaba.excel.a.b.b
    public boolean a(com.alibaba.excel.e.b.b r1, Record r2) {
        return ((com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.MERGE);
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r10, Record r11) {
        com.alibaba.excel.e.b.b r9 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r10, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        MergeCellsRecord r12 = (MergeCellsRecord) ZeusTransformUtils.preCheckCast(r11, MergeCellsRecord.class, "com.obric.memorydata.plugin");
        int r13 = 0;
    L4:
        if (r13 >= r12.getNumAreas()) goto L6;
        CellRangeAddress r0 = r12.getAreaAt(r13);
        com.alibaba.excel.metadata.f r8 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.MERGE, null, Integer.valueOf(r0.getFirstRow()), Integer.valueOf(r0.getLastRow()), Integer.valueOf(r0.getFirstColumn()), Integer.valueOf(r0.getLastColumn()));
        r9.g().a(r8);
        r9.e().a(r9);
        r13 = r13 + 1;
        goto L4
    }
}
