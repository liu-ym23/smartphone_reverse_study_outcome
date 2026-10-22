package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public f() {
    }

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
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        ca0.l r1 = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGiftWallPreRequestManager();
        JsonElement r2 = null;
        if (r1 == null) goto L5;
        JsonObject r3 = r1.h();
    L6:
        StringBuilder r4 = new StringBuilder("currentState uid=");
        if (r3 == null) goto L9;
        r2 = r3.get("user_id");
    L9:
        r4.append(r2);
        ALogger.w("ttlive_gift_exhibition", r4.toString());
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public final String key() {
        int r0 = com.bytedance.android.live.browser.jsbridge.i.g.e.b;
        return "gift_exhibition_data";
    }
}
