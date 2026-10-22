package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r10);

    ByteString getByteString(int r10);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
