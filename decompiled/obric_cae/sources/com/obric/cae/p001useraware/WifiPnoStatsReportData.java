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
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiPnoStatsReportData extends GeneratedMessageV3 implements WifiPnoStatsReportDataOrBuilder {
    private static final WifiPnoStatsReportData DEFAULT_INSTANCE = null;
    public static final int DURATIONMS_FIELD_NUMBER = 5;
    public static final int ESTIMATEDROUNDSTODAY_FIELD_NUMBER = 10;
    public static final int ESTIMATEDROUNDS_FIELD_NUMBER = 7;
    public static final int EVENT_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<WifiPnoStatsReportData> PARSER = null;
    public static final int PERIODMS_FIELD_NUMBER = 6;
    public static final int SESSIONCOUNTTODAY_FIELD_NUMBER = 9;
    public static final int STARTWALLCLOCKMS_FIELD_NUMBER = 3;
    public static final int STOPWALLCLOCKMS_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int TOTALDURATIONTODAYMS_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private long durationMs_;
    private int estimatedRoundsToday_;
    private int estimatedRounds_;
    private int event_;
    private byte memoizedIsInitialized;
    private int periodMs_;
    private int sessionCountToday_;
    private long startWallClockMs_;
    private long stopWallClockMs_;
    private long timeStamp_;
    private long totalDurationTodayMs_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiPnoStatsReportDataOrBuilder {
        private int bitField0_;
        private long durationMs_;
        private int estimatedRoundsToday_;
        private int estimatedRounds_;
        private int event_;
        private int periodMs_;
        private int sessionCountToday_;
        private long startWallClockMs_;
        private long stopWallClockMs_;
        private long timeStamp_;
        private long totalDurationTodayMs_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(WifiPnoStatsReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WifiPnoStatsReportData.access$302(r8, this.timeStamp_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WifiPnoStatsReportData.access$402(r8, this.event_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WifiPnoStatsReportData.access$502(r8, this.startWallClockMs_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WifiPnoStatsReportData.access$602(r8, this.stopWallClockMs_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            WifiPnoStatsReportData.access$702(r8, this.durationMs_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            WifiPnoStatsReportData.access$802(r8, this.periodMs_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            WifiPnoStatsReportData.access$902(r8, this.estimatedRounds_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            WifiPnoStatsReportData.access$1002(r8, this.totalDurationTodayMs_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            WifiPnoStatsReportData.access$1102(r8, this.sessionCountToday_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L33;
            WifiPnoStatsReportData.access$1202(r8, this.estimatedRoundsToday_);
            r11 = r11 | 512;
        L33:
            WifiPnoStatsReportData.access$1376(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_descriptor;
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

        public Builder clearDurationMs() {
            this.bitField0_ &= -17;
            this.durationMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEstimatedRounds() {
            this.bitField0_ &= -65;
            this.estimatedRounds_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEstimatedRoundsToday() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.estimatedRoundsToday_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEvent() {
            this.bitField0_ &= -3;
            this.event_ = 0;
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

        public Builder clearPeriodMs() {
            this.bitField0_ &= -33;
            this.periodMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSessionCountToday() {
            this.bitField0_ &= -257;
            this.sessionCountToday_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStartWallClockMs() {
            this.bitField0_ &= -5;
            this.startWallClockMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStopWallClockMs() {
            this.bitField0_ &= -9;
            this.stopWallClockMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeStamp() {
            this.bitField0_ &= -2;
            this.timeStamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalDurationTodayMs() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.totalDurationTodayMs_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_descriptor;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public long getDurationMs() {
            return this.durationMs_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public int getEstimatedRounds() {
            return this.estimatedRounds_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public int getEstimatedRoundsToday() {
            return this.estimatedRoundsToday_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public int getEvent() {
            return this.event_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public int getPeriodMs() {
            return this.periodMs_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public int getSessionCountToday() {
            return this.sessionCountToday_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public long getStartWallClockMs() {
            return this.startWallClockMs_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public long getStopWallClockMs() {
            return this.stopWallClockMs_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public long getTimeStamp() {
            return this.timeStamp_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public long getTotalDurationTodayMs() {
            return this.totalDurationTodayMs_;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasDurationMs() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasEstimatedRounds() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasEstimatedRoundsToday() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasEvent() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasPeriodMs() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasSessionCountToday() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasStartWallClockMs() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasStopWallClockMs() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasTimeStamp() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
        public boolean hasTotalDurationTodayMs() {
            if ((this.bitField0_ & 128) == 0) goto L5;
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

        public Builder setDurationMs(long r8) {
            this.durationMs_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setEstimatedRounds(int r8) {
            this.estimatedRounds_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setEstimatedRoundsToday(int r8) {
            this.estimatedRoundsToday_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setEvent(int r8) {
            this.event_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setPeriodMs(int r8) {
            this.periodMs_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSessionCountToday(int r8) {
            this.sessionCountToday_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setStartWallClockMs(long r8) {
            this.startWallClockMs_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setStopWallClockMs(long r8) {
            this.stopWallClockMs_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setTimeStamp(long r8) {
            this.timeStamp_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTotalDurationTodayMs(long r8) {
            this.totalDurationTodayMs_ = r8;
            this.bitField0_ |= 128;
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
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiPnoStatsReportData.class, Builder.class);
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
        public WifiPnoStatsReportData build() {
            WifiPnoStatsReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiPnoStatsReportData buildPartial() {
            WifiPnoStatsReportData r8 = new WifiPnoStatsReportData(this, null);
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
        public WifiPnoStatsReportData getDefaultInstanceForType() {
            return WifiPnoStatsReportData.getDefaultInstance();
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
            this.timeStamp_ = 0;
            this.event_ = 0;
            this.startWallClockMs_ = 0;
            this.stopWallClockMs_ = 0;
            this.durationMs_ = 0;
            this.periodMs_ = 0;
            this.estimatedRounds_ = 0;
            this.totalDurationTodayMs_ = 0;
            this.sessionCountToday_ = 0;
            this.estimatedRoundsToday_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L32;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L29;
            int r12 = r8.readTag();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            switch(r12) {
                case 0: goto L19;
                case 8: goto L17;
                case 16: goto L16;
                case 24: goto L15;
                case 32: goto L14;
                case 40: goto L13;
                case 48: goto L12;
                case 56: goto L11;
                case 64: goto L10;
                case 72: goto L9;
                case 80: goto L8;
                default: goto L20;
            };     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
        L8:
            this.estimatedRoundsToday_ = r8.readSInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 512;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L9:
            this.sessionCountToday_ = r8.readSInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 256;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L10:
            this.totalDurationTodayMs_ = r8.readInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 128;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L11:
            this.estimatedRounds_ = r8.readSInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 64;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L12:
            this.periodMs_ = r8.readSInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 32;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L13:
            this.durationMs_ = r8.readInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 16;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L14:
            this.stopWallClockMs_ = r8.readInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 8;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L15:
            this.startWallClockMs_ = r8.readInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 4;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L16:
            this.event_ = r8.readSInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 2;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L17:
            this.timeStamp_ = r8.readInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 1;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
        L19:
            r11 = true;
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L24:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            onChanged();
            return this;
        L32:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof WifiPnoStatsReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WifiPnoStatsReportData) r8);
        }

        public Builder mergeFrom(WifiPnoStatsReportData r8) {
            if (r8 != WifiPnoStatsReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTimeStamp() == false) goto L9;
            setTimeStamp(r8.getTimeStamp());
        L9:
            if (r8.hasEvent() == false) goto L12;
            setEvent(r8.getEvent());
        L12:
            if (r8.hasStartWallClockMs() == false) goto L15;
            setStartWallClockMs(r8.getStartWallClockMs());
        L15:
            if (r8.hasStopWallClockMs() == false) goto L18;
            setStopWallClockMs(r8.getStopWallClockMs());
        L18:
            if (r8.hasDurationMs() == false) goto L21;
            setDurationMs(r8.getDurationMs());
        L21:
            if (r8.hasPeriodMs() == false) goto L24;
            setPeriodMs(r8.getPeriodMs());
        L24:
            if (r8.hasEstimatedRounds() == false) goto L27;
            setEstimatedRounds(r8.getEstimatedRounds());
        L27:
            if (r8.hasTotalDurationTodayMs() == false) goto L30;
            setTotalDurationTodayMs(r8.getTotalDurationTodayMs());
        L30:
            if (r8.hasSessionCountToday() == false) goto L33;
            setSessionCountToday(r8.getSessionCountToday());
        L33:
            if (r8.hasEstimatedRoundsToday() == false) goto L35;
            setEstimatedRoundsToday(r8.getEstimatedRoundsToday());
        L35:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WifiPnoStatsReportData();
        PARSER = new AnonymousClass1();
    }

    private WifiPnoStatsReportData() {
        this.timeStamp_ = 0;
        this.event_ = 0;
        this.startWallClockMs_ = 0;
        this.stopWallClockMs_ = 0;
        this.durationMs_ = 0;
        this.periodMs_ = 0;
        this.estimatedRounds_ = 0;
        this.totalDurationTodayMs_ = 0;
        this.sessionCountToday_ = 0;
        this.estimatedRoundsToday_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ long access$1002(WifiPnoStatsReportData r8, long r10) {
        r8.totalDurationTodayMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(WifiPnoStatsReportData r8, int r10) {
        r8.sessionCountToday_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(WifiPnoStatsReportData r8, int r10) {
        r8.estimatedRoundsToday_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1376(WifiPnoStatsReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$302(WifiPnoStatsReportData r8, long r10) {
        r8.timeStamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(WifiPnoStatsReportData r8, int r10) {
        r8.event_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$502(WifiPnoStatsReportData r8, long r10) {
        r8.startWallClockMs_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(WifiPnoStatsReportData r8, long r10) {
        r8.stopWallClockMs_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$702(WifiPnoStatsReportData r8, long r10) {
        r8.durationMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(WifiPnoStatsReportData r8, int r10) {
        r8.periodMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(WifiPnoStatsReportData r8, int r10) {
        r8.estimatedRounds_ = r10;
        return r10;
    }

    public static WifiPnoStatsReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WifiPnoStatsReportData parseDelimitedFrom(InputStream r8) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WifiPnoStatsReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WifiPnoStatsReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WifiPnoStatsReportData) == false) goto L8;
        WifiPnoStatsReportData r10 = (WifiPnoStatsReportData) r8;
        if (hasTimeStamp() == r10.hasTimeStamp()) goto L13;
        return false;
    L13:
        if (hasTimeStamp() == false) goto L18;
        if (getTimeStamp() == r10.getTimeStamp()) goto L18;
        return false;
    L18:
        if (hasEvent() == r10.hasEvent()) goto L21;
        return false;
    L21:
        if (hasEvent() == false) goto L26;
        if (getEvent() == r10.getEvent()) goto L26;
        return false;
    L26:
        if (hasStartWallClockMs() == r10.hasStartWallClockMs()) goto L29;
        return false;
    L29:
        if (hasStartWallClockMs() == false) goto L34;
        if (getStartWallClockMs() == r10.getStartWallClockMs()) goto L34;
        return false;
    L34:
        if (hasStopWallClockMs() == r10.hasStopWallClockMs()) goto L37;
        return false;
    L37:
        if (hasStopWallClockMs() == false) goto L42;
        if (getStopWallClockMs() == r10.getStopWallClockMs()) goto L42;
        return false;
    L42:
        if (hasDurationMs() == r10.hasDurationMs()) goto L45;
        return false;
    L45:
        if (hasDurationMs() == false) goto L50;
        if (getDurationMs() == r10.getDurationMs()) goto L50;
        return false;
    L50:
        if (hasPeriodMs() == r10.hasPeriodMs()) goto L53;
        return false;
    L53:
        if (hasPeriodMs() == false) goto L58;
        if (getPeriodMs() == r10.getPeriodMs()) goto L58;
        return false;
    L58:
        if (hasEstimatedRounds() == r10.hasEstimatedRounds()) goto L61;
        return false;
    L61:
        if (hasEstimatedRounds() == false) goto L66;
        if (getEstimatedRounds() == r10.getEstimatedRounds()) goto L66;
        return false;
    L66:
        if (hasTotalDurationTodayMs() == r10.hasTotalDurationTodayMs()) goto L69;
        return false;
    L69:
        if (hasTotalDurationTodayMs() == false) goto L74;
        if (getTotalDurationTodayMs() == r10.getTotalDurationTodayMs()) goto L74;
        return false;
    L74:
        if (hasSessionCountToday() == r10.hasSessionCountToday()) goto L77;
        return false;
    L77:
        if (hasSessionCountToday() == false) goto L82;
        if (getSessionCountToday() == r10.getSessionCountToday()) goto L82;
        return false;
    L82:
        if (hasEstimatedRoundsToday() == r10.hasEstimatedRoundsToday()) goto L85;
        return false;
    L85:
        if (hasEstimatedRoundsToday() == false) goto L90;
        if (getEstimatedRoundsToday() == r10.getEstimatedRoundsToday()) goto L90;
        return false;
    L90:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L92;
        return false;
    L92:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public long getDurationMs() {
        return this.durationMs_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public int getEstimatedRounds() {
        return this.estimatedRounds_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public int getEstimatedRoundsToday() {
        return this.estimatedRoundsToday_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public int getEvent() {
        return this.event_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WifiPnoStatsReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public int getPeriodMs() {
        return this.periodMs_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt64Size(1, this.timeStamp_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeSInt32Size(2, this.event_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt64Size(3, this.startWallClockMs_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt64Size(4, this.stopWallClockMs_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt64Size(5, this.durationMs_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeSInt32Size(6, this.periodMs_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeSInt32Size(7, this.estimatedRounds_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt64Size(8, this.totalDurationTodayMs_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeSInt32Size(9, this.sessionCountToday_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L35;
        r10 = r10 + CodedOutputStream.computeSInt32Size(10, this.estimatedRoundsToday_);
    L35:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public int getSessionCountToday() {
        return this.sessionCountToday_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public long getStartWallClockMs() {
        return this.startWallClockMs_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public long getStopWallClockMs() {
        return this.stopWallClockMs_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public long getTimeStamp() {
        return this.timeStamp_;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public long getTotalDurationTodayMs() {
        return this.totalDurationTodayMs_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasDurationMs() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasEstimatedRounds() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasEstimatedRoundsToday() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasEvent() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasPeriodMs() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasSessionCountToday() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasStartWallClockMs() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasStopWallClockMs() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasTimeStamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.p001useraware.WifiPnoStatsReportDataOrBuilder
    public boolean hasTotalDurationTodayMs() {
        if ((this.bitField0_ & 128) == 0) goto L5;
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
        if (hasTimeStamp() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getTimeStamp());
    L9:
        if (hasEvent() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getEvent();
    L12:
        if (hasStartWallClockMs() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(getStartWallClockMs());
    L15:
        if (hasStopWallClockMs() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashLong(getStopWallClockMs());
    L18:
        if (hasDurationMs() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashLong(getDurationMs());
    L21:
        if (hasPeriodMs() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getPeriodMs();
    L24:
        if (hasEstimatedRounds() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getEstimatedRounds();
    L27:
        if (hasTotalDurationTodayMs() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + Internal.hashLong(getTotalDurationTodayMs());
    L30:
        if (hasSessionCountToday() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getSessionCountToday();
    L33:
        if (hasEstimatedRoundsToday() == false) goto L35;
        r10 = b.a(r10, 37, 10, 53) + getEstimatedRoundsToday();
    L35:
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
        return new WifiPnoStatsReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt64(1, this.timeStamp_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeSInt32(2, this.event_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt64(3, this.startWallClockMs_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt64(4, this.stopWallClockMs_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt64(5, this.durationMs_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeSInt32(6, this.periodMs_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeSInt32(7, this.estimatedRounds_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt64(8, this.totalDurationTodayMs_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeSInt32(9, this.sessionCountToday_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L32;
        r8.writeSInt32(10, this.estimatedRoundsToday_);
    L32:
        getUnknownFields().writeTo(r8);
    }

    private WifiPnoStatsReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.timeStamp_ = 0;
        this.event_ = 0;
        this.startWallClockMs_ = 0;
        this.stopWallClockMs_ = 0;
        this.durationMs_ = 0;
        this.periodMs_ = 0;
        this.estimatedRounds_ = 0;
        this.totalDurationTodayMs_ = 0;
        this.sessionCountToday_ = 0;
        this.estimatedRoundsToday_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WifiPnoStatsReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WifiPnoStatsReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WifiPnoStatsReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiPnoStatsReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WifiPnoStatsReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WifiPnoStatsReportData parseFrom(CodedInputStream r8) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WifiPnoStatsReportData getDefaultInstanceForType() {
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

    public static WifiPnoStatsReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WifiPnoStatsReportData parseFrom(InputStream r8) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WifiPnoStatsReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiPnoStatsReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WifiPnoStatsReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiPnoStatsReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WifiPnoStatsReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiPnoStatsReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
