package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

        private void buildPartial0(EnumValue r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            EnumValue.access$402(r8, this.name_);
        L6:
            if ((r10 & 2) == 0) goto L9;
            EnumValue.access$502(r8, this.number_);
            return;
        }

        private void buildPartialRepeatedFields(EnumValue r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            EnumValue.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L7:
            r11 = this.options_;
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
            List<Option> r8 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.optionsBuilder_;
        }

        public Builder addAllOptions(Iterable<? extends Option> r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue build() {
            EnumValue r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue buildPartial() {
            EnumValue r8 = new EnumValue(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public EnumValue getDefaultInstanceForType() {
            return EnumValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public Option getOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.options_.get(r8);
        L6:
            return (Option) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r8);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.options_.get(r8);
        L6:
            return (OptionOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
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
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder removeOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setName(String r8) {
            if (r8 == null) goto L6;
            this.name_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.name_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNumber(int r8) {
            this.number_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.options_ = Collections.emptyList();
        }

        public Builder addOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Option.Builder addOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r8, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.number_ = 0;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -5;
            return this;
        L5:
            this.options_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addOptions(Option.Builder r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addOptions(Option r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r12 == 0) goto L23;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.number_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (r12 != 26) goto L14;
            Option r13 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r14 = this.optionsBuilder_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r14 == null) goto L18;
            r14.addMessage(r13);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L18:
            ensureOptionsIsMutable();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.options_.add(r13);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L23:
            r11 = true;
            goto L4
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L31:
            onChanged();
            return this;
        L34:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder mergeFrom(EnumValue r8) {
            if (r8 != EnumValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L9;
            this.name_ = EnumValue.access$400(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.getNumber() == 0) goto L12;
            setNumber(r8.getNumber());
        L12:
            if (this.optionsBuilder_ != null) goto L21;
            if (EnumValue.access$300(r8).isEmpty() == false) goto L16;
        L29:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L16:
            if (this.options_.isEmpty() == false) goto L18;
            this.options_ = EnumValue.access$300(r8);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L29
        L18:
            ensureOptionsIsMutable();
            this.options_.addAll(EnumValue.access$300(r8));
            goto L19
        L21:
            if (EnumValue.access$300(r8).isEmpty() == true) goto L29;
            if (this.optionsBuilder_.isEmpty() == false) goto L28;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = null;
            this.optionsBuilder_ = null;
            this.options_ = EnumValue.access$300(r8);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L27;
            r10 = internalGetOptionsFieldBuilder();
        L27:
            this.optionsBuilder_ = r10;
            goto L29
        L28:
            this.optionsBuilder_.addAllMessages(EnumValue.access$300(r8));
            goto L29
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof EnumValue) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((EnumValue) r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "EnumValue");
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

    public static /* synthetic */ List access$300(EnumValue r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$302(EnumValue r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(EnumValue r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$402(EnumValue r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(EnumValue r8, int r10) {
        r8.number_ = r10;
        return r10;
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

    public static EnumValue parseDelimitedFrom(InputStream r8) {
        return (EnumValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static EnumValue parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof EnumValue) == false) goto L8;
        EnumValue r10 = (EnumValue) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (getNumber() == r10.getNumber()) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
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
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
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
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r12 = this.number_;
        if (r12 == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeInt32Size(2, r12);
    L13:
        if (r10 >= this.options_.size()) goto L15;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.options_.get(r10));
        r10 = r10 + 1;
        goto L13
    L15:
        int r13 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = (((getDescriptor().hashCode() + 779) * 37) + 1) * 53;
        int r11 = (((getName().hashCode() + r10) * 37) + 2) * 53;
        int r12 = getNumber() + r11;
        if (getOptionsCount() <= 0) goto L8;
        r12 = defpackage.b.a(r12, 37, 3, 53) + getOptionsList().hashCode();
    L8:
        int r13 = getUnknownFields().hashCode();
        int r14 = r13 + (r12 * 29);
        this.memoizedHashCode = r14;
        return r14;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.memoizedIsInitialized;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L5:
        int r10 = this.number_;
        if (r10 == 0) goto L8;
        r8.writeInt32(2, r10);
    L8:
        int r11 = 0;
    L10:
        if (r11 >= this.options_.size()) goto L12;
        r8.writeMessage(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L10
    L12:
        getUnknownFields().writeTo(r8);
    }

    private EnumValue(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.number_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(EnumValue r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static EnumValue parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (EnumValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static EnumValue parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ EnumValue(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static EnumValue parseFrom(CodedInputStream r8) {
        return (EnumValue) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static EnumValue parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (EnumValue) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    public static EnumValue parseFrom(InputStream r8) {
        return (EnumValue) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static EnumValue parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (EnumValue) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static EnumValue parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static EnumValue parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static EnumValue parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static EnumValue parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
