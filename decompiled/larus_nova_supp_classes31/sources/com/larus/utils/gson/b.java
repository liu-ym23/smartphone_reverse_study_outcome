package com.larus.utils.gson;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static String a(Object r1) {
        return GsonProtectorUtils.toJson((Gson) a.getValue(), r1);
    }
}
