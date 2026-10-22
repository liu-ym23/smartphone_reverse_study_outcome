package com.bytedance.crypto.bridge;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ITeaBridge {
    String onGetDeviceId();

    void onTeaEvent(String r1, JSONObject r2);
}
