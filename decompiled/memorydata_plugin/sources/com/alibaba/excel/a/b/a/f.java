package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class f extends a implements com.alibaba.excel.a.b.a {
    public f() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r5, Record r6) {
        com.alibaba.excel.e.b.b r4 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.b.a r7 = r4.g();
        if (ZeusTransformUtils.instanceOf(r6, LastCellOfRowDummyRecord.class) == false) goto L6;
        LastCellOfRowDummyRecord r8 = (LastCellOfRowDummyRecord) ZeusTransformUtils.preCheckCast(r6, LastCellOfRowDummyRecord.class, "com.obric.memorydata.plugin");
        r7.b(Integer.valueOf(r8.getRow()));
        r4.a(new com.alibaba.excel.h.c.a.c(Integer.valueOf(r8.getRow()), r7.x(), r4.b().f(), r7.s()));
        r4.e().b(r4);
        r7.b(new LinkedHashMap());
        r7.a(RowTypeEnum.EMPTY);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, MissingCellDummyRecord.class) == false) goto L10;
        MissingCellDummyRecord r9 = (MissingCellDummyRecord) ZeusTransformUtils.preCheckCast(r6, MissingCellDummyRecord.class, "com.obric.memorydata.plugin");
        r7.s().putIfAbsent(Integer.valueOf(r9.getColumn()), com.alibaba.excel.metadata.data.f.a(Integer.valueOf(r9.getRow()), Integer.valueOf(r9.getColumn())));
        return;
    }
}
