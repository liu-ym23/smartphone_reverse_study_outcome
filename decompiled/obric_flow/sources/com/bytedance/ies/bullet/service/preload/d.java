package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.pool.g;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.bytedance.ies.bullet.core.kit.bridge.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b f6114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBridgeMethod$Access f6115c;
    public final String d;
    public final Lazy e;
    public final long f;

    public d(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f6114b = r5;
        this.f6115c = IBridgeMethod$Access.f5959a;
        this.d = "__prerender";
        this.e = LazyKt.lazy(new WebPreRenderBridge$poolService$2(this));
        this.f = 10000;
    }

    public static JSONObject h(int r5, String r10, boolean r11) {
        JSONObject r12 = new JSONObject();
        r12.put("code", r5);
        JSONObject r13 = new JSONObject();
        r13.put("__status_message__", r10);
        r13.put("container", "BulletX");
        r13.put("result", r11);
        Unit r14 = Unit.INSTANCE;
        r12.put("data", r13);
        return r12;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final void a(JSONObject r12, sc.a r13) {
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r14 = r12.optString("schema");
        com.bytedance.ies.bullet.core.container.e r5 = (com.bytedance.ies.bullet.core.container.e) this.f6114b.a(com.bytedance.ies.bullet.core.container.e.class);
        Context r10 = null;
        if (r5 == null) goto L5;
        com.bytedance.ies.bullet.core.e r11 = r5.getBulletContext();
    L6:
        if (r11 == null) goto L8;
        r10 = r11.f5294h;
    L8:
        Context r15 = r10;
        if (r15 != null) goto L12;
        r13.a(h(-1, "context is null", false));
        return;
    L12:
        Uri r16 = Uri.parse(r14);
        Lazy r17 = this.e;
        g r18 = (g) r17.getValue();
        if (r18 == null) goto L16;
        s6.c r19 = new s6.c(4, this, r13);
        Intrinsics.checkNotNullParameter(r16, "schema");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r19, "callback");
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r21 = new StringBuilder("start to preRender on schema: ");
        r21.append(r16);
        r21.append(", duration: ");
        long r22 = this.f;
        r21.append(r22);
        com.bytedance.ies.bullet.service.base.b.a(2, r21.toString(), "XPreRender");
        r18.b(r16, r15, r22, r19, new com.bytedance.ies.bullet.pool.b(r15, r18.f5811a, r16));
    L16:
        if (((g) r17.getValue()) != null) goto L19;
        r13.a(h(-3, "poolService is null", false));
        return;
    L19:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final IBridgeMethod$Access f() {
        return this.f6115c;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final String g() {
        return this.d;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b, com.bytedance.ies.bullet.service.base.m
    public final void release() {
    }
}
