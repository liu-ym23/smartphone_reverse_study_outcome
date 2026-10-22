package com.bytedance.android.btm.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final String a;
    public final JSONObject b;

    public h(j r10) {
        String r0 = r10.a();
        if (r0 != null) goto L6;
        r0 = "null";
    L6:
        this.a = r0;
        this.b = r10.h;
    }
}
