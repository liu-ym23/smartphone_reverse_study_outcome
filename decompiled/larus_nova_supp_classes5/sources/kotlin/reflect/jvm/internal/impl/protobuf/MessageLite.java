package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    /* JADX INFO: renamed from: newBuilderForType */
    Builder mo379newBuilderForType();

    /* JADX INFO: renamed from: toBuilder */
    Builder mo380toBuilder();

    void writeTo(CodedOutputStream r1) throws IOException;
}
