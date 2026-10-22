package com.obric.cae.wifi;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeWifiServiceProto extends GeneratedMessageV3 implements CaeWifiServiceProtoOrBuilder {
    public static final int CAEWIFISERVICEPROTO_FIELD_NUMBER = 1;
    private static final CaeWifiServiceProto DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<CaeWifiServiceProto> PARSER = null;
    private static final long serialVersionUID = 0;
    private List<CaeWifiServiceProtoData> caeWifiServiceProto_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeWifiServiceProtoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> caeWifiServiceProtoBuilder_;
        private List<CaeWifiServiceProtoData> caeWifiServiceProto_;

        private Builder() {
            this.caeWifiServiceProto_ = Collections.emptyList();
        }

        private void buildPartial0(CaeWifiServiceProto r8) {
        }

        private void buildPartialRepeatedFields(CaeWifiServiceProto r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            CaeWifiServiceProto.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.caeWifiServiceProto_ = Collections.unmodifiableList(this.caeWifiServiceProto_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.caeWifiServiceProto_;
            goto L9
        }

        private void ensureCaeWifiServiceProtoIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.caeWifiServiceProto_ = new ArrayList(this.caeWifiServiceProto_);
            this.bitField0_ |= 1;
            return;
        }

        private RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> getCaeWifiServiceProtoFieldBuilder() {
            if (this.caeWifiServiceProtoBuilder_ != null) goto L10;
            List<CaeWifiServiceProtoData> r8 = this.caeWifiServiceProto_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.caeWifiServiceProtoBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.caeWifiServiceProto_ = null;
        L10:
            return this.caeWifiServiceProtoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProto_descriptor;
        }

        public Builder addAllCaeWifiServiceProto(Iterable<? extends CaeWifiServiceProtoData> r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L5;
            ensureCaeWifiServiceProtoIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.caeWifiServiceProto_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addCaeWifiServiceProto(int r8, CaeWifiServiceProtoData.Builder r10) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r11 = this.caeWifiServiceProtoBuilder_;
            if (r11 != null) goto L5;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public CaeWifiServiceProtoData.Builder addCaeWifiServiceProtoBuilder() {
            return (CaeWifiServiceProtoData.Builder) getCaeWifiServiceProtoFieldBuilder().addBuilder(CaeWifiServiceProtoData.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearCaeWifiServiceProto() {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r8 = this.caeWifiServiceProtoBuilder_;
            if (r8 != null) goto L5;
            this.caeWifiServiceProto_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
        public CaeWifiServiceProtoData getCaeWifiServiceProto(int r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.caeWifiServiceProto_.get(r8);
        L6:
            return (CaeWifiServiceProtoData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public CaeWifiServiceProtoData.Builder getCaeWifiServiceProtoBuilder(int r8) {
            return (CaeWifiServiceProtoData.Builder) getCaeWifiServiceProtoFieldBuilder().getBuilder(r8);
        }

        public List<CaeWifiServiceProtoData.Builder> getCaeWifiServiceProtoBuilderList() {
            return getCaeWifiServiceProtoFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
        public int getCaeWifiServiceProtoCount() {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r8 = this.caeWifiServiceProtoBuilder_;
            if (r8 != null) goto L7;
            return this.caeWifiServiceProto_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
        public List<CaeWifiServiceProtoData> getCaeWifiServiceProtoList() {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r8 = this.caeWifiServiceProtoBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.caeWifiServiceProto_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
        public CaeWifiServiceProtoDataOrBuilder getCaeWifiServiceProtoOrBuilder(int r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.caeWifiServiceProto_.get(r8);
        L6:
            return (CaeWifiServiceProtoDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
        public List<? extends CaeWifiServiceProtoDataOrBuilder> getCaeWifiServiceProtoOrBuilderList() {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r8 = this.caeWifiServiceProtoBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.caeWifiServiceProto_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeCaeWifiServiceProto(int r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L5;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setCaeWifiServiceProto(int r8, CaeWifiServiceProtoData.Builder r10) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r11 = this.caeWifiServiceProtoBuilder_;
            if (r11 != null) goto L5;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.caeWifiServiceProto_ = Collections.emptyList();
        }

        public Builder addCaeWifiServiceProto(int r8, CaeWifiServiceProtoData r10) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r11 = this.caeWifiServiceProtoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public CaeWifiServiceProtoData.Builder addCaeWifiServiceProtoBuilder(int r8) {
            return (CaeWifiServiceProtoData.Builder) getCaeWifiServiceProtoFieldBuilder().addBuilder(r8, CaeWifiServiceProtoData.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeWifiServiceProto.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setCaeWifiServiceProto(int r8, CaeWifiServiceProtoData r10) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r11 = this.caeWifiServiceProtoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addCaeWifiServiceProto(CaeWifiServiceProtoData.Builder r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L5;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeWifiServiceProto build() {
            CaeWifiServiceProto r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeWifiServiceProto buildPartial() {
            CaeWifiServiceProto r8 = new CaeWifiServiceProto(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public CaeWifiServiceProto getDefaultInstanceForType() {
            return CaeWifiServiceProto.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addCaeWifiServiceProto(CaeWifiServiceProtoData r8) {
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = this.caeWifiServiceProtoBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            return (Builder) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return (Builder) super.clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (Builder) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r8 = this.caeWifiServiceProtoBuilder_;
            if (r8 != null) goto L5;
            this.caeWifiServiceProto_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            return this;
        L5:
            this.caeWifiServiceProto_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L28;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L25;
            int r12 = r8.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r12 == 0) goto L17;
            if (r12 != 10) goto L10;
            CaeWifiServiceProtoData r13 = (CaeWifiServiceProtoData) r8.readMessage(CaeWifiServiceProtoData.PARSER, r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r14 = this.caeWifiServiceProtoBuilder_;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r14 == null) goto L14;
            r14.addMessage(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L14:
            ensureCaeWifiServiceProtoIsMutable();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.caeWifiServiceProto_.add(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L17:
            r11 = true;
            goto L4
        L18:
            th = move-exception;
            onChanged();
            throw th;
        L20:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L18
        L25:
            onChanged();
            return this;
        L28:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CaeWifiServiceProto) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeWifiServiceProto) r8);
        }

        public Builder mergeFrom(CaeWifiServiceProto r8) {
            if (r8 != CaeWifiServiceProto.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (this.caeWifiServiceProtoBuilder_ != null) goto L15;
            if (CaeWifiServiceProto.access$300(r8).isEmpty() == false) goto L10;
        L23:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L10:
            if (this.caeWifiServiceProto_.isEmpty() == false) goto L12;
            this.caeWifiServiceProto_ = CaeWifiServiceProto.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L23
        L12:
            ensureCaeWifiServiceProtoIsMutable();
            this.caeWifiServiceProto_.addAll(CaeWifiServiceProto.access$300(r8));
            goto L13
        L15:
            if (CaeWifiServiceProto.access$300(r8).isEmpty() == true) goto L23;
            if (this.caeWifiServiceProtoBuilder_.isEmpty() == false) goto L22;
            this.caeWifiServiceProtoBuilder_.dispose();
            RepeatedFieldBuilderV3<CaeWifiServiceProtoData, CaeWifiServiceProtoData.Builder, CaeWifiServiceProtoDataOrBuilder> r10 = null;
            this.caeWifiServiceProtoBuilder_ = null;
            this.caeWifiServiceProto_ = CaeWifiServiceProto.access$300(r8);
            this.bitField0_ &= -2;
            if (CaeWifiServiceProto.access$400() == false) goto L21;
            r10 = getCaeWifiServiceProtoFieldBuilder();
        L21:
            this.caeWifiServiceProtoBuilder_ = r10;
            goto L23
        L22:
            this.caeWifiServiceProtoBuilder_.addAllMessages(CaeWifiServiceProto.access$300(r8));
            goto L23
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeWifiServiceProto();
        PARSER = new AnonymousClass1();
    }

    private CaeWifiServiceProto() {
        this.memoizedIsInitialized = -1;
        this.caeWifiServiceProto_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(CaeWifiServiceProto r8) {
        return r8.caeWifiServiceProto_;
    }

    public static /* synthetic */ List access$302(CaeWifiServiceProto r8, List r10) {
        r8.caeWifiServiceProto_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static CaeWifiServiceProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProto_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeWifiServiceProto parseDelimitedFrom(InputStream r8) {
        return (CaeWifiServiceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeWifiServiceProto parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeWifiServiceProto> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeWifiServiceProto) == false) goto L8;
        CaeWifiServiceProto r10 = (CaeWifiServiceProto) r8;
        if (getCaeWifiServiceProtoList().equals(r10.getCaeWifiServiceProtoList()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
    public CaeWifiServiceProtoData getCaeWifiServiceProto(int r8) {
        return this.caeWifiServiceProto_.get(r8);
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
    public int getCaeWifiServiceProtoCount() {
        return this.caeWifiServiceProto_.size();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
    public List<CaeWifiServiceProtoData> getCaeWifiServiceProtoList() {
        return this.caeWifiServiceProto_;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
    public CaeWifiServiceProtoDataOrBuilder getCaeWifiServiceProtoOrBuilder(int r8) {
        return this.caeWifiServiceProto_.get(r8);
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoOrBuilder
    public List<? extends CaeWifiServiceProtoDataOrBuilder> getCaeWifiServiceProtoOrBuilderList() {
        return this.caeWifiServiceProto_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeWifiServiceProto> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.caeWifiServiceProto_.size()) goto L9;
        r11 = r11 + CodedOutputStream.computeMessageSize(1, this.caeWifiServiceProto_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (getCaeWifiServiceProtoCount() <= 0) goto L8;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getCaeWifiServiceProtoList().hashCode();
    L8:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new CaeWifiServiceProto();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.caeWifiServiceProto_.size()) goto L6;
        r8.writeMessage(1, this.caeWifiServiceProto_.get(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r8);
    }

    private CaeWifiServiceProto(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeWifiServiceProto r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeWifiServiceProto parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeWifiServiceProto parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeWifiServiceProto.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeWifiServiceProto(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeWifiServiceProto parseFrom(CodedInputStream r8) {
        return (CaeWifiServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeWifiServiceProto getDefaultInstanceForType() {
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

    public static CaeWifiServiceProto parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeWifiServiceProto parseFrom(InputStream r8) {
        return (CaeWifiServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeWifiServiceProto parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeWifiServiceProto parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeWifiServiceProto parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeWifiServiceProto parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeWifiServiceProto parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
