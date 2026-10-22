package com.bytedance.sdk.account.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static com.ss.android.account.b.a f3106a;

        static {
            f3106a = new com.ss.android.account.b.a();
        }

        public static com.bytedance.sdk.account.h.a a(JSONObject r1, JSONObject r2) {
            return f3106a.a(r1, r2);
        }

        public static com.bytedance.sdk.account.h.a b(JSONObject r0, JSONObject r1) {
            return a(r0, r1);
        }
    }

    public static void a(com.bytedance.sdk.account.g.a r2, JSONObject r3, JSONObject r4) {
        String r5 = "error_code";
        if (r3.has("error_code") == false) goto L5;
    L4:
        r2.f3121a = r3.optInt(r5, r2.f3121a);
    L8:
        r2.f3122b = r3.optString("description");
        if (r2.f3121a != 1075) goto L12;
        r2.e = r3.optLong("apply_time");
        r2.h = r3.optString("avatar_url");
        r2.g = r3.optString("nick_name");
        r2.d = r3.optString("token");
        r2.f = r3.optLong("cancel_time");
        return;
    L12:
        return;
    L5:
        r5 = "code";
        if (r3.has("code") == false) goto L8;
        goto L8
    }
}
