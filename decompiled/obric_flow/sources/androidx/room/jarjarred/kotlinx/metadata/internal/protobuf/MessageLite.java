package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r5) throws IOException;

        boolean mergeDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException;

        Builder mergeFrom(ByteString r5) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r5) throws IOException;

        Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException;

        Builder mergeFrom(InputStream r5) throws IOException;

        Builder mergeFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException;

        Builder mergeFrom(byte[] r5) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r5) throws IOException;

    void writeTo(CodedOutputStream r5) throws IOException;

    void writeTo(OutputStream r5) throws IOException;
}
