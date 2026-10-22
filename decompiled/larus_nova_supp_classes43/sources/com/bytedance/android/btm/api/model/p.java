package com.bytedance.android.btm.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements xc.a<p> {
    public boolean a;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return null;
    }

    public final String save() {
        JSONObject r0 = new JSONObject();
        r0.put("launch_mode", null);
        r0.put("type", null);
        r0.put("extra_info", null);
        r0.put("target_btm", null);
        r0.put("expire", this.a);
        return r0.toString();
    }
}
