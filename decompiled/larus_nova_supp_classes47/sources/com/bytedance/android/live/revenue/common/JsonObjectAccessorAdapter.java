package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.revenue.common.p;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revenue/common/JsonObjectAccessorAdapter;", "Lcom/bytedance/android/live/revenue/common/p;", "T", "Lcom/google/gson/JsonSerializer;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JsonObjectAccessorAdapter<T extends p> implements JsonSerializer<T>, JsonDeserializer<T> {
    public JsonObjectAccessorAdapter() {
    }

    public final Object deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, "typeOfT");
        Intrinsics.checkNotNullParameter(r6, "context");
        Type r0 = null;
        if (r4.isJsonNull() == false) goto L6;
        return null;
    L6:
        if (r4.isJsonObject() == false) goto L22;
        JsonObject r7 = r4.getAsJsonObject();
        if ((r5 instanceof Class) == false) goto L11;
        r0 = r5;
    L11:
        Class r1 = (Class) r0;
        if (r1 == null) goto L20;
        Constructor r8 = r1.getDeclaredConstructor(new Class[]{JsonObject.class});
        r8.setAccessible(true);
        Object r9 = r8.newInstance(new Object[]{r7});
        if (r9 == null) goto L18;
        return (p) r9;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L20:
        throw new IllegalArgumentException("Cannot determine class from type: " + r5);
    L22:
        throw new IllegalArgumentException("Expected JsonObject but got ".concat(r4.getClass().getSimpleName()));
    }

    public final JsonElement serialize(Object r2, Type r3, JsonSerializationContext r4) {
        p r5 = (p) r2;
        Intrinsics.checkNotNullParameter(r3, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.a.deepCopy();
    }
}
