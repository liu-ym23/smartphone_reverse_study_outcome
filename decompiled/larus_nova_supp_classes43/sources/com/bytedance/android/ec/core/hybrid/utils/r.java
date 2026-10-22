package com.bytedance.android.ec.core.hybrid.utils;

import android.app.Activity;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r {
    static {
    }

    @JvmStatic
    public static final void a(String r10, Activity r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (r10 == null) goto L13;
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L7;
        String r1 = r10;
    L8:
        if (r1 == null) goto L13;
        int r12 = p0.a;
        String r13 = p0.b(r10, MapsKt.mapOf(TuplesKt.to("is_will_finish", "1")));
        if (r13 == null) goto L13;
        r10 = r13;
        goto L13
    L7:
        r1 = null;
    L13:
        com.bytedance.android.ec.sdk.helper.p.a.d(r10, r11);
    }
}
