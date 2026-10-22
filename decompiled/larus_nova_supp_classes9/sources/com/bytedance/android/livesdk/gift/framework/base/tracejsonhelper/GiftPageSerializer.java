package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/GiftPageSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/android/livesdk/gift/model/w1;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPageSerializer implements JsonSerializer<w1> {
    public GiftPageSerializer() {
    }

    public final JsonElement serialize(Object r4, Type r5, JsonSerializationContext r6) {
        w1 r7 = (w1) r4;
        JsonObject r8 = new JsonObject();
        boolean r9 = false;
        if (r7 == null) goto L5;
        int r0 = r7.getPageType();
    L6:
        r8.addProperty("page_type", String.valueOf(r0));
        Object r1 = BuildConfig.FLAVOR;
        if (r7 == null) goto L10;
        String r2 = r7.getPageName();
        if (r2 == null) goto L10;
    L11:
        r8.addProperty("page_name", r2);
        if (r7 == null) goto L14;
        r9 = r7.getDisplay();
    L14:
        r8.addProperty("display", String.valueOf(r9));
        if (r7 == null) goto L20;
        List<h1> r10 = r7.getGifts();
        if (r10 == null) goto L20;
        r1 = r10;
    L20:
        r8.addProperty("gifts", String.valueOf(r1));
        return r8;
    L10:
        r2 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r0 = 0;
        goto L6
    }
}
