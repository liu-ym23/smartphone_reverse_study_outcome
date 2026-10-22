package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/tracejsonhelper/ImageModelSerializer;", "Lcom/google/gson/JsonSerializer;", "Lpy/k;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageModelSerializer implements JsonSerializer<k> {
    public ImageModelSerializer() {
    }

    public final JsonElement serialize(Object r1, Type r2, JsonSerializationContext r3) {
        k r4 = (k) r1;
        return new JsonObject();
    }
}
