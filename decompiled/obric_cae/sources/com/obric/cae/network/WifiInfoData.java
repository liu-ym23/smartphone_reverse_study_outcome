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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WifiInfoData extends GeneratedMessageV3 implements WifiInfoDataOrBuilder {
    public static final int BSSID_FIELD_NUMBER = 2;
    private static final WifiInfoData DEFAULT_INSTANCE = null;
    public static final int FREQ_FIELD_NUMBER = 4;
    public static final int L2_AVERAGE_JITTER_FIELD_NUMBER = 10;
    public static final int L2_AVERAGE_TPUT_FIELD_NUMBER = 9;
    public static final int LINKSPEED_FIELD_NUMBER = 6;
    public static final int NETWORK_QOE_FIELD_NUMBER = 11;

    @Deprecated
    public static final Parser<WifiInfoData> PARSER = null;
    public static final int RSSI_FIELD_NUMBER = 5;
    public static final int SSID_FIELD_NUMBER = 1;
    public static final int STANDARD_FIELD_NUMBER = 3;
    public static final int TCP_AVERAGE_RTT_FIELD_NUMBER = 7;
    public static final int TCP_RETRY_RATE_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object bssid_;
    private int freq_;
    private int l2AverageJitter_;
    private int l2AverageTput_;
    private int linkspeed_;
    private byte memoizedIsInitialized;
    private List<NetworkQoE> networkQoe_;
    private int rssi_;
    private volatile Object ssid_;
    private int standard_;
    private int tcpAverageRtt_;
    private int tcpRetryRate_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiInfoDataOrBuilder {
        private int bitField0_;
        private Object bssid_;
        private int freq_;
        private int l2AverageJitter_;
        private int l2AverageTput_;
        private int linkspeed_;
        private RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> networkQoeBuilder_;
        private List<NetworkQoE> networkQoe_;
        private int rssi_;
        private Object ssid_;
        private int standard_;
        private int tcpAverageRtt_;
        private int tcpRetryRate_;

        private Builder() {
            this.ssid_ = "";
            this.bssid_ = "";
            this.networkQoe_ = Collections.emptyList();
        }

        private void buildPartial0(WifiInfoData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WifiInfoData.access$402(r8, this.ssid_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WifiInfoData.access$502(r8, this.bssid_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WifiInfoData.access$602(r8, this.standard_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WifiInfoData.access$702(r8, this.freq_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            WifiInfoData.access$802(r8, this.rssi_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            WifiInfoData.access$902(r8, this.linkspeed_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            WifiInfoData.access$1002(r8, this.tcpAverageRtt_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            WifiInfoData.access$1102(r8, this.tcpRetryRate_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            WifiInfoData.access$1202(r8, this.l2AverageTput_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L33;
            WifiInfoData.access$1302(r8, this.l2AverageJitter_);
            r11 = r11 | 512;
        L33:
            WifiInfoData.access$1476(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(WifiInfoData r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            WifiInfoData.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 1024) == 0) goto L7;
            this.networkQoe_ = Collections.unmodifiableList(this.networkQoe_);
            this.bitField0_ &= -1025;
        L7:
            r11 = this.networkQoe_;
            goto L9
        }

        private void ensureNetworkQoeIsMutable() {
            if ((this.bitField0_ & 1024) != 0) goto L6;
            this.networkQoe_ = new ArrayList(this.networkQoe_);
            this.bitField0_ |= 1024;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_WifiInfoData_descriptor;
        }

        private RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> getNetworkQoeFieldBuilder() {
            if (this.networkQoeBuilder_ != null) goto L10;
            List<NetworkQoE> r8 = this.networkQoe_;
            if ((this.bitField0_ & 1024) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.networkQoeBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.networkQoe_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.networkQoeBuilder_;
        }

        public Builder addAllNetworkQoe(Iterable<? extends NetworkQoE> r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L5;
            ensureNetworkQoeIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.networkQoe_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addNetworkQoe(int r8, NetworkQoE.Builder r10) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r11 = this.networkQoeBuilder_;
            if (r11 != null) goto L5;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public NetworkQoE.Builder addNetworkQoeBuilder() {
            return (NetworkQoE.Builder) getNetworkQoeFieldBuilder().addBuilder(NetworkQoE.getDefaultInstance());
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
            this.bssid_ = WifiInfoData.getDefaultInstance().getBssid();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFreq() {
            this.bitField0_ &= -9;
            this.freq_ = 0;
            onChanged();
            return this;
        }

        public Builder clearL2AverageJitter() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.l2AverageJitter_ = 0;
            onChanged();
            return this;
        }

        public Builder clearL2AverageTput() {
            this.bitField0_ &= -257;
            this.l2AverageTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLinkspeed() {
            this.bitField0_ &= -33;
            this.linkspeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNetworkQoe() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L5;
            this.networkQoe_ = Collections.emptyList();
            this.bitField0_ &= -1025;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRssi() {
            this.bitField0_ &= -17;
            this.rssi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSsid() {
            this.ssid_ = WifiInfoData.getDefaultInstance().getSsid();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearStandard() {
            this.bitField0_ &= -5;
            this.standard_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTcpAverageRtt() {
            this.bitField0_ &= -65;
            this.tcpAverageRtt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTcpRetryRate() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.tcpRetryRate_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
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

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public ByteString getBssidBytes() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssid_ = r10;
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_WifiInfoData_descriptor;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getFreq() {
            return this.freq_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getL2AverageJitter() {
            return this.l2AverageJitter_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getL2AverageTput() {
            return this.l2AverageTput_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getLinkspeed() {
            return this.linkspeed_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public NetworkQoE getNetworkQoe(int r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.networkQoe_.get(r8);
        L6:
            return (NetworkQoE) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public NetworkQoE.Builder getNetworkQoeBuilder(int r8) {
            return (NetworkQoE.Builder) getNetworkQoeFieldBuilder().getBuilder(r8);
        }

        public List<NetworkQoE.Builder> getNetworkQoeBuilderList() {
            return getNetworkQoeFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getNetworkQoeCount() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L7;
            return this.networkQoe_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public List<NetworkQoE> getNetworkQoeList() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.networkQoe_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.networkQoe_.get(r8);
        L6:
            return (NetworkQoEOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.networkQoe_);
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getRssi() {
            return this.rssi_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public String getSsid() {
            Object r8 = this.ssid_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.ssid_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public ByteString getSsidBytes() {
            Object r8 = this.ssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getStandard() {
            return this.standard_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getTcpAverageRtt() {
            return this.tcpAverageRtt_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public int getTcpRetryRate() {
            return this.tcpRetryRate_;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasFreq() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasL2AverageJitter() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasL2AverageTput() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasLinkspeed() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasRssi() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasSsid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasStandard() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasTcpAverageRtt() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.WifiInfoDataOrBuilder
        public boolean hasTcpRetryRate() {
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

        public Builder removeNetworkQoe(int r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L5;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setFreq(int r8) {
            this.freq_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setL2AverageJitter(int r8) {
            this.l2AverageJitter_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setL2AverageTput(int r8) {
            this.l2AverageTput_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setLinkspeed(int r8) {
            this.linkspeed_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setNetworkQoe(int r8, NetworkQoE.Builder r10) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r11 = this.networkQoeBuilder_;
            if (r11 != null) goto L5;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRssi(int r8) {
            this.rssi_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSsid(String r8) {
            if (r8 == null) goto L6;
            this.ssid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSsidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.ssid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStandard(int r8) {
            this.standard_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTcpAverageRtt(int r8) {
            this.tcpAverageRtt_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTcpRetryRate(int r8) {
            this.tcpRetryRate_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.ssid_ = "";
            this.bssid_ = "";
            this.networkQoe_ = Collections.emptyList();
        }

        public Builder addNetworkQoe(int r8, NetworkQoE r10) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r11 = this.networkQoeBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public NetworkQoE.Builder addNetworkQoeBuilder(int r8) {
            return (NetworkQoE.Builder) getNetworkQoeFieldBuilder().addBuilder(r8, NetworkQoE.getDefaultInstance());
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_WifiInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiInfoData.class, Builder.class);
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

        public Builder setNetworkQoe(int r8, NetworkQoE r10) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r11 = this.networkQoeBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.set(r8, r10);
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

        public Builder addNetworkQoe(NetworkQoE.Builder r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L5;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.add(r8.build());
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
        public WifiInfoData build() {
            WifiInfoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiInfoData buildPartial() {
            WifiInfoData r8 = new WifiInfoData(this, null);
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
        public WifiInfoData getDefaultInstanceForType() {
            return WifiInfoData.getDefaultInstance();
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

        public Builder addNetworkQoe(NetworkQoE r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureNetworkQoeIsMutable();
            this.networkQoe_.add(r8);
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
            this.ssid_ = "";
            this.bssid_ = "";
            this.standard_ = 0;
            this.freq_ = 0;
            this.rssi_ = 0;
            this.linkspeed_ = 0;
            this.tcpAverageRtt_ = 0;
            this.tcpRetryRate_ = 0;
            this.l2AverageTput_ = 0;
            this.l2AverageJitter_ = 0;
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L5;
            this.networkQoe_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -1025;
            return this;
        L5:
            this.networkQoe_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L36;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L33;
            int r12 = r8.readTag();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            switch(r12) {
                case 0: goto L23;
                case 10: goto L21;
                case 18: goto L20;
                case 24: goto L19;
                case 32: goto L18;
                case 40: goto L17;
                case 48: goto L16;
                case 56: goto L15;
                case 64: goto L14;
                case 72: goto L13;
                case 80: goto L12;
                case 90: goto L8;
                default: goto L24;
            };     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
        L8:
            NetworkQoE r13 = (NetworkQoE) r8.readMessage(NetworkQoE.PARSER, r10);     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r14 = this.networkQoeBuilder_;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            if (r14 == null) goto L10;
            r14.addMessage(r13);     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L10:
            ensureNetworkQoeIsMutable();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.networkQoe_.add(r13);     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L12:
            this.l2AverageJitter_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 512;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L13:
            this.l2AverageTput_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 256;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L14:
            this.tcpRetryRate_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 128;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L15:
            this.tcpAverageRtt_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 64;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L16:
            this.linkspeed_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 32;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L17:
            this.rssi_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 16;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L18:
            this.freq_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 8;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L19:
            this.standard_ = r8.readInt32();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 4;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L20:
            this.bssid_ = r8.readBytes();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 2;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L21:
            this.ssid_ = r8.readBytes();     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 1;     // Catch: Throwable -> L26 InvalidProtocolBufferException -> L28
        L23:
            r11 = true;
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L26:
            th = move-exception;
            onChanged();
            throw th;
        L28:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L26
        L33:
            onChanged();
            return this;
        L36:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof WifiInfoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WifiInfoData) r8);
        }

        public Builder mergeFrom(WifiInfoData r8) {
            if (r8 != WifiInfoData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSsid() == false) goto L9;
            this.ssid_ = WifiInfoData.access$400(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasBssid() == false) goto L12;
            this.bssid_ = WifiInfoData.access$500(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasStandard() == false) goto L15;
            setStandard(r8.getStandard());
        L15:
            if (r8.hasFreq() == false) goto L18;
            setFreq(r8.getFreq());
        L18:
            if (r8.hasRssi() == false) goto L21;
            setRssi(r8.getRssi());
        L21:
            if (r8.hasLinkspeed() == false) goto L24;
            setLinkspeed(r8.getLinkspeed());
        L24:
            if (r8.hasTcpAverageRtt() == false) goto L27;
            setTcpAverageRtt(r8.getTcpAverageRtt());
        L27:
            if (r8.hasTcpRetryRate() == false) goto L30;
            setTcpRetryRate(r8.getTcpRetryRate());
        L30:
            if (r8.hasL2AverageTput() == false) goto L33;
            setL2AverageTput(r8.getL2AverageTput());
        L33:
            if (r8.hasL2AverageJitter() == false) goto L36;
            setL2AverageJitter(r8.getL2AverageJitter());
        L36:
            if (this.networkQoeBuilder_ != null) goto L45;
            if (WifiInfoData.access$300(r8).isEmpty() == false) goto L40;
        L53:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L40:
            if (this.networkQoe_.isEmpty() == false) goto L42;
            this.networkQoe_ = WifiInfoData.access$300(r8);
            this.bitField0_ &= -1025;
        L43:
            onChanged();
            goto L53
        L42:
            ensureNetworkQoeIsMutable();
            this.networkQoe_.addAll(WifiInfoData.access$300(r8));
            goto L43
        L45:
            if (WifiInfoData.access$300(r8).isEmpty() == true) goto L53;
            if (this.networkQoeBuilder_.isEmpty() == false) goto L52;
            this.networkQoeBuilder_.dispose();
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = null;
            this.networkQoeBuilder_ = null;
            this.networkQoe_ = WifiInfoData.access$300(r8);
            this.bitField0_ &= -1025;
            if (WifiInfoData.access$1500() == false) goto L51;
            r10 = getNetworkQoeFieldBuilder();
        L51:
            this.networkQoeBuilder_ = r10;
            goto L53
        L52:
            this.networkQoeBuilder_.addAllMessages(WifiInfoData.access$300(r8));
            goto L53
        }
    }

    static {
        DEFAULT_INSTANCE = new WifiInfoData();
        PARSER = new AnonymousClass1();
    }

    private WifiInfoData() {
        this.ssid_ = "";
        this.bssid_ = "";
        this.standard_ = 0;
        this.freq_ = 0;
        this.rssi_ = 0;
        this.linkspeed_ = 0;
        this.tcpAverageRtt_ = 0;
        this.tcpRetryRate_ = 0;
        this.l2AverageTput_ = 0;
        this.l2AverageJitter_ = 0;
        this.memoizedIsInitialized = -1;
        this.ssid_ = "";
        this.bssid_ = "";
        this.networkQoe_ = Collections.emptyList();
    }

    public static /* synthetic */ int access$1002(WifiInfoData r8, int r10) {
        r8.tcpAverageRtt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(WifiInfoData r8, int r10) {
        r8.tcpRetryRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(WifiInfoData r8, int r10) {
        r8.l2AverageTput_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(WifiInfoData r8, int r10) {
        r8.l2AverageJitter_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1476(WifiInfoData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1500() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(WifiInfoData r8) {
        return r8.networkQoe_;
    }

    public static /* synthetic */ List access$302(WifiInfoData r8, List r10) {
        r8.networkQoe_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(WifiInfoData r8) {
        return r8.ssid_;
    }

    public static /* synthetic */ Object access$402(WifiInfoData r8, Object r10) {
        r8.ssid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(WifiInfoData r8) {
        return r8.bssid_;
    }

    public static /* synthetic */ Object access$502(WifiInfoData r8, Object r10) {
        r8.bssid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(WifiInfoData r8, int r10) {
        r8.standard_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(WifiInfoData r8, int r10) {
        r8.freq_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(WifiInfoData r8, int r10) {
        r8.rssi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(WifiInfoData r8, int r10) {
        r8.linkspeed_ = r10;
        return r10;
    }

    public static WifiInfoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_WifiInfoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WifiInfoData parseDelimitedFrom(InputStream r8) {
        return (WifiInfoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WifiInfoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WifiInfoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WifiInfoData) == false) goto L8;
        WifiInfoData r10 = (WifiInfoData) r8;
        if (hasSsid() == r10.hasSsid()) goto L13;
        return false;
    L13:
        if (hasSsid() == false) goto L18;
        if (getSsid().equals(r10.getSsid()) == true) goto L18;
        return false;
    L18:
        if (hasBssid() == r10.hasBssid()) goto L21;
        return false;
    L21:
        if (hasBssid() == false) goto L26;
        if (getBssid().equals(r10.getBssid()) == true) goto L26;
        return false;
    L26:
        if (hasStandard() == r10.hasStandard()) goto L29;
        return false;
    L29:
        if (hasStandard() == false) goto L34;
        if (getStandard() == r10.getStandard()) goto L34;
        return false;
    L34:
        if (hasFreq() == r10.hasFreq()) goto L37;
        return false;
    L37:
        if (hasFreq() == false) goto L42;
        if (getFreq() == r10.getFreq()) goto L42;
        return false;
    L42:
        if (hasRssi() == r10.hasRssi()) goto L45;
        return false;
    L45:
        if (hasRssi() == false) goto L50;
        if (getRssi() == r10.getRssi()) goto L50;
        return false;
    L50:
        if (hasLinkspeed() == r10.hasLinkspeed()) goto L53;
        return false;
    L53:
        if (hasLinkspeed() == false) goto L58;
        if (getLinkspeed() == r10.getLinkspeed()) goto L58;
        return false;
    L58:
        if (hasTcpAverageRtt() == r10.hasTcpAverageRtt()) goto L61;
        return false;
    L61:
        if (hasTcpAverageRtt() == false) goto L66;
        if (getTcpAverageRtt() == r10.getTcpAverageRtt()) goto L66;
        return false;
    L66:
        if (hasTcpRetryRate() == r10.hasTcpRetryRate()) goto L69;
        return false;
    L69:
        if (hasTcpRetryRate() == false) goto L74;
        if (getTcpRetryRate() == r10.getTcpRetryRate()) goto L74;
        return false;
    L74:
        if (hasL2AverageTput() == r10.hasL2AverageTput()) goto L77;
        return false;
    L77:
        if (hasL2AverageTput() == false) goto L82;
        if (getL2AverageTput() == r10.getL2AverageTput()) goto L82;
        return false;
    L82:
        if (hasL2AverageJitter() == r10.hasL2AverageJitter()) goto L85;
        return false;
    L85:
        if (hasL2AverageJitter() == false) goto L90;
        if (getL2AverageJitter() == r10.getL2AverageJitter()) goto L90;
        return false;
    L90:
        if (getNetworkQoeList().equals(r10.getNetworkQoeList()) == true) goto L93;
        return false;
    L93:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L95;
        return false;
    L95:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
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

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public ByteString getBssidBytes() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getFreq() {
        return this.freq_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getL2AverageJitter() {
        return this.l2AverageJitter_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getL2AverageTput() {
        return this.l2AverageTput_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getLinkspeed() {
        return this.linkspeed_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public NetworkQoE getNetworkQoe(int r8) {
        return this.networkQoe_.get(r8);
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getNetworkQoeCount() {
        return this.networkQoe_.size();
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public List<NetworkQoE> getNetworkQoeList() {
        return this.networkQoe_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8) {
        return this.networkQoe_.get(r8);
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList() {
        return this.networkQoe_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WifiInfoData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getRssi() {
        return this.rssi_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.ssid_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.bssid_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt32Size(3, this.standard_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeInt32Size(4, this.freq_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + CodedOutputStream.computeInt32Size(5, this.rssi_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r11 = r11 + CodedOutputStream.computeInt32Size(6, this.linkspeed_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        r11 = r11 + CodedOutputStream.computeInt32Size(7, this.tcpAverageRtt_);
    L28:
        if ((this.bitField0_ & 128) == 0) goto L31;
        r11 = r11 + CodedOutputStream.computeInt32Size(8, this.tcpRetryRate_);
    L31:
        if ((this.bitField0_ & 256) == 0) goto L34;
        r11 = r11 + CodedOutputStream.computeInt32Size(9, this.l2AverageTput_);
    L34:
        if ((this.bitField0_ & 512) == 0) goto L37;
        r11 = r11 + CodedOutputStream.computeInt32Size(10, this.l2AverageJitter_);
    L37:
        if (r10 >= this.networkQoe_.size()) goto L39;
        r11 = r11 + CodedOutputStream.computeMessageSize(11, this.networkQoe_.get(r10));
        r10 = r10 + 1;
        goto L37
    L39:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public String getSsid() {
        Object r8 = this.ssid_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.ssid_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public ByteString getSsidBytes() {
        Object r8 = this.ssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.ssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getStandard() {
        return this.standard_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getTcpAverageRtt() {
        return this.tcpAverageRtt_;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public int getTcpRetryRate() {
        return this.tcpRetryRate_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasBssid() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasFreq() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasL2AverageJitter() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasL2AverageTput() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasLinkspeed() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasRssi() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasSsid() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasStandard() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasTcpAverageRtt() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.WifiInfoDataOrBuilder
    public boolean hasTcpRetryRate() {
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
        if (hasSsid() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSsid().hashCode();
    L9:
        if (hasBssid() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getBssid().hashCode();
    L12:
        if (hasStandard() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getStandard();
    L15:
        if (hasFreq() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getFreq();
    L18:
        if (hasRssi() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getRssi();
    L21:
        if (hasLinkspeed() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getLinkspeed();
    L24:
        if (hasTcpAverageRtt() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getTcpAverageRtt();
    L27:
        if (hasTcpRetryRate() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getTcpRetryRate();
    L30:
        if (hasL2AverageTput() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getL2AverageTput();
    L33:
        if (hasL2AverageJitter() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getL2AverageJitter();
    L36:
        if (getNetworkQoeCount() <= 0) goto L38;
        r10 = b.a(r10, 37, 11, 53) + getNetworkQoeList().hashCode();
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
        return new WifiInfoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.ssid_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.bssid_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.standard_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.freq_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.rssi_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.linkspeed_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.tcpAverageRtt_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.tcpRetryRate_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.l2AverageTput_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L32;
        r8.writeInt32(10, this.l2AverageJitter_);
    L32:
        int r10 = 0;
    L34:
        if (r10 >= this.networkQoe_.size()) goto L36;
        r8.writeMessage(11, this.networkQoe_.get(r10));
        r10 = r10 + 1;
        goto L34
    L36:
        getUnknownFields().writeTo(r8);
    }

    private WifiInfoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.ssid_ = "";
        this.bssid_ = "";
        this.standard_ = 0;
        this.freq_ = 0;
        this.rssi_ = 0;
        this.linkspeed_ = 0;
        this.tcpAverageRtt_ = 0;
        this.tcpRetryRate_ = 0;
        this.l2AverageTput_ = 0;
        this.l2AverageJitter_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WifiInfoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WifiInfoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiInfoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WifiInfoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_WifiInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiInfoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WifiInfoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WifiInfoData parseFrom(CodedInputStream r8) {
        return (WifiInfoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WifiInfoData getDefaultInstanceForType() {
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

    public static WifiInfoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WifiInfoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WifiInfoData parseFrom(InputStream r8) {
        return (WifiInfoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WifiInfoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiInfoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WifiInfoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiInfoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WifiInfoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiInfoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
