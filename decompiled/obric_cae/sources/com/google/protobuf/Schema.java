package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T r8, T r10);

    int getSerializedSize(T r8);

    int hashCode(T r8);

    boolean isInitialized(T r8);

    void makeImmutable(T r8);

    void mergeFrom(T r8, Reader r10, ExtensionRegistryLite r11);

    void mergeFrom(T r8, T r10);

    void mergeFrom(T r8, byte[] r10, int r11, int r12, ArrayDecoders.Registers r13);

    T newInstance();

    void writeTo(T r8, Writer r10);
}
