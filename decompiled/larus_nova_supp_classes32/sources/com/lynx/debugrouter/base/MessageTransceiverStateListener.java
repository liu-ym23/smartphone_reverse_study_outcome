package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface MessageTransceiverStateListener {
    void onClose(MessageTransceiver r1, int r2, String r3);

    void onError(MessageTransceiver r1, Throwable r2);

    void onMessage(MessageTransceiver r1, String r2);

    void onOpen(MessageTransceiver r1);
}
