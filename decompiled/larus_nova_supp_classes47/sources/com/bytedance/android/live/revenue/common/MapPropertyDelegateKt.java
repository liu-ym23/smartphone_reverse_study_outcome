package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MapPropertyDelegateKt {
    public static final <K> w<K, String> a(Map<K, String> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$property");
        return new w(r2, MapPropertyDelegateKt$property$3.INSTANCE);
    }
}
