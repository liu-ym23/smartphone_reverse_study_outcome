package com.bytedance.ies.bullet.web.pia;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.e f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6250b;

    public s() {
        this.f6250b = new ConcurrentHashMap();
    }

    public final void a(String r5) {
        if (StringsKt.g(r5, "._handleMessageFromToutiao(") == true) goto L5;
        return;
    L5:
        if (StringsKt.g(r5, "__pia_jsb2_glue__") == false) goto L26;
        JSONObject r10 = new JSONObject(StringsKt.a0(StringsKt.S(r5, "._handleMessageFromToutiao("), ")"));     // Catch: JSONException -> L20
        String r11 = r10.getString("__callback_id");     // Catch: JSONException -> L20
        if (r11 == null) goto L24;
        JSONObject r12 = r10.optJSONObject("__params");     // Catch: JSONException -> L20
        if (r12 != null) goto L13;
        r12 = new JSONObject();     // Catch: JSONException -> L20
        r12.put("code", -4);     // Catch: JSONException -> L20
        r12.put("msg", "[GLUE] invalid result format!");     // Catch: JSONException -> L20
    L16:
        fh.a r13 = (fh.a) this.f6250b.remove(r11);     // Catch: JSONException -> L20
        if (r13 == null) goto L25;
        r13.accept(r12);     // Catch: JSONException -> L20
        return;
    L25:
        return;
    L13:
        if (r12.has("__data") == false) goto L16;
        r12.put("data", r12.get("__data"));     // Catch: JSONException -> L20
        goto L16
    L24:
        return;
    L27:
        return;
    }
}
