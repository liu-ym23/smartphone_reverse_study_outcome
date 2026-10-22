package com.bytedance.android.bcm.impl2;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends kc.a.C0174a {
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
        r0.put("btm", this.c);     // Catch: Throwable -> L15
        r0.put("btm_show_id", this.e);     // Catch: Throwable -> L15
        if (this.h == null) goto L6;
    L7:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L15
        r10.put(AIStateLogRequest.SOURCE_PAGE, this.h);     // Catch: Throwable -> L14
        r10.put("unit", this.i);     // Catch: Throwable -> L14
    L9:
        r0.put("content", r10);     // Catch: Throwable -> L15
    L10:
        String r1 = this.f;     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        r0.put("jump_with_token", r1);     // Catch: Throwable -> L15
        goto L13
    L6:
        if (this.i == null) goto L10;
    L13:
        return r0;
    }

    public e() {
    }
}
