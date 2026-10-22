package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor r10, RpcController r11, Message r12);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r10);

    Message getResponsePrototype(Descriptors.MethodDescriptor r10);
}
