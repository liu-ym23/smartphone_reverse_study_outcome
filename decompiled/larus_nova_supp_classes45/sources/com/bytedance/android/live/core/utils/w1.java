package com.bytedance.android.live.core.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w1 {
    public static final Map<String, String> a = null;

    static {
        a = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(String r1, String r2) {
        if (v.a() == false) goto L8;
        if (r2 == null) goto L9;
        a.put(r1, r2);
        return;
    L9:
        return;
    }
}
