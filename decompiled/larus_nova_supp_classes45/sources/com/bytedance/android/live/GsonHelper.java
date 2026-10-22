package com.bytedance.android.live;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.gson.BooleanTypeAdapter;
import com.bytedance.android.live.gson.LynxPassthroughSaasAdapter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class GsonHelper {
    private static Map<Class<?>, Map<String, String>> fieldNameMapping;

    public static class a {
        public static final GsonBuilder a = null;
        public static final Gson b = null;
        public static final Gson c = null;
        public static final Gson d = null;
        public static final JsonParser e = null;

        static {
            GsonBuilder r0 = new GsonBuilder();
            FieldNamingPolicy r1 = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
            GsonBuilder r2 = r0.setFieldNamingPolicy(r1).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter());
            Class r3 = Boolean.TYPE;
            GsonBuilder r4 = r2.registerTypeAdapter(r3, new BooleanTypeAdapter());
            a = r4;
            int r5 = LynxPassthroughSaasAdapter.a;
            GsonBuilder r6 = new GsonBuilder().setFieldNamingPolicy(r1).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).registerTypeAdapter(r3, new BooleanTypeAdapter());
            Intrinsics.checkNotNullParameter(r6, "gsonBuilder");
            r6.setExclusionStrategies(new ExclusionStrategy[]{new com.bytedance.android.live.gson.a()}).registerTypeHierarchyAdapter(ja0.a.class, new LynxPassthroughSaasAdapter());
            b = r6.create();
            c = r4.create();
            d = new Gson();
            e = new JsonParser();
        }
    }

    public GsonHelper() {
    }

    static {
        fieldNameMapping = new HashMap();
        registerFieldNameMapping(Object.class, "user_infos", "open_user_infos");
        registerFieldNameMapping(Object.class, "anchor_info_map", "open_anchor_info_map");
        registerFieldNameMapping(Object.class, "anchor_effect_map", "open_anchor_effect_map");
        registerFieldNameMapping(Object.class, "mic_dress_info", "open_mic_dress_info");
        registerFieldNameMapping(Object.class, "user_id_to_score", "user_open_id_to_score");
        registerFieldNameMapping(Object.class, "user_armies_map", "open_user_armies_map");
        registerFieldNameMapping(Object.class, "grade_changes", "open_grade_changes");
    }

    public static GsonBuilder builder() {
        return a.a;
    }

    public static Gson get() {
        return a.c;
    }

    public static Gson getDefault() {
        return a.d;
    }

    public static Gson getLynxWorkaround() {
        return a.b;
    }

    public static JsonParser parser() {
        return a.e;
    }

    private static String shadowOverrideFieldIdlName(String r2) {
        return Item.MIX_ID_SEPERATOR + r2;
    }

    public static <T> List<T> fromJsonArray(String r3, Class<T> r4) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r3) == true) goto L8;
        Iterator r5 = GsonProtectorUtils.parse(parser(), r3).getAsJsonArray().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        JsonElement r1 = (JsonElement) r5.next();
        r0.add(GsonProtectorUtils.fromJson(getDefault(), r1, r4));
    L8:
        return r0;
    }

    public static String mappingFieldName(Class<?> r1, String r2) {
        Map<String, String> r3 = fieldNameMapping.get(r1);
        if (r3 != null) goto L5;
        r3 = fieldNameMapping.get(Object.class);
    L5:
        if (r3 != null) goto L8;
        return r2;
    L8:
        if (r3.keySet().contains(r2) == false) goto L12;
        return r3.get(r2);
    L12:
        if (r3.values().contains(r2) == true) goto L14;
        return r2;
    L14:
        return shadowOverrideFieldIdlName(r2);
    }

    public static void registerTypeAdapter(Type r1, Object r2) {
        a.a.registerTypeAdapter(r1, r2);
    }

    public static synchronized void registerFieldNameMapping(Class<?> r3, String r4, String r5) {
        monitor-enter(GsonHelper.class);
        Map<Class<?>, Map<String, String>> r1 = fieldNameMapping;     // Catch: Throwable -> L14
        if (r3 == null) goto L7;
        Class<?> r2 = r3;
    L8:
        Map<String, String> r6 = r1.get(r2);     // Catch: Throwable -> L14
        if (r6 != null) goto L11;
        r6 = new HashMap();     // Catch: Throwable -> L14
    L11:
        r6.put(r5, r4);     // Catch: Throwable -> L14
        fieldNameMapping.put(r3, r6);     // Catch: Throwable -> L14
        monitor-exit(GsonHelper.class);
        return;
    L7:
        r2 = Object.class;
    L14:
        th = move-exception;
        throw th;
    }
}
