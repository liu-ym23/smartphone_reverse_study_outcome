package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.IndexRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class j extends a implements com.alibaba.excel.a.b.a {
    public j() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r2, Record r3) {
        com.alibaba.excel.e.b.b r1 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        if (r1.b() != null) goto L5;
        return;
    L5:
        r1.b().a(Integer.valueOf(((IndexRecord) ZeusTransformUtils.preCheckCast(r3, IndexRecord.class, "com.obric.memorydata.plugin")).getLastRowAdd1()));
    }
}
