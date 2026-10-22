package com.bytedance.android.live;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.gson.BooleanTypeAdapterForSaaS;
import com.bytedance.android.live.gson.FeedItemTypeAdapter;
import com.bytedance.android.live.gson.RoomTypeAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveGsonHelper {

    public static class a {
        public static final Gson a = null;
        public static final Gson b = null;

        static {
            a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Room.class, new RoomTypeAdapter()).registerTypeAdapter(FeedItem.class, new FeedItemTypeAdapter()).registerTypeAdapter(Boolean.class, new BooleanTypeAdapterForSaaS()).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapterForSaaS()).create();
            b = new Gson();
            new JsonParser();
        }
    }

    public LiveGsonHelper() {
    }

    public static Gson get() {
        return a.a;
    }

    public static Gson getDefault() {
        return a.b;
    }
}
