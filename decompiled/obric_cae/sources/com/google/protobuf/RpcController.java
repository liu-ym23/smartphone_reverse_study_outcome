package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> r8);

    void reset();

    void setFailed(String r8);

    void startCancel();
}
