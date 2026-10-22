package com.bytedance.android.live.profit.dress;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/dress/DressModelWrapperJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/live/profit/dress/DressModelWrapper;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
final class DressModelWrapperJsonAdapter implements JsonDeserializer<DressModelWrapper>, JsonSerializer<DressModelWrapper> {
    public DressModelWrapperJsonAdapter() {
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "typeOfT");
        Intrinsics.checkNotNullParameter(r4, "context");
        return new DressModelWrapper((o) r4.deserialize(r2, o.class), null, r2.getAsJsonObject());
    }

    public final JsonElement serialize(Object r2, Type r3, JsonSerializationContext r4) {
        DressModelWrapper r5 = (DressModelWrapper) r2;
        Intrinsics.checkNotNullParameter(r5, "src");
        Intrinsics.checkNotNullParameter(r3, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r4, "context");
        JsonObject r6 = r5.getJson();
        if (r6 == null) goto L6;
        return r6;
    L6:
        return r4.serialize(r5.getDecoded());
    }
}
