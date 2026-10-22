package com.bytedance.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1562b;
    private Map<String, String> c;

    public d() {
        this.f1562b = -1;
    }

    public void a(int r1) {
        this.f1562b = r1;
    }

    public void a(Map<String, String> r3) {
        this.c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void a(byte[] r1) {
        this.f1561a = r1;
    }

    public byte[] a() {
        return this.f1561a;
    }

    public int b() {
        return this.f1562b;
    }

    public Map<String, String> c() {
        return this.c;
    }
}
