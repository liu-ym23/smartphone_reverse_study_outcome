package com.bytedance.android.annie.xbridge.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.annie.xbridge.mix.JSB2ConvertUtilsKt$getStatefulMethodV2$1] */
    public static final JSB2ConvertUtilsKt$getStatefulMethodV2$1 a(final com.bytedance.ies.web.jsbridge2.f r1, final String r10, final m16.b r11) {
        Intrinsics.checkNotNullParameter(r1, "method");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "contextProviderFactory");
        return new JSB2ConvertUtilsKt$getStatefulMethodV2$1(r10, r11, r1);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.annie.xbridge.mix.JSB2ConvertUtilsKt$getStatelessMethodV2$1] */
    public static final JSB2ConvertUtilsKt$getStatelessMethodV2$1 b(final com.bytedance.ies.web.jsbridge2.g r1, final String r10, final m16.b r11) {
        Intrinsics.checkNotNullParameter(r1, "method");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "contextProviderFactory");
        return new JSB2ConvertUtilsKt$getStatelessMethodV2$1(r10, r11, r1);
    }
}
