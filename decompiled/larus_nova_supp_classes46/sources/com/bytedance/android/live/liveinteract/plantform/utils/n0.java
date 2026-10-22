package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.s1;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0 {
    public static final JsonObject a(dg2.e r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toDynamicInfoJsonObject");
        NetworkUtils.NetworkType r6 = NetworkUtils.b(s1.getContext(), NetworkUtils.a);
        boolean r0 = NetworkUtils.e(s1.getContext());
        JsonObject r1 = new JsonObject();
        r1.addProperty("uid", null);
        r1.addProperty("loss_ratio", Double.valueOf(0.0d));
        int r2 = 0;
        r1.addProperty("rtt", 0);
        r1.addProperty("total_band_width", 0);
        r1.addProperty("tx_quality", 0);
        r1.addProperty("rx_quality", 0);
        r1.addProperty("wwan_available", Boolean.valueOf(r0));
        if (r6 != NetworkUtils.NetworkType.WIFI) goto L6;
        r2 = 1;
    L9:
        r1.addProperty("network_status", Integer.valueOf(r2));
        return r1;
    L6:
        if (r6 == NetworkUtils.NetworkType.NONE) goto L9;
        r2 = 2;
        goto L9
    }
}
