package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        @CanIgnoreReturnValue
        Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11);

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

        @CanIgnoreReturnValue
        Builder clear();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder clear() {
            return clear();
        }

        @CanIgnoreReturnValue
        Builder clearField(Descriptors.FieldDescriptor r10);

        @CanIgnoreReturnValue
        Builder clearOneof(Descriptors.OneofDescriptor r10);

        Builder clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor r10);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r10);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(Message r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, int r11, int r12);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @CanIgnoreReturnValue
        Builder mergeUnknownFields(UnknownFieldSet r10);

        Builder newBuilderForField(Descriptors.FieldDescriptor r10);

        @CanIgnoreReturnValue
        Builder setField(Descriptors.FieldDescriptor r10, Object r11);

        @CanIgnoreReturnValue
        Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12);

        @CanIgnoreReturnValue
        Builder setUnknownFields(UnknownFieldSet r10);
    }

    boolean equals(Object r10);

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
