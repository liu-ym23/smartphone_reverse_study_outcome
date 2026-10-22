package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r8);

    void add(byte[] r8);

    boolean addAllByteArray(Collection<byte[]> r8);

    boolean addAllByteString(Collection<? extends ByteString> r8);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int r8);

    ByteString getByteString(int r8);

    Object getRaw(int r8);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList r8);

    void set(int r8, ByteString r10);

    void set(int r8, byte[] r10);
}
