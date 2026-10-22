package com.alibaba.excel.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.SSTRecord;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SSTRecord f145a;

    public d(SSTRecord r1) {
        this.f145a = r1;
    }

    @Override // com.alibaba.excel.c.c
    public String a(Integer r1) {
        return this.f145a.getString(r1.intValue()).toString();
    }

    @Override // com.alibaba.excel.c.c
    public void a() {
    }

    @Override // com.alibaba.excel.c.c
    public void a(com.alibaba.excel.e.a r2) {
        com.alibaba.excel.e.a r1 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.c.c
    public void a(String r1) {
    }

    @Override // com.alibaba.excel.c.c
    public void b() {
    }
}
