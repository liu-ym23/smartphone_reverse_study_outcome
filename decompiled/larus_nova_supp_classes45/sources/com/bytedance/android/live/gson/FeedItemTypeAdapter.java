package com.bytedance.android.live.gson;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FeedItemTypeAdapter implements JsonDeserializer<FeedItem>, JsonSerializer<FeedItem> {
    public FeedItemTypeAdapter() {
    }

    public final Object deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException {
        FeedItem r4 = (FeedItem) GsonHelper.getDefault().fromJson(r1, FeedItem.class);     // Catch: Exception -> L4
        r4.init();     // Catch: Exception -> L4
        return r4;
    L4:
        e = move-exception;
        e.printStackTrace();
        throw new JsonParseException("error type");
    }

    public final JsonElement serialize(Object r2, Type r3, JsonSerializationContext r4) {
        FeedItem r5 = (FeedItem) r2;
        JsonObject r6 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r5).getAsJsonObject();
        r6.add("data", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r5.getRoom(), Room.class));
        return r6;
    }
}
