package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import vz1.e;
import vz1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/DialogIconModelSerializer;", "Lcom/google/gson/JsonSerializer;", "Lvz1/e;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogIconModelSerializer implements JsonSerializer<e> {
    public DialogIconModelSerializer() {
    }

    public final JsonElement serialize(Object r3, Type r4, JsonSerializationContext r5) {
        e r6 = (e) r3;
        JsonObject r7 = new JsonObject();
        Object r8 = BuildConfig.FLAVOR;
        if (r6 == null) goto L7;
        h1 r0 = r6.a;
        if (r0 == null) goto L7;
        Object r1 = Long.valueOf(r0.getId());
    L8:
        r7.addProperty("gift", String.valueOf(r1));
        if (r6 == null) goto L11;
        boolean r2 = r6.e;
    L12:
        r7.addProperty("isProp", String.valueOf(r2));
        if (r6 == null) goto L18;
        h r9 = r6.g;
        if (r9 == null) goto L18;
        r8 = r9;
    L18:
        r7.addProperty("propInfo", String.valueOf(r8));
        return r7;
    L11:
        r2 = false;
    L7:
        r1 = BuildConfig.FLAVOR;
        goto L8
    }
}
