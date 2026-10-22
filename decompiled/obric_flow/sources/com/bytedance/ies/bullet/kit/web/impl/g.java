package com.bytedance.ies.bullet.kit.web.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements sc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.b f5515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f5516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ce.d f5517c;

    public g(com.bytedance.ies.bullet.core.kit.bridge.b r5, i r10, ce.d r11) {
        this.f5515a = r5;
        this.f5516b = r10;
        this.f5517c = r11;
    }

    @Override // sc.a
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        com.bytedance.ies.bullet.core.kit.bridge.b r10 = this.f5515a;
        com.bytedance.ies.bullet.kit.web.jsbridge.d r11 = this.f5516b.f5525h;
        if (r11 == null) goto L6;
        r11.a(r10, this.f5517c.f1179b, r5);
        return;
    }

    @Override // sc.a
    public final void onError(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L7
        r11.put("code", r5);     // Catch: JSONException -> L7
        r11.put("msg", r10);     // Catch: JSONException -> L7
        com.bytedance.ies.bullet.kit.web.jsbridge.d r12 = this.f5516b.f5525h;     // Catch: JSONException -> L7
        if (r12 == null) goto L12;
        r12.a(this.f5515a, this.f5517c.f1179b, r11);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
