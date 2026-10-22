package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/network/gson/EmptyResponseInstanceCreator;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/network/response/a;", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptyResponseInstanceCreator implements JsonDeserializer<a> {
    public final Gson a;

    public EmptyResponseInstanceCreator(Gson r2) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        this.a = r2;
    }

    public final Object deserialize(JsonElement r5, Type r6, JsonDeserializationContext r7) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "typeOfT");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r5.isJsonObject() == false) goto L14;
        JsonObject r8 = r5.getAsJsonObject();
        JsonElement r9 = r8.get("status_code");
        if (r9 == null) goto L12;
        int r10 = r9.getAsInt();
        if (r10 != 0) goto L10;
        return new b.C0138b((Extra) GsonProtectorUtils.fromJson(this.a, r8.get("extra"), Extra.class));
    L10:
        return new b.a(r10, (RequestError) GsonProtectorUtils.fromJson(this.a, r8.get("data"), RequestError.class), (Extra) GsonProtectorUtils.fromJson(this.a, r8.get("extra"), Extra.class));
    L12:
        throw new IllegalArgumentException(("status_code not found in response: " + r5).toString());
    L14:
        throw new IllegalStateException(("wrong type of json element for " + r6 + ", current: " + r5).toString());
    }
}
