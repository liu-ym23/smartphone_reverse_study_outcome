package com.alibaba.excel.metadata.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RoundingMode f257b;

    public g(String r1, RoundingMode r2) {
        this.f256a = r1;
        this.f257b = r2;
    }

    public static g a(com.alibaba.excel.b.a.b r2) {
        com.alibaba.excel.b.a.b r3 = (com.alibaba.excel.b.a.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.b.a.b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new g(r3.a(), r3.b());
    }

    public String a() {
        return this.f256a;
    }

    public RoundingMode b() {
        return this.f257b;
    }
}
