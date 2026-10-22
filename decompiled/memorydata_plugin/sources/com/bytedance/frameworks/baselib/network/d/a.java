package com.bytedance.frameworks.baselib.network.d;

import com.bytedance.retrofit2.client.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Header> f2317b;

    public a(String r3, List<Header> r4) {
        List<Header> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f2316a = r3;
        this.f2317b = r5;
    }
}
