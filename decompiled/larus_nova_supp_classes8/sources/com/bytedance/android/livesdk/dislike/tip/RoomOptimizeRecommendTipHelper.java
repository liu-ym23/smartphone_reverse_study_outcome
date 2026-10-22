package com.bytedance.android.livesdk.dislike.tip;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.livesdk.log.u;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RoomOptimizeRecommendTipHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(RoomOptimizeRecommendTipHelper$hintService$2.INSTANCE);
    }

    public static boolean a() {
        if (TextUtils.equals((String) u.l().c(x.class).getMap().get("enter_from_merge"), "homepage_hot") == false) goto L6;
        return true;
    L6:
        return false;
    }
}
