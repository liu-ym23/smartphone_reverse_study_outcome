package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException;
}
