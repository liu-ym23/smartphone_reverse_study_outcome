package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IMessageReceiveListener {
    void onConnection(int r5, String r10, JSONObject r11);

    void onFeedBackLog(String r5);

    void onMessage(byte[] r5, int r10);
}
