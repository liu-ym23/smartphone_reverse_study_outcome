package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class EnumValue extends GeneratedMessage implements EnumValueOrBuilder {
    private static final EnumValue DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<EnumValue> PARSER = null;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private List<Option> options_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumValueOrBuilder {
        private int bitField0_;
        private Object name_;
        private int number_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;

        private Builder() {
            this.name_ = "";
            this.options_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.name_ = "";
            this.options_ = Collections.emptyList();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(EnumValue r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            EnumValue.access$402(r3, this.name_);
        L6:
            if ((r0 & 2) == 0) goto L9;
            EnumValue.access$502(r3, this.number_);
            return;
        }

        private void buildPartialRepeatedFields(EnumValue r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            EnumValue.access$302(r2, r1);
            return;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L7:
            r1 = this.options_;
            goto L9
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r1 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.optionsBuilder_;
        }

        public Builder addAllOptions(Iterable<? extends Option> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addOptions(Option.Builder r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addOptions(Option r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureOptionsIsMutable();
            this.options_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public Option.Builder addOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(r2, Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue build() {
            EnumValue r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue buildPartial() {
            EnumValue r0 = new EnumValue(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.number_ = 0;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -5;
            return this;
        L5:
            this.options_ = null;
            r0.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearName() {
            this.name_ = EnumValue.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumValue getDefaultInstanceForType() {
            return EnumValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public Option getOptions(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (Option) ZeusTransformUtils.preCheckCast(r2, Option.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().getBuilder(r2), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(r2, OptionOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L30;
            int r1 = r5.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            if (r1 == 0) goto L22;
            if (r1 != 10) goto L9;
            this.name_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r1 != 16) goto L11;
            this.number_ = r5.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L11:
            if (r1 != 26) goto L13;
            Option r2 = (Option) ZeusTransformUtils.preCheckCast(r5.readMessage(Option.parser(), r6), Option.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            if (r3 == null) goto L17;
            r3.addMessage(r2);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L17:
            ensureOptionsIsMutable();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.options_.add(r2);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L13:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L22:
            r0 = true;
            goto L3
        L25:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            onChanged();
            throw th;
        L30:
            onChanged();
            return this;
        }

        public Builder mergeFrom(EnumValue r3) {
            if (r3 != EnumValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r3.getName().isEmpty() == true) goto L9;
            this.name_ = EnumValue.access$400(r3);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r3.getNumber() == 0) goto L12;
            setNumber(r3.getNumber());
        L12:
            if (this.optionsBuilder_ != null) goto L21;
            if (EnumValue.access$300(r3).isEmpty() == false) goto L16;
        L29:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        L16:
            if (this.options_.isEmpty() == false) goto L18;
            this.options_ = EnumValue.access$300(r3);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L29
        L18:
            ensureOptionsIsMutable();
            this.options_.addAll(EnumValue.access$300(r3));
            goto L19
        L21:
            if (EnumValue.access$300(r3).isEmpty() == true) goto L29;
            if (this.optionsBuilder_.isEmpty() == false) goto L28;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = null;
            this.optionsBuilder_ = null;
            this.options_ = EnumValue.access$300(r3);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L27;
            r0 = internalGetOptionsFieldBuilder();
        L27:
            this.optionsBuilder_ = r0;
            goto L29
        L28:
            this.optionsBuilder_.addAllMessages(EnumValue.access$300(r3));
            goto L29
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, EnumValue.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((EnumValue) ZeusTransformUtils.preCheckCast(r4, EnumValue.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public Builder removeOptions(int r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder setName(String r1) {
            Objects.requireNonNull(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNumber(int r1) {
            this.number_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", EnumValue.class.getName());
        DEFAULT_INSTANCE = new EnumValue();
        PARSER = new AnonymousClass1();
    }

    private EnumValue() {
        this.name_ = "";
        this.number_ = 0;
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.options_ = Collections.emptyList();
    }

    private EnumValue(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.name_ = "";
        this.number_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ EnumValue(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ List access$300(EnumValue r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$302(EnumValue r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ Object access$400(EnumValue r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$402(EnumValue r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ int access$502(EnumValue r0, int r1) {
        r0.number_ = r1;
        return r1;
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(EnumValue r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static EnumValue parseDelimitedFrom(InputStream r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(ByteString r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(CodedInputStream r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(InputStream r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(ByteBuffer r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(byte[] r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static EnumValue parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (EnumValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), EnumValue.class, "com.obric.memorydata.plugin");
    }

    public static Parser<EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EnumValue.class) == false) goto L8;
        EnumValue r6 = (EnumValue) ZeusTransformUtils.preCheckCast(r5, EnumValue.class, "com.obric.memorydata.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getNumber() == r6.getNumber()) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EnumValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r2 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r3 = this.number_;
        if (r3 == 0) goto L13;
        r2 = r2 + CodedOutputStream.computeInt32Size(2, r3);
    L13:
        if (r1 >= this.options_.size()) goto L15;
        r2 = r2 + CodedOutputStream.computeMessageSize(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r1), MessageLite.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L13
    L15:
        int r4 = r2 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r4;
        return r4;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getNumber();
        if (getOptionsCount() <= 0) goto L9;
        r0 = (((r0 * 37) + 3) * 53) + getOptionsList().hashCode();
    L9:
        int r1 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r6, 1, this.name_);
    L5:
        int r0 = this.number_;
        if (r0 == 0) goto L8;
        r6.writeInt32(2, r0);
    L8:
        int r1 = 0;
    L10:
        if (r1 >= this.options_.size()) goto L12;
        r6.writeMessage(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r1), MessageLite.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L10
    L12:
        getUnknownFields().writeTo(r6);
    }
}
