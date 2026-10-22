package com.bytedance.android.live.core.setting;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f7 {
    public static SharedPreferences a;
    public static long b;

    public static SharedPreferences a() {
        if (a != null) goto L10;
        if (c7.getContext() != null) goto L8;
        d7.a("getLocalSettingExtrasSharedPreferences - context is null", new Exception("getLocalSettingExtrasSharedPreferences - context is null"));
        return null;
    L8:
        a = c7.getContext().getSharedPreferences("ttlive_setting_extra", 0);
    L10:
        return a;
    }

    @JvmStatic
    public static final Map<String, String> b() {
        HashMap r0 = new HashMap();
        SharedPreferences r1 = a();
        if (r1 == null) goto L9;
        String r2 = r1.getString("dolphin_extra", "");
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put("dolphin_extra", r2);
        e7.a("get setting dolphin extra: ".concat(r2));
    L9:
        r0.put("dolphin_incr", GamePromoteDataContext.GAME_TYPE_MOBILE);
        return r0;
    }

    @JvmStatic
    public static final void c() {
        Intrinsics.checkNotNullParameter("v2", "version");
        b = System.currentTimeMillis();
        e7.a("set setting sdk version: v2");
    }

    static {
    }

    @JvmStatic
    public static final void d(JsonObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.has("dolphin_extra") == false) goto L15;
        String r3 = r2.get("dolphin_extra").getAsString();
        SharedPreferences r1 = a();
        if (r1 == null) goto L12;
        SharedPreferences.Editor r4 = r1.edit();
        if (r4 == null) goto L12;
        SharedPreferences.Editor r0 = r4.putString("dolphin_extra", r3);
        if (r0 == null) goto L12;
        r0.apply();
    L12:
        e7.a("update dolphin extra: " + r3);
        return;
    }
}
