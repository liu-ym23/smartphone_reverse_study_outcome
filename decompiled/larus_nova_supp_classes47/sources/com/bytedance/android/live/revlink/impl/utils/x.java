package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "activityId");
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        if ((!Intrinsics.areEqual(r2, DataType.FALSE)) == false) goto L7;
        return true;
    L7:
        if (r3 == IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal()) goto L12;
        return false;
    L12:
        return true;
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(r2, ""), r3);
    }
}
