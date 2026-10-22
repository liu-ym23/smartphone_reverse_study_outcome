package com.bytedance.crash.config;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BitsConfig {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static volatile BitsConfig sInstance;
    private final Map<String, Object> mPropertiesMap;

    BitsConfig() {
        this.mPropertiesMap = new HashMap();
        Context r10 = Global.getContext();
        if (r10 != null) goto L5;
        return;
    L5:
        Properties r11 = new Properties();
        r11.load(r10.getAssets().open(PROPERTIES_PATH));     // Catch: Exception -> L12
        Iterator r12 = r11.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r12.hasNext() == false) goto L17;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L12
        this.mPropertiesMap.put(String.valueOf(r13.getKey()), r13.getValue());     // Catch: Exception -> L12
    L17:
        return;
    }

    private static BitsConfig get() {
        if (sInstance != null) goto L6;
        sInstance = new BitsConfig();
    L6:
        return sInstance;
    }

    @NonNull
    public static Map<String, Object> getPropertiesMap() {
        return get().mPropertiesMap;
    }

    @NonNull
    public static String getReleaseBuild() {
        Object r10 = getPropertiesMap().get("release_build");
        if (r10 == null) goto L7;
        String r11 = String.valueOf(r10);
        if (r11.length() < 16) goto L9;
        return r11;
    L9:
        return "invalid";
    L7:
        return "invalid";
    }

    public static void load(JSONObject r10) {
        Iterator<Map.Entry<String, Object>> r11 = getPropertiesMap().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, Object> r12 = r11.next();
        if (r10.has(r12.getKey()) == true) goto L4;
        r10.put(r12.getKey(), String.valueOf(r12.getValue()));     // Catch: Throwable -> L10
        goto L4
    }
}
