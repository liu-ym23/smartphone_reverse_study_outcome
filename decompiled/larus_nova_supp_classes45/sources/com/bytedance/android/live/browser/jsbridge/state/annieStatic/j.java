package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.livesdk.config.h4;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public static final Boolean a = null;
    public static final ConcurrentHashMap<String, Pair<JsonElement, Boolean>> b = null;

    public static final class a implements b70.a {
        public a() {
        }

        @Override // b70.a
        public final void onSuccess() {
            j.b.clear();
            AnnieParamUtil.c.clear();
        }
    }

    public static final class b {
    }

    public j() {
    }

    public final com.bytedance.android.annie.api.data.subscribe.g<JsonObject> c() {
        return this;
    }

    public final char d() {
        return ':';
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

    static {
        a = (Boolean) h4.a.getValue();
        b = new ConcurrentHashMap();
        SettingIncStrategy.a(new a());
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.C0113i r0 = com.bytedance.android.live.browser.jsbridge.i.g.C0113i.b;
        return "setting";
    }

    public final JsonElement a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        JsonObject r0 = new JsonObject();
        Iterator r11 = CollectionsKt.asSequence(StringsKt.split$default(r9, new String[]{":"}, false, 0, 6, null)).iterator();
    L4:
        if (r11.hasNext() == false) goto L34;
        String r1 = (String) r11.next();
        Boolean r2 = a;
        if (r2.booleanValue() == false) goto L10;
        Pair<JsonElement, Boolean> r3 = b.get(r1);
        if (r3 == null) goto L10;
        JsonElement r4 = (JsonElement) r3.getFirst();
    L33:
        r0.add(r1, r4);
    L10:
        Gson r5 = GsonHelper.get();
        Object r6 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r1);
        boolean r7 = false;
        if (r6 != null) goto L13;
        JsonElement r8 = null;
    L27:
        if (r2.booleanValue() == false) goto L32;
        ConcurrentHashMap<String, Pair<JsonElement, Boolean>> r12 = b;
        if (r8 != null) goto L31;
        r7 = true;
    L31:
        r12.put(r1, TuplesKt.to(r8, Boolean.valueOf(r7)));
    L32:
        r4 = r8;
        goto L33
    L13:
        if ((r6 instanceof JSONObject) == false) goto L16;
        r8 = GsonProtectorUtils.toJsonTree(r5, GsonProtectorUtils.fromJson(r5, r6.toString(), Object.class));
        goto L27
    L16:
        if ((r6 instanceof JSONArray) == false) goto L19;
        r8 = GsonProtectorUtils.toJsonTree(r5, GsonProtectorUtils.fromJson(r5, r6.toString(), new k().getType()));
        goto L27
    L19:
        if ((r6 instanceof Boolean) == true) goto L21;
        r8 = GsonProtectorUtils.toJsonTree(r5, r6);
        goto L27
    L21:
        if (((Boolean) r6).booleanValue() == false) goto L23;
        r8 = GsonProtectorUtils.toJsonTree(r5, 1);
        goto L27
    L23:
        r8 = GsonProtectorUtils.toJsonTree(r5, 0);
        goto L27
    L34:
        return r0;
    }

    public final JsonElement e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return a(r2);
    }
}
