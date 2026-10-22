package com.bytedance.android.annie.api.data.subscribe;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static JsonElement b(Object r1) {
        return GsonProtectorUtils.toJsonTree(a, r1);
    }

    public static String c(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "any");
        return GsonProtectorUtils.toJson(a, r1);
    }

    public static Object a(String r1, Class r10) {
        Intrinsics.checkNotNullParameter(r1, "jsonStr");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return GsonProtectorUtils.fromJson(a, r1, r10);
    }
}
