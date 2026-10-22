package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor r8, RpcController r10, Message r11, Message r12, RpcCallback<Message> r13);
}
