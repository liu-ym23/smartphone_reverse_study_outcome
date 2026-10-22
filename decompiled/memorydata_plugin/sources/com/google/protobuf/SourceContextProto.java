package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class SourceContextProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_SourceContext_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable = null;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", SourceContextProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\",\n\rSourceContext\u0012\u001b\n\tfile_name\u0018\u0001 \u0001(\tR\bfileNameB\u008a\u0001\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001Z6google.golang.org/protobuf/types/known/sourcecontextpb¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_google_protobuf_SourceContext_descriptor = r0;
        internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r0, new String[]{"FileName"});
        descriptor.resolveAllFeaturesImmutable();
    }

    private SourceContextProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }
}
