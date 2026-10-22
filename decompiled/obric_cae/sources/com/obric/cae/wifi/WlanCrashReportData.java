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
import com.obric.cae.network.BlockedReason;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WlanCrashReportData extends GeneratedMessageV3 implements WlanCrashReportDataOrBuilder {
    public static final int CNSS_PLAT_QUIRKS_FIELD_NUMBER = 8;
    public static final int CONNECTED_LAST_FIELD_NUMBER = 9;
    private static final WlanCrashReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 19;
    public static final int DEVICE_DEV_STATE_STR_FIELD_NUMBER = 15;
    public static final int DEVICE_EXEC_STR_FIELD_NUMBER = 14;
    public static final int DEVICE_ID_FIELD_NUMBER = 23;
    public static final int DEVICE_TIME_FIELD_NUMBER = 18;
    public static final int DRIVER_STATE_FIELD_NUMBER = 7;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int HOST_DEV_STATE_STR_FIELD_NUMBER = 12;
    public static final int HOST_EXEC_STR_FIELD_NUMBER = 13;
    public static final int HOST_HANG_FUNC_FIELD_NUMBER = 17;
    public static final int HOST_HANG_LINE_FIELD_NUMBER = 16;
    public static final int HOST_PM_STATE_STR_FIELD_NUMBER = 11;
    public static final int MHI_STATE_FIELD_NUMBER = 6;

    @Deprecated
    public static final Parser<WlanCrashReportData> PARSER = null;
    public static final int PCI_LINK_DOWN_IND_FIELD_NUMBER = 5;
    public static final int PCI_LINK_STATE_FIELD_NUMBER = 4;
    public static final int RDDM_SFR_INFO_FIELD_NUMBER = 10;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int REASON_STR_FIELD_NUMBER = 20;
    public static final int RECOVERY_COUNT_FIELD_NUMBER = 21;
    public static final int SUB_REASON_FIELD_NUMBER = 3;
    public static final int TRIGGER_SOURCE_FIELD_NUMBER = 22;
    public static final int WLAN_DRIVER_VERSION_FIELD_NUMBER = 24;
    public static final int WLAN_FW_BUILD_TIMESTAMP_FIELD_NUMBER = 26;
    public static final int WLAN_FW_VERSION_FIELD_NUMBER = 25;
    public static final int WLAN_FW_VERSION_STR_FIELD_NUMBER = 27;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cnssPlatQuirks_;
    private int connectedLast_;
    private volatile Object deviceDate_;
    private volatile Object deviceDevStateStr_;
    private volatile Object deviceExecStr_;
    private int deviceId_;
    private long deviceTime_;
    private int driverState_;
    private volatile Object eventType_;
    private volatile Object hostDevStateStr_;
    private volatile Object hostExecStr_;
    private volatile Object hostHangFunc_;
    private int hostHangLine_;
    private volatile Object hostPmStateStr_;
    private byte memoizedIsInitialized;
    private int mhiState_;
    private int pciLinkDownInd_;
    private int pciLinkState_;
    private volatile Object rddmSfrInfo_;
    private volatile Object reasonStr_;
    private int reason_;
    private int recoveryCount_;
    private volatile Object subReason_;
    private volatile Object triggerSource_;
    private volatile Object wlanDriverVersion_;
    private volatile Object wlanFwBuildTimestamp_;
    private volatile Object wlanFwVersionStr_;
    private int wlanFwVersion_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WlanCrashReportDataOrBuilder {
        private int bitField0_;
        private int cnssPlatQuirks_;
        private int connectedLast_;
        private Object deviceDate_;
        private Object deviceDevStateStr_;
        private Object deviceExecStr_;
        private int deviceId_;
        private long deviceTime_;
        private int driverState_;
        private Object eventType_;
        private Object hostDevStateStr_;
        private Object hostExecStr_;
        private Object hostHangFunc_;
        private int hostHangLine_;
        private Object hostPmStateStr_;
        private int mhiState_;
        private int pciLinkDownInd_;
        private int pciLinkState_;
        private Object rddmSfrInfo_;
        private Object reasonStr_;
        private int reason_;
        private int recoveryCount_;
        private Object subReason_;
        private Object triggerSource_;
        private Object wlanDriverVersion_;
        private Object wlanFwBuildTimestamp_;
        private Object wlanFwVersionStr_;
        private int wlanFwVersion_;

        private Builder() {
            this.eventType_ = "";
            this.subReason_ = "";
            this.rddmSfrInfo_ = "";
            this.hostPmStateStr_ = "";
            this.hostDevStateStr_ = "";
            this.hostExecStr_ = "";
            this.deviceExecStr_ = "";
            this.deviceDevStateStr_ = "";
            this.hostHangFunc_ = "";
            this.deviceDate_ = "";
            this.reasonStr_ = "";
            this.triggerSource_ = "";
            this.wlanDriverVersion_ = "";
            this.wlanFwBuildTimestamp_ = "";
            this.wlanFwVersionStr_ = "";
        }

        private void buildPartial0(WlanCrashReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WlanCrashReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WlanCrashReportData.access$402(r8, this.reason_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WlanCrashReportData.access$502(r8, this.subReason_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WlanCrashReportData.access$602(r8, this.pciLinkState_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            WlanCrashReportData.access$702(r8, this.pciLinkDownInd_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            WlanCrashReportData.access$802(r8, this.mhiState_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            WlanCrashReportData.access$902(r8, this.driverState_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            WlanCrashReportData.access$1002(r8, this.cnssPlatQuirks_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            WlanCrashReportData.access$1102(r8, this.connectedLast_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            WlanCrashReportData.access$1202(r8, this.rddmSfrInfo_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            WlanCrashReportData.access$1302(r8, this.hostPmStateStr_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            WlanCrashReportData.access$1402(r8, this.hostDevStateStr_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            WlanCrashReportData.access$1502(r8, this.hostExecStr_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            WlanCrashReportData.access$1602(r8, this.deviceExecStr_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            WlanCrashReportData.access$1702(r8, this.deviceDevStateStr_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            WlanCrashReportData.access$1802(r8, this.hostHangLine_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            WlanCrashReportData.access$1902(r8, this.hostHangFunc_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            WlanCrashReportData.access$2002(r8, this.deviceTime_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            WlanCrashReportData.access$2102(r8, this.deviceDate_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            WlanCrashReportData.access$2202(r8, this.reasonStr_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            WlanCrashReportData.access$2302(r8, this.recoveryCount_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            WlanCrashReportData.access$2402(r8, this.triggerSource_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            WlanCrashReportData.access$2502(r8, this.deviceId_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            WlanCrashReportData.access$2602(r8, this.wlanDriverVersion_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            WlanCrashReportData.access$2702(r8, this.wlanFwVersion_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            WlanCrashReportData.access$2802(r8, this.wlanFwBuildTimestamp_);
            r11 = r11 | 33554432;
        L82:
            if ((r10 & 67108864) == 0) goto L84;
            WlanCrashReportData.access$2902(r8, this.wlanFwVersionStr_);
            r11 = r11 | 67108864;
        L84:
            WlanCrashReportData.access$3076(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WlanCrashReportData_descriptor;
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

        public Builder clearCnssPlatQuirks() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.cnssPlatQuirks_ = 0;
            onChanged();
            return this;
        }

        public Builder clearConnectedLast() {
            this.bitField0_ &= -257;
            this.connectedLast_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = WlanCrashReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder clearDeviceDevStateStr() {
            this.deviceDevStateStr_ = WlanCrashReportData.getDefaultInstance().getDeviceDevStateStr();
            this.bitField0_ &= -16385;
            onChanged();
            return this;
        }

        public Builder clearDeviceExecStr() {
            this.deviceExecStr_ = WlanCrashReportData.getDefaultInstance().getDeviceExecStr();
            this.bitField0_ &= -8193;
            onChanged();
            return this;
        }

        public Builder clearDeviceId() {
            this.bitField0_ &= -4194305;
            this.deviceId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -131073;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDriverState() {
            this.bitField0_ &= -65;
            this.driverState_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = WlanCrashReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearHostDevStateStr() {
            this.hostDevStateStr_ = WlanCrashReportData.getDefaultInstance().getHostDevStateStr();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder clearHostExecStr() {
            this.hostExecStr_ = WlanCrashReportData.getDefaultInstance().getHostExecStr();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder clearHostHangFunc() {
            this.hostHangFunc_ = WlanCrashReportData.getDefaultInstance().getHostHangFunc();
            this.bitField0_ &= -65537;
            onChanged();
            return this;
        }

        public Builder clearHostHangLine() {
            this.bitField0_ &= -32769;
            this.hostHangLine_ = 0;
            onChanged();
            return this;
        }

        public Builder clearHostPmStateStr() {
            this.hostPmStateStr_ = WlanCrashReportData.getDefaultInstance().getHostPmStateStr();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder clearMhiState() {
            this.bitField0_ &= -33;
            this.mhiState_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPciLinkDownInd() {
            this.bitField0_ &= -17;
            this.pciLinkDownInd_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPciLinkState() {
            this.bitField0_ &= -9;
            this.pciLinkState_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRddmSfrInfo() {
            this.rddmSfrInfo_ = WlanCrashReportData.getDefaultInstance().getRddmSfrInfo();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
            return this;
        }

        public Builder clearReason() {
            this.bitField0_ &= -3;
            this.reason_ = 0;
            onChanged();
            return this;
        }

        public Builder clearReasonStr() {
            this.reasonStr_ = WlanCrashReportData.getDefaultInstance().getReasonStr();
            this.bitField0_ &= -524289;
            onChanged();
            return this;
        }

        public Builder clearRecoveryCount() {
            this.bitField0_ &= -1048577;
            this.recoveryCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSubReason() {
            this.subReason_ = WlanCrashReportData.getDefaultInstance().getSubReason();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearTriggerSource() {
            this.triggerSource_ = WlanCrashReportData.getDefaultInstance().getTriggerSource();
            this.bitField0_ &= -2097153;
            onChanged();
            return this;
        }

        public Builder clearWlanDriverVersion() {
            this.wlanDriverVersion_ = WlanCrashReportData.getDefaultInstance().getWlanDriverVersion();
            this.bitField0_ &= -8388609;
            onChanged();
            return this;
        }

        public Builder clearWlanFwBuildTimestamp() {
            this.wlanFwBuildTimestamp_ = WlanCrashReportData.getDefaultInstance().getWlanFwBuildTimestamp();
            this.bitField0_ &= -33554433;
            onChanged();
            return this;
        }

        public Builder clearWlanFwVersion() {
            this.bitField0_ &= -16777217;
            this.wlanFwVersion_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWlanFwVersionStr() {
            this.wlanFwVersionStr_ = WlanCrashReportData.getDefaultInstance().getWlanFwVersionStr();
            this.bitField0_ &= -67108865;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getCnssPlatQuirks() {
            return this.cnssPlatQuirks_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getConnectedLast() {
            return this.connectedLast_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WlanCrashReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getDeviceDevStateStr() {
            Object r8 = this.deviceDevStateStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceDevStateStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getDeviceDevStateStrBytes() {
            Object r8 = this.deviceDevStateStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDevStateStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getDeviceExecStr() {
            Object r8 = this.deviceExecStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceExecStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getDeviceExecStrBytes() {
            Object r8 = this.deviceExecStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceExecStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getDriverState() {
            return this.driverState_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getHostDevStateStr() {
            Object r8 = this.hostDevStateStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.hostDevStateStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getHostDevStateStrBytes() {
            Object r8 = this.hostDevStateStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.hostDevStateStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getHostExecStr() {
            Object r8 = this.hostExecStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.hostExecStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getHostExecStrBytes() {
            Object r8 = this.hostExecStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.hostExecStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getHostHangFunc() {
            Object r8 = this.hostHangFunc_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.hostHangFunc_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getHostHangFuncBytes() {
            Object r8 = this.hostHangFunc_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.hostHangFunc_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getHostHangLine() {
            return this.hostHangLine_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getHostPmStateStr() {
            Object r8 = this.hostPmStateStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.hostPmStateStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getHostPmStateStrBytes() {
            Object r8 = this.hostPmStateStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.hostPmStateStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getMhiState() {
            return this.mhiState_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getPciLinkDownInd() {
            return this.pciLinkDownInd_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getPciLinkState() {
            return this.pciLinkState_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getRddmSfrInfo() {
            Object r8 = this.rddmSfrInfo_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.rddmSfrInfo_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getRddmSfrInfoBytes() {
            Object r8 = this.rddmSfrInfo_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.rddmSfrInfo_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getReason() {
            return this.reason_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getReasonStr() {
            Object r8 = this.reasonStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.reasonStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getReasonStrBytes() {
            Object r8 = this.reasonStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.reasonStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getRecoveryCount() {
            return this.recoveryCount_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getSubReason() {
            Object r8 = this.subReason_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.subReason_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getSubReasonBytes() {
            Object r8 = this.subReason_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.subReason_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getTriggerSource() {
            Object r8 = this.triggerSource_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.triggerSource_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getTriggerSourceBytes() {
            Object r8 = this.triggerSource_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.triggerSource_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getWlanDriverVersion() {
            Object r8 = this.wlanDriverVersion_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wlanDriverVersion_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getWlanDriverVersionBytes() {
            Object r8 = this.wlanDriverVersion_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wlanDriverVersion_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getWlanFwBuildTimestamp() {
            Object r8 = this.wlanFwBuildTimestamp_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wlanFwBuildTimestamp_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getWlanFwBuildTimestampBytes() {
            Object r8 = this.wlanFwBuildTimestamp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wlanFwBuildTimestamp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public int getWlanFwVersion() {
            return this.wlanFwVersion_;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public String getWlanFwVersionStr() {
            Object r8 = this.wlanFwVersionStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wlanFwVersionStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public ByteString getWlanFwVersionStrBytes() {
            Object r8 = this.wlanFwVersionStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wlanFwVersionStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasCnssPlatQuirks() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasConnectedLast() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDeviceDevStateStr() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDeviceExecStr() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDeviceId() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasDriverState() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasHostDevStateStr() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasHostExecStr() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasHostHangFunc() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasHostHangLine() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasHostPmStateStr() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasMhiState() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasPciLinkDownInd() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasPciLinkState() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasRddmSfrInfo() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasReason() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasReasonStr() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasRecoveryCount() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasSubReason() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasTriggerSource() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasWlanDriverVersion() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasWlanFwBuildTimestamp() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasWlanFwVersion() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
        public boolean hasWlanFwVersionStr() {
            if ((this.bitField0_ & 67108864) == 0) goto L5;
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

        public Builder setCnssPlatQuirks(int r8) {
            this.cnssPlatQuirks_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setConnectedLast(int r8) {
            this.connectedLast_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDevStateStr(String r8) {
            if (r8 == null) goto L6;
            this.deviceDevStateStr_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDevStateStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDevStateStr_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceExecStr(String r8) {
            if (r8 == null) goto L6;
            this.deviceExecStr_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceExecStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceExecStr_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceId(int r8) {
            this.deviceId_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setDriverState(int r8) {
            this.driverState_ = r8;
            this.bitField0_ |= 64;
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

        public Builder setHostDevStateStr(String r8) {
            if (r8 == null) goto L6;
            this.hostDevStateStr_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostDevStateStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.hostDevStateStr_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostExecStr(String r8) {
            if (r8 == null) goto L6;
            this.hostExecStr_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostExecStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.hostExecStr_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostHangFunc(String r8) {
            if (r8 == null) goto L6;
            this.hostHangFunc_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostHangFuncBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.hostHangFunc_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostHangLine(int r8) {
            this.hostHangLine_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setHostPmStateStr(String r8) {
            if (r8 == null) goto L6;
            this.hostPmStateStr_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setHostPmStateStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.hostPmStateStr_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setMhiState(int r8) {
            this.mhiState_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setPciLinkDownInd(int r8) {
            this.pciLinkDownInd_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setPciLinkState(int r8) {
            this.pciLinkState_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setRddmSfrInfo(String r8) {
            if (r8 == null) goto L6;
            this.rddmSfrInfo_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRddmSfrInfoBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.rddmSfrInfo_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setReason(int r8) {
            this.reason_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setReasonStr(String r8) {
            if (r8 == null) goto L6;
            this.reasonStr_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setReasonStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.reasonStr_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRecoveryCount(int r8) {
            this.recoveryCount_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSubReason(String r8) {
            if (r8 == null) goto L6;
            this.subReason_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSubReasonBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.subReason_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTriggerSource(String r8) {
            if (r8 == null) goto L6;
            this.triggerSource_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTriggerSourceBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.triggerSource_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWlanDriverVersion(String r8) {
            if (r8 == null) goto L6;
            this.wlanDriverVersion_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWlanDriverVersionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wlanDriverVersion_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWlanFwBuildTimestamp(String r8) {
            if (r8 == null) goto L6;
            this.wlanFwBuildTimestamp_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWlanFwBuildTimestampBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wlanFwBuildTimestamp_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWlanFwVersion(int r8) {
            this.wlanFwVersion_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setWlanFwVersionStr(String r8) {
            if (r8 == null) goto L6;
            this.wlanFwVersionStr_ = r8;
            this.bitField0_ |= 67108864;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWlanFwVersionStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wlanFwVersionStr_ = r8;
            this.bitField0_ |= 67108864;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.subReason_ = "";
            this.rddmSfrInfo_ = "";
            this.hostPmStateStr_ = "";
            this.hostDevStateStr_ = "";
            this.hostExecStr_ = "";
            this.deviceExecStr_ = "";
            this.deviceDevStateStr_ = "";
            this.hostHangFunc_ = "";
            this.deviceDate_ = "";
            this.reasonStr_ = "";
            this.triggerSource_ = "";
            this.wlanDriverVersion_ = "";
            this.wlanFwBuildTimestamp_ = "";
            this.wlanFwVersionStr_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WlanCrashReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WlanCrashReportData.class, Builder.class);
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
        public WlanCrashReportData build() {
            WlanCrashReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WlanCrashReportData buildPartial() {
            WlanCrashReportData r8 = new WlanCrashReportData(this, null);
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
        public WlanCrashReportData getDefaultInstanceForType() {
            return WlanCrashReportData.getDefaultInstance();
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
            this.reason_ = 0;
            this.subReason_ = "";
            this.pciLinkState_ = 0;
            this.pciLinkDownInd_ = 0;
            this.mhiState_ = 0;
            this.driverState_ = 0;
            this.cnssPlatQuirks_ = 0;
            this.connectedLast_ = 0;
            this.rddmSfrInfo_ = "";
            this.hostPmStateStr_ = "";
            this.hostDevStateStr_ = "";
            this.hostExecStr_ = "";
            this.deviceExecStr_ = "";
            this.deviceDevStateStr_ = "";
            this.hostHangLine_ = 0;
            this.hostHangFunc_ = "";
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            this.reasonStr_ = "";
            this.recoveryCount_ = 0;
            this.triggerSource_ = "";
            this.deviceId_ = 0;
            this.wlanDriverVersion_ = "";
            this.wlanFwVersion_ = 0;
            this.wlanFwBuildTimestamp_ = "";
            this.wlanFwVersionStr_ = "";
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
            switch(r12) {
                case 0: goto L36;
                case 10: goto L34;
                case 16: goto L33;
                case 26: goto L32;
                case 32: goto L31;
                case 40: goto L30;
                case 48: goto L29;
                case 56: goto L28;
                case 64: goto L27;
                case 72: goto L26;
                case 82: goto L25;
                case 90: goto L24;
                case 98: goto L23;
                case 106: goto L22;
                case 114: goto L21;
                case 122: goto L20;
                case 128: goto L19;
                case 138: goto L18;
                case 144: goto L17;
                case 154: goto L16;
                case 162: goto L15;
                case 168: goto L14;
                case 178: goto L13;
                case 184: goto L12;
                case 194: goto L11;
                case 200: goto L10;
                case 210: goto L9;
                case 218: goto L8;
                default: goto L37;
            };     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L8:
            this.wlanFwVersionStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 67108864;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L9:
            this.wlanFwBuildTimestamp_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 33554432;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L10:
            this.wlanFwVersion_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L11:
            this.wlanDriverVersion_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L12:
            this.deviceId_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L13:
            this.triggerSource_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L14:
            this.recoveryCount_ = r8.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L15:
            this.reasonStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 524288;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L16:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 262144;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L17:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 131072;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L18:
            this.hostHangFunc_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 65536;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L19:
            this.hostHangLine_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 32768;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L20:
            this.deviceDevStateStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16384;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L21:
            this.deviceExecStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 8192;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L22:
            this.hostExecStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 4096;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L23:
            this.hostDevStateStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 2048;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L24:
            this.hostPmStateStr_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1024;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L25:
            this.rddmSfrInfo_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 512;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L26:
            this.connectedLast_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 256;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L27:
            this.cnssPlatQuirks_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L28:
            this.driverState_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 64;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L29:
            this.mhiState_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L30:
            this.pciLinkDownInd_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L31:
            this.pciLinkState_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L32:
            this.subReason_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L33:
            this.reason_ = r8.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L34:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L36:
            r11 = true;
            goto L4
        L37:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
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
            if ((r8 instanceof WlanCrashReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WlanCrashReportData) r8);
        }

        public Builder mergeFrom(WlanCrashReportData r8) {
            if (r8 != WlanCrashReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = WlanCrashReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasReason() == false) goto L12;
            setReason(r8.getReason());
        L12:
            if (r8.hasSubReason() == false) goto L15;
            this.subReason_ = WlanCrashReportData.access$500(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasPciLinkState() == false) goto L18;
            setPciLinkState(r8.getPciLinkState());
        L18:
            if (r8.hasPciLinkDownInd() == false) goto L21;
            setPciLinkDownInd(r8.getPciLinkDownInd());
        L21:
            if (r8.hasMhiState() == false) goto L24;
            setMhiState(r8.getMhiState());
        L24:
            if (r8.hasDriverState() == false) goto L27;
            setDriverState(r8.getDriverState());
        L27:
            if (r8.hasCnssPlatQuirks() == false) goto L30;
            setCnssPlatQuirks(r8.getCnssPlatQuirks());
        L30:
            if (r8.hasConnectedLast() == false) goto L33;
            setConnectedLast(r8.getConnectedLast());
        L33:
            if (r8.hasRddmSfrInfo() == false) goto L36;
            this.rddmSfrInfo_ = WlanCrashReportData.access$1200(r8);
            this.bitField0_ |= 512;
            onChanged();
        L36:
            if (r8.hasHostPmStateStr() == false) goto L39;
            this.hostPmStateStr_ = WlanCrashReportData.access$1300(r8);
            this.bitField0_ |= 1024;
            onChanged();
        L39:
            if (r8.hasHostDevStateStr() == false) goto L42;
            this.hostDevStateStr_ = WlanCrashReportData.access$1400(r8);
            this.bitField0_ |= 2048;
            onChanged();
        L42:
            if (r8.hasHostExecStr() == false) goto L45;
            this.hostExecStr_ = WlanCrashReportData.access$1500(r8);
            this.bitField0_ |= 4096;
            onChanged();
        L45:
            if (r8.hasDeviceExecStr() == false) goto L48;
            this.deviceExecStr_ = WlanCrashReportData.access$1600(r8);
            this.bitField0_ |= 8192;
            onChanged();
        L48:
            if (r8.hasDeviceDevStateStr() == false) goto L51;
            this.deviceDevStateStr_ = WlanCrashReportData.access$1700(r8);
            this.bitField0_ |= 16384;
            onChanged();
        L51:
            if (r8.hasHostHangLine() == false) goto L54;
            setHostHangLine(r8.getHostHangLine());
        L54:
            if (r8.hasHostHangFunc() == false) goto L57;
            this.hostHangFunc_ = WlanCrashReportData.access$1900(r8);
            this.bitField0_ |= 65536;
            onChanged();
        L57:
            if (r8.hasDeviceTime() == false) goto L60;
            setDeviceTime(r8.getDeviceTime());
        L60:
            if (r8.hasDeviceDate() == false) goto L63;
            this.deviceDate_ = WlanCrashReportData.access$2100(r8);
            this.bitField0_ |= 262144;
            onChanged();
        L63:
            if (r8.hasReasonStr() == false) goto L66;
            this.reasonStr_ = WlanCrashReportData.access$2200(r8);
            this.bitField0_ |= 524288;
            onChanged();
        L66:
            if (r8.hasRecoveryCount() == false) goto L69;
            setRecoveryCount(r8.getRecoveryCount());
        L69:
            if (r8.hasTriggerSource() == false) goto L72;
            this.triggerSource_ = WlanCrashReportData.access$2400(r8);
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
        L72:
            if (r8.hasDeviceId() == false) goto L75;
            setDeviceId(r8.getDeviceId());
        L75:
            if (r8.hasWlanDriverVersion() == false) goto L78;
            this.wlanDriverVersion_ = WlanCrashReportData.access$2600(r8);
            this.bitField0_ |= 8388608;
            onChanged();
        L78:
            if (r8.hasWlanFwVersion() == false) goto L81;
            setWlanFwVersion(r8.getWlanFwVersion());
        L81:
            if (r8.hasWlanFwBuildTimestamp() == false) goto L84;
            this.wlanFwBuildTimestamp_ = WlanCrashReportData.access$2800(r8);
            this.bitField0_ |= 33554432;
            onChanged();
        L84:
            if (r8.hasWlanFwVersionStr() == false) goto L86;
            this.wlanFwVersionStr_ = WlanCrashReportData.access$2900(r8);
            this.bitField0_ |= 67108864;
            onChanged();
        L86:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WlanCrashReportData();
        PARSER = new AnonymousClass1();
    }

    private WlanCrashReportData() {
        this.eventType_ = "";
        this.reason_ = 0;
        this.subReason_ = "";
        this.pciLinkState_ = 0;
        this.pciLinkDownInd_ = 0;
        this.mhiState_ = 0;
        this.driverState_ = 0;
        this.cnssPlatQuirks_ = 0;
        this.connectedLast_ = 0;
        this.rddmSfrInfo_ = "";
        this.hostPmStateStr_ = "";
        this.hostDevStateStr_ = "";
        this.hostExecStr_ = "";
        this.deviceExecStr_ = "";
        this.deviceDevStateStr_ = "";
        this.hostHangLine_ = 0;
        this.hostHangFunc_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.reasonStr_ = "";
        this.recoveryCount_ = 0;
        this.triggerSource_ = "";
        this.deviceId_ = 0;
        this.wlanDriverVersion_ = "";
        this.wlanFwVersion_ = 0;
        this.wlanFwBuildTimestamp_ = "";
        this.wlanFwVersionStr_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.subReason_ = "";
        this.rddmSfrInfo_ = "";
        this.hostPmStateStr_ = "";
        this.hostDevStateStr_ = "";
        this.hostExecStr_ = "";
        this.deviceExecStr_ = "";
        this.deviceDevStateStr_ = "";
        this.hostHangFunc_ = "";
        this.deviceDate_ = "";
        this.reasonStr_ = "";
        this.triggerSource_ = "";
        this.wlanDriverVersion_ = "";
        this.wlanFwBuildTimestamp_ = "";
        this.wlanFwVersionStr_ = "";
    }

    public static /* synthetic */ int access$1002(WlanCrashReportData r8, int r10) {
        r8.cnssPlatQuirks_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(WlanCrashReportData r8, int r10) {
        r8.connectedLast_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(WlanCrashReportData r8) {
        return r8.rddmSfrInfo_;
    }

    public static /* synthetic */ Object access$1202(WlanCrashReportData r8, Object r10) {
        r8.rddmSfrInfo_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1300(WlanCrashReportData r8) {
        return r8.hostPmStateStr_;
    }

    public static /* synthetic */ Object access$1302(WlanCrashReportData r8, Object r10) {
        r8.hostPmStateStr_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(WlanCrashReportData r8) {
        return r8.hostDevStateStr_;
    }

    public static /* synthetic */ Object access$1402(WlanCrashReportData r8, Object r10) {
        r8.hostDevStateStr_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1500(WlanCrashReportData r8) {
        return r8.hostExecStr_;
    }

    public static /* synthetic */ Object access$1502(WlanCrashReportData r8, Object r10) {
        r8.hostExecStr_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1600(WlanCrashReportData r8) {
        return r8.deviceExecStr_;
    }

    public static /* synthetic */ Object access$1602(WlanCrashReportData r8, Object r10) {
        r8.deviceExecStr_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1700(WlanCrashReportData r8) {
        return r8.deviceDevStateStr_;
    }

    public static /* synthetic */ Object access$1702(WlanCrashReportData r8, Object r10) {
        r8.deviceDevStateStr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(WlanCrashReportData r8, int r10) {
        r8.hostHangLine_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1900(WlanCrashReportData r8) {
        return r8.hostHangFunc_;
    }

    public static /* synthetic */ Object access$1902(WlanCrashReportData r8, Object r10) {
        r8.hostHangFunc_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2002(WlanCrashReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2100(WlanCrashReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$2102(WlanCrashReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2200(WlanCrashReportData r8) {
        return r8.reasonStr_;
    }

    public static /* synthetic */ Object access$2202(WlanCrashReportData r8, Object r10) {
        r8.reasonStr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2302(WlanCrashReportData r8, int r10) {
        r8.recoveryCount_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2400(WlanCrashReportData r8) {
        return r8.triggerSource_;
    }

    public static /* synthetic */ Object access$2402(WlanCrashReportData r8, Object r10) {
        r8.triggerSource_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(WlanCrashReportData r8, int r10) {
        r8.deviceId_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2600(WlanCrashReportData r8) {
        return r8.wlanDriverVersion_;
    }

    public static /* synthetic */ Object access$2602(WlanCrashReportData r8, Object r10) {
        r8.wlanDriverVersion_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(WlanCrashReportData r8, int r10) {
        r8.wlanFwVersion_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2800(WlanCrashReportData r8) {
        return r8.wlanFwBuildTimestamp_;
    }

    public static /* synthetic */ Object access$2802(WlanCrashReportData r8, Object r10) {
        r8.wlanFwBuildTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2900(WlanCrashReportData r8) {
        return r8.wlanFwVersionStr_;
    }

    public static /* synthetic */ Object access$2902(WlanCrashReportData r8, Object r10) {
        r8.wlanFwVersionStr_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$300(WlanCrashReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(WlanCrashReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3076(WlanCrashReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(WlanCrashReportData r8, int r10) {
        r8.reason_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(WlanCrashReportData r8) {
        return r8.subReason_;
    }

    public static /* synthetic */ Object access$502(WlanCrashReportData r8, Object r10) {
        r8.subReason_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(WlanCrashReportData r8, int r10) {
        r8.pciLinkState_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(WlanCrashReportData r8, int r10) {
        r8.pciLinkDownInd_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(WlanCrashReportData r8, int r10) {
        r8.mhiState_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(WlanCrashReportData r8, int r10) {
        r8.driverState_ = r10;
        return r10;
    }

    public static WlanCrashReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WlanCrashReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WlanCrashReportData parseDelimitedFrom(InputStream r8) {
        return (WlanCrashReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WlanCrashReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WlanCrashReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WlanCrashReportData) == false) goto L8;
        WlanCrashReportData r10 = (WlanCrashReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasReason() == r10.hasReason()) goto L21;
        return false;
    L21:
        if (hasReason() == false) goto L26;
        if (getReason() == r10.getReason()) goto L26;
        return false;
    L26:
        if (hasSubReason() == r10.hasSubReason()) goto L29;
        return false;
    L29:
        if (hasSubReason() == false) goto L34;
        if (getSubReason().equals(r10.getSubReason()) == true) goto L34;
        return false;
    L34:
        if (hasPciLinkState() == r10.hasPciLinkState()) goto L37;
        return false;
    L37:
        if (hasPciLinkState() == false) goto L42;
        if (getPciLinkState() == r10.getPciLinkState()) goto L42;
        return false;
    L42:
        if (hasPciLinkDownInd() == r10.hasPciLinkDownInd()) goto L45;
        return false;
    L45:
        if (hasPciLinkDownInd() == false) goto L50;
        if (getPciLinkDownInd() == r10.getPciLinkDownInd()) goto L50;
        return false;
    L50:
        if (hasMhiState() == r10.hasMhiState()) goto L53;
        return false;
    L53:
        if (hasMhiState() == false) goto L58;
        if (getMhiState() == r10.getMhiState()) goto L58;
        return false;
    L58:
        if (hasDriverState() == r10.hasDriverState()) goto L61;
        return false;
    L61:
        if (hasDriverState() == false) goto L66;
        if (getDriverState() == r10.getDriverState()) goto L66;
        return false;
    L66:
        if (hasCnssPlatQuirks() == r10.hasCnssPlatQuirks()) goto L69;
        return false;
    L69:
        if (hasCnssPlatQuirks() == false) goto L74;
        if (getCnssPlatQuirks() == r10.getCnssPlatQuirks()) goto L74;
        return false;
    L74:
        if (hasConnectedLast() == r10.hasConnectedLast()) goto L77;
        return false;
    L77:
        if (hasConnectedLast() == false) goto L82;
        if (getConnectedLast() == r10.getConnectedLast()) goto L82;
        return false;
    L82:
        if (hasRddmSfrInfo() == r10.hasRddmSfrInfo()) goto L85;
        return false;
    L85:
        if (hasRddmSfrInfo() == false) goto L90;
        if (getRddmSfrInfo().equals(r10.getRddmSfrInfo()) == true) goto L90;
        return false;
    L90:
        if (hasHostPmStateStr() == r10.hasHostPmStateStr()) goto L93;
        return false;
    L93:
        if (hasHostPmStateStr() == false) goto L98;
        if (getHostPmStateStr().equals(r10.getHostPmStateStr()) == true) goto L98;
        return false;
    L98:
        if (hasHostDevStateStr() == r10.hasHostDevStateStr()) goto L101;
        return false;
    L101:
        if (hasHostDevStateStr() == false) goto L106;
        if (getHostDevStateStr().equals(r10.getHostDevStateStr()) == true) goto L106;
        return false;
    L106:
        if (hasHostExecStr() == r10.hasHostExecStr()) goto L109;
        return false;
    L109:
        if (hasHostExecStr() == false) goto L114;
        if (getHostExecStr().equals(r10.getHostExecStr()) == true) goto L114;
        return false;
    L114:
        if (hasDeviceExecStr() == r10.hasDeviceExecStr()) goto L117;
        return false;
    L117:
        if (hasDeviceExecStr() == false) goto L122;
        if (getDeviceExecStr().equals(r10.getDeviceExecStr()) == true) goto L122;
        return false;
    L122:
        if (hasDeviceDevStateStr() == r10.hasDeviceDevStateStr()) goto L125;
        return false;
    L125:
        if (hasDeviceDevStateStr() == false) goto L130;
        if (getDeviceDevStateStr().equals(r10.getDeviceDevStateStr()) == true) goto L130;
        return false;
    L130:
        if (hasHostHangLine() == r10.hasHostHangLine()) goto L133;
        return false;
    L133:
        if (hasHostHangLine() == false) goto L138;
        if (getHostHangLine() == r10.getHostHangLine()) goto L138;
        return false;
    L138:
        if (hasHostHangFunc() == r10.hasHostHangFunc()) goto L141;
        return false;
    L141:
        if (hasHostHangFunc() == false) goto L146;
        if (getHostHangFunc().equals(r10.getHostHangFunc()) == true) goto L146;
        return false;
    L146:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L149;
        return false;
    L149:
        if (hasDeviceTime() == false) goto L154;
        if (getDeviceTime() == r10.getDeviceTime()) goto L154;
        return false;
    L154:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L157;
        return false;
    L157:
        if (hasDeviceDate() == false) goto L162;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L162;
        return false;
    L162:
        if (hasReasonStr() == r10.hasReasonStr()) goto L165;
        return false;
    L165:
        if (hasReasonStr() == false) goto L170;
        if (getReasonStr().equals(r10.getReasonStr()) == true) goto L170;
        return false;
    L170:
        if (hasRecoveryCount() == r10.hasRecoveryCount()) goto L173;
        return false;
    L173:
        if (hasRecoveryCount() == false) goto L178;
        if (getRecoveryCount() == r10.getRecoveryCount()) goto L178;
        return false;
    L178:
        if (hasTriggerSource() == r10.hasTriggerSource()) goto L181;
        return false;
    L181:
        if (hasTriggerSource() == false) goto L186;
        if (getTriggerSource().equals(r10.getTriggerSource()) == true) goto L186;
        return false;
    L186:
        if (hasDeviceId() == r10.hasDeviceId()) goto L189;
        return false;
    L189:
        if (hasDeviceId() == false) goto L194;
        if (getDeviceId() == r10.getDeviceId()) goto L194;
        return false;
    L194:
        if (hasWlanDriverVersion() == r10.hasWlanDriverVersion()) goto L197;
        return false;
    L197:
        if (hasWlanDriverVersion() == false) goto L202;
        if (getWlanDriverVersion().equals(r10.getWlanDriverVersion()) == true) goto L202;
        return false;
    L202:
        if (hasWlanFwVersion() == r10.hasWlanFwVersion()) goto L205;
        return false;
    L205:
        if (hasWlanFwVersion() == false) goto L210;
        if (getWlanFwVersion() == r10.getWlanFwVersion()) goto L210;
        return false;
    L210:
        if (hasWlanFwBuildTimestamp() == r10.hasWlanFwBuildTimestamp()) goto L213;
        return false;
    L213:
        if (hasWlanFwBuildTimestamp() == false) goto L218;
        if (getWlanFwBuildTimestamp().equals(r10.getWlanFwBuildTimestamp()) == true) goto L218;
        return false;
    L218:
        if (hasWlanFwVersionStr() == r10.hasWlanFwVersionStr()) goto L221;
        return false;
    L221:
        if (hasWlanFwVersionStr() == false) goto L226;
        if (getWlanFwVersionStr().equals(r10.getWlanFwVersionStr()) == true) goto L226;
        return false;
    L226:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L228;
        return false;
    L228:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getCnssPlatQuirks() {
        return this.cnssPlatQuirks_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getConnectedLast() {
        return this.connectedLast_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getDeviceDevStateStr() {
        Object r8 = this.deviceDevStateStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceDevStateStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getDeviceDevStateStrBytes() {
        Object r8 = this.deviceDevStateStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDevStateStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getDeviceExecStr() {
        Object r8 = this.deviceExecStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceExecStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getDeviceExecStrBytes() {
        Object r8 = this.deviceExecStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceExecStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getDeviceId() {
        return this.deviceId_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getDriverState() {
        return this.driverState_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getHostDevStateStr() {
        Object r8 = this.hostDevStateStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.hostDevStateStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getHostDevStateStrBytes() {
        Object r8 = this.hostDevStateStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.hostDevStateStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getHostExecStr() {
        Object r8 = this.hostExecStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.hostExecStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getHostExecStrBytes() {
        Object r8 = this.hostExecStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.hostExecStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getHostHangFunc() {
        Object r8 = this.hostHangFunc_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.hostHangFunc_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getHostHangFuncBytes() {
        Object r8 = this.hostHangFunc_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.hostHangFunc_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getHostHangLine() {
        return this.hostHangLine_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getHostPmStateStr() {
        Object r8 = this.hostPmStateStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.hostPmStateStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getHostPmStateStrBytes() {
        Object r8 = this.hostPmStateStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.hostPmStateStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getMhiState() {
        return this.mhiState_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WlanCrashReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getPciLinkDownInd() {
        return this.pciLinkDownInd_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getPciLinkState() {
        return this.pciLinkState_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getRddmSfrInfo() {
        Object r8 = this.rddmSfrInfo_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.rddmSfrInfo_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getRddmSfrInfoBytes() {
        Object r8 = this.rddmSfrInfo_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.rddmSfrInfo_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getReason() {
        return this.reason_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getReasonStr() {
        Object r8 = this.reasonStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.reasonStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getReasonStrBytes() {
        Object r8 = this.reasonStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.reasonStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getRecoveryCount() {
        return this.recoveryCount_;
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
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.reason_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.subReason_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.pciLinkState_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.pciLinkDownInd_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.mhiState_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.driverState_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.cnssPlatQuirks_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.connectedLast_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + GeneratedMessage.computeStringSize(10, this.rddmSfrInfo_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + GeneratedMessage.computeStringSize(11, this.hostPmStateStr_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + GeneratedMessage.computeStringSize(12, this.hostDevStateStr_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + GeneratedMessage.computeStringSize(13, this.hostExecStr_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + GeneratedMessage.computeStringSize(14, this.deviceExecStr_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + GeneratedMessage.computeStringSize(15, this.deviceDevStateStr_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.hostHangLine_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + GeneratedMessage.computeStringSize(17, this.hostHangFunc_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeUInt64Size(18, this.deviceTime_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + GeneratedMessage.computeStringSize(19, this.deviceDate_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r10 = r10 + GeneratedMessage.computeStringSize(20, this.reasonStr_);
    L66:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L69;
        r10 = r10 + CodedOutputStream.computeUInt32Size(21, this.recoveryCount_);
    L69:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L72;
        r10 = r10 + GeneratedMessage.computeStringSize(22, this.triggerSource_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r10 = r10 + CodedOutputStream.computeUInt32Size(23, this.deviceId_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L78;
        r10 = r10 + GeneratedMessage.computeStringSize(24, this.wlanDriverVersion_);
    L78:
        if ((this.bitField0_ & 16777216) == 0) goto L81;
        r10 = r10 + CodedOutputStream.computeUInt32Size(25, this.wlanFwVersion_);
    L81:
        if ((this.bitField0_ & 33554432) == 0) goto L84;
        r10 = r10 + GeneratedMessage.computeStringSize(26, this.wlanFwBuildTimestamp_);
    L84:
        if ((this.bitField0_ & 67108864) == 0) goto L86;
        r10 = r10 + GeneratedMessage.computeStringSize(27, this.wlanFwVersionStr_);
    L86:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getSubReason() {
        Object r8 = this.subReason_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.subReason_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getSubReasonBytes() {
        Object r8 = this.subReason_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.subReason_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getTriggerSource() {
        Object r8 = this.triggerSource_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.triggerSource_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getTriggerSourceBytes() {
        Object r8 = this.triggerSource_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.triggerSource_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getWlanDriverVersion() {
        Object r8 = this.wlanDriverVersion_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wlanDriverVersion_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getWlanDriverVersionBytes() {
        Object r8 = this.wlanDriverVersion_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wlanDriverVersion_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getWlanFwBuildTimestamp() {
        Object r8 = this.wlanFwBuildTimestamp_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wlanFwBuildTimestamp_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getWlanFwBuildTimestampBytes() {
        Object r8 = this.wlanFwBuildTimestamp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wlanFwBuildTimestamp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public int getWlanFwVersion() {
        return this.wlanFwVersion_;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public String getWlanFwVersionStr() {
        Object r8 = this.wlanFwVersionStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wlanFwVersionStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public ByteString getWlanFwVersionStrBytes() {
        Object r8 = this.wlanFwVersionStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wlanFwVersionStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasCnssPlatQuirks() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasConnectedLast() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDeviceDevStateStr() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDeviceExecStr() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDeviceId() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasDriverState() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasHostDevStateStr() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasHostExecStr() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasHostHangFunc() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasHostHangLine() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasHostPmStateStr() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasMhiState() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasPciLinkDownInd() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasPciLinkState() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasRddmSfrInfo() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasReason() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasReasonStr() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasRecoveryCount() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasSubReason() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasTriggerSource() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasWlanDriverVersion() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasWlanFwBuildTimestamp() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasWlanFwVersion() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WlanCrashReportDataOrBuilder
    public boolean hasWlanFwVersionStr() {
        if ((this.bitField0_ & 67108864) == 0) goto L5;
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
        if (hasReason() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getReason();
    L12:
        if (hasSubReason() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getSubReason().hashCode();
    L15:
        if (hasPciLinkState() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getPciLinkState();
    L18:
        if (hasPciLinkDownInd() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getPciLinkDownInd();
    L21:
        if (hasMhiState() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getMhiState();
    L24:
        if (hasDriverState() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getDriverState();
    L27:
        if (hasCnssPlatQuirks() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getCnssPlatQuirks();
    L30:
        if (hasConnectedLast() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getConnectedLast();
    L33:
        if (hasRddmSfrInfo() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getRddmSfrInfo().hashCode();
    L36:
        if (hasHostPmStateStr() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getHostPmStateStr().hashCode();
    L39:
        if (hasHostDevStateStr() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getHostDevStateStr().hashCode();
    L42:
        if (hasHostExecStr() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + getHostExecStr().hashCode();
    L45:
        if (hasDeviceExecStr() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getDeviceExecStr().hashCode();
    L48:
        if (hasDeviceDevStateStr() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + getDeviceDevStateStr().hashCode();
    L51:
        if (hasHostHangLine() == false) goto L54;
        r10 = defpackage.b.a(r10, 37, 16, 53) + getHostHangLine();
    L54:
        if (hasHostHangFunc() == false) goto L57;
        r10 = defpackage.b.a(r10, 37, 17, 53) + getHostHangFunc().hashCode();
    L57:
        if (hasDeviceTime() == false) goto L60;
        r10 = defpackage.b.a(r10, 37, 18, 53) + Internal.hashLong(getDeviceTime());
    L60:
        if (hasDeviceDate() == false) goto L63;
        r10 = defpackage.b.a(r10, 37, 19, 53) + getDeviceDate().hashCode();
    L63:
        if (hasReasonStr() == false) goto L66;
        r10 = defpackage.b.a(r10, 37, 20, 53) + getReasonStr().hashCode();
    L66:
        if (hasRecoveryCount() == false) goto L69;
        r10 = defpackage.b.a(r10, 37, 21, 53) + getRecoveryCount();
    L69:
        if (hasTriggerSource() == false) goto L72;
        r10 = defpackage.b.a(r10, 37, 22, 53) + getTriggerSource().hashCode();
    L72:
        if (hasDeviceId() == false) goto L75;
        r10 = defpackage.b.a(r10, 37, 23, 53) + getDeviceId();
    L75:
        if (hasWlanDriverVersion() == false) goto L78;
        r10 = defpackage.b.a(r10, 37, 24, 53) + getWlanDriverVersion().hashCode();
    L78:
        if (hasWlanFwVersion() == false) goto L81;
        r10 = defpackage.b.a(r10, 37, 25, 53) + getWlanFwVersion();
    L81:
        if (hasWlanFwBuildTimestamp() == false) goto L84;
        r10 = defpackage.b.a(r10, 37, 26, 53) + getWlanFwBuildTimestamp().hashCode();
    L84:
        if (hasWlanFwVersionStr() == false) goto L86;
        r10 = defpackage.b.a(r10, 37, 27, 53) + getWlanFwVersionStr().hashCode();
    L86:
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
        return new WlanCrashReportData();
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
        r8.writeInt32(2, this.reason_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.subReason_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.pciLinkState_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.pciLinkDownInd_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.mhiState_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.driverState_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.cnssPlatQuirks_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.connectedLast_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        GeneratedMessage.writeString(r8, 10, this.rddmSfrInfo_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        GeneratedMessage.writeString(r8, 11, this.hostPmStateStr_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        GeneratedMessage.writeString(r8, 12, this.hostDevStateStr_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        GeneratedMessage.writeString(r8, 13, this.hostExecStr_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        GeneratedMessage.writeString(r8, 14, this.deviceExecStr_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        GeneratedMessage.writeString(r8, 15, this.deviceDevStateStr_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeInt32(16, this.hostHangLine_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        GeneratedMessage.writeString(r8, 17, this.hostHangFunc_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r8.writeUInt64(18, this.deviceTime_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        GeneratedMessage.writeString(r8, 19, this.deviceDate_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        GeneratedMessage.writeString(r8, 20, this.reasonStr_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r8.writeUInt32(21, this.recoveryCount_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        GeneratedMessage.writeString(r8, 22, this.triggerSource_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r8.writeUInt32(23, this.deviceId_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        GeneratedMessage.writeString(r8, 24, this.wlanDriverVersion_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r8.writeUInt32(25, this.wlanFwVersion_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        GeneratedMessage.writeString(r8, 26, this.wlanFwBuildTimestamp_);
    L81:
        if ((this.bitField0_ & 67108864) == 0) goto L83;
        GeneratedMessage.writeString(r8, 27, this.wlanFwVersionStr_);
    L83:
        getUnknownFields().writeTo(r8);
    }

    private WlanCrashReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.reason_ = 0;
        this.subReason_ = "";
        this.pciLinkState_ = 0;
        this.pciLinkDownInd_ = 0;
        this.mhiState_ = 0;
        this.driverState_ = 0;
        this.cnssPlatQuirks_ = 0;
        this.connectedLast_ = 0;
        this.rddmSfrInfo_ = "";
        this.hostPmStateStr_ = "";
        this.hostDevStateStr_ = "";
        this.hostExecStr_ = "";
        this.deviceExecStr_ = "";
        this.deviceDevStateStr_ = "";
        this.hostHangLine_ = 0;
        this.hostHangFunc_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.reasonStr_ = "";
        this.recoveryCount_ = 0;
        this.triggerSource_ = "";
        this.deviceId_ = 0;
        this.wlanDriverVersion_ = "";
        this.wlanFwVersion_ = 0;
        this.wlanFwBuildTimestamp_ = "";
        this.wlanFwVersionStr_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WlanCrashReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WlanCrashReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WlanCrashReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WlanCrashReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WlanCrashReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WlanCrashReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WlanCrashReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WlanCrashReportData parseFrom(CodedInputStream r8) {
        return (WlanCrashReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WlanCrashReportData getDefaultInstanceForType() {
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

    public static WlanCrashReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WlanCrashReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WlanCrashReportData parseFrom(InputStream r8) {
        return (WlanCrashReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WlanCrashReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WlanCrashReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WlanCrashReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WlanCrashReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WlanCrashReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WlanCrashReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
