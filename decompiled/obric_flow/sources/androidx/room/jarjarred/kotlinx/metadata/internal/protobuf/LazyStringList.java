package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r5);

    void add(byte[] r5);

    boolean addAllByteArray(Collection<byte[]> r5);

    boolean addAllByteString(Collection<? extends ByteString> r5);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int r5);

    ByteString getByteString(int r5);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList r5);

    void set(int r5, ByteString r10);

    void set(int r5, byte[] r10);
}
