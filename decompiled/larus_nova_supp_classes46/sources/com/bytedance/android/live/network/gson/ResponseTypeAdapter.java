package com.bytedance.android.live.network.gson;

import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ResponseTypeAdapter extends AbsJsonDeserializer<Response> {
    public ResponseTypeAdapter(Gson r1) {
        super(r1);
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) throws JsonParseException {
        Response r5 = (Response) GsonProtectorUtils.fromJson(this.a, r2, r3);
        if (r5.statusCode == 0) goto L5;
        r5.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r2.getAsJsonObject().get("data"), RequestError.class);
    L5:
        return r5;
    }
}
