package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2434b;
    private Map<String, String> c;
    private String d;

    public h(boolean r2) {
        this.f2434b = true;
        this.f2433a = r2;
    }

    public h(boolean r3, boolean r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f2434b = true;
        this.f2433a = r3;
        this.f2434b = r4;
        this.c = r6;
    }

    void a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.d = r2;
    }

    public void a(Map<String, String> r3) {
        this.c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        this.f2434b = r1;
    }

    public boolean a() {
        return this.f2433a;
    }

    public boolean b() {
        return this.f2434b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }
}
