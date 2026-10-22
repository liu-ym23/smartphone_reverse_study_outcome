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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class StartScanDailyReportData extends GeneratedMessageV3 implements StartScanDailyReportDataOrBuilder {
    public static final int DATE_KEY_FIELD_NUMBER = 2;
    private static final StartScanDailyReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 5;
    public static final int DEVICE_TIME_FIELD_NUMBER = 4;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int FULL_SCAN_COUNT_FIELD_NUMBER = 7;

    @Deprecated
    public static final Parser<StartScanDailyReportData> PARSER = null;
    public static final int PARTIAL_SCAN_COUNT_FIELD_NUMBER = 6;
    public static final int START_SCAN_SUCCESS_COUNT_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object dateKey_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private int fullScanCount_;
    private byte memoizedIsInitialized;
    private int partialScanCount_;
    private int startScanSuccessCount_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StartScanDailyReportDataOrBuilder {
        private int bitField0_;
        private Object dateKey_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int fullScanCount_;
        private int partialScanCount_;
        private int startScanSuccessCount_;

        private Builder() {
            this.eventType_ = "";
            this.dateKey_ = "";
            this.deviceDate_ = "";
        }

        private void buildPartial0(StartScanDailyReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            StartScanDailyReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            StartScanDailyReportData.access$402(r8, this.dateKey_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            StartScanDailyReportData.access$502(r8, this.startScanSuccessCount_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            StartScanDailyReportData.access$602(r8, this.deviceTime_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            StartScanDailyReportData.access$702(r8, this.deviceDate_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            StartScanDailyReportData.access$802(r8, this.partialScanCount_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L24;
            StartScanDailyReportData.access$902(r8, this.fullScanCount_);
            r11 = r11 | 64;
        L24:
            StartScanDailyReportData.access$1076(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_StartScanDailyReportData_descriptor;
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

        public Builder clearDateKey() {
            this.dateKey_ = StartScanDailyReportData.getDefaultInstance().getDateKey();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = StartScanDailyReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -9;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = StartScanDailyReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFullScanCount() {
            this.bitField0_ &= -65;
            this.fullScanCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPartialScanCount() {
            this.bitField0_ &= -33;
            this.partialScanCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStartScanSuccessCount() {
            this.bitField0_ &= -5;
            this.startScanSuccessCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public String getDateKey() {
            Object r8 = this.dateKey_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.dateKey_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public ByteString getDateKeyBytes() {
            Object r8 = this.dateKey_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.dateKey_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_StartScanDailyReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public String getDeviceDate() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceDate_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public String getEventType() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.eventType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public int getFullScanCount() {
            return this.fullScanCount_;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public int getPartialScanCount() {
            return this.partialScanCount_;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public int getStartScanSuccessCount() {
            return this.startScanSuccessCount_;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasDateKey() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasFullScanCount() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasPartialScanCount() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
        public boolean hasStartScanSuccessCount() {
            if ((this.bitField0_ & 4) == 0) goto L5;
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

        public Builder setDateKey(String r8) {
            if (r8 == null) goto L6;
            this.dateKey_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDateKeyBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.dateKey_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEventType(String r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEventTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setFullScanCount(int r8) {
            this.fullScanCount_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setPartialScanCount(int r8) {
            this.partialScanCount_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setStartScanSuccessCount(int r8) {
            this.startScanSuccessCount_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.dateKey_ = "";
            this.deviceDate_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_StartScanDailyReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(StartScanDailyReportData.class, Builder.class);
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

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StartScanDailyReportData build() {
            StartScanDailyReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StartScanDailyReportData buildPartial() {
            StartScanDailyReportData r8 = new StartScanDailyReportData(this, null);
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
        public StartScanDailyReportData getDefaultInstanceForType() {
            return StartScanDailyReportData.getDefaultInstance();
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
            this.eventType_ = "";
            this.dateKey_ = "";
            this.startScanSuccessCount_ = 0;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            this.partialScanCount_ = 0;
            this.fullScanCount_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L43;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L40;
            int r12 = r8.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r12 == 0) goto L32;
            if (r12 != 10) goto L10;
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.dateKey_ = r8.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.startScanSuccessCount_ = r8.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 8;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L16:
            if (r12 != 42) goto L18;
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L18:
            if (r12 != 48) goto L20;
            this.partialScanCount_ = r8.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 32;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L20:
            if (r12 != 56) goto L22;
            this.fullScanCount_ = r8.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 64;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L32:
            r11 = true;
            goto L4
        L35:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            onChanged();
            return this;
        L43:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof StartScanDailyReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((StartScanDailyReportData) r8);
        }

        public Builder mergeFrom(StartScanDailyReportData r8) {
            if (r8 != StartScanDailyReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = StartScanDailyReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasDateKey() == false) goto L12;
            this.dateKey_ = StartScanDailyReportData.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasStartScanSuccessCount() == false) goto L15;
            setStartScanSuccessCount(r8.getStartScanSuccessCount());
        L15:
            if (r8.hasDeviceTime() == false) goto L18;
            setDeviceTime(r8.getDeviceTime());
        L18:
            if (r8.hasDeviceDate() == false) goto L21;
            this.deviceDate_ = StartScanDailyReportData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasPartialScanCount() == false) goto L24;
            setPartialScanCount(r8.getPartialScanCount());
        L24:
            if (r8.hasFullScanCount() == false) goto L26;
            setFullScanCount(r8.getFullScanCount());
        L26:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new StartScanDailyReportData();
        PARSER = new AnonymousClass1();
    }

    private StartScanDailyReportData() {
        this.eventType_ = "";
        this.dateKey_ = "";
        this.startScanSuccessCount_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.partialScanCount_ = 0;
        this.fullScanCount_ = 0;
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.dateKey_ = "";
        this.deviceDate_ = "";
    }

    public static /* synthetic */ int access$1076(StartScanDailyReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(StartScanDailyReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(StartScanDailyReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(StartScanDailyReportData r8) {
        return r8.dateKey_;
    }

    public static /* synthetic */ Object access$402(StartScanDailyReportData r8, Object r10) {
        r8.dateKey_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(StartScanDailyReportData r8, int r10) {
        r8.startScanSuccessCount_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(StartScanDailyReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(StartScanDailyReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$702(StartScanDailyReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(StartScanDailyReportData r8, int r10) {
        r8.partialScanCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(StartScanDailyReportData r8, int r10) {
        r8.fullScanCount_ = r10;
        return r10;
    }

    public static StartScanDailyReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_StartScanDailyReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StartScanDailyReportData parseDelimitedFrom(InputStream r8) {
        return (StartScanDailyReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static StartScanDailyReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<StartScanDailyReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof StartScanDailyReportData) == false) goto L8;
        StartScanDailyReportData r10 = (StartScanDailyReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasDateKey() == r10.hasDateKey()) goto L21;
        return false;
    L21:
        if (hasDateKey() == false) goto L26;
        if (getDateKey().equals(r10.getDateKey()) == true) goto L26;
        return false;
    L26:
        if (hasStartScanSuccessCount() == r10.hasStartScanSuccessCount()) goto L29;
        return false;
    L29:
        if (hasStartScanSuccessCount() == false) goto L34;
        if (getStartScanSuccessCount() == r10.getStartScanSuccessCount()) goto L34;
        return false;
    L34:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L37;
        return false;
    L37:
        if (hasDeviceTime() == false) goto L42;
        if (getDeviceTime() == r10.getDeviceTime()) goto L42;
        return false;
    L42:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L45;
        return false;
    L45:
        if (hasDeviceDate() == false) goto L50;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L50;
        return false;
    L50:
        if (hasPartialScanCount() == r10.hasPartialScanCount()) goto L53;
        return false;
    L53:
        if (hasPartialScanCount() == false) goto L58;
        if (getPartialScanCount() == r10.getPartialScanCount()) goto L58;
        return false;
    L58:
        if (hasFullScanCount() == r10.hasFullScanCount()) goto L61;
        return false;
    L61:
        if (hasFullScanCount() == false) goto L66;
        if (getFullScanCount() == r10.getFullScanCount()) goto L66;
        return false;
    L66:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L68;
        return false;
    L68:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public String getDateKey() {
        Object r8 = this.dateKey_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.dateKey_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public ByteString getDateKeyBytes() {
        Object r8 = this.dateKey_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.dateKey_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public String getDeviceDate() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceDate_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public String getEventType() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.eventType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public int getFullScanCount() {
        return this.fullScanCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<StartScanDailyReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public int getPartialScanCount() {
        return this.partialScanCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.eventType_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.dateKey_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.startScanSuccessCount_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeUInt64Size(4, this.deviceTime_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.deviceDate_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.partialScanCount_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L26;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.fullScanCount_);
    L26:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public int getStartScanSuccessCount() {
        return this.startScanSuccessCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasDateKey() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasFullScanCount() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasPartialScanCount() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.StartScanDailyReportDataOrBuilder
    public boolean hasStartScanSuccessCount() {
        if ((this.bitField0_ & 4) == 0) goto L5;
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
        if (hasEventType() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getEventType().hashCode();
    L9:
        if (hasDateKey() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getDateKey().hashCode();
    L12:
        if (hasStartScanSuccessCount() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getStartScanSuccessCount();
    L15:
        if (hasDeviceTime() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + Internal.hashLong(getDeviceTime());
    L18:
        if (hasDeviceDate() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getDeviceDate().hashCode();
    L21:
        if (hasPartialScanCount() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getPartialScanCount();
    L24:
        if (hasFullScanCount() == false) goto L26;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getFullScanCount();
    L26:
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
        return new StartScanDailyReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.eventType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.dateKey_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.startScanSuccessCount_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeUInt64(4, this.deviceTime_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.deviceDate_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.partialScanCount_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L23;
        r8.writeInt32(7, this.fullScanCount_);
    L23:
        getUnknownFields().writeTo(r8);
    }

    private StartScanDailyReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.dateKey_ = "";
        this.startScanSuccessCount_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.partialScanCount_ = 0;
        this.fullScanCount_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(StartScanDailyReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static StartScanDailyReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StartScanDailyReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static StartScanDailyReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_StartScanDailyReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(StartScanDailyReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ StartScanDailyReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static StartScanDailyReportData parseFrom(CodedInputStream r8) {
        return (StartScanDailyReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public StartScanDailyReportData getDefaultInstanceForType() {
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

    public static StartScanDailyReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (StartScanDailyReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static StartScanDailyReportData parseFrom(InputStream r8) {
        return (StartScanDailyReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static StartScanDailyReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StartScanDailyReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static StartScanDailyReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static StartScanDailyReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static StartScanDailyReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static StartScanDailyReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
