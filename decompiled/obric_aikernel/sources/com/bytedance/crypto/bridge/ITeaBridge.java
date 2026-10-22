package com.bytedance.crypto.bridge;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ITeaBridge {
    String onGetDeviceId();

    void onTeaEvent(String r10, JSONObject r11);
}
