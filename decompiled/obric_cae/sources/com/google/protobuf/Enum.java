package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

        private void buildPartial0(Enum r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Enum.access$502(r8, this.name_);
        L6:
            if ((r10 & 8) == 0) goto L12;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L10;
            SourceContext r12 = this.sourceContext_;
        L11:
            Enum.access$602(r8, r12);
            int r13 = 1;
        L14:
            if ((r10 & 16) == 0) goto L17;
            Enum.access$702(r8, this.syntax_);
        L17:
            if ((r10 & 32) == 0) goto L19;
            Enum.access$802(r8, this.edition_);
        L19:
            Enum.access$976(r8, r13);
            return;
        L10:
            r12 = (SourceContext) r11.build();
            goto L11
        L12:
            r13 = 0;
            goto L14
        }

        private void buildPartialRepeatedFields(Enum r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            Enum.access$302(r8, r11);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            Enum.access$402(r8, r13);
            return;
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            r13 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
            this.bitField0_ &= -3;
        L7:
            r11 = this.enumvalue_;
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
            List<EnumValue> r8 = this.enumvalue_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.enumvalueBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.enumvalue_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.enumvalueBuilder_;
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

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            ensureEnumvalueIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.enumvalue_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
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

        public Builder addEnumvalue(int r8, EnumValue.Builder r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public EnumValue.Builder addEnumvalueBuilder() {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
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
        public Enum build() {
            Enum r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Enum buildPartial() {
            Enum r8 = new Enum(this, null);
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

        public Builder clearEdition() {
            this.edition_ = Enum.getDefaultInstance().getEdition();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearEnumvalue() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r8 = this.enumvalueBuilder_;
            if (r8 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Enum.getDefaultInstance().getName();
            this.bitField0_ &= -2;
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

        public Builder clearSourceContext() {
            this.bitField0_ &= -9;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
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

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getEdition() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.edition_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getEditionBytes() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.edition_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.enumvalue_.get(r8);
        L6:
            return (EnumValue) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public EnumValue.Builder getEnumvalueBuilder(int r8) {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().getBuilder(r8);
        }

        public List<EnumValue.Builder> getEnumvalueBuilderList() {
            return internalGetEnumvalueFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r8 = this.enumvalueBuilder_;
            if (r8 != null) goto L7;
            return this.enumvalue_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r8 = this.enumvalueBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.enumvalue_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValueOrBuilder getEnumvalueOrBuilder(int r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.enumvalue_.get(r8);
        L6:
            return (EnumValueOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r8 = this.enumvalueBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.enumvalue_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.EnumOrBuilder
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

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
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

        @Override // com.google.protobuf.EnumOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 != null) goto L9;
            SourceContext r10 = this.sourceContext_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) r8.getMessage();
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 != null) goto L5;
            SourceContext r10 = this.sourceContext_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            Syntax r8 = Syntax.forNumber(this.syntax_);
            if (r8 == null) goto L5;
            return r8;
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
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeSourceContext(SourceContext r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 8;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L11;
            if (r11 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r8);
        L11:
            this.sourceContext_ = r8;
            goto L14
        }

        public Builder removeEnumvalue(int r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
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

        public Builder setEdition(String r8) {
            if (r8 == null) goto L6;
            this.edition_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEditionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.edition_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEnumvalue(int r8, EnumValue.Builder r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
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

        public Builder setSourceContext(SourceContext.Builder r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            SourceContext r11 = r8.build();
            if (r10 != null) goto L5;
            this.sourceContext_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSyntax(Syntax r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 16;
            this.syntax_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSyntaxValue(int r8) {
            this.syntax_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.enumvalue_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addEnumvalue(int r8, EnumValue r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public EnumValue.Builder addEnumvalueBuilder(int r8) {
            return (EnumValue.Builder) internalGetEnumvalueFieldBuilder().addBuilder(r8, EnumValue.getDefaultInstance());
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
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r8 = this.enumvalueBuilder_;
            if (r8 != null) goto L5;
            this.enumvalue_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 == null) goto L13;
            r11.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        L9:
            this.options_ = null;
            r10.clear();
            goto L10
        L5:
            this.enumvalue_ = null;
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

        public Builder setEnumvalue(int r8, EnumValue r10) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = this.enumvalueBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
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

        public Builder setSourceContext(SourceContext r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.sourceContext_ = r8;
        L9:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addEnumvalue(EnumValue.Builder r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L5;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
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

        public Builder addEnumvalue(EnumValue r8) {
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r10 = this.enumvalueBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureEnumvalueIsMutable();
            this.enumvalue_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
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
            if (r10 == null) goto L46;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L43;
            int r12 = r8.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r12 == 0) goto L35;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            if (r12 == 18) goto L30;
            if (r12 != 26) goto L14;
            MessageLite r13 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            RepeatedFieldBuilder r14 = this.optionsBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r14 == null) goto L27;
        L29:
            r14.addMessage(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L27:
            ensureOptionsIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            List r15 = this.options_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L28:
            r15.add(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            if (r12 != 34) goto L16;
            r8.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.syntax_ = r8.readEnum();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L18:
            if (r12 != 50) goto L20;
            this.edition_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L30:
            r13 = (EnumValue) r8.readMessage(EnumValue.parser(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r14 = this.enumvalueBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r14 != null) goto L29;
            ensureEnumvalueIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r15 = this.enumvalue_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L35:
            r11 = true;
            goto L4
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L43:
            onChanged();
            return this;
        L46:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder mergeFrom(Enum r8) {
            if (r8 != Enum.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L8;
            this.name_ = Enum.access$500(r8);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = null;
            if (this.enumvalueBuilder_ != null) goto L18;
            if (Enum.access$300(r8).isEmpty() == true) goto L28;
            if (this.enumvalue_.isEmpty() == false) goto L15;
            this.enumvalue_ = Enum.access$300(r8);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureEnumvalueIsMutable();
            this.enumvalue_.addAll(Enum.access$300(r8));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Enum.access$400(r8).isEmpty() == true) goto L46;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Enum.access$400(r8);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L46
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Enum.access$400(r8));
        L46:
            if (r8.hasSourceContext() == false) goto L49;
            mergeSourceContext(r8.getSourceContext());
        L49:
            if (Enum.access$700(r8) == 0) goto L52;
            setSyntaxValue(r8.getSyntaxValue());
        L52:
            if (r8.getEdition().isEmpty() == true) goto L54;
            this.edition_ = Enum.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L54:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L37:
            if (Enum.access$400(r8).isEmpty() == true) goto L46;
            if (this.optionsBuilder_.isEmpty() == false) goto L44;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Enum.access$400(r8);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            r10 = internalGetOptionsFieldBuilder();
        L43:
            this.optionsBuilder_ = r10;
            goto L46
        L44:
            this.optionsBuilder_.addAllMessages(Enum.access$400(r8));
            goto L46
        L18:
            if (Enum.access$300(r8).isEmpty() == true) goto L28;
            if (this.enumvalueBuilder_.isEmpty() == false) goto L26;
            this.enumvalueBuilder_.dispose();
            this.enumvalueBuilder_ = null;
            this.enumvalue_ = Enum.access$300(r8);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<EnumValue, EnumValue.Builder, EnumValueOrBuilder> r11 = internalGetEnumvalueFieldBuilder();
        L25:
            this.enumvalueBuilder_ = r11;
            goto L28
        L24:
            r11 = null;
            goto L25
        L26:
            this.enumvalueBuilder_.addAllMessages(Enum.access$300(r8));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Enum) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Enum) r8);
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Enum");
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

    public static /* synthetic */ List access$300(Enum r8) {
        return r8.enumvalue_;
    }

    public static /* synthetic */ List access$302(Enum r8, List r10) {
        r8.enumvalue_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(Enum r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$402(Enum r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(Enum r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$502(Enum r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ SourceContext access$602(Enum r8, SourceContext r10) {
        r8.sourceContext_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$700(Enum r8) {
        return r8.syntax_;
    }

    public static /* synthetic */ int access$702(Enum r8, int r10) {
        r8.syntax_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(Enum r8) {
        return r8.edition_;
    }

    public static /* synthetic */ Object access$802(Enum r8, Object r10) {
        r8.edition_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$976(Enum r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
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

    public static Enum parseDelimitedFrom(InputStream r8) {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Enum parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Enum) == false) goto L8;
        Enum r10 = (Enum) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (getEnumvalueList().equals(r10.getEnumvalueList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (hasSourceContext() == r10.hasSourceContext()) goto L22;
        return false;
    L22:
        if (hasSourceContext() == false) goto L27;
        if (getSourceContext().equals(r10.getSourceContext()) == true) goto L27;
        return false;
    L27:
        if (this.syntax_ == r10.syntax_) goto L30;
        return false;
    L30:
        if (getEdition().equals(r10.getEdition()) == true) goto L33;
        return false;
    L33:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L35;
        return false;
    L35:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getEdition() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.edition_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getEditionBytes() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.edition_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int r8) {
        return this.enumvalue_.get(r8);
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
    public EnumValueOrBuilder getEnumvalueOrBuilder(int r8) {
        return this.enumvalue_.get(r8);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
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
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
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
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.enumvalue_.size()) goto L14;
        r11 = r11 + CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(r12));
        r12 = r12 + 1;
    L14:
        if (r10 >= this.options_.size()) goto L17;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.options_.get(r10));
        r10 = r10 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r11 = r11 + CodedOutputStream.computeMessageSize(4, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r11 = r11 + CodedOutputStream.computeEnumSize(5, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        r11 = r11 + GeneratedMessage.computeStringSize(6, this.edition_);
    L25:
        int r13 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax r8 = Syntax.forNumber(this.syntax_);
        if (r8 == null) goto L5;
        return r8;
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
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = (((getDescriptor().hashCode() + 779) * 37) + 1) * 53;
        int r11 = getName().hashCode() + r10;
        if (getEnumvalueCount() <= 0) goto L9;
        int r12 = defpackage.b.a(r11, 37, 2, 53);
        r11 = getEnumvalueList().hashCode() + r12;
    L9:
        if (getOptionsCount() <= 0) goto L12;
        int r13 = defpackage.b.a(r11, 37, 3, 53);
        r11 = getOptionsList().hashCode() + r13;
    L12:
        if (hasSourceContext() == false) goto L14;
        int r14 = defpackage.b.a(r11, 37, 4, 53);
        r11 = getSourceContext().hashCode() + r14;
    L14:
        int r15 = (((defpackage.b.a(r11, 37, 5, 53) + this.syntax_) * 37) + 6) * 53;
        int r16 = (getEdition().hashCode() + r15) * 29;
        int r17 = getUnknownFields().hashCode() + r16;
        this.memoizedHashCode = r17;
        return r17;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Builder.class);
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
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= this.enumvalue_.size()) goto L10;
        r8.writeMessage(2, this.enumvalue_.get(r11));
        r11 = r11 + 1;
    L10:
        if (r10 >= this.options_.size()) goto L13;
        r8.writeMessage(3, this.options_.get(r10));
        r10 = r10 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 1) == 0) goto L16;
        r8.writeMessage(4, getSourceContext());
    L16:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L19;
        r8.writeEnum(5, this.syntax_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L21;
        GeneratedMessage.writeString(r8, 6, this.edition_);
    L21:
        getUnknownFields().writeTo(r8);
    }

    private Enum(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Enum r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Enum parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Enum) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Enum parseFrom(ByteString r8, ExtensionRegistryLite r10) {
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

    public /* synthetic */ Enum(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Enum parseFrom(CodedInputStream r8) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r8);
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

    public static Enum parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    public static Enum parseFrom(InputStream r8) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static Enum parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Enum) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Enum parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Enum parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Enum parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Enum parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
