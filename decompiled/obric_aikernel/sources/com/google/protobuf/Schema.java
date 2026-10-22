package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T r10, T r11);

    int getSerializedSize(T r10);

    int hashCode(T r10);

    boolean isInitialized(T r10);

    void makeImmutable(T r10);

    void mergeFrom(T r10, Reader r11, ExtensionRegistryLite r12);

    void mergeFrom(T r10, T r11);

    void mergeFrom(T r10, byte[] r11, int r12, int r13, ArrayDecoders.Registers r14);

    T newInstance();

    void writeTo(T r10, Writer r11);
}
