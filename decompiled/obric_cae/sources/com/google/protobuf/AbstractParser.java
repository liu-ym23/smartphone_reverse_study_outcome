package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public AbstractParser() {
    }

    private MessageType checkMessageInitialized(MessageType r8) {
        if (r8 != null) goto L4;
    L8:
        return r8;
    L4:
        if (r8.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r8).asInvalidProtocolBufferException().setUnfinishedMessage(r8);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r8) {
        if ((r8 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r8).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r8);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r8) {
        return (MessageType) parseDelimitedFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r8) {
        return (MessageType) parseFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r8) {
        return (MessageType) parsePartialDelimitedFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r8) {
        return (MessageType) parsePartialFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r8, r10));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r8, r10));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        int r11 = r8.read();     // Catch: IOException -> L9
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r8, CodedInputStream.readRawVarint32(r11, r8)), r10);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r8, ExtensionRegistryLite r10) {
        CodedInputStream r11 = r8.newCodedInput();
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r8) {
        return parseDelimitedFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r8) {
        return (MessageType) parseFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r8) {
        return parsePartialDelimitedFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream r8) {
        return parsePartialFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return parseDelimitedFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r8, r10));
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return parsePartialDelimitedFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r8) {
        return (MessageType) parsePartialFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r8) {
        return (MessageType) parseFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r8, ExtensionRegistryLite r10) {
        CodedInputStream r11 = CodedInputStream.newInstance(r8);
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r8, r10));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r8) {
        return (MessageType) parsePartialFrom(r8, 0, r8.length, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r8) {
        return (MessageType) parseFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r8, int r10, int r11) {
        return (MessageType) parsePartialFrom(r8, r10, r11, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        CodedInputStream r11 = CodedInputStream.newInstance(r8);
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return (MessageType) checkMessageInitialized(r12);
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
        CodedInputStream r13 = CodedInputStream.newInstance(r8, r10, r11);
        MessageType r14 = parsePartialFrom(r13, r12);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r8) {
        return (MessageType) parseFrom(r8, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (MessageType) parsePartialFrom(r8, 0, r8.length, r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r8, int r10, int r11) {
        return (MessageType) parseFrom(r8, r10, r11, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r8) {
        return parsePartialFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r8, r10, r11, r12));
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r8, ExtensionRegistryLite r10) {
        return parsePartialFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (MessageType) parseFrom(r8, 0, r8.length, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r8) {
        return parsePartialFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r8) {
        return parseFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r8) {
        return parsePartialFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r8, ExtensionRegistryLite r10) {
        return parsePartialFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r8) {
        return parseFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r8) {
        return parsePartialFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r8, int r10, int r11) {
        return parsePartialFrom(r8, r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r8) {
        return parseFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
        return parsePartialFrom(r8, r10, r11, r12);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r8, ExtensionRegistryLite r10) {
        return parsePartialFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r8) {
        return parseFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r8) {
        return parseFrom(r8);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r8, int r10, int r11) {
        return parseFrom(r8, r10, r11);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
        return parseFrom(r8, r10, r11, r12);
    }

    @Override // com.google.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return parseFrom(r8, r10);
    }
}
