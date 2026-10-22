package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends bj.a {
    public final JSONObject I;
    public final String J;
    public final PlatformType K;
    public String L;
    public String M;
    public String N;

    public c(String r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "url");
        super(r5);
        this.I = r11;
        this.J = r10;
        int r12 = 0;
        r12 = r11.optInt("bigIntStrategy", 0);     // Catch: Exception -> L6
    L4:
        this.F = r12;
        this.K = PlatformType.f7288b;
        this.L = "";
        this.M = "";
        this.N = "";
    }

    @Override // bj.a
    public final JSONObject a() {
        return this.I;
    }

    @Override // bj.a
    public final Object b() {
        return this.I;
    }

    @Override // bj.a
    public final PlatformType c() {
        return this.K;
    }

    @Override // bj.a
    public final String d() {
        return this.J;
    }
}
