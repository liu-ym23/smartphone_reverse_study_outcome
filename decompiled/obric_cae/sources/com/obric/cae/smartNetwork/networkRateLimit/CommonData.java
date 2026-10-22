package com.obric.cae.smartNetwork.networkRateLimit;

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
public final class CommonData extends GeneratedMessageV3 implements CommonDataOrBuilder {
    public static final int BACKGROUND_APP_RATE_FIELD_NUMBER = 9;
    private static final CommonData DEFAULT_INSTANCE = null;
    public static final int FOREGROUND_APP_IS_IN_WHITELIST_FIELD_NUMBER = 6;
    public static final int FOREGROUND_APP_PKG_NAME_FIELD_NUMBER = 5;
    public static final int FOREGROUND_APP_RATE_FIELD_NUMBER = 7;
    public static final int FOREGROUND_APP_RTT_AVERAGE_FIELD_NUMBER = 8;
    public static final int IF_NAME_FIELD_NUMBER = 1;
    public static final int MAX_BANDWIDTH_ESTIMATED_VALUE_FIELD_NUMBER = 4;

    @Deprecated
    public static final Parser<CommonData> PARSER = null;
    public static final int RATE_CTRL_UID_NUMBER_FIELD_NUMBER = 2;
    public static final int TEMPERATURE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int backgroundAppRate_;
    private int bitField0_;
    private boolean foregroundAppIsInWhitelist_;
    private volatile Object foregroundAppPkgName_;
    private int foregroundAppRate_;
    private int foregroundAppRttAverage_;
    private volatile Object ifName_;
    private int maxBandwidthEstimatedValue_;
    private byte memoizedIsInitialized;
    private int rateCtrlUidNumber_;
    private float temperature_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonDataOrBuilder {
        private int backgroundAppRate_;
        private int bitField0_;
        private boolean foregroundAppIsInWhitelist_;
        private Object foregroundAppPkgName_;
        private int foregroundAppRate_;
        private int foregroundAppRttAverage_;
        private Object ifName_;
        private int maxBandwidthEstimatedValue_;
        private int rateCtrlUidNumber_;
        private float temperature_;

        private Builder() {
            this.ifName_ = "";
            this.foregroundAppPkgName_ = "";
        }

        private void buildPartial0(CommonData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            CommonData.access$302(r8, this.ifName_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            CommonData.access$402(r8, this.rateCtrlUidNumber_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            CommonData.access$502(r8, this.temperature_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            CommonData.access$602(r8, this.maxBandwidthEstimatedValue_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            CommonData.access$702(r8, this.foregroundAppPkgName_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            CommonData.access$802(r8, this.foregroundAppIsInWhitelist_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            CommonData.access$902(r8, this.foregroundAppRate_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            CommonData.access$1002(r8, this.foregroundAppRttAverage_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L30;
            CommonData.access$1102(r8, this.backgroundAppRate_);
            r11 = r11 | 256;
        L30:
            CommonData.access$1276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_descriptor;
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

        public Builder clearBackgroundAppRate() {
            this.bitField0_ &= -257;
            this.backgroundAppRate_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearForegroundAppIsInWhitelist() {
            this.bitField0_ &= -33;
            this.foregroundAppIsInWhitelist_ = false;
            onChanged();
            return this;
        }

        public Builder clearForegroundAppPkgName() {
            this.foregroundAppPkgName_ = CommonData.getDefaultInstance().getForegroundAppPkgName();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearForegroundAppRate() {
            this.bitField0_ &= -65;
            this.foregroundAppRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearForegroundAppRttAverage() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.foregroundAppRttAverage_ = 0;
            onChanged();
            return this;
        }

        public Builder clearIfName() {
            this.ifName_ = CommonData.getDefaultInstance().getIfName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearMaxBandwidthEstimatedValue() {
            this.bitField0_ &= -9;
            this.maxBandwidthEstimatedValue_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRateCtrlUidNumber() {
            this.bitField0_ &= -3;
            this.rateCtrlUidNumber_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTemperature() {
            this.bitField0_ &= -5;
            this.temperature_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public int getBackgroundAppRate() {
            return this.backgroundAppRate_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean getForegroundAppIsInWhitelist() {
            return this.foregroundAppIsInWhitelist_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public String getForegroundAppPkgName() {
            Object r8 = this.foregroundAppPkgName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.foregroundAppPkgName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public ByteString getForegroundAppPkgNameBytes() {
            Object r8 = this.foregroundAppPkgName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.foregroundAppPkgName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public int getForegroundAppRate() {
            return this.foregroundAppRate_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public int getForegroundAppRttAverage() {
            return this.foregroundAppRttAverage_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public String getIfName() {
            Object r8 = this.ifName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.ifName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public ByteString getIfNameBytes() {
            Object r8 = this.ifName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ifName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public int getMaxBandwidthEstimatedValue() {
            return this.maxBandwidthEstimatedValue_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public int getRateCtrlUidNumber() {
            return this.rateCtrlUidNumber_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public float getTemperature() {
            return this.temperature_;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasBackgroundAppRate() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasForegroundAppIsInWhitelist() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasForegroundAppPkgName() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasForegroundAppRate() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasForegroundAppRttAverage() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasIfName() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasMaxBandwidthEstimatedValue() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasRateCtrlUidNumber() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
        public boolean hasTemperature() {
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

        public Builder setBackgroundAppRate(int r8) {
            this.backgroundAppRate_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setForegroundAppIsInWhitelist(boolean r8) {
            this.foregroundAppIsInWhitelist_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setForegroundAppPkgName(String r8) {
            if (r8 == null) goto L6;
            this.foregroundAppPkgName_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setForegroundAppPkgNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.foregroundAppPkgName_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setForegroundAppRate(int r8) {
            this.foregroundAppRate_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setForegroundAppRttAverage(int r8) {
            this.foregroundAppRttAverage_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setIfName(String r8) {
            if (r8 == null) goto L6;
            this.ifName_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIfNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.ifName_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setMaxBandwidthEstimatedValue(int r8) {
            this.maxBandwidthEstimatedValue_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setRateCtrlUidNumber(int r8) {
            this.rateCtrlUidNumber_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setTemperature(float r8) {
            this.temperature_ = r8;
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
            this.ifName_ = "";
            this.foregroundAppPkgName_ = "";
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
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonData.class, Builder.class);
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
        public CommonData build() {
            CommonData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CommonData buildPartial() {
            CommonData r8 = new CommonData(this, null);
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
        public CommonData getDefaultInstanceForType() {
            return CommonData.getDefaultInstance();
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
            this.ifName_ = "";
            this.rateCtrlUidNumber_ = 0;
            this.temperature_ = 0.0f;
            this.maxBandwidthEstimatedValue_ = 0;
            this.foregroundAppPkgName_ = "";
            this.foregroundAppIsInWhitelist_ = false;
            this.foregroundAppRate_ = 0;
            this.foregroundAppRttAverage_ = 0;
            this.backgroundAppRate_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L49;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L46;
            int r12 = r8.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r12 == 0) goto L38;
            if (r12 != 10) goto L10;
            this.ifName_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.rateCtrlUidNumber_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L12:
            if (r12 != 29) goto L13;
            this.temperature_ = r8.readFloat();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L13:
            int r13 = 32;
            if (r12 != 32) goto L16;
            this.maxBandwidthEstimatedValue_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L16:
            if (r12 != 42) goto L18;
            this.foregroundAppPkgName_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L18:
            if (r12 == 48) goto L31;
            r13 = 64;
            if (r12 != 56) goto L21;
            this.foregroundAppRate_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            int r14 = this.bitField0_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L30:
            this.bitField0_ = r14 | r13;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L21:
            if (r12 != 64) goto L23;
            this.foregroundAppRttAverage_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L23:
            if (r12 != 72) goto L25;
            this.backgroundAppRate_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 256;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L25:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L31:
            this.foregroundAppIsInWhitelist_ = r8.readBool();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r14 = this.bitField0_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L38:
            r11 = true;
            goto L4
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L46:
            onChanged();
            return this;
        L49:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CommonData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CommonData) r8);
        }

        public Builder mergeFrom(CommonData r8) {
            if (r8 != CommonData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasIfName() == false) goto L9;
            this.ifName_ = CommonData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasRateCtrlUidNumber() == false) goto L12;
            setRateCtrlUidNumber(r8.getRateCtrlUidNumber());
        L12:
            if (r8.hasTemperature() == false) goto L15;
            setTemperature(r8.getTemperature());
        L15:
            if (r8.hasMaxBandwidthEstimatedValue() == false) goto L18;
            setMaxBandwidthEstimatedValue(r8.getMaxBandwidthEstimatedValue());
        L18:
            if (r8.hasForegroundAppPkgName() == false) goto L21;
            this.foregroundAppPkgName_ = CommonData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasForegroundAppIsInWhitelist() == false) goto L24;
            setForegroundAppIsInWhitelist(r8.getForegroundAppIsInWhitelist());
        L24:
            if (r8.hasForegroundAppRate() == false) goto L27;
            setForegroundAppRate(r8.getForegroundAppRate());
        L27:
            if (r8.hasForegroundAppRttAverage() == false) goto L30;
            setForegroundAppRttAverage(r8.getForegroundAppRttAverage());
        L30:
            if (r8.hasBackgroundAppRate() == false) goto L32;
            setBackgroundAppRate(r8.getBackgroundAppRate());
        L32:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new CommonData();
        PARSER = new AnonymousClass1();
    }

    private CommonData() {
        this.ifName_ = "";
        this.rateCtrlUidNumber_ = 0;
        this.temperature_ = 0.0f;
        this.maxBandwidthEstimatedValue_ = 0;
        this.foregroundAppPkgName_ = "";
        this.foregroundAppIsInWhitelist_ = false;
        this.foregroundAppRate_ = 0;
        this.foregroundAppRttAverage_ = 0;
        this.backgroundAppRate_ = 0;
        this.memoizedIsInitialized = -1;
        this.ifName_ = "";
        this.foregroundAppPkgName_ = "";
    }

    public static /* synthetic */ int access$1002(CommonData r8, int r10) {
        r8.foregroundAppRttAverage_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(CommonData r8, int r10) {
        r8.backgroundAppRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1276(CommonData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(CommonData r8) {
        return r8.ifName_;
    }

    public static /* synthetic */ Object access$302(CommonData r8, Object r10) {
        r8.ifName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(CommonData r8, int r10) {
        r8.rateCtrlUidNumber_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$502(CommonData r8, float r10) {
        r8.temperature_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(CommonData r8, int r10) {
        r8.maxBandwidthEstimatedValue_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(CommonData r8) {
        return r8.foregroundAppPkgName_;
    }

    public static /* synthetic */ Object access$702(CommonData r8, Object r10) {
        r8.foregroundAppPkgName_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$802(CommonData r8, boolean r10) {
        r8.foregroundAppIsInWhitelist_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(CommonData r8, int r10) {
        r8.foregroundAppRate_ = r10;
        return r10;
    }

    public static CommonData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CommonData parseDelimitedFrom(InputStream r8) {
        return (CommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CommonData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CommonData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CommonData) == false) goto L8;
        CommonData r10 = (CommonData) r8;
        if (hasIfName() == r10.hasIfName()) goto L13;
        return false;
    L13:
        if (hasIfName() == false) goto L18;
        if (getIfName().equals(r10.getIfName()) == true) goto L18;
        return false;
    L18:
        if (hasRateCtrlUidNumber() == r10.hasRateCtrlUidNumber()) goto L21;
        return false;
    L21:
        if (hasRateCtrlUidNumber() == false) goto L26;
        if (getRateCtrlUidNumber() == r10.getRateCtrlUidNumber()) goto L26;
        return false;
    L26:
        if (hasTemperature() == r10.hasTemperature()) goto L29;
        return false;
    L29:
        if (hasTemperature() == false) goto L34;
        if (Float.floatToIntBits(getTemperature()) == Float.floatToIntBits(r10.getTemperature())) goto L34;
        return false;
    L34:
        if (hasMaxBandwidthEstimatedValue() == r10.hasMaxBandwidthEstimatedValue()) goto L37;
        return false;
    L37:
        if (hasMaxBandwidthEstimatedValue() == false) goto L42;
        if (getMaxBandwidthEstimatedValue() == r10.getMaxBandwidthEstimatedValue()) goto L42;
        return false;
    L42:
        if (hasForegroundAppPkgName() == r10.hasForegroundAppPkgName()) goto L45;
        return false;
    L45:
        if (hasForegroundAppPkgName() == false) goto L50;
        if (getForegroundAppPkgName().equals(r10.getForegroundAppPkgName()) == true) goto L50;
        return false;
    L50:
        if (hasForegroundAppIsInWhitelist() == r10.hasForegroundAppIsInWhitelist()) goto L53;
        return false;
    L53:
        if (hasForegroundAppIsInWhitelist() == false) goto L58;
        if (getForegroundAppIsInWhitelist() == r10.getForegroundAppIsInWhitelist()) goto L58;
        return false;
    L58:
        if (hasForegroundAppRate() == r10.hasForegroundAppRate()) goto L61;
        return false;
    L61:
        if (hasForegroundAppRate() == false) goto L66;
        if (getForegroundAppRate() == r10.getForegroundAppRate()) goto L66;
        return false;
    L66:
        if (hasForegroundAppRttAverage() == r10.hasForegroundAppRttAverage()) goto L69;
        return false;
    L69:
        if (hasForegroundAppRttAverage() == false) goto L74;
        if (getForegroundAppRttAverage() == r10.getForegroundAppRttAverage()) goto L74;
        return false;
    L74:
        if (hasBackgroundAppRate() == r10.hasBackgroundAppRate()) goto L77;
        return false;
    L77:
        if (hasBackgroundAppRate() == false) goto L82;
        if (getBackgroundAppRate() == r10.getBackgroundAppRate()) goto L82;
        return false;
    L82:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L84;
        return false;
    L84:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public int getBackgroundAppRate() {
        return this.backgroundAppRate_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean getForegroundAppIsInWhitelist() {
        return this.foregroundAppIsInWhitelist_;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public String getForegroundAppPkgName() {
        Object r8 = this.foregroundAppPkgName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.foregroundAppPkgName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public ByteString getForegroundAppPkgNameBytes() {
        Object r8 = this.foregroundAppPkgName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.foregroundAppPkgName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public int getForegroundAppRate() {
        return this.foregroundAppRate_;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public int getForegroundAppRttAverage() {
        return this.foregroundAppRttAverage_;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public String getIfName() {
        Object r8 = this.ifName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.ifName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public ByteString getIfNameBytes() {
        Object r8 = this.ifName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.ifName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public int getMaxBandwidthEstimatedValue() {
        return this.maxBandwidthEstimatedValue_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CommonData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public int getRateCtrlUidNumber() {
        return this.rateCtrlUidNumber_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.ifName_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeUInt32Size(2, this.rateCtrlUidNumber_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeFloatSize(3, this.temperature_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeUInt32Size(4, this.maxBandwidthEstimatedValue_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.foregroundAppPkgName_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeBoolSize(6, this.foregroundAppIsInWhitelist_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeUInt32Size(7, this.foregroundAppRate_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeUInt32Size(8, this.foregroundAppRttAverage_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L32;
        r10 = r10 + CodedOutputStream.computeUInt32Size(9, this.backgroundAppRate_);
    L32:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public float getTemperature() {
        return this.temperature_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasBackgroundAppRate() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasForegroundAppIsInWhitelist() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasForegroundAppPkgName() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasForegroundAppRate() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasForegroundAppRttAverage() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasIfName() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasMaxBandwidthEstimatedValue() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasRateCtrlUidNumber() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.CommonDataOrBuilder
    public boolean hasTemperature() {
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
        if (hasIfName() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getIfName().hashCode();
    L9:
        if (hasRateCtrlUidNumber() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getRateCtrlUidNumber();
    L12:
        if (hasTemperature() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Float.floatToIntBits(getTemperature());
    L15:
        if (hasMaxBandwidthEstimatedValue() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getMaxBandwidthEstimatedValue();
    L18:
        if (hasForegroundAppPkgName() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getForegroundAppPkgName().hashCode();
    L21:
        if (hasForegroundAppIsInWhitelist() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + Internal.hashBoolean(getForegroundAppIsInWhitelist());
    L24:
        if (hasForegroundAppRate() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getForegroundAppRate();
    L27:
        if (hasForegroundAppRttAverage() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getForegroundAppRttAverage();
    L30:
        if (hasBackgroundAppRate() == false) goto L32;
        r10 = b.a(r10, 37, 9, 53) + getBackgroundAppRate();
    L32:
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
        return new CommonData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.ifName_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeUInt32(2, this.rateCtrlUidNumber_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeFloat(3, this.temperature_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeUInt32(4, this.maxBandwidthEstimatedValue_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.foregroundAppPkgName_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeBool(6, this.foregroundAppIsInWhitelist_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeUInt32(7, this.foregroundAppRate_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeUInt32(8, this.foregroundAppRttAverage_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        r8.writeUInt32(9, this.backgroundAppRate_);
    L29:
        getUnknownFields().writeTo(r8);
    }

    private CommonData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.ifName_ = "";
        this.rateCtrlUidNumber_ = 0;
        this.temperature_ = 0.0f;
        this.maxBandwidthEstimatedValue_ = 0;
        this.foregroundAppPkgName_ = "";
        this.foregroundAppIsInWhitelist_ = false;
        this.foregroundAppRate_ = 0;
        this.foregroundAppRttAverage_ = 0;
        this.backgroundAppRate_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CommonData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CommonData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CommonData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CommonData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CommonData parseFrom(CodedInputStream r8) {
        return (CommonData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CommonData getDefaultInstanceForType() {
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

    public static CommonData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CommonData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CommonData parseFrom(InputStream r8) {
        return (CommonData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CommonData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CommonData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CommonData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CommonData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CommonData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CommonData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
