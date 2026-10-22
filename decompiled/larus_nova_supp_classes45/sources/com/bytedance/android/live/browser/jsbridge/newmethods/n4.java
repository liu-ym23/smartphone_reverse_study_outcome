package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.foundation.depend.IUgSettingCallback;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n4 implements IUgSettingCallback {
    public final /* synthetic */ o4 a;

    public n4(o4 r1) {
        this.a = r1;
    }

    public final void onResult(Map<String, Object> r7) {
        if (r7 != null) goto L4;
        this.a.finishWithFailure();
        return;
    L4:
        JsonObject r0 = new JsonObject();
        JsonObject r1 = new JsonObject();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<String, Object> r3 = r8.next();
        if (r3.getValue() == null) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2.put(r3.getKey(), r3.getValue());
        goto L6
    L10:
        r4 = false;
        goto L11
    L13:
        Iterator r9 = r2.entrySet().iterator();
    L15:
        if (r9.hasNext() == false) goto L27;
        Map.Entry r5 = (Map.Entry) r9.next();
        o4 r6 = this.a;
        Object r11 = r5.getValue();
        r6.getClass();
        Gson r12 = GsonHelper.get();
        if (r11 != null) goto L19;
        JsonElement r13 = null;
    L26:
        r1.add(StringsKt.removePrefix((String) r5.getKey(), this.a.a), r13);
        goto L15
    L19:
        if ((r11 instanceof JSONObject) == false) goto L22;
        r13 = GsonProtectorUtils.toJsonTree(r12, GsonProtectorUtils.fromJson(r12, r11.toString(), Object.class));
        goto L26
    L22:
        if ((r11 instanceof JSONArray) == false) goto L24;
        r13 = GsonProtectorUtils.toJsonTree(r12, GsonProtectorUtils.fromJson(r12, r11.toString(), new m4().getType()));
        goto L26
    L24:
        r13 = GsonProtectorUtils.toJsonTree(r12, r11);
        goto L26
    L27:
        r0.add("data", r1);
        this.a.finishWithResult(r0);
    }
}
