package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> r10);

    void reset();

    void setFailed(String r10);

    void startCancel();
}
