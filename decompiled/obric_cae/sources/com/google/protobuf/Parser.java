package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r8);

    MessageType parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10);

    MessageType parseFrom(ByteString r8);

    MessageType parseFrom(ByteString r8, ExtensionRegistryLite r10);

    MessageType parseFrom(CodedInputStream r8);

    MessageType parseFrom(CodedInputStream r8, ExtensionRegistryLite r10);

    MessageType parseFrom(InputStream r8);

    MessageType parseFrom(InputStream r8, ExtensionRegistryLite r10);

    MessageType parseFrom(ByteBuffer r8);

    MessageType parseFrom(ByteBuffer r8, ExtensionRegistryLite r10);

    MessageType parseFrom(byte[] r8);

    MessageType parseFrom(byte[] r8, int r10, int r11);

    MessageType parseFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12);

    MessageType parseFrom(byte[] r8, ExtensionRegistryLite r10);

    MessageType parsePartialDelimitedFrom(InputStream r8);

    MessageType parsePartialDelimitedFrom(InputStream r8, ExtensionRegistryLite r10);

    MessageType parsePartialFrom(ByteString r8);

    MessageType parsePartialFrom(ByteString r8, ExtensionRegistryLite r10);

    MessageType parsePartialFrom(CodedInputStream r8);

    MessageType parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10);

    MessageType parsePartialFrom(InputStream r8);

    MessageType parsePartialFrom(InputStream r8, ExtensionRegistryLite r10);

    MessageType parsePartialFrom(byte[] r8);

    MessageType parsePartialFrom(byte[] r8, int r10, int r11);

    MessageType parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12);

    MessageType parsePartialFrom(byte[] r8, ExtensionRegistryLite r10);
}
