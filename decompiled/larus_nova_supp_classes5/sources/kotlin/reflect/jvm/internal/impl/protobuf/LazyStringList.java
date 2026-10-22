package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r1);

    ByteString getByteString(int r1);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
