package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class aj extends bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f5290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f5291b;

    public aj(byte[] r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f5290a = r3;
        this.f5291b = r5;
        a(bo.a.e);
        a(bo.c.f5374b);
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return null;
    }

    @Override // com.loc.bo
    public final Map<String, String> b() {
        return this.f5291b;
    }

    @Override // com.loc.bo
    public final String c() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.bo
    public final byte[] d() {
        return this.f5290a;
    }
}
