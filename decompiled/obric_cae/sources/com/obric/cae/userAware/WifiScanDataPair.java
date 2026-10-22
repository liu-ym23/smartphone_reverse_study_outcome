package com.obric.cae.userAware;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiScanDataPair extends GeneratedMessageV3 implements WifiScanDataPairOrBuilder {
    public static final int ANCHOR_WIFI_DATA_FIELD_NUMBER = 2;
    private static final WifiScanDataPair DEFAULT_INSTANCE = null;
    public static final int NEW_WIFI_SCAN_DATA_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<WifiScanDataPair> PARSER = null;
    private static final long serialVersionUID = 0;
    private WifiScanData anchorWifiData_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private WifiScanData newWifiScanData_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiScanDataPairOrBuilder {
        private SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> anchorWifiDataBuilder_;
        private WifiScanData anchorWifiData_;
        private int bitField0_;
        private SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> newWifiScanDataBuilder_;
        private WifiScanData newWifiScanData_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(WifiScanDataPair r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L9;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r11 = this.newWifiScanDataBuilder_;
            if (r11 != null) goto L7;
            WifiScanData r12 = this.newWifiScanData_;
        L8:
            WifiScanDataPair.access$402(r8, r12);
            int r13 = 1;
        L11:
            if ((r10 & 2) == 0) goto L17;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r14 = this.anchorWifiDataBuilder_;
            if (r14 != null) goto L15;
            WifiScanData r15 = this.anchorWifiData_;
        L16:
            WifiScanDataPair.access$502(r8, r15);
            r13 = r13 | 2;
            goto L17
        L15:
            r15 = (WifiScanData) r14.build();
        L17:
            WifiScanDataPair.access$676(r8, r13);
            return;
        L7:
            r12 = (WifiScanData) r11.build();
            goto L8
        L9:
            r13 = 0;
            goto L11
        }

        private SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> getAnchorWifiDataFieldBuilder() {
            if (this.anchorWifiDataBuilder_ != null) goto L6;
            this.anchorWifiDataBuilder_ = new SingleFieldBuilderV3(getAnchorWifiData(), getParentForChildren(), isClean());
            this.anchorWifiData_ = null;
        L6:
            return this.anchorWifiDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_WifiScanDataPair_descriptor;
        }

        private SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> getNewWifiScanDataFieldBuilder() {
            if (this.newWifiScanDataBuilder_ != null) goto L6;
            this.newWifiScanDataBuilder_ = new SingleFieldBuilderV3(getNewWifiScanData(), getParentForChildren(), isClean());
            this.newWifiScanData_ = null;
        L6:
            return this.newWifiScanDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (WifiScanDataPair.access$200() == false) goto L6;
            getNewWifiScanDataFieldBuilder();
            getAnchorWifiDataFieldBuilder();
            return;
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

        public Builder clearAnchorWifiData() {
            this.bitField0_ &= -3;
            this.anchorWifiData_ = null;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.anchorWifiDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.anchorWifiDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearNewWifiScanData() {
            this.bitField0_ &= -2;
            this.newWifiScanData_ = null;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.newWifiScanDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.newWifiScanDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public WifiScanData getAnchorWifiData() {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.anchorWifiDataBuilder_;
            if (r8 != null) goto L9;
            WifiScanData r10 = this.anchorWifiData_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return WifiScanData.getDefaultInstance();
        L9:
            return (WifiScanData) r8.getMessage();
        }

        public WifiScanData.Builder getAnchorWifiDataBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (WifiScanData.Builder) getAnchorWifiDataFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public WifiScanDataOrBuilder getAnchorWifiDataOrBuilder() {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.anchorWifiDataBuilder_;
            if (r8 != null) goto L5;
            WifiScanData r10 = this.anchorWifiData_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return WifiScanData.getDefaultInstance();
        L5:
            return (WifiScanDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_WifiScanDataPair_descriptor;
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public WifiScanData getNewWifiScanData() {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.newWifiScanDataBuilder_;
            if (r8 != null) goto L9;
            WifiScanData r10 = this.newWifiScanData_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return WifiScanData.getDefaultInstance();
        L9:
            return (WifiScanData) r8.getMessage();
        }

        public WifiScanData.Builder getNewWifiScanDataBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (WifiScanData.Builder) getNewWifiScanDataFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public WifiScanDataOrBuilder getNewWifiScanDataOrBuilder() {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.newWifiScanDataBuilder_;
            if (r8 != null) goto L5;
            WifiScanData r10 = this.newWifiScanData_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return WifiScanData.getDefaultInstance();
        L5:
            return (WifiScanDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public boolean hasAnchorWifiData() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
        public boolean hasNewWifiScanData() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAnchorWifiData(WifiScanData r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.anchorWifiDataBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            WifiScanData r11 = this.anchorWifiData_;
            if (r11 == null) goto L11;
            if (r11 == WifiScanData.getDefaultInstance()) goto L11;
            getAnchorWifiDataBuilder().mergeFrom(r8);
        L11:
            this.anchorWifiData_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeNewWifiScanData(WifiScanData r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.newWifiScanDataBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L11;
            WifiScanData r11 = this.newWifiScanData_;
            if (r11 == null) goto L11;
            if (r11 == WifiScanData.getDefaultInstance()) goto L11;
            getNewWifiScanDataBuilder().mergeFrom(r8);
        L11:
            this.newWifiScanData_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAnchorWifiData(WifiScanData.Builder r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.anchorWifiDataBuilder_;
            WifiScanData r11 = r8.build();
            if (r10 != null) goto L5;
            this.anchorWifiData_ = r11;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNewWifiScanData(WifiScanData.Builder r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.newWifiScanDataBuilder_;
            WifiScanData r11 = r8.build();
            if (r10 != null) goto L5;
            this.newWifiScanData_ = r11;
        L6:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
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
            maybeForceBuilderInitialization();
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
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_WifiScanDataPair_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanDataPair.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAnchorWifiData(WifiScanData r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.anchorWifiDataBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.anchorWifiData_ = r8;
        L9:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNewWifiScanData(WifiScanData r8) {
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.newWifiScanDataBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.newWifiScanData_ = r8;
        L9:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiScanDataPair build() {
            WifiScanDataPair r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiScanDataPair buildPartial() {
            WifiScanDataPair r8 = new WifiScanDataPair(this, null);
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
        public WifiScanDataPair getDefaultInstanceForType() {
            return WifiScanDataPair.getDefaultInstance();
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
            this.newWifiScanData_ = null;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r8 = this.newWifiScanDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.newWifiScanDataBuilder_ = null;
        L5:
            this.anchorWifiData_ = null;
            SingleFieldBuilderV3<WifiScanData, WifiScanData.Builder, WifiScanDataOrBuilder> r10 = this.anchorWifiDataBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.anchorWifiDataBuilder_ = null;
        L8:
            return this;
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
            r8.readMessage(getNewWifiScanDataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (r12 != 18) goto L12;
            r8.readMessage(getAnchorWifiDataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L12:
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
            if ((r8 instanceof WifiScanDataPair) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WifiScanDataPair) r8);
        }

        public Builder mergeFrom(WifiScanDataPair r8) {
            if (r8 != WifiScanDataPair.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasNewWifiScanData() == false) goto L9;
            mergeNewWifiScanData(r8.getNewWifiScanData());
        L9:
            if (r8.hasAnchorWifiData() == false) goto L11;
            mergeAnchorWifiData(r8.getAnchorWifiData());
        L11:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WifiScanDataPair();
        PARSER = new AnonymousClass1();
    }

    private WifiScanDataPair() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ WifiScanData access$402(WifiScanDataPair r8, WifiScanData r10) {
        r8.newWifiScanData_ = r10;
        return r10;
    }

    public static /* synthetic */ WifiScanData access$502(WifiScanDataPair r8, WifiScanData r10) {
        r8.anchorWifiData_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$676(WifiScanDataPair r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static WifiScanDataPair getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_WifiScanDataPair_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WifiScanDataPair parseDelimitedFrom(InputStream r8) {
        return (WifiScanDataPair) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WifiScanDataPair parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WifiScanDataPair> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WifiScanDataPair) == false) goto L8;
        WifiScanDataPair r10 = (WifiScanDataPair) r8;
        if (hasNewWifiScanData() == r10.hasNewWifiScanData()) goto L13;
        return false;
    L13:
        if (hasNewWifiScanData() == false) goto L18;
        if (getNewWifiScanData().equals(r10.getNewWifiScanData()) == true) goto L18;
        return false;
    L18:
        if (hasAnchorWifiData() == r10.hasAnchorWifiData()) goto L21;
        return false;
    L21:
        if (hasAnchorWifiData() == false) goto L26;
        if (getAnchorWifiData().equals(r10.getAnchorWifiData()) == true) goto L26;
        return false;
    L26:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public WifiScanData getAnchorWifiData() {
        WifiScanData r8 = this.anchorWifiData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WifiScanData.getDefaultInstance();
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public WifiScanDataOrBuilder getAnchorWifiDataOrBuilder() {
        WifiScanData r8 = this.anchorWifiData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WifiScanData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public WifiScanData getNewWifiScanData() {
        WifiScanData r8 = this.newWifiScanData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WifiScanData.getDefaultInstance();
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public WifiScanDataOrBuilder getNewWifiScanDataOrBuilder() {
        WifiScanData r8 = this.newWifiScanData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WifiScanData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WifiScanDataPair> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeMessageSize(1, getNewWifiScanData());
    L9:
        if ((this.bitField0_ & 2) == 0) goto L11;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getAnchorWifiData());
    L11:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public boolean hasAnchorWifiData() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.WifiScanDataPairOrBuilder
    public boolean hasNewWifiScanData() {
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
        int r10 = getDescriptor().hashCode() + 779;
        if (hasNewWifiScanData() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getNewWifiScanData().hashCode();
    L9:
        if (hasAnchorWifiData() == false) goto L11;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getAnchorWifiData().hashCode();
    L11:
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
        return new WifiScanDataPair();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeMessage(1, getNewWifiScanData());
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r8.writeMessage(2, getAnchorWifiData());
    L8:
        getUnknownFields().writeTo(r8);
    }

    private WifiScanDataPair(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WifiScanDataPair r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WifiScanDataPair parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataPair) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WifiScanDataPair parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_WifiScanDataPair_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanDataPair.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WifiScanDataPair(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WifiScanDataPair parseFrom(CodedInputStream r8) {
        return (WifiScanDataPair) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WifiScanDataPair getDefaultInstanceForType() {
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

    public static WifiScanDataPair parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataPair) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WifiScanDataPair parseFrom(InputStream r8) {
        return (WifiScanDataPair) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WifiScanDataPair parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataPair) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WifiScanDataPair parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanDataPair parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WifiScanDataPair parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanDataPair parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
