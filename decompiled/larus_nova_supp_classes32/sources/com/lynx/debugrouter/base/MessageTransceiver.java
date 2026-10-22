package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface MessageTransceiver {
    boolean connect(String r1);

    void disconnect();

    long queueSize();

    void removeStateListener(MessageTransceiverStateListener r1);

    void send(String r1);

    void setStateListener(MessageTransceiverStateListener r1);
}
