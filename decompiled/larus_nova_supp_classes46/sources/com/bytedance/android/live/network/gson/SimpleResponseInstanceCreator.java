package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.network.response.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/network/gson/SimpleResponseInstanceCreator;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/network/response/e;", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleResponseInstanceCreator implements JsonDeserializer<e<?>> {
    public final Gson a;

    public SimpleResponseInstanceCreator(Gson r2) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        this.a = r2;
    }

    public final Object deserialize(JsonElement r5, Type r6, JsonDeserializationContext r7) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "typeOfT");
        Intrinsics.checkNotNullParameter(r7, "context");
        if ((r6 instanceof ParameterizedType) == false) goto L18;
        if (r5.isJsonObject() == false) goto L16;
        JsonObject r8 = r5.getAsJsonObject();
        JsonElement r0 = r8.get("status_code");
        if (r0 == null) goto L14;
        int r9 = r0.getAsInt();
        if (r9 != 0) goto L12;
        return new f.b(GsonProtectorUtils.fromJson(this.a, r8.get("data"), ((ParameterizedType) r6).getActualTypeArguments()[0]), (Extra) GsonProtectorUtils.fromJson(this.a, r8.get("extra"), Extra.class));
    L12:
        return new f.a(r9, (RequestError) GsonProtectorUtils.fromJson(this.a, r8.get("data"), RequestError.class), (Extra) GsonProtectorUtils.fromJson(this.a, r8.get("extra"), Extra.class));
    L14:
        throw new IllegalArgumentException(("status_code not found in response: " + r5).toString());
    L16:
        throw new IllegalStateException(("wrong type of json element for " + r6 + ", current: " + r5).toString());
    L18:
        throw new IllegalStateException(("typeOfT must be ParameterizedType, current is: " + r6).toString());
    }
}
