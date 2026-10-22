package com.bytedance.apm6.hub.config.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigChangeListener {
    void onConfigChanged(JSONObject r10, boolean r11);
}
