package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Predicate {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final boolean test(Object r4) {
        JSONObject r5 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_Android") == false) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_IOS") == true) goto L12;
        LiveSeiUtil r1 = LiveSeiUtil.i;
        String r2 = r5.optString("source");
        r1.getClass();
        if (LiveSeiUtil.d(r2) == true) goto L12;
        if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_Windows") == true) goto L12;
        return false;
    }
}
