package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor r1, RpcController r2, Message r3, Message r4);
}
