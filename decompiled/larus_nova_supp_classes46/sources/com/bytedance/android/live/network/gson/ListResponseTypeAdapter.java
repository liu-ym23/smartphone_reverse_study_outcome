package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ListResponseTypeAdapter extends AbsJsonDeserializer<ListResponse> {
    public ListResponseTypeAdapter(Gson r1) {
        super(r1);
    }

    public final Object deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) throws JsonParseException {
        JsonObject r6 = r3.getAsJsonObject();
        int r0 = r6.get("status_code").getAsInt();
        if (r0 == 0) goto L7;
        ListResponse r7 = new ListResponse();
        r7.statusCode = r0;
        r7.extra = (R) GsonProtectorUtils.fromJson(this.a, r6.get("extra"), Extra.class);
        r7.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r6.get("data"), RequestError.class);
        return r7;
    L7:
        return (ListResponse) GsonProtectorUtils.fromJson(this.a, r3, r4);
    }
}
