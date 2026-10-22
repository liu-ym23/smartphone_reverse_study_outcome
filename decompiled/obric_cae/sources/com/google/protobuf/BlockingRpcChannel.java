package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor r8, RpcController r10, Message r11, Message r12);
}
