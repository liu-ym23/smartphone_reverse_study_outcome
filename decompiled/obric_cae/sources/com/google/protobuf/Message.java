package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        @CanIgnoreReturnValue
        Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10);

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
        Builder clearField(Descriptors.FieldDescriptor r8);

        @CanIgnoreReturnValue
        Builder clearOneof(Descriptors.OneofDescriptor r8);

        Builder clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* bridge */ /* synthetic */ default MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor r8);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r8, int r10);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r8);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(Message r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, int r10, int r11);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        @CanIgnoreReturnValue
        Builder mergeUnknownFields(UnknownFieldSet r8);

        Builder newBuilderForField(Descriptors.FieldDescriptor r8);

        @CanIgnoreReturnValue
        Builder setField(Descriptors.FieldDescriptor r8, Object r10);

        @CanIgnoreReturnValue
        Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11);

        @CanIgnoreReturnValue
        Builder setUnknownFields(UnknownFieldSet r8);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @CanIgnoreReturnValue
        /* bridge */ /* synthetic */ default MessageLite.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    boolean equals(Object r8);

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
