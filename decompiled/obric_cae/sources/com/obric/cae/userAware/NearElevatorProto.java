package com.obric.cae.userAware;

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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NearElevatorProto extends GeneratedMessageV3 implements NearElevatorProtoOrBuilder {
    private static final NearElevatorProto DEFAULT_INSTANCE = null;
    public static final int ELEVATOR_ID_FIELD_NUMBER = 2;
    public static final int ELEVATOR_UPDATE_CNT_FIELD_NUMBER = 3;
    public static final int IS_IN_ELEVATOR_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<NearElevatorProto> PARSER = null;
    public static final int WIFI_DATA_PAIRS_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int elevatorId_;
    private int elevatorUpdateCnt_;
    private boolean isInElevator_;
    private byte memoizedIsInitialized;
    private List<WifiScanDataPair> wifiDataPairs_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NearElevatorProtoOrBuilder {
        private int bitField0_;
        private int elevatorId_;
        private int elevatorUpdateCnt_;
        private boolean isInElevator_;
        private RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> wifiDataPairsBuilder_;
        private List<WifiScanDataPair> wifiDataPairs_;

        private Builder() {
            this.wifiDataPairs_ = Collections.emptyList();
        }

        private void buildPartial0(NearElevatorProto r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            NearElevatorProto.access$402(r8, this.isInElevator_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            NearElevatorProto.access$502(r8, this.elevatorId_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L12;
            NearElevatorProto.access$602(r8, this.elevatorUpdateCnt_);
            r11 = r11 | 4;
        L12:
            NearElevatorProto.access$776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(NearElevatorProto r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            NearElevatorProto.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L7;
            this.wifiDataPairs_ = Collections.unmodifiableList(this.wifiDataPairs_);
            this.bitField0_ &= -9;
        L7:
            r11 = this.wifiDataPairs_;
            goto L9
        }

        private void ensureWifiDataPairsIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.wifiDataPairs_ = new ArrayList(this.wifiDataPairs_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_NearElevatorProto_descriptor;
        }

        private RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> getWifiDataPairsFieldBuilder() {
            if (this.wifiDataPairsBuilder_ != null) goto L10;
            List<WifiScanDataPair> r8 = this.wifiDataPairs_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiDataPairsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiDataPairs_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiDataPairsBuilder_;
        }

        public Builder addAllWifiDataPairs(Iterable<? extends WifiScanDataPair> r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiDataPairsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiDataPairs_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiDataPairs(int r8, WifiScanDataPair.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r11 = this.wifiDataPairsBuilder_;
            if (r11 != null) goto L5;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiScanDataPair.Builder addWifiDataPairsBuilder() {
            return (WifiScanDataPair.Builder) getWifiDataPairsFieldBuilder().addBuilder(WifiScanDataPair.getDefaultInstance());
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

        public Builder clearElevatorId() {
            this.bitField0_ &= -3;
            this.elevatorId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearElevatorUpdateCnt() {
            this.bitField0_ &= -5;
            this.elevatorUpdateCnt_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearIsInElevator() {
            this.bitField0_ &= -2;
            this.isInElevator_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearWifiDataPairs() {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r8 = this.wifiDataPairsBuilder_;
            if (r8 != null) goto L5;
            this.wifiDataPairs_ = Collections.emptyList();
            this.bitField0_ &= -9;
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

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_NearElevatorProto_descriptor;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public int getElevatorId() {
            return this.elevatorId_;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public int getElevatorUpdateCnt() {
            return this.elevatorUpdateCnt_;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public boolean getIsInElevator() {
            return this.isInElevator_;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public WifiScanDataPair getWifiDataPairs(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiDataPairs_.get(r8);
        L6:
            return (WifiScanDataPair) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiScanDataPair.Builder getWifiDataPairsBuilder(int r8) {
            return (WifiScanDataPair.Builder) getWifiDataPairsFieldBuilder().getBuilder(r8);
        }

        public List<WifiScanDataPair.Builder> getWifiDataPairsBuilderList() {
            return getWifiDataPairsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public int getWifiDataPairsCount() {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r8 = this.wifiDataPairsBuilder_;
            if (r8 != null) goto L7;
            return this.wifiDataPairs_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public List<WifiScanDataPair> getWifiDataPairsList() {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r8 = this.wifiDataPairsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiDataPairs_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public WifiScanDataPairOrBuilder getWifiDataPairsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiDataPairs_.get(r8);
        L6:
            return (WifiScanDataPairOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public List<? extends WifiScanDataPairOrBuilder> getWifiDataPairsOrBuilderList() {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r8 = this.wifiDataPairsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiDataPairs_);
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public boolean hasElevatorId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public boolean hasElevatorUpdateCnt() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
        public boolean hasIsInElevator() {
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeWifiDataPairs(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setElevatorId(int r8) {
            this.elevatorId_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setElevatorUpdateCnt(int r8) {
            this.elevatorUpdateCnt_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setIsInElevator(boolean r8) {
            this.isInElevator_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiDataPairs(int r8, WifiScanDataPair.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r11 = this.wifiDataPairsBuilder_;
            if (r11 != null) goto L5;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.wifiDataPairs_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiDataPairs(int r8, WifiScanDataPair r10) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r11 = this.wifiDataPairsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiScanDataPair.Builder addWifiDataPairsBuilder(int r8) {
            return (WifiScanDataPair.Builder) getWifiDataPairsFieldBuilder().addBuilder(r8, WifiScanDataPair.getDefaultInstance());
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
            return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_NearElevatorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(NearElevatorProto.class, Builder.class);
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

        public Builder setWifiDataPairs(int r8, WifiScanDataPair r10) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r11 = this.wifiDataPairsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.set(r8, r10);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiDataPairs(WifiScanDataPair.Builder r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NearElevatorProto build() {
            NearElevatorProto r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NearElevatorProto buildPartial() {
            NearElevatorProto r8 = new NearElevatorProto(this, null);
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
        public NearElevatorProto getDefaultInstanceForType() {
            return NearElevatorProto.getDefaultInstance();
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

        public Builder addWifiDataPairs(WifiScanDataPair r8) {
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = this.wifiDataPairsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.add(r8);
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
            this.isInElevator_ = false;
            this.elevatorId_ = 0;
            this.elevatorUpdateCnt_ = 0;
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r8 = this.wifiDataPairsBuilder_;
            if (r8 != null) goto L5;
            this.wifiDataPairs_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -9;
            return this;
        L5:
            this.wifiDataPairs_ = null;
            r8.clear();
            goto L6
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
            this.isInElevator_ = r8.readBool();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.elevatorId_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.elevatorUpdateCnt_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L14:
            if (r12 != 34) goto L16;
            WifiScanDataPair r13 = (WifiScanDataPair) r8.readMessage(WifiScanDataPair.PARSER, r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r14 = this.wifiDataPairsBuilder_;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r14 == null) goto L20;
            r14.addMessage(r13);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L20:
            ensureWifiDataPairsIsMutable();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.wifiDataPairs_.add(r13);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L16:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L26:
            r11 = true;
            goto L4
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            onChanged();
            throw th;
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
            if ((r8 instanceof NearElevatorProto) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NearElevatorProto) r8);
        }

        public Builder mergeFrom(NearElevatorProto r8) {
            if (r8 != NearElevatorProto.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasIsInElevator() == false) goto L9;
            setIsInElevator(r8.getIsInElevator());
        L9:
            if (r8.hasElevatorId() == false) goto L12;
            setElevatorId(r8.getElevatorId());
        L12:
            if (r8.hasElevatorUpdateCnt() == false) goto L15;
            setElevatorUpdateCnt(r8.getElevatorUpdateCnt());
        L15:
            if (this.wifiDataPairsBuilder_ != null) goto L24;
            if (NearElevatorProto.access$300(r8).isEmpty() == false) goto L19;
        L32:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L19:
            if (this.wifiDataPairs_.isEmpty() == false) goto L21;
            this.wifiDataPairs_ = NearElevatorProto.access$300(r8);
            this.bitField0_ &= -9;
        L22:
            onChanged();
            goto L32
        L21:
            ensureWifiDataPairsIsMutable();
            this.wifiDataPairs_.addAll(NearElevatorProto.access$300(r8));
            goto L22
        L24:
            if (NearElevatorProto.access$300(r8).isEmpty() == true) goto L32;
            if (this.wifiDataPairsBuilder_.isEmpty() == false) goto L31;
            this.wifiDataPairsBuilder_.dispose();
            RepeatedFieldBuilderV3<WifiScanDataPair, WifiScanDataPair.Builder, WifiScanDataPairOrBuilder> r10 = null;
            this.wifiDataPairsBuilder_ = null;
            this.wifiDataPairs_ = NearElevatorProto.access$300(r8);
            this.bitField0_ &= -9;
            if (NearElevatorProto.access$800() == false) goto L30;
            r10 = getWifiDataPairsFieldBuilder();
        L30:
            this.wifiDataPairsBuilder_ = r10;
            goto L32
        L31:
            this.wifiDataPairsBuilder_.addAllMessages(NearElevatorProto.access$300(r8));
            goto L32
        }
    }

    static {
        DEFAULT_INSTANCE = new NearElevatorProto();
        PARSER = new AnonymousClass1();
    }

    private NearElevatorProto() {
        this.isInElevator_ = false;
        this.elevatorId_ = 0;
        this.elevatorUpdateCnt_ = 0;
        this.memoizedIsInitialized = -1;
        this.wifiDataPairs_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(NearElevatorProto r8) {
        return r8.wifiDataPairs_;
    }

    public static /* synthetic */ List access$302(NearElevatorProto r8, List r10) {
        r8.wifiDataPairs_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$402(NearElevatorProto r8, boolean r10) {
        r8.isInElevator_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(NearElevatorProto r8, int r10) {
        r8.elevatorId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(NearElevatorProto r8, int r10) {
        r8.elevatorUpdateCnt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$776(NearElevatorProto r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$800() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static NearElevatorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_NearElevatorProto_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NearElevatorProto parseDelimitedFrom(InputStream r8) {
        return (NearElevatorProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NearElevatorProto parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NearElevatorProto> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NearElevatorProto) == false) goto L8;
        NearElevatorProto r10 = (NearElevatorProto) r8;
        if (hasIsInElevator() == r10.hasIsInElevator()) goto L13;
        return false;
    L13:
        if (hasIsInElevator() == false) goto L18;
        if (getIsInElevator() == r10.getIsInElevator()) goto L18;
        return false;
    L18:
        if (hasElevatorId() == r10.hasElevatorId()) goto L21;
        return false;
    L21:
        if (hasElevatorId() == false) goto L26;
        if (getElevatorId() == r10.getElevatorId()) goto L26;
        return false;
    L26:
        if (hasElevatorUpdateCnt() == r10.hasElevatorUpdateCnt()) goto L29;
        return false;
    L29:
        if (hasElevatorUpdateCnt() == false) goto L34;
        if (getElevatorUpdateCnt() == r10.getElevatorUpdateCnt()) goto L34;
        return false;
    L34:
        if (getWifiDataPairsList().equals(r10.getWifiDataPairsList()) == true) goto L37;
        return false;
    L37:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L39;
        return false;
    L39:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public int getElevatorId() {
        return this.elevatorId_;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public int getElevatorUpdateCnt() {
        return this.elevatorUpdateCnt_;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public boolean getIsInElevator() {
        return this.isInElevator_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NearElevatorProto> getParserForType() {
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
        int r11 = CodedOutputStream.computeBoolSize(1, this.isInElevator_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeInt32Size(2, this.elevatorId_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt32Size(3, this.elevatorUpdateCnt_);
    L16:
        if (r10 >= this.wifiDataPairs_.size()) goto L18;
        r11 = r11 + CodedOutputStream.computeMessageSize(4, this.wifiDataPairs_.get(r10));
        r10 = r10 + 1;
        goto L16
    L18:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public WifiScanDataPair getWifiDataPairs(int r8) {
        return this.wifiDataPairs_.get(r8);
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public int getWifiDataPairsCount() {
        return this.wifiDataPairs_.size();
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public List<WifiScanDataPair> getWifiDataPairsList() {
        return this.wifiDataPairs_;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public WifiScanDataPairOrBuilder getWifiDataPairsOrBuilder(int r8) {
        return this.wifiDataPairs_.get(r8);
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public List<? extends WifiScanDataPairOrBuilder> getWifiDataPairsOrBuilderList() {
        return this.wifiDataPairs_;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public boolean hasElevatorId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public boolean hasElevatorUpdateCnt() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.NearElevatorProtoOrBuilder
    public boolean hasIsInElevator() {
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
        if (hasIsInElevator() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsInElevator());
    L9:
        if (hasElevatorId() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getElevatorId();
    L12:
        if (hasElevatorUpdateCnt() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getElevatorUpdateCnt();
    L15:
        if (getWifiDataPairsCount() <= 0) goto L17;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getWifiDataPairsList().hashCode();
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
        return new NearElevatorProto();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeBool(1, this.isInElevator_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.elevatorId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L11;
        r8.writeInt32(3, this.elevatorUpdateCnt_);
    L11:
        int r10 = 0;
    L13:
        if (r10 >= this.wifiDataPairs_.size()) goto L15;
        r8.writeMessage(4, this.wifiDataPairs_.get(r10));
        r10 = r10 + 1;
        goto L13
    L15:
        getUnknownFields().writeTo(r8);
    }

    private NearElevatorProto(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.isInElevator_ = false;
        this.elevatorId_ = 0;
        this.elevatorUpdateCnt_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NearElevatorProto r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NearElevatorProto parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NearElevatorProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NearElevatorProto parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNearElevatorEvent.internal_static_com_obric_cae_userAware_NearElevatorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(NearElevatorProto.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NearElevatorProto(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NearElevatorProto parseFrom(CodedInputStream r8) {
        return (NearElevatorProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NearElevatorProto getDefaultInstanceForType() {
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

    public static NearElevatorProto parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NearElevatorProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NearElevatorProto parseFrom(InputStream r8) {
        return (NearElevatorProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NearElevatorProto parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NearElevatorProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NearElevatorProto parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NearElevatorProto parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NearElevatorProto parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NearElevatorProto parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
