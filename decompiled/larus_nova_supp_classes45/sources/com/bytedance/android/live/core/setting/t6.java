package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.setting.v2.helper.SettingBooleanTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t6 {
    public static final Gson a = null;

    static {
        a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new SettingBooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter()).create();
    }
}
