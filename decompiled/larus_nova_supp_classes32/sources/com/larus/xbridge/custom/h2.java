package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h2 {
    public static final com.bytedance.sdk.xbridge.cn.network.a.c a(com.bytedance.ies.bullet.prefetchv2.v r2, Number r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "prefetchStatus");
        com.bytedance.sdk.xbridge.cn.network.a.c r0 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
        r0.setHttpCode(r2.a);
        r0.setClientCode(null);
        r0.setHeader(r2.b);
        r0.setPrefetchStatus(r3);
        ConvertUtils r4 = ConvertUtils.INSTANCE;     // Catch: Throwable -> L8
        JSONObject r5 = r2.c;     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        r5 = new JSONObject();     // Catch: Throwable -> L8
    L6:
        r0.setResponse(r4.jsonToMap(r5));     // Catch: Throwable -> L8
    L9:
        return r0;
    L8:
        int r6 = XRequestMethod.d;
        goto L9
    }
}
