package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class d extends a implements com.alibaba.excel.a.b.a {
    public d() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r4, Record r5) {
        com.alibaba.excel.e.b.b r3 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        BoolErrRecord r6 = (BoolErrRecord) ZeusTransformUtils.preCheckCast(r5, BoolErrRecord.class, "com.obric.memorydata.plugin");
        r3.g().s().put(Integer.valueOf(r6.getColumn()), com.alibaba.excel.metadata.data.f.a(Boolean.valueOf(r6.getBooleanValue()), Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn())));
        r3.g().a(RowTypeEnum.DATA);
    }
}
