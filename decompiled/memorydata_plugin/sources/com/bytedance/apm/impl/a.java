package com.bytedance.apm.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f1372b;
    public byte[] c;

    public a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f1371a = r3;
        this.f1372b = r6;
        this.c = r5;
    }
}
