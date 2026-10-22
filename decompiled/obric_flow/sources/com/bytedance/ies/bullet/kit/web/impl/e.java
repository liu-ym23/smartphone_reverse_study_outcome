package com.bytedance.ies.bullet.kit.web.impl;

import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements IBridge3Registry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f5510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.web.b f5511b;

    public e(i r5, com.bytedance.sdk.xbridge.cn.platform.web.b r10) {
        this.f5510a = r5;
        this.f5511b = r10;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry
    public final void handle(String r5, JSONObject r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        if (r10 != null) goto L5;
        r10 = new JSONObject();
    L5:
        String r12 = this.f5510a.f5528k;
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.bytedance.sdk.xbridge.cn.platform.web.c r13 = new com.bytedance.sdk.xbridge.cn.platform.web.c(r5, r12, r10);
        d r14 = new d(r13, r11);
        this.f5511b.l(r13, r14);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry, com.bytedance.ies.bullet.service.base.m
    public final void release() {
    }
}
