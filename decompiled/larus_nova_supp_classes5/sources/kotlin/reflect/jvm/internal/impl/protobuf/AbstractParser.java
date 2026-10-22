package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    private MessageType checkMessageInitialized(MessageType r2) throws InvalidProtocolBufferException {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (r2.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r2).asInvalidProtocolBufferException().setUnfinishedMessage(r2);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r2) {
        if ((r2 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r2).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    public MessageType parsePartialDelimitedFrom(InputStream r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        int r0 = r3.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)), r4);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    public MessageType parsePartialFrom(ByteString r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        CodedInputStream r4 = r2.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r5 = parsePartialFrom(r4, r3);     // Catch: InvalidProtocolBufferException -> L9
        r4.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r5;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r5);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    public MessageType parsePartialFrom(InputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        CodedInputStream r4 = CodedInputStream.newInstance(r2);
        MessageType r5 = parsePartialFrom(r4, r3);
        r4.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r5;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return parseFrom(r1, r2);
    }
}
