package com.bytedance.android.annie.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final GsonBuilder a = null;
    public static final Gson b = null;
    public static final Gson c = null;

    static {
        GsonBuilder r0 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
        a = r0;
        b = r0.create();
        c = new Gson();
        new JsonParser();
    }
}
