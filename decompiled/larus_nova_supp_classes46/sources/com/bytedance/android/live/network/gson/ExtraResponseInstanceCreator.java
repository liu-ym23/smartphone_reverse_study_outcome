package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.d;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/network/gson/ExtraResponseInstanceCreator;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraResponseInstanceCreator implements JsonDeserializer<ExtraResponse<?, ?>> {
    public final Gson a;

    public ExtraResponseInstanceCreator(Gson r2) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        this.a = r2;
    }

    public final Object deserialize(JsonElement r7, Type r8, JsonDeserializationContext r9) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Intrinsics.checkNotNullParameter(r8, "typeOfT");
        Intrinsics.checkNotNullParameter(r9, "context");
        if ((r8 instanceof ParameterizedType) == false) goto L20;
        if (r7.isJsonObject() == false) goto L18;
        JsonObject r10 = r7.getAsJsonObject();
        JsonElement r0 = r10.get("status_code");
        if (r0 != null) goto L9;
        r0 = r10.get("errno");
    L9:
        if (r0 == null) goto L16;
        int r11 = r0.getAsInt();
        if (r11 != 0) goto L14;
        ParameterizedType r12 = (ParameterizedType) r8;
        return new d.b(GsonProtectorUtils.fromJson(this.a, r10.get("data"), r12.getActualTypeArguments()[0]), (Extra) GsonProtectorUtils.fromJson(this.a, r10.get("extra"), r12.getActualTypeArguments()[1]));
    L14:
        return new d.a(r11, (RequestError) GsonProtectorUtils.fromJson(this.a, r10.get("data"), RequestError.class), (Extra) GsonProtectorUtils.fromJson(this.a, r10.get("extra"), ((ParameterizedType) r8).getActualTypeArguments()[1]));
    L16:
        throw new IllegalArgumentException(("status_code not found in response: " + r7).toString());
    L18:
        throw new IllegalStateException(("wrong type of json element for " + r8 + ", current: " + r7).toString());
    L20:
        throw new IllegalStateException(("typeOfT must be ParameterizedType, current is: " + r8).toString());
    }
}
