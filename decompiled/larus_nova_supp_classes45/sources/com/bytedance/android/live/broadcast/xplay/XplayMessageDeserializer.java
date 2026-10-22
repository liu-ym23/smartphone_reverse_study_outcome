package com.bytedance.android.live.broadcast.xplay;

import a10.a;
import a10.d;
import a10.e;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/xplay/XplayMessageDeserializer;", "Lcom/google/gson/JsonDeserializer;", "La10/d;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class XplayMessageDeserializer implements JsonDeserializer<d> {
    public XplayMessageDeserializer() {
    }

    public final Object deserialize(JsonElement r5, Type r6, JsonDeserializationContext r7) {
        if (r5 == null) goto L31;
        JsonObject r8 = r5.getAsJsonObject();
        if (r8 == null) goto L31;
        JsonElement r9 = r8.get("action");
        String r11 = "";
        if (r9 == null) goto L9;
        String r12 = r9.getAsString();
        if (r12 == null) goto L9;
    L10:
        XplayMessageType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r12, "messageKey");
        XplayMessageType r0 = (XplayMessageType) XplayMessageType.access$getTypeMap$cp().get(r12);
        if (r0 != null) goto L13;
        r0 = XplayMessageType.UNKNOWN;
    L13:
        Class<? extends a> r1 = r0.getMessageType();
        JsonElement r13 = r8.get("body");
        JsonObject r2 = null;
        if (r13 == null) goto L16;
        JsonObject r14 = r13.getAsJsonObject();
    L17:
        Gson r3 = GsonHelper.get();
        if (r14 == null) goto L20;
        r2 = r14.getAsJsonObject("data");
    L20:
        a r4 = (a) GsonProtectorUtils.fromJson(r3, r2, r1);
        if (r14 == null) goto L29;
        JsonElement r15 = r14.get("type");
        if (r15 == null) goto L29;
        String r16 = r15.getAsString();
        if (r16 == null) goto L29;
        r11 = r16;
    L29:
        return new d(r12, new e(r11, r4), 2);
    L16:
        r14 = null;
    L9:
        r12 = "";
    L31:
        throw new JsonParseException("json object is null");
    }
}
