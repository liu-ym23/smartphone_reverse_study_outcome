package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
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

        private void buildPartial0(Value r8) {
        }

        private void buildPartialOneofs(Value r8) {
            Value.access$302(r8, this.kindCase_);
            Value.access$402(r8, this.kind_);
            if (this.kindCase_ != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 == null) goto L8;
            Value.access$402(r8, r10.build());
        L8:
            if (this.kindCase_ != 6) goto L13;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r11 = this.listValueBuilder_;
            if (r11 == null) goto L14;
            Value.access$402(r8, r11.build());
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
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
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
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r8 = this.listValueBuilder_;
            if (r8 != null) goto L8;
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
            r8.clear();
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
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r8 = this.structValueBuilder_;
            if (r8 != null) goto L8;
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
            r8.clear();
            goto L11
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) goto L5;
            return false;
        L5:
            return ((Boolean) this.kind_).booleanValue();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
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
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r8 = this.listValueBuilder_;
            if (r8 != null) goto L12;
            if (this.kindCase_ != 6) goto L10;
            Object r10 = this.kind_;
        L8:
            return (ListValue) r10;
        L10:
            return ListValue.getDefaultInstance();
        L12:
            if (this.kindCase_ != 6) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return ListValue.getDefaultInstance();
        }

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) internalGetListValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            int r8 = this.kindCase_;
            if (r8 != 6) goto L8;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 == null) goto L8;
            return (ListValueOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 6) goto L12;
            return (ListValue) this.kind_;
        L12:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ != 1) goto L9;
            NullValue r8 = NullValue.forNumber(((Integer) this.kind_).intValue());
            if (r8 == null) goto L7;
            return r8;
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
            Object r8 = this.kind_;
        L7:
            if ((r8 instanceof String) == true) goto L13;
            String r10 = ((ByteString) r8).toStringUtf8();
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r10;
        L11:
            return r10;
        L13:
            return (String) r8;
        L5:
            r8 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            if (this.kindCase_ != 3) goto L5;
            Object r8 = this.kind_;
        L7:
            if ((r8 instanceof String) == false) goto L13;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r10;
        L11:
            return r10;
        L13:
            return (ByteString) r8;
        L5:
            r8 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r8 = this.structValueBuilder_;
            if (r8 != null) goto L12;
            if (this.kindCase_ != 5) goto L10;
            Object r10 = this.kind_;
        L8:
            return (Struct) r10;
        L10:
            return Struct.getDefaultInstance();
        L12:
            if (this.kindCase_ != 5) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return Struct.getDefaultInstance();
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) internalGetStructValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            int r8 = this.kindCase_;
            if (r8 != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 == null) goto L8;
            return (StructOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 5) goto L12;
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
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeListValue(ListValue r8) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L11;
            if (this.kindCase_ == 6) goto L7;
        L9:
            this.kind_ = r8;
            onChanged();
        L14:
            this.kindCase_ = 6;
            return this;
        L7:
            if (this.kind_ == ListValue.getDefaultInstance()) goto L9;
            r8 = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 6) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        public Builder mergeStructValue(Struct r8) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L11;
            if (this.kindCase_ == 5) goto L7;
        L9:
            this.kind_ = r8;
            onChanged();
        L14:
            this.kindCase_ = 5;
            return this;
        L7:
            if (this.kind_ == Struct.getDefaultInstance()) goto L9;
            r8 = Struct.newBuilder((Struct) this.kind_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 5) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        public Builder setBoolValue(boolean r8) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(r8);
            onChanged();
            return this;
        }

        public Builder setListValue(ListValue.Builder r8) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            ListValue r11 = r8.build();
            if (r10 != null) goto L5;
            this.kind_ = r11;
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNullValue(NullValue r8) {
            if (r8 == null) goto L6;
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r8.getNumber());
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNullValueValue(int r8) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r8);
            onChanged();
            return this;
        }

        public Builder setNumberValue(double r8) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(r8);
            onChanged();
            return this;
        }

        public Builder setStringValue(String r8) {
            if (r8 == null) goto L6;
            this.kindCase_ = 3;
            this.kind_ = r8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStringValueBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.kindCase_ = 3;
            this.kind_ = r8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStructValue(Struct.Builder r8) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            Struct r11 = r8.build();
            if (r10 != null) goto L5;
            this.kind_ = r11;
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.kindCase_ = 0;
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setListValue(ListValue r8) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.kind_ = r8;
            onChanged();
        L9:
            this.kindCase_ = 6;
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setStructValue(Struct r8) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r10 = this.structValueBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.kind_ = r8;
            onChanged();
        L9:
            this.kindCase_ = 5;
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

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value build() {
            Value r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value buildPartial() {
            Value r8 = new Value(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            buildPartialOneofs(r8);
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
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
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r8 = this.structValueBuilder_;
            if (r8 == null) goto L5;
            r8.clear();
        L5:
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r10 = this.listValueBuilder_;
            if (r10 == null) goto L8;
            r10.clear();
        L8:
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
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
            if (r10 == null) goto L41;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L38;
            int r12 = r8.readTag();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            if (r12 == 0) goto L30;
            if (r12 == 8) goto L28;
            if (r12 != 17) goto L12;
            this.kind_ = Double.valueOf(r8.readDouble());     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 2;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L12:
            if (r12 != 26) goto L14;
            Object r13 = r8.readStringRequireUtf8();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 3;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L26:
            this.kind_ = r13;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.kind_ = Boolean.valueOf(r8.readBool());     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 4;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L16:
            if (r12 != 42) goto L18;
            r8.readMessage(internalGetStructValueFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 5;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L18:
            if (r12 != 50) goto L20;
            r8.readMessage(internalGetListValueFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 6;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L28:
            int r14 = r8.readEnum();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.kindCase_ = 1;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            r13 = Integer.valueOf(r14);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L30:
            r11 = true;
            goto L4
        L33:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            onChanged();
            return this;
        L41:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Value) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Value) r8);
        }

        public Builder mergeFrom(Value r8) {
            if (r8 != Value.getDefaultInstance()) goto L5;
            return this;
        L5:
            int r10 = r8.getKindCase().ordinal();
            if (r10 != 0) goto L8;
            setNullValueValue(r8.getNullValueValue());
        L23:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L8:
            if (r10 != 1) goto L10;
            setNumberValue(r8.getNumberValue());
            goto L23
        L10:
            if (r10 == 2) goto L20;
            if (r10 != 3) goto L13;
            setBoolValue(r8.getBoolValue());
            goto L23
        L13:
            if (r10 != 4) goto L15;
            mergeStructValue(r8.getStructValue());
            goto L23
        L15:
            if (r10 != 5) goto L23;
            mergeListValue(r8.getListValue());
            goto L23
        L20:
            this.kindCase_ = 3;
            this.kind_ = Value.access$400(r8);
            onChanged();
            goto L23
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

        private KindCase(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static KindCase forNumber(int r8) {
            switch(r8) {
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
        public static KindCase valueOf(int r8) {
            return forNumber(r8);
        }

        public static KindCase[] values() {
            return (KindCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        public static KindCase valueOf(String r8) {
            return (KindCase) java.lang.Enum.valueOf(KindCase.class, r8);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Value");
        DEFAULT_INSTANCE = new Value();
        PARSER = new AnonymousClass1();
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ int access$302(Value r8, int r10) {
        r8.kindCase_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(Value r8) {
        return r8.kind_;
    }

    public static /* synthetic */ Object access$402(Value r8, Object r10) {
        r8.kind_ = r10;
        return r10;
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

    public static Value parseDelimitedFrom(InputStream r8) {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Value parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Value) == false) goto L8;
        Value r10 = (Value) r8;
        if (getKindCase().equals(r10.getKindCase()) == true) goto L13;
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
        if (getListValue().equals(r10.getListValue()) == true) goto L34;
        return false;
    L19:
        if (getStructValue().equals(r10.getStructValue()) == true) goto L34;
        return false;
    L22:
        if (getBoolValue() == r10.getBoolValue()) goto L34;
        return false;
    L25:
        if (getStringValue().equals(r10.getStringValue()) == true) goto L34;
        return false;
    L28:
        if (Double.doubleToLongBits(getNumberValue()) == Double.doubleToLongBits(r10.getNumberValue())) goto L34;
        return false;
    L31:
        if (getNullValueValue() == r10.getNullValueValue()) goto L34;
        return false;
    L34:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.kind_).booleanValue();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
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
        NullValue r8 = NullValue.forNumber(((Integer) this.kind_).intValue());
        if (r8 == null) goto L7;
        return r8;
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
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (this.kindCase_ != 1) goto L9;
        r10 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
    L9:
        if (this.kindCase_ != 2) goto L12;
        r10 = r10 + CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
    L12:
        if (this.kindCase_ != 3) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.kind_);
    L15:
        if (this.kindCase_ != 4) goto L18;
        r10 = r10 + CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
    L18:
        if (this.kindCase_ != 5) goto L21;
        r10 = r10 + CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
    L21:
        if (this.kindCase_ != 6) goto L23;
        r10 = r10 + CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
    L23:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ != 3) goto L5;
        Object r8 = this.kind_;
    L7:
        if ((r8 instanceof String) == true) goto L9;
        String r10 = ((ByteString) r8).toStringUtf8();
        if (this.kindCase_ != 3) goto L13;
        this.kind_ = r10;
    L13:
        return r10;
    L9:
        return (String) r8;
    L5:
        r8 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        Object r8 = this.kind_;
    L7:
        if ((r8 instanceof String) == false) goto L13;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        if (this.kindCase_ != 3) goto L11;
        this.kind_ = r10;
    L11:
        return r10;
    L13:
        return (ByteString) r8;
    L5:
        r8 = "";
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
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
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
        int r11 = defpackage.b.a(r10, 37, 6, 53);
        int r12 = getListValue().hashCode();
    L14:
        r10 = r11 + r12;
        goto L15
    L9:
        r11 = defpackage.b.a(r10, 37, 5, 53);
        r12 = getStructValue().hashCode();
        goto L14
    L10:
        r11 = defpackage.b.a(r10, 37, 4, 53);
        r12 = Internal.hashBoolean(getBoolValue());
        goto L14
    L11:
        r11 = defpackage.b.a(r10, 37, 3, 53);
        r12 = getStringValue().hashCode();
        goto L14
    L12:
        r11 = defpackage.b.a(r10, 37, 2, 53);
        r12 = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
        goto L14
    L13:
        r11 = defpackage.b.a(r10, 37, 1, 53);
        r12 = getNullValueValue();
    L15:
        int r13 = getUnknownFields().hashCode();
        int r14 = r13 + (r10 * 29);
        this.memoizedHashCode = r14;
        return r14;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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
        if (this.kindCase_ != 1) goto L6;
        r8.writeEnum(1, ((Integer) this.kind_).intValue());
    L6:
        if (this.kindCase_ != 2) goto L9;
        r8.writeDouble(2, ((Double) this.kind_).doubleValue());
    L9:
        if (this.kindCase_ != 3) goto L12;
        GeneratedMessage.writeString(r8, 3, this.kind_);
    L12:
        if (this.kindCase_ != 4) goto L15;
        r8.writeBool(4, ((Boolean) this.kind_).booleanValue());
    L15:
        if (this.kindCase_ != 5) goto L18;
        r8.writeMessage(5, (Struct) this.kind_);
    L18:
        if (this.kindCase_ != 6) goto L20;
        r8.writeMessage(6, (ListValue) this.kind_);
    L20:
        getUnknownFields().writeTo(r8);
    }

    private Value(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Value r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Value parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Value parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ Value(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Value parseFrom(CodedInputStream r8) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Value getDefaultInstanceForType() {
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

    public static Value parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Value parseFrom(InputStream r8) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static Value parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Value) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Value parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Value parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Value parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Value parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
