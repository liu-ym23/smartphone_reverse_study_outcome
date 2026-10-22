package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class n extends a implements com.alibaba.excel.a.b.a {
    public n() {
    }

    @Override // com.alibaba.excel.a.b.a.a, com.alibaba.excel.a.b.b
    public boolean a(com.alibaba.excel.e.b.b r1, Record r2) {
        return ((com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.COMMENT);
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r4, Record r5) {
        com.alibaba.excel.e.b.b r3 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        NoteRecord r6 = (NoteRecord) ZeusTransformUtils.preCheckCast(r5, NoteRecord.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.g().z().get(Integer.valueOf(r6.getShapeId())), String.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.f r0 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.COMMENT, r7, Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn()));
        r3.g().a(r0);
        r3.e().a(r3);
    }
}
