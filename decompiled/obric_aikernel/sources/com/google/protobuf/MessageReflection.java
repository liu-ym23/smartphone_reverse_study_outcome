package com.google.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class MessageReflection {

    /* JADX INFO: renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r10 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r10;
            r10[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;
        private boolean hasNestedBuilders;

        public BuilderAdapter(Message.Builder r10) {
            this.hasNestedBuilders = true;
            this.builder = r10;
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            if (this.hasNestedBuilders == false) goto L11;
            return this.builder.getFieldBuilder(r10);
        L6:
            this.hasNestedBuilders = false;
            return null;
        L11:
            return null;
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor r10, Message r11) {
            if (r11 == null) goto L6;
            return r11.newBuilderForType();
        L6:
            return this.builder.newBuilderForField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            if ((r11 instanceof MessageLite.Builder) == false) goto L5;
            r11 = ((MessageLite.Builder) r11).buildPartial();
        L5:
            this.builder.addRepeatedField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r10) {
            this.builder.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r10) {
            this.builder.clearOneof(r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r10, String r11) {
            return r10.findImmutableExtensionByName(r11);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r10, Descriptors.Descriptor r11, int r12) {
            return r10.findImmutableExtensionByNumber(r11, r12);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            return this.builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor r10) {
            return this.builder.getField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            return this.builder.getOneofFieldDescriptor(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r10) {
            if (r10.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            if (r10.isRepeated() == true) goto L13;
            if ((this.builder instanceof GeneratedMessage.Builder) == false) goto L13;
            return WireFormat.Utf8Validation.LAZY;
        L13:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            return this.builder.hasField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            return this.builder.hasOneof(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = newMessageFieldInstance(r12, r13);
            r10.readGroup(r12.getNumber(), r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L11;
            Message.Builder r15 = getFieldBuilder(r12);
            if (r15 == null) goto L10;
            r10.readGroup(r12.getNumber(), r15, r11);
            return;
        L10:
            Message.Builder r16 = newMessageFieldInstance(r12, r13);
            r16.mergeFrom((Message) getField(r12));
        L12:
            r10.readGroup(r12.getNumber(), r16, r11);
            setField(r12, r16.buildPartial());
            return;
        L11:
            r16 = newMessageFieldInstance(r12, r13);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = newMessageFieldInstance(r12, r13);
            r10.readMessage(r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L11;
            Message.Builder r15 = getFieldBuilder(r12);
            if (r15 == null) goto L10;
            r10.readMessage(r15, r11);
            return;
        L10:
            Message.Builder r16 = newMessageFieldInstance(r12, r13);
            r16.mergeFrom((Message) getField(r12));
        L12:
            r10.readMessage(r16, r11);
            setField(r12, r16.buildPartial());
            return;
        L11:
            r16 = newMessageFieldInstance(r12, r13);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            if (r11 == null) goto L4;
            Message.Builder r12 = r11.newBuilderForType();
        L6:
            return new BuilderAdapter(r12);
        L4:
            r12 = this.builder.newBuilderForField(r10);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            if (r10.isRepeated() == false) goto L5;
        L10:
            Message.Builder r12 = newMessageFieldInstance(r10, r11);
            if (r10.isRepeated() == true) goto L16;
            Message r13 = (Message) getField(r10);
            if (r13 == null) goto L16;
            r12.mergeFrom(r13);
        L16:
            return new BuilderAdapter(r12);
        L5:
            if (hasField(r10) == false) goto L10;
            Message.Builder r14 = getFieldBuilder(r10);
            if (r14 == null) goto L10;
            return new BuilderAdapter(r14);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r13 == null) goto L4;
            Message.Builder r14 = r13.newBuilderForType();
        L6:
            if (r12.isRepeated() == true) goto L10;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L10;
            r14.mergeFrom(r15);
        L10:
            r10.readGroup(r12.getNumber(), r14, r11);
            return r14.buildPartial();
        L4:
            r14 = this.builder.newBuilderForField(r12);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r13 == null) goto L4;
            Message.Builder r14 = r13.newBuilderForType();
        L6:
            if (r12.isRepeated() == true) goto L10;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L10;
            r14.mergeFrom(r15);
        L10:
            r10.readMessage(r14, r11);
            return r14.buildPartial();
        L4:
            r14 = this.builder.newBuilderForField(r12);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r13 == null) goto L4;
            Message.Builder r14 = r13.newBuilderForType();
        L6:
            if (r12.isRepeated() == true) goto L10;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L10;
            r14.mergeFrom(r15);
        L10:
            r14.mergeFrom(r10, r11);
            return r14.buildPartial();
        L4:
            r14 = this.builder.newBuilderForField(r12);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isRepeated() == false) goto L5;
        L10:
            this.builder.setField(r10, r11);
            return this;
        L5:
            if ((r11 instanceof MessageLite.Builder) == false) goto L10;
            if (r11 == getFieldBuilder(r10)) goto L9;
            this.builder.setField(r10, ((MessageLite.Builder) r11).buildPartial());
        L9:
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            if ((r12 instanceof MessageLite.Builder) == false) goto L5;
            r12 = ((MessageLite.Builder) r12).buildPartial();
        L5:
            this.builder.setRepeatedField(r10, r11, r12);
            return this;
        }
    }

    static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> r10) {
            this.extensions = r10;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            this.extensions.addRepeatedField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r10) {
            this.extensions.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r10) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r10, String r11) {
            return r10.findImmutableExtensionByName(r11);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r10, Descriptors.Descriptor r11, int r12) {
            return r10.findImmutableExtensionByNumber(r11, r12);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor r10) {
            return this.extensions.getField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r10) {
            if (r10.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            return this.extensions.hasField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = r13.newBuilderForType();
            r10.readGroup(r12.getNumber(), r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L8;
            MessageLite.Builder r15 = ((MessageLite) getField(r12)).toBuilder();
            r10.readGroup(r12.getNumber(), r15, r11);
            setField(r12, r15.buildPartial());
            return;
        L8:
            Message.Builder r16 = r13.newBuilderForType();
            r10.readGroup(r12.getNumber(), r16, r11);
            setField(r12, r16.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = r13.newBuilderForType();
            r10.readMessage(r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L8;
            MessageLite.Builder r15 = ((MessageLite) getField(r12)).toBuilder();
            r10.readMessage(r15, r11);
            setField(r12, r15.buildPartial());
            return;
        L8:
            Message.Builder r16 = r13.newBuilderForType();
            r10.readMessage(r16, r11);
            setField(r12, r16.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r10.readGroup(r12.getNumber(), r14, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r10.readMessage(r14, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r14.mergeFrom(r10, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r10, Object r11) {
            this.extensions.setField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            this.extensions.setRepeatedField(r10, r11, r12);
            return this;
        }
    }

    static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> r10) {
            this.extensions = r10;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            this.extensions.addRepeatedField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget clearField(Descriptors.FieldDescriptor r10) {
            this.extensions.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r10) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r10, String r11) {
            return r10.findImmutableExtensionByName(r11);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r10, Descriptors.Descriptor r11, int r12) {
            return r10.findImmutableExtensionByNumber(r11, r12);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor r10) {
            return this.extensions.getField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r10) {
            if (r10.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            return this.extensions.hasField(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = r13.newBuilderForType();
            r10.readGroup(r12.getNumber(), r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L12;
            Object r15 = this.extensions.getFieldAllowBuilders(r12);
            if ((r15 instanceof MessageLite.Builder) == false) goto L9;
            MessageLite.Builder r16 = (MessageLite.Builder) r15;
        L10:
            r10.readGroup(r12.getNumber(), r16, r11);
            return;
        L9:
            r16 = ((MessageLite) r15).toBuilder();
            this.extensions.setField(r12, r16);
            goto L10
        L12:
            Message.Builder r17 = r13.newBuilderForType();
            r10.readGroup(r12.getNumber(), r17, r11);
            setField(r12, r17);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            if (r12.isRepeated() == false) goto L5;
            Message.Builder r14 = r13.newBuilderForType();
            r10.readMessage(r14, r11);
            addRepeatedField(r12, r14.buildPartial());
            return;
        L5:
            if (hasField(r12) == false) goto L12;
            Object r15 = this.extensions.getFieldAllowBuilders(r12);
            if ((r15 instanceof MessageLite.Builder) == false) goto L9;
            MessageLite.Builder r16 = (MessageLite.Builder) r15;
        L10:
            r10.readMessage(r16, r11);
            return;
        L9:
            r16 = ((MessageLite) r15).toBuilder();
            this.extensions.setField(r12, r16);
            goto L10
        L12:
            Message.Builder r17 = r13.newBuilderForType();
            r10.readMessage(r17, r11);
            setField(r12, r17);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r10, Message r11) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r10.readGroup(r12.getNumber(), r14, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r10.readMessage(r14, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13) {
            Message.Builder r14 = r13.newBuilderForType();
            if (r12.isRepeated() == true) goto L7;
            Message r15 = (Message) getField(r12);
            if (r15 == null) goto L7;
            r14.mergeFrom(r15);
        L7:
            r14.mergeFrom(r10, r11);
            return r14.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget setField(Descriptors.FieldDescriptor r10, Object r11) {
            this.extensions.setField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            this.extensions.setRepeatedField(r10, r11, r12);
            return this;
        }
    }

    interface MergeTarget {

        public static final enum ContainerType extends java.lang.Enum<ContainerType> {
            private static final /* synthetic */ ContainerType[] $VALUES = null;
            public static final ContainerType EXTENSION_SET = null;
            public static final ContainerType MESSAGE = null;

            private static /* synthetic */ ContainerType[] $values() {
                return new ContainerType[]{MESSAGE, EXTENSION_SET};
            }

            static {
                MESSAGE = new ContainerType("MESSAGE", 0);
                EXTENSION_SET = new ContainerType("EXTENSION_SET", 1);
                $VALUES = $values();
            }

            private ContainerType(String r10, int r11) {
                super(r10, r11);
            }

            public static ContainerType valueOf(String r10) {
                return (ContainerType) java.lang.Enum.valueOf(ContainerType.class, r10);
            }

            public static ContainerType[] values() {
                return (ContainerType[]) $VALUES.clone();
            }
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor r10, Object r11);

        MergeTarget clearField(Descriptors.FieldDescriptor r10);

        MergeTarget clearOneof(Descriptors.OneofDescriptor r10);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r10, String r11);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r10, Descriptors.Descriptor r11, int r12);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor r10);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r10);

        boolean hasField(Descriptors.FieldDescriptor r10);

        boolean hasOneof(Descriptors.OneofDescriptor r10);

        void mergeGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13);

        void mergeMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r10, Message r11);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r10, Message r11);

        Object parseGroup(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13);

        Object parseMessage(CodedInputStream r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13);

        Object parseMessageFromBytes(ByteString r10, ExtensionRegistryLite r11, Descriptors.FieldDescriptor r12, Message r13);

        MergeTarget setField(Descriptors.FieldDescriptor r10, Object r11);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12);
    }

    MessageReflection() {
    }

    static String delimitWithCommas(List<String> r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        if (r11.length() <= 0) goto L8;
        r11.append(", ");
    L8:
        r11.append(r13);
        goto L4
    L10:
        return r11.toString();
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream r10, ExtensionRegistry.ExtensionInfo r11, ExtensionRegistryLite r12, MergeTarget r13) {
        Descriptors.FieldDescriptor r14 = r11.descriptor;
        r13.setField(r14, r13.parseMessage(r10, r12, r14, r11.defaultInstance));
    }

    static List<String> findMissingFields(MessageOrBuilder r10) {
        ArrayList r11 = new ArrayList();
        findMissingFields(r10, "", r11);
        return r11;
    }

    private static void findMissingFields(MessageOrBuilder r10, String r11, List<String> r12) {
        Iterator<Descriptors.FieldDescriptor> r13 = r10.getDescriptorForType().getFields().iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r14 = r13.next();
        if (r14.isRequired() == false) goto L4;
        if (r10.hasField(r14) == true) goto L4;
        r12.add(r11 + r14.getName());
        goto L4
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r15 = r10.getAllFields().entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L24;
        Map.Entry<Descriptors.FieldDescriptor, Object> r16 = r15.next();
        Descriptors.FieldDescriptor r17 = r16.getKey();
        Object r18 = r16.getValue();
        if (r17.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        if (r17.isRepeated() == true) goto L17;
        if (r10.hasField(r17) == false) goto L12;
        findMissingFields((MessageOrBuilder) r18, subMessagePrefix(r11, r17, -1), r12);
        goto L12
    L17:
        int r19 = 0;
        Iterator r20 = ((List) r18).iterator();
    L19:
        if (r20.hasNext() == false) goto L12;
        findMissingFields((MessageOrBuilder) r20.next(), subMessagePrefix(r11, r17, r19), r12);
        r19 = r19 + 1;
        goto L19
    }

    static int getSerializedSize(Message r10, Map<Descriptors.FieldDescriptor, Object> r11) {
        boolean r12 = r10.getDescriptorForType().getOptions().getMessageSetWireFormat();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r13 = r11.entrySet().iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L16;
        Map.Entry<Descriptors.FieldDescriptor, Object> r15 = r13.next();
        Descriptors.FieldDescriptor r16 = r15.getKey();
        Object r17 = r15.getValue();
        if (r12 == true) goto L8;
    L14:
        int r18 = FieldSet.computeFieldSize(r16, r17);
    L15:
        r14 = r14 + r18;
        goto L4
    L8:
        if (r16.isExtension() == false) goto L14;
        if (r16.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L14;
        if (r16.isRepeated() == true) goto L14;
        r18 = CodedOutputStream.computeMessageSetExtensionSize(r16.getNumber(), (Message) r17);
        goto L15
    L16:
        UnknownFieldSet r19 = r10.getUnknownFields();
        if (r12 == false) goto L19;
        int r20 = r19.getSerializedSizeAsMessageSet();
    L21:
        return r14 + r20;
    L19:
        r20 = r19.getSerializedSize();
        goto L21
    }

    static boolean isInitialized(MessageOrBuilder r10) {
        Iterator<Descriptors.FieldDescriptor> r11 = r10.getDescriptorForType().getFields().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r12 = r11.next();
        if (r12.isRequired() == false) goto L4;
        if (r10.hasField(r12) == true) goto L4;
        return false;
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r13 = r10.getAllFields().entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L26;
        Map.Entry<Descriptors.FieldDescriptor, Object> r14 = r13.next();
        Descriptors.FieldDescriptor r15 = r14.getKey();
        if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        boolean r16 = r15.isRepeated();
        Object r17 = r14.getValue();
        if (r16 == true) goto L17;
        if (((Message) r17).isInitialized() == true) goto L12;
        return false;
    L17:
        Iterator r18 = ((List) r17).iterator();
    L19:
        if (r18.hasNext() == false) goto L12;
        if (((Message) r18.next()).isInitialized() == true) goto L19;
        return false;
    L26:
        return true;
    }

    static boolean mergeFieldFrom(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, Descriptors.Descriptor r13, MergeTarget r14, int r15) {
        if (r13.getOptions().getMessageSetWireFormat() == true) goto L5;
    L8:
        int r16 = WireFormat.getTagWireType(r15);
        int r17 = WireFormat.getTagFieldNumber(r15);
        Descriptors.FieldDescriptor r18 = null;
        if (r13.isExtensionNumber(r17) == false) goto L24;
        if ((r12 instanceof ExtensionRegistry) == false) goto L26;
        ExtensionRegistry.ExtensionInfo r19 = r14.findExtensionByNumber((ExtensionRegistry) r12, r13, r17);
        if (r19 == null) goto L26;
        Descriptors.FieldDescriptor r20 = r19.descriptor;
        Message r21 = r19.defaultInstance;
        if (r21 == null) goto L18;
    L22:
        Message r110 = r21;
        r18 = r20;
    L27:
        boolean r22 = false;
        if (r18 != null) goto L31;
    L29:
        boolean r23 = false;
        r22 = true;
    L38:
        if (r22 == false) goto L44;
        if (r11 == null) goto L43;
        return r11.mergeFieldFrom(r15, r10);
    L43:
        return r10.skipField(r15);
    L44:
        if (r23 == false) goto L61;
        int r24 = r10.pushLimit(r10.readRawVarint32());
        if (r18.getLiteType() != WireFormat.FieldType.ENUM) goto L58;
    L48:
        if (r10.getBytesUntilLimit() <= 0) goto L60;
        int r111 = r10.readEnum();
        if (r18.legacyEnumFieldTreatedAsClosed() == true) goto L51;
        r14.addRepeatedField(r18, r18.getEnumType().findValueByNumberCreatingIfUnknown(r111));
        goto L48
    L51:
        Descriptors.EnumValueDescriptor r112 = r18.getEnumType().findValueByNumber(r111);
        if (r112 == null) goto L53;
        r14.addRepeatedField(r18, r112);
        goto L48
    L53:
        if (r11 == null) goto L48;
        r11.mergeVarintField(r17, r111);
    L60:
        r10.popLimit(r24);
    L81:
        return true;
    L58:
        if (r10.getBytesUntilLimit() <= 0) goto L60;
        r14.addRepeatedField(r18, WireFormat.readPrimitiveField(r10, r18.getLiteType(), r14.getUtf8Validation(r18)));
        goto L58
    L61:
        int r113 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r18.getType().ordinal()];
        if (r113 != 1) goto L64;
        r14.mergeGroup(r10, r12, r18, r110);
        return true;
    L64:
        if (r113 != 2) goto L66;
        r14.mergeMessage(r10, r12, r18, r110);
        return true;
    L66:
        if (r113 == 3) goto L68;
        Object r25 = WireFormat.readPrimitiveField(r10, r18.getLiteType(), r14.getUtf8Validation(r18));
    L78:
        if (r18.isRepeated() == false) goto L80;
        r14.addRepeatedField(r18, r25);
        goto L81
    L80:
        r14.setField(r18, r25);
        goto L81
    L68:
        int r26 = r10.readEnum();
        if (r18.legacyEnumFieldTreatedAsClosed() == false) goto L76;
        Descriptors.EnumValueDescriptor r27 = r18.getEnumType().findValueByNumber(r26);
        if (r27 != null) goto L75;
        if (r11 == null) goto L74;
        r11.mergeVarintField(r17, r26);
    L74:
        return true;
    L75:
        r25 = r27;
        goto L78
    L76:
        r25 = r18.getEnumType().findValueByNumberCreatingIfUnknown(r26);
        goto L78
    L31:
        if (r16 != FieldSet.getWireFormatForFieldType(r18.getLiteType(), false)) goto L34;
        r23 = false;
        goto L38
    L34:
        if (r18.isPackable() == false) goto L29;
        if (r16 != FieldSet.getWireFormatForFieldType(r18.getLiteType(), true)) goto L29;
        r23 = true;
        goto L38
    L18:
        if (r20.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
        throw new IllegalStateException("Message-typed extension lacked default instance: " + r20.getFullName());
    L26:
        r110 = null;
        goto L27
    L24:
        if (r14.getContainerType() != MergeTarget.ContainerType.MESSAGE) goto L26;
        r18 = r13.findFieldByNumber(r17);
        r110 = null;
        goto L27
    L5:
        if (r15 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L8;
        mergeMessageSetExtensionFromCodedStream(r10, r11, r12, r13, r14);
        return true;
    }

    static void mergeMessageFrom(Message.Builder r10, UnknownFieldSet.Builder r11, CodedInputStream r12, ExtensionRegistryLite r13) {
        BuilderAdapter r14 = new BuilderAdapter(r10);
        Descriptors.Descriptor r15 = r10.getDescriptorForType();
    L3:
        int r16 = r12.readTag();
        if (r16 == 0) goto L8;
        if (mergeFieldFrom(r12, r11, r13, r15, r14, r16) == true) goto L3;
        return;
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString r10, ExtensionRegistry.ExtensionInfo r11, ExtensionRegistryLite r12, MergeTarget r13) {
        Descriptors.FieldDescriptor r14 = r11.descriptor;
        if (r13.hasField(r14) == false) goto L5;
    L8:
        r13.setField(r14, r13.parseMessageFromBytes(r10, r12, r14, r11.defaultInstance));
        return;
    L5:
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == true) goto L8;
        r13.setField(r14, new LazyField(r11.defaultInstance, r12, r10));
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, Descriptors.Descriptor r13, MergeTarget r14) {
        int r15 = 0;
        ExtensionRegistry.ExtensionInfo r16 = null;
        ByteString r17 = null;
    L3:
        int r18 = r10.readTag();
        if (r18 == 0) goto L26;
        if (r18 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
        if (r18 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L15;
        if (r18 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L26;
        if (r10.skipField(r18) == true) goto L3;
    L15:
        if (r15 == 0) goto L20;
        if (r16 == null) goto L20;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L20;
        eagerlyMergeMessageSetExtension(r10, r16, r12, r14);
        r17 = null;
    L20:
        r17 = r10.readBytes();
        goto L3
    L8:
        r15 = r10.readUInt32();
        if (r15 == 0) goto L3;
        if ((r12 instanceof ExtensionRegistry) == false) goto L3;
        r16 = r14.findExtensionByNumber((ExtensionRegistry) r12, r13, r15);
    L26:
        r10.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (r17 == null) goto L54;
        if (r15 == 0) goto L55;
        if (r16 == null) goto L31;
        mergeMessageSetExtensionFromBytes(r17, r16, r12, r14);
        return;
    L31:
        if (r11 == null) goto L57;
        r11.mergeField(r15, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r17).build());
        return;
    L57:
        return;
    L55:
        return;
    }

    private static String subMessagePrefix(String r10, Descriptors.FieldDescriptor r11, int r12) {
        StringBuilder r13 = new StringBuilder(r10);
        if (r11.isExtension() == false) goto L5;
        r13.append('(');
        r13.append(r11.getFullName());
        r13.append(')');
    L7:
        if (r12 == (-1)) goto L9;
        r13.append('[');
        r13.append(r12);
        r13.append(']');
    L9:
        r13.append('.');
        return r13.toString();
    L5:
        r13.append(r11.getName());
        goto L7
    }

    static void writeMessageTo(Message r10, Map<Descriptors.FieldDescriptor, Object> r11, CodedOutputStream r12, boolean r13) {
        boolean r14 = r10.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (r13 == false) goto L13;
        TreeMap r15 = new TreeMap(r11);
        Iterator<Descriptors.FieldDescriptor> r16 = r10.getDescriptorForType().getFields().iterator();
    L6:
        if (r16.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r17 = r16.next();
        if (r17.isRequired() == false) goto L6;
        if (r15.containsKey(r17) == true) goto L6;
        r15.put(r17, r10.getField(r17));
        goto L6
    L12:
        r11 = r15;
    L13:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r18 = r11.entrySet().iterator();
    L15:
        if (r18.hasNext() == false) goto L26;
        Map.Entry<Descriptors.FieldDescriptor, Object> r19 = r18.next();
        Descriptors.FieldDescriptor r20 = r19.getKey();
        Object r21 = r19.getValue();
        if (r14 == false) goto L25;
        if (r20.isExtension() == false) goto L25;
        if (r20.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L25;
        if (r20.isRepeated() == true) goto L25;
        r12.writeMessageSetExtension(r20.getNumber(), (Message) r21);
    L25:
        FieldSet.writeField(r20, r21, r12);
        goto L15
    L26:
        UnknownFieldSet r22 = r10.getUnknownFields();
        if (r14 == false) goto L29;
        r22.writeAsMessageSetTo(r12);
        return;
    L29:
        r22.writeTo(r12);
    }
}
