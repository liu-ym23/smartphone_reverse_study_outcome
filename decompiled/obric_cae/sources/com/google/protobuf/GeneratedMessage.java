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
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    static final String PRE22_GENCODE_ERROR_PROPERTY = "com.google.protobuf.error_on_unsafe_pre22_gencode";
    static final String PRE22_GENCODE_SILENCE_PROPERTY = "com.google.protobuf.use_unsafe_pre22_gencode";
    static final String PRE22_GENCODE_VULNERABILITY_MESSAGE = "As of 2022/09/29 (release 21.7) makeExtensionsImmutable should not be called from protobuf gencode. If you are seeing this message, your gencode is vulnerable to a denial of service attack. You should regenerate your code using protobuf 25.6 or later. Use the latest version that meets your needs. However, if you understand the risks and wish to continue with vulnerable gencode, you can set the system property `-Dcom.google.protobuf.use_unsafe_pre22_gencode` on the command line to silence this warning. You also can set `-Dcom.google.protobuf.error_on_unsafe_pre22_gencode` to throw an error instead. See security vulnerability: https://github.com/protocolbuffers/protobuf/security/advisories/GHSA-h4h5-3hr4-j3g2";
    protected static boolean alwaysUseFieldBuilders = false;
    protected static final Set<String> loggedPre22TypeNames = null;
    private static final Logger logger = null;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;

        static {
            int[] r8 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r8;
            r8[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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

        public class BuilderParentImpl implements AbstractMessage.BuilderParent {
            final /* synthetic */ Builder this$0;

            private BuilderParentImpl(Builder r8) {
                this.this$0 = r8;
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }

            public /* synthetic */ BuilderParentImpl(Builder r8, AnonymousClass1 r10) {
                this(r8);
            }
        }

        public Builder() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
        }

        public static /* synthetic */ Map access$900(Builder r8) {
            return r8.getAllFieldsMutable();
        }

        private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap r8 = new TreeMap();
            List<Descriptors.FieldDescriptor> r10 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
            int r11 = 0;
        L4:
            if (r11 >= r10.size()) goto L22;
            Descriptors.FieldDescriptor r12 = r10.get(r11);
            Descriptors.OneofDescriptor r13 = r12.getContainingOneof();
            if (r13 == null) goto L12;
            r11 = r11 + (r13.getFieldCount() - 1);
            if (hasOneof(r13) == false) goto L21;
            r12 = getOneofFieldDescriptor(r13);
        L19:
            Object r14 = getField(r12);
        L20:
            r8.put(r12, r14);
        L21:
            r11 = r11 + 1;
            goto L4
        L12:
            if (r12.isRepeated() == false) goto L17;
            List r15 = (List) getField(r12);
            boolean r16 = r15.isEmpty();
            r14 = r15;
            if (r16 == true) goto L21;
        L17:
            if (hasField(r12) == true) goto L19;
        L22:
            return r8;
        }

        private BuilderT setUnknownFieldsInternal(UnknownFieldSet r8) {
            this.unknownFieldsOrBuilder = r8;
            onChanged();
            return this;
        }

        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).addRepeated(this, r10);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public BuilderT clearField(Descriptors.FieldDescriptor r8) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
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
        public Object getField(Descriptors.FieldDescriptor r8) {
            Object r10 = FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).get(this);
            if (r8.isRepeated() == true) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList((List) r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r8) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r8).get(this);
        }

        public AbstractMessage.BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRepeated(this, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r8, int r10) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRepeatedBuilder(this, r10);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            Object r8 = this.unknownFieldsOrBuilder;
            if ((r8 instanceof UnknownFieldSet) == false) goto L5;
            this.unknownFieldsOrBuilder = ((UnknownFieldSet) r8).toBuilder();
        L5:
            onChanged();
            return (UnknownFieldSet.Builder) this.unknownFieldsOrBuilder;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            Object r8 = this.unknownFieldsOrBuilder;
            if ((r8 instanceof UnknownFieldSet) == false) goto L7;
            return (UnknownFieldSet) r8;
        L7:
            return ((UnknownFieldSet.Builder) r8).buildPartial();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r8).has(this);
        }

        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        @Deprecated
        public MapField internalGetMapField(int r8) {
            throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
        }

        public MapFieldReflectionAccessor internalGetMapFieldReflection(int r8) {
            return internalGetMapField(r8);
        }

        @Deprecated
        public MapField internalGetMutableMapField(int r8) {
            throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
        }

        public MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r8) {
            return internalGetMutableMapField(r8);
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r8 = getDescriptorForType().getFields().iterator();
        L4:
            if (r8.hasNext() == false) goto L25;
            Descriptors.FieldDescriptor r10 = r8.next();
            if (r10.isRequired() == false) goto L11;
            if (hasField(r10) == true) goto L11;
            return false;
        L11:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            if (r10.isRepeated() == true) goto L14;
            if (hasField(r10) == false) goto L4;
            if (((Message) getField(r10)).isInitialized() == true) goto L4;
            return false;
        L14:
            Iterator r11 = ((List) getField(r10)).iterator();
        L16:
            if (r11.hasNext() == false) goto L4;
            if (((Message) r11.next()).isInitialized() == true) goto L16;
            return false;
        L25:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public final void mergeUnknownLengthDelimitedField(int r8, ByteString r10) {
            getUnknownFieldSetBuilder().mergeLengthDelimitedField(r8, r10);
        }

        public final void mergeUnknownVarintField(int r8, int r10) {
            getUnknownFieldSetBuilder().mergeVarintField(r8, r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r8) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).newBuilder();
        }

        public void onBuilt() {
            if (this.builderParent == null) goto L6;
            markClean();
            return;
        }

        public final void onChanged() {
            if (this.isClean == false) goto L8;
            AbstractMessage.BuilderParent r8 = this.builderParent;
            if (r8 == null) goto L9;
            r8.markDirty();
            this.isClean = false;
            return;
        L9:
            return;
        }

        public boolean parseUnknownField(CodedInputStream r8, ExtensionRegistryLite r10, int r11) {
            if (r8.shouldDiscardUnknownFields() == false) goto L7;
            return r8.skipField(r11);
        L7:
            return getUnknownFieldSetBuilder().mergeFieldFrom(r11, r8);
        }

        public BuilderT setField(Descriptors.FieldDescriptor r8, Object r10) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).set(this, r10);
            return this;
        }

        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).setRepeated(this, r10, r11);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void setUnknownFieldSetBuilder(UnknownFieldSet.Builder r8) {
            this.unknownFieldsOrBuilder = r8;
            onChanged();
        }

        public BuilderT setUnknownFields(UnknownFieldSet r8) {
            return (BuilderT) setUnknownFieldsInternal(r8);
        }

        public BuilderT setUnknownFieldsProto3(UnknownFieldSet r8) {
            return (BuilderT) setUnknownFieldsInternal(r8);
        }

        public Builder(AbstractMessage.BuilderParent r8) {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            this.builderParent = r8;
        }

        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.unknownFieldsOrBuilder = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearOneof(Descriptors.OneofDescriptor r8) {
            FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r8).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT mergeUnknownFields(UnknownFieldSet r8) {
            if (UnknownFieldSet.getDefaultInstance().equals(r8) == false) goto L6;
            return this;
        L6:
            if (UnknownFieldSet.getDefaultInstance().equals(this.unknownFieldsOrBuilder) == false) goto L10;
            this.unknownFieldsOrBuilder = r8;
        L8:
            onChanged();
            return this;
        L10:
            getUnknownFieldSetBuilder().mergeFrom(r8);
            goto L8
        }

        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clone() {
            return (BuilderT) ((Builder) getDefaultInstanceForType().newBuilderForType()).mergeFrom(buildPartial());
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
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
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }
    }

    public static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        private CachedDescriptorRetriever() {
        }

        public /* synthetic */ CachedDescriptorRetriever(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor != null) goto L15;
            Descriptors.FieldDescriptor r8 = loadDescriptor();
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.descriptor != null) goto L9;
            this.descriptor = r8;     // Catch: Throwable -> L11
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

        public ExtendableBuilder(AbstractMessage.BuilderParent r8) {
            super(r8);
        }

        public static /* synthetic */ FieldSet access$400(ExtendableBuilder r8) {
            return r8.buildExtensions();
        }

        private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r8 = this.extensions;
            if (r8 != null) goto L6;
            return FieldSet.emptySet();
        L6:
            return r8.buildPartial();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions != null) goto L6;
            this.extensions = FieldSet.newBuilder();
            return;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageT, ?> r8) {
            if (r8.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r8.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <T> BuilderT addExtension(Extension<? extends MessageT, List<T>> r8, T r10) {
            return (BuilderT) addExtension(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public final <T> BuilderT clearExtension(Extension<? extends MessageT, T> r8) {
            return (BuilderT) clearExtension(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public boolean extensionsAreInitialized() {
            FieldSet.Builder<Descriptors.FieldDescriptor> r8 = this.extensions;
            if (r8 != null) goto L5;
        L8:
            return true;
        L5:
            if (r8.isInitialized() == true) goto L8;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r8 = Builder.access$900(this);
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 == null) goto L6;
            r8.putAll(r10.getAllFields());
        L6:
            return Collections.unmodifiableMap(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r8) {
            Extension<MessageT, ?> r10 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r10);
            Descriptors.FieldDescriptor r11 = r10.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r12 = this.extensions;
            if (r12 != null) goto L5;
            Object r13 = null;
        L6:
            if (r13 != null) goto L18;
            if (r11.isRepeated() == false) goto L12;
            return (T) Collections.emptyList();
        L12:
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L16;
            return (T) r10.getMessageDefaultInstance();
        L16:
            return (T) r10.fromReflectionType(r11.getDefaultValue());
        L18:
            return (T) r10.fromReflectionType(r13);
        L5:
            r13 = r12.getField(r11);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r8) {
            Extension<MessageT, ?> r10 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r10);
            Descriptors.FieldDescriptor r11 = r10.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r12 = this.extensions;
            if (r12 != null) goto L6;
            return 0;
        L6:
            return r12.getRepeatedFieldCount(r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L16;
            verifyContainingType(r8);
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 != null) goto L7;
            Object r11 = null;
        L8:
            if (r11 == null) goto L10;
            return r11;
        L10:
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            return DynamicMessage.getDefaultInstance(r8.getMessageType());
        L14:
            return r8.getDefaultValue();
        L7:
            r11 = r10.getField(r8);
            goto L8
        L16:
            return super.getField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L23;
            verifyContainingType(r8);
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L21;
            ensureExtensionsIsMutable();
            Object r10 = this.extensions.getFieldAllowBuilders(r8);
            if (r10 != null) goto L12;
            Message.Builder r11 = DynamicMessage.newBuilder(r8.getMessageType());
        L9:
            this.extensions.setField(r8, r11);
            onChanged();
            return r11;
        L12:
            if ((r10 instanceof Message.Builder) == false) goto L16;
            return (Message.Builder) r10;
        L16:
            if ((r10 instanceof Message) == false) goto L19;
            r11 = ((Message) r10).toBuilder();
            goto L9
        L19:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L21:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L23:
            return super.getFieldBuilder(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
            if (r8.isExtension() == false) goto L11;
            verifyContainingType(r8);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 == null) goto L9;
            return r11.getRepeatedField(r8, r10);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            return super.getRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r8, int r10) {
            if (r8.isExtension() == false) goto L19;
            verifyContainingType(r8);
            ensureExtensionsIsMutable();
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L17;
            Object r11 = this.extensions.getRepeatedFieldAllowBuilders(r8, r10);
            if ((r11 instanceof Message.Builder) == false) goto L11;
            return (Message.Builder) r11;
        L11:
            if ((r11 instanceof Message) == false) goto L15;
            Message.Builder r12 = ((Message) r11).toBuilder();
            this.extensions.setRepeatedField(r8, r10, r12);
            onChanged();
            return r12;
        L15:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L17:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L19:
            return super.getRepeatedFieldBuilder(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L10;
            verifyContainingType(r8);
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 != null) goto L8;
            return 0;
        L8:
            return r10.getRepeatedFieldCount(r8);
        L10:
            return super.getRepeatedFieldCount(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r8) {
            Extension<MessageT, ?> r10 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r10);
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.extensions;
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11.hasField(r10.getDescriptor()) == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L12;
            verifyContainingType(r8);
            FieldSet.Builder<Descriptors.FieldDescriptor> r10 = this.extensions;
            if (r10 != null) goto L7;
        L9:
            return false;
        L7:
            if (r10.hasField(r8) == false) goto L9;
            return true;
        L12:
            return super.hasField(r8);
        }

        public void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> r8) {
            this.extensions = FieldSet.Builder.fromFieldSet(r8);
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

        public void mergeExtensionFields(ExtendableMessage<?> r8) {
            if (ExtendableMessage.access$600(r8) == null) goto L6;
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$600(r8));
            onChanged();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L7;
            return DynamicMessage.newBuilder(r8.getMessageType());
        L7:
            return super.newBuilderForField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public boolean parseUnknownField(CodedInputStream r8, ExtensionRegistryLite r10, int r11) {
            ensureExtensionsIsMutable();
            if (r8.shouldDiscardUnknownFields() == false) goto L5;
            UnknownFieldSet.Builder r12 = null;
        L7:
            return MessageReflection.mergeFieldFrom(r8, r12, r10, getDescriptorForType(), new MessageReflection.ExtensionBuilderAdapter(this.extensions), r11);
        L5:
            r12 = getUnknownFieldSetBuilder();
            goto L7
        }

        public final <T> BuilderT setExtension(Extension<? extends MessageT, List<T>> r8, int r10, T r11) {
            return (BuilderT) setExtension(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public final <T> BuilderT addExtension(ExtensionLite<? extends MessageT, List<T>> r8, T r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r11);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            this.extensions.addRepeatedField(r12, r11.singularToReflectionType(r10));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r8, r10);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        public final <T> BuilderT clearExtension(ExtensionLite<? extends MessageT, T> r8) {
            Extension<MessageT, ?> r10 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r10);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r10.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r8);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r8, int r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r11);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> r13 = this.extensions;
            if (r13 == null) goto L7;
            return (T) r11.singularFromReflectionType(r13.getRepeatedField(r12, r10));
        L7:
            throw new IndexOutOfBoundsException();
        }

        public final <T> BuilderT setExtension(Extension<? extends MessageT, T> r8, T r10) {
            return (BuilderT) setExtension(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor r8, Object r10) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            ensureExtensionsIsMutable();
            this.extensions.setField(r8, r10);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r8, r10, r11);
            onChanged();
            return this;
        L7:
            return (BuilderT) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.extensions = null;
            return (BuilderT) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, List<T>> r8, int r10, T r11) {
            Extension<MessageT, ?> r12 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r12);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r13 = r12.getDescriptor();
            this.extensions.setRepeatedField(r13, r10, r12.singularToReflectionType(r11));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, T> r8, T r10) {
            Extension<MessageT, ?> r11 = GeneratedMessage.access$500(r8);
            verifyExtensionContainingType(r11);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            this.extensions.setField(r12, r11.toReflectionType(r10));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageT> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public interface ExtensionSerializer {
            void writeUntil(int r8, CodedOutputStream r10);
        }

        public class ExtensionWriter implements ExtensionSerializer {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public ExtensionWriter(ExtendableMessage r8, boolean r10) {
                this.this$0 = r8;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r11 = ExtendableMessage.access$600(r8).iterator();
                this.iter = r11;
                if (r11.hasNext() == false) goto L5;
                this.next = r11.next();
            L5:
                this.messageSetWireFormat = r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int r8, CodedOutputStream r10) {
            L2:
                Map.Entry<Descriptors.FieldDescriptor, Object> r11 = this.next;
                if (r11 == null) goto L22;
                if (r11.getKey().getNumber() >= r8) goto L27;
                Descriptors.FieldDescriptor r12 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L16:
                FieldSet.writeField(r12, this.next.getValue(), r10);
            L18:
                if (this.iter.hasNext() == false) goto L20;
                Map.Entry<Descriptors.FieldDescriptor, Object> r13 = this.iter.next();
            L21:
                this.next = r13;
                goto L2
            L20:
                r13 = null;
                goto L21
            L9:
                if (r12.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
                if (r12.isRepeated() == true) goto L16;
                boolean r14 = this.next instanceof LazyField.LazyEntry;
                int r15 = r12.getNumber();
                if (r14 == false) goto L15;
                r10.writeRawMessageSetExtension(r15, ((LazyField.LazyEntry) this.next).getField().toByteString());
                goto L18
            L15:
                r10.writeMessageSetExtension(r15, (Message) this.next.getValue());
                goto L18
            L27:
                return;
            }
        }

        public static final class FieldEntry {
            private final Descriptors.FieldDescriptor descriptor;
            private final Object value;

            public FieldEntry(Descriptors.FieldDescriptor r8, Object r10) {
                this.descriptor = r8;
                this.value = r10;
            }

            public Descriptors.FieldDescriptor getDescriptor() {
                return this.descriptor;
            }

            public Object getValue() {
                return this.value;
            }
        }

        public static final class FieldEntryIterator implements Iterator<FieldEntry> {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;

            public FieldEntryIterator(FieldSet<Descriptors.FieldDescriptor> r8) {
                this.iter = r8.iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.iter.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public final FieldEntry next() {
                Map.Entry<Descriptors.FieldDescriptor, Object> r8 = this.iter.next();
                return new FieldEntry(r8.getKey(), r8.getValue());
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ FieldEntry next() {
                return next();
            }
        }

        public static final class NoOpExtensionSerializer implements ExtensionSerializer {
            private static final NoOpExtensionSerializer INSTANCE = null;

            static {
                INSTANCE = new NoOpExtensionSerializer();
            }

            private NoOpExtensionSerializer() {
            }

            public static /* synthetic */ NoOpExtensionSerializer access$700() {
                return INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int r8, CodedOutputStream r10) {
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public static /* synthetic */ FieldSet access$600(ExtendableMessage r8) {
            return r8.extensions;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r8.getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public final Iterator<FieldEntry> extensionsIterator() {
            return new FieldEntryIterator(this.extensions);
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r8 = GeneratedMessage.access$800(this, false);
            r8.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map r8 = GeneratedMessage.access$800(this, false);
            r8.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> r8) {
            Extension r10 = GeneratedMessage.access$500(r8);
            Descriptors.FieldDescriptor r11 = r10.getDescriptor();
            verifyExtensionContainingType(r11);
            Object r12 = this.extensions.getField(r11);
            if (r12 == null) goto L5;
        L11:
            T r13 = (T) r10.fromReflectionType(r12);
        L13:
            if (this.extensions.lazyFieldCorrupted(r11) == false) goto L15;
            setMemoizedSerializedSize(-1);
        L15:
            return r13;
        L5:
            if (r11.isRepeated() == false) goto L8;
            r13 = (T) ProtobufArrayList.emptyList();
            goto L13
        L8:
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            r13 = (T) r10.getMessageDefaultInstance();
            goto L13
        L10:
            r12 = r11.getDefaultValue();
            goto L11
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r8) {
            Descriptors.FieldDescriptor r10 = GeneratedMessage.access$500(r8).getDescriptor();
            verifyExtensionContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10);
        }

        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L17;
            verifyContainingType(r8);
            Object r10 = this.extensions.getField(r8);
            if (r10 == null) goto L7;
            return r10;
        L7:
            if (r8.isRepeated() == false) goto L11;
            return Collections.emptyList();
        L11:
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            return DynamicMessage.getDefaultInstance(r8.getMessageType());
        L15:
            return r8.getDefaultValue();
        L17:
            return super.getField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            return this.extensions.getRepeatedField(r8, r10);
        L7:
            return super.getRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            return this.extensions.getRepeatedFieldCount(r8);
        L7:
            return super.getRepeatedFieldCount(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r8) {
            Descriptors.FieldDescriptor r10 = GeneratedMessage.access$500(r8).getDescriptor();
            verifyExtensionContainingType(r10);
            return this.extensions.hasField(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            if (r8.isExtension() == false) goto L7;
            verifyContainingType(r8);
            return this.extensions.hasField(r8);
        L7:
            return super.hasField(r8);
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

        @Override // com.google.protobuf.GeneratedMessage
        public void makeExtensionsImmutable() {
            GeneratedMessage.warnPre22Gencode(getClass());
            this.extensions.makeImmutable();
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

        public ExtendableMessage(ExtendableBuilder<MessageT, ?> r8) {
            super(r8);
            this.extensions = ExtendableBuilder.access$400(r8);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r8, int r10) {
            Extension r11 = GeneratedMessage.access$500(r8);
            Descriptors.FieldDescriptor r12 = r11.getDescriptor();
            verifyExtensionContainingType(r12);
            return (T) r11.singularFromReflectionType(this.extensions.getRepeatedField(r12, r10));
        }
    }

    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends MessageOrBuilder {
        Message getDefaultInstanceForType();

        @Override // com.google.protobuf.MessageOrBuilder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        /* bridge */ /* synthetic */ default MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        default <T> T getExtension(Extension<? extends MessageT, T> r8) {
            return (T) getExtension(r8);
        }

        <T> T getExtension(ExtensionLite<? extends MessageT, T> r8);

        <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> r8, int r10);

        default <T> int getExtensionCount(Extension<? extends MessageT, List<T>> r8) {
            return getExtensionCount(r8);
        }

        <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> r8);

        default <T> boolean hasExtension(Extension<? extends MessageT, T> r8) {
            return hasExtension(r8);
        }

        <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> r8);

        default <T> T getExtension(Extension<? extends MessageT, List<T>> r8, int r10) {
            return (T) getExtension(r8, r10);
        }

        default <T> int getExtensionCount(GeneratedExtension<MessageT, List<T>> r8) {
            return getExtensionCount(r8);
        }

        default <T> boolean hasExtension(GeneratedExtension<? extends MessageT, T> r8) {
            return hasExtension(r8);
        }

        default <T> T getExtension(GeneratedExtension<MessageT, T> r8) {
            return (T) getExtension(r8);
        }

        default <T> T getExtension(GeneratedExtension<MessageT, List<T>> r8, int r10) {
            return (T) getExtension(r8, r10);
        }
    }

    public interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        public interface FieldAccessor {
            void addRepeated(Builder<?> r8, Object r10);

            void clear(Builder<?> r8);

            Object get(Builder<?> r8);

            Object get(GeneratedMessage r8);

            Message.Builder getBuilder(Builder<?> r8);

            Object getRaw(GeneratedMessage r8);

            Object getRepeated(Builder<?> r8, int r10);

            Object getRepeated(GeneratedMessage r8, int r10);

            Message.Builder getRepeatedBuilder(Builder<?> r8, int r10);

            int getRepeatedCount(Builder<?> r8);

            int getRepeatedCount(GeneratedMessage r8);

            boolean has(Builder<?> r8);

            boolean has(GeneratedMessage r8);

            Message.Builder newBuilder();

            void set(Builder<?> r8, Object r10);

            void setRepeated(Builder<?> r8, int r10, Object r11);
        }

        public static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            public MapFieldAccessor(Descriptors.FieldDescriptor r8, Class<? extends GeneratedMessage> r10) {
                this.field = r8;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.access$1200(GeneratedMessage.access$1100(r10, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private Message coerceType(Message r8) {
                if (r8 != null) goto L6;
                return null;
            L6:
                if (this.mapEntryMessageDefaultInstance.getClass().isInstance(r8) == false) goto L9;
                return r8;
            L9:
                return this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(r8).build();
            }

            private MapFieldReflectionAccessor getMapField(Builder<?> r8) {
                return r8.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMutableMapField(Builder<?> r8) {
                return r8.internalGetMutableMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r8, Object r10) {
                getMutableMapField(r8).getMutableList().add(coerceType((Message) r10));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r8) {
                getMutableMapField(r8).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r8) {
                ArrayList r10 = new ArrayList();
                int r11 = 0;
            L4:
                if (r11 >= getRepeatedCount(r8)) goto L7;
                r10.add(getRepeated(r8, r11));
                r11 = r11 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r8) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r8) {
                return get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r8, int r10) {
                return getMapField(r8).getList().get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r8, int r10) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r8) {
                return getMapField(r8).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r8) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                clear(r8);
                Iterator r11 = ((List) r10).iterator();
            L4:
                if (r11.hasNext() == false) goto L6;
                addRepeated(r8, r11.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r8, int r10, Object r11) {
                getMutableMapField(r8).getMutableList().set(r10, coerceType((Message) r11));
            }

            private MapFieldReflectionAccessor getMapField(GeneratedMessage r8) {
                return r8.internalGetMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r8) {
                ArrayList r10 = new ArrayList();
                int r11 = 0;
            L4:
                if (r11 >= getRepeatedCount(r8)) goto L7;
                r10.add(getRepeated(r8, r11));
                r11 = r11 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r8, int r10) {
                return getMapField(r8).getList().get(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r8) {
                return getMapField(r8).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r8) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }
        }

        public interface OneofAccessor {
            void clear(Builder<?> r8);

            Descriptors.FieldDescriptor get(Builder<?> r8);

            Descriptors.FieldDescriptor get(GeneratedMessage r8);

            boolean has(Builder<?> r8);

            boolean has(GeneratedMessage r8);
        }

        public static class RealOneofAccessor implements OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            public RealOneofAccessor(Descriptors.Descriptor r8, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
                this.descriptor = r8;
                this.caseMethod = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r10, "Case"), new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.access$1100(r12, defpackage.b.d("get", r10, "Case"), new Class[0]);
                this.clearMethod = GeneratedMessage.access$1100(r12, defpackage.b.c("clear", r10), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r8) {
                GeneratedMessage.access$1200(this.clearMethod, r8, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r8) {
                int r10 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r8, new Object[0])).getNumber();
                if (r10 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r8) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r8, new Object[0])).getNumber() == 0) goto L6;
                return true;
            L6:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r8) {
                int r10 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r8, new Object[0])).getNumber();
                if (r10 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r8) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r8, new Object[0])).getNumber() == 0) goto L6;
                return true;
            L6:
                return false;
            }
        }

        public static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private final Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            public RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor r8, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
                super(r10, r11, r12);
                this.enumDescriptor = r8.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r13 = !r8.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r13;
                if (r13 == false) goto L6;
                String r14 = defpackage.b.d("get", r10, "Value");
                Class r15 = Integer.TYPE;
                this.getRepeatedValueMethod = GeneratedMessage.access$1100(r11, r14, new Class[]{r15});
                this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(r12, defpackage.b.d("get", r10, "Value"), new Class[]{r15});
                this.setRepeatedValueMethod = GeneratedMessage.access$1100(r12, defpackage.b.d("set", r10, "Value"), new Class[]{r15, r15});
                this.addRepeatedValueMethod = GeneratedMessage.access$1100(r12, defpackage.b.d("add", r10, "Value"), new Class[]{r15});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r8, Object r10) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.addRepeatedValueMethod, r8, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r10).getNumber())});
                return;
            L6:
                super.addRepeated(r8, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r10}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r8) {
                ArrayList r10 = new ArrayList();
                int r11 = getRepeatedCount(r8);
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L6;
                r10.add(getRepeated(r8, r12));
                r12 = r12 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r8, int r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, r8, new Object[]{Integer.valueOf(r10)})).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r8, r10), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r8, int r10, Object r11) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setRepeatedValueMethod, r8, new Object[]{Integer.valueOf(r10), Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber())});
                return;
            L6:
                super.setRepeated(r8, r10, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r11}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r8) {
                ArrayList r10 = new ArrayList();
                int r11 = getRepeatedCount(r8);
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L6;
                r10.add(getRepeated(r8, r12));
                r12 = r12 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r8, int r10) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r11 = ((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethod, r8, new Object[]{Integer.valueOf(r10)})).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r11);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r8, r10), new Object[0]);
            }
        }

        public static class RepeatedFieldAccessor implements FieldAccessor {
            protected final MethodInvoker invoker;
            protected final Class<?> type;

            public interface MethodInvoker {
                void addRepeated(Builder<?> r8, Object r10);

                void clear(Builder<?> r8);

                Object get(Builder<?> r8);

                Object get(GeneratedMessage r8);

                Object getRepeated(Builder<?> r8, int r10);

                Object getRepeated(GeneratedMessage r8, int r10);

                int getRepeatedCount(Builder<?> r8);

                int getRepeatedCount(GeneratedMessage r8);

                void setRepeated(Builder<?> r8, int r10, Object r11);
            }

            public static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method addRepeatedMethod;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getCountMethod;
                private final java.lang.reflect.Method getCountMethodBuilder;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method getRepeatedMethod;
                private final java.lang.reflect.Method getRepeatedMethodBuilder;
                private final java.lang.reflect.Method setRepeatedMethod;

                public ReflectionInvoker(String r8, Class<? extends GeneratedMessage> r10, Class<? extends Builder<?>> r11) {
                    this.getMethod = GeneratedMessage.access$1100(r10, defpackage.b.d("get", r8, "List"), new Class[0]);
                    this.getMethodBuilder = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r8, "List"), new Class[0]);
                    String r12 = defpackage.b.c("get", r8);
                    Class r13 = Integer.TYPE;
                    java.lang.reflect.Method r14 = GeneratedMessage.access$1100(r10, r12, new Class[]{r13});
                    this.getRepeatedMethod = r14;
                    this.getRepeatedMethodBuilder = GeneratedMessage.access$1100(r11, defpackage.b.c("get", r8), new Class[]{r13});
                    Class<?> r15 = r14.getReturnType();
                    this.setRepeatedMethod = GeneratedMessage.access$1100(r11, defpackage.b.c("set", r8), new Class[]{r13, r15});
                    this.addRepeatedMethod = GeneratedMessage.access$1100(r11, defpackage.b.c("add", r8), new Class[]{r15});
                    this.getCountMethod = GeneratedMessage.access$1100(r10, defpackage.b.d("get", r8, "Count"), new Class[0]);
                    this.getCountMethodBuilder = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r8, "Count"), new Class[0]);
                    this.clearMethod = GeneratedMessage.access$1100(r11, defpackage.b.c("clear", r8), new Class[0]);
                }

                public static /* synthetic */ java.lang.reflect.Method access$1400(ReflectionInvoker r8) {
                    return r8.getRepeatedMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(Builder<?> r8, Object r10) {
                    GeneratedMessage.access$1200(this.addRepeatedMethod, r8, new Object[]{r10});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(Builder<?> r8) {
                    GeneratedMessage.access$1200(this.clearMethod, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(Builder<?> r8) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(Builder<?> r8, int r10) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, r8, new Object[]{Integer.valueOf(r10)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(Builder<?> r8) {
                    return ((Integer) GeneratedMessage.access$1200(this.getCountMethodBuilder, r8, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(Builder<?> r8, int r10, Object r11) {
                    GeneratedMessage.access$1200(this.setRepeatedMethod, r8, new Object[]{Integer.valueOf(r10), r11});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r8) {
                    return GeneratedMessage.access$1200(this.getMethod, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(GeneratedMessage r8, int r10) {
                    return GeneratedMessage.access$1200(this.getRepeatedMethod, r8, new Object[]{Integer.valueOf(r10)});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(GeneratedMessage r8) {
                    return ((Integer) GeneratedMessage.access$1200(this.getCountMethod, r8, new Object[0])).intValue();
                }
            }

            public RepeatedFieldAccessor(String r8, Class<? extends GeneratedMessage> r10, Class<? extends Builder<?>> r11) {
                ReflectionInvoker r12 = new ReflectionInvoker(r8, r10, r11);
                this.type = ReflectionInvoker.access$1400(r12).getReturnType();
                this.invoker = getMethodInvoker(r12);
            }

            public static MethodInvoker getMethodInvoker(ReflectionInvoker r8) {
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r8, Object r10) {
                this.invoker.addRepeated(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r8) {
                this.invoker.clear(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r8) {
                return this.invoker.get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r8) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r8) {
                return get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r8, int r10) {
                return this.invoker.getRepeated(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r8, int r10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r8) {
                return this.invoker.getRepeatedCount(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r8) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                clear(r8);
                Iterator r11 = ((List) r10).iterator();
            L4:
                if (r11.hasNext() == false) goto L6;
                addRepeated(r8, r11.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r8, int r10, Object r11) {
                this.invoker.setRepeated(r8, r10, r11);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r8) {
                return this.invoker.get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r8, int r10) {
                return this.invoker.getRepeated(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r8) {
                return this.invoker.getRepeatedCount(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r8) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }
        }

        public static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public RepeatedMessageFieldAccessor(String r8, Class<? extends GeneratedMessage> r10, Class<? extends Builder<?>> r11) {
                super(r8, r10, r11);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r8, "Builder"), new Class[]{Integer.TYPE});
            }

            private Object coerceType(Object r8) {
                if (this.type.isInstance(r8) == false) goto L6;
                return r8;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r8).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r8, Object r10) {
                super.addRepeated(r8, coerceType(r10));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r8, int r10) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r8, new Object[]{Integer.valueOf(r10)});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r8, int r10, Object r11) {
                super.setRepeated(r8, r10, coerceType(r11));
            }
        }

        public static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private final Descriptors.EnumDescriptor enumDescriptor;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            public SingularEnumFieldAccessor(Descriptors.FieldDescriptor r8, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12, String r13) {
                super(r8, r10, r11, r12, r13);
                this.enumDescriptor = r8.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r14 = !r8.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = r14;
                if (r14 == false) goto L6;
                this.getValueMethod = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r10, "Value"), new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.access$1100(r12, defpackage.b.d("get", r10, "Value"), new Class[0]);
                this.setValueMethod = GeneratedMessage.access$1100(r12, defpackage.b.d("set", r10, "Value"), new Class[]{Integer.TYPE});
                return;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r8) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r10 = ((Integer) GeneratedMessage.access$1200(this.getValueMethodBuilder, r8, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r10);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r8), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setValueMethod, r8, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r10).getNumber())});
                return;
            L6:
                super.set(r8, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r10}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r8) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r10 = ((Integer) GeneratedMessage.access$1200(this.getValueMethod, r8, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r10);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r8), new Object[0]);
            }
        }

        public static class SingularFieldAccessor implements FieldAccessor {
            protected final Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final Class<?> type;

            public interface MethodInvoker {
                void clear(Builder<?> r8);

                Object get(Builder<?> r8);

                Object get(GeneratedMessage r8);

                int getOneofFieldNumber(Builder<?> r8);

                int getOneofFieldNumber(GeneratedMessage r8);

                boolean has(Builder<?> r8);

                boolean has(GeneratedMessage r8);

                void set(Builder<?> r8, Object r10);
            }

            public static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method caseMethod;
                private final java.lang.reflect.Method caseMethodBuilder;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method hasMethod;
                private final java.lang.reflect.Method hasMethodBuilder;
                private final java.lang.reflect.Method setMethod;

                public ReflectionInvoker(String r8, Class<? extends GeneratedMessage> r10, Class<? extends Builder<?>> r11, String r12, boolean r13, boolean r14) {
                    java.lang.reflect.Method r15 = GeneratedMessage.access$1100(r10, defpackage.b.c("get", r8), new Class[0]);
                    this.getMethod = r15;
                    this.getMethodBuilder = GeneratedMessage.access$1100(r11, defpackage.b.c("get", r8), new Class[0]);
                    this.setMethod = GeneratedMessage.access$1100(r11, defpackage.b.c("set", r8), new Class[]{r15.getReturnType()});
                    java.lang.reflect.Method r16 = null;
                    if (r14 == false) goto L5;
                    java.lang.reflect.Method r17 = GeneratedMessage.access$1100(r10, defpackage.b.c("has", r8), new Class[0]);
                L6:
                    this.hasMethod = r17;
                    if (r14 == false) goto L9;
                    java.lang.reflect.Method r18 = GeneratedMessage.access$1100(r11, defpackage.b.c("has", r8), new Class[0]);
                L10:
                    this.hasMethodBuilder = r18;
                    this.clearMethod = GeneratedMessage.access$1100(r11, defpackage.b.c("clear", r8), new Class[0]);
                    if (r13 == false) goto L13;
                    java.lang.reflect.Method r19 = GeneratedMessage.access$1100(r10, defpackage.b.d("get", r12, "Case"), new Class[0]);
                L14:
                    this.caseMethod = r19;
                    if (r13 == false) goto L17;
                    r16 = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r12, "Case"), new Class[0]);
                L17:
                    this.caseMethodBuilder = r16;
                    return;
                L13:
                    r19 = null;
                    goto L14
                L9:
                    r18 = null;
                    goto L10
                L5:
                    r17 = null;
                    goto L6
                }

                public static /* synthetic */ java.lang.reflect.Method access$1300(ReflectionInvoker r8) {
                    return r8.getMethod;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(Builder<?> r8) {
                    GeneratedMessage.access$1200(this.clearMethod, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(Builder<?> r8) {
                    return GeneratedMessage.access$1200(this.getMethodBuilder, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(Builder<?> r8) {
                    return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r8, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(Builder<?> r8) {
                    return ((Boolean) GeneratedMessage.access$1200(this.hasMethodBuilder, r8, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(Builder<?> r8, Object r10) {
                    GeneratedMessage.access$1200(this.setMethod, r8, new Object[]{r10});
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage r8) {
                    return GeneratedMessage.access$1200(this.getMethod, r8, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(GeneratedMessage r8) {
                    return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r8, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(GeneratedMessage r8) {
                    return ((Boolean) GeneratedMessage.access$1200(this.hasMethod, r8, new Object[0])).booleanValue();
                }
            }

            public SingularFieldAccessor(Descriptors.FieldDescriptor r10, String r11, Class<? extends GeneratedMessage> r12, Class<? extends Builder<?>> r13, String r14) {
                if (r10.getRealContainingOneof() == null) goto L5;
                boolean r8 = true;
            L6:
                boolean r15 = r8;
                this.isOneofField = r15;
                boolean r16 = r10.hasPresence();
                this.hasHasMethod = r16;
                ReflectionInvoker r17 = new ReflectionInvoker(r11, r12, r13, r14, r15, r16);
                this.field = r10;
                this.type = ReflectionInvoker.access$1300(r17).getReturnType();
                this.invoker = getMethodInvoker(r17);
                return;
            L5:
                r8 = false;
                goto L6
            }

            public static MethodInvoker getMethodInvoker(ReflectionInvoker r8) {
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> r8, Object r10) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> r8) {
                this.invoker.clear(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> r8) {
                return this.invoker.get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r8) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r8) {
                return get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> r8, int r10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> r8, int r10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> r8) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> r8) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r8) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r8).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                this.invoker.set(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> r8, int r10, Object r11) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r8) {
                return this.invoker.get(r8);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r8, int r10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r8) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r8) {
                if (this.hasHasMethod == true) goto L14;
                if (this.isOneofField == false) goto L12;
                if (this.invoker.getOneofFieldNumber(r8) == this.field.getNumber()) goto L15;
                return false;
            L15:
                return true;
            L12:
                return !get(r8).equals(this.field.getDefaultValue());
            L14:
                return this.invoker.has(r8);
            }
        }

        public static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public SingularMessageFieldAccessor(Descriptors.FieldDescriptor r8, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12, String r13) {
                super(r8, r10, r11, r12, r13);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r12, defpackage.b.d("get", r10, "Builder"), new Class[0]);
            }

            private Object coerceType(Object r8) {
                if (this.type.isInstance(r8) == false) goto L6;
                return r8;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r8).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> r8) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r8, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                super.set(r8, coerceType(r10));
            }
        }

        public static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            public SingularStringFieldAccessor(Descriptors.FieldDescriptor r8, String r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12, String r13) {
                super(r8, r10, r11, r12, r13);
                this.getBytesMethod = GeneratedMessage.access$1100(r11, defpackage.b.d("get", r10, "Bytes"), new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.access$1100(r12, defpackage.b.d("set", r10, "Bytes"), new Class[]{ByteString.class});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r8) {
                return GeneratedMessage.access$1200(this.getBytesMethod, r8, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> r8, Object r10) {
                if ((r10 instanceof ByteString) == false) goto L5;
                GeneratedMessage.access$1200(this.setBytesMethodBuilder, r8, new Object[]{r10});
                return;
            L5:
                super.set(r8, r10);
            }
        }

        public static class SyntheticOneofAccessor implements OneofAccessor {
            private final Descriptors.FieldDescriptor fieldDescriptor;

            public SyntheticOneofAccessor(Descriptors.Descriptor r8, int r10) {
                this.fieldDescriptor = r8.getOneof(r10).getField(0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> r8) {
                r8.clearField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> r8) {
                if (r8.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> r8) {
                return r8.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage r8) {
                if (r8.hasField(this.fieldDescriptor) == true) goto L7;
                return null;
            L7:
                return this.fieldDescriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage r8) {
                return r8.hasField(this.fieldDescriptor);
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor r8, String[] r10) {
            this.descriptor = r8;
            this.camelCaseNames = r10;
            this.fields = new FieldAccessor[r8.getFieldCount()];
            this.oneofs = new OneofAccessor[r8.getOneofCount()];
            this.initialized = false;
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable r8) {
            return r8.descriptor;
        }

        public static /* synthetic */ OneofAccessor access$100(FieldAccessorTable r8, Descriptors.OneofDescriptor r10) {
            return r8.getOneof(r10);
        }

        public static /* synthetic */ FieldAccessor access$200(FieldAccessorTable r8, Descriptors.FieldDescriptor r10) {
            return r8.getField(r10);
        }

        private FieldAccessor getField(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != this.descriptor) goto L11;
            if (r8.isExtension() == true) goto L9;
            return this.fields[r8.getIndex()];
        L9:
            throw new IllegalArgumentException("This type does not have extensions.");
        L11:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private OneofAccessor getOneof(Descriptors.OneofDescriptor r8) {
            if (r8.getContainingType() != this.descriptor) goto L7;
            return this.oneofs[r8.getIndex()];
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
            int r8 = this.fields.length;     // Catch: Throwable -> L51
            int r10 = 0;
            int r11 = 0;
        L11:
            String r14 = null;
            if (r11 >= r8) goto L42;
            Descriptors.FieldDescriptor r15 = this.descriptor.getField(r11);     // Catch: Throwable -> L51
            if (r15.getContainingOneof() == null) goto L18;
            int r16 = r15.getContainingOneof().getIndex() + r8;     // Catch: Throwable -> L51
            String[] r17 = this.camelCaseNames;     // Catch: Throwable -> L51
            if (r16 >= r17.length) goto L18;
            r14 = r17[r16];     // Catch: Throwable -> L51
        L18:
            String r18 = r14;
            if (r15.isRepeated() == false) goto L31;
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L27;
            if (r15.isMapField() == false) goto L25;
            this.fields[r11] = new MapFieldAccessor(r15, r12);     // Catch: Throwable -> L51
        L40:
            r11 = r11 + 1;     // Catch: Throwable -> L51
            goto L11
        L25:
            this.fields[r11] = new RepeatedMessageFieldAccessor(this.camelCaseNames[r11], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L27:
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L29;
            this.fields[r11] = new RepeatedEnumFieldAccessor(r15, this.camelCaseNames[r11], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L29:
            this.fields[r11] = new RepeatedFieldAccessor(this.camelCaseNames[r11], r12, r13);     // Catch: Throwable -> L51
            goto L40
        L31:
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            this.fields[r11] = new SingularMessageFieldAccessor(r15, this.camelCaseNames[r11], r12, r13, r18);     // Catch: Throwable -> L51
            goto L40
        L34:
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L37;
            this.fields[r11] = new SingularEnumFieldAccessor(r15, this.camelCaseNames[r11], r12, r13, r18);     // Catch: Throwable -> L51
            goto L40
        L37:
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L39;
            this.fields[r11] = new SingularStringFieldAccessor(r15, this.camelCaseNames[r11], r12, r13, r18);     // Catch: Throwable -> L51
            goto L40
        L39:
            this.fields[r11] = new SingularFieldAccessor(r15, this.camelCaseNames[r11], r12, r13, r18);     // Catch: Throwable -> L51
        L42:
            if (r10 >= this.descriptor.getOneofCount()) goto L48;
            if (r10 >= this.descriptor.getRealOneofCount()) goto L46;
            this.oneofs[r10] = new RealOneofAccessor(this.descriptor, this.camelCaseNames[r10 + r8], r12, r13);     // Catch: Throwable -> L51
        L47:
            r10 = r10 + 1;     // Catch: Throwable -> L51
            goto L42
        L46:
            this.oneofs[r10] = new SyntheticOneofAccessor(this.descriptor, r10);     // Catch: Throwable -> L51
            goto L47
        L48:
            this.initialized = true;     // Catch: Throwable -> L51
            this.camelCaseNames = null;     // Catch: Throwable -> L51
            monitor-exit(this);     // Catch: Throwable -> L51
            return this;
        }

        public FieldAccessorTable(Descriptors.Descriptor r8, String[] r10, Class<? extends GeneratedMessage> r11, Class<? extends Builder<?>> r12) {
            this(r8, r10);
            ensureFieldAccessorsInitialized(r11, r12);
        }
    }

    public static class GeneratedExtension<ContainingT extends Message, T> extends Extension<ContainingT, T> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class<?> singularType;

        public GeneratedExtension(ExtensionDescriptorRetriever r8, Class<?> r10, Message r11, Extension.ExtensionType r12) {
            if (Message.class.isAssignableFrom(r10) == true) goto L5;
        L9:
            this.descriptorRetriever = r8;
            this.singularType = r10;
            this.messageDefaultInstance = r11;
            if (ProtocolMessageEnum.class.isAssignableFrom(r10) == false) goto L12;
            this.enumValueOf = GeneratedMessage.access$1100(r10, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
            java.lang.reflect.Method r13 = GeneratedMessage.access$1100(r10, "getValueDescriptor", new Class[0]);
        L13:
            this.enumGetValueDescriptor = r13;
            this.extensionType = r12;
            return;
        L12:
            r13 = null;
            this.enumValueOf = null;
            goto L13
        L5:
            if (r10.isInstance(r11) == true) goto L9;
            throw new IllegalArgumentException("Bad messageDefaultInstance for ".concat(r10.getName()));
        }

        @Override // com.google.protobuf.Extension
        public Object fromReflectionType(Object r8) {
            Descriptors.FieldDescriptor r10 = getDescriptor();
            if (r10.isRepeated() == false) goto L17;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        L10:
            ProtobufArrayList r11 = new ProtobufArrayList();
            List r12 = (List) r8;
            r11.ensureCapacity(r12.size());
            Iterator r13 = r12.iterator();
        L12:
            if (r13.hasNext() == false) goto L14;
            r11.add(singularFromReflectionType(r13.next()));
            goto L12
        L14:
            r11.makeImmutable();
            return r11;
        L7:
            if (r10.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L10;
            return r8;
        L17:
            return singularFromReflectionType(r8);
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
            ExtensionDescriptorRetriever r8 = this.descriptorRetriever;
            if (r8 == null) goto L7;
            return r8.getDescriptor();
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

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        public void internalInit(final Descriptors.FieldDescriptor r8) {
            if (this.descriptorRetriever != null) goto L7;
            this.descriptorRetriever = new AnonymousClass1(this, r8);
            return;
        L7:
            throw new IllegalStateException("Already initialized.");
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.Extension
        public Object singularFromReflectionType(Object r8) {
            Descriptors.FieldDescriptor r10 = getDescriptor();
            int r11 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[r10.getJavaType().ordinal()];
            if (r11 == 1) goto L10;
            if (r11 == 2) goto L8;
            return r8;
        L8:
            return GeneratedMessage.access$1200(this.enumValueOf, null, new Object[]{r8});
        L10:
            if (this.singularType.isInstance(r8) == false) goto L13;
            return r8;
        L13:
            return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) r8).build();
        }

        @Override // com.google.protobuf.Extension
        public Object singularToReflectionType(Object r8) {
            Descriptors.FieldDescriptor r10 = getDescriptor();
            if (AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[r10.getJavaType().ordinal()] == 2) goto L6;
            return r8;
        L6:
            return GeneratedMessage.access$1200(this.enumGetValueDescriptor, r8, new Object[0]);
        }

        @Override // com.google.protobuf.Extension
        public Object toReflectionType(Object r8) {
            Descriptors.FieldDescriptor r10 = getDescriptor();
            if (r10.isRepeated() == false) goto L13;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L11;
            ArrayList r11 = new ArrayList();
            Iterator r12 = ((List) r8).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(singularToReflectionType(r12.next()));
            goto L8
        L10:
            return r11;
        L11:
            return r8;
        L13:
            return singularToReflectionType(r8);
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
            return getMessageDefaultInstance();
        }
    }

    public static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = null;

        static {
            INSTANCE = new UnusedPrivateParameter();
        }

        private UnusedPrivateParameter() {
        }
    }

    static {
        logger = Logger.getLogger(GeneratedMessage.class.getName());
        alwaysUseFieldBuilders = false;
        loggedPre22TypeNames = new CopyOnWriteArraySet();
    }

    public GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    public static /* synthetic */ java.lang.reflect.Method access$1100(Class r8, String r10, Class[] r11) {
        return getMethodOrDie(r8, r10, r11);
    }

    public static /* synthetic */ Object access$1200(java.lang.reflect.Method r8, Object r10, Object[] r11) {
        return invokeOrDie(r8, r10, r11);
    }

    public static /* synthetic */ Extension access$500(ExtensionLite r8) {
        return checkNotLite(r8);
    }

    public static /* synthetic */ Map access$800(GeneratedMessage r8, boolean r10) {
        return r8.getAllFieldsMutable(r10);
    }

    public static boolean canUseUnsafe() {
        if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
    L7:
        return false;
    L5:
        if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
        return true;
    }

    private static <MessageT extends ExtendableMessage<MessageT>, T> Extension<MessageT, T> checkNotLite(ExtensionLite<? extends MessageT, T> r8) {
        if (r8.isLite() == true) goto L7;
        return (Extension) r8;
    L7:
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    public static int computeStringSize(int r8, Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSize(r8, (String) r10);
    L7:
        return CodedOutputStream.computeBytesSize(r8, (ByteString) r10);
    }

    public static int computeStringSizeNoTag(Object r8) {
        if ((r8 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSizeNoTag((String) r8);
    L7:
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r8);
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

    public static <T> Internal.ProtobufList<T> emptyList(Class<T> r8) {
        return ProtobufArrayList.emptyList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean r8) {
        TreeMap r10 = new TreeMap();
        List<Descriptors.FieldDescriptor> r11 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L25;
        Descriptors.FieldDescriptor r13 = r11.get(r12);
        Descriptors.OneofDescriptor r14 = r13.getContainingOneof();
        if (r14 == null) goto L12;
        r12 = r12 + (r14.getFieldCount() - 1);
        if (hasOneof(r14) == false) goto L24;
        r13 = getOneofFieldDescriptor(r14);
    L19:
        if (r8 == true) goto L21;
    L23:
        Object r15 = getField(r13);
    L15:
        r10.put(r13, r15);
        goto L24
    L21:
        if (r13.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L23;
        r15 = getFieldRaw(r13);
    L24:
        r12 = r12 + 1;
        goto L4
    L12:
        if (r13.isRepeated() == false) goto L17;
        List r16 = (List) getField(r13);
        boolean r17 = r16.isEmpty();
        r15 = r16;
        if (r17 == true) goto L24;
    L17:
        if (hasField(r13) == true) goto L19;
    L25:
        return r10;
    }

    private static java.lang.reflect.Method getMethodOrDie(Class<?> r8, String r10, Class<?>... r11) {
        return r8.getMethod(r10, r11);
    L4:
        e = move-exception;
        throw new IllegalStateException("Generated message class \"" + r8.getName() + "\" missing method \"" + r10 + "\".", e);
    }

    @CanIgnoreReturnValue
    private static Object invokeOrDie(java.lang.reflect.Method r8, Object r10, Object... r11) {
        return r8.invoke(r10, r11);
    L15:
        e = move-exception;
        throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r12 = e.getCause();
        if ((r12 instanceof RuntimeException) == true) goto L14;
        if ((r12 instanceof Error) == false) goto L12;
        throw ((Error) r12);
    L12:
        throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", r12);
    L14:
        throw ((RuntimeException) r12);
    }

    public static boolean isStringEmpty(Object r8) {
        if ((r8 instanceof String) == false) goto L7;
        return ((String) r8).isEmpty();
    L7:
        return ((ByteString) r8).isEmpty();
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r8) {
        return (ListT) makeMutableCopy(r8, 0);
    }

    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream r8, Map<Boolean, V> r10, MapEntry<Boolean, V> r11, int r12, boolean r13) {
        if (r10.containsKey(Boolean.valueOf(r13)) == false) goto L6;
        r8.writeMessage(r12, r11.newBuilderForType().setKey(Boolean.valueOf(r13)).setValue(r10.get(Boolean.valueOf(r13))).build());
        return;
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newFileScopedGeneratedExtension(Class<?> r8, Message r10) {
        return new GeneratedExtension(null, r8, r10, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newMessageScopedGeneratedExtension(final Message r8, final int r10, Class<?> r11, Message r12) {
        return new GeneratedExtension(new AnonymousClass1(r8, r10), r11, r12, Extension.ExtensionType.IMMUTABLE);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r8, InputStream r10) {
        return r8.parseDelimitedFrom(r10);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r8, CodedInputStream r10) {
        return r8.parseFrom(r10);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <V> void serializeBooleanMapTo(CodedOutputStream r8, MapField<Boolean, V> r10, MapEntry<Boolean, V> r11, int r12) {
        Map<Boolean, V> r13 = r10.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r13, r11, r12);
        return;
    L6:
        maybeSerializeBooleanEntryTo(r8, r13, r11, r12, false);
        maybeSerializeBooleanEntryTo(r8, r13, r11, r12, true);
    }

    public static <V> void serializeIntegerMapTo(CodedOutputStream r8, MapField<Integer, V> r10, MapEntry<Integer, V> r11, int r12) {
        Map<Integer, V> r13 = r10.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r13, r11, r12);
        return;
    L6:
        int r14 = r13.size();
        int[] r15 = new int[r14];
        Iterator<Integer> r16 = r13.keySet().iterator();
        int r17 = 0;
        int r18 = 0;
    L8:
        if (r16.hasNext() == false) goto L10;
        r15[r18] = r16.next().intValue();
        r18 = r18 + 1;
        goto L8
    L10:
        Arrays.sort(r15);
    L11:
        if (r17 >= r14) goto L13;
        int r19 = r15[r17];
        r8.writeMessage(r12, r11.newBuilderForType().setKey(Integer.valueOf(r19)).setValue(r13.get(Integer.valueOf(r19))).build());
        r17 = r17 + 1;
        goto L11
    }

    public static <V> void serializeLongMapTo(CodedOutputStream r8, MapField<Long, V> r10, MapEntry<Long, V> r11, int r12) {
        Map<Long, V> r13 = r10.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r13, r11, r12);
        return;
    L6:
        int r14 = r13.size();
        long[] r15 = new long[r14];
        Iterator<Long> r16 = r13.keySet().iterator();
        int r17 = 0;
        int r18 = 0;
    L8:
        if (r16.hasNext() == false) goto L10;
        r15[r18] = r16.next().longValue();
        r18 = r18 + 1;
        goto L8
    L10:
        Arrays.sort(r15);
    L11:
        if (r17 >= r14) goto L13;
        long r19 = r15[r17];
        r8.writeMessage(r12, r11.newBuilderForType().setKey(Long.valueOf(r19)).setValue(r13.get(Long.valueOf(r19))).build());
        r17 = r17 + 1;
        goto L11
    }

    private static <K, V> void serializeMapTo(CodedOutputStream r8, Map<K, V> r10, MapEntry<K, V> r11, int r12) {
        Iterator<Map.Entry<K, V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<K, V> r14 = r13.next();
        r8.writeMessage(r12, r11.newBuilderForType().setKey(r14.getKey()).setValue(r14.getValue()).build());
        goto L4
    }

    public static <V> void serializeStringMapTo(CodedOutputStream r8, MapField<String, V> r10, MapEntry<String, V> r11, int r12) {
        Map<String, V> r13 = r10.getMap();
        if (r8.isSerializationDeterministic() == true) goto L6;
        serializeMapTo(r8, r13, r11, r12);
        return;
    L6:
        String[] r14 = new String[r13.size()];
        String[] r15 = (String[]) r13.keySet().toArray(r14);
        Arrays.sort(r15);
        int r16 = r15.length;
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L9;
        String r18 = r15[r17];
        r8.writeMessage(r12, r11.newBuilderForType().setKey(r18).setValue(r13.get(r18)).build());
        r17 = r17 + 1;
        goto L7
    }

    public static void setAlwaysUseFieldBuildersForTesting(boolean r8) {
        alwaysUseFieldBuilders = r8;
    }

    public static void warnPre22Gencode(Class<?> r8) {
        if (System.getProperty(PRE22_GENCODE_SILENCE_PROPERTY) == null) goto L5;
        return;
    L5:
        String r10 = r8.getName();
        String r11 = defpackage.b.d("Vulnerable protobuf generated type in use: ", r10, "\nAs of 2022/09/29 (release 21.7) makeExtensionsImmutable should not be called from protobuf gencode. If you are seeing this message, your gencode is vulnerable to a denial of service attack. You should regenerate your code using protobuf 25.6 or later. Use the latest version that meets your needs. However, if you understand the risks and wish to continue with vulnerable gencode, you can set the system property `-Dcom.google.protobuf.use_unsafe_pre22_gencode` on the command line to silence this warning. You also can set `-Dcom.google.protobuf.error_on_unsafe_pre22_gencode` to throw an error instead. See security vulnerability: https://github.com/protocolbuffers/protobuf/security/advisories/GHSA-h4h5-3hr4-j3g2");
        if (System.getProperty(PRE22_GENCODE_ERROR_PROPERTY) != null) goto L13;
        if (loggedPre22TypeNames.add(r10) == true) goto L10;
        return;
    L10:
        logger.warning(r11);
        return;
    L13:
        throw new UnsupportedOperationException(r11);
    }

    public static void writeString(CodedOutputStream r8, int r10, Object r11) {
        if ((r11 instanceof String) == false) goto L5;
        r8.writeString(r10, (String) r11);
        return;
    L5:
        r8.writeBytes(r10, (ByteString) r11);
    }

    public static void writeStringNoTag(CodedOutputStream r8, Object r10) {
        if ((r10 instanceof String) == false) goto L5;
        r8.writeStringNoTag((String) r10);
        return;
    L5:
        r8.writeBytesNoTag((ByteString) r10);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r8) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).get(this);
    }

    public Object getFieldRaw(Descriptors.FieldDescriptor r8) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r8).get(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRepeated(this, r10);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        this.memoizedSize = r10;
        return r10;
    }

    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r8) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r8).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r8) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r8).has(this);
    }

    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    @Deprecated
    public MapField internalGetMapField(int r8) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public MapFieldReflectionAccessor internalGetMapFieldReflection(int r8) {
        return internalGetMapField(r8);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        Iterator<Descriptors.FieldDescriptor> r8 = getDescriptorForType().getFields().iterator();
    L4:
        if (r8.hasNext() == false) goto L25;
        Descriptors.FieldDescriptor r10 = r8.next();
        if (r10.isRequired() == false) goto L11;
        if (hasField(r10) == true) goto L11;
        return false;
    L11:
        if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
        if (r10.isRepeated() == true) goto L14;
        if (hasField(r10) == false) goto L4;
        if (((Message) getField(r10)).isInitialized() == true) goto L4;
        return false;
    L14:
        Iterator r11 = ((List) getField(r10)).iterator();
    L16:
        if (r11.hasNext() == false) goto L4;
        if (((Message) r11.next()).isInitialized() == true) goto L16;
        return false;
    L25:
        return true;
    }

    public void makeExtensionsImmutable() {
        warnPre22Gencode(getClass());
    }

    @Deprecated
    public void mergeFromAndMakeImmutableInternal(CodedInputStream r8, ExtensionRegistryLite r10) {
        Schema r11 = Protobuf.getInstance().schemaFor(this);
        r11.mergeFrom(this, CodedInputStreamReader.forCodedInput(r8), r10);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        r11.makeImmutable(this);
        return;
    L9:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L6:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    public Object newInstance(UnusedPrivateParameter r8) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public boolean parseUnknownField(CodedInputStream r8, UnknownFieldSet.Builder r10, ExtensionRegistryLite r11, int r12) {
        if (r8.shouldDiscardUnknownFields() == false) goto L7;
        return r8.skipField(r12);
    L7:
        return r10.mergeFieldFrom(r12, r8);
    }

    public boolean parseUnknownFieldProto3(CodedInputStream r8, UnknownFieldSet.Builder r10, ExtensionRegistryLite r11, int r12) {
        return parseUnknownField(r8, r10, r11, r12);
    }

    public void setUnknownFields(UnknownFieldSet r8) {
        this.unknownFields = r8;
    }

    public Object writeReplace() {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), r8, false);
    }

    public GeneratedMessage(Builder<?> r8) {
        this.unknownFields = r8.getUnknownFields();
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT r8, int r10) {
        int r11 = r8.size();
        if (r10 > r11) goto L5;
        r10 = r11 * 2;
    L5:
        if (r10 > 0) goto L8;
        r10 = 10;
    L8:
        return (ListT) r8.mutableCopyWithCapacity(r10);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r8, InputStream r10, ExtensionRegistryLite r11) {
        return r8.parseDelimitedFrom(r10, r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r8, CodedInputStream r10, ExtensionRegistryLite r11) {
        return r8.parseFrom(r10, r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r8, InputStream r10) {
        return r8.parseFrom(r10);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r8, InputStream r10, ExtensionRegistryLite r11) {
        return r8.parseFrom(r10, r11);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }
}
