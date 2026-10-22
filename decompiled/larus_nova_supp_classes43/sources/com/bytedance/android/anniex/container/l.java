package com.bytedance.android.anniex.container;

import com.bytedance.android.anniex.container.popup.PopupCloseType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements com.bytedance.ies.bullet.core.kit.bridge.h {
    public final Object a;

    public final String getName() {
        return "containerShouldClose";
    }

    public final Object getParams() {
        return this.a;
    }

    public l(PopupCloseType r10) {
        JSONObject r0 = new JSONObject();
        r0.put("type", PopupCloseType.getTag$default(r10, false, 1, null));
        this.a = r0;
    }
}
