package com.obric.cae.smartNetwork.netAccel;

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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AccelCapability extends GeneratedMessageV3 implements AccelCapabilityOrBuilder {
    public static final int CELLULARINFO_FIELD_NUMBER = 4;
    private static final AccelCapability DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<AccelCapability> PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int WIFIINFO_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<CellularInfo> cellularInfo_;
    private byte memoizedIsInitialized;
    private int state_;
    private long timestamp_;
    private List<WifiInfo> wifiInfo_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AccelCapabilityOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> cellularInfoBuilder_;
        private List<CellularInfo> cellularInfo_;
        private int state_;
        private long timestamp_;
        private RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> wifiInfoBuilder_;
        private List<WifiInfo> wifiInfo_;

        private Builder() {
            this.wifiInfo_ = Collections.emptyList();
            this.cellularInfo_ = Collections.emptyList();
        }

        private void buildPartial0(AccelCapability r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            AccelCapability.access$2602(r8, this.state_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L9;
            AccelCapability.access$2702(r8, this.timestamp_);
            r11 = r11 | 2;
        L9:
            AccelCapability.access$2876(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(AccelCapability r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            AccelCapability.access$2402(r8, r11);
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r12 = this.cellularInfoBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            AccelCapability.access$2502(r8, r13);
            return;
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            this.cellularInfo_ = Collections.unmodifiableList(this.cellularInfo_);
            this.bitField0_ &= -9;
        L14:
            r13 = this.cellularInfo_;
            goto L16
        L5:
            if ((this.bitField0_ & 4) == 0) goto L7;
            this.wifiInfo_ = Collections.unmodifiableList(this.wifiInfo_);
            this.bitField0_ &= -5;
        L7:
            r11 = this.wifiInfo_;
            goto L9
        }

        private void ensureCellularInfoIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.cellularInfo_ = new ArrayList(this.cellularInfo_);
            this.bitField0_ |= 8;
            return;
        }

        private void ensureWifiInfoIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.wifiInfo_ = new ArrayList(this.wifiInfo_);
            this.bitField0_ |= 4;
            return;
        }

        private RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> getCellularInfoFieldBuilder() {
            if (this.cellularInfoBuilder_ != null) goto L10;
            List<CellularInfo> r8 = this.cellularInfo_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.cellularInfoBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.cellularInfo_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.cellularInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_descriptor;
        }

        private RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> getWifiInfoFieldBuilder() {
            if (this.wifiInfoBuilder_ != null) goto L10;
            List<WifiInfo> r8 = this.wifiInfo_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiInfoBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiInfo_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiInfoBuilder_;
        }

        public Builder addAllCellularInfo(Iterable<? extends CellularInfo> r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L5;
            ensureCellularInfoIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.cellularInfo_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiInfo(Iterable<? extends WifiInfo> r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L5;
            ensureWifiInfoIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiInfo_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addCellularInfo(int r8, CellularInfo.Builder r10) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r11 = this.cellularInfoBuilder_;
            if (r11 != null) goto L5;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public CellularInfo.Builder addCellularInfoBuilder() {
            return (CellularInfo.Builder) getCellularInfoFieldBuilder().addBuilder(CellularInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiInfo(int r8, WifiInfo.Builder r10) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r11 = this.wifiInfoBuilder_;
            if (r11 != null) goto L5;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiInfo.Builder addWifiInfoBuilder() {
            return (WifiInfo.Builder) getWifiInfoFieldBuilder().addBuilder(WifiInfo.getDefaultInstance());
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

        public Builder clearCellularInfo() {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r8 = this.cellularInfoBuilder_;
            if (r8 != null) goto L5;
            this.cellularInfo_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearState() {
            this.bitField0_ &= -2;
            this.state_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -3;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiInfo() {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r8 = this.wifiInfoBuilder_;
            if (r8 != null) goto L5;
            this.wifiInfo_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public CellularInfo getCellularInfo(int r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.cellularInfo_.get(r8);
        L6:
            return (CellularInfo) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public CellularInfo.Builder getCellularInfoBuilder(int r8) {
            return (CellularInfo.Builder) getCellularInfoFieldBuilder().getBuilder(r8);
        }

        public List<CellularInfo.Builder> getCellularInfoBuilderList() {
            return getCellularInfoFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public int getCellularInfoCount() {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r8 = this.cellularInfoBuilder_;
            if (r8 != null) goto L7;
            return this.cellularInfo_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public List<CellularInfo> getCellularInfoList() {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r8 = this.cellularInfoBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.cellularInfo_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public CellularInfoOrBuilder getCellularInfoOrBuilder(int r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.cellularInfo_.get(r8);
        L6:
            return (CellularInfoOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public List<? extends CellularInfoOrBuilder> getCellularInfoOrBuilderList() {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r8 = this.cellularInfoBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.cellularInfo_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public WifiInfo getWifiInfo(int r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiInfo_.get(r8);
        L6:
            return (WifiInfo) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiInfo.Builder getWifiInfoBuilder(int r8) {
            return (WifiInfo.Builder) getWifiInfoFieldBuilder().getBuilder(r8);
        }

        public List<WifiInfo.Builder> getWifiInfoBuilderList() {
            return getWifiInfoFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public int getWifiInfoCount() {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r8 = this.wifiInfoBuilder_;
            if (r8 != null) goto L7;
            return this.wifiInfo_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public List<WifiInfo> getWifiInfoList() {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r8 = this.wifiInfoBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiInfo_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public WifiInfoOrBuilder getWifiInfoOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiInfo_.get(r8);
        L6:
            return (WifiInfoOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public List<? extends WifiInfoOrBuilder> getWifiInfoOrBuilderList() {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r8 = this.wifiInfoBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiInfo_);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public boolean hasState() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
        public boolean hasTimestamp() {
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

        public Builder removeCellularInfo(int r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L5;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiInfo(int r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L5;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setCellularInfo(int r8, CellularInfo.Builder r10) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r11 = this.cellularInfoBuilder_;
            if (r11 != null) goto L5;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setState(int r8) {
            this.state_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiInfo(int r8, WifiInfo.Builder r10) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r11 = this.wifiInfoBuilder_;
            if (r11 != null) goto L5;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.wifiInfo_ = Collections.emptyList();
            this.cellularInfo_ = Collections.emptyList();
        }

        public Builder addCellularInfo(int r8, CellularInfo r10) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r11 = this.cellularInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public CellularInfo.Builder addCellularInfoBuilder(int r8) {
            return (CellularInfo.Builder) getCellularInfoFieldBuilder().addBuilder(r8, CellularInfo.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiInfo(int r8, WifiInfo r10) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r11 = this.wifiInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiInfo.Builder addWifiInfoBuilder(int r8) {
            return (WifiInfo.Builder) getWifiInfoFieldBuilder().addBuilder(r8, WifiInfo.getDefaultInstance());
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
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_fieldAccessorTable.ensureFieldAccessorsInitialized(AccelCapability.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setCellularInfo(int r8, CellularInfo r10) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r11 = this.cellularInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.set(r8, r10);
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

        public Builder setWifiInfo(int r8, WifiInfo r10) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r11 = this.wifiInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addCellularInfo(CellularInfo.Builder r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L5;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.add(r8.build());
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

        public Builder addWifiInfo(WifiInfo.Builder r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L5;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AccelCapability build() {
            AccelCapability r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AccelCapability buildPartial() {
            AccelCapability r8 = new AccelCapability(this, null);
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
        public AccelCapability getDefaultInstanceForType() {
            return AccelCapability.getDefaultInstance();
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

        public Builder addCellularInfo(CellularInfo r8) {
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureCellularInfoIsMutable();
            this.cellularInfo_.add(r8);
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

        public Builder addWifiInfo(WifiInfo r8) {
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r10 = this.wifiInfoBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiInfoIsMutable();
            this.wifiInfo_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
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
            this.state_ = 0;
            this.timestamp_ = 0;
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r8 = this.wifiInfoBuilder_;
            if (r8 != null) goto L5;
            this.wifiInfo_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = this.cellularInfoBuilder_;
            if (r10 != null) goto L9;
            this.cellularInfo_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -9;
            return this;
        L9:
            this.cellularInfo_ = null;
            r10.clear();
            goto L10
        L5:
            this.wifiInfo_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L40;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L37;
            int r12 = r8.readTag();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r12 == 0) goto L29;
            if (r12 != 8) goto L10;
            this.state_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L12:
            if (r12 == 26) goto L23;
            if (r12 != 34) goto L16;
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (CellularInfo) r8.readMessage(CellularInfo.PARSER, r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            RepeatedFieldBuilderV3 r14 = this.cellularInfoBuilder_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r14 == null) goto L20;
        L22:
            r14.addMessage(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L20:
            ensureCellularInfoIsMutable();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            List r15 = this.cellularInfo_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L21:
            r15.add(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L16:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L23:
            r13 = (WifiInfo) r8.readMessage(WifiInfo.PARSER, r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            r14 = this.wifiInfoBuilder_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r14 != null) goto L22;
            ensureWifiInfoIsMutable();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            r15 = this.wifiInfo_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
        L29:
            r11 = true;
            goto L4
        L30:
            th = move-exception;
            onChanged();
            throw th;
        L32:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L30
        L37:
            onChanged();
            return this;
        L40:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof AccelCapability) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((AccelCapability) r8);
        }

        public Builder mergeFrom(AccelCapability r8) {
            if (r8 != AccelCapability.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasState() == false) goto L9;
            setState(r8.getState());
        L9:
            if (r8.hasTimestamp() == false) goto L11;
            setTimestamp(r8.getTimestamp());
        L11:
            RepeatedFieldBuilderV3<CellularInfo, CellularInfo.Builder, CellularInfoOrBuilder> r10 = null;
            if (this.wifiInfoBuilder_ != null) goto L21;
            if (AccelCapability.access$2400(r8).isEmpty() == true) goto L31;
            if (this.wifiInfo_.isEmpty() == false) goto L18;
            this.wifiInfo_ = AccelCapability.access$2400(r8);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L31
        L18:
            ensureWifiInfoIsMutable();
            this.wifiInfo_.addAll(AccelCapability.access$2400(r8));
        L31:
            if (this.cellularInfoBuilder_ != null) goto L40;
            if (AccelCapability.access$2500(r8).isEmpty() == false) goto L35;
        L48:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L35:
            if (this.cellularInfo_.isEmpty() == false) goto L37;
            this.cellularInfo_ = AccelCapability.access$2500(r8);
            this.bitField0_ &= -9;
        L38:
            onChanged();
            goto L48
        L37:
            ensureCellularInfoIsMutable();
            this.cellularInfo_.addAll(AccelCapability.access$2500(r8));
            goto L38
        L40:
            if (AccelCapability.access$2500(r8).isEmpty() == true) goto L48;
            if (this.cellularInfoBuilder_.isEmpty() == false) goto L47;
            this.cellularInfoBuilder_.dispose();
            this.cellularInfoBuilder_ = null;
            this.cellularInfo_ = AccelCapability.access$2500(r8);
            this.bitField0_ &= -9;
            if (AccelCapability.access$3000() == false) goto L46;
            r10 = getCellularInfoFieldBuilder();
        L46:
            this.cellularInfoBuilder_ = r10;
            goto L48
        L47:
            this.cellularInfoBuilder_.addAllMessages(AccelCapability.access$2500(r8));
            goto L48
        L21:
            if (AccelCapability.access$2400(r8).isEmpty() == true) goto L31;
            if (this.wifiInfoBuilder_.isEmpty() == false) goto L29;
            this.wifiInfoBuilder_.dispose();
            this.wifiInfoBuilder_ = null;
            this.wifiInfo_ = AccelCapability.access$2400(r8);
            this.bitField0_ &= -5;
            if (AccelCapability.access$2900() == false) goto L27;
            RepeatedFieldBuilderV3<WifiInfo, WifiInfo.Builder, WifiInfoOrBuilder> r11 = getWifiInfoFieldBuilder();
        L28:
            this.wifiInfoBuilder_ = r11;
            goto L31
        L27:
            r11 = null;
            goto L28
        L29:
            this.wifiInfoBuilder_.addAllMessages(AccelCapability.access$2400(r8));
            goto L31
        }
    }

    public static final class CellularInfo extends GeneratedMessageV3 implements CellularInfoOrBuilder {
        public static final int CELLID_FIELD_NUMBER = 3;
        private static final CellularInfo DEFAULT_INSTANCE = null;

        @Deprecated
        public static final Parser<CellularInfo> PARSER = null;
        public static final int RSRP_FIELD_NUMBER = 4;
        public static final int SINR_FIELD_NUMBER = 5;
        public static final int SUBID_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long cellId_;
        private byte memoizedIsInitialized;
        private int rsrp_;
        private int sinr_;
        private int subid_;
        private int type_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CellularInfoOrBuilder {
            private int bitField0_;
            private long cellId_;
            private int rsrp_;
            private int sinr_;
            private int subid_;
            private int type_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(CellularInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                CellularInfo.access$1502(r8, this.subid_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                CellularInfo.access$1602(r8, this.type_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                CellularInfo.access$1702(r8, this.cellId_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                CellularInfo.access$1802(r8, this.rsrp_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L18;
                CellularInfo.access$1902(r8, this.sinr_);
                r11 = r11 | 16;
            L18:
                CellularInfo.access$2076(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_descriptor;
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

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public long getCellId() {
                return this.cellId_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public int getRsrp() {
                return this.rsrp_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public int getSinr() {
                return this.sinr_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public int getSubid() {
                return this.subid_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public int getType() {
                return this.type_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public boolean hasCellId() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public boolean hasRsrp() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public boolean hasSinr() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
            public boolean hasSubid() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CellularInfo.class, Builder.class);
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
            public CellularInfo build() {
                CellularInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CellularInfo buildPartial() {
                CellularInfo r8 = new CellularInfo(this, null);
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
            public CellularInfo getDefaultInstanceForType() {
                return CellularInfo.getDefaultInstance();
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
                this.subid_ = 0;
                this.type_ = 0;
                this.cellId_ = 0;
                this.rsrp_ = 0;
                this.sinr_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L37;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L34;
                int r12 = r8.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                if (r12 == 0) goto L26;
                if (r12 != 8) goto L10;
                this.subid_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                this.bitField0_ |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.type_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                this.bitField0_ |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.cellId_ = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                this.bitField0_ |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.rsrp_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                this.bitField0_ |= 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                goto L4
            L16:
                if (r12 != 40) goto L18;
                this.sinr_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                this.bitField0_ |= 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
                goto L4
            L18:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L26:
                r11 = true;
                goto L4
            L27:
                th = move-exception;
                onChanged();
                throw th;
            L29:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L27
            L34:
                onChanged();
                return this;
            L37:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof CellularInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((CellularInfo) r8);
            }

            public Builder mergeFrom(CellularInfo r8) {
                if (r8 != CellularInfo.getDefaultInstance()) goto L6;
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
                if (r8.hasSinr() == false) goto L20;
                setSinr(r8.getSinr());
            L20:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new CellularInfo();
            PARSER = new AnonymousClass1();
        }

        private CellularInfo() {
            this.subid_ = 0;
            this.type_ = 0;
            this.cellId_ = 0;
            this.rsrp_ = 0;
            this.sinr_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$1502(CellularInfo r8, int r10) {
            r8.subid_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1602(CellularInfo r8, int r10) {
            r8.type_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$1702(CellularInfo r8, long r10) {
            r8.cellId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1802(CellularInfo r8, int r10) {
            r8.rsrp_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1902(CellularInfo r8, int r10) {
            r8.sinr_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2076(CellularInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static CellularInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CellularInfo parseDelimitedFrom(InputStream r8) {
            return (CellularInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static CellularInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<CellularInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof CellularInfo) == false) goto L8;
            CellularInfo r10 = (CellularInfo) r8;
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
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L52;
            return false;
        L52:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public long getCellId() {
            return this.cellId_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CellularInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
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
            if ((this.bitField0_ & 1) == 0) goto L9;
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.subid_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.type_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeInt64Size(3, this.cellId_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeInt32Size(4, this.rsrp_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L20;
            r10 = r10 + CodedOutputStream.computeInt32Size(5, this.sinr_);
        L20:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public int getSinr() {
            return this.sinr_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public int getSubid() {
            return this.subid_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public boolean hasCellId() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public boolean hasRsrp() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public boolean hasSinr() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
        public boolean hasSubid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfoOrBuilder
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
            r10 = defpackage.b.a(r10, 37, 1, 53) + getSubid();
        L9:
            if (hasType() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + getType();
        L12:
            if (hasCellId() == false) goto L15;
            r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(getCellId());
        L15:
            if (hasRsrp() == false) goto L18;
            r10 = defpackage.b.a(r10, 37, 4, 53) + getRsrp();
        L18:
            if (hasSinr() == false) goto L20;
            r10 = defpackage.b.a(r10, 37, 5, 53) + getSinr();
        L20:
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
            return new CellularInfo();
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
            if ((this.bitField0_ & 16) == 0) goto L17;
            r8.writeInt32(5, this.sinr_);
        L17:
            getUnknownFields().writeTo(r8);
        }

        private CellularInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.subid_ = 0;
            this.type_ = 0;
            this.cellId_ = 0;
            this.rsrp_ = 0;
            this.sinr_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(CellularInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static CellularInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CellularInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static CellularInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CellularInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ CellularInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static CellularInfo parseFrom(CodedInputStream r8) {
            return (CellularInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public CellularInfo getDefaultInstanceForType() {
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

        public static CellularInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (CellularInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CellularInfo parseFrom(InputStream r8) {
            return (CellularInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static CellularInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CellularInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static CellularInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static CellularInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static CellularInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static CellularInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface CellularInfoOrBuilder extends MessageOrBuilder {
        long getCellId();

        int getRsrp();

        int getSinr();

        int getSubid();

        int getType();

        boolean hasCellId();

        boolean hasRsrp();

        boolean hasSinr();

        boolean hasSubid();

        boolean hasType();
    }

    public static final class WifiInfo extends GeneratedMessageV3 implements WifiInfoOrBuilder {
        public static final int BSSID_FIELD_NUMBER = 2;
        private static final WifiInfo DEFAULT_INSTANCE = null;
        public static final int FREQ_FIELD_NUMBER = 4;
        public static final int INTEFACE_FIELD_NUMBER = 8;
        public static final int LINKSPEED_FIELD_NUMBER = 6;

        @Deprecated
        public static final Parser<WifiInfo> PARSER = null;
        public static final int RSSI_FIELD_NUMBER = 5;
        public static final int RXLINKSPEED_FIELD_NUMBER = 7;
        public static final int SSID_FIELD_NUMBER = 1;
        public static final int STANDARD_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object bssid_;
        private int freq_;
        private volatile Object inteface_;
        private int linkspeed_;
        private byte memoizedIsInitialized;
        private int rssi_;
        private int rxLinkspeed_;
        private volatile Object ssid_;
        private int standard_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiInfoOrBuilder {
            private int bitField0_;
            private Object bssid_;
            private int freq_;
            private Object inteface_;
            private int linkspeed_;
            private int rssi_;
            private int rxLinkspeed_;
            private Object ssid_;
            private int standard_;

            private Builder() {
                this.ssid_ = "";
                this.bssid_ = "";
                this.inteface_ = "";
            }

            private void buildPartial0(WifiInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                WifiInfo.access$302(r8, this.ssid_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                WifiInfo.access$402(r8, this.bssid_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                WifiInfo.access$502(r8, this.standard_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                WifiInfo.access$602(r8, this.freq_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L19;
                WifiInfo.access$702(r8, this.rssi_);
                r11 = r11 | 16;
            L19:
                if ((r10 & 32) == 0) goto L22;
                WifiInfo.access$802(r8, this.linkspeed_);
                r11 = r11 | 32;
            L22:
                if ((r10 & 64) == 0) goto L25;
                WifiInfo.access$902(r8, this.rxLinkspeed_);
                r11 = r11 | 64;
            L25:
                if ((r10 & 128) == 0) goto L27;
                WifiInfo.access$1002(r8, this.inteface_);
                r11 = r11 | 128;
            L27:
                WifiInfo.access$1176(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_descriptor;
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
                this.bssid_ = WifiInfo.getDefaultInstance().getBssid();
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

            public Builder clearInteface() {
                this.inteface_ = WifiInfo.getDefaultInstance().getInteface();
                this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
                onChanged();
                return this;
            }

            public Builder clearLinkspeed() {
                this.bitField0_ &= -33;
                this.linkspeed_ = 0;
                onChanged();
                return this;
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

            public Builder clearRxLinkspeed() {
                this.bitField0_ &= -65;
                this.rxLinkspeed_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSsid() {
                this.ssid_ = WifiInfo.getDefaultInstance().getSsid();
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public int getFreq() {
                return this.freq_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public String getInteface() {
                Object r8 = this.inteface_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.inteface_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public ByteString getIntefaceBytes() {
                Object r8 = this.inteface_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.inteface_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public int getLinkspeed() {
                return this.linkspeed_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public int getRssi() {
                return this.rssi_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public int getRxLinkspeed() {
                return this.rxLinkspeed_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public ByteString getSsidBytes() {
                Object r8 = this.ssid_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.ssid_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public int getStandard() {
                return this.standard_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasBssid() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasFreq() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasInteface() {
                if ((this.bitField0_ & 128) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasLinkspeed() {
                if ((this.bitField0_ & 32) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasRssi() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasRxLinkspeed() {
                if ((this.bitField0_ & 64) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasSsid() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
            public boolean hasStandard() {
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

            public Builder setInteface(String r8) {
                if (r8 == null) goto L6;
                this.inteface_ = r8;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setIntefaceBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.inteface_ = r8;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setLinkspeed(int r8) {
                this.linkspeed_ = r8;
                this.bitField0_ |= 32;
                onChanged();
                return this;
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

            public Builder setRxLinkspeed(int r8) {
                this.rxLinkspeed_ = r8;
                this.bitField0_ |= 64;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
                return setUnknownFields(r8);
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
                this.ssid_ = "";
                this.bssid_ = "";
                this.inteface_ = "";
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiInfo.class, Builder.class);
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
            public WifiInfo build() {
                WifiInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WifiInfo buildPartial() {
                WifiInfo r8 = new WifiInfo(this, null);
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
            public WifiInfo getDefaultInstanceForType() {
                return WifiInfo.getDefaultInstance();
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
                this.ssid_ = "";
                this.bssid_ = "";
                this.standard_ = 0;
                this.freq_ = 0;
                this.rssi_ = 0;
                this.linkspeed_ = 0;
                this.rxLinkspeed_ = 0;
                this.inteface_ = "";
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
                this.ssid_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L10:
                if (r12 != 18) goto L12;
                this.bssid_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.standard_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.freq_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L16:
                if (r12 != 40) goto L18;
                this.rssi_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L18:
                if (r12 != 48) goto L20;
                this.linkspeed_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L20:
                if (r12 != 56) goto L22;
                this.rxLinkspeed_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L22:
                if (r12 != 66) goto L24;
                this.inteface_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L24:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L35:
                r11 = true;
                goto L4
            L38:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L36
            L36:
                th = move-exception;
                onChanged();
                throw th;
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
                if ((r8 instanceof WifiInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((WifiInfo) r8);
            }

            public Builder mergeFrom(WifiInfo r8) {
                if (r8 != WifiInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasSsid() == false) goto L9;
                this.ssid_ = WifiInfo.access$300(r8);
                this.bitField0_ |= 1;
                onChanged();
            L9:
                if (r8.hasBssid() == false) goto L12;
                this.bssid_ = WifiInfo.access$400(r8);
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
                if (r8.hasRxLinkspeed() == false) goto L27;
                setRxLinkspeed(r8.getRxLinkspeed());
            L27:
                if (r8.hasInteface() == false) goto L29;
                this.inteface_ = WifiInfo.access$1000(r8);
                this.bitField0_ |= 128;
                onChanged();
            L29:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new WifiInfo();
            PARSER = new AnonymousClass1();
        }

        private WifiInfo() {
            this.ssid_ = "";
            this.bssid_ = "";
            this.standard_ = 0;
            this.freq_ = 0;
            this.rssi_ = 0;
            this.linkspeed_ = 0;
            this.rxLinkspeed_ = 0;
            this.inteface_ = "";
            this.memoizedIsInitialized = -1;
            this.ssid_ = "";
            this.bssid_ = "";
            this.inteface_ = "";
        }

        public static /* synthetic */ Object access$1000(WifiInfo r8) {
            return r8.inteface_;
        }

        public static /* synthetic */ Object access$1002(WifiInfo r8, Object r10) {
            r8.inteface_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1176(WifiInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static /* synthetic */ Object access$300(WifiInfo r8) {
            return r8.ssid_;
        }

        public static /* synthetic */ Object access$302(WifiInfo r8, Object r10) {
            r8.ssid_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$400(WifiInfo r8) {
            return r8.bssid_;
        }

        public static /* synthetic */ Object access$402(WifiInfo r8, Object r10) {
            r8.bssid_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$502(WifiInfo r8, int r10) {
            r8.standard_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$602(WifiInfo r8, int r10) {
            r8.freq_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$702(WifiInfo r8, int r10) {
            r8.rssi_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$802(WifiInfo r8, int r10) {
            r8.linkspeed_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$902(WifiInfo r8, int r10) {
            r8.rxLinkspeed_ = r10;
            return r10;
        }

        public static WifiInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiInfo parseDelimitedFrom(InputStream r8) {
            return (WifiInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static WifiInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<WifiInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof WifiInfo) == false) goto L8;
            WifiInfo r10 = (WifiInfo) r8;
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
            if (hasRxLinkspeed() == r10.hasRxLinkspeed()) goto L61;
            return false;
        L61:
            if (hasRxLinkspeed() == false) goto L66;
            if (getRxLinkspeed() == r10.getRxLinkspeed()) goto L66;
            return false;
        L66:
            if (hasInteface() == r10.hasInteface()) goto L69;
            return false;
        L69:
            if (hasInteface() == false) goto L74;
            if (getInteface().equals(r10.getInteface()) == true) goto L74;
            return false;
        L74:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L76;
            return false;
        L76:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public int getFreq() {
            return this.freq_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public String getInteface() {
            Object r8 = this.inteface_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.inteface_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public ByteString getIntefaceBytes() {
            Object r8 = this.inteface_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.inteface_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public int getLinkspeed() {
            return this.linkspeed_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WifiInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public int getRssi() {
            return this.rssi_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public int getRxLinkspeed() {
            return this.rxLinkspeed_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r8 = this.memoizedSize;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r10 = 0 + GeneratedMessage.computeStringSize(1, this.ssid_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + GeneratedMessage.computeStringSize(2, this.bssid_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeInt32Size(3, this.standard_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeInt32Size(4, this.freq_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L21;
            r10 = r10 + CodedOutputStream.computeInt32Size(5, this.rssi_);
        L21:
            if ((this.bitField0_ & 32) == 0) goto L24;
            r10 = r10 + CodedOutputStream.computeInt32Size(6, this.linkspeed_);
        L24:
            if ((this.bitField0_ & 64) == 0) goto L27;
            r10 = r10 + CodedOutputStream.computeInt32Size(7, this.rxLinkspeed_);
        L27:
            if ((this.bitField0_ & 128) == 0) goto L29;
            r10 = r10 + GeneratedMessage.computeStringSize(8, this.inteface_);
        L29:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
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

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public ByteString getSsidBytes() {
            Object r8 = this.ssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public int getStandard() {
            return this.standard_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasFreq() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasInteface() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasLinkspeed() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasRssi() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasRxLinkspeed() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasSsid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfoOrBuilder
        public boolean hasStandard() {
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
            if (hasSsid() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + getSsid().hashCode();
        L9:
            if (hasBssid() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + getBssid().hashCode();
        L12:
            if (hasStandard() == false) goto L15;
            r10 = defpackage.b.a(r10, 37, 3, 53) + getStandard();
        L15:
            if (hasFreq() == false) goto L18;
            r10 = defpackage.b.a(r10, 37, 4, 53) + getFreq();
        L18:
            if (hasRssi() == false) goto L21;
            r10 = defpackage.b.a(r10, 37, 5, 53) + getRssi();
        L21:
            if (hasLinkspeed() == false) goto L24;
            r10 = defpackage.b.a(r10, 37, 6, 53) + getLinkspeed();
        L24:
            if (hasRxLinkspeed() == false) goto L27;
            r10 = defpackage.b.a(r10, 37, 7, 53) + getRxLinkspeed();
        L27:
            if (hasInteface() == false) goto L29;
            r10 = defpackage.b.a(r10, 37, 8, 53) + getInteface().hashCode();
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
            return new WifiInfo();
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
            r8.writeInt32(7, this.rxLinkspeed_);
        L24:
            if ((this.bitField0_ & 128) == 0) goto L26;
            GeneratedMessage.writeString(r8, 8, this.inteface_);
        L26:
            getUnknownFields().writeTo(r8);
        }

        private WifiInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.ssid_ = "";
            this.bssid_ = "";
            this.standard_ = 0;
            this.freq_ = 0;
            this.rssi_ = 0;
            this.linkspeed_ = 0;
            this.rxLinkspeed_ = 0;
            this.inteface_ = "";
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(WifiInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static WifiInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (WifiInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static WifiInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ WifiInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static WifiInfo parseFrom(CodedInputStream r8) {
            return (WifiInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public WifiInfo getDefaultInstanceForType() {
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

        public static WifiInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (WifiInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static WifiInfo parseFrom(InputStream r8) {
            return (WifiInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static WifiInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (WifiInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static WifiInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static WifiInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static WifiInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static WifiInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface WifiInfoOrBuilder extends MessageOrBuilder {
        String getBssid();

        ByteString getBssidBytes();

        int getFreq();

        String getInteface();

        ByteString getIntefaceBytes();

        int getLinkspeed();

        int getRssi();

        int getRxLinkspeed();

        String getSsid();

        ByteString getSsidBytes();

        int getStandard();

        boolean hasBssid();

        boolean hasFreq();

        boolean hasInteface();

        boolean hasLinkspeed();

        boolean hasRssi();

        boolean hasRxLinkspeed();

        boolean hasSsid();

        boolean hasStandard();
    }

    static {
        DEFAULT_INSTANCE = new AccelCapability();
        PARSER = new AnonymousClass1();
    }

    private AccelCapability() {
        this.state_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.wifiInfo_ = Collections.emptyList();
        this.cellularInfo_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$2400(AccelCapability r8) {
        return r8.wifiInfo_;
    }

    public static /* synthetic */ List access$2402(AccelCapability r8, List r10) {
        r8.wifiInfo_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$2500(AccelCapability r8) {
        return r8.cellularInfo_;
    }

    public static /* synthetic */ List access$2502(AccelCapability r8, List r10) {
        r8.cellularInfo_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2602(AccelCapability r8, int r10) {
        r8.state_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2702(AccelCapability r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2876(AccelCapability r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$2900() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$3000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static AccelCapability getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AccelCapability parseDelimitedFrom(InputStream r8) {
        return (AccelCapability) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static AccelCapability parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<AccelCapability> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AccelCapability) == false) goto L8;
        AccelCapability r10 = (AccelCapability) r8;
        if (hasState() == r10.hasState()) goto L13;
        return false;
    L13:
        if (hasState() == false) goto L18;
        if (getState() == r10.getState()) goto L18;
        return false;
    L18:
        if (hasTimestamp() == r10.hasTimestamp()) goto L21;
        return false;
    L21:
        if (hasTimestamp() == false) goto L26;
        if (getTimestamp() == r10.getTimestamp()) goto L26;
        return false;
    L26:
        if (getWifiInfoList().equals(r10.getWifiInfoList()) == true) goto L29;
        return false;
    L29:
        if (getCellularInfoList().equals(r10.getCellularInfoList()) == true) goto L32;
        return false;
    L32:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L34;
        return false;
    L34:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public CellularInfo getCellularInfo(int r8) {
        return this.cellularInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public int getCellularInfoCount() {
        return this.cellularInfo_.size();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public List<CellularInfo> getCellularInfoList() {
        return this.cellularInfo_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public CellularInfoOrBuilder getCellularInfoOrBuilder(int r8) {
        return this.cellularInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public List<? extends CellularInfoOrBuilder> getCellularInfoOrBuilderList() {
        return this.cellularInfo_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AccelCapability> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = CodedOutputStream.computeInt32Size(1, this.state_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r11 = r11 + CodedOutputStream.computeInt64Size(2, this.timestamp_);
    L12:
        int r12 = 0;
    L14:
        if (r12 >= this.wifiInfo_.size()) goto L17;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.wifiInfo_.get(r12));
        r12 = r12 + 1;
    L17:
        if (r10 >= this.cellularInfo_.size()) goto L19;
        r11 = r11 + CodedOutputStream.computeMessageSize(4, this.cellularInfo_.get(r10));
        r10 = r10 + 1;
        goto L17
    L19:
        int r13 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public int getState() {
        return this.state_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public WifiInfo getWifiInfo(int r8) {
        return this.wifiInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public int getWifiInfoCount() {
        return this.wifiInfo_.size();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public List<WifiInfo> getWifiInfoList() {
        return this.wifiInfo_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public WifiInfoOrBuilder getWifiInfoOrBuilder(int r8) {
        return this.wifiInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public List<? extends WifiInfoOrBuilder> getWifiInfoOrBuilderList() {
        return this.wifiInfo_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public boolean hasState() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelCapabilityOrBuilder
    public boolean hasTimestamp() {
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
        if (hasState() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getState();
    L9:
        if (hasTimestamp() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getTimestamp());
    L12:
        if (getWifiInfoCount() <= 0) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getWifiInfoList().hashCode();
    L15:
        if (getCellularInfoCount() <= 0) goto L17;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getCellularInfoList().hashCode();
    L17:
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
        return new AccelCapability();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.state_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r8.writeInt64(2, this.timestamp_);
    L8:
        int r10 = 0;
        int r11 = 0;
    L10:
        if (r11 >= this.wifiInfo_.size()) goto L13;
        r8.writeMessage(3, this.wifiInfo_.get(r11));
        r11 = r11 + 1;
    L13:
        if (r10 >= this.cellularInfo_.size()) goto L15;
        r8.writeMessage(4, this.cellularInfo_.get(r10));
        r10 = r10 + 1;
        goto L13
    L15:
        getUnknownFields().writeTo(r8);
    }

    private AccelCapability(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.state_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(AccelCapability r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static AccelCapability parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AccelCapability) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static AccelCapability parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_fieldAccessorTable.ensureFieldAccessorsInitialized(AccelCapability.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ AccelCapability(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static AccelCapability parseFrom(CodedInputStream r8) {
        return (AccelCapability) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public AccelCapability getDefaultInstanceForType() {
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

    public static AccelCapability parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (AccelCapability) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static AccelCapability parseFrom(InputStream r8) {
        return (AccelCapability) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static AccelCapability parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AccelCapability) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static AccelCapability parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static AccelCapability parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static AccelCapability parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static AccelCapability parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
