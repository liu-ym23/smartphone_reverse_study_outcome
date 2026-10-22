package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
class MessageReflection {

    /* JADX INFO: renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r0 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0;
            r0[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
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

        public BuilderAdapter(Message.Builder r3) {
            Message.Builder r4 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r3, Message.Builder.class, "com.obric.memorydata.plugin");
            this.hasNestedBuilders = true;
            this.builder = r4;
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r2) {
            if (this.hasNestedBuilders == false) goto L11;
            return this.builder.getFieldBuilder(r2);
        L6:
            this.hasNestedBuilders = false;
            return null;
        L11:
            return null;
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor r3, Message r4) {
            Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L7;
            return r5.newBuilderForType();
        L7:
            return this.builder.newBuilderForField(r3);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MessageLite.Builder.class) == false) goto L5;
            r4 = ((MessageLite.Builder) ZeusTransformUtils.preCheckCast(r4, MessageLite.Builder.class, "com.obric.memorydata.plugin")).buildPartial();
        L5:
            this.builder.addRepeatedField(r3, r4);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r2) {
            this.builder.clearField(r2);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r2) {
            this.builder.clearOneof(r2);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r1, String r2) {
            return r1.findImmutableExtensionByName(r2);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r1, Descriptors.Descriptor r2, int r3) {
            return r1.findImmutableExtensionByNumber(r2, r3);
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
        public Object getField(Descriptors.FieldDescriptor r1) {
            return this.builder.getField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
            return this.builder.getOneofFieldDescriptor(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r2) {
            if (r2.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            if (r2.isRepeated() == true) goto L13;
            if (ZeusTransformUtils.instanceOf(this.builder, GeneratedMessage.Builder.class) == false) goto L13;
            return WireFormat.Utf8Validation.LAZY;
        L13:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r1) {
            return this.builder.hasField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r1) {
            return this.builder.hasOneof(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r4, ExtensionRegistryLite r5, Descriptors.FieldDescriptor r6, Message r7) {
            Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
            if (r6.isRepeated() == false) goto L5;
            Message.Builder r9 = newMessageFieldInstance(r6, r8);
            r4.readGroup(r6.getNumber(), r9, r5);
            addRepeatedField(r6, r9.buildPartial());
            return;
        L5:
            if (hasField(r6) == false) goto L11;
            Message.Builder r0 = getFieldBuilder(r6);
            if (r0 == null) goto L10;
            r4.readGroup(r6.getNumber(), r0, r5);
            return;
        L10:
            Message.Builder r10 = newMessageFieldInstance(r6, r8);
            r10.mergeFrom((Message) ZeusTransformUtils.preCheckCast(getField(r6), Message.class, "com.obric.memorydata.plugin"));
        L12:
            r4.readGroup(r6.getNumber(), r10, r5);
            setField(r6, r10.buildPartial());
            return;
        L11:
            r10 = newMessageFieldInstance(r6, r8);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r4, ExtensionRegistryLite r5, Descriptors.FieldDescriptor r6, Message r7) {
            Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
            if (r6.isRepeated() == false) goto L5;
            Message.Builder r9 = newMessageFieldInstance(r6, r8);
            r4.readMessage(r9, r5);
            addRepeatedField(r6, r9.buildPartial());
            return;
        L5:
            if (hasField(r6) == false) goto L11;
            Message.Builder r0 = getFieldBuilder(r6);
            if (r0 == null) goto L10;
            r4.readMessage(r0, r5);
            return;
        L10:
            Message.Builder r10 = newMessageFieldInstance(r6, r8);
            r10.mergeFrom((Message) ZeusTransformUtils.preCheckCast(getField(r6), Message.class, "com.obric.memorydata.plugin"));
        L12:
            r4.readMessage(r10, r5);
            setField(r6, r10.buildPartial());
            return;
        L11:
            r10 = newMessageFieldInstance(r6, r8);
            goto L12
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r3, Message r4) {
            Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            Message.Builder r2 = r5.newBuilderForType();
        L7:
            return new BuilderAdapter(r2);
        L5:
            r2 = this.builder.newBuilderForField(r3);
            goto L7
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r3, Message r4) {
            Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
            if (r3.isRepeated() == false) goto L5;
        L10:
            Message.Builder r6 = newMessageFieldInstance(r3, r5);
            if (r3.isRepeated() == true) goto L16;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r3), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L16;
            r6.mergeFrom(r2);
        L16:
            return new BuilderAdapter(r6);
        L5:
            if (hasField(r3) == false) goto L10;
            Message.Builder r0 = getFieldBuilder(r3);
            if (r0 == null) goto L10;
            return new BuilderAdapter(r0);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
        L7:
            if (r5.isRepeated() == true) goto L11;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L11;
            r8.mergeFrom(r2);
        L11:
            r3.readGroup(r5.getNumber(), r8, r4);
            return r8.buildPartial();
        L5:
            r8 = this.builder.newBuilderForField(r5);
            goto L7
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
        L7:
            if (r5.isRepeated() == true) goto L11;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L11;
            r8.mergeFrom(r2);
        L11:
            r3.readMessage(r8, r4);
            return r8.buildPartial();
        L5:
            r8 = this.builder.newBuilderForField(r5);
            goto L7
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
        L7:
            if (r5.isRepeated() == true) goto L11;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L11;
            r8.mergeFrom(r2);
        L11:
            r8.mergeFrom(r3, r4);
            return r8.buildPartial();
        L5:
            r8 = this.builder.newBuilderForField(r5);
            goto L7
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r4, Object r5) {
            if (r4.isRepeated() == false) goto L5;
        L10:
            this.builder.setField(r4, r5);
            return this;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, MessageLite.Builder.class) == false) goto L10;
            if (r5 == getFieldBuilder(r4)) goto L9;
            this.builder.setField(r4, ((MessageLite.Builder) ZeusTransformUtils.preCheckCast(r5, MessageLite.Builder.class, "com.obric.memorydata.plugin")).buildPartial());
        L9:
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r3, int r4, Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, MessageLite.Builder.class) == false) goto L5;
            r5 = ((MessageLite.Builder) ZeusTransformUtils.preCheckCast(r5, MessageLite.Builder.class, "com.obric.memorydata.plugin")).buildPartial();
        L5:
            this.builder.setRepeatedField(r3, r4, r5);
            return this;
        }
    }

    static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> r1) {
            this.extensions = r1;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r2, Object r3) {
            this.extensions.addRepeatedField(r2, r3);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r2) {
            this.extensions.clearField(r2);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r1) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r1, String r2) {
            return r1.findImmutableExtensionByName(r2);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r1, Descriptors.Descriptor r2, int r3) {
            return r1.findImmutableExtensionByNumber(r2, r3);
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
        public Object getField(Descriptors.FieldDescriptor r1) {
            return this.extensions.getField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r1) {
            if (r1.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r1) {
            return this.extensions.hasField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r1) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r5.isRepeated() == false) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
            r3.readGroup(r5.getNumber(), r8, r4);
            addRepeatedField(r5, r8.buildPartial());
            return;
        L5:
            if (hasField(r5) == false) goto L8;
            MessageLite.Builder r9 = ((MessageLite) ZeusTransformUtils.preCheckCast(getField(r5), MessageLite.class, "com.obric.memorydata.plugin")).toBuilder();
            r3.readGroup(r5.getNumber(), r9, r4);
            setField(r5, r9.buildPartial());
            return;
        L8:
            Message.Builder r10 = r7.newBuilderForType();
            r3.readGroup(r5.getNumber(), r10, r4);
            setField(r5, r10.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r5.isRepeated() == false) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
            r3.readMessage(r8, r4);
            addRepeatedField(r5, r8.buildPartial());
            return;
        L5:
            if (hasField(r5) == false) goto L8;
            MessageLite.Builder r9 = ((MessageLite) ZeusTransformUtils.preCheckCast(getField(r5), MessageLite.class, "com.obric.memorydata.plugin")).toBuilder();
            r3.readMessage(r9, r4);
            setField(r5, r9.buildPartial());
            return;
        L8:
            Message.Builder r10 = r7.newBuilderForType();
            r3.readMessage(r10, r4);
            setField(r5, r10.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r1, Message r2) {
            Message r0 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r1, Message r2) {
            Message r0 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r3.readGroup(r5.getNumber(), r7, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r3.readMessage(r7, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r7.mergeFrom(r3, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r2, Object r3) {
            this.extensions.setField(r2, r3);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r2, int r3, Object r4) {
            this.extensions.setRepeatedField(r2, r3, r4);
            return this;
        }
    }

    static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> r1) {
            this.extensions = r1;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor r2, Object r3) {
            this.extensions.addRepeatedField(r2, r3);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor r2) {
            this.extensions.clearField(r2);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor r1) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r1, String r2) {
            return r1.findImmutableExtensionByName(r2);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r1, Descriptors.Descriptor r2, int r3) {
            return r1.findImmutableExtensionByNumber(r2, r3);
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
        public Object getField(Descriptors.FieldDescriptor r1) {
            return this.extensions.getField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r1) {
            if (r1.needsUtf8Check() == false) goto L7;
            return WireFormat.Utf8Validation.STRICT;
        L7:
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor r1) {
            return this.extensions.hasField(r1);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor r1) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r5.isRepeated() == false) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
            r3.readGroup(r5.getNumber(), r8, r4);
            addRepeatedField(r5, r8.buildPartial());
            return;
        L5:
            if (hasField(r5) == false) goto L12;
            Object r9 = this.extensions.getFieldAllowBuilders(r5);
            if (ZeusTransformUtils.instanceOf(r9, MessageLite.Builder.class) == false) goto L9;
            MessageLite.Builder r2 = (MessageLite.Builder) ZeusTransformUtils.preCheckCast(r9, MessageLite.Builder.class, "com.obric.memorydata.plugin");
        L10:
            r3.readGroup(r5.getNumber(), r2, r4);
            return;
        L9:
            MessageLite.Builder r10 = ((MessageLite) ZeusTransformUtils.preCheckCast(r9, MessageLite.class, "com.obric.memorydata.plugin")).toBuilder();
            this.extensions.setField(r5, r10);
            r2 = r10;
            goto L10
        L12:
            MessageLite.Builder r11 = r7.newBuilderForType();
            r3.readGroup(r5.getNumber(), r11, r4);
            setField(r5, r11);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin");
            if (r5.isRepeated() == false) goto L5;
            Message.Builder r8 = r7.newBuilderForType();
            r3.readMessage(r8, r4);
            addRepeatedField(r5, r8.buildPartial());
            return;
        L5:
            if (hasField(r5) == false) goto L12;
            Object r9 = this.extensions.getFieldAllowBuilders(r5);
            if (ZeusTransformUtils.instanceOf(r9, MessageLite.Builder.class) == false) goto L9;
            MessageLite.Builder r2 = (MessageLite.Builder) ZeusTransformUtils.preCheckCast(r9, MessageLite.Builder.class, "com.obric.memorydata.plugin");
        L10:
            r3.readMessage(r2, r4);
            return;
        L9:
            MessageLite.Builder r10 = ((MessageLite) ZeusTransformUtils.preCheckCast(r9, MessageLite.class, "com.obric.memorydata.plugin")).toBuilder();
            this.extensions.setField(r5, r10);
            r2 = r10;
            goto L10
        L12:
            MessageLite.Builder r11 = r7.newBuilderForType();
            r3.readMessage(r11, r4);
            setField(r5, r11);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r1, Message r2) {
            Message r0 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r1, Message r2) {
            Message r0 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r3.readGroup(r5.getNumber(), r7, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r3.readMessage(r7, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString r3, ExtensionRegistryLite r4, Descriptors.FieldDescriptor r5, Message r6) {
            Message.Builder r7 = ((Message) ZeusTransformUtils.wrapperContextForParams(r6, Message.class, "com.obric.memorydata.plugin")).newBuilderForType();
            if (r5.isRepeated() == true) goto L7;
            Message r2 = (Message) ZeusTransformUtils.preCheckCast(getField(r5), Message.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r7.mergeFrom(r2);
        L7:
            r7.mergeFrom(r3, r4);
            return r7.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor r2, Object r3) {
            this.extensions.setField(r2, r3);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor r2, int r3, Object r4) {
            this.extensions.setRepeatedField(r2, r3, r4);
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

            private ContainerType(String r1, int r2) {
                super(r1, r2);
            }

            public static ContainerType valueOf(String r2) {
                return (ContainerType) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(ContainerType.class, r2), ContainerType.class, "com.obric.memorydata.plugin");
            }

            public static ContainerType[] values() {
                return (ContainerType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContainerType[].class, "com.obric.memorydata.plugin");
            }
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor r1, Object r2);

        MergeTarget clearField(Descriptors.FieldDescriptor r1);

        MergeTarget clearOneof(Descriptors.OneofDescriptor r1);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry r1, String r2);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry r1, Descriptors.Descriptor r2, int r3);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor r1);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor r1);

        boolean hasField(Descriptors.FieldDescriptor r1);

        boolean hasOneof(Descriptors.OneofDescriptor r1);

        void mergeGroup(CodedInputStream r1, ExtensionRegistryLite r2, Descriptors.FieldDescriptor r3, Message r4);

        void mergeMessage(CodedInputStream r1, ExtensionRegistryLite r2, Descriptors.FieldDescriptor r3, Message r4);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor r1, Message r2);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor r1, Message r2);

        Object parseGroup(CodedInputStream r1, ExtensionRegistryLite r2, Descriptors.FieldDescriptor r3, Message r4);

        Object parseMessage(CodedInputStream r1, ExtensionRegistryLite r2, Descriptors.FieldDescriptor r3, Message r4);

        Object parseMessageFromBytes(ByteString r1, ExtensionRegistryLite r2, Descriptors.FieldDescriptor r3, Message r4);

        MergeTarget setField(Descriptors.FieldDescriptor r1, Object r2);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3);
    }

    MessageReflection() {
    }

    static String delimitWithCommas(List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L8;
        r0.append(", ");
    L8:
        r0.append(r2);
        goto L4
    L10:
        return r0.toString();
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream r2, ExtensionRegistry.ExtensionInfo r3, ExtensionRegistryLite r4, MergeTarget r5) {
        MergeTarget r6 = (MergeTarget) ZeusTransformUtils.wrapperContextForParams(r5, MergeTarget.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r0 = r3.descriptor;
        r6.setField(r0, r6.parseMessage(r2, r4, r0, r3.defaultInstance));
    }

    static List<String> findMissingFields(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        findMissingFields(r3, "", r0);
        return r0;
    }

    private static void findMissingFields(MessageOrBuilder r7, String r8, List<String> r9) {
        MessageOrBuilder r10 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r7, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Iterator<Descriptors.FieldDescriptor> r0 = r10.getDescriptorForType().getFields().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r2.isRequired() == false) goto L4;
        if (r10.hasField(r2) == true) goto L4;
        r11.add(r8 + r2.getName());
        goto L4
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r1 = r10.getAllFields().entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L24;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r4 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r3.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        Object r5 = r3.getValue();
        if (r4.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        if (r4.isRepeated() == true) goto L17;
        if (r10.hasField(r4) == false) goto L12;
        findMissingFields((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r5, MessageOrBuilder.class, "com.obric.memorydata.plugin"), subMessagePrefix(r8, r4, -1), r11);
        goto L12
    L17:
        int r6 = 0;
        Iterator r12 = ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r12.hasNext() == false) goto L12;
        findMissingFields((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r12.next(), MessageOrBuilder.class, "com.obric.memorydata.plugin"), subMessagePrefix(r8, r4, r6), r11);
        r6 = r6 + 1;
        goto L19
    }

    static int getSerializedSize(Message r7, Map<Descriptors.FieldDescriptor, Object> r8) {
        Message r9 = (Message) ZeusTransformUtils.wrapperContextForParams(r7, Message.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        boolean r0 = r9.getDescriptorForType().getOptions().getMessageSetWireFormat();
        Iterator r11 = r10.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r4 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r3.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        Object r5 = r3.getValue();
        if (r0 == true) goto L8;
    L14:
        int r6 = FieldSet.computeFieldSize(r4, r5);
    L15:
        r2 = r2 + r6;
        goto L4
    L8:
        if (r4.isExtension() == false) goto L14;
        if (r4.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L14;
        if (r4.isRepeated() == true) goto L14;
        r6 = CodedOutputStream.computeMessageSetExtensionSize(r4.getNumber(), (Message) ZeusTransformUtils.preCheckCast(r5, Message.class, "com.obric.memorydata.plugin"));
        goto L15
    L16:
        UnknownFieldSet r12 = r9.getUnknownFields();
        if (r0 == false) goto L19;
        int r13 = r12.getSerializedSizeAsMessageSet();
    L21:
        return r2 + r13;
    L19:
        r13 = r12.getSerializedSize();
        goto L21
    }

    static boolean isInitialized(MessageOrBuilder r6) {
        MessageOrBuilder r7 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r6, MessageOrBuilder.class, "com.obric.memorydata.plugin");
        Iterator<Descriptors.FieldDescriptor> r0 = r7.getDescriptorForType().getFields().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r2.isRequired() == false) goto L4;
        if (r7.hasField(r2) == true) goto L4;
        return false;
    L10:
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r8 = r7.getAllFields().entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r3 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
        boolean r4 = r3.isRepeated();
        Object r5 = r1.getValue();
        if (r4 == true) goto L17;
        if (((Message) ZeusTransformUtils.preCheckCast(r5, Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L12;
        return false;
    L17:
        Iterator r9 = ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r9.hasNext() == false) goto L12;
        if (((Message) ZeusTransformUtils.preCheckCast(r9.next(), Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L19;
        return false;
    L26:
        return true;
    }

    static boolean mergeFieldFrom(CodedInputStream r7, UnknownFieldSet.Builder r8, ExtensionRegistryLite r9, Descriptors.Descriptor r10, MergeTarget r11, int r12) {
        MergeTarget r13 = (MergeTarget) ZeusTransformUtils.wrapperContextForParams(r11, MergeTarget.class, "com.obric.memorydata.plugin");
        if (r10.getOptions().getMessageSetWireFormat() == true) goto L5;
    L8:
        int r0 = WireFormat.getTagWireType(r12);
        int r3 = WireFormat.getTagFieldNumber(r12);
        Descriptors.FieldDescriptor r5 = null;
        if (r10.isExtensionNumber(r3) == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r9, ExtensionRegistry.class) == false) goto L26;
        ExtensionRegistry.ExtensionInfo r14 = r13.findExtensionByNumber((ExtensionRegistry) ZeusTransformUtils.preCheckCast(r9, ExtensionRegistry.class, "com.obric.memorydata.plugin"), r10, r3);
        if (r14 == null) goto L26;
        Descriptors.FieldDescriptor r1 = r14.descriptor;
        Message r6 = r14.defaultInstance;
        if (r6 == null) goto L18;
    L22:
        Message r15 = r6;
        r5 = r1;
    L27:
        boolean r2 = false;
        if (r5 != null) goto L31;
    L29:
        boolean r4 = false;
        r2 = true;
    L38:
        if (r2 == false) goto L44;
        if (r8 == null) goto L43;
        return r8.mergeFieldFrom(r12, r7);
    L43:
        return r7.skipField(r12);
    L44:
        if (r4 == false) goto L61;
        int r16 = r7.pushLimit(r7.readRawVarint32());
        if (r5.getLiteType() != WireFormat.FieldType.ENUM) goto L58;
    L48:
        if (r7.getBytesUntilLimit() <= 0) goto L60;
        int r17 = r7.readEnum();
        if (r5.legacyEnumFieldTreatedAsClosed() == true) goto L51;
        r13.addRepeatedField(r5, r5.getEnumType().findValueByNumberCreatingIfUnknown(r17));
        goto L48
    L51:
        Descriptors.EnumValueDescriptor r18 = r5.getEnumType().findValueByNumber(r17);
        if (r18 == null) goto L53;
        r13.addRepeatedField(r5, r18);
        goto L48
    L53:
        if (r8 == null) goto L48;
        r8.mergeVarintField(r3, r17);
    L60:
        r7.popLimit(r16);
    L81:
        return true;
    L58:
        if (r7.getBytesUntilLimit() <= 0) goto L60;
        r13.addRepeatedField(r5, WireFormat.readPrimitiveField(r7, r5.getLiteType(), r13.getUtf8Validation(r5)));
        goto L58
    L61:
        int r19 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r5.getType().ordinal()];
        if (r19 != 1) goto L64;
        r13.mergeGroup(r7, r9, r5, r15);
        return true;
    L64:
        if (r19 != 2) goto L66;
        r13.mergeMessage(r7, r9, r5, r15);
        return true;
    L66:
        if (r19 == 3) goto L68;
        Object r20 = WireFormat.readPrimitiveField(r7, r5.getLiteType(), r13.getUtf8Validation(r5));
    L78:
        if (r5.isRepeated() == false) goto L80;
        r13.addRepeatedField(r5, r20);
        goto L81
    L80:
        r13.setField(r5, r20);
        goto L81
    L68:
        int r21 = r7.readEnum();
        if (r5.legacyEnumFieldTreatedAsClosed() == false) goto L76;
        Descriptors.EnumValueDescriptor r22 = r5.getEnumType().findValueByNumber(r21);
        if (r22 != null) goto L75;
        if (r8 == null) goto L74;
        r8.mergeVarintField(r3, r21);
    L74:
        return true;
    L75:
        r20 = r22;
        goto L78
    L76:
        r20 = r5.getEnumType().findValueByNumberCreatingIfUnknown(r21);
        goto L78
    L31:
        if (r0 != FieldSet.getWireFormatForFieldType(r5.getLiteType(), false)) goto L34;
        r4 = false;
        goto L38
    L34:
        if (r5.isPackable() == false) goto L29;
        if (r0 != FieldSet.getWireFormatForFieldType(r5.getLiteType(), true)) goto L29;
        r4 = true;
        goto L38
    L18:
        if (r1.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
        throw new IllegalStateException("Message-typed extension lacked default instance: " + r1.getFullName());
    L26:
        r15 = null;
        goto L27
    L24:
        if (r13.getContainerType() != MergeTarget.ContainerType.MESSAGE) goto L26;
        r5 = r10.findFieldByNumber(r3);
        r15 = null;
        goto L27
    L5:
        if (r12 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L8;
        mergeMessageSetExtensionFromCodedStream(r7, r8, r9, r10, r13);
        return true;
    }

    static void mergeMessageFrom(Message.Builder r7, UnknownFieldSet.Builder r8, CodedInputStream r9, ExtensionRegistryLite r10) {
        Message.Builder r11 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r7, Message.Builder.class, "com.obric.memorydata.plugin");
        BuilderAdapter r6 = new BuilderAdapter(r11);
        Descriptors.Descriptor r12 = r11.getDescriptorForType();
    L3:
        int r5 = r9.readTag();
        if (r5 == 0) goto L8;
        if (mergeFieldFrom(r9, r8, r10, r12, r6, r5) == true) goto L3;
        return;
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString r2, ExtensionRegistry.ExtensionInfo r3, ExtensionRegistryLite r4, MergeTarget r5) {
        MergeTarget r6 = (MergeTarget) ZeusTransformUtils.wrapperContextForParams(r5, MergeTarget.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r0 = r3.descriptor;
        if (r6.hasField(r0) == false) goto L5;
    L8:
        r6.setField(r0, r6.parseMessageFromBytes(r2, r4, r0, r3.defaultInstance));
        return;
    L5:
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == true) goto L8;
        r6.setField(r0, new LazyField(r3.defaultInstance, r4, r2));
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream r7, UnknownFieldSet.Builder r8, ExtensionRegistryLite r9, Descriptors.Descriptor r10, MergeTarget r11) {
        MergeTarget r12 = (MergeTarget) ZeusTransformUtils.wrapperContextForParams(r11, MergeTarget.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        ExtensionRegistry.ExtensionInfo r3 = null;
        ByteString r4 = null;
    L3:
        int r5 = r7.readTag();
        if (r5 == 0) goto L26;
        if (r5 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
        if (r5 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L15;
        if (r5 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L26;
        if (r7.skipField(r5) == true) goto L3;
    L15:
        if (r2 == 0) goto L20;
        if (r3 == null) goto L20;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L20;
        eagerlyMergeMessageSetExtension(r7, r3, r9, r12);
        r4 = null;
    L20:
        r4 = r7.readBytes();
        goto L3
    L8:
        r2 = r7.readUInt32();
        if (r2 == 0) goto L3;
        if (ZeusTransformUtils.instanceOf(r9, ExtensionRegistry.class) == false) goto L3;
        r3 = r12.findExtensionByNumber((ExtensionRegistry) ZeusTransformUtils.preCheckCast(r9, ExtensionRegistry.class, "com.obric.memorydata.plugin"), r10, r2);
    L26:
        r7.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (r4 == null) goto L55;
        if (r2 == 0) goto L56;
        if (r3 == null) goto L31;
        mergeMessageSetExtensionFromBytes(r4, r3, r9, r12);
        return;
    L31:
        if (r4 == null) goto L58;
        if (r8 == null) goto L59;
        r8.mergeField(r2, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r4).build());
        return;
    L59:
        return;
    L58:
        return;
    L56:
        return;
    }

    private static String subMessagePrefix(String r1, Descriptors.FieldDescriptor r2, int r3) {
        StringBuilder r0 = new StringBuilder(r1);
        if (r2.isExtension() == false) goto L5;
        r0.append('(').append(r2.getFullName()).append(')');
    L7:
        if (r3 == (-1)) goto L9;
        r0.append('[').append(r3).append(']');
    L9:
        r0.append('.');
        return r0.toString();
    L5:
        r0.append(r2.getName());
        goto L7
    }

    static void writeMessageTo(Message r5, Map<Descriptors.FieldDescriptor, Object> r6, CodedOutputStream r7, boolean r8) {
        Message r9 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        boolean r0 = r9.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (r8 == false) goto L13;
        TreeMap r11 = new TreeMap(r10);
        Iterator<Descriptors.FieldDescriptor> r12 = r9.getDescriptorForType().getFields().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r12.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r2.isRequired() == false) goto L6;
        if (r11.containsKey(r2) == true) goto L6;
        r11.put(r2, r9.getField(r2));
        goto L6
    L12:
        r10 = r11;
    L13:
        Iterator r13 = r10.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Descriptors.FieldDescriptor r3 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r14.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        Object r15 = r14.getValue();
        if (r0 == false) goto L25;
        if (r3.isExtension() == false) goto L25;
        if (r3.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L25;
        if (r3.isRepeated() == true) goto L25;
        r7.writeMessageSetExtension(r3.getNumber(), (Message) ZeusTransformUtils.preCheckCast(r15, Message.class, "com.obric.memorydata.plugin"));
    L25:
        FieldSet.writeField(r3, r15, r7);
        goto L15
    L26:
        UnknownFieldSet r16 = r9.getUnknownFields();
        if (r0 == false) goto L29;
        r16.writeAsMessageSetTo(r7);
        return;
    L29:
        r16.writeTo(r7);
    }
}
