package com.bytedance.android.bcm.impl2;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends kc.a.C0174a {
    public static final /* synthetic */ int j = 0;
    public JSONObject h;
    public JSONObject i;

    public static final class a {
    }

    static {
    }

    @Override // kc.a.C0174a
    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("btm", this.c);     // Catch: Throwable -> L13
        r0.put("btm_show_id", this.e);     // Catch: Throwable -> L13
        if (this.h == null) goto L6;
    L7:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L13
        r10.put(AIStateLogRequest.SOURCE_PAGE, this.h);     // Catch: Throwable -> L12
        r10.put("unit", this.i);     // Catch: Throwable -> L12
    L9:
        r0.put("content", r10);     // Catch: Throwable -> L13
    L10:
        r0.put("jump_with_token", this.f);     // Catch: Throwable -> L13
        goto L11
    L6:
        if (this.i == null) goto L10;
    L11:
        return r0;
    }

    public d() {
    }
}
