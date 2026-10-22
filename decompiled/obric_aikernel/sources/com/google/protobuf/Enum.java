package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Enum extends GeneratedMessage implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 6;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> enumvalueBuilder_;
        private List<EnumValue> enumvalue_;
        private Object name_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        private Builder() {
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Enum r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            Enum.access$502(r10, this.name_);
        L5:
            int r12 = 0;
            if ((r11 & 8) == 0) goto L13;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L10;
            SourceContext r14 = this.sourceContext_;
        L11:
            Enum.access$602(r10, r14);
            r12 = 1;
            goto L13
        L10:
            r14 = (SourceContext) r13.build();
        L13:
            if ((r11 & 16) == 0) goto L16;
            Enum.access$702(r10, this.syntax_);
        L16:
            if ((r11 & 32) == 0) goto L18;
            Enum.access$802(r10, this.edition_);
        L18:
            Enum.access$976(r10, r12);
        }

        private void buildPartialRepeatedFields(Enum r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            Enum.access$302(r10, r12);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r13 = this.optionsBuilder_;
            if (r13 == null) goto L12;
            List r14 = r13.build();
        L16:
            Enum.access$402(r10, r14);
            return;
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            r14 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            this.bitField0_ &= -3;
        L7:
            r12 = this.enumvalue_;
            goto L9
        }

        private void ensureEnumvalueIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.enumvalue_ = new ArrayList(this.enumvalue_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        private RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> internalGetEnumvalueFieldBuilder() {
            if (this.enumvalueBuilder_ != null) goto L10;
            List<EnumValue> r10 = this.enumvalue_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.enumvalueBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.enumvalue_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.enumvalueBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.optionsBuilder_;
        }

        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> internalGetSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ != null) goto L6;
            this.sourceContextBuilder_ = new SingleFieldBuilder(getSourceContext(), getParentForChildren(), isClean());
            this.sourceContext_ = null;
        L6:
            return this.sourceContextBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetEnumvalueFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            return;
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.enumvalue_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllOptions(Iterable<? extends Option> r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addEnumvalue(int r10, EnumValue.Builder r11) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addEnumvalue(int r10, EnumValue r11) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addEnumvalue(EnumValue.Builder r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addEnumvalue(EnumValue r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public EnumValue.Builder addEnumvalueBuilder() {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
        }

        public EnumValue.Builder addEnumvalueBuilder(int r10) {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().addBuilder(r10, EnumValue.getDefaultInstance());
        }

        public Builder addOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addOptions(Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addOptions(Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureOptionsIsMutable();
            this.options_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r10, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum build() {
            Enum r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
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
        public Enum buildPartial() {
            Enum r10 = new Enum(this, null);
            buildPartialRepeatedFields(r10);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            onBuilt();
            return r10;
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
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r12 = this.sourceContextBuilder_;
            if (r12 == null) goto L13;
            r12.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        L9:
            this.options_ = null;
            r11.clear();
            goto L10
        L5:
            this.enumvalue_ = null;
            r10.clear();
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

        public Builder clearEdition() {
            this.edition_ = Enum.getDefaultInstance().getEdition();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearEnumvalue() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Enum.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -9;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
            this.sourceContextBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
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
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getEdition() {
            Object r10 = this.edition_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.edition_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getEditionBytes() {
            Object r10 = this.edition_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.edition_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.enumvalue_.get(r10);
        L6:
            return (EnumValue) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public EnumValue.Builder getEnumvalueBuilder(int r10) {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().getBuilder(r10);
        }

        public List<EnumValue.Builder> getEnumvalueBuilderList() {
            return internalGetEnumvalueFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            return this.enumvalue_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.enumvalue_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValueOrBuilder getEnumvalueOrBuilder(int r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.enumvalue_.get(r10);
        L6:
            return (EnumValueOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.enumvalue_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Option getOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.options_.get(r10);
        L6:
            return (Option) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r10);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.options_.get(r10);
        L6:
            return (OptionOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L9;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L7;
            return r11;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) r10.getMessage();
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L5;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L9;
            return r11;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) r10.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.forNumber(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L42;
            int r13 = r10.readTag();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r13 == 0) goto L34;
            if (r13 != 10) goto L9;
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 1;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L9:
            if (r13 == 18) goto L29;
            if (r13 != 26) goto L13;
            MessageLite r14 = (Option) r10.readMessage(Option.parser(), r11);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            RepeatedFieldBuilder r15 = this.optionsBuilder_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r15 == null) goto L26;
        L28:
            r15.addMessage(r14);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L26:
            ensureOptionsIsMutable();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            List r16 = this.options_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
        L27:
            r16.add(r14);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L13:
            if (r13 != 34) goto L15;
            r10.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 8;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L15:
            if (r13 != 40) goto L17;
            this.syntax_ = r10.readEnum();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 16;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L17:
            if (r13 != 50) goto L19;
            this.edition_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 32;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L19:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L29:
            r14 = (EnumValue) r10.readMessage(EnumValue.parser(), r11);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r15 = this.enumvalueBuilder_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r15 != null) goto L28;
            ensureEnumvalueIsMutable();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r16 = this.enumvalue_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
        L34:
            r12 = true;
            goto L3
        L35:
            th = move-exception;
            onChanged();
            throw th;
        L37:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L35
        L42:
            onChanged();
            return this;
        }

        public Builder mergeFrom(Enum r10) {
            if (r10 != Enum.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Enum.access$500(r10);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = null;
            if (this.enumvalueBuilder_ != null) goto L18;
            if (Enum.access$300(r10).isEmpty() == true) goto L28;
            if (this.enumvalue_.isEmpty() == false) goto L15;
            this.enumvalue_ = Enum.access$300(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureEnumvalueIsMutable();
            this.enumvalue_.addAll(Enum.access$300(r10));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Enum.access$400(r10).isEmpty() == true) goto L46;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Enum.access$400(r10);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L46
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Enum.access$400(r10));
        L46:
            if (r10.hasSourceContext() == false) goto L49;
            mergeSourceContext(r10.getSourceContext());
        L49:
            if (Enum.access$700(r10) == 0) goto L52;
            setSyntaxValue(r10.getSyntaxValue());
        L52:
            if (r10.getEdition().isEmpty() == true) goto L54;
            this.edition_ = Enum.access$800(r10);
            this.bitField0_ |= 32;
            onChanged();
        L54:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L37:
            if (Enum.access$400(r10).isEmpty() == true) goto L46;
            if (this.optionsBuilder_.isEmpty() == false) goto L44;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Enum.access$400(r10);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            r11 = internalGetOptionsFieldBuilder();
        L43:
            this.optionsBuilder_ = r11;
            goto L46
        L44:
            this.optionsBuilder_.addAllMessages(Enum.access$400(r10));
            goto L46
        L18:
            if (Enum.access$300(r10).isEmpty() == true) goto L28;
            if (this.enumvalueBuilder_.isEmpty() == false) goto L26;
            this.enumvalueBuilder_.dispose();
            this.enumvalueBuilder_ = null;
            this.enumvalue_ = Enum.access$300(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = internalGetEnumvalueFieldBuilder();
        L25:
            this.enumvalueBuilder_ = r12;
            goto L28
        L24:
            r12 = null;
            goto L25
        L26:
            this.enumvalueBuilder_.addAllMessages(Enum.access$300(r10));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Enum) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Enum) r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        public Builder mergeSourceContext(SourceContext r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 == null) goto L5;
            r11.mergeFrom(r10);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 8;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            SourceContext r12 = this.sourceContext_;
            if (r12 == null) goto L11;
            if (r12 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r10);
        L11:
            this.sourceContext_ = r10;
            goto L14
        }

        public Builder removeEnumvalue(int r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder removeOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder setEdition(String r10) {
            Objects.requireNonNull(r10);
            this.edition_ = r10;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.edition_ = r10;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setEnumvalue(int r10, EnumValue.Builder r11) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setEnumvalue(int r10, EnumValue r11) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r12 = this.enumvalueBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setName(String r10) {
            Objects.requireNonNull(r10);
            this.name_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.name_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setSourceContext(SourceContext.Builder r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            SourceContext r12 = r10.build();
            if (r11 != null) goto L5;
            this.sourceContext_ = r12;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setSourceContext(SourceContext r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            this.sourceContext_ = r10;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }

        public Builder setSyntax(Syntax r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 16;
            this.syntax_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r10) {
            this.syntax_ = r10;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Enum.class.getName());
        DEFAULT_INSTANCE = new Enum();
        PARSER = new AnonymousClass1();
    }

    private Enum() {
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    private Enum(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Enum(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ List access$300(Enum r10) {
        return r10.enumvalue_;
    }

    static /* synthetic */ List access$302(Enum r10, List r11) {
        r10.enumvalue_ = r11;
        return r11;
    }

    static /* synthetic */ List access$400(Enum r10) {
        return r10.options_;
    }

    static /* synthetic */ List access$402(Enum r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$500(Enum r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$502(Enum r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ SourceContext access$602(Enum r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    static /* synthetic */ int access$700(Enum r10) {
        return r10.syntax_;
    }

    static /* synthetic */ int access$702(Enum r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$800(Enum r10) {
        return r10.edition_;
    }

    static /* synthetic */ Object access$802(Enum r10, Object r11) {
        r10.edition_ = r11;
        return r11;
    }

    static /* synthetic */ int access$976(Enum r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Enum r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Enum parseDelimitedFrom(InputStream r10) {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Enum parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Enum parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Enum parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Enum parseFrom(CodedInputStream r10) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Enum parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Enum parseFrom(InputStream r10) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Enum parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Enum parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Enum parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Enum parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Enum parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Enum) == false) goto L8;
        Enum r11 = (Enum) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (getEnumvalueList().equals(r11.getEnumvalueList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r11.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (hasSourceContext() == r11.hasSourceContext()) goto L22;
        return false;
    L22:
        if (hasSourceContext() == false) goto L27;
        if (getSourceContext().equals(r11.getSourceContext()) == true) goto L27;
        return false;
    L27:
        if (this.syntax_ == r11.syntax_) goto L30;
        return false;
    L30:
        if (getEdition().equals(r11.getEdition()) == true) goto L33;
        return false;
    L33:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L35;
        return false;
    L35:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Enum getDefaultInstanceForType() {
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

    @Override // com.google.protobuf.EnumOrBuilder
    public String getEdition() {
        Object r10 = this.edition_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.edition_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getEditionBytes() {
        Object r10 = this.edition_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.edition_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int r10) {
        return this.enumvalue_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValueOrBuilder getEnumvalueOrBuilder(int r10) {
        return this.enumvalue_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Enum> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r12 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.enumvalue_.size()) goto L14;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(r13));
        r13 = r13 + 1;
    L14:
        if (r11 >= this.options_.size()) goto L17;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r12 = r12 + CodedOutputStream.computeMessageSize(4, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r12 = r12 + CodedOutputStream.computeEnumSize(5, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        r12 = r12 + GeneratedMessage.computeStringSize(6, this.edition_);
    L25:
        int r14 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r14;
        return r14;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.forNumber(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getEnumvalueCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getEnumvalueList().hashCode();
    L9:
        if (getOptionsCount() <= 0) goto L12;
        r11 = (((r11 * 37) + 3) * 53) + getOptionsList().hashCode();
    L12:
        if (hasSourceContext() == false) goto L14;
        r11 = (((r11 * 37) + 4) * 53) + getSourceContext().hashCode();
    L14:
        int r12 = (((((((((r11 * 37) + 5) * 53) + this.syntax_) * 37) + 6) * 53) + getEdition().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r10 = this.memoizedIsInitialized;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 != 0) goto L8;
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
    protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return newBuilderForType(r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
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
    public void writeTo(CodedOutputStream r10) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r10, 1, this.name_);
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= this.enumvalue_.size()) goto L10;
        r10.writeMessage(2, this.enumvalue_.get(r12));
        r12 = r12 + 1;
    L10:
        if (r11 >= this.options_.size()) goto L13;
        r10.writeMessage(3, this.options_.get(r11));
        r11 = r11 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 1) == 0) goto L16;
        r10.writeMessage(4, getSourceContext());
    L16:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L19;
        r10.writeEnum(5, this.syntax_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L21;
        GeneratedMessage.writeString(r10, 6, this.edition_);
    L21:
        getUnknownFields().writeTo(r10);
    }
}
