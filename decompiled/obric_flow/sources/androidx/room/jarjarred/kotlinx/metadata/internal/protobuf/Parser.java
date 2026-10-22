package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r5) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r5) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r5) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r5) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r5) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r5) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r5) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r5) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;
}
