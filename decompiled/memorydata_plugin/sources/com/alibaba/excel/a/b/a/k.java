package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class k extends a implements com.alibaba.excel.a.b.a {
    public k() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r4, Record r5) {
        com.alibaba.excel.e.b.b r3 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        LabelRecord r6 = (LabelRecord) ZeusTransformUtils.preCheckCast(r5, LabelRecord.class, "com.obric.memorydata.plugin");
        String r7 = r6.getValue();
        if (r7 != null) goto L5;
    L7:
        r3.g().s().put(Integer.valueOf(r6.getColumn()), com.alibaba.excel.metadata.data.f.a(r7, Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn())));
        r3.g().a(RowTypeEnum.DATA);
        return;
    L5:
        if (r3.d().b().a().booleanValue() == false) goto L7;
        r7 = r7.trim();
        goto L7
    }
}
