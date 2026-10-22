package com.bytedance.rpc.transport;

/* JADX INFO: loaded from: classes2.dex */
public interface TransportCallback {
    void onFailure(Throwable r1);

    void onSuccess(TransportResponse r1);
}
