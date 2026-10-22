package com.obric.cae.p001useraware;

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
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeUserAwareServiceProto extends GeneratedMessageV3 implements CaeUserAwareServiceProtoOrBuilder {
    public static final int CAEUSERAWARESERVICEPROTODATA_FIELD_NUMBER = 1;
    private static final CaeUserAwareServiceProto DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<CaeUserAwareServiceProto> PARSER = null;
    private static final long serialVersionUID = 0;
    private List<CaeUserAwareServiceProtoData> caeUserAwareServiceProtoData_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeUserAwareServiceProtoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> caeUserAwareServiceProtoDataBuilder_;
        private List<CaeUserAwareServiceProtoData> caeUserAwareServiceProtoData_;

        private Builder() {
            this.caeUserAwareServiceProtoData_ = Collections.emptyList();
        }

        private void buildPartial0(CaeUserAwareServiceProto r8) {
        }

        private void buildPartialRepeatedFields(CaeUserAwareServiceProto r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            CaeUserAwareServiceProto.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.caeUserAwareServiceProtoData_ = Collections.unmodifiableList(this.caeUserAwareServiceProtoData_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.caeUserAwareServiceProtoData_;
            goto L9
        }

        private void ensureCaeUserAwareServiceProtoDataIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.caeUserAwareServiceProtoData_ = new ArrayList(this.caeUserAwareServiceProtoData_);
            this.bitField0_ |= 1;
            return;
        }

        private RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> getCaeUserAwareServiceProtoDataFieldBuilder() {
            if (this.caeUserAwareServiceProtoDataBuilder_ != null) goto L10;
            List<CaeUserAwareServiceProtoData> r8 = this.caeUserAwareServiceProtoData_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.caeUserAwareServiceProtoDataBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.caeUserAwareServiceProtoData_ = null;
        L10:
            return this.caeUserAwareServiceProtoDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_descriptor;
        }

        public Builder addAllCaeUserAwareServiceProtoData(Iterable<? extends CaeUserAwareServiceProtoData> r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L5;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.caeUserAwareServiceProtoData_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addCaeUserAwareServiceProtoData(int r8, CaeUserAwareServiceProtoData.Builder r10) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r11 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r11 != null) goto L5;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public CaeUserAwareServiceProtoData.Builder addCaeUserAwareServiceProtoDataBuilder() {
            return (CaeUserAwareServiceProtoData.Builder) getCaeUserAwareServiceProtoDataFieldBuilder().addBuilder(CaeUserAwareServiceProtoData.getDefaultInstance());
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

        public Builder clearCaeUserAwareServiceProtoData() {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r8 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r8 != null) goto L5;
            this.caeUserAwareServiceProtoData_ = Collections.emptyList();
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

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
        public CaeUserAwareServiceProtoData getCaeUserAwareServiceProtoData(int r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.caeUserAwareServiceProtoData_.get(r8);
        L6:
            return (CaeUserAwareServiceProtoData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public CaeUserAwareServiceProtoData.Builder getCaeUserAwareServiceProtoDataBuilder(int r8) {
            return (CaeUserAwareServiceProtoData.Builder) getCaeUserAwareServiceProtoDataFieldBuilder().getBuilder(r8);
        }

        public List<CaeUserAwareServiceProtoData.Builder> getCaeUserAwareServiceProtoDataBuilderList() {
            return getCaeUserAwareServiceProtoDataFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
        public int getCaeUserAwareServiceProtoDataCount() {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r8 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r8 != null) goto L7;
            return this.caeUserAwareServiceProtoData_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
        public List<CaeUserAwareServiceProtoData> getCaeUserAwareServiceProtoDataList() {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r8 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.caeUserAwareServiceProtoData_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
        public CaeUserAwareServiceProtoDataOrBuilder getCaeUserAwareServiceProtoDataOrBuilder(int r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.caeUserAwareServiceProtoData_.get(r8);
        L6:
            return (CaeUserAwareServiceProtoDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
        public List<? extends CaeUserAwareServiceProtoDataOrBuilder> getCaeUserAwareServiceProtoDataOrBuilderList() {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r8 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.caeUserAwareServiceProtoData_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_descriptor;
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

        public Builder removeCaeUserAwareServiceProtoData(int r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L5;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setCaeUserAwareServiceProtoData(int r8, CaeUserAwareServiceProtoData.Builder r10) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r11 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r11 != null) goto L5;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.set(r8, r10.build());
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
            this.caeUserAwareServiceProtoData_ = Collections.emptyList();
        }

        public Builder addCaeUserAwareServiceProtoData(int r8, CaeUserAwareServiceProtoData r10) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r11 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public CaeUserAwareServiceProtoData.Builder addCaeUserAwareServiceProtoDataBuilder(int r8) {
            return (CaeUserAwareServiceProtoData.Builder) getCaeUserAwareServiceProtoDataFieldBuilder().addBuilder(r8, CaeUserAwareServiceProtoData.getDefaultInstance());
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
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeUserAwareServiceProto.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setCaeUserAwareServiceProtoData(int r8, CaeUserAwareServiceProtoData r10) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r11 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.set(r8, r10);
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

        public Builder addCaeUserAwareServiceProtoData(CaeUserAwareServiceProtoData.Builder r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L5;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.add(r8.build());
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
        public CaeUserAwareServiceProto build() {
            CaeUserAwareServiceProto r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeUserAwareServiceProto buildPartial() {
            CaeUserAwareServiceProto r8 = new CaeUserAwareServiceProto(this, null);
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
        public CaeUserAwareServiceProto getDefaultInstanceForType() {
            return CaeUserAwareServiceProto.getDefaultInstance();
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

        public Builder addCaeUserAwareServiceProtoData(CaeUserAwareServiceProtoData r8) {
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.add(r8);
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
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r8 = this.caeUserAwareServiceProtoDataBuilder_;
            if (r8 != null) goto L5;
            this.caeUserAwareServiceProtoData_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            return this;
        L5:
            this.caeUserAwareServiceProtoData_ = null;
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
            CaeUserAwareServiceProtoData r13 = (CaeUserAwareServiceProtoData) r8.readMessage(CaeUserAwareServiceProtoData.PARSER, r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r14 = this.caeUserAwareServiceProtoDataBuilder_;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r14 == null) goto L14;
            r14.addMessage(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L14:
            ensureCaeUserAwareServiceProtoDataIsMutable();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.caeUserAwareServiceProtoData_.add(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
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
            if ((r8 instanceof CaeUserAwareServiceProto) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeUserAwareServiceProto) r8);
        }

        public Builder mergeFrom(CaeUserAwareServiceProto r8) {
            if (r8 != CaeUserAwareServiceProto.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (this.caeUserAwareServiceProtoDataBuilder_ != null) goto L15;
            if (CaeUserAwareServiceProto.access$300(r8).isEmpty() == false) goto L10;
        L23:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L10:
            if (this.caeUserAwareServiceProtoData_.isEmpty() == false) goto L12;
            this.caeUserAwareServiceProtoData_ = CaeUserAwareServiceProto.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L23
        L12:
            ensureCaeUserAwareServiceProtoDataIsMutable();
            this.caeUserAwareServiceProtoData_.addAll(CaeUserAwareServiceProto.access$300(r8));
            goto L13
        L15:
            if (CaeUserAwareServiceProto.access$300(r8).isEmpty() == true) goto L23;
            if (this.caeUserAwareServiceProtoDataBuilder_.isEmpty() == false) goto L22;
            this.caeUserAwareServiceProtoDataBuilder_.dispose();
            RepeatedFieldBuilderV3<CaeUserAwareServiceProtoData, CaeUserAwareServiceProtoData.Builder, CaeUserAwareServiceProtoDataOrBuilder> r10 = null;
            this.caeUserAwareServiceProtoDataBuilder_ = null;
            this.caeUserAwareServiceProtoData_ = CaeUserAwareServiceProto.access$300(r8);
            this.bitField0_ &= -2;
            if (CaeUserAwareServiceProto.access$400() == false) goto L21;
            r10 = getCaeUserAwareServiceProtoDataFieldBuilder();
        L21:
            this.caeUserAwareServiceProtoDataBuilder_ = r10;
            goto L23
        L22:
            this.caeUserAwareServiceProtoDataBuilder_.addAllMessages(CaeUserAwareServiceProto.access$300(r8));
            goto L23
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeUserAwareServiceProto();
        PARSER = new AnonymousClass1();
    }

    private CaeUserAwareServiceProto() {
        this.memoizedIsInitialized = -1;
        this.caeUserAwareServiceProtoData_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(CaeUserAwareServiceProto r8) {
        return r8.caeUserAwareServiceProtoData_;
    }

    public static /* synthetic */ List access$302(CaeUserAwareServiceProto r8, List r10) {
        r8.caeUserAwareServiceProtoData_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static CaeUserAwareServiceProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeUserAwareServiceProto parseDelimitedFrom(InputStream r8) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeUserAwareServiceProto parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeUserAwareServiceProto> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeUserAwareServiceProto) == false) goto L8;
        CaeUserAwareServiceProto r10 = (CaeUserAwareServiceProto) r8;
        if (getCaeUserAwareServiceProtoDataList().equals(r10.getCaeUserAwareServiceProtoDataList()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
    public CaeUserAwareServiceProtoData getCaeUserAwareServiceProtoData(int r8) {
        return this.caeUserAwareServiceProtoData_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
    public int getCaeUserAwareServiceProtoDataCount() {
        return this.caeUserAwareServiceProtoData_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
    public List<CaeUserAwareServiceProtoData> getCaeUserAwareServiceProtoDataList() {
        return this.caeUserAwareServiceProtoData_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
    public CaeUserAwareServiceProtoDataOrBuilder getCaeUserAwareServiceProtoDataOrBuilder(int r8) {
        return this.caeUserAwareServiceProtoData_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoOrBuilder
    public List<? extends CaeUserAwareServiceProtoDataOrBuilder> getCaeUserAwareServiceProtoDataOrBuilderList() {
        return this.caeUserAwareServiceProtoData_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeUserAwareServiceProto> getParserForType() {
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
        if (r10 >= this.caeUserAwareServiceProtoData_.size()) goto L9;
        r11 = r11 + CodedOutputStream.computeMessageSize(1, this.caeUserAwareServiceProtoData_.get(r10));
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
        if (getCaeUserAwareServiceProtoDataCount() <= 0) goto L8;
        r10 = b.a(r10, 37, 1, 53) + getCaeUserAwareServiceProtoDataList().hashCode();
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
        return new CaeUserAwareServiceProto();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.caeUserAwareServiceProtoData_.size()) goto L6;
        r8.writeMessage(1, this.caeUserAwareServiceProtoData_.get(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r8);
    }

    private CaeUserAwareServiceProto(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeUserAwareServiceProto r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeUserAwareServiceProto parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeUserAwareServiceProto parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeUserAwareServiceProto.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeUserAwareServiceProto(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeUserAwareServiceProto parseFrom(CodedInputStream r8) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeUserAwareServiceProto getDefaultInstanceForType() {
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

    public static CaeUserAwareServiceProto parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeUserAwareServiceProto parseFrom(InputStream r8) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeUserAwareServiceProto parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeUserAwareServiceProto parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeUserAwareServiceProto parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeUserAwareServiceProto parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeUserAwareServiceProto parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
