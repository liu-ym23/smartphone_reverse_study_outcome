package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        @CanIgnoreReturnValue
        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r10);

        boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(MessageLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, int r11, int r12);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r10);

    void writeTo(CodedOutputStream r10);

    void writeTo(OutputStream r10);
}
