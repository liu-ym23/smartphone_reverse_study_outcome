package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class KmpMapPropertyDelegateKt {
    public static final <K> s<K, String> a(Map<K, String> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$kmpProperty");
        return new s(r2, KmpMapPropertyDelegateKt$kmpProperty$3.INSTANCE);
    }
}
