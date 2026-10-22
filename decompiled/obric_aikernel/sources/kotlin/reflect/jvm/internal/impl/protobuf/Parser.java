package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parseFrom(InputStream r10, ExtensionRegistryLite r11);

    MessageType parseFrom(ByteString r10, ExtensionRegistryLite r11);

    MessageType parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11);
}
