package com.bytedance.sdk.xbridge.cn.platform.web;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.bytedance.sdk.xbridge.cn.protocol.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f7408a;

    public a() {
        this.f7408a = new g();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.d
    public final com.bytedance.sdk.xbridge.cn.protocol.g a() {
        return this.f7408a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.d
    public final Object b(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        JSONObject r11 = new JSONObject();
        r11.put("code", r5);
        r11.put("msg", r10);
        return r11;
    }
}
