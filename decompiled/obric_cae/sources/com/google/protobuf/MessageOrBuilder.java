package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    List<String> findInitializationErrors();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    /* bridge */ /* synthetic */ default MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    Descriptors.Descriptor getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor r8);

    String getInitializationErrorString();

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8);

    Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor r8);

    UnknownFieldSet getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor r8);

    boolean hasOneof(Descriptors.OneofDescriptor r8);
}
