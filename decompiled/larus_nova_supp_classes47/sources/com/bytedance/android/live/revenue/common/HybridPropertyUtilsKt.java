package com.bytedance.android.live.revenue.common;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.s1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class HybridPropertyUtilsKt {
    public static final SharedPreferences a = null;
    public static final w0<Map<String, String>> b = null;
    public static final w0<Boolean> c = null;
    public static final w0<String> d = null;

    static {
        a = s1.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        b = new w0(HybridPropertyUtilsKt$STRING_MAP_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2.INSTANCE);
        c = new w0(HybridPropertyUtilsKt$BOOLEAN_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$BOOLEAN_ADAPTER$2.INSTANCE);
        HybridPropertyUtilsKt$INT_ADAPTER$1 r0 = HybridPropertyUtilsKt$INT_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$INT_ADAPTER$2 r1 = HybridPropertyUtilsKt$INT_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "read");
        Intrinsics.checkNotNullParameter(r1, "write");
        HybridPropertyUtilsKt$LONG_ADAPTER$1 r2 = HybridPropertyUtilsKt$LONG_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$LONG_ADAPTER$2 r3 = HybridPropertyUtilsKt$LONG_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "read");
        Intrinsics.checkNotNullParameter(r3, "write");
        HybridPropertyUtilsKt$FLOAT_ADAPTER$1 r4 = HybridPropertyUtilsKt$FLOAT_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$FLOAT_ADAPTER$2 r5 = HybridPropertyUtilsKt$FLOAT_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "read");
        Intrinsics.checkNotNullParameter(r5, "write");
        d = new w0(HybridPropertyUtilsKt$STRING_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$STRING_ADAPTER$2.INSTANCE);
    }

    public static final void a(String r1, Object r2) {
        a.edit().putString(r1, r2.toString()).apply();
    }

    public static final m b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return new m(r2, r3, d);
    }

    public static final m c(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return new m(r2, r3, b);
    }
}
