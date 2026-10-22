package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class SourceContextProto extends GeneratedFile {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_SourceContext_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable = null;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "SourceContextProto");
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\",\n\rSourceContext\u0012\u001b\n\tfile_name\u0018\u0001 \u0001(\tR\bfileNameB\u008a\u0001\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001Z6google.golang.org/protobuf/types/known/sourcecontextpb¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageType(0);
        internal_static_google_protobuf_SourceContext_descriptor = r8;
        internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r8, new String[]{"FileName"});
        descriptor.resolveAllFeaturesImmutable();
    }

    private SourceContextProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
