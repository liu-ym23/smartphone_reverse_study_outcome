package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r10);

    MessageType parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parseFrom(ByteString r10);

    MessageType parseFrom(ByteString r10, ExtensionRegistryLite r11);

    MessageType parseFrom(CodedInputStream r10);

    MessageType parseFrom(CodedInputStream r10, ExtensionRegistryLite r11);

    MessageType parseFrom(InputStream r10);

    MessageType parseFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parseFrom(ByteBuffer r10);

    MessageType parseFrom(ByteBuffer r10, ExtensionRegistryLite r11);

    MessageType parseFrom(byte[] r10);

    MessageType parseFrom(byte[] r10, int r11, int r12);

    MessageType parseFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13);

    MessageType parseFrom(byte[] r10, ExtensionRegistryLite r11);

    MessageType parsePartialDelimitedFrom(InputStream r10);

    MessageType parsePartialDelimitedFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parsePartialFrom(ByteString r10);

    MessageType parsePartialFrom(ByteString r10, ExtensionRegistryLite r11);

    MessageType parsePartialFrom(CodedInputStream r10);

    MessageType parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11);

    MessageType parsePartialFrom(InputStream r10);

    MessageType parsePartialFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parsePartialFrom(byte[] r10);

    MessageType parsePartialFrom(byte[] r10, int r11, int r12);

    MessageType parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13);

    MessageType parsePartialFrom(byte[] r10, ExtensionRegistryLite r11);
}
