package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends bj.a {
    public final PlatformType I;
    public final ReadableMap J;
    public final String K;

    public d(String r5, ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        super(r5);
        this.I = PlatformType.f7289c;
        if (r10 != null) goto L17;
    L7:
        if (r10 != null) goto L9;
    L13:
        if (r10 != null) goto L15;
        r10 = new JavaOnlyMap();
    L15:
        this.J = r10;
        this.K = "";
        return;
    L9:
        if (r10.hasKey("data") != true) goto L13;
        r10 = r10.getMap("data");     // Catch: Exception -> L12
    L12:
        r10 = new JavaOnlyMap();
        goto L13
    L17:
        if (r10.hasKey("namespace") != true) goto L7;
        String r11 = r10.getString("namespace");     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(r11, "<set-?>");     // Catch: Exception -> L12
        this.d = r11;     // Catch: Exception -> L12
        goto L7
    }

    @Override // bj.a
    public final JSONObject a() {
        ReadableMap r5 = this.J;
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
        return this.J;
    }

    @Override // bj.a
    public final PlatformType c() {
        return this.I;
    }

    @Override // bj.a
    public final String d() {
        return this.K;
    }
}
