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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeWifiServiceProtoData extends GeneratedMessageV3 implements CaeWifiServiceProtoDataOrBuilder {
    public static final int CONNECTIONTIMEREPORT_FIELD_NUMBER = 2;
    private static final CaeWifiServiceProtoData DEFAULT_INSTANCE = null;
    public static final int LINKLAYERQUALITYREPORT_FIELD_NUMBER = 5;
    public static final int MLOLINKLAYERQUALITYREPORT_FIELD_NUMBER = 6;
    public static final int NETWORKQUALITYSTATUSREPORT_FIELD_NUMBER = 4;

    @Deprecated
    public static final Parser<CaeWifiServiceProtoData> PARSER = null;
    public static final int POORLINKDISCONNECTREPORT_FIELD_NUMBER = 11;
    public static final int POWERSTATSREPORT_FIELD_NUMBER = 3;
    public static final int ROAMSUCCESSREPORT_FIELD_NUMBER = 7;
    public static final int ROUTERMODELREPORT_FIELD_NUMBER = 1;
    public static final int STARTSCANDAILYREPORT_FIELD_NUMBER = 8;
    public static final int WAKEPACKETREPORT_FIELD_NUMBER = 10;
    public static final int WLANCRASHREPORT_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private ConnectionTimeReportData connectionTimeReport_;
    private LinkLayerQualityReportData linkLayerQualityReport_;
    private byte memoizedIsInitialized;
    private MloLinkLayerQualityReportData mloLinkLayerQualityReport_;
    private NetworkQualityStatusReportData networkQualityStatusReport_;
    private PoorLinkDisconnectReportData poorLinkDisconnectReport_;
    private PowerStatsReportData powerStatsReport_;
    private RoamSuccessReportData roamSuccessReport_;
    private RouterModelReportData routerModelReport_;
    private StartScanDailyReportData startScanDailyReport_;
    private WakePacketReportData wakePacketReport_;
    private WlanCrashReportData wlanCrashReport_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeWifiServiceProtoDataOrBuilder {
        private int bitField0_;
        private SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> connectionTimeReportBuilder_;
        private ConnectionTimeReportData connectionTimeReport_;
        private SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> linkLayerQualityReportBuilder_;
        private LinkLayerQualityReportData linkLayerQualityReport_;
        private SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> mloLinkLayerQualityReportBuilder_;
        private MloLinkLayerQualityReportData mloLinkLayerQualityReport_;
        private SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> networkQualityStatusReportBuilder_;
        private NetworkQualityStatusReportData networkQualityStatusReport_;
        private SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> poorLinkDisconnectReportBuilder_;
        private PoorLinkDisconnectReportData poorLinkDisconnectReport_;
        private SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> powerStatsReportBuilder_;
        private PowerStatsReportData powerStatsReport_;
        private SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> roamSuccessReportBuilder_;
        private RoamSuccessReportData roamSuccessReport_;
        private SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> routerModelReportBuilder_;
        private RouterModelReportData routerModelReport_;
        private SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> startScanDailyReportBuilder_;
        private StartScanDailyReportData startScanDailyReport_;
        private SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> wakePacketReportBuilder_;
        private WakePacketReportData wakePacketReport_;
        private SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> wlanCrashReportBuilder_;
        private WlanCrashReportData wlanCrashReport_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(CaeWifiServiceProtoData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L9;
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r11 = this.routerModelReportBuilder_;
            if (r11 != null) goto L7;
            RouterModelReportData r12 = this.routerModelReport_;
        L8:
            CaeWifiServiceProtoData.access$402(r8, r12);
            int r13 = 1;
        L11:
            if ((r10 & 2) == 0) goto L18;
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r14 = this.connectionTimeReportBuilder_;
            if (r14 != null) goto L15;
            ConnectionTimeReportData r15 = this.connectionTimeReport_;
        L16:
            CaeWifiServiceProtoData.access$502(r8, r15);
            r13 = r13 | 2;
            goto L18
        L15:
            r15 = (ConnectionTimeReportData) r14.build();
        L18:
            if ((r10 & 4) == 0) goto L25;
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r16 = this.powerStatsReportBuilder_;
            if (r16 != null) goto L22;
            PowerStatsReportData r17 = this.powerStatsReport_;
        L23:
            CaeWifiServiceProtoData.access$602(r8, r17);
            r13 = r13 | 4;
            goto L25
        L22:
            r17 = (PowerStatsReportData) r16.build();
        L25:
            if ((r10 & 8) == 0) goto L32;
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r18 = this.networkQualityStatusReportBuilder_;
            if (r18 != null) goto L29;
            NetworkQualityStatusReportData r19 = this.networkQualityStatusReport_;
        L30:
            CaeWifiServiceProtoData.access$702(r8, r19);
            r13 = r13 | 8;
            goto L32
        L29:
            r19 = (NetworkQualityStatusReportData) r18.build();
        L32:
            if ((r10 & 16) == 0) goto L39;
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r20 = this.linkLayerQualityReportBuilder_;
            if (r20 != null) goto L36;
            LinkLayerQualityReportData r21 = this.linkLayerQualityReport_;
        L37:
            CaeWifiServiceProtoData.access$802(r8, r21);
            r13 = r13 | 16;
            goto L39
        L36:
            r21 = (LinkLayerQualityReportData) r20.build();
        L39:
            if ((r10 & 32) == 0) goto L46;
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r22 = this.mloLinkLayerQualityReportBuilder_;
            if (r22 != null) goto L43;
            MloLinkLayerQualityReportData r23 = this.mloLinkLayerQualityReport_;
        L44:
            CaeWifiServiceProtoData.access$902(r8, r23);
            r13 = r13 | 32;
            goto L46
        L43:
            r23 = (MloLinkLayerQualityReportData) r22.build();
        L46:
            if ((r10 & 64) == 0) goto L53;
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r24 = this.roamSuccessReportBuilder_;
            if (r24 != null) goto L50;
            RoamSuccessReportData r25 = this.roamSuccessReport_;
        L51:
            CaeWifiServiceProtoData.access$1002(r8, r25);
            r13 = r13 | 64;
            goto L53
        L50:
            r25 = (RoamSuccessReportData) r24.build();
        L53:
            if ((r10 & 128) == 0) goto L60;
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r26 = this.startScanDailyReportBuilder_;
            if (r26 != null) goto L57;
            StartScanDailyReportData r27 = this.startScanDailyReport_;
        L58:
            CaeWifiServiceProtoData.access$1102(r8, r27);
            r13 = r13 | 128;
            goto L60
        L57:
            r27 = (StartScanDailyReportData) r26.build();
        L60:
            if ((r10 & 256) == 0) goto L67;
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r28 = this.wlanCrashReportBuilder_;
            if (r28 != null) goto L64;
            WlanCrashReportData r29 = this.wlanCrashReport_;
        L65:
            CaeWifiServiceProtoData.access$1202(r8, r29);
            r13 = r13 | 256;
            goto L67
        L64:
            r29 = (WlanCrashReportData) r28.build();
        L67:
            if ((r10 & 512) == 0) goto L74;
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r30 = this.wakePacketReportBuilder_;
            if (r30 != null) goto L71;
            WakePacketReportData r31 = this.wakePacketReport_;
        L72:
            CaeWifiServiceProtoData.access$1302(r8, r31);
            r13 = r13 | 512;
            goto L74
        L71:
            r31 = (WakePacketReportData) r30.build();
        L74:
            if ((r10 & 1024) == 0) goto L80;
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r32 = this.poorLinkDisconnectReportBuilder_;
            if (r32 != null) goto L78;
            PoorLinkDisconnectReportData r33 = this.poorLinkDisconnectReport_;
        L79:
            CaeWifiServiceProtoData.access$1402(r8, r33);
            r13 = r13 | 1024;
            goto L80
        L78:
            r33 = (PoorLinkDisconnectReportData) r32.build();
        L80:
            CaeWifiServiceProtoData.access$1576(r8, r13);
            return;
        L7:
            r12 = (RouterModelReportData) r11.build();
            goto L8
        L9:
            r13 = 0;
            goto L11
        }

        private SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> getConnectionTimeReportFieldBuilder() {
            if (this.connectionTimeReportBuilder_ != null) goto L6;
            this.connectionTimeReportBuilder_ = new SingleFieldBuilderV3(getConnectionTimeReport(), getParentForChildren(), isClean());
            this.connectionTimeReport_ = null;
        L6:
            return this.connectionTimeReportBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProtoData_descriptor;
        }

        private SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> getLinkLayerQualityReportFieldBuilder() {
            if (this.linkLayerQualityReportBuilder_ != null) goto L6;
            this.linkLayerQualityReportBuilder_ = new SingleFieldBuilderV3(getLinkLayerQualityReport(), getParentForChildren(), isClean());
            this.linkLayerQualityReport_ = null;
        L6:
            return this.linkLayerQualityReportBuilder_;
        }

        private SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> getMloLinkLayerQualityReportFieldBuilder() {
            if (this.mloLinkLayerQualityReportBuilder_ != null) goto L6;
            this.mloLinkLayerQualityReportBuilder_ = new SingleFieldBuilderV3(getMloLinkLayerQualityReport(), getParentForChildren(), isClean());
            this.mloLinkLayerQualityReport_ = null;
        L6:
            return this.mloLinkLayerQualityReportBuilder_;
        }

        private SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> getNetworkQualityStatusReportFieldBuilder() {
            if (this.networkQualityStatusReportBuilder_ != null) goto L6;
            this.networkQualityStatusReportBuilder_ = new SingleFieldBuilderV3(getNetworkQualityStatusReport(), getParentForChildren(), isClean());
            this.networkQualityStatusReport_ = null;
        L6:
            return this.networkQualityStatusReportBuilder_;
        }

        private SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> getPoorLinkDisconnectReportFieldBuilder() {
            if (this.poorLinkDisconnectReportBuilder_ != null) goto L6;
            this.poorLinkDisconnectReportBuilder_ = new SingleFieldBuilderV3(getPoorLinkDisconnectReport(), getParentForChildren(), isClean());
            this.poorLinkDisconnectReport_ = null;
        L6:
            return this.poorLinkDisconnectReportBuilder_;
        }

        private SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> getPowerStatsReportFieldBuilder() {
            if (this.powerStatsReportBuilder_ != null) goto L6;
            this.powerStatsReportBuilder_ = new SingleFieldBuilderV3(getPowerStatsReport(), getParentForChildren(), isClean());
            this.powerStatsReport_ = null;
        L6:
            return this.powerStatsReportBuilder_;
        }

        private SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> getRoamSuccessReportFieldBuilder() {
            if (this.roamSuccessReportBuilder_ != null) goto L6;
            this.roamSuccessReportBuilder_ = new SingleFieldBuilderV3(getRoamSuccessReport(), getParentForChildren(), isClean());
            this.roamSuccessReport_ = null;
        L6:
            return this.roamSuccessReportBuilder_;
        }

        private SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> getRouterModelReportFieldBuilder() {
            if (this.routerModelReportBuilder_ != null) goto L6;
            this.routerModelReportBuilder_ = new SingleFieldBuilderV3(getRouterModelReport(), getParentForChildren(), isClean());
            this.routerModelReport_ = null;
        L6:
            return this.routerModelReportBuilder_;
        }

        private SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> getStartScanDailyReportFieldBuilder() {
            if (this.startScanDailyReportBuilder_ != null) goto L6;
            this.startScanDailyReportBuilder_ = new SingleFieldBuilderV3(getStartScanDailyReport(), getParentForChildren(), isClean());
            this.startScanDailyReport_ = null;
        L6:
            return this.startScanDailyReportBuilder_;
        }

        private SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> getWakePacketReportFieldBuilder() {
            if (this.wakePacketReportBuilder_ != null) goto L6;
            this.wakePacketReportBuilder_ = new SingleFieldBuilderV3(getWakePacketReport(), getParentForChildren(), isClean());
            this.wakePacketReport_ = null;
        L6:
            return this.wakePacketReportBuilder_;
        }

        private SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> getWlanCrashReportFieldBuilder() {
            if (this.wlanCrashReportBuilder_ != null) goto L6;
            this.wlanCrashReportBuilder_ = new SingleFieldBuilderV3(getWlanCrashReport(), getParentForChildren(), isClean());
            this.wlanCrashReport_ = null;
        L6:
            return this.wlanCrashReportBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (CaeWifiServiceProtoData.access$200() == false) goto L6;
            getRouterModelReportFieldBuilder();
            getConnectionTimeReportFieldBuilder();
            getPowerStatsReportFieldBuilder();
            getNetworkQualityStatusReportFieldBuilder();
            getLinkLayerQualityReportFieldBuilder();
            getMloLinkLayerQualityReportFieldBuilder();
            getRoamSuccessReportFieldBuilder();
            getStartScanDailyReportFieldBuilder();
            getWlanCrashReportFieldBuilder();
            getWakePacketReportFieldBuilder();
            getPoorLinkDisconnectReportFieldBuilder();
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

        public Builder clearConnectionTimeReport() {
            this.bitField0_ &= -3;
            this.connectionTimeReport_ = null;
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r8 = this.connectionTimeReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.connectionTimeReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearLinkLayerQualityReport() {
            this.bitField0_ &= -17;
            this.linkLayerQualityReport_ = null;
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r8 = this.linkLayerQualityReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.linkLayerQualityReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearMloLinkLayerQualityReport() {
            this.bitField0_ &= -33;
            this.mloLinkLayerQualityReport_ = null;
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r8 = this.mloLinkLayerQualityReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.mloLinkLayerQualityReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearNetworkQualityStatusReport() {
            this.bitField0_ &= -9;
            this.networkQualityStatusReport_ = null;
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r8 = this.networkQualityStatusReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkQualityStatusReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPoorLinkDisconnectReport() {
            this.bitField0_ &= -1025;
            this.poorLinkDisconnectReport_ = null;
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r8 = this.poorLinkDisconnectReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.poorLinkDisconnectReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearPowerStatsReport() {
            this.bitField0_ &= -5;
            this.powerStatsReport_ = null;
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r8 = this.powerStatsReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.powerStatsReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearRoamSuccessReport() {
            this.bitField0_ &= -65;
            this.roamSuccessReport_ = null;
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r8 = this.roamSuccessReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.roamSuccessReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearRouterModelReport() {
            this.bitField0_ &= -2;
            this.routerModelReport_ = null;
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r8 = this.routerModelReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.routerModelReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearStartScanDailyReport() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.startScanDailyReport_ = null;
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r8 = this.startScanDailyReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.startScanDailyReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearWakePacketReport() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.wakePacketReport_ = null;
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r8 = this.wakePacketReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.wakePacketReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearWlanCrashReport() {
            this.bitField0_ &= -257;
            this.wlanCrashReport_ = null;
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r8 = this.wlanCrashReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.wlanCrashReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public ConnectionTimeReportData getConnectionTimeReport() {
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r8 = this.connectionTimeReportBuilder_;
            if (r8 != null) goto L9;
            ConnectionTimeReportData r10 = this.connectionTimeReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return ConnectionTimeReportData.getDefaultInstance();
        L9:
            return (ConnectionTimeReportData) r8.getMessage();
        }

        public ConnectionTimeReportData.Builder getConnectionTimeReportBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (ConnectionTimeReportData.Builder) getConnectionTimeReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public ConnectionTimeReportDataOrBuilder getConnectionTimeReportOrBuilder() {
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r8 = this.connectionTimeReportBuilder_;
            if (r8 != null) goto L5;
            ConnectionTimeReportData r10 = this.connectionTimeReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return ConnectionTimeReportData.getDefaultInstance();
        L5:
            return (ConnectionTimeReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProtoData_descriptor;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public LinkLayerQualityReportData getLinkLayerQualityReport() {
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r8 = this.linkLayerQualityReportBuilder_;
            if (r8 != null) goto L9;
            LinkLayerQualityReportData r10 = this.linkLayerQualityReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return LinkLayerQualityReportData.getDefaultInstance();
        L9:
            return (LinkLayerQualityReportData) r8.getMessage();
        }

        public LinkLayerQualityReportData.Builder getLinkLayerQualityReportBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (LinkLayerQualityReportData.Builder) getLinkLayerQualityReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public LinkLayerQualityReportDataOrBuilder getLinkLayerQualityReportOrBuilder() {
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r8 = this.linkLayerQualityReportBuilder_;
            if (r8 != null) goto L5;
            LinkLayerQualityReportData r10 = this.linkLayerQualityReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return LinkLayerQualityReportData.getDefaultInstance();
        L5:
            return (LinkLayerQualityReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public MloLinkLayerQualityReportData getMloLinkLayerQualityReport() {
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r8 = this.mloLinkLayerQualityReportBuilder_;
            if (r8 != null) goto L9;
            MloLinkLayerQualityReportData r10 = this.mloLinkLayerQualityReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return MloLinkLayerQualityReportData.getDefaultInstance();
        L9:
            return (MloLinkLayerQualityReportData) r8.getMessage();
        }

        public MloLinkLayerQualityReportData.Builder getMloLinkLayerQualityReportBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (MloLinkLayerQualityReportData.Builder) getMloLinkLayerQualityReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public MloLinkLayerQualityReportDataOrBuilder getMloLinkLayerQualityReportOrBuilder() {
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r8 = this.mloLinkLayerQualityReportBuilder_;
            if (r8 != null) goto L5;
            MloLinkLayerQualityReportData r10 = this.mloLinkLayerQualityReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return MloLinkLayerQualityReportData.getDefaultInstance();
        L5:
            return (MloLinkLayerQualityReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public NetworkQualityStatusReportData getNetworkQualityStatusReport() {
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r8 = this.networkQualityStatusReportBuilder_;
            if (r8 != null) goto L9;
            NetworkQualityStatusReportData r10 = this.networkQualityStatusReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkQualityStatusReportData.getDefaultInstance();
        L9:
            return (NetworkQualityStatusReportData) r8.getMessage();
        }

        public NetworkQualityStatusReportData.Builder getNetworkQualityStatusReportBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (NetworkQualityStatusReportData.Builder) getNetworkQualityStatusReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public NetworkQualityStatusReportDataOrBuilder getNetworkQualityStatusReportOrBuilder() {
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r8 = this.networkQualityStatusReportBuilder_;
            if (r8 != null) goto L5;
            NetworkQualityStatusReportData r10 = this.networkQualityStatusReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkQualityStatusReportData.getDefaultInstance();
        L5:
            return (NetworkQualityStatusReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public PoorLinkDisconnectReportData getPoorLinkDisconnectReport() {
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r8 = this.poorLinkDisconnectReportBuilder_;
            if (r8 != null) goto L9;
            PoorLinkDisconnectReportData r10 = this.poorLinkDisconnectReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return PoorLinkDisconnectReportData.getDefaultInstance();
        L9:
            return (PoorLinkDisconnectReportData) r8.getMessage();
        }

        public PoorLinkDisconnectReportData.Builder getPoorLinkDisconnectReportBuilder() {
            this.bitField0_ |= 1024;
            onChanged();
            return (PoorLinkDisconnectReportData.Builder) getPoorLinkDisconnectReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public PoorLinkDisconnectReportDataOrBuilder getPoorLinkDisconnectReportOrBuilder() {
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r8 = this.poorLinkDisconnectReportBuilder_;
            if (r8 != null) goto L5;
            PoorLinkDisconnectReportData r10 = this.poorLinkDisconnectReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return PoorLinkDisconnectReportData.getDefaultInstance();
        L5:
            return (PoorLinkDisconnectReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public PowerStatsReportData getPowerStatsReport() {
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r8 = this.powerStatsReportBuilder_;
            if (r8 != null) goto L9;
            PowerStatsReportData r10 = this.powerStatsReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return PowerStatsReportData.getDefaultInstance();
        L9:
            return (PowerStatsReportData) r8.getMessage();
        }

        public PowerStatsReportData.Builder getPowerStatsReportBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (PowerStatsReportData.Builder) getPowerStatsReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public PowerStatsReportDataOrBuilder getPowerStatsReportOrBuilder() {
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r8 = this.powerStatsReportBuilder_;
            if (r8 != null) goto L5;
            PowerStatsReportData r10 = this.powerStatsReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return PowerStatsReportData.getDefaultInstance();
        L5:
            return (PowerStatsReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public RoamSuccessReportData getRoamSuccessReport() {
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r8 = this.roamSuccessReportBuilder_;
            if (r8 != null) goto L9;
            RoamSuccessReportData r10 = this.roamSuccessReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return RoamSuccessReportData.getDefaultInstance();
        L9:
            return (RoamSuccessReportData) r8.getMessage();
        }

        public RoamSuccessReportData.Builder getRoamSuccessReportBuilder() {
            this.bitField0_ |= 64;
            onChanged();
            return (RoamSuccessReportData.Builder) getRoamSuccessReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public RoamSuccessReportDataOrBuilder getRoamSuccessReportOrBuilder() {
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r8 = this.roamSuccessReportBuilder_;
            if (r8 != null) goto L5;
            RoamSuccessReportData r10 = this.roamSuccessReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return RoamSuccessReportData.getDefaultInstance();
        L5:
            return (RoamSuccessReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public RouterModelReportData getRouterModelReport() {
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r8 = this.routerModelReportBuilder_;
            if (r8 != null) goto L9;
            RouterModelReportData r10 = this.routerModelReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return RouterModelReportData.getDefaultInstance();
        L9:
            return (RouterModelReportData) r8.getMessage();
        }

        public RouterModelReportData.Builder getRouterModelReportBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (RouterModelReportData.Builder) getRouterModelReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public RouterModelReportDataOrBuilder getRouterModelReportOrBuilder() {
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r8 = this.routerModelReportBuilder_;
            if (r8 != null) goto L5;
            RouterModelReportData r10 = this.routerModelReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return RouterModelReportData.getDefaultInstance();
        L5:
            return (RouterModelReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public StartScanDailyReportData getStartScanDailyReport() {
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r8 = this.startScanDailyReportBuilder_;
            if (r8 != null) goto L9;
            StartScanDailyReportData r10 = this.startScanDailyReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return StartScanDailyReportData.getDefaultInstance();
        L9:
            return (StartScanDailyReportData) r8.getMessage();
        }

        public StartScanDailyReportData.Builder getStartScanDailyReportBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (StartScanDailyReportData.Builder) getStartScanDailyReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public StartScanDailyReportDataOrBuilder getStartScanDailyReportOrBuilder() {
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r8 = this.startScanDailyReportBuilder_;
            if (r8 != null) goto L5;
            StartScanDailyReportData r10 = this.startScanDailyReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return StartScanDailyReportData.getDefaultInstance();
        L5:
            return (StartScanDailyReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public WakePacketReportData getWakePacketReport() {
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r8 = this.wakePacketReportBuilder_;
            if (r8 != null) goto L9;
            WakePacketReportData r10 = this.wakePacketReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return WakePacketReportData.getDefaultInstance();
        L9:
            return (WakePacketReportData) r8.getMessage();
        }

        public WakePacketReportData.Builder getWakePacketReportBuilder() {
            this.bitField0_ |= 512;
            onChanged();
            return (WakePacketReportData.Builder) getWakePacketReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public WakePacketReportDataOrBuilder getWakePacketReportOrBuilder() {
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r8 = this.wakePacketReportBuilder_;
            if (r8 != null) goto L5;
            WakePacketReportData r10 = this.wakePacketReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return WakePacketReportData.getDefaultInstance();
        L5:
            return (WakePacketReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public WlanCrashReportData getWlanCrashReport() {
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r8 = this.wlanCrashReportBuilder_;
            if (r8 != null) goto L9;
            WlanCrashReportData r10 = this.wlanCrashReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return WlanCrashReportData.getDefaultInstance();
        L9:
            return (WlanCrashReportData) r8.getMessage();
        }

        public WlanCrashReportData.Builder getWlanCrashReportBuilder() {
            this.bitField0_ |= 256;
            onChanged();
            return (WlanCrashReportData.Builder) getWlanCrashReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public WlanCrashReportDataOrBuilder getWlanCrashReportOrBuilder() {
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r8 = this.wlanCrashReportBuilder_;
            if (r8 != null) goto L5;
            WlanCrashReportData r10 = this.wlanCrashReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return WlanCrashReportData.getDefaultInstance();
        L5:
            return (WlanCrashReportDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasConnectionTimeReport() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasLinkLayerQualityReport() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasMloLinkLayerQualityReport() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasNetworkQualityStatusReport() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasPoorLinkDisconnectReport() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasPowerStatsReport() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasRoamSuccessReport() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasRouterModelReport() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasStartScanDailyReport() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasWakePacketReport() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
        public boolean hasWlanCrashReport() {
            if ((this.bitField0_ & 256) == 0) goto L5;
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

        public Builder mergeConnectionTimeReport(ConnectionTimeReportData r8) {
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r10 = this.connectionTimeReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            ConnectionTimeReportData r11 = this.connectionTimeReport_;
            if (r11 == null) goto L11;
            if (r11 == ConnectionTimeReportData.getDefaultInstance()) goto L11;
            getConnectionTimeReportBuilder().mergeFrom(r8);
        L11:
            this.connectionTimeReport_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeLinkLayerQualityReport(LinkLayerQualityReportData r8) {
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r10 = this.linkLayerQualityReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            LinkLayerQualityReportData r11 = this.linkLayerQualityReport_;
            if (r11 == null) goto L11;
            if (r11 == LinkLayerQualityReportData.getDefaultInstance()) goto L11;
            getLinkLayerQualityReportBuilder().mergeFrom(r8);
        L11:
            this.linkLayerQualityReport_ = r8;
            goto L13
        }

        public Builder mergeMloLinkLayerQualityReport(MloLinkLayerQualityReportData r8) {
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r10 = this.mloLinkLayerQualityReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L11;
            MloLinkLayerQualityReportData r11 = this.mloLinkLayerQualityReport_;
            if (r11 == null) goto L11;
            if (r11 == MloLinkLayerQualityReportData.getDefaultInstance()) goto L11;
            getMloLinkLayerQualityReportBuilder().mergeFrom(r8);
        L11:
            this.mloLinkLayerQualityReport_ = r8;
            goto L13
        }

        public Builder mergeNetworkQualityStatusReport(NetworkQualityStatusReportData r8) {
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r10 = this.networkQualityStatusReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            NetworkQualityStatusReportData r11 = this.networkQualityStatusReport_;
            if (r11 == null) goto L11;
            if (r11 == NetworkQualityStatusReportData.getDefaultInstance()) goto L11;
            getNetworkQualityStatusReportBuilder().mergeFrom(r8);
        L11:
            this.networkQualityStatusReport_ = r8;
            goto L13
        }

        public Builder mergePoorLinkDisconnectReport(PoorLinkDisconnectReportData r8) {
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r10 = this.poorLinkDisconnectReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1024) == 0) goto L11;
            PoorLinkDisconnectReportData r11 = this.poorLinkDisconnectReport_;
            if (r11 == null) goto L11;
            if (r11 == PoorLinkDisconnectReportData.getDefaultInstance()) goto L11;
            getPoorLinkDisconnectReportBuilder().mergeFrom(r8);
        L11:
            this.poorLinkDisconnectReport_ = r8;
            goto L13
        }

        public Builder mergePowerStatsReport(PowerStatsReportData r8) {
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r10 = this.powerStatsReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L11;
            PowerStatsReportData r11 = this.powerStatsReport_;
            if (r11 == null) goto L11;
            if (r11 == PowerStatsReportData.getDefaultInstance()) goto L11;
            getPowerStatsReportBuilder().mergeFrom(r8);
        L11:
            this.powerStatsReport_ = r8;
            goto L13
        }

        public Builder mergeRoamSuccessReport(RoamSuccessReportData r8) {
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r10 = this.roamSuccessReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 64) == 0) goto L11;
            RoamSuccessReportData r11 = this.roamSuccessReport_;
            if (r11 == null) goto L11;
            if (r11 == RoamSuccessReportData.getDefaultInstance()) goto L11;
            getRoamSuccessReportBuilder().mergeFrom(r8);
        L11:
            this.roamSuccessReport_ = r8;
            goto L13
        }

        public Builder mergeRouterModelReport(RouterModelReportData r8) {
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r10 = this.routerModelReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L11;
            RouterModelReportData r11 = this.routerModelReport_;
            if (r11 == null) goto L11;
            if (r11 == RouterModelReportData.getDefaultInstance()) goto L11;
            getRouterModelReportBuilder().mergeFrom(r8);
        L11:
            this.routerModelReport_ = r8;
            goto L13
        }

        public Builder mergeStartScanDailyReport(StartScanDailyReportData r8) {
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r10 = this.startScanDailyReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L11;
            StartScanDailyReportData r11 = this.startScanDailyReport_;
            if (r11 == null) goto L11;
            if (r11 == StartScanDailyReportData.getDefaultInstance()) goto L11;
            getStartScanDailyReportBuilder().mergeFrom(r8);
        L11:
            this.startScanDailyReport_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder mergeWakePacketReport(WakePacketReportData r8) {
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r10 = this.wakePacketReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 512) == 0) goto L11;
            WakePacketReportData r11 = this.wakePacketReport_;
            if (r11 == null) goto L11;
            if (r11 == WakePacketReportData.getDefaultInstance()) goto L11;
            getWakePacketReportBuilder().mergeFrom(r8);
        L11:
            this.wakePacketReport_ = r8;
            goto L13
        }

        public Builder mergeWlanCrashReport(WlanCrashReportData r8) {
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r10 = this.wlanCrashReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 256) == 0) goto L11;
            WlanCrashReportData r11 = this.wlanCrashReport_;
            if (r11 == null) goto L11;
            if (r11 == WlanCrashReportData.getDefaultInstance()) goto L11;
            getWlanCrashReportBuilder().mergeFrom(r8);
        L11:
            this.wlanCrashReport_ = r8;
            goto L13
        }

        public Builder setConnectionTimeReport(ConnectionTimeReportData.Builder r8) {
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r10 = this.connectionTimeReportBuilder_;
            ConnectionTimeReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.connectionTimeReport_ = r11;
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

        public Builder setLinkLayerQualityReport(LinkLayerQualityReportData.Builder r8) {
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r10 = this.linkLayerQualityReportBuilder_;
            LinkLayerQualityReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.linkLayerQualityReport_ = r11;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setMloLinkLayerQualityReport(MloLinkLayerQualityReportData.Builder r8) {
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r10 = this.mloLinkLayerQualityReportBuilder_;
            MloLinkLayerQualityReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.mloLinkLayerQualityReport_ = r11;
        L6:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNetworkQualityStatusReport(NetworkQualityStatusReportData.Builder r8) {
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r10 = this.networkQualityStatusReportBuilder_;
            NetworkQualityStatusReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkQualityStatusReport_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setPoorLinkDisconnectReport(PoorLinkDisconnectReportData.Builder r8) {
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r10 = this.poorLinkDisconnectReportBuilder_;
            PoorLinkDisconnectReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.poorLinkDisconnectReport_ = r11;
        L6:
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setPowerStatsReport(PowerStatsReportData.Builder r8) {
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r10 = this.powerStatsReportBuilder_;
            PowerStatsReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.powerStatsReport_ = r11;
        L6:
            this.bitField0_ |= 4;
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

        public Builder setRoamSuccessReport(RoamSuccessReportData.Builder r8) {
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r10 = this.roamSuccessReportBuilder_;
            RoamSuccessReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.roamSuccessReport_ = r11;
        L6:
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setRouterModelReport(RouterModelReportData.Builder r8) {
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r10 = this.routerModelReportBuilder_;
            RouterModelReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.routerModelReport_ = r11;
        L6:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setStartScanDailyReport(StartScanDailyReportData.Builder r8) {
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r10 = this.startScanDailyReportBuilder_;
            StartScanDailyReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.startScanDailyReport_ = r11;
        L6:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWakePacketReport(WakePacketReportData.Builder r8) {
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r10 = this.wakePacketReportBuilder_;
            WakePacketReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.wakePacketReport_ = r11;
        L6:
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setWlanCrashReport(WlanCrashReportData.Builder r8) {
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r10 = this.wlanCrashReportBuilder_;
            WlanCrashReportData r11 = r8.build();
            if (r10 != null) goto L5;
            this.wlanCrashReport_ = r11;
        L6:
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeWifiServiceProtoData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setConnectionTimeReport(ConnectionTimeReportData r8) {
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r10 = this.connectionTimeReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.connectionTimeReport_ = r8;
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

        public Builder setLinkLayerQualityReport(LinkLayerQualityReportData r8) {
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r10 = this.linkLayerQualityReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.linkLayerQualityReport_ = r8;
        L9:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setMloLinkLayerQualityReport(MloLinkLayerQualityReportData r8) {
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r10 = this.mloLinkLayerQualityReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.mloLinkLayerQualityReport_ = r8;
        L9:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setNetworkQualityStatusReport(NetworkQualityStatusReportData r8) {
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r10 = this.networkQualityStatusReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkQualityStatusReport_ = r8;
        L9:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setPoorLinkDisconnectReport(PoorLinkDisconnectReportData r8) {
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r10 = this.poorLinkDisconnectReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.poorLinkDisconnectReport_ = r8;
        L9:
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setPowerStatsReport(PowerStatsReportData r8) {
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r10 = this.powerStatsReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.powerStatsReport_ = r8;
        L9:
            this.bitField0_ |= 4;
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

        public Builder setRoamSuccessReport(RoamSuccessReportData r8) {
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r10 = this.roamSuccessReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.roamSuccessReport_ = r8;
        L9:
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setRouterModelReport(RouterModelReportData r8) {
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r10 = this.routerModelReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.routerModelReport_ = r8;
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

        public Builder setStartScanDailyReport(StartScanDailyReportData r8) {
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r10 = this.startScanDailyReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.startScanDailyReport_ = r8;
        L9:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWakePacketReport(WakePacketReportData r8) {
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r10 = this.wakePacketReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.wakePacketReport_ = r8;
        L9:
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setWlanCrashReport(WlanCrashReportData r8) {
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r10 = this.wlanCrashReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.wlanCrashReport_ = r8;
        L9:
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeWifiServiceProtoData build() {
            CaeWifiServiceProtoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeWifiServiceProtoData buildPartial() {
            CaeWifiServiceProtoData r8 = new CaeWifiServiceProtoData(this, null);
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
        public CaeWifiServiceProtoData getDefaultInstanceForType() {
            return CaeWifiServiceProtoData.getDefaultInstance();
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
            this.routerModelReport_ = null;
            SingleFieldBuilderV3<RouterModelReportData, RouterModelReportData.Builder, RouterModelReportDataOrBuilder> r8 = this.routerModelReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.routerModelReportBuilder_ = null;
        L5:
            this.connectionTimeReport_ = null;
            SingleFieldBuilderV3<ConnectionTimeReportData, ConnectionTimeReportData.Builder, ConnectionTimeReportDataOrBuilder> r10 = this.connectionTimeReportBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.connectionTimeReportBuilder_ = null;
        L8:
            this.powerStatsReport_ = null;
            SingleFieldBuilderV3<PowerStatsReportData, PowerStatsReportData.Builder, PowerStatsReportDataOrBuilder> r11 = this.powerStatsReportBuilder_;
            if (r11 == null) goto L11;
            r11.dispose();
            this.powerStatsReportBuilder_ = null;
        L11:
            this.networkQualityStatusReport_ = null;
            SingleFieldBuilderV3<NetworkQualityStatusReportData, NetworkQualityStatusReportData.Builder, NetworkQualityStatusReportDataOrBuilder> r12 = this.networkQualityStatusReportBuilder_;
            if (r12 == null) goto L14;
            r12.dispose();
            this.networkQualityStatusReportBuilder_ = null;
        L14:
            this.linkLayerQualityReport_ = null;
            SingleFieldBuilderV3<LinkLayerQualityReportData, LinkLayerQualityReportData.Builder, LinkLayerQualityReportDataOrBuilder> r13 = this.linkLayerQualityReportBuilder_;
            if (r13 == null) goto L17;
            r13.dispose();
            this.linkLayerQualityReportBuilder_ = null;
        L17:
            this.mloLinkLayerQualityReport_ = null;
            SingleFieldBuilderV3<MloLinkLayerQualityReportData, MloLinkLayerQualityReportData.Builder, MloLinkLayerQualityReportDataOrBuilder> r14 = this.mloLinkLayerQualityReportBuilder_;
            if (r14 == null) goto L20;
            r14.dispose();
            this.mloLinkLayerQualityReportBuilder_ = null;
        L20:
            this.roamSuccessReport_ = null;
            SingleFieldBuilderV3<RoamSuccessReportData, RoamSuccessReportData.Builder, RoamSuccessReportDataOrBuilder> r15 = this.roamSuccessReportBuilder_;
            if (r15 == null) goto L23;
            r15.dispose();
            this.roamSuccessReportBuilder_ = null;
        L23:
            this.startScanDailyReport_ = null;
            SingleFieldBuilderV3<StartScanDailyReportData, StartScanDailyReportData.Builder, StartScanDailyReportDataOrBuilder> r16 = this.startScanDailyReportBuilder_;
            if (r16 == null) goto L26;
            r16.dispose();
            this.startScanDailyReportBuilder_ = null;
        L26:
            this.wlanCrashReport_ = null;
            SingleFieldBuilderV3<WlanCrashReportData, WlanCrashReportData.Builder, WlanCrashReportDataOrBuilder> r17 = this.wlanCrashReportBuilder_;
            if (r17 == null) goto L29;
            r17.dispose();
            this.wlanCrashReportBuilder_ = null;
        L29:
            this.wakePacketReport_ = null;
            SingleFieldBuilderV3<WakePacketReportData, WakePacketReportData.Builder, WakePacketReportDataOrBuilder> r18 = this.wakePacketReportBuilder_;
            if (r18 == null) goto L32;
            r18.dispose();
            this.wakePacketReportBuilder_ = null;
        L32:
            this.poorLinkDisconnectReport_ = null;
            SingleFieldBuilderV3<PoorLinkDisconnectReportData, PoorLinkDisconnectReportData.Builder, PoorLinkDisconnectReportDataOrBuilder> r19 = this.poorLinkDisconnectReportBuilder_;
            if (r19 == null) goto L35;
            r19.dispose();
            this.poorLinkDisconnectReportBuilder_ = null;
        L35:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L33;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L30;
            int r12 = r8.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            switch(r12) {
                case 0: goto L20;
                case 10: goto L18;
                case 18: goto L17;
                case 26: goto L16;
                case 34: goto L15;
                case 42: goto L14;
                case 50: goto L13;
                case 58: goto L12;
                case 66: goto L11;
                case 74: goto L10;
                case 82: goto L9;
                case 90: goto L8;
                default: goto L21;
            };     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
        L8:
            r8.readMessage(getPoorLinkDisconnectReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 1024;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L9:
            r8.readMessage(getWakePacketReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 512;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L10:
            r8.readMessage(getWlanCrashReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 256;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L11:
            r8.readMessage(getStartScanDailyReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 128;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L12:
            r8.readMessage(getRoamSuccessReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 64;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L13:
            r8.readMessage(getMloLinkLayerQualityReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 32;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L14:
            r8.readMessage(getLinkLayerQualityReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 16;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L15:
            r8.readMessage(getNetworkQualityStatusReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 8;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L16:
            r8.readMessage(getPowerStatsReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 4;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L17:
            r8.readMessage(getConnectionTimeReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            goto L4
        L18:
            r8.readMessage(getRouterModelReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
            this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
        L20:
            r11 = true;
            goto L4
        L21:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L25:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            onChanged();
            throw th;
        L30:
            onChanged();
            return this;
        L33:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CaeWifiServiceProtoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeWifiServiceProtoData) r8);
        }

        public Builder mergeFrom(CaeWifiServiceProtoData r8) {
            if (r8 != CaeWifiServiceProtoData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasRouterModelReport() == false) goto L9;
            mergeRouterModelReport(r8.getRouterModelReport());
        L9:
            if (r8.hasConnectionTimeReport() == false) goto L12;
            mergeConnectionTimeReport(r8.getConnectionTimeReport());
        L12:
            if (r8.hasPowerStatsReport() == false) goto L15;
            mergePowerStatsReport(r8.getPowerStatsReport());
        L15:
            if (r8.hasNetworkQualityStatusReport() == false) goto L18;
            mergeNetworkQualityStatusReport(r8.getNetworkQualityStatusReport());
        L18:
            if (r8.hasLinkLayerQualityReport() == false) goto L21;
            mergeLinkLayerQualityReport(r8.getLinkLayerQualityReport());
        L21:
            if (r8.hasMloLinkLayerQualityReport() == false) goto L24;
            mergeMloLinkLayerQualityReport(r8.getMloLinkLayerQualityReport());
        L24:
            if (r8.hasRoamSuccessReport() == false) goto L27;
            mergeRoamSuccessReport(r8.getRoamSuccessReport());
        L27:
            if (r8.hasStartScanDailyReport() == false) goto L30;
            mergeStartScanDailyReport(r8.getStartScanDailyReport());
        L30:
            if (r8.hasWlanCrashReport() == false) goto L33;
            mergeWlanCrashReport(r8.getWlanCrashReport());
        L33:
            if (r8.hasWakePacketReport() == false) goto L36;
            mergeWakePacketReport(r8.getWakePacketReport());
        L36:
            if (r8.hasPoorLinkDisconnectReport() == false) goto L38;
            mergePoorLinkDisconnectReport(r8.getPoorLinkDisconnectReport());
        L38:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeWifiServiceProtoData();
        PARSER = new AnonymousClass1();
    }

    private CaeWifiServiceProtoData() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ RoamSuccessReportData access$1002(CaeWifiServiceProtoData r8, RoamSuccessReportData r10) {
        r8.roamSuccessReport_ = r10;
        return r10;
    }

    public static /* synthetic */ StartScanDailyReportData access$1102(CaeWifiServiceProtoData r8, StartScanDailyReportData r10) {
        r8.startScanDailyReport_ = r10;
        return r10;
    }

    public static /* synthetic */ WlanCrashReportData access$1202(CaeWifiServiceProtoData r8, WlanCrashReportData r10) {
        r8.wlanCrashReport_ = r10;
        return r10;
    }

    public static /* synthetic */ WakePacketReportData access$1302(CaeWifiServiceProtoData r8, WakePacketReportData r10) {
        r8.wakePacketReport_ = r10;
        return r10;
    }

    public static /* synthetic */ PoorLinkDisconnectReportData access$1402(CaeWifiServiceProtoData r8, PoorLinkDisconnectReportData r10) {
        r8.poorLinkDisconnectReport_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(CaeWifiServiceProtoData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ RouterModelReportData access$402(CaeWifiServiceProtoData r8, RouterModelReportData r10) {
        r8.routerModelReport_ = r10;
        return r10;
    }

    public static /* synthetic */ ConnectionTimeReportData access$502(CaeWifiServiceProtoData r8, ConnectionTimeReportData r10) {
        r8.connectionTimeReport_ = r10;
        return r10;
    }

    public static /* synthetic */ PowerStatsReportData access$602(CaeWifiServiceProtoData r8, PowerStatsReportData r10) {
        r8.powerStatsReport_ = r10;
        return r10;
    }

    public static /* synthetic */ NetworkQualityStatusReportData access$702(CaeWifiServiceProtoData r8, NetworkQualityStatusReportData r10) {
        r8.networkQualityStatusReport_ = r10;
        return r10;
    }

    public static /* synthetic */ LinkLayerQualityReportData access$802(CaeWifiServiceProtoData r8, LinkLayerQualityReportData r10) {
        r8.linkLayerQualityReport_ = r10;
        return r10;
    }

    public static /* synthetic */ MloLinkLayerQualityReportData access$902(CaeWifiServiceProtoData r8, MloLinkLayerQualityReportData r10) {
        r8.mloLinkLayerQualityReport_ = r10;
        return r10;
    }

    public static CaeWifiServiceProtoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProtoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeWifiServiceProtoData parseDelimitedFrom(InputStream r8) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeWifiServiceProtoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeWifiServiceProtoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeWifiServiceProtoData) == false) goto L8;
        CaeWifiServiceProtoData r10 = (CaeWifiServiceProtoData) r8;
        if (hasRouterModelReport() == r10.hasRouterModelReport()) goto L13;
        return false;
    L13:
        if (hasRouterModelReport() == false) goto L18;
        if (getRouterModelReport().equals(r10.getRouterModelReport()) == true) goto L18;
        return false;
    L18:
        if (hasConnectionTimeReport() == r10.hasConnectionTimeReport()) goto L21;
        return false;
    L21:
        if (hasConnectionTimeReport() == false) goto L26;
        if (getConnectionTimeReport().equals(r10.getConnectionTimeReport()) == true) goto L26;
        return false;
    L26:
        if (hasPowerStatsReport() == r10.hasPowerStatsReport()) goto L29;
        return false;
    L29:
        if (hasPowerStatsReport() == false) goto L34;
        if (getPowerStatsReport().equals(r10.getPowerStatsReport()) == true) goto L34;
        return false;
    L34:
        if (hasNetworkQualityStatusReport() == r10.hasNetworkQualityStatusReport()) goto L37;
        return false;
    L37:
        if (hasNetworkQualityStatusReport() == false) goto L42;
        if (getNetworkQualityStatusReport().equals(r10.getNetworkQualityStatusReport()) == true) goto L42;
        return false;
    L42:
        if (hasLinkLayerQualityReport() == r10.hasLinkLayerQualityReport()) goto L45;
        return false;
    L45:
        if (hasLinkLayerQualityReport() == false) goto L50;
        if (getLinkLayerQualityReport().equals(r10.getLinkLayerQualityReport()) == true) goto L50;
        return false;
    L50:
        if (hasMloLinkLayerQualityReport() == r10.hasMloLinkLayerQualityReport()) goto L53;
        return false;
    L53:
        if (hasMloLinkLayerQualityReport() == false) goto L58;
        if (getMloLinkLayerQualityReport().equals(r10.getMloLinkLayerQualityReport()) == true) goto L58;
        return false;
    L58:
        if (hasRoamSuccessReport() == r10.hasRoamSuccessReport()) goto L61;
        return false;
    L61:
        if (hasRoamSuccessReport() == false) goto L66;
        if (getRoamSuccessReport().equals(r10.getRoamSuccessReport()) == true) goto L66;
        return false;
    L66:
        if (hasStartScanDailyReport() == r10.hasStartScanDailyReport()) goto L69;
        return false;
    L69:
        if (hasStartScanDailyReport() == false) goto L74;
        if (getStartScanDailyReport().equals(r10.getStartScanDailyReport()) == true) goto L74;
        return false;
    L74:
        if (hasWlanCrashReport() == r10.hasWlanCrashReport()) goto L77;
        return false;
    L77:
        if (hasWlanCrashReport() == false) goto L82;
        if (getWlanCrashReport().equals(r10.getWlanCrashReport()) == true) goto L82;
        return false;
    L82:
        if (hasWakePacketReport() == r10.hasWakePacketReport()) goto L85;
        return false;
    L85:
        if (hasWakePacketReport() == false) goto L90;
        if (getWakePacketReport().equals(r10.getWakePacketReport()) == true) goto L90;
        return false;
    L90:
        if (hasPoorLinkDisconnectReport() == r10.hasPoorLinkDisconnectReport()) goto L93;
        return false;
    L93:
        if (hasPoorLinkDisconnectReport() == false) goto L98;
        if (getPoorLinkDisconnectReport().equals(r10.getPoorLinkDisconnectReport()) == true) goto L98;
        return false;
    L98:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L100;
        return false;
    L100:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public ConnectionTimeReportData getConnectionTimeReport() {
        ConnectionTimeReportData r8 = this.connectionTimeReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return ConnectionTimeReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public ConnectionTimeReportDataOrBuilder getConnectionTimeReportOrBuilder() {
        ConnectionTimeReportData r8 = this.connectionTimeReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return ConnectionTimeReportData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public LinkLayerQualityReportData getLinkLayerQualityReport() {
        LinkLayerQualityReportData r8 = this.linkLayerQualityReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return LinkLayerQualityReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public LinkLayerQualityReportDataOrBuilder getLinkLayerQualityReportOrBuilder() {
        LinkLayerQualityReportData r8 = this.linkLayerQualityReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return LinkLayerQualityReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public MloLinkLayerQualityReportData getMloLinkLayerQualityReport() {
        MloLinkLayerQualityReportData r8 = this.mloLinkLayerQualityReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return MloLinkLayerQualityReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public MloLinkLayerQualityReportDataOrBuilder getMloLinkLayerQualityReportOrBuilder() {
        MloLinkLayerQualityReportData r8 = this.mloLinkLayerQualityReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return MloLinkLayerQualityReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public NetworkQualityStatusReportData getNetworkQualityStatusReport() {
        NetworkQualityStatusReportData r8 = this.networkQualityStatusReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkQualityStatusReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public NetworkQualityStatusReportDataOrBuilder getNetworkQualityStatusReportOrBuilder() {
        NetworkQualityStatusReportData r8 = this.networkQualityStatusReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkQualityStatusReportData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeWifiServiceProtoData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public PoorLinkDisconnectReportData getPoorLinkDisconnectReport() {
        PoorLinkDisconnectReportData r8 = this.poorLinkDisconnectReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return PoorLinkDisconnectReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public PoorLinkDisconnectReportDataOrBuilder getPoorLinkDisconnectReportOrBuilder() {
        PoorLinkDisconnectReportData r8 = this.poorLinkDisconnectReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return PoorLinkDisconnectReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public PowerStatsReportData getPowerStatsReport() {
        PowerStatsReportData r8 = this.powerStatsReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return PowerStatsReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public PowerStatsReportDataOrBuilder getPowerStatsReportOrBuilder() {
        PowerStatsReportData r8 = this.powerStatsReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return PowerStatsReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public RoamSuccessReportData getRoamSuccessReport() {
        RoamSuccessReportData r8 = this.roamSuccessReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return RoamSuccessReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public RoamSuccessReportDataOrBuilder getRoamSuccessReportOrBuilder() {
        RoamSuccessReportData r8 = this.roamSuccessReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return RoamSuccessReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public RouterModelReportData getRouterModelReport() {
        RouterModelReportData r8 = this.routerModelReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return RouterModelReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public RouterModelReportDataOrBuilder getRouterModelReportOrBuilder() {
        RouterModelReportData r8 = this.routerModelReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return RouterModelReportData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeMessageSize(1, getRouterModelReport());
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getConnectionTimeReport());
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeMessageSize(3, getPowerStatsReport());
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeMessageSize(4, getNetworkQualityStatusReport());
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeMessageSize(5, getLinkLayerQualityReport());
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeMessageSize(6, getMloLinkLayerQualityReport());
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeMessageSize(7, getRoamSuccessReport());
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeMessageSize(8, getStartScanDailyReport());
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeMessageSize(9, getWlanCrashReport());
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeMessageSize(10, getWakePacketReport());
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L38;
        r10 = r10 + CodedOutputStream.computeMessageSize(11, getPoorLinkDisconnectReport());
    L38:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public StartScanDailyReportData getStartScanDailyReport() {
        StartScanDailyReportData r8 = this.startScanDailyReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return StartScanDailyReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public StartScanDailyReportDataOrBuilder getStartScanDailyReportOrBuilder() {
        StartScanDailyReportData r8 = this.startScanDailyReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return StartScanDailyReportData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public WakePacketReportData getWakePacketReport() {
        WakePacketReportData r8 = this.wakePacketReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WakePacketReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public WakePacketReportDataOrBuilder getWakePacketReportOrBuilder() {
        WakePacketReportData r8 = this.wakePacketReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WakePacketReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public WlanCrashReportData getWlanCrashReport() {
        WlanCrashReportData r8 = this.wlanCrashReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WlanCrashReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public WlanCrashReportDataOrBuilder getWlanCrashReportOrBuilder() {
        WlanCrashReportData r8 = this.wlanCrashReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return WlanCrashReportData.getDefaultInstance();
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasConnectionTimeReport() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasLinkLayerQualityReport() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasMloLinkLayerQualityReport() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasNetworkQualityStatusReport() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasPoorLinkDisconnectReport() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasPowerStatsReport() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasRoamSuccessReport() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasRouterModelReport() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasStartScanDailyReport() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasWakePacketReport() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.CaeWifiServiceProtoDataOrBuilder
    public boolean hasWlanCrashReport() {
        if ((this.bitField0_ & 256) == 0) goto L5;
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
        if (hasRouterModelReport() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getRouterModelReport().hashCode();
    L9:
        if (hasConnectionTimeReport() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getConnectionTimeReport().hashCode();
    L12:
        if (hasPowerStatsReport() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getPowerStatsReport().hashCode();
    L15:
        if (hasNetworkQualityStatusReport() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getNetworkQualityStatusReport().hashCode();
    L18:
        if (hasLinkLayerQualityReport() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getLinkLayerQualityReport().hashCode();
    L21:
        if (hasMloLinkLayerQualityReport() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getMloLinkLayerQualityReport().hashCode();
    L24:
        if (hasRoamSuccessReport() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getRoamSuccessReport().hashCode();
    L27:
        if (hasStartScanDailyReport() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getStartScanDailyReport().hashCode();
    L30:
        if (hasWlanCrashReport() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getWlanCrashReport().hashCode();
    L33:
        if (hasWakePacketReport() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getWakePacketReport().hashCode();
    L36:
        if (hasPoorLinkDisconnectReport() == false) goto L38;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getPoorLinkDisconnectReport().hashCode();
    L38:
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
        return new CaeWifiServiceProtoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeMessage(1, getRouterModelReport());
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeMessage(2, getConnectionTimeReport());
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeMessage(3, getPowerStatsReport());
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeMessage(4, getNetworkQualityStatusReport());
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeMessage(5, getLinkLayerQualityReport());
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeMessage(6, getMloLinkLayerQualityReport());
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeMessage(7, getRoamSuccessReport());
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeMessage(8, getStartScanDailyReport());
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeMessage(9, getWlanCrashReport());
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeMessage(10, getWakePacketReport());
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L35;
        r8.writeMessage(11, getPoorLinkDisconnectReport());
    L35:
        getUnknownFields().writeTo(r8);
    }

    private CaeWifiServiceProtoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeWifiServiceProtoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeWifiServiceProtoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeWifiServiceProtoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_CaeWifiServiceProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeWifiServiceProtoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeWifiServiceProtoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeWifiServiceProtoData parseFrom(CodedInputStream r8) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeWifiServiceProtoData getDefaultInstanceForType() {
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

    public static CaeWifiServiceProtoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeWifiServiceProtoData parseFrom(InputStream r8) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeWifiServiceProtoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeWifiServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeWifiServiceProtoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeWifiServiceProtoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeWifiServiceProtoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeWifiServiceProtoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
