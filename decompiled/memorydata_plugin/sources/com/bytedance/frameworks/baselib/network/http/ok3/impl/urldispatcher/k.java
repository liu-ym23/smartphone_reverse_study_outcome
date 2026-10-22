package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import com.bytedance.retrofit2.client.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2525b;
    private int c;
    private final List<Header> d;

    public k(String r1, String r2) {
        this.f2524a = r1;
        this.f2525b = r2;
        this.c = 0;
        this.d = null;
    }

    public k(String r3, String r4, List<Header> r5) {
        List<Header> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.f2524a = r3;
        this.f2525b = r4;
        this.c = 0;
        this.d = r6;
    }

    public String a() {
        return this.f2525b;
    }

    public void a(int r1) {
        this.c = r1;
    }

    public String b() {
        return this.f2524a;
    }

    public int c() {
        return this.c;
    }

    public List<Header> d() {
        return this.d;
    }
}
