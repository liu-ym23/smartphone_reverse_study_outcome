package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

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

    public MessageType parsePartialFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        CodedInputStream r11 = r5.newCodedInput();
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r5, r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return parseFrom(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r5, r10));
    }

    public MessageType parsePartialFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        CodedInputStream r11 = CodedInputStream.newInstance(r5);
        MessageType r12 = parsePartialFrom(r11, r10);
        r11.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r12;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r12);
    }
}
