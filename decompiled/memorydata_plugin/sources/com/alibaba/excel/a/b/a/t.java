package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.TextObjectRecord;

/* JADX INFO: loaded from: classes.dex */
public class t extends a implements com.alibaba.excel.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f127a = null;

    static {
        f127a = org.slf4j.d.a(t.class);
    }

    public t() {
    }

    @Override // com.alibaba.excel.a.b.a.a, com.alibaba.excel.a.b.b
    public boolean a(com.alibaba.excel.e.b.b r1, Record r2) {
        return ((com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.COMMENT);
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r2, Record r3) {
        com.alibaba.excel.e.b.b r1 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        TextObjectRecord r4 = (TextObjectRecord) ZeusTransformUtils.preCheckCast(r3, TextObjectRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.b.a r5 = r1.g();
        Integer r6 = r5.y();
        if (r6 != null) goto L6;
        f127a.debug("tempObjectIndex is null.");
        return;
    L6:
        r5.z().put(r6, r4.getStr().getString());
        r5.d(null);
    }
}
