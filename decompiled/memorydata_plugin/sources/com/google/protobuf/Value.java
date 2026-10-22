package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.kindCase_ = 0;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Value r1) {
        }

        private void buildPartialOneofs(Value r3) {
            Value.access$302(r3, this.kindCase_);
            Value.access$402(r3, this.kind_);
            if (this.kindCase_ != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            if (r0 == null) goto L8;
            Value.access$402(r3, r0.build());
        L8:
            if (this.kindCase_ != 6) goto L13;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r2 = this.listValueBuilder_;
            if (r2 == null) goto L14;
            Value.access$402(r3, r2.build());
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
            this.listValueBuilder_ = new SingleFieldBuilder((ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin"), getParentForChildren(), isClean());
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
            this.structValueBuilder_ = new SingleFieldBuilder((Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin"), getParentForChildren(), isClean());
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
            Value r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
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
            Value r0 = new Value(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            buildPartialOneofs(r0);
            onBuilt();
            return r0;
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
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r1 = this.structValueBuilder_;
            if (r1 == null) goto L5;
            r1.clear();
        L5:
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r2 = this.listValueBuilder_;
            if (r2 == null) goto L8;
            r2.clear();
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
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r0 = this.listValueBuilder_;
            if (r0 != null) goto L8;
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
            r0.clear();
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
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            if (r0 != null) goto L8;
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
            r0.clear();
            goto L11
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) goto L5;
            return false;
        L5:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.kind_, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
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
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r0 = this.listValueBuilder_;
            if (r0 != null) goto L12;
            if (this.kindCase_ != 6) goto L10;
            Object r3 = this.kind_;
        L8:
            return (ListValue) ZeusTransformUtils.preCheckCast(r3, ListValue.class, "com.obric.memorydata.plugin");
        L10:
            return ListValue.getDefaultInstance();
        L12:
            if (this.kindCase_ != 6) goto L15;
            r3 = r0.getMessage();
            goto L8
        L15:
            return ListValue.getDefaultInstance();
        }

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) ZeusTransformUtils.preCheckCast(internalGetListValueFieldBuilder().getBuilder(), ListValue.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            int r0 = this.kindCase_;
            if (r0 != 6) goto L8;
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r3 = this.listValueBuilder_;
            if (r3 == null) goto L8;
            return (ListValueOrBuilder) ZeusTransformUtils.preCheckCast(r3.getMessageOrBuilder(), ListValueOrBuilder.class, "com.obric.memorydata.plugin");
        L8:
            if (r0 != 6) goto L12;
            return (ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin");
        L12:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ != 1) goto L9;
            NullValue r2 = NullValue.forNumber(((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue());
            if (r2 == null) goto L7;
            return r2;
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
            return ((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) goto L5;
            return 0.0d;
        L5:
            return ((Double) ZeusTransformUtils.preCheckCast(this.kind_, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public String getStringValue() {
            if (this.kindCase_ != 3) goto L5;
            Object r0 = this.kind_;
        L7:
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L13;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r1;
        L11:
            return r1;
        L13:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        L5:
            r0 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            if (this.kindCase_ != 3) goto L5;
            Object r0 = this.kind_;
        L7:
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L13;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r1;
        L11:
            return r1;
        L13:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        L5:
            r0 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            if (r0 != null) goto L12;
            if (this.kindCase_ != 5) goto L10;
            Object r3 = this.kind_;
        L8:
            return (Struct) ZeusTransformUtils.preCheckCast(r3, Struct.class, "com.obric.memorydata.plugin");
        L10:
            return Struct.getDefaultInstance();
        L12:
            if (this.kindCase_ != 5) goto L15;
            r3 = r0.getMessage();
            goto L8
        L15:
            return Struct.getDefaultInstance();
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) ZeusTransformUtils.preCheckCast(internalGetStructValueFieldBuilder().getBuilder(), Struct.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            int r0 = this.kindCase_;
            if (r0 != 5) goto L8;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r3 = this.structValueBuilder_;
            if (r3 == null) goto L8;
            return (StructOrBuilder) ZeusTransformUtils.preCheckCast(r3.getMessageOrBuilder(), StructOrBuilder.class, "com.obric.memorydata.plugin");
        L8:
            if (r0 != 5) goto L12;
            return (Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin");
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L37;
            int r1 = r5.readTag();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r1 == 0) goto L29;
            if (r1 == 8) goto L27;
            if (r1 != 17) goto L11;
            this.kind_ = Double.valueOf(r5.readDouble());     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L11:
            if (r1 != 26) goto L13;
            Object r2 = r5.readStringRequireUtf8();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 3;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L25:
            this.kind_ = r2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L13:
            if (r1 != 32) goto L15;
            this.kind_ = Boolean.valueOf(r5.readBool());     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 4;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L15:
            if (r1 != 42) goto L17;
            r5.readMessage(internalGetStructValueFieldBuilder().getBuilder(), r6);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 5;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L17:
            if (r1 != 50) goto L19;
            r5.readMessage(internalGetListValueFieldBuilder().getBuilder(), r6);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 6;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L3
        L19:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L27:
            int r3 = r5.readEnum();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.kindCase_ = 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            r2 = Integer.valueOf(r3);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L29:
            r0 = true;
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
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Value.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Value) ZeusTransformUtils.preCheckCast(r4, Value.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(Value r4) {
            if (r4 != Value.getDefaultInstance()) goto L5;
            return this;
        L5:
            int r0 = r4.getKindCase().ordinal();
            if (r0 != 0) goto L8;
            setNullValueValue(r4.getNullValueValue());
        L23:
            mergeUnknownFields(r4.getUnknownFields());
            onChanged();
            return this;
        L8:
            if (r0 != 1) goto L10;
            setNumberValue(r4.getNumberValue());
            goto L23
        L10:
            if (r0 == 2) goto L20;
            if (r0 != 3) goto L13;
            setBoolValue(r4.getBoolValue());
            goto L23
        L13:
            if (r0 != 4) goto L15;
            mergeStructValue(r4.getStructValue());
            goto L23
        L15:
            if (r0 != 5) goto L23;
            mergeListValue(r4.getListValue());
            goto L23
        L20:
            this.kindCase_ = 3;
            this.kind_ = Value.access$400(r4);
            onChanged();
            goto L23
        }

        public Builder mergeListValue(ListValue r5) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r0 = this.listValueBuilder_;
            if (r0 != null) goto L11;
            if (this.kindCase_ == 6) goto L7;
        L9:
            this.kind_ = r5;
            onChanged();
        L14:
            this.kindCase_ = 6;
            return this;
        L7:
            if (this.kind_ == ListValue.getDefaultInstance()) goto L9;
            r5 = ListValue.newBuilder((ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin")).mergeFrom(r5).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 6) goto L13;
            r0.mergeFrom(r5);
            goto L14
        L13:
            r0.setMessage(r5);
            goto L14
        }

        public Builder mergeStructValue(Struct r5) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            if (r0 != null) goto L11;
            if (this.kindCase_ == 5) goto L7;
        L9:
            this.kind_ = r5;
            onChanged();
        L14:
            this.kindCase_ = 5;
            return this;
        L7:
            if (this.kind_ == Struct.getDefaultInstance()) goto L9;
            r5 = Struct.newBuilder((Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin")).mergeFrom(r5).buildPartial();
            goto L9
        L11:
            if (this.kindCase_ != 5) goto L13;
            r0.mergeFrom(r5);
            goto L14
        L13:
            r0.setMessage(r5);
            goto L14
        }

        public Builder setBoolValue(boolean r2) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(r2);
            onChanged();
            return this;
        }

        public Builder setListValue(ListValue.Builder r2) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r0 = this.listValueBuilder_;
            ListValue r3 = r2.build();
            if (r0 != null) goto L5;
            this.kind_ = r3;
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r0.setMessage(r3);
            goto L6
        }

        public Builder setListValue(ListValue r2) {
            SingleFieldBuilder<ListValue, ListValue.Builder, ListValueOrBuilder> r0 = this.listValueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            this.kind_ = r2;
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }

        public Builder setNullValue(NullValue r2) {
            Objects.requireNonNull(r2);
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r2.getNumber());
            onChanged();
            return this;
        }

        public Builder setNullValueValue(int r2) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r2);
            onChanged();
            return this;
        }

        public Builder setNumberValue(double r2) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(r2);
            onChanged();
            return this;
        }

        public Builder setStringValue(String r2) {
            Objects.requireNonNull(r2);
            this.kindCase_ = 3;
            this.kind_ = r2;
            onChanged();
            return this;
        }

        public Builder setStringValueBytes(ByteString r2) {
            Objects.requireNonNull(r2);
            AbstractMessageLite.checkByteStringIsUtf8(r2);
            this.kindCase_ = 3;
            this.kind_ = r2;
            onChanged();
            return this;
        }

        public Builder setStructValue(Struct.Builder r2) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            Struct r3 = r2.build();
            if (r0 != null) goto L5;
            this.kind_ = r3;
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r0.setMessage(r3);
            goto L6
        }

        public Builder setStructValue(Struct r2) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> r0 = this.structValueBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            this.kind_ = r2;
            onChanged();
        L6:
            this.kindCase_ = 5;
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }
    }

    public static final enum KindCase extends java.lang.Enum<KindCase> implements AbstractMessageLite.InternalOneOfEnum, Internal.EnumLite {
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

        private KindCase(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static KindCase forNumber(int r0) {
            switch(r0) {
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
        public static KindCase valueOf(int r0) {
            return forNumber(r0);
        }

        public static KindCase valueOf(String r2) {
            return (KindCase) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(KindCase.class, r2), KindCase.class, "com.obric.memorydata.plugin");
        }

        public static KindCase[] values() {
            return (KindCase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KindCase[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.AbstractMessageLite.InternalOneOfEnum, com.google.protobuf.Internal.EnumLite
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

    private Value(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Value(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int access$302(Value r0, int r1) {
        r0.kindCase_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$400(Value r0) {
        return r0.kind_;
    }

    static /* synthetic */ Object access$402(Value r0, Object r1) {
        r0.kind_ = r1;
        return r1;
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

    public static Builder newBuilder(Value r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Value parseDelimitedFrom(InputStream r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(ByteString r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(CodedInputStream r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(InputStream r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(ByteBuffer r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(byte[] r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Value parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Value) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Value.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Value.class) == false) goto L8;
        Value r9 = (Value) ZeusTransformUtils.preCheckCast(r8, Value.class, "com.obric.memorydata.plugin");
        if (getKindCase().equals(r9.getKindCase()) == true) goto L13;
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
        if (getListValue().equals(r9.getListValue()) == true) goto L34;
        return false;
    L19:
        if (getStructValue().equals(r9.getStructValue()) == true) goto L34;
        return false;
    L22:
        if (getBoolValue() == r9.getBoolValue()) goto L34;
        return false;
    L25:
        if (getStringValue().equals(r9.getStringValue()) == true) goto L34;
        return false;
    L28:
        if (Double.doubleToLongBits(getNumberValue()) == Double.doubleToLongBits(r9.getNumberValue())) goto L34;
        return false;
    L31:
        if (getNullValueValue() == r9.getNullValueValue()) goto L34;
        return false;
    L34:
        if (getUnknownFields().equals(r9.getUnknownFields()) == true) goto L36;
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
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.kind_, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
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
        return (ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin");
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin");
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) goto L9;
        NullValue r2 = NullValue.forNumber(((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r2 == null) goto L7;
        return r2;
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
        return ((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) goto L5;
        return 0.0d;
    L5:
        return ((Double) ZeusTransformUtils.preCheckCast(this.kind_, Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (this.kindCase_ != 1) goto L9;
        r1 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L9:
        if (this.kindCase_ != 2) goto L12;
        r1 = r1 + CodedOutputStream.computeDoubleSize(2, ((Double) ZeusTransformUtils.preCheckCast(this.kind_, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L12:
        if (this.kindCase_ != 3) goto L15;
        r1 = r1 + GeneratedMessage.computeStringSize(3, this.kind_);
    L15:
        if (this.kindCase_ != 4) goto L18;
        r1 = r1 + CodedOutputStream.computeBoolSize(4, ((Boolean) ZeusTransformUtils.preCheckCast(this.kind_, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L18:
        if (this.kindCase_ != 5) goto L21;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, (Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin"));
    L21:
        if (this.kindCase_ != 6) goto L23;
        r1 = r1 + CodedOutputStream.computeMessageSize(6, (ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin"));
    L23:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ != 3) goto L5;
        Object r0 = this.kind_;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        if (this.kindCase_ != 3) goto L13;
        this.kind_ = r1;
    L13:
        return r1;
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L5:
        r0 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        Object r0 = this.kind_;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L13;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        if (this.kindCase_ != 3) goto L11;
        this.kind_ = r1;
    L11:
        return r1;
    L13:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    L5:
        r0 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin");
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin");
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
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = 779 + getDescriptor().hashCode();
        switch(this.kindCase_) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        int r1 = ((r0 * 37) + 6) * 53;
        int r2 = getListValue().hashCode();
    L15:
        r0 = r1 + r2;
        goto L16
    L10:
        r1 = ((r0 * 37) + 5) * 53;
        r2 = getStructValue().hashCode();
        goto L15
    L11:
        r1 = ((r0 * 37) + 4) * 53;
        r2 = Internal.hashBoolean(getBoolValue());
        goto L15
    L12:
        r1 = ((r0 * 37) + 3) * 53;
        r2 = getStringValue().hashCode();
        goto L15
    L13:
        r1 = ((r0 * 37) + 2) * 53;
        r2 = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
        goto L15
    L14:
        r1 = ((r0 * 37) + 1) * 53;
        r2 = getNullValueValue();
    L16:
        int r3 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r3;
        return r3;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
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
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) {
        if (this.kindCase_ != 1) goto L6;
        r6.writeEnum(1, ((Integer) ZeusTransformUtils.preCheckCast(this.kind_, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L6:
        if (this.kindCase_ != 2) goto L9;
        r6.writeDouble(2, ((Double) ZeusTransformUtils.preCheckCast(this.kind_, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L9:
        if (this.kindCase_ != 3) goto L12;
        GeneratedMessage.writeString(r6, 3, this.kind_);
    L12:
        if (this.kindCase_ != 4) goto L15;
        r6.writeBool(4, ((Boolean) ZeusTransformUtils.preCheckCast(this.kind_, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L15:
        if (this.kindCase_ != 5) goto L18;
        r6.writeMessage(5, (Struct) ZeusTransformUtils.preCheckCast(this.kind_, Struct.class, "com.obric.memorydata.plugin"));
    L18:
        if (this.kindCase_ != 6) goto L20;
        r6.writeMessage(6, (ListValue) ZeusTransformUtils.preCheckCast(this.kind_, ListValue.class, "com.obric.memorydata.plugin"));
    L20:
        getUnknownFields().writeTo(r6);
    }
}
