package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    public static long a() {
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.core.h.c;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.core.h.a;
        if ((((Number) r0.getValue(null, r1[1])).intValue() & 1) != 0) goto L7;
        return -1;
    L7:
        return ((Number) com.bytedance.android.livesdk.gift.platform.core.h.n.getValue(null, r1[12])).longValue() * 1000;
    }

    static {
    }
}
