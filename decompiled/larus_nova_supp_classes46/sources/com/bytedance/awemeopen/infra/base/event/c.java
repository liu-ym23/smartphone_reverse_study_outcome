package com.bytedance.awemeopen.infra.base.event;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements d {
    public static final c a = null;
    public static final HashMap<String, Function0<String>> b = null;

    public c() {
    }

    static {
        a = new c();
        b = new HashMap();
    }

    @Override // com.bytedance.awemeopen.infra.base.event.d
    public final JSONObject getParams() {
        JSONObject r0 = new JSONObject();
        String r1 = (String) b.f.invoke();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("aosdk_open_id", r1);
        Function0<String> r3 = b.g;
        if (r3 != null) goto L8;
        String r4 = "";
    L9:
        if (r4 == null) goto L12;
        r2 = r4;
    L12:
        r0.put("nature_open_id", r2);
        if (((Boolean) b.h.invoke()).booleanValue() == false) goto L15;
        String r5 = "1";
    L16:
        r0.put("is_auth", r5);
        r0.put("is_tob", "0");
        r0.put("origin_app_id", AoEnv.d());
        r0.put("aosdk_version", AoEnv.g());
        r0.put("aosdk_version_code", 37300);
        r0.put("aosdk_full_version", "3.7.3");
        r0.put("host_version", AoEnv.f());
        r0.put("host_version_code", AoEnv.a().getHostVersionCode());
        r0.put("host_update_version_code", AoEnv.e());
        r0.put("aobizsdk_name", AoEnv.c);
        r0.put("aobizsdk_version", AoEnv.d);
        r0.put("aobizsdk_version_code", 0);
        HashMap<String, Function0<String>> r6 = b;
        if ((!r6.isEmpty()) == false) goto L22;
        Iterator<Map.Entry<String, Function0<String>>> r7 = r6.entrySet().iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        Map.Entry<String, Function0<String>> r8 = r7.next();
        r0.put(r8.getKey(), r8.getValue().invoke());
    L22:
        return r0;
    L15:
        r5 = "0";
        goto L16
    L8:
        r4 = (String) r3.invoke();
        goto L9
    }
}
