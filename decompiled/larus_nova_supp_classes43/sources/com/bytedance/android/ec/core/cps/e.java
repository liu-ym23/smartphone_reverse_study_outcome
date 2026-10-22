package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final JSONObject a(h r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toJSON");
        JSONObject r0 = new JSONObject();
        r0.put("v", r10.g());
        r0.put("e", r10.b());
        r0.put("d", r10.d());
        r0.put("t", r10.f());
        r0.put("h", r10.c());
        r0.put("r", r10.e());
        r0.put("c", r10.a());
        return r0;
    }
}
