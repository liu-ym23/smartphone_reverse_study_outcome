package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public final Gson a;
    public final DataCenter b;

    public final /* synthetic */ JsonElement a(String r1) {
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r1);
    }

    public final /* synthetic */ com.bytedance.android.annie.api.data.subscribe.g c() {
        return com.bytedance.android.annie.api.data.subscribe.f.e(this);
    }

    public final /* synthetic */ char d() {
        return '.';
    }

    public final /* synthetic */ JsonElement e(String r1, String r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.b(this, r1, r2);
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    public final Object g() {
        JsonObject r0 = new JsonObject();
        DataCenter r1 = this.b;
        Boolean r2 = Boolean.FALSE;
        r0.addProperty("enter_from_dou_plus", (Boolean) r1.get("enter_from_dou_plus", r2));
        r0.addProperty("enter_from_effect_ad", (Boolean) this.b.get("enter_from_effect_ad", r2));
        HashMap r3 = (HashMap) this.b.get("live_douplus_log_extra", new HashMap());
        if (r3 != null) goto L5;
        r3 = new HashMap();
    L5:
        r0.add("live_douplus_log_extra", GsonProtectorUtils.toJsonTree(this.a, r3).getAsJsonObject());
        HashMap r4 = (HashMap) this.b.get("live_effect_ad_log_extra_map", new HashMap());
        if (r4 != null) goto L8;
        r4 = new HashMap();
    L8:
        r0.add("live_effect_ad_log_extra_map", GsonProtectorUtils.toJsonTree(this.a, r4).getAsJsonObject());
        return r0;
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.c r0 = com.bytedance.android.live.browser.jsbridge.i.g.c.b;
        return "dou_plus";
    }

    public d(Gson r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
    }
}
