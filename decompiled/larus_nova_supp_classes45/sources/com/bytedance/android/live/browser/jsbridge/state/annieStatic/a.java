package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import am2.n;
import com.bytedance.android.livesdk.log.u;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public a() {
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
        LinkedHashMap r0 = new LinkedHashMap();
        JsonObject r1 = new JsonObject();
        u.l().c(n.class).u(r0, n.f());
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((String) r3.getValue()) == null) goto L4;
        r1.addProperty((String) r3.getKey(), (String) r3.getValue());
        goto L4
    L8:
        return r1;
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.a r0 = com.bytedance.android.live.browser.jsbridge.i.g.a.b;
        return "adlog";
    }
}
