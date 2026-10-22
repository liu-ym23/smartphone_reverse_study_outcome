package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 {
    public h0() {
    }

    public static JSONObject a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "seiJson");
        if (r2.has("app_data") == false) goto L7;
        String r3 = JSONObjectProtectorUtils.getString(r2, "app_data");     // Catch: Throwable -> L9
        return new JSONObject(new Regex("\\\\").replace(r3, ""));
    L7:
        return null;
    L12:
        return null;
    }

    public static JSONObject b(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L25;
        JSONObject r5 = LiveSeiUtil.a(r4);     // Catch: Throwable -> L19
        if (r5.has("info") == true) goto L12;
        return r5;
    L12:
        if (r5.has("source") == true) goto L14;
        return r5;
    L14:
        if (Intrinsics.areEqual(r5.optString("source"), "zego") == false) goto L24;
        return JSONObjectProtectorUtils.getJSONObject(r5, "info");
    L24:
        return r5;
    L26:
        return null;
    L25:
        return null;
    L7:
        r2 = false;
        goto L8
    }
}
