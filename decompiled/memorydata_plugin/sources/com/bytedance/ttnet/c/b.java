package com.bytedance.ttnet.c;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.h;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3215b;
    private String c;
    private Map<String, String> d;
    private CountDownLatch e;
    private c f;

    b(String r3, int r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f3214a = r3;
        this.f3215b = r4;
        this.d = r6;
        this.c = UUID.randomUUID().toString();
        this.e = new CountDownLatch(1);
    }

    public String a() {
        return this.c;
    }

    public void b() {
        this.e.await();
    }

    public void c() {
        this.e.countDown();
    }

    public c d() {
        return this.f;
    }

    public void e() {
        h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(this.f3214a, this.f3215b, this.c, this.d);
    }

    public void setResult(c r1) {
        this.f = r1;
    }
}
