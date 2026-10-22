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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class CaeNetworkHandoverData extends GeneratedMessageV3 implements CaeNetworkHandoverDataOrBuilder {
    public static final int CLUSTER_EVENT_FIELD_NUMBER = 5;
    private static final CaeNetworkHandoverData DEFAULT_INSTANCE = null;
    public static final int NETWORK_BAD_QOE_EVENT_FIELD_NUMBER = 8;
    public static final int NETWORK_DETECT_EVENT_FIELD_NUMBER = 6;
    public static final int NETWORK_FAST_SWITCH_EVENT_FIELD_NUMBER = 7;

    @Deprecated
    public static final Parser<CaeNetworkHandoverData> PARSER = null;
    public static final int SWITCH_FEEDBACK_EVENT_FIELD_NUMBER = 4;
    public static final int SWITCH_NETWORK_EVENT_FIELD_NUMBER = 2;
    public static final int SWITCH_RL_EVENT_FIELD_NUMBER = 3;
    public static final int SWITCH_TRAFFIC_EVENT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private ClusterData clusterEvent_;
    private byte memoizedIsInitialized;
    private NetworkBadQoEData networkBadQoeEvent_;
    private NetworkDetectData networkDetectEvent_;
    private NetworkFastSwitchData networkFastSwitchEvent_;
    private SwitchFeedbackData switchFeedbackEvent_;
    private SwitchNetworkData switchNetworkEvent_;
    private SwitchRLData switchRlEvent_;
    private SwitchTrafficData switchTrafficEvent_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeNetworkHandoverDataOrBuilder {
        private int bitField0_;
        private SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> clusterEventBuilder_;
        private ClusterData clusterEvent_;
        private SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> networkBadQoeEventBuilder_;
        private NetworkBadQoEData networkBadQoeEvent_;
        private SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> networkDetectEventBuilder_;
        private NetworkDetectData networkDetectEvent_;
        private SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> networkFastSwitchEventBuilder_;
        private NetworkFastSwitchData networkFastSwitchEvent_;
        private SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> switchFeedbackEventBuilder_;
        private SwitchFeedbackData switchFeedbackEvent_;
        private SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> switchNetworkEventBuilder_;
        private SwitchNetworkData switchNetworkEvent_;
        private SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> switchRlEventBuilder_;
        private SwitchRLData switchRlEvent_;
        private SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> switchTrafficEventBuilder_;
        private SwitchTrafficData switchTrafficEvent_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(CaeNetworkHandoverData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L9;
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r11 = this.switchTrafficEventBuilder_;
            if (r11 != null) goto L7;
            SwitchTrafficData r12 = this.switchTrafficEvent_;
        L8:
            CaeNetworkHandoverData.access$402(r8, r12);
            int r13 = 1;
        L11:
            if ((r10 & 2) == 0) goto L18;
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r14 = this.switchNetworkEventBuilder_;
            if (r14 != null) goto L15;
            SwitchNetworkData r15 = this.switchNetworkEvent_;
        L16:
            CaeNetworkHandoverData.access$502(r8, r15);
            r13 = r13 | 2;
            goto L18
        L15:
            r15 = (SwitchNetworkData) r14.build();
        L18:
            if ((r10 & 4) == 0) goto L25;
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r16 = this.switchRlEventBuilder_;
            if (r16 != null) goto L22;
            SwitchRLData r17 = this.switchRlEvent_;
        L23:
            CaeNetworkHandoverData.access$602(r8, r17);
            r13 = r13 | 4;
            goto L25
        L22:
            r17 = (SwitchRLData) r16.build();
        L25:
            if ((r10 & 8) == 0) goto L32;
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r18 = this.switchFeedbackEventBuilder_;
            if (r18 != null) goto L29;
            SwitchFeedbackData r19 = this.switchFeedbackEvent_;
        L30:
            CaeNetworkHandoverData.access$702(r8, r19);
            r13 = r13 | 8;
            goto L32
        L29:
            r19 = (SwitchFeedbackData) r18.build();
        L32:
            if ((r10 & 16) == 0) goto L39;
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r20 = this.clusterEventBuilder_;
            if (r20 != null) goto L36;
            ClusterData r21 = this.clusterEvent_;
        L37:
            CaeNetworkHandoverData.access$802(r8, r21);
            r13 = r13 | 16;
            goto L39
        L36:
            r21 = (ClusterData) r20.build();
        L39:
            if ((r10 & 32) == 0) goto L46;
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r22 = this.networkDetectEventBuilder_;
            if (r22 != null) goto L43;
            NetworkDetectData r23 = this.networkDetectEvent_;
        L44:
            CaeNetworkHandoverData.access$902(r8, r23);
            r13 = r13 | 32;
            goto L46
        L43:
            r23 = (NetworkDetectData) r22.build();
        L46:
            if ((r10 & 64) == 0) goto L53;
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r24 = this.networkFastSwitchEventBuilder_;
            if (r24 != null) goto L50;
            NetworkFastSwitchData r25 = this.networkFastSwitchEvent_;
        L51:
            CaeNetworkHandoverData.access$1002(r8, r25);
            r13 = r13 | 64;
            goto L53
        L50:
            r25 = (NetworkFastSwitchData) r24.build();
        L53:
            if ((r10 & 128) == 0) goto L59;
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r26 = this.networkBadQoeEventBuilder_;
            if (r26 != null) goto L57;
            NetworkBadQoEData r27 = this.networkBadQoeEvent_;
        L58:
            CaeNetworkHandoverData.access$1102(r8, r27);
            r13 = r13 | 128;
            goto L59
        L57:
            r27 = (NetworkBadQoEData) r26.build();
        L59:
            CaeNetworkHandoverData.access$1276(r8, r13);
            return;
        L7:
            r12 = (SwitchTrafficData) r11.build();
            goto L8
        L9:
            r13 = 0;
            goto L11
        }

        private SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> getClusterEventFieldBuilder() {
            if (this.clusterEventBuilder_ != null) goto L6;
            this.clusterEventBuilder_ = new SingleFieldBuilderV3(getClusterEvent(), getParentForChildren(), isClean());
            this.clusterEvent_ = null;
        L6:
            return this.clusterEventBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CaeNetworkHandoverData_descriptor;
        }

        private SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> getNetworkBadQoeEventFieldBuilder() {
            if (this.networkBadQoeEventBuilder_ != null) goto L6;
            this.networkBadQoeEventBuilder_ = new SingleFieldBuilderV3(getNetworkBadQoeEvent(), getParentForChildren(), isClean());
            this.networkBadQoeEvent_ = null;
        L6:
            return this.networkBadQoeEventBuilder_;
        }

        private SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> getNetworkDetectEventFieldBuilder() {
            if (this.networkDetectEventBuilder_ != null) goto L6;
            this.networkDetectEventBuilder_ = new SingleFieldBuilderV3(getNetworkDetectEvent(), getParentForChildren(), isClean());
            this.networkDetectEvent_ = null;
        L6:
            return this.networkDetectEventBuilder_;
        }

        private SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> getNetworkFastSwitchEventFieldBuilder() {
            if (this.networkFastSwitchEventBuilder_ != null) goto L6;
            this.networkFastSwitchEventBuilder_ = new SingleFieldBuilderV3(getNetworkFastSwitchEvent(), getParentForChildren(), isClean());
            this.networkFastSwitchEvent_ = null;
        L6:
            return this.networkFastSwitchEventBuilder_;
        }

        private SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> getSwitchFeedbackEventFieldBuilder() {
            if (this.switchFeedbackEventBuilder_ != null) goto L6;
            this.switchFeedbackEventBuilder_ = new SingleFieldBuilderV3(getSwitchFeedbackEvent(), getParentForChildren(), isClean());
            this.switchFeedbackEvent_ = null;
        L6:
            return this.switchFeedbackEventBuilder_;
        }

        private SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> getSwitchNetworkEventFieldBuilder() {
            if (this.switchNetworkEventBuilder_ != null) goto L6;
            this.switchNetworkEventBuilder_ = new SingleFieldBuilderV3(getSwitchNetworkEvent(), getParentForChildren(), isClean());
            this.switchNetworkEvent_ = null;
        L6:
            return this.switchNetworkEventBuilder_;
        }

        private SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> getSwitchRlEventFieldBuilder() {
            if (this.switchRlEventBuilder_ != null) goto L6;
            this.switchRlEventBuilder_ = new SingleFieldBuilderV3(getSwitchRlEvent(), getParentForChildren(), isClean());
            this.switchRlEvent_ = null;
        L6:
            return this.switchRlEventBuilder_;
        }

        private SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> getSwitchTrafficEventFieldBuilder() {
            if (this.switchTrafficEventBuilder_ != null) goto L6;
            this.switchTrafficEventBuilder_ = new SingleFieldBuilderV3(getSwitchTrafficEvent(), getParentForChildren(), isClean());
            this.switchTrafficEvent_ = null;
        L6:
            return this.switchTrafficEventBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (CaeNetworkHandoverData.access$200() == false) goto L6;
            getSwitchTrafficEventFieldBuilder();
            getSwitchNetworkEventFieldBuilder();
            getSwitchRlEventFieldBuilder();
            getSwitchFeedbackEventFieldBuilder();
            getClusterEventFieldBuilder();
            getNetworkDetectEventFieldBuilder();
            getNetworkFastSwitchEventFieldBuilder();
            getNetworkBadQoeEventFieldBuilder();
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

        public Builder clearClusterEvent() {
            this.bitField0_ &= -17;
            this.clusterEvent_ = null;
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r8 = this.clusterEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.clusterEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearNetworkBadQoeEvent() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.networkBadQoeEvent_ = null;
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r8 = this.networkBadQoeEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkBadQoeEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearNetworkDetectEvent() {
            this.bitField0_ &= -33;
            this.networkDetectEvent_ = null;
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r8 = this.networkDetectEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkDetectEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearNetworkFastSwitchEvent() {
            this.bitField0_ &= -65;
            this.networkFastSwitchEvent_ = null;
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r8 = this.networkFastSwitchEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkFastSwitchEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearSwitchFeedbackEvent() {
            this.bitField0_ &= -9;
            this.switchFeedbackEvent_ = null;
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r8 = this.switchFeedbackEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchFeedbackEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchNetworkEvent() {
            this.bitField0_ &= -3;
            this.switchNetworkEvent_ = null;
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r8 = this.switchNetworkEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchNetworkEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchRlEvent() {
            this.bitField0_ &= -5;
            this.switchRlEvent_ = null;
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r8 = this.switchRlEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchRlEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchTrafficEvent() {
            this.bitField0_ &= -2;
            this.switchTrafficEvent_ = null;
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r8 = this.switchTrafficEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchTrafficEventBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public ClusterData getClusterEvent() {
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r8 = this.clusterEventBuilder_;
            if (r8 != null) goto L9;
            ClusterData r10 = this.clusterEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return ClusterData.getDefaultInstance();
        L9:
            return (ClusterData) r8.getMessage();
        }

        public ClusterData.Builder getClusterEventBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (ClusterData.Builder) getClusterEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public ClusterDataOrBuilder getClusterEventOrBuilder() {
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r8 = this.clusterEventBuilder_;
            if (r8 != null) goto L5;
            ClusterData r10 = this.clusterEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return ClusterData.getDefaultInstance();
        L5:
            return (ClusterDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CaeNetworkHandoverData_descriptor;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkBadQoEData getNetworkBadQoeEvent() {
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r8 = this.networkBadQoeEventBuilder_;
            if (r8 != null) goto L9;
            NetworkBadQoEData r10 = this.networkBadQoeEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkBadQoEData.getDefaultInstance();
        L9:
            return (NetworkBadQoEData) r8.getMessage();
        }

        public NetworkBadQoEData.Builder getNetworkBadQoeEventBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (NetworkBadQoEData.Builder) getNetworkBadQoeEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkBadQoEDataOrBuilder getNetworkBadQoeEventOrBuilder() {
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r8 = this.networkBadQoeEventBuilder_;
            if (r8 != null) goto L5;
            NetworkBadQoEData r10 = this.networkBadQoeEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkBadQoEData.getDefaultInstance();
        L5:
            return (NetworkBadQoEDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkDetectData getNetworkDetectEvent() {
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r8 = this.networkDetectEventBuilder_;
            if (r8 != null) goto L9;
            NetworkDetectData r10 = this.networkDetectEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkDetectData.getDefaultInstance();
        L9:
            return (NetworkDetectData) r8.getMessage();
        }

        public NetworkDetectData.Builder getNetworkDetectEventBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (NetworkDetectData.Builder) getNetworkDetectEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkDetectDataOrBuilder getNetworkDetectEventOrBuilder() {
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r8 = this.networkDetectEventBuilder_;
            if (r8 != null) goto L5;
            NetworkDetectData r10 = this.networkDetectEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkDetectData.getDefaultInstance();
        L5:
            return (NetworkDetectDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkFastSwitchData getNetworkFastSwitchEvent() {
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r8 = this.networkFastSwitchEventBuilder_;
            if (r8 != null) goto L9;
            NetworkFastSwitchData r10 = this.networkFastSwitchEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkFastSwitchData.getDefaultInstance();
        L9:
            return (NetworkFastSwitchData) r8.getMessage();
        }

        public NetworkFastSwitchData.Builder getNetworkFastSwitchEventBuilder() {
            this.bitField0_ |= 64;
            onChanged();
            return (NetworkFastSwitchData.Builder) getNetworkFastSwitchEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public NetworkFastSwitchDataOrBuilder getNetworkFastSwitchEventOrBuilder() {
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r8 = this.networkFastSwitchEventBuilder_;
            if (r8 != null) goto L5;
            NetworkFastSwitchData r10 = this.networkFastSwitchEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkFastSwitchData.getDefaultInstance();
        L5:
            return (NetworkFastSwitchDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchFeedbackData getSwitchFeedbackEvent() {
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r8 = this.switchFeedbackEventBuilder_;
            if (r8 != null) goto L9;
            SwitchFeedbackData r10 = this.switchFeedbackEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SwitchFeedbackData.getDefaultInstance();
        L9:
            return (SwitchFeedbackData) r8.getMessage();
        }

        public SwitchFeedbackData.Builder getSwitchFeedbackEventBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (SwitchFeedbackData.Builder) getSwitchFeedbackEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchFeedbackDataOrBuilder getSwitchFeedbackEventOrBuilder() {
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r8 = this.switchFeedbackEventBuilder_;
            if (r8 != null) goto L5;
            SwitchFeedbackData r10 = this.switchFeedbackEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SwitchFeedbackData.getDefaultInstance();
        L5:
            return (SwitchFeedbackDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchNetworkData getSwitchNetworkEvent() {
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r8 = this.switchNetworkEventBuilder_;
            if (r8 != null) goto L9;
            SwitchNetworkData r10 = this.switchNetworkEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SwitchNetworkData.getDefaultInstance();
        L9:
            return (SwitchNetworkData) r8.getMessage();
        }

        public SwitchNetworkData.Builder getSwitchNetworkEventBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (SwitchNetworkData.Builder) getSwitchNetworkEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchNetworkDataOrBuilder getSwitchNetworkEventOrBuilder() {
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r8 = this.switchNetworkEventBuilder_;
            if (r8 != null) goto L5;
            SwitchNetworkData r10 = this.switchNetworkEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SwitchNetworkData.getDefaultInstance();
        L5:
            return (SwitchNetworkDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchRLData getSwitchRlEvent() {
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r8 = this.switchRlEventBuilder_;
            if (r8 != null) goto L9;
            SwitchRLData r10 = this.switchRlEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SwitchRLData.getDefaultInstance();
        L9:
            return (SwitchRLData) r8.getMessage();
        }

        public SwitchRLData.Builder getSwitchRlEventBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (SwitchRLData.Builder) getSwitchRlEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchRLDataOrBuilder getSwitchRlEventOrBuilder() {
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r8 = this.switchRlEventBuilder_;
            if (r8 != null) goto L5;
            SwitchRLData r10 = this.switchRlEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SwitchRLData.getDefaultInstance();
        L5:
            return (SwitchRLDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchTrafficData getSwitchTrafficEvent() {
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r8 = this.switchTrafficEventBuilder_;
            if (r8 != null) goto L9;
            SwitchTrafficData r10 = this.switchTrafficEvent_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SwitchTrafficData.getDefaultInstance();
        L9:
            return (SwitchTrafficData) r8.getMessage();
        }

        public SwitchTrafficData.Builder getSwitchTrafficEventBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (SwitchTrafficData.Builder) getSwitchTrafficEventFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public SwitchTrafficDataOrBuilder getSwitchTrafficEventOrBuilder() {
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r8 = this.switchTrafficEventBuilder_;
            if (r8 != null) goto L5;
            SwitchTrafficData r10 = this.switchTrafficEvent_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SwitchTrafficData.getDefaultInstance();
        L5:
            return (SwitchTrafficDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasClusterEvent() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasNetworkBadQoeEvent() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasNetworkDetectEvent() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasNetworkFastSwitchEvent() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasSwitchFeedbackEvent() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasSwitchNetworkEvent() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasSwitchRlEvent() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
        public boolean hasSwitchTrafficEvent() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeClusterEvent(ClusterData r8) {
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r10 = this.clusterEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            ClusterData r11 = this.clusterEvent_;
            if (r11 == null) goto L11;
            if (r11 == ClusterData.getDefaultInstance()) goto L11;
            getClusterEventBuilder().mergeFrom(r8);
        L11:
            this.clusterEvent_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeNetworkBadQoeEvent(NetworkBadQoEData r8) {
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r10 = this.networkBadQoeEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L11;
            NetworkBadQoEData r11 = this.networkBadQoeEvent_;
            if (r11 == null) goto L11;
            if (r11 == NetworkBadQoEData.getDefaultInstance()) goto L11;
            getNetworkBadQoeEventBuilder().mergeFrom(r8);
        L11:
            this.networkBadQoeEvent_ = r8;
            goto L13
        }

        public Builder mergeNetworkDetectEvent(NetworkDetectData r8) {
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r10 = this.networkDetectEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L11;
            NetworkDetectData r11 = this.networkDetectEvent_;
            if (r11 == null) goto L11;
            if (r11 == NetworkDetectData.getDefaultInstance()) goto L11;
            getNetworkDetectEventBuilder().mergeFrom(r8);
        L11:
            this.networkDetectEvent_ = r8;
            goto L13
        }

        public Builder mergeNetworkFastSwitchEvent(NetworkFastSwitchData r8) {
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r10 = this.networkFastSwitchEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 64) == 0) goto L11;
            NetworkFastSwitchData r11 = this.networkFastSwitchEvent_;
            if (r11 == null) goto L11;
            if (r11 == NetworkFastSwitchData.getDefaultInstance()) goto L11;
            getNetworkFastSwitchEventBuilder().mergeFrom(r8);
        L11:
            this.networkFastSwitchEvent_ = r8;
            goto L13
        }

        public Builder mergeSwitchFeedbackEvent(SwitchFeedbackData r8) {
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r10 = this.switchFeedbackEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            SwitchFeedbackData r11 = this.switchFeedbackEvent_;
            if (r11 == null) goto L11;
            if (r11 == SwitchFeedbackData.getDefaultInstance()) goto L11;
            getSwitchFeedbackEventBuilder().mergeFrom(r8);
        L11:
            this.switchFeedbackEvent_ = r8;
            goto L13
        }

        public Builder mergeSwitchNetworkEvent(SwitchNetworkData r8) {
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r10 = this.switchNetworkEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            SwitchNetworkData r11 = this.switchNetworkEvent_;
            if (r11 == null) goto L11;
            if (r11 == SwitchNetworkData.getDefaultInstance()) goto L11;
            getSwitchNetworkEventBuilder().mergeFrom(r8);
        L11:
            this.switchNetworkEvent_ = r8;
            goto L13
        }

        public Builder mergeSwitchRlEvent(SwitchRLData r8) {
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r10 = this.switchRlEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L11;
            SwitchRLData r11 = this.switchRlEvent_;
            if (r11 == null) goto L11;
            if (r11 == SwitchRLData.getDefaultInstance()) goto L11;
            getSwitchRlEventBuilder().mergeFrom(r8);
        L11:
            this.switchRlEvent_ = r8;
            goto L13
        }

        public Builder mergeSwitchTrafficEvent(SwitchTrafficData r8) {
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r10 = this.switchTrafficEventBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L11;
            SwitchTrafficData r11 = this.switchTrafficEvent_;
            if (r11 == null) goto L11;
            if (r11 == SwitchTrafficData.getDefaultInstance()) goto L11;
            getSwitchTrafficEventBuilder().mergeFrom(r8);
        L11:
            this.switchTrafficEvent_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setClusterEvent(ClusterData.Builder r8) {
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r10 = this.clusterEventBuilder_;
            ClusterData r11 = r8.build();
            if (r10 != null) goto L5;
            this.clusterEvent_ = r11;
        L6:
            this.bitField0_ |= 16;
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

        public Builder setNetworkBadQoeEvent(NetworkBadQoEData.Builder r8) {
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r10 = this.networkBadQoeEventBuilder_;
            NetworkBadQoEData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkBadQoeEvent_ = r11;
        L6:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNetworkDetectEvent(NetworkDetectData.Builder r8) {
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r10 = this.networkDetectEventBuilder_;
            NetworkDetectData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkDetectEvent_ = r11;
        L6:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNetworkFastSwitchEvent(NetworkFastSwitchData.Builder r8) {
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r10 = this.networkFastSwitchEventBuilder_;
            NetworkFastSwitchData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkFastSwitchEvent_ = r11;
        L6:
            this.bitField0_ |= 64;
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

        public Builder setSwitchFeedbackEvent(SwitchFeedbackData.Builder r8) {
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r10 = this.switchFeedbackEventBuilder_;
            SwitchFeedbackData r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchFeedbackEvent_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchNetworkEvent(SwitchNetworkData.Builder r8) {
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r10 = this.switchNetworkEventBuilder_;
            SwitchNetworkData r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchNetworkEvent_ = r11;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchRlEvent(SwitchRLData.Builder r8) {
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r10 = this.switchRlEventBuilder_;
            SwitchRLData r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchRlEvent_ = r11;
        L6:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchTrafficEvent(SwitchTrafficData.Builder r8) {
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r10 = this.switchTrafficEventBuilder_;
            SwitchTrafficData r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchTrafficEvent_ = r11;
        L6:
            this.bitField0_ |= 1;
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CaeNetworkHandoverData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeNetworkHandoverData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setClusterEvent(ClusterData r8) {
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r10 = this.clusterEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.clusterEvent_ = r8;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNetworkBadQoeEvent(NetworkBadQoEData r8) {
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r10 = this.networkBadQoeEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkBadQoeEvent_ = r8;
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

        public Builder setNetworkDetectEvent(NetworkDetectData r8) {
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r10 = this.networkDetectEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkDetectEvent_ = r8;
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

        public Builder setNetworkFastSwitchEvent(NetworkFastSwitchData r8) {
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r10 = this.networkFastSwitchEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkFastSwitchEvent_ = r8;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSwitchFeedbackEvent(SwitchFeedbackData r8) {
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r10 = this.switchFeedbackEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchFeedbackEvent_ = r8;
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

        public Builder setSwitchNetworkEvent(SwitchNetworkData r8) {
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r10 = this.switchNetworkEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchNetworkEvent_ = r8;
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

        public Builder setSwitchRlEvent(SwitchRLData r8) {
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r10 = this.switchRlEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchRlEvent_ = r8;
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

        public Builder setSwitchTrafficEvent(SwitchTrafficData r8) {
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r10 = this.switchTrafficEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchTrafficEvent_ = r8;
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
        public CaeNetworkHandoverData build() {
            CaeNetworkHandoverData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeNetworkHandoverData buildPartial() {
            CaeNetworkHandoverData r8 = new CaeNetworkHandoverData(this, null);
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
        public CaeNetworkHandoverData getDefaultInstanceForType() {
            return CaeNetworkHandoverData.getDefaultInstance();
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
            this.switchTrafficEvent_ = null;
            SingleFieldBuilderV3<SwitchTrafficData, SwitchTrafficData.Builder, SwitchTrafficDataOrBuilder> r8 = this.switchTrafficEventBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchTrafficEventBuilder_ = null;
        L5:
            this.switchNetworkEvent_ = null;
            SingleFieldBuilderV3<SwitchNetworkData, SwitchNetworkData.Builder, SwitchNetworkDataOrBuilder> r10 = this.switchNetworkEventBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.switchNetworkEventBuilder_ = null;
        L8:
            this.switchRlEvent_ = null;
            SingleFieldBuilderV3<SwitchRLData, SwitchRLData.Builder, SwitchRLDataOrBuilder> r11 = this.switchRlEventBuilder_;
            if (r11 == null) goto L11;
            r11.dispose();
            this.switchRlEventBuilder_ = null;
        L11:
            this.switchFeedbackEvent_ = null;
            SingleFieldBuilderV3<SwitchFeedbackData, SwitchFeedbackData.Builder, SwitchFeedbackDataOrBuilder> r12 = this.switchFeedbackEventBuilder_;
            if (r12 == null) goto L14;
            r12.dispose();
            this.switchFeedbackEventBuilder_ = null;
        L14:
            this.clusterEvent_ = null;
            SingleFieldBuilderV3<ClusterData, ClusterData.Builder, ClusterDataOrBuilder> r13 = this.clusterEventBuilder_;
            if (r13 == null) goto L17;
            r13.dispose();
            this.clusterEventBuilder_ = null;
        L17:
            this.networkDetectEvent_ = null;
            SingleFieldBuilderV3<NetworkDetectData, NetworkDetectData.Builder, NetworkDetectDataOrBuilder> r14 = this.networkDetectEventBuilder_;
            if (r14 == null) goto L20;
            r14.dispose();
            this.networkDetectEventBuilder_ = null;
        L20:
            this.networkFastSwitchEvent_ = null;
            SingleFieldBuilderV3<NetworkFastSwitchData, NetworkFastSwitchData.Builder, NetworkFastSwitchDataOrBuilder> r15 = this.networkFastSwitchEventBuilder_;
            if (r15 == null) goto L23;
            r15.dispose();
            this.networkFastSwitchEventBuilder_ = null;
        L23:
            this.networkBadQoeEvent_ = null;
            SingleFieldBuilderV3<NetworkBadQoEData, NetworkBadQoEData.Builder, NetworkBadQoEDataOrBuilder> r16 = this.networkBadQoeEventBuilder_;
            if (r16 == null) goto L26;
            r16.dispose();
            this.networkBadQoeEventBuilder_ = null;
        L26:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L46;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L43;
            int r12 = r8.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r12 == 0) goto L35;
            if (r12 != 10) goto L10;
            r8.readMessage(getSwitchTrafficEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            if (r12 != 18) goto L12;
            r8.readMessage(getSwitchNetworkEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L12:
            if (r12 != 26) goto L14;
            r8.readMessage(getSwitchRlEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            if (r12 != 34) goto L16;
            r8.readMessage(getSwitchFeedbackEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            if (r12 != 42) goto L18;
            r8.readMessage(getClusterEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L18:
            if (r12 != 50) goto L20;
            r8.readMessage(getNetworkDetectEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            if (r12 != 58) goto L22;
            r8.readMessage(getNetworkFastSwitchEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L22:
            if (r12 != 66) goto L24;
            r8.readMessage(getNetworkBadQoeEventFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L35:
            r11 = true;
            goto L4
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L43:
            onChanged();
            return this;
        L46:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CaeNetworkHandoverData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeNetworkHandoverData) r8);
        }

        public Builder mergeFrom(CaeNetworkHandoverData r8) {
            if (r8 != CaeNetworkHandoverData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSwitchTrafficEvent() == false) goto L9;
            mergeSwitchTrafficEvent(r8.getSwitchTrafficEvent());
        L9:
            if (r8.hasSwitchNetworkEvent() == false) goto L12;
            mergeSwitchNetworkEvent(r8.getSwitchNetworkEvent());
        L12:
            if (r8.hasSwitchRlEvent() == false) goto L15;
            mergeSwitchRlEvent(r8.getSwitchRlEvent());
        L15:
            if (r8.hasSwitchFeedbackEvent() == false) goto L18;
            mergeSwitchFeedbackEvent(r8.getSwitchFeedbackEvent());
        L18:
            if (r8.hasClusterEvent() == false) goto L21;
            mergeClusterEvent(r8.getClusterEvent());
        L21:
            if (r8.hasNetworkDetectEvent() == false) goto L24;
            mergeNetworkDetectEvent(r8.getNetworkDetectEvent());
        L24:
            if (r8.hasNetworkFastSwitchEvent() == false) goto L27;
            mergeNetworkFastSwitchEvent(r8.getNetworkFastSwitchEvent());
        L27:
            if (r8.hasNetworkBadQoeEvent() == false) goto L29;
            mergeNetworkBadQoeEvent(r8.getNetworkBadQoeEvent());
        L29:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeNetworkHandoverData();
        PARSER = new AnonymousClass1();
    }

    private CaeNetworkHandoverData() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ NetworkFastSwitchData access$1002(CaeNetworkHandoverData r8, NetworkFastSwitchData r10) {
        r8.networkFastSwitchEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ NetworkBadQoEData access$1102(CaeNetworkHandoverData r8, NetworkBadQoEData r10) {
        r8.networkBadQoeEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1276(CaeNetworkHandoverData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ SwitchTrafficData access$402(CaeNetworkHandoverData r8, SwitchTrafficData r10) {
        r8.switchTrafficEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ SwitchNetworkData access$502(CaeNetworkHandoverData r8, SwitchNetworkData r10) {
        r8.switchNetworkEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ SwitchRLData access$602(CaeNetworkHandoverData r8, SwitchRLData r10) {
        r8.switchRlEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ SwitchFeedbackData access$702(CaeNetworkHandoverData r8, SwitchFeedbackData r10) {
        r8.switchFeedbackEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ ClusterData access$802(CaeNetworkHandoverData r8, ClusterData r10) {
        r8.clusterEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ NetworkDetectData access$902(CaeNetworkHandoverData r8, NetworkDetectData r10) {
        r8.networkDetectEvent_ = r10;
        return r10;
    }

    public static CaeNetworkHandoverData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CaeNetworkHandoverData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeNetworkHandoverData parseDelimitedFrom(InputStream r8) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeNetworkHandoverData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeNetworkHandoverData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeNetworkHandoverData) == false) goto L8;
        CaeNetworkHandoverData r10 = (CaeNetworkHandoverData) r8;
        if (hasSwitchTrafficEvent() == r10.hasSwitchTrafficEvent()) goto L13;
        return false;
    L13:
        if (hasSwitchTrafficEvent() == false) goto L18;
        if (getSwitchTrafficEvent().equals(r10.getSwitchTrafficEvent()) == true) goto L18;
        return false;
    L18:
        if (hasSwitchNetworkEvent() == r10.hasSwitchNetworkEvent()) goto L21;
        return false;
    L21:
        if (hasSwitchNetworkEvent() == false) goto L26;
        if (getSwitchNetworkEvent().equals(r10.getSwitchNetworkEvent()) == true) goto L26;
        return false;
    L26:
        if (hasSwitchRlEvent() == r10.hasSwitchRlEvent()) goto L29;
        return false;
    L29:
        if (hasSwitchRlEvent() == false) goto L34;
        if (getSwitchRlEvent().equals(r10.getSwitchRlEvent()) == true) goto L34;
        return false;
    L34:
        if (hasSwitchFeedbackEvent() == r10.hasSwitchFeedbackEvent()) goto L37;
        return false;
    L37:
        if (hasSwitchFeedbackEvent() == false) goto L42;
        if (getSwitchFeedbackEvent().equals(r10.getSwitchFeedbackEvent()) == true) goto L42;
        return false;
    L42:
        if (hasClusterEvent() == r10.hasClusterEvent()) goto L45;
        return false;
    L45:
        if (hasClusterEvent() == false) goto L50;
        if (getClusterEvent().equals(r10.getClusterEvent()) == true) goto L50;
        return false;
    L50:
        if (hasNetworkDetectEvent() == r10.hasNetworkDetectEvent()) goto L53;
        return false;
    L53:
        if (hasNetworkDetectEvent() == false) goto L58;
        if (getNetworkDetectEvent().equals(r10.getNetworkDetectEvent()) == true) goto L58;
        return false;
    L58:
        if (hasNetworkFastSwitchEvent() == r10.hasNetworkFastSwitchEvent()) goto L61;
        return false;
    L61:
        if (hasNetworkFastSwitchEvent() == false) goto L66;
        if (getNetworkFastSwitchEvent().equals(r10.getNetworkFastSwitchEvent()) == true) goto L66;
        return false;
    L66:
        if (hasNetworkBadQoeEvent() == r10.hasNetworkBadQoeEvent()) goto L69;
        return false;
    L69:
        if (hasNetworkBadQoeEvent() == false) goto L74;
        if (getNetworkBadQoeEvent().equals(r10.getNetworkBadQoeEvent()) == true) goto L74;
        return false;
    L74:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L76;
        return false;
    L76:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public ClusterData getClusterEvent() {
        ClusterData r8 = this.clusterEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return ClusterData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public ClusterDataOrBuilder getClusterEventOrBuilder() {
        ClusterData r8 = this.clusterEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return ClusterData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkBadQoEData getNetworkBadQoeEvent() {
        NetworkBadQoEData r8 = this.networkBadQoeEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkBadQoEData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkBadQoEDataOrBuilder getNetworkBadQoeEventOrBuilder() {
        NetworkBadQoEData r8 = this.networkBadQoeEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkBadQoEData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkDetectData getNetworkDetectEvent() {
        NetworkDetectData r8 = this.networkDetectEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkDetectData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkDetectDataOrBuilder getNetworkDetectEventOrBuilder() {
        NetworkDetectData r8 = this.networkDetectEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkDetectData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkFastSwitchData getNetworkFastSwitchEvent() {
        NetworkFastSwitchData r8 = this.networkFastSwitchEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkFastSwitchData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public NetworkFastSwitchDataOrBuilder getNetworkFastSwitchEventOrBuilder() {
        NetworkFastSwitchData r8 = this.networkFastSwitchEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkFastSwitchData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeNetworkHandoverData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeMessageSize(1, getSwitchTrafficEvent());
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getSwitchNetworkEvent());
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeMessageSize(3, getSwitchRlEvent());
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeMessageSize(4, getSwitchFeedbackEvent());
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeMessageSize(5, getClusterEvent());
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeMessageSize(6, getNetworkDetectEvent());
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeMessageSize(7, getNetworkFastSwitchEvent());
    L27:
        if ((this.bitField0_ & 128) == 0) goto L29;
        r10 = r10 + CodedOutputStream.computeMessageSize(8, getNetworkBadQoeEvent());
    L29:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchFeedbackData getSwitchFeedbackEvent() {
        SwitchFeedbackData r8 = this.switchFeedbackEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchFeedbackData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchFeedbackDataOrBuilder getSwitchFeedbackEventOrBuilder() {
        SwitchFeedbackData r8 = this.switchFeedbackEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchFeedbackData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchNetworkData getSwitchNetworkEvent() {
        SwitchNetworkData r8 = this.switchNetworkEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchNetworkData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchNetworkDataOrBuilder getSwitchNetworkEventOrBuilder() {
        SwitchNetworkData r8 = this.switchNetworkEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchNetworkData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchRLData getSwitchRlEvent() {
        SwitchRLData r8 = this.switchRlEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchRLData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchRLDataOrBuilder getSwitchRlEventOrBuilder() {
        SwitchRLData r8 = this.switchRlEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchRLData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchTrafficData getSwitchTrafficEvent() {
        SwitchTrafficData r8 = this.switchTrafficEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchTrafficData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public SwitchTrafficDataOrBuilder getSwitchTrafficEventOrBuilder() {
        SwitchTrafficData r8 = this.switchTrafficEvent_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchTrafficData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasClusterEvent() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasNetworkBadQoeEvent() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasNetworkDetectEvent() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasNetworkFastSwitchEvent() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasSwitchFeedbackEvent() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasSwitchNetworkEvent() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasSwitchRlEvent() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.CaeNetworkHandoverDataOrBuilder
    public boolean hasSwitchTrafficEvent() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasSwitchTrafficEvent() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSwitchTrafficEvent().hashCode();
    L9:
        if (hasSwitchNetworkEvent() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getSwitchNetworkEvent().hashCode();
    L12:
        if (hasSwitchRlEvent() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getSwitchRlEvent().hashCode();
    L15:
        if (hasSwitchFeedbackEvent() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getSwitchFeedbackEvent().hashCode();
    L18:
        if (hasClusterEvent() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getClusterEvent().hashCode();
    L21:
        if (hasNetworkDetectEvent() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getNetworkDetectEvent().hashCode();
    L24:
        if (hasNetworkFastSwitchEvent() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getNetworkFastSwitchEvent().hashCode();
    L27:
        if (hasNetworkBadQoeEvent() == false) goto L29;
        r10 = b.a(r10, 37, 8, 53) + getNetworkBadQoeEvent().hashCode();
    L29:
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
        return new CaeNetworkHandoverData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeMessage(1, getSwitchTrafficEvent());
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeMessage(2, getSwitchNetworkEvent());
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeMessage(3, getSwitchRlEvent());
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeMessage(4, getSwitchFeedbackEvent());
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeMessage(5, getClusterEvent());
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeMessage(6, getNetworkDetectEvent());
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeMessage(7, getNetworkFastSwitchEvent());
    L24:
        if ((this.bitField0_ & 128) == 0) goto L26;
        r8.writeMessage(8, getNetworkBadQoeEvent());
    L26:
        getUnknownFields().writeTo(r8);
    }

    private CaeNetworkHandoverData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeNetworkHandoverData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeNetworkHandoverData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeNetworkHandoverData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_CaeNetworkHandoverData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeNetworkHandoverData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeNetworkHandoverData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeNetworkHandoverData parseFrom(CodedInputStream r8) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeNetworkHandoverData getDefaultInstanceForType() {
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

    public static CaeNetworkHandoverData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeNetworkHandoverData parseFrom(InputStream r8) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeNetworkHandoverData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeNetworkHandoverData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeNetworkHandoverData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeNetworkHandoverData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeNetworkHandoverData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeNetworkHandoverData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
