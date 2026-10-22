package com.bytedance.services.apm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f3181b;
    private byte[] c;

    public c(int r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f3180a = r3;
        this.f3181b = r6;
        this.c = r5;
    }

    public c(int r1, byte[] r2) {
        this.f3180a = r1;
        this.c = r2;
    }

    public int a() {
        return this.f3180a;
    }

    public byte[] b() {
        return this.c;
    }

    public Map<String, String> c() {
        return this.f3181b;
    }
}
