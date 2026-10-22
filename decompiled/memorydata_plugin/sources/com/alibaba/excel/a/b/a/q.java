package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class q extends a implements com.alibaba.excel.a.b.a {
    public q() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r2, Record r3) {
        com.alibaba.excel.e.b.b r1 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        RKRecord r4 = (RKRecord) ZeusTransformUtils.preCheckCast(r3, RKRecord.class, "com.obric.memorydata.plugin");
        r1.g().s().put(Integer.valueOf(r4.getColumn()), com.alibaba.excel.metadata.data.f.a(Integer.valueOf(r4.getRow()), Integer.valueOf(r4.getColumn())));
    }
}
