package com.bytedance.android.btm.impl.page.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public com.bytedance.android.btm.impl.util.f<Object> a;
    public PageInfo b;
    public Flag c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("pageInfo", String.valueOf(this.b));     // Catch: Throwable -> L6
        r0.put("flag", this.c.toString());     // Catch: Throwable -> L6
        r0.put("sentEvent", this.d);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public i() {
        this.c = Flag.NOT_SURE;
    }
}
