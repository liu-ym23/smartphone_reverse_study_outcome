package com.alibaba.excel.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.StringRecord;

/* JADX INFO: loaded from: classes.dex */
public class s extends a implements com.alibaba.excel.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f126a = null;

    static {
        f126a = org.slf4j.d.a(s.class);
    }

    public s() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r2, Record r3) {
        com.alibaba.excel.e.b.b r1 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        StringRecord r4 = (StringRecord) ZeusTransformUtils.preCheckCast(r3, StringRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.b.a r5 = r1.g();
        com.alibaba.excel.metadata.data.f<?> r6 = r5.v();
        if (r6 != null) goto L6;
        f126a.warn("String type formula but no value found.");
        return;
    L6:
        r6.a(r4.getString());
        r5.s().put(r6.b(), r6);
        r5.a(null);
    }
}
