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
public final class CellularInfoData extends GeneratedMessageV3 implements CellularInfoDataOrBuilder {
    public static final int CELL_ID_FIELD_NUMBER = 3;
    private static final CellularInfoData DEFAULT_INSTANCE = null;
    public static final int L2_AVERAGE_JITTER_FIELD_NUMBER = 9;
    public static final int L2_AVERAGE_TPUT_FIELD_NUMBER = 8;
    public static final int NETWORK_QOE_FIELD_NUMBER = 10;

    @Deprecated
    public static final Parser<CellularInfoData> PARSER = null;
    public static final int RSRP_FIELD_NUMBER = 4;
    public static final int SINR_FIELD_NUMBER = 5;
    public static final int SUBID_FIELD_NUMBER = 1;
    public static final int TCP_AVERAGE_RTT_FIELD_NUMBER = 6;
    public static final int TCP_RETRY_RATE_FIELD_NUMBER = 7;
    public static final int TYPE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private long cellId_;
    private int l2AverageJitter_;
    private int l2AverageTput_;
    private byte memoizedIsInitialized;
    private List<NetworkQoE> networkQoe_;
    private int rsrp_;
    private int sinr_;
    private int subid_;
    private int tcpAverageRtt_;
    private int tcpRetryRate_;
    private int type_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CellularInfoDataOrBuilder {
        private int bitField0_;
        private long cellId_;
        private int l2AverageJitter_;
        private int l2AverageTput_;
        private RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> networkQoeBuilder_;
        private List<NetworkQoE> networkQoe_;
        private int rsrp_;
        private int sinr_;
        private int subid_;
        private int tcpAverageRtt_;
        private int tcpRetryRate_;
        private int type_;

        private Builder() {
            this.networkQoe_ = Collections.emptyList();
        }

        private void buildPartial0(CellularInfoData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            CellularInfoData.access$402(r8, this.subid_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            CellularInfoData.access$502(r8, this.type_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            CellularInfoData.access$602(r8, this.cellId_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            CellularInfoData.access$702(r8, this.rsrp_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            CellularInfoData.access$802(r8, this.sinr_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            CellularInfoData.access$902(r8, this.tcpAverageRtt_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            CellularInfoData.access$1002(r8, this.tcpRetryRate_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            CellularInfoData.access$1102(r8, this.l2AverageTput_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L30;
            CellularInfoData.access$1202(r8, this.l2AverageJitter_);
            r11 = r11 | 256;
        L30:
            CellularInfoData.access$1376(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(CellularInfoData r8) {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = this.networkQoeBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            CellularInfoData.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 512) == 0) goto L7;
            this.networkQoe_ = Collections.unmodifiableList(this.networkQoe_);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L7:
            r11 = this.networkQoe_;
            goto L9
        }

        private void ensureNetworkQoeIsMutable() {
            if ((this.bitField0_ & 512) != 0) goto L6;
            this.networkQoe_ = new ArrayList(this.networkQoe_);
            this.bitField0_ |= 512;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CellularInfoData_descriptor;
        }

        private RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> getNetworkQoeFieldBuilder() {
            if (this.networkQoeBuilder_ != null) goto L10;
            List<NetworkQoE> r8 = this.networkQoe_;
            if ((this.bitField0_ & 512) == 0) goto L7;
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

        public Builder clearCellId() {
            this.bitField0_ &= -5;
            this.cellId_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearL2AverageJitter() {
            this.bitField0_ &= -257;
            this.l2AverageJitter_ = 0;
            onChanged();
            return this;
        }

        public Builder clearL2AverageTput() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.l2AverageTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNetworkQoe() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L5;
            this.networkQoe_ = Collections.emptyList();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
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

        public Builder clearRsrp() {
            this.bitField0_ &= -9;
            this.rsrp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSinr() {
            this.bitField0_ &= -17;
            this.sinr_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSubid() {
            this.bitField0_ &= -2;
            this.subid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTcpAverageRtt() {
            this.bitField0_ &= -33;
            this.tcpAverageRtt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTcpRetryRate() {
            this.bitField0_ &= -65;
            this.tcpRetryRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public long getCellId() {
            return this.cellId_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CellularInfoData_descriptor;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getL2AverageJitter() {
            return this.l2AverageJitter_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getL2AverageTput() {
            return this.l2AverageTput_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
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

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getNetworkQoeCount() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L7;
            return this.networkQoe_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public List<NetworkQoE> getNetworkQoeList() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.networkQoe_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
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

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList() {
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.networkQoe_);
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getRsrp() {
            return this.rsrp_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getSinr() {
            return this.sinr_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getSubid() {
            return this.subid_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getTcpAverageRtt() {
            return this.tcpAverageRtt_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getTcpRetryRate() {
            return this.tcpRetryRate_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasCellId() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasL2AverageJitter() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasL2AverageTput() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasRsrp() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasSinr() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasSubid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasTcpAverageRtt() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasTcpRetryRate() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CellularInfoDataOrBuilder
        public boolean hasType() {
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

        public Builder setCellId(long r8) {
            this.cellId_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setL2AverageJitter(int r8) {
            this.l2AverageJitter_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setL2AverageTput(int r8) {
            this.l2AverageTput_ = r8;
            this.bitField0_ |= 128;
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

        public Builder setRsrp(int r8) {
            this.rsrp_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSinr(int r8) {
            this.sinr_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSubid(int r8) {
            this.subid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTcpAverageRtt(int r8) {
            this.tcpAverageRtt_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setTcpRetryRate(int r8) {
            this.tcpRetryRate_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setType(int r8) {
            this.type_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CellularInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CellularInfoData.class, Builder.class);
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
        public CellularInfoData build() {
            CellularInfoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CellularInfoData buildPartial() {
            CellularInfoData r8 = new CellularInfoData(this, null);
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
        public CellularInfoData getDefaultInstanceForType() {
            return CellularInfoData.getDefaultInstance();
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
            this.subid_ = 0;
            this.type_ = 0;
            this.cellId_ = 0;
            this.rsrp_ = 0;
            this.sinr_ = 0;
            this.tcpAverageRtt_ = 0;
            this.tcpRetryRate_ = 0;
            this.l2AverageTput_ = 0;
            this.l2AverageJitter_ = 0;
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r8 = this.networkQoeBuilder_;
            if (r8 != null) goto L5;
            this.networkQoe_ = Collections.emptyList();
        L6:
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
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
            if (r10 == null) goto L35;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L32;
            int r12 = r8.readTag();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            switch(r12) {
                case 0: goto L22;
                case 8: goto L20;
                case 16: goto L19;
                case 24: goto L18;
                case 32: goto L17;
                case 40: goto L16;
                case 48: goto L15;
                case 56: goto L14;
                case 64: goto L13;
                case 72: goto L12;
                case 82: goto L8;
                default: goto L23;
            };     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
        L8:
            NetworkQoE r13 = (NetworkQoE) r8.readMessage(NetworkQoE.PARSER, r10);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r14 = this.networkQoeBuilder_;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            if (r14 == null) goto L10;
            r14.addMessage(r13);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L10:
            ensureNetworkQoeIsMutable();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.networkQoe_.add(r13);     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L12:
            this.l2AverageJitter_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 256;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L13:
            this.l2AverageTput_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 128;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L14:
            this.tcpRetryRate_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 64;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L15:
            this.tcpAverageRtt_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 32;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L16:
            this.sinr_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 16;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L17:
            this.rsrp_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 8;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L18:
            this.cellId_ = r8.readInt64();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 4;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L19:
            this.type_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 2;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            goto L4
        L20:
            this.subid_ = r8.readInt32();     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
            this.bitField0_ |= 1;     // Catch: Throwable -> L25 InvalidProtocolBufferException -> L27
        L22:
            r11 = true;
            goto L4
        L23:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L25:
            th = move-exception;
            onChanged();
            throw th;
        L27:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L25
        L32:
            onChanged();
            return this;
        L35:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CellularInfoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CellularInfoData) r8);
        }

        public Builder mergeFrom(CellularInfoData r8) {
            if (r8 != CellularInfoData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSubid() == false) goto L9;
            setSubid(r8.getSubid());
        L9:
            if (r8.hasType() == false) goto L12;
            setType(r8.getType());
        L12:
            if (r8.hasCellId() == false) goto L15;
            setCellId(r8.getCellId());
        L15:
            if (r8.hasRsrp() == false) goto L18;
            setRsrp(r8.getRsrp());
        L18:
            if (r8.hasSinr() == false) goto L21;
            setSinr(r8.getSinr());
        L21:
            if (r8.hasTcpAverageRtt() == false) goto L24;
            setTcpAverageRtt(r8.getTcpAverageRtt());
        L24:
            if (r8.hasTcpRetryRate() == false) goto L27;
            setTcpRetryRate(r8.getTcpRetryRate());
        L27:
            if (r8.hasL2AverageTput() == false) goto L30;
            setL2AverageTput(r8.getL2AverageTput());
        L30:
            if (r8.hasL2AverageJitter() == false) goto L33;
            setL2AverageJitter(r8.getL2AverageJitter());
        L33:
            if (this.networkQoeBuilder_ != null) goto L42;
            if (CellularInfoData.access$300(r8).isEmpty() == false) goto L37;
        L50:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L37:
            if (this.networkQoe_.isEmpty() == false) goto L39;
            this.networkQoe_ = CellularInfoData.access$300(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L40:
            onChanged();
            goto L50
        L39:
            ensureNetworkQoeIsMutable();
            this.networkQoe_.addAll(CellularInfoData.access$300(r8));
            goto L40
        L42:
            if (CellularInfoData.access$300(r8).isEmpty() == true) goto L50;
            if (this.networkQoeBuilder_.isEmpty() == false) goto L49;
            this.networkQoeBuilder_.dispose();
            RepeatedFieldBuilderV3<NetworkQoE, NetworkQoE.Builder, NetworkQoEOrBuilder> r10 = null;
            this.networkQoeBuilder_ = null;
            this.networkQoe_ = CellularInfoData.access$300(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            if (CellularInfoData.access$1400() == false) goto L48;
            r10 = getNetworkQoeFieldBuilder();
        L48:
            this.networkQoeBuilder_ = r10;
            goto L50
        L49:
            this.networkQoeBuilder_.addAllMessages(CellularInfoData.access$300(r8));
            goto L50
        }
    }

    static {
        DEFAULT_INSTANCE = new CellularInfoData();
        PARSER = new AnonymousClass1();
    }

    private CellularInfoData() {
        this.subid_ = 0;
        this.type_ = 0;
        this.cellId_ = 0;
        this.rsrp_ = 0;
        this.sinr_ = 0;
        this.tcpAverageRtt_ = 0;
        this.tcpRetryRate_ = 0;
        this.l2AverageTput_ = 0;
        this.l2AverageJitter_ = 0;
        this.memoizedIsInitialized = -1;
        this.networkQoe_ = Collections.emptyList();
    }

    public static /* synthetic */ int access$1002(CellularInfoData r8, int r10) {
        r8.tcpRetryRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(CellularInfoData r8, int r10) {
        r8.l2AverageTput_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(CellularInfoData r8, int r10) {
        r8.l2AverageJitter_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1376(CellularInfoData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(CellularInfoData r8) {
        return r8.networkQoe_;
    }

    public static /* synthetic */ List access$302(CellularInfoData r8, List r10) {
        r8.networkQoe_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(CellularInfoData r8, int r10) {
        r8.subid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(CellularInfoData r8, int r10) {
        r8.type_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(CellularInfoData r8, long r10) {
        r8.cellId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(CellularInfoData r8, int r10) {
        r8.rsrp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(CellularInfoData r8, int r10) {
        r8.sinr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(CellularInfoData r8, int r10) {
        r8.tcpAverageRtt_ = r10;
        return r10;
    }

    public static CellularInfoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CellularInfoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CellularInfoData parseDelimitedFrom(InputStream r8) {
        return (CellularInfoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CellularInfoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CellularInfoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CellularInfoData) == false) goto L8;
        CellularInfoData r10 = (CellularInfoData) r8;
        if (hasSubid() == r10.hasSubid()) goto L13;
        return false;
    L13:
        if (hasSubid() == false) goto L18;
        if (getSubid() == r10.getSubid()) goto L18;
        return false;
    L18:
        if (hasType() == r10.hasType()) goto L21;
        return false;
    L21:
        if (hasType() == false) goto L26;
        if (getType() == r10.getType()) goto L26;
        return false;
    L26:
        if (hasCellId() == r10.hasCellId()) goto L29;
        return false;
    L29:
        if (hasCellId() == false) goto L34;
        if (getCellId() == r10.getCellId()) goto L34;
        return false;
    L34:
        if (hasRsrp() == r10.hasRsrp()) goto L37;
        return false;
    L37:
        if (hasRsrp() == false) goto L42;
        if (getRsrp() == r10.getRsrp()) goto L42;
        return false;
    L42:
        if (hasSinr() == r10.hasSinr()) goto L45;
        return false;
    L45:
        if (hasSinr() == false) goto L50;
        if (getSinr() == r10.getSinr()) goto L50;
        return false;
    L50:
        if (hasTcpAverageRtt() == r10.hasTcpAverageRtt()) goto L53;
        return false;
    L53:
        if (hasTcpAverageRtt() == false) goto L58;
        if (getTcpAverageRtt() == r10.getTcpAverageRtt()) goto L58;
        return false;
    L58:
        if (hasTcpRetryRate() == r10.hasTcpRetryRate()) goto L61;
        return false;
    L61:
        if (hasTcpRetryRate() == false) goto L66;
        if (getTcpRetryRate() == r10.getTcpRetryRate()) goto L66;
        return false;
    L66:
        if (hasL2AverageTput() == r10.hasL2AverageTput()) goto L69;
        return false;
    L69:
        if (hasL2AverageTput() == false) goto L74;
        if (getL2AverageTput() == r10.getL2AverageTput()) goto L74;
        return false;
    L74:
        if (hasL2AverageJitter() == r10.hasL2AverageJitter()) goto L77;
        return false;
    L77:
        if (hasL2AverageJitter() == false) goto L82;
        if (getL2AverageJitter() == r10.getL2AverageJitter()) goto L82;
        return false;
    L82:
        if (getNetworkQoeList().equals(r10.getNetworkQoeList()) == true) goto L85;
        return false;
    L85:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L87;
        return false;
    L87:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public long getCellId() {
        return this.cellId_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getL2AverageJitter() {
        return this.l2AverageJitter_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getL2AverageTput() {
        return this.l2AverageTput_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public NetworkQoE getNetworkQoe(int r8) {
        return this.networkQoe_.get(r8);
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getNetworkQoeCount() {
        return this.networkQoe_.size();
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public List<NetworkQoE> getNetworkQoeList() {
        return this.networkQoe_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8) {
        return this.networkQoe_.get(r8);
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList() {
        return this.networkQoe_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CellularInfoData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getRsrp() {
        return this.rsrp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = CodedOutputStream.computeInt32Size(1, this.subid_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeInt32Size(2, this.type_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt64Size(3, this.cellId_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeInt32Size(4, this.rsrp_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + CodedOutputStream.computeInt32Size(5, this.sinr_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r11 = r11 + CodedOutputStream.computeInt32Size(6, this.tcpAverageRtt_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        r11 = r11 + CodedOutputStream.computeInt32Size(7, this.tcpRetryRate_);
    L28:
        if ((this.bitField0_ & 128) == 0) goto L31;
        r11 = r11 + CodedOutputStream.computeInt32Size(8, this.l2AverageTput_);
    L31:
        if ((this.bitField0_ & 256) == 0) goto L34;
        r11 = r11 + CodedOutputStream.computeInt32Size(9, this.l2AverageJitter_);
    L34:
        if (r10 >= this.networkQoe_.size()) goto L36;
        r11 = r11 + CodedOutputStream.computeMessageSize(10, this.networkQoe_.get(r10));
        r10 = r10 + 1;
        goto L34
    L36:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getSinr() {
        return this.sinr_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getSubid() {
        return this.subid_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getTcpAverageRtt() {
        return this.tcpAverageRtt_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getTcpRetryRate() {
        return this.tcpRetryRate_;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasCellId() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasL2AverageJitter() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasL2AverageTput() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasRsrp() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasSinr() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasSubid() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasTcpAverageRtt() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasTcpRetryRate() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CellularInfoDataOrBuilder
    public boolean hasType() {
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
        if (hasSubid() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSubid();
    L9:
        if (hasType() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getType();
    L12:
        if (hasCellId() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(getCellId());
    L15:
        if (hasRsrp() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getRsrp();
    L18:
        if (hasSinr() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getSinr();
    L21:
        if (hasTcpAverageRtt() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getTcpAverageRtt();
    L24:
        if (hasTcpRetryRate() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getTcpRetryRate();
    L27:
        if (hasL2AverageTput() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getL2AverageTput();
    L30:
        if (hasL2AverageJitter() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getL2AverageJitter();
    L33:
        if (getNetworkQoeCount() <= 0) goto L35;
        r10 = b.a(r10, 37, 10, 53) + getNetworkQoeList().hashCode();
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
        return new CellularInfoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.subid_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.type_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt64(3, this.cellId_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.rsrp_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.sinr_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.tcpAverageRtt_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.tcpRetryRate_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.l2AverageTput_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        r8.writeInt32(9, this.l2AverageJitter_);
    L29:
        int r10 = 0;
    L31:
        if (r10 >= this.networkQoe_.size()) goto L33;
        r8.writeMessage(10, this.networkQoe_.get(r10));
        r10 = r10 + 1;
        goto L31
    L33:
        getUnknownFields().writeTo(r8);
    }

    private CellularInfoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.subid_ = 0;
        this.type_ = 0;
        this.cellId_ = 0;
        this.rsrp_ = 0;
        this.sinr_ = 0;
        this.tcpAverageRtt_ = 0;
        this.tcpRetryRate_ = 0;
        this.l2AverageTput_ = 0;
        this.l2AverageJitter_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CellularInfoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CellularInfoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CellularInfoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CellularInfoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CellularInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CellularInfoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CellularInfoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CellularInfoData parseFrom(CodedInputStream r8) {
        return (CellularInfoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CellularInfoData getDefaultInstanceForType() {
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

    public static CellularInfoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CellularInfoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CellularInfoData parseFrom(InputStream r8) {
        return (CellularInfoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CellularInfoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CellularInfoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CellularInfoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CellularInfoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CellularInfoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CellularInfoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
