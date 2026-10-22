package com.bytedance.android.livesdk.gift.platform.business.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean a(a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$inEnableDefaultSelectLockedCardTabs");
        return r1.l6().contains(Integer.valueOf(r2));
    }

    public static final boolean b(a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$inEnableManualSelectLockedCardTabs");
        return r1.a5().contains(Integer.valueOf(r2));
    }

    public static final boolean c(a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isEnableDefaultSelectLockedCurrentTab");
        return r1.l6().contains(Integer.valueOf(r2));
    }
}
