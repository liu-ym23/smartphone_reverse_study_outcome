package com.bytedance.ies.bullet.core;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f5324c;
    public JSONObject d;
    public LoadStage e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ad.a f5328k;

    public k(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        this.f5322a = r5;
        this.f5324c = new JSONObject();
        this.d = new JSONObject();
        this.e = LoadStage.f5267b;
        this.f = "begin";
        this.g = "unknown";
        this.f5325h = 99999999;
        this.f5327j = "default_bid";
    }

    public final void a(Long r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tracertId");
        Intrinsics.checkNotNullParameter(r11, "sdkType");
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "Tracert init, monitorId " + this.f5322a, null);
        JSONObject r13 = new JSONObject();
        this.d = r13;
        r13.put("entry_start_timestamp", r5.longValue());
        JSONObject r14 = this.f5324c;
        r14.put("tracert_id", r10);
        r14.put("sdk_type", r11);
        this.f5323b = true;
    }

    public final boolean b(JSONObject r5, JSONObject r10) {
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "Tracert inject, monitorId " + this.f5322a + ", " + r5 + ", " + r10, null);
        if (this.f5323b == true) goto L6;
        return false;
    L6:
        if (r5 == null) goto L8;
        com.lynx.tasm.utils.a.i(this.f5324c, r5);
    L8:
        if (r10 == null) goto L12;
        com.lynx.tasm.utils.a.i(this.d, r10);
        return true;
    L12:
        return true;
    }
}
