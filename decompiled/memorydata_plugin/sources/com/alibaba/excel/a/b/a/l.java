package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class l extends a implements com.alibaba.excel.a.b.a {
    public l() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r4, Record r5) {
        com.alibaba.excel.e.b.b r3 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        LabelSSTRecord r6 = (LabelSSTRecord) ZeusTransformUtils.preCheckCast(r5, LabelSSTRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.c.c r7 = r3.a().x();
        Map<Integer, com.alibaba.excel.metadata.e> r0 = r3.g().s();
        if (r7 != null) goto L6;
        r0.put(Integer.valueOf(r6.getColumn()), com.alibaba.excel.metadata.data.f.a(Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn())));
        return;
    L6:
        String r8 = r7.a(Integer.valueOf(r6.getSSTIndex()));
        if (r8 != null) goto L11;
        r0.put(Integer.valueOf(r6.getColumn()), com.alibaba.excel.metadata.data.f.a(Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn())));
        return;
    L11:
        if (r3.d().b().a().booleanValue() == false) goto L13;
        r8 = r8.trim();
    L13:
        r0.put(Integer.valueOf(r6.getColumn()), com.alibaba.excel.metadata.data.f.a(r8, Integer.valueOf(r6.getRow()), Integer.valueOf(r6.getColumn())));
        r3.g().a(RowTypeEnum.DATA);
    }
}
