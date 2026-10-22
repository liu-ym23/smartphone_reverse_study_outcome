package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;

        static {
            int[] r10 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r10;
            r10[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<BuilderT extends Builder<BuilderT>> extends AbstractMessage.Builder<BuilderT> {
        private AbstractMessage.BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderT>.BuilderParentImpl meAsParent;
        private Object unknownFieldsOrBuilder;

        private class BuilderParentImpl implements AbstractMessage.BuilderParent {
            final /* synthetic */ Builder this$0;

            private BuilderParentImpl(Builder r10) {
                this.this$0 = r10;
            }

            /* synthetic */ BuilderParentImpl(Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }
        }

        protected Builder() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
        }

        protected Builder(AbstractMessage.BuilderParent r10) {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            this.builderParent = r10;
        }

        static /* synthetic */ Map access$900(Builder r10) {
            return r10.getAllFieldsMutable();
        }

        private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap r10 = new TreeMap();
            List<Descriptors.FieldDescriptor> r11 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
            int r12 = 0;
        L4:
            if (r12 >= r11.size()) goto L22;
            Descriptors.FieldDescriptor r13 = r11.get(r12);
            Descriptors.OneofDescriptor r14 = r13.getContainingOneof();
            if (r14 == null) goto L12;
            r12 = r12 + (r14.getFieldCount() - 1);
            if (hasOneof(r14) == false) goto L21;
            r13 = getOneofFieldDescriptor(r14);
        L19:
            Object r15 = getField(r13);
        L20:
            r10.put(r13, r15);
        L21:
            r12 = r12 + 1;
            goto L4
        L12:
            if (r13.isRepeated() == false) goto L17;
            List r16 = (List) getField(r13);
            boolean r17 = r16.isEmpty();
            r15 = r16;
            if (r17 == true) goto L21;
        L17:
            if (hasField(r13) == true) goto L19;
        L22:
            return r10;
        }

        private BuilderT setUnknownFieldsInternal(UnknownFieldSet r10) {
            this.unknownFieldsOrBuilder = r10;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).addRepeated(this, r11);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT clearField(Descriptors.FieldDescriptor r10) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).clear(this);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearOneof(Descriptors.OneofDescriptor r10) {
            FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clone() {
            return (BuilderT) ((Builder) getDefaultInstanceForType().newBuilderForType()).mergeFrom(buildPartial());
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo13clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        void dispose() {
            this.builderParent = null;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            Object r11 = FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).get(this);
            if (r10.isRepeated() == true) goto L5;
            return r11;
        L5:
            return Collections.unmodifiableList((List) r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).get(this);
        }

        protected AbstractMessage.BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeated(this, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedBuilder(this, r11);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            Object r10 = this.unknownFieldsOrBuilder;
            if ((r10 instanceof UnknownFieldSet) == false) goto L5;
            this.unknownFieldsOrBuilder = ((UnknownFieldSet) r10).toBuilder();
        L5:
            onChanged();
            return (UnknownFieldSet.Builder) this.unknownFieldsOrBuilder;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            Object r10 = this.unknownFieldsOrBuilder;
            if ((r10 instanceof UnknownFieldSet) == false) goto L7;
            return (UnknownFieldSet) r10;
        L7:
            return ((UnknownFieldSet.Builder) r10).buildPartial();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).has(this);
        }

        protected abstract FieldAccessorTable internalGetFieldAccessorTable();

        @Deprecated
        protected MapField internalGetMapField(int r10) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }

        protected MapFieldReflectionAccessor internalGetMapFieldReflection(int r10) {
            return internalGetMapField(r10);
        }

        @Deprecated
        protected MapField internalGetMutableMapField(int r10) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }

        protected MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r10) {
            return internalGetMutableMapField(r10);
        }

        protected boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r10 = getDescriptorForType().getFields().iterator();
        L4:
            if (r10.hasNext() == false) goto L25;
            Descriptors.FieldDescriptor r11 = r10.next();
            if (r11.isRequired() == false) goto L11;
            if (hasField(r11) == true) goto L11;
            return false;
        L11:
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            if (r11.isRepeated() == true) goto L14;
            if (hasField(r11) == false) goto L4;
            if (((Message) getField(r11)).isInitialized() == true) goto L4;
            return false;
        L14:
            Iterator r12 = ((List) getField(r11)).iterator();
        L16:
            if (r12.hasNext() == false) goto L4;
            if (((Message) r12.next()).isInitialized() == true) goto L16;
            return false;
        L25:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT mergeUnknownFields(UnknownFieldSet r10) {
            if (UnknownFieldSet.getDefaultInstance().equals(r10) == false) goto L6;
            return this;
        L6:
            if (UnknownFieldSet.getDefaultInstance().equals(this.unknownFieldsOrBuilder) == false) goto L10;
            this.unknownFieldsOrBuilder = r10;
        L8:
            onChanged();
            return this;
        L10:
            getUnknownFieldSetBuilder().mergeFrom(r10);
            goto L8
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        protected final void mergeUnknownLengthDelimitedField(int r10, ByteString r11) {
            getUnknownFieldSetBuilder().mergeLengthDelimitedField(r10, r11);
        }

        protected final void mergeUnknownVarintField(int r10, int r11) {
            getUnknownFieldSetBuilder().mergeVarintField(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).newBuilder();
        }

        protected void onBuilt() {
            if (this.builderParent == null) goto L6;
            markClean();
            return;
        }

        protected final void onChanged() {
            if (this.isClean == false) goto L8;
            AbstractMessage.BuilderParent r10 = this.builderParent;
            if (r10 == null) goto L9;
            r10.markDirty();
            this.isClean = false;
            return;
        L9:
            return;
        }

        protected boolean parseUnknownField(CodedInputStream r10, ExtensionRegistryLite r11, int r12) {
            if (r10.shouldDiscardUnknownFields() == false) goto L7;
            return r10.skipField(r12);
        L7:
            return getUnknownFieldSetBuilder().mergeFieldFrom(r12, r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor r10, Object r11) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).set(this, r11);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).setRepeated(this, r11, r12);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        protected void setUnknownFieldSetBuilder(UnknownFieldSet.Builder r10) {
            this.unknownFieldsOrBuilder = r10;
            onChanged();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setUnknownFields(UnknownFieldSet r10) {
            return (BuilderT) setUnknownFieldsInternal(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        protected BuilderT setUnknownFieldsProto3(UnknownFieldSet r10) {
            return (BuilderT) setUnknownFieldsInternal(r10);
        }
    }

    private static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        private CachedDescriptorRetriever() {
        }

        /* synthetic */ CachedDescriptorRetriever(AnonymousClass1 r10) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor != null) goto L15;
            Descriptors.FieldDescriptor r10 = loadDescriptor();
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.descriptor != null) goto L9;
            this.descriptor = r10;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
        L15:
            return this.descriptor;
        }

        protected abstract Descriptors.FieldDescriptor loadDescriptor();
    }

    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        private FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(AbstractMessage.BuilderParent r10) {
            super(r10);
        }

        static /* synthetic */ FieldSet access$400(ExtendableBuilder r10) {
            return r10.buildExtensions();
        }

        private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 != null) goto L6;
            return FieldSet.emptySet();
        L6:
            return r10.buildPartial();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions != null) goto L6;
            this.extensions = FieldSet.newBuilder();
            return;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageT, ?> r10) {
            if (r10.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r10.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <T> BuilderT addExtension(ExtensionLite<? extends MessageT, List<T>> r10, T r11) {
            Extension<MessageT, ?> r12 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r12);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            this.extensions.addRepeatedField(r13, r12.singularToReflectionType(r11));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r10, r11);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.extensions = null;
            return (BuilderT) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public final <T> BuilderT clearExtension(ExtensionLite<? extends MessageT, T> r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r11.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r10);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.clearField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        protected boolean extensionsAreInitialized() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 != null) goto L5;
        L8:
            return true;
        L5:
            if (r10.isInitialized() == true) goto L8;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r10 = Builder.access$900(this);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 == null) goto L6;
            r10.putAll(r11.getAllFields());
        L6:
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r13 = this.extensions;
            if (r13 != null) goto L5;
            Object r14 = null;
        L6:
            if (r14 != null) goto L18;
            if (r12.isRepeated() == false) goto L12;
            return (T) Collections.emptyList();
        L12:
            if (r12.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L16;
            return (T) r11.getMessageDefaultInstance();
        L16:
            return (T) r11.fromReflectionType(r12.getDefaultValue());
        L18:
            return (T) r11.fromReflectionType(r14);
        L5:
            r14 = r13.getField(r12);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r10, int r11) {
            Extension<MessageT, ?> r12 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r12);
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r14 = this.extensions;
            if (r14 == null) goto L7;
            return (T) r12.singularFromReflectionType(r14.getRepeatedField(r13, r11));
        L7:
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r13 = this.extensions;
            if (r13 != null) goto L6;
            return 0;
        L6:
            return r13.getRepeatedFieldCount(r12);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L16;
            verifyContainingType(r10);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 != null) goto L7;
            Object r12 = null;
        L8:
            if (r12 == null) goto L10;
            return r12;
        L10:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L14:
            return r10.getDefaultValue();
        L7:
            r12 = r11.getField(r10);
            goto L8
        L16:
            return super.getField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L23;
            verifyContainingType(r10);
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L21;
            ensureExtensionsIsMutable();
            Object r11 = this.extensions.getFieldAllowBuilders(r10);
            if (r11 != null) goto L12;
            Message.Builder r12 = DynamicMessage.newBuilder(r10.getMessageType());
        L9:
            this.extensions.setField(r10, r12);
            onChanged();
            return r12;
        L12:
            if ((r11 instanceof Message.Builder) == false) goto L16;
            return (Message.Builder) r11;
        L16:
            if ((r11 instanceof Message) == false) goto L19;
            r12 = ((Message) r11).toBuilder();
            goto L9
        L19:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L21:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L23:
            return super.getFieldBuilder(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            if (r10.isExtension() == false) goto L11;
            verifyContainingType(r10);
            FieldSet.Builder<Descriptors.FieldDescriptor> r12 = this.extensions;
            if (r12 == null) goto L9;
            return r12.getRepeatedField(r10, r11);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            return super.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            if (r10.isExtension() == false) goto L19;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L17;
            Object r12 = this.extensions.getRepeatedFieldAllowBuilders(r10, r11);
            if ((r12 instanceof Message.Builder) == false) goto L11;
            return (Message.Builder) r12;
        L11:
            if ((r12 instanceof Message) == false) goto L15;
            Message.Builder r13 = ((Message) r12).toBuilder();
            this.extensions.setRepeatedField(r10, r11, r13);
            onChanged();
            return r13;
        L15:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L17:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L19:
            return super.getRepeatedFieldBuilder(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L10;
            verifyContainingType(r10);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 != null) goto L8;
            return 0;
        L8:
            return r11.getRepeatedFieldCount(r10);
        L10:
            return super.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            FieldSet.Builder<Descriptors.FieldDescriptor> r12 = this.extensions;
            if (r12 != null) goto L5;
        L7:
            return false;
        L5:
            if (r12.hasField(r11.getDescriptor()) == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L12;
            verifyContainingType(r10);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 != null) goto L7;
        L9:
            return false;
        L7:
            if (r11.hasField(r10) == false) goto L9;
            return true;
        L12:
            return super.hasField(r10);
        }

        void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> r10) {
            this.extensions = FieldSet.Builder.fromFieldSet(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        protected void mergeExtensionFields(ExtendableMessage<?> r10) {
            if (ExtendableMessage.access$600(r10) == null) goto L6;
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$600(r10));
            onChanged();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            return DynamicMessage.newBuilder(r10.getMessageType());
        L7:
            return super.newBuilderForField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected boolean parseUnknownField(CodedInputStream r10, ExtensionRegistryLite r11, int r12) {
            ensureExtensionsIsMutable();
            if (r10.shouldDiscardUnknownFields() == false) goto L5;
            UnknownFieldSet.Builder r13 = null;
        L7:
            return MessageReflection.mergeFieldFrom(r10, r13, r11, getDescriptorForType(), new MessageReflection.ExtensionBuilderAdapter(this.extensions), r12);
        L5:
            r13 = getUnknownFieldSetBuilder();
            goto L7
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, List<T>> r10, int r11, T r12) {
            Extension<MessageT, ?> r13 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r13);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r14 = r13.getDescriptor();
            this.extensions.setRepeatedField(r14, r11, r13.singularToReflectionType(r12));
            onChanged();
            return this;
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, T> r10, T r11) {
            Extension<MessageT, ?> r12 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r12);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            this.extensions.setField(r13, r12.toReflectionType(r11));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.setField(r10, r11);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r10, r11, r12);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageT> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected interface ExtensionSerializer {
            void writeUntil(int r10, CodedOutputStream r11);
        }

        protected class ExtensionWriter implements ExtensionSerializer {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            protected ExtensionWriter(ExtendableMessage r10, boolean r11) {
                this.this$0 = r10;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = ExtendableMessage.access$600(r10).iterator();
                this.iter = r12;
                if (r12.hasNext() == false) goto L5;
                this.next = r12.next();
            L5:
                this.messageSetWireFormat = r11;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int r10, CodedOutputStream r11) {
            L2:
                Map.Entry<Descriptors.FieldDescriptor, Object> r12 = this.next;
                if (r12 == null) goto L22;
                if (r12.getKey().getNumber() >= r10) goto L27;
                Descriptors.FieldDescriptor r13 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L16:
                FieldSet.writeField(r13, this.next.getValue(), r11);
            L18:
                if (this.iter.hasNext() == false) goto L20;
                Map.Entry<Descriptors.FieldDescriptor, Object> r14 = this.iter.next();
            L21:
                this.next = r14;
                goto L2
            L20:
                r14 = null;
                goto L21
            L9:
                if (r13.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
                if (r13.isRepeated() == true) goto L16;
                boolean r15 = this.next instanceof LazyField.LazyEntry;
                int r16 = r13.getNumber();
                if (r15 == false) goto L15;
                r11.writeRawMessageSetExtension(r16, ((LazyField.LazyEntry) this.next).getField().toByteString());
                goto L18
            L15:
                r11.writeMessageSetExtension(r16, (Message) this.next.getValue());
                goto L18
            L27:
                return;
            }
        }

        private static final class NoOpExtensionSerializer implements ExtensionSerializer {
            private static final NoOpExtensionSerializer INSTANCE = null;

            static {
                INSTANCE = new NoOpExtensionSerializer();
            }

            private NoOpExtensionSerializer() {
            }

            static /* synthetic */ NoOpExtensionSerializer access$700() {
                return INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int r10, CodedOutputStream r11) {
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageT, ?> r10) {
            super(r10);
            this.extensions = ExtendableBuilder.access$400(r10);
        }

        static /* synthetic */ FieldSet access$600(ExtendableMessage r10) {
            return r10.extensions;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<? extends MessageT, ?> r10) {
            if (r10.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r10.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r10 = GeneratedMessage.access$800(this, false);
            r10.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map r10 = GeneratedMessage.access$800(this, false);
            r10.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r10) {
            Extension<? extends MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            Object r13 = this.extensions.getField(r12);
            if (r13 == null) goto L5;
        L11:
            T r14 = (T) r11.fromReflectionType(r13);
        L13:
            if (this.extensions.lazyFieldCorrupted(r12) == false) goto L15;
            setMemoizedSerializedSize(-1);
        L15:
            return r14;
        L5:
            if (r12.isRepeated() == false) goto L8;
            r14 = (T) ProtobufArrayList.emptyList();
            goto L13
        L8:
            if (r12.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            r14 = (T) r11.getMessageDefaultInstance();
            goto L13
        L10:
            r13 = r12.getDefaultValue();
            goto L11
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r10, int r11) {
            Extension<? extends MessageT, ?> r12 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r12);
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            return (T) r12.singularFromReflectionType(this.extensions.getRepeatedField(r13, r11));
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r10) {
            Extension<? extends MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r12);
        }

        protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L17;
            verifyContainingType(r10);
            Object r11 = this.extensions.getField(r10);
            if (r11 == null) goto L7;
            return r11;
        L7:
            if (r10.isRepeated() == false) goto L11;
            return Collections.emptyList();
        L11:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L15:
            return r10.getDefaultValue();
        L17:
            return super.getField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedField(r10, r11);
        L7:
            return super.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10);
        L7:
            return super.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r10) {
            Extension<? extends MessageT, ?> r11 = GeneratedMessage.access$500(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.hasField(r11.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            if (r10.isExtension() == false) goto L7;
            verifyContainingType(r10);
            return this.extensions.hasField(r10);
        L7:
            return super.hasField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        protected ExtensionSerializer newExtensionSerializer() {
            if (this.extensions.isEmpty() == false) goto L7;
            return NoOpExtensionSerializer.access$700();
        L7:
            return new ExtensionWriter(this, false);
        }

        @Deprecated
        protected ExtendableMessage<MessageT>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false);
        }

        protected ExtensionSerializer newMessageSetExtensionSerializer() {
            if (this.extensions.isEmpty() == false) goto L7;
            return NoOpExtensionSerializer.access$700();
        L7:
            return new ExtensionWriter(this, true);
        }

        protected ExtendableMessage<MessageT>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        @Override // com.google.protobuf.MessageOrBuilder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        /* bridge */ /* synthetic */ default MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        <T> T getExtension(ExtensionLite<? extends MessageT, T> r10);

        <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r10, int r11);

        <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r10);

        <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r10);
    }

    interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        private interface FieldAccessor {
            void addRepeated(Builder<?> r10, Object r11);

            void clear(Builder<?> r10);

            Object get(Builder<?> r10);

            Object get(GeneratedMessage r10);

            Message.Builder getBuilder(Builder<?> r10);

            Object getRaw(GeneratedMessage r10);

            Object getRepeated(Builder<?> r10, int r11);

            Object getRepeated(GeneratedMessage r10, int r11);

            Message.Builder getRepeatedBuilder(Builder<?> r10, int r11);

            int getRepeatedCount(Builder<?> r10);

            int getRepeatedCount(GeneratedMessage r10);

            boolean has(Builder<?> r10);

            boolean has(GeneratedMessage r10);

            Message.Builder newBuilder();

            void set(Builder<?> r10, Object r11);

            void setRepeated(Builder<?> r10, int r11, Object r12);
        }

        private static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(Descriptors.FieldDescriptor r10, Class<? extends GeneratedMessage> r11) {
                this.field = r10;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.access$1200(GeneratedMessage.access$1100(r11, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private Message coerceType(Message r10) {
                if (r10 != null) goto L6;
                return null;
            L6:
                if (this.mapEntryMessageDefaultInstance.getClass().isInstance(r10) == false) goto L9;
                return r10;
            L9:
                return this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(r10).build();
            }

            private MapFieldReflectionAccessor getMapField(Builder<?> r10) {
                return r10.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMapField(GeneratedMessage r10) {
                return r10.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMutableMapField(Builder<?> r10) {
                return r10.internalGetMutableMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r10, Object r11) {
                getMutableMapField(r10).getMutableList().add(coerceType((Message) r11));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r10) {
                getMutableMapField(r10).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r10) {
                ArrayList r11 = new ArrayList();
                int r12 = 0;
            L4:
                if (r12 >= getRepeatedCount(r10)) goto L7;
                r11.add(getRepeated(r10, r12));
                r12 = r12 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r10) {
                ArrayList r11 = new ArrayList();
                int r12 = 0;
            L4:
                if (r12 >= getRepeatedCount(r10)) goto L7;
                r11.add(getRepeated(r10, r12));
                r12 = r12 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r10) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r10, int r11) {
                return getMapField(r10).getList().get(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r10, int r11) {
                return getMapField(r10).getList().get(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r10, int r11) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r10) {
                return getMapField(r10).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r10) {
                return getMapField(r10).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r10) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r10) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                clear(r10);
                Iterator r12 = ((List) r11).iterator();
            L4:
                if (r12.hasNext() == false) goto L6;
                addRepeated(r10, r12.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r10, int r11, Object r12) {
                getMutableMapField(r10).getMutableList().set(r11, coerceType((Message) r12));
            }
        }

        private interface OneofAccessor {
            void clear(Builder<?> r10);

            Descriptors.FieldDescriptor get(Builder<?> r10);

            Descriptors.FieldDescriptor get(GeneratedMessage r10);

            boolean has(Builder<?> r10);

            boolean has(GeneratedMessage r10);
        }

        private static class RealOneofAccessor implements OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            RealOneofAccessor(Descriptors.Descriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13) {
                this.descriptor = r10;
                this.caseMethod = GeneratedMessage.access$1100(r12, "get" + r11 + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.access$1100(r13, "get" + r11 + "Case", new Class[0]);
                StringBuilder r14 = new StringBuilder();
                r14.append("clear");
                r14.append(r11);
                this.clearMethod = GeneratedMessage.access$1100(r13, r14.toString(), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r10) {
                GeneratedMessage.access$1200(this.clearMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r10) {
                int r11 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r10, new Object[0])).getNumber();
                if (r11 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r10) {
                int r11 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r10, new Object[0])).getNumber();
                if (r11 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r10) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r10, new Object[0])).getNumber() == 0) goto L6;
                return true;
            L6:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r10) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r10, new Object[0])).getNumber() == 0) goto L6;
                return true;
            L6:
                return false;
            }
        }

        private static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private final Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13) {
                super(r11, r12, r13);
                this.enumDescriptor = r10.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r14 = !r10.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r14;
                if (r14 == false) goto L6;
                Class r15 = Integer.TYPE;
                this.getRepeatedValueMethod = GeneratedMessage.access$1100(r12, "get" + r11 + "Value", new Class[]{r15});
                this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(r13, "get" + r11 + "Value", new Class[]{r15});
                this.setRepeatedValueMethod = GeneratedMessage.access$1100(r13, "set" + r11 + "Value", new Class[]{r15, r15});
                this.addRepeatedValueMethod = GeneratedMessage.access$1100(r13, "add" + r11 + "Value", new Class[]{r15});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r10, Object r11) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.addRepeatedValueMethod, r10, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber())});
                return;
            L6:
                super.addRepeated(r10, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r11}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r10) {
                ArrayList r11 = new ArrayList();
                int r12 = getRepeatedCount(r10);
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L6;
                r11.add(getRepeated(r10, r13));
                r13 = r13 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r10) {
                ArrayList r11 = new ArrayList();
                int r12 = getRepeatedCount(r10);
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L6;
                r11.add(getRepeated(r10, r13));
                r13 = r13 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r10, int r11) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, r10, new Object[]{Integer.valueOf(r11)})).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r10, r11), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r10, int r11) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethod, r10, new Object[]{Integer.valueOf(r11)})).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r10, r11), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r10, int r11, Object r12) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setRepeatedValueMethod, r10, new Object[]{Integer.valueOf(r11), Integer.valueOf(((Descriptors.EnumValueDescriptor) r12).getNumber())});
                return;
            L6:
                super.setRepeated(r10, r11, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r12}));
            }
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final MethodInvoker invoker;
            protected final Class<?> type;

            interface MethodInvoker {
                void addRepeated(Builder<?> r10, Object r11);

                void clear(Builder<?> r10);

                Object get(Builder<?> r10);

                Object get(GeneratedMessage r10);

                Object getRepeated(Builder<?> r10, int r11);

                Object getRepeated(GeneratedMessage r10, int r11);

                int getRepeatedCount(Builder<?> r10);

                int getRepeatedCount(GeneratedMessage r10);

                void setRepeated(Builder<?> r10, int r11, Object r12);
            }

            private static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method addRepeatedMethod;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getCountMethod;
                private final java.lang.reflect.Method getCountMethodBuilder;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method getRepeatedMethod;
                private final java.lang.reflect.Method getRepeatedMethodBuilder;
                private final java.lang.reflect.Method setRepeatedMethod;

                ReflectionInvoker(String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
                    this.getMethod = GeneratedMessage.access$1100(r11, "get" + r10 + "List", new Class[0]);
                    this.getMethodBuilder = GeneratedMessage.access$1100(r12, "get" + r10 + "List", new Class[0]);
                    StringBuilder r13 = new StringBuilder();
                    r13.append("get");
                    r13.append(r10);
                    String r14 = r13.toString();
                    Class r15 = Integer.TYPE;
                    java.lang.reflect.Method r16 = GeneratedMessage.access$1100(r11, r14, new Class[]{r15});
                    this.getRepeatedMethod = r16;
                    this.getRepeatedMethodBuilder = GeneratedMessage.access$1100(r12, "get" + r10, new Class[]{r15});
                    Class<?> r17 = r16.getReturnType();
                    this.setRepeatedMethod = GeneratedMessage.access$1100(r12, "set" + r10, new Class[]{r15, r17});
                    this.addRepeatedMethod = GeneratedMessage.access$1100(r12, "add" + r10, new Class[]{r17});
                    this.getCountMethod = GeneratedMessage.access$1100(r11, "get" + r10 + "Count", new Class[0]);
                    this.getCountMethodBuilder = GeneratedMessage.access$1100(r12, "get" + r10 + "Count", new Class[0]);
                    StringBuilder r18 = new StringBuilder();
                    r18.append("clear");
                    r18.append(r10);
                    this.clearMethod = GeneratedMessage.access$1100(r12, r18.toString(), new Class[0]);
                }

                static /* synthetic */ java.lang.reflect.Method access$1400(ReflectionInvoker r10) {
                    return r10.getRepeatedMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(Builder<?> r10, Object r11) {
                    GeneratedMessage.access$1200(this.addRepeatedMethod, r10, new Object[]{r11});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(Builder<?> r10) {
                    GeneratedMessage.access$1200(this.clearMethod, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(Builder<?> r10) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r10) {
                    return GeneratedMessage.access$1200(this.getMethod, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(Builder<?> r10, int r11) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, r10, new Object[]{Integer.valueOf(r11)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(GeneratedMessage r10, int r11) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethod, r10, new Object[]{Integer.valueOf(r11)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(Builder<?> r10) {
                    return ((Integer) GeneratedMessage.access$1200(this.getCountMethodBuilder, r10, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(GeneratedMessage r10) {
                    return ((Integer) GeneratedMessage.access$1200(this.getCountMethod, r10, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(Builder<?> r10, int r11, Object r12) {
                    GeneratedMessage.access$1200(this.setRepeatedMethod, r10, new Object[]{Integer.valueOf(r11), r12});
                }
            }

            RepeatedFieldAccessor(String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
                ReflectionInvoker r13 = new ReflectionInvoker(r10, r11, r12);
                this.type = ReflectionInvoker.access$1400(r13).getReturnType();
                this.invoker = getMethodInvoker(r13);
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker r10) {
                return r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r10, Object r11) {
                this.invoker.addRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r10) {
                this.invoker.clear(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r10) {
                return this.invoker.get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r10) {
                return this.invoker.get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r10) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r10, int r11) {
                return this.invoker.getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r10, int r11) {
                return this.invoker.getRepeated(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r10) {
                return this.invoker.getRepeatedCount(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r10) {
                return this.invoker.getRepeatedCount(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r10) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r10) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                clear(r10);
                Iterator r12 = ((List) r11).iterator();
            L4:
                if (r12.hasNext() == false) goto L6;
                addRepeated(r10, r12.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r10, int r11, Object r12) {
                this.invoker.setRepeated(r10, r11, r12);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            RepeatedMessageFieldAccessor(String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
                super(r10, r11, r12);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r12, "get" + r10 + "Builder", new Class[]{Integer.TYPE});
            }

            private Object coerceType(Object r10) {
                if (this.type.isInstance(r10) == false) goto L6;
                return r10;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r10).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r10, Object r11) {
                super.addRepeated(r10, coerceType(r11));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r10, int r11) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r10, new Object[]{Integer.valueOf(r11)});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r10, int r11, Object r12) {
                super.setRepeated(r10, r11, coerceType(r12));
            }
        }

        private static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private final Descriptors.EnumDescriptor enumDescriptor;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.enumDescriptor = r10.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r15 = !r10.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r15;
                if (r15 == false) goto L6;
                this.getValueMethod = GeneratedMessage.access$1100(r12, "get" + r11 + "Value", new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.access$1100(r13, "get" + r11 + "Value", new Class[0]);
                this.setValueMethod = GeneratedMessage.access$1100(r13, "set" + r11 + "Value", new Class[]{Integer.TYPE});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessage.access$1200(this.getValueMethodBuilder, r10, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r10), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessage.access$1200(this.getValueMethod, r10, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r10), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setValueMethod, r10, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber())});
                return;
            L6:
                super.set(r10, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r11}));
            }
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final Class<?> type;

            private interface MethodInvoker {
                void clear(Builder<?> r10);

                Object get(Builder<?> r10);

                Object get(GeneratedMessage r10);

                int getOneofFieldNumber(Builder<?> r10);

                int getOneofFieldNumber(GeneratedMessage r10);

                boolean has(Builder<?> r10);

                boolean has(GeneratedMessage r10);

                void set(Builder<?> r10, Object r11);
            }

            private static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method caseMethod;
                private final java.lang.reflect.Method caseMethodBuilder;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method hasMethod;
                private final java.lang.reflect.Method hasMethodBuilder;
                private final java.lang.reflect.Method setMethod;

                ReflectionInvoker(String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12, String r13, boolean r14, boolean r15) {
                    java.lang.reflect.Method r16 = GeneratedMessage.access$1100(r11, "get" + r10, new Class[0]);
                    this.getMethod = r16;
                    this.getMethodBuilder = GeneratedMessage.access$1100(r12, "get" + r10, new Class[0]);
                    this.setMethod = GeneratedMessage.access$1100(r12, "set" + r10, new Class[]{r16.getReturnType()});
                    java.lang.reflect.Method r17 = null;
                    if (r15 == false) goto L5;
                    java.lang.reflect.Method r18 = GeneratedMessage.access$1100(r11, "has" + r10, new Class[0]);
                L6:
                    this.hasMethod = r18;
                    if (r15 == false) goto L9;
                    java.lang.reflect.Method r19 = GeneratedMessage.access$1100(r12, "has" + r10, new Class[0]);
                L10:
                    this.hasMethodBuilder = r19;
                    this.clearMethod = GeneratedMessage.access$1100(r12, "clear" + r10, new Class[0]);
                    if (r14 == false) goto L13;
                    java.lang.reflect.Method r20 = GeneratedMessage.access$1100(r11, "get" + r13 + "Case", new Class[0]);
                L14:
                    this.caseMethod = r20;
                    if (r14 == false) goto L17;
                    r17 = GeneratedMessage.access$1100(r12, "get" + r13 + "Case", new Class[0]);
                L17:
                    this.caseMethodBuilder = r17;
                    return;
                L13:
                    r20 = null;
                    goto L14
                L9:
                    r19 = null;
                    goto L10
                L5:
                    r18 = null;
                    goto L6
                }

                static /* synthetic */ java.lang.reflect.Method access$1300(ReflectionInvoker r10) {
                    return r10.getMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(Builder<?> r10) {
                    GeneratedMessage.access$1200(this.clearMethod, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(Builder<?> r10) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r10) {
                    return GeneratedMessage.access$1200(this.getMethod, r10, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(Builder<?> r10) {
                    return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r10, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(GeneratedMessage r10) {
                    return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r10, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(Builder<?> r10) {
                    return ((Boolean) GeneratedMessage.access$1200(this.hasMethodBuilder, r10, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(GeneratedMessage r10) {
                    return ((Boolean) GeneratedMessage.access$1200(this.hasMethod, r10, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(Builder<?> r10, Object r11) {
                    GeneratedMessage.access$1200(this.setMethod, r10, new Object[]{r11});
                }
            }

            SingularFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13, String r14) {
                if (r10.getRealContainingOneof() == null) goto L5;
                boolean r15 = true;
            L6:
                boolean r16 = r15;
                this.isOneofField = r16;
                boolean r17 = r10.hasPresence();
                this.hasHasMethod = r17;
                ReflectionInvoker r18 = new ReflectionInvoker(r11, r12, r13, r14, r16, r17);
                this.field = r10;
                this.type = ReflectionInvoker.access$1300(r18).getReturnType();
                this.invoker = getMethodInvoker(r18);
                return;
            L5:
                r15 = false;
                goto L6
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker r10) {
                return r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r10, Object r11) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r10) {
                this.invoker.clear(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r10) {
                return this.invoker.get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r10) {
                return this.invoker.get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r10) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r10) {
                return get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r10, int r11) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r10) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r10) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r10) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r10) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r10).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r10) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r10) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r10).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                this.invoker.set(r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r10, int r11, Object r12) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r13, "get" + r11 + "Builder", new Class[0]);
            }

            private Object coerceType(Object r10) {
                if (this.type.isInstance(r10) == false) goto L6;
                return r10;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r10).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r10) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                super.set(r10, coerceType(r11));
            }
        }

        private static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            SingularStringFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13, String r14) {
                super(r10, r11, r12, r13, r14);
                this.getBytesMethod = GeneratedMessage.access$1100(r12, "get" + r11 + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.access$1100(r13, "set" + r11 + "Bytes", new Class[]{ByteString.class});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r10) {
                return GeneratedMessage.access$1200(this.getBytesMethod, r10, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r10, Object r11) {
                if ((r11 instanceof ByteString) == false) goto L5;
                GeneratedMessage.access$1200(this.setBytesMethodBuilder, r10, new Object[]{r11});
                return;
            L5:
                super.set(r10, r11);
            }
        }

        private static class SyntheticOneofAccessor implements OneofAccessor {
            private final Descriptors.FieldDescriptor fieldDescriptor;

            SyntheticOneofAccessor(Descriptors.Descriptor r10, int r11) {
                this.fieldDescriptor = r10.getOneofs().get(r11).getFields().get(0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r10) {
                r10.clearField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r10) {
                if (r10.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r10) {
                if (r10.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r10) {
                return r10.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r10) {
                return r10.hasField(this.fieldDescriptor);
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor r10, String[] r11) {
            this.descriptor = r10;
            this.camelCaseNames = r11;
            this.fields = new FieldAccessor[r10.getFields().size()];
            this.oneofs = new OneofAccessor[r10.getOneofs().size()];
            this.initialized = false;
        }

        public FieldAccessorTable(Descriptors.Descriptor r10, String[] r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13) {
            this(r10, r11);
            ensureFieldAccessorsInitialized(r12, r13);
        }

        static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable r10) {
            return r10.descriptor;
        }

        static /* synthetic */ OneofAccessor access$100(FieldAccessorTable r10, Descriptors.OneofDescriptor r11) {
            return r10.getOneof(r11);
        }

        static /* synthetic */ FieldAccessor access$200(FieldAccessorTable r10, Descriptors.FieldDescriptor r11) {
            return r10.getField(r11);
        }

        private FieldAccessor getField(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != this.descriptor) goto L11;
            if (r10.isExtension() == true) goto L9;
            return this.fields[r10.getIndex()];
        L9:
            throw new IllegalArgumentException("This type does not have extensions.");
        L11:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private OneofAccessor getOneof(Descriptors.OneofDescriptor r10) {
            if (r10.getContainingType() != this.descriptor) goto L7;
            return this.oneofs[r10.getIndex()];
        L7:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        @CanIgnoreReturnValue
        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13) {
            if (this.initialized == false) goto L5;
            return this;
        L5:
            monitor-enter(this);
        L51:
            th = move-exception;
            throw th;
        L7:
            if (this.initialized == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L51
            return this;
        L10:
            int r10 = this.fields.length;     // Catch: Throwable -> L51
            int r11 = 0;
            int r14 = 0;
        L11:
            String r15 = null;
            if (r14 >= r10) goto L42;
            Descriptors.FieldDescriptor r16 = this.descriptor.getFields().get(r14);     // Catch: Throwable -> L51
            if (r16.getContainingOneof() == null) goto L18;
            int r17 = r16.getContainingOneof().getIndex() + r10;     // Catch: Throwable -> L51
            String[] r18 = this.camelCaseNames;     // Catch: Throwable -> L51
            if (r17 >= r18.length) goto L18;
            r15 = r18[r17];     // Catch: Throwable -> L51
        L18:
            String r19 = r15;
            if (r16.isRepeated() == false) goto L31;
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L27;
            if (r16.isMapField() == false) goto L25;
            this.fields[r14] = new MapFieldAccessor(r16, r12);     // Catch: Throwable -> L51
        L40:
            r14 = r14 + 1;     // Catch: Throwable -> L51
            goto L11
        L25:
            this.fields[r14] = new RepeatedMessageFieldAccessor(this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L27:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L29;
            this.fields[r14] = new RepeatedEnumFieldAccessor(r16, this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L29:
            this.fields[r14] = new RepeatedFieldAccessor(this.camelCaseNames[r14], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L31:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            this.fields[r14] = new SingularMessageFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r19);     // Catch: Throwable -> L51
            goto L40
        L34:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L37;
            this.fields[r14] = new SingularEnumFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r19);     // Catch: Throwable -> L51
            goto L40
        L37:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L39;
            this.fields[r14] = new SingularStringFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r19);     // Catch: Throwable -> L51
            goto L40
        L39:
            this.fields[r14] = new SingularFieldAccessor(r16, this.camelCaseNames[r14], r12, r13, r19);     // Catch: Throwable -> L51
        L42:
            if (r11 >= this.descriptor.getOneofs().size()) goto L48;
            if (r11 >= this.descriptor.getRealOneofs().size()) goto L46;
            this.oneofs[r11] = new RealOneofAccessor(this.descriptor, this.camelCaseNames[r11 + r10], r12, r13);     // Catch: Throwable -> L51
        L47:
            r11 = r11 + 1;     // Catch: Throwable -> L51
            goto L42
        L46:
            this.oneofs[r11] = new SyntheticOneofAccessor(this.descriptor, r11);     // Catch: Throwable -> L51
            goto L47
        L48:
            this.initialized = true;     // Catch: Throwable -> L51
            this.camelCaseNames = null;     // Catch: Throwable -> L51
            monitor-exit(this);     // Catch: Throwable -> L51
            return this;
        }
    }

    public static class GeneratedExtension<ContainingT extends Message, T> extends Extension<ContainingT, T> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class<?> singularType;

        GeneratedExtension(ExtensionDescriptorRetriever r10, Class<?> r11, Message r12, Extension.ExtensionType r13) {
            if (Message.class.isAssignableFrom(r11) == true) goto L5;
        L9:
            this.descriptorRetriever = r10;
            this.singularType = r11;
            this.messageDefaultInstance = r12;
            if (ProtocolMessageEnum.class.isAssignableFrom(r11) == false) goto L12;
            this.enumValueOf = GeneratedMessage.access$1100(r11, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
            java.lang.reflect.Method r14 = GeneratedMessage.access$1100(r11, "getValueDescriptor", new Class[0]);
        L13:
            this.enumGetValueDescriptor = r14;
            this.extensionType = r13;
            return;
        L12:
            r14 = null;
            this.enumValueOf = null;
            goto L13
        L5:
            if (r11.isInstance(r12) == true) goto L9;
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + r11.getName());
        }

        @Override // com.google.protobuf.Extension
        protected Object fromReflectionType(Object r10) {
            Descriptors.FieldDescriptor r11 = getDescriptor();
            if (r11.isRepeated() == false) goto L17;
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        L10:
            ProtobufArrayList r12 = new ProtobufArrayList();
            List r13 = (List) r10;
            r12.ensureCapacity(r13.size());
            Iterator r14 = r13.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            r12.add(singularFromReflectionType(r14.next()));
            goto L12
        L14:
            r12.makeImmutable();
            return r12;
        L7:
            if (r11.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L10;
            return r10;
        L17:
            return singularFromReflectionType(r10);
        }

        @Override // com.google.protobuf.ExtensionLite
        public T getDefaultValue() {
            if (isRepeated() == false) goto L7;
            return (T) Collections.emptyList();
        L7:
            if (getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return (T) this.messageDefaultInstance;
        L11:
            return (T) singularFromReflectionType(getDescriptor().getDefaultValue());
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor getDescriptor() {
            ExtensionDescriptorRetriever r10 = this.descriptorRetriever;
            if (r10 == null) goto L7;
            return r10.getDescriptor();
        L7:
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.Extension
        protected Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
            return getMessageDefaultInstance();
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        public void internalInit(final Descriptors.FieldDescriptor r10) {
            if (this.descriptorRetriever != null) goto L7;
            this.descriptorRetriever = new AnonymousClass1(this, r10);
            return;
        L7:
            throw new IllegalStateException("Already initialized.");
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.Extension
        protected Object singularFromReflectionType(Object r10) {
            int r11 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (r11 == 1) goto L10;
            if (r11 == 2) goto L8;
            return r10;
        L8:
            return GeneratedMessage.access$1200(this.enumValueOf, null, new Object[]{r10});
        L10:
            if (this.singularType.isInstance(r10) == false) goto L13;
            return r10;
        L13:
            return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) r10).build();
        }

        @Override // com.google.protobuf.Extension
        protected Object singularToReflectionType(Object r10) {
            Descriptors.FieldDescriptor r11 = getDescriptor();
            if (AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[r11.getJavaType().ordinal()] == 2) goto L6;
            return r10;
        L6:
            return GeneratedMessage.access$1200(this.enumGetValueDescriptor, r10, new Object[0]);
        }

        @Override // com.google.protobuf.Extension
        protected Object toReflectionType(Object r10) {
            Descriptors.FieldDescriptor r11 = getDescriptor();
            if (r11.isRepeated() == false) goto L13;
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L11;
            ArrayList r12 = new ArrayList();
            Iterator r13 = ((List) r10).iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r12.add(singularToReflectionType(r13.next()));
            goto L8
        L10:
            return r12;
        L11:
            return r10;
        L13:
            return singularToReflectionType(r10);
        }
    }

    protected static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = null;

        static {
            INSTANCE = new UnusedPrivateParameter();
        }

        private UnusedPrivateParameter() {
        }
    }

    static {
    }

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder<?> r10) {
        this.unknownFields = r10.getUnknownFields();
    }

    static /* synthetic */ java.lang.reflect.Method access$1100(Class r10, String r11, Class[] r12) {
        return getMethodOrDie(r10, r11, r12);
    }

    static /* synthetic */ Object access$1200(java.lang.reflect.Method r10, Object r11, Object[] r12) {
        return invokeOrDie(r10, r11, r12);
    }

    static /* synthetic */ Extension access$500(ExtensionLite r10) {
        return checkNotLite(r10);
    }

    static /* synthetic */ Map access$800(GeneratedMessage r10, boolean r11) {
        return r10.getAllFieldsMutable(r11);
    }

    protected static boolean canUseUnsafe() {
        if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
    L7:
        return false;
    L5:
        if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
        return true;
    }

    private static <MessageT extends ExtendableMessage<MessageT>, T> Extension<MessageT, T> checkNotLite(ExtensionLite<? extends MessageT, T> r10) {
        if (r10.isLite() == true) goto L7;
        return (Extension) r10;
    L7:
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    protected static int computeStringSize(int r10, Object r11) {
        if ((r11 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSize(r10, (String) r11);
    L7:
        return CodedOutputStream.computeBytesSize(r10, (ByteString) r11);
    }

    protected static int computeStringSizeNoTag(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSizeNoTag((String) r10);
    L7:
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r10);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static <T> Internal.ProtobufList<T> emptyList(Class<T> r10) {
        return ProtobufArrayList.emptyList();
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean r10) {
        TreeMap r11 = new TreeMap();
        List<Descriptors.FieldDescriptor> r12 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L25;
        Descriptors.FieldDescriptor r14 = r12.get(r13);
        Descriptors.OneofDescriptor r15 = r14.getContainingOneof();
        if (r15 == null) goto L12;
        r13 = r13 + (r15.getFieldCount() - 1);
        if (hasOneof(r15) == false) goto L24;
        r14 = getOneofFieldDescriptor(r15);
    L19:
        if (r10 == true) goto L21;
    L23:
        Object r16 = getField(r14);
    L15:
        r11.put(r14, r16);
        goto L24
    L21:
        if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L23;
        r16 = getFieldRaw(r14);
    L24:
        r13 = r13 + 1;
        goto L4
    L12:
        if (r14.isRepeated() == false) goto L17;
        List r17 = (List) getField(r14);
        boolean r18 = r17.isEmpty();
        r16 = r17;
        if (r18 == true) goto L24;
    L17:
        if (hasField(r14) == true) goto L19;
    L25:
        return r11;
    }

    private static java.lang.reflect.Method getMethodOrDie(Class<?> r10, String r11, Class<?>... r12) {
        return r10.getMethod(r11, r12);
    L4:
        e = move-exception;
        throw new IllegalStateException("Generated message class \"" + r10.getName() + "\" missing method \"" + r11 + "\".", e);
    }

    @CanIgnoreReturnValue
    private static Object invokeOrDie(java.lang.reflect.Method r10, Object r11, Object... r12) {
        return r10.invoke(r11, r12);
    L15:
        e = move-exception;
        throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r13 = e.getCause();
        if ((r13 instanceof RuntimeException) == true) goto L14;
        if ((r13 instanceof Error) == false) goto L12;
        throw ((Error) r13);
    L12:
        throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", r13);
    L14:
        throw ((RuntimeException) r13);
    }

    protected static boolean isStringEmpty(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return ((String) r10).isEmpty();
    L7:
        return ((ByteString) r10).isEmpty();
    }

    protected static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r10) {
        return (ListT) makeMutableCopy(r10, 0);
    }

    protected static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r10, int r11) {
        int r12 = r10.size();
        if (r11 > r12) goto L5;
        r11 = r12 * 2;
    L5:
        if (r11 > 0) goto L8;
        r11 = 10;
    L8:
        return (ListT) r10.mutableCopyWithCapacity(r11);
    }

    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream r10, Map<Boolean, V> r11, MapEntry<Boolean, V> r12, int r13, boolean r14) {
        if (r11.containsKey(Boolean.valueOf(r14)) == false) goto L6;
        r10.writeMessage(r13, r12.newBuilderForType().setKey(Boolean.valueOf(r14)).setValue(r11.get(Boolean.valueOf(r14))).build());
        return;
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newFileScopedGeneratedExtension(Class<?> r10, Message r11) {
        return new GeneratedExtension(null, r10, r11, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newMessageScopedGeneratedExtension(final Message r10, final int r11, Class<?> r12, Message r13) {
        return new GeneratedExtension(new AnonymousClass1(r10, r11), r12, r13, Extension.ExtensionType.IMMUTABLE);
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> r10, InputStream r11) {
        return r10.parseDelimitedFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> r10, InputStream r11, ExtensionRegistryLite r12) {
        return r10.parseDelimitedFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> r10, CodedInputStream r11) {
        return r10.parseFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        return r10.parseFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> r10, InputStream r11) {
        return r10.parseFrom(r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> r10, InputStream r11, ExtensionRegistryLite r12) {
        return r10.parseFrom(r11, r12);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    protected static <V> void serializeBooleanMapTo(CodedOutputStream r10, MapField<Boolean, V> r11, MapEntry<Boolean, V> r12, int r13) {
        Map<Boolean, V> r14 = r11.getMap();
        if (r10.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r10, r14, r12, r13);
        return;
    L6:
        maybeSerializeBooleanEntryTo(r10, r14, r12, r13, false);
        maybeSerializeBooleanEntryTo(r10, r14, r12, r13, true);
    }

    protected static <V> void serializeIntegerMapTo(CodedOutputStream r10, MapField<Integer, V> r11, MapEntry<Integer, V> r12, int r13) {
        Map<Integer, V> r14 = r11.getMap();
        if (r10.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r10, r14, r12, r13);
        return;
    L6:
        int r15 = r14.size();
        int[] r16 = new int[r15];
        Iterator<Integer> r17 = r14.keySet().iterator();
        int r18 = 0;
        int r19 = 0;
    L8:
        if (r17.hasNext() == false) goto L10;
        r16[r19] = r17.next().intValue();
        r19 = r19 + 1;
        goto L8
    L10:
        Arrays.sort(r16);
    L11:
        if (r18 >= r15) goto L13;
        int r20 = r16[r18];
        r10.writeMessage(r13, r12.newBuilderForType().setKey(Integer.valueOf(r20)).setValue(r14.get(Integer.valueOf(r20))).build());
        r18 = r18 + 1;
        goto L11
    }

    protected static <V> void serializeLongMapTo(CodedOutputStream r10, MapField<Long, V> r11, MapEntry<Long, V> r12, int r13) {
        Map<Long, V> r14 = r11.getMap();
        if (r10.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r10, r14, r12, r13);
        return;
    L6:
        int r15 = r14.size();
        long[] r16 = new long[r15];
        Iterator<Long> r17 = r14.keySet().iterator();
        int r18 = 0;
        int r19 = 0;
    L8:
        if (r17.hasNext() == false) goto L10;
        r16[r19] = r17.next().longValue();
        r19 = r19 + 1;
        goto L8
    L10:
        Arrays.sort(r16);
    L11:
        if (r18 >= r15) goto L13;
        long r20 = r16[r18];
        r10.writeMessage(r13, r12.newBuilderForType().setKey(Long.valueOf(r20)).setValue(r14.get(Long.valueOf(r20))).build());
        r18 = r18 + 1;
        goto L11
    }

    private static <K, V> void serializeMapTo(CodedOutputStream r10, Map<K, V> r11, MapEntry<K, V> r12, int r13) {
        Iterator<Map.Entry<K, V>> r14 = r11.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry<K, V> r15 = r14.next();
        r10.writeMessage(r13, r12.newBuilderForType().setKey(r15.getKey()).setValue(r15.getValue()).build());
        goto L4
    }

    protected static <V> void serializeStringMapTo(CodedOutputStream r10, MapField<String, V> r11, MapEntry<String, V> r12, int r13) {
        Map<String, V> r14 = r11.getMap();
        if (r10.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r10, r14, r12, r13);
        return;
    L6:
        String[] r15 = new String[r14.size()];
        String[] r16 = (String[]) r14.keySet().toArray(r15);
        Arrays.sort(r16);
        int r17 = r16.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L9;
        String r19 = r16[r18];
        r10.writeMessage(r13, r12.newBuilderForType().setKey(r19).setValue(r14.get(r19)).build());
        r18 = r18 + 1;
        goto L7
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean r10) {
        alwaysUseFieldBuilders = r10;
    }

    protected static void writeString(CodedOutputStream r10, int r11, Object r12) {
        if ((r12 instanceof String) == false) goto L5;
        r10.writeString(r11, (String) r12);
        return;
    L5:
        r10.writeBytes(r11, (ByteString) r12);
    }

    protected static void writeStringNoTag(CodedOutputStream r10, Object r11) {
        if ((r11 instanceof String) == false) goto L5;
        r10.writeStringNoTag((String) r11);
        return;
    L5:
        r10.writeBytesNoTag((ByteString) r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).get(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).get(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeated(this, r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r10).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r10) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r10).has(this);
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    @Deprecated
    protected MapField internalGetMapField(int r10) {
        throw new IllegalArgumentException("No map fields found in " + getClass().getName());
    }

    protected MapFieldReflectionAccessor internalGetMapFieldReflection(int r10) {
        return internalGetMapField(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        Iterator<Descriptors.FieldDescriptor> r10 = getDescriptorForType().getFields().iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        Descriptors.FieldDescriptor r11 = r10.next();
        if (r11.isRequired() == false) goto L11;
        if (hasField(r11) == true) goto L11;
        return false;
    L11:
        if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
        if (r11.isRepeated() == true) goto L14;
        if (hasField(r11) == false) goto L4;
        if (((Message) getField(r11)).isInitialized() == true) goto L4;
        return false;
    L14:
        Iterator r12 = ((List) getField(r11)).iterator();
    L16:
        if (r12.hasNext() == false) goto L4;
        if (((Message) r12.next()).isInitialized() == true) goto L16;
        return false;
    L25:
        return true;
    }

    @Deprecated
    protected void mergeFromAndMakeImmutableInternal(CodedInputStream r10, ExtensionRegistryLite r11) {
        Schema r12 = Protobuf.getInstance().schemaFor(this);
        r12.mergeFrom(this, CodedInputStreamReader.forCodedInput(r10), r11);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        r12.makeImmutable(this);
        return;
    L9:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L6:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    protected Object newInstance(UnusedPrivateParameter r10) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    protected boolean parseUnknownField(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) {
        if (r10.shouldDiscardUnknownFields() == false) goto L7;
        return r10.skipField(r13);
    L7:
        return r11.mergeFieldFrom(r13, r10);
    }

    protected boolean parseUnknownFieldProto3(CodedInputStream r10, UnknownFieldSet.Builder r11, ExtensionRegistryLite r12, int r13) {
        return parseUnknownField(r10, r11, r12, r13);
    }

    void setUnknownFields(UnknownFieldSet r10) {
        this.unknownFields = r10;
    }

    protected Object writeReplace() {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), r10, false);
    }
}
