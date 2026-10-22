package com.bytedance.android.livesdk.gift.platform.core.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class x {
    public x() {
    }

    public abstract void a(JSONObject r1);

    public final String toString() {
        JSONObject r0 = new JSONObject();
        a(r0);
        return r0.toString();
    }
}
