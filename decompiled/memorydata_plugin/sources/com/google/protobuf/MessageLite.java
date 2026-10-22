package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r1);

        boolean mergeDelimitedFrom(InputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(ByteString r1);

        Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2);

        Builder mergeFrom(CodedInputStream r1);

        Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(MessageLite r1);

        Builder mergeFrom(InputStream r1);

        Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(byte[] r1);

        Builder mergeFrom(byte[] r1, int r2, int r3);

        Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4);

        Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r1);

    void writeTo(CodedOutputStream r1);

    void writeTo(OutputStream r1);
}
