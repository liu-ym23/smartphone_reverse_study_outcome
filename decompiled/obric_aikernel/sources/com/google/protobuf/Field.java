package com.google.protobuf;

import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
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

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Field r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L6;
            Field.access$402(r10, this.kind_);
        L6:
            if ((r11 & 2) == 0) goto L9;
            Field.access$502(r10, this.cardinality_);
        L9:
            if ((r11 & 4) == 0) goto L12;
            Field.access$602(r10, this.number_);
        L12:
            if ((r11 & 8) == 0) goto L15;
            Field.access$702(r10, this.name_);
        L15:
            if ((r11 & 16) == 0) goto L18;
            Field.access$802(r10, this.typeUrl_);
        L18:
            if ((r11 & 32) == 0) goto L21;
            Field.access$902(r10, this.oneofIndex_);
        L21:
            if ((r11 & 64) == 0) goto L24;
            Field.access$1002(r10, this.packed_);
        L24:
            if ((r11 & 256) == 0) goto L27;
            Field.access$1102(r10, this.jsonName_);
        L27:
            if ((r11 & 512) == 0) goto L30;
            Field.access$1202(r10, this.defaultValue_);
            return;
        }

        private void buildPartialRepeatedFields(Field r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            Field.access$302(r10, r12);
            return;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -129;
        L7:
            r12 = this.options_;
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
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 128) == 0) goto L7;
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
        public Field build() {
            Field r10 = buildPartial();
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
        public Field buildPartial() {
            Field r10 = new Field(this, null);
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -129;
            this.jsonName_ = "";
            this.defaultValue_ = "";
            return this;
        L5:
            this.options_ = null;
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
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
            Cardinality r10 = Cardinality.forNumber(this.cardinality_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Cardinality.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            Object r10 = this.defaultValue_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.defaultValue_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object r10 = this.defaultValue_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.defaultValue_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object r10 = this.jsonName_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.jsonName_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object r10 = this.jsonName_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.jsonName_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind r10 = Kind.forNumber(this.kind_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Kind.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
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

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r10 = this.typeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.typeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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
            if (r12 == true) goto L31;
            int r13 = r10.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            switch(r13) {
                case 0: goto L21;
                case 8: goto L19;
                case 16: goto L18;
                case 24: goto L17;
                case 34: goto L16;
                case 50: goto L15;
                case 56: goto L14;
                case 64: goto L13;
                case 74: goto L9;
                case 82: goto L8;
                case 90: goto L7;
                default: goto L22;
            };     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L7:
            this.defaultValue_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 512;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L8:
            this.jsonName_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 256;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L9:
            Option r14 = (Option) r10.readMessage(Option.parser(), r11);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r15 = this.optionsBuilder_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r15 == null) goto L11;
            r15.addMessage(r14);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L11:
            ensureOptionsIsMutable();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.options_.add(r14);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L13:
            this.packed_ = r10.readBool();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 64;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L14:
            this.oneofIndex_ = r10.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 32;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L15:
            this.typeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L16:
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L17:
            this.number_ = r10.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L18:
            this.cardinality_ = r10.readEnum();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L19:
            this.kind_ = r10.readEnum();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L21:
            r12 = true;
            goto L3
        L22:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
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
        }

        public Builder mergeFrom(Field r10) {
            if (r10 != Field.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Field.access$400(r10) == 0) goto L9;
            setKindValue(r10.getKindValue());
        L9:
            if (Field.access$500(r10) == 0) goto L12;
            setCardinalityValue(r10.getCardinalityValue());
        L12:
            if (r10.getNumber() == 0) goto L15;
            setNumber(r10.getNumber());
        L15:
            if (r10.getName().isEmpty() == true) goto L18;
            this.name_ = Field.access$700(r10);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r10.getTypeUrl().isEmpty() == true) goto L21;
            this.typeUrl_ = Field.access$800(r10);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r10.getOneofIndex() == 0) goto L24;
            setOneofIndex(r10.getOneofIndex());
        L24:
            if (r10.getPacked() == false) goto L27;
            setPacked(r10.getPacked());
        L27:
            if (this.optionsBuilder_ != null) goto L36;
            if (Field.access$300(r10).isEmpty() == true) goto L45;
            if (this.options_.isEmpty() == false) goto L33;
            this.options_ = Field.access$300(r10);
            this.bitField0_ &= -129;
        L34:
            onChanged();
            goto L45
        L33:
            ensureOptionsIsMutable();
            this.options_.addAll(Field.access$300(r10));
        L45:
            if (r10.getJsonName().isEmpty() == true) goto L48;
            this.jsonName_ = Field.access$1100(r10);
            this.bitField0_ |= 256;
            onChanged();
        L48:
            if (r10.getDefaultValue().isEmpty() == true) goto L50;
            this.defaultValue_ = Field.access$1200(r10);
            this.bitField0_ |= 512;
            onChanged();
        L50:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L36:
            if (Field.access$300(r10).isEmpty() == true) goto L45;
            if (this.optionsBuilder_.isEmpty() == false) goto L43;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = null;
            this.optionsBuilder_ = null;
            this.options_ = Field.access$300(r10);
            this.bitField0_ &= -129;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L42;
            r11 = internalGetOptionsFieldBuilder();
        L42:
            this.optionsBuilder_ = r11;
            goto L45
        L43:
            this.optionsBuilder_.addAllMessages(Field.access$300(r10));
            goto L45
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Field) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Field) r10);
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

        public Builder setCardinality(Cardinality r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 2;
            this.cardinality_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setCardinalityValue(int r10) {
            this.cardinality_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDefaultValue(String r10) {
            Objects.requireNonNull(r10);
            this.defaultValue_ = r10;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDefaultValueBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.defaultValue_ = r10;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setJsonName(String r10) {
            Objects.requireNonNull(r10);
            this.jsonName_ = r10;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setJsonNameBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.jsonName_ = r10;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setKind(Kind r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 1;
            this.kind_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setKindValue(int r10) {
            this.kind_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setName(String r10) {
            Objects.requireNonNull(r10);
            this.name_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.name_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setNumber(int r10) {
            this.number_ = r10;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setOneofIndex(int r10) {
            this.oneofIndex_ = r10;
            this.bitField0_ |= 32;
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

        public Builder setPacked(boolean r10) {
            this.packed_ = r10;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTypeUrl(String r10) {
            Objects.requireNonNull(r10);
            this.typeUrl_ = r10;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.typeUrl_ = r10;
            this.bitField0_ |= 16;
            onChanged();
            return this;
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
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Cardinality.class.getName());
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Cardinality(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Cardinality forNumber(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
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
        public static Cardinality valueOf(int r10) {
            return forNumber(r10);
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor r10) {
            if (r10.getType() != getDescriptor()) goto L11;
            if (r10.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r10.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Cardinality valueOf(String r10) {
            return (Cardinality) java.lang.Enum.valueOf(Cardinality.class, r10);
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
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Kind.class.getName());
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        private Kind(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Kind forNumber(int r10) {
            switch(r10) {
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
        public static Kind valueOf(int r10) {
            return forNumber(r10);
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor r10) {
            if (r10.getType() != getDescriptor()) goto L11;
            if (r10.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r10.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Kind valueOf(String r10) {
            return (Kind) java.lang.Enum.valueOf(Kind.class, r10);
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
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Field.class.getName());
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

    private Field(GeneratedMessage.Builder<?> r10) {
        super(r10);
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

    /* synthetic */ Field(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ boolean access$1002(Field r10, boolean r11) {
        r10.packed_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$1100(Field r10) {
        return r10.jsonName_;
    }

    static /* synthetic */ Object access$1102(Field r10, Object r11) {
        r10.jsonName_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$1200(Field r10) {
        return r10.defaultValue_;
    }

    static /* synthetic */ Object access$1202(Field r10, Object r11) {
        r10.defaultValue_ = r11;
        return r11;
    }

    static /* synthetic */ List access$300(Field r10) {
        return r10.options_;
    }

    static /* synthetic */ List access$302(Field r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    static /* synthetic */ int access$400(Field r10) {
        return r10.kind_;
    }

    static /* synthetic */ int access$402(Field r10, int r11) {
        r10.kind_ = r11;
        return r11;
    }

    static /* synthetic */ int access$500(Field r10) {
        return r10.cardinality_;
    }

    static /* synthetic */ int access$502(Field r10, int r11) {
        r10.cardinality_ = r11;
        return r11;
    }

    static /* synthetic */ int access$602(Field r10, int r11) {
        r10.number_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$700(Field r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$702(Field r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$800(Field r10) {
        return r10.typeUrl_;
    }

    static /* synthetic */ Object access$802(Field r10, Object r11) {
        r10.typeUrl_ = r11;
        return r11;
    }

    static /* synthetic */ int access$902(Field r10, int r11) {
        r10.oneofIndex_ = r11;
        return r11;
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

    public static Builder newBuilder(Field r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Field parseDelimitedFrom(InputStream r10) {
        return (Field) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Field parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Field) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Field parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Field parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Field parseFrom(CodedInputStream r10) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Field parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Field parseFrom(InputStream r10) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Field parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Field) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Field parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Field parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Field parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Field parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Field) == false) goto L8;
        Field r11 = (Field) r10;
        if (this.kind_ == r11.kind_) goto L13;
        return false;
    L13:
        if (this.cardinality_ == r11.cardinality_) goto L16;
        return false;
    L16:
        if (getNumber() == r11.getNumber()) goto L19;
        return false;
    L19:
        if (getName().equals(r11.getName()) == true) goto L22;
        return false;
    L22:
        if (getTypeUrl().equals(r11.getTypeUrl()) == true) goto L25;
        return false;
    L25:
        if (getOneofIndex() == r11.getOneofIndex()) goto L28;
        return false;
    L28:
        if (getPacked() == r11.getPacked()) goto L31;
        return false;
    L31:
        if (getOptionsList().equals(r11.getOptionsList()) == true) goto L34;
        return false;
    L34:
        if (getJsonName().equals(r11.getJsonName()) == true) goto L37;
        return false;
    L37:
        if (getDefaultValue().equals(r11.getDefaultValue()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r10 = Cardinality.forNumber(this.cardinality_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Cardinality.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Field getDefaultInstanceForType() {
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

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        Object r10 = this.defaultValue_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.defaultValue_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object r10 = this.defaultValue_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.defaultValue_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object r10 = this.jsonName_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.jsonName_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object r10 = this.jsonName_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.jsonName_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r10 = Kind.forNumber(this.kind_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Kind.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
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
    public Option getOptions(int r10) {
        return this.options_.get(r10);
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
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
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
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L8;
        int r12 = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    L10:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L12;
        r12 = r12 + CodedOutputStream.computeEnumSize(2, this.cardinality_);
    L12:
        int r13 = this.number_;
        if (r13 == 0) goto L16;
        r12 = r12 + CodedOutputStream.computeInt32Size(3, r13);
    L16:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L19;
        r12 = r12 + GeneratedMessage.computeStringSize(4, this.name_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L21;
        r12 = r12 + GeneratedMessage.computeStringSize(6, this.typeUrl_);
    L21:
        int r14 = this.oneofIndex_;
        if (r14 == 0) goto L24;
        r12 = r12 + CodedOutputStream.computeInt32Size(7, r14);
    L24:
        boolean r15 = this.packed_;
        if (r15 == false) goto L28;
        r12 = r12 + CodedOutputStream.computeBoolSize(8, r15);
    L28:
        if (r11 >= this.options_.size()) goto L31;
        r12 = r12 + CodedOutputStream.computeMessageSize(9, this.options_.get(r11));
        r11 = r11 + 1;
        goto L28
    L31:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L34;
        r12 = r12 + GeneratedMessage.computeStringSize(10, this.jsonName_);
    L34:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L36;
        r12 = r12 + GeneratedMessage.computeStringSize(11, this.defaultValue_);
    L36:
        int r16 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r16;
        return r16;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object r10 = this.typeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.typeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r10 = this.typeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.typeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + Internal.hashBoolean(getPacked());
        if (getOptionsCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 9) * 53) + getOptionsList().hashCode();
    L8:
        int r12 = (((((((((r11 * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L6;
        r10.writeEnum(1, this.kind_);
    L6:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L8;
        r10.writeEnum(2, this.cardinality_);
    L8:
        int r11 = this.number_;
        if (r11 == 0) goto L12;
        r10.writeInt32(3, r11);
    L12:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L15;
        GeneratedMessage.writeString(r10, 4, this.name_);
    L15:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L17;
        GeneratedMessage.writeString(r10, 6, this.typeUrl_);
    L17:
        int r12 = this.oneofIndex_;
        if (r12 == 0) goto L20;
        r10.writeInt32(7, r12);
    L20:
        boolean r13 = this.packed_;
        if (r13 == false) goto L23;
        r10.writeBool(8, r13);
    L23:
        int r14 = 0;
    L25:
        if (r14 >= this.options_.size()) goto L28;
        r10.writeMessage(9, this.options_.get(r14));
        r14 = r14 + 1;
        goto L25
    L28:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L31;
        GeneratedMessage.writeString(r10, 10, this.jsonName_);
    L31:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L33;
        GeneratedMessage.writeString(r10, 11, this.defaultValue_);
    L33:
        getUnknownFields().writeTo(r10);
    }
}
