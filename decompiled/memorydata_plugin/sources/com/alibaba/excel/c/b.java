package com.alibaba.excel.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f144a;

    public b() {
        this.f144a = new ArrayList();
    }

    @Override // com.alibaba.excel.c.c
    public String a(Integer r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.intValue() >= 0) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.f144a.get(r2.intValue()), String.class, "com.obric.memorydata.plugin");
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
        this.f144a.add(r1);
    }

    @Override // com.alibaba.excel.c.c
    public void b() {
    }
}
