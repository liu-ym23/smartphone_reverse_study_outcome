package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class e extends a implements com.alibaba.excel.a.b.a {
    public e() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r2, Record r3) {
        com.alibaba.excel.e.b.b r1 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        BoundSheetRecord r4 = (BoundSheetRecord) ZeusTransformUtils.preCheckCast(r3, BoundSheetRecord.class, "com.obric.memorydata.plugin");
        r1.f().J().add(r4);
    }
}
