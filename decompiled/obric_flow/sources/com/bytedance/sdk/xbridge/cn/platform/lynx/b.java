package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends bj.a {
    public final ReadableMap I;
    public final String J;
    public final PlatformType K;
    public final ReadableMap L;
    public final String M;

    public b(String r5, String r10, ReadableMap r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        super(r5);
        this.I = r11;
        this.J = r10;
        this.K = PlatformType.f7287a;
        if (r11 != null) goto L21;
    L7:
        if (r11 != null) goto L9;
    L11:
        if (r11 != null) goto L13;
    L17:
        if (r11 != null) goto L19;
        r11 = new JavaOnlyMap();
    L19:
        this.L = r11;
        this.M = this.J;
        return;
    L13:
        if (r11.hasKey("data") != true) goto L17;
        r11 = r11.getMap("data");     // Catch: Exception -> L16
    L16:
        r11 = new JavaOnlyMap();
        goto L17
    L9:
        if (r11.hasKey("bigIntStrategy") != true) goto L11;
        this.F = r11.getInt("bigIntStrategy", 0);     // Catch: Exception -> L16
        goto L11
    L21:
        if (r11.hasKey("namespace") != true) goto L7;
        String r12 = r11.getString("namespace");     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r12, "<set-?>");     // Catch: Exception -> L16
        this.d = r12;     // Catch: Exception -> L16
        goto L7
    }

    @Override // bj.a
    public final JSONObject a() {
        ReadableMap r5 = this.L;
        JSONObject r10 = null;
        if ((r5 instanceof JavaOnlyMap) == false) goto L5;
        JavaOnlyMap r11 = (JavaOnlyMap) r5;
    L6:
        if (r11 == null) goto L8;
        r10 = r11.a();
    L8:
        if (r10 == null) goto L10;
        return r10;
    L10:
        return new JSONObject();
    L5:
        r11 = null;
        goto L6
    }

    @Override // bj.a
    public final Object b() {
        return this.L;
    }

    @Override // bj.a
    public final PlatformType c() {
        return this.K;
    }

    @Override // bj.a
    public final String d() {
        return this.M;
    }
}
