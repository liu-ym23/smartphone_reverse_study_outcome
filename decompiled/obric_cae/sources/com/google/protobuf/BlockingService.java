package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor r8, RpcController r10, Message r11);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r8);

    Message getResponsePrototype(Descriptors.MethodDescriptor r8);
}
