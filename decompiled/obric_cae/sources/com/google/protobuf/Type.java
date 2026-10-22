package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Type extends GeneratedMessage implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 7;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static final Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<Field> fields_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private LazyStringArrayList oneofs_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TypeOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> fieldsBuilder_;
        private List<Field> fields_;
        private Object name_;
        private LazyStringArrayList oneofs_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        private Builder() {
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(Type r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Type.access$502(r8, this.name_);
        L6:
            if ((r10 & 4) == 0) goto L9;
            this.oneofs_.makeImmutable();
            Type.access$602(r8, this.oneofs_);
        L9:
            if ((r10 & 16) == 0) goto L15;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L13;
            SourceContext r12 = this.sourceContext_;
        L14:
            Type.access$702(r8, r12);
            int r13 = 1;
        L17:
            if ((r10 & 32) == 0) goto L20;
            Type.access$802(r8, this.syntax_);
        L20:
            if ((r10 & 64) == 0) goto L22;
            Type.access$902(r8, this.edition_);
        L22:
            Type.access$1076(r8, r13);
            return;
        L13:
            r12 = (SourceContext) r11.build();
            goto L14
        L15:
            r13 = 0;
            goto L17
        }

        private void buildPartialRepeatedFields(Type r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            Type.access$302(r8, r11);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            Type.access$402(r8, r13);
            return;
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -9;
        L14:
            r13 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.fields_ = Collections.unmodifiableList(this.fields_);
            this.bitField0_ &= -3;
        L7:
            r11 = this.fields_;
            goto L9
        }

        private void ensureFieldsIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.fields_ = new ArrayList(this.fields_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureOneofsIsMutable() {
            if (this.oneofs_.isModifiable() == true) goto L5;
            this.oneofs_ = new LazyStringArrayList(this.oneofs_);
        L5:
            this.bitField0_ |= 4;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> internalGetFieldsFieldBuilder() {
            if (this.fieldsBuilder_ != null) goto L10;
            List<Field> r8 = this.fields_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.fieldsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.fields_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.fieldsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r8 = this.options_;
            if ((this.bitField0_ & 8) == 0) goto L7;
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
            internalGetFieldsFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            return;
        }

        public Builder addAllFields(Iterable<? extends Field> r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            ensureFieldsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.fields_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllOneofs(Iterable<String> r8) {
            ensureOneofsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.oneofs_);
            this.bitField0_ |= 4;
            onChanged();
            return this;
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

        public Builder addFields(int r8, Field.Builder r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Field.Builder addFieldsBuilder() {
            return (Field.Builder) internalGetFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
        }

        public Builder addOneofs(String r8) {
            if (r8 == null) goto L6;
            ensureOneofsIsMutable();
            this.oneofs_.add(r8);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder addOneofsBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            ensureOneofsIsMutable();
            this.oneofs_.add(r8);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
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
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearEdition() {
            this.edition_ = Type.getDefaultInstance().getEdition();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearFields() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r8 = this.fieldsBuilder_;
            if (r8 != null) goto L5;
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Type.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOneofs() {
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
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
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getEdition() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.edition_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getEditionBytes() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.edition_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.fields_.get(r8);
        L6:
            return (Field) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Field.Builder getFieldsBuilder(int r8) {
            return (Field.Builder) internalGetFieldsFieldBuilder().getBuilder(r8);
        }

        public List<Field.Builder> getFieldsBuilderList() {
            return internalGetFieldsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r8 = this.fieldsBuilder_;
            if (r8 != null) goto L7;
            return this.fields_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r8 = this.fieldsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.fields_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public FieldOrBuilder getFieldsOrBuilder(int r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.fields_.get(r8);
        L6:
            return (FieldOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r8 = this.fieldsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.fields_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int r8) {
            return this.oneofs_.get(r8);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int r8) {
            return this.oneofs_.getByteString(r8);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return this.oneofs_.size();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ProtocolStringList getOneofsList() {
            this.oneofs_.makeImmutable();
            return this.oneofs_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            Syntax r8 = Syntax.forNumber(this.syntax_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L11;
            if (r11 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r8);
        L11:
            this.sourceContext_ = r8;
            goto L14
        }

        public Builder removeFields(int r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.remove(r8);
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEditionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.edition_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setFields(int r8, Field.Builder r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.set(r8, r10.build());
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

        public Builder setOneofs(int r8, String r10) {
            if (r10 == null) goto L6;
            ensureOneofsIsMutable();
            this.oneofs_.set(r8, r10);
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSyntax(Syntax r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 32;
            this.syntax_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSyntaxValue(int r8) {
            this.syntax_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addFields(int r8, Field r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Field.Builder addFieldsBuilder(int r8) {
            return (Field.Builder) internalGetFieldsFieldBuilder().addBuilder(r8, Field.getDefaultInstance());
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

        @Override // com.google.protobuf.TypeOrBuilder
        public /* bridge */ /* synthetic */ List getOneofsList() {
            return getOneofsList();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setFields(int r8, Field r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.set(r8, r10);
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
            this.bitField0_ |= 16;
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

        public Builder addFields(Field.Builder r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r8.build());
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
        public Type build() {
            Type r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type buildPartial() {
            Type r8 = new Type(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addFields(Field r8) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureFieldsIsMutable();
            this.fields_.add(r8);
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
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r8 = this.fieldsBuilder_;
            if (r8 != null) goto L5;
            this.fields_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            this.oneofs_ = LazyStringArrayList.emptyList();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -9;
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
            this.fields_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L49;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L46;
            int r12 = r8.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r12 == 0) goto L38;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L10:
            if (r12 == 18) goto L33;
            if (r12 != 26) goto L14;
            String r13 = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            ensureOneofsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.oneofs_.add(r13);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L14:
            if (r12 != 34) goto L16;
            MessageLite r14 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            RepeatedFieldBuilder r15 = this.optionsBuilder_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r15 == null) goto L29;
        L31:
            r15.addMessage(r14);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L29:
            ensureOptionsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            List r16 = this.options_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L30:
            r16.add(r14);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L16:
            if (r12 != 42) goto L18;
            r8.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L18:
            if (r12 != 48) goto L20;
            this.syntax_ = r8.readEnum();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L20:
            if (r12 != 58) goto L22;
            this.edition_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 64;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L33:
            r14 = (Field) r8.readMessage(Field.parser(), r10);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.fieldsBuilder_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r15 != null) goto L31;
            ensureFieldsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r16 = this.fields_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L38:
            r11 = true;
            goto L4
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L46:
            onChanged();
            return this;
        L49:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Type) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Type) r8);
        }

        public Builder mergeFrom(Type r8) {
            if (r8 != Type.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L8;
            this.name_ = Type.access$500(r8);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = null;
            if (this.fieldsBuilder_ != null) goto L18;
            if (Type.access$300(r8).isEmpty() == true) goto L28;
            if (this.fields_.isEmpty() == false) goto L15;
            this.fields_ = Type.access$300(r8);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureFieldsIsMutable();
            this.fields_.addAll(Type.access$300(r8));
        L28:
            if (Type.access$600(r8).isEmpty() == true) goto L35;
            if (this.oneofs_.isEmpty() == false) goto L32;
            this.oneofs_ = Type.access$600(r8);
            this.bitField0_ |= 4;
        L33:
            onChanged();
            goto L35
        L32:
            ensureOneofsIsMutable();
            this.oneofs_.addAll(Type.access$600(r8));
        L35:
            if (this.optionsBuilder_ != null) goto L44;
            if (Type.access$400(r8).isEmpty() == true) goto L53;
            if (this.options_.isEmpty() == false) goto L41;
            this.options_ = Type.access$400(r8);
            this.bitField0_ &= -9;
        L42:
            onChanged();
            goto L53
        L41:
            ensureOptionsIsMutable();
            this.options_.addAll(Type.access$400(r8));
        L53:
            if (r8.hasSourceContext() == false) goto L56;
            mergeSourceContext(r8.getSourceContext());
        L56:
            if (Type.access$800(r8) == 0) goto L59;
            setSyntaxValue(r8.getSyntaxValue());
        L59:
            if (r8.getEdition().isEmpty() == true) goto L61;
            this.edition_ = Type.access$900(r8);
            this.bitField0_ |= 64;
            onChanged();
        L61:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L44:
            if (Type.access$400(r8).isEmpty() == true) goto L53;
            if (this.optionsBuilder_.isEmpty() == false) goto L51;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Type.access$400(r8);
            this.bitField0_ &= -9;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L50;
            r10 = internalGetOptionsFieldBuilder();
        L50:
            this.optionsBuilder_ = r10;
            goto L53
        L51:
            this.optionsBuilder_.addAllMessages(Type.access$400(r8));
            goto L53
        L18:
            if (Type.access$300(r8).isEmpty() == true) goto L28;
            if (this.fieldsBuilder_.isEmpty() == false) goto L26;
            this.fieldsBuilder_.dispose();
            this.fieldsBuilder_ = null;
            this.fields_ = Type.access$300(r8);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = internalGetFieldsFieldBuilder();
        L25:
            this.fieldsBuilder_ = r11;
            goto L28
        L24:
            r11 = null;
            goto L25
        L26:
            this.fieldsBuilder_.addAllMessages(Type.access$300(r8));
            goto L28
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Type");
        DEFAULT_INSTANCE = new Type();
        PARSER = new AnonymousClass1();
    }

    private Type() {
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static /* synthetic */ int access$1076(Type r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$300(Type r8) {
        return r8.fields_;
    }

    public static /* synthetic */ List access$302(Type r8, List r10) {
        r8.fields_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(Type r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$402(Type r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(Type r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$502(Type r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ LazyStringArrayList access$600(Type r8) {
        return r8.oneofs_;
    }

    public static /* synthetic */ LazyStringArrayList access$602(Type r8, LazyStringArrayList r10) {
        r8.oneofs_ = r10;
        return r10;
    }

    public static /* synthetic */ SourceContext access$702(Type r8, SourceContext r10) {
        r8.sourceContext_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$800(Type r8) {
        return r8.syntax_;
    }

    public static /* synthetic */ int access$802(Type r8, int r10) {
        r8.syntax_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$900(Type r8) {
        return r8.edition_;
    }

    public static /* synthetic */ Object access$902(Type r8, Object r10) {
        r8.edition_ = r10;
        return r10;
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type parseDelimitedFrom(InputStream r8) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Type parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Type) == false) goto L8;
        Type r10 = (Type) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (getFieldsList().equals(r10.getFieldsList()) == true) goto L16;
        return false;
    L16:
        if (getOneofsList().equals(r10.getOneofsList()) == true) goto L19;
        return false;
    L19:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r10.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r10.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (this.syntax_ == r10.syntax_) goto L33;
        return false;
    L33:
        if (getEdition().equals(r10.getEdition()) == true) goto L36;
        return false;
    L36:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L38;
        return false;
    L38:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getEdition() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.edition_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getEditionBytes() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.edition_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int r8) {
        return this.fields_.get(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public FieldOrBuilder getFieldsOrBuilder(int r8) {
        return this.fields_.get(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int r8) {
        return this.oneofs_.get(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int r8) {
        return this.oneofs_.getByteString(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Type> getParserForType() {
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
        if (r12 >= this.fields_.size()) goto L13;
        r11 = r11 + CodedOutputStream.computeMessageSize(2, this.fields_.get(r12));
        r12 = r12 + 1;
        goto L11
    L13:
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r13 >= this.oneofs_.size()) goto L17;
        r14 = r14 + GeneratedMessage.computeStringSizeNoTag(this.oneofs_.getRaw(r13));
        r13 = r13 + 1;
        goto L15
    L17:
        int r15 = (getOneofsList().size() * 1) + (r11 + r14);
    L19:
        if (r10 >= this.options_.size()) goto L22;
        r15 = r15 + CodedOutputStream.computeMessageSize(4, this.options_.get(r10));
        r10 = r10 + 1;
        goto L19
    L22:
        if ((this.bitField0_ & 1) == 0) goto L25;
        r15 = r15 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L28;
        r15 = r15 + CodedOutputStream.computeEnumSize(6, this.syntax_);
    L28:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L30;
        r15 = r15 + GeneratedMessage.computeStringSize(7, this.edition_);
    L30:
        int r16 = getUnknownFields().getSerializedSize() + r15;
        this.memoizedSize = r16;
        return r16;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax r8 = Syntax.forNumber(this.syntax_);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
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
        if (getFieldsCount() <= 0) goto L9;
        int r12 = defpackage.b.a(r11, 37, 2, 53);
        r11 = getFieldsList().hashCode() + r12;
    L9:
        if (getOneofsCount() <= 0) goto L12;
        int r13 = defpackage.b.a(r11, 37, 3, 53);
        r11 = getOneofsList().hashCode() + r13;
    L12:
        if (getOptionsCount() <= 0) goto L15;
        int r14 = defpackage.b.a(r11, 37, 4, 53);
        r11 = getOptionsList().hashCode() + r14;
    L15:
        if (hasSourceContext() == false) goto L17;
        int r15 = defpackage.b.a(r11, 37, 5, 53);
        r11 = getSourceContext().hashCode() + r15;
    L17:
        int r16 = (((defpackage.b.a(r11, 37, 6, 53) + this.syntax_) * 37) + 7) * 53;
        int r17 = (getEdition().hashCode() + r16) * 29;
        int r18 = getUnknownFields().hashCode() + r17;
        this.memoizedHashCode = r18;
        return r18;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= this.fields_.size()) goto L9;
        r8.writeMessage(2, this.fields_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.oneofs_.size()) goto L14;
        GeneratedMessage.writeString(r8, 3, this.oneofs_.getRaw(r12));
        r12 = r12 + 1;
    L14:
        if (r10 >= this.options_.size()) goto L17;
        r8.writeMessage(4, this.options_.get(r10));
        r10 = r10 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r8.writeMessage(5, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r8.writeEnum(6, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        GeneratedMessage.writeString(r8, 7, this.edition_);
    L25:
        getUnknownFields().writeTo(r8);
    }

    private Type(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Type r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Type parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Type parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public /* bridge */ /* synthetic */ List getOneofsList() {
        return getOneofsList();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ Type(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Type parseFrom(CodedInputStream r8) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    public static Type parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Type parseFrom(InputStream r8) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static Type parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Type parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Type parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Type parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Type parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
