package com.bytedance.ies.bullet.lynx.impl;

import android.view.View;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.v0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements IBridge3Registry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f5653a;

    public d(e r5) {
        this.f5653a = r5;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry
    public final void handle(String r5, JSONObject r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r12 = this.f5653a.e;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        r10 = new JSONObject();
    L7:
        JavaOnlyMap r13 = v0.h(r10, 0);
        LynxView r14 = (LynxView) ((View) r12.t().e.get());
        if (r14 == null) goto L11;
        String r15 = r14.getTemplateUrl();
        if (r15 == null) goto L11;
    L12:
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r16 = new com.bytedance.sdk.xbridge.cn.platform.lynx.b(r5, r15, r13);
        r12.l(r16, new com.bytedance.sdk.xbridge.cn.platform.lynx.g(new r6.a(r11), r16, r12.t()));
        return;
    L11:
        r15 = "";
        goto L12
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry, com.bytedance.ies.bullet.service.base.m
    public final void release() {
    }
}
