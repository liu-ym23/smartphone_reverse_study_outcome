package com.bytedance.sdk.account.save;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3154a = "max_cache";

    static {
    }

    public static int a() {
        JSONObject r0 = ((com.bytedance.sdk.account.platform.api.a) ZeusTransformUtils.preCheckCast(com.bytedance.sdk.account.platform.a.a.a(com.bytedance.sdk.account.platform.api.a.class), com.bytedance.sdk.account.platform.api.a.class, "com.obric.memorydata.plugin")).a();
        int r1 = a.f3134a;
        if (r0 == null) goto L5;
        r1 = r0.optInt(f3154a, a.f3134a);
    L5:
        if (r1 >= 0) goto L9;
        return 0;
    L9:
        return r1;
    }
}
