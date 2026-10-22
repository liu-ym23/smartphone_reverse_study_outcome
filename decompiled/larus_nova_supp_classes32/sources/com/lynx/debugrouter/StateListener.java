package com.lynx.debugrouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface StateListener {
    void onClose(int r1, String r2);

    void onError(String r1);

    void onMessage(String r1);

    void onOpen(ConnectionType r1);
}
