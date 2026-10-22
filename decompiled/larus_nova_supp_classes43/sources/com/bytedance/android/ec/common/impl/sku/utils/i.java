package com.bytedance.android.ec.common.impl.sku.utils;

import android.app.Activity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public i() {
    }

    static {
    }

    public static void a(String r10, Activity r11, String r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "orderUrl");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r12, "packLogId");
        Intrinsics.checkNotNullParameter(r13, "skuLogId");
        ECLiveHybridUtil.k(r11, r10, false, false, r14, null, 220);
        com.bytedance.android.ec.core.monitor.j.a(r10, r12, r13);
    }
}
