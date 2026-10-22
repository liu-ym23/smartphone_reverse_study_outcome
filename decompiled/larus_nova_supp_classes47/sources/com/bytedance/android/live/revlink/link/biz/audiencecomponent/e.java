package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import io.reactivex.functions.Predicate;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Predicate {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final boolean test(Object r4) {
        JSONObject r5 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        if (Intrinsics.areEqual(r5.optString("source"), "TTLiveSDK_Android") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r5.optString("source"), "TTLiveSDK_IOS") == true) goto L12;
        Lazy r1 = LiveSeiUtil.a;
        if (LiveSeiUtil.b(r5.optString("source")) == true) goto L12;
        if (Intrinsics.areEqual(r5.optString("source"), "TTLiveSDK_Windows") == true) goto L12;
        return false;
    }
}
