package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BitsConfig {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static volatile BitsConfig sInstance;
    private final Map<String, Object> mPropertiesMap;

    BitsConfig() {
        this.mPropertiesMap = new HashMap();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        Properties r2 = new Properties();
        r2.load(r0.getAssets().open(PROPERTIES_PATH));     // Catch: Exception -> L12
        Iterator r1 = r2.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.mPropertiesMap.put(String.valueOf(r3.getKey()), r3.getValue());     // Catch: Exception -> L12
    L17:
        return;
    }

    private static BitsConfig get() {
        if (sInstance != null) goto L6;
        sInstance = new BitsConfig();
    L6:
        return sInstance;
    }

    public static Map<String, Object> getPropertiesMap() {
        return get().mPropertiesMap;
    }

    public static String getReleaseBuild() {
        Object r0 = getPropertiesMap().get("release_build");
        if (r0 == null) goto L7;
        String r1 = String.valueOf(r0);
        if (r1.length() < 16) goto L9;
        return r1;
    L9:
        return "invalid";
    L7:
        return "invalid";
    }

    public static void load(JSONObject r5) {
        Iterator<Map.Entry<String, Object>> r0 = getPropertiesMap().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r5.has((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        r5.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), String.valueOf(r1.getValue()));     // Catch: Throwable -> L10
        goto L4
    }
}
