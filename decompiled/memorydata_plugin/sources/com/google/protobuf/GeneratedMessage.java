package com.google.protobuf;

import com.tom_roush.pdfbox.pdmodel.a.d.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;

        static {
            int[] r0 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r0;
            r0[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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

            private BuilderParentImpl(Builder r1) {
                this.this$0 = r1;
            }

            /* synthetic */ BuilderParentImpl(Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }
        }

        public Builder() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
        }

        public Builder(AbstractMessage.BuilderParent r3) {
            AbstractMessage.BuilderParent r4 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin");
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            this.builderParent = r4;
        }

        static /* synthetic */ Map access$900(Builder r0) {
            return r0.getAllFieldsMutable();
        }

        private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap r0 = new TreeMap();
            List<Descriptors.FieldDescriptor> r1 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
            int r2 = 0;
        L4:
            if (r2 >= r1.size()) goto L22;
            Descriptors.FieldDescriptor r3 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.get(r2), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
            Descriptors.OneofDescriptor r4 = r3.getContainingOneof();
            if (r4 == null) goto L12;
            r2 = r2 + (r4.getFieldCount() - 1);
            if (hasOneof(r4) == false) goto L21;
            r3 = getOneofFieldDescriptor(r4);
        L19:
            Object r5 = getField(r3);
        L20:
            r0.put(r3, r5);
        L21:
            r2 = r2 + 1;
            goto L4
        L12:
            if (r3.isRepeated() == false) goto L17;
            List r6 = (List) ZeusTransformUtils.preCheckCast(getField(r3), List.class, "com.obric.memorydata.plugin");
            boolean r7 = r6.isEmpty();
            r5 = r6;
            if (r7 == true) goto L21;
        L17:
            if (hasField(r3) == true) goto L19;
        L22:
            return r0;
        }

        private BuilderT setUnknownFieldsInternal(UnknownFieldSet r1) {
            this.unknownFieldsOrBuilder = r1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r2, Object r3) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).addRepeated(this, r3);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
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
        public BuilderT clearField(Descriptors.FieldDescriptor r2) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).clear(this);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearOneof(Descriptors.OneofDescriptor r2) {
            FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r2).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
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
            return (BuilderT) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(getDefaultInstanceForType().newBuilderForType(), Builder.class, "com.obric.memorydata.plugin")).mergeFrom(buildPartial()), Builder.class, "com.obric.memorydata.plugin");
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
        public /* bridge */ /* synthetic */ Object mo141clone() {
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
        public Object getField(Descriptors.FieldDescriptor r2) {
            Object r1 = FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).get(this);
            if (r2.isRepeated() == true) goto L5;
            return r1;
        L5:
            return Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r2) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r2) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r2).get(this);
        }

        public AbstractMessage.BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r2, int r3) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRepeated(this, r3);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r2, int r3) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRepeatedBuilder(this, r3);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r2) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            if (ZeusTransformUtils.instanceOf(this.unknownFieldsOrBuilder, UnknownFieldSet.class) == false) goto L5;
            this.unknownFieldsOrBuilder = ((UnknownFieldSet) ZeusTransformUtils.preCheckCast(this.unknownFieldsOrBuilder, UnknownFieldSet.class, "com.obric.memorydata.plugin")).toBuilder();
        L5:
            onChanged();
            return (UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(this.unknownFieldsOrBuilder, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            boolean r0 = ZeusTransformUtils.instanceOf(this.unknownFieldsOrBuilder, UnknownFieldSet.class);
            Object r2 = this.unknownFieldsOrBuilder;
            if (r0 == false) goto L7;
            return (UnknownFieldSet) ZeusTransformUtils.preCheckCast(r2, UnknownFieldSet.class, "com.obric.memorydata.plugin");
        L7:
            return ((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r2, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin")).buildPartial();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r2) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r2) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r2).has(this);
        }

        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        @Deprecated
        public MapField internalGetMapField(int r3) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }

        public MapFieldReflectionAccessor internalGetMapFieldReflection(int r1) {
            return internalGetMapField(r1);
        }

        @Deprecated
        public MapField internalGetMutableMapField(int r3) {
            throw new IllegalArgumentException("No map fields found in " + getClass().getName());
        }

        public MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r1) {
            return internalGetMutableMapField(r1);
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r0 = getDescriptorForType().getFields().iterator();
        L4:
            if (r0.hasNext() == false) goto L25;
            Descriptors.FieldDescriptor r1 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
            if (r1.isRequired() == false) goto L11;
            if (hasField(r1) == true) goto L11;
            return false;
        L11:
            if (r1.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            if (r1.isRepeated() == true) goto L14;
            if (hasField(r1) == false) goto L4;
            if (((Message) ZeusTransformUtils.preCheckCast(getField(r1), Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L4;
            return false;
        L14:
            Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(getField(r1), List.class, "com.obric.memorydata.plugin")).iterator();
        L16:
            if (r2.hasNext() == false) goto L4;
            if (((Message) ZeusTransformUtils.preCheckCast(r2.next(), Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L16;
            return false;
        L25:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT mergeUnknownFields(UnknownFieldSet r3) {
            if (UnknownFieldSet.getDefaultInstance().equals(r3) == false) goto L6;
            return this;
        L6:
            if (UnknownFieldSet.getDefaultInstance().equals(this.unknownFieldsOrBuilder) == false) goto L10;
            this.unknownFieldsOrBuilder = r3;
        L8:
            onChanged();
            return this;
        L10:
            getUnknownFieldSetBuilder().mergeFrom(r3);
            goto L8
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        public final void mergeUnknownLengthDelimitedField(int r1, ByteString r2) {
            getUnknownFieldSetBuilder().mergeLengthDelimitedField(r1, r2);
        }

        public final void mergeUnknownVarintField(int r1, int r2) {
            getUnknownFieldSetBuilder().mergeVarintField(r1, r2);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r1) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r1).newBuilder();
        }

        public void onBuilt() {
            if (this.builderParent == null) goto L6;
            markClean();
            return;
        }

        public final void onChanged() {
            if (this.isClean == false) goto L8;
            AbstractMessage.BuilderParent r0 = this.builderParent;
            if (r0 == null) goto L9;
            r0.markDirty();
            this.isClean = false;
            return;
        L9:
            return;
        }

        public boolean parseUnknownField(CodedInputStream r1, ExtensionRegistryLite r2, int r3) {
            if (r1.shouldDiscardUnknownFields() == false) goto L7;
            return r1.skipField(r3);
        L7:
            return getUnknownFieldSetBuilder().mergeFieldFrom(r3, r1);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor r2, Object r3) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).set(this, r3);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r2, int r3, Object r4) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).setRepeated(this, r3, r4);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void setUnknownFieldSetBuilder(UnknownFieldSet.Builder r1) {
            this.unknownFieldsOrBuilder = r1;
            onChanged();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderT setUnknownFields(UnknownFieldSet r1) {
            return (BuilderT) setUnknownFieldsInternal(r1);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        public BuilderT setUnknownFieldsProto3(UnknownFieldSet r1) {
            return (BuilderT) setUnknownFieldsInternal(r1);
        }
    }

    private static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        private CachedDescriptorRetriever() {
        }

        /* synthetic */ CachedDescriptorRetriever(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor != null) goto L15;
            Descriptors.FieldDescriptor r0 = loadDescriptor();
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.descriptor != null) goto L9;
            this.descriptor = r0;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
        L15:
            return this.descriptor;
        }

        public abstract Descriptors.FieldDescriptor loadDescriptor();
    }

    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        private FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        public ExtendableBuilder() {
        }

        public ExtendableBuilder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ FieldSet access$400(ExtendableBuilder r0) {
            return r0.buildExtensions();
        }

        private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r0 = this.extensions;
            if (r0 != null) goto L6;
            return FieldSet.emptySet();
        L6:
            return r0.buildPartial();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions != null) goto L6;
            this.extensions = FieldSet.newBuilder();
            return;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r1) {
            if (r1.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageT, ?> r4) {
            if (r4.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r4.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <T> BuilderT addExtension(ExtensionLite<? extends MessageT, List<T>> r3, T r4) {
            Extension<MessageT, ?> r5 = GeneratedMessage.access$500(r3);
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r0 = r5.getDescriptor();
            this.extensions.addRepeatedField(r0, r5.singularToReflectionType(r4));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r2, Object r3) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r2, r3);
            onChanged();
            return this;
        L7:
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.addRepeatedField(r2, r3), ExtendableBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
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
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clear(), ExtendableBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public final <T> BuilderT clearExtension(ExtensionLite<? extends MessageT, T> r2) {
            Extension<MessageT, ?> r3 = GeneratedMessage.access$500(r2);
            verifyExtensionContainingType(r3);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r3.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r2);
            onChanged();
            return this;
        L7:
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.clearField(r2), ExtendableBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        public boolean extensionsAreInitialized() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r0 = this.extensions;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.isInitialized() == true) goto L8;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r0 = Builder.access$900(this);
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 == null) goto L6;
            r0.putAll(r1.getAllFields());
        L6:
            return Collections.unmodifiableMap(r0);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r3) {
            Extension<MessageT, ?> r4 = GeneratedMessage.access$500(r3);
            verifyExtensionContainingType(r4);
            Descriptors.FieldDescriptor r0 = r4.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r2 = this.extensions;
            if (r2 != null) goto L5;
            Object r5 = null;
        L6:
            if (r5 != null) goto L18;
            if (r0.isRepeated() == false) goto L12;
            return (T) Collections.emptyList();
        L12:
            if (r0.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L16;
            return (T) r4.getMessageDefaultInstance();
        L16:
            return (T) r4.fromReflectionType(r0.getDefaultValue());
        L18:
            return (T) r4.fromReflectionType(r5);
        L5:
            r5 = r2.getField(r0);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r2, int r3) {
            Extension<MessageT, ?> r4 = GeneratedMessage.access$500(r2);
            verifyExtensionContainingType(r4);
            Descriptors.FieldDescriptor r0 = r4.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 == null) goto L7;
            return (T) r4.singularFromReflectionType(r1.getRepeatedField(r0, r3));
        L7:
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r1) {
            Extension<MessageT, ?> r2 = GeneratedMessage.access$500(r1);
            verifyExtensionContainingType(r2);
            Descriptors.FieldDescriptor r3 = r2.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r0 = this.extensions;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getRepeatedFieldCount(r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L16;
            verifyContainingType(r2);
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 != null) goto L7;
            Object r3 = null;
        L8:
            if (r3 == null) goto L10;
            return r3;
        L10:
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            return DynamicMessage.getDefaultInstance(r2.getMessageType());
        L14:
            return r2.getDefaultValue();
        L7:
            r3 = r1.getField(r2);
            goto L8
        L16:
            return super.getField(r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r4) {
            if (r4.isExtension() == false) goto L23;
            verifyContainingType(r4);
            if (r4.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L21;
            ensureExtensionsIsMutable();
            Object r0 = this.extensions.getFieldAllowBuilders(r4);
            if (r0 != null) goto L12;
            Message.Builder r1 = DynamicMessage.newBuilder(r4.getMessageType());
        L9:
            this.extensions.setField(r4, r1);
            onChanged();
            return r1;
        L12:
            if (ZeusTransformUtils.instanceOf(r0, Message.Builder.class) == false) goto L16;
            return (Message.Builder) ZeusTransformUtils.preCheckCast(r0, Message.Builder.class, "com.obric.memorydata.plugin");
        L16:
            if (ZeusTransformUtils.instanceOf(r0, Message.class) == false) goto L19;
            r1 = ((Message) ZeusTransformUtils.preCheckCast(r0, Message.class, "com.obric.memorydata.plugin")).toBuilder();
            goto L9
        L19:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L21:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L23:
            return super.getFieldBuilder(r4);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r2, int r3) {
            if (r2.isExtension() == false) goto L11;
            verifyContainingType(r2);
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 == null) goto L9;
            return r1.getRepeatedField(r2, r3);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            return super.getRepeatedField(r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r5, int r6) {
            if (r5.isExtension() == false) goto L19;
            verifyContainingType(r5);
            ensureExtensionsIsMutable();
            if (r5.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L17;
            Object r0 = this.extensions.getRepeatedFieldAllowBuilders(r5, r6);
            if (ZeusTransformUtils.instanceOf(r0, Message.Builder.class) == false) goto L11;
            return (Message.Builder) ZeusTransformUtils.preCheckCast(r0, Message.Builder.class, "com.obric.memorydata.plugin");
        L11:
            if (ZeusTransformUtils.instanceOf(r0, Message.class) == false) goto L15;
            Message.Builder r1 = ((Message) ZeusTransformUtils.preCheckCast(r0, Message.class, "com.obric.memorydata.plugin")).toBuilder();
            this.extensions.setRepeatedField(r5, r6, r1);
            onChanged();
            return r1;
        L15:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L17:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L19:
            return super.getRepeatedFieldBuilder(r5, r6);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L10;
            verifyContainingType(r2);
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 != null) goto L8;
            return 0;
        L8:
            return r1.getRepeatedFieldCount(r2);
        L10:
            return super.getRepeatedFieldCount(r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r1) {
            Extension<MessageT, ?> r2 = GeneratedMessage.access$500(r1);
            verifyExtensionContainingType(r2);
            FieldSet.Builder<Descriptors.FieldDescriptor> r0 = this.extensions;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasField(r2.getDescriptor()) == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L12;
            verifyContainingType(r2);
            FieldSet.Builder<Descriptors.FieldDescriptor> r1 = this.extensions;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.hasField(r2) == false) goto L9;
            return true;
        L12:
            return super.hasField(r2);
        }

        void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> r1) {
            this.extensions = FieldSet.Builder.fromFieldSet(r1);
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

        public void mergeExtensionFields(ExtendableMessage<?> r2) {
            if (ExtendableMessage.access$600(r2) == null) goto L6;
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$600(r2));
            onChanged();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L7;
            return DynamicMessage.newBuilder(r2.getMessageType());
        L7:
            return super.newBuilderForField(r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public boolean parseUnknownField(CodedInputStream r8, ExtensionRegistryLite r9, int r10) {
            ensureExtensionsIsMutable();
            if (r8.shouldDiscardUnknownFields() == false) goto L5;
            UnknownFieldSet.Builder r0 = null;
        L7:
            return MessageReflection.mergeFieldFrom(r8, r0, r9, getDescriptorForType(), new MessageReflection.ExtensionBuilderAdapter(this.extensions), r10);
        L5:
            r0 = getUnknownFieldSetBuilder();
            goto L7
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, List<T>> r3, int r4, T r5) {
            Extension<MessageT, ?> r6 = GeneratedMessage.access$500(r3);
            verifyExtensionContainingType(r6);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r0 = r6.getDescriptor();
            this.extensions.setRepeatedField(r0, r4, r6.singularToReflectionType(r5));
            onChanged();
            return this;
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, T> r3, T r4) {
            Extension<MessageT, ?> r5 = GeneratedMessage.access$500(r3);
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r0 = r5.getDescriptor();
            this.extensions.setField(r0, r5.toReflectionType(r4));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor r2, Object r3) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            ensureExtensionsIsMutable();
            this.extensions.setField(r2, r3);
            onChanged();
            return this;
        L7:
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setField(r2, r3), ExtendableBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r2, int r3, Object r4) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r2, r3, r4);
            onChanged();
            return this;
        L7:
            return (BuilderT) ZeusTransformUtils.preCheckCast(super.setRepeatedField(r2, r3, r4), ExtendableBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageT> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected interface ExtensionSerializer {
            void writeUntil(int r1, CodedOutputStream r2);
        }

        protected class ExtensionWriter implements ExtensionSerializer {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public ExtensionWriter(ExtendableMessage r3, boolean r4) {
                this.this$0 = r3;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r5 = ExtendableMessage.access$600(r3).iterator();
                this.iter = r5;
                if (r5.hasNext() == false) goto L5;
                this.next = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            L5:
                this.messageSetWireFormat = r4;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int r5, CodedOutputStream r6) {
            L2:
                Map.Entry<Descriptors.FieldDescriptor, Object> r0 = this.next;
                if (r0 == null) goto L22;
                if (((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin")).getNumber() >= r5) goto L27;
                Descriptors.FieldDescriptor r1 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(this.next.getKey(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
                if (this.messageSetWireFormat == true) goto L9;
            L16:
                FieldSet.writeField(r1, this.next.getValue(), r6);
            L18:
                if (this.iter.hasNext() == false) goto L20;
                Map.Entry<Descriptors.FieldDescriptor, Object> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iter.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            L21:
                this.next = r2;
                goto L2
            L20:
                r2 = null;
                goto L21
            L9:
                if (r1.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
                if (r1.isRepeated() == true) goto L16;
                boolean r3 = ZeusTransformUtils.instanceOf(this.next, LazyField.LazyEntry.class);
                int r4 = r1.getNumber();
                if (r3 == false) goto L15;
                r6.writeRawMessageSetExtension(r4, ((LazyField.LazyEntry) ZeusTransformUtils.preCheckCast(this.next, LazyField.LazyEntry.class, "com.obric.memorydata.plugin")).getField().toByteString());
                goto L18
            L15:
                r6.writeMessageSetExtension(r4, (Message) ZeusTransformUtils.preCheckCast(this.next.getValue(), Message.class, "com.obric.memorydata.plugin"));
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
            public void writeUntil(int r1, CodedOutputStream r2) {
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public ExtendableMessage(ExtendableBuilder<MessageT, ?> r1) {
            super(r1);
            this.extensions = ExtendableBuilder.access$400(r1);
        }

        static /* synthetic */ FieldSet access$600(ExtendableMessage r0) {
            return r0.extensions;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r1) {
            if (r1.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<? extends MessageT, ?> r4) {
            if (r4.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r4.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r0 = GeneratedMessage.access$800(this, false);
            r0.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r0);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map r0 = GeneratedMessage.access$800(this, false);
            r0.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r0);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r4) {
            Extension<? extends MessageT, ?> r5 = GeneratedMessage.access$500(r4);
            verifyExtensionContainingType(r5);
            Descriptors.FieldDescriptor r0 = r5.getDescriptor();
            Object r1 = this.extensions.getField(r0);
            if (r1 == null) goto L5;
        L11:
            T r6 = (T) r5.fromReflectionType(r1);
        L13:
            if (this.extensions.lazyFieldCorrupted(r0) == false) goto L15;
            setMemoizedSerializedSize(-1);
        L15:
            return r6;
        L5:
            if (r0.isRepeated() == false) goto L8;
            r6 = (T) ProtobufArrayList.emptyList();
            goto L13
        L8:
            if (r0.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            r6 = (T) r5.getMessageDefaultInstance();
            goto L13
        L10:
            r1 = r0.getDefaultValue();
            goto L11
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r2, int r3) {
            Extension<? extends MessageT, ?> r4 = GeneratedMessage.access$500(r2);
            verifyExtensionContainingType(r4);
            Descriptors.FieldDescriptor r0 = r4.getDescriptor();
            return (T) r4.singularFromReflectionType(this.extensions.getRepeatedField(r0, r3));
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r1) {
            Extension<? extends MessageT, ?> r2 = GeneratedMessage.access$500(r1);
            verifyExtensionContainingType(r2);
            Descriptors.FieldDescriptor r3 = r2.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r3);
        }

        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L17;
            verifyContainingType(r2);
            Object r1 = this.extensions.getField(r2);
            if (r1 == null) goto L7;
            return r1;
        L7:
            if (r2.isRepeated() == false) goto L11;
            return Collections.emptyList();
        L11:
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            return DynamicMessage.getDefaultInstance(r2.getMessageType());
        L15:
            return r2.getDefaultValue();
        L17:
            return super.getField(r2);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r2, int r3) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            return this.extensions.getRepeatedField(r2, r3);
        L7:
            return super.getRepeatedField(r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            return this.extensions.getRepeatedFieldCount(r2);
        L7:
            return super.getRepeatedFieldCount(r2);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r1) {
            Extension<? extends MessageT, ?> r2 = GeneratedMessage.access$500(r1);
            verifyExtensionContainingType(r2);
            return this.extensions.hasField(r2.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r2) {
            if (r2.isExtension() == false) goto L7;
            verifyContainingType(r2);
            return this.extensions.hasField(r2);
        L7:
            return super.hasField(r2);
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

        public ExtensionSerializer newExtensionSerializer() {
            if (this.extensions.isEmpty() == false) goto L7;
            return NoOpExtensionSerializer.access$700();
        L7:
            return new ExtensionWriter(this, false);
        }

        @Deprecated
        public ExtendableMessage<MessageT>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false);
        }

        public ExtensionSerializer newMessageSetExtensionSerializer() {
            if (this.extensions.isEmpty() == false) goto L7;
            return NoOpExtensionSerializer.access$700();
        L7:
            return new ExtensionWriter(this, true);
        }

        public ExtendableMessage<MessageT>.ExtensionWriter newMessageSetExtensionWriter() {
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

        <T> T getExtension(ExtensionLite<? extends MessageT, T> r1);

        <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r1, int r2);

        <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r1);

        <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r1);
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
            void addRepeated(Builder<?> r1, Object r2);

            void clear(Builder<?> r1);

            Object get(Builder<?> r1);

            Object get(GeneratedMessage r1);

            Message.Builder getBuilder(Builder<?> r1);

            Object getRaw(GeneratedMessage r1);

            Object getRepeated(Builder<?> r1, int r2);

            Object getRepeated(GeneratedMessage r1, int r2);

            Message.Builder getRepeatedBuilder(Builder<?> r1, int r2);

            int getRepeatedCount(Builder<?> r1);

            int getRepeatedCount(GeneratedMessage r1);

            boolean has(Builder<?> r1);

            boolean has(GeneratedMessage r1);

            Message.Builder newBuilder();

            void set(Builder<?> r1, Object r2);

            void setRepeated(Builder<?> r1, int r2, Object r3);
        }

        private static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(Descriptors.FieldDescriptor r3, Class<? extends GeneratedMessage> r4) {
                this.field = r3;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(GeneratedMessage.access$1100(r4, "getDefaultInstance", new Class[0]), null, new Object[0]), GeneratedMessage.class, "com.obric.memorydata.plugin")).getMapEntryMessageDefaultInstance();
            }

            private Message coerceType(Message r3) {
                Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
                if (r4 != null) goto L7;
                return null;
            L7:
                if (ZeusTransformUtils.instanceOf(this.mapEntryMessageDefaultInstance.getClass(), r4) == false) goto L10;
                return r4;
            L10:
                return this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(r4).build();
            }

            private MapFieldReflectionAccessor getMapField(Builder<?> r1) {
                return r1.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMapField(GeneratedMessage r1) {
                return r1.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMutableMapField(Builder<?> r1) {
                return r1.internalGetMutableMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r3, Object r4) {
                getMutableMapField(r3).getMutableList().add(coerceType((Message) ZeusTransformUtils.preCheckCast(r4, Message.class, "com.obric.memorydata.plugin")));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r1) {
                getMutableMapField(r1).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r4) {
                ArrayList r0 = new ArrayList();
                int r1 = 0;
            L4:
                if (r1 >= getRepeatedCount(r4)) goto L7;
                r0.add(getRepeated(r4, r1));
                r1 = r1 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r4) {
                ArrayList r0 = new ArrayList();
                int r1 = 0;
            L4:
                if (r1 >= getRepeatedCount(r4)) goto L7;
                r0.add(getRepeated(r4, r1));
                r1 = r1 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r1) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r1) {
                return get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r1, int r2) {
                return getMapField(r1).getList().get(r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r1, int r2) {
                return getMapField(r1).getList().get(r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r1, int r2) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r1) {
                return getMapField(r1).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r1) {
                return getMapField(r1).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r1) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r1) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r3, Object r4) {
                clear(r3);
                Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                addRepeated(r3, r5.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r3, int r4, Object r5) {
                getMutableMapField(r3).getMutableList().set(r4, coerceType((Message) ZeusTransformUtils.preCheckCast(r5, Message.class, "com.obric.memorydata.plugin")));
            }
        }

        private interface OneofAccessor {
            void clear(Builder<?> r1);

            Descriptors.FieldDescriptor get(Builder<?> r1);

            Descriptors.FieldDescriptor get(GeneratedMessage r1);

            boolean has(Builder<?> r1);

            boolean has(GeneratedMessage r1);
        }

        private static class RealOneofAccessor implements OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            RealOneofAccessor(Descriptors.Descriptor r5, String r6, Class<? extends GeneratedMessage> r7, Class<? extends Builder<?>> r8) {
                this.descriptor = r5;
                this.caseMethod = GeneratedMessage.access$1100(r7, "get" + r6 + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.access$1100(r8, "get" + r6 + "Case", new Class[0]);
                this.clearMethod = GeneratedMessage.access$1100(r8, "clear" + r6, new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r2) {
                GeneratedMessage.access$1200(this.clearMethod, r2, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r3) {
                int r4 = ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethodBuilder, r3, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
                if (r4 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r4);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r3) {
                int r4 = ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethod, r3, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
                if (r4 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r4);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r3) {
                if (((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethodBuilder, r3, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber() == 0) goto L6;
                return true;
            L6:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r3) {
                if (((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethod, r3, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber() == 0) goto L6;
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

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor r7, String r8, Class<? extends GeneratedMessage> r9, Class<? extends Builder<?>> r10) {
                super(r8, r9, r10);
                this.enumDescriptor = r7.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r11 = !r7.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r11;
                if (r11 == false) goto L6;
                this.getRepeatedValueMethod = GeneratedMessage.access$1100(r9, "get" + r8 + "Value", new Class[]{Integer.TYPE});
                this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(r10, "get" + r8 + "Value", new Class[]{Integer.TYPE});
                this.setRepeatedValueMethod = GeneratedMessage.access$1100(r10, "set" + r8 + "Value", new Class[]{Integer.TYPE, Integer.TYPE});
                this.addRepeatedValueMethod = GeneratedMessage.access$1100(r10, "add" + r8 + "Value", new Class[]{Integer.TYPE});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r5, Object r6) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.addRepeatedValueMethod, r5, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r6, Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin")).getNumber())});
                return;
            L6:
                super.addRepeated(r5, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r6}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r5) {
                ArrayList r0 = new ArrayList();
                int r1 = getRepeatedCount(r5);
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L6;
                r0.add(getRepeated(r5, r2));
                r2 = r2 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r5) {
                ArrayList r0 = new ArrayList();
                int r1 = getRepeatedCount(r5);
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L6;
                r0.add(getRepeated(r5, r2));
                r2 = r2 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r4, int r5) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, r4, new Object[]{Integer.valueOf(r5)}), Integer.class, "com.obric.memorydata.plugin")).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r4, r5), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r4, int r5) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getRepeatedValueMethod, r4, new Object[]{Integer.valueOf(r5)}), Integer.class, "com.obric.memorydata.plugin")).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r4, r5), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r5, int r6, Object r7) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setRepeatedValueMethod, r5, new Object[]{Integer.valueOf(r6), Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r7, Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin")).getNumber())});
                return;
            L6:
                super.setRepeated(r5, r6, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r7}));
            }
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final MethodInvoker invoker;
            protected final Class<?> type;

            interface MethodInvoker {
                void addRepeated(Builder<?> r1, Object r2);

                void clear(Builder<?> r1);

                Object get(Builder<?> r1);

                Object get(GeneratedMessage r1);

                Object getRepeated(Builder<?> r1, int r2);

                Object getRepeated(GeneratedMessage r1, int r2);

                int getRepeatedCount(Builder<?> r1);

                int getRepeatedCount(GeneratedMessage r1);

                void setRepeated(Builder<?> r1, int r2, Object r3);
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

                ReflectionInvoker(String r8, Class<? extends GeneratedMessage> r9, Class<? extends Builder<?>> r10) {
                    this.getMethod = GeneratedMessage.access$1100(r9, "get" + r8 + e.f16168a, new Class[0]);
                    this.getMethodBuilder = GeneratedMessage.access$1100(r10, "get" + r8 + e.f16168a, new Class[0]);
                    java.lang.reflect.Method r0 = GeneratedMessage.access$1100(r9, "get" + r8, new Class[]{Integer.TYPE});
                    this.getRepeatedMethod = r0;
                    this.getRepeatedMethodBuilder = GeneratedMessage.access$1100(r10, "get" + r8, new Class[]{Integer.TYPE});
                    Class<?> r1 = r0.getReturnType();
                    this.setRepeatedMethod = GeneratedMessage.access$1100(r10, "set" + r8, new Class[]{Integer.TYPE, r1});
                    this.addRepeatedMethod = GeneratedMessage.access$1100(r10, "add" + r8, new Class[]{r1});
                    this.getCountMethod = GeneratedMessage.access$1100(r9, "get" + r8 + "Count", new Class[0]);
                    this.getCountMethodBuilder = GeneratedMessage.access$1100(r10, "get" + r8 + "Count", new Class[0]);
                    this.clearMethod = GeneratedMessage.access$1100(r10, "clear" + r8, new Class[0]);
                }

                static /* synthetic */ java.lang.reflect.Method access$1400(ReflectionInvoker r0) {
                    return r0.getRepeatedMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(Builder<?> r3, Object r4) {
                    GeneratedMessage.access$1200(this.addRepeatedMethod, r3, new Object[]{r4});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(Builder<?> r2) {
                    GeneratedMessage.access$1200(this.clearMethod, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(Builder<?> r2) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r2) {
                    return GeneratedMessage.access$1200(this.getMethod, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(Builder<?> r3, int r4) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, r3, new Object[]{Integer.valueOf(r4)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(GeneratedMessage r3, int r4) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethod, r3, new Object[]{Integer.valueOf(r4)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(Builder<?> r2) {
                    return ((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getCountMethodBuilder, r2, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(GeneratedMessage r2) {
                    return ((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getCountMethod, r2, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(Builder<?> r3, int r4, Object r5) {
                    GeneratedMessage.access$1200(this.setRepeatedMethod, r3, new Object[]{Integer.valueOf(r4), r5});
                }
            }

            RepeatedFieldAccessor(String r2, Class<? extends GeneratedMessage> r3, Class<? extends Builder<?>> r4) {
                ReflectionInvoker r0 = new ReflectionInvoker(r2, r3, r4);
                this.type = ReflectionInvoker.access$1400(r0).getReturnType();
                this.invoker = getMethodInvoker(r0);
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker r0) {
                return r0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r1, Object r2) {
                this.invoker.addRepeated(r1, r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r1) {
                this.invoker.clear(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r1) {
                return this.invoker.get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r1) {
                return this.invoker.get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r1) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r1) {
                return get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r1, int r2) {
                return this.invoker.getRepeated(r1, r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r1, int r2) {
                return this.invoker.getRepeated(r1, r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r1, int r2) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r1) {
                return this.invoker.getRepeatedCount(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r1) {
                return this.invoker.getRepeatedCount(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r1) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r1) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r3, Object r4) {
                clear(r3);
                Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                addRepeated(r3, r5.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r1, int r2, Object r3) {
                this.invoker.setRepeated(r1, r2, r3);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            RepeatedMessageFieldAccessor(String r4, Class<? extends GeneratedMessage> r5, Class<? extends Builder<?>> r6) {
                super(r4, r5, r6);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r6, "get" + r4 + "Builder", new Class[]{Integer.TYPE});
            }

            private Object coerceType(Object r3) {
                if (ZeusTransformUtils.instanceOf(this.type, r3) == false) goto L6;
                return r3;
            L6:
                return ((Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]), Message.Builder.class, "com.obric.memorydata.plugin")).mergeFrom((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin")).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r1, Object r2) {
                super.addRepeated(r1, coerceType(r2));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r3, int r4) {
                return (Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r3, new Object[]{Integer.valueOf(r4)}), Message.Builder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]), Message.Builder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r1, int r2, Object r3) {
                super.setRepeated(r1, r2, coerceType(r3));
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

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor r5, String r6, Class<? extends GeneratedMessage> r7, Class<? extends Builder<?>> r8, String r9) {
                super(r5, r6, r7, r8, r9);
                this.enumDescriptor = r5.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r10 = !r5.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r10;
                if (r10 == false) goto L6;
                this.getValueMethod = GeneratedMessage.access$1100(r7, "get" + r6 + "Value", new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.access$1100(r8, "get" + r6 + "Value", new Class[0]);
                this.setValueMethod = GeneratedMessage.access$1100(r8, "set" + r6 + "Value", new Class[]{Integer.TYPE});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r3) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r4 = ((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getValueMethodBuilder, r3, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r4);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r3), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r3) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r4 = ((Integer) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getValueMethod, r3, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r4);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r3), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r5, Object r6) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setValueMethod, r5, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r6, Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin")).getNumber())});
                return;
            L6:
                super.set(r5, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r6}));
            }
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final Class<?> type;

            private interface MethodInvoker {
                void clear(Builder<?> r1);

                Object get(Builder<?> r1);

                Object get(GeneratedMessage r1);

                int getOneofFieldNumber(Builder<?> r1);

                int getOneofFieldNumber(GeneratedMessage r1);

                boolean has(Builder<?> r1);

                boolean has(GeneratedMessage r1);

                void set(Builder<?> r1, Object r2);
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

                ReflectionInvoker(String r7, Class<? extends GeneratedMessage> r8, Class<? extends Builder<?>> r9, String r10, boolean r11, boolean r12) {
                    java.lang.reflect.Method r0 = GeneratedMessage.access$1100(r8, "get" + r7, new Class[0]);
                    this.getMethod = r0;
                    this.getMethodBuilder = GeneratedMessage.access$1100(r9, "get" + r7, new Class[0]);
                    this.setMethod = GeneratedMessage.access$1100(r9, "set" + r7, new Class[]{r0.getReturnType()});
                    java.lang.reflect.Method r3 = null;
                    if (r12 == false) goto L5;
                    java.lang.reflect.Method r4 = GeneratedMessage.access$1100(r8, "has" + r7, new Class[0]);
                L6:
                    this.hasMethod = r4;
                    if (r12 == false) goto L9;
                    java.lang.reflect.Method r13 = GeneratedMessage.access$1100(r9, "has" + r7, new Class[0]);
                L10:
                    this.hasMethodBuilder = r13;
                    this.clearMethod = GeneratedMessage.access$1100(r9, "clear" + r7, new Class[0]);
                    if (r11 == false) goto L13;
                    java.lang.reflect.Method r14 = GeneratedMessage.access$1100(r8, "get" + r10 + "Case", new Class[0]);
                L14:
                    this.caseMethod = r14;
                    if (r11 == false) goto L17;
                    r3 = GeneratedMessage.access$1100(r9, "get" + r10 + "Case", new Class[0]);
                L17:
                    this.caseMethodBuilder = r3;
                    return;
                L13:
                    r14 = null;
                    goto L14
                L9:
                    r13 = null;
                    goto L10
                L5:
                    r4 = null;
                    goto L6
                }

                static /* synthetic */ java.lang.reflect.Method access$1300(ReflectionInvoker r0) {
                    return r0.getMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(Builder<?> r2) {
                    GeneratedMessage.access$1200(this.clearMethod, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(Builder<?> r2) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r2) {
                    return GeneratedMessage.access$1200(this.getMethod, r2, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(Builder<?> r2) {
                    return ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethodBuilder, r2, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(GeneratedMessage r2) {
                    return ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.caseMethod, r2, new Object[0]), Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(Builder<?> r2) {
                    return ((Boolean) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.hasMethodBuilder, r2, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(GeneratedMessage r2) {
                    return ((Boolean) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.hasMethod, r2, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(Builder<?> r3, Object r4) {
                    GeneratedMessage.access$1200(this.setMethod, r3, new Object[]{r4});
                }
            }

            SingularFieldAccessor(Descriptors.FieldDescriptor r9, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12, String r13) {
                if (r9.getRealContainingOneof() == null) goto L5;
                boolean r0 = true;
            L6:
                boolean r6 = r0;
                this.isOneofField = r6;
                boolean r7 = r9.hasPresence();
                this.hasHasMethod = r7;
                ReflectionInvoker r1 = new ReflectionInvoker(r10, r11, r12, r13, r6, r7);
                this.field = r9;
                this.type = ReflectionInvoker.access$1300(r1).getReturnType();
                this.invoker = getMethodInvoker(r1);
                return;
            L5:
                r0 = false;
                goto L6
            }

            static MethodInvoker getMethodInvoker(ReflectionInvoker r0) {
                return r0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r1, Object r2) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r1) {
                this.invoker.clear(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r1) {
                return this.invoker.get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r1) {
                return this.invoker.get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r1) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r1) {
                return get(r1);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r1, int r2) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r1, int r2) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r1, int r2) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r1) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r1) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r3) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r3) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r3).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r3);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r3) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r3) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r3).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r3);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r1, Object r2) {
                this.invoker.set(r1, r2);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r1, int r2, Object r3) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor r2, String r3, Class<? extends GeneratedMessage> r4, Class<? extends Builder<?>> r5, String r6) {
                super(r2, r3, r4, r5, r6);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r5, "get" + r3 + "Builder", new Class[0]);
            }

            private Object coerceType(Object r3) {
                if (ZeusTransformUtils.instanceOf(this.type, r3) == false) goto L6;
                return r3;
            L6:
                return ((Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]), Message.Builder.class, "com.obric.memorydata.plugin")).mergeFrom((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin")).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r2) {
                return (Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r2, new Object[0]), Message.Builder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) ZeusTransformUtils.preCheckCast(GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]), Message.Builder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r1, Object r2) {
                super.set(r1, coerceType(r2));
            }
        }

        private static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            SingularStringFieldAccessor(Descriptors.FieldDescriptor r3, String r4, Class<? extends GeneratedMessage> r5, Class<? extends Builder<?>> r6, String r7) {
                super(r3, r4, r5, r6, r7);
                this.getBytesMethod = GeneratedMessage.access$1100(r5, "get" + r4 + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.access$1100(r6, "set" + r4 + "Bytes", new Class[]{ByteString.class});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r2) {
                return GeneratedMessage.access$1200(this.getBytesMethod, r2, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r3, Object r4) {
                if (ZeusTransformUtils.instanceOf(r4, ByteString.class) == false) goto L5;
                GeneratedMessage.access$1200(this.setBytesMethodBuilder, r3, new Object[]{r4});
                return;
            L5:
                super.set(r3, r4);
            }
        }

        private static class SyntheticOneofAccessor implements OneofAccessor {
            private final Descriptors.FieldDescriptor fieldDescriptor;

            SyntheticOneofAccessor(Descriptors.Descriptor r2, int r3) {
                this.fieldDescriptor = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(((Descriptors.OneofDescriptor) ZeusTransformUtils.preCheckCast(r2.getOneofs().get(r3), Descriptors.OneofDescriptor.class, "com.obric.memorydata.plugin")).getFields().get(0), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r1) {
                r1.clearField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r2) {
                if (r2.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r2) {
                if (r2.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r1) {
                return r1.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r1) {
                return r1.hasField(this.fieldDescriptor);
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor r1, String[] r2) {
            this.descriptor = r1;
            this.camelCaseNames = r2;
            this.fields = new FieldAccessor[r1.getFields().size()];
            this.oneofs = new OneofAccessor[r1.getOneofs().size()];
            this.initialized = false;
        }

        public FieldAccessorTable(Descriptors.Descriptor r1, String[] r2, Class<? extends GeneratedMessage> r3, Class<? extends Builder<?>> r4) {
            this(r1, r2);
            ensureFieldAccessorsInitialized(r3, r4);
        }

        static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable r0) {
            return r0.descriptor;
        }

        static /* synthetic */ OneofAccessor access$100(FieldAccessorTable r0, Descriptors.OneofDescriptor r1) {
            return r0.getOneof(r1);
        }

        static /* synthetic */ FieldAccessor access$200(FieldAccessorTable r0, Descriptors.FieldDescriptor r1) {
            return r0.getField(r1);
        }

        private FieldAccessor getField(Descriptors.FieldDescriptor r3) {
            if (r3.getContainingType() != this.descriptor) goto L11;
            if (r3.isExtension() == true) goto L9;
            return this.fields[r3.getIndex()];
        L9:
            throw new IllegalArgumentException("This type does not have extensions.");
        L11:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private OneofAccessor getOneof(Descriptors.OneofDescriptor r3) {
            if (r3.getContainingType() != this.descriptor) goto L7;
            return this.oneofs[r3.getIndex()];
        L7:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

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
            int r0 = this.fields.length;     // Catch: Throwable -> L51
            int r1 = 0;
            int r2 = 0;
        L11:
            String r3 = null;
            if (r2 >= r0) goto L42;
            Descriptors.FieldDescriptor r6 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(this.descriptor.getFields().get(r2), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
            if (r6.getContainingOneof() == null) goto L18;
            int r4 = r6.getContainingOneof().getIndex() + r0;     // Catch: Throwable -> L51
            String[] r5 = this.camelCaseNames;     // Catch: Throwable -> L51
            if (r4 >= r5.length) goto L18;
            r3 = r5[r4];     // Catch: Throwable -> L51
        L18:
            String r10 = r3;
            if (r6.isRepeated() == false) goto L31;
            if (r6.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L27;
            if (r6.isMapField() == false) goto L25;
            this.fields[r2] = new MapFieldAccessor(r6, r12);     // Catch: Throwable -> L51
        L40:
            r2 = r2 + 1;     // Catch: Throwable -> L51
            goto L11
        L25:
            this.fields[r2] = new RepeatedMessageFieldAccessor(this.camelCaseNames[r2], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L27:
            if (r6.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L29;
            this.fields[r2] = new RepeatedEnumFieldAccessor(r6, this.camelCaseNames[r2], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L29:
            this.fields[r2] = new RepeatedFieldAccessor(this.camelCaseNames[r2], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L31:
            if (r6.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            this.fields[r2] = new SingularMessageFieldAccessor(r6, this.camelCaseNames[r2], r12, r13, r10);     // Catch: Throwable -> L51
            goto L40
        L34:
            if (r6.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L37;
            this.fields[r2] = new SingularEnumFieldAccessor(r6, this.camelCaseNames[r2], r12, r13, r10);     // Catch: Throwable -> L51
            goto L40
        L37:
            if (r6.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L39;
            this.fields[r2] = new SingularStringFieldAccessor(r6, this.camelCaseNames[r2], r12, r13, r10);     // Catch: Throwable -> L51
            goto L40
        L39:
            this.fields[r2] = new SingularFieldAccessor(r6, this.camelCaseNames[r2], r12, r13, r10);     // Catch: Throwable -> L51
        L42:
            if (r1 >= this.descriptor.getOneofs().size()) goto L48;
            if (r1 >= this.descriptor.getRealOneofs().size()) goto L46;
            this.oneofs[r1] = new RealOneofAccessor(this.descriptor, this.camelCaseNames[r1 + r0], r12, r13);     // Catch: Throwable -> L51
        L47:
            r1 = r1 + 1;     // Catch: Throwable -> L51
            goto L42
        L46:
            this.oneofs[r1] = new SyntheticOneofAccessor(this.descriptor, r1);     // Catch: Throwable -> L51
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

        GeneratedExtension(ExtensionDescriptorRetriever r3, Class<?> r4, Message r5, Extension.ExtensionType r6) {
            ExtensionDescriptorRetriever r7 = (ExtensionDescriptorRetriever) ZeusTransformUtils.wrapperContextForParams(r3, ExtensionDescriptorRetriever.class, "com.obric.memorydata.plugin");
            Message r8 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
            if (Message.class.isAssignableFrom(r4) == true) goto L5;
        L9:
            this.descriptorRetriever = r7;
            this.singularType = r4;
            this.messageDefaultInstance = r8;
            if (ProtocolMessageEnum.class.isAssignableFrom(r4) == false) goto L12;
            this.enumValueOf = GeneratedMessage.access$1100(r4, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
            java.lang.reflect.Method r9 = GeneratedMessage.access$1100(r4, "getValueDescriptor", new Class[0]);
        L13:
            this.enumGetValueDescriptor = r9;
            this.extensionType = r6;
            return;
        L12:
            r9 = null;
            this.enumValueOf = null;
            goto L13
        L5:
            if (ZeusTransformUtils.instanceOf(r4, r8) == true) goto L9;
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + r4.getName());
        }

        @Override // com.google.protobuf.Extension
        public Object fromReflectionType(Object r4) {
            Descriptors.FieldDescriptor r0 = getDescriptor();
            if (r0.isRepeated() == false) goto L17;
            if (r0.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        L10:
            ProtobufArrayList r1 = new ProtobufArrayList();
            r1.ensureCapacity(((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).size());
            Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        L12:
            if (r5.hasNext() == false) goto L14;
            r1.add(singularFromReflectionType(r5.next()));
            goto L12
        L14:
            r1.makeImmutable();
            return r1;
        L7:
            if (r0.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L10;
            return r4;
        L17:
            return singularFromReflectionType(r4);
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
            ExtensionDescriptorRetriever r1 = this.descriptorRetriever;
            if (r1 == null) goto L7;
            return r1.getDescriptor();
        L7:
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.Extension
        public Extension.ExtensionType getExtensionType() {
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

        public void internalInit(final Descriptors.FieldDescriptor r2) {
            if (this.descriptorRetriever != null) goto L7;
            this.descriptorRetriever = new AnonymousClass1(this, r2);
            return;
        L7:
            throw new IllegalStateException("Already initialized.");
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.Extension
        public Object singularFromReflectionType(Object r4) {
            int r0 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (r0 == 1) goto L10;
            if (r0 == 2) goto L8;
            return r4;
        L8:
            return GeneratedMessage.access$1200(this.enumValueOf, null, new Object[]{r4});
        L10:
            if (ZeusTransformUtils.instanceOf(this.singularType, r4) == false) goto L13;
            return r4;
        L13:
            return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) ZeusTransformUtils.preCheckCast(r4, Message.class, "com.obric.memorydata.plugin")).build();
        }

        @Override // com.google.protobuf.Extension
        public Object singularToReflectionType(Object r3) {
            Descriptors.FieldDescriptor r0 = getDescriptor();
            if (AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[r0.getJavaType().ordinal()] == 2) goto L6;
            return r3;
        L6:
            return GeneratedMessage.access$1200(this.enumGetValueDescriptor, r3, new Object[0]);
        }

        @Override // com.google.protobuf.Extension
        public Object toReflectionType(Object r4) {
            Descriptors.FieldDescriptor r0 = getDescriptor();
            if (r0.isRepeated() == false) goto L13;
            if (r0.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L11;
            ArrayList r1 = new ArrayList();
            Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r1.add(singularToReflectionType(r5.next()));
            goto L8
        L10:
            return r1;
        L11:
            return r4;
        L13:
            return singularToReflectionType(r4);
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

    public GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    public GeneratedMessage(Builder<?> r1) {
        this.unknownFields = r1.getUnknownFields();
    }

    static /* synthetic */ java.lang.reflect.Method access$1100(Class r0, String r1, Class[] r2) {
        return getMethodOrDie(r0, r1, r2);
    }

    static /* synthetic */ Object access$1200(java.lang.reflect.Method r0, Object r1, Object[] r2) {
        return invokeOrDie(r0, r1, r2);
    }

    static /* synthetic */ Extension access$500(ExtensionLite r0) {
        return checkNotLite(r0);
    }

    static /* synthetic */ Map access$800(GeneratedMessage r0, boolean r1) {
        return r0.getAllFieldsMutable(r1);
    }

    public static boolean canUseUnsafe() {
        if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
    L7:
        return false;
    L5:
        if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
        return true;
    }

    private static <MessageT extends ExtendableMessage<MessageT>, T> Extension<MessageT, T> checkNotLite(ExtensionLite<? extends MessageT, T> r2) {
        if (r2.isLite() == true) goto L7;
        return (Extension) ZeusTransformUtils.preCheckCast(r2, Extension.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    public static int computeStringSize(int r2, Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L7;
        return CodedOutputStream.computeStringSize(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L7:
        return CodedOutputStream.computeBytesSize(r2, (ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    }

    public static int computeStringSizeNoTag(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return CodedOutputStream.computeStringSizeNoTag((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L7:
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin"));
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static <T> Internal.ProtobufList<T> emptyList(Class<T> r0) {
        return ProtobufArrayList.emptyList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean r8) {
        TreeMap r0 = new TreeMap();
        List<Descriptors.FieldDescriptor> r1 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
        int r2 = 0;
    L4:
        if (r2 >= r1.size()) goto L25;
        Descriptors.FieldDescriptor r3 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.get(r2), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        Descriptors.OneofDescriptor r4 = r3.getContainingOneof();
        if (r4 == null) goto L12;
        r2 = r2 + (r4.getFieldCount() - 1);
        if (hasOneof(r4) == false) goto L24;
        r3 = getOneofFieldDescriptor(r4);
    L19:
        if (r8 == true) goto L21;
    L23:
        Object r5 = getField(r3);
    L15:
        r0.put(r3, r5);
        goto L24
    L21:
        if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L23;
        r5 = getFieldRaw(r3);
    L24:
        r2 = r2 + 1;
        goto L4
    L12:
        if (r3.isRepeated() == false) goto L17;
        List r6 = (List) ZeusTransformUtils.preCheckCast(getField(r3), List.class, "com.obric.memorydata.plugin");
        boolean r7 = r6.isEmpty();
        r5 = r6;
        if (r7 == true) goto L24;
    L17:
        if (hasField(r3) == true) goto L19;
    L25:
        return r0;
    }

    private static java.lang.reflect.Method getMethodOrDie(Class<?> r3, String r4, Class<?>... r5) {
        return r3.getMethod(r4, r5);
    L4:
        e = move-exception;
        throw new IllegalStateException("Generated message class \"" + r3.getName() + "\" missing method \"" + r4 + "\".", e);
    }

    private static Object invokeOrDie(java.lang.reflect.Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r3, RuntimeException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, Error.class) == false) goto L12;
        throw ((Error) ZeusTransformUtils.preCheckCast(r3, Error.class, "com.obric.memorydata.plugin"));
    L12:
        throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r3, RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    public static boolean isStringEmpty(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")).isEmpty();
    L7:
        return ((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r2) {
        return (ListT) makeMutableCopy((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.ProtobufList.class, "com.obric.memorydata.plugin"), 0);
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r2, int r3) {
        Internal.ProtobufList r4 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.ProtobufList.class, "com.obric.memorydata.plugin");
        int r0 = r4.size();
        if (r3 > r0) goto L5;
        r3 = r0 * 2;
    L5:
        if (r3 > 0) goto L8;
        r3 = 10;
    L8:
        return (ListT) r4.mutableCopyWithCapacity(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream r2, Map<Boolean, V> r3, MapEntry<Boolean, V> r4, int r5, boolean r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r7.containsKey(Boolean.valueOf(r6)) == false) goto L6;
        r2.writeMessage(r5, r4.newBuilderForType().setKey(Boolean.valueOf(r6)).setValue(r7.get(Boolean.valueOf(r6))).build());
        return;
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newFileScopedGeneratedExtension(Class<?> r3, Message r4) {
        return new GeneratedExtension(null, r3, (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin"), Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newMessageScopedGeneratedExtension(Message r2, final int r3, Class<?> r4, Message r5) {
        final Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
        Message r7 = (Message) ZeusTransformUtils.wrapperContextForParams(r5, Message.class, "com.obric.memorydata.plugin");
        return new GeneratedExtension(new AnonymousClass1(r6, r3), r4, r7, Extension.ExtensionType.IMMUTABLE);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r2, InputStream r3) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseDelimitedFrom(r3), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r2, InputStream r3, ExtensionRegistryLite r4) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseDelimitedFrom(r3, r4), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r2, CodedInputStream r3) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseFrom(r3), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r2, CodedInputStream r3, ExtensionRegistryLite r4) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseFrom(r3, r4), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r2, InputStream r3) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseFrom(r3), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r2, InputStream r3, ExtensionRegistryLite r4) {
        return (M) ZeusTransformUtils.preCheckCast(((Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.memorydata.plugin")).parseFrom(r3, r4), Message.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <V> void serializeBooleanMapTo(CodedOutputStream r1, MapField<Boolean, V> r2, MapEntry<Boolean, V> r3, int r4) {
        Map<Boolean, V> r5 = r2.getMap();
        if (r1.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r1, r5, r3, r4);
        return;
    L6:
        maybeSerializeBooleanEntryTo(r1, r5, r3, r4, false);
        maybeSerializeBooleanEntryTo(r1, r5, r3, r4, true);
    }

    public static <V> void serializeIntegerMapTo(CodedOutputStream r8, MapField<Integer, V> r9, MapEntry<Integer, V> r10, int r11) {
        Map<Integer, V> r12 = r9.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r12, r10, r11);
        return;
    L6:
        int r0 = r12.size();
        int[] r1 = new int[r0];
        Iterator<Integer> r2 = r12.keySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r1[r4] = ((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r4 = r4 + 1;
        goto L8
    L10:
        Arrays.sort(r1);
    L11:
        if (r3 >= r0) goto L13;
        int r5 = r1[r3];
        r8.writeMessage(r11, r10.newBuilderForType().setKey(Integer.valueOf(r5)).setValue(r12.get(Integer.valueOf(r5))).build());
        r3 = r3 + 1;
        goto L11
    }

    public static <V> void serializeLongMapTo(CodedOutputStream r8, MapField<Long, V> r9, MapEntry<Long, V> r10, int r11) {
        Map<Long, V> r12 = r9.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r12, r10, r11);
        return;
    L6:
        int r0 = r12.size();
        long[] r1 = new long[r0];
        Iterator<Long> r2 = r12.keySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r1[r4] = ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        r4 = r4 + 1;
        goto L8
    L10:
        Arrays.sort(r1);
    L11:
        if (r3 >= r0) goto L13;
        long r5 = r1[r3];
        r8.writeMessage(r11, r10.newBuilderForType().setKey(Long.valueOf(r5)).setValue(r12.get(Long.valueOf(r5))).build());
        r3 = r3 + 1;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void serializeMapTo(CodedOutputStream r4, Map<K, V> r5, MapEntry<K, V> r6, int r7) {
        Iterator<Map.Entry<K, V>> r8 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeMessage(r7, r6.newBuilderForType().setKey(r0.getKey()).setValue(r0.getValue()).build());
        goto L4
    }

    public static <V> void serializeStringMapTo(CodedOutputStream r5, MapField<String, V> r6, MapEntry<String, V> r7, int r8) {
        Map<String, V> r9 = r6.getMap();
        if (r5.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r5, r9, r7, r8);
        return;
    L6:
        String[] r0 = new String[r9.size()];
        String[] r1 = (String[]) ZeusTransformUtils.preCheckCast(r9.keySet().toArray(r0), String[].class, "com.obric.memorydata.plugin");
        Arrays.sort(r1);
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        String r4 = r1[r3];
        r5.writeMessage(r8, r7.newBuilderForType().setKey(r4).setValue(r9.get(r4)).build());
        r3 = r3 + 1;
        goto L7
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean r0) {
        alwaysUseFieldBuilders = r0;
    }

    public static void writeString(CodedOutputStream r2, int r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L5;
        r2.writeString(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r2.writeBytes(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
    }

    public static void writeStringNoTag(CodedOutputStream r2, Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L5;
        r2.writeStringNoTag((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r2.writeBytesNoTag((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
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
    public Object getField(Descriptors.FieldDescriptor r2) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).get(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor r2) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r2) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r2).get(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r2, int r3) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRepeated(this, r3);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r2) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r2) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r2).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r2) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r2).has(this);
    }

    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    @Deprecated
    public MapField internalGetMapField(int r3) {
        throw new IllegalArgumentException("No map fields found in " + getClass().getName());
    }

    public MapFieldReflectionAccessor internalGetMapFieldReflection(int r1) {
        return internalGetMapField(r1);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        Iterator<Descriptors.FieldDescriptor> r0 = getDescriptorForType().getFields().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        Descriptors.FieldDescriptor r1 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r1.isRequired() == false) goto L11;
        if (hasField(r1) == true) goto L11;
        return false;
    L11:
        if (r1.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
        if (r1.isRepeated() == true) goto L14;
        if (hasField(r1) == false) goto L4;
        if (((Message) ZeusTransformUtils.preCheckCast(getField(r1), Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L4;
        return false;
    L14:
        Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(getField(r1), List.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r2.hasNext() == false) goto L4;
        if (((Message) ZeusTransformUtils.preCheckCast(r2.next(), Message.class, "com.obric.memorydata.plugin")).isInitialized() == true) goto L16;
        return false;
    L25:
        return true;
    }

    @Deprecated
    public void mergeFromAndMakeImmutableInternal(CodedInputStream r2, ExtensionRegistryLite r3) {
        Schema r0 = Protobuf.getInstance().schemaFor(this);
        r0.mergeFrom(this, CodedInputStreamReader.forCodedInput(r2), r3);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        r0.makeImmutable(this);
        return;
    L9:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L6:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    public Object newInstance(UnusedPrivateParameter r1) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public boolean parseUnknownField(CodedInputStream r1, UnknownFieldSet.Builder r2, ExtensionRegistryLite r3, int r4) {
        if (r1.shouldDiscardUnknownFields() == false) goto L7;
        return r1.skipField(r4);
    L7:
        return r2.mergeFieldFrom(r4, r1);
    }

    public boolean parseUnknownFieldProto3(CodedInputStream r1, UnknownFieldSet.Builder r2, ExtensionRegistryLite r3, int r4) {
        return parseUnknownField(r1, r2, r3, r4);
    }

    void setUnknownFields(UnknownFieldSet r1) {
        this.unknownFields = r1;
    }

    public Object writeReplace() {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r3) {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), r3, false);
    }
}
