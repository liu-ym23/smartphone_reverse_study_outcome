package com.google.protobuf;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Field r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Field.access$402(r3, this.kind_);
        L6:
            if ((r0 & 2) == 0) goto L9;
            Field.access$502(r3, this.cardinality_);
        L9:
            if ((r0 & 4) == 0) goto L12;
            Field.access$602(r3, this.number_);
        L12:
            if ((r0 & 8) == 0) goto L15;
            Field.access$702(r3, this.name_);
        L15:
            if ((r0 & 16) == 0) goto L18;
            Field.access$802(r3, this.typeUrl_);
        L18:
            if ((r0 & 32) == 0) goto L21;
            Field.access$902(r3, this.oneofIndex_);
        L21:
            if ((r0 & 64) == 0) goto L24;
            Field.access$1002(r3, this.packed_);
        L24:
            if ((r0 & 256) == 0) goto L27;
            Field.access$1102(r3, this.jsonName_);
        L27:
            if ((r0 & 512) == 0) goto L30;
            Field.access$1202(r3, this.defaultValue_);
            return;
        }

        private void buildPartialRepeatedFields(Field r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            Field.access$302(r2, r1);
            return;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -129;
        L7:
            r1 = this.options_;
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
            List<Option> r1 = this.options_;
            if ((this.bitField0_ & 128) == 0) goto L7;
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
        public Field build() {
            Field r1 = buildPartial();
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
        public Field buildPartial() {
            Field r0 = new Field(this, null);
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -129;
            this.jsonName_ = "";
            this.defaultValue_ = "";
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
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
            Cardinality r0 = Cardinality.forNumber(this.cardinality_);
            if (r0 == null) goto L5;
            return r0;
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
            Object r0 = this.defaultValue_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.defaultValue_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object r0 = this.defaultValue_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.defaultValue_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object r0 = this.jsonName_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.jsonName_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object r0 = this.jsonName_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.jsonName_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind r0 = Kind.forNumber(this.kind_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Kind.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object r0 = this.typeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.typeUrl_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r0 = this.typeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.typeUrl_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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
            if (r0 == true) goto L31;
            int r1 = r5.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            switch(r1) {
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
            this.defaultValue_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 512;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L8:
            this.jsonName_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 256;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L9:
            Option r2 = (Option) ZeusTransformUtils.preCheckCast(r5.readMessage(Option.parser(), r6), Option.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r3 == null) goto L11;
            r3.addMessage(r2);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L11:
            ensureOptionsIsMutable();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.options_.add(r2);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L13:
            this.packed_ = r5.readBool();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 64;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L14:
            this.oneofIndex_ = r5.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 32;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L15:
            this.typeUrl_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L16:
            this.name_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L17:
            this.number_ = r5.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L18:
            this.cardinality_ = r5.readEnum();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L19:
            this.kind_ = r5.readEnum();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L21:
            r0 = true;
            goto L3
        L22:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
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

        public Builder mergeFrom(Field r3) {
            if (r3 != Field.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Field.access$400(r3) == 0) goto L9;
            setKindValue(r3.getKindValue());
        L9:
            if (Field.access$500(r3) == 0) goto L12;
            setCardinalityValue(r3.getCardinalityValue());
        L12:
            if (r3.getNumber() == 0) goto L15;
            setNumber(r3.getNumber());
        L15:
            if (r3.getName().isEmpty() == true) goto L18;
            this.name_ = Field.access$700(r3);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r3.getTypeUrl().isEmpty() == true) goto L21;
            this.typeUrl_ = Field.access$800(r3);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r3.getOneofIndex() == 0) goto L24;
            setOneofIndex(r3.getOneofIndex());
        L24:
            if (r3.getPacked() == false) goto L27;
            setPacked(r3.getPacked());
        L27:
            if (this.optionsBuilder_ != null) goto L36;
            if (Field.access$300(r3).isEmpty() == true) goto L45;
            if (this.options_.isEmpty() == false) goto L33;
            this.options_ = Field.access$300(r3);
            this.bitField0_ &= -129;
        L34:
            onChanged();
            goto L45
        L33:
            ensureOptionsIsMutable();
            this.options_.addAll(Field.access$300(r3));
        L45:
            if (r3.getJsonName().isEmpty() == true) goto L48;
            this.jsonName_ = Field.access$1100(r3);
            this.bitField0_ |= 256;
            onChanged();
        L48:
            if (r3.getDefaultValue().isEmpty() == true) goto L50;
            this.defaultValue_ = Field.access$1200(r3);
            this.bitField0_ |= 512;
            onChanged();
        L50:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        L36:
            if (Field.access$300(r3).isEmpty() == true) goto L45;
            if (this.optionsBuilder_.isEmpty() == false) goto L43;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = null;
            this.optionsBuilder_ = null;
            this.options_ = Field.access$300(r3);
            this.bitField0_ &= -129;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L42;
            r0 = internalGetOptionsFieldBuilder();
        L42:
            this.optionsBuilder_ = r0;
            goto L45
        L43:
            this.optionsBuilder_.addAllMessages(Field.access$300(r3));
            goto L45
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Field.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Field) ZeusTransformUtils.preCheckCast(r4, Field.class, "com.obric.memorydata.plugin"));
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

        public Builder setCardinality(Cardinality r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 2;
            this.cardinality_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setCardinalityValue(int r1) {
            this.cardinality_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDefaultValue(String r1) {
            Objects.requireNonNull(r1);
            this.defaultValue_ = r1;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDefaultValueBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.defaultValue_ = r1;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setJsonName(String r1) {
            Objects.requireNonNull(r1);
            this.jsonName_ = r1;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setJsonNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.jsonName_ = r1;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setKind(Kind r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 1;
            this.kind_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setKindValue(int r1) {
            this.kind_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setName(String r1) {
            Objects.requireNonNull(r1);
            this.name_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.name_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setNumber(int r1) {
            this.number_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setOneofIndex(int r1) {
            this.oneofIndex_ = r1;
            this.bitField0_ |= 32;
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

        public Builder setPacked(boolean r1) {
            this.packed_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTypeUrl(String r1) {
            Objects.requireNonNull(r1);
            this.typeUrl_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.typeUrl_ = r1;
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

        private Cardinality(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Cardinality forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
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
            return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(Field.getDescriptor().getEnumTypes().get(1), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Cardinality valueOf(int r0) {
            return forNumber(r0);
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor r2) {
            if (r2.getType() != getDescriptor()) goto L11;
            if (r2.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r2.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Cardinality valueOf(String r2) {
            return (Cardinality) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Cardinality.class, r2), Cardinality.class, "com.obric.memorydata.plugin");
        }

        public static Cardinality[] values() {
            return (Cardinality[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Cardinality[].class, "com.obric.memorydata.plugin");
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
            return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
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

        private Kind(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Kind forNumber(int r0) {
            switch(r0) {
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
            return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(Field.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Kind valueOf(int r0) {
            return forNumber(r0);
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor r2) {
            if (r2.getType() != getDescriptor()) goto L11;
            if (r2.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r2.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
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
            return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
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

    private Field(GeneratedMessage.Builder<?> r2) {
        super(r2);
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

    /* synthetic */ Field(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ boolean access$1002(Field r0, boolean r1) {
        r0.packed_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$1100(Field r0) {
        return r0.jsonName_;
    }

    static /* synthetic */ Object access$1102(Field r0, Object r1) {
        r0.jsonName_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$1200(Field r0) {
        return r0.defaultValue_;
    }

    static /* synthetic */ Object access$1202(Field r0, Object r1) {
        r0.defaultValue_ = r1;
        return r1;
    }

    static /* synthetic */ List access$300(Field r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$302(Field r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ int access$400(Field r0) {
        return r0.kind_;
    }

    static /* synthetic */ int access$402(Field r0, int r1) {
        r0.kind_ = r1;
        return r1;
    }

    static /* synthetic */ int access$500(Field r0) {
        return r0.cardinality_;
    }

    static /* synthetic */ int access$502(Field r0, int r1) {
        r0.cardinality_ = r1;
        return r1;
    }

    static /* synthetic */ int access$602(Field r0, int r1) {
        r0.number_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$700(Field r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$702(Field r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$800(Field r0) {
        return r0.typeUrl_;
    }

    static /* synthetic */ Object access$802(Field r0, Object r1) {
        r0.typeUrl_ = r1;
        return r1;
    }

    static /* synthetic */ int access$902(Field r0, int r1) {
        r0.oneofIndex_ = r1;
        return r1;
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

    public static Builder newBuilder(Field r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Field parseDelimitedFrom(InputStream r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(ByteString r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(CodedInputStream r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(InputStream r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(ByteBuffer r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(byte[] r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Field parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Field) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Field.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Field.class) == false) goto L8;
        Field r6 = (Field) ZeusTransformUtils.preCheckCast(r5, Field.class, "com.obric.memorydata.plugin");
        if (this.kind_ == r6.kind_) goto L13;
        return false;
    L13:
        if (this.cardinality_ == r6.cardinality_) goto L16;
        return false;
    L16:
        if (getNumber() == r6.getNumber()) goto L19;
        return false;
    L19:
        if (getName().equals(r6.getName()) == true) goto L22;
        return false;
    L22:
        if (getTypeUrl().equals(r6.getTypeUrl()) == true) goto L25;
        return false;
    L25:
        if (getOneofIndex() == r6.getOneofIndex()) goto L28;
        return false;
    L28:
        if (getPacked() == r6.getPacked()) goto L31;
        return false;
    L31:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L34;
        return false;
    L34:
        if (getJsonName().equals(r6.getJsonName()) == true) goto L37;
        return false;
    L37:
        if (getDefaultValue().equals(r6.getDefaultValue()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r0 = Cardinality.forNumber(this.cardinality_);
        if (r0 == null) goto L5;
        return r0;
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
        Object r0 = this.defaultValue_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.defaultValue_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object r0 = this.defaultValue_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.defaultValue_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object r0 = this.jsonName_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.jsonName_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object r0 = this.jsonName_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.jsonName_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r0 = Kind.forNumber(this.kind_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Kind.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.memorydata.plugin");
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
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.memorydata.plugin");
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
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L8;
        int r1 = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    L10:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L12;
        r1 = r1 + CodedOutputStream.computeEnumSize(2, this.cardinality_);
    L12:
        int r3 = this.number_;
        if (r3 == 0) goto L16;
        r1 = r1 + CodedOutputStream.computeInt32Size(3, r3);
    L16:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L19;
        r1 = r1 + GeneratedMessage.computeStringSize(4, this.name_);
    L19:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L21;
        r1 = r1 + GeneratedMessage.computeStringSize(6, this.typeUrl_);
    L21:
        int r4 = this.oneofIndex_;
        if (r4 == 0) goto L24;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, r4);
    L24:
        boolean r5 = this.packed_;
        if (r5 == false) goto L28;
        r1 = r1 + CodedOutputStream.computeBoolSize(8, r5);
    L28:
        if (r2 >= this.options_.size()) goto L31;
        r1 = r1 + CodedOutputStream.computeMessageSize(9, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r2), MessageLite.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L28
    L31:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L34;
        r1 = r1 + GeneratedMessage.computeStringSize(10, this.jsonName_);
    L34:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L36;
        r1 = r1 + GeneratedMessage.computeStringSize(11, this.defaultValue_);
    L36:
        int r6 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r6;
        return r6;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object r0 = this.typeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.typeUrl_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r0 = this.typeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.typeUrl_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + Internal.hashBoolean(getPacked());
        if (getOptionsCount() <= 0) goto L9;
        r0 = (((r0 * 37) + 9) * 53) + getOptionsList().hashCode();
    L9:
        int r1 = (((((((((r0 * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L6;
        r6.writeEnum(1, this.kind_);
    L6:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L8;
        r6.writeEnum(2, this.cardinality_);
    L8:
        int r0 = this.number_;
        if (r0 == 0) goto L12;
        r6.writeInt32(3, r0);
    L12:
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L15;
        GeneratedMessage.writeString(r6, 4, this.name_);
    L15:
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L17;
        GeneratedMessage.writeString(r6, 6, this.typeUrl_);
    L17:
        int r1 = this.oneofIndex_;
        if (r1 == 0) goto L20;
        r6.writeInt32(7, r1);
    L20:
        boolean r2 = this.packed_;
        if (r2 == false) goto L23;
        r6.writeBool(8, r2);
    L23:
        int r3 = 0;
    L25:
        if (r3 >= this.options_.size()) goto L28;
        r6.writeMessage(9, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r3), MessageLite.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L25
    L28:
        if (GeneratedMessage.isStringEmpty(this.jsonName_) == true) goto L31;
        GeneratedMessage.writeString(r6, 10, this.jsonName_);
    L31:
        if (GeneratedMessage.isStringEmpty(this.defaultValue_) == true) goto L33;
        GeneratedMessage.writeString(r6, 11, this.defaultValue_);
    L33:
        getUnknownFields().writeTo(r6);
    }
}
