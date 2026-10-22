package com.bytedance.android.live.lynx.components;

import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends com.bytedance.ies.web.jsbridge2.g<JsonObject, Object> {
    public final /* synthetic */ LiveLynxComponentForSaas a;

    public e(LiveLynxComponentForSaas r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, CallContext r5) {
        JsonObject r6 = (JsonObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        JsonElement r7 = r6.get("eventName");
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.isJsonPrimitive() == false) goto L22;
        String r1 = r7.getAsJsonPrimitive().getAsString();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L23;
        String r8 = r7.getAsString();
        JsonElement r9 = r6.get("params");
        Map<String, Map<String, String>> r0 = this.a.n;
        Map<String, String> r10 = (Map) GsonProtectorUtils.fromJson(LiveGsonHelper.getDefault(), r9, new d().getType());
        if (r10 != null) goto L18;
        r10 = new LinkedHashMap();
    L18:
        r0.put(r8, r10);
        return null;
    L23:
        return null;
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r2 = false;
        goto L13
    L22:
        return null;
    }
}
