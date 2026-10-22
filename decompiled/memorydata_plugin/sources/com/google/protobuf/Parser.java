package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r1);

    MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2);

    MessageType parseFrom(ByteString r1);

    MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2);

    MessageType parseFrom(CodedInputStream r1);

    MessageType parseFrom(CodedInputStream r1, ExtensionRegistryLite r2);

    MessageType parseFrom(InputStream r1);

    MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2);

    MessageType parseFrom(ByteBuffer r1);

    MessageType parseFrom(ByteBuffer r1, ExtensionRegistryLite r2);

    MessageType parseFrom(byte[] r1);

    MessageType parseFrom(byte[] r1, int r2, int r3);

    MessageType parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4);

    MessageType parseFrom(byte[] r1, ExtensionRegistryLite r2);

    MessageType parsePartialDelimitedFrom(InputStream r1);

    MessageType parsePartialDelimitedFrom(InputStream r1, ExtensionRegistryLite r2);

    MessageType parsePartialFrom(ByteString r1);

    MessageType parsePartialFrom(ByteString r1, ExtensionRegistryLite r2);

    MessageType parsePartialFrom(CodedInputStream r1);

    MessageType parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2);

    MessageType parsePartialFrom(InputStream r1);

    MessageType parsePartialFrom(InputStream r1, ExtensionRegistryLite r2);

    MessageType parsePartialFrom(byte[] r1);

    MessageType parsePartialFrom(byte[] r1, int r2, int r3);

    MessageType parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4);

    MessageType parsePartialFrom(byte[] r1, ExtensionRegistryLite r2);
}
