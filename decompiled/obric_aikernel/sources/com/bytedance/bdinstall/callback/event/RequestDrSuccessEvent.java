package com.bytedance.bdinstall.callback.event;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestDrSuccessEvent {
    private final JSONObject response;

    public RequestDrSuccessEvent(JSONObject r10) {
        this.response = r10;
    }

    public JSONObject getResponse() {
        return this.response;
    }
}
