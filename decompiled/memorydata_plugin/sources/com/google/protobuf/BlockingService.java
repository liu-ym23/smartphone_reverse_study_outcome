package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor r1, RpcController r2, Message r3);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r1);

    Message getResponsePrototype(Descriptors.MethodDescriptor r1);
}
