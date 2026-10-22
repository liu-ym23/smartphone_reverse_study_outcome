package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
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

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
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

        private void buildPartial0(Type r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L6;
            Type.access$502(r10, this.name_);
        L6:
            if ((r11 & 4) == 0) goto L8;
            this.oneofs_.makeImmutable();
            Type.access$602(r10, this.oneofs_);
        L8:
            int r12 = 0;
            if ((r11 & 16) == 0) goto L16;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L13;
            SourceContext r14 = this.sourceContext_;
        L14:
            Type.access$702(r10, r14);
            r12 = 1;
            goto L16
        L13:
            r14 = (SourceContext) r13.build();
        L16:
            if ((r11 & 32) == 0) goto L19;
            Type.access$802(r10, this.syntax_);
        L19:
            if ((r11 & 64) == 0) goto L21;
            Type.access$902(r10, this.edition_);
        L21:
            Type.access$1076(r10, r12);
        }

        private void buildPartialRepeatedFields(Type r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            Type.access$302(r10, r12);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r13 = this.optionsBuilder_;
            if (r13 == null) goto L12;
            List r14 = r13.build();
        L16:
            Type.access$402(r10, r14);
            return;
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -9;
        L14:
            r14 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.fields_ = Collections.unmodifiableList(this.fields_);
            this.bitField0_ &= -3;
        L7:
            r12 = this.fields_;
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
            List<Field> r10 = this.fields_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.fieldsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.fields_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.fieldsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 8) == 0) goto L7;
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
            internalGetFieldsFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            return;
        }

        public Builder addAllFields(Iterable<? extends Field> r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.fields_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllOneofs(Iterable<String> r10) {
            ensureOneofsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.oneofs_);
            this.bitField0_ |= 4;
            onChanged();
            return this;
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

        public Builder addFields(int r10, Field.Builder r11) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addFields(int r10, Field r11) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureFieldsIsMutable();
            this.fields_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addFields(Field.Builder r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addFields(Field r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureFieldsIsMutable();
            this.fields_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Field.Builder addFieldsBuilder() {
            return (Field.Builder) internalGetFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
        }

        public Field.Builder addFieldsBuilder(int r10) {
            return (Field.Builder) internalGetFieldsFieldBuilder().addBuilder(r10, Field.getDefaultInstance());
        }

        public Builder addOneofs(String r10) {
            Objects.requireNonNull(r10);
            ensureOneofsIsMutable();
            this.oneofs_.add(r10);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addOneofsBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            ensureOneofsIsMutable();
            this.oneofs_.add(r10);
            this.bitField0_ |= 4;
            onChanged();
            return this;
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
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type build() {
            Type r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type buildPartial() {
            Type r10 = new Type(this, null);
            buildPartialRepeatedFields(r10);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            onBuilt();
            return r10;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
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

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            this.fields_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            this.oneofs_ = LazyStringArrayList.emptyList();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -9;
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
            this.fields_ = null;
            r10.clear();
            goto L6
        }

        public Builder clearEdition() {
            this.edition_ = Type.getDefaultInstance().getEdition();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearFields() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L5;
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
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
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getEdition() {
            Object r10 = this.edition_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.edition_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getEditionBytes() {
            Object r10 = this.edition_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.edition_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.fields_.get(r10);
        L6:
            return (Field) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Field.Builder getFieldsBuilder(int r10) {
            return (Field.Builder) internalGetFieldsFieldBuilder().getBuilder(r10);
        }

        public List<Field.Builder> getFieldsBuilderList() {
            return internalGetFieldsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            return this.fields_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.fields_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public FieldOrBuilder getFieldsOrBuilder(int r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.fields_.get(r10);
        L6:
            return (FieldOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r10 = this.fieldsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.fields_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int r10) {
            return this.oneofs_.get(r10);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int r10) {
            return this.oneofs_.getByteString(r10);
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
        public /* bridge */ /* synthetic */ List getOneofsList() {
            return getOneofsList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.forNumber(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
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
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L45;
            int r13 = r10.readTag();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            if (r13 == 0) goto L37;
            if (r13 != 10) goto L9;
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 1;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L9:
            if (r13 == 18) goto L32;
            if (r13 != 26) goto L13;
            String r14 = r10.readStringRequireUtf8();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            ensureOneofsIsMutable();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.oneofs_.add(r14);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L13:
            if (r13 != 34) goto L15;
            MessageLite r15 = (Option) r10.readMessage(Option.parser(), r11);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            RepeatedFieldBuilder r16 = this.optionsBuilder_;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            if (r16 == null) goto L28;
        L30:
            r16.addMessage(r15);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L28:
            ensureOptionsIsMutable();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            List r17 = this.options_;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
        L29:
            r17.add(r15);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L15:
            if (r13 != 42) goto L17;
            r10.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 16;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L17:
            if (r13 != 48) goto L19;
            this.syntax_ = r10.readEnum();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 32;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L19:
            if (r13 != 58) goto L21;
            this.edition_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 64;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L3
        L21:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L32:
            r15 = (Field) r10.readMessage(Field.parser(), r11);     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            r16 = this.fieldsBuilder_;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            if (r16 != null) goto L30;
            ensureFieldsIsMutable();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            r17 = this.fields_;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
        L37:
            r12 = true;
            goto L3
        L38:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L38
        L45:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Type) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Type) r10);
        }

        public Builder mergeFrom(Type r10) {
            if (r10 != Type.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Type.access$500(r10);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = null;
            if (this.fieldsBuilder_ != null) goto L18;
            if (Type.access$300(r10).isEmpty() == true) goto L28;
            if (this.fields_.isEmpty() == false) goto L15;
            this.fields_ = Type.access$300(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureFieldsIsMutable();
            this.fields_.addAll(Type.access$300(r10));
        L28:
            if (Type.access$600(r10).isEmpty() == true) goto L35;
            if (this.oneofs_.isEmpty() == false) goto L32;
            this.oneofs_ = Type.access$600(r10);
            this.bitField0_ |= 4;
        L33:
            onChanged();
            goto L35
        L32:
            ensureOneofsIsMutable();
            this.oneofs_.addAll(Type.access$600(r10));
        L35:
            if (this.optionsBuilder_ != null) goto L44;
            if (Type.access$400(r10).isEmpty() == true) goto L53;
            if (this.options_.isEmpty() == false) goto L41;
            this.options_ = Type.access$400(r10);
            this.bitField0_ &= -9;
        L42:
            onChanged();
            goto L53
        L41:
            ensureOptionsIsMutable();
            this.options_.addAll(Type.access$400(r10));
        L53:
            if (r10.hasSourceContext() == false) goto L56;
            mergeSourceContext(r10.getSourceContext());
        L56:
            if (Type.access$800(r10) == 0) goto L59;
            setSyntaxValue(r10.getSyntaxValue());
        L59:
            if (r10.getEdition().isEmpty() == true) goto L61;
            this.edition_ = Type.access$900(r10);
            this.bitField0_ |= 64;
            onChanged();
        L61:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L44:
            if (Type.access$400(r10).isEmpty() == true) goto L53;
            if (this.optionsBuilder_.isEmpty() == false) goto L51;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Type.access$400(r10);
            this.bitField0_ &= -9;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L50;
            r11 = internalGetOptionsFieldBuilder();
        L50:
            this.optionsBuilder_ = r11;
            goto L53
        L51:
            this.optionsBuilder_.addAllMessages(Type.access$400(r10));
            goto L53
        L18:
            if (Type.access$300(r10).isEmpty() == true) goto L28;
            if (this.fieldsBuilder_.isEmpty() == false) goto L26;
            this.fieldsBuilder_.dispose();
            this.fieldsBuilder_ = null;
            this.fields_ = Type.access$300(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r12 = internalGetFieldsFieldBuilder();
        L25:
            this.fieldsBuilder_ = r12;
            goto L28
        L24:
            r12 = null;
            goto L25
        L26:
            this.fieldsBuilder_.addAllMessages(Type.access$300(r10));
            goto L28
        }

        public Builder mergeSourceContext(SourceContext r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 == null) goto L5;
            r11.mergeFrom(r10);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r12 = this.sourceContext_;
            if (r12 == null) goto L11;
            if (r12 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r10);
        L11:
            this.sourceContext_ = r10;
            goto L14
        }

        public Builder removeFields(int r10) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r11 = this.fieldsBuilder_;
            if (r11 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.remove(r10);
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.edition_ = r10;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setFields(int r10, Field.Builder r11) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            ensureFieldsIsMutable();
            this.fields_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setFields(int r10, Field r11) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> r12 = this.fieldsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureFieldsIsMutable();
            this.fields_.set(r10, r11);
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

        public Builder setOneofs(int r10, String r11) {
            Objects.requireNonNull(r11);
            ensureOneofsIsMutable();
            this.oneofs_.set(r10, r11);
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }

        public Builder setSyntax(Syntax r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 32;
            this.syntax_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r10) {
            this.syntax_ = r10;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Type.class.getName());
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

    private Type(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Type(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ int access$1076(Type r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    static /* synthetic */ List access$300(Type r10) {
        return r10.fields_;
    }

    static /* synthetic */ List access$302(Type r10, List r11) {
        r10.fields_ = r11;
        return r11;
    }

    static /* synthetic */ List access$400(Type r10) {
        return r10.options_;
    }

    static /* synthetic */ List access$402(Type r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$500(Type r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$502(Type r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ LazyStringArrayList access$600(Type r10) {
        return r10.oneofs_;
    }

    static /* synthetic */ LazyStringArrayList access$602(Type r10, LazyStringArrayList r11) {
        r10.oneofs_ = r11;
        return r11;
    }

    static /* synthetic */ SourceContext access$702(Type r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    static /* synthetic */ int access$800(Type r10) {
        return r10.syntax_;
    }

    static /* synthetic */ int access$802(Type r10, int r11) {
        r10.syntax_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$900(Type r10) {
        return r10.edition_;
    }

    static /* synthetic */ Object access$902(Type r10, Object r11) {
        r10.edition_ = r11;
        return r11;
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

    public static Builder newBuilder(Type r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Type parseDelimitedFrom(InputStream r10) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Type parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Type parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Type parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Type parseFrom(CodedInputStream r10) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Type parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Type parseFrom(InputStream r10) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Type parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Type parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Type parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Type parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Type parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Type) == false) goto L8;
        Type r11 = (Type) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (getFieldsList().equals(r11.getFieldsList()) == true) goto L16;
        return false;
    L16:
        if (getOneofsList().equals(r11.getOneofsList()) == true) goto L19;
        return false;
    L19:
        if (getOptionsList().equals(r11.getOptionsList()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r11.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r11.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (this.syntax_ == r11.syntax_) goto L33;
        return false;
    L33:
        if (getEdition().equals(r11.getEdition()) == true) goto L36;
        return false;
    L36:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L38;
        return false;
    L38:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getEdition() {
        Object r10 = this.edition_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.edition_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getEditionBytes() {
        Object r10 = this.edition_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.edition_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int r10) {
        return this.fields_.get(r10);
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
    public FieldOrBuilder getFieldsOrBuilder(int r10) {
        return this.fields_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int r10) {
        return this.oneofs_.get(r10);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int r10) {
        return this.oneofs_.getByteString(r10);
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
    public /* bridge */ /* synthetic */ List getOneofsList() {
        return getOneofsList();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
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
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
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
        if (r13 >= this.fields_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.fields_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
        int r15 = 0;
    L15:
        if (r14 >= this.oneofs_.size()) goto L17;
        r15 = r15 + GeneratedMessage.computeStringSizeNoTag(this.oneofs_.getRaw(r14));
        r14 = r14 + 1;
        goto L15
    L17:
        int r16 = (r12 + r15) + (getOneofsList().size() * 1);
    L19:
        if (r11 >= this.options_.size()) goto L22;
        r16 = r16 + CodedOutputStream.computeMessageSize(4, this.options_.get(r11));
        r11 = r11 + 1;
        goto L19
    L22:
        if ((this.bitField0_ & 1) == 0) goto L25;
        r16 = r16 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L28;
        r16 = r16 + CodedOutputStream.computeEnumSize(6, this.syntax_);
    L28:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L30;
        r16 = r16 + GeneratedMessage.computeStringSize(7, this.edition_);
    L30:
        int r17 = r16 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r17;
        return r17;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.forNumber(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
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
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getFieldsCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getFieldsList().hashCode();
    L9:
        if (getOneofsCount() <= 0) goto L12;
        r11 = (((r11 * 37) + 3) * 53) + getOneofsList().hashCode();
    L12:
        if (getOptionsCount() <= 0) goto L15;
        r11 = (((r11 * 37) + 4) * 53) + getOptionsList().hashCode();
    L15:
        if (hasSourceContext() == false) goto L17;
        r11 = (((r11 * 37) + 5) * 53) + getSourceContext().hashCode();
    L17:
        int r12 = (((((((((r11 * 37) + 6) * 53) + this.syntax_) * 37) + 7) * 53) + getEdition().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r10, 1, this.name_);
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= this.fields_.size()) goto L9;
        r10.writeMessage(2, this.fields_.get(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.oneofs_.size()) goto L14;
        GeneratedMessage.writeString(r10, 3, this.oneofs_.getRaw(r13));
        r13 = r13 + 1;
    L14:
        if (r11 >= this.options_.size()) goto L17;
        r10.writeMessage(4, this.options_.get(r11));
        r11 = r11 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) == 0) goto L20;
        r10.writeMessage(5, getSourceContext());
    L20:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L23;
        r10.writeEnum(6, this.syntax_);
    L23:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L25;
        GeneratedMessage.writeString(r10, 7, this.edition_);
    L25:
        getUnknownFields().writeTo(r10);
    }
}
