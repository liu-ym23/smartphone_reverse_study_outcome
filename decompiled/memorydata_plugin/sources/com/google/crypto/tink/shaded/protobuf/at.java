package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public interface at extends au {

    public interface a extends au, Cloneable {
        a a(at r1);

        a a(byte[] r1);

        a b(k r1, q r2);

        at b();

        at c();
    }

    be<? extends at> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeTo(CodedOutputStream r1);
}
