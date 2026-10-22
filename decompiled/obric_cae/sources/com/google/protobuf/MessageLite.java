package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        @CanIgnoreReturnValue
        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r8);

        boolean mergeDelimitedFrom(InputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(MessageLite r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, int r10, int r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r8);

    void writeTo(CodedOutputStream r8);

    void writeTo(OutputStream r8);
}
