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
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RouterModelReportData extends GeneratedMessageV3 implements RouterModelReportDataOrBuilder {
    public static final int BSSID_FIELD_NUMBER = 2;
    public static final int BSSID_MD5_FIELD_NUMBER = 3;
    private static final RouterModelReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 9;
    public static final int DEVICE_TIME_FIELD_NUMBER = 8;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int MLO_ENABLE_FIELD_NUMBER = 7;

    @Deprecated
    public static final Parser<RouterModelReportData> PARSER = null;
    public static final int ROUTER_MODEL_FIELD_NUMBER = 5;
    public static final int ROUTER_TYPE_FIELD_NUMBER = 4;
    public static final int WIFIGENERATION_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object bssidMd5_;
    private volatile Object bssid_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private byte memoizedIsInitialized;
    private int mloEnable_;
    private volatile Object routerModel_;
    private volatile Object routerType_;
    private volatile Object wifigeneration_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RouterModelReportDataOrBuilder {
        private int bitField0_;
        private Object bssidMd5_;
        private Object bssid_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int mloEnable_;
        private Object routerModel_;
        private Object routerType_;
        private Object wifigeneration_;

        private Builder() {
            this.eventType_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.routerType_ = "";
            this.routerModel_ = "";
            this.wifigeneration_ = "";
            this.deviceDate_ = "";
        }

        private void buildPartial0(RouterModelReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            RouterModelReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            RouterModelReportData.access$402(r8, this.bssid_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            RouterModelReportData.access$502(r8, this.bssidMd5_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            RouterModelReportData.access$602(r8, this.routerType_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            RouterModelReportData.access$702(r8, this.routerModel_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            RouterModelReportData.access$802(r8, this.wifigeneration_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            RouterModelReportData.access$902(r8, this.mloEnable_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            RouterModelReportData.access$1002(r8, this.deviceTime_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L30;
            RouterModelReportData.access$1102(r8, this.deviceDate_);
            r11 = r11 | 256;
        L30:
            RouterModelReportData.access$1276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RouterModelReportData_descriptor;
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

        public Builder clearBssid() {
            this.bssid_ = RouterModelReportData.getDefaultInstance().getBssid();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearBssidMd5() {
            this.bssidMd5_ = RouterModelReportData.getDefaultInstance().getBssidMd5();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = RouterModelReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = RouterModelReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearMloEnable() {
            this.bitField0_ &= -65;
            this.mloEnable_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRouterModel() {
            this.routerModel_ = RouterModelReportData.getDefaultInstance().getRouterModel();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearRouterType() {
            this.routerType_ = RouterModelReportData.getDefaultInstance().getRouterType();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearWifigeneration() {
            this.wifigeneration_ = RouterModelReportData.getDefaultInstance().getWifigeneration();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public String getBssid() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.bssid_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getBssidBytes() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public String getBssidMd5() {
            Object r8 = this.bssidMd5_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.bssidMd5_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getBssidMd5Bytes() {
            Object r8 = this.bssidMd5_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssidMd5_ = r10;
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RouterModelReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public int getMloEnable() {
            return this.mloEnable_;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public String getRouterModel() {
            Object r8 = this.routerModel_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.routerModel_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getRouterModelBytes() {
            Object r8 = this.routerModel_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.routerModel_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public String getRouterType() {
            Object r8 = this.routerType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.routerType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getRouterTypeBytes() {
            Object r8 = this.routerType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.routerType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public String getWifigeneration() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wifigeneration_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public ByteString getWifigenerationBytes() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifigeneration_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasBssidMd5() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasMloEnable() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasRouterModel() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasRouterType() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
        public boolean hasWifigeneration() {
            if ((this.bitField0_ & 32) == 0) goto L5;
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

        public Builder setBssid(String r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5(String r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 128;
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

        public Builder setMloEnable(int r8) {
            this.mloEnable_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRouterModel(String r8) {
            if (r8 == null) goto L6;
            this.routerModel_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRouterModelBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.routerModel_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRouterType(String r8) {
            if (r8 == null) goto L6;
            this.routerType_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRouterTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.routerType_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifigeneration(String r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifigenerationBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.routerType_ = "";
            this.routerModel_ = "";
            this.wifigeneration_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RouterModelReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(RouterModelReportData.class, Builder.class);
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
        public RouterModelReportData build() {
            RouterModelReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RouterModelReportData buildPartial() {
            RouterModelReportData r8 = new RouterModelReportData(this, null);
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
        public RouterModelReportData getDefaultInstanceForType() {
            return RouterModelReportData.getDefaultInstance();
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
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.routerType_ = "";
            this.routerModel_ = "";
            this.wifigeneration_ = "";
            this.mloEnable_ = 0;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L48;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L45;
            int r12 = r8.readTag();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            if (r12 == 0) goto L37;
            if (r12 != 10) goto L10;
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 1;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.bssid_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 2;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L12:
            if (r12 != 26) goto L14;
            this.bssidMd5_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 4;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L14:
            if (r12 != 34) goto L16;
            this.routerType_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 8;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L16:
            if (r12 != 42) goto L18;
            this.routerModel_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 16;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L18:
            if (r12 != 50) goto L20;
            this.wifigeneration_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 32;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L20:
            if (r12 != 56) goto L21;
            this.mloEnable_ = r8.readInt32();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 64;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L21:
            if (r12 != 64) goto L23;
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 128;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L23:
            if (r12 != 74) goto L25;
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            this.bitField0_ |= 256;     // Catch: Throwable -> L38 InvalidProtocolBufferException -> L40
            goto L4
        L25:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L37:
            r11 = true;
            goto L4
        L38:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L38
        L45:
            onChanged();
            return this;
        L48:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof RouterModelReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((RouterModelReportData) r8);
        }

        public Builder mergeFrom(RouterModelReportData r8) {
            if (r8 != RouterModelReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = RouterModelReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasBssid() == false) goto L12;
            this.bssid_ = RouterModelReportData.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasBssidMd5() == false) goto L15;
            this.bssidMd5_ = RouterModelReportData.access$500(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasRouterType() == false) goto L18;
            this.routerType_ = RouterModelReportData.access$600(r8);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r8.hasRouterModel() == false) goto L21;
            this.routerModel_ = RouterModelReportData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasWifigeneration() == false) goto L24;
            this.wifigeneration_ = RouterModelReportData.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasMloEnable() == false) goto L27;
            setMloEnable(r8.getMloEnable());
        L27:
            if (r8.hasDeviceTime() == false) goto L30;
            setDeviceTime(r8.getDeviceTime());
        L30:
            if (r8.hasDeviceDate() == false) goto L32;
            this.deviceDate_ = RouterModelReportData.access$1100(r8);
            this.bitField0_ |= 256;
            onChanged();
        L32:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new RouterModelReportData();
        PARSER = new AnonymousClass1();
    }

    private RouterModelReportData() {
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.routerType_ = "";
        this.routerModel_ = "";
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.routerType_ = "";
        this.routerModel_ = "";
        this.wifigeneration_ = "";
        this.deviceDate_ = "";
    }

    public static /* synthetic */ long access$1002(RouterModelReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(RouterModelReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$1102(RouterModelReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1276(RouterModelReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(RouterModelReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(RouterModelReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(RouterModelReportData r8) {
        return r8.bssid_;
    }

    public static /* synthetic */ Object access$402(RouterModelReportData r8, Object r10) {
        r8.bssid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(RouterModelReportData r8) {
        return r8.bssidMd5_;
    }

    public static /* synthetic */ Object access$502(RouterModelReportData r8, Object r10) {
        r8.bssidMd5_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$600(RouterModelReportData r8) {
        return r8.routerType_;
    }

    public static /* synthetic */ Object access$602(RouterModelReportData r8, Object r10) {
        r8.routerType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(RouterModelReportData r8) {
        return r8.routerModel_;
    }

    public static /* synthetic */ Object access$702(RouterModelReportData r8, Object r10) {
        r8.routerModel_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(RouterModelReportData r8) {
        return r8.wifigeneration_;
    }

    public static /* synthetic */ Object access$802(RouterModelReportData r8, Object r10) {
        r8.wifigeneration_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(RouterModelReportData r8, int r10) {
        r8.mloEnable_ = r10;
        return r10;
    }

    public static RouterModelReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RouterModelReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RouterModelReportData parseDelimitedFrom(InputStream r8) {
        return (RouterModelReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static RouterModelReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<RouterModelReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof RouterModelReportData) == false) goto L8;
        RouterModelReportData r10 = (RouterModelReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasBssid() == r10.hasBssid()) goto L21;
        return false;
    L21:
        if (hasBssid() == false) goto L26;
        if (getBssid().equals(r10.getBssid()) == true) goto L26;
        return false;
    L26:
        if (hasBssidMd5() == r10.hasBssidMd5()) goto L29;
        return false;
    L29:
        if (hasBssidMd5() == false) goto L34;
        if (getBssidMd5().equals(r10.getBssidMd5()) == true) goto L34;
        return false;
    L34:
        if (hasRouterType() == r10.hasRouterType()) goto L37;
        return false;
    L37:
        if (hasRouterType() == false) goto L42;
        if (getRouterType().equals(r10.getRouterType()) == true) goto L42;
        return false;
    L42:
        if (hasRouterModel() == r10.hasRouterModel()) goto L45;
        return false;
    L45:
        if (hasRouterModel() == false) goto L50;
        if (getRouterModel().equals(r10.getRouterModel()) == true) goto L50;
        return false;
    L50:
        if (hasWifigeneration() == r10.hasWifigeneration()) goto L53;
        return false;
    L53:
        if (hasWifigeneration() == false) goto L58;
        if (getWifigeneration().equals(r10.getWifigeneration()) == true) goto L58;
        return false;
    L58:
        if (hasMloEnable() == r10.hasMloEnable()) goto L61;
        return false;
    L61:
        if (hasMloEnable() == false) goto L66;
        if (getMloEnable() == r10.getMloEnable()) goto L66;
        return false;
    L66:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L69;
        return false;
    L69:
        if (hasDeviceTime() == false) goto L74;
        if (getDeviceTime() == r10.getDeviceTime()) goto L74;
        return false;
    L74:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L77;
        return false;
    L77:
        if (hasDeviceDate() == false) goto L82;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L82;
        return false;
    L82:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L84;
        return false;
    L84:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public String getBssid() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.bssid_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getBssidBytes() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public String getBssidMd5() {
        Object r8 = this.bssidMd5_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.bssidMd5_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getBssidMd5Bytes() {
        Object r8 = this.bssidMd5_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssidMd5_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public int getMloEnable() {
        return this.mloEnable_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RouterModelReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public String getRouterModel() {
        Object r8 = this.routerModel_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.routerModel_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getRouterModelBytes() {
        Object r8 = this.routerModel_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.routerModel_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public String getRouterType() {
        Object r8 = this.routerType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.routerType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getRouterTypeBytes() {
        Object r8 = this.routerType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.routerType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
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
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.bssid_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.bssidMd5_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + GeneratedMessage.computeStringSize(4, this.routerType_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.routerModel_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + GeneratedMessage.computeStringSize(6, this.wifigeneration_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.mloEnable_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeUInt64Size(8, this.deviceTime_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L32;
        r10 = r10 + GeneratedMessage.computeStringSize(9, this.deviceDate_);
    L32:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public String getWifigeneration() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wifigeneration_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public ByteString getWifigenerationBytes() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifigeneration_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasBssid() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasBssidMd5() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasMloEnable() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasRouterModel() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasRouterType() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RouterModelReportDataOrBuilder
    public boolean hasWifigeneration() {
        if ((this.bitField0_ & 32) == 0) goto L5;
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
        if (hasBssid() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getBssid().hashCode();
    L12:
        if (hasBssidMd5() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getBssidMd5().hashCode();
    L15:
        if (hasRouterType() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getRouterType().hashCode();
    L18:
        if (hasRouterModel() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getRouterModel().hashCode();
    L21:
        if (hasWifigeneration() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getWifigeneration().hashCode();
    L24:
        if (hasMloEnable() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getMloEnable();
    L27:
        if (hasDeviceTime() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + Internal.hashLong(getDeviceTime());
    L30:
        if (hasDeviceDate() == false) goto L32;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getDeviceDate().hashCode();
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
        return new RouterModelReportData();
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
        GeneratedMessage.writeString(r8, 2, this.bssid_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.bssidMd5_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        GeneratedMessage.writeString(r8, 4, this.routerType_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.routerModel_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r8, 6, this.wifigeneration_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.mloEnable_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeUInt64(8, this.deviceTime_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        GeneratedMessage.writeString(r8, 9, this.deviceDate_);
    L29:
        getUnknownFields().writeTo(r8);
    }

    private RouterModelReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.routerType_ = "";
        this.routerModel_ = "";
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(RouterModelReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static RouterModelReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (RouterModelReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static RouterModelReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RouterModelReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(RouterModelReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ RouterModelReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static RouterModelReportData parseFrom(CodedInputStream r8) {
        return (RouterModelReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public RouterModelReportData getDefaultInstanceForType() {
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

    public static RouterModelReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (RouterModelReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static RouterModelReportData parseFrom(InputStream r8) {
        return (RouterModelReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static RouterModelReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (RouterModelReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static RouterModelReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static RouterModelReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static RouterModelReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static RouterModelReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
