package com.larus.setting.api;

import com.larus.network.HttpConst;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;

    public u() {
    }

    static {
        StringBuilder r0 = new StringBuilder();
        HttpConst r1 = HttpConst.a;
        r1.getClass();
        String r2 = HttpConst.g;
        r0.append(r2);
        r0.append("/legal/vulnerability");
        a = r0.toString();
        StringBuilder r3 = new StringBuilder();
        r1.getClass();
        r3.append(r2);
        r3.append("/legal/community_guidelines");
        b = r3.toString();
        StringBuilder r4 = new StringBuilder();
        r1.getClass();
        r4.append(r2);
        r4.append("/legal/ip_protection_guideline");
        c = r4.toString();
        StringBuilder r5 = new StringBuilder();
        r1.getClass();
        r5.append(r2);
        r5.append("/ocean_legal/permissions");
        d = r5.toString();
        StringBuilder r6 = new StringBuilder();
        r1.getClass();
        r6.append(r2);
        r6.append("/legal/third_parties");
        e = r6.toString();
        f = "https://www.volcengine.com/product/yunque?utm_campaign=doubao_app&utm_content=setting_button&utm_medium=setting_button&utm_source=external_cooperation&utm_term=doubao_app_setting_button";
        g = "https://mp.oceancloudapi.com/api/gw/plugin/doaction_pass_query";
        h = "https://mp.oceancloudapi.com/api/doubao/do_action_v2";
    }

    public static JSONObject a(String r3, JSONObject r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, "funName");
        Intrinsics.checkNotNullParameter("FPA_Audio", "scene");
        Intrinsics.checkNotNullParameter("7367318881150451738", "botId");
        Intrinsics.checkNotNullParameter(r3, "apiName");
        JSONObject r1 = new JSONObject();
        r1.put("scene", "FPA_Audio");
        r1.put("bot_id", "7367318881150451738");
        r1.put("ext", new JSONObject());
        r1.put("trace_info", new JSONObject());
        JSONObject r6 = new JSONObject();
        r6.put("api_name", r3);
        if (r4 != null) goto L8;
        r4 = new JSONObject();
    L8:
        r6.put("params", r4.toString());
        Unit r7 = Unit.INSTANCE;
        r1.put("payload", r6.toString());
        return r1;
    }
}
