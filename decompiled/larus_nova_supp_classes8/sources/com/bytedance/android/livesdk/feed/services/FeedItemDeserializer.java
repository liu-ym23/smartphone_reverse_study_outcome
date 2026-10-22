package com.bytedance.android.livesdk.feed.services;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedItemDeserializer implements JsonDeserializer<FeedItem> {
    public final Gson a;

    public FeedItemDeserializer() {
        this.a = GsonHelper.get();
    }

    public final Object deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) throws JsonParseException {
        FeedItem r7 = (FeedItem) this.a.fromJson(r4, FeedItem.class);     // Catch: Exception -> L22
        JsonObject r8 = r4.getAsJsonObject();     // Catch: Exception -> L22
        int r0 = r7.type;     // Catch: Exception -> L22
        if (r0 != 1) goto L5;
    L20:
        r7.setItem((Item) r6.deserialize(r8.get("data"), Room.class));     // Catch: Exception -> L22
    L21:
        return r7;
    L5:
        if (r0 == 2) goto L20;
        if (r0 != 3) goto L9;
        String r9 = new String(Base64.decode(r8.get("ad").getAsString(), 1));     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r9) == true) goto L21;
        r7.adJSONObject = new JSONObject(r9);     // Catch: Exception -> L22
        r7.setItem((Item) GsonHelper.get().fromJson(r9, HotsoonAd.class));     // Catch: Exception -> L22
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L22
        r7.getItem().setSubId(r1);     // Catch: Exception -> L22
        r7.adJSONObject.put("subId", r1);     // Catch: JSONException -> L18 Exception -> L22
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L22
        goto L21
    L9:
        if (r0 == 4) goto L20;
        if (r0 == 5) goto L20;
    L22:
        e = move-exception;
        e.printStackTrace();
        throw new JsonParseException("error type");
    }
}
