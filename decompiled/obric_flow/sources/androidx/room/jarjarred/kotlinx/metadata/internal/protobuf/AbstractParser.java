package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public AbstractParser() {
    }

    private MessageType checkMessageInitialized(MessageType r5) throws InvalidProtocolBufferException {
        if (r5 != null) goto L4;
    L8:
        return r5;
    L4:
        if (r5.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r5).asInvalidProtocolBufferException().setUnfinishedMessage(r5);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r5) {
        if ((r5 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r5).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r5) throws InvalidProtocolBufferException {
        return parseFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r5) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r5, r10));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r5) throws InvalidProtocolBufferException {
        return parseFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        int r11 = r5.read();     // Catch: IOException -> L9
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r5, CodedInputStream.readRawVarint32(r11, r5)), r10);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r5) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException {
        return (MessageType) parseDelimitedFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r5) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r5) throws InvalidProtocolBufferException {
        return parseFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r5) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return parseFrom(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r5) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialDelimitedFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream r5) throws InvalidProtocolBufferException {
        return parsePartialFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        CodedInputStream r11 = r5.newCodedInput();
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r5) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(ByteString r5) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10, r11, r12));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r5) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, r10, r11, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r5, int r10, int r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        CodedInputStream r13 = CodedInputStream.newInstance(r5, r10, r11);
        MessageType r14 = parsePartialFrom(r13, r12);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, 0, r5.length, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parseFrom(InputStream r5) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r5, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r5, int r10, int r11) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r5, r10, r11, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r5, 0, r5.length, r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r5, 0, r5.length, EMPTY_REGISTRY);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        CodedInputStream r11 = CodedInputStream.newInstance(r5);
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r5) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r5, EMPTY_REGISTRY);
    }
}
