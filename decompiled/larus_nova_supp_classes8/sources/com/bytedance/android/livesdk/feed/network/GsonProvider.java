package com.bytedance.android.livesdk.feed.network;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.feed.services.FeedItemDeserializer;
import com.bytedance.android.livesdk.feed.services.c;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GsonProvider implements c.b<Gson> {

    public static abstract class AbsJsonDeserializer<T> implements JsonDeserializer<T> {
        public final Gson a;

        public AbsJsonDeserializer(Gson r1) {
            this.a = r1;
        }
    }

    public static class BaseListResponseDeserializer extends AbsJsonDeserializer<BaseListResponse> {
        public BaseListResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) throws JsonParseException {
            JsonObject r7 = r4.getAsJsonObject();
            int r0 = r7.get("status_code").getAsInt();
            if (r0 == 0) goto L13;
            BaseListResponse r8 = new BaseListResponse();
            r8.statusCode = r0;
            r8.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r7.get("data"), RequestError.class);
            if ((r5 instanceof ParameterizedType) == false) goto L11;
            Type[] r9 = ((ParameterizedType) r5).getActualTypeArguments();
            if (r9.length > 1) goto L10;
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), Extra.class);
            return r8;
        L10:
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), r9[1]);
            return r8;
        L11:
            r8.extra = (Extra) GsonProtectorUtils.fromJson(this.a, r7.get("extra"), Extra.class);
            return r8;
        L13:
            return (BaseListResponse) GsonProtectorUtils.fromJson(this.a, r4, r5);
        }
    }

    public static class BaseResponseDeserializer extends AbsJsonDeserializer<BaseResponse> {
        public BaseResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) throws JsonParseException {
            BaseResponse r5 = (BaseResponse) GsonProtectorUtils.fromJson(this.a, r2, r3);
            if (r5.statusCode == 0) goto L5;
            r5.error = (RequestError) GsonProtectorUtils.fromJson(this.a, r2.getAsJsonObject().get("data"), RequestError.class);
        L5:
            return r5;
        }
    }

    public static class BooleanTypeAdapter extends TypeAdapter<Boolean> {
        private BooleanTypeAdapter() {
        }

        public /* synthetic */ BooleanTypeAdapter(int r1) {
            this();
        }

        public final Object read(JsonReader r5) throws IOException {
            JsonToken r0 = r5.peek();
            int r1 = a.a[r0.ordinal()];
            boolean r2 = true;
            if (r1 == 1) goto L17;
            if (r1 != 2) goto L7;
            r5.nextNull();
            return null;
        L7:
            if (r1 != 3) goto L14;
            if (r5.nextInt() != 0) goto L18;
            r2 = false;
        L18:
            return Boolean.valueOf(r2);
        L14:
            throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r0);
        L17:
            return Boolean.valueOf(r5.nextBoolean());
        }

        public final void write(JsonWriter r1, Object r2) throws IOException {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            r1.nullValue();
            return;
        L5:
            r1.value(r3);
        }
    }

    public static class ListResponseDeserializer extends AbsJsonDeserializer<ListResponse> {
        public ListResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) throws JsonParseException {
            JsonObject r6 = r3.getAsJsonObject();
            int r0 = r6.get("status_code").getAsInt();
            if (r0 == 0) goto L7;
            ListResponse r7 = new ListResponse();
            ((BaseListResponse) r7).statusCode = r0;
            ((BaseListResponse) r7).extra = (Extra) GsonProtectorUtils.fromJson(this.a, r6.get("extra"), Extra.class);
            ((BaseListResponse) r7).error = (RequestError) GsonProtectorUtils.fromJson(this.a, r6.get("data"), RequestError.class);
            return r7;
        L7:
            return (ListResponse) GsonProtectorUtils.fromJson(this.a, r3, r4);
        }
    }

    public static class ResponseDeserializer extends AbsJsonDeserializer<Response> {
        public ResponseDeserializer(Gson r1) {
            super(r1);
        }

        public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) throws JsonParseException {
            Response r5 = (Response) GsonProtectorUtils.fromJson(this.a, r2, r3);
            if (((BaseResponse) r5).statusCode == 0) goto L5;
            ((BaseResponse) r5).error = (RequestError) GsonProtectorUtils.fromJson(this.a, r2.getAsJsonObject().get("data"), RequestError.class);
        L5:
            return r5;
        }
    }

    public static class RoomDeserializer implements JsonDeserializer<Room> {
        public final Gson a;

        private RoomDeserializer() {
            this.a = GsonHelper.get();
        }

        public /* synthetic */ RoomDeserializer(int r1) {
            this();
        }

        public final Object deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException {
            Room r4 = (Room) GsonProtectorUtils.fromJson(this.a, r1, r2);
            r4.init();
            return r4;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            a = r0;
            r0[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public GsonProvider() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [R, com.google.gson.Gson] */
    @Override // com.bytedance.android.livesdk.feed.services.c.b
    public final c.b.a<Gson> a(c.b.a<Gson> r5) {
        GsonBuilder r0 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        int r3 = 0;
        r0.registerTypeAdapter(Room.class, new RoomDeserializer(r3));
        r0.registerTypeAdapter(FeedItem.class, new FeedItemDeserializer());
        r0.registerTypeAdapter(Boolean.class, new BooleanTypeAdapter(r3));
        r0.registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter(r3));
        Gson r1 = r0.create();
        r0.registerTypeAdapter(BaseResponse.class, new BaseResponseDeserializer(r1));
        r0.registerTypeAdapter(Response.class, new ResponseDeserializer(r1));
        r0.registerTypeAdapter(BaseListResponse.class, new BaseListResponseDeserializer(r1));
        r0.registerTypeAdapter(ListResponse.class, new ListResponseDeserializer(r1));
        r5.a = r0.create();
        r5.b = true;
        return r5;
    }
}
