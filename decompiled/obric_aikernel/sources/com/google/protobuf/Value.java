package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Value extends GeneratedMessage implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static final Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ValueOrBuilder {
        private int bitField0_;
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> listValueBuilder_;
        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> structValueBuilder_;

        private Builder() {
            this.kindCase_ = 0;
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.kindCase_ = 0;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Value r10) {
        }

        private void buildPartialOneofs(Value r10) {
            Value.access$302(r10, this.kindCase_);
            Value.access$402(r10, this.kind_);
            if (this.kindCase_ != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 == null) goto L8;
            Value.access$402(r10, r11.build());
        L8:
            if (this.kindCase_ != 6) goto L13;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r12 = this.listValueBuilder_;
            if (r12 == null) goto L14;
            Value.access$402(r10, r12.build());
            return;
        L14:
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        private SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> internalGetListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        L5:
            if (this.kindCase_ == 6) goto L7;
            this.kind_ = ListValue.getDefaultInstance();
        L7:
            this.listValueBuilder_ = new SingleFieldBuilder((ListValue) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
        }

        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> internalGetStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        L5:
            if (this.kindCase_ == 5) goto L7;
            this.kind_ = Struct.getDefaultInstance();
        L7:
            this.structValueBuilder_ = new SingleFieldBuilder((Struct) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
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
        public Value build() {
            Value r10 = buildPartial();
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
        public Value buildPartial() {
            Value r10 = new Value(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            buildPartialOneofs(r10);
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
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 == null) goto L8;
            r11.clear();
        L8:
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
        }

        public Builder clearBoolValue() {
            if (this.kindCase_ != 4) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        public Builder clearListValue() {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L8;
            if (this.kindCase_ != 6) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 6) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r10.clear();
            goto L11
        }

        public Builder clearNullValue() {
            if (this.kindCase_ != 1) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearNumberValue() {
            if (this.kindCase_ != 2) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearStringValue() {
            if (this.kindCase_ != 3) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L8;
            if (this.kindCase_ != 5) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 5) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r10.clear();
            goto L11
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) goto L5;
            return false;
        L5:
            return ((Boolean) this.kind_).booleanValue();
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
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L12;
            if (this.kindCase_ != 6) goto L10;
            Object r11 = this.kind_;
        L8:
            return (ListValue) r11;
        L10:
            return ListValue.getDefaultInstance();
        L12:
            if (this.kindCase_ != 6) goto L15;
            r11 = r10.getMessage();
            goto L8
        L15:
            return ListValue.getDefaultInstance();
        }

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) internalGetListValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            int r10 = this.kindCase_;
            if (r10 != 6) goto L8;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 == null) goto L8;
            return (ListValueOrBuilder) r11.getMessageOrBuilder();
        L8:
            if (r10 != 6) goto L12;
            return (ListValue) this.kind_;
        L12:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ != 1) goto L9;
            NullValue r10 = NullValue.forNumber(((Integer) this.kind_).intValue());
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NullValue.UNRECOGNIZED;
        L9:
            return NullValue.NULL_VALUE;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            if (this.kindCase_ == 1) goto L5;
            return 0;
        L5:
            return ((Integer) this.kind_).intValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) goto L5;
            return 0.0d;
        L5:
            return ((Double) this.kind_).doubleValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public String getStringValue() {
            if (this.kindCase_ != 3) goto L5;
            Object r10 = this.kind_;
        L7:
            if ((r10 instanceof String) == true) goto L13;
            String r11 = ((ByteString) r10).toStringUtf8();
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r11;
        L11:
            return r11;
        L13:
            return (String) r10;
        L5:
            r10 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            if (this.kindCase_ != 3) goto L5;
            Object r10 = this.kind_;
        L7:
            if ((r10 instanceof String) == false) goto L13;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r11;
        L11:
            return r11;
        L13:
            return (ByteString) r10;
        L5:
            r10 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L12;
            if (this.kindCase_ != 5) goto L10;
            Object r11 = this.kind_;
        L8:
            return (Struct) r11;
        L10:
            return Struct.getDefaultInstance();
        L12:
            if (this.kindCase_ != 5) goto L15;
            r11 = r10.getMessage();
            goto L8
        L15:
            return Struct.getDefaultInstance();
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) internalGetStructValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            int r10 = this.kindCase_;
            if (r10 != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 == null) goto L8;
            return (StructOrBuilder) r11.getMessageOrBuilder();
        L8:
            if (r10 != 5) goto L12;
            return (Struct) this.kind_;
        L12:
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasBoolValue() {
            if (this.kindCase_ != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            if (this.kindCase_ != 6) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasNullValue() {
            if (this.kindCase_ == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasNumberValue() {
            if (this.kindCase_ != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStringValue() {
            if (this.kindCase_ != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            if (this.kindCase_ != 5) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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
            if (r12 == true) goto L37;
            int r13 = r10.readTag();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r13 == 0) goto L29;
            if (r13 == 8) goto L27;
            if (r13 != 17) goto L11;
            this.kind_ = Double.valueOf(r10.readDouble());     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L11:
            if (r13 != 26) goto L13;
            Object r14 = r10.readStringRequireUtf8();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 3;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L25:
            this.kind_ = r14;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L13:
            if (r13 != 32) goto L15;
            this.kind_ = Boolean.valueOf(r10.readBool());     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 4;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L15:
            if (r13 != 42) goto L17;
            r10.readMessage(internalGetStructValueFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 5;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L17:
            if (r13 != 50) goto L19;
            r10.readMessage(internalGetListValueFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 6;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L19:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L27:
            int r15 = r10.readEnum();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            r14 = Integer.valueOf(r15);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L29:
            r12 = true;
            goto L3
        L32:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            onChanged();
            throw th;
        L37:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Value) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Value) r10);
        }

        public Builder mergeFrom(Value r10) {
            if (r10 != Value.getDefaultInstance()) goto L5;
            return this;
        L5:
            int r11 = r10.getKindCase().ordinal();
            if (r11 != 0) goto L8;
            setNullValueValue(r10.getNullValueValue());
        L23:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L8:
            if (r11 != 1) goto L10;
            setNumberValue(r10.getNumberValue());
            goto L23
        L10:
            if (r11 == 2) goto L20;
            if (r11 != 3) goto L13;
            setBoolValue(r10.getBoolValue());
            goto L23
        L13:
            if (r11 != 4) goto L15;
            mergeStructValue(r10.getStructValue());
            goto L23
        L15:
            if (r11 != 5) goto L23;
            mergeListValue(r10.getListValue());
            goto L23
        L20:
            this.kindCase_ = 3;
            this.kind_ = Value.access$400(r10);
            onChanged();
            goto L23
        }

        public Builder mergeListValue(ListValue r10) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 != null) goto L11;
            if (this.kindCase_ == 6) goto L7;
        L9:
            this.kind_ = r10;
            onChanged();
        L14:
            this.kindCase_ = 6;
            return this;
        L7:
            if (this.kind_ == ListValue.getDefaultInstance()) goto L9;
            r10 = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(r10).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 6) goto L13;
            r11.mergeFrom(r10);
            goto L14
        L13:
            r11.setMessage(r10);
            goto L14
        }

        public Builder mergeStructValue(Struct r10) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L11;
            if (this.kindCase_ == 5) goto L7;
        L9:
            this.kind_ = r10;
            onChanged();
        L14:
            this.kindCase_ = 5;
            return this;
        L7:
            if (this.kind_ == Struct.getDefaultInstance()) goto L9;
            r10 = Struct.newBuilder((Struct) this.kind_).mergeFrom(r10).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 5) goto L13;
            r11.mergeFrom(r10);
            goto L14
        L13:
            r11.setMessage(r10);
            goto L14
        }

        public Builder setBoolValue(boolean r10) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(r10);
            onChanged();
            return this;
        }

        public Builder setListValue(ListValue.Builder r10) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            ListValue r12 = r10.build();
            if (r11 != null) goto L5;
            this.kind_ = r12;
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setListValue(ListValue r10) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            this.kind_ = r10;
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }

        public Builder setNullValue(NullValue r10) {
            Objects.requireNonNull(r10);
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r10.getNumber());
            onChanged();
            return this;
        }

        public Builder setNullValueValue(int r10) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r10);
            onChanged();
            return this;
        }

        public Builder setNumberValue(double r10) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(r10);
            onChanged();
            return this;
        }

        public Builder setStringValue(String r10) {
            Objects.requireNonNull(r10);
            this.kindCase_ = 3;
            this.kind_ = r10;
            onChanged();
            return this;
        }

        public Builder setStringValueBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.kindCase_ = 3;
            this.kind_ = r10;
            onChanged();
            return this;
        }

        public Builder setStructValue(Struct.Builder r10) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            Struct r12 = r10.build();
            if (r11 != null) goto L5;
            this.kind_ = r12;
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setStructValue(Struct r10) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r11 = this.structValueBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            this.kind_ = r10;
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }
    }

    public static final enum KindCase extends java.lang.Enum<KindCase> implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        private static final /* synthetic */ KindCase[] $VALUES = null;
        public static final KindCase BOOL_VALUE = null;
        public static final KindCase KIND_NOT_SET = null;
        public static final KindCase LIST_VALUE = null;
        public static final KindCase NULL_VALUE = null;
        public static final KindCase NUMBER_VALUE = null;
        public static final KindCase STRING_VALUE = null;
        public static final KindCase STRUCT_VALUE = null;
        private final int value;

        private static /* synthetic */ KindCase[] $values() {
            return new KindCase[]{NULL_VALUE, NUMBER_VALUE, STRING_VALUE, BOOL_VALUE, STRUCT_VALUE, LIST_VALUE, KIND_NOT_SET};
        }

        static {
            NULL_VALUE = new KindCase("NULL_VALUE", 0, 1);
            NUMBER_VALUE = new KindCase("NUMBER_VALUE", 1, 2);
            STRING_VALUE = new KindCase("STRING_VALUE", 2, 3);
            BOOL_VALUE = new KindCase("BOOL_VALUE", 3, 4);
            STRUCT_VALUE = new KindCase("STRUCT_VALUE", 4, 5);
            LIST_VALUE = new KindCase("LIST_VALUE", 5, 6);
            KIND_NOT_SET = new KindCase("KIND_NOT_SET", 6, 0);
            $VALUES = $values();
        }

        private KindCase(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static KindCase forNumber(int r10) {
            switch(r10) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return LIST_VALUE;
        L8:
            return STRUCT_VALUE;
        L10:
            return BOOL_VALUE;
        L12:
            return STRING_VALUE;
        L14:
            return NUMBER_VALUE;
        L16:
            return NULL_VALUE;
        L18:
            return KIND_NOT_SET;
        }

        @Deprecated
        public static KindCase valueOf(int r10) {
            return forNumber(r10);
        }

        public static KindCase valueOf(String r10) {
            return (KindCase) java.lang.Enum.valueOf(KindCase.class, r10);
        }

        public static KindCase[] values() {
            return (KindCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Value.class.getName());
        DEFAULT_INSTANCE = new Value();
        PARSER = new AnonymousClass1();
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    private Value(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Value(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ int access$302(Value r10, int r11) {
        r10.kindCase_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$400(Value r10) {
        return r10.kind_;
    }

    static /* synthetic */ Object access$402(Value r10, Object r11) {
        r10.kind_ = r11;
        return r11;
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Value parseDelimitedFrom(InputStream r10) {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Value parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Value parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Value parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Value parseFrom(CodedInputStream r10) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Value parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Value parseFrom(InputStream r10) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Value parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Value parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Value parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Value parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Value parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Value) == false) goto L8;
        Value r11 = (Value) r10;
        if (getKindCase().equals(r11.getKindCase()) == true) goto L13;
        return false;
    L13:
        switch(this.kindCase_) {
            case 1: goto L31;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L22;
            case 5: goto L19;
            case 6: goto L16;
            default: goto L34;
        };
    L16:
        if (getListValue().equals(r11.getListValue()) == true) goto L34;
        return false;
    L19:
        if (getStructValue().equals(r11.getStructValue()) == true) goto L34;
        return false;
    L22:
        if (getBoolValue() == r11.getBoolValue()) goto L34;
        return false;
    L25:
        if (getStringValue().equals(r11.getStringValue()) == true) goto L34;
        return false;
    L28:
        if (Double.doubleToLongBits(getNumberValue()) == Double.doubleToLongBits(r11.getNumberValue())) goto L34;
        return false;
    L31:
        if (getNullValueValue() == r11.getNullValueValue()) goto L34;
        return false;
    L34:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.kind_).booleanValue();
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
    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) goto L9;
        NullValue r10 = NullValue.forNumber(((Integer) this.kind_).intValue());
        if (r10 == null) goto L7;
        return r10;
    L7:
        return NullValue.UNRECOGNIZED;
    L9:
        return NullValue.NULL_VALUE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) goto L5;
        return 0;
    L5:
        return ((Integer) this.kind_).intValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) goto L5;
        return 0.0d;
    L5:
        return ((Double) this.kind_).doubleValue();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (this.kindCase_ != 1) goto L9;
        r11 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
    L9:
        if (this.kindCase_ != 2) goto L12;
        r11 = r11 + CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
    L12:
        if (this.kindCase_ != 3) goto L15;
        r11 = r11 + GeneratedMessage.computeStringSize(3, this.kind_);
    L15:
        if (this.kindCase_ != 4) goto L18;
        r11 = r11 + CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
    L18:
        if (this.kindCase_ != 5) goto L21;
        r11 = r11 + CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
    L21:
        if (this.kindCase_ != 6) goto L23;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
    L23:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ != 3) goto L5;
        Object r10 = this.kind_;
    L7:
        if ((r10 instanceof String) == true) goto L9;
        String r11 = ((ByteString) r10).toStringUtf8();
        if (this.kindCase_ != 3) goto L13;
        this.kind_ = r11;
    L13:
        return r11;
    L9:
        return (String) r10;
    L5:
        r10 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        Object r10 = this.kind_;
    L7:
        if ((r10 instanceof String) == false) goto L13;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        if (this.kindCase_ != 3) goto L11;
        this.kind_ = r11;
    L11:
        return r11;
    L13:
        return (ByteString) r10;
    L5:
        r10 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        if (this.kindCase_ != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        if (this.kindCase_ != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        if (this.kindCase_ == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        if (this.kindCase_ != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        if (this.kindCase_ != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        if (this.kindCase_ != 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = 779 + getDescriptor().hashCode();
        switch(this.kindCase_) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L15;
        };
    L8:
        int r12 = ((r11 * 37) + 6) * 53;
        int r13 = getListValue().hashCode();
    L14:
        r11 = r12 + r13;
        goto L15
    L9:
        r12 = ((r11 * 37) + 5) * 53;
        r13 = getStructValue().hashCode();
        goto L14
    L10:
        r12 = ((r11 * 37) + 4) * 53;
        r13 = Internal.hashBoolean(getBoolValue());
        goto L14
    L11:
        r12 = ((r11 * 37) + 3) * 53;
        r13 = getStringValue().hashCode();
        goto L14
    L12:
        r12 = ((r11 * 37) + 2) * 53;
        r13 = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
        goto L14
    L13:
        r12 = ((r11 * 37) + 1) * 53;
        r13 = getNullValueValue();
    L15:
        int r14 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r14;
        return r14;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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
        if (this.kindCase_ != 1) goto L6;
        r10.writeEnum(1, ((Integer) this.kind_).intValue());
    L6:
        if (this.kindCase_ != 2) goto L9;
        r10.writeDouble(2, ((Double) this.kind_).doubleValue());
    L9:
        if (this.kindCase_ != 3) goto L12;
        GeneratedMessage.writeString(r10, 3, this.kind_);
    L12:
        if (this.kindCase_ != 4) goto L15;
        r10.writeBool(4, ((Boolean) this.kind_).booleanValue());
    L15:
        if (this.kindCase_ != 5) goto L18;
        r10.writeMessage(5, (Struct) this.kind_);
    L18:
        if (this.kindCase_ != 6) goto L20;
        r10.writeMessage(6, (ListValue) this.kind_);
    L20:
        getUnknownFields().writeTo(r10);
    }
}
