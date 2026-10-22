package com.ss.android.account;

import com.bytedance.crash.tracker.ActivityLifecycle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.bytedance.sdk.account.h.a {
    public String o;
    public String p;
    public String q;

    public a() {
    }

    public a(JSONObject r1, JSONObject r2) {
        super(r1, r2);
    }

    private static void a(a r2, JSONObject r3) {
        String r0 = ActivityLifecycle.NAME;
        if (r3.has(ActivityLifecycle.NAME) == false) goto L5;
    L4:
        r2.o = r3.optString(r0);
    L8:
        r2.q = r3.optString("avatar_url");
        r2.p = r3.optString("description");
        return;
    L5:
        r0 = "username";
        if (r3.has("username") == false) goto L8;
        goto L8
    }

    @Override // com.bytedance.sdk.account.h.a
    public void c() {
        super.c();
        a(this, b());
    }
}
