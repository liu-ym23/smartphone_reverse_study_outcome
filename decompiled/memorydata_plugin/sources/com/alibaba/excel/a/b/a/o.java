package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class o extends a implements com.alibaba.excel.a.b.a {
    public o() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r5, Record r6) {
        com.alibaba.excel.e.b.b r4 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        NumberRecord r7 = (NumberRecord) ZeusTransformUtils.preCheckCast(r6, NumberRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.data.f<?> r8 = com.alibaba.excel.metadata.data.f.a(BigDecimal.valueOf(r7.getValue()), Integer.valueOf(r7.getRow()), Integer.valueOf(r7.getColumn()));
        short r0 = (short) r4.f().H().getFormatIndex(r7);
        com.alibaba.excel.metadata.data.d r1 = new com.alibaba.excel.metadata.data.d();
        r1.a(Short.valueOf(r0));
        r1.a(com.alibaba.excel.d.a.a(Short.valueOf(r0), r4.f().H().getFormatString(r7), r4.b().f().c()));
        r8.a(r1);
        r4.g().s().put(Integer.valueOf(r7.getColumn()), r8);
        r4.g().a(RowTypeEnum.DATA);
    }
}
