package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor r10, RpcController r11, Message r12, Message r13);
}
