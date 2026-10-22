package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Empty_descriptor = null;
    static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_Empty_fieldAccessorTable = null;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", EmptyProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bgoogle/protobuf/empty.proto\u0012\u000fgoogle.protobuf\"\u0007\n\u0005EmptyB}\n\u0013com.google.protobufB\nEmptyProtoP\u0001Z.google.golang.org/protobuf/types/known/emptypbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Empty_descriptor = r10;
        internal_static_google_protobuf_Empty_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r10, new String[0]);
        descriptor.resolveAllFeaturesImmutable();
    }

    private EmptyProto() {
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
