package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.h;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/network/gson/LazyDataJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "", "Lcom/bytedance/android/live/base/model/h;", "<init>", "()V", "livenetwork_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LazyDataJsonAdapter implements JsonDeserializer<List<h>> {
    public LazyDataJsonAdapter() {
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        return CollectionsKt.mutableListOf(new h[]{new h(null, r2)});
    }
}
