package com.ss.android.lark.integrator.ccm.dependency.di;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements gwa.g {
    public final /* synthetic */ gwa.g.a a() {
        return null;
    }

    public final /* synthetic */ boolean isDoubaoEnterpriseUser() {
        return false;
    }

    public final /* synthetic */ void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
    }

    public final String getHost() {
        return "https://www." + ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).getMainDomain();
    }

    public final gwa.g.b getSecurityComplianceDependency() {
        return new gwa.f();
    }

    public g() {
    }
}
