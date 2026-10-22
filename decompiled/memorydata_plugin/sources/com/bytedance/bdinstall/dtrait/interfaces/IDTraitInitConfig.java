package com.bytedance.bdinstall.dtrait.interfaces;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IDTraitInitConfig {
    boolean encryptAndCompress();

    String getAppId();

    JSONObject getDeviceHeader();

    void onEvent(String r1, JSONObject r2);
}
