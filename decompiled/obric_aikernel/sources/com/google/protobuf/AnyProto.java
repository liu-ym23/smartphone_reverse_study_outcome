package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class AnyProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Any_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_Any_fieldAccessorTable = null;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", AnyProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"6\n\u0003Any\u0012\u0019\n\btype_url\u0018\u0001 \u0001(\tR\u0007typeUrl\u0012\u0014\n\u0005value\u0018\u0002 \u0001(\fR\u0005valueBv\n\u0013com.google.protobufB\bAnyProtoP\u0001Z,google.golang.org/protobuf/types/known/anypb¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Any_descriptor = r10;
        internal_static_google_protobuf_Any_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r10, new String[]{"TypeUrl", "Value"});
        descriptor.resolveAllFeaturesImmutable();
    }

    private AnyProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r10) {
        registerAllExtensions(r10);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r10) {
    }
}
