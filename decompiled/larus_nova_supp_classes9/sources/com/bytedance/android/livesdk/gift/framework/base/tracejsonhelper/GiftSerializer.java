package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/GiftSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSerializer implements JsonSerializer<h1> {
    public GiftSerializer() {
    }

    public final JsonElement serialize(Object r3, Type r4, JsonSerializationContext r5) {
        h1 r6 = (h1) r3;
        JsonObject r7 = new JsonObject();
        if (r6 == null) goto L5;
        boolean r8 = r6.isDisplayedOnPanel();
    L6:
        r7.addProperty("is_displayed_on_panel", String.valueOf(r8));
        if (r6 == null) goto L9;
        long r0 = r6.getId();
    L10:
        r7.addProperty("id", String.valueOf(r0));
        return r7;
    L9:
        r0 = 0;
        goto L10
    L5:
        r8 = false;
        goto L6
    }
}
