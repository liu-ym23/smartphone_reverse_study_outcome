package com.ss.android.deviceregister.b;

import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class b {
    b() {
    }

    void a(JSONObject r3) {
        boolean r2 = com.ss.android.deviceregister.d.e.v();
        if (r2 == false) goto L6;
        Object r1 = "Harmony";
    L23:
        r3.put("os", r1);     // Catch: JSONException -> L9
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        JSONObject r4 = new JSONObject();
        r4.put("os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L16
        r4.put("os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));     // Catch: Throwable -> L16
        r4.put("release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L16
    L25:
        r3.put("harmony", r4);     // Catch: JSONException -> L20
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
        r1 = LocationInfoConst.SYSTEM;
        goto L23
    }
}
