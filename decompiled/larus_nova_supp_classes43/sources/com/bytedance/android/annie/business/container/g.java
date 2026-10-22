package com.bytedance.android.annie.business.container;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends com.bytedance.ies.web.jsbridge2.g<JsonObject, Object> {
    public final /* synthetic */ AnnieXLiveHybridComponent a;

    public g(AnnieXLiveHybridComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, CallContext r11) {
        JsonObject r12 = (JsonObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        JsonElement r13 = r12.get("eventName");
        if (r13 != null) goto L5;
        return null;
    L5:
        if (r13.isJsonPrimitive() == true) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r13.getAsJsonPrimitive().getAsString()) == true) goto L23;
        JsonElement r14 = r12.get("noLivePrefix");
        if (r14 != null) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L17;
        String r16 = "noLivePrefix" + r13.getAsString();
    L18:
        this.a.h.put(r16, (Map<String, String>) GsonProtectorUtils.fromJson(new Gson(), r12.get("params"), new f().getType()));
        return null;
    L17:
        r16 = r13.getAsString();
        goto L18
    L12:
        if (r14.isJsonPrimitive() == false) goto L14;
        r15 = r14.getAsJsonPrimitive().getAsBoolean();
        goto L15
    L23:
        return null;
    }
}
