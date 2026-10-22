package com.bytedance.android.live.revenue.platform.network.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final Gson a = null;

    static {
        a = GsonHelper.get();
    }

    public static Extra a(Extra r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "originExtra");
        Intrinsics.checkNotNullParameter(r2, "extraType");
        if ((r1 instanceof i) == false) goto L6;
        return (Extra) GsonProtectorUtils.fromJson(a, ((i) r1).b, r2);
    L6:
        return (Extra) r2.newInstance();
    }
}
