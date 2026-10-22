package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;

/* JADX INFO: loaded from: classes.dex */
public class r extends a implements com.alibaba.excel.a.b.a {
    public r() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r3, Record r4) {
        ((com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin")).a().a(new com.alibaba.excel.c.d((SSTRecord) ZeusTransformUtils.preCheckCast(r4, SSTRecord.class, "com.obric.memorydata.plugin")));
    }
}
