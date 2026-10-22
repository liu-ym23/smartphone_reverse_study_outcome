package com.google.protobuf;

import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Field extends GeneratedMessage implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static final Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int cardinality_;
    private volatile Object defaultValue_;
    private volatile Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private List<Option> options_;
    private boolean packed_;
    private volatile Object typeUrl_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements FieldOrBuilder {
        private int bitField0_;
        private int cardinality_;
        private Object defaultValue_;
        private Object jsonName_;
        private int kind_;
        private Object name_;
        private int number_;
        private int oneofIndex_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private boolean packed_;
        private Object typeUrl_;

        private Builder() {
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
        }

        private void buildPartial0(Field r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Field.access$402(r8, this.kind_);
        L6:
            if ((r10 & 2) == 0) goto L9;
            Field.access$502(r8, this.cardinality_);
        L9:
            if ((r10 & 4) == 0) goto L12;
            Field.access$602(r8, this.number_);
        L12:
            if ((r10 & 8) == 0) goto L15;
            Field.access$702(r8, this.name_);
        L15:
            if ((r10 & 16) == 0) goto L18;
            Field.access$802(r8, this.typeUrl_);
        L18:
            if ((r10 & 32) == 0) goto L21;
            Field.access$902(r8, this.oneofIndex_);
        L21:
            if ((r10 & 64) == 0) goto L24;
            Field.access$1002(r8, this.packed_);
        L24:
            if ((r10 & 256) == 0) goto L27;
            Field.access$1102(r8, this.jsonName_);
        L27:
            if ((r10 & 512) == 0) goto L30;
            Field.access$1202(r8, this.defaultValue_);
            return;
        }

        private void buildPartialRepeatedFields(Field r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            Field.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L7:
            r11 = this.options_;
            goto L9
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 128) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 128;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r8 = this.options_;
            if ((this.bitField0_ & 128) == 0) goto L7;
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
        public Field build() {
            Field r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field buildPartial() {
            Field r8 = new Field(this, null);
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

        public Builder clearCardinality() {
            this.bitField0_ &= -3;
            this.cardinality_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDefaultValue() {
            this.defaultValue_ = Field.getDefaultInstance().getDefaultValue();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
            return this;
        }

        public Builder clearJsonName() {
            this.jsonName_ = Field.getDefaultInstance().getJsonName();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearKind() {
            this.bitField0_ &= -2;
            this.kind_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Field.getDefaultInstance().getName();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearNumber() {
            this.bitField0_ &= -5;
            this.number_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOneofIndex() {
            this.bitField0_ &= -33;
            this.oneofIndex_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearPacked() {
            this.bitField0_ &= -65;
            this.packed_ = false;
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            Cardinality r8 = Cardinality.forNumber(this.cardinality_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Cardinality.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            Object r8 = this.defaultValue_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.defaultValue_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object r8 = this.defaultValue_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.defaultValue_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object r8 = this.jsonName_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.jsonName_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object r8 = this.jsonName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.jsonName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind r8 = Kind.forNumber(this.kind_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Kind.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object r8 = this.typeUrl_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.typeUrl_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r8 = this.typeUrl_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.typeUrl_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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

        public Builder setCardinality(Cardinality r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 2;
            this.cardinality_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCardinalityValue(int r8) {
            this.cardinality_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDefaultValue(String r8) {
            if (r8 == null) goto L6;
            this.defaultValue_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDefaultValueBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.defaultValue_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setJsonName(String r8) {
            if (r8 == null) goto L6;
            this.jsonName_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setJsonNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.jsonName_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKind(Kind r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 1;
            this.kind_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKindValue(int r8) {
            this.kind_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setName(String r8) {
            if (r8 == null) goto L6;
            this.name_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.name_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNumber(int r8) {
            this.number_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setOneofIndex(int r8) {
            this.oneofIndex_ = r8;
            this.bitField0_ |= 32;
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

        public Builder setPacked(boolean r8) {
            this.packed_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTypeUrl(String r8) {
            if (r8 == null) goto L6;
            this.typeUrl_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTypeUrlBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.typeUrl_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.jsonName_ = "";
            this.defaultValue_ = "";
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
            if (r10 == null) goto L35;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L32;
            int r12 = r8.readTag();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            switch(r12) {
                case 0: goto L22;
                case 8: goto L20;
                case 16: goto L19;
                case 24: goto L18;
                case 34: goto L17;
                case 50: goto L16;
                case 56: goto L15;
                case 64: goto L14;
                case 74: goto L10;
                case 82: goto L9;
                case 90: goto L8;
                default: goto L23;
            };     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
        L8:
            this.defaultValue_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 512;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L9:
            this.jsonName_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 256;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L10:
            Option r13 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r14 = this.optionsBuilder_;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            if (r14 == null) goto L12;
            r14.addMessage(r13);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L12:
            ensureOptionsIsMutable();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.options_.add(r13);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L14:
            this.packed_ = r8.readBool();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 64;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L15:
            this.oneofIndex_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 32;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L16:
            this.typeUrl_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 16;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L17:
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 8;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L18:
            this.number_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 4;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L19:
            this.cardinality_ = r8.readEnum();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 2;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L20:
            this.kind_ = r8.readEnum();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 1;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
        L22:
            r11 = true;
            goto L4
        L23:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L27:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            onChanged();
            throw th;
        L32:
            onChanged();
            return this;
        L35:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder mergeFrom(Field r8) {
            if (r8 != Field.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Field.access$400(r8) == 0) goto L9;
            setKindValue(r8.getKindValue());
        L9:
            if (Field.access$500(r8) == 0) goto L12;
            setCardinalityValue(r8.getCardinalityValue());
        L12:
            if (r8.getNumber() == 0) goto L15;
            setNumber(r8.getNumber());
        L15:
            if (r8.getName().isEmpty() == true) goto L18;
            this.name_ = Field.access$700(r8);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r8.getTypeUrl().isEmpty() == true) goto L21;
            this.typeUrl_ = Field.access$800(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.getOneofIndex() == 0) goto L24;
            setOneofIndex(r8.getOneofIndex());
        L24:
            if (r8.getPacked() == false) goto L27;
            setPacked(r8.getPacked());
        L27:
            if (this.optionsBuilder_ != null) goto L36;
            if (Field.access$300(r8).isEmpty() == true) goto L45;
            if (this.options_.isEmpty() == false) goto L33;
            this.options_ = Field.access$300(r8);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L34:
            onChanged();
            goto L45
        L33:
            ensureOptionsIsMutable();
            this.options_.addAll(Field.access$300(r8));
        L45:
            if (r8.getJsonName().isEmpty() == true) goto L48;
            this.jsonName_ = Field.access$1100(r8);
            this.bitField0_ |= 256;
            onChanged();
        L48:
            if (r8.getDefaultValue().isEmpty() == true) goto L50;
            this.defaultValue_ = Field.access$1200(r8);
            this.bitField0_ |= 512;
            onChanged();
        L50:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L36:
            if (Field.access$300(r8).isEmpty() == true) goto L45;
            if (this.optionsBuilder_.isEmpty() == false) goto L43;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = null;
            this.optionsBuilder_ = null;
            this.options_ = Field.access$300(r8);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L42;
            r10 = internalGetOptionsFieldBuilder();
        L42:
            this.optionsBuilder_ = r10;
            goto L45
        L43:
            this.optionsBuilder_.addAllMessages(Field.access$300(r8));
            goto L45
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Field) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Field) r8);
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

    public static final enum Cardinality extends java.lang.Enum<Cardinality> implements ProtocolMessageEnum {
        private static final /* synthetic */ Cardinality[] $VALUES = null;
        public static final Cardinality CARDINALITY_OPTIONAL = null;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final Cardinality CARDINALITY_REPEATED = null;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final Cardinality CARDINALITY_REQUIRED = null;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final Cardinality CARDINALITY_UNKNOWN = null;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final Cardinality UNRECOGNIZED = null;
        private static final Cardinality[] VALUES = null;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        private static /* synthetic */ Cardinality[] $values() {
            return new Cardinality[]{CARDINALITY_UNKNOWN, CARDINALITY_OPTIONAL, CARDINALITY_REQUIRED, CARDINALITY_REPEATED, UNRECOGNIZED};
        }

        static {
            CARDINALITY_UNKNOWN = new Cardinality("CARDINALITY_UNKNOWN", 0, 0);
            CARDINALITY_OPTIONAL = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
            CARDINALITY_REQUIRED = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
            CARDINALITY_REPEATED = new Cardinality("CARDINALITY_REPEATED", 3, 3);
            UNRECOGNIZED = new Cardinality("UNRECOGNIZED", 4, -1);
            $VALUES = $values();
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Cardinality");
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Cardinality(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Cardinality forNumber(int r8) {
            if (r8 == 0) goto L18;
            if (r8 == 1) goto L16;
            if (r8 == 2) goto L14;
            if (r8 == 3) goto L12;
            return null;
        L12:
            return CARDINALITY_REPEATED;
        L14:
            return CARDINALITY_REQUIRED;
        L16:
            return CARDINALITY_OPTIONAL;
        L18:
            return CARDINALITY_UNKNOWN;
        }

        public static Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Cardinality valueOf(int r8) {
            return forNumber(r8);
        }

        public static Cardinality[] values() {
            return (Cardinality[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) goto L7;
            return getDescriptor().getValues().get(ordinal());
        L7:
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor r8) {
            if (r8.getType() != getDescriptor()) goto L11;
            if (r8.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r8.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Cardinality valueOf(String r8) {
            return (Cardinality) java.lang.Enum.valueOf(Cardinality.class, r8);
        }
    }

    public static final enum Kind extends java.lang.Enum<Kind> implements ProtocolMessageEnum {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind TYPE_BOOL = null;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final Kind TYPE_BYTES = null;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final Kind TYPE_DOUBLE = null;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final Kind TYPE_ENUM = null;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final Kind TYPE_FIXED32 = null;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final Kind TYPE_FIXED64 = null;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final Kind TYPE_FLOAT = null;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final Kind TYPE_GROUP = null;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final Kind TYPE_INT32 = null;
        public static final int TYPE_INT32_VALUE = 5;
        public static final Kind TYPE_INT64 = null;
        public static final int TYPE_INT64_VALUE = 3;
        public static final Kind TYPE_MESSAGE = null;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final Kind TYPE_SFIXED32 = null;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final Kind TYPE_SFIXED64 = null;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final Kind TYPE_SINT32 = null;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final Kind TYPE_SINT64 = null;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final Kind TYPE_STRING = null;
        public static final int TYPE_STRING_VALUE = 9;
        public static final Kind TYPE_UINT32 = null;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final Kind TYPE_UINT64 = null;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final Kind TYPE_UNKNOWN = null;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final Kind UNRECOGNIZED = null;
        private static final Kind[] VALUES = null;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        private static /* synthetic */ Kind[] $values() {
            return new Kind[]{TYPE_UNKNOWN, TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64, UNRECOGNIZED};
        }

        static {
            TYPE_UNKNOWN = new Kind("TYPE_UNKNOWN", 0, 0);
            TYPE_DOUBLE = new Kind("TYPE_DOUBLE", 1, 1);
            TYPE_FLOAT = new Kind("TYPE_FLOAT", 2, 2);
            TYPE_INT64 = new Kind("TYPE_INT64", 3, 3);
            TYPE_UINT64 = new Kind("TYPE_UINT64", 4, 4);
            TYPE_INT32 = new Kind("TYPE_INT32", 5, 5);
            TYPE_FIXED64 = new Kind("TYPE_FIXED64", 6, 6);
            TYPE_FIXED32 = new Kind("TYPE_FIXED32", 7, 7);
            TYPE_BOOL = new Kind("TYPE_BOOL", 8, 8);
            TYPE_STRING = new Kind("TYPE_STRING", 9, 9);
            TYPE_GROUP = new Kind("TYPE_GROUP", 10, 10);
            TYPE_MESSAGE = new Kind("TYPE_MESSAGE", 11, 11);
            TYPE_BYTES = new Kind("TYPE_BYTES", 12, 12);
            TYPE_UINT32 = new Kind("TYPE_UINT32", 13, 13);
            TYPE_ENUM = new Kind("TYPE_ENUM", 14, 14);
            TYPE_SFIXED32 = new Kind("TYPE_SFIXED32", 15, 15);
            TYPE_SFIXED64 = new Kind("TYPE_SFIXED64", 16, 16);
            TYPE_SINT32 = new Kind("TYPE_SINT32", 17, 17);
            TYPE_SINT64 = new Kind("TYPE_SINT64", 18, 18);
            UNRECOGNIZED = new Kind("UNRECOGNIZED", 19, -1);
            $VALUES = $values();
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Kind");
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Kind(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Kind forNumber(int r8) {
            switch(r8) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L10;
                case 17: goto L8;
                case 18: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TYPE_SINT64;
        L8:
            return TYPE_SINT32;
        L10:
            return TYPE_SFIXED64;
        L12:
            return TYPE_SFIXED32;
        L14:
            return TYPE_ENUM;
        L16:
            return TYPE_UINT32;
        L18:
            return TYPE_BYTES;
        L20:
            return TYPE_MESSAGE;
        L22:
            return TYPE_GROUP;
        L24:
            return TYPE_STRING;
        L26:
            return TYPE_BOOL;
        L28:
            return TYPE_FIXED32;
        L30:
            return TYPE_FIXED64;
        L32:
            return TYPE_INT32;
        L34:
            return TYPE_UINT64;
        L36:
            return TYPE_INT64;
        L38:
            return TYPE_FLOAT;
        L40:
            return TYPE_DOUBLE;
        L42:
            return TYPE_UNKNOWN;
        }

        public static Descriptors.EnumDescriptor getDescriptor() {
            return Field.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Kind valueOf(int r8) {
            return forNumber(r8);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) goto L7;
            return getDescriptor().getValues().get(ordinal());
        L7:
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor r8) {
            if (r8.getType() != getDescriptor()) goto L11;
            if (r8.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r8.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Kind valueOf(String r8) {
            return (Kind) java.lang.Enum.valueOf(Kind.class, r8);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Field");
        DEFAULT_INSTANCE = new Field();
        PARSER = new AnonymousClass1();
    }

    private Field() {
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.jsonName_ = "";
        this.defaultValue_ = "";
        this.memoizedIsInitialized = -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    public static /* synthetic */ boolean access$1002(Field r8, boolean r10) {
        r8.packed_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(Field r8) {
        return r8.jsonName_;
    }

    public static /* synthetic */ Object access$1102(Field r8, Object r10) {
        r8.jsonName_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(Field r8) {
        return r8.defaultValue_;
    }

    public static /* synthetic */ Object access$1202(Field r8, Object r10) {
        r8.defaultValue_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$300(Field r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$302(Field r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$400(Field r8) {
        return r8.kind_;
    }

    public static /* synthetic */ int access$402(Field r8, int r10) {
        r8.kind_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$500(Field r8) {
        return r8.cardinality_;
    }

    public static /* synthetic */ int access$502(Field r8, int r10) {
        r8.cardinality_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(Field r8, int r10) {
        r8.number_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(Field r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$702(Field r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(Field r8) {
        return r8.typeUrl_;
    }

    public static /* synthetic */ Object access$802(Field r8, Object r10) {
        r8.typeUrl_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(Field r8, int r10) {
        r8.oneofIndex_ = r10;
        return r10;
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Field parseDelimitedFrom(InputStream r8) {
        return (Field) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Field parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Field) == false) goto L8;
        Field r10 = (Field) r8;
        if (this.kind_ == r10.kind_) goto L13;
        return false;
    L13:
        if (this.cardinality_ == r10.cardinality_) goto L16;
        return false;
    L16:
        if (getNumber() == r10.getNumber()) goto L19;
        return false;
    L19:
        if (getName().equals(r10.getName()) == true) goto L22;
        return false;
    L22:
        if (getTypeUrl().equals(r10.getTypeUrl()) == true) goto L25;
        return false;
    L25:
        if (getOneofIndex() == r10.getOneofIndex()) goto L28;
        return false;
    L28:
        if (getPacked() == r10.getPacked()) goto L31;
        return false;
    L31:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L34;
        return false;
    L34:
        if (getJsonName().equals(r10.getJsonName()) == true) goto L37;
        return false;
    L37:
        if (getDefaultValue().equals(r10.getDefaultValue()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r8 = Cardinality.forNumber(this.cardinality_);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Cardinality.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        Object r8 = this.defaultValue_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.defaultValue_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object r8 = this.defaultValue_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.defaultValue_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object r8 = this.jsonName_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.jsonName_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object r8 = this.jsonName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.jsonName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r8 = Kind.forNumber(this.kind_);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Kind.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Field> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L8;
        int r11 = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    L10:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L12;
        r11 = r11 + CodedOutputStream.computeEnumSize(2, this.cardinality_);
    L12:
        int r12 = this.number_;
        if (r12 == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt32Size(3, r12);
    L16:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L19;
        r11 = r11 + GeneratedMessage.computeStringSize(4, this.name_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L21;
        r11 = r11 + GeneratedMessage.computeStringSize(6, this.typeUrl_);
    L21:
        int r13 = this.oneofIndex_;
        if (r13 == 0) goto L24;
        r11 = r11 + CodedOutputStream.computeInt32Size(7, r13);
    L24:
        boolean r14 = this.packed_;
        if (r14 == false) goto L28;
        r11 = r11 + CodedOutputStream.computeBoolSize(8, r14);
    L28:
        if (r10 >= this.options_.size()) goto L31;
        r11 = r11 + CodedOutputStream.computeMessageSize(9, this.options_.get(r10));
        r10 = r10 + 1;
        goto L28
    L31:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L34;
        r11 = r11 + GeneratedMessage.computeStringSize(10, this.jsonName_);
    L34:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L36;
        r11 = r11 + GeneratedMessage.computeStringSize(11, this.defaultValue_);
    L36:
        int r15 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r15;
        return r15;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object r8 = this.typeUrl_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.typeUrl_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r8 = this.typeUrl_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.typeUrl_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = (((((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53;
        int r11 = (((getNumber() + r10) * 37) + 4) * 53;
        int r12 = (((getName().hashCode() + r11) * 37) + 6) * 53;
        int r13 = (((getTypeUrl().hashCode() + r12) * 37) + 7) * 53;
        int r14 = (((getOneofIndex() + r13) * 37) + 8) * 53;
        int r15 = Internal.hashBoolean(getPacked()) + r14;
        if (getOptionsCount() <= 0) goto L8;
        int r16 = defpackage.b.a(r15, 37, 9, 53);
        r15 = getOptionsList().hashCode() + r16;
    L8:
        int r17 = defpackage.b.a(r15, 37, 10, 53);
        int r18 = (((getJsonName().hashCode() + r17) * 37) + 11) * 53;
        int r19 = (getDefaultValue().hashCode() + r18) * 29;
        int r20 = getUnknownFields().hashCode() + r19;
        this.memoizedHashCode = r20;
        return r20;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L6;
        r8.writeEnum(1, this.kind_);
    L6:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L8;
        r8.writeEnum(2, this.cardinality_);
    L8:
        int r10 = this.number_;
        if (r10 == 0) goto L12;
        r8.writeInt32(3, r10);
    L12:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L15;
        GeneratedMessage.writeString(r8, 4, this.name_);
    L15:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L17;
        GeneratedMessage.writeString(r8, 6, this.typeUrl_);
    L17:
        int r11 = this.oneofIndex_;
        if (r11 == 0) goto L20;
        r8.writeInt32(7, r11);
    L20:
        boolean r12 = this.packed_;
        if (r12 == false) goto L23;
        r8.writeBool(8, r12);
    L23:
        int r13 = 0;
    L25:
        if (r13 >= this.options_.size()) goto L28;
        r8.writeMessage(9, this.options_.get(r13));
        r13 = r13 + 1;
        goto L25
    L28:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L31;
        GeneratedMessage.writeString(r8, 10, this.jsonName_);
    L31:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L33;
        GeneratedMessage.writeString(r8, 11, this.defaultValue_);
    L33:
        getUnknownFields().writeTo(r8);
    }

    private Field(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.jsonName_ = "";
        this.defaultValue_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Field r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Field parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Field) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Field parseFrom(ByteString r8, ExtensionRegistryLite r10) {
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

    public /* synthetic */ Field(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Field parseFrom(CodedInputStream r8) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r8);
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

    public static Field parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    public static Field parseFrom(InputStream r8) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static Field parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Field parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Field parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Field parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Field parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
