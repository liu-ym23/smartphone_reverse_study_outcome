package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class i extends a implements com.alibaba.excel.a.b.a {
    public i() {
    }

    @Override // com.alibaba.excel.a.b.a.a, com.alibaba.excel.a.b.b
    public boolean a(com.alibaba.excel.e.b.b r1, Record r2) {
        return ((com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.HYPERLINK);
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r8, Record r9) {
        com.alibaba.excel.e.b.b r7 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r8, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        HyperlinkRecord r10 = (HyperlinkRecord) ZeusTransformUtils.preCheckCast(r9, HyperlinkRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.f r11 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.HYPERLINK, r10.getAddress(), Integer.valueOf(r10.getFirstRow()), Integer.valueOf(r10.getLastRow()), Integer.valueOf(r10.getFirstColumn()), Integer.valueOf(r10.getLastColumn()));
        r7.g().a(r11);
        r7.e().a(r7);
    }
}
