package com.google.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class MessageReflection {

    /* JADX INFO: renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r8 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r8;
            r8[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;
        private boolean hasNestedBuilders;

        public BuilderAdapter(Message.Builder r8) {
            this.hasNestedBuilders = true;
            this.builder = r8;
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r8) {
            if (this.hasNestedBuilders == false) goto L11;
            return this.builder.getFieldBuilder(r8);
        L6:
            this.hasNestedBuilders = false;
            return null;
        L11:
            return null;
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor r8, Message r10) {
            if (r10 == null) goto L6;
            return r10.newBuilderForType();
        L6:
            return this.builder.newBuilderForField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            if ((r10 instanceof MessageLite.Builder) == false) goto L5;
            r10 = ((MessageLite.Builder) r10).buildPartial();
        L5:
            this.builder.addRepeatedField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r8) {
            this.builder.clearField(r8);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r8) {
            this.builder.clearOneof(r8);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r8, String r10) {
            return r8.findImmutableExtensionByName(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r8, Descriptors.Descriptor r10, int r11) {
            return r8.findImmutableExtensionByNumber(r10, r11);
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
        public Object getField(Descriptors.FieldDescriptor r8) {
            return this.builder.getField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            return this.builder.getOneofFieldDescriptor(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r8) {
            if (r8.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            if (r8.isRepeated() == true) goto L13;
            if ((this.builder instanceof GeneratedMessage.Builder) == false) goto L13;
            return WireFormat.Utf8Validation.LAZY;
        L13:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            return this.builder.hasField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            return this.builder.hasOneof(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = newMessageFieldInstance(r11, r12);
            r8.readGroup(r11.getNumber(), r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L11;
            Message.Builder r14 = getFieldBuilder(r11);
            if (r14 == null) goto L10;
            r8.readGroup(r11.getNumber(), r14, r10);
            return;
        L10:
            Message.Builder r15 = newMessageFieldInstance(r11, r12);
            r15.mergeFrom((Message) getField(r11));
        L12:
            r8.readGroup(r11.getNumber(), r15, r10);
            setField(r11, r15.buildPartial());
            return;
        L11:
            r15 = newMessageFieldInstance(r11, r12);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = newMessageFieldInstance(r11, r12);
            r8.readMessage(r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L11;
            Message.Builder r14 = getFieldBuilder(r11);
            if (r14 == null) goto L10;
            r8.readMessage(r14, r10);
            return;
        L10:
            Message.Builder r15 = newMessageFieldInstance(r11, r12);
            r15.mergeFrom((Message) getField(r11));
        L12:
            r8.readMessage(r15, r10);
            setField(r11, r15.buildPartial());
            return;
        L11:
            r15 = newMessageFieldInstance(r11, r12);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            if (r10 == null) goto L4;
            Message.Builder r11 = r10.newBuilderForType();
        L6:
            return new BuilderAdapter(r11);
        L4:
            r11 = this.builder.newBuilderForField(r8);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            if (r8.isRepeated() == false) goto L5;
        L10:
            Message.Builder r11 = newMessageFieldInstance(r8, r10);
            if (r8.isRepeated() == true) goto L16;
            Message r12 = (Message) getField(r8);
            if (r12 == null) goto L16;
            r11.mergeFrom(r12);
        L16:
            return new BuilderAdapter(r11);
        L5:
            if (hasField(r8) == false) goto L10;
            Message.Builder r13 = getFieldBuilder(r8);
            if (r13 == null) goto L10;
            return new BuilderAdapter(r13);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r12 == null) goto L4;
            Message.Builder r13 = r12.newBuilderForType();
        L6:
            if (r11.isRepeated() == true) goto L10;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L10;
            r13.mergeFrom(r14);
        L10:
            r8.readGroup(r11.getNumber(), r13, r10);
            return r13.buildPartial();
        L4:
            r13 = this.builder.newBuilderForField(r11);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r12 == null) goto L4;
            Message.Builder r13 = r12.newBuilderForType();
        L6:
            if (r11.isRepeated() == true) goto L10;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L10;
            r13.mergeFrom(r14);
        L10:
            r8.readMessage(r13, r10);
            return r13.buildPartial();
        L4:
            r13 = this.builder.newBuilderForField(r11);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r12 == null) goto L4;
            Message.Builder r13 = r12.newBuilderForType();
        L6:
            if (r11.isRepeated() == true) goto L10;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L10;
            r13.mergeFrom(r14);
        L10:
            r13.mergeFrom(r8, r10);
            return r13.buildPartial();
        L4:
            r13 = this.builder.newBuilderForField(r11);
            goto L6
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r8, Object r10) {
            if (r8.isRepeated() == false) goto L5;
        L10:
            this.builder.setField(r8, r10);
            return this;
        L5:
            if ((r10 instanceof MessageLite.Builder) == false) goto L10;
            if (r10 == getFieldBuilder(r8)) goto L9;
            this.builder.setField(r8, ((MessageLite.Builder) r10).buildPartial());
        L9:
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            if ((r11 instanceof MessageLite.Builder) == false) goto L5;
            r11 = ((MessageLite.Builder) r11).buildPartial();
        L5:
            this.builder.setRepeatedField(r8, r10, r11);
            return this;
        }
    }

    public static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> r8) {
            this.extensions = r8;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            this.extensions.addRepeatedField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r8) {
            this.extensions.clearField(r8);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r8) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r8, String r10) {
            return r8.findImmutableExtensionByName(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r8, Descriptors.Descriptor r10, int r11) {
            return r8.findImmutableExtensionByNumber(r10, r11);
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
        public Object getField(Descriptors.FieldDescriptor r8) {
            return this.extensions.getField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r8) {
            if (r8.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            return this.extensions.hasField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = r12.newBuilderForType();
            r8.readGroup(r11.getNumber(), r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L8;
            MessageLite.Builder r14 = ((MessageLite) getField(r11)).toBuilder();
            r8.readGroup(r11.getNumber(), r14, r10);
            setField(r11, r14.buildPartial());
            return;
        L8:
            Message.Builder r15 = r12.newBuilderForType();
            r8.readGroup(r11.getNumber(), r15, r10);
            setField(r11, r15.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = r12.newBuilderForType();
            r8.readMessage(r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L8;
            MessageLite.Builder r14 = ((MessageLite) getField(r11)).toBuilder();
            r8.readMessage(r14, r10);
            setField(r11, r14.buildPartial());
            return;
        L8:
            Message.Builder r15 = r12.newBuilderForType();
            r8.readMessage(r15, r10);
            setField(r11, r15.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r8.readGroup(r11.getNumber(), r13, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r8.readMessage(r13, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r13.mergeFrom(r8, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r8, Object r10) {
            this.extensions.setField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            this.extensions.setRepeatedField(r8, r10, r11);
            return this;
        }
    }

    public static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        public ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> r8) {
            this.extensions = r8;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            this.extensions.addRepeatedField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget clearField(Descriptors.FieldDescriptor r8) {
            this.extensions.clearField(r8);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r8) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r8, String r10) {
            return r8.findImmutableExtensionByName(r10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r8, Descriptors.Descriptor r10, int r11) {
            return r8.findImmutableExtensionByNumber(r10, r11);
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
        public Object getField(Descriptors.FieldDescriptor r8) {
            return this.extensions.getField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r8) {
            if (r8.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            return this.extensions.hasField(r8);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = r12.newBuilderForType();
            r8.readGroup(r11.getNumber(), r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L12;
            Object r14 = this.extensions.getFieldAllowBuilders(r11);
            if ((r14 instanceof MessageLite.Builder) == false) goto L9;
            MessageLite.Builder r15 = (MessageLite.Builder) r14;
        L10:
            r8.readGroup(r11.getNumber(), r15, r10);
            return;
        L9:
            r15 = ((MessageLite) r14).toBuilder();
            this.extensions.setField(r11, r15);
            goto L10
        L12:
            Message.Builder r16 = r12.newBuilderForType();
            r8.readGroup(r11.getNumber(), r16, r10);
            setField(r11, r16);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            if (r11.isRepeated() == false) goto L5;
            Message.Builder r13 = r12.newBuilderForType();
            r8.readMessage(r13, r10);
            addRepeatedField(r11, r13.buildPartial());
            return;
        L5:
            if (hasField(r11) == false) goto L12;
            Object r14 = this.extensions.getFieldAllowBuilders(r11);
            if ((r14 instanceof MessageLite.Builder) == false) goto L9;
            MessageLite.Builder r15 = (MessageLite.Builder) r14;
        L10:
            r8.readMessage(r15, r10);
            return;
        L9:
            r15 = ((MessageLite) r14).toBuilder();
            this.extensions.setField(r11, r15);
            goto L10
        L12:
            Message.Builder r16 = r12.newBuilderForType();
            r8.readMessage(r16, r10);
            setField(r11, r16);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r8, Message r10) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r8.readGroup(r11.getNumber(), r13, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r8.readMessage(r13, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12) {
            Message.Builder r13 = r12.newBuilderForType();
            if (r11.isRepeated() == true) goto L7;
            Message r14 = (Message) getField(r11);
            if (r14 == null) goto L7;
            r13.mergeFrom(r14);
        L7:
            r13.mergeFrom(r8, r10);
            return r13.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget setField(Descriptors.FieldDescriptor r8, Object r10) {
            this.extensions.setField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        @CanIgnoreReturnValue
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            this.extensions.setRepeatedField(r8, r10, r11);
            return this;
        }
    }

    public interface MergeTarget {

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

            private ContainerType(String r8, int r10) {
                super(r8, r10);
            }

            public static ContainerType valueOf(String r8) {
                return (ContainerType) java.lang.Enum.valueOf(ContainerType.class, r8);
            }

            public static ContainerType[] values() {
                return (ContainerType[]) $VALUES.clone();
            }
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor r8, Object r10);

        MergeTarget clearField(Descriptors.FieldDescriptor r8);

        MergeTarget clearOneof(Descriptors.OneofDescriptor r8);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r8, String r10);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r8, Descriptors.Descriptor r10, int r11);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor r8);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r8);

        boolean hasField(Descriptors.FieldDescriptor r8);

        boolean hasOneof(Descriptors.OneofDescriptor r8);

        void mergeGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12);

        void mergeMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r8, Message r10);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r8, Message r10);

        Object parseGroup(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12);

        Object parseMessage(CodedInputStream r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12);

        Object parseMessageFromBytes(ByteString r8, ExtensionRegistryLite r10, Descriptors.FieldDescriptor r11, Message r12);

        MergeTarget setField(Descriptors.FieldDescriptor r8, Object r10);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11);
    }

    public MessageReflection() {
    }

    public static String delimitWithCommas(List<String> r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator<String> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();
        if (r10.length() <= 0) goto L8;
        r10.append(", ");
    L8:
        r10.append(r12);
        goto L4
    L10:
        return r10.toString();
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream r8, ExtensionRegistry.ExtensionInfo r10, ExtensionRegistryLite r11, MergeTarget r12) {
        Descriptors.FieldDescriptor r13 = r10.descriptor;
        r12.setField(r13, r12.parseMessage(r8, r11, r13, r10.defaultInstance));
    }

    public static List<String> findMissingFields(MessageOrBuilder r8) {
        ArrayList r10 = new ArrayList();
        findMissingFields(r8, "", r10);
        return r10;
    }

    public static int getSerializedSize(Message r8, Map<Descriptors.FieldDescriptor, Object> r10) {
        boolean r11 = r8.getDescriptorForType().getOptions().getMessageSetWireFormat();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = r10.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<Descriptors.FieldDescriptor, Object> r14 = r12.next();
        Descriptors.FieldDescriptor r15 = r14.getKey();
        Object r16 = r14.getValue();
        if (r11 == false) goto L14;
        if (r15.isExtension() == false) goto L14;
        if (r15.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L14;
        if (r15.isRepeated() == true) goto L14;
        r13 = CodedOutputStream.computeMessageSetExtensionSize(r15.getNumber(), (Message) r16) + r13;
    L14:
        r13 = r13 + FieldSet.computeFieldSize(r15, r16);
        goto L4
    L15:
        UnknownFieldSet r17 = r8.getUnknownFields();
        if (r11 == false) goto L18;
        int r18 = r17.getSerializedSizeAsMessageSet();
    L20:
        return r18 + r13;
    L18:
        r18 = r17.getSerializedSize();
        goto L20
    }

    public static boolean isInitialized(MessageOrBuilder r8) {
        Iterator<Descriptors.FieldDescriptor> r10 = r8.getDescriptorForType().getFields().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r11 = r10.next();
        if (r11.isRequired() == false) goto L4;
        if (r8.hasField(r11) == true) goto L4;
        return false;
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = r8.getAllFields().entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L26;
        Map.Entry<Descriptors.FieldDescriptor, Object> r13 = r12.next();
        Descriptors.FieldDescriptor r14 = r13.getKey();
        if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        boolean r15 = r14.isRepeated();
        Object r16 = r13.getValue();
        if (r15 == true) goto L17;
        if (((Message) r16).isInitialized() == true) goto L12;
        return false;
    L17:
        Iterator r17 = ((List) r16).iterator();
    L19:
        if (r17.hasNext() == false) goto L12;
        if (((Message) r17.next()).isInitialized() == true) goto L19;
        return false;
    L26:
        return true;
    }

    public static boolean mergeFieldFrom(CodedInputStream r8, UnknownFieldSet.Builder r10, ExtensionRegistryLite r11, Descriptors.Descriptor r12, MergeTarget r13, int r14) {
        if (r12.getOptions().getMessageSetWireFormat() == true) goto L5;
    L8:
        int r15 = WireFormat.getTagWireType(r14);
        int r16 = WireFormat.getTagFieldNumber(r14);
        Descriptors.FieldDescriptor r17 = null;
        if (r12.isExtensionNumber(r16) == false) goto L24;
        if ((r11 instanceof ExtensionRegistry) == false) goto L26;
        ExtensionRegistry.ExtensionInfo r18 = r13.findExtensionByNumber((ExtensionRegistry) r11, r12, r16);
        if (r18 == null) goto L26;
        Descriptors.FieldDescriptor r19 = r18.descriptor;
        Message r20 = r18.defaultInstance;
        if (r20 == null) goto L18;
    L22:
        Message r110 = r20;
        r17 = r19;
    L27:
        boolean r21 = false;
        if (r17 != null) goto L31;
    L29:
        boolean r22 = false;
        r21 = true;
    L38:
        if (r21 == false) goto L44;
        if (r10 == null) goto L43;
        return r10.mergeFieldFrom(r14, r8);
    L43:
        return r8.skipField(r14);
    L44:
        if (r22 == false) goto L61;
        int r23 = r8.pushLimit(r8.readRawVarint32());
        if (r17.getLiteType() != WireFormat.FieldType.ENUM) goto L58;
    L48:
        if (r8.getBytesUntilLimit() <= 0) goto L60;
        int r111 = r8.readEnum();
        if (r17.legacyEnumFieldTreatedAsClosed() == true) goto L51;
        r13.addRepeatedField(r17, r17.getEnumType().findValueByNumberCreatingIfUnknown(r111));
        goto L48
    L51:
        Descriptors.EnumValueDescriptor r112 = r17.getEnumType().findValueByNumber(r111);
        if (r112 == null) goto L53;
        r13.addRepeatedField(r17, r112);
        goto L48
    L53:
        if (r10 == null) goto L48;
        r10.mergeVarintField(r16, r111);
    L60:
        r8.popLimit(r23);
    L81:
        return true;
    L58:
        if (r8.getBytesUntilLimit() <= 0) goto L60;
        r13.addRepeatedField(r17, r8.readPrimitiveField(r17.getLiteType(), r13.getUtf8Validation(r17)));
        goto L58
    L61:
        int r113 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r17.getType().ordinal()];
        if (r113 != 1) goto L64;
        r13.mergeGroup(r8, r11, r17, r110);
        return true;
    L64:
        if (r113 != 2) goto L66;
        r13.mergeMessage(r8, r11, r17, r110);
        return true;
    L66:
        if (r113 == 3) goto L68;
        Object r24 = r8.readPrimitiveField(r17.getLiteType(), r13.getUtf8Validation(r17));
    L78:
        if (r17.isRepeated() == false) goto L80;
        r13.addRepeatedField(r17, r24);
        goto L81
    L80:
        r13.setField(r17, r24);
        goto L81
    L68:
        int r25 = r8.readEnum();
        if (r17.legacyEnumFieldTreatedAsClosed() == false) goto L76;
        Descriptors.EnumValueDescriptor r26 = r17.getEnumType().findValueByNumber(r25);
        if (r26 != null) goto L75;
        if (r10 == null) goto L74;
        r10.mergeVarintField(r16, r25);
    L74:
        return true;
    L75:
        r24 = r26;
        goto L78
    L76:
        r24 = r17.getEnumType().findValueByNumberCreatingIfUnknown(r25);
        goto L78
    L31:
        if (r15 != FieldSet.getWireFormatForFieldType(r17.getLiteType(), false)) goto L34;
        r22 = false;
        goto L38
    L34:
        if (r17.isPackable() == false) goto L29;
        if (r15 != FieldSet.getWireFormatForFieldType(r17.getLiteType(), true)) goto L29;
        r22 = true;
        goto L38
    L18:
        if (r19.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
        throw new IllegalStateException("Message-typed extension lacked default instance: " + r19.getFullName());
    L26:
        r110 = null;
        goto L27
    L24:
        if (r13.getContainerType() != MergeTarget.ContainerType.MESSAGE) goto L26;
        r17 = r12.findFieldByNumber(r16);
        r110 = null;
        goto L27
    L5:
        if (r14 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L8;
        mergeMessageSetExtensionFromCodedStream(r8, r10, r11, r12, r13);
        return true;
    }

    public static void mergeMessageFrom(Message.Builder r8, UnknownFieldSet.Builder r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        BuilderAdapter r13 = new BuilderAdapter(r8);
        Descriptors.Descriptor r14 = r8.getDescriptorForType();
    L3:
        int r15 = r11.readTag();
        if (r15 == 0) goto L8;
        if (mergeFieldFrom(r11, r10, r12, r14, r13, r15) == true) goto L3;
        return;
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString r8, ExtensionRegistry.ExtensionInfo r10, ExtensionRegistryLite r11, MergeTarget r12) {
        Descriptors.FieldDescriptor r13 = r10.descriptor;
        if (r12.hasField(r13) == false) goto L5;
    L8:
        r12.setField(r13, r12.parseMessageFromBytes(r8, r11, r13, r10.defaultInstance));
        return;
    L5:
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == true) goto L8;
        r12.setField(r13, new LazyField(r10.defaultInstance, r11, r8));
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream r8, UnknownFieldSet.Builder r10, ExtensionRegistryLite r11, Descriptors.Descriptor r12, MergeTarget r13) {
        int r14 = 0;
        ExtensionRegistry.ExtensionInfo r15 = null;
        ByteString r16 = null;
    L3:
        int r17 = r8.readTag();
        if (r17 == 0) goto L26;
        if (r17 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
        if (r17 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L15;
        if (r17 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L26;
        if (r8.skipField(r17) == true) goto L3;
    L15:
        if (r14 == 0) goto L20;
        if (r15 == null) goto L20;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L20;
        eagerlyMergeMessageSetExtension(r8, r15, r11, r13);
        r16 = null;
    L20:
        r16 = r8.readBytes();
        goto L3
    L8:
        r14 = r8.readUInt32();
        if (r14 == 0) goto L3;
        if ((r11 instanceof ExtensionRegistry) == false) goto L3;
        r15 = r13.findExtensionByNumber((ExtensionRegistry) r11, r12, r14);
    L26:
        r8.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (r16 == null) goto L54;
        if (r14 == 0) goto L55;
        if (r15 == null) goto L31;
        mergeMessageSetExtensionFromBytes(r16, r15, r11, r13);
        return;
    L31:
        if (r10 == null) goto L57;
        r10.mergeField(r14, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r16).build());
        return;
    L57:
        return;
    L55:
        return;
    }

    private static String subMessagePrefix(String r8, Descriptors.FieldDescriptor r10, int r11) {
        StringBuilder r12 = new StringBuilder(r8);
        if (r10.isExtension() == false) goto L5;
        r12.append('(');
        r12.append(r10.getFullName());
        r12.append(')');
    L7:
        if (r11 == (-1)) goto L9;
        r12.append('[');
        r12.append(r11);
        r12.append(']');
    L9:
        r12.append('.');
        return r12.toString();
    L5:
        r12.append(r10.getName());
        goto L7
    }

    public static void writeMessageTo(Message r8, Map<Descriptors.FieldDescriptor, Object> r10, CodedOutputStream r11, boolean r12) {
        boolean r13 = r8.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (r12 == false) goto L13;
        TreeMap r14 = new TreeMap(r10);
        Iterator<Descriptors.FieldDescriptor> r15 = r8.getDescriptorForType().getFields().iterator();
    L6:
        if (r15.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r16 = r15.next();
        if (r16.isRequired() == false) goto L6;
        if (r14.containsKey(r16) == true) goto L6;
        r14.put(r16, r8.getField(r16));
        goto L6
    L12:
        r10 = r14;
    L13:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r17 = r10.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L26;
        Map.Entry<Descriptors.FieldDescriptor, Object> r18 = r17.next();
        Descriptors.FieldDescriptor r19 = r18.getKey();
        Object r20 = r18.getValue();
        if (r13 == false) goto L25;
        if (r19.isExtension() == false) goto L25;
        if (r19.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L25;
        if (r19.isRepeated() == true) goto L25;
        r11.writeMessageSetExtension(r19.getNumber(), (Message) r20);
    L25:
        FieldSet.writeField(r19, r20, r11);
        goto L15
    L26:
        UnknownFieldSet r21 = r8.getUnknownFields();
        if (r13 == false) goto L29;
        r21.writeAsMessageSetTo(r11);
        return;
    L29:
        r21.writeTo(r11);
    }

    private static void findMissingFields(MessageOrBuilder r8, String r10, List<String> r11) {
        Iterator<Descriptors.FieldDescriptor> r12 = r8.getDescriptorForType().getFields().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r13 = r12.next();
        if (r13.isRequired() == false) goto L4;
        if (r8.hasField(r13) == true) goto L4;
        StringBuilder r14 = android.aimedia.a.j(r10);
        r14.append(r13.getName());
        r11.add(r14.toString());
        goto L4
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r15 = r8.getAllFields().entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L24;
        Map.Entry<Descriptors.FieldDescriptor, Object> r16 = r15.next();
        Descriptors.FieldDescriptor r17 = r16.getKey();
        Object r18 = r16.getValue();
        if (r17.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        if (r17.isRepeated() == true) goto L17;
        if (r8.hasField(r17) == false) goto L12;
        findMissingFields((MessageOrBuilder) r18, subMessagePrefix(r10, r17, -1), r11);
        goto L12
    L17:
        Iterator r19 = ((List) r18).iterator();
        int r20 = 0;
    L19:
        if (r19.hasNext() == false) goto L12;
        int r21 = r20 + 1;
        findMissingFields((MessageOrBuilder) r19.next(), subMessagePrefix(r10, r17, r20), r11);
        r20 = r21;
        goto L19
    }
}
