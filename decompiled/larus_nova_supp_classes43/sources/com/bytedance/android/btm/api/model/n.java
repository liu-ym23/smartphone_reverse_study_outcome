package com.bytedance.android.btm.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class n {
    public boolean a;

    public n() {
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("reuse", this.a);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }
}
