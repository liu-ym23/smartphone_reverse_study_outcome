package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class HarmonyLoader {
    HarmonyLoader() {
    }

    void doLoad(JSONObject r10) {
        boolean r11 = RomUtils.isHarmonyUI();
        if (r11 == false) goto L6;
        Object r12 = "Harmony";
    L23:
        r10.put("os", r12);     // Catch: JSONException -> L9
    L11:
        if (r11 == true) goto L13;
        return;
    L13:
        JSONObject r13 = new JSONObject();
        r13.put("os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L16
        r13.put("os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));     // Catch: Throwable -> L16
        r13.put("release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L16
    L25:
        r10.put("harmony", r13);     // Catch: JSONException -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r12 = "Android";
        goto L23
    }
}
