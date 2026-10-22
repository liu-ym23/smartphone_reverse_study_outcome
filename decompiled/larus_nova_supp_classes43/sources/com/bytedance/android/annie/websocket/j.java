package com.bytedance.android.annie.websocket;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface j {
    void onClosed();

    void onConnected();

    void onFailed(String r1);

    void onMessage(String r1);

    void onMessage(byte[] r1);
}
