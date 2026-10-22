package com.obric.cae.network;

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

/* JADX INFO: loaded from: classes.dex */
public final class NetworkDetectData extends GeneratedMessageV3 implements NetworkDetectDataOrBuilder {
    public static final int CELL_RSRP_FIELD_NUMBER = 18;
    public static final int CELL_SINR_FIELD_NUMBER = 19;
    public static final int CELL_TYPE_FIELD_NUMBER = 17;
    public static final int CONNECT_TIME_MS_FIELD_NUMBER = 10;
    private static final NetworkDetectData DEFAULT_INSTANCE = null;
    public static final int DETECT_RESULT_FIELD_NUMBER = 4;
    public static final int DETECT_RTT_FIELD_NUMBER = 6;
    public static final int DETECT_SCENE_FIELD_NUMBER = 2;
    public static final int DNS_TIME_MS_FIELD_NUMBER = 9;
    public static final int ERROR_CODE_FIELD_NUMBER = 7;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 3;

    @Deprecated
    public static final Parser<NetworkDetectData> PARSER = null;
    public static final int REDIRECT_URL_FIELD_NUMBER = 8;
    public static final int RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int TLS_TIME_MS_FIELD_NUMBER = 11;
    public static final int TOTAL_TIME_MS_FIELD_NUMBER = 13;
    public static final int TTFB_DURATION_MS_FIELD_NUMBER = 12;
    public static final int WIFI_FREQ_FIELD_NUMBER = 16;
    public static final int WIFI_RSSI_FIELD_NUMBER = 15;
    public static final int WIFI_SSID_FIELD_NUMBER = 14;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cellRsrp_;
    private int cellSinr_;
    private int cellType_;
    private int connectTimeMs_;
    private int detectResult_;
    private int detectRtt_;
    private int detectScene_;
    private int dnsTimeMs_;
    private int errorCode_;
    private byte memoizedIsInitialized;
    private int networkType_;
    private volatile Object redirectUrl_;
    private int responseCode_;
    private long timestamp_;
    private int tlsTimeMs_;
    private int totalTimeMs_;
    private int ttfbDurationMs_;
    private int wifiFreq_;
    private int wifiRssi_;
    private volatile Object wifiSsid_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NetworkDetectDataOrBuilder {
        private int bitField0_;
        private int cellRsrp_;
        private int cellSinr_;
        private int cellType_;
        private int connectTimeMs_;
        private int detectResult_;
        private int detectRtt_;
        private int detectScene_;
        private int dnsTimeMs_;
        private int errorCode_;
        private int networkType_;
        private Object redirectUrl_;
        private int responseCode_;
        private long timestamp_;
        private int tlsTimeMs_;
        private int totalTimeMs_;
        private int ttfbDurationMs_;
        private int wifiFreq_;
        private int wifiRssi_;
        private Object wifiSsid_;

        private Builder() {
            this.redirectUrl_ = "";
            this.wifiSsid_ = "";
        }

        private void buildPartial0(NetworkDetectData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            NetworkDetectData.access$302(r8, this.timestamp_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            NetworkDetectData.access$402(r8, this.detectScene_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            NetworkDetectData.access$502(r8, this.networkType_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            NetworkDetectData.access$602(r8, this.detectResult_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            NetworkDetectData.access$702(r8, this.responseCode_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            NetworkDetectData.access$802(r8, this.detectRtt_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            NetworkDetectData.access$902(r8, this.errorCode_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            NetworkDetectData.access$1002(r8, this.redirectUrl_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            NetworkDetectData.access$1102(r8, this.dnsTimeMs_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            NetworkDetectData.access$1202(r8, this.connectTimeMs_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            NetworkDetectData.access$1302(r8, this.tlsTimeMs_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            NetworkDetectData.access$1402(r8, this.ttfbDurationMs_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            NetworkDetectData.access$1502(r8, this.totalTimeMs_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            NetworkDetectData.access$1602(r8, this.wifiSsid_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            NetworkDetectData.access$1702(r8, this.wifiRssi_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            NetworkDetectData.access$1802(r8, this.wifiFreq_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            NetworkDetectData.access$1902(r8, this.cellType_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            NetworkDetectData.access$2002(r8, this.cellRsrp_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L60;
            NetworkDetectData.access$2102(r8, this.cellSinr_);
            r11 = r11 | 262144;
        L60:
            NetworkDetectData.access$2276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkDetectData_descriptor;
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

        public Builder clearCellRsrp() {
            this.bitField0_ &= -131073;
            this.cellRsrp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCellSinr() {
            this.bitField0_ &= -262145;
            this.cellSinr_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCellType() {
            this.bitField0_ &= -65537;
            this.cellType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearConnectTimeMs() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.connectTimeMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDetectResult() {
            this.bitField0_ &= -9;
            this.detectResult_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDetectRtt() {
            this.bitField0_ &= -33;
            this.detectRtt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDetectScene() {
            this.bitField0_ &= -3;
            this.detectScene_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDnsTimeMs() {
            this.bitField0_ &= -257;
            this.dnsTimeMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearErrorCode() {
            this.bitField0_ &= -65;
            this.errorCode_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearNetworkType() {
            this.bitField0_ &= -5;
            this.networkType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRedirectUrl() {
            this.redirectUrl_ = NetworkDetectData.getDefaultInstance().getRedirectUrl();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearResponseCode() {
            this.bitField0_ &= -17;
            this.responseCode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -2;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTlsTimeMs() {
            this.bitField0_ &= -1025;
            this.tlsTimeMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTimeMs() {
            this.bitField0_ &= -4097;
            this.totalTimeMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTtfbDurationMs() {
            this.bitField0_ &= -2049;
            this.ttfbDurationMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiFreq() {
            this.bitField0_ &= -32769;
            this.wifiFreq_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiRssi() {
            this.bitField0_ &= -16385;
            this.wifiRssi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiSsid() {
            this.wifiSsid_ = NetworkDetectData.getDefaultInstance().getWifiSsid();
            this.bitField0_ &= -8193;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getCellRsrp() {
            return this.cellRsrp_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getCellSinr() {
            return this.cellSinr_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getCellType() {
            return this.cellType_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getConnectTimeMs() {
            return this.connectTimeMs_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkDetectData_descriptor;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getDetectResult() {
            return this.detectResult_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getDetectRtt() {
            return this.detectRtt_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getDetectScene() {
            return this.detectScene_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getDnsTimeMs() {
            return this.dnsTimeMs_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getNetworkType() {
            return this.networkType_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public String getRedirectUrl() {
            Object r8 = this.redirectUrl_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.redirectUrl_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public ByteString getRedirectUrlBytes() {
            Object r8 = this.redirectUrl_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.redirectUrl_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getResponseCode() {
            return this.responseCode_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getTlsTimeMs() {
            return this.tlsTimeMs_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getTotalTimeMs() {
            return this.totalTimeMs_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getTtfbDurationMs() {
            return this.ttfbDurationMs_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getWifiFreq() {
            return this.wifiFreq_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public int getWifiRssi() {
            return this.wifiRssi_;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public String getWifiSsid() {
            Object r8 = this.wifiSsid_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wifiSsid_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public ByteString getWifiSsidBytes() {
            Object r8 = this.wifiSsid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifiSsid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasCellRsrp() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasCellSinr() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasCellType() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasConnectTimeMs() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasDetectResult() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasDetectRtt() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasDetectScene() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasDnsTimeMs() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasErrorCode() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasNetworkType() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasRedirectUrl() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasResponseCode() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasTlsTimeMs() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasTotalTimeMs() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasTtfbDurationMs() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasWifiFreq() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasWifiRssi() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
        public boolean hasWifiSsid() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
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

        public Builder setCellRsrp(int r8) {
            this.cellRsrp_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setCellSinr(int r8) {
            this.cellSinr_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setCellType(int r8) {
            this.cellType_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setConnectTimeMs(int r8) {
            this.connectTimeMs_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDetectResult(int r8) {
            this.detectResult_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setDetectRtt(int r8) {
            this.detectRtt_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setDetectScene(int r8) {
            this.detectScene_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDnsTimeMs(int r8) {
            this.dnsTimeMs_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setErrorCode(int r8) {
            this.errorCode_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNetworkType(int r8) {
            this.networkType_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setRedirectUrl(String r8) {
            if (r8 == null) goto L6;
            this.redirectUrl_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRedirectUrlBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.redirectUrl_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setResponseCode(int r8) {
            this.responseCode_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTlsTimeMs(int r8) {
            this.tlsTimeMs_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setTotalTimeMs(int r8) {
            this.totalTimeMs_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setTtfbDurationMs(int r8) {
            this.ttfbDurationMs_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiFreq(int r8) {
            this.wifiFreq_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setWifiRssi(int r8) {
            this.wifiRssi_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setWifiSsid(String r8) {
            if (r8 == null) goto L6;
            this.wifiSsid_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifiSsidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifiSsid_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.redirectUrl_ = "";
            this.wifiSsid_ = "";
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkDetectData_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkDetectData.class, Builder.class);
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
        public NetworkDetectData build() {
            NetworkDetectData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkDetectData buildPartial() {
            NetworkDetectData r8 = new NetworkDetectData(this, null);
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
        public NetworkDetectData getDefaultInstanceForType() {
            return NetworkDetectData.getDefaultInstance();
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
            this.timestamp_ = 0;
            this.detectScene_ = 0;
            this.networkType_ = 0;
            this.detectResult_ = 0;
            this.responseCode_ = 0;
            this.detectRtt_ = 0;
            this.errorCode_ = 0;
            this.redirectUrl_ = "";
            this.dnsTimeMs_ = 0;
            this.connectTimeMs_ = 0;
            this.tlsTimeMs_ = 0;
            this.ttfbDurationMs_ = 0;
            this.totalTimeMs_ = 0;
            this.wifiSsid_ = "";
            this.wifiRssi_ = 0;
            this.wifiFreq_ = 0;
            this.cellType_ = 0;
            this.cellRsrp_ = 0;
            this.cellSinr_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L41;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L38;
            int r12 = r8.readTag();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            switch(r12) {
                case 0: goto L28;
                case 8: goto L26;
                case 16: goto L25;
                case 24: goto L24;
                case 32: goto L23;
                case 40: goto L22;
                case 48: goto L21;
                case 56: goto L20;
                case 66: goto L19;
                case 72: goto L18;
                case 80: goto L17;
                case 88: goto L16;
                case 96: goto L15;
                case 104: goto L14;
                case 114: goto L13;
                case 120: goto L12;
                case 128: goto L11;
                case 136: goto L10;
                case 144: goto L9;
                case 152: goto L8;
                default: goto L29;
            };     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L8:
            this.cellSinr_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 262144;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L9:
            this.cellRsrp_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 131072;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L10:
            this.cellType_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 65536;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L11:
            this.wifiFreq_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 32768;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L12:
            this.wifiRssi_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 16384;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L13:
            this.wifiSsid_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 8192;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L14:
            this.totalTimeMs_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 4096;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L15:
            this.ttfbDurationMs_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 2048;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L16:
            this.tlsTimeMs_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1024;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L17:
            this.connectTimeMs_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 512;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L18:
            this.dnsTimeMs_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 256;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L19:
            this.redirectUrl_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 128;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L20:
            this.errorCode_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 64;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L21:
            this.detectRtt_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 32;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L22:
            this.responseCode_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 16;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L23:
            this.detectResult_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 8;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L24:
            this.networkType_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 4;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L25:
            this.detectScene_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 2;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L26:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L28:
            r11 = true;
            goto L4
        L29:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L33:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            onChanged();
            return this;
        L41:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof NetworkDetectData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NetworkDetectData) r8);
        }

        public Builder mergeFrom(NetworkDetectData r8) {
            if (r8 != NetworkDetectData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTimestamp() == false) goto L9;
            setTimestamp(r8.getTimestamp());
        L9:
            if (r8.hasDetectScene() == false) goto L12;
            setDetectScene(r8.getDetectScene());
        L12:
            if (r8.hasNetworkType() == false) goto L15;
            setNetworkType(r8.getNetworkType());
        L15:
            if (r8.hasDetectResult() == false) goto L18;
            setDetectResult(r8.getDetectResult());
        L18:
            if (r8.hasResponseCode() == false) goto L21;
            setResponseCode(r8.getResponseCode());
        L21:
            if (r8.hasDetectRtt() == false) goto L24;
            setDetectRtt(r8.getDetectRtt());
        L24:
            if (r8.hasErrorCode() == false) goto L27;
            setErrorCode(r8.getErrorCode());
        L27:
            if (r8.hasRedirectUrl() == false) goto L30;
            this.redirectUrl_ = NetworkDetectData.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (r8.hasDnsTimeMs() == false) goto L33;
            setDnsTimeMs(r8.getDnsTimeMs());
        L33:
            if (r8.hasConnectTimeMs() == false) goto L36;
            setConnectTimeMs(r8.getConnectTimeMs());
        L36:
            if (r8.hasTlsTimeMs() == false) goto L39;
            setTlsTimeMs(r8.getTlsTimeMs());
        L39:
            if (r8.hasTtfbDurationMs() == false) goto L42;
            setTtfbDurationMs(r8.getTtfbDurationMs());
        L42:
            if (r8.hasTotalTimeMs() == false) goto L45;
            setTotalTimeMs(r8.getTotalTimeMs());
        L45:
            if (r8.hasWifiSsid() == false) goto L48;
            this.wifiSsid_ = NetworkDetectData.access$1600(r8);
            this.bitField0_ |= 8192;
            onChanged();
        L48:
            if (r8.hasWifiRssi() == false) goto L51;
            setWifiRssi(r8.getWifiRssi());
        L51:
            if (r8.hasWifiFreq() == false) goto L54;
            setWifiFreq(r8.getWifiFreq());
        L54:
            if (r8.hasCellType() == false) goto L57;
            setCellType(r8.getCellType());
        L57:
            if (r8.hasCellRsrp() == false) goto L60;
            setCellRsrp(r8.getCellRsrp());
        L60:
            if (r8.hasCellSinr() == false) goto L62;
            setCellSinr(r8.getCellSinr());
        L62:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new NetworkDetectData();
        PARSER = new AnonymousClass1();
    }

    private NetworkDetectData() {
        this.timestamp_ = 0;
        this.detectScene_ = 0;
        this.networkType_ = 0;
        this.detectResult_ = 0;
        this.responseCode_ = 0;
        this.detectRtt_ = 0;
        this.errorCode_ = 0;
        this.redirectUrl_ = "";
        this.dnsTimeMs_ = 0;
        this.connectTimeMs_ = 0;
        this.tlsTimeMs_ = 0;
        this.ttfbDurationMs_ = 0;
        this.totalTimeMs_ = 0;
        this.wifiSsid_ = "";
        this.wifiRssi_ = 0;
        this.wifiFreq_ = 0;
        this.cellType_ = 0;
        this.cellRsrp_ = 0;
        this.cellSinr_ = 0;
        this.memoizedIsInitialized = -1;
        this.redirectUrl_ = "";
        this.wifiSsid_ = "";
    }

    public static /* synthetic */ Object access$1000(NetworkDetectData r8) {
        return r8.redirectUrl_;
    }

    public static /* synthetic */ Object access$1002(NetworkDetectData r8, Object r10) {
        r8.redirectUrl_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(NetworkDetectData r8, int r10) {
        r8.dnsTimeMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(NetworkDetectData r8, int r10) {
        r8.connectTimeMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(NetworkDetectData r8, int r10) {
        r8.tlsTimeMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(NetworkDetectData r8, int r10) {
        r8.ttfbDurationMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(NetworkDetectData r8, int r10) {
        r8.totalTimeMs_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1600(NetworkDetectData r8) {
        return r8.wifiSsid_;
    }

    public static /* synthetic */ Object access$1602(NetworkDetectData r8, Object r10) {
        r8.wifiSsid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(NetworkDetectData r8, int r10) {
        r8.wifiRssi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(NetworkDetectData r8, int r10) {
        r8.wifiFreq_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1902(NetworkDetectData r8, int r10) {
        r8.cellType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2002(NetworkDetectData r8, int r10) {
        r8.cellRsrp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(NetworkDetectData r8, int r10) {
        r8.cellSinr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2276(NetworkDetectData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$302(NetworkDetectData r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(NetworkDetectData r8, int r10) {
        r8.detectScene_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(NetworkDetectData r8, int r10) {
        r8.networkType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(NetworkDetectData r8, int r10) {
        r8.detectResult_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(NetworkDetectData r8, int r10) {
        r8.responseCode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(NetworkDetectData r8, int r10) {
        r8.detectRtt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(NetworkDetectData r8, int r10) {
        r8.errorCode_ = r10;
        return r10;
    }

    public static NetworkDetectData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkDetectData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NetworkDetectData parseDelimitedFrom(InputStream r8) {
        return (NetworkDetectData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NetworkDetectData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NetworkDetectData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NetworkDetectData) == false) goto L8;
        NetworkDetectData r10 = (NetworkDetectData) r8;
        if (hasTimestamp() == r10.hasTimestamp()) goto L13;
        return false;
    L13:
        if (hasTimestamp() == false) goto L18;
        if (getTimestamp() == r10.getTimestamp()) goto L18;
        return false;
    L18:
        if (hasDetectScene() == r10.hasDetectScene()) goto L21;
        return false;
    L21:
        if (hasDetectScene() == false) goto L26;
        if (getDetectScene() == r10.getDetectScene()) goto L26;
        return false;
    L26:
        if (hasNetworkType() == r10.hasNetworkType()) goto L29;
        return false;
    L29:
        if (hasNetworkType() == false) goto L34;
        if (getNetworkType() == r10.getNetworkType()) goto L34;
        return false;
    L34:
        if (hasDetectResult() == r10.hasDetectResult()) goto L37;
        return false;
    L37:
        if (hasDetectResult() == false) goto L42;
        if (getDetectResult() == r10.getDetectResult()) goto L42;
        return false;
    L42:
        if (hasResponseCode() == r10.hasResponseCode()) goto L45;
        return false;
    L45:
        if (hasResponseCode() == false) goto L50;
        if (getResponseCode() == r10.getResponseCode()) goto L50;
        return false;
    L50:
        if (hasDetectRtt() == r10.hasDetectRtt()) goto L53;
        return false;
    L53:
        if (hasDetectRtt() == false) goto L58;
        if (getDetectRtt() == r10.getDetectRtt()) goto L58;
        return false;
    L58:
        if (hasErrorCode() == r10.hasErrorCode()) goto L61;
        return false;
    L61:
        if (hasErrorCode() == false) goto L66;
        if (getErrorCode() == r10.getErrorCode()) goto L66;
        return false;
    L66:
        if (hasRedirectUrl() == r10.hasRedirectUrl()) goto L69;
        return false;
    L69:
        if (hasRedirectUrl() == false) goto L74;
        if (getRedirectUrl().equals(r10.getRedirectUrl()) == true) goto L74;
        return false;
    L74:
        if (hasDnsTimeMs() == r10.hasDnsTimeMs()) goto L77;
        return false;
    L77:
        if (hasDnsTimeMs() == false) goto L82;
        if (getDnsTimeMs() == r10.getDnsTimeMs()) goto L82;
        return false;
    L82:
        if (hasConnectTimeMs() == r10.hasConnectTimeMs()) goto L85;
        return false;
    L85:
        if (hasConnectTimeMs() == false) goto L90;
        if (getConnectTimeMs() == r10.getConnectTimeMs()) goto L90;
        return false;
    L90:
        if (hasTlsTimeMs() == r10.hasTlsTimeMs()) goto L93;
        return false;
    L93:
        if (hasTlsTimeMs() == false) goto L98;
        if (getTlsTimeMs() == r10.getTlsTimeMs()) goto L98;
        return false;
    L98:
        if (hasTtfbDurationMs() == r10.hasTtfbDurationMs()) goto L101;
        return false;
    L101:
        if (hasTtfbDurationMs() == false) goto L106;
        if (getTtfbDurationMs() == r10.getTtfbDurationMs()) goto L106;
        return false;
    L106:
        if (hasTotalTimeMs() == r10.hasTotalTimeMs()) goto L109;
        return false;
    L109:
        if (hasTotalTimeMs() == false) goto L114;
        if (getTotalTimeMs() == r10.getTotalTimeMs()) goto L114;
        return false;
    L114:
        if (hasWifiSsid() == r10.hasWifiSsid()) goto L117;
        return false;
    L117:
        if (hasWifiSsid() == false) goto L122;
        if (getWifiSsid().equals(r10.getWifiSsid()) == true) goto L122;
        return false;
    L122:
        if (hasWifiRssi() == r10.hasWifiRssi()) goto L125;
        return false;
    L125:
        if (hasWifiRssi() == false) goto L130;
        if (getWifiRssi() == r10.getWifiRssi()) goto L130;
        return false;
    L130:
        if (hasWifiFreq() == r10.hasWifiFreq()) goto L133;
        return false;
    L133:
        if (hasWifiFreq() == false) goto L138;
        if (getWifiFreq() == r10.getWifiFreq()) goto L138;
        return false;
    L138:
        if (hasCellType() == r10.hasCellType()) goto L141;
        return false;
    L141:
        if (hasCellType() == false) goto L146;
        if (getCellType() == r10.getCellType()) goto L146;
        return false;
    L146:
        if (hasCellRsrp() == r10.hasCellRsrp()) goto L149;
        return false;
    L149:
        if (hasCellRsrp() == false) goto L154;
        if (getCellRsrp() == r10.getCellRsrp()) goto L154;
        return false;
    L154:
        if (hasCellSinr() == r10.hasCellSinr()) goto L157;
        return false;
    L157:
        if (hasCellSinr() == false) goto L162;
        if (getCellSinr() == r10.getCellSinr()) goto L162;
        return false;
    L162:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L164;
        return false;
    L164:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getCellRsrp() {
        return this.cellRsrp_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getCellSinr() {
        return this.cellSinr_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getCellType() {
        return this.cellType_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getConnectTimeMs() {
        return this.connectTimeMs_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getDetectResult() {
        return this.detectResult_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getDetectRtt() {
        return this.detectRtt_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getDetectScene() {
        return this.detectScene_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getDnsTimeMs() {
        return this.dnsTimeMs_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getErrorCode() {
        return this.errorCode_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getNetworkType() {
        return this.networkType_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkDetectData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public String getRedirectUrl() {
        Object r8 = this.redirectUrl_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.redirectUrl_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public ByteString getRedirectUrlBytes() {
        Object r8 = this.redirectUrl_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.redirectUrl_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getResponseCode() {
        return this.responseCode_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt64Size(1, this.timestamp_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.detectScene_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.networkType_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.detectResult_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.responseCode_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.detectRtt_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.errorCode_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + GeneratedMessage.computeStringSize(8, this.redirectUrl_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.dnsTimeMs_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.connectTimeMs_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.tlsTimeMs_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.ttfbDurationMs_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.totalTimeMs_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + GeneratedMessage.computeStringSize(14, this.wifiSsid_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeInt32Size(15, this.wifiRssi_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.wifiFreq_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeInt32Size(17, this.cellType_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeInt32Size(18, this.cellRsrp_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L62;
        r10 = r10 + CodedOutputStream.computeInt32Size(19, this.cellSinr_);
    L62:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getTlsTimeMs() {
        return this.tlsTimeMs_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getTotalTimeMs() {
        return this.totalTimeMs_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getTtfbDurationMs() {
        return this.ttfbDurationMs_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getWifiFreq() {
        return this.wifiFreq_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public int getWifiRssi() {
        return this.wifiRssi_;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public String getWifiSsid() {
        Object r8 = this.wifiSsid_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wifiSsid_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public ByteString getWifiSsidBytes() {
        Object r8 = this.wifiSsid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifiSsid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasCellRsrp() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasCellSinr() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasCellType() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasConnectTimeMs() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasDetectResult() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasDetectRtt() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasDetectScene() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasDnsTimeMs() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasErrorCode() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasNetworkType() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasRedirectUrl() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasResponseCode() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasTlsTimeMs() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasTotalTimeMs() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasTtfbDurationMs() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasWifiFreq() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasWifiRssi() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkDetectDataOrBuilder
    public boolean hasWifiSsid() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
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
        if (hasTimestamp() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getTimestamp());
    L9:
        if (hasDetectScene() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getDetectScene();
    L12:
        if (hasNetworkType() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getNetworkType();
    L15:
        if (hasDetectResult() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getDetectResult();
    L18:
        if (hasResponseCode() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getResponseCode();
    L21:
        if (hasDetectRtt() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getDetectRtt();
    L24:
        if (hasErrorCode() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getErrorCode();
    L27:
        if (hasRedirectUrl() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getRedirectUrl().hashCode();
    L30:
        if (hasDnsTimeMs() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getDnsTimeMs();
    L33:
        if (hasConnectTimeMs() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getConnectTimeMs();
    L36:
        if (hasTlsTimeMs() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + getTlsTimeMs();
    L39:
        if (hasTtfbDurationMs() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + getTtfbDurationMs();
    L42:
        if (hasTotalTimeMs() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getTotalTimeMs();
    L45:
        if (hasWifiSsid() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + getWifiSsid().hashCode();
    L48:
        if (hasWifiRssi() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + getWifiRssi();
    L51:
        if (hasWifiFreq() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + getWifiFreq();
    L54:
        if (hasCellType() == false) goto L57;
        r10 = b.a(r10, 37, 17, 53) + getCellType();
    L57:
        if (hasCellRsrp() == false) goto L60;
        r10 = b.a(r10, 37, 18, 53) + getCellRsrp();
    L60:
        if (hasCellSinr() == false) goto L62;
        r10 = b.a(r10, 37, 19, 53) + getCellSinr();
    L62:
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
        return new NetworkDetectData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt64(1, this.timestamp_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.detectScene_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.networkType_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.detectResult_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.responseCode_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.detectRtt_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.errorCode_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        GeneratedMessage.writeString(r8, 8, this.redirectUrl_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.dnsTimeMs_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.connectTimeMs_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.tlsTimeMs_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.ttfbDurationMs_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.totalTimeMs_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        GeneratedMessage.writeString(r8, 14, this.wifiSsid_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeInt32(15, this.wifiRssi_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeInt32(16, this.wifiFreq_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r8.writeInt32(17, this.cellType_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r8.writeInt32(18, this.cellRsrp_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L59;
        r8.writeInt32(19, this.cellSinr_);
    L59:
        getUnknownFields().writeTo(r8);
    }

    private NetworkDetectData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.timestamp_ = 0;
        this.detectScene_ = 0;
        this.networkType_ = 0;
        this.detectResult_ = 0;
        this.responseCode_ = 0;
        this.detectRtt_ = 0;
        this.errorCode_ = 0;
        this.redirectUrl_ = "";
        this.dnsTimeMs_ = 0;
        this.connectTimeMs_ = 0;
        this.tlsTimeMs_ = 0;
        this.ttfbDurationMs_ = 0;
        this.totalTimeMs_ = 0;
        this.wifiSsid_ = "";
        this.wifiRssi_ = 0;
        this.wifiFreq_ = 0;
        this.cellType_ = 0;
        this.cellRsrp_ = 0;
        this.cellSinr_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NetworkDetectData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NetworkDetectData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkDetectData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NetworkDetectData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkDetectData_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkDetectData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NetworkDetectData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NetworkDetectData parseFrom(CodedInputStream r8) {
        return (NetworkDetectData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NetworkDetectData getDefaultInstanceForType() {
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

    public static NetworkDetectData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NetworkDetectData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NetworkDetectData parseFrom(InputStream r8) {
        return (NetworkDetectData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NetworkDetectData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkDetectData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NetworkDetectData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkDetectData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NetworkDetectData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkDetectData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
