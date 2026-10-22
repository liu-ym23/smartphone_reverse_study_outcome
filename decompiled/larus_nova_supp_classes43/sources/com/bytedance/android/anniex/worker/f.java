package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends le7.a<ReadableMap> {
    public final PlatformType M;
    public final ReadableMap N;
    public final String O;

    public final JSONObject a() {
        JavaOnlyMap r0 = this.N;
        JSONObject r10 = null;
        if ((r0 instanceof JavaOnlyMap) == false) goto L5;
        JavaOnlyMap r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r10 = r1.toJSONObject();
    L8:
        if (r10 == null) goto L10;
        return r10;
    L10:
        return new JSONObject();
    L5:
        r1 = null;
        goto L6
    }

    public final Object b() {
        return this.N;
    }

    public final PlatformType c() {
        return this.M;
    }

    public final String d() {
        return this.O;
    }

    public f(String r10, ReadableMap r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        super(r10);
        this.M = PlatformType.WORKER;
        boolean r12 = false;
        if (r11 != null) goto L23;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L11;
        e(r11.getString("namespace"));     // Catch: Exception -> L18
    L11:
        if (r11 != null) goto L13;
    L15:
        if (r12 == false) goto L19;
        r11 = r11.getMap("data");     // Catch: Exception -> L18
    L18:
        r11 = new JavaOnlyMap();
    L19:
        if (r11 != null) goto L21;
        r11 = new JavaOnlyMap();
    L21:
        this.N = r11;
        this.O = "";
        return;
    L13:
        if (r11.hasKey("data") != true) goto L15;
        r12 = true;
        goto L15
    L23:
        if (r11.hasKey("namespace") != true) goto L7;
        r13 = true;
        goto L8
    }
}
