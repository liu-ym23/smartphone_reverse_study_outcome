package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IMessageReceiveListener {
    void onConnection(int r8, String r10, JSONObject r11);

    void onFeedBackLog(String r8);

    void onMessage(byte[] r8, int r10);
}
