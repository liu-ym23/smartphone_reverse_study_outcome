package com.bytedance.android.ec.core.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final Gson a = null;
        public static final Gson b = null;
        public static final JsonParser c = null;

        static {
            a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter()).registerTypeAdapter(JSONObject.class, new JSONObjectAdapter()).registerTypeAdapter(JSONArray.class, new JSONArrayAdapter()).create();
            b = new Gson();
            c = new JsonParser();
        }
    }

    static {
    }
}
