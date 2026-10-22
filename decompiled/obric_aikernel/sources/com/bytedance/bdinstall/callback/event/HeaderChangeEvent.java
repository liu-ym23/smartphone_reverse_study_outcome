package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.Utils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderChangeEvent {
    private final JSONObject mHeader;

    public HeaderChangeEvent(JSONObject r10) {
        JSONObject r11 = new JSONObject();
        Utils.copy(r11, r10);
        this.mHeader = r11;
    }

    public JSONObject getHeaderCopy() {
        return this.mHeader;
    }
}
