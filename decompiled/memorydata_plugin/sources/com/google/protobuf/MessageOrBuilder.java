package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    List<String> findInitializationErrors();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    /* bridge */ /* synthetic */ default MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    Descriptors.Descriptor getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor r1);

    String getInitializationErrorString();

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1);

    Object getRepeatedField(Descriptors.FieldDescriptor r1, int r2);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor r1);

    UnknownFieldSet getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor r1);

    boolean hasOneof(Descriptors.OneofDescriptor r1);
}
