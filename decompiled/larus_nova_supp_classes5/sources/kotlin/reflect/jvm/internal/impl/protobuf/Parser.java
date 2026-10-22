package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException;
}
