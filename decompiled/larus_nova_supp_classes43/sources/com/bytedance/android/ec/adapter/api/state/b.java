package com.bytedance.android.ec.adapter.api.state;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final JSONObject a(a r10) {
        JSONObject r0 = new JSONObject();
        if (r10 == null) goto L5;
        r0.put("roomID", r10.f);
        r0.put("roomAnchorID", r10.g);
        r0.put("roomAnchorSecID", r10.h);
        r0.put("isAnchor", r10.c);
        r0.put("isFollowed", r10.i);
        r0.put("ecomLiveParams", new JSONObject(r10.p));
        r0.put("reportParams", new JSONObject(r10.m));
    L5:
        return r0;
    }
}
