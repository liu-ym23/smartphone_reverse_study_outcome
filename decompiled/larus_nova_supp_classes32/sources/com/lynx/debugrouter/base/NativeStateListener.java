package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface NativeStateListener {
    void onClose();

    void onError(String r1);

    void onMessage(String r1);

    void onOpen();
}
