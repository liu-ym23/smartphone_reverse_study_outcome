package com.bytedance.android.ec.core.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u0 {
    public static Gson a;

    public static Gson c() {
        if (a != null) goto L6;
        a = new Gson();
    L6:
        return a;
    }

    public static String d(Object r1) {
        return GsonProtectorUtils.toJson(c(), r1);
    }

    public static <T> T a(JsonObject r1, Class<T> r10) {
        return (T) c().fromJson(r1, r10);
    L4:
        return null;
    }

    public static <T> T b(String r1, Class<T> r10) {
        return (T) c().fromJson(r1, r10);
    L4:
        return null;
    }

    public static <T> List<T> e(String r1, Class<T[]> r10) {
        Object[] r11 = (Object[]) c().fromJson(r1, r10);     // Catch: Throwable -> L8
        if (r11 != null) goto L7;
        return new ArrayList();
    L7:
        return new ArrayList(Arrays.asList(r11));
    L9:
        return new ArrayList();
    }
}
