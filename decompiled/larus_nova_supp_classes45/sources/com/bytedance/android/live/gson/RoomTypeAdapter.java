package com.bytedance.android.live.gson;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RoomTypeAdapter implements JsonDeserializer<Room> {
    public RoomTypeAdapter() {
    }

    public final Object deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException {
        Room r4 = (Room) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r1, r2);
        r4.init();
        return r4;
    }
}
