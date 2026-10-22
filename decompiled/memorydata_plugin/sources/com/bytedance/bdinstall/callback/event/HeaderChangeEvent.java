package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.Utils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderChangeEvent {
    private final JSONObject mHeader;

    public HeaderChangeEvent(JSONObject r2) {
        JSONObject r0 = new JSONObject();
        Utils.copy(r0, r2);
        this.mHeader = r0;
    }

    public JSONObject getHeaderCopy() {
        return this.mHeader;
    }
}
