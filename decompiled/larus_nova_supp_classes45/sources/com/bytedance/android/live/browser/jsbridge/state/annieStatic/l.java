package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.s1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public final com.bytedance.android.annie.api.data.subscribe.g<JsonObject> c() {
        return this;
    }

    public final /* synthetic */ char d() {
        return '.';
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* bridge */ /* synthetic */ Object g() {
        return null;
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.j r0 = com.bytedance.android.live.browser.jsbridge.i.g.j.b;
        return "storage";
    }

    public l() {
    }

    public final JsonElement a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (TextUtils.isEmpty(r4) == true) goto L7;
        Intrinsics.checkNotNullParameter(r4, "key");
        SharedPreferences r0 = s1.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        JsonObject r1 = new JsonObject();
        r1.addProperty(r4, r0.getString(r4, ""));
        return r1;
    L7:
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r4);
    }

    public final JsonElement e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return a(r2);
    }
}
