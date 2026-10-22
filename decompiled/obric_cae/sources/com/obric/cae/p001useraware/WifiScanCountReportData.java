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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiScanCountReportData extends GeneratedMessageV3 implements WifiScanCountReportDataOrBuilder {
    public static final int DATESCANCOUNT_FIELD_NUMBER = 4;
    public static final int DATESCANDROPCOUNT_FIELD_NUMBER = 5;
    private static final WifiScanCountReportData DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<WifiScanCountReportData> PARSER = null;
    public static final int SCANTYPE_FIELD_NUMBER = 3;
    public static final int SCENETYPE_FIELD_NUMBER = 1;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int dateScanCount_;
    private int dateScanDropCount_;
    private byte memoizedIsInitialized;
    private int scanType_;
    private int sceneType_;
    private long timeStamp_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiScanCountReportDataOrBuilder {
        private int bitField0_;
        private int dateScanCount_;
        private int dateScanDropCount_;
        private int scanType_;
        private int sceneType_;
        private long timeStamp_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(WifiScanCountReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WifiScanCountReportData.access$302(r8, this.sceneType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WifiScanCountReportData.access$402(r8, this.timeStamp_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WifiScanCountReportData.access$502(r8, this.scanType_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WifiScanCountReportData.access$602(r8, this.dateScanCount_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L18;
            WifiScanCountReportData.access$702(r8, this.dateScanDropCount_);
            r11 = r11 | 16;
        L18:
            WifiScanCountReportData.access$876(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiScanCountReportData_descriptor;
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

        public Builder clearDateScanCount() {
            this.bitField0_ &= -9;
            this.dateScanCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDateScanDropCount() {
            this.bitField0_ &= -17;
            this.dateScanDropCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearScanType() {
            this.bitField0_ &= -5;
            this.scanType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSceneType() {
            this.bitField0_ &= -2;
            this.sceneType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeStamp() {
            this.bitField0_ &= -3;
            this.timeStamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public int getDateScanCount() {
            return this.dateScanCount_;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public int getDateScanDropCount() {
            return this.dateScanDropCount_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiScanCountReportData_descriptor;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public int getScanType() {
            return this.scanType_;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public int getSceneType() {
            return this.sceneType_;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public long getTimeStamp() {
            return this.timeStamp_;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public boolean hasDateScanCount() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public boolean hasDateScanDropCount() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public boolean hasScanType() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public boolean hasSceneType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
        public boolean hasTimeStamp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
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

        public Builder setDateScanCount(int r8) {
            this.dateScanCount_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setDateScanDropCount(int r8) {
            this.dateScanDropCount_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setScanType(int r8) {
            this.scanType_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setSceneType(int r8) {
            this.sceneType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTimeStamp(long r8) {
            this.timeStamp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
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
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiScanCountReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanCountReportData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
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

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiScanCountReportData build() {
            WifiScanCountReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiScanCountReportData buildPartial() {
            WifiScanCountReportData r8 = new WifiScanCountReportData(this, null);
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
        public WifiScanCountReportData getDefaultInstanceForType() {
            return WifiScanCountReportData.getDefaultInstance();
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
            this.sceneType_ = 0;
            this.timeStamp_ = 0;
            this.scanType_ = 0;
            this.dateScanCount_ = 0;
            this.dateScanDropCount_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L37;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L34;
            int r12 = r8.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r12 == 0) goto L26;
            if (r12 != 8) goto L10;
            this.sceneType_ = r8.readSInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.timeStamp_ = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.scanType_ = r8.readSInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.dateScanCount_ = r8.readSInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.dateScanDropCount_ = r8.readSInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L18:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L26:
            r11 = true;
            goto L4
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L34:
            onChanged();
            return this;
        L37:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof WifiScanCountReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WifiScanCountReportData) r8);
        }

        public Builder mergeFrom(WifiScanCountReportData r8) {
            if (r8 != WifiScanCountReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSceneType() == false) goto L9;
            setSceneType(r8.getSceneType());
        L9:
            if (r8.hasTimeStamp() == false) goto L12;
            setTimeStamp(r8.getTimeStamp());
        L12:
            if (r8.hasScanType() == false) goto L15;
            setScanType(r8.getScanType());
        L15:
            if (r8.hasDateScanCount() == false) goto L18;
            setDateScanCount(r8.getDateScanCount());
        L18:
            if (r8.hasDateScanDropCount() == false) goto L20;
            setDateScanDropCount(r8.getDateScanDropCount());
        L20:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WifiScanCountReportData();
        PARSER = new AnonymousClass1();
    }

    private WifiScanCountReportData() {
        this.sceneType_ = 0;
        this.timeStamp_ = 0;
        this.scanType_ = 0;
        this.dateScanCount_ = 0;
        this.dateScanDropCount_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ int access$302(WifiScanCountReportData r8, int r10) {
        r8.sceneType_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$402(WifiScanCountReportData r8, long r10) {
        r8.timeStamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(WifiScanCountReportData r8, int r10) {
        r8.scanType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(WifiScanCountReportData r8, int r10) {
        r8.dateScanCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(WifiScanCountReportData r8, int r10) {
        r8.dateScanDropCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$876(WifiScanCountReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static WifiScanCountReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiScanCountReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WifiScanCountReportData parseDelimitedFrom(InputStream r8) {
        return (WifiScanCountReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WifiScanCountReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WifiScanCountReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WifiScanCountReportData) == false) goto L8;
        WifiScanCountReportData r10 = (WifiScanCountReportData) r8;
        if (hasSceneType() == r10.hasSceneType()) goto L13;
        return false;
    L13:
        if (hasSceneType() == false) goto L18;
        if (getSceneType() == r10.getSceneType()) goto L18;
        return false;
    L18:
        if (hasTimeStamp() == r10.hasTimeStamp()) goto L21;
        return false;
    L21:
        if (hasTimeStamp() == false) goto L26;
        if (getTimeStamp() == r10.getTimeStamp()) goto L26;
        return false;
    L26:
        if (hasScanType() == r10.hasScanType()) goto L29;
        return false;
    L29:
        if (hasScanType() == false) goto L34;
        if (getScanType() == r10.getScanType()) goto L34;
        return false;
    L34:
        if (hasDateScanCount() == r10.hasDateScanCount()) goto L37;
        return false;
    L37:
        if (hasDateScanCount() == false) goto L42;
        if (getDateScanCount() == r10.getDateScanCount()) goto L42;
        return false;
    L42:
        if (hasDateScanDropCount() == r10.hasDateScanDropCount()) goto L45;
        return false;
    L45:
        if (hasDateScanDropCount() == false) goto L50;
        if (getDateScanDropCount() == r10.getDateScanDropCount()) goto L50;
        return false;
    L50:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L52;
        return false;
    L52:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public int getDateScanCount() {
        return this.dateScanCount_;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public int getDateScanDropCount() {
        return this.dateScanDropCount_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WifiScanCountReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public int getScanType() {
        return this.scanType_;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public int getSceneType() {
        return this.sceneType_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeSInt32Size(1, this.sceneType_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt64Size(2, this.timeStamp_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeSInt32Size(3, this.scanType_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeSInt32Size(4, this.dateScanCount_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L20;
        r10 = r10 + CodedOutputStream.computeSInt32Size(5, this.dateScanDropCount_);
    L20:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public long getTimeStamp() {
        return this.timeStamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public boolean hasDateScanCount() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public boolean hasDateScanDropCount() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public boolean hasScanType() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public boolean hasSceneType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.p001useraware.WifiScanCountReportDataOrBuilder
    public boolean hasTimeStamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
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
        if (hasSceneType() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSceneType();
    L9:
        if (hasTimeStamp() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getTimeStamp());
    L12:
        if (hasScanType() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getScanType();
    L15:
        if (hasDateScanCount() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getDateScanCount();
    L18:
        if (hasDateScanDropCount() == false) goto L20;
        r10 = b.a(r10, 37, 5, 53) + getDateScanDropCount();
    L20:
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
        return new WifiScanCountReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeSInt32(1, this.sceneType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt64(2, this.timeStamp_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeSInt32(3, this.scanType_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeSInt32(4, this.dateScanCount_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L17;
        r8.writeSInt32(5, this.dateScanDropCount_);
    L17:
        getUnknownFields().writeTo(r8);
    }

    private WifiScanCountReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.sceneType_ = 0;
        this.timeStamp_ = 0;
        this.scanType_ = 0;
        this.dateScanCount_ = 0;
        this.dateScanDropCount_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WifiScanCountReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WifiScanCountReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanCountReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WifiScanCountReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiScanCountReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanCountReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WifiScanCountReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WifiScanCountReportData parseFrom(CodedInputStream r8) {
        return (WifiScanCountReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WifiScanCountReportData getDefaultInstanceForType() {
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

    public static WifiScanCountReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanCountReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WifiScanCountReportData parseFrom(InputStream r8) {
        return (WifiScanCountReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WifiScanCountReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanCountReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WifiScanCountReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanCountReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WifiScanCountReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanCountReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
