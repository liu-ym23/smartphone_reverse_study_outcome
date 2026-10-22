package com.bytedance.android.live.profit.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static b a() {
        FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$1 r0 = FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$1.INSTANCE;
        FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$2 r1 = FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "onStart");
        Intrinsics.checkNotNullParameter(r1, "onEnd");
        return new b(r0, r1, true, true);
    }
}
