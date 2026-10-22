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
public final class ClusterData extends GeneratedMessageV3 implements ClusterDataOrBuilder {
    public static final int CLUSTER_ID_FIELD_NUMBER = 2;
    public static final int DAY7CELLDATAUSED_FIELD_NUMBER = 3;
    public static final int DAY7GAMECELLDATAUSED_FIELD_NUMBER = 8;
    public static final int DAY7GAMEWIFIDATAUSED_FIELD_NUMBER = 12;
    public static final int DAY7NEWSCELLDATAUSED_FIELD_NUMBER = 7;
    public static final int DAY7NEWSWIFIDATAUSED_FIELD_NUMBER = 11;
    public static final int DAY7SOCIALCELLDATAUSED_FIELD_NUMBER = 5;
    public static final int DAY7SOCIALWIFIDATAUSED_FIELD_NUMBER = 9;
    public static final int DAY7VIDEOCELLDATAUSED_FIELD_NUMBER = 6;
    public static final int DAY7VIDEOWIFIDATAUSED_FIELD_NUMBER = 10;
    public static final int DAY7WIFIDATAUSED_FIELD_NUMBER = 4;
    private static final ClusterData DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<ClusterData> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int clusterId_;
    private long day7CellDataUsed_;
    private long day7GameCellDataUsed_;
    private long day7GameWifiDataUsed_;
    private long day7NewsCellDataUsed_;
    private long day7NewsWifiDataUsed_;
    private long day7SocialCellDataUsed_;
    private long day7SocialWifiDataUsed_;
    private long day7VideoCellDataUsed_;
    private long day7VideoWifiDataUsed_;
    private long day7WifiDataUsed_;
    private byte memoizedIsInitialized;
    private long timestamp_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClusterDataOrBuilder {
        private int bitField0_;
        private int clusterId_;
        private long day7CellDataUsed_;
        private long day7GameCellDataUsed_;
        private long day7GameWifiDataUsed_;
        private long day7NewsCellDataUsed_;
        private long day7NewsWifiDataUsed_;
        private long day7SocialCellDataUsed_;
        private long day7SocialWifiDataUsed_;
        private long day7VideoCellDataUsed_;
        private long day7VideoWifiDataUsed_;
        private long day7WifiDataUsed_;
        private long timestamp_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(ClusterData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            ClusterData.access$302(r8, this.timestamp_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            ClusterData.access$402(r8, this.clusterId_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            ClusterData.access$502(r8, this.day7CellDataUsed_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            ClusterData.access$602(r8, this.day7WifiDataUsed_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            ClusterData.access$702(r8, this.day7SocialCellDataUsed_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            ClusterData.access$802(r8, this.day7VideoCellDataUsed_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            ClusterData.access$902(r8, this.day7NewsCellDataUsed_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            ClusterData.access$1002(r8, this.day7GameCellDataUsed_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            ClusterData.access$1102(r8, this.day7SocialWifiDataUsed_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            ClusterData.access$1202(r8, this.day7VideoWifiDataUsed_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            ClusterData.access$1302(r8, this.day7NewsWifiDataUsed_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L39;
            ClusterData.access$1402(r8, this.day7GameWifiDataUsed_);
            r11 = r11 | 2048;
        L39:
            ClusterData.access$1576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_ClusterData_descriptor;
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

        public Builder clearClusterId() {
            this.bitField0_ &= -3;
            this.clusterId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7CellDataUsed() {
            this.bitField0_ &= -5;
            this.day7CellDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7GameCellDataUsed() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.day7GameCellDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7GameWifiDataUsed() {
            this.bitField0_ &= -2049;
            this.day7GameWifiDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7NewsCellDataUsed() {
            this.bitField0_ &= -65;
            this.day7NewsCellDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7NewsWifiDataUsed() {
            this.bitField0_ &= -1025;
            this.day7NewsWifiDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7SocialCellDataUsed() {
            this.bitField0_ &= -17;
            this.day7SocialCellDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7SocialWifiDataUsed() {
            this.bitField0_ &= -257;
            this.day7SocialWifiDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7VideoCellDataUsed() {
            this.bitField0_ &= -33;
            this.day7VideoCellDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7VideoWifiDataUsed() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.day7VideoWifiDataUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDay7WifiDataUsed() {
            this.bitField0_ &= -9;
            this.day7WifiDataUsed_ = 0;
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

        public Builder clearTimestamp() {
            this.bitField0_ &= -2;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public int getClusterId() {
            return this.clusterId_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7CellDataUsed() {
            return this.day7CellDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7GameCellDataUsed() {
            return this.day7GameCellDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7GameWifiDataUsed() {
            return this.day7GameWifiDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7NewsCellDataUsed() {
            return this.day7NewsCellDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7NewsWifiDataUsed() {
            return this.day7NewsWifiDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7SocialCellDataUsed() {
            return this.day7SocialCellDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7SocialWifiDataUsed() {
            return this.day7SocialWifiDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7VideoCellDataUsed() {
            return this.day7VideoCellDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7VideoWifiDataUsed() {
            return this.day7VideoWifiDataUsed_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getDay7WifiDataUsed() {
            return this.day7WifiDataUsed_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_ClusterData_descriptor;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasClusterId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7CellDataUsed() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7GameCellDataUsed() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7GameWifiDataUsed() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7NewsCellDataUsed() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7NewsWifiDataUsed() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7SocialCellDataUsed() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7SocialWifiDataUsed() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7VideoCellDataUsed() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7VideoWifiDataUsed() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasDay7WifiDataUsed() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.ClusterDataOrBuilder
        public boolean hasTimestamp() {
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

        public Builder setClusterId(int r8) {
            this.clusterId_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDay7CellDataUsed(long r8) {
            this.day7CellDataUsed_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setDay7GameCellDataUsed(long r8) {
            this.day7GameCellDataUsed_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setDay7GameWifiDataUsed(long r8) {
            this.day7GameWifiDataUsed_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setDay7NewsCellDataUsed(long r8) {
            this.day7NewsCellDataUsed_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setDay7NewsWifiDataUsed(long r8) {
            this.day7NewsWifiDataUsed_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setDay7SocialCellDataUsed(long r8) {
            this.day7SocialCellDataUsed_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setDay7SocialWifiDataUsed(long r8) {
            this.day7SocialWifiDataUsed_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDay7VideoCellDataUsed(long r8) {
            this.day7VideoCellDataUsed_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setDay7VideoWifiDataUsed(long r8) {
            this.day7VideoWifiDataUsed_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDay7WifiDataUsed(long r8) {
            this.day7WifiDataUsed_ = r8;
            this.bitField0_ |= 8;
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

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 1;
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_ClusterData_fieldAccessorTable.ensureFieldAccessorsInitialized(ClusterData.class, Builder.class);
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
        public ClusterData build() {
            ClusterData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ClusterData buildPartial() {
            ClusterData r8 = new ClusterData(this, null);
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
        public ClusterData getDefaultInstanceForType() {
            return ClusterData.getDefaultInstance();
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
            this.timestamp_ = 0;
            this.clusterId_ = 0;
            this.day7CellDataUsed_ = 0;
            this.day7WifiDataUsed_ = 0;
            this.day7SocialCellDataUsed_ = 0;
            this.day7VideoCellDataUsed_ = 0;
            this.day7NewsCellDataUsed_ = 0;
            this.day7GameCellDataUsed_ = 0;
            this.day7SocialWifiDataUsed_ = 0;
            this.day7VideoWifiDataUsed_ = 0;
            this.day7NewsWifiDataUsed_ = 0;
            this.day7GameWifiDataUsed_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            switch(r12) {
                case 0: goto L21;
                case 8: goto L19;
                case 16: goto L18;
                case 24: goto L17;
                case 32: goto L16;
                case 40: goto L15;
                case 48: goto L14;
                case 56: goto L13;
                case 64: goto L12;
                case 72: goto L11;
                case 80: goto L10;
                case 88: goto L9;
                case 96: goto L8;
                default: goto L22;
            };     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L8:
            this.day7GameWifiDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2048;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L9:
            this.day7NewsWifiDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1024;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            this.day7VideoWifiDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 512;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L11:
            this.day7SocialWifiDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 256;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            this.day7GameCellDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 128;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L13:
            this.day7NewsCellDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 64;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            this.day7VideoCellDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 32;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L15:
            this.day7SocialCellDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            this.day7WifiDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L17:
            this.day7CellDataUsed_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L18:
            this.clusterId_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L19:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L21:
            r11 = true;
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
        L31:
            onChanged();
            return this;
        L34:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof ClusterData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((ClusterData) r8);
        }

        public Builder mergeFrom(ClusterData r8) {
            if (r8 != ClusterData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTimestamp() == false) goto L9;
            setTimestamp(r8.getTimestamp());
        L9:
            if (r8.hasClusterId() == false) goto L12;
            setClusterId(r8.getClusterId());
        L12:
            if (r8.hasDay7CellDataUsed() == false) goto L15;
            setDay7CellDataUsed(r8.getDay7CellDataUsed());
        L15:
            if (r8.hasDay7WifiDataUsed() == false) goto L18;
            setDay7WifiDataUsed(r8.getDay7WifiDataUsed());
        L18:
            if (r8.hasDay7SocialCellDataUsed() == false) goto L21;
            setDay7SocialCellDataUsed(r8.getDay7SocialCellDataUsed());
        L21:
            if (r8.hasDay7VideoCellDataUsed() == false) goto L24;
            setDay7VideoCellDataUsed(r8.getDay7VideoCellDataUsed());
        L24:
            if (r8.hasDay7NewsCellDataUsed() == false) goto L27;
            setDay7NewsCellDataUsed(r8.getDay7NewsCellDataUsed());
        L27:
            if (r8.hasDay7GameCellDataUsed() == false) goto L30;
            setDay7GameCellDataUsed(r8.getDay7GameCellDataUsed());
        L30:
            if (r8.hasDay7SocialWifiDataUsed() == false) goto L33;
            setDay7SocialWifiDataUsed(r8.getDay7SocialWifiDataUsed());
        L33:
            if (r8.hasDay7VideoWifiDataUsed() == false) goto L36;
            setDay7VideoWifiDataUsed(r8.getDay7VideoWifiDataUsed());
        L36:
            if (r8.hasDay7NewsWifiDataUsed() == false) goto L39;
            setDay7NewsWifiDataUsed(r8.getDay7NewsWifiDataUsed());
        L39:
            if (r8.hasDay7GameWifiDataUsed() == false) goto L41;
            setDay7GameWifiDataUsed(r8.getDay7GameWifiDataUsed());
        L41:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new ClusterData();
        PARSER = new AnonymousClass1();
    }

    private ClusterData() {
        this.timestamp_ = 0;
        this.clusterId_ = 0;
        this.day7CellDataUsed_ = 0;
        this.day7WifiDataUsed_ = 0;
        this.day7SocialCellDataUsed_ = 0;
        this.day7VideoCellDataUsed_ = 0;
        this.day7NewsCellDataUsed_ = 0;
        this.day7GameCellDataUsed_ = 0;
        this.day7SocialWifiDataUsed_ = 0;
        this.day7VideoWifiDataUsed_ = 0;
        this.day7NewsWifiDataUsed_ = 0;
        this.day7GameWifiDataUsed_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ long access$1002(ClusterData r8, long r10) {
        r8.day7GameCellDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1102(ClusterData r8, long r10) {
        r8.day7SocialWifiDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1202(ClusterData r8, long r10) {
        r8.day7VideoWifiDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1302(ClusterData r8, long r10) {
        r8.day7NewsWifiDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1402(ClusterData r8, long r10) {
        r8.day7GameWifiDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(ClusterData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$302(ClusterData r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(ClusterData r8, int r10) {
        r8.clusterId_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$502(ClusterData r8, long r10) {
        r8.day7CellDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(ClusterData r8, long r10) {
        r8.day7WifiDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$702(ClusterData r8, long r10) {
        r8.day7SocialCellDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$802(ClusterData r8, long r10) {
        r8.day7VideoCellDataUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$902(ClusterData r8, long r10) {
        r8.day7NewsCellDataUsed_ = r10;
        return r10;
    }

    public static ClusterData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_ClusterData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ClusterData parseDelimitedFrom(InputStream r8) {
        return (ClusterData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static ClusterData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<ClusterData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ClusterData) == false) goto L8;
        ClusterData r10 = (ClusterData) r8;
        if (hasTimestamp() == r10.hasTimestamp()) goto L13;
        return false;
    L13:
        if (hasTimestamp() == false) goto L18;
        if (getTimestamp() == r10.getTimestamp()) goto L18;
        return false;
    L18:
        if (hasClusterId() == r10.hasClusterId()) goto L21;
        return false;
    L21:
        if (hasClusterId() == false) goto L26;
        if (getClusterId() == r10.getClusterId()) goto L26;
        return false;
    L26:
        if (hasDay7CellDataUsed() == r10.hasDay7CellDataUsed()) goto L29;
        return false;
    L29:
        if (hasDay7CellDataUsed() == false) goto L34;
        if (getDay7CellDataUsed() == r10.getDay7CellDataUsed()) goto L34;
        return false;
    L34:
        if (hasDay7WifiDataUsed() == r10.hasDay7WifiDataUsed()) goto L37;
        return false;
    L37:
        if (hasDay7WifiDataUsed() == false) goto L42;
        if (getDay7WifiDataUsed() == r10.getDay7WifiDataUsed()) goto L42;
        return false;
    L42:
        if (hasDay7SocialCellDataUsed() == r10.hasDay7SocialCellDataUsed()) goto L45;
        return false;
    L45:
        if (hasDay7SocialCellDataUsed() == false) goto L50;
        if (getDay7SocialCellDataUsed() == r10.getDay7SocialCellDataUsed()) goto L50;
        return false;
    L50:
        if (hasDay7VideoCellDataUsed() == r10.hasDay7VideoCellDataUsed()) goto L53;
        return false;
    L53:
        if (hasDay7VideoCellDataUsed() == false) goto L58;
        if (getDay7VideoCellDataUsed() == r10.getDay7VideoCellDataUsed()) goto L58;
        return false;
    L58:
        if (hasDay7NewsCellDataUsed() == r10.hasDay7NewsCellDataUsed()) goto L61;
        return false;
    L61:
        if (hasDay7NewsCellDataUsed() == false) goto L66;
        if (getDay7NewsCellDataUsed() == r10.getDay7NewsCellDataUsed()) goto L66;
        return false;
    L66:
        if (hasDay7GameCellDataUsed() == r10.hasDay7GameCellDataUsed()) goto L69;
        return false;
    L69:
        if (hasDay7GameCellDataUsed() == false) goto L74;
        if (getDay7GameCellDataUsed() == r10.getDay7GameCellDataUsed()) goto L74;
        return false;
    L74:
        if (hasDay7SocialWifiDataUsed() == r10.hasDay7SocialWifiDataUsed()) goto L77;
        return false;
    L77:
        if (hasDay7SocialWifiDataUsed() == false) goto L82;
        if (getDay7SocialWifiDataUsed() == r10.getDay7SocialWifiDataUsed()) goto L82;
        return false;
    L82:
        if (hasDay7VideoWifiDataUsed() == r10.hasDay7VideoWifiDataUsed()) goto L85;
        return false;
    L85:
        if (hasDay7VideoWifiDataUsed() == false) goto L90;
        if (getDay7VideoWifiDataUsed() == r10.getDay7VideoWifiDataUsed()) goto L90;
        return false;
    L90:
        if (hasDay7NewsWifiDataUsed() == r10.hasDay7NewsWifiDataUsed()) goto L93;
        return false;
    L93:
        if (hasDay7NewsWifiDataUsed() == false) goto L98;
        if (getDay7NewsWifiDataUsed() == r10.getDay7NewsWifiDataUsed()) goto L98;
        return false;
    L98:
        if (hasDay7GameWifiDataUsed() == r10.hasDay7GameWifiDataUsed()) goto L101;
        return false;
    L101:
        if (hasDay7GameWifiDataUsed() == false) goto L106;
        if (getDay7GameWifiDataUsed() == r10.getDay7GameWifiDataUsed()) goto L106;
        return false;
    L106:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L108;
        return false;
    L108:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public int getClusterId() {
        return this.clusterId_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7CellDataUsed() {
        return this.day7CellDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7GameCellDataUsed() {
        return this.day7GameCellDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7GameWifiDataUsed() {
        return this.day7GameWifiDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7NewsCellDataUsed() {
        return this.day7NewsCellDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7NewsWifiDataUsed() {
        return this.day7NewsWifiDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7SocialCellDataUsed() {
        return this.day7SocialCellDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7SocialWifiDataUsed() {
        return this.day7SocialWifiDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7VideoCellDataUsed() {
        return this.day7VideoCellDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7VideoWifiDataUsed() {
        return this.day7VideoWifiDataUsed_;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getDay7WifiDataUsed() {
        return this.day7WifiDataUsed_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ClusterData> getParserForType() {
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
        r10 = 0 + CodedOutputStream.computeInt64Size(1, this.timestamp_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.clusterId_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt64Size(3, this.day7CellDataUsed_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt64Size(4, this.day7WifiDataUsed_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt64Size(5, this.day7SocialCellDataUsed_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt64Size(6, this.day7VideoCellDataUsed_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt64Size(7, this.day7NewsCellDataUsed_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt64Size(8, this.day7GameCellDataUsed_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt64Size(9, this.day7SocialWifiDataUsed_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt64Size(10, this.day7VideoWifiDataUsed_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt64Size(11, this.day7NewsWifiDataUsed_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L41;
        r10 = r10 + CodedOutputStream.computeInt64Size(12, this.day7GameWifiDataUsed_);
    L41:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasClusterId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7CellDataUsed() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7GameCellDataUsed() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7GameWifiDataUsed() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7NewsCellDataUsed() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7NewsWifiDataUsed() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7SocialCellDataUsed() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7SocialWifiDataUsed() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7VideoCellDataUsed() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7VideoWifiDataUsed() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasDay7WifiDataUsed() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.ClusterDataOrBuilder
    public boolean hasTimestamp() {
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
        if (hasTimestamp() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getTimestamp());
    L9:
        if (hasClusterId() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getClusterId();
    L12:
        if (hasDay7CellDataUsed() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(getDay7CellDataUsed());
    L15:
        if (hasDay7WifiDataUsed() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashLong(getDay7WifiDataUsed());
    L18:
        if (hasDay7SocialCellDataUsed() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashLong(getDay7SocialCellDataUsed());
    L21:
        if (hasDay7VideoCellDataUsed() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + Internal.hashLong(getDay7VideoCellDataUsed());
    L24:
        if (hasDay7NewsCellDataUsed() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + Internal.hashLong(getDay7NewsCellDataUsed());
    L27:
        if (hasDay7GameCellDataUsed() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + Internal.hashLong(getDay7GameCellDataUsed());
    L30:
        if (hasDay7SocialWifiDataUsed() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + Internal.hashLong(getDay7SocialWifiDataUsed());
    L33:
        if (hasDay7VideoWifiDataUsed() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + Internal.hashLong(getDay7VideoWifiDataUsed());
    L36:
        if (hasDay7NewsWifiDataUsed() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + Internal.hashLong(getDay7NewsWifiDataUsed());
    L39:
        if (hasDay7GameWifiDataUsed() == false) goto L41;
        r10 = b.a(r10, 37, 12, 53) + Internal.hashLong(getDay7GameWifiDataUsed());
    L41:
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
        return new ClusterData();
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
        r8.writeInt32(2, this.clusterId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt64(3, this.day7CellDataUsed_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt64(4, this.day7WifiDataUsed_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt64(5, this.day7SocialCellDataUsed_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt64(6, this.day7VideoCellDataUsed_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt64(7, this.day7NewsCellDataUsed_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt64(8, this.day7GameCellDataUsed_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt64(9, this.day7SocialWifiDataUsed_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt64(10, this.day7VideoWifiDataUsed_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt64(11, this.day7NewsWifiDataUsed_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L38;
        r8.writeInt64(12, this.day7GameWifiDataUsed_);
    L38:
        getUnknownFields().writeTo(r8);
    }

    private ClusterData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.timestamp_ = 0;
        this.clusterId_ = 0;
        this.day7CellDataUsed_ = 0;
        this.day7WifiDataUsed_ = 0;
        this.day7SocialCellDataUsed_ = 0;
        this.day7VideoCellDataUsed_ = 0;
        this.day7NewsCellDataUsed_ = 0;
        this.day7GameCellDataUsed_ = 0;
        this.day7SocialWifiDataUsed_ = 0;
        this.day7VideoWifiDataUsed_ = 0;
        this.day7NewsWifiDataUsed_ = 0;
        this.day7GameWifiDataUsed_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(ClusterData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static ClusterData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ClusterData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static ClusterData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_ClusterData_fieldAccessorTable.ensureFieldAccessorsInitialized(ClusterData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ ClusterData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static ClusterData parseFrom(CodedInputStream r8) {
        return (ClusterData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public ClusterData getDefaultInstanceForType() {
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

    public static ClusterData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (ClusterData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static ClusterData parseFrom(InputStream r8) {
        return (ClusterData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static ClusterData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ClusterData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static ClusterData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static ClusterData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static ClusterData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static ClusterData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
