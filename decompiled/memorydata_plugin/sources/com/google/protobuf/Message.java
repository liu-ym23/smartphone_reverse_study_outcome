package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2);

        Message build();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite build() {
            return build();
        }

        Message buildPartial();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite buildPartial() {
            return buildPartial();
        }

        Builder clear();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder clear() {
            return clear();
        }

        Builder clearField(Descriptors.FieldDescriptor r1);

        Builder clearOneof(Descriptors.OneofDescriptor r1);

        Builder clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor r1);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r1, int r2);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r1);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(ByteString r1);

        Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2);

        Builder mergeFrom(CodedInputStream r1);

        Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(Message r1);

        Builder mergeFrom(InputStream r1);

        Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2);

        Builder mergeFrom(byte[] r1);

        Builder mergeFrom(byte[] r1, int r2, int r3);

        Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4);

        Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        Builder mergeUnknownFields(UnknownFieldSet r1);

        Builder newBuilderForField(Descriptors.FieldDescriptor r1);

        Builder setField(Descriptors.FieldDescriptor r1, Object r2);

        Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3);

        Builder setUnknownFields(UnknownFieldSet r1);
    }

    boolean equals(Object r1);

    Parser<? extends Message> getParserForType();

    int hashCode();

    Builder newBuilderForType();

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    /* bridge */ /* synthetic */ default MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    Builder toBuilder();

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    /* bridge */ /* synthetic */ default MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    String toString();
}
