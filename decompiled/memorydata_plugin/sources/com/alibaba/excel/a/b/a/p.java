package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;

/* JADX INFO: loaded from: classes.dex */
public class p extends a implements com.alibaba.excel.a.b.a {
    public p() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r3, Record r4) {
        com.alibaba.excel.e.b.b r2 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        Iterator<SubRecord> r5 = ((ObjRecord) ZeusTransformUtils.preCheckCast(r4, ObjRecord.class, "com.obric.memorydata.plugin")).getSubRecords().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        SubRecord r6 = (SubRecord) ZeusTransformUtils.preCheckCast(r5.next(), SubRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, CommonObjectDataSubRecord.class) == false) goto L4;
        CommonObjectDataSubRecord r7 = (CommonObjectDataSubRecord) ZeusTransformUtils.preCheckCast(r6, CommonObjectDataSubRecord.class, "com.obric.memorydata.plugin");
        if (25 != r7.getObjectType()) goto L14;
        r2.g().d(Integer.valueOf(r7.getObjectId()));
        return;
    L14:
        return;
    }
}
