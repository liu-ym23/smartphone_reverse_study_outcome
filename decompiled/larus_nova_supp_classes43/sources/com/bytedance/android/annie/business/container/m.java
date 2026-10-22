package com.bytedance.android.annie.business.container;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements com.bytedance.ies.bullet.core.kit.bridge.h {
    public final /* synthetic */ boolean a;

    public final String getName() {
        return "H5_visibilityChange";
    }

    public final Object getParams() {
        JSONObject r0 = new JSONObject();
        r0.put("visible", this.a);
        return r0;
    }

    public m(boolean r1) {
        this.a = r1;
    }
}
